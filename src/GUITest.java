import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUITest {

	private JFrame frame;
	private JPanel boardPanel;
	private static ImageIcon diceOne = makeImageIcon("inverted-dice-1.png");
	private static ImageIcon diceTwo = makeImageIcon("inverted-dice-2.png");
	private static ImageIcon diceThree = makeImageIcon("inverted-dice-3.png");
	private static ImageIcon diceFour = makeImageIcon("inverted-dice-4.png");
	private static ImageIcon diceFive = makeImageIcon("inverted-dice-5.png");
	private static ImageIcon diceSix = makeImageIcon("inverted-dice-6.png");
	
	private static ImageIcon unknown = makeImageIcon("unknown.png");
	
	private static ImageIcon ballroom = makeImageIcon("ballroom.png");
	private static ImageIcon billiardroom = makeImageIcon("billiardroom.png");
	private static ImageIcon conversatory = makeImageIcon("conversatory.png");
	private static ImageIcon diningroom = makeImageIcon("diningroom.png");
	private static ImageIcon kitchen = makeImageIcon("kitchen.png");
	private static ImageIcon library = makeImageIcon("library.png");
	private static ImageIcon lounge = makeImageIcon("lounge.png");
	private static ImageIcon study = makeImageIcon("study.png");

	private static ImageIcon candlestick = makeImageIcon("candlestick.png");
	private static ImageIcon dagger = makeImageIcon("dagger.png");
	private static ImageIcon leadpipe = makeImageIcon("leadpipe.png");
	private static ImageIcon revolver = makeImageIcon("revolver.png");
	private static ImageIcon rope = makeImageIcon("rope.png");
	
	private static ImageIcon green = makeImageIcon("green.png");
	private static ImageIcon mustard = makeImageIcon("mustard.png");
	private static ImageIcon peacock = makeImageIcon("peacock.png");
	private static ImageIcon plum = makeImageIcon("plum.png");
	private static ImageIcon scarlett = makeImageIcon("scarlett.png");
	private static ImageIcon white = makeImageIcon("white.png");
	
	
	
	private JLabel dice1;
	private JLabel dice2;


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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 609, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 593, 21);
		frame.getContentPane().add(menuBar);
		
		JMenuItem mntmFile = new JMenuItem("File");
		menuBar.add(mntmFile);
		
		JMenuItem mntmGame = new JMenuItem("Game");
		menuBar.add(mntmGame);
//		
		JPanel footerPanel = new JPanel();
		footerPanel.setBounds(0, 505, 434, -104);
		frame.getContentPane().add(footerPanel);
		
//		frame.getContentPane().setLayout(new BorderLayout());
		  
		
		boardPanel = new JPanel();
		boardPanel.setBounds(0, 21, 434, 380);
		boardPanel.setBackground(Color.red);
		frame.getContentPane().add(boardPanel);
		Game g = new Game();
		g.initialise(6);
		drawBoard(g.getBoard().retrieveBoard(),28,25);
		frame.getContentPane().add(boardPanel);


		JButton btnRollDice = new JButton("Roll Dice");
		btnRollDice.setBounds(166, 412, 113, 30);
		frame.getContentPane().add(btnRollDice);
		
		dice1 = new JLabel();
		dice1.setBounds(155, 458, 55, 55);
		dice1.setIcon(scaleImage(diceOne, dice1.getWidth(), dice1.getHeight()));
		frame.getContentPane().add(dice1);
		
		dice2 = new JLabel();
		dice2.setBounds(235, 458, 55, 55);
		dice2.setIcon(scaleImage(diceOne, dice2.getWidth(), dice2.getHeight()));
		frame.getContentPane().add(dice2);
		
		JLabel card1 = new JLabel("Card 1");
		card1.setBounds(463, 30, 100, 153);
		card1.setIcon(scaleImage(unknown, card1.getWidth(), card1.getHeight()));
		frame.getContentPane().add(card1);
		
		JLabel card2 = new JLabel("Card 2");
		card2.setBounds(463, 195, 100, 153);
		card2.setIcon(scaleImage(unknown, card2.getWidth(), card2.getHeight()));
		frame.getContentPane().add(card2);
		
		JLabel card3 = new JLabel("Card 3");
		card3.setBounds(463, 358, 100, 153);
		card3.setIcon(scaleImage(unknown, card3.getWidth(), card3.getHeight()));
		frame.getContentPane().add(card3);
		
		JButton btnEndTurn = new JButton("End Turn");
		btnEndTurn.setBounds(10, 412, 113, 30);
		frame.getContentPane().add(btnEndTurn);
		
		JButton btnMakeSuggestion = new JButton("Make Suggestion");
		btnMakeSuggestion.setBounds(10, 453, 113, 30);
		frame.getContentPane().add(btnMakeSuggestion);
		
		JButton btnMakeAccusation = new JButton("Make Accusation");
		btnMakeAccusation.setBounds(10, 494, 113, 30);
		frame.getContentPane().add(btnMakeAccusation);
	}
	
	
	  public void drawBoard(Cell[][] board, int cols, int rows) {
		  boardPanel.setLayout(new GridLayout(rows, cols));

		  for (int row = 0 ; row < 25; row++) {
		    	for (int col = 0; col < 28; col++) {
	              JLabel cell = new JLabel(getIcon(board[row][col]),JLabel.CENTER);
	              cell.setMinimumSize(new Dimension(20,20));
	              Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	              cell.setBorder(border);
	              boardPanel.add(cell);
	          }
	      }
	      boardPanel.setMaximumSize(new Dimension(20*cols,20*rows));
	      frame.setSize(575,575);
	      frame.setVisible(true);
	  }
	  
	  
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
}


