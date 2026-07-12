package com.Kontakt_Kartei.demo.service;

import com.Kontakt_Kartei.demo.entity.BereichEntity;
import com.Kontakt_Kartei.demo.entity.PersonEntity;
import com.Kontakt_Kartei.demo.record.PersonRecord;
import com.Kontakt_Kartei.demo.repository.BereichRepository;
import com.Kontakt_Kartei.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

import java.util.Optional;
import java.util.Set;

@Service
public class PersonService {

    private final PersonRepository _datenbankP;
    private final BereichRepository _datenbankB;

    @Autowired
    public PersonService(PersonRepository repositoryP, BereichRepository repositoryB) {
        this._datenbankP = repositoryP;
        this._datenbankB = repositoryB;
    }

    public List<PersonRecord> findAll() {
        return _datenbankP.findAll()
                .stream()
                .map(this::toRecord)
                .toList();
    }

    public void save(PersonRecord record) {

        PersonEntity entity = toEntity(record);
        _datenbankP.save(entity);
    }

    public Optional<PersonRecord> findById(Long id) {
        return toRecordOptional(_datenbankP.findById(id));
    }

    public void delete(Long id) {
        _datenbankP.deleteById(id);
    }

    private PersonRecord toRecord(PersonEntity entity) {

        List<Long> bereichIds = entity.getBereiche()
                .stream()
                .map(BereichEntity::getBereich_id)
                .toList();

        return new PersonRecord(
                entity.getPerson_id(),
                entity.getName(),
                entity.getAnrede(),
                entity.getKontaktdaten(),
                entity.getBeschreibung(),
                bereichIds
        );
    }

    private Optional<PersonRecord> toRecordOptional(Optional<PersonEntity> input) {
        return input.map(this::toRecord);
    }

    private PersonEntity toEntity(PersonRecord record) {

        PersonEntity entity;

        if(record.person_id() != null) {
            entity = _datenbankP.findById(record.person_id())
                    .orElse(new PersonEntity());
        } else {entity = new PersonEntity();}

        entity.setPerson_id(record.person_id());
        entity.setName(record.name());
        entity.setAnrede(record.anrede());
        entity.setKontaktdaten(record.kontaktdaten());
        entity.setBeschreibung(record.beschreibung());

        Set<BereichEntity> bereiche = new HashSet<>(_datenbankB.findAllById(record.bereichIds()));

        entity.setBereiche(bereiche);

        return entity;
    }
}
