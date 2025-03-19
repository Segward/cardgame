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

  public void checkHand(FlowPane labelFlow) {
    // Check if the dealer has a flush, queen of clubs, and hearts
    int sum = DeckOfCards.getSumOfFaces(dealerHand);
    boolean flush = DeckOfCards.hasFlush(dealerHand);
    boolean queen = DeckOfCards.hasQueenOfSpades(dealerHand);
    HashSet<String> hearts = DeckOfCards.getHearts(dealerHand);

    // Create text labels
    Text sumText = new Text("Sum: " + sum);
    Text flushText = new Text("Flush: " + flush);
    Text queenText = new Text("Queen of Spades: " + queen);
    Text heartsText = new Text("Hearts: " + hearts);

    if (hearts.isEmpty()) {
      heartsText.setText("Hearts: None");
    }

    // Add identifiers to the text labels
    sumText.setId("output-label");
    flushText.setId("output-label");
    queenText.setId("output-label");
    heartsText.setId("output-label");

    // Add the text labels to the FlowPane
    labelFlow.getChildren().clear();
    labelFlow.getChildren().addAll(sumText, flushText, queenText, heartsText);
  }
}
