//Authored by Ben Hanson and Matt Edmundson
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/


import java.util.*;

// line 16 "model.ump"
// line 95 "model.ump"
public class Cell
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Cell Attributes
  private Player player; //Player currently occupying this cell
  private Weapon weapon; //Weapon currently occupying this cell
  private int x; //Location of cell in board
  private int y;
  private boolean isWall; //Is true if this cell is a wall
  private Room room; //Stores room that this cell is a part of


  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Cell(Player aPlayer, Weapon aWeapon, int aX, int aY)
  {
    player = aPlayer;
    weapon = aWeapon;
    x = aX;
    y = aY;
    isWall = false;
    room = null;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPlayer(Player aPlayer) 
  {
    boolean wasSet = false;
    player = aPlayer;
    wasSet = true;
    return wasSet;
  }

  public void setWall(boolean bool) {
	  isWall = bool;
  }

  public boolean isWall() {
	return isWall;
  }

  public boolean setWeapon(Weapon aWeapon)
  {
    boolean wasSet = false;
    weapon = aWeapon;
    wasSet = true;
    return wasSet;
  }

  public boolean setX(int aX)
  {
    boolean wasSet = false;
    x = aX;
    wasSet = true;
    return wasSet;
  }

  public boolean setY(int aY)
  {
    boolean wasSet = false;
    y = aY;
    wasSet = true;
    return wasSet;
  }

  public Player getPlayer()
  {
    return player;
  }

  public Weapon getWeapon()
  {
    return weapon;
  }

  public int getX()
  {
    return x;
  }

  public int getY()
  {
    return y;
  }

  public void setRoom(Room r) {
	  this.room = r;
  }

  public Room getRoom() {
	  return this.room;
  }

  //Displays state of cell, prioritises player over weapon if they occupy the same cell
  public String toString() 
  {
	if (isWall) {
		return "#"; //Represents wall
	} else if (player != null) {
    	return player.toString(); //If player occupies cell, display them
    } else if (weapon != null){
    	return weapon.toString(); //Else if weapon occupies cell, display that
    } else {
    	return "_";
    }
  }
}