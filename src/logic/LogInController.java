package logic;

import java.util.ArrayList;
import java.util.List;

import dao.UtenteDao;
import entity.Utente;

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
	 * @throws Exception
	 */
	public boolean login(String username, String password) throws Exception{
		UtenteDao ud = new UtenteDao();
		List<String> l = new ArrayList<String>();
		l = ud.cerca(username, password);
		if(l!= null){
			u.setUsername(l.get(0));
			u.setEmail(l.get(1));
			u.setPassword(l.get(2));
			u.setNome(l.get(3));
			u.setCognome(l.get(4));
			//u = new Utente(l.get(0), l.get(2), l.get(1));
			return true;
		}
		else return false;
	}
	
	public Utente getUtente(){
		return u;
	}
}
