CREATE TABLE weather_data (
                              id SERIAL PRIMARY KEY,
                              city VARCHAR(255),
                              temperature DOUBLE PRECISION,
                              description VARCHAR(255),
                              timestamp TIMESTAMP
);
