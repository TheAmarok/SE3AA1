package com.Kontakt_Kartei.demo.record;

import java.util.List;

public record PersonRecord(
        Long person_id,
        String name,
        String anrede,
        String kontaktdaten,
        String beschreibung,
        List<Long> bereichIds
) {}
