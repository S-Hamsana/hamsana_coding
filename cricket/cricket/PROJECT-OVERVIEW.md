# Cricket Team Management System - Project Overview

## Architecture

This application follows a layered architecture pattern with clear separation of concerns:

```
┌─────────────────────────────────────┐
│         REST Controller             │  - HTTP endpoints
│     (PlayerController.java)         │  - Request/Response handling
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│         Service Layer               │  - Business logic
│  (PlayerService/PlayerServiceImpl)  │  - Transaction management
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│      Repository Layer               │  - Data access
│       (PlayerRepo.java)             │  - Database operations
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│         Database                    │  - PostgreSQL (Supabase)
│      (players table)                │  - Data persistence
└─────────────────────────────────────┘
```

## Package Structure

### com.hexaware.cricket

**Main Application Class**
- `CricketTeamMgmtApp.java` - Spring Boot application entry point

### controller
- `PlayerController.java` - REST API endpoints for player operations
- Handles HTTP requests and responses
- Performs input validation using @Valid
- Returns appropriate HTTP status codes

### dto (Data Transfer Objects)
- `PlayerRequest.java` - Request payload for create/update operations
- `PlayerResponse.java` - Response payload for all operations
- `ErrorResponse.java` - Standardized error response format
- Separates API contracts from database entities

### entity
- `Player.java` - JPA entity mapping to players table
- Contains database mappings and relationships
- Uses Lombok annotations to reduce boilerplate

### exception
- `PlayerNotFoundException.java` - Custom exception for missing players
- `GlobalExceptionHandler.java` - Centralized exception handling
- Provides consistent error responses across the API

### repo (Repository)
- `PlayerRepo.java` - Spring Data JPA repository
- Extends JpaRepository for CRUD operations
- No custom queries needed for basic operations

### service
- `PlayerService.java` - Service interface
- `PlayerServiceImpl.java` - Service implementation
- Contains business logic and data transformations
- Manages transactions

## Key Features

### 1. Input Validation
- Bean validation using Jakarta Validation API
- Field-level constraints on PlayerRequest
- Custom validation messages
- Comprehensive error responses

### 2. Error Handling
- Global exception handler using @RestControllerAdvice
- Specific handlers for different exception types
- Standardized error response format
- Validation error details in response

### 3. Database Integration
- JPA/Hibernate ORM for database operations
- PostgreSQL database (Supabase)
- Automatic timestamp management
- UUID primary keys

### 4. RESTful Design
- Resource-based URLs
- Proper HTTP methods (GET, POST, PUT, DELETE)
- Appropriate status codes
- JSON request/response format

### 5. CORS Support
- Cross-Origin Resource Sharing enabled
- Allows frontend integration from any origin

## Design Decisions

### Why UUID for Player ID?
- Globally unique identifiers
- Better for distributed systems
- Prevents ID enumeration attacks
- Easier for data migration

### Why Separate DTO and Entity?
- API contract independence from database schema
- Flexibility to change database without affecting API
- Security - don't expose internal structure
- Clean separation of concerns

### Why Service Layer?
- Encapsulates business logic
- Transaction management
- Reusability across controllers
- Easy to test

### Why Global Exception Handler?
- Centralized error handling
- Consistent error responses
- Reduces code duplication
- Easier maintenance

## Configuration

### application.properties
- Database connection details (configurable via environment variables)
- JPA/Hibernate settings
- Server port configuration
- Error response settings

### Database Schema
- `players` table with all required fields
- Automatic timestamps (created_at, updated_at)
- Row Level Security enabled
- Public access policies (adjust for production)

## Coding Standards

- **Package Naming**: com.hexaware.cricket
- **Class Names**: PascalCase
- **Method Names**: camelCase
- **Constants**: UPPER_SNAKE_CASE
- **No Comments**: Self-documenting code with clear naming
- **Short Names**: Concise and meaningful identifiers

## Testing Recommendations

1. Unit tests for service layer
2. Integration tests for repository layer
3. API tests for controller endpoints
4. Validation tests for edge cases
5. Exception handling tests

## Production Considerations

1. Update RLS policies for proper authentication
2. Add API rate limiting
3. Implement API versioning
4. Add logging and monitoring
5. Use environment-specific configurations
6. Add API documentation (Swagger/OpenAPI)
7. Implement caching where appropriate
8. Add database indexes for performance
