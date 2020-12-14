package logic;

import bean.LogInBean;

public class LogInController {
	
	private static LogInController INSTANCE = null;
	
	/**
	 * singleton
	 */
	private LogInController(){
	}
	
	public static LogInController getInstance(){
		if(INSTANCE == null){
			INSTANCE = new LogInController();
		}
		
		return INSTANCE;
	}

	public boolean login(String username, String password){
		boolean esito;
		/**
		 * check sul db
		 */
		if(username.compareTo("Mario")==0 && password.compareTo("cazzo")==0){
			esito = true;
		}
		else{
			esito = false;
		}
		return esito;
	}
}
