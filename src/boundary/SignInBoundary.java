/**
 * Sample Skeleton for 'SignIn.fxml' Controller Class
 */

package boundary;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import logic.CaricaScenaController;
import logic.RegistraDatiController;
import logic.SignInController;
import bean.SignInBean;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class SignInBoundary {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtUsername"
    private TextField txtUsername; // Value injected by FXMLLoader

    @FXML // fx:id="txtEmail"
    private TextField txtEmail; // Value injected by FXMLLoader

    @FXML
    private PasswordField txtPasswd;

    @FXML
    private PasswordField txtCheckPaswd;

    @FXML // fx:id="txtCheckEmail"
    private TextField txtCheckEmail; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnnulla"
    private Button btnAnnulla; // Value injected by FXMLLoader

    @FXML // fx:id="btnSigIn"
    private Button btnSigIn; // Value injected by FXMLLoader
    
    @FXML
    private Label label;
    private SignInBean bean = new SignInBean();

    @FXML
    void handleAnnulla(ActionEvent event) throws IOException {
    	String path = "Home.fxml";
		CaricaScenaController c = new CaricaScenaController(path, event);
    	c.caricaScena();
    }

    @FXML
    void handleSignIn(ActionEvent event) throws IOException {
    	bean.setEmail(txtEmail.getText());
    	bean.setConfEmail(txtCheckEmail.getText());
    	bean.setPassword(txtPasswd.getText());
    	bean.setConfPass(txtCheckPaswd.getText());
    	bean.setUsername(txtUsername.getText());
    	int check = bean.validate();
    	if(check==0){
    		String path = "UserHome.fxml";
    		CaricaScenaController c = new CaricaScenaController(path, event);
        	c.caricaScena();
    	}
    	else if(check == -1){
    		System.out.println("NO");
    		label.setText("Email non valida");
    	}
    	else if(check == 2){
    		label.setText("Email diverse");
    	}
    	else if(check == 1){
    		label.setText("Password diverse");
    	}
    	else{
    		label.setText("Username gi� esistente");
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtUsername != null : "fx:id=\"txtUsername\" was not injected: check your FXML file 'SignIn.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'SignIn.fxml'.";
        assert txtPasswd != null : "fx:id=\"txtPasswd\" was not injected: check your FXML file 'SignIn.fxml'.";
        assert txtCheckPaswd != null : "fx:id=\"txtCheckPaswd\" was not injected: check your FXML file 'SignIn.fxml'.";
        assert txtCheckEmail != null : "fx:id=\"txtCheckEmail\" was not injected: check your FXML file 'SignIn.fxml'.";
        assert btnAnnulla != null : "fx:id=\"btnAnnulla\" was not injected: check your FXML file 'SignIn.fxml'.";
        assert btnSigIn != null : "fx:id=\"btnSigIn\" was not injected: check your FXML file 'SignIn.fxml'.";

    }
}

