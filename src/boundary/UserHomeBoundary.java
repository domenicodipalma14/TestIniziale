/**
 * Sample Skeleton for 'UserHome.fxml' Controller Class
 */

package boundary;

import java.net.URL;
import java.util.ResourceBundle;

import error.DBException;
import error.DriverException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import logic.UserHomeController;

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
    
    @FXML
    private Label lbTipoUtente;
    
    @FXML
    private CheckBox checkOrganizzatore;

    @FXML
    private CheckBox checkGiocatore;
    
    private static final String ACTION_1 = "Organizzatore, Giocatore";
    private static final String ACTION_2 = "Giocatore";
    private static final String ACTION_3 = "Organizzatore";
    private static final String ACTION_4 = "Impostare tipo profilo";
    
    @FXML
    void handleCheckOrganizzatore(ActionEvent event) throws DBException, DriverException{
    	if(checkOrganizzatore.isSelected()){
    		if(checkGiocatore.isSelected()) lbTipoUtente.setText(ACTION_1);
    		else lbTipoUtente.setText(ACTION_3);
    		UserHomeController.setOrganizzatore();
    	}
    	else{
    		String s = lbTipoUtente.getText();
    		if(s.equals(ACTION_1)) lbTipoUtente.setText(ACTION_2);
    		else if(s.equals(ACTION_3)) lbTipoUtente.setText(ACTION_4);
    		UserHomeController.setOrganizzatore();
    	}
    }
    
    @FXML
    void handleCheckGiocatore(ActionEvent event) throws DBException, DriverException{
    	if(checkGiocatore.isSelected()){
    		if(checkOrganizzatore.isSelected()) lbTipoUtente.setText(ACTION_1);
    		else lbTipoUtente.setText(ACTION_2);
    		UserHomeController.setGiocatore();
    	}
    	else{
    		String s = lbTipoUtente.getText();
    		if(s.equals(ACTION_1)) lbTipoUtente.setText(ACTION_3);
    		else if(s.equals(ACTION_2)) lbTipoUtente.setText(ACTION_4);
    		UserHomeController.setGiocatore();
    	}
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	lbUsername.setText(UserHomeController.impostaUsername());
    	lbCognome.setText(UserHomeController.impostaCognome());
    	lbNome.setText(UserHomeController.impostaNome());
    	if(UserHomeController.checkTipo()){
    		lbTipoUtente.setText(ACTION_1);
    	}
    	else if (UserHomeController.checkGiocatore()) lbTipoUtente.setText(ACTION_2);
    	else if(UserHomeController.checkOrganizzatore()) lbTipoUtente.setText(ACTION_3);
    	else lbTipoUtente.setText(ACTION_4);
    	
    	if(UserHomeController.checkTipo()){
    		checkGiocatore.setSelected(true);
    		checkOrganizzatore.setSelected(true);
    	}
    	else if(UserHomeController.checkOrganizzatore()){
    		checkOrganizzatore.setSelected(true);
    		checkGiocatore.setSelected(false);
    	}
    	else if(UserHomeController.checkGiocatore()){
    		checkGiocatore.setSelected(true);
    		checkOrganizzatore.setSelected(false);
    	}
    	else {
    		checkGiocatore.setSelected(false);
    		checkOrganizzatore.setSelected(false);
    	}
    }
}
