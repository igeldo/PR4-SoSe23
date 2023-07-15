# Wetterapp Projekt

Dieses Projekt besteht aus einer Wetter-App mit einem Frontend, einem Datenabfrage-Microservice, einem Datenbank-Microservice und einer PostgreSQL-Datenbank. Das Projekt ist containerisiert und kann mithilfe von Docker Compose bereitgestellt werden.

## Voraussetzungen

Um das Projekt auszuführen, müssen folgende Voraussetzungen erfüllt sein:

- Docker: Stellen Sie sicher, dass Docker auf Ihrem System installiert ist.

## Installation

Führen Sie die folgenden Schritte aus, um das Projekt zu installieren und auszuführen:

1. Klone das Projekt-Repository auf deinen lokalen Computer.

2. Navigiere in das Hauptverzeichnis des Projekts.

3. Öffne die `docker-compose.yml`-Datei. Überprüfe die Konfiguration und passe sie bei Bedarf an.

4. Öffne ein Terminal oder eine Eingabeaufforderung und navigiere zum Hauptverzeichnis des Projekts.

5. Führe den folgenden Befehl aus, um die Docker-Images für das Projekt zu erstellen:

   ```shell
   docker-compose build
   ```

   Dadurch werden die Docker-Images für den Datenbank-Microservice, den Datenabfrage-Microservice und die Wetter-App erstellt.

6. Führe anschließend den folgenden Befehl aus, um das Projekt mit Docker Compose bereitzustellen:

   ```shell
   docker-compose up
   ```

   Dadurch werden die Container für die PostgreSQL-Datenbank, den Datenbank-Microservice, die Datenabfrage und die Wetter-App erstellt und gestartet.

7. Sobald die Container gestartet sind, kannst du auf die Wetter-App über deinen Webbrowser zugreifen, indem du die URL `http://localhost:3000` aufrufst.

   Beachte, dass der Aufbau der Datenbank und das Abrufen von Wetterdaten einige Zeit in Anspruch nehmen können, bis sie vollständig initialisiert sind. Bitte habe Geduld und warte, bis der Vorgang abgeschlossen ist.

8. Du solltest nun die Wetter-App verwenden können, um Wetterinformationen abzurufen.

## Verwendung

- Öffne deinen Webbrowser und navigiere zu `http://localhost:3000`, um die Wetter-App zu öffnen.

- Gib den gewünschten Standort ein oder verwende die aktuelle Position, um Wetterinformationen abzurufen.

- Die Wetter-App verwendet den Datenabfrage-Microservice, um die Anfrage an die Datenbank zu senden und die entsprechenden Wetterdaten abzurufen.

## Anpassung

Wenn du das Projekt anpassen möchtest, findest du die verschiedenen Komponenten in ihren entsprechenden Verzeichnissen:

- Das Frontend der Wetter-App befindet sich im Verzeichnis `Wetterapp`.

- Der Datenabfrage-Microservice befindet sich im Verzeichnis `Datenabfrage`.

- Der Datenbank-Microservice befindet sich im Verzeichnis `Datenbank`.

Du kannst die jeweiligen Dateien in den entsprechenden Verzeichnissen bearbeiten, um das Verhalten der Komponenten anzupassen.

## Hinweise

- Bitte beachte, dass in dieser README-Anleitung davon ausgegangen wird, dass Docker bereits auf deinem System installiert ist und ordnungsgemäß funktioniert. Wenn Docker nicht korrekt installiert oder konfiguriert ist, können bei der Ausführung des Projekts Fehler auftreten.

- Stelle sicher, dass keine anderen Dienste oder Anwendungen auf den verwendeten Ports (5432, 8080, 2000, 3000) laufen, da diese von den Containern beansprucht werden.

- Für die Verwendung der PostgreSQL-Datenbank werden folgende Zugangsdaten verwendet:
  - Benutzername: postgres
  - Passwort: de46503
  - Datenbank: weatherdata

- Du kannst die Zugangsdaten und andere Konfigurationsoptionen in der `docker-compose.yml`-Datei anpassen, wenn du dies benötigst.

- Weitere Informationen zur Konfiguration der einzelnen Komponenten findest du in den entsprechenden Verzeichnissen des Projekts.

- Wenn du das Projekt nicht mehr benötigst, kannst du die Container stoppen und entfernen, indem du den Befehl `docker-compose down` im Hauptverzeichnis des Projekts ausführst.

- Falls Probleme oder Fehler auftreten, überprüfe die Ausgabe im Terminal oder der Eingabeaufforderung, in der du `docker-compose up` ausgeführt hast, um mögliche Fehlermeldungen anzuzeigen.
```
