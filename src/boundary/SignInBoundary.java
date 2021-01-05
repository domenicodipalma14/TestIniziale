/**
 * Sample Skeleton for 'SignIn.fxml' Controller Class
 */

package boundary;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import logic.CaricaScenaController;
import logic.SignInController;
import error.DBException;
import error.DriverException;
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
    private TextField txtNome; 
    
    @FXML 
    private TextField txtCognome; 
    
    @FXML
    private PasswordField txtPasswd;

    @FXML
    private PasswordField txtCheckPaswd;
    
    @FXML
    private Button btnTitolare;


    @FXML // fx:id="txtCheckEmail"
    private TextField txtCheckEmail; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnnulla"
    private Button btnAnnulla; // Value injected by FXMLLoader

    @FXML // fx:id="btnSigIn"
    private Button btnSigIn; // Value injected by FXMLLoader
    
    @FXML
    private DatePicker txtData;
    
    @FXML
    private ComboBox<String> comboboxCitta = new ComboBox<>() ;
    
    @FXML
    private Label label;
   
    
    private void setBean(){
    	SignInController.getIstance().setDatiPersonaliBean(txtNome.getText(), txtCognome.getText(), txtData.getValue(), txtUsername.getText());
    	SignInController.getIstance().setEmailBean(txtEmail.getText(),txtCheckEmail.getText());
    	SignInController.getIstance().setPasswdBean(txtPasswd.getText(), txtCheckPaswd.getText());
    }
    @FXML
    void handleRegTitolare(ActionEvent event) {
    	/*try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Demo.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("ABC");
            stage.setScene(new Scene(root1));  
            stage.show();
          }catch(Exception e){
        	  e.printStackTrace();
          }*/
    }
    @FXML
    void scegliCitta(ActionEvent event) {
    	String value = (String) comboboxCitta.getValue();
    	SignInController.getIstance().setCittaBean(value);
    }

    @FXML
    void handleAnnulla(ActionEvent event) throws IOException {
    	String path = "Home.fxml";
		CaricaScenaController c = new CaricaScenaController(path, event);
    	c.caricaScena();
    }

    @FXML
    void handleSignIn(ActionEvent event) throws DriverException, DBException, IOException, SQLException{
    	if(SignInController.checkCampi(txtNome.getText(), txtCognome.getText(), txtData.getValue(), txtUsername.getText(), txtEmail.getText(), txtPasswd.getText(), comboboxCitta.getValue())){
	    	setBean();
	    	int check = SignInController.getIstance().checkDati();
	    	if(check==0){
	    		String path = "UserHome.fxml";
				CaricaScenaController c = new CaricaScenaController(path, event);
				c.caricaScena();
			}
			else if(check == -1){
				label.setText("Email non valida");
			}
			else if(check == 2){
				label.setText("Email diverse");
			}
			else if(check == 1){
				label.setText("Password diverse");
			}
			else{
				label.setText("Username già esistente");
			}
    	}
    	else label.setText("Tutti i campi sono obbligatori");
 
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtUsername != null : "fx:id=\"txtUsername\" was not injected: check your FXML file 'SignIn.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'SignIn.fxml'.";
        assert txtCheckEmail != null : "fx:id=\"txtCheckEmail\" was not injected: check your FXML file 'SignIn.fxml'.";
        assert txtPasswd != null : "fx:id=\"txtPasswd\" was not injected: check your FXML file 'SignIn.fxml'.";
        assert txtCheckPaswd != null : "fx:id=\"txtCheckPaswd\" was not injected: check your FXML file 'SignIn.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SignIn.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SignIn.fxml'.";
        assert txtData != null : "fx:id=\"txtData\" was not injected: check your FXML file 'SignIn.fxml'.";
        assert btnAnnulla != null : "fx:id=\"btnAnnulla\" was not injected: check your FXML file 'SignIn.fxml'.";
        assert btnSigIn != null : "fx:id=\"btnSigIn\" was not injected: check your FXML file 'SignIn.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'SignIn.fxml'.";
       
        try {
        	List<String> listacitta;
			listacitta = SignInController.getIstance().getCitta();
			for(String s : listacitta){
				comboboxCitta.getItems().add(s);
			}
        } catch (DriverException | DBException | SQLException e) {
			e.printStackTrace();
		}
        comboboxCitta.setEditable(true);
    }
}

