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

- [x] Verwendet Java, Maven und Spring Boot
- [x] Ist eine Web-Anwendung
- [x] Die Daten sind Persistent
- [x] Es wird eine der folgenden Persistenz-APIs verwendet
    - H2 mit Spring Data JPA
- [x] Die Anwendung verwendet zwei Tabellen
- [x] Create, Read, Update und Delete Operationen werden unterstützt.
- [x] Daten sollen in Datei auf Festplatte/SSD geschrieben werden.
- [x] Das Datenmodell wird als Diagramm dargestellt und als PNG, SVG oder PDF im Repo Beigefügt.
- [x] Eine (rein funktionale) HTML Benutzeroberfläche besteht. Dafür können verwendet werden:
    - Thymeleaf
    - Statische HTML-Seite mit RestController & REST-API
    - CSS-Framework wie Bootstrap
- [x] Video für das Erklären der Anwendung ist erstellt.

#### Bewertungskriterien
- [x] Funktional Korrekt
- [x] Funktional Robust
- [x] Oberfläche besitzt konsistentes Aussehen
- [x] Oberfläche muss gut bedienbar sein
- [x] Zahlen & Datumsformate passen zur Sprache
- [x] Sicherheitsabfrage vor Löschoperation
- [x] Texte haben guten farblichen Kontrast
- [x] Texte haben immer etwas Platz drum herum
- [x] Ungültige Eingaben werden sinnvoll behandelt
- [x] Bedienung ist Intuitiv

#### Quellcode Anforderungen
- [x] Code ist nicht KI-Generiert
- [x] Bei H2 Verwendung muss das Datenmodell normalisiert sein.
- [x] Catch Blöcke des Exception Handeling müssen den Zwischenfall immer loggen und wenn Sinnvoll den Benutzer darauf hinweisen.
- [x] Import-Anweisungen gelten für Klassen, keine Wildcards mit *
- [x] Kommentare sollten vorhanden sein
- [x] Kommentare für ganze Methoden/Klassen/... als JavaDoc-Kommentar
- [x] Commits müssen regelmäßig gepushed werden.
- [x] Quellcode wird in Moodle als ZIP abgegeben.
- [x] Benennung muss gut verständlich sein.
- [x] Gängige Benennungskonventionen werden beachtet.
    - UpperCamelCase für Klassennamen
    - lowerCamelCase für Variablen
- [x] Quellcodezeilen sind nie länger als 120 Zeichen
- [x] Methoden haben <50 Zeilen
- [x] Einrückung & Leerzeichen sind einheitlich
- [x] Kein Duplicate Code
- [x] Keine Codeleichen
- [x] Alle Variablen müssen irgendwann ausgelesen/genutzt werden
- [x] Keine unnötigen Imports
- [x] Klassen sind in Packages
- [x] Jedes Package enthält mindestens zwei Klassen
- [x] Verwende @Override wann immer möglich
- [x] Keine deprecated Klassen & Methoden
- [x] Einfache Datentransportklassen sind Records
- [x] Beachte Best Practices der Vorlesung
- [x] Verwende kein Lombok

#### Bewertungserleichterung
- [x] ``mvnw spring-boot:run`` im Hauptverzeichnis via Maven Wrapper soll Anwendung starten
- [x] Anwendung ist auf Port 8080 erreichbar
- [x] Bei H2 ist die H2-Konsole aktiviert
- [x] Bei H2 ist die H2-Konsole auf ``localhost:8080/h2-console/`` erreichbar

#### Anforderungen ans Video
- [x] Dient als Tutorial für neuen Endanwender
- [x] Bildschirm abfilmen und auf Tonspur erklären
- [x] Zwei bis drei Minuten
- [x] Keine Bearbeitung des Videos (auch keine Schnitte)
- [x] Video ist mit VLC Media Player abspielbar
- [x] Auf moodle hochladen
- [x] Keine Hintergrundmusik
- [x] Keine Hintergrundgeräusche
- [x] Mit Headset/Mikrofon aufgenommen
- [x] Videoauflösung erlaubt lesen des Textes
- [x] Das Video darf nicht abrupt enden
- [x] Technische Details wie Quellcode werden weggelassen