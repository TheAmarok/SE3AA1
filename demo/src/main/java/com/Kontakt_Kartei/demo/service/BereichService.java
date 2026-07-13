package com.Kontakt_Kartei.demo.service;

import com.Kontakt_Kartei.demo.entity.BereichEntity;
import com.Kontakt_Kartei.demo.entity.PersonEntity;
import com.Kontakt_Kartei.demo.exception.BereichMissingException;
import com.Kontakt_Kartei.demo.repository.BereichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BereichService {

    private final BereichRepository _datenbankB;

    @Autowired
    public BereichService(BereichRepository repository) {
        this._datenbankB = repository;
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

    /**
     * Löscht einen Bereich anhand seiner ID und entfernt zuvor alle zugewiesenen Personen.
     * <p>
     * Die Methode lädt den Bereich, entfernt die bidirektionalen Verknüpfungen
     * in den betroffenen Personen-Entitäten zur Wahrung der referentiellen Integrität
     * und löscht den Bereich anschließend aus der Datenbank.
     *
     * @param id Die ID des zu löschenden Bereichs.
     * @throws BereichMissingException Wenn kein Bereich mit der angegebenen ID existiert.
     */
    @Transactional
    public void delete(Long id) {

        BereichEntity bereich = _datenbankB.findById(id)
                .orElseThrow(() -> new BereichMissingException("Bereich " + id + " fehlt."));

        for (PersonEntity person : bereich.getPersonen()) {
            person.getBereiche().remove(bereich);
        }

        bereich.getPersonen().clear();

        _datenbankB.delete(bereich);
    }

}
