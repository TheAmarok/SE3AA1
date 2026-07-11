package com.Kontakt_Kartei.demo.record;

public record BereichRecord (
        Long bereich_id,
        String name,
        String kontaktdaten,
        String beschreibung
) {}
