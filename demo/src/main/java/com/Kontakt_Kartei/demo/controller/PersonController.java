package com.Kontakt_Kartei.demo.controller;

import com.Kontakt_Kartei.demo.entity.BereichEntity;
import com.Kontakt_Kartei.demo.entity.PersonEntity;
import com.Kontakt_Kartei.demo.exception.BereichMissingException;
import com.Kontakt_Kartei.demo.exception.PersonMissingException;
import com.Kontakt_Kartei.demo.service.BereichService;
import com.Kontakt_Kartei.demo.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/personen")
public class PersonController {

    private final PersonService _serviceP;
    private final BereichService _serviceB;
    private static final Logger log = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    public PersonController(PersonService serviceP, BereichService serviceB) {
        this._serviceP = serviceP;
        this._serviceB = serviceB;
    }

    @GetMapping
    public String showAll(Model model) {

        model.addAttribute("personen",
                _serviceP.findAll());

        return "personen";
    }

    @GetMapping("/neue-person")
    public String showForm(Model model) {

        model.addAttribute("person",
                new PersonEntity());
        model.addAttribute(
                "bereiche",
                _serviceB.findAll());

        return "person-input";
    }

    @PostMapping("/speichern")
    public String save(
            @ModelAttribute PersonEntity person,
            @RequestParam(required = false) List<Long> bereichIds) {


        Set<BereichEntity> bereiche = new HashSet<>();

        if (bereichIds != null) {

            for(Long id : bereichIds) {
                BereichEntity bereich = _serviceB.findById(id)
                        .orElseThrow(() -> new BereichMissingException("Bereich " + id + " der Person fehlt."));
                bereiche.add(bereich);
            }
        }

        person.setBereiche(bereiche);

        _serviceP.save(person);

        return "redirect:/personen";
    }

    @GetMapping("/bearbeiten/{id}")
    public String edit(
            @PathVariable Long id,
            Model model) {

        PersonEntity person = _serviceP.findById(id)
                .orElseThrow(() -> new PersonMissingException("Person " + id + " fehlt."));

        model.addAttribute("person", person);
        model.addAttribute( "bereiche", _serviceB.findAll());

        return "person-input";
    }

    @GetMapping("/loeschen/{id}")
    public String delete(
            @PathVariable Long id) {

        _serviceP.delete(id);

        return "redirect:/personen";
    }

    @ExceptionHandler(BereichMissingException.class)
    public String handleBereichMissing(BereichMissingException e, RedirectAttributes redirectAttributes) {
        log.warn("Fehler aufgerufen: {}", e.getMessage(), e);
        redirectAttributes.addFlashAttribute("error", "Bereich existiert nicht.");
        return "redirect:/fehler";
    }

    @ExceptionHandler(PersonMissingException.class)
    public String handlePersonMissing(PersonMissingException e, RedirectAttributes redirectAttributes) {
        log.warn("Fehler aufgerufen: {}", e.getMessage(), e);
        redirectAttributes.addFlashAttribute("error", "Person existiert nicht.");
        return "redirect:/fehler";
    }

}
