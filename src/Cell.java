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
  private Player player;
  private Weapon weapon;
  private int x;
  private int y;
  private boolean isWall;


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
  
  


  public String toString()
  {
	if (isWall) {
		return "#";
	} else if (player != null) {
    	return player.toString();
    } else if (weapon != null){
    	return weapon.toString();
    } else {
    	return "_";
    }
  }
}