import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MyController implements ActionListener{
	
	private MyModel model;
	private MyView view;
	
	public MyController(){
		model = new MyModel();
		view = new MyView();
		view.addButtonListener(this);
		view.addExitListener(this);
		view.addResetListener(this);
		view.setModel(model);
		model.setView(view);
	}
	
	public void actionPerformed(ActionEvent event){
		JButton[][] buttons = view.getButtons();
		int number;
		
		//if a button is clicked get value from user and update view and model
		if(event.getSource() instanceof JButton){
			String value = view.getUserValue();
			
			try{
				number = Integer.parseInt(value);
				for(int i = 0; i<3; i++){
					for(int j = 0; j<3; j++){
						if(event.getSource()==buttons[i][j]){
							view.buttonClicked(i, j, value);
							model.setValue(i,j,number);
							if(view.allClicked()){
								if(model.checkStatus())
									view.gameWon();
								else
									view.gameLost();
							}
						}
							
					}
				}
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null,"Invalid, please enter a number");
			}
			
			
		}
		
		//if exit was pressed update view
		else if(event.getActionCommand().equals("Exit")){
			view.exitClicked();
		}
		
		//if reset was pressed update view
		else if(event.getActionCommand().equals("Reset")){
			view.resetClicked();
			model.reset();
		}
		
		
	}
}
