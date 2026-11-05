# Java Wordle Solver

An automated Wordle solver written entirely in Java.

> **Project status:** The solver is currently under development.

## Setup

The bot is intended to run completely autonomously and perform the following steps.

### Initialization

1. Open [Wordle](https://www.nytimes.com/games/wordle/index.html).
2. Click **Play**.
3. Click **Continue to Wordle**.
4. Close the **How to Play** dialog.
5. Scroll past the advertisement to view the game board.

### Gameplay

The bot must be able to:

1. Generate a guess
2. Enter the guess into the game automatically
3. Read the color of each letter in the guess
4. Repeat the process until either:
   - The word is solved, with all letters green.
   - The bot uses all six guesses without solving the word.
5. Terminate after the game ends.

## Current implementation

The current Java program is a starter application. The browser automation,
guess-generation, and board-reading functionality still need to be implemented.

## Requirements

- Java Development Kit (JDK)
- A browser supported by the eventual automation library

## Running the program

Compile and run the current starter program with:

```powershell
javac Main.java
java Main
```
