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
	private Long person_id;
	
	private String name;
	private String anrede;
	private String kontaktdaten;
	private String beschreibung;
	
	@ManyToMany
	@JoinTable(	name 				= "person_bereich",
				joinColumns 		= @JoinColumn(name = "person_id"),
				inverseJoinColumns 	= @JoinColumn(name = "bereich_id"))
	private Set<BereichEntity> bereiche;

	public Long getPerson_id() {
		return person_id;
	}

	public void setPerson_id(Long person_id) {
		this.person_id = person_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnrede() {
		return anrede;
	}

	public void setAnrede(String anrede) {
		this.anrede = anrede;
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

	public Set<BereichEntity> getBereiche() {
		return bereiche;
	}

	public void setBereiche(Set<BereichEntity> bereiche) {
		this.bereiche = bereiche;
	}

}
