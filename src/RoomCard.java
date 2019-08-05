/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/



// line 55 "model.ump"
// line 131 "model.ump"

public enum RoomCard implements Card {
	KITCHEN,
	BALL_ROOM,
	CONSERVATORY,
	BILLIARD_ROOM,
	LIBRARY,
	STUDY,
	HALL,
	LOUNGE,
	DINING_ROOM;
	
}

//public class RoomCard extends Card
//{
//
//  //------------------------
//  // MEMBER VARIABLES
//  //------------------------
//
//  //RoomCard Attributes
//  private String name;
//
//  //------------------------
//  // CONSTRUCTOR
//  //------------------------
//
//  public RoomCard(String aName)
//  {
//    super();
//    name = aName;
//  }
//
//  //------------------------
//  // INTERFACE
//  //------------------------
//
//  public boolean setName(String aName)
//  {
//    boolean wasSet = false;
//    name = aName;
//    wasSet = true;
//    return wasSet;
//  }
//
//  public String getName()
//  {
//    return name;
//  }
//
//  public void delete()
//  {
//    super.delete();
//  }
//
//
//  public String toString()
//  {
//    return super.toString() + "["+
//            "name" + ":" + getName()+ "]";
//  }
//}