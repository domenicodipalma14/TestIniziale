/**
 * Sample Skeleton for 'UserHome.fxml' Controller Class
 */

package boundary;

import java.net.URL;
import java.util.ResourceBundle;

import entity.Utente;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import logic.LogInController;

public class UserHomeBoundary {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="lbNome"
    private Label lbNome; // Value injected by FXMLLoader

    @FXML // fx:id="lbCognome"
    private Label lbCognome; // Value injected by FXMLLoader

    @FXML // fx:id="lbUsername"
    private Label lbUsername; // Value injected by FXMLLoader
    
    private LogInController lc = LogInController.getInstance();
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	Utente u = lc.getUtente();
    	lbUsername.setText(u.getUsername());
    	lbCognome.setText(u.getCognome());
    	lbNome.setText(u.getNome());

    }
}
