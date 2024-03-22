Feature:Permission
  Background:US_0020
    Given Benutzer geht zur URL
    And Benutzer meldet sich an

  @Probieren
  Scenario: TC_0020_0001
    Given Benutzer klickt auf der linken Seite der Seite auf „ Permissions“.
    Then Der Benutzer wird sehen, dass 94 Permission eingegangen sind.
    And Benutzer meldet sich ab

  Scenario: TC_0020_0002
    Given Benutzer klickt auf der linken Seite der Seite auf „ Permissions“.
    Then Der Benutzer sieht, dass der accounting_read angekommen ist.
    And Benutzer meldet sich ab

  Scenario: TC_0020_0003
    Given Benutzer klickt auf der linken Seite der Seite auf „ Permissions“.
    Then Der Benutzer sieht, dass der accounting_write angekommen ist.
    And Benutzer meldet sich ab