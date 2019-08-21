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

public class Accusation {
	private static Board board;
	private Player p;
	private Room r;
	private String charName;
	private List<Card> accusation;
	
	public Accusation(Player p, Room r, String charName) {
		this.p = p;
		this.r = r;
		this.charName = charName;
		accusation = new ArrayList<Card>();
	}
	
	/*Allows the player to make a final accusation for solution cards. Returns a List of Cards to be compared to the solution
	 * cards.*/
	
//	public List<Card> makeAccusation() {
//		accusation.clear();
//		System.out.println("Player " + p.toString() + " you are making a final accusation.\n");
//		//Room
//		System.out.println("Pick a room\n");
//		List<Card> rCards = Game.getRoomCards();
//		System.out.println(cardsListToString(rCards) + "\n");
//		while(true) {
//			Scanner inputReader = new Scanner(System.in);
//			String input = inputReader.nextLine();
//			if(correctCard(input, rCards)) {
//				break;
//			}else {
//				System.out.println("Please input a valid room.");
//			}
//		}
//		
//		//Weapon
//		System.out.println("Pick a weapon: \n");
//		List<Card> wCards = Game.getWeapCards();
//		System.out.println(cardsListToString(wCards) + "\n");
//		while(true){
//			Scanner inputReader = new Scanner(System.in);
//			String input = inputReader.nextLine();
//			if(correctCard(input, wCards)) {
//				break;
//			}else {
//				System.out.println("Please input a valid weapon.");
//			}
//		}
//
//		//Character
//		System.out.println("Pick a character: \n");
//		List<Card> cCards = Game.getCharCards();
//		System.out.println(cardsListToString(cCards) + "\n");
//		while(true) {
//			Scanner inputReader = new Scanner(System.in);
//			String input = inputReader.nextLine();
//			if(correctCard(input, cCards)) {
//				break;
//			}else {
//				System.out.println("Please input a valid character.");
//			}
//		}
//		return accusation;
//	}
	
	public void makeAccusation(){
		accusation.clear();
		accuseRoom();
	}
	
	public void accuseRoom() {
		accuseWeap();
	}
	
	public void accuseWeap() {
		JFrame frmCluedoSuggestion = new JFrame();
		frmCluedoSuggestion.setTitle("Cluedo Accusation");
		frmCluedoSuggestion.setBounds(100, 100, 350, 280);
		frmCluedoSuggestion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCluedoSuggestion.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 300, 50);
		frmCluedoSuggestion.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblPickYourSuggestion = new JLabel(charName + " is currently making an accusation");
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
					accusation.add(WeaponCard.Candlestick);
					frmCluedoSuggestion.setVisible(false);
					accuseChar();
				}else if(rdbtnDagger.isSelected()) {
					accusation.add(WeaponCard.Dagger);
					frmCluedoSuggestion.setVisible(false);
					accuseChar();
				}else if(rdbtnLeadPipe.isSelected()) {
					accusation.add(WeaponCard.Leadpipe);
					frmCluedoSuggestion.setVisible(false);
					accuseChar();
				}else if(rdbtnRevolver.isSelected()) {
					accusation.add(WeaponCard.Revolver);
					frmCluedoSuggestion.setVisible(false);
					accuseChar();
				}else if(rdbtnRope.isSelected()) {
					accusation.add(WeaponCard.Rope);
					frmCluedoSuggestion.setVisible(false);
					accuseChar();
				}else if(rdbtnSpanner.isSelected()) {
					accusation.add(WeaponCard.Spanner);
					frmCluedoSuggestion.setVisible(false);
					accuseChar();
				}else {
					JOptionPane.showMessageDialog(frmCluedoSuggestion,"Please select a weapon!");
				}
			}
		});
		

		bg.clearSelection();
		panel_1.add(btnConfirm);
	}
	
	public void accuseChar() {
		JFrame frmCluedoSuggestion = new JFrame();
		frmCluedoSuggestion.setTitle("Cluedo Accusation");
		frmCluedoSuggestion.setBounds(100, 100, 350, 280);
		frmCluedoSuggestion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCluedoSuggestion.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 300, 50);
		frmCluedoSuggestion.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblPickYourSuggestion = new JLabel(charName + " is currently making an accusation");
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
					accusation.add(CharacterCard.Mr_Green);
					frmCluedoSuggestion.setVisible(false);
				}else if(rdbtnMustard.isSelected()) {
					accusation.add(CharacterCard.Colonel_Mustard);
					frmCluedoSuggestion.setVisible(false);
				}else if(rdbtnPeacock.isSelected()) {
					accusation.add(CharacterCard.Mrs_Peacock);
					frmCluedoSuggestion.setVisible(false);
				}else if(rdbtnPlum.isSelected()) {
					accusation.add(CharacterCard.Professor_Plum);
					frmCluedoSuggestion.setVisible(false);
				}else if(rdbtnScarlett.isSelected()) {
					accusation.add(CharacterCard.Miss_Scarlett);
					frmCluedoSuggestion.setVisible(false);
				}else if(rdbtnWhite.isSelected()) {
					accusation.add(CharacterCard.Mrs_White);
					frmCluedoSuggestion.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(frmCluedoSuggestion,"Please select a weapon!");
				}
			}
		});
		

		bg.clearSelection();
		panel_1.add(btnConfirm);
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
