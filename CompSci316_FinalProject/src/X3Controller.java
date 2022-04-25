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

/*** 3X3 Controller ***/

public class X3Controller implements Initializable{
	
	boolean checkButton[]  = new boolean[9];
	Button gridButtons[][] = new Button[3][3];
	
	X3 X3 = new X3();
	
    @FXML private VBox containerVBox;
    @FXML private GridPane ticTacToeGrid;
    @FXML private Button button00;
    @FXML private Button button10;
    @FXML private Button button20;
    @FXML private Button button01;
    @FXML private Button button11;
    @FXML private Button button21;
    @FXML private Button button02;
    @FXML private Button button12;
    @FXML private Button button22;
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
    void button10Pressed(ActionEvent event) {
    	playGame( button10, 3 );	
    }

    @FXML
    void button11Pressed(ActionEvent event) {
    	playGame( button11, 4 );     	
    }

    @FXML
    void button12Pressed(ActionEvent event) {
    	playGame( button12, 5 );    	
    }
    
    @FXML
    void button20Pressed(ActionEvent event) {
    	playGame( button20, 6 );	
    }

    @FXML
    void button21Pressed(ActionEvent event) {
    	playGame( button21, 7 );
    }

    @FXML
    void button22Pressed(ActionEvent event) {
    	playGame( button22, 8 ); 	
    }

    @FXML
    void newButtonPressed(ActionEvent event) {
    	buttonSorter();
    	X3.newButton( player1ChoiceBox, player2ChoiceBox, 
    			      newButton, outputTextField, gridButtons );
    }

    @FXML
    void resetButtonPressed(ActionEvent event) {
    	buttonSorter();
    	X3.resetButton( gridButtons, resetButton, outputTextField );
    }
    
    @FXML
    void menuButtonPressed(ActionEvent event) throws IOException {	
		switchScenes(event, "MainMenu.fxml");
	}   
    
    //Method runs When a playable button is pressed
    public void playGame( Button button, int buttonID ) {
    	checkButton[buttonID] = true;
    	X3.change( button, player1ChoiceBox, 
    			   player2ChoiceBox, outputTextField );
    	X3.result( gridButtons, outputTextField, player1WinsTextField, 
		           player2WinsTextField, resetButton, checkButton );
    }
    
    //Method puts playable buttons in an array
    public void buttonSorter() {
    	gridButtons[0][0] = button00;
    	gridButtons[1][0] = button10;
    	gridButtons[2][0] = button20;
    	gridButtons[0][1] = button01;
    	gridButtons[1][1] = button11;
    	gridButtons[2][1] = button21;
    	gridButtons[0][2] = button02;
    	gridButtons[1][2] = button12;
    	gridButtons[2][2] = button22;
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
