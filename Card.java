// we can chnage this (lesson 3.8 - direction.java)


/**
 * @author DergoDawg &
 */
import java.util.*;
import java.io.*;

public class Card{
  private int suit;
  private int number;
  private String suitName;
  private String numName;


public Card (int s, int n){//Creates a card with a suit and a number
  this.suit =s;
  this.number = n;
  if (this.suit == 0){//Creates a string name for the suits
    this.suitName = "Spades";
  }
  if (this.suit == 1){
    this.suitName = "Clubs";
  }
  if (this.suit == 2){
    this.suitName = "Diamonds";
  }
  if (this.suit == 3){
    this.suitName = "Hearts";
  }
  if (this.number == 1){//Creates string names for the written numbers
    this.numName = "Ace";
  }
   if (this.number == 2){
    this.numName = "Two";
  }
   if (this.number == 3){
    this.numName = "Three";
  }
   if (this.number == 4){
    this.numName = "Four";
  }
   if (this.number == 5){
    this.numName = "Five";
  }
   if (this.number == 6){
    this.numName = "Six";
  }
   if (this.number == 7){
    this.numName = "Seven";
  }
   if (this.number == 8){
    this.numName = "Eight";
  }
   if (this.number == 9){
    this.numName = "Nine";
  }
   if (this.number == 10){
    this.numName = "Ten";
  }
   if (this.number == 11){
    this.numName = "Jack";
  }
   if (this.number == 12){
    this.numName = "Queen";
  }
   if (this.number == 13){
    this.numName = "King";
  }
}
public String getSuit(){//returns the written suit name
    return this.suitName;
  }
public String getNum(){//returns the written number name
    return this.numName;
  }
public int getVal(){//returns the written number name
    return this.number;
  }
  public String getName(){
    String title = this.numName + " of " + this.suitName;
    return title;
  }
}
