# Weather API Integration Application

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [Configuration](#configuration)
- [API Documentation](#api-documentation)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Overview
This repository contains a Java Spring Boot application that integrates with weather APIs to provide weather forecasts for various locations. The application fetches weather data from the Rapid API and provides a RESTful API for retrieving weather forecasts.

## Features
- Retrieve weather forecast summary for a specific city.
- Get hourly weather forecast details for a city.
- Header-based authentication using client ID and client secret.
- Detailed API documentation.

## Getting Started
Follow these instructions to set up and run the application locally.

### Prerequisites
Before you begin, ensure you have met the following requirements:
- Java 8 or higher installed.
- Maven for building the project.
- Rapid API account with an API key (for authentication).

### Installation
1. Clone this repository:
2. Navigate to the project directory:
3. Build the project using Maven:

## Usage
1. Start the application:
2. API documentation to learn how to use the available endpoints.
   
# Weather API Documentation

The Weather APIs provides information about the weather summary and hourly forecast for a given location.

## Get Weather Summary

Get a summary of the weather forecast for a specific location.

**Endpoint**: `/weather/summary`

**HTTP Method**: GET

**Request Headers**:

- `Authorization` (header): Header-based authentication with jwt token

**Parameters**:

- `locationName` (query parameter): The name of the location for which you want weather information.

**Example Request**:

```http
GET /weather/summary?locationName=Mumbai
Authorization: <Bearer_token>
```

## Get Weather Forecast

Get a hourly weather forecast for a specific location.

**Endpoint**: `/weather/hourly-forecast`

**HTTP Method**: GET

**Request Headers**:

- `Authorization` (header): Header-based authentication with jwt token

**Parameters**:

- `locationName` (query parameter): The name of the location for which you want weather information.

**Example Request**:

```http
GET /weather/hourly-forecast?locationName=Mumbai
Authorization: <Bearer_token>
```

## Authentication login

Get jwt token based on clientId and clientSecret.

**Endpoint**: `/login`

**HTTP Method**: POST

**Request Headers**:

- `clientId` (header): Header-based authentication with a random client ID
- `clientSecret` (header): Header-based authentication with a random client Secret

**Example Request**:

```http
POST /login
clientId: <random_client_id>
clientSecret: <random_client_secret>
```





