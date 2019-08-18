import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class GraphicsInterface extends JFrame implements WindowListener{
	
	private JPanel menuBar;
	private JLabel[][] board;
	private JPanel footerBar;
	
	public GraphicsInterface(){
		
	}
	
	public void makeMenuBar() {
		
	}
	
	public void makeFooterBar() {
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// Ask the user to confirm they wanted to do this
		int r = JOptionPane.showConfirmDialog(this,
				new JLabel("Exit Cluedo?"), "Confirm Exit",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);

		if (r == JOptionPane.YES_OPTION)
			System.exit(0);

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new GraphicsInterface();
	}

}
