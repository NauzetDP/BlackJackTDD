package blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    
    private List<Card> deck;
    
    public Deck () {
        this.deck = new ArrayList<>();
    }
    
    public Deck (List<Card> deck) {
        this.deck = deck;
    }
    
    public Card getNextCard() {
        Card c = this.deck.get(0);
        this.deck.remove(0);
        return c;
    }
    
    public List<Card> getDeck() {
        return this.deck;
    }
    
    public boolean isEmpty() {
        return this.deck.isEmpty();
    }
}