@Users@Regression
Feature: Users
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

    @day1
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

    @day2
    Scenario: TC_0016_003 Der Benutzer sollte in der Lage sein, die neue Rolle zu löschen, die er dem von ihm erstellten Benutzer hinzugefügt hat
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das + Symbol neben den Rollen unten rechts
      And Benutzer fuegt eine neue Rolle hinzu "new_user_another_role"
      And Benutzer loescht die hinzugefuegte Rolle
      Then Benutzer bestaetigt dass die Rolle geloescht wurde
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab

    @day3
    Scenario:TC_0016_004 Der Benutzer sollte die beim Anlegen des Benutzers eingegebene E-Mail-Adresse nicht ändern können
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      Then Benutzer bestaetigt dass die E-Mail Adresse nicht geandert werden konnen
      And Benutzer klickt auf das Symbol Speichern oben rechts
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab

    @day5
    Scenario: TC_0016_005 Der Benutzer darf das Feld für den Benutzernamen nicht leer lassen, wenn er den von ihm erstellten Benutzer bearbeitet
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      And Benutzer loescht das Feld fuer den Benutzernamen
      And Benutzer klickt auf das Symbol Speichern oben rechts
      Then Benutzer bestaetigt dass er eine Fehlermeldung im Users erhalten hat
      And Benutzer klickt auf das Schließen-Symbol oben rechts
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab


    @day6
    Scenario: TC_0016_006 Der Benutzer muss den erstellten Benutzer aktualisieren, indem er Daten, die mit einem Buchstaben beginnen, in das Feld Benutzername eingibt
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      And Benutzer gibt Daten ein, die mit einem Buchstaben beginnen "new_user_username"
      And Benutzer klickt auf das Symbol Speichern oben rechts
      Then Benutzer bestaetigt dass der Benutzername aktualisiert wurde
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab

    @day7
    Scenario: TC_0016_007 Die Fehlermeldung sollte angezeigt werden, wenn der Benutzer Daten, die mit einer Zahl beginnen, in das Feld für den Benutzernamen des von ihm erstellten Benutzers eingibt
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      And Benutzer gibt Daten ein, die mit einer Zahl beginnen "new_user_username1"
      Then Benutzer bestaetigt dass er eine Fehlermeldung im Users mit Zahl erhalten hat
      And Benutzer klickt auf das Schließen-Symbol oben rechts
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab

    @day8@Fail
    Scenario: TC_0016_008 Der Benutzer sollte nicht aktualisieren können, wenn er Daten, die mit einer Zahl beginnen, in das Feld für den Benutzernamen des von ihm erstellten Benutzers eingibt
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      And Benutzer gibt Daten ein, die mit einer Zahl beginnen "new_user_username1"
      And Benutzer klickt auf das Symbol Speichern oben rechts
      Then Benutzer bestaetigt dass Benutzername nicht aktualisiert wurde
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab

    @day9
    Scenario: TC_0016_009 Es sollte eine Fehlermeldung angezeigt werden, wenn der Benutzer bei der Bearbeitung des Feldes für den Benutzernamen des von ihm erstellten Benutzers Daten eingibt, die mit einem Sonderzeichen beginnen
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      And Benutzer gibt Daten ein, die mit einem Sonderzeichen beginnen "new_user_username2"
      Then Benutzer bestaetigt dass er eine Fehlermeldung im Users mit Sonderzeichen erhalten hat
      And Benutzer klickt auf das Schließen-Symbol oben rechts
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab

    @day10@Fail
    Scenario: TC_0016_010 Der Benutzer sollte nicht aktualisieren können, wenn er bei der Bearbeitung des von ihm erstellten Benutzers Daten in das Feld Benutzername eingibt, die mit einem Sonderzeichen beginnen
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      And Benutzer gibt Daten ein, die mit einem Sonderzeichen beginnen "new_user_username2"
      And Benutzer klickt auf das Symbol Speichern oben rechts
      Then Benutzer bestaetigt dass Benutzername nicht aktualisiert wurde
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab

    @day11
    Scenario: TC_0016_011 Es sollte eine Fehlermeldung angezeigt werden, wenn der Benutzer bei der Bearbeitung des Feldes für den Benutzernamen des von ihm erstellten Benutzers Daten eingibt, die mit einem Sonderzeichen enden
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      And Benutzer gibt Daten ein, die mit einem Sonderzeichen enden "new_user_username3"
      Then Benutzer bestaetigt dass er eine Fehlermeldung im Users mit Sonderzeichen erhalten hat
      And Benutzer klickt auf das Schließen-Symbol oben rechts
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab

    @day12@Fail
    Scenario: TC_0016_012 Der Benutzer sollte nicht aktualisieren können, wenn er bei der Bearbeitung des von ihm angelegten Benutzers in das Feld Benutzername Daten eingibt, die mit einem Sonderzeichen enden
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      And Benutzer gibt Daten ein, die mit einem Sonderzeichen enden "new_user_username3"
      And Benutzer klickt auf das Symbol Speichern oben rechts
      Then Benutzer bestaetigt dass Benutzername nicht aktualisiert wurde
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab

    @day13
    Scenario: TC_0016_013 Wenn der Benutzer das Feld Benutzername in dem von ihm erstellten Benutzer bearbeitet, sollte die Fehlermeldung angezeigt werden, wenn er Daten eingibt, die andere Sonderzeichen als -._ enthalten
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      And Benutzer gibt Daten ein, die mit einem Sonderzeichen enthalten "new_user_username4"
      Then Benutzer bestaetigt dass er eine Fehlermeldung im Users mit Sonderzeichen erhalten hat
      And Benutzer klickt auf das Schließen-Symbol oben rechts
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab

    @day14@Fail
    Scenario: TC_0016_014 Wenn der Benutzer das Feld für den Benutzernamen in dem von ihm erstellten Benutzer bearbeitet, sollte er nicht aktualisiert werden, wenn er Daten eingibt, die andere Sonderzeichen als -._ enthalten
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      And Benutzer gibt Daten ein, die mit einem Sonderzeichen enthalten "new_user_username4"
      And Benutzer klickt auf das Symbol Speichern oben rechts
      Then Benutzer bestaetigt dass Benutzername nicht aktualisiert wurde
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab

    @day15
    Scenario Outline:TC_0016_015 Der Benutzer sollte keine Fehlermeldung erhalten, wenn er bei der Bearbeitung des Feldes für den Benutzernamen des von ihm erstellten Benutzers Daten eingibt, die eines der Sonderzeichen -._ enthalten
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      And Benutzer gibt Daten ein, die ein Sonderzeichen enthalten "<new_user_username5>"
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

    @day16
    Scenario Outline: TC_0016_016 Wenn der Benutzer das Feld für den Benutzernamen in dem von ihm erstellten Benutzer bearbeitet, muss der Benutzer aktualisieren, wenn er Daten eingibt, die eines der Sonderzeichen -._
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf das Bearbeitungssymbol (Stift) oben rechts
      And Benutzer gibt Daten ein, die ein Sonderzeichen enthalten "<new_user_username5>"
      And Benutzer klickt auf das Symbol Speichern oben rechts
      Then Benutzer bestaetigt dass der Benutzername aktualisiert ist
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab
      Examples:
        | new_user_username5 |
        | ad-min             |
        | ad.min             |
        | ad_min             |

  @day17
  Scenario: TC_0016_017 Der Benutzer muss in der Lage sein, das Passwort des erstellten Benutzers zurückzusetzen
      When Benutzer klickt auf das Menu Benutzer
      And Benutzer fuegt einen Benutzer hinzu
      And Benutzer klickt auf den gesuchten Benutzer
      And Benutzer klickt auf den Link Password zurucksetzen
      Then Benutzer bestaetigt dass das Password zuruckgesetzt wurde
      And Benutzer kehrt zum Benutzermenu zuruck
      And Benutzer loescht den neuen hinzugefuegten Benutzer
      And Benutzer meldet sich ab

  @tag1
  Scenario: TC_0017_001 Der Benutzer muss die Schaltfläche Neues Mitglied einladen im Benutzermenü anzeigen
    When Benutzer klickt auf das Menu Benutzer
    Then Benutzer bestaetigt dass die Schaltflache Neues Mitglied einladen angezeigt wird
    And Benutzer meldet sich ab

  @tag2
  Scenario: TC_0017_002 Der Benutzer muss die Schaltfläche Neues Mitglied hinzufügen im Menü "Benutzer" anzeigen
    When Benutzer klickt auf das Menu Benutzer
    Then Benutzer bestaetigt dass die Schaltflache Neues Mitglied hinzufugen angezeigt wird
    And Benutzer meldet sich ab

  @tag3
  Scenario: TC_0017_003 Der Benutzer muss die Schaltfläche Mehrere Mitglieder hinzufügen im Menü Benutzer anzeigen
    When Benutzer klickt auf das Menu Benutzer
    Then Benutzer bestaetigt dass die Schaltflache Mehrere Mitglieder hinzufugen angezeigt wird
    And Benutzer meldet sich ab

  @tag4
  Scenario: TC_0017_004 Der Benutzer sollte die Möglichkeit haben, einen Benutzer per E-Mail einzuladen, um einen neuen Benutzer hinzuzufügen
    When Benutzer klickt auf das Menu Benutzer
    And Benutzer klickt auf die Schaltflaeche Neues Mitglied Einladen
    And Benutzer waehlt Abteilung
    And Benutzer waehlt Rolle
    And Benutzer gibt seine E-Mail Adresse ein
    And Benutzer klickt auf Schaltflaeche Einladen
    Then Benutzer bestaetigt dass die Einladungs E-Mail verschickt wurde
    And Benutzer klickt auf Schaltflaeche Schliessen
    And Benutzer loescht den neuen hinzugefuegten Benutzer
    And Benutzer meldet sich ab

  @tag5
  Scenario: TC_0017_005 Beim Einladen eines neuen Benutzers per E-Mail sollte der Benutzer eine Fehlermeldung erhalten, wenn die Rolle leer gelassen wird
    When Benutzer klickt auf das Menu Benutzer
    And Benutzer klickt auf die Schaltflaeche Neues Mitglied Einladen
    And Benutzer waehlt Abteilung
    And Benutzer laesst die Rolle leer
    And Benutzer gibt seine E-Mail Adresse ein
    And Benutzer klickt auf Schaltflaeche Einladen
    Then Benutzer bestaetigt dass er eine Fehlermeldung beim Einladen und Hinzufuegun erhalten hat
    And Benutzer klickt auf Schaltflaeche Schliessen
    And Benutzer meldet sich ab


  @tag6
  Scenario: TC_0017_006 Beim Einladen eines neuen Benutzers per E-Mail sollte der Benutzer eine Fehlermeldung erhalten, wenn das E-Mail-Feld leer gelassen wird
    When Benutzer klickt auf das Menu Benutzer
    And Benutzer klickt auf die Schaltflaeche Neues Mitglied Einladen
    And Benutzer waehlt Abteilung
    And Benutzer waehlt Rolle
    And Benutzer laesst die E-Mail-Adresse leer
    And Benutzer klickt auf Schaltflaeche Einladen
    Then Benutzer bestaetigt dass er eine Fehlermeldung beim Einladen und Hinzufuegun erhalten hat
    And Benutzer klickt auf Schaltflaeche Schliessen
    And Benutzer meldet sich ab


  @tag7
  Scenario: TC_0017_007 Wenn der Benutzer beim Einladen eines neuen Benutzers das E-Mail-Feld leer laesst, sollte er die Einladung vornehmen
    When Benutzer klickt auf das Menu Benutzer
    And Benutzer klickt auf die Schaltflaeche Neues Mitglied Einladen
    And Benutzer laesst Abteilung leer
    And Benutzer waehlt Rolle
    And Benutzer gibt seine E-Mail Adresse ein
    And Benutzer klickt auf Schaltflaeche Einladen
    Then Benutzer bestaetigt dass die Einladungs E-Mail verschickt wurde
    And Benutzer klickt auf Schaltflaeche Schliessen
    And Benutzer loescht den neuen hinzugefuegten Benutzer
    And Benutzer meldet sich ab

  @tag8
  Scenario: TC_0017_008 Der Benutzer fügt einen neuen Benutzer hinzu, indem er auf die Schaltfläche "Neues Mitglied hinzufügen" klickt
    When Benutzer klickt auf das Menu Benutzer
    And Benutzer klickt auf die Schaltflaeche Neues Mitglied hinzufugen
    And Benutzer waehlt Abteilung
    And Benutzer waehlt Rolle
    And Benutzer gibt seine E-Mail Adresse ein
    And Benutzer klickt auf die Schaltflaeche Registrieren
    Then Benutzer ueberprueft, dass ein neuer Benutzer hinzugefuegt wurde
    And Benutzer klickt auf Schaltflaeche Schliessen
    And Benutzer loescht den neuen hinzugefuegten Benutzer
    And Benutzer meldet sich ab

  @tag9
  Scenario: TC_0017_009 Wenn der Benutzer beim Hinzufügen eines Benutzers über die Schaltfläche "Neues Mitglied hinzufügen" die Rolle nicht angibt, sollte der Benutzer eine Fehlermeldung erhalten
    When Benutzer klickt auf das Menu Benutzer
    And Benutzer klickt auf die Schaltflaeche Neues Mitglied hinzufugen
    And Benutzer waehlt Abteilung
    And Benutzer laesst die Rolle leer
    And Benutzer gibt seine E-Mail Adresse ein
    And Benutzer klickt auf die Schaltflaeche Registrieren
    Then Benutzer bestaetigt dass er eine Fehlermeldung beim Einladen und Hinzufuegun erhalten hat
    And Benutzer klickt auf Schaltflaeche Schliessen
    And Benutzer meldet sich ab

  @tag10
  Scenario: TC_0017_010 Wenn der Benutzer beim Hinzufügen eines Benutzers über die Schaltfläche "Neues Mitglied hinzufügen" das E-Mail-Feld nicht angibt, sollte der Benutzer eine Fehlermeldung erhalten
    When Benutzer klickt auf das Menu Benutzer
    And Benutzer klickt auf die Schaltflaeche Neues Mitglied hinzufugen
    And Benutzer waehlt Abteilung
    And Benutzer waehlt Rolle
    And Benutzer laesst die E-Mail-Adresse leer
    And Benutzer klickt auf die Schaltflaeche Registrieren
    Then Benutzer bestaetigt dass er eine Fehlermeldung beim Einladen und Hinzufuegun erhalten hat
    And Benutzer klickt auf Schaltflaeche Schliessen
    And Benutzer meldet sich ab

  @tag11
  Scenario: TC_0017_011 Der Benutzer sollte in der Lage sein, einen Benutzer hinzuzufügen, wenn er das Abteilungsfeld beim Hinzufügen eines Benutzers über die Schaltfläche "Neues Mitglied hinzufügen" leer lässt
    When Benutzer klickt auf das Menu Benutzer
    And Benutzer klickt auf die Schaltflaeche Neues Mitglied hinzufugen
    And Benutzer laesst Abteilung leer
    And Benutzer waehlt Rolle
    And Benutzer gibt seine E-Mail Adresse ein
    And Benutzer klickt auf die Schaltflaeche Registrieren
    Then Benutzer ueberprueft, dass ein neuer Benutzer hinzugefuegt wurde
    And Benutzer klickt auf Schaltflaeche Schliessen
    And Benutzer loescht den neuen hinzugefuegten Benutzer
    And Benutzer meldet sich ab


  @tag12
  Scenario: TC_0017_012 Der Benutzer fügt mehrere Benutzer über die Schaltfläche "Mehrere Mitglieder hinzufügen" hinzu
    When Benutzer klickt auf das Menu Benutzer
    And Benutzer klickt auf die Schaltflaeche Mehrere Mitglieder hinzufugen
    And Benutzer waehlt die Rolle aus
    And Benutzer waehld die Abteilungsart aus
    And Benutzer waehlt die Abteilung aus
    And Benutzer gibt seine E-Mail-Adresse in das E-Mail-Feld ein
    And Benutzer klickt auf die Schaltflaeche E-Mails Registrieren
    Then Benutzer bestaetigt, dass neue Benutzer hinzugefuegt wurde
    And Benutzer loescht die neuen hinzugefuegten Benutzern
    And Benutzer meldet sich ab


  @tag13
  Scenario: TC_0017_013 Wenn der Benutzer beim Hinzufügen von Benutzern über die Schaltfläche "Mehrere Mitglieder hinzufügen" die Rolle nicht auswählt, kann er keine Benutzer hinzufügen
    When Benutzer klickt auf das Menu Benutzer
    And Benutzer klickt auf die Schaltflaeche Mehrere Mitglieder hinzufugen
    And Benutzer laesst das Feld Benutzerrolle leer
    And Benutzer waehld die Abteilungsart aus
    And Benutzer waehlt die Abteilung aus
    And Benutzer gibt seine E-Mail-Adresse in das E-Mail-Feld ein
    And Benutzer klickt auf die Schaltflaeche E-Mails Registrieren
    Then Benutzer bestaetigt dass er eine Fehlermeldung beim mehrere mitglieder Hinzufuegen erhalten hat
    And Benutzer meldet sich ab


  @tag14
  Scenario: TC_0017_014 Wenn der Benutzer keinen Abteilungstyp nicht auswählt, kann er auch einen neunen Benutzern über die Schaltfläche 'Mehrere Mitglider Hinzufügen' hinzufügen
    When Benutzer klickt auf das Menu Benutzer
    And Benutzer klickt auf die Schaltflaeche Mehrere Mitglieder hinzufugen
    And Benutzer waehlt die Rolle aus
    And Benutzer laesst das Feld Abteilungstyp leer
    And Benutzer waehlt die Abteilung aus
    And Benutzer gibt seine E-Mail-Adresse in das E-Mail-Feld ein
    And Benutzer klickt auf die Schaltflaeche E-Mails Registrieren
    Then Benutzer bestaetigt, dass neue Benutzer hinzugefuegt wurde
    And Benutzer loescht die neuen hinzugefuegten Benutzern
    And Benutzer meldet sich ab


  @tag15
  Scenario: TC_0017_015 Beim Hinzufügen von Benutzern über die Schaltfläche Mehrere Mitglieder hinzufügen kann der Benutzer auch Benutzer hinzufügen, ohne das Feld Abteilung auszuwählen
    When Benutzer klickt auf das Menu Benutzer
    And Benutzer klickt auf die Schaltflaeche Mehrere Mitglieder hinzufugen
    And Benutzer waehlt die Rolle aus
    And Benutzer waehld die Abteilungsart aus
    And Benutzer laesst das Feld Abteilung leer
    And Benutzer gibt seine E-Mail-Adresse in das E-Mail-Feld ein
    And Benutzer klickt auf die Schaltflaeche E-Mails Registrieren
    Then Benutzer bestaetigt, dass neue Benutzer hinzugefuegt wurde
    And Benutzer loescht die neuen hinzugefuegten Benutzern
    And Benutzer meldet sich ab


  @tag16
  Scenario: TC_0017_016	Beim Hinzufügen von Benutzern über die Schaltfläche Mehrere Mitglieder hinzufügen kann der Benutzer neun Benutzer nicht hinzufügen, wenn das E-Mail Feld leer gelassen wird
    When Benutzer klickt auf das Menu Benutzer
    And Benutzer klickt auf die Schaltflaeche Mehrere Mitglieder hinzufugen
    And Benutzer waehlt die Rolle aus
    And Benutzer waehld die Abteilungsart aus
    And Benutzer waehlt die Abteilung aus
    And Benutzer laesst das EMail Feld leer
    And Benutzer klickt auf die Schaltflaeche E-Mails Registrieren
    Then Benutzer bestaetigt dass er eine Fehlermeldung im Email beim mehrere mitglieder Hinzufuegen erhalten hat
    And Benutzer meldet sich ab


  @tag17
  Scenario: TC_0017_017	Beim Hinzufügen von Benutzern über die Schaltfläche Mehrere Mitglieder hinzufügen kann der Benutzer einen neuen Benutzer hinzufügen, wenn er in das E-Mail Feld eine E-Mail Addresse eingibt
    When Benutzer klickt auf das Menu Benutzer
    And Benutzer klickt auf die Schaltflaeche Mehrere Mitglieder hinzufugen
    And Benutzer waehlt die Rolle aus
    And Benutzer waehld die Abteilungsart aus
    And Benutzer waehlt die Abteilung aus
    And Benutzer gibt eine E-Mail-Adresse in das E-Mail-Feld ein
    And Benutzer klickt auf die Schaltflaeche E-Mails Registrieren
    Then Benutzer bestaetigt, dass neue Benutzer hinzugefuegt wurde
    And Benutzer loescht die neuen hinzugefuegten Benutzern
    And Benutzer meldet sich ab
























