package com.Kontakt_Kartei.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Kontakt_Kartei.demo.entity.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

}
