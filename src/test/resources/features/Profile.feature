@Profile @Regression @Hlm
Feature: Profile

  Background:
    Given Benutzer geht zur URL
    And Benutzer meldet sich an Profile

  @PositiveScnario
  Scenario: TC_0004_001 Email Adresse nicht Aktualisieren
    When Benutzer klickt auf die Schaltflaeche edit
    Then Benutzer bestaetigt, dass sich die E-Mail-Adresse nicht geaendert hat
    And Benutzer meldet sich ab

  @PositiveScnario @Smoke
  Scenario Outline: TC_0004_002,TC_0004_011,TC_0004_012  Password Aktualisieren
    When Benutzer klickt auf dieSchaltflaeche Change Password
    And Benutzer gibt   "<Password>" "<Password2>" ein
    And Benutzer klickt auf die Schaltflaeche Confirm
    Then Benutzer bestaetigt, Password wurde aktualisiert
    And Benutzer klickt auf dieSchaltflaeche cancel
    And Benutzer aktualisiert altes Passwort
    And Benutzer meldet sich ab
    Examples:
      | Password             | Password2            |
      | 5eIxXyQ7TyLH8x9.     | 5eIxXyQ7TyLH8x9.     |
      | 5eIxXyQ.             | 5eIxXyQ.             |
      | 5eIxXyQ7TyLH8x.5exXy | 5eIxXyQ7TyLH8x.5exXy |

  @NegativeScnario @Smoke
  Scenario Outline:TC_0004_003,TC_0004_004,TC_0004_005,TC_0004_006,TC_0004_007,TC_0004_008,TC_0004_009,TC_0004_010 Password nicht Aktualisieren

    When Benutzer klickt auf dieSchaltflaeche Change Password
    And Benutzer gibt   "<Password>" "<Password2>" ein
    And Benutzer klickt auf die Schaltflaeche Confirm
    Then Benutzer bestaetigt, Password wurde nicht aktualisiert
    And Benutzer klickt auf die dieSchaltflaeche cancel
    And Benutzer meldet sich ab


    Examples:
      | Password              | Password2             |
      | 5eIxXy.               | 5eIxXy.               |
      | 5eIxXy.12345678912345 | 5eIxXy.12345678912345 |
      |                       |                       |
      | 5eixxyq7tylh8x.       | 5eixxyq7tylh8x.       |
      | 5EIXXYQ7TYLH8X.       | 5EIXXYQ7TYLH8X.       |
      | 5eIxXyQ7TyLH8x        | 5eIxXyQ7TyLH8x        |
      | 5eIxXyQ7TyLH8x.§      | 5eIxXyQ7TyLH8x.§      |
      | eIxXyQTyLHx.          | eIxXyQTyLHx.          |


