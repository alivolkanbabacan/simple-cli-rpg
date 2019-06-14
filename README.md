# Simple Command-Line Rpg

A simple command line rpg running on console. You control a character trying to go through challenges. There are two themes right now that you can play. You can choose the theme to play when you start a new game. In the game, character is shown with a green 'C' letter, while the enemies are shown with their unique symbols and in red color. The objective is to go to the winning area to finish the game. The winning area is shown in yellow color.

### Technologies
- Java 8
- Maven
- JUnit 5
- Mockito

### How to build

- Run "mvn clean install" from project's root directory.


### How to run

- Run "java -jar simple-cli-rpg-1.0-jar-with-dependencies.jar" from the target folder under project's root directory.

### How to extend

- You can add new monsters by extending the Monster class. Then you can associate the monster you want with the theme you want by adding the monster to that theme's monster factory.

- You can add new themes by extending the Theme class. Then you can extend the MonsterFactory interface for creating your own theme's unique MonsterFactory. After this you must put a new MenuItem to ThemeMenu for your newly created Theme and you are ready to go.

- Right now there is no level up, but there is a LevelUpStrategy variable stored in Player instantiated with a NoLevelUpStrategy instance on creation of the Player. You can implement the LevelUpStrategy interface to write your own level up strategies and use them in Player or in any class extending the Player, thus having a level up mechanism for your character. 

- Input and Output operations are done on console by the Console class. But by implementing the InputOutput interface, you can write different implementations not using console for these operations.