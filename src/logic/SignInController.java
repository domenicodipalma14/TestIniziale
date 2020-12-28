package logic;

import java.time.LocalDate;

import dao.UtenteDao;

public class SignInController {
	
	private static SignInController istance = null;
	
	
	private SignInController() {
	}
	
	public static SignInController getIstance(){
		if(istance == null){
			istance = new SignInController();
		}
		return istance;
	}
	

	public boolean registrati(String username, String password, String email, String nome, String cognome, LocalDate data){
		UtenteDao u = new UtenteDao();
		try {
			if(u.cerca(username, password)== null && u.inserisci(username, password, email, nome , cognome, data)>0){
					return true;
			}
			return false;
		} catch (Exception e) {
			//Qualcoda è andato storto
		}
		return false;
	}
	
	
	
	
	

}
