package logic;

import java.sql.SQLException;
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
	 * metodo che effettua il login e setta la classe utente
	 * @param username
	 * @param password
	 * @return l[0] = username, l[1] = email, l[2] = password, l[3] = nome, l[4] = cognome, l[5] = sport
	 * @throws DriverException 
	 * @throws DBException 
	 * @throws SQLException 
	 * @throws Exception
	 */
	public boolean login(String username, String password) throws DriverException, DBException{
		UtenteDao ud = new UtenteDao();
		List<String> l;
		l = ud.cerca(username, password);
		if(!l.isEmpty()){
			u.setUsername(l.get(0));
			u.setEmail(l.get(1));
			u.setPassword(l.get(2));
			u.setNome(l.get(3));
			u.setCognome(l.get(4));
			u.setCitta(l.get(5));
			if(ud.checkTitolare(username)){
				u.setTitolare(true);
			}
			else {
				List<Boolean> tipo;
				tipo = ud.checkTipo(username);
				u.setOrganizzatore(tipo.get(0));
				u.setGiocatore(tipo.get(1));
				u.setSport(ud.getSport(username));
			}
			return true;
		}
		else return false;
		
	}
	
	public Utente getUtente(){
		return u;
	}
}
