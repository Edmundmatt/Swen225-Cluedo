import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Suggestion {
	private static Board board;
	private Player p;
	private List<Card> suggestion;
	
	public Suggestion(Player p) {
		this.p = p;
		suggestion = new ArrayList<Card>();
	}
	
	public void makeSuggestion(Room room) {
		suggestion.clear();
		Room curRoom = Game.getBoard().findPlayer(p).getRoom();
		System.out.println("You are currently in " + curRoom.getName() + ".");
		//Add room to suggestion
		for(Card c : Game.getRoomCards()) {
			if(room.getName().equalsIgnoreCase(c.toString())) {
				suggestion.add(c);
			}
		}
		
		//Weapon
		System.out.println("Pick a weapon: \n");
		List<Card> wCards = Game.getWeapCards();
		System.out.println(cardsListToString(wCards) + "\n");
		String weapString;
		while(true){
			Scanner inputReader = new Scanner(System.in);
			String input = inputReader.nextLine();
			if(correctCard(input, wCards)) {
				weapString = input;
				break;
			}else {
				System.out.println("Please input a valid weapon");
			}
		}
		
		//Character
		System.out.println("Pick a character: \n");
		List<Card> cCards = Game.getCharCards();
		System.out.println(cardsListToString(cCards) + "\n");
		String playString;
		while(true) {
			Scanner inputReader = new Scanner(System.in);
			String input2 = inputReader.nextLine();
			if(correctCard(input2, cCards)) {
				playString = input2;
				break;
			}else {
				System.out.println("Please input a valid character");
			}
		}
		//teleport player and weapon to room

		Player suggPlay = Game.getPlayer(playString);
		Game.movePlayerToRoom(suggPlay, room);
		
		Weapon suggWeap = Game.getWeapon(weapString);
		Game.moveWeaponToRoom(suggWeap, room);
		
		System.out.println(suggestion.toString());
		Game.getBoard().draw();

		refuteSuggestion();
	}

	public void refuteSuggestion() {
		for(Player player : Game.getPlayers()) {
			if(!player.equals(p)) {
				System.out.println(player.toString() + ". Refute the suggestion.\n");
				System.out.println("Either name one of your cards that refutes the suggestion \n"
						+ "or, if there none, input 'none'.\n");
				System.out.println(refuteCards(player));
				while(true) {
					Scanner inputReader = new Scanner(System.in);
					String input = inputReader.nextLine();
					if(input.equalsIgnoreCase("none")){
						System.out.println("Player " + player.toString() + " has no cards that refute the suggestion.");
						break;
					}else {
						boolean found = false;
						for(Card c : suggestion) {
							if(input.equalsIgnoreCase(c.toString())) {
								System.out.println("Player " + player.toString() + " refutes the suggestion with card: " +
										c.toString());
								found = true;
							}
						}
						if(found) break;
						System.out.println(player.toString() + ". Please input a valid answer.");
					}
				}
				
			}
		}
	}
	
	public String refuteCards(Player player) {
		List<Card> matches = new ArrayList<Card>();
		for(Card c : player.getPlayersCards()) {
			for(Card ca : suggestion) {
				if(ca.equals(c)) {
					matches.add(c);
				}
			}
		}
		return cardsListToString(matches);
	}

	public String cardsListToString(List<Card> list) {
		String out = "";
		for(Card c : list) {
			out = out + c.toString() + "\n";
		}
		return out;
	}

	public boolean correctCard(String input, List<Card> list) {
		for(Card c : list) {
			if(input.equalsIgnoreCase(c.stringCheck())) {
				suggestion.add(c);
				return true;
			}
		}
		return false;
	}
}
