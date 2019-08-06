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
			}else{
				System.out.println("Room, suggestion error");
			}
		}
		
		//Weapon
		System.out.println("Pick a weapon: \n");
		List<Card> wCards = Game.getWeapCards();
		System.out.println(cardsListToString(wCards) + "\n");
		while(true){
			Scanner inputReader = new Scanner(System.in);
			String input = inputReader.nextLine();
			if(correctCard(input, wCards)) {
				break;
			}else {
				System.out.println("Please input a valid weapon");
			}
		}
		
		//Character
		System.out.println("Pick a character: \n");
		List<Card> cCards = Game.getCharCards();
		System.out.println(cardsListToString(cCards));
		while(true) {
			Scanner inputReader = new Scanner(System.in);
			String input = inputReader.nextLine();
			if(correctCard(input, cCards)) {
				break;
			}else {
				System.out.println("Please input a valid character");
			}
		}


	}

	public void refuteSuggestion() {
		//		   for(Player p)
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
