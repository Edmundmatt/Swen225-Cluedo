/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/


import java.util.*;

// line 85 "model.ump"
// line 90 "model.ump"
public class Player
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Player Associations
  private List<Game> games;
  private List<Card> playersCards;
  private String name;
  private boolean skip;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Player(String name)
  {
	  games = new ArrayList<Game>();
	  setPlayersCards(new ArrayList<Card>());
	  this.name = name;
	  skip = false;
  }

  public String toString() {
	  return this.name;
  }

  public List<Card> getPlayersCards() {
	  return playersCards;
  }

  public void setPlayersCards(List<Card> playersCards) {
	  this.playersCards = playersCards;
  }

  public String playersCardsToString() {
	  String out = "";
	  for(Card c : playersCards) {
		  out = out + c.toString() + "\n";
	  }
	  return out;
  }

  public boolean getSkip() {
	  return skip;
  }
  
  public void setSkip(boolean b) {
	  skip = b;
  }
}