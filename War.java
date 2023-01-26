import java.util.*;
import java.io.*;

public class War extends TwoPlayerGame {
  private Deck warDeck;

  

  
  public  void shuffCheck(ArrayList<Card> hand, ArrayList<Card> disc) {
    if (hand.size() == 0) {
      int s = disc.size();
      for (int j = 0; j < s; j++) {
        hand.add(disc.get(0));
        disc.remove(0);
      }
      Collections.shuffle(hand);
    }
  }

  public  void m(ArrayList<Card> giving, ArrayList<Card> getting) {
    getting.add(giving.get(0));
    giving.remove(0);
  }

  public  int tVal(Card card) {
    if (card.getVal() >= 2) {
      int fVal = card.getVal();
      return fVal;
    } else {
      int fVal = 14;
      return fVal;
    }
  }

  public  int vs(int p1, int p2) {
    if (p1 == p2) {
      return 0;
    } else if (p1 > p2) {
      return 1;
    } else {
      return 2;
    }
  }

  // JC Note: removed static
  public void play() {
    Scanner scan = new Scanner(System.in);
    boolean playInput = false;
    String playCheck = "d";
    if (scan.nextLine().toLowerCase().equals(playCheck)) {

      playInput = true;
    }
    while (playInput == false) {
      System.out.println("Please input D as your command");
      if (scan.nextLine().toLowerCase().equals(playCheck)) {
        playInput = true;
      }
    }
  }
  public void redraw() {
    Scanner scan = new Scanner(System.in);
    boolean playInput = false;
    String playCheck = "Yes";
    if (scan.nextLine().toLowerCase().equals(playCheck)) {

      playInput = true;
    }
    while (playInput == false) {
      System.out.println("Please input D as your command");
      if (scan.nextLine().toLowerCase().equals(playCheck)) {
        playInput = true;
      }
    }
  }
  // JC Note: removed static
  // JC Note: changed start to playGame()
  public void playGame() {
    Scanner scan = new Scanner(System.in);
    int d1 = 4; 
    int d2 = 4;
    String response = "";
    ArrayList<Card> spoils = new ArrayList();
    ArrayList<Card> side1 = new ArrayList();
    ArrayList<Card> side2 = new ArrayList();
    Deck War = new Deck();
    ArrayList<Card> hand1 = new ArrayList();
    ArrayList<Card> disc1 = new ArrayList();
    ArrayList<Card> hand2 = new ArrayList();
    ArrayList<Card> disc2 = new ArrayList();

    for (int i = 0; i < 7; i++) {
      hand1.add(War.cDraw());
    }
    for (int i = 0; i < 7; i++) {
      hand2.add(War.cDraw());
    }

   
    for (int i = 1; hand1.size() > 0 && hand2.size() > 0&&i<12; i++) {
      System.out.println("Round " + i + "\n");
    if(i%2==0){
      System.out.printf("\n%s,type D to play your card\n",getPlayer1().getName());
      play();
      m(hand1, spoils);
      shuffCheck(hand1, disc1);
      System.out.printf("%s played ",getPlayer1().getName());
      System.out.println(spoils.get(0).getName());
      if (d1>0){
      System.out.println("You have " + d1 + " redraw(s), would you like to swap this card for a random card from the deck? (Yes/No)");
      response = scan.nextLine().toLowerCase(); 
      if(response == "yes"){
        spoils.set(0,War.cDraw());
        System.out.println("You drew a " + spoils.get(0).getName());
        d1--;
      }
        else if (response == "no"){
          System.out.println("You retained your current card?");
        }
        else{
          while(response!="yes"&&response!="no"){
            System.out.println("Please enter a valid response");
            response = scan.nextLine().toLowerCase();
          }
          if(response == "yes"){
        spoils.set(0,War.cDraw());
        System.out.println("You drew a " + spoils.get(0).getName());
        d1--;
      }
        else if (response == "no"){
          System.out.println("You retained your current card?");
        }
        }
      }
      System.out.printf("\n%s,type D to play your card\n",getPlayer2().getName());
      play();
      m(hand2, spoils);
      shuffCheck(hand2, disc2);
      System.out.printf("%s played ",getPlayer2().getName());
      System.out.println(spoils.get(1).getName());
        System.out.println("You have " + d2 + " redraw(s), would you like to swap this card for a random card from the deck? (Yes/No)");
      response = scan.nextLine().toLowerCase(); 
      if (d2>0){
      if(response == "yes"){
        spoils.set(1,War.cDraw());
        System.out.println("You drew a " + spoils.get(1).getName());
        d2--;
      }
        else if (response == "no"){
          System.out.println("You retained your current card?");
        }
        else{
          while(response!="yes"&&response!="no"){
            System.out.println("Please enter a valid response");
            response = scan.nextLine().toLowerCase();
          }
          if(response == "yes"){
        spoils.set(1,War.cDraw());
        System.out.println("You drew a " + spoils.get(1).getName());
        d2--;
      }
        else if (response == "no"){
          System.out.println("You retained your current card?");
        }
        }
      }
    }
      else{
        System.out.printf("%s,type D to play your card\n",getPlayer2().getName());
      play();
      m(hand2, spoils);
      shuffCheck(hand2, disc2);
      System.out.printf("%s played ",getPlayer2().getName());
      System.out.println(spoils.get(1).getName());
         if (d2>0){
      if(response == "yes"){
        spoils.set(1,War.cDraw());
        System.out.println("You drew a " + spoils.get(1).getName());
        d2--;
      }
        else if (response == "no"){
          System.out.println("You retained your current card?");
        }
        else{
          while(response!="yes"&&response!="no"){
            System.out.println("Please enter a valid response");
            response = scan.nextLine().toLowerCase();
          }
          if(response == "yes"){
        spoils.set(1,War.cDraw());
        System.out.println("You drew a " + spoils.get(1).getName());
        d2--;
      }
        else if (response == "no"){
          System.out.println("You retained your current card?");
        }
        }
      }
    
        System.out.printf("\n%s,type D to play your card\n",getPlayer1().getName());
      play();
      m(hand1, spoils);
      shuffCheck(hand1, disc1);
      System.out.printf("%s played ",getPlayer1().getName());
      System.out.println(spoils.get(0).getName());
        if (d1>0){
      System.out.println("You have " + d1 + " redraw(s), would you like to swap this card for a random card from the deck? (Yes/No)");
      response = scan.nextLine().toLowerCase(); 
      if(response == "yes"){
        spoils.set(0,War.cDraw());
        System.out.println("You drew a " + spoils.get(0).getName());
        d1--;
      }
        else if (response == "no"){
          System.out.println("You retained your current card?");
        }
        else{
          while(response!="yes"&&response!="no"){
            System.out.println("Please enter a valid response");
            response = scan.nextLine().toLowerCase();
          }
          if(response == "yes"){
        spoils.set(0,War.cDraw());
        System.out.println("You drew a " + spoils.get(0).getName());
        d1--;
      }
        else if (response == "no"){
          System.out.println("You retained your current card?");
        }
        }
      }
      }
      if (tVal(spoils.get(0)) == tVal(spoils.get(1))) {
        
        int points1 = 0;
        int points2 = 0;

        System.out.println("You are equally matched.");
        System.out.println("You have started War against each other!");
        for (int j = 0; j < 3; j++) {
          m(hand1, side1);
          shuffCheck(hand1, disc1);
          m(hand2, side2);
          shuffCheck(hand2, disc2);
          System.out.printf("\nMatch " + (j + 1) + "\n %s's " + side1.get(j).getName() + " vs %s's "
              + side2.get(j).getName() + "\n",getPlayer1().getName(),getPlayer2().getName());
          if (vs(tVal(side1.get(j)), tVal(side2.get(j))) == 0) {
            System.out.println(side2.get(j).getName() + " defeats " + side1.get(i).getName() + " in battle!\n\n");
            points2++;
          } else if ((side1.get(j).getVal() > side2.get(j).getVal())
              || (side1.get(j).getVal() == 1 && side2.get(j).getVal() != 1)) {
            System.out.println(side1.get(j).getName() + " defeats " + side2.get(j).getName() + " in battle!\n\n");
            points1++;
          } else {
            System.out.println(side2.get(j).getName() + " defeats " + side1.get(j).getName() + " in battle!\n\n");
            points2++;
          }
        }
        if (points1 == points2) {
          System.out.println("Both players tied! You both lose your cards");
          for (int j = 0; j < 3; j++) {
            side1.remove(0);
            side2.remove(0);
          }
          spoils.remove(0);
          spoils.remove(0);

        }

        else if (points1 > points2) {
          System.out.printf("\n%s won all the spoils!",getPlayer1().getName());
          for (int j = 0; j < 3; j++) {
            m(side1, disc1);
            m(side2, disc1);

          }
          m(spoils, disc1);
          m(spoils, disc1);
          shuffCheck(hand1, disc1);
        } else if (points2 > points1) {
          System.out.printf("\n%s won all the spoils!",getPlayer2().getName());
          for (int j = 0; j < 3; j++) {
            m(side1, disc2);
            m(side2, disc2);

          }
          m(spoils, disc2);
          m(spoils, disc2);
          shuffCheck(hand2, disc2);
        }

      } else if (tVal(spoils.get(1)) > tVal(spoils.get(0))) {
        System.out.println(spoils.get(1).getName() + " defeats " + spoils.get(0).getName() + " in battle!\n\n");
        m(spoils, disc2);
        m(spoils, disc2);
      } else {
        System.out.println(spoils.get(0).getName() + " defeats " + spoils.get(1).getName() + " in battle!\n\n");
        m(spoils, disc1);
        m(spoils, disc1);
      }

    }
    if (hand1.size() == 0) {
      getPlayer2().addPoints(4);
      System.out.printf("\n%s won the war!",getPlayer2().getName());
    } else if(hand2.size() == 0) {
      System.out.printf("\n%s won the war!",getPlayer1().getName());
      getPlayer1().addPoints(4);
    }
    else if(hand1.size()>hand2.size()){
      System.out.printf("\n%s won the war!",getPlayer1().getName());
      getPlayer1().addPoints(4);
      
    }
    else if(hand2.size()>hand1.size()){
            getPlayer2().addPoints(4);
      System.out.printf("\n%s won the war!",getPlayer2().getName());
    }
    else{
      System.out.printf("\n It was a tie!");
    }
  }

 public void printInstructions() {
    System.out.print(
        "War!\n Welcome to War. In this game each player will be given seven cards to play against each other in a game of war. These ten cards will form their \"deck\". When losing a round of war the winning player will recieve the loser card. \n");
  }
public War(Player player1, Player player2) {
    super(player1, player2);

  }
}
