import java.util.*;
import java.io.*;

public class Blackjack extends TwoPlayerGame {
  private Deck BlackjackDeck;

  public Blackjack(Player player1, Player player2) {
    super(player1, player2);
  }



  public int hVal(ArrayList<Card> hand) {
    ArrayList<Card> aces = new ArrayList();
    for (int i = 0; i < hand.size(); i++) {
      if (hand.get(i).getVal() == 1) {
        aces.add(hand.get(i));
        hand.remove(i);
        i--;
      }
    }
    for (int i = 0; i < aces.size(); i++) {
      hand.add(aces.get(i));
    }
    int handVal = 0;
    for (int i = 0; i < hand.size(); i++) {
      if (hand.get(i).getVal() > 10) {
        handVal += 10;
      } else if (hand.get(i).getVal() == 1) {
        if (handVal > 10 || hand.size() > i + 1) {
          handVal += 1;
        } else {
          handVal += 11;
        }
      } else {
        handVal += hand.get(i).getVal();
      }
    }
    return handVal;
  }

 
  public void bet(ArrayList<Integer> p) {
    Scanner scan = new Scanner(System.in);
    String bet = scan.nextLine();
      int checker = 0;
    try {
          checker = Integer.parseInt(bet);
        } catch (NumberFormatException e) {
          checker = 0;
        }
    p.set(1,checker);
    if (p.get(1) >= p.get(0)||p.get(1)<=0) {
      p.set(1, 0);
      while (p.get(1) == 0) {
        System.out.println("Enter a valid bet.");
        bet = scan.nextLine();
    try {
          checker = Integer.parseInt(bet);
        } catch (NumberFormatException e) {
          checker = 0;
        }
    p.set(1,checker);
        if (p.get(1) > p.get(0)||p.get(1)==0) {
         p.set(1, 0);
        }
      }
    }
      p.set(0, p.get(0) - p.get(1));
    
  }

  public void empty(ArrayList<Card> hand) {
    for (Card x: hand) {
      hand.remove(0);
    }
  }

  public void printInstructions() {
    System.out.println(
        "In this game of Blackjack, you will be competing against a dealer alongside the other player to see who can get closest to 21 with the cards in their hand. If the hands value goes over 21\n or your hands value is worth less than the dealers you bust\n and lose your bet. Otherwise, you make double your money by beating the dealer or getting a blackjack. All face cards in this game are worth 10, and aces are worth either 11 or 1 depending on how close you are to 21. Whoever ends the game with the\n most points wins!");
  }

  public void pH(ArrayList<Card> hand) {
    for (int j = 0; j < hand.size(); j++) {
      System.out.println(hand.get(j).getName());
    }
    System.out.print("\n\n");
  }

