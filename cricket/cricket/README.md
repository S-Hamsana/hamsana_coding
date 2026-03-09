# Cricket Team Management System - Backend

RESTful API backend for managing cricket team players.

## Technology Stack

- Java 17
- Spring Boot 3.2.0
- Spring Data JPA
- PostgreSQL (Supabase)
- Maven
- Lombok

## Project Structure

```
src/main/java/com/hexaware/cricket/
├── controller/       # REST API endpoints
├── dto/             # Data Transfer Objects
├── entity/          # JPA entities
├── exception/       # Custom exceptions and handlers
├── repo/            # Repository interfaces
├── service/         # Business logic
└── CricketTeamMgmtApp.java
```

## API Endpoints

### GET /api/players
Retrieve all players

**Response:** `200 OK`
```json
[
  {
    "playerId": "uuid",
    "playerName": "string",
    "jerseyNumber": 0,
    "role": "string",
    "totalMatches": 0,
    "teamName": "string",
    "countryState": "string",
    "description": "string",
    "createdAt": "timestamp",
    "updatedAt": "timestamp"
  }
]
```

### GET /api/players/{playerId}
Retrieve a specific player by ID

**Response:** `200 OK` or `404 Not Found`

### POST /api/players
Create a new player

**Request Body:**
```json
{
  "playerName": "Virat Kohli",
  "jerseyNumber": 18,
  "role": "Batsman",
  "totalMatches": 254,
  "teamName": "Royal Challengers Bangalore",
  "countryState": "India",
  "description": "Indian cricket team captain"
}
```

**Validations:**
- playerName: required, 2-100 characters
- jerseyNumber: required, 1-999
- role: required, must be "Batsman", "Bowler", "Keeper", or "All Rounder"
- totalMatches: minimum 0
- teamName: required, 2-100 characters
- countryState: required, 2-100 characters
- description: optional, max 500 characters

**Response:** `201 Created` or `400 Bad Request`

### PUT /api/players/{playerId}
Update player details

**Request Body:** Same as POST

**Response:** `200 OK`, `400 Bad Request`, or `404 Not Found`

### DELETE /api/players/{playerId}
Delete a player

**Response:** `204 No Content` or `404 Not Found`

## Setup Instructions

### Prerequisites
- JDK 17 or higher
- Maven 3.6+
- PostgreSQL database (Supabase)

### Database Configuration

Create a `.env` file in the project root:

```properties
DB_URL=jdbc:postgresql://your-supabase-host:5432/postgres
DB_USER=postgres
DB_PASSWORD=your-password
```

### Build and Run

```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

## Error Handling

The API returns standardized error responses:

```json
{
  "timestamp": "2024-01-01T12:00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed",
  "path": "/api/players",
  "validationErrors": {
    "playerName": "Player name is required"
  }
}
```

## Validation Rules

- All required fields must be provided
- Jersey numbers must be unique and between 1-999
- Player roles are restricted to: Batsman, Bowler, Keeper, All Rounder
- Total matches cannot be negative
- All text fields have appropriate length constraints
