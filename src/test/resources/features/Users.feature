@Users
Feature: US_0015, US_0016,US_0017
  Background:
    Given Benutzer geht zur URL
    And Benutzer meldet sich an

    Scenario: TC_0015_001 Der Benutzer muss einen von ihm hinzugefügten Benutzer sehen
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer sucht die E-Mail Adresse des neuen Benutzers
      Then Benutzer bestaetigt dass der neue Benutzer hinzugefuegt ist
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab








