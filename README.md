# SE3AA1
_Repository für das Assignment  zu ”Ausgewählte Aspekte des Software-Engineering I“_

Ziel des Projektes ist es, eine Webanwendung für das Verwalten von Kontakten zu entwickeln. Dafür wird die H2 mit Spring Data JPA verwendet.
![E-R-Diagramm der Anwendung](ER-Diagramm.png)

Personen haben jeweils einen Namen, Kontaktdaten, eine Anrede und eine Beschreibung.
Bereiche haben Ebenfalls Namen, Beschreibungen und Kontaktdaten.

So kann dokumentiert werden, wer in welcher Gruppe ist.
Es kann klar nach Bereichen wie Clubs, Arbeitsbereichen oder Freundeskreisen gefiltert werden, wobei auch Kontaktmöglichkeiten wie E-Mail Verteider für die eizelnen Bereiche erstellt werden können.

Aufgrund der N-M-Relation wird eine Join-Tabelle benötigt, welche von JPA automatisch generiert werden kann.

## Anforderungen
An das Projekt werden folgende Anforderungen gestellt:

- [ ] Verwendet Java, Maven und Spring Boot
- [ ] Ist eine Web-Anwendung
- [ ] Die Daten sind Persistent
- [ ] Es wird eine der folgenden Persistenz-APIs verwendet
    - H2 mit JPA
    - H2 mit Spring Data JPA
    - Cassandra mit Spring Data
    - MongoDB mit Spring Data
    - Neo4j mit Spring Data
- [ ] Die Anwendung verwendet zwei Tabellen
- [ ] Create, Read, Update und Delete Operationen werden unterstützt.
- [ ] Daten sollen in Datei auf Festplatte/SSD geschrieben werden.
- [ ] Wird kein H2 verwendet, muss eine docker-compose.yml enthalten sein.
- [ ] Das Datenmodell wird als Diagramm dargestellt und als PNG, SVG oder PDF im Repo Beigefügt.
- [ ] Eine (rein funktionale) HTML Benutzeroberfläche besteht. Dafür können verwendet werden:
    - Thymeleaf
    - Statische HTML-Seite mit RestController & REST-API
    - CSS-Framework wie Bootstrap
- [ ] Video für das Erklären der Anwendung ist erstellt.

#### Bewertungskriterien
- [ ] Funktional Korrekt
- [ ] Funktional Robust
- [ ] Oberfläche besitzt konsistenzes Aussehen
- [ ] Oberfläche muss gut bedienbar sein
- [ ] Zahlen & Datumsformate passen zur Sprache
- [ ] Sicherheitsabfrage vor Löschoperation
- [ ] Texte haben guten farblichen Kontrast
- [ ] Texte haben immer etwas Platz drum herum
- [ ] Ungültige Eingaben werden sinnvoll behandelt
- [ ] Bedienung ist Intuitiv

#### Quellcode Anforderungen
- [ ] Code ist nicht KI-Generiert
- [ ] Bei H2 Verwendung muss das Datenmodell normalisiert sein.
- [ ] Catch Blöcke des Exception Handeling müssen den Zwischenfall immer loggen und wenn Sinnvoll den Benutzer darauf hinweisen.
- [ ] Import-Anweisungen gelten für Klassen, keine Wildcards mit *
- [ ] Kommentare sollten vorhanden sein
- [ ] Kommentare für ganze Methoden/Klassen/... als JavaDoc-Kommentar
- [ ] Commits müssen regelmäßig gepushed werden.
- [ ] Quellcode wird in Moodle als ZIP abgegeben.
- [ ] Benennung muss gut verständlich sein.
- [ ] Gängige Benennungskonventionen werden beachtet.
    - UpperCamelCase für Klassennamen
    - lowerCamelCase für Variablen
- [ ] Quellcodezeilen sind nie länger als 120 Zeichen
- [ ] Methoden haben <50 Zeilen
- [ ] Einrückung & Leerzeichen sind einheitlich
- [ ] Kein Duplicate Code
- [ ] Keine Codeleichen
- [ ] Alle Variablen müssen irgendwann ausgelesen/genutzt werden
- [ ] Keine unnötigen Imports
- [ ] Klassen sind in Packages
- [ ] Jedes Package enthält mindestens zwei Klassen
- [ ] Verwende @Override wann immer möglich
- [ ] Keine deprecated Klassen & Methoden
- [ ] Einfache Datentransportklassen sind Records
- [ ] Beachte Best Practices der Vorlesung
- [ ] Verwende kein Lombok

#### Bewertungserleichterung
- [ ] ``mvnw spring-boot:run`` im Hauptverzeichnis via Maven Wrapper soll Anwendung starten
- [ ] Anwendung ist auf Port 8080 erreichbar
- [ ] Bei H2 ist die H2-Konsole aktiviert
- [ ] Bei H2 ist die H2-Konsole auf ``localhost:8080/h2-console/`` erreichbar

#### Anforderungen ans Video
- [ ] Dient als Tutorial für neuen Endanwender
- [ ] Bildschirm abfilmen und auf Tonspur erklären
- [ ] Zwei bis drei Minuten
- [ ] Keine Bearbeitung des Videos (auch keine Schnitte)
- [ ] Video ist mit VLC Media Player abspielbar
- [ ] Auf moodle hochladen
- [ ] Keine Hintergrundmusik
- [ ] Keine Hintergrundgeräuche
- [ ] Mit Headset/Mikrofon aufgenommen
- [ ] Videoauflösung erlaubt lesen des Textes
- [ ] Das Video darf nicht abrupt enden
- [ ] Technische Dtails wie Quellcode werden