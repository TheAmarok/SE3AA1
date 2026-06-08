package com.Kontakt_Kartei.demo.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class BereichEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String kontaktdaten;
	private String beschreibung;
	
	@ManyToMany(mappedBy = "bereiche")
	private Set<PersonEntity> personen;
}
