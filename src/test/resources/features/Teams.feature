@Team
Feature:US_0007
  Background:
    Given Benutzer geht zur URL
    And Benutzer meldet sich an
  Scenario: TC_0013_001
    Given Der Benutzer klickt auf der linken Seite der Seite auf Team
    And Der Benutzer klickt auf die Schaltflaeche Neues Team hinzufugen
    And Der Benutzer schreibt den TAbteilungsnamen
    And Der Benutzer schreibt den TKurznamen der Abteilung
    And Der Benutzer wahlt den TAbteilungstyp aus
    Then Uberpruft, ob Sie das neue Team zum Abschnitt „Team“ hinzufugen konnen

  Scenario: TC_0013_002
    Given Der Benutzer klickt auf der linken Seite der Seite auf Team
    And Der Benutzer klickt auf das gespeicherte Team
    Then Der Benutzer Uberpruft die Anklickbarkeit des gespeicherten Teams.

  Scenario: TC_0014_001
    Given Der Benutzer klickt auf der linken Seite der Seite auf Team
    And Der Benutzer klickt auf das gespeicherte Team
    And Der Benutzer bearbeiten Teamklicks
    And Der Benutzer aendert den Benutzernamen
    And Der Benutzer klickt auf die Schaltflaeche Speichern
    And Der Benutzer klickt auf den Abschnitt Team
    Then Der Benutzer bestätigt den neuen TNamen
  @B1
  Scenario: TC_0014_002
    Given Der Benutzer klickt auf der linken Seite der Seite auf Team
    And Der Benutzer klickt auf das gespeicherte Team
    And Der Benutzer bearbeiten Teamklicks
    And Der Benutzer andert den TKurznamen.
    And Der Benutzer klickt auf die Schaltflaeche Speichern
    And Der Benutzer klickt auf den Abschnitt Team
    And Der Benutzer klickt auf das gespeicherte Team
    Then Der Benutzer bestatigt den neuen TKurznamen
