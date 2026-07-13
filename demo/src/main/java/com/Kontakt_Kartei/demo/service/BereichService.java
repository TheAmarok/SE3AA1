package com.Kontakt_Kartei.demo.service;

import com.Kontakt_Kartei.demo.controller.HomeController;
import com.Kontakt_Kartei.demo.entity.BereichEntity;
import com.Kontakt_Kartei.demo.entity.PersonEntity;
import com.Kontakt_Kartei.demo.exception.BereichMissingException;
import com.Kontakt_Kartei.demo.repository.BereichRepository;
import com.Kontakt_Kartei.demo.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BereichService {

    private final BereichRepository _datenbankB;
    private final PersonRepository _datenbankP;
    private static final Logger log = LoggerFactory.getLogger(BereichService.class);

    @Autowired
    public BereichService(BereichRepository repositoryB, PersonRepository repositoryP) {
        this._datenbankB = repositoryB;
        this._datenbankP = repositoryP;
    }

    public List<BereichEntity> findAll() {
        return _datenbankB.findAll();
    }

    public void save(BereichEntity entity) {
        _datenbankB.save(entity);
    }

    public Optional<BereichEntity> findById(Long id) {
        return _datenbankB.findById(id);
    }

    public void delete(Long id) {

        BereichEntity bereich = _datenbankB.findById(id)
                .orElseThrow(() -> new BereichMissingException("Bereich " + id + " fehlt."));

        List<PersonEntity> personen =
                _datenbankP.findByBereiche_Bereich_id(id);

        for (PersonEntity person : personen) {
            person.getBereiche().remove(bereich);
        }

        _datenbankB.delete(bereich);
    }

    @ExceptionHandler(BereichMissingException.class)
    public String handleBereichMissing(BereichMissingException e, RedirectAttributes redirectAttributes) {
        log.warn("Fehler aufgerufen: {}", e.getMessage(), e);
        redirectAttributes.addFlashAttribute("error", "Bereich existiert nicht.");
        return "redirect:/fehler";
    }

}
