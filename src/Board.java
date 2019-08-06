/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/


import java.util.*;

// line 2 "model.ump"
// line 77 "model.ump"
// line 115 "model.ump"
public class Board
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Board Attributes
  private Cell[][] board;
  private ArrayList<Room> rooms;



  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Board()
  {
	rooms = new ArrayList<Room>();

    board = new Cell[25][28];
    for (int row = 0 ; row < 25; row++) {
    	for (int col = 0; col < 28; col++) {
    		board[row][col] = new Cell(null, null, row, col);
    	}
    }
  }

  public void draw() {
	  for (int row = 0 ; row < 25; row++) {
		  String rowSoFar = "";
	    	for (int col = 0; col < 28; col++) {
	    		rowSoFar += board[row][col].toString();
	    		rowSoFar += "|";
	    	}
	    	System.out.println(rowSoFar);
	    }
	  System.out.println("\n");
  }

  public void setPlayer(Player p, int row, int col) {
	  board[row][col].setPlayer(p);
  }

  public void setWeapon(Weapon w, int row, int col) {
	  board[row][col].setWeapon(w);
  }

  public void movePlayer (Player p, String dir) {
	  Cell c = findPlayer(p);
	  if (c != null) {
		  int x = c.getX();
		  int y = c.getY();

		  if (dir.equals("north") && x > 0 && !board[x-1][y].isWall()) {
			  board[x-1][y].setPlayer(c.getPlayer());
			  c.setPlayer(null);
		  } else if (dir.equals("south") && x < 24  && !board[x+1][y].isWall()) {
			  board[x+1][y].setPlayer(c.getPlayer());
			  c.setPlayer(null);
		  } else if (dir.equals("east") && y < 27 && !board[x][y+1].isWall()) {
			  board[x][y+1].setPlayer(c.getPlayer());
			  c.setPlayer(null);
		  } else if (dir.equals("west") && y > 0 && !board[x][y-1].isWall()){
			  board[x][y-1].setPlayer(c.getPlayer());
			  c.setPlayer(null);
		  }
	  }
  }

  public boolean canMove(Player p, String dir) {
	  Cell c = findPlayer(p);
	  if (c != null) {
		  int x = c.getX();
		  int y = c.getY();

		  if (dir.equals("north") && x > 0 && !board[x-1][y].isWall()) {
			  Cell next = board[x-1][y];
			  if (!next.isWall() && next.getPlayer() == null) {
				  return true;
			  }
		  } else if (dir.equals("south") && x < 24  && !board[x+1][y].isWall()) {
			  Cell next = board[x+1][y];
			  if (!next.isWall() && next.getPlayer() == null) {
				  return true;
			  }
		  } else if (dir.equals("east") && y < 27 && !board[x][y+1].isWall()) {
			  Cell next = board[x][y+1];
			  if (!next.isWall() && next.getPlayer() == null) {
				  return true;
			  }
		  } else if (dir.equals("west") && y > 0 && !board[x][y-1].isWall()){
			  Cell next = board[x][y-1];
			  if (!next.isWall() && next.getPlayer() == null) {
				  return true;
			  }
		  }
	  }
	  return false;
  }

  public void buildBoard() {
	  Room kitchen = new Room("kitchen");
	  rooms.add(kitchen);
	  Room ballRoom = new Room("ballroom");
	  rooms.add(ballRoom);
	  Room conservatory = new Room("conservatory");
	  rooms.add(conservatory);
	  Room diningRoom = new Room("dining room");
	  rooms.add(diningRoom);
	  Room billiardRoom = new Room("billiard room");
	  rooms.add(billiardRoom);
	  Room library = new Room("library");
	  rooms.add(library);
	  Room lounge = new Room("lounge");
	  rooms.add(lounge);
	  Room hall = new Room("hall");
	  rooms.add(hall);
	  Room study = new Room("study");
	  rooms.add(study);

  String input =
    "111111##___#2222#___##333333"+
	"111111#___#222222#___#333333"+
	"111111#___#222222#___#333333"+
	"111111#___#222222#____333333"+
	"#11111#____222222____#######"+
	"####_##___#222222#__________"+
	"__________#_####_#_________#"+
	"#____________________#######"+
	"######_______________#555555"+
	"44444####_____________555555"+
	"44444444#____________#555555"+
	"44444444_____________#555555"+
	"44444444#____________#####_#"+
	"44444444#__________________#"+
	"44444444#____________###_###"+
	"######_##___________#6666666"+
	"#____________________6666666"+
	"____________________#6666666"+
	"#_________###__###___#######"+
    "######_#__#888888#__________"+
	"#777777#__#888888__________#"+
	"7777777#__#888888#__#_######"+
	"7777777#__#888888#__#999999#"+
	"7777777#__#888888#__#999999_"+
	"7777777#_##888888##_##99999_";

  	int row = 0;
  	int col = 0;

  	for (char c : input.toCharArray()) {
  		if (c == '#') {
  			board[row][col].setWall(true);
  		} else if (c == '1') {
  			kitchen.addCell(board[row][col]);
  			board[row][col].setRoom(kitchen);
  		} else if (c == '2') {
  			ballRoom.addCell(board[row][col]);
  			board[row][col].setRoom(ballRoom);
  		} else if (c == '3') {
  			conservatory.addCell(board[row][col]);
  			board[row][col].setRoom(conservatory);
  		} else if (c == '4') {
  			diningRoom.addCell(board[row][col]);
  			board[row][col].setRoom(diningRoom);
  		} else if (c == '5') {
  			billiardRoom.addCell(board[row][col]);
  			board[row][col].setRoom(billiardRoom);
  		} else if (c == '6') {
  			library.addCell(board[row][col]);
  			board[row][col].setRoom(library);
  		} else if (c == '7') {
  			lounge.addCell(board[row][col]);
  			board[row][col].setRoom(lounge);
  		} else if (c == '8') {
  			hall.addCell(board[row][col]);
  			board[row][col].setRoom(hall);
  		} else if (c == '9') {
  			study.addCell(board[row][col]);
  			board[row][col].setRoom(study);
  		}

  		col++;
  		if (col >= 28) {
  			col = 0;
  			row++;
  		}
  	}
  }

  public Cell findPlayer(Player p) {
	  for (int row = 0 ; row < 25; row++) {
	    	for (int col = 0; col < 24; col++) {
	    		if (board[row][col].getPlayer() == p) {
	    			return board[row][col];
	    		}
	    	}
	    }
	return null;
  }

  public Cell findWeapon (Weapon w) {
	  for (int row = 0 ; row < 25; row++) {
	    	for (int col = 0; col < 24; col++) {
	    		if (board[row][col].getWeapon() == w) {
	    			return board[row][col];
	    		}
	    	}
	    }
	return null;
  }


  // line 7 "model.ump"
  public Cell findCell(int x, int y){
	return board[x][y];
  }

  public List<Room> getRooms(){
	  return this.rooms;
  }

  public ArrayList<Room> getRandomRooms() {
	  ArrayList<Room> randomRooms = new ArrayList<Room>(rooms);
	  Collections.shuffle(randomRooms);
	  return randomRooms;
  }

  public void movePlayerToCell(Player p, Cell c) {
	  if (c.getPlayer() == null) {
		  Cell originalPos = findPlayer(p);
		  c.setPlayer(p);
		  originalPos.setPlayer(null);
	  }
  }

  public void moveWeaponToCell(Weapon w, Cell c) {
	  if (c.getWeapon() == null) {
		  Cell originalPos = findWeapon(w);
		  c.setWeapon(w);
		  originalPos.setWeapon(null);
	  }
  }

  public Cell[][] retrieveBoard(){
	  return board;
  }

  public String toString()
  {
	String boardString = "";

    for (int row = 0 ; row < 25; row++) {
	    	for (int col = 0; col < 28; col++) {
	    		boardString += board[row][col].toString();
	    	}
	    }

    return boardString;
  }
}