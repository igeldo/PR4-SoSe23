**README.md**

*Created by ChatGPT, Author: Philipp Bornefeld*

This repository contains a Spring Microservice and a PostgreSQL database for storing weather data with timestamps. The two systems run in separate Docker containers, managed by a docker-compose.yml file.

## Prerequisites

To run this system, ensure that you have the following prerequisites installed:

- Docker: [Install Docker](https://docs.docker.com/get-docker/)
- Docker Compose: [Install Docker Compose](https://docs.docker.com/compose/install/)

## Getting Started

1. Clone this repository to your local machine:

   ```bash
   git clone <repository-url>
   ```

2. Navigate to the project directory:

   ```bash
   cd <project-directory>
   ```

3. Build and start the Docker containers using Docker Compose:

   ```bash
   docker-compose up -d
   ```

   This command will start the PostgreSQL container and the Spring Microservice container.

4. Verify that the containers are running:

   ```bash
   docker ps
   ```

   You should see two containers running: `weatherDB_postgres` and `weatherDB_access`.

5. Accessing the Spring Microservice:

   The Spring Microservice provides APIs to save and retrieve weather data.

   - **Saving Weather Data:**

     To save weather data, you can use tools like cURL, Postman, or any other HTTP client application. Here's an example using cURL:

     ```bash
     curl -X POST -H "Content-Type: application/json" -d '{
       "city": "Berlin",
       "temperature": 25.6,
       "description": "Sunny"
     }' http://localhost:8080/weather
     ```

     This sends a POST request to `http://localhost:8080/weather` with the JSON payload containing the weather data. Adjust the values of "city", "temperature", and "description" according to your desired data.

   - **Retrieving Weather Data:**

     To retrieve weather data for a specific city, you can make a GET request to `http://localhost:8080/weather/{city}`, where `{city}` is the name of the city. For example, to retrieve weather data for Berlin, you can use the following command:

     ```bash
     curl http://localhost:8080/weather/Berlin
     ```

6. **Troubleshooting**

   If you encounter any issues, consider the following troubleshooting steps:

   - If the Docker containers fail to start, make sure you have Docker and Docker Compose installed correctly and there are no conflicts with existing services using the required ports (5432 for PostgreSQL and 8080 for the Spring Microservice).

   - Check the container logs for any error messages:

     ```bash
     docker logs <container-name>
     ```

     Replace `<container-name>` with the actual name of the container (`weatherDB_postgres` or `weatherDB_access`).

## License

This project is licensed under the [MIT License](LICENSE).

Feel free to reach out if you have any questions or need further assistance!