package logic;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CaricaScenaController {
	private String path;
	private ActionEvent event;
	
	public CaricaScenaController(String path, ActionEvent event) {
		super();
		this.path = path;
		this.event = event;
	}

	public void caricaScena() throws IOException {
	    BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/view/"+path));
	    Scene scene = new Scene(root);
	    	
	    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	    window.setScene(scene);
	    window.show();
	}
}
