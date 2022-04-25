import javafx.scene.control.Button;

/*** Grid Button Functions ***/

public class GridButtonFunctions {

	
	//Sets playable buttons to either enable or disable
	public void buttonsDisable( Button gridButtons[][], boolean visibility ) {
	   
		for(int x = 0; x  < gridButtons.length; x++ ) {
			for(int y = 0; y  < gridButtons.length; y++ ) {
				gridButtons[x][y].setDisable(visibility);
			}
		}
	}
	
	
	//Clears all playable buttons
	public void buttonsClear( Button gridButtons[][], String text ) {
		
		for(int x = 0; x  < gridButtons.length; x++ ) {
			for(int y = 0; y  < gridButtons.length; y++ ) {
				gridButtons[x][y].setText(text);;
			}
		}
	}
}