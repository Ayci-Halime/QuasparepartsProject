@Profile @Regression
Feature: US_0004

  Background:
    Given Benutzer geht zur URL
    And Benutzer meldet sich an Profile


  Scenario: TC_0004_001
    When Benutzer klickt auf die Schaltflaeche edit
    Then Benutzer bestaetigt, dass sich die E-Mail-Adresse nicht geaendert hat
    And Benutzer meldet sich ab

  Scenario Outline: TC_0004_002,TC_0004_011,TC_0004_012
    When Benutzer klickt auf dieSchaltflaeche Change Password
    And Benutzer gibt ein  "<Password>" ein
    And Benutzer gibt ein  "<Password>" ein
    And Benutzer klickt auf die Schaltflaeche Confirm
    Then Benutzer bestaetigt, Der Text 'Change password successfully' wurde angezeigt
    And Benutzer klickt auf dieSchaltflaeche cancel
    And Benutzer aktualisiert altes Passwort
    And Benutzer meldet sich ab

    Examples:
      | Password             |
      | 5eIxXyQ7TyLH8x9.     |
      | 5eIxXyQ.             |
      | 5eIxXyQ7TyLH8x.5exXy |


