package com.gla.Strings.Level3;
import java.util.Scanner;

public class DeckOfCard {

        static String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        static String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

        // Method to initialize the deck
        public static String[] initializeDeck() {
            int numOfCards = suits.length * ranks.length;
            String[] deck = new String[numOfCards];
            int index = 0;
            for (String suit : suits) {
                for (String rank : ranks) {
                    deck[index++] = rank + " of " + suit;
                }
            }
            return deck;
        }

        // Method to shuffle the deck
        public static void shuffleDeck(String[] deck) {
            int n = deck.length;
            for (int i = 0; i < n; i++) {
                int randomCardNumber = i + (int) (Math.random() * (n - i));
                // Swap deck[i] and deck[randomCardNumber]
                String temp = deck[i];
                deck[i] = deck[randomCardNumber];
                deck[randomCardNumber] = temp;
            }
        }

        // Method to distribute n cards among x players
        public static String[][] distributeCards(String[] deck, int n, int x) {
            if (n > deck.length) {
                System.out.println("Not enough cards in the deck.");
                return null;
            }
            if (n % x != 0) {
                System.out.println("Cannot evenly distribute " + n + " cards among " + x + " players.");
                return null;
            }

            int cardsPerPlayer = n / x;
            String[][] players = new String[x][cardsPerPlayer];
            int cardIndex = 0;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < cardsPerPlayer; j++) {
                    players[i][j] = deck[cardIndex++];
                }
            }
            return players;
        }

        // Method to print the players and their cards
        public static void printPlayersCards(String[][] players) {
            if (players == null) return;
            for (int i = 0; i < players.length; i++) {
                System.out.println("Player " + (i + 1) + "'s cards:");
                for (String card : players[i]) {
                    System.out.println("  " + card);
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Input number of players and number of cards to distribute
            System.out.print("Enter number of players: ");
            int x = scanner.nextInt();
            System.out.print("Enter number of cards to distribute: ");
            int n = scanner.nextInt();

            // Initialize and shuffle deck
            String[] deck = initializeDeck();
            shuffleDeck(deck);

            // Distribute cards to players
            String[][] players = distributeCards(deck, n, x);

            // Print players and their cards
            printPlayersCards(players);

        }


}
