package edu.ntnu.idat2003.models;

import java.util.HashSet;

public class DeckOfCards {

  private static final char[] suits = {'H', 'D', 'C', 'S'};

  public static HashSet<PlayingCard> dealHand(int numberOfCards) {
    HashSet<PlayingCard> hand = new HashSet<>();
    while(hand.size() < numberOfCards) {
      int suitIndex = (int) (Math.random() * 4);
      int face = (int) (Math.random() * 13) + 1;
      PlayingCard card = new PlayingCard(suits[suitIndex], face);
      hand.add(card); // Only unique cards are added
    }
    return hand;
  }

  public static HashSet<String> getHearts(HashSet<PlayingCard> hand) {
    HashSet<String> hearts = new HashSet<>();
    hand.stream()
        .filter(card -> card.getSuit() == 'H')
        .forEach(card -> hearts.add(card.getAsString()));
    return hearts;
  }

  public static int getSumOfFaces(HashSet<PlayingCard> hand) {
    return hand.stream().mapToInt(PlayingCard::getFace).sum();
  }

  public static boolean hasQueenOfClubs(HashSet<PlayingCard> hand) {
    return hand.contains(new PlayingCard('C', 12));
  }

  public static boolean hasFlush(HashSet<PlayingCard> hand) {
    return hand.stream().map(PlayingCard::getSuit).distinct().count() == 1;
  }
}