  public void payout(ArrayList<Integer> p) {
    p.set(0, (p.get(1) * 2)+p.get(0));
    p.set(1, 0);
  }
 public void turn(ArrayList<Card> hand, Deck deck) {
    Scanner scan = new Scanner(System.in);
    boolean looper = false;
    String playCheck1 = "hit";
    String playCheck2 = "stand";
    
    while (looper == false&&hVal(hand)<21) {
      String response = "";
    System.out.printf("Type hit to draw another card or type stand to keep your \ncurrent hand \n");
      response = scan.nextLine().toLowerCase();
    if (response.equals(playCheck1)) {
    hand.add(deck.cDraw());
      System.out.println("You drew the: " + hand.get(hand.size() - 1).getName());
          System.out.printf("Your current hand is:\n ");
          pH(hand);
      
    } else if (response.equals(playCheck2)) {
      looper=true;
    }
    else{
      System.out.println("Please input a valid command");
    }
  }
  }
  public void playGame() {
    Scanner scan = new Scanner(System.in);
    ArrayList<Integer> p1 = new ArrayList();
    ArrayList<Integer> p2 = new ArrayList();
    p1.add(1000);
    p2.add(1000);
    p1.add(0);
    p2.add(0);
    boolean p1Bet = true;
    boolean p2Bet = true;
    Deck pile = new Deck();
    ArrayList<Card> dealer = new ArrayList();
    ArrayList<Card> hand1 = new ArrayList();
    ArrayList<Card> hand2 = new ArrayList();
    
    System.out.printf("%s & %s play Blackjack!\n\n",
        getPlayer1().getName(), getPlayer2().getName());
    for (int i = 0; i < 3 && p1.get(0) > 0 && p2.get(0) > 0; i++) {
      System.out.printf("%s, you have " + p1.get(0) + " points. Make your bet!\n", getPlayer1().getName());
      bet(p1);
      System.out.printf("%s, you have " + p2.get(0) + " points. Make your bet!\n", getPlayer2().getName());
      bet(p2);
      dealer.add(pile.cDraw());
      dealer.add(pile.cDraw());
      System.out.println("The dealer's first card is the " + dealer.get(0).getName());

      hand1.add(pile.cDraw());
      hand1.add(pile.cDraw());

      System.out.printf("\n\n%s, your current hand is:\n ", getPlayer1().getName());
      pH(hand1);
      if (hVal(hand1) == 21) {
        System.out.println("You got blackjack, you get 2x your money!");
        payout(p1);
      } else {
       turn(hand1,pile);
        
      }
      if (hVal(hand1) == 21) {
        System.out.printf("%s,You got blackjack, you get 2x your money!\n",getPlayer1().getName());
        payout(p1);
        p1Bet = false;
      }
      if(hVal(hand1) > 21){
        System.out.println("You went over 21, you lost your bet!\n\n");
        p1.set(1,0);
        p1Bet = false;
      }
      hand2.add(pile.cDraw());
      hand2.add(pile.cDraw());

      System.out.printf("\n\n%s, your current hand is:\n ", getPlayer2().getName());
      pH(hand2);
       if (hVal(hand2) == 21) {
        System.out.printf("%s,You got blackjack, you get 2x your money!\n",getPlayer2().getName());
        payout(p2);
        p2Bet = false;
      }
     else {
        turn(hand2,pile);
              
      }
        if (hVal(hand2) == 21) {
        System.out.printf("%s,You got blackjack, you get 2x your money!\n",getPlayer2().getName());
        payout(p2);
        p2Bet = false;
      }
      if(hVal(hand2) > 21){
        System.out.println("You went over 21, you lost your bet!\n\n");
        p2.set(1,0);
        p2Bet = false;
      }
      
      while(hVal(dealer)<17){
        dealer.add(pile.cDraw());
      }
System.out.println("The dealer shows the rest of their hand: " );
      pH(dealer);
      if(hVal(dealer)>21){
        System.out.println("The dealer went over 21, if you're still in, you make 2x your bet! \n" );
         if (p1Bet ==true){
           payout(p1);
           
      }
        if (p2Bet ==true){
          payout(p2);
      }
      }
      else{
      
      if (p1Bet ==true){
      
      if(hVal(hand1) > 21){
        System.out.printf("%s,You went over 21, you lost your bet!\n",getPlayer1().getName());
        p1.set(1,0);
      }
      if (hVal(hand1) == 21) {
        System.out.printf("%s,You got blackjack, you get 2x your money!\n",getPlayer1().getName());
        payout(p1);
      }
      if (hVal(hand1) < hVal(dealer)) {
        System.out.printf("%s,You lost to the dealer, you lost your bet!\n",getPlayer1().getName());
        p1.set(1,0);
      }
        if (hVal(hand1) > hVal(dealer)) {
        System.out.printf("%s,You beat the dealer, you got 2x your bet!\n",getPlayer1().getName());
        p1.set(1,0);
      }
      if (hVal(hand1) == hVal(dealer)){
        System.out.printf("%s,You tied the dealer, you get your bet back!\n",getPlayer1().getName());
        p1.set(0,p1.get(0)+p1.get(1));
        p1.set(1,0);
        
      }
      }
      if (p2Bet ==true){
      if(hVal(hand2) > 21){
        System.out.printf("%s,You went over 21, you lost your bet!\n",getPlayer2().getName());
        p2.set(1,0);
      }
      if (hVal(hand2) == 21) {
        System.out.printf("%s,You got blackjack, you get 2x your money!\n",getPlayer2().getName());
        payout(p2);
      }
      if (hVal(hand2) < hVal(dealer)) {
        System.out.printf("%s,You lost to the dealer, you lost your bet!\n",getPlayer2().getName());
        p2.set(1,0);
      }
        if (hVal(hand2) > hVal(dealer)) {
        System.out.printf("%s,You beat the dealer, you got 2x your bet!\n",getPlayer2().getName());
        p2.set(1,0);
      }
      if (hVal(hand2) == hVal(dealer)){
        System.out.printf("%s,You tied the dealer, you get your bet back!\n",getPlayer2().getName());
        p2.set(0,p2.get(0)+p2.get(1));
        p2.set(1,0);      
      }
      }
      }
       System.out.printf("%s, you ended this round with " + p1.get(0) + " points!\n\n", getPlayer1().getName());
      System.out.printf("%s, you ended this round with " + p2.get(0) + " points!\n\n", getPlayer2().getName());
      
      empty(hand1);
      empty(hand2);
      empty(dealer);
      pile.Shuffle();
    }
    if(p1.get(0)>p2.get(0)){
      System.out.printf("%s,You have more points than %s and won in blackjack!\n",getPlayer1().getName(),getPlayer2().getName());
    getPlayer1().addPoints(3);
      
    }
    else if(p2.get(0)>p1.get(0)){
      System.out.printf("%s,You have more points than %s and won in blackjack!\n",getPlayer2().getName(),getPlayer1().getName());
      getPlayer2().addPoints(3);
    }
    else{
      System.out.printf("%s and %s,You have equal points and tied in blackjack!\n",getPlayer1().getName(),getPlayer2().getName());
    getPlayer2().addPoints(3);
    getPlayer1().addPoints(3);
    }
  }
  
}
