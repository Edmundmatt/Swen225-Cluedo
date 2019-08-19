import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Label;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GUITest {

	private JFrame frame;
	private static ImageIcon diceOne = makeImageIcon("inverted-dice-1.png");
	private static ImageIcon diceTwo = makeImageIcon("inverted-dice-2.png");
	private static ImageIcon diceThree = makeImageIcon("inverted-dice-3.png");
	private static ImageIcon diceFour = makeImageIcon("inverted-dice-4.png");
	private static ImageIcon diceFive = makeImageIcon("inverted-dice-5.png");
	private static ImageIcon diceSix = makeImageIcon("inverted-dice-6.png");


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
		frame.setBounds(100, 100, 450, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		frame.getContentPane().add(menuBar);
		
		JMenuItem mntmFile = new JMenuItem("File");
		menuBar.add(mntmFile);
		
		JMenuItem mntmGame = new JMenuItem("Game");
		menuBar.add(mntmGame);
		
		JPanel footerPanel = new JPanel();
		footerPanel.setBounds(0, 505, 434, -104);
		frame.getContentPane().add(footerPanel);
		
		JPanel boardPanel = new JPanel();
		boardPanel.setBounds(0, 21, 434, 380);
		frame.getContentPane().add(boardPanel);
		
		JButton btnRollDice = new JButton("Roll Dice");
		btnRollDice.setBounds(23, 412, 73, 23);
		frame.getContentPane().add(btnRollDice);
		
		JLabel dice1 = new JLabel();
		dice1.setBounds(10, 446, 40, 40);
		dice1.setIcon(diceOne);
		frame.getContentPane().add(dice1);
		
		JLabel dice2 = new JLabel();
		dice2.setBounds(60, 446, 40, 40);
		dice2.setIcon(diceTwo);
		frame.getContentPane().add(dice2);
		
		JLabel card1 = new JLabel("Card 1");
		card1.setBounds(284, 422, 46, 61);
		frame.getContentPane().add(card1);
		
		JLabel card2 = new JLabel("Card 2");
		card2.setBounds(330, 422, 46, 61);
		frame.getContentPane().add(card2);
		
		JLabel card3 = new JLabel("Card 3");
		card3.setBounds(378, 422, 46, 61);
		frame.getContentPane().add(card3);
	}
	
	/**
	 * Helper method for loading image icons.
	 * @param filename
	 * @return
	 */
	private static ImageIcon makeImageIcon(String filename) {
		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon(filename).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		return imageIcon;
	}
	

}


