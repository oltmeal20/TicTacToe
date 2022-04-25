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

/*** 4X4 Controller ***/

public class X4Controller implements Initializable{
	
	boolean checkButton[]  = new boolean[16];
	Button gridButtons[][] = new Button[4][4];
	
	X4 X4 = new X4();
	
    @FXML private VBox containerVBox;
    @FXML private GridPane ticTacToeGrid;
    @FXML private Button button00;
    @FXML private Button button10;
    @FXML private Button button20;
    @FXML private Button button30;
    @FXML private Button button01;
    @FXML private Button button11;
    @FXML private Button button21;
    @FXML private Button button31;
    @FXML private Button button02;
    @FXML private Button button12;
    @FXML private Button button22;
    @FXML private Button button32;
    @FXML private Button button03;
    @FXML private Button button13;
    @FXML private Button button23;
    @FXML private Button button33;
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
    void button10Pressed(ActionEvent event) {
    	playGame( button10, 4 ); 	
    }

    @FXML
    void button11Pressed(ActionEvent event) {
    	playGame( button11, 5 );     	
    }

    @FXML
    void button12Pressed(ActionEvent event) {
    	playGame( button12, 6 );   	
    }

    @FXML
    void button13Pressed(ActionEvent event) {
    	playGame( button13, 7 ); 	
    }

    
    @FXML
    void button20Pressed(ActionEvent event) {
    	playGame( button20, 8 ); 	
    }

    @FXML
    void button21Pressed(ActionEvent event) {
    	playGame( button21, 9 );
    }

    @FXML
    void button22Pressed(ActionEvent event) {
    	playGame( button22, 10 ); 	
    }

    @FXML
    void button23Pressed(ActionEvent event) {
    	playGame( button23, 11 ); 
    }
    
    
    @FXML
    void button30Pressed(ActionEvent event) {
    	playGame( button30, 12 );  
    }

    @FXML
    void button31Pressed(ActionEvent event) {
    	playGame( button31, 13 ); 
    }

    @FXML
    void button32Pressed(ActionEvent event) {
    	playGame( button32, 14 ); 
    }

    @FXML
    void button33Pressed(ActionEvent event) {
    	playGame( button33, 15 );  
    }

    @FXML
    void newButtonPressed(ActionEvent event) {
    	buttonSorter();
    	X4.newButton( player1ChoiceBox, player2ChoiceBox, 
    			      newButton, outputTextField, gridButtons );
    }

    @FXML
    void resetButtonPressed(ActionEvent event) {
    	buttonSorter();
    	X4.resetButton( gridButtons, resetButton, outputTextField );
    }
    
    @FXML
    void menuButtonPressed(ActionEvent event) throws IOException {	
		switchScenes(event, "MainMenu.fxml");
	}   
    
    //Method runs When a playable button is pressed
    public void playGame( Button button, int buttonID) {
    	checkButton[buttonID] = true;
    	X4.change( button, player1ChoiceBox, 
    			   player2ChoiceBox, outputTextField );
    	X4.result( gridButtons, outputTextField, player1WinsTextField, 
		           player2WinsTextField, resetButton, checkButton );
    }
    
    //Method puts playable buttons in an array
    public void buttonSorter() {
    	gridButtons[0][0] = button00;
    	gridButtons[1][0] = button10;
    	gridButtons[2][0] = button20;
    	gridButtons[3][0] = button30;
    	gridButtons[0][1] = button01;
    	gridButtons[1][1] = button11;
    	gridButtons[2][1] = button21;
    	gridButtons[3][1] = button31;
    	gridButtons[0][2] = button02;
    	gridButtons[1][2] = button12;
    	gridButtons[2][2] = button22;
    	gridButtons[3][2] = button32;
    	gridButtons[0][3] = button03;
    	gridButtons[1][3] = button13;
    	gridButtons[2][3] = button23;
    	gridButtons[3][3] = button33;
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
