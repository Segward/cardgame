package edu.ntnu.idat2003.graphics;

import edu.ntnu.idat2003.models.DeckOfCards;
import edu.ntnu.idat2003.models.PlayingCard;
import java.util.HashSet;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class Engine {

  private HashSet<PlayingCard> dealerHand;

  private StackPane createCard(PlayingCard card) {
    // Create a CSS style for the card
    String stylingBackground =
        String.format(
            "-fx-background-image: url('/images/%s.png'); -fx-background-size: cover;",
            card.getAsString());

    // Create a StackPane to hold the card
    StackPane cardPane = new StackPane();
    cardPane.setPrefSize(66, 100);
    cardPane.setStyle(stylingBackground);

    return cardPane;
  }

  public void dealHands(FlowPane dealerFlow) {
    dealerFlow.getChildren().clear();
    dealerHand = DeckOfCards.dealHand(5);
    dealerHand.forEach(card -> dealerFlow.getChildren().add(createCard(card)));
  }

  public void checkSum(Text outputLabel) {
    int sum = DeckOfCards.getSumOfFaces(dealerHand);
    outputLabel.setText("Sum: " + sum);
  }

  public void checkFlush(Text outputLabel) {
    boolean flush = DeckOfCards.hasFlush(dealerHand);
    outputLabel.setText("Flush: " + flush);
  }

  public void checkQueen(Text outputLabel) {
    boolean queen = DeckOfCards.hasQueenOfClubs(dealerHand);
    outputLabel.setText("Queen of clubs: " + queen);
  }

  public void checkHearts(Text outputLabel) {
    HashSet<String> hearts = DeckOfCards.getHearts(dealerHand);
    outputLabel.setText("Hearts: " + hearts);
  }
}
