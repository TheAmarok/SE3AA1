package com.Kontakt_Kartei.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Kontakt_Kartei.demo.entity.PersonEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    @Query("""
           SELECT p FROM PersonEntity p
           JOIN p.bereiche b
           WHERE b.bereich_id = :bereichId
           """)
    List<PersonEntity> findPersonenByBereichId(Long bereichId);
}
