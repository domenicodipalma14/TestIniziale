package logic;

import dao.UtenteDao;
import entity.Utente;
import error.DBException;
import error.DriverException;

public class UserHomeController {
	private static Utente u = LogInController.getInstance().getUtente();
	
	public static String impostaUsername(){
		return u.getUsername();
	}
	
	public static String impostaNome(){
		return u.getNome();
	}
	
	public static String impostaCognome(){
		return u.getCognome();
	}
	
	public static boolean checkOrganizzatore(){
		return u.isOrganizzatore();
	}
	
	public static boolean checkGiocatore(){
		return u.isGiocatore();
	}
	
	/**
	 * 
	 * @return true se l'utente è un organizzatore e un giocatore
	 */
	public static boolean checkTipo(){
		return (checkOrganizzatore() && checkGiocatore());
	}
	
	public static void setOrganizzatore(String tipo) throws DBException, DriverException{
		if(UtenteDao.setOrganizzatoreDB(u.getUsername(), tipo)){
			u.setOrganizzatore(true);
		}
		else{
			u.setOrganizzatore(false);
		}
	}
	
	public static void setGiocatore(String tipo) throws DBException, DriverException{
		if(UtenteDao.setOrganizzatoreDB(u.getUsername(), tipo)){
			u.setGiocatore(true);
		}
		else{
			u.setGiocatore(false);
		}
	}
	
	

}
