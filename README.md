# Leaderboard API with Spring Boot and Redis

## Project Description

This project is a simple leaderboard system implemented using Spring Boot and Redis. It allows users to add or update player scores, retrieve top players, get individual player scores, and check a player's rank. Redis's sorted set is used to maintain the leaderboard efficiently.

## API Endpoints

### 1. Add/Update Player Score
- **URL**: `/leaderboard/add`
- **Method**: `POST`
- **Parameters**:
  - `name` (String): The player's name.
  - `score` (Double): The player's score.
### 2. Get Top N Players
- **URL**: `/leaderboard/top/{count}`
- **Method**: `GET`
- **Parameters**:
- `count` (Integer): The number of top players to retrieve.
### 3. Get Player Score
- **URL**: `/leaderboard/score/{name}`
- **Method**: `GET`
- **Parameters**:
- `name` (String): The name of the player.
### 4. Get Player Rank
- **URL**: `/leaderboard/rank/{name}`
- **Method**: `GET`
- **Parameters**:
- `name` (String): The name of the player.
- **Example**:
