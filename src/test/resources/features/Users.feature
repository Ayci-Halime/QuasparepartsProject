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


    Scenario: TC_0015_003 Wenn der Benutzer die E-Mail des von ihm hinzugefügten Benutzers nicht bestätigt, sollte er das grüne Häkchen nicht sehen
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
      And Benutzer klickt auf das + Symbol neben den Rollen unten rechts
      And Benutzer fuegt eine neue Rolle hinzu "new_user_another_role"
      Then Benutzer prueft dass die Rolle hinzugefuegt ist
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab


    Scenario: TC_0016_003 Der Benutzer sollte in der Lage sein, die neue Rolle zu löschen, die er dem von ihm erstellten Benutzer hinzugefügt hat
      When Benutzer geht zur URL
      And Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer sucht die E-Mail Adresse des neuen Benutzers
      And Benutzer klickt den gesuchten Benutzer
      And Benutzer klickt auf das + Symbol neben den Rollen unten rechts
      And Benutzer fuegt eine neue Rolle hinzu "new_user_another_role"
      And Benutzer loescht die hinzugefuegte Rolle
      Then Benutzer bestaetigt dass die Rolle geloescht wurde
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab


    Scenario:TC_0016_004 Der Benutzer sollte die beim Anlegen des Benutzers eingegebene E-Mail-Adresse nicht ändern können
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer sucht die E-Mail Adresse des neuen Benutzers
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts









