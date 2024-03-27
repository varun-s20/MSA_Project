# Software Requirements Specification (SRS) for Hotel and User Rating System

## 1. Introduction
This document outlines the specifications and requirements for the Hotel and User Rating System. This system is designed to manage users, hotels, and ratings efficiently. It is composed of multiple microservices, including User Service, Hotel Service, Rating Service, and an API Gateway.

## 2. System Overview
The system is divided into the following microservices:

- User Service: Manages user-related operations such as creating, retrieving, updating, and deleting users.
- Hotel Service: Handles hotel-related data.
- Rating Service: Manages ratings provided by users for hotels.
- API Gateway: Serves as an entry point for clients, routing requests to the appropriate service.

## 3. Functional Requirements
### 3.1 User Service
- Create User: Users can be created and stored in the system.
- Retrieve User: Users can be retrieved by their ID. This includes fetching ratings from the Rating Service and hotel information from the Hotel Service for each rating.
- Update User: User details can be updated.
- Delete User: Users can be deleted from the system.

### 3.2 Hotel Service
It is referenced in the User Service for fetching hotel details associated with ratings.

### 3.3 Rating Service
- Create Rating: Allows the creation of a new rating for a hotel by a user.
- Retrieve Ratings: Ratings can be retrieved by user ID or hotel ID.

### 3.4 API Gateway
Acts as a single entry point for all client requests and routes them to the appropriate microservice.

## 4. Non-functional Requirements
### 4.1 Performance
The system should be capable of handling a high number of requests concurrently without significant delays.

### 4.2 Scalability
The system should be scalable, allowing for an increase in the number of services or instances to handle load efficiently.

## 5. System Architecture
The system employs a microservice architecture, facilitating the development, deployment, and scalability of each component independently.

## 6. Technologies Used
Spring Boot for microservice implementation.
REST for microservices communication.

## 7. Testing
Unit and integration tests are provided for each microservice to ensure system reliability and correctness.

