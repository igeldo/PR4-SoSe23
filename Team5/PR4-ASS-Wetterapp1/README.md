## Project Description

This project aims to demonstrate the use of ChatGPT in microservice development. The repository contains two microservices, "Wetterapp" and "Datenabfrage", which are containerized using Docker and can be deployed using Docker Compose. The Wetterapp microservice is a simple weather application that retrieves weather data from an external API, while the Datenabfrage microservice provides data querying functionality.

## Required Packages

To install the required packages for each microservice, run the following commands:

### Wetterapp

```
npm install axios
npm install express
```

### Datenabfrage

```
npm install express
npm install pg
```

## Containerization

Both microservices can be containerized using Docker. Follow the instructions below to containerize and run the microservices.

### Docker Compose

To build, run, and remove the containers for both microservices using Docker Compose, follow these steps:

1. Install Docker Compose if you haven't already. You can find installation instructions [here](https://docs.docker.com/compose/install/).
2. Navigate to the project directory in your terminal or command prompt.
3. Run the following command to build the Docker images:

```
docker-compose build
```

This will build the Docker images for both microservices.

4. Run the following command to start the containers:

```
docker-compose up
```

This will start the containers for both microservices and expose their respective ports to the host machine. You can access the Wetterapp at `http://localhost:3000` and the Datenabfrage microservice at `http://localhost:2000`.

5. If you want to stop and remove the containers, run the following command:

```
docker-compose down
```

This will stop and remove the containers for both microservices.

### Manual Docker commands

Alternatively, you can use the manual Docker commands to build and run the containers for each microservice separately. Follow the instructions below for each microservice.

### Wetterapp

1. Navigate to the Wetterapp microservice directory in your terminal or command prompt.
2. Run the following command to build the Docker image:

```
docker build -t wetterapp .
```

3. Run the following command to start the container:

```
docker run -p 3000:3000 wetterapp
```

This will start the container for the Wetterapp microservice and expose its port to the host machine. You can access the Wetterapp at `http://localhost:3000`.

4. If you want to stop and remove the container, run the following command:

```
docker stop <container_id>
docker rm <container_id>
```

Replace `<container_id>` with the ID of the running container.

### Datenabfrage

1. Navigate to the Datenabfrage microservice directory in your terminal or command prompt.
2. Run the following command to build the Docker image:

```
docker build -t datenabfrage-microservice .
```

3. Run the following command to start the container:

```
docker run -p 2000:2000 datenabfrage-microservice
```

This will start the container for the Datenabfrage microservice and expose its port to the host machine. You can access the Datenabfrage microservice at `http://localhost:2000`.

4. If you want to stop and remove the container, run the following command:

```
docker stop <container_id>
docker rm <container_id>
```

Replace `<container_id>` with the ID of the running container.

Authors: TiEsp001 and PBornefeld.