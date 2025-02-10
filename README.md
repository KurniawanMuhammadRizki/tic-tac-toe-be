# Tic-Tac-Toe Game

This is a simple Tic-Tac-Toe game implemented with a **Java Spring Boot backend** and a **frontend** (built with React + NEXT.JS). The game is configurable to support different board sizes and uses **WebSocket** for real-time communication between the frontend and backend.

## Features

- **Configurable Board Size**: The game supports different board sizes without any hardcoding.
- **Web-Based with WebSocket**: The backend uses WebSocket for real-time communication with the frontend.
- **RESTful API for Game Initialization**: REST endpoints are provided to start a new game.
- **Win and Draw Detection**: The game automatically detects when a player wins or if the game ends in a draw.
- **Frontend Integration**: A separate frontend repository is provided for a seamless user experience.

## Game Rules

The rules of the game depend on the size of the board:

### For 3x3 Board
- Players take turns placing their symbols (`X` or `O`) on the board.
- The first player to get **3 of their symbols in a row** (horizontally, vertically, or diagonally) wins the game.
- If the board is filled completely without any player achieving 3 in a row, the game ends in a draw.

### For Boards Larger Than 3x3 (e.g., 5x5, 9x9)
- Players take turns placing their symbols (`X` or `O`) on the board.
- The first player to get **4 of their symbols in a row** (horizontally, vertically, or diagonally) wins the game.
- If the board is filled completely without any player achieving 4 in a row, the game ends in a draw.

## Technologies Used
- **Java**: The core programming language used for the game logic.
- **Spring Boot**: Used to create the web-based application and handle WebSocket communication.
- **WebSocket**: Used for real-time communication between the client and server.
- **Lombok**: Used to reduce boilerplate code with annotations like `@Data`.
- **Maven**: Used for dependency management and building the project.

## Getting Started

1. **Clone and run the Backend Repository**
2. **Clone and run the Front Repository**

## API Endpoints
Start a New Game:

- Endpoint: POST /api/v1/game/start
- Parameters: size (int) - The size of the board (e.g., 3 for a 3x3 board).
- Response: Returns a GameResponseDTO containing the game ID and initial board state.

Get Game Status:

- Endpoint: GET /api/v1/game/{gameId}
- Parameters: gameId (String) - The ID of the game.
- Response: Returns a GameResponseDTO containing the current board state and game status.

## WebSocket Endpoints 
Make a Move:
- WebSocket Destination: /app/move
- Message Type: Move (JSON object containing gameId, row, col, and symbol).
- Response: The server broadcasts the updated game state to /topic/game.

## Best Practices
- OOP Principles: The backend code is structured using Object-Oriented Programming principles, making it modular and easy to extend.
- Lombok: Used to reduce boilerplate code, making the codebase cleaner and more readable.
- Error Handling: Proper error handling is implemented to manage invalid moves and other exceptions gracefully.
- Configurability: The game board size is configurable, allowing for flexibility without hardcoding.
- Real-Time Communication: WebSocket is used for real-time updates, providing a seamless user experience.

### Backend Repository: [link](https://github.com/KurniawanMuhammadRizki/tic-tac-toe-be)
### Frontend Repository: [link](https://github.com/KurniawanMuhammadRizki/tic-tac-toe-fe)

   
