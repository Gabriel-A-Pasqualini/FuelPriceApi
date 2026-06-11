# FuelPrice API

FuelPrice API is a Spring Boot REST API that powers the FuelPrice ecosystem. It provides services for vehicle management, fuel price tracking, refueling history, fuel consumption calculations, and location-based features.

The API is designed with scalability, maintainability, and clean architecture principles in mind, serving as the backend for the FuelPrice mobile application.

## Key Features

* **Vehicle Management:** Create, update, list, and manage vehicles.
* **Fuel Price Tracking:** Store and retrieve fuel prices for calculations and historical analysis.
* **Refueling History:** Register and track refueling events over time.
* **Fuel Consumption Analysis:** Calculate fuel efficiency and consumption metrics.
* **Location Services Integration:** Support geolocation-based features and nearby fuel station searches.
* **RESTful Architecture:** Standardized endpoints for seamless integration with mobile and web clients.
* **Authentication & Authorization:** Secure access to user resources.

## Technologies

* Java 21
* Spring Boot
* Spring Data JPA
* Spring Security
* Hibernate
* PostgreSQL
* Docker
* Maven
* JWT Authentication

## Architecture

This project follows Clean Architecture principles, promoting:

* Separation of concerns
* High maintainability
* Testability
* Scalability
* Domain-driven organization

## Getting Started

### Prerequisites

* Java 21+
* Maven 3.9+
* Docker (optional)
* PostgreSQL

### Running Locally

```bash
mvn spring-boot:run
```

### Running Tests

```bash
mvn test
```

### Build

```bash
mvn clean package
```

## Docker

Docker support is available for local development and deployment.

```bash
docker compose up -d
```

## Related Projects

* FuelPrice App (Flutter Mobile Application)
* FuelPrice API (Spring Boot Backend)
