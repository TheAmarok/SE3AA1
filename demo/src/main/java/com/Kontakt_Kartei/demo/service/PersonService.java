package com.Kontakt_Kartei.demo.service;

import com.Kontakt_Kartei.demo.entity.PersonEntity;
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

    public List<PersonEntity> findAll() {
        return _datenbankP.findAll();
    }

    public PersonEntity save(PersonEntity person) {
        return _datenbankP.save(person);
    }

    public Optional<PersonEntity> findById(Long id) {
        return _datenbankP.findById(id);
    }

    public void delete(Long id) {
        _datenbankP.deleteById(id);
    }
}
