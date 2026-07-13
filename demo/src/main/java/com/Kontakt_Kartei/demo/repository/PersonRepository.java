package com.Kontakt_Kartei.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Kontakt_Kartei.demo.entity.PersonEntity;

import java.util.List;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    List<PersonEntity> findByBereiche_Bereich_id(Long bereich_id);
}
