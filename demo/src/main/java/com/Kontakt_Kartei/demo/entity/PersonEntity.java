package com.Kontakt_Kartei.demo.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class PersonEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String anrede;
	private String kontaktdaten;
	private String beschreibung;
	
	@ManyToMany
	@JoinTable(	name 				= "person_bereich",
				joinColumns 		= @JoinColumn(name = "person_id"),
				inverseJoinColumns 	= @JoinColumn(name = "bereich_id"))
	private Set<BereichEntity> bereiche;

}
