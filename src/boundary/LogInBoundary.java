package boundary;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import bean.LogInBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logic.CaricaScenaController;

public class LogInBoundary {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtUsername"
    private TextField txtUsername; // Value injected by FXMLLoader

    @FXML // fx:id="txtPassword"
    private TextField txtPassword; // Value injected by FXMLLoader

    @FXML // fx:id="logIn"
    private Button logIn; // Value injected by FXMLLoader

    @FXML // fx:id="txtLabel"
    private Label txtLabel; // Value injected by FXMLLoader

    private LogInBean bean = new LogInBean();
    
    @FXML
    private Button btnBack;

    @FXML
    void handleBack(ActionEvent event) throws IOException {
    	String path = "Home.fxml";
		CaricaScenaController c = new CaricaScenaController(path, event);
    	c.caricaScena();
    }
  
    @FXML
    void handleLogIn(ActionEvent event){
    	String usr = txtUsername.getText();
    	String pas = txtPassword.getText();
    	bean.setPassword(pas);
    	bean.setUsername(usr);
    	boolean es;
		try {
			es = bean.validate();
			if(es){
	    		String path = "UserHome.fxml";
	    		CaricaScenaController c = new CaricaScenaController(path, event);
	        	c.caricaScena();
	    	}
	    	else{
	    		txtLabel.setText("DATI NON VALIDI");
	    	}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtUsername != null : "fx:id=\"txtUsername\" was not injected: check your FXML file 'LogIn.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'LogIn.fxml'.";
        assert logIn != null : "fx:id=\"logIn\" was not injected: check your FXML file 'LogIn.fxml'.";
        assert txtLabel != null : "fx:id=\"txtLabel\" was not injected: check your FXML file 'LogIn.fxml'.";

    }
}
