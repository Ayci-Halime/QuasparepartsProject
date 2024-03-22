Feature:
  Background:US_0018
    Given Benutzer geht zur URL
    And Benutzer meldet sich an

  @Probieren
  Scenario: TC_0018_0001
    Given Benutzer klickt auf der linken Seite der Seite auf „Rolles“.
    Then Benutzer bestaetigt, dass es im Modul Alle Rollen 14 Rollen gibt.
    And Benutzer meldet sich ab




  Scenario: TC_0019_0001
    Given Benutzer klickt auf der linken Seite der Seite auf „ Rolles“.
    And Der Benutzer sieht, dass der Store Manager angekommen ist.
    Then Der Benutzer bestätigt, dass er auf Store Manager geklickt hat.
    And Benutzer meldet sich ab