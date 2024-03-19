@Department
  Feature:US_0007
    Background:
      Given Benutzer geht zur URL
      And Benutzer meldet sich an
      Scenario: TC_0007_001
        Given Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
        Then Der Benutzer uberpruft, ob die Finanzabteilung angezeigt wird

      Scenario: TC_0007_002
        Given Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
        Then Der Benutzer uberpruft, ob die Logistikabteilung angezeigt wird

      Scenario: TC_0007_003
        Given Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
        Then Der Benutzer uberpruft, ob die Abteilung „Marketing und Vertrieb“ angezeigt wird

      Scenario: TC_0007_004
        Given  Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
        Then  Der Benutzer uberpruft, ob die Qualitetssicherungsabteilung angezeigt wird

      Scenario: TC_0007_005
        Given Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
        And Der Benutzer klickt auf die Schaltflache „Neue Abteilung hinzufugen“.
        And Der Benutzer schreibt den Abteilungsnamen
        And Der Benutzer schreibt den Kurznamen der Abteilung
        And Der Benutzer wahlt den Abteilungstyp aus
        And Der Benutzer klickt auf die Schaltflache „Speichern“.
        Then Uberpruft, ob eine neue Abteilung zum Abschnitt „Abteilung“ hinzugefugt werden kann

      Scenario: TC_0008_001
        Given  Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
        And Der Benutzer klickt auf die Schaltflache „Neue Abteilung hinzufugen“.
        And Der Benutzer schreibt den Abteilungsnamen
        And Der Benutzer schreibt den Kurznamen der Abteilung
        And Der Benutzer wahlt den Abteilungstyp aus
        And Der Benutzer klickt auf die Schaltflache „Speichern“.
        Then Uberpruft, ob eine neue Abteilung zum Abschnitt „Abteilung“ hinzugefugt werden kann

      Scenario: TC_0008_002
        Given  Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
        Then  Der Benutzer uberpruft, ob die Schaltflache „Neue Abteilung hinzufugen“ im Abschnitt „Abteilung“ angezeigt wird

    Scenario: TC_0008_003
      Given  Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
      And Der Benutzer klickt auf die Schaltflache „Neue Abteilung hinzufugen“.
      And Der Benutzer lasst den Abschnitt „Abteilungsname“ leer.
      And Der Benutzer schreibt den Kurznamen der Abteilung
      And Der Benutzer wahlt den Abteilungstyp aus
      And Der Benutzer klickt auf die Schaltflache „Speichern“.
      And Stellt sicher, dass dem Abschnitt „Abteilung“ keine neue Abteilung hinzugefugt werden kann.

    Scenario: TC_0008_004
      Given  Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
      And Der Benutzer klickt auf die Schaltflache „Neue Abteilung hinzufugen“.
      And Drucken Sie im Abschnitt „Name der Benutzerabteilung“ einfach die Leertaste.
      And Der Benutzer schreibt den Kurznamen der Abteilung
      And Der Benutzer wahlt den Abteilungstyp aus
      And Der Benutzer klickt auf die Schaltflache „Speichern“.
      Then Uberpruft, ob dem Abschnitt „Abteilung“ eine neue Abteilung hinzugefugt wurde

    Scenario: TC_0008_005
      Given  Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
      And Der Benutzer klickt auf die Schaltflache „Neue Abteilung hinzufugen“.
      And Drucken Sie im Abschnitt „Name der Benutzerabteilung“ einfach die Leertaste.
      And Im Abschnitt „Name der Benutzerabteilung“ konnen nur Zahlen eingegeben werden.
      And Der Benutzer wahlt den Abteilungstyp aus
      And Der Benutzer klickt auf die Schaltflache „Speichern“.
      Then Uberpruft, ob dem Abschnitt „Abteilung“(mit Zahlen) eine neue Abteilung hinzugefugt wurde

    Scenario: TC_0008_006
      Given  Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
      And Der Benutzer klickt auf die Schaltflache „Neue Abteilung hinzufugen“.
      And Im Abschnitt „Name der Benutzerabteilung“ konnen nur Sonderzeichen eingegeben werden.
      And Im Abschnitt „Name der Benutzerabteilung“ konnen nur Zahlen eingegeben werden.
      And Der Benutzer wahlt den Abteilungstyp aus
      And Der Benutzer klickt auf die Schaltflache „Speichern“.
      Then Uberpruft, ob dem Abschnitt „Abteilung“(mit Sonderzeichen) eine neue Abteilung hinzugefugt wurde

    Scenario: TC_0008_007
      Given  Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
      And Der Benutzer klickt auf die Schaltflache „Neue Abteilung hinzufugen“.
      And Der Benutzer schreibt den Abteilungsnamen
      And Der Benutzer schreibt den Kurznamen der Abteilung
      And Der Benutzer lasst Abteilungstyp leer.
      And Der Benutzer klickt auf die Schaltflache „Speichern“.
      Then Uberpruft, ob dem Abschnitt „Abteilung“ keine neue Abteilung hinzugefugt wurde

      @Benutzer
    Scenario: TC_0009_001
      Given  Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.
      And Der Benutzer klickt auf eine gespeicherte Abteilung
      And Der Benutzer klickt auf „Abteilung bearbeiten“.
      And Andert den Benutzernamen.
      And Der Benutzer klickt auf die Schaltflache „Speichern“.
      And Der Benutzer klickt auf den Abteilungsbereich
      Then Der Benutzer bestätigt den neuen Namen