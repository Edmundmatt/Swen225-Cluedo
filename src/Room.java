//Authored by Ben Hanson and Matt Edmundson
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/


import java.util.*;

// line 24 "model.ump"
// line 100 "model.ump"
public class Room
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Room Attributes
  private String name; //Name of room
  private ArrayList<Cell> cellList; //List of cells which comprise this room

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Room(String aName)
  {
    name = aName;
    cellList = new ArrayList<Cell>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }


  public String getName()
  {
    return name;
  }

  public List getCellList()
  {
    return cellList;
  }

  //Returns a random cell from the room
  public Cell getRandomCell() {
	  int randIndex = (int)Math. random()*cellList.size();
	  return cellList.get(randIndex);
  }

  //Returns a random cell from the room that doesn't contain a player or a weapon
  public Cell getRandomFreeCell() {
	  ArrayList<Cell> tempCellList = new ArrayList<Cell>(this.cellList);
	  Collections.shuffle(tempCellList);
	  
	  for (Cell c : tempCellList) {
		  if (c.getWeapon() == null && c.getPlayer() == null) {
			  return c;
		  }
	  }	  
	  return null; //No free cell was found in the room
	  }

  public void addCell(Cell c) {
	  cellList.add(c);
  }

  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "cellList" + "=" + (getCellList() != null ? !getCellList().equals(this)  ? getCellList().toString().replaceAll("  ","    ") : "this" : "null");
  }

}