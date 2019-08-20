import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUITest {

	private JFrame frame;
	private JPanel boardPanel;
	private Game g;
	private static ImageIcon diceOne = makeImageIcon("inverted-dice-1.png");
	private static ImageIcon diceTwo = makeImageIcon("inverted-dice-2.png");
	private static ImageIcon diceThree = makeImageIcon("inverted-dice-3.png");
	private static ImageIcon diceFour = makeImageIcon("inverted-dice-4.png");
	private static ImageIcon diceFive = makeImageIcon("inverted-dice-5.png");
	private static ImageIcon diceSix = makeImageIcon("inverted-dice-6.png");
	
	private static ImageIcon unknown = makeImageIcon("unknown.png");
	
	private static ImageIcon ballroom = makeImageIcon("ballroom.png");
	private static ImageIcon billiardroom = makeImageIcon("billiardroom.png");
	private static ImageIcon conversatory = makeImageIcon("conservatory.png");
	private static ImageIcon diningroom = makeImageIcon("diningroom.png");
	private static ImageIcon hall = makeImageIcon("hall.png");
	private static ImageIcon kitchen = makeImageIcon("kitchen.png");
	private static ImageIcon library = makeImageIcon("library.png");
	private static ImageIcon lounge = makeImageIcon("lounge.png");
	private static ImageIcon study = makeImageIcon("study.png");

	private static ImageIcon candlestick = makeImageIcon("candlestick.png");
	private static ImageIcon dagger = makeImageIcon("dagger.png");
	private static ImageIcon leadpipe = makeImageIcon("leadpipe.png");
	private static ImageIcon revolver = makeImageIcon("revolver.png");
	private static ImageIcon rope = makeImageIcon("rope.png");
	private static ImageIcon spanner = makeImageIcon("spanner.png");
	
	private static ImageIcon green = makeImageIcon("green.png");
	private static ImageIcon mustard = makeImageIcon("mustard.png");
	private static ImageIcon peacock = makeImageIcon("peacock.png");
	private static ImageIcon plum = makeImageIcon("plum.png");
	private static ImageIcon scarlett = makeImageIcon("scarlett.png");
	private static ImageIcon white = makeImageIcon("white.png");
	
	private JLabel dice1;
	private JLabel dice2;
	private JLabel instructions;
	private JLabel card1;
	private JLabel card2;
	private JLabel card3;
	
	//Declaring these buttons as they are enabled/disabled during the game
	private JButton moveNorth;
	private JButton moveSouth;
	private JButton moveEast;
	private JButton moveWest;
	private JButton btnRollDice;
	
	private int playerNum = 1; //Used in character selection

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUITest window = new GUITest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUITest() {
		g = new Game();
		int playerCount = 0;
		while(true) {
			String input = JOptionPane.showInputDialog("How many players? (3-6)");
			if (input.chars().allMatch( Character::isDigit)) {
				playerCount = Integer.parseInt(input);
				if (playerCount >= 3 && playerCount <= 6) {
					break;
				}
			}
		}
		g.initialise(playerCount);
		characterSelectInit();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Cluedo");
		frame.setBounds(100, 100, 630, 620);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent we)
		    { 
		        String ObjButtons[] = {"Yes","No"};
		        int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?","Cluedo",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
		            System.exit(0);
		        }
		    }
		});
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 593, 21);
		frame.getContentPane().add(menuBar);
		
		JMenuItem mntmFile = new JMenuItem("File");
		menuBar.add(mntmFile);
		
		JMenuItem mntmGame = new JMenuItem("Game");
		menuBar.add(mntmGame);
		
		JPanel footerPanel = new JPanel();
		footerPanel.setBounds(0, 505, 434, -104);
		frame.getContentPane().add(footerPanel);
		  
		
		boardPanel = new JPanel();
		boardPanel.setBounds(0, 21, 474, 420);
		frame.getContentPane().add(boardPanel);
		drawBoard();
		frame.getContentPane().add(boardPanel);


		btnRollDice = new JButton("Roll Dice");
		btnRollDice.setBounds(166, 462, 113, 30);
		btnRollDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] list = Game.performDice();
				dice1.setIcon(scaleImage(getCorrectDiceIcon(list[0]), dice1.getWidth(), dice1.getHeight()));
				dice2.setIcon(scaleImage(getCorrectDiceIcon(list[1]), dice2.getWidth(), dice2.getHeight()));
				enableMovement(); //Enables movement as player has rolled dice
				btnRollDice.setEnabled(false); //Disables dice button as player can't roll dice again this turn
				updateMovesLeft(); //Writes moves left to instruction panel
			}
		});
		frame.getContentPane().add(btnRollDice);
		
		dice1 = new JLabel();
		dice1.setBounds(155, 508, 55, 55);
		dice1.setIcon(scaleImage(diceOne, dice1.getWidth(), dice1.getHeight()));
		frame.getContentPane().add(dice1);
		
		dice2 = new JLabel();
		dice2.setBounds(235, 508, 55, 55);
		dice2.setIcon(scaleImage(diceOne, dice2.getWidth(), dice2.getHeight()));
		frame.getContentPane().add(dice2);
		
		card1 = new JLabel("Card 1");
		card1.setBounds(493, 30, 100, 153);
		card2 = new JLabel("Card 2");
		card2.setBounds(493, 196, 100, 153);
		card3 = new JLabel("Card 3");
		card3.setBounds(493, 358, 100, 153);
		
		updateCardDisplays();
		
		frame.getContentPane().add(card1);
		frame.getContentPane().add(card2);
		frame.getContentPane().add(card3);
		
		JButton btnEndTurn = new JButton("End Turn");
		btnEndTurn.setBounds(10, 462, 113, 30);
		btnEndTurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.nextPlayerTurn();
				updateCardDisplays();
				setInstructions(g.getPlayers().get(g.getPlayerTurn()-1).getCharacterName() + " please roll the dice!");
				disableMovement();
				btnRollDice.setEnabled(true);
			}
		});
		frame.getContentPane().add(btnEndTurn);
		
		JButton btnMakeSuggestion = new JButton("Make Suggestion");
		btnMakeSuggestion.setBounds(10, 503, 113, 30);
		btnMakeSuggestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Suggestion check");
			}
		});
		frame.getContentPane().add(btnMakeSuggestion);
		
		JButton btnMakeAccusation = new JButton("Make Accusation");
		btnMakeAccusation.setBounds(10, 544, 113, 30);
		btnMakeAccusation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Accusation check");
			}
		});
		frame.getContentPane().add(btnMakeAccusation);
		
		//Movement buttons
		moveNorth = new JButton(new ImageIcon("src/north.png"));
		moveNorth.setBounds(360, 462, 45, 45);
		moveNorth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movePlayer("north");
				drawBoard();
			}
		});
		frame.getContentPane().add(moveNorth);
		
		moveSouth = new JButton(new ImageIcon("src/south.png"));
		moveSouth.setBounds(360, 510, 45, 45);
		moveSouth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movePlayer("south");
				drawBoard();
			}
		});
		frame.getContentPane().add(moveSouth);
		
		moveEast = new JButton(new ImageIcon("src/east.png"));
		moveEast.setBounds(408, 510, 45, 45);
		moveEast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movePlayer("east");
				drawBoard();
			}
		});
		frame.getContentPane().add(moveEast);
		
		moveWest = new JButton(new ImageIcon("src/west.png"));
		moveWest.setBounds(312, 510, 45, 45);
		moveWest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movePlayer("west");
				drawBoard();
			}
		});
		frame.getContentPane().add(moveWest);
		
		//Sets initial instructions
		instructions = new JLabel(g.getPlayers().get(g.getPlayerTurn()-1).getCharacterName() + " please roll the dice!");
		instructions.setBounds(15, 420, 400, 50);
		frame.getContentPane().add(instructions);
		
		//Disables movement as first player must roll dice
		disableMovement();
	}

	/*Creates character selection window and allows players to select their preferred cluedo character*/
	private void characterSelectInit() {
		frame = new JFrame("Cluedo Character Select");
		frame.setBounds(100, 100, 350, 280);
		frame.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent we)
		    { 
		        String ObjButtons[] = {"Yes","No"};
		        int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?","Cluedo",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
		            System.exit(0);
		        }
		    }
		});
		frame.getContentPane().setLayout(null);
		
		//Initialises panel for character selection
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 300, 44);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		//Initialises instruction label
		JLabel lblCharacterSelection = new JLabel("Player 1 please select your character:");
		lblCharacterSelection.setBounds(50, 0, 300, 44);
		panel.add(lblCharacterSelection);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 50, 312, 170);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		//Initialises radio buttons for character selection
		JRadioButton rdbtnMrGreen = new JRadioButton("Mr. Green");
		rdbtnMrGreen.setBounds(18, 23, 126, 23);
		panel_1.add(rdbtnMrGreen);
		
		JRadioButton rdbtnColonelMustard = new JRadioButton("Colonel Mustard");
		rdbtnColonelMustard.setBounds(168, 23, 138, 23);
		panel_1.add(rdbtnColonelMustard);
		
		JRadioButton rdbtnMrsPeacock = new JRadioButton("Mrs. Peacock");
		rdbtnMrsPeacock.setBounds(18, 58, 126, 23);
		panel_1.add(rdbtnMrsPeacock);
		
		JRadioButton rdbtnProfessorPlum = new JRadioButton("Professor Plum");
		rdbtnProfessorPlum.setBounds(168, 58, 138, 23);
		panel_1.add(rdbtnProfessorPlum);
		
		JRadioButton rdbtnMissScarlett = new JRadioButton("Miss Scarlett");
		rdbtnMissScarlett.setBounds(18, 92, 126, 23);
		panel_1.add(rdbtnMissScarlett);
		
		JRadioButton rdbtnMrsWhite = new JRadioButton("Mrs. White");
		rdbtnMrsWhite.setBounds(168, 92, 138, 23);
		panel_1.add(rdbtnMrsWhite);
		
		//Add buttons to group
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnMrGreen);
		bg.add(rdbtnColonelMustard);
		bg.add(rdbtnMrsPeacock);
		bg.add(rdbtnProfessorPlum);
		bg.add(rdbtnMissScarlett);
		bg.add(rdbtnMrsWhite);
		
		//Creates confirm button
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(105, 130, 89, 35);
		btnConfirm.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) { //If the confirm button is pressed
				Player p = g.getPlayers().get(playerNum-1);	//Retrieve current player
				
				if (rdbtnMrGreen.isSelected()) { //If player chose Mr Green
						p.setName("G"); //Set the player's abbreviated name to Mr Green's
						rdbtnMrGreen.setEnabled(false); //Disable radio button
						playerNum++; //Move to next player
						lblCharacterSelection.setText("Player " + playerNum + " please select your character:"); //Update instructional box
					} else if (rdbtnColonelMustard.isSelected()) {
						p.setName("M");
						rdbtnColonelMustard.setEnabled(false);
						playerNum++;
						lblCharacterSelection.setText("Player " + playerNum + " please select your character:");
					} else if (rdbtnMrsPeacock.isSelected()) {
						p.setName("P");
						rdbtnMrsPeacock.setEnabled(false);
						playerNum++;
						lblCharacterSelection.setText("Player " + playerNum + " please select your character:");
					} else if (rdbtnProfessorPlum.isSelected()) {
						p.setName("L");
						rdbtnProfessorPlum.setEnabled(false);
						playerNum++;
						lblCharacterSelection.setText("Player " + playerNum + " please select your character:");
					} else if (rdbtnMissScarlett.isSelected()) {
						p.setName("S");
						rdbtnMissScarlett.setEnabled(false);
						playerNum++;
						lblCharacterSelection.setText("Player " + playerNum + " please select your character:");
					} else if (rdbtnMrsWhite.isSelected()) {
						p.setName("W");
						rdbtnMrsWhite.setEnabled(false);
						playerNum++;
						lblCharacterSelection.setText("Player " + playerNum + " please select your character:");
					} else {
						JOptionPane.showMessageDialog(frame,"Please select a character!"); //If no character was chosen, prompt the user to choose
					}
				
				bg.clearSelection(); //Clears radio button selections
				
				if (playerNum > g.getPlayers().size()) { //If all players have chosen their desired character
					frame.setVisible(false); //Close character selection window
					initialize(); //Initialise main GUI
				}
			}
		});
		panel_1.add(btnConfirm);
	}
	
	/*Sets instruction label on UI to provided string*/
	public void setInstructions(String content) {
		instructions.setText(content);
	}
	
	
	/*Updates number of moves left and displays room that player current occupies*/
	public void updateMovesLeft() {
		if(g.playerInRoom()) {
			setInstructions(g.getPlayers().get(g.getPlayerTurn()-1).getCharacterName() + " - you can move freely within the " + Game.getBoard().findPlayer(Game.getCurrentPlayer()).getRoom().getName() + ".");
		}else {
			setInstructions(g.getPlayers().get(g.getPlayerTurn()-1).getCharacterName() + " - you have " + g.getMovesLeft() + " turns left.");
		}
	}
	
	public void updateCardDisplays() {
		//Return the correct image icons for the current player
		Player currentPlayer = Game.getCurrentPlayer();
		ImageIcon firstCard = getCorrectCard(currentPlayer.getPlayersCards().get(0));
		ImageIcon scndCard = getCorrectCard(currentPlayer.getPlayersCards().get(1));
		ImageIcon thirdCard = getCorrectCard(currentPlayer.getPlayersCards().get(2));

		card1.setIcon(scaleImage(firstCard, card1.getWidth(), card1.getHeight()));
		card2.setIcon(scaleImage(scndCard, card2.getWidth(), card2.getHeight()));
		card3.setIcon(scaleImage(thirdCard, card3.getWidth(), card3.getHeight()));
	}
	
	/*Disables movement controls*/
	private void disableMovement() {
		moveNorth.setEnabled(false);
		moveSouth.setEnabled(false);
		moveEast.setEnabled(false);
		moveWest.setEnabled(false);
	}
	
	/*Enables movement controls*/
	private void enableMovement() {
		moveNorth.setEnabled(true);
		moveSouth.setEnabled(true);
		moveEast.setEnabled(true);
		moveWest.setEnabled(true);
	}
	
	/*Moves the player, and rolls over to the next turn if player is out of moves*/
	private void movePlayer(String direction) {
		if (g.getMovesLeft() > 1) {
			g.movePlayer(direction);
			updateMovesLeft();
		} else {
			//Begins next players turn and prompts them to roll dice
			g.nextPlayerTurn();
			disableMovement(); 
			btnRollDice.setEnabled(true);
			setInstructions(g.getPlayers().get(g.getPlayerTurn()-1).getCharacterName() + " please roll the dice!");
			updateCardDisplays();
		}
	}
	
	  /*Retrieves board from game class and draws in GUI, called to update board when players move*/
	  public void drawBoard() {
		  boardPanel.removeAll(); //Clears old version panel before drawing 
		  int cols = 28;
		  int rows = 25;
		  Cell[][] board = g.getBoard().retrieveBoard(); //Retrieves game's current board layout
		  boardPanel.setLayout(new GridLayout(rows, cols)); //Constructs gridlayout to board dimensions
		  for (int row = 0 ; row < rows; row++) { //Iterates through rows/columns of board, drawing each cell individually
		    	for (int col = 0; col < cols; col++) {
	              JLabel cell = new JLabel(getIcon(board[row][col]),JLabel.CENTER); //Calls getIcon method to decide which image to use for this cell
	              cell.setMinimumSize(new Dimension(25,25));
	              Border border = BorderFactory.createLineBorder(Color.BLACK, 1); //Black border creates grid effect in board
	              cell.setBorder(border);
	              boardPanel.add(cell);
	          }
	      }
	      boardPanel.setMaximumSize(new Dimension(25*cols,25*rows));
	      frame.setVisible(true);
	  }
	  
	  /*Retrieves the appropriate imageIcon when drawing the board*/
	  private ImageIcon getIcon(Cell cell) {
		  if (cell.isWall()) {
			  return new ImageIcon("src/wallCell.png");
		  } else if (cell.getPlayer() != null) { //If cell contains player
			  if (cell.getRoom() != null) { //If cell is in room
				  if (cell.getPlayer().toString().equals("S")) {
					  return new ImageIcon("src/missScarlettRoomCell.png");
				  } else if (cell.getPlayer().toString().equals("M")) {
					  return new ImageIcon("src/colonelMustardRoomCell.png");
				  } else if (cell.getPlayer().toString().equals("W")) {
					  return new ImageIcon("src/mrsWhiteRoomCell.png");
				  } else if (cell.getPlayer().toString().equals("G")) {
					  return new ImageIcon("src/mrGreenRoomCell.png");
				  } else if (cell.getPlayer().toString().equals("P")) {
					  return new ImageIcon("src/mrsPeacockRoomCell.png");
				  } else {
					  return new ImageIcon("src/professorPlumRoomCell.png");
				  }
			  } else {
				  if (cell.getPlayer().toString().equals("S")) {
					  return new ImageIcon("src/missScarlettEmptyCell.png");
				  } else if (cell.getPlayer().toString().equals("M")) {
					  return new ImageIcon("src/colonelMustardEmptyCell.png");
				  } else if (cell.getPlayer().toString().equals("W")) {
					  return new ImageIcon("src/mrsWhiteEmptyCell.png");
				  } else if (cell.getPlayer().toString().equals("G")) {
					  return new ImageIcon("src/mrGreenEmptyCell.png");
				  } else if (cell.getPlayer().toString().equals("P")) {
					  return new ImageIcon("src/mrsPeacockEmptyCell.png");
				  } else {
					  return new ImageIcon("src/professorPlumEmptyCell.png");
				  }
			  }
		  } else if (cell.getRoom() != null) {
			  if (cell.getWeapon() != null) {
				  if (cell.getWeapon().toString().equals("l")) {
					  return new ImageIcon("src/leadpipeCell.png");
				  } else if (cell.getWeapon().toString().equals("c")){
					  return new ImageIcon("src/candlestickCell.png");
				  } else if (cell.getWeapon().toString().equals("d")){
					  return new ImageIcon("src/daggerCell.png");
				  } else if (cell.getWeapon().toString().equals("r")){
					  return new ImageIcon("src/revolverCell.png");
				  } else if (cell.getWeapon().toString().equals("s")){
					  return new ImageIcon("src/spannerCell.png");
				  } else {
					  return new ImageIcon("src/ropeCell.png");
				  }
			  } else {
			  return new ImageIcon("src/roomCell.png");
			  }
		  } else {
			  return new ImageIcon("src/emptyCell.png");
		  }
	  }
	
	/**
	 * Helper method for loading image icons.
	 * @param filename
	 * @return
	 */
	private static ImageIcon makeImageIcon(String filename) {
		// using the URL means the image loads when stored
		// in a jar or expanded into individual files.
		java.net.URL imageURL = GUITest.class.getResource(filename);

		ImageIcon icon = null;
		if (imageURL != null) {
			icon = new ImageIcon(imageURL);
		}
		return icon;
	}
	
	private static ImageIcon scaleImage(ImageIcon image, int width, int height) {
		ImageIcon imageIcon = 
				new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		return imageIcon;
	}
	
	
	private static ImageIcon getCorrectDiceIcon(int dice) {
		if(dice == 1) {
			return diceOne;
		}else if(dice == 2) {
			return diceTwo;
		}else if(dice == 3) {
			return diceThree;
		}else if(dice == 4) {
			return diceFour;
		}else if(dice == 5) {
			return diceFive;
		}else {
			return diceSix;
		}
	}
	
	private static ImageIcon getCorrectCard(Card card) {
		if(card.getClass().equals(RoomCard.class)) {
			if(card.equals(RoomCard.Ball_Room)) {
				return ballroom;
			}else if(card.equals(RoomCard.Billiard_Room)) {
				return billiardroom;
			}else if(card.equals(RoomCard.Conversatory)) {
				return conversatory;
			}else if(card.equals(RoomCard.Dining_Room)) {
				return diningroom;
			}else if(card.equals(RoomCard.Hall)) {
				return hall;
			}else if(card.equals(RoomCard.Kitchen)) {
				return kitchen;
			}else if(card.equals(RoomCard.Library)) {
				return library;
			}else if(card.equals(RoomCard.Lounge)) {
				return lounge;
			}else if(card.equals(RoomCard.Study)) {
				return study;
			}
			else {
				return unknown;
			}
		}else if(card.getClass().equals(WeaponCard.class)) {
			if(card.equals(WeaponCard.Candlestick)) {
				return candlestick;
			}else if(card.equals(WeaponCard.Dagger)) {
				return dagger;
			}else if(card.equals(WeaponCard.Leadpipe)) {
				return leadpipe;
			}else if(card.equals(WeaponCard.Revolver)) {
				return revolver;
			}else if(card.equals(WeaponCard.Rope)) {
				return rope;
			}else if(card.equals(WeaponCard.Spanner)) {
				return spanner;
			}
			else {
				return unknown;
			}
		}else if(card.getClass().equals(CharacterCard.class)) {
			if(card.equals(CharacterCard.Colonel_Mustard)) {
				return mustard;
			}else if(card.equals(CharacterCard.Miss_Scarlett)) {
				return scarlett;
			}else if(card.equals(CharacterCard.Mr_Green)) {
				return green;
			}else if(card.equals(CharacterCard.Mrs_Peacock)) {
				return peacock;
			}else if(card.equals(CharacterCard.Mrs_White)) {
				return white;
			}else if(card.equals(CharacterCard.Professor_Plum)) {
				return plum;
			}else {
				return unknown;
			}
		}
		else {
			return unknown;
		}
	}

}