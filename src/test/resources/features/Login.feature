@Login @Smoke @Regression @both
Feature: Login
  Background:
    Given Benutzer geht zur URL
    And Benutzer klickt auf die Schaltflaeche Anmelden



  Scenario: TC_0001_001 Benutzer muss sich mit gültiger E-Mail und Passwort anmelden
    When Benutzer gibt seine EMail oder Username ein "username"
    And Benutzer gibt seinen Password ein "password"
    And Benutzer klickt auf die Schaltflaeche Sigin
    Then Benutzer prueft dass er angemeldet ist
    And Benutzer meldet sich ab


  Scenario Outline: TC_0001_002,TC_0001_003,TC_0001_004,TC_0001_005,TC_0001_006,TC_0001_007,TC_0001_009
    When Benutzer gibt E-Mail oder Username ein "<username>"
    And Benutzer gibt Password ein "<password>"
    And Benutzer klickt auf die Schaltflaeche Sigin
    Then Benutzer bestaetigt dass er eine Fehlermeldung erhalten hat
    Examples:
      | username            | password         |
      | dsdt2004gmail.com   |  lcYtbIv7nBhIrqX |
      | dsdt2004@gmailcom   |  lcYtbIv7nBhIrqX |
      | dsdt2004@gmail..com |  lcYtbIv7nBhIrqX |
      | dsdt2010@gmail.com  |  lcYtbIv7nBhIrqX |
      | dsdt2004@gmail.com  |  lcYtbIvBhIrqX98 |
      | dsdt2010@gmail.com  |  lcYtbIvBhIrqX98 |
      | dsdt2004gmailcom    |  lcYtbIv7nBhIrqX |


  Scenario: TC_0001_008 Wenn sich der Benutzer mit einer gültigen E-Mail und einem gültigen Passwort anmeldet, sollte die Startseite angezeigt werden
    When Benutzer gibt seine EMail oder Username ein "username"
    And Benutzer gibt seinen Password ein "password"
    And Benutzer klickt auf die Schaltflaeche Sigin
    Then Benutzer bestaetigt dass die Homepage angezeigt wird
    And Benutzer meldet sich ab
