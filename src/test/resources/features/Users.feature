@Users@Regression
Feature: US_0015, US_0016, US_0017
  Background:
    Given Benutzer geht zur URL
    And Benutzer meldet sich an

    @day
    Scenario: TC_0015_001 Der Benutzer muss einen von ihm hinzugefügten Benutzer sehen
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer sucht die E-Mail Adresse des neuen Benutzers
      Then Benutzer bestaetigt dass der neue Benutzer hinzugefuegt ist
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab


    Scenario: TC_0016_002 Der Benutzer muss in der Lage sein, dem von ihm erstellten Benutzer eine neue Rolle hinzuzufügen
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
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
      Then Benutzer bestaetigt dass die E-Mail Adresse nicht geandert werden konnen
      And Benutzer klickt auf das Symbol Speichern oben rechts
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab


    Scenario: TC_0016_005 Der Benutzer darf das Feld für den Benutzernamen nicht leer lassen, wenn er den von ihm erstellten Benutzer bearbeitet
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer sucht die E-Mail Adresse des neuen Benutzers
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      And Benutzer loescht das Feld fuer den Benutzernamen
      And Benutzer klickt auf das Symbol Speichern oben rechts
      Then Benutzer bestaetigt dass er eine Fehlermeldung im Users erhalten hat
      And Benutzer klickt auf das Schließen-Symbol oben rechts
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab



    Scenario: TC_0016_006 Der Benutzer muss den erstellten Benutzer aktualisieren, indem er Daten, die mit einem Buchstaben beginnen, in das Feld Benutzername eingibt
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer sucht die E-Mail Adresse des neuen Benutzers
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      And Benutzer gibt Daten ein, die mit einem Buchstaben beginnen "new_user_username"
      And Benutzer klickt auf das Schließen-Symbol oben rechts
      Then Benutzer bestaetigt dass der Benutzername aktualisiert wurde
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab


    Scenario: TC_0016_007 Die Fehlermeldung sollte angezeigt werden, wenn der Benutzer Daten, die mit einer Zahl beginnen, in das Feld für den Benutzernamen des von ihm erstellten Benutzers eingibt
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer sucht die E-Mail Adresse des neuen Benutzers
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      And Benutzer gibt Daten ein, die mit einer Zahl beginnen "new_user_username1"
      Then Benutzer bestaetigt dass er eine Fehlermeldung im Users mit Zahl erhalten hat
      And Benutzer klickt auf das Schließen-Symbol oben rechts
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab


    Scenario: TC_0016_008 Der Benutzer sollte nicht aktualisieren können, wenn er Daten, die mit einer Zahl beginnen, in das Feld für den Benutzernamen des von ihm erstellten Benutzers eingibt
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer sucht die E-Mail Adresse des neuen Benutzers
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      And Benutzer gibt Daten ein, die mit einer Zahl beginnen "new_user_username1"
      And Benutzer klickt auf das Symbol Speichern oben rechts
      Then Benutzer bestaetigt dass Benutzername nicht aktualisiert wurde
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab

    Scenario: TC_0016_009 Es sollte eine Fehlermeldung angezeigt werden, wenn der Benutzer bei der Bearbeitung des Feldes für den Benutzernamen des von ihm erstellten Benutzers Daten eingibt, die mit einem Sonderzeichen beginnen
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer sucht die E-Mail Adresse des neuen Benutzers
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      And Benutzer gibt Daten ein, die mit einem Sonderzeichen beginnen "new_user_username2"
      Then Benutzer bestaetigt dass er eine Fehlermeldung im Users mit Sonderzeichen erhalten hat
      And Benutzer klickt auf das Schließen-Symbol oben rechts
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab

    Scenario: TC_0016_010 Der Benutzer sollte nicht aktualisieren können, wenn er bei der Bearbeitung des von ihm erstellten Benutzers Daten in das Feld Benutzername eingibt, die mit einem Sonderzeichen beginnen
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer sucht die E-Mail Adresse des neuen Benutzers
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      And Benutzer gibt Daten ein, die mit einem Sonderzeichen beginnen "new_user_username2"
      And Benutzer klickt auf das Symbol Speichern oben rechts
      Then Benutzer bestaetigt dass Benutzername nicht aktualisiert wurde
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab


    Scenario: TC_0016_011 Es sollte eine Fehlermeldung angezeigt werden, wenn der Benutzer bei der Bearbeitung des Feldes für den Benutzernamen des von ihm erstellten Benutzers Daten eingibt, die mit einem Sonderzeichen enden
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer sucht die E-Mail Adresse des neuen Benutzers
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      And Benutzer gibt Daten ein, die mit einem Sonderzeichen enden "new_user_username3"
      Then Benutzer bestaetigt dass er eine Fehlermeldung im Users mit Sonderzeichen erhalten hat
      And Benutzer klickt auf das Schließen-Symbol oben rechts
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab

    Scenario: TC_0016_012 Der Benutzer sollte nicht aktualisieren können, wenn er bei der Bearbeitung des von ihm angelegten Benutzers in das Feld Benutzername Daten eingibt, die mit einem Sonderzeichen enden
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer sucht die E-Mail Adresse des neuen Benutzers
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      And Benutzer gibt Daten ein, die mit einem Sonderzeichen enden "new_user_username3"
      And Benutzer klickt auf das Symbol Speichern oben rechts
      Then Benutzer bestaetigt dass Benutzername nicht aktualisiert wurde
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab


    Scenario: TC_0016_013 Wenn der Benutzer das Feld Benutzername in dem von ihm erstellten Benutzer bearbeitet, sollte die Fehlermeldung angezeigt werden, wenn er Daten eingibt, die andere Sonderzeichen als -._ enthalten
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer sucht die E-Mail Adresse des neuen Benutzers
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      And Benutzer gibt Daten ein, die mit einem Sonderzeichen enden "new_user_username4"
      Then Benutzer bestaetigt dass er eine Fehlermeldung im Users mit Sonderzeichen erhalten hat
      And Benutzer klickt auf das Schließen-Symbol oben rechts
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab

    Scenario: TC_0016_014 Wenn der Benutzer das Feld für den Benutzernamen in dem von ihm erstellten Benutzer bearbeitet, sollte er nicht aktualisiert werden, wenn er Daten eingibt, die andere Sonderzeichen als -._ enthalten
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer sucht die E-Mail Adresse des neuen Benutzers
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      And Benutzer gibt Daten ein, die einem Sonderzeichen enthalten "new_user_username4"
      And Benutzer klickt auf das Symbol Speichern oben rechts
      Then Benutzer bestaetigt dass Benutzername nicht aktualisiert wurde
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab


    Scenario Outline:TC_0016_015 Der Benutzer sollte keine Fehlermeldung erhalten, wenn er bei der Bearbeitung des Feldes für den Benutzernamen des von ihm erstellten Benutzers Daten eingibt, die eines der Sonderzeichen -._ enthalten
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer sucht die E-Mail Adresse des neuen Benutzers
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      And Benutzer gibt Daten ein, die ein Sonderzeichen enthalten "<new_user_username5>"
      And Benutzer klickt auf das Symbol Speichern oben rechts
      Then Benutzer bestaetigt dass er keine Fehlermeldung erhalten hat
      And Benutzer klickt auf das Schließen-Symbol oben rechts
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab
      Examples:
        | new_user_username5 |
        | ad-min |
        | ad.min |
        | ad_min |


    Scenario Outline: TC_0016_016 Wenn der Benutzer das Feld für den Benutzernamen in dem von ihm erstellten Benutzer bearbeitet, muss der Benutzer aktualisieren, wenn er Daten eingibt, die eines der Sonderzeichen -._
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer sucht die E-Mail Adresse des neuen Benutzers
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      And Benutzer gibt Daten ein, die ein Sonderzeichen enthalten "<new_user_username6>"
      And Benutzer klickt auf das Symbol Speichern oben rechts
      Then Benutzer bestaetigt dass der Benutzername aktualisiert wurde
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab
      Examples:
        | new_user_username6 |
        | ad-min |
        | ad.min |
        | ad_min |


    Scenario: TC_0016_017 Der Benutzer muss in der Lage sein, das Passwort des erstellten Benutzers zurückzusetzen
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer sucht die E-Mail Adresse des neuen Benutzers
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf den Link Password zurucksetzen
      Then Benutzer bestaetigt dass das Password zuruckgesetzt wurde
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab



