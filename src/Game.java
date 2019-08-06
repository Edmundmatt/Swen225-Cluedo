/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/


import java.util.*;

// line 61 "model.ump"
// line 136 "model.ump"
public class Game
{
	public static void main(String[] args) {
		Game g = new Game();

		while (true){
		int playerCount = 0;
		Scanner inputReader = new Scanner(System.in);
		System.out.println("Welcome to Cluedo! How many players this game? (between 3-6)");
		if (inputReader.hasNextInt()) {
			playerCount = inputReader.nextInt();
			if (playerCount >= 3 && playerCount <= 6) {
				initialise(playerCount);
				break;
			}
		}
		System.out.println("Please enter a number between 3 and 6!");
		}

		runTurn();

//		while(true) {
//			String input = null;
//			System.out.println("please enter a direction (north etc.)" );
//			Scanner inputReader = new Scanner(System.in);
//			input = inputReader.nextLine();
//			board.movePlayer(p, input);
//			board.draw();
//		}

	}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Game Attributes
 // private HashMap playerDecks;
  private static int playerTurn;
  private static List<Player> playerList;
  private static List<Weapon> weaponList;
  private static List<Room> roomList;
  private static Board board;
  private static Player p;
  private List<Card> solution;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Game(){
   // playerDecks = aPlayerDecks;
    playerTurn = 1;
    playerList = new ArrayList<Player>();
    weaponList = new ArrayList<Weapon>();
    roomList = new ArrayList<Room>();
  }


  public static int rollDice() {
	  Random random = new Random();
	  return (int)(Math. random()*6+1);
  }

  public static void runTurn() {
	 while(true) {
	  System.out.println("It's Player " + playerTurn + "'s turn! (your character is " + playerList.get(playerTurn-1).toString() + ")");
	  Player p = playerList.get(playerTurn-1);
	  int moves = rollDice();
	  System.out.println("Dice roll: " + moves);

	  while (moves > 0) {
		  if (board.findPlayer(p).getRoom()==null) {
		  System.out.println("You have " + moves + " moves left. Please enter a direction to move: (north etc)");
		  }
		  Scanner inputReader = new Scanner(System.in);
		  String input = inputReader.nextLine();
		  if (board.canMove(p, input)){
			  board.movePlayer(p, input);
			  board.draw();
			  if (board.findPlayer(p).getRoom()==null) {
				  moves--;
			  } else {
				  System.out.println("You're currently in the " + board.findPlayer(p).getRoom().getName() +".");
				  System.out.println("You can move freely within the room - please enter a direction.");
			  }
		  }
	  }



	  playerTurn++;
		if (playerTurn > playerList.size()) {
			playerTurn = 1;
		}
	 }
  }

  // line 70 "model.ump"
   public static void initialise(int playerCount){
	    board = new Board();
		Player p1 = new Player("S"); //Miss Scarlett
		playerList.add(p1);
		Player p2 = new Player("M"); //Colonel Mustard
		playerList.add(p2);
		Player p3 = new Player("W"); //Mrs. White
		playerList.add(p3);
		board.setPlayer(p1, 24, 8);
		board.setPlayer(p2, 17, 0);
		board.setPlayer(p3, 0, 10);
		if (playerCount > 3) {
			Player p4 = new Player("G"); //Mr. Green
			board.setPlayer(p4, 0, 17);
			playerList.add(p4);
		}
		if (playerCount > 4) {
			Player p5 = new Player("P"); //Mrs. Peacock
			board.setPlayer(p5, 5, 27);
			playerList.add(p5);
		}
		if (playerCount > 5) {
			Player p6 = new Player("L"); //Professor Plum
			board.setPlayer(p6, 19, 27);
			playerList.add(p6);
		}
		board.buildBoard();
		for (Room r : board.getRooms()) {
			roomList.add(r);
		}
		initialiseWeapons();
		board.draw();
  }

   public static void initialiseWeapons() {
	   Weapon candlestick = new Weapon("c");
	   weaponList.add(candlestick);
	   Weapon dagger = new Weapon("d");
	   weaponList.add(dagger);
	   Weapon leadDagger = new Weapon("l");
	   weaponList.add(leadDagger);
	   Weapon revolver = new Weapon("r");
	   weaponList.add(revolver);
	   Weapon rope = new Weapon("o");
	   weaponList.add(rope);
	   Weapon spanner = new Weapon("s");
	   weaponList.add(spanner);

	   ArrayList<Weapon> tempWeaponList = new ArrayList<Weapon>(weaponList);
	   Collections.shuffle(tempWeaponList);

	   ArrayList<Room> randomRooms = board.getRandomRooms();
	   int index = 0;

	   for (Weapon w : tempWeaponList) {
		   randomRooms.get(index).getRandomCell().setWeapon(w);
		   index++;
	   }

   }

   //Matt added this method
   public void generateCards() {
 	  List<Card> rCards = Arrays.asList(RoomCard.values());
 	  List<Card> wCards = Arrays.asList(WeaponCard.values());
 	  List<Card> cCards = Arrays.asList(CharacterCard.values());
 	  distributeCards(rCards, wCards, cCards);
   }

   //Matt added this method
   public void distributeCards(List<Card> rCards, List<Card> wCards, List<Card> cCards) {
 	  //Random solution
 	  solution = new ArrayList<Card>();
 	  //Room
 	  Card randRoom = getRandCard(rCards);
 	  solution.add(randRoom);
 	  rCards.remove(randRoom);
 	  //Weapon
 	  Card randWeap = getRandCard(wCards);
 	  solution.add(randWeap);
 	  wCards.remove(randWeap);
 	  //Character
 	  Card randChar = getRandCard(cCards);
 	  solution.add(randChar);
 	  cCards.remove(randChar);

 	  //Rest of cards
 	  while(!rCards.isEmpty() && !wCards.isEmpty() && !cCards.isEmpty()) {
 		  for(Player p : playerList) {
 			  if(!rCards.isEmpty()) {
 				  randRoom = getRandCard(rCards);
 				  p.getPlayersCards().add(randRoom);
 				  rCards.remove(randRoom);
 			  }
 			  if(!wCards.isEmpty()) {
 				  randWeap = getRandCard(wCards);
 				  p.getPlayersCards().add(randWeap);
 				  wCards.remove(randWeap);
 			  }
 			  if(!cCards.isEmpty()) {
 				  randChar = getRandCard(cCards);
 				  p.getPlayersCards().add(randChar);
 				  cCards.remove(randChar);
 			  }

 		  }
 	  }
   }

   //Matt added - function to get random element from List
   public Card getRandCard(List<Card> list) {
 	  Random rand = new Random();
 	  return list.get(rand.nextInt(list.size()));
   }


  public String toString()
  {
    return super.toString();
  }
}