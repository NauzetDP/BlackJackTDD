package blackjack.model;

import java.util.List;

public class Cards {
    
    private List<Card> cards;
    private int score = 0;
    
    public Cards () {}
    
    public Cards (List<Card> cards) {
        this.cards = cards;
        this.setScore();
    }
    
    private void setScore() {
        int jokers = 0;
        this.score = 0;
        for (Card c: cards) {
            if (c.getValue() == 11) {
                jokers += 1;
                continue;
            }
            this.score += c.getValue();
        }
        while (jokers != 0) {
            this.score += ((this.score + 11) > 21) ? 1 : 11;
            jokers -= 1;
        }
    }
    
    public void addCard(Card c) {
        cards.add(c);
        this.setScore();
    }
    
    public int getScore() {
        return this.score;
    }
    
    public List<Card> getCards() {
        return cards;
    }
}