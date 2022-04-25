import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/*** Main Menu ***/

public class MainMenuController {

	@FXML private Button x3Button;
    @FXML private Button x4Button;
	@FXML private Button x5Button;
	@FXML private Button instructionsButton;
	@FXML private Button closeButton;

	@FXML
	void closeButtonPressed(ActionEvent event) {
    	Platform.exit();
    } 

	@FXML
	void instructionsButtonPressed(ActionEvent event) throws IOException {	
		switchScenes(event, "Instructions.fxml");
	}

	@FXML
	void x3ButtonPressed(ActionEvent event) throws IOException {	
		switchScenes(event, "3x3.fxml");
	}
	
	@FXML
	void x4ButtonPressed(ActionEvent event) throws IOException {	
		switchScenes(event, "4x4.fxml");
	}

	@FXML
	void x5ButtonPressed(ActionEvent event) throws IOException {	
		switchScenes(event, "5x5.fxml");
	}
	
	
	// method allows application to switch scenes with press of a button
    public void switchScenes(ActionEvent event, String sceneName) throws IOException{
    	 
    	Parent parent = FXMLLoader.load(getClass().getResource(sceneName));
    	Scene scene = new Scene(parent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(scene);
    	window.show();
    }
}
