//Authored by Ben Hanson and Matt Edmundson
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Suggestion {
	private static Board board;
	private Player p;
	private String w;
	private Player pp;
	private Room r;
	private RoomCard rc;
	private WeaponCard wc;
	private CharacterCard cc;
	private String charName;
	private List<Card> suggestion;
	private GUITest gui;
	
	public Suggestion(Player p, Room r, String charName) {
		this.p = p;
		this.r = r;
		this.charName = charName;
		suggestion = new ArrayList<Card>();
	}
	
	public void makeSuggestion() {
		if (r == null) {
			  noSuggestionWindow();
		  }else {
			  suggestion.clear();
			  suggestionWindow();
		  }
	}
	
	public static void noSuggestionWindow() {
		JOptionPane.showMessageDialog(null, "Must be in a room to make a suggestion");
	}
	
	public void suggestionWindow() {
		for(Card c : Game.getRoomCards()) {
			if(r.getName().equalsIgnoreCase(c.toString())) {
				suggestion.add(c);
			}
		}
		suggestionWeaponWindow();
	}
	
	
	
	public void suggestionWeaponWindow() {
		JFrame frmCluedoSuggestion = new JFrame();
		frmCluedoSuggestion.setTitle("Cluedo Suggestion");
		frmCluedoSuggestion.setBounds(100, 100, 350, 280);
		frmCluedoSuggestion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCluedoSuggestion.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 300, 50);
		frmCluedoSuggestion.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblPickYourSuggestion = new JLabel(charName + " is currently making a suggestion in the " + r.getName());
		lblPickYourSuggestion.setBounds(10, 0, 300, 44);
		panel.add(lblPickYourSuggestion);

		JLabel lblWeaponSuggestion = new JLabel("Pick a weapon:");
		lblWeaponSuggestion.setBounds(10, 20, 300, 44);
		panel.add(lblWeaponSuggestion);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 50, 312, 170);
		frmCluedoSuggestion.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JRadioButton rdbtnCandlestick = new JRadioButton("Candlestick");
		rdbtnCandlestick.setBounds(18, 23, 126, 23);
		panel_1.add(rdbtnCandlestick);

		JRadioButton rdbtnDagger = new JRadioButton("Dagger");
		rdbtnDagger.setBounds(168, 23, 138, 23);
		panel_1.add(rdbtnDagger);

		JRadioButton rdbtnLeadPipe = new JRadioButton("Lead Pipe");
		rdbtnLeadPipe.setBounds(18, 58, 126, 23);
		panel_1.add(rdbtnLeadPipe);

		JRadioButton rdbtnRevolver = new JRadioButton("Revolver");
		rdbtnRevolver.setBounds(168, 58, 138, 23);
		panel_1.add(rdbtnRevolver);

		JRadioButton rdbtnRope = new JRadioButton("Rope");
		rdbtnRope.setBounds(18, 92, 126, 23);
		panel_1.add(rdbtnRope);

		JRadioButton rdbtnSpanner = new JRadioButton("Spanner");
		rdbtnSpanner.setBounds(168, 92, 138, 23);
		panel_1.add(rdbtnSpanner);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnCandlestick);
		bg.add(rdbtnDagger);
		bg.add(rdbtnLeadPipe);
		bg.add(rdbtnRevolver);
		bg.add(rdbtnRope);
		bg.add(rdbtnSpanner);

		frmCluedoSuggestion.setVisible(true);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(105, 130, 89, 35);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnCandlestick.isSelected()) {
					suggestion.add(WeaponCard.Candlestick);
					w = "c";
					frmCluedoSuggestion.setVisible(false);
					suggestionCharacterWindow();
				}else if(rdbtnDagger.isSelected()) {
					suggestion.add(WeaponCard.Dagger);
					w = "d";
					frmCluedoSuggestion.setVisible(false);
					suggestionCharacterWindow();
				}else if(rdbtnLeadPipe.isSelected()) {
					suggestion.add(WeaponCard.Leadpipe);
					w = "l";
					frmCluedoSuggestion.setVisible(false);
					suggestionCharacterWindow();
				}else if(rdbtnRevolver.isSelected()) {
					suggestion.add(WeaponCard.Revolver);
					w = "r";
					frmCluedoSuggestion.setVisible(false);
					suggestionCharacterWindow();
				}else if(rdbtnRope.isSelected()) {
					suggestion.add(WeaponCard.Rope);
					w = "o";
					frmCluedoSuggestion.setVisible(false);
					suggestionCharacterWindow();
				}else if(rdbtnSpanner.isSelected()) {
					suggestion.add(WeaponCard.Spanner);
					w = "s";
					frmCluedoSuggestion.setVisible(false);
					suggestionCharacterWindow();
				}else {
					JOptionPane.showMessageDialog(frmCluedoSuggestion,"Please select a weapon!");
				}
			}
		});
		

		bg.clearSelection();
		panel_1.add(btnConfirm);
	}
	
	
	public void suggestionCharacterWindow() {
		JFrame frmCluedoSuggestion = new JFrame();
		frmCluedoSuggestion.setTitle("Cluedo Suggestion");
		frmCluedoSuggestion.setBounds(100, 100, 350, 280);
		frmCluedoSuggestion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCluedoSuggestion.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 300, 50);
		frmCluedoSuggestion.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblPickYourSuggestion = new JLabel(charName + " is currently making a suggestion in the " + r.getName());
		lblPickYourSuggestion.setBounds(10, 0, 300, 44);
		panel.add(lblPickYourSuggestion);

		JLabel lblCharacterSuggestion = new JLabel("Pick a character:");
		lblCharacterSuggestion.setBounds(10, 20, 300, 44);
		panel.add(lblCharacterSuggestion);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 50, 312, 170);
		frmCluedoSuggestion.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JRadioButton rdbtnGreen = new JRadioButton("Mr Green");
		rdbtnGreen.setBounds(18, 23, 126, 23);
		panel_1.add(rdbtnGreen);

		JRadioButton rdbtnMustard = new JRadioButton("Colonel Mustard");
		rdbtnMustard.setBounds(168, 23, 138, 23);
		panel_1.add(rdbtnMustard);

		JRadioButton rdbtnPeacock = new JRadioButton("Mrs. Peacock");
		rdbtnPeacock.setBounds(18, 58, 126, 23);
		panel_1.add(rdbtnPeacock);

		JRadioButton rdbtnPlum = new JRadioButton("Professor Plum");
		rdbtnPlum.setBounds(168, 58, 138, 23);
		panel_1.add(rdbtnPlum);

		JRadioButton rdbtnScarlett = new JRadioButton("Miss Scarlett");
		rdbtnScarlett.setBounds(18, 92, 126, 23);
		panel_1.add(rdbtnScarlett);

		JRadioButton rdbtnWhite = new JRadioButton("Mrs White");
		rdbtnWhite.setBounds(168, 92, 138, 23);
		panel_1.add(rdbtnWhite);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnGreen);
		bg.add(rdbtnMustard);
		bg.add(rdbtnPeacock);
		bg.add(rdbtnPlum);
		bg.add(rdbtnScarlett);
		bg.add(rdbtnPlum);

		frmCluedoSuggestion.setVisible(true);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(105, 130, 89, 35);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnGreen.isSelected()) {
					suggestion.add(CharacterCard.Mr_Green);
					cc = CharacterCard.Mr_Green;
					frmCluedoSuggestion.setVisible(false);
					moveToRoom();
					refuteSuggestion();
				}else if(rdbtnMustard.isSelected()) {
					suggestion.add(CharacterCard.Colonel_Mustard);
					cc = CharacterCard.Colonel_Mustard;
					frmCluedoSuggestion.setVisible(false);
					moveToRoom();
					refuteSuggestion();
				}else if(rdbtnPeacock.isSelected()) {
					suggestion.add(CharacterCard.Mrs_Peacock);
					cc = CharacterCard.Mrs_Peacock;
					frmCluedoSuggestion.setVisible(false);
					moveToRoom();
					refuteSuggestion();
				}else if(rdbtnPlum.isSelected()) {
					suggestion.add(CharacterCard.Professor_Plum);
					cc = CharacterCard.Professor_Plum;
					frmCluedoSuggestion.setVisible(false);
					moveToRoom();
					refuteSuggestion();
				}else if(rdbtnScarlett.isSelected()) {
					suggestion.add(CharacterCard.Miss_Scarlett);
					cc = CharacterCard.Miss_Scarlett;
					frmCluedoSuggestion.setVisible(false);
					moveToRoom();
					refuteSuggestion();
				}else if(rdbtnWhite.isSelected()) {
					suggestion.add(CharacterCard.Mrs_White);
					cc = CharacterCard.Mrs_White;
					frmCluedoSuggestion.setVisible(false);
					moveToRoom();
					refuteSuggestion();
				}else {
					JOptionPane.showMessageDialog(frmCluedoSuggestion,"Please select a weapon!");
				}
			}
		});
		

		bg.clearSelection();
		panel_1.add(btnConfirm);
	}

	/*Allows all other players to refute the suggestion the player has given*/
	public void refuteSuggestion() {
		System.out.println("refute Sug");
//		for(Player player : Game.getPlayers()) {
//			if(!player.equals(p)) {
//				System.out.println(player.toString() + ". Refute the suggestion.\n");
//				System.out.println("Either name one of your cards that refutes the suggestion \n"
//						+ "or, if there none, input 'none'.\n");
//				System.out.println(refuteCards(player));
//				while(true) {
//					Scanner inputReader = new Scanner(System.in);
//					String input = inputReader.nextLine();
//					if(input.equalsIgnoreCase("none")){
//						System.out.println("Player " + player.toString() + " has no cards that refute the suggestion.\n");
//						break;
//					}else {
//						boolean found = false;
//						for(Card c : suggestion) {
//							if(input.equalsIgnoreCase(c.toString()) || input.equalsIgnoreCase(c.stringCheck())) {
//								System.out.println("Player " + player.toString() + " refutes the suggestion with card: " +
//										c.toString()+"\n");
//								found = true;
//							}
//						}
//						if(found) break;
//						System.out.println(player.toString() + ". Please input a valid answer.");
//					}
//				}
//				
//			}
//		}
	}
	
	public void moveToRoom() {
		Player corPlay = getCorrectPlayer();
		if(corPlay != null)	Game.movePlayerToRoom(corPlay, r);
		Game.moveWeaponToRoom(Game.getWeapon(w), r);
	}
	
	public Player getCorrectPlayer() {
		if(cc.equals(CharacterCard.Mr_Green)) {
			return Game.getPlayer("G");
		}else if(cc.equals(CharacterCard.Colonel_Mustard)) {
			return Game.getPlayer("M");
		}else if(cc.equals(CharacterCard.Mrs_Peacock)) {
			return Game.getPlayer("P");
		}else if(cc.equals(CharacterCard.Professor_Plum)) {
			return Game.getPlayer("L");
		}else if(cc.equals(CharacterCard.Miss_Scarlett)) {
			return Game.getPlayer("S");
		}else if(cc.equals(CharacterCard.Mrs_White)) {
			return Game.getPlayer("W");
		}else {
			return null;
		}
	}
	
	/*Returns any cards the player has that were in the suggestion as a String*/
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

	/*Takes a list of cards, returns as a String*/
	public String cardsListToString(List<Card> list) {
		String out = "";
		for(Card c : list) {
			out = out + c.toString() + "\n";
		}
		return out;
	}

	/*Checks that an input is a valid card*/
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
