@Company
Feature:US_0006

  Background:
    Given Benutzer geht zur URL
    And Benutzer meldet sich an

  Scenario: TC_0006_0001
    Given Benutzer klickt auf der linken Seite der Seite auf „Company“.
    And Benutzer klickt auf der Edit.
    And Loescht den Benutzernamen
    And Benutzer klickt auf der Save.
    Then Benutzer bestaetigt, dass unter dem Namen eine Warnung erscheint.
    And Benutzer meldet sich ab

  @Probieren
  Scenario: TC_0006_0002
    Given Benutzer klickt auf der linken Seite der Seite auf „Company“.
    And Benutzer klickt auf der Edit.
    And Laesst den E-Mail leer.
    And Benutzer klickt auf der Save.
    Then Der Benutzer sieht, dass die Nachricht Unternehmensinformationen aktualisiert wurde.
    And Benutzer meldet sich ab


  Scenario: TC_0006_0003
    Given Benutzer klickt auf der linken Seite der Seite auf „Company“.
    And Benutzer klickt auf der Edit.
    And Laesst den E-Mail und das Namen leer.
    And Benutzer klickt auf der Save.
    Then Benutzer bestaetigt, dass unter dem Namen eine Warnung erscheint.
    And Benutzer meldet sich ab


  Scenario: TC_0006_0004
    Given Benutzer klickt auf der linken Seite der Seite auf „Company“.
    And Benutzer klickt auf der Edit.
    And Benutzer gibt einen Buchstaben in das E-Mail ein und füllt auch das Namens aus.
    And Benutzer klickt auf der Save.
    Then Benutzer bestaetigt, dass unter dem Namen eine Warnung erscheint.
    And Benutzer meldet sich ab