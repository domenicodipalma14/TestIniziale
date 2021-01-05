package bean;

import logic.LogInController;
import logic.SignInController;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.regex.Pattern;

import error.DBException;
import error.DriverException;

public class SignInBean{

	private String username;
	private String email;
	private String confEmail;
	private String password;
	private String confPass;
	
	private String nome;
	private String cognome;
	private LocalDate data;
	private String citta;
	
	/**
	 * @return the citta
	 */
	public String getCitta() {
		return citta;
	}

	/**
	 * @param citta the citta to set
	 */
	public void setCitta(String citta) {
		this.citta = citta;
	}

	/**
	 * @return the data
	 */
	public LocalDate getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(LocalDate data) {
		this.data = data;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the confEmail
	 */
	public String getConfEmail() {
		return confEmail;
	}

	/**
	 * @param confEmail the confEmail to set
	 */
	public void setConfEmail(String confEmail) {
		this.confEmail = confEmail;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the confPass
	 */
	public String getConfPass() {
		return confPass;
	}

	/**
	 * @param confPass the confPass to set
	 */
	public void setConfPass(String confPass) {
		this.confPass = confPass;
	}
	
	public static boolean isValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
	
	/**
	 * metodo che controlla la validità dei dati inseriti
	 * @return -1 se email non valida, 0 se tutto giusto, 1 se password non corrispondono, 2 se email non corrispondono
	 * @throws DBException 
	 * @throws DriverException 
	 * @throws SQLException 
	 * @throws Exception 
	 */
	public int validate() throws DriverException, DBException, SQLException{
		if(isValid(getEmail())){
			if(getEmail().compareTo(getConfEmail())==0) {
				if(getPassword().compareTo(getConfPass())==0){
				
					if(SignInController.getIstance().registrati(getUsername(), getPassword(), getEmail(), getNome(), getCognome(), getData(), getCitta())){
						LogInController.getInstance().login(username, password);
						return 0;
					}
					return -2;
				}else return 1;
			}
			else return 2;
		}
		return -1;
	}

}
