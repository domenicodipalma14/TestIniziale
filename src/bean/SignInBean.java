package bean;

import logic.LogInController;
import java.util.regex.Pattern;

public class SignInBean {
	private String username;
	private String email;
	private String confEmail;
	private String password;
	private String confPass;
	
	public SignInBean(){
		//devo vedere
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
	 */
	public int validate(){
		if(isValid(getEmail())){
			if(getEmail().compareTo(getConfEmail())==0) {
				if(getPassword().compareTo(getConfPass())==0){
					/**
					 * if(controllo db) return 0; else return 3;
					 * se username valido, registra dati nel db
					 */
					
					/**
					 * decidere se lasciare
					 * RegistraDatiController reg = new RegistraDatiController();
					 * reg.insericiDatiDb(bean);
		    		*/
		    		if(LogInController.getInstance().login(username, password))
		    		/*
		    		 * se utente appena inserito viene trovato return 0 e cambio scena 
		    		 */
		    		
		    			return 0;
				}else return 1;
			}
			else return 2;
		}
		return -1;
	}

}
