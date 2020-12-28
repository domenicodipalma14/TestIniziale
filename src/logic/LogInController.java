package logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UtenteDao;
import entity.Utente;
import error.DBException;
import error.DriverException;

public class LogInController {
	
	private static LogInController istance = null;
	private Utente u = new Utente();
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

	/**
	 * 
	 * @param username
	 * @param password
	 * @return l[0] = username, l[1] = email, l[2] = password, l[3] = nome, l[4] = cognome
	 * @throws DriverException 
	 * @throws DBException 
	 * @throws SQLException 
	 * @throws Exception
	 */
	public boolean login(String username, String password) throws DriverException, DBException{
		UtenteDao ud = new UtenteDao();
		List<String> l = new ArrayList<>();
		l = ud.cerca(username, password);
		if(!l.isEmpty()){
			u.setUsername(l.get(0));
			u.setEmail(l.get(1));
			u.setPassword(l.get(2));
			u.setNome(l.get(3));
			u.setCognome(l.get(4));
			return true;
		}
		else return false;
		
	}
	
	public Utente getUtente(){
		return u;
	}
}
