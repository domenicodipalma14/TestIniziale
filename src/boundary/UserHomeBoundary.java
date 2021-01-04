/**
 * Sample Skeleton for 'UserHome.fxml' Controller Class
 */

package boundary;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import error.DBException;
import error.DriverException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import logic.CaricaScenaController;
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
    private Label lbSport;
    
    @FXML
    private RadioButton radioButtonCalcetto;

    @FXML
    private ToggleGroup sport;

    @FXML
    private RadioButton radioButtonPallavolo;
    
    @FXML
    private Button organizzaPartitaButton;

    @FXML
    private Button organizzaTorneoButton;

    @FXML
    private Button partecipaButton;

    @FXML
    private Button logoutButton;
    @FXML
    private Label lbCitta;


    @FXML
    private RadioButton radioButtonBasket;
    
    private static final String ACTION_1 = "Organizzatore, Giocatore";
    private static final String ACTION_2 = "Giocatore";
    private static final String ACTION_3 = "Organizzatore";
    private static final String ACTION_4 = "Impostare tipo profilo";
    
    private static final String SPORT_1 = "Calcetto";
    private static final String SPORT_2 = "Basket";
    private static final String SPORT_3 = "Pallavolo";
    
    @FXML
    void handleLogout(ActionEvent event) {
    	String path = "LogIn.fxml";
		CaricaScenaController c = new CaricaScenaController(path, event);
        try {
			c.caricaScena();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void handlePartecipa(ActionEvent event) {
    	String path = "Partecipa.fxml";
		CaricaScenaController c = new CaricaScenaController(path, event);
        try {
			c.caricaScena();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void handlePartita(ActionEvent event) {
    	String path = "CreaPartita.fxml";
		CaricaScenaController c = new CaricaScenaController(path, event);
        try {
			c.caricaScena();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void handleTorneo(ActionEvent event) {
    	String path = "CreaTorneo.fxml";
		CaricaScenaController c = new CaricaScenaController(path, event);
        try {
			c.caricaScena();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void handleBasket(ActionEvent event) throws DBException, DriverException {
    	if(radioButtonBasket.isSelected()){
    		lbSport.setText(SPORT_2);
    		//query db per aggiornare lo sport dell'utente
    		UserHomeController.setSport(SPORT_2);
    	}
    }

    @FXML
    void handleCalcetto(ActionEvent event) throws DBException, DriverException {
    	if(radioButtonCalcetto.isSelected()){
    		lbSport.setText(SPORT_1);
    		//query db per aggiornare lo sport dell'utente
    		UserHomeController.setSport(SPORT_1);
    	}
    }
    
    @FXML
    void handlePallavolo(ActionEvent event) throws DBException, DriverException {
    	if(radioButtonPallavolo.isSelected()){
    		lbSport.setText(SPORT_3);
    		//query db per aggiornare lo sport dell'utente
    		UserHomeController.setSport(SPORT_3);
    	}
    }
    
    
    @FXML
    void handleCheckOrganizzatore(ActionEvent event) throws DBException, DriverException{
    	if(checkOrganizzatore.isSelected()){
    		if(checkGiocatore.isSelected()){
    			lbTipoUtente.setText(ACTION_1);
    			organizzaTorneoButton.setVisible(true);
    			organizzaPartitaButton.setVisible(true);
    			partecipaButton.setVisible(true);
    		}
    		else{
    			lbTipoUtente.setText(ACTION_3);
    			organizzaTorneoButton.setVisible(true);
    			organizzaPartitaButton.setVisible(true);
    			partecipaButton.setVisible(false);
    		}
    	}
    	else{
    		String s = lbTipoUtente.getText();
    		if(s.equals(ACTION_1)){
    			lbTipoUtente.setText(ACTION_2);
    			organizzaTorneoButton.setVisible(false);
    			organizzaPartitaButton.setVisible(false);
    			partecipaButton.setVisible(true);
    		}
    		else if(s.equals(ACTION_3)){
    			lbTipoUtente.setText(ACTION_4);
    			organizzaTorneoButton.setVisible(false);
    			organizzaPartitaButton.setVisible(false);
    			partecipaButton.setVisible(false);
    		}
    	}
    	UserHomeController.setOrganizzatore(ACTION_3);
    }
    
    @FXML
    void handleCheckGiocatore(ActionEvent event) throws DBException, DriverException{
    	if(checkGiocatore.isSelected()){
    		if(checkOrganizzatore.isSelected()){
    			lbTipoUtente.setText(ACTION_1);
    			settaBottoni(true, true, true);
    		}
    		else{
    			lbTipoUtente.setText(ACTION_2);
    			settaBottoni(false, false, true);
    		}
    	}
    	else{
    		String s = lbTipoUtente.getText();
    		if(s.equals(ACTION_1)){
    			lbTipoUtente.setText(ACTION_3);
    			settaBottoni(true, true, false);
    		}
    		else if(s.equals(ACTION_2)) {
    			lbTipoUtente.setText(ACTION_4);
    			settaBottoni(false, false, false);
    		}
    	}
    	UserHomeController.setGiocatore(ACTION_2);
    }
    
    public void gestioneCheckBoxTipo(){
    	if(UserHomeController.checkTipo()){
    		//sia giocatore che organizzatore
    		checkGiocatore.setSelected(true);
    		checkOrganizzatore.setSelected(true);
    	}
    	else if(UserHomeController.checkOrganizzatore()){
    		//utente di tipo organizzatore
    		checkOrganizzatore.setSelected(true);
    		checkGiocatore.setSelected(false);
    	}
    	else if(UserHomeController.checkGiocatore()){
    		//utente di tipo giocatore
    		checkGiocatore.setSelected(true);
    		checkOrganizzatore.setSelected(false);
    	}
    	else {
    		//utente con tipo da impostare
    		checkGiocatore.setSelected(false);
    		checkOrganizzatore.setSelected(false);
    	}
    }
    
    public void inizializzaSportLabel(){
    	String s = UserHomeController.checkSport();
    	if(s!=null){
	    	switch(s){
	    		case SPORT_2: 
	    			lbSport.setText(SPORT_2); 
	    			radioButtonBasket.setSelected(true);
	    			break;
	    		case SPORT_1: 
	    			lbSport.setText(SPORT_1); 
	    			radioButtonCalcetto.setSelected(true);
	    			break;
	    		case SPORT_3: 
	    			lbSport.setText(SPORT_3);
	    			radioButtonCalcetto.setSelected(true);
	    			break;
	    		default:
	    	    		lbSport.setText(SPORT_3);
	    	    		
	    	}
	    	
    	}
    	else lbSport.setText("Impostare sport preferito");
    }
    public void settaBottoni(boolean torneo, boolean partita, boolean partecipa){
    	organizzaTorneoButton.setVisible(torneo);
		organizzaPartitaButton.setVisible(partita);
		partecipaButton.setVisible(partecipa);
    }
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	lbUsername.setText(UserHomeController.impostaUsername());
    	lbCognome.setText(UserHomeController.impostaCognome());
    	lbNome.setText(UserHomeController.impostaNome());
    	lbCitta.setText(UserHomeController.impostaCitta());
    	if(UserHomeController.checkTipo()){
    		lbTipoUtente.setText(ACTION_1);
    		settaBottoni(true, true, true);
    	}
    	else if (UserHomeController.checkGiocatore()){
    		lbTipoUtente.setText(ACTION_2);
			settaBottoni(false, false, true);
    	}
    	else if(UserHomeController.checkOrganizzatore()) {
    		lbTipoUtente.setText(ACTION_3);
			settaBottoni(true, true, false);
    	}
    	else{
    		lbTipoUtente.setText(ACTION_4);
			settaBottoni(false, false, false);
    	}
    	gestioneCheckBoxTipo();
    	inizializzaSportLabel();
    }
}
