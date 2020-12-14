package logic;

public class LogInController {
	
	private static LogInController istance = null;
	
	/**
	 * singleton
	 */
	private LogInController(){
	}
	
	public static LogInController getInstance(){
		if(istance == null){
			istance = new LogInController();
		}
		
		return istance;
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
