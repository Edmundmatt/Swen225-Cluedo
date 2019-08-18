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
              cell.setMinimumSize(new Dimension(15,15));
              boardPanel.add(cell);
          }
      }
      System.out.println(boardPanel.contains(1, 1));
      boardPanel.setMaximumSize(new Dimension(15*cols,15*rows));
      boardPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
      frame.add(boardPanel);
      frame.setSize(500,500);
      frame.setVisible(true);
  }
  
  private ImageIcon getIcon(Cell cell) {
	  if (cell.isWall()) {
		  return new ImageIcon("src/wallCell.png");
	  } else if (cell.getPlayer() != null) {
		  if (cell.getRoom() != null) {
			  return new ImageIcon("src/playerRoomCell.png");
		  } else {
			  return new ImageIcon("src/playerEmptyCell.png");
		  }
	  } else if (cell.getRoom() != null) {
		  return new ImageIcon("src/roomCell.png");
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