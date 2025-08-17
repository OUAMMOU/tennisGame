# Web Service Rest Tennis 
## Application Description

The Web Service Rest Tennis application simulates and manages a tennis game. It provides REST endpoints to:

- Determine the winner of a tennis game based on a sequence of played points.
- Handle game states such as advantage, deuce, and victory.
- Validate user inputs to ensure compliance with tennis rules.

### Key Features

- **Main Endpoint**: `/tennis/winner/{sequence}`
    - **Responses**:
        - `200 OK`: A winner is determined.
        - `400 Bad Request`: The sequence is invalid.
        - `422 Unprocessable Entity`: The game is unfinished.
- **Error Handling**:
    - Validates incorrect sequences (e.g., invalid characters).
    - Manages unfinished game states.
- **Unit and Integration Tests**:
    - Verifies state transitions (normal, deuce, advantage).
    - Validates edge cases and errors.

### Technologies Used

- Java 21
- Spring Boot (3.5.3)
- Maven for dependency management
- MockMvc for REST endpoint integration testing