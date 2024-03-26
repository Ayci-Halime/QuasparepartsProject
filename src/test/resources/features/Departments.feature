@Department @Regression
Feature:Departments

  Background:
    Given Benutzer geht zur URL
    And Benutzer meldet sich an

  Scenario: TC_0007_001 Überprüft, ob die Finanzabteilung angezeigt wird
    Given Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
    Then Der Benutzer uberpruft, ob die Finanzabteilung angezeigt wird

  Scenario: TC_0007_002 Überprüft, ob die Logistikabteilung angezeigt wird
    Given Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
    Then Der Benutzer uberpruft, ob die Logistikabteilung angezeigt wird

  Scenario: TC_0007_003 Überprüft, ob die Abteilung „Marketing und Vertrieb“ angezeigt wird
    Given Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
    Then Der Benutzer uberpruft, ob die Abteilung „Marketing und Vertrieb“ angezeigt wird

  Scenario: TC_0007_004 Überprüft, ob die Qualitätssicherungsabteilung angezeigt wird
    Given  Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
    Then  Der Benutzer uberpruft, ob die Qualitetssicherungsabteilung angezeigt wird

  @Smoke
  Scenario: TC_0007_005 einer registrierten Abteilung Überprüft, ob es angezeigt wurde
    Given Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
    And Der Benutzer klickt auf die Schaltflache „Neue Abteilung hinzufugen“.
    And Der Benutzer schreibt den Abteilungsnamen
    And Der Benutzer schreibt den Kurznamen der Abteilung
    And Der Benutzer wahlt den Abteilungstyp aus
    And Der Benutzer klickt auf die Schaltflache „Speichern“.
    Then Uberpruft, ob eine neue Abteilung zum Abschnitt „Abteilung“ hinzugefugt werden kann
    And Delete  Department

  @Smoke
  Scenario: TC_0008_001 „Personal der Abteilung Überprüft, ob Sie die Abteilung hinzufügen können
    Given  Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
    And Der Benutzer klickt auf die Schaltflache „Neue Abteilung hinzufugen“.
    And Der Benutzer schreibt den Abteilungsnamen
    And Der Benutzer schreibt den Kurznamen der Abteilung
    And Der Benutzer wahlt den Abteilungstyp aus
    And Der Benutzer klickt auf die Schaltflache „Speichern“.
    Then Uberpruft, ob eine neue Abteilung zum Abschnitt „Abteilung“ hinzugefugt werden kann
    And Delete  Department

  Scenario: TC_0008_002 Überprüft, ob die Schaltfläche „Neue Abteilung hinzufügen“ im Abschnitt „Abteilung“ angezeigt wird
    Given  Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
    Then  Der Benutzer uberpruft, ob die Schaltflache „Neue Abteilung hinzufugen“ im Abschnitt „Abteilung“ angezeigt wird

  Scenario: TC_0008_003 "Beim Hinzufügen einer neuen Abteilungzum Modul „Abteilungen“ mussder Abteilungsname obligatorisch sein."
    Given  Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
    And Der Benutzer klickt auf die Schaltflache „Neue Abteilung hinzufugen“.
    And Der Benutzer lasst den Abschnitt „Abteilungsname“ leer.
    And Der Benutzer schreibt den Kurznamen der Abteilung
    And Der Benutzer wahlt den Abteilungstyp aus
    And Der Benutzer klickt auf die Schaltflache „Speichern“.
    And Stellt sicher, dass dem Abschnitt „Abteilung“ keine neue Abteilung hinzugefugt werden kann.

   # Scenario: TC_0008_004
    #  Given  Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
    #  And Der Benutzer klickt auf die Schaltflache „Neue Abteilung hinzufugen“.
     # And Drucken Sie im Abschnitt „Name der Benutzerabteilung“ einfach die Leertaste.
     # And Der Benutzer schreibt den Kurznamen der Abteilung
     # And Der Benutzer wahlt den Abteilungstyp aus
     # And Der Benutzer klickt auf die Schaltflache „Speichern“.
     # Then Uberpruft, ob dem Abschnitt „Abteilung“ eine neue Abteilung hinzugefugt wurde

  Scenario: TC_0008_005 "Beim Hinzufügen einer neuen Abteilungzum Modul „Abteilungen“ wirdder Abteilungsname nur durch Eingabeeines numerischen Werts hinzugefügt."
    Given  Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
    And Der Benutzer klickt auf die Schaltflache „Neue Abteilung hinzufugen“.
    And Drucken Sie im Abschnitt „Name der Benutzerabteilung“ einfach die Leertaste.
    And Im Abschnitt „Name der Benutzerabteilung“ konnen nur Zahlen eingegeben werden.
    And Der Benutzer wahlt den Abteilungstyp aus
    And Der Benutzer klickt auf die Schaltflache „Speichern“.
    Then Uberpruft, ob dem Abschnitt „Abteilung“(mit Zahlen) eine neue Abteilung hinzugefugt wurde
    And Delete  Department

  Scenario: TC_0008_006 "Beim Hinzufügen einer neuen Abteilungzum Modul Abteilungen wirdder Abteilungsname nur durchdie Eingabe von Sonderzeichen hinzugefügt."
    Given  Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
    And Der Benutzer klickt auf die Schaltflache „Neue Abteilung hinzufugen“.
    And Im Abschnitt „Name der Benutzerabteilung“ konnen nur Sonderzeichen eingegeben werden.
    And Im Abschnitt „Name der Benutzerabteilung“ konnen nur Zahlen eingegeben werden.
    And Der Benutzer wahlt den Abteilungstyp aus
    And Der Benutzer klickt auf die Schaltflache „Speichern“.
    Then Uberpruft, ob dem Abschnitt „Abteilung“(mit Sonderzeichen) eine neue Abteilung hinzugefugt wurde
    And Delete  Department

  Scenario: TC_0008_007 "Eine neue Ergänzung zum AbteilungsmodulAbteilung beim Hinzufügen einer AbteilungTyp sollte obligatorisch sein."
    Given  Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
    And Der Benutzer klickt auf die Schaltflache „Neue Abteilung hinzufugen“.
    And Der Benutzer schreibt den Abteilungsnamen
    And Der Benutzer schreibt den Kurznamen der Abteilung
    And Der Benutzer lasst Abteilungstyp leer.
    And Der Benutzer klickt auf die Schaltflache „Speichern“.
    Then Uberpruft, ob dem Abschnitt „Abteilung“ keine neue Abteilung hinzugefugt wurde


  Scenario: TC_0009_001 Im Modul „Abteilungen“ gespeichertDer Name einer Abteilung kann geändert werden
    Given  Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
    And Der Benutzer klickt auf eine gespeicherte Abteilung
    And Der Benutzer klickt auf „Abteilung bearbeiten“.
    And Andert den Benutzernamen.
    And Der Benutzer klickt auf die Schaltflache „Speichern“.
    And Der Benutzer klickt auf den Abteilungsbereich
    Then Der Benutzer bestätigt den neuen Namen

  Scenario:  TC_0009_002 "Im Modul „Abteilungen“ gespeichert„Kurzname“ einer Abteilungaustauschbar"
    Given  Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
    And Der Benutzer klickt auf eine gespeicherte Abteilung
    And Der Benutzer klickt auf „Abteilung bearbeiten“.
    And Der Benutzer andert den Kurznamen.
    And Der Benutzer klickt auf die Schaltflache „Speichern“.
    And Der Benutzer klickt auf den Abteilungsbereich
    And Der Benutzer klickt auf eine gespeicherte Abteilung
    Then Der Benutzer bestatigt den neuen Kurznamen

  Scenario:  TC_0009_003 "Im Modul „Abteilungen“ gespeichert eine Abteilung „Abteilungstyp“austauschbar"
    Given  Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
    And Der Benutzer klickt auf eine gespeicherte Abteilung
    And Der Benutzer klickt auf „Abteilung bearbeiten“.
    And Der Benutzer andert den „Abteilungstyp“.
    And Der Benutzer klickt auf die Schaltflache „Speichern“.
    And Der Benutzer klickt auf der linken Seite der Seite auf Team
    Then Der Benutzer bestatigt, dass diese „Abteilung“ nicht zur Abteilung gehort

  Scenario:  TC_0009_004 "Im Modul „Abteilungen“ gespeichert eine Abteilung „Beschreibung“austauschbar"
    Given  Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
    And Der Benutzer klickt auf eine gespeicherte Abteilung
    And Der Benutzer klickt auf „Abteilung bearbeiten“.
    And Der Benutzer andert die „Abteilungsbeschreibung“.
    And Der Benutzer klickt auf die Schaltflache „Speichern“.
    And Der Benutzer klickt auf den Abteilungsbereich
    And Der Benutzer klickt auf eine gespeicherte Abteilung
    Then Der Benutzer bestatigt, dass sich „Beschreibung“ in der Abteilung geandert hat

  Scenario:  TC_0009_005 "Im Modul „Abteilungen“ gespeicherteine Abteilung in „Rollen“austauschbar"
    Given  Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
    And Der Benutzer klickt auf eine gespeicherte Abteilung
    And Der Benutzer klickt auf „Abteilung bearbeiten“.
    And Der Benutzer andert die Abteilungsrollen
    And Der Benutzer klickt auf die Schaltflache „Speichern“.
    And Der Benutzer klickt auf den Abteilungsbereich
    And Der Benutzer klickt auf eine gespeicherte Abteilung
    Then Der Benutzer bestatigt, dass sich „Rollen“ in der Abteilung geandert haben

  @Smoke
  Scenario:  TC_0009_006 "Eine im Modul Abteilungen gespeicherte Abteilung kann gelöscht werden."
    Given  Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
    And Der Benutzer klickt auf eine gespeicherte Abteilung
    And Der Benutzer klickt auf „Abteilung bearbeiten“.
    And Der Benutzer klickt auf die Schaltflache „Abteilung loschen“.
    And Der Benutzer klickt auf dem angezeigten Bildschirm auf „Bestatigen“
    Then Der Benutzer Uberpruft, ob die geloschte Abteilung geloscht wurde

  @B1
  Scenario:  TC_0009_007 "Ein im Abteilungsmodul gespeichertes Abteilungsbild kann nicht geändert werden.."
    Given  Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
    And Der Benutzer klickt auf eine gespeicherte Abteilung
    And Der Benutzer klickt auf „Abteilung bearbeiten“.
    And Der Benutzer klickt auf „Bild andern“
    And Der Benutzer ladt ein Bild vom Computer hoch

  Scenario: Delete Personel
    Given Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
    And Delete  Department