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

	/**
	 * Entfernt alle zugewiesenen Personen, wenn dieser Bereich gelöscht wird.
	 * <p>
	 * Diese Methode stellt die referenzielle Integrität sicher, indem sie die
	 * bidirektionale Verknüpfung auf der Gegenseite (Person) auflöst, bevor
	 * die interne Liste der Personen geleert wird.
	 */
	public void removePersonen() {
		for (PersonEntity person : personen) {
			person.getBereiche().remove(this);
		}
		personen.clear();
	}

	//Get & Set Methoden, alle von Thymeleaf genutzt

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

	public Set<PersonEntity> getPersonen() {
		return personen;
	}

	public void setPersonen(Set<PersonEntity> personen) {
		this.personen = personen;
	}
}
