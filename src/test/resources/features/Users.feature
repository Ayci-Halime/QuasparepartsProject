@Users@Regression
Feature: US_0015, US_0016, US_0017
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


    Scenario: TC_0015_003 Wenn der Benutzer die E-Mail des von ihm hinzugefügten Benutzers nicht bestätigt, sollte er das grüne Häkchen nicht sehen.
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer sucht die E-Mail Adresse des neuen Benutzers
      And Benutzer bestaetigt dass die gruene Hacken nicht sichtbar ist
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab


    Scenario: TC_0016_002 Der Benutzer muss in der Lage sein, dem von ihm erstellten Benutzer eine neue Rolle hinzuzufügen
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer sucht die E-Mail Adresse des neuen Benutzers
      And Benutzer klickt auf den gesuchten Benutzer







