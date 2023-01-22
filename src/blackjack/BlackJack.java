
package blackjack;

import blackjack.model.Cards;
import blackjack.model.Deck;
import java.util.ArrayList;
import java.util.List;

public class BlackJack {
    
    public static void main(String[] args) {
    }
    
    public static String getWinners(Cards hand1, Cards hand2, Cards hand3, 
                                    Cards croupier, Deck deck) {
        List<String> winners = new ArrayList<String>();
        while (croupier.getScore() < 17 && !deck.isEmpty()) {
            croupier.addCard(deck.getNextCard());
        }
        if (checkWinnerHand(hand1, croupier)) winners.add("1");
        if (checkWinnerHand(hand2, croupier)) winners.add("2");
        if (checkWinnerHand(hand3, croupier)) winners.add("3");
        if (winners.isEmpty()) return "";
        String output = "Ganadores: ";
        for (String winner : winners) {
            output += winner + ", ";
        }
        return output.substring(0, output.length()-2);
    }
    
    public static boolean checkWinnerHand (Cards hand, Cards croupier) {
        if (hand.getScore() > 21) {
            return false;
        }
        if (hand.getScore() > croupier.getScore()) {
            return true;
        } else if (hand.getScore() == 21 && croupier.getScore() == 21 && 
                   hand.getCards().size() == 2 &&  croupier.getCards().size() > 2) {
            return true;
        } else {
            return false;
        }
    }
    
}
