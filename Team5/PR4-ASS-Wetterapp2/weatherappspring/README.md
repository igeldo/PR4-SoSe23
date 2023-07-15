# Weather API Microservice

*Created by ChatGPT, Author: Philipp Bornefeld*

This repository contains a Springboot microservice that communicates with the openweathermap API to retrieve weather data for a specific city. The microservice is designed to run in a Docker container.

## Prerequisites

To run this microservice, ensure that you have the following prerequisites installed:

- Docker: [Install Docker](https://docs.docker.com/get-docker/)

## Getting Started

1. Clone this repository to your local machine:

   ```bash
   git clone <repository-url>
   ```

2. Navigate to the project directory:

   ```bash
   cd <project-directory>
   ```

3. Build the Docker image and start the container:

   ```bash
   docker-compose up -d
   ```

   This command will build the Docker image and start the container based on the provided `docker-compose.yml` file.

4. Verify that the container is running:

   ```bash
   docker ps
   ```

   You should see a container named `weather-api-container` running.

5. Accessing the Weather API:

   The Weather API microservice provides an endpoint to retrieve weather data for a specific city.

   - **Retrieving Weather Data:**

     To retrieve weather data for a city, make a GET request to `http://localhost:2345/weather/{city}`, where `{city}` is the name of the city. For example, to retrieve weather data for Berlin, you can use the following command:

     ```bash
     curl http://localhost:2345/weather/Berlin
     ```

     Adjust the `{city}` parameter according to the desired city.

6. **Troubleshooting**

   If you encounter any issues, consider the following troubleshooting steps:

   - Make sure you have Docker installed correctly and there are no conflicts with existing services using the required port (2345).

   - Check the container logs for any error messages:

     ```bash
     docker logs weather-api-container
     ```

## License

This project is licensed under the [MIT License](LICENSE).

Feel free to reach out if you have any questions or need further assistance!
