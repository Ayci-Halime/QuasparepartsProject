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