package edu.ntnu.idat2003.views;

import edu.ntnu.idat2003.graphics.Engine;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UserInterface {

  private Stage primaryStage;
  private Pane root;
  private Engine engine;

  public UserInterface(Stage primaryStage) {
    this.primaryStage = primaryStage;
    this.root = new Pane();
    this.engine = new Engine();
  }

  public void init() {
    // Set the root Pane as the scene of the primaryStage
    primaryStage.setTitle("Cardgame");
    primaryStage.setMinWidth(800);
    primaryStage.setMinHeight(600);

    // Bind the root Pane to the primaryStage's size
    root.prefWidthProperty().bind(primaryStage.widthProperty());
    root.prefHeightProperty().bind(primaryStage.heightProperty());

    // Add the stylesheet
    root.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
  }

  public void start() {
    createScene();
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
  }

  private void createScene() {
    // Create a vertical box layout
    VBox vBox = new VBox();
    vBox.prefWidthProperty().bind(root.widthProperty());
    vBox.prefHeightProperty().bind(root.heightProperty());

    // Create the dealer section
    StackPane dealerSection = new StackPane();
    dealerSection.setId("dealer-section");
    dealerSection.prefWidthProperty().bind(vBox.widthProperty());
    dealerSection.prefHeightProperty().bind(vBox.heightProperty().multiply(0.6));

    // Create a label section
    StackPane labelSection = new StackPane();
    labelSection.setId("normal-section");
    labelSection.prefWidthProperty().bind(vBox.widthProperty());
    labelSection.prefHeightProperty().bind(vBox.heightProperty().multiply(0.2));

    // Create the button section
    StackPane buttonSection = new StackPane();
    buttonSection.setId("normal-section");
    buttonSection.prefWidthProperty().bind(vBox.widthProperty());
    buttonSection.prefHeightProperty().bind(vBox.heightProperty().multiply(0.2));

    // Add the sections to the vertical box layout
    vBox.getChildren().addAll(dealerSection, labelSection, buttonSection);

    // Create a flow layout for the dealer section
    FlowPane dealerFlow = new FlowPane();
    dealerFlow.setId("flow-pane");

    // Create a flow layout for label output
    FlowPane labelFlow = new FlowPane();
    labelFlow.setId("flow-pane");

    // Create a label for the output
    Text outputLabel = new Text("Welcome to the card game!");
    outputLabel.setId("output-label");
    labelFlow.getChildren().add(outputLabel);

    // Create a flow layout for the buttons
    FlowPane buttonFlow = new FlowPane();
    buttonFlow.setId("flow-pane");

    // Create the buttons
    Button dealButton = new Button("Deal");
    dealButton.setPrefSize(100, 50);
    dealButton.setOnAction(event -> engine.dealHands(dealerFlow));

    Button checkSumButton = new Button("Check sum");
    checkSumButton.setPrefSize(100, 50);
    checkSumButton.setOnAction(event -> engine.checkSum(outputLabel));

    Button checkQueenButton = new Button("Check queen");
    checkQueenButton.setPrefSize(100, 50);
    checkQueenButton.setOnAction(event -> engine.checkQueen(outputLabel));

    Button checkFlushButton = new Button("Check flush");
    checkFlushButton.setPrefSize(100, 50);
    checkFlushButton.setOnAction(event -> engine.checkFlush(outputLabel));

    Button checkHeartsButton = new Button("Check hearts");
    checkHeartsButton.setPrefSize(100, 50);
    checkHeartsButton.setOnAction(event -> engine.checkHearts(outputLabel));

    // Add the buttons to the flow layout
    buttonFlow
        .getChildren()
        .addAll(dealButton, checkSumButton, checkQueenButton, checkFlushButton, checkHeartsButton);

    // Add the flow layouts to the sections
    dealerSection.getChildren().add(dealerFlow);
    buttonSection.getChildren().addAll(buttonFlow);
    labelSection.getChildren().add(labelFlow);

    // Add the vertical box layout to the root Pane
    root.getChildren().add(vBox);
  }
}