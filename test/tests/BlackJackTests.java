package tests;

import blackjack.BlackJack;
import blackjack.model.Card;
import blackjack.model.Cards;
import blackjack.model.Deck;
import java.util.ArrayList;
import java.util.Arrays;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

public class BlackJackTests {
    
    private BlackJack bj = new BlackJack();
    
    @Test
    public void checkTest() {
        Cards hand1 = new Cards();
        Cards hand2 = new Cards();
        Cards hand3 = new Cards();
        Cards croupier = new Cards();
        Deck deck = new Deck();
        assertEquals("", bj.getWinners(hand1, hand2, hand3, croupier, deck));
    }
    
    @Test
    public void testWhereGet21With3Cards() {
        Cards hand1 = new Cards(Arrays.asList(new Card[]{new Card("1"), 
                                                         new Card("J"),
                                                         new Card("K")}));
        
        assertEquals(21, hand1.getScore());
    }
    
    @Test
    public void testAHandWith2JokersAndMoreCardsWhereUGet24() {
        Cards hand1 = new Cards(Arrays.asList(new Card[]{new Card("3"), 
                                                         new Card("6"),
                                                         new Card("A"),
                                                         new Card("3"),
                                                         new Card("A"),
                                                         new Card("K")}));
        
        assertEquals(24, hand1.getScore());
    }
    
    @Test
    public void testAHandWhereUGet16WithNumbers() {
        Cards hand1 = new Cards(Arrays.asList(new Card[]{new Card("9"), 
                                                         new Card("7")}));
        
        assertEquals(16, hand1.getScore());
    }
    
    @Test
    public void testAHandWhereUGet21WithNumbers() {
        Cards hand1 = new Cards(Arrays.asList(new Card[]{new Card("9"), 
                                                         new Card("7"),
                                                         new Card("5")}));
        
        assertEquals(21, hand1.getScore());
    }
    
    @Test
    public void testBlackJackPlayerButCroupierNot() {
        Cards hand1 = new Cards(Arrays.asList(new Card[]{new Card("J"), 
                                                         new Card("A")}));
        
        Cards croupier = new Cards(Arrays.asList(new Card[]{new Card("9"), 
                                                         new Card("7"),
                                                         new Card("5")}));
        
        assertEquals(true, this.bj.checkWinnerHand(hand1, croupier));
    }
    
    @Test
    public void testBlackJackPlayerAndCroupierToo() {
        Cards hand1 = new Cards(Arrays.asList(new Card[]{new Card("J"), 
                                                         new Card("A")}));
        
        Cards croupier = new Cards(Arrays.asList(new Card[]{new Card("J"), 
                                                         new Card("A")}));
        
        assertEquals(false, this.bj.checkWinnerHand(hand1, croupier));
    }
    
    @Test
    public void test21CroupierAndHand() {
        Cards hand2 = new Cards(Arrays.asList(new Card[]{new Card("10"), 
                                                         new Card("5"), 
                                                         new Card("6")}));
        
        Cards croupier = new Cards(Arrays.asList(new Card[]{new Card("9"), 
                                                         new Card("7"),
                                                         new Card("5")}));
        
        assertEquals(false, this.bj.checkWinnerHand(hand2, croupier));
    }
    
    @Test
    public void test24InHandCroupierWith21() {
        Cards hand3 = new Cards(Arrays.asList(new Card[]{new Card("3"), 
                                                         new Card("6"),
                                                         new Card("A"),
                                                         new Card("3"),
                                                         new Card("A"),
                                                         new Card("K")}));
        
        Cards croupier = new Cards(Arrays.asList(new Card[]{new Card("9"), 
                                                         new Card("7"),
                                                         new Card("5")}));
        
        assertEquals(false, this.bj.checkWinnerHand(hand3, croupier));
    }
    
    @Test
    public void testToSolveProblem() {
        Cards hand1 = new Cards(Arrays.asList(new Card[]{new Card("J"), 
                                                         new Card("A")}));
        
        Cards hand2 = new Cards(Arrays.asList(new Card[]{new Card("10"), 
                                                         new Card("5"), 
                                                         new Card("6")}));
        
        Cards hand3 = new Cards(Arrays.asList(new Card[]{new Card("3"), 
                                                         new Card("6"),
                                                         new Card("A"),
                                                         new Card("3"),
                                                         new Card("A"),
                                                         new Card("K")}));
        
        Cards croupier = new Cards(new ArrayList (Arrays.asList(new Card[]{
                                                                new Card("9"), 
                                                                new Card("7")})));
        
        Deck deck = new Deck(new ArrayList(Arrays.asList(new Card[]{new Card("5"), 
                                                                    new Card("4"),
                                                                    new Card("K"),
                                                                    new Card("2")})));
        
        assertEquals("Ganadores: 1", bj.getWinners(hand1, hand2, hand3, croupier, deck));
    }
    
    @Test
    public void testCroupierHandInProblem2() {
        
        Cards croupier = new Cards(Arrays.asList(new Card[]{new Card("5"), 
                                                         new Card("10"),
                                                         new Card("A"),
                                                         new Card("3")}));
        
        assertEquals(19, croupier.getScore());
    }
    
    @Test
    public void testToSolveProblem2() {
        Cards hand1 = new Cards(Arrays.asList(new Card[]{new Card("10"), 
                                                         new Card("K")}));
        
        Cards hand2 = new Cards(Arrays.asList(new Card[]{new Card("10"), 
                                                         new Card("2"), 
                                                         new Card("6")}));
        
        Cards hand3 = new Cards(Arrays.asList(new Card[]{new Card("8"), 
                                                         new Card("8"),
                                                         new Card("5")}));
        
        Cards croupier = new Cards(new ArrayList (Arrays.asList(new Card[]{
                                                                new Card("5"), 
                                                                new Card("10")})));
        
        Deck deck = new Deck(new ArrayList(Arrays.asList(new Card[]{new Card("A"),
                                                                    new Card("3"),
                                                                    new Card("K"),
                                                                    new Card("2")})));
        
        assertEquals("Ganadores: 1, 3", bj.getWinners(hand1, hand2, hand3, croupier, deck));
    }
}
