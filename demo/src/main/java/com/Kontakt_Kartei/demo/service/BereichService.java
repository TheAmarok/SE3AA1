package com.Kontakt_Kartei.demo.service;

import com.Kontakt_Kartei.demo.entity.BereichEntity;
import com.Kontakt_Kartei.demo.record.BereichRecord;
import com.Kontakt_Kartei.demo.repository.BereichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BereichService {

    private final BereichRepository _datenbankB;

    @Autowired
    public BereichService(BereichRepository repository) {
        this._datenbankB = repository;
    }

    public List<BereichRecord> findAll() {
        return _datenbankB.findAll()
                .stream()
                .map(this::toRecord)
                .toList();
    }

    public BereichRecord save(BereichRecord record) {

        BereichEntity entity = toEntity(record);
        BereichEntity saved = _datenbankB.save(entity);
        return toRecord(saved);
    }

    public Optional<BereichRecord> findById(Long id) {
        return toRecordOptional(_datenbankB.findById(id));
    }

    public void delete(Long id) {
        _datenbankB.deleteById(id);
    }

    private BereichRecord toRecord(BereichEntity entity) {
        return new BereichRecord(
                entity.getBereich_id(),
                entity.getName(),
                entity.getKontaktdaten(),
                entity.getBeschreibung()
        );
    }

    private Optional<BereichRecord> toRecordOptional(Optional<BereichEntity> input) {
        if (input.isEmpty()) {
            return Optional.empty();
        }
        BereichEntity entity = input.get();
        return Optional.of(new BereichRecord(
                entity.getBereich_id(),
                entity.getName(),
                entity.getKontaktdaten(),
                entity.getBeschreibung()
        ));
    }

    private BereichEntity toEntity(BereichRecord record) {

        BereichEntity entity = new BereichEntity();

        entity.setBereich_id(record.bereich_id());
        entity.setName(record.name());
        entity.setKontaktdaten(record.kontaktdaten());
        entity.setBeschreibung(record.beschreibung());

        return entity;
    }
}
