package logic;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import bean.SignInBean;
import dao.UtenteDao;
import error.DBException;
import error.DriverException;

public class SignInController {
	
	private static SignInController istance = null;
	private UtenteDao u = new UtenteDao();
	 private SignInBean bean = new SignInBean();
	
	private SignInController() {
	}
	
	public static SignInController getIstance(){
		if(istance == null){
			istance = new SignInController();
		}
		return istance;
	}
	
	public void setCittaBean(String citta){
		bean.setCitta(citta);
	}
	
	public int checkDati() throws DriverException, DBException, SQLException{
		return (bean.validate());
	}
	
	public void setPasswdBean(String password, String confPassword){
		bean.setConfPass(confPassword);
		bean.setPassword(password);
	}
	public void setEmailBean(String email, String confEmail){
		bean.setEmail(email);
		bean.setConfEmail(confEmail);
	}
	public void setDatiPersonaliBean(String nome, String cognome, LocalDate data, String username){
		bean.setUsername(username);
    	bean.setNome(nome);
    	bean.setCognome(cognome);
    	bean.setData(data);
	}
	public boolean registrati(String username, String password, String email, String nome, String cognome, LocalDate data, String citta) throws DriverException, DBException, SQLException{
		return (u.cerca(username, password).isEmpty() && u.inserisciUtente(username, password, email, nome , cognome, data, citta)>0);
	}
	
	public List<String> getCitta() throws DriverException, DBException, SQLException{
		return (u.selectCitta());
	}

	public static boolean checkCampi(String nome, String cognome, LocalDate date, String username, String email,String passwd, String citta) {
		/*if(nome.isEmpty() || nome.length() == 0) return false;
		else if(cognome.isEmpty() || cognome.length() == 0) return false;
		else if(date == null) return false;
		else if(username.isEmpty() || username.length() == 0) return false;
		else if (email.isEmpty() || email.length() == 0) return false;
		else if(passwd.isEmpty() || passwd.length() == 0) return false;
		else if(citta == null) return false;*/
		if((nome.isEmpty() || nome.length() == 0) || (cognome.isEmpty() || cognome.length() == 0) || (date == null) || (username.isEmpty() || username.length() == 0) || (email.isEmpty() || email.length() == 0) || (passwd.isEmpty() || passwd.length() == 0) || (citta == null)) return false;
		return true;
	}
}
