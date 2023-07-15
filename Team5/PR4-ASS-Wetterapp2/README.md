# Wetterapp mit Microservices

Dieses Projekt ist eine Wetterapp, die mithilfe von Microservices entwickelt wurde. Die Kernfrage des Projekts war, inwiefern ChatGPT bei der Softwareentwicklung genutzt werden kann, mit einem Schwerpunkt auf Microservices. Der Autor dieses Projekts ist Philipp Bornefeld und ChatGPT wurde zur Generierung des README und des Codes verwendet.

## Installation

Um das Projekt auszuführen, musst du Docker und Docker Compose auf deinem System installiert haben.

1. Klone das Repository:

```bash
git clone [GitHub-Repository-URL]
```

2. Navigiere in das Projektverzeichnis:

```bash
cd [Projektverzeichnis]
```

(Optional) Generiere die JAR-Dateien für die Spring Microservices:

Für die Spring Microservices müssen die entsprechenden JAR-Dateien generiert werden, falls sie noch nicht vorhanden sind. Führe dazu die folgenden Befehle in den Verzeichnissen "weatherappspring" und "weatherDB" aus:

```bash
cd weatherappspring
mvn clean package -DskipTests
cd ../weatherDB
mvn clean package -DskipTests
```

Dadurch werden die erforderlichen JAR-Dateien für die Spring Microservices erstellt.

3. Führe die folgenden Befehle aus, um die Container zu erstellen und auszuführen:

```bash
docker-compose build
docker-compose up
```

Dieser Befehl erstellt und startet alle erforderlichen Container für die Wetterapp. Bitte beachte, dass der Befehl `docker-compose build` beim ersten Ausführen etwas länger dauern kann, da die Container erstellt werden müssen.

4. Sobald die Container gestartet wurden, kannst du auf die Wetterapp über deinen Webbrowser zugreifen:

```
http://localhost:5173
```

## Steuerung

Die Wetterapp besteht aus mehreren Microservices, die in separaten Containern ausgeführt werden. Die Steuerung der App erfolgt über die `docker-compose.yml`-Datei und die Docker-CLI.

- Um die Container zu starten, führe folgenden Befehl aus:

```bash
docker-compose up
```

- Um die Container im Hintergrund auszuführen, verwende die Option `-d`:

```bash
docker-compose up -d
```

- Um die Container zu stoppen, verwende den Befehl:

```bash
docker-compose down
```

Weitere Informationen zur Verwendung von Docker Compose findest du in der offiziellen [Dokumentation](https://docs.docker.com/compose/).

## Troubleshooting

- **Portkonflikte:** Stelle sicher, dass die in der `docker-compose.yml`-Datei angegebenen Ports auf deinem System nicht bereits verwendet werden. Ändere die Portzuordnung in der `docker-compose.yml`-Datei bei Bedarf.

- **Fehler beim Erstellen der Container:** Überprüfe die Docker- und Docker Compose-Installation und stellen sicher, dass alle Abhängigkeiten korrekt konfiguriert sind. Überprüfe auch, ob die `Dockerfile`-Dateien in den einzelnen Modulen ordnungsgemäß erstellt wurden.

Wenn du weitere Probleme oder Fragen hast, zögere nicht, den Autor Philipp Bornefeld zu kontaktieren.

## Lizenz

Dieses Projekt ist unter der MIT-Lizenz lizenziert. Weitere Informationen findest du in der [Lizenzdatei](LICENSE).
```

Bitte ersetze `[GitHub-Repository-URL]` durch die tatsächliche URL deines GitHub-Repositorys und `[Projektverzeichnis]` durch den Namen des Projektverzeichnisses, falls er vorhanden ist.