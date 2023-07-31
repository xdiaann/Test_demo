package 游戏;

/**
 * TODO 添加类的描述
 *
 * @author zd
 * @version 1.0, 2023/7/19 11:51
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DouNiuGame {
    private List<String> deck;

    public DouNiuGame() {
        deck = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        String[] suits = {"♠", "♥", "♣", "♦"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + suit);
            }
        }
    }

    public void shuffleDeck() {
        Random rand = new Random();
        for (int i = deck.size() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            String temp = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }
    }

    public void dealCards(int numPlayers) {
        if (numPlayers <= 0 || numPlayers > 10) {
            System.out.println("Invalid number of players!");
            return;
        }

        if (deck.size() < numPlayers * 5) {
            System.out.println("Not enough cards in the deck!");
            return;
        }

        List<List<String>> playerHands = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            playerHands.add(new ArrayList<>());
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < numPlayers; j++) {
                String card = deck.remove(0);
                playerHands.get(j).add(card);
            }
        }

        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Player " + (i + 1) + ": " + playerHands.get(i));
        }
    }

    public static void main(String[] args) {
        DouNiuGame game = new DouNiuGame();
        game.shuffleDeck();
        game.dealCards(4);
    }
}
