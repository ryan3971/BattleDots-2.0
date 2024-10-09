# BattleDots-SinglePlayer

This version of BattleDots was used to test and develop new power-ups before adding it to BattleDots-3.0, where it would be given multiplayer capabilities. 
This game is still in development. 

BattleDots 2.0 is an Android game that offers an exciting single-player experience where players control a dot and navigate through a field of obstacles and power-ups.

# Game Overview
BattleDots 2.0 is a fast-paced, action-packed game where players control a dot using touch controls. The objective is to survive as long as possible while avoiding obstacles and collecting power-ups to enhance your abilities.
## Features
- Single-player gameplay
- Touch-based controls
- Various power-ups and obstacles
- Dynamic difficulty progression
- Lives system
- Speed boost and fire button mechanics

# Installation
1. Clone the repository or download the source code.
2. Open the project in Android Studio.
3. Build and run the app on an Android device or emulator (minimum SDK version: 19).

# How to Play
Launch the game and tap "New Game" to start.
Use the touch pad to control your dot's movement.
Avoid obstacles (green circles) and collect power-ups (blue circles).
Use the speed boost button for a temporary speed increase.
Utilize the fire button to activate certain power-ups.
Survive as long as possible and aim for a high score!

## Game Elements
- **Player Dot:** The main character controlled by the player.
- **Obstacles:** Green circles that must be avoided.
- **Power-ups:** Blue circles that grant various abilities when collected.
- **Touch Pad:** Used for controlling the dot's movement.
- **Speed Boost Button:** Provides a temporary speed increase.
- **Fire Button:** Activates certain power-ups.
- **Lives:** Displayed at the top of the screen, indicating remaining chances.

## Power-ups
BattleDots 2.0 features a wide array of power-ups, including:
1. Dot Size Modifiers (Enlarge/Shrink)
2. Speed Modifiers (Speed Up/Slow Down)
3. Direction Reversal
4. Invisibility
5. Laser
6. Bouncing Ball
7. Shield
8. Multi-Laser
9. Target Ball
10. Power Wave
11. Rapid Fire
12. Sentry Gun
13. Triple Balls
14. Obstacle Drop
Each power-up provides unique abilities or challenges to keep the gameplay exciting and varied.

# Technical Details
Language: Java
Platform: Android
Minimum SDK Version: 19
Target SDK Version: Not specified (update recommended)

# Key Classes:
- **MainActivity**: Handles game initialization and UI management.
- **GameView**: Manages the game loop and rendering.
- **ObstaclesAndPowerUps**: Controls obstacle and power-up generation and collision detection.
- **ManageObjects**: Manages various game objects like lasers, balls, and power-ups.
- **PowerUpVariables**: Stores and manages power-up states.
- **Boundaries**: Handles game boundaries and player movement.

## MainActivity
- Main entry point of the application
- Handles game initialization and UI management
- Manages game start and end states
- Implements countdown timer for game start
- Contains comments about future improvements and known issues

## GameView
- Extends Android View class
- Manages the game loop and rendering
- Handles touch events for player input
- Initializes and updates game objects
- Manages power-ups and obstacles
- Draws game elements on the canvas

## ObstaclesAndPowerUps
- Responsible for creating, updating, and drawing obstacles and power-ups
- Manages collision detection between the player and obstacles/power-ups
- Handles the creation of new obstacles and power-ups as needed

## ManageObjects
- Manages various game objects like lasers, balls, and power-ups
- Handles creation, updating, and removal of game objects
- Implements logic for different power-ups (e.g., laser, bouncing ball, multi-laser)
- Manages special power-ups like sentry guns and triple balls

## PowerUpVariables
- Stores and manages power-up states
- Handles dot speed, size, and other attributes affected by power-ups
- Provides methods to get and set power-up states
- Manages visibility of power-up images

## GameConstants
- Stores constant values used throughout the game
- Manages screen dimensions and game boundaries
- Handles lists of obstacle and power-up coordinates
- Provides methods to access and modify game constants

## TouchPad
- Implements the touch control pad for player movement
- Draws the touch pad on the screen
- Manages touch pad coordinates and sizes

## Dot
- Represents the player's dot
- Handles drawing the dot on the canvas
- Manages dot attributes like size and color

## Boundaries
- Manages game boundaries and player movement
- Updates player position based on touch input
- Handles collision detection with game boundaries

## PowerUp_Images
- Manages the display of power-up images on the screen
- Handles showing and hiding power-up icons

## Lives
- Manages the player's lives
- Draws life indicators on the screen
- Handles life loss and game over conditions

## Various power-up classes (e.g., shootLaser, BouncingBall, MultiLaser, PowerWave)
- Implement specific power-up behaviors
- Handle drawing and updating of power-up effects
- Manage collision detection for power-up effects

# Future Improvements
As noted in the source code comments, there are several areas for potential improvement:
- Optimize Bluetooth connectivity and data transfer.
- Implement more efficient obstacle and power-up generation.
- Fine-tune game balance and speed.
- Add more game modes and customization options.
- Improve multi-threading for better performance.
- Enhance UI transitions and animations.
- Implement a circular buffer for data transfer.
- Add new power-ups and game mechanics.
For a complete list of potential improvements and known issues, refer to the comments in the MainActivity.java file:

