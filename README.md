# **E-Commerce(Pharma)**


## **Über das Project**

Bei dieser Website handelt es sich um eine E-Commerce-Website für Benutzer eines Pharmaunternehmens.

## **Mitwirkende**

Dieses Projekt wurde von vier QA-Testern unterstützt. Zusätzlich zu der Rolle des QA-Testers wurden die folgenden Rollen auch von QA-Testern übernommen:
Teamleiter-rolle
Scrum-Master-Rolle
Produktbesitzer-rolle
Testarchitekten-rolle
Business-Analysten-rolle

## **Build-Management-Tool**

Für den Aufbau des Projekt-Frameworks wurde Cucumber Page Object Model (POM) mit Maven verwendet. Cucumber POM hilft uns dabei, Testfälle zu erstellen und auszuführen, und bietet eine bessere Wartbarkeit, Wiederverwendbarkeit und verbesserte Lesbarkeit des Codes. POM ermöglicht es, die Logik des Codes mit separaten Klassen für jede Seite klarer auszudrücken.
Treiberklasse, Datenverwaltung und Bericht
In diesem Projekt wurde das Ziel verfolgt, Tests parallel auszuführen. Zur parallelen Ausführung von Tests wurde der Treiber aus der Klasse DriverThreadLocal verwendet. Die zu verwendenden Testdaten wurden von QA-Ingenieuren festgelegt. Zur Verwaltung der Daten wurde die Datei configuration.properties verwendet. Außerdem wurde für die Berichterstattung in diesem Projekt der Extend-Cucumber-Report verwendet.

## **Projekt-Management-Tool**

Für die Fehlerverfolgung, Problemerkennung, Agile-Projektverwaltung und als Projektmanagement-Tool wurde Jira Xray verwendet. Darüber hinaus wurde durch die Integration von Jira und GitHub mit Slack sichergestellt, dass das Team Benachrichtigungen erhält, wenn es eine Änderung in Jira oder GitHub gibt.

## **Wie kann man dieses Projekt ausführen und Berichte erhalten?**

Wenn wir unsere Tests parallel ausführen möchten, müssen wir dem pom.xml-Datei ein Plugin hinzufügen und dieses Plugin konfigurieren. Anschließend können wir die Tests durch Eingabe des Testbefehls in das Terminal ausführen.
Alternativ können wir unsere Tests auch von der Runner-Klasse ausführen.
Der Testbericht wird im Test-Output-Ordner gesammelt.





## **Hakkinda**

Bu site bir ilac firmasinin kullanicilarinin E-Ticaret sitesidir.

## **Katkıda Bulunanlar**

Bu projeye dört QA Tester tarafından katkı sağlanmıştır. Ayrıca, QA Tester rolüne ek olarak, aşağıdaki roller de QA Testerlar tarafından üstlenilmiştir.
Takım Lideri Rolü
Scrum Master Rolü
Ürün Sahibi Rolü
Test Mimarı Rolü
İş Analisti Rolü

## **Build Yönetim Aracı**

Proje framework'ünü oluşturmak için Cucumber Page Object Model (POM) ile Maven kullanılmıştır. Cucumber POM, test case'lerimizi oluşturup çalıştırmamıza yardımcı olur, kodlarda daha iyi bakım, yeniden kullanılabilirlik ve geliştirilmiş okunabilirlik sağlar. POM, her sayfa için ayrı sınıflarla kod mantığının daha net ifade edilmesini sağlar.

## **Driver Class, Veri Yönetimi ve Rapor**

Bu projede testleri paralel çalıştırmak hedeflenmiştir. Testleri paralel  çalıştırmak için DriverThreadLocal sınıfından driver kullanılmıştır. Testlerde kullanıcalak veriler, QA Mühendisleri tarafından belirlenmiştir.. Verileri yönetmek için configuration.properties dosyası kullanılmıştır. Ayrıca, sonuçları raporlamak için bu projede Extend cucumber report kullanılmıştır.

## **Proje Yönetim Aracı**

Bu projede, hata takibi, sorun takibi, Agile Proje Yönetimi ve proje yönetim aracı olarak Jira Xray kullanılmıştır. Bunun yanı sıra, Jira ve GitHub'ı Slack ile entegre edilerek, takımın Jira veya GitHub'ta bir değişiklik olduğunda bildirim almasını sağlanmıştır.

## **Bu projeyi nasıl çalıştırabilir ve rapor alabilirsiniz?**

Eger testlerimizi paralel calistirmak istiyorsak pom.xml dosyasina plugin ekleyerek bu plugini yapilandirmak gereklidir.Daha sonra Terminalden test komutunu girerek calistirabiliriz.
Bunun yani sira testlerimizi runner classindan da calistirabiliriz
Test raporu test-output klasöründe toplanacaktir.

