import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Accusation {
	private static Board board;
	private Player p;
	private List<Card> accusation;
	
	public Accusation(Player p) {
		this.p = p;
		accusation = new ArrayList<Card>();
	}
	
	/*Allows the player to make a final accusation for solution cards. Returns a List of Cards to be compared to the solution
	 * cards.*/
	public List<Card> makeAccusation() {
		accusation.clear();
		System.out.println("Player " + p.toString() + " you are making a final accusation.\n");
		//Room
		System.out.println("Pick a room\n");
		List<Card> rCards = Game.getRoomCards();
		System.out.println(cardsListToString(rCards) + "\n");
		while(true) {
			Scanner inputReader = new Scanner(System.in);
			String input = inputReader.nextLine();
			if(correctCard(input, rCards)) {
				break;
			}else {
				System.out.println("Please input a valid room.");
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
				System.out.println("Please input a valid weapon.");
			}
		}

		//Character
		System.out.println("Pick a character: \n");
		List<Card> cCards = Game.getCharCards();
		System.out.println(cardsListToString(cCards) + "\n");
		while(true) {
			Scanner inputReader = new Scanner(System.in);
			String input = inputReader.nextLine();
			if(correctCard(input, cCards)) {
				break;
			}else {
				System.out.println("Please input a valid character.");
			}
		}
		return accusation;
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
				accusation.add(c);
				return true;
			}
		}
		return false;
	}
	
}
