import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/*** 3X3 Class ***/

public class X3 {
	
	/*** Local Variables ***/
	
	private boolean character = true;
	private boolean check     = false;
	
	private int player1Counter = 0;
	private int player2Counter = 0;
	private int counter        = 0;
	
	private String player1Character = "";
	private String player2Character = "";

	GridButtonFunctions gridButtonFunctions = new GridButtonFunctions();
	
	/*** Getters ***/
	
	public boolean isCharacter() {
		return character;
	}

	public boolean isCheck() {
		return check;
	}
	
	public int getPlayer1Counter() {
		return player1Counter;
	}
	
	public int getPlayer2Counter() {
		return player2Counter;
	}
	
	public int getCounter() {
		return counter;
	}
	
	public String getPlayer1Character() {
		return player1Character;
	}
	
	public String getPlayer2Character() {
		return player2Character;
	}
	
	/*** Setters ***/
	
	public void setCharacter(boolean character) {
		this.character = character;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public void setPlayer1Counter(int player1Counter) {
		this.player1Counter = player1Counter;
	}

	public void setPlayer2Counter(int player2Counter) {
		this.player2Counter = player2Counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public void setPlayer1Character(String player1Character) {
		this.player1Character = player1Character;
	}

	public void setPlayer2Character(String player2Character) {
		this.player2Character = player2Character;
	}

    /*** Methods ***/
	
	//Method alternates players' turn
	public void change( Button button,  
						ChoiceBox<String> player1ChoiceBox, 
						ChoiceBox<String> player2ChoiceBox, 
						TextField outputTextField  ) {
		
    	//if statement sets button text
    	//and switches 'x' and 'o' after every move
    	if( button.getText() == "" ) {
    		if( isCharacter() == true ) {
    			button.setText(player1ChoiceBox.getValue());
    			character = false;
    			outputTextField.setText( "Player 2's turn" );
    		} else {
    			button.setText(player2ChoiceBox.getValue());
    			character = true;
    			outputTextField.setText( "Player 1's turn" );
    		}
    	}
    }
	
	//Method checks to see if the there is a tic-tac-toe
	public void result( Button gridButtons[][], TextField outputTextField, 
						TextField player1WinsTextField, 
						TextField player2WinsTextField, 
						Button resetButton, boolean checkButton[]) {
		
		counter++;
		check = isTrue(checkButton);

    	if ( getCounter() <= Math.pow(gridButtons.length, 2)) {

    		//Down Wins
			end( gridButtons[0][0], gridButtons[0][1], gridButtons[0][2], 
    			 outputTextField, player1WinsTextField, player2WinsTextField, 
    			 resetButton, gridButtons, checkButton );
    		end( gridButtons[1][0], gridButtons[1][1], gridButtons[1][2], 
       			 outputTextField, player1WinsTextField, player2WinsTextField, 
       			 resetButton, gridButtons, checkButton );
    		end( gridButtons[2][0], gridButtons[2][1], gridButtons[2][2],
       			 outputTextField, player1WinsTextField, player2WinsTextField, 
       			 resetButton, gridButtons, checkButton );

    		//Across Wins
    		
    		end( gridButtons[0][0], gridButtons[1][0], gridButtons[2][0], 
       			 outputTextField, player1WinsTextField, player2WinsTextField, 
       			 resetButton, gridButtons, checkButton );
    		end( gridButtons[0][1], gridButtons[1][1], gridButtons[2][1],
       			 outputTextField, player1WinsTextField, player2WinsTextField, 
       			 resetButton, gridButtons, checkButton );
    		end( gridButtons[0][2], gridButtons[1][2], gridButtons[2][2],  
       			 outputTextField, player1WinsTextField, player2WinsTextField, 
       			 resetButton, gridButtons, checkButton );

    		//Diagonal Wins
    		
    		end( gridButtons[0][0], gridButtons[1][1], gridButtons[2][2], 
       			 outputTextField, player1WinsTextField, player2WinsTextField, 
       			 resetButton, gridButtons, checkButton );
    		end( gridButtons[2][0], gridButtons[1][1], 
    			 gridButtons[0][2], outputTextField, player1WinsTextField, player2WinsTextField, 
       			 resetButton, gridButtons, checkButton );

    		//Draw
	
    	} else if( isCheck() == true) {

    		resetButton.setDisable( false );
    		
    		//Disables all playable buttons
    		gridButtonFunctions.buttonsDisable( gridButtons, true );
    		
    		outputTextField.setText( "Draw" );
    		
    		counter = 0;
    		
    		//Once all grid buttons were selected, they became 'taken'
    		//all grid buttons are reset and now all playable once again
    		for( int i = 0; i  < checkButton.length; i++ ) {
    			checkButton[i] = false;
    		}
    	}	
	}
	
	//Method checks to see if all buttons have been selected
	public boolean isTrue ( boolean checkButton[] ) {

		for (int i = 0; i < checkButton.length; i++) {
			if (!checkButton[i]) { 
				return false;
			}
		}
		return true;
	}
	
	//Method breaks down 'result' method, and allows the game to 
	//determine which player got a tic-tac-toe.
	//(Simplifies winner into a single method)
	public void end( Button button1, Button button2, Button button3,
					 TextField outputTextField, TextField player1WinsTextField,
					 TextField player2WinsTextField, Button resetButton, 
					 Button gridButtons[][], boolean checkButton[] ) {

    	done( button1, button2, button3, getPlayer1Character(), 
    		  outputTextField, getPlayer1Counter(), player1WinsTextField, 
    		  resetButton, gridButtons, checkButton);
    	
    	done( button1, button2, button3, getPlayer2Character(), 
       		  outputTextField, getPlayer2Counter(), player2WinsTextField, 
       		  resetButton, gridButtons, checkButton);
    }
	
	//Method determines the winner
	public void done( Button button1, Button button2, Button button3,
					  String character, TextField output, 
					  int playerCounter, TextField playerWins, 
					  Button reset, Button gridButtons[][], 
					  boolean checkButton[] ) {

		if ( button1.getText() == character && button2.getText() == character && 
			 button3.getText() == character ) {

			// Counter method
			WinCounter( playerCounter, playerWins );

			reset.setDisable( false );
			
			//Disables all playable buttons
			gridButtonFunctions.buttonsDisable( gridButtons, true );

			//If player 1 won
			if( character == getPlayer1Character() ) {
				player1Counter++;
				output.setText( "Player 1 Wins" );
				counter = 0;
				for( int i = 0; i  < checkButton.length; i++) {
					checkButton[i] = false;
				}
			}
			
			//If player 2 won
			if( character == getPlayer2Character() ) {
				player2Counter++;
				output.setText( "Player 2 Wins" );
				counter = 0;
				for( int i = 0; i  < checkButton.length; i++) {
					checkButton[i] = false;
				}
			}
		}
	}
	
	//Method Increases player's win counter on every player's win by 1 point
	public void WinCounter( int playerCounter, TextField playerWins ) {

		playerWins.setText( String.valueOf( playerCounter ) );
	}
	
	//Method starts a new game
	public void newButton( ChoiceBox<String> player1ChoiceBox, 
						   ChoiceBox<String> player2ChoiceBox, 
						   Button newButton, TextField outputTextField, 
						   Button gridButtons[][]) {
		
		String value1 = "x";
    	String value2 = "o";
		
		player1Counter = 1;
    	player2Counter = 1;
    	
    	character = true;
    	
    	//Enable all playable buttons
    	//once "New" button is pressed
    	gridButtonFunctions.buttonsDisable(gridButtons, false);
    	
    	player1ChoiceBox.setDisable(true);
    	player2ChoiceBox.setDisable(true);
    	
    	newButton.setDisable(true);
    	
 
    	//Validates player1 character
    	player1ChoiceBox = initialCharacter( player1ChoiceBox, 
    										 player2ChoiceBox, 
    										 value1, value2 );
    	
    	//Validates player2 character 		
    	player2ChoiceBox = initialCharacter( player2ChoiceBox, 
    										 player1ChoiceBox, 
    										 value2, value1 );
    	
    	//Validates checks that both characters are different  	
    	if( player1ChoiceBox.getValue() == player2ChoiceBox.getValue() ) {
    		player1ChoiceBox.setValue("x");
    		player2ChoiceBox.setValue("o");
    	}
    	
    	player1Character = player1ChoiceBox.getValue();
    	player2Character = player2ChoiceBox.getValue();
    	
    	outputTextField.setText( "Player 1's turn" );	
	}	
	
	//Method validates player's character
	public ChoiceBox<String> initialCharacter( 
								            ChoiceBox<String> player1ChoiceBox,
								            ChoiceBox<String> player2ChoiceBox,
								            String value1, String value2) {

		ChoiceBox<String> choiceBox;	
		
		if( player1ChoiceBox.getValue() == ("-") ) {
    		player1ChoiceBox.setValue(value1);
    	} else if ( ( player1ChoiceBox.getValue() == ("-") ) && 
    			    ( player2ChoiceBox.getValue() == (value1) ) ) {
    		player1ChoiceBox.setValue(value2);
    	}
		
		choiceBox = player1ChoiceBox;
		
		return choiceBox;
	}
	
	//Method resets game
	public void resetButton( Button gridButtons[][], Button resetButton, 
							 TextField outputTextField ) {
		
		character = true;
    	
    	//Clears all playable buttons
		gridButtonFunctions.buttonsClear( gridButtons, "");
		
		resetButton.setDisable(true);
		
		//Enable all playable buttons
		gridButtonFunctions.buttonsDisable( gridButtons, false);
    	
    	outputTextField.setText("Player 1's turn");
	}	
}
