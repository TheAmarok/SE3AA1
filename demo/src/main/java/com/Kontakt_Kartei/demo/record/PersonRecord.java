package com.Kontakt_Kartei.demo.record;

public record PersonRecord(
        Long person_id,
        String name,
        String anrede,
        String kontaktdaten,
        String beschreibung
) {}
