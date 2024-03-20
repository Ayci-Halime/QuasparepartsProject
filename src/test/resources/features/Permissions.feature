Feature:
  Background:US_0020
    Given Benutzer geht zur URL
    And Benutzer meldet sich an
  Scenario: TC_0020_0001
    Given Benutzer klickt auf der linken Seite der Seite auf „ Permissions“.
    And Der Benutzer klickt links auf der Seite auf Berechtigungen.
    Then Der Benutzer sieht, dass der accounting_read angekommen ist.
    And Benutzer meldet sich ab