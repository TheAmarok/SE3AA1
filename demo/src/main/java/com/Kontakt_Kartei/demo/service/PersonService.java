package com.Kontakt_Kartei.demo.service;

import com.Kontakt_Kartei.demo.entity.PersonEntity;
import com.Kontakt_Kartei.demo.record.PersonRecord;
import com.Kontakt_Kartei.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository _datenbankP;

    @Autowired
    public PersonService(PersonRepository repository) {
        this._datenbankP = repository;
    }

    public List<PersonRecord> findAll() {
        return _datenbankP.findAll()
                .stream()
                .map(this::toRecord)
                .toList();
    }

    public PersonEntity save(PersonEntity person) {
        return _datenbankP.save(person);
    }

    public PersonRecord findById(Long id) {
        PersonEntity person = _datenbankP.findById(id).orElseThrow();
        return toRecord(_datenbankP.findById(id));
    }

    public void delete(Long id) {
        _datenbankP.deleteById(id);
    }

    private PersonRecord toRecord(PersonEntity entity) {
        return new PersonRecord(
                entity.getPerson_id(),
                entity.getName(),
                entity.getAnrede(),
                entity.getKontaktdaten(),
                entity.getBeschreibung()
        );
    }
}
