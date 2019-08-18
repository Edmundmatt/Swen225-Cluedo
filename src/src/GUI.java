//Authored by Ben Hanson and Matt Edmundson
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// line 61 "model.ump"
// line 136 "model.ump"
public class GUI extends Application
{
	private JFrame frame;
	private JPanel boardPanel;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GUI(){
	  frame = new JFrame("Cluedo");
	  frame.pack();
	  initialiseGUI();
	  drawBoard(Game.getBoard().retrieveBoard(),28,25);
  }
  
  private void initialiseGUI() {
	  frame.setLayout(new BorderLayout());
	  frame.setVisible(true);
  }
  
  public void drawBoard(Cell[][] board, int cols, int rows) {
	  Board textBoard = new Board();
	  textBoard.buildBoard();
	  boardPanel = new JPanel(new GridLayout(rows, cols));
	  
	  for (int row = 0 ; row < 25; row++) {
	    	for (int col = 0; col < 28; col++) {
              JLabel cell = new JLabel(getIcon(board[row][col]),JLabel.CENTER);
              cell.setMinimumSize(new Dimension(20,20));
              boardPanel.add(cell);
          }
      }
      boardPanel.setMaximumSize(new Dimension(20*cols,20*rows));
      boardPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
      frame.add(boardPanel);
      frame.setSize(600,600);
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
  
 


  public String toString()
  {
    return super.toString();
  }

@Override
public void start(Stage primaryStage) throws Exception {
	
}
}