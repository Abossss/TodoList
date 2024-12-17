# 📋 **TodoList**

<div align="center">  

[简体中文](README_CN.md) / [繁体中文](README_TC.md) / [English](README.md) / Deutsch / [日本語](README_JP.md)

</div>  

---

## 🌐 <span style="color: #2ecc71;">Projektübersicht</span> 💡

`TodoList` ist eine einfache grafische Aufgabenverwaltungsanwendung, die mit Java Swing erstellt wurde. Sie hilft den Benutzern, Aufgaben hinzuzufügen, anzuzeigen, zu verwalten und als erledigt zu markieren. Die Anwendung zeigt eine intuitive Aufgabenliste an und unterstützt die lokale Speicherung von Aufgabendaten, sodass Benutzer beim nächsten Start der Anwendung den vorherigen Aufgabenstatus wiederherstellen können. 📅

---

## 🛠️ <span style="color: #9b59b6;">Projektstruktur</span> 📂

- **Wurzelverzeichnis**:
    - `.gitignore`: Gibt Dateien oder Verzeichnisse an, die nicht vom Git-Versionskontrollsystem verfolgt werden sollen, um unnötige lokale Konfigurations- oder Kompilierungsdateien vom Repository fernzuhalten und das Repository sauber zu halten. 🗑️
    - `tasks.txt`: Eine Textdatei, die zur Speicherung von Aufgabeninformationen verwendet wird. Die Anwendung lädt die Aufgabendaten aus dieser Datei und speichert alle Änderungen an den Aufgaben (wie Hinzufügen, Löschen, Aktualisieren des Status) zurück in diese Datei, um die Daten persistent zu halten. 📄
    - `TodoList.iml`: Die Konfigurationsdatei des Projekts für die IntelliJ IDEA IDE, die Projektmodul- und Abhängigkeitsinformationen speichert und sicherstellt, dass die IDE das Projekt korrekt erkennt und aufbaut. 🖥️

- **`.idea` Verzeichnis**:  
  Speichert Konfigurationsdateien, die speziell für die IntelliJ IDEA Entwicklungsumgebung verwendet werden, wie `misc.xml`, `modules.xml`, `vcs.xml`, `workspace.xml` usw. Diese Dateien betreffen hauptsächlich die IDE-spezifischen Einstellungen, Modulverwaltung, Versionskontrollsystem-Integration und Arbeitsbereichskonfigurationen und sind nicht direkt mit der Projekterstellung oder Logik verbunden, aber wichtig für die Entwicklung und Ausführung des Projekts in IDEA. 🛠️

- **`out` Verzeichnis**:  
  Enthält die kompilierten Ausgabedateien des Projekts, wie z.B. `.class` Dateien. Der `production` Unterordner enthält die Verzeichnisstruktur des Projekts, die der Paketstruktur des Projekts entspricht (falls vorhanden), und enthält die kompilierten Bytecode-Dateien der Java-Klassen sowie Ressourcen wie `favicon.ico` und `icon.png`, die zur Laufzeit der Anwendung benötigt werden. 🔧

