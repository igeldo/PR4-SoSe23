# Weather App README

This is the README document for the Weather App project. It was created by Philipp Bornefeld and developed using ChatGPT.

## Installation

To run the Weather App project, please follow the steps below:

1. Make sure Docker is installed on your system.

2. Clone the GitHub repository using the following command:

   ```bash
   git clone <repository URL>
   ```

3. Navigate to the project directory:

   ```bash
   cd <path to project directory>
   ```

4. Build the Docker container using the provided `docker-compose.yml` file by running the following command:

   ```bash
   docker-compose up --build
   ```

   This will create and start the container. The Weather App will be accessible on port 5173.

5. Open your web browser and visit the following URL to access the Weather App:

   ```
   http://localhost:5173
   ```

   You should see the Weather App interface and be able to access its features.

## Usage

The Weather App can be operated through the web browser. Enter the name of a city or location in the search field to retrieve the corresponding weather information.

## Troubleshooting

Here are some common issues and possible solutions:

- **The Docker container fails to start:** Ensure that Docker is correctly installed and that you are in the correct directory where the `docker-compose.yml` file is located. Also, check the output of the `docker-compose up` command for any error messages.

- **The Weather App is not available on port 5173:** Make sure no other service is running on port 5173 and that the port forwarding in the `docker-compose.yml` file is configured correctly.

- **Weather data is not displayed correctly:** Check your internet connection to ensure that weather data can be successfully retrieved. Make sure you enter the city or location name correctly.

- **Further assistance:** For any further issues or questions, feel free to contact the author, Philipp Bornefeld.

## License

This project is licensed under the MIT License. Please see the [LICENSE](LICENSE) file for more details.