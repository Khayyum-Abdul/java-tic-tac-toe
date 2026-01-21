# Tic Tac Toe CLI (NxN Java Game)

A command-line based Tic Tac Toe game written in Java.  
This version supports a dynamic board size (NxN), where **N can range from 3 to 10**.  
Two players can play by entering their names and taking turns in the terminal.

---

## ✨ Features

- Dynamic board size (3×3 up to 10×10)
- Two-player mode (Player X and Player O)
- Player name input
- Clear command-line interface
- Input validation for:
  - Board size
  - Row and column values
  - Occupied cells
- Automatic detection of:
  - Win (row, column, diagonals)
  - Draw
- Option to play again after each game
- Beginner-friendly and well-commented code

---

## 🕹️ How to Play

1. Run the program.
2. Enter the board size (between **3 and 10**).
3. Enter names for:
   - Player X
   - Player O
4. The board will be displayed with row and column indices.
5. On your turn, enter your move as:


Example:

6. The game continues until:
- A player wins, or
- The board is full (draw).
7. After the game ends, choose whether to play again.

---

## 🚀 How to Run

Compile the program:

```bash
javac Main.java

Run the game:

java TicTacToeCLI

📁 Project Structure
    .
    └── Main.java

🧠 Concepts Used

2D Arrays

Loops and Conditions

Methods and Static Functions

User Input using Scanner

Basic Game Logic

Command-Line Interface (CLI)

📌 Notes

Rows and columns start from 0.

Only empty cells can be filled.

The game enforces the board size limit (3–10).
