package boundary;

import java.io.IOException;
/**
 * Sample Skeleton for 'Home.fxml' Controller Class
 */
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import logic.CaricaScenaController;

public class HomeBoundary {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnLogIn"
    private Button btnLogIn; // Value injected by FXMLLoader

    @FXML // fx:id="btnSignIn"
    private Button btnSignIn; // Value injected by FXMLLoader
    
    @FXML
    void handleLogIn(ActionEvent event) throws IOException {
    	String path = "LogIn.fxml";
    	CaricaScenaController c = new CaricaScenaController(path, event);
    	c.caricaScena();
    }

    @FXML
    void handleSignIn(ActionEvent event) throws IOException {
    	String path = "SignIn.fxml";
    	CaricaScenaController c = new CaricaScenaController(path, event);
    	c.caricaScena();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnLogIn != null : "fx:id=\"btnLogIn\" was not injected: check your FXML file 'Home.fxml'.";
        assert btnSignIn != null : "fx:id=\"btnSignIn\" was not injected: check your FXML file 'Home.fxml'.";

    }
}
