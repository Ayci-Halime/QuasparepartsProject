@Team @Regression
Feature:Teams
  Background:
    Given Benutzer geht zur URL
    And Benutzer meldet sich an
  Scenario: TC_0013_001 "Überprüft, ob Sie im Teammodul ein neues Team hinzufügen können"
    Given Der Benutzer klickt auf der linken Seite der Seite auf Team
    And Der Benutzer klickt auf die Schaltflaeche Neues Team hinzufugen
    And Der Benutzer schreibt den TAbteilungsnamen
    And Der Benutzer schreibt den TKurznamen der Abteilung
    And Der Benutzer wahlt den TAbteilungstyp aus
    Then Uberpruft, ob Sie das neue Team zum Abschnitt „Team“ hinzufugen konnen
    And Delete Team
  @Smoke
  Scenario: TC_0013_002 "Überprüft die Anklickbarkeit eines neuen Teams im Teammodul"
    Given Der Benutzer klickt auf der linken Seite der Seite auf Team
    And Der Benutzer klickt auf das gespeicherte Team
    Then Der Benutzer Uberpruft die Anklickbarkeit des gespeicherten Teams.

  Scenario: TC_0014_001 "Der Name eines im Team-Modul gespeicherten Teams kann geändert werden."
    Given Der Benutzer klickt auf der linken Seite der Seite auf Team
    And Der Benutzer klickt auf das gespeicherte Team
    And Der Benutzer bearbeiten Teamklicks
    And Der Benutzer aendert den Benutzernamen
    And Der Benutzer klickt auf die Schaltflaeche Speichern
    And Der Benutzer klickt auf den Abschnitt Team
    Then Der Benutzer bestätigt den neuen TNamen

  Scenario: TC_0014_002 "Der „Kurzname“ eines im Team-Modul gespeicherten Teams kann geändert werden."
    Given Der Benutzer klickt auf der linken Seite der Seite auf Team
    And Der Benutzer klickt auf das gespeicherte Team
    And Der Benutzer bearbeiten Teamklicks
    And Der Benutzer andert den TKurznamen.
    And Der Benutzer klickt auf die Schaltflaeche Speichern
    And Der Benutzer klickt auf den Abschnitt Team
    And Der Benutzer klickt auf das gespeicherte Team
    Then Der Benutzer bestatigt den neuen TKurznamen

  Scenario: TC_0014_003 "Der „Abteilungstyp“ eines im Teammodul gespeicherten Teams kann geändert werden."
    Given Der Benutzer klickt auf der linken Seite der Seite auf Team
    And Der Benutzer klickt auf das gespeicherte Team
    And Der Benutzer bearbeiten Teamklicks
    And Der Benutzer andert den Abteilungstyp.
    And Der Benutzer klickt auf die Schaltflaeche Speichern
    And Der Benutzer klickt auf den Abschnitt Team
    Then Der Benutzer uberpruft den neuen Abteilungstyp

  Scenario: TC_0014_004 "Die „Beschreibung“ eines im Team-Modul gespeicherten Teams kann geändert werden"
    Given Der Benutzer klickt auf der linken Seite der Seite auf Team
    And Der Benutzer klickt auf das gespeicherte Team
    And Der Benutzer bearbeiten Teamklicks
    And Der Benutzer andert die „Abteilungsbeschreibung“.
    And Der Benutzer klickt auf die Schaltflaeche Speichern
    And Der Benutzer klickt auf den Abschnitt Team
    Then Der Benutzer bestatigt, dass sich „Beschreibung“ in der Abteilung geandert hat

  Scenario: TC_0014_005 "Die im Team-Modul gespeicherten„Rollen“ eines Teams können geändert werden"
    Given Der Benutzer klickt auf der linken Seite der Seite auf Team
    And Der Benutzer klickt auf das gespeicherte Team
    And Der Benutzer bearbeiten Teamklicks
    And Der Benutzer andert die Abteilungsrollen
    And Der Benutzer klickt auf die Schaltflaeche Speichern
    And Der Benutzer klickt auf den Abschnitt Team
    And Der Benutzer klickt auf eine gespeicherte Abteilung
    Then Der Benutzer bestatigt, dass sich „Rollen“ in der Abteilung geandert haben

  Scenario: TC_0014_006 "Überprüft, ob ein im Team-Modul gespeichertes Team gelöscht werden kann"
    Given Der Benutzer klickt auf der linken Seite der Seite auf Team
    And Der Benutzer klickt auf das gespeicherte Team
    And Der Benutzer bearbeiten Teamklicks
    And Der Benutzer klickt auf die Schaltflache „Abteilung loschen“.
    And Der Benutzer klickt auf dem angezeigten Bildschirm auf „Bestatigen“
    Then Der Benutzer Uberpruft, ob die geloschte Abteilung geloscht wurde

 #Scenario: TC_0014_007
   # Given Der Benutzer klickt auf der linken Seite der Seite auf Team
   # And Der Benutzer klickt auf die Schaltflache „Neue Abteilung hinzufugen“.
   # And Der Benutzer lasst den Abschnitt „Abteilungsname“ leer.
    #And Der Benutzer schreibt den Kurznamen der Abteilung
   # And Der Benutzer wahlt den Abteilungstyp aus
   # And Der Benutzer klickt auf die Schaltflache „Speichern“.
   # And Stellt sicher, dass dem Abschnitt „Abteilung“ keine neue Abteilung hinzugefugt werden kann.

  Scenario: TC_0014_008 "Beim Hinzufügen eines neuen Teams zum Teammodul muss der Abteilungsname obligatorisch sein."
    Given Der Benutzer klickt auf der linken Seite der Seite auf Team
    And Der Benutzer klickt auf die Schaltflache „Neue Abteilung hinzufugen“.
    And Der Benutzer schreibt den Abteilungsnamen
    And Der Benutzer schreibt den Kurznamen der Abteilung
    And Der Benutzer lasst Abteilungstyp leer.
    And Der Benutzer klickt auf die Schaltflache „Speichern“.
    Then Uberpruft, ob dem Abschnitt „Abteilung“ keine neue Abteilung hinzugefugt wurde

    Scenario: Delete Team
      And Delete Team