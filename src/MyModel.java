
public class MyModel {
	
	public static final int SIZE = 3;
	private MyView view;
	private int grid[][];
	
	public MyModel(){
		grid = new int[SIZE][SIZE];
	}
	
	//set the view for model
	public void setView(MyView view){
		this.view = view;
	}
	
	//set value of 2d array
	public void setValue(int i , int j, int value){
		grid[i][j] = value;
	}
	
	//reset 2d array
	public void reset(){
		for(int i = 0; i<SIZE; i++){
			for(int j=0; j<SIZE; j++){
				grid[i][j] = 0;
			}
		}
	}
	
	//get sum of rows
	public int getRowSum(int row){
		return(grid[row][0] + grid[row][1] + grid[row][2]);
	}
	
	//get sum of columns
	public int getColSum(int col){
		return(grid[0][col] + grid[1][col] + grid[2][col]);
	}

	//check the status of the game
	public boolean checkStatus(){
		if(getRowSum(0) == getRowSum(1) &&  getRowSum(0) == getRowSum(2)){
			if(getColSum(0) == getColSum(1) &&  getColSum(0) == getColSum(2))
				return true;
		}
		
		return false;
	}
}
