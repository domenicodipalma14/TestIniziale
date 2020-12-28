package logic;

import java.sql.SQLException;
import java.time.LocalDate;

import dao.UtenteDao;
import error.DBException;
import error.DriverException;

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
	

	public boolean registrati(String username, String password, String email, String nome, String cognome, LocalDate data) throws DriverException, DBException, SQLException{
		UtenteDao u = new UtenteDao();
		if(u.cerca(username, password).isEmpty() && u.inserisci(username, password, email, nome , cognome, data)>0) return true;
		return false;
	
	}
}
