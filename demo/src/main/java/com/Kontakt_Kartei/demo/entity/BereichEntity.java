package com.Kontakt_Kartei.demo.entity;

import java.util.HashSet;
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
	private Long bereich_id;
	
	private String name;
	private String kontaktdaten;
	private String beschreibung;
	
	@ManyToMany(mappedBy = "bereiche")
	private Set<PersonEntity> personen = new HashSet<>();

	public Long getBereich_id() {
		return bereich_id;
	}

	public void setBereich_id(Long bereich_id) {
		this.bereich_id = bereich_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKontaktdaten() {
		return kontaktdaten;
	}

	public void setKontaktdaten(String kontaktdaten) {
		this.kontaktdaten = kontaktdaten;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
}
