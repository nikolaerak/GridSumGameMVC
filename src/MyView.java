import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class MyView extends JFrame {

	private JButton[][] buttonGrid;
	private JMenuBar bar;
	private JMenu menu;
	private JMenuItem reset;
	private JMenuItem exit;
	private MyModel model;
	
	public MyView(){
		
		super("Sum Game");
		buttonGrid = new JButton[3][3];
		this.setLayout(new GridLayout(3,3));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(1000, 1000);
		
		//add buttons to frame
		for(int i = 0; i<3; i++){
			for(int j = 0; j<3; j++){
				buttonGrid[i][j] = new JButton("");
				add(buttonGrid[i][j]);
			}
		}
		
		//add menu bar and menu items
		bar = new JMenuBar();
		setJMenuBar(bar);
		menu = new JMenu("File");
		bar.add(menu);
		
		//Setup for reset
		reset = new JMenuItem("Reset");
		menu.add(reset);
				
				
		//Setup for exit
		exit = new JMenuItem("Exit");
		menu.add(exit);
		
		this.setVisible(true);
	}
	
	//add listener for reset menu item
	public void addResetListener(ActionListener actionListener){
		reset.addActionListener(actionListener);
	}
	
	//add listener for exit menu item
	public void addExitListener(ActionListener actionListener){
		exit.addActionListener(actionListener);
	}
	
	//add listener for all buttons
	public void addButtonListener(ActionListener actionListener){
		for(int i = 0; i<3; i++){
			for(int j = 0; j<3; j++){
				buttonGrid[i][j].addActionListener(actionListener);
			}
		}
	}
	
	//set the model
	public void setModel(MyModel model){
		this.model = model;
	}
	
	//update button gui
	public void buttonClicked(int row, int col, String number){
		buttonGrid[row][col].setText(number);
		buttonGrid[row][col].setFont(new Font("Times New Roman",Font.PLAIN,200));
		buttonGrid[row][col].setEnabled(false);
	}
	
	//exit gui
	public void exitClicked(){
		System.exit(0);
	}
	
	//reset the gui
	public void resetClicked(){
		for(int i = 0; i<3; i++){
			for(int j = 0; j<3; j++){
				buttonGrid[i][j].setText("");
				buttonGrid[i][j].setEnabled(true);
			}
		}
	}
	
	//get the buttons
	public JButton[][] getButtons(){
		return buttonGrid;
	}
	
	//ask user for value
	public String getUserValue(){
		return JOptionPane.showInputDialog("Enter a number");
	}
	
	//message for win
	public void gameWon(){
		JOptionPane.showMessageDialog(null, "You win!");
	}
	
	//message for loss
	public void gameLost(){
		JOptionPane.showMessageDialog(null, "You Lost!");
	}
	
	//check if all gui buttons clicked
	public boolean allClicked(){
		for(int i = 0; i<3; i++){
			for(int j = 0; j<3; j++){
				if(buttonGrid[i][j].isEnabled() == true)
					return false;
			}
		}
		return true;
	}
	
	
}
