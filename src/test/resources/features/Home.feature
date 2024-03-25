@Home @Regression @Hlm
Feature: HomePage

  Background:
    Given Benutzer geht zur URL
    And Benutzer meldet sich an


  Scenario:TC_0002_001 Logo Anzeigen
    Then Benutzer bestaetigt, dass  das Nioyatech-Logo sichtbar ist
    And Benutzer meldet sich ab

  Scenario:TC_0002_002 Logo Klicken
    When Benutzer klickt auf das Nioyatech-Logo
    Then Benutzer bestaetigt, dass er die Startseite anzeigt
    And Benutzer klickt auf die Schaltflaeche Anmelden
    And Benutzer meldet sich ab


  Scenario: TC_0002_003 Seitenleiste Sehen
    Then Benutzer bestaetigt, dass er die Seitenleiste unten links anzeigt
    And Benutzer meldet sich ab

  Scenario: TC_0002_004 Seitenleiste Anklickbar
    Then Benutzer bestaetigt,dass Menubar ausgeblendet wird
    And Benutzer meldet sich ab

  Scenario: TC_0002_005 Seitenleiste Anklickbar
    When Benutzer klickt auf die Menubar
    Then Benutzer bestaetigt, dass Menubar angezeigt wird
    And Benutzer meldet sich ab


  Scenario: TC_0003_001 Email Adresse Anzeigen
    Then Benutzer bestaetigt, dass er die E-Mail-Adresse in der oberen rechten Ecke sieht.
    And Benutzer meldet sich ab

  Scenario: TC_0003_002 Titel Anzeigen
    Then Benutzer bestaetigt, dass sein Titel in der oberen rechten Ecke angezeigt wird
    And Benutzer meldet sich ab


    Scenario: TC_0003_003 Email Adresse Anzeigen in Dropdownmenu
      When Benutzer klickt auf das Menu Benutzerr
      Then Benutzer bestaetigt, dass er die E-Mail-Adresse in der oberen in DropDown sieht.
      And Benutzer meldet sich ab

    Scenario:  TC_0003_004 Titel Anzeigen in Dropdownmenu
      When Benutzer klickt auf das Menu Benutzerr
      Then Benutzer bestaetigt, dass er die Titel in der oberen in DropDown sieht.
      And Benutzer meldet sich ab