- **`src` Verzeichnis**:  
  Das Quellcodedirectory des Projekts, das alle Java-Klassen enthält, die die Funktionalität des Projekts implementieren. Die wichtigsten Java-Klassen sind:
    - **`TaskInputPanel.java`**:
        - **Benutzeroberfläche**: Enthält ein Texteingabefeld `taskInputField` für die Eingabe des Aufgabennamens des Benutzers, mit angepasster Schriftart, -größe und Stil des Eingabefelds; sowie einen "Aufgabe hinzufügen" Button `addButton`, um die eingegebene Aufgabe zu übermitteln. 📝
        - **Interaktionslogik**: Wenn der Benutzer den Aufgabennamen in das Eingabefeld eingibt und auf den "Aufgabe hinzufügen"-Button klickt oder die Enter-Taste drückt, wird die Methode `addTask` ausgelöst. ⏩
    - **`TaskListPanel.java`**:
        - **Mitglieder und Initialisierung**: Enthält eine `JList<String>` namens `taskList` zur Anzeige der Aufgabenliste, ein `DefaultListModel<String>` als Datenmodell für die `taskList` und eine Liste von `Task` Objekten (`tasks`), die die tatsächlichen Aufgaben speichern. Außerdem ein `File` Objekt (`taskFile`), das auf die lokale Datei `tasks.txt` zeigt, in der die Aufgabendaten gespeichert sind. 📋
        - **Innere Klasse `Task`**: Definiert eine innere Klasse, die eine einzelne Aufgabe darstellt, mit Eigenschaften wie Aufgabennamen (`name`), Erledigungsstatus (`completed`) und Priorität (`priority`). 🎯
        - **Methoden für Aufgabenoperationen**:
            - Die Methode `addTask` fügt eine neue Aufgabe hinzu, indem sie den Namen der Aufgabe von `TaskInputPanel` entgegennimmt, ein neues `Task` Objekt erstellt und es der Liste `tasks` und dem `listModel` hinzufügt. ➕
            - Die Methode `removeSelectedTask` entfernt die ausgewählte Aufgabe aus `tasks` und `listModel` basierend auf dem Index der ausgewählten Aufgabe. 🗑️
            - Die Methode `toggleTaskCompletion` ändert den Erledigungsstatus einer Aufgabe je nach übergebenem Index. ✅
    - **`ToDoListApp.java`**:
        - **Erstellen und Layout der Benutzeroberfläche**: In der Konstruktorfunktion wird das Fenster mit einem Titel "To-Do List", einer festen Fenstergröße und einer zentralen Position auf dem Bildschirm konfiguriert. 🏗️
        - **Startpunkt**: Die Methode `main` startet die Anwendung, indem sie eine Instanz der `ToDoListApp`-Klasse erstellt. 🚀

---

## 🛠️ <span style="color: #95a5a6;">Wie man es benutzt</span>

1. **Starten der Anwendung**: Führen Sie die `main` Methode der `ToDoListApp`-Klasse aus. 🖱️
2. **Aufgabe hinzufügen**: Geben Sie im Eingabefeld für Aufgaben den Namen der Aufgabe ein und klicken Sie auf die Schaltfläche "Aufgabe hinzufügen" oder drücken Sie die Enter-Taste. ✍️
3. **Aufgaben anzeigen**: Sehen Sie sich alle hinzugefügten Aufgaben in der Aufgabenliste an. 👀
4. **Aufgabe als erledigt markieren**: Klicken Sie auf eine Aufgabe in der Liste oder wählen Sie eine Aufgabe aus und drücken Sie die Enter-Taste, um den Erledigungsstatus zu wechseln. ✅
5. **Aufgabe löschen**: Wählen Sie die zu löschende Aufgabe in der Liste aus und klicken Sie auf die Schaltfläche "Ausgewählte Aufgabe löschen". ❌

---

## ⚠️ <span style="color: #f1c40f;">Wichtige Hinweise</span>

1. **Daten Speicherung**:
    - Dieses Projekt speichert Aufgabendaten in der Datei `tasks.txt`. Bitte löschen oder ändern Sie diese Datei nicht unachtsam, da dies zu Fehlern beim Laden oder Speichern von Aufgaben führen kann und die Anwendung beeinträchtigen könnte. 💾

2. **Fehlerbehandlung**:
    - Momentan wird bei Fehlern wie Dateioperationen eine Fehlermeldung angezeigt. In komplexeren Szenarien könnte eine detailliertere Fehlerbehandlung, z. B. das Protokollieren von Fehlern, erforderlich sein. 📉

---

Ich hoffe, diese `README` Datei hilft Ihnen weiter. Sie können den Inhalt entsprechend Ihrer tatsächlichen Nutzung des Projekts anpassen oder erweitern, damit andere Benutzer das `TodoList` Projekt besser verstehen und verwenden können. 😊
