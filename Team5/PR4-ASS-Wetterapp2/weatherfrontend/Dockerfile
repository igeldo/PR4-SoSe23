# Basisimage
FROM node:14-alpine

# Arbeitsverzeichnis im Container erstellen
WORKDIR /app

# Abhängigkeiten installieren
COPY package*.json ./
RUN npm install

# Anwendungscode kopieren
COPY . .

# Build durchführen
RUN npm run build

# Server starten
CMD ["npm", "run", "serve", "--", "--host", "0.0.0.0"]
