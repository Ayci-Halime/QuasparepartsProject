@RemoteUnits @Regression
Feature: US_0010, US_0011

  Background:
    Given Benutzer geht zur URL
    And Benutzer meldet sich an

  Scenario: TC_0010_001
    When  Benutzer klickt auf dieSchaltflaeche RemoteUnits
    Then Benutzer bestaetigt, dass sich die RemoteUnit "K��ln Warehouse" betrachtet
    And Benutzer meldet sich ab



  Scenario: TC_0010_002
    When Benutzer erstellt Remote unit "New RemoteUnit"
    And Benutzer klickt auf dieSchaltflaeche RemoteUnits
    And Benutzer gibt den search "New RemoteUnit" ein
    Then Benutzer bestätigt, dass er Remote-Units anzeigt
    And Benutzer loescht die hinzugefuegte Remote Unit "New RemoteUnit"
    And Benutzer meldet sich ab


  Scenario:TC_0010_003
    When Benutzer erstellt Remote unit "New RemoteUnit"
    And Benutzer klickt auf dieSchaltflaeche RemoteUnits
    And Benutzer gibt den search "New RemoteUnit" ein
    Then Benutzer bestaetigt, dass sich die RemoteUnit "New RemoteUnit" betrachtet
    And Benutzer loescht die hinzugefuegte Remote Unit "New RemoteUnit"
    And Benutzer meldet sich ab


  Scenario:TC_0011_001
    When Benutzer klickt auf dieSchaltflaeche RemoteUnits
    And Benutzer klickt auf dieSchaltflaeche Add new Remote Unit
    And Benutzer gibt den Abteilungsnamen "New RemoteUnit" ein
    And Benutzer waehlt als Abteilungstyp "Remote Unit" aus
    And Benutzer klickt auf dieSchaltflaeche save
    And Benutzer klickt auf dieSchaltflaeche RemoteUnits
    And Benutzer gibt den search "New RemoteUnit" ein
    Then Benutzer bestaetigt, dass sich die RemoteUnit "New RemoteUnit" betrachtet
    And Benutzer loescht die hinzugefuegte Remote Unit "New RemoteUnit"
    And Benutzer meldet sich ab


  Scenario:TC_0011_002
    When Benutzer klickt auf dieSchaltflaeche RemoteUnits
    And Benutzer klickt auf dieSchaltflaeche Add new Remote Unit
    And Benutzer waehlt als Abteilungstyp "Remote Unit" aus
    And Benutzer klickt auf dieSchaltflaeche save
    Then Benutzer bestaetigt, dass sich die errormessage betrachtet
    And Benutzer meldet sich ab

  Scenario:TC_0011_003
    When Benutzer klickt auf dieSchaltflaeche RemoteUnits
    And Benutzer klickt auf dieSchaltflaeche Add new Remote Unit
    And Benutzer gibt den Abteilungsnamen "New RemoteUnit" ein
    And Benutzer klickt auf dieSchaltflaeche save
    Then Benutzer bestaetigt, dass sich die type errormessage betrachtet
    And Benutzer meldet sich ab

  Scenario:TC_0011_004
    When Benutzer klickt auf dieSchaltflaeche RemoteUnits
    And Benutzer klickt auf dieSchaltflaeche Add new Remote Unit
    And Benutzer gibt den Abteilungsnamen "New RemoteUnit" ein
    And Benutzer gibt den  Short Name "NR" ein
    And Benutzer waehlt als Abteilungstyp "Remote Unit" aus
    And Benutzer gibt den Description "Remote"ein
    And Benutzer wählt Role "Sales Manager" aus
    And Benutzer klickt auf dieSchaltflaeche save
    And Benutzer klickt auf dieSchaltflaeche RemoteUnits
    And Benutzer gibt den search "New RemoteUnit" ein
    Then Benutzer bestaetigt, dass sich die RemoteUnit "New RemoteUnit" betrachtet
    And Benutzer loescht die hinzugefuegte Remote Unit "New RemoteUnit"
    And Benutzer meldet sich ab


  Scenario:TC_0012_001
    When Benutzer erstellt Remote unit "New RemoteUnit" "Remote Unit" "NR" "Remote" "Sales Manager"
    And Benutzer klickt auf die Schaltflaeche editButton
    And Benutzer gibt den Abteilungsnamen "New Unit" ein
    And Benutzer klickt auf dieSchaltflaeche save
    Then Benutzer bestaetigt, dass die departments name aktualisiert wurde
    And Benutzer loescht die hinzugefuegte Remote Unit "New Unit"
    And Benutzer meldet sich ab


  Scenario:TC_0012_002
    When Benutzer erstellt Remote unit "New RemoteUnit" "Remote Unit" "NR" "Remote" "Sales Manager"
    And Benutzer klickt auf die Schaltflaeche editButton
    And Benutzer gibt den  Short Name "NRU" ein
    And Benutzer klickt auf dieSchaltflaeche save
    Then Benutzer bestaetigt, dass die departments name aktualisiert wurde
    And Benutzer loescht die hinzugefuegte Remote Unit "New RemoteUnit"
    And Benutzer meldet sich ab



  Scenario:TC_0012_003
    When Benutzer erstellt Remote unit "New RemoteUnit" "Remote Unit" "NR" "Remote" "Sales Manager"
    And Benutzer klickt auf die Schaltflaeche editButton
    And Benutzer waehlt als Abteilungstyp "Department" aus
    And Benutzer klickt auf dieSchaltflaeche save
    Then Benutzer bestaetigt, dass die departments name aktualisiert wurde
    And Benutzer klickt auf die Schaltflaeche editButton
    And Benutzer waehlt als Abteilungstyp "Remote Unit" aus
    And Benutzer klickt auf dieSchaltflaeche save
    And Benutzer loescht die hinzugefuegte Remote Unit "New RemoteUnit"
    And Benutzer meldet sich ab
