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

    public Optional<PersonRecord> findById(Long id) {
        return toRecordOptional(_datenbankP.findById(id));
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

    private Optional<PersonRecord> toRecordOptional(Optional<PersonEntity> input) {
        if (input.isEmpty()) {
            return Optional.empty();
        }
        PersonEntity entity = input.get();
        return Optional.of(new PersonRecord(
                entity.getPerson_id(),
                entity.getName(),
                entity.getAnrede(),
                entity.getKontaktdaten(),
                entity.getBeschreibung()
        ));
    }
}
