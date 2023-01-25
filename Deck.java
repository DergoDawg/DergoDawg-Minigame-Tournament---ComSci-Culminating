import java.util.*;
import java.io.*;
public class Deck{
  private int cardCount;
  private ArrayList<Card> allCards;//Sets up an array to contain all of the cards in the deck.
  public Deck(){
    this.allCards = new ArrayList<Card>();
    for(int i=0;i<4;i++){//These loops add all cards and suits to the deck
      for(int j =1;j<13;j++){
        this.allCards.add(new Card(i,j));
      }
    }
    Collections.shuffle(this.allCards);//shuffles the deck each time it is made
    this.cardCount= -1;
  }
  public void Shuffle(){//a shuffle method use between rounds
    Collections.shuffle(this.allCards);
    this.cardCount=0;
  }
  public Card cDraw(){
    this.cardCount++;
    //return (this.allCards.get(i)&&this.cardCount+=1);
    // NOTE: Diego i had to change the line above so that everything would compile
    return (this.allCards.get(cardCount));
  }
}

