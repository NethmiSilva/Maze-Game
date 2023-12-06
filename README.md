# Maze Game Project 

## Overview
This maze game project is a console-based application developed to demonstrate key concepts of object-oriented programming (OOP). The game allows users to navigate through a maze loaded from a file using various movement commands. The project incorporates appropriate use of containers, clear and distinct class responsibilities, error handling, and design patterns like the Strategy, Template, and Decorator patterns.

## Features

### 1. Maze Creation
The maze is created by reading a file, and an array is used as a container to represent the maze structure. The implementation aims to reduce complexity in maze creation and player movement.

### 2. Class Responsibilities
The project is organized into 16 separate classes, each with distinct responsibilities:
1. App.java: Main class responsible for user interaction, prompting the user to enter the file name.
2. Read.java: Reads the file entered by the user and creates the maze.
3. Clear.java: Clears the terminal.
4. CreateGrid.java: Abstract class called in Read to create the maze by assigning characters.
5. Border.java: Extends CreateGrid, creates the borders for the maze.
6. Link.java: Extends CreateGrid, adds characters to link the walls and doors of the maze.
7. Movement.java: Interface defining player movement methods.
8. ViewMovement.java: Prints the maze after each movement.
9. Move.java: Takes user input to move the player around the maze and implements the Movement interface.
10. MovementDecorator.java: Abstract class implementing the Movement interface, incorporating the Template pattern.
11. Play.java: Dummy class implementing the Movement interface to prevent method conflicts in base implementations.
12. Up.java, Down.java, Left.java, Right.java: Extend MovementDecorator, providing specific implementations for player movement.
    
### 3. Error Handling and Logging
Error handling is implemented with try-catch blocks and custom exceptions, each associated with appropriate logging statements:

1. FileNotFoundException: Throws a severe-level log as the maze cannot be created without a valid file name.
2. InputMismatchException and NumberFormatException: Issue a warning-level log, indicating invalid user input.
3. ArrayIndexOutOfBoundsException: Triggers a warning-level log, alerting the user to access elements out of array bounds.
4. Custom exceptions are thrown to display personalized messages to the user, and external errors are handled with CustomException without revealing internal details.

### 4. Strategy and Template Patterns
The Template pattern is employed in two instances:

1. CreateGrid.java: Abstract class with a template method (makeMaze) and a hook method (assignCharacters) called by the template method. Implemented by Border.java and Link.java.
2. MovementDecorator.java: Abstract class with a template method (movement) and a hook method (move). Implemented by Up.java, Down.java, Left.java, and Right.java. This also involves the use of the Decorator pattern.
   
### 5. Decorator Pattern
The Decorator pattern is used to extend the functionality of player movement without altering the existing classes:
1. Movement.java: Interface defining player movement methods.
2. MovementDecorator.java: Abstract class implementing the Movement interface and acting as the base for specific movements.
Up.java, Down.java, Left.java, Right.java: Extend MovementDecorator, providing different implementations for moving the player.

## How to Run
Clone the repository to your local machine.
Compile and run ./gradlew run 
Follow the prompts to enter the maze file name and navigate through the maze using specified commands.

<img src="https://github.com/NethmiSilva/Maze-Game/assets/91644460/2ff90b0e-ebf1-4a4b-9677-4dec01b14f9f" width="300" height="500">


