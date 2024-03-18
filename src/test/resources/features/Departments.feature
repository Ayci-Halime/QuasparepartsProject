@Department
  Feature:US_0007
    Background:
      Given Benutzer geht zur URL
      And Benutzer meldet sich an
      Scenario: TC_0007_001
        Given Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
        Then Der Benutzer uberpruft, ob die Finanzabteilung angezeigt wird


