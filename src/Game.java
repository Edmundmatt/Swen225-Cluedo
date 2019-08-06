/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/


import java.util.*;

// line 61 "model.ump"
// line 136 "model.ump"
public class Game
{
	public static void main(String[] args) {
		Game g = new Game();
		
		//Loop to to ensure a correct number of players is inputted into the game
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
	}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Game Attributes
 // private HashMap playerDecks;
  private static int playerTurn;
  private static ArrayList<Player> playerList;
  private static ArrayList<Weapon> weaponList;
  private static ArrayList<Room> roomList;
  private static Board board;
  private static Player p;
  private static ArrayList<Card> solution;
  private static Suggestion suggestion;
  private static Accusation accusation;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Game(){
    playerTurn = 1;
    playerList = new ArrayList<Player>();
    weaponList = new ArrayList<Weapon>();
    roomList = new ArrayList<Room>();
  }

  /*Random dice rolling*/
  public static int rollDice() {
	  Random random = new Random();
	  return (int)(Math. random()*12+1);
  }
  
  /*A main method that loop through turns of all players, taking inputs and calling other methods to run the game.*/
  public static void runTurn() {
		 while(true) {
			 Player p = playerList.get(playerTurn-1);
			 //If a player has already made an accusation - skip turn
			 if(!p.getSkip()) {
				 System.out.println("It's Player " + p + "'s turn! (your character is " + playerList.get(playerTurn-1).toString() + ")");
				 System.out.println("Player " + p + "'s cards: ");
				 System.out.println(p.playersCardsToString());
				 int moves = rollDice();
				 System.out.println("Dice roll: " + moves);

				 while (moves > 0) {
					 if (board.findPlayer(p).getRoom()==null) {
						 System.out.println("You have " + moves + " moves left. Please enter a direction to move: (north etc)");
						 System.out.println("Or make an accusation with the command 'accuse'.");
					 }
					 Scanner inputReader = new Scanner(System.in);
					 String input = inputReader.nextLine();
					 if (input.equals("suggest")) {
						 if (board.findPlayer(p).getRoom() == null) {
							 System.out.println("You must be in a room to make a suggestion!");
						 } else {
							 suggestion = new Suggestion(p);
							 suggestion.makeSuggestion(board.findPlayer(p).getRoom());
							 nextPlayerTurn();
						 }
					 } else if (input.equals("accuse")) {
						 accusation = new Accusation(p);
						 List<Card> accuseAttempt = accusation.makeAccusation();
						 if(solution.equals(accuseAttempt)) {
							 gameOver(p);
							 return;
						 }else {
							 System.out.println("Accuse attempt failure");
							 System.out.println("Player " + p + " can no longer make suggestions or accusations!\n");
							 p.setSkip(true);
							 nextPlayerTurn();

						 }
					 } else if (board.canMove(p, input)){
						 board.movePlayer(p, input);
						 board.draw();
						 if (board.findPlayer(p).getRoom()==null) {
							 moves--;
						 } else {
							 System.out.println("You're currently in the " + board.findPlayer(p).getRoom().getName() +".");
							 System.out.println("You can move freely within the room - please enter a direction.");
							 System.out.println("Or you can make a suggestion with the command 'suggest'.\n");
						 }
					 }
				 }
			 }
		  
//		  playerTurn++;
//			if (playerTurn > playerList.size()) {
//				playerTurn = 1;
//			}
		  nextPlayerTurn();
	 }
  }
  
  /*Method called when the game has finished*/
  public static void gameOver(Player p) {
	  System.out.println("Nice work! That's the correct solution!\n");
	  System.out.println("Player " + p + " wins the game!");
  }
  
  /*Continue to the next player's turn*/
  public static void nextPlayerTurn() {
	  playerTurn++;
		if (playerTurn > playerList.size()) {
			playerTurn = 1;
		}
		runTurn();
  }
  
  /*Initialises much of the game elements*/
   public static void initialise(int playerCount){
	    board = new Board();
	    //Create new players add add them to the board
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
		//Create all the cards and weapons
		generateCards();
		initialiseWeapons();
		board.draw();
  }
   
   /*Creates all the weapons in the game and adds them to the board in a random place*/
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

   /*Create Lists of the different cards from enum*/
   public static void generateCards() {
	  List<Card> rCards = getRoomCards();
	  List<Card> wCards = getWeapCards();
	  List<Card> cCards = getCharCards();
	  
 	  distributeCards(rCards, wCards, cCards);
   }
   
   public static List<Card> getRoomCards() {
	   return new LinkedList<Card>(Arrays.asList(RoomCard.values()));
   }
   
   public static List<Card> getWeapCards() {
	   return new LinkedList<Card>(Arrays.asList(WeaponCard.values()));
   }

   public static List<Card> getCharCards() {
	   return new LinkedList<Card>(Arrays.asList(CharacterCard.values()));
   }
   
   /*Randomly assign a solution to the game and attribute the rest of the cards to the players hands*/
   public  static void distributeCards(List<Card> rCards, List<Card> wCards, List<Card> cCards) {
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
 	  
 	  //Testing the correct accusation
// 	  solution.add(RoomCard.Kitchen);
// 	  rCards.remove(RoomCard.Kitchen);
// 	  solution.add(WeaponCard.Candlestick);
// 	  wCards.remove(WeaponCard.Candlestick);
// 	  solution.add(CharacterCard.Miss_Scarlett);
// 	  cCards.remove(CharacterCard.Miss_Scarlett);
 	  
 	  
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
   
   //Return a random Card from a list
   public static Card getRandCard(List<Card> list) {
 	  Random rand = new Random();
 	  return list.get(rand.nextInt(list.size()));
   }
   
   public static Board getBoard() {
	   return Game.board;
   }

   public static ArrayList<Player> getPlayers(){
	   return Game.playerList;
   }
   
   /*Moves a player to a random free cell in a room*/
   public static void movePlayerToRoom(Player p, Room r) {
	   Cell newCell = r.getRandomFreeCell();
	   board.movePlayerToCell(p, newCell);
   }

   /*Moves a weapon to a random free cell in a room*/
   public static void moveWeaponToRoom(Weapon w, Room r) {
	   Cell newCell = r.getRandomFreeCell();
	   board.moveWeaponToCell(w, newCell);
   }
   
   public static Weapon getWeapon(String s) {
	   for(Weapon w : weaponList) {
		   if(w.toString().equals(s)) {
			   return w;
		   }
	   }
	   return null;
   }
   
   public static Player getPlayer(String s) {
	   for(Player p : playerList) {
		   if(p.toString().equals(s)) {
			   return p;
		   }
	   }
	   return null;
   }

   


  public String toString()
  {
    return super.toString();
  }
}