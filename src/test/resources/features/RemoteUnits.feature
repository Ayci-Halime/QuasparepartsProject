  @RemoteUnits @Regression
  Feature: US_0010
    Background:
      Given Benutzer geht zur URL
      And Benutzer meldet sich an

      Scenario: TC_0010_001
        When  Benutzer klickt auf dieSchaltflaeche RemoteUnits
        Then Benutzer bestaetigt, dass sich die RemoteUnit "K��ln Warehouse" betrachtet
        And Benutzer meldet sich ab

        Scenario:TC_0010_003
          When Benutzer klickt auf dieSchaltflaeche RemoteUnits
          And Benutzer klickt auf dieSchaltflaeche Add new Remote Unit
          And Benutzer gibt den Abteilungsnamen "New RemoteUnit" ein
          And Benutzer waehlt als Abteilungstyp Remote-Unit aus
          And Benutzer klickt auf dieSchaltflaeche save
          And Benutzer klickt auf dieSchaltflaeche RemoteUnits
          Then Benutzer bestaetigt, dass sich die RemoteUnit "New RemoteUnit" betrachtet
          And Benutzer loescht die hinzugefuegte Remote Unit "New RemoteUnit"
          And Benutzer meldet sich ab


