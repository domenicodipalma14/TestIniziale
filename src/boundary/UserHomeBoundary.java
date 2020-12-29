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
    
    
    @FXML
    void handleCheckOrganizzatore(ActionEvent event) throws DBException, DriverException{
    	if(checkOrganizzatore.isSelected()){
    		if(checkGiocatore.isSelected()) lbTipoUtente.setText("Organizzatore, Giocatore");
    		else lbTipoUtente.setText("Organizzatore");
    		UserHomeController.setOrganizzatore();
    	}
    	else{
    		String s = lbTipoUtente.getText();
    		if(s.equals("Organizzatore, Giocatore")) lbTipoUtente.setText("Giocatore");
    		else if(s.equals("Organizzatore")) lbTipoUtente.setText("Impostare tipo profilo");
    		UserHomeController.setOrganizzatore();
    	}
    }
    
    @FXML
    void handleCheckGiocatore(ActionEvent event) throws DBException, DriverException{
    	if(checkGiocatore.isSelected()){
    		if(checkOrganizzatore.isSelected()) lbTipoUtente.setText("Organizzatore, Giocatore");
    		else lbTipoUtente.setText("Giocatore");
    		UserHomeController.setGiocatore();
    	}
    	else{
    		String s = lbTipoUtente.getText();
    		if(s.equals("Organizzatore, Giocatore")) lbTipoUtente.setText("Organizzatore");
    		else if(s.equals("Giocatore")) lbTipoUtente.setText("Impostare tipo profilo");
    		UserHomeController.setGiocatore();
    	}
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	lbUsername.setText(UserHomeController.impostaUsername());
    	lbCognome.setText(UserHomeController.impostaCognome());
    	lbNome.setText(UserHomeController.impostaNome());
    	if(UserHomeController.checkTipo()){
    		lbTipoUtente.setText("Giocatore, Organizzatore");
    	}
    	else if (UserHomeController.checkGiocatore()) lbTipoUtente.setText("Giocatore");
    	else if(UserHomeController.checkOrganizzatore()) lbTipoUtente.setText("Organizzatore");
    	else lbTipoUtente.setText("Impostare tipo profilo");
    	
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
