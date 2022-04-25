import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*** 5X5 Controller ***/

public class X5Controller implements Initializable{
	
	boolean checkButton[]  = new boolean[25];
	Button gridButtons[][] = new Button[5][5];
	
	X5 X5 = new X5();
	
    @FXML private VBox containerVBox;
    @FXML private GridPane ticTacToeGrid;
    @FXML private Button button00;
    @FXML private Button button10;
    @FXML private Button button20;
    @FXML private Button button30;
    @FXML private Button button40;
    @FXML private Button button01;
    @FXML private Button button11;
    @FXML private Button button21;
    @FXML private Button button31;
    @FXML private Button button41;
    @FXML private Button button02;
    @FXML private Button button12;
    @FXML private Button button22;
    @FXML private Button button32;
    @FXML private Button button42;
    @FXML private Button button03;
    @FXML private Button button13;
    @FXML private Button button23;
    @FXML private Button button33;
    @FXML private Button button43;
    @FXML private Button button04;
    @FXML private Button button14;
    @FXML private Button button24;
    @FXML private Button button34;
    @FXML private Button button44;
    @FXML private VBox controlVBox;
    @FXML private TextField outputTextField;
    @FXML private GridPane choiceGrid;
    @FXML private Label player1Label;
    @FXML public ChoiceBox<String> player1ChoiceBox;
    @FXML private Label player2Label;
    @FXML public ChoiceBox<String> player2ChoiceBox;
    @FXML private TextField player1WinsTextField;
    @FXML private TextField player2WinsTextField;
    @FXML private GridPane userGrid;
    @FXML private Button newButton;
    @FXML private Button resetButton;
    @FXML private Button menuButton;
    
    @FXML
    void button00Pressed(ActionEvent event) {
    	playGame( button00, 0 );    	
    }

    @FXML
    void button01Pressed(ActionEvent event) {
    	playGame( button01, 1 );   	
    }

    @FXML
    void button02Pressed(ActionEvent event) {
    	playGame( button02, 2 );	
    }

    @FXML
    void button03Pressed(ActionEvent event) {
    	playGame( button03, 3 );	
    }

    @FXML
    void button04Pressed(ActionEvent event) {
    	playGame( button04, 4 );
    }
    
    @FXML
    void button10Pressed(ActionEvent event) {
    	playGame( button10, 5 );	
    }

    @FXML
    void button11Pressed(ActionEvent event) {
    	playGame( button11, 6 );   	
    }

    @FXML
    void button12Pressed(ActionEvent event) {
    	playGame( button12, 7 );   	
    }

    @FXML
    void button13Pressed(ActionEvent event) {
    	playGame( button13, 8 ); 	
    }
    
    @FXML
    void button14Pressed(ActionEvent event) {
    	playGame( button14, 9 );
    }    
    
    @FXML
    void button20Pressed(ActionEvent event) {
    	playGame( button20, 10 );	
    }

    @FXML
    void button21Pressed(ActionEvent event) {
    	playGame( button21, 11 );
    }

    @FXML
    void button22Pressed(ActionEvent event) {
    	playGame( button22, 12 );	
    }

    @FXML
    void button23Pressed(ActionEvent event) {
    	playGame( button23, 13 );
    }
    
    @FXML
    void button24Pressed(ActionEvent event) {
    	playGame( button24, 14 );
    }
    
    @FXML
    void button30Pressed(ActionEvent event) {
    	playGame( button30, 15 );
    }

    @FXML
    void button31Pressed(ActionEvent event) {
    	playGame( button31, 16 );
    }

    @FXML
    void button32Pressed(ActionEvent event) {
    	playGame( button32, 17 );
    }

    @FXML
    void button33Pressed(ActionEvent event) {
    	playGame( button33, 18 );
    }
    
    @FXML
    void button34Pressed(ActionEvent event) {
    	playGame( button34, 19 );
    }

    @FXML
    void button40Pressed(ActionEvent event) {
    	playGame( button40, 20 );
    }

    @FXML
    void button41Pressed(ActionEvent event) {
    	playGame( button41, 21 );
    }

    @FXML
    void button42Pressed(ActionEvent event) {
    	playGame( button42, 22 );
    }

    @FXML
    void button43Pressed(ActionEvent event) {
    	playGame( button43, 23 );
    }

    @FXML
    void button44Pressed(ActionEvent event) {
    	playGame( button44, 24 );
    }

    @FXML
    void newButtonPressed(ActionEvent event) {
    	buttonSorter();
    	X5.newButton( player1ChoiceBox, player2ChoiceBox, 
    			      newButton, outputTextField, gridButtons );
    }

    @FXML
    void resetButtonPressed(ActionEvent event) {
    	buttonSorter();
    	X5.resetButton( gridButtons, resetButton, outputTextField );
    }
    
    @FXML
    void menuButtonPressed(ActionEvent event) throws IOException {	
		switchScenes(event, "MainMenu.fxml");
	}   
    
    //Method runs When a playable button is pressed
    public void playGame( Button button, int buttonID ) {
    	checkButton[buttonID] = true;
    	X5.change( button, player1ChoiceBox, 
    			   player2ChoiceBox, outputTextField );
    	X5.result( gridButtons, outputTextField, player1WinsTextField, 
		           player2WinsTextField, resetButton, checkButton );
    }
    
    //Method puts playable buttons in an array
    public void buttonSorter() {
    	gridButtons[0][0] = button00;
    	gridButtons[1][0] = button10;
    	gridButtons[2][0] = button20;
    	gridButtons[3][0] = button30;
    	gridButtons[4][0] = button40;
    	gridButtons[0][1] = button01;
    	gridButtons[1][1] = button11;
    	gridButtons[2][1] = button21;
    	gridButtons[3][1] = button31;
    	gridButtons[4][1] = button41;
    	gridButtons[0][2] = button02;
    	gridButtons[1][2] = button12;
    	gridButtons[2][2] = button22;
    	gridButtons[3][2] = button32;
    	gridButtons[4][2] = button42;
    	gridButtons[0][3] = button03;
    	gridButtons[1][3] = button13;
    	gridButtons[2][3] = button23;
    	gridButtons[3][3] = button33;
    	gridButtons[4][3] = button43;
    	gridButtons[0][4] = button04;
    	gridButtons[1][4] = button14;
    	gridButtons[2][4] = button24;
    	gridButtons[3][4] = button34;
    	gridButtons[4][4] = button44;
    }
    
    //method allows application to switch scenes with press of a button
    public void switchScenes(ActionEvent event, String sceneName) throws IOException{
    	
    	Parent parent = FXMLLoader.load(getClass().getResource(sceneName));
    	Scene scene = new Scene(parent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(scene);
    	window.show();
    }
    
    //method initializes characters in the choice boxes
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    
    	List<String> list = new ArrayList<String>();
        list.add("x");
        list.add("o");
        list.add("+");
        list.add("#");
        list.add("$");
        list.add("1");
        list.add("<3");
        list.add(":)");
        ObservableList<String> obList = FXCollections.observableList(list);
        
        player1ChoiceBox.getItems().clear();
        player1ChoiceBox.setItems(obList);
        
        player2ChoiceBox.getItems().clear();
        player2ChoiceBox.setItems(obList);
    	
    	outputTextField.setText("Select you charachter then press 'New'");
		
	}
}
