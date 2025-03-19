// filepath: /Volumes/DiskName/Programming/ladder-game/src/main/java/edu/ntnu/idat2003/App.java
package edu.ntnu.idat2003;

import edu.ntnu.idat2003.views.UserInterface;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

  @Override
  public void start(Stage primaryStage) {
    UserInterface userInterface = new UserInterface(primaryStage);
    userInterface.init();
    userInterface.start();
  }

  public static void main(String[] args) {
    launch(args);
  }
}