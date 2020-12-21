package bean;

import logic.LogInController;

/**
 * @author DOMENICO
 *
 */
public class LogInBean {
	
	private String username;
	private String password;
	
	
	public LogInBean() {
		//devo pensare bene
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
	 * controlla se i dati iseriti sono validi, in caso di validità dei dati 
	 * chiama il login per controllare se l'utente è presente nel db
	 * @return true se il login ha successo
	 * @throws Exception 
	 */
	public boolean validate() throws Exception{
		if(username == null || username.equals("") || password==null || password.equals("")){
			return false;
		}
		
		return(LogInController.getInstance().login(username, password));
	}
	

}
