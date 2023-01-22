package blackjack.model;

public class Card {
    
    private String name;
    private int value;
    
    public Card (String name) {
        this.name = name;
        this.setValue();
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
    
    private void setValue() {
        if (name.equals("J") || name.equals("Q") || name.equals("K")) {
            this.value = 10;
        } else if (name.equals("A")) {
            this.value = 11; 
        } else {
            this.value = Integer.valueOf(this.name);
        }
    }
}