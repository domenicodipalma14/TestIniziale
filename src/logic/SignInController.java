package logic;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import dao.UtenteDao;
import error.DBException;
import error.DriverException;

public class SignInController {
	
	private static SignInController istance = null;
	private UtenteDao u = new UtenteDao();
	
	private SignInController() {
	}
	
	public static SignInController getIstance(){
		if(istance == null){
			istance = new SignInController();
		}
		return istance;
	}
	
	public boolean registrati(String username, String password, String email, String nome, String cognome, LocalDate data, String citta) throws DriverException, DBException, SQLException{
		return (u.cerca(username, password).isEmpty() && u.inserisciUtente(username, password, email, nome , cognome, data, citta)>0);
	}
	
	public List<String> getCitta() throws DriverException, DBException, SQLException{
		return (u.selectCitta());
	}
}
