# API Testing Guide

## Base URL
```
http://localhost:8080
```

## Test Scenarios

### 1. Create a Player (POST)

```bash
curl -X POST http://localhost:8080/api/players \
  -H "Content-Type: application/json" \
  -d '{
    "playerName": "Virat Kohli",
    "jerseyNumber": 18,
    "role": "Batsman",
    "totalMatches": 254,
    "teamName": "Royal Challengers Bangalore",
    "countryState": "India",
    "description": "Former Indian cricket team captain"
  }'
```

### 2. Get All Players (GET)

```bash
curl -X GET http://localhost:8080/api/players
```

### 3. Get Player by ID (GET)

```bash
curl -X GET http://localhost:8080/api/players/{playerId}
```

Replace `{playerId}` with actual UUID from previous response.

### 4. Update Player (PUT)

```bash
curl -X PUT http://localhost:8080/api/players/{playerId} \
  -H "Content-Type: application/json" \
  -d '{
    "playerName": "Virat Kohli",
    "jerseyNumber": 18,
    "role": "Batsman",
    "totalMatches": 260,
    "teamName": "Royal Challengers Bangalore",
    "countryState": "India",
    "description": "Former Indian cricket team captain and legendary batsman"
  }'
```

### 5. Delete Player (DELETE)

```bash
curl -X DELETE http://localhost:8080/api/players/{playerId}
```

## Validation Test Cases

### Invalid Role
```bash
curl -X POST http://localhost:8080/api/players \
  -H "Content-Type: application/json" \
  -d '{
    "playerName": "Test Player",
    "jerseyNumber": 10,
    "role": "InvalidRole",
    "totalMatches": 50,
    "teamName": "Test Team",
    "countryState": "Test Country",
    "description": "Test description"
  }'
```

Expected: 400 Bad Request with validation error

### Missing Required Field
```bash
curl -X POST http://localhost:8080/api/players \
  -H "Content-Type: application/json" \
  -d '{
    "jerseyNumber": 10,
    "role": "Batsman",
    "totalMatches": 50,
    "teamName": "Test Team",
    "countryState": "Test Country"
  }'
```

Expected: 400 Bad Request - playerName is required

### Invalid Jersey Number
```bash
curl -X POST http://localhost:8080/api/players \
  -H "Content-Type: application/json" \
  -d '{
    "playerName": "Test Player",
    "jerseyNumber": 1000,
    "role": "Batsman",
    "totalMatches": 50,
    "teamName": "Test Team",
    "countryState": "Test Country"
  }'
```

Expected: 400 Bad Request - jersey number must not exceed 999

### Negative Total Matches
```bash
curl -X POST http://localhost:8080/api/players \
  -H "Content-Type: application/json" \
  -d '{
    "playerName": "Test Player",
    "jerseyNumber": 10,
    "role": "Batsman",
    "totalMatches": -5,
    "teamName": "Test Team",
    "countryState": "Test Country"
  }'
```

Expected: 400 Bad Request - total matches cannot be negative

## Valid Player Roles

- Batsman
- Bowler
- Keeper
- All Rounder

## Expected Response Codes

- `200 OK` - Successful GET/PUT
- `201 Created` - Successful POST
- `204 No Content` - Successful DELETE
- `400 Bad Request` - Validation error
- `404 Not Found` - Player not found
- `500 Internal Server Error` - Server error
