package dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import connessionedb.ConnessioneDB;
import error.DBException;
import error.DriverException;


public class UtenteDao{
	private static ConnessioneDB conn = ConnessioneDB.getIstance();
	private List<String> lista = new ArrayList<>();
	private List<Boolean> tipo = new ArrayList<>();
	
	private static final String VIRGOLETTA = "'";
	
	/**
	 * metodo che restituisce lo sport preferito di un utente andando a leggere nel DB
	 * @param username
	 * @return stringa che indica lo sport selezionato dall'utente
	 * @throws DBException
	 * @throws DriverException
	 */
	public String getSport(String username) throws DBException, DriverException{
		Connection c = conn.createConnessione();
		Statement stm;
		try{
			stm = c.createStatement();
			ResultSet res = stm.executeQuery("SELECT sport_nome FROM Utente WHERE  username='"+username+"'");
			res.next();
			String sport = res.getString("sport_nome");
			conn.chiudi(stm, c, res);
			return sport;
		} catch (SQLException e){
			throw new DBException(e.getMessage());
		}
	}
	
	
	public static boolean setSportDB(String sport, String username) throws DBException, DriverException{
		Connection c = conn.createConnessione();
		Statement stm;
		try {
			stm = c.createStatement();
			if(stm.executeUpdate("UPDATE Utente SET sport_nome='"+sport+"' WHERE username='"+username+"'")!=0){
				conn.chiudi(stm, c);
				return true;
			}
			else{
				conn.chiudi(stm, c);
				return false;
			}
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
		
	}
	/**
	 * metodo che controlla che il tipo di utente e ne setta i valori in conseguenza all'input ricevuto
	 * @param username dell'utente 
	 * @param tipo indaca se l'utente vuole settare organizzatore o giocatore
	 * @return  true se viene settato a true, false altrimenti
	 * @throws DBException
	 * @throws DriverException
	 */
	public static boolean setTipoDB(String username, String tipo) throws DBException, DriverException{
		Connection c = conn.createConnessione();
		Statement stm;
		try {
			stm = c.createStatement();
			ResultSet res = stm.executeQuery("SELECT "+tipo+" FROM utente WHERE username='"+username+"'");
			res.next();
			boolean b = res.getBoolean(tipo);
			if(b){
				int ris = stm.executeUpdate("UPDATE Utente SET "+tipo+" = false WHERE username='"+username+"'");
				conn.chiudi(stm, c);
				if(ris!=0) return false;
			}
			else{
				int ris = stm.executeUpdate("UPDATE Utente SET "+tipo+" = true WHERE username='"+username+"'");
				conn.chiudi(stm, c);
				if(ris!=0) return true;
			}
			conn.chiudi(stm, c, res);
			return false;
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
	}
	

	public boolean checkTitolare(String username) throws DriverException, DBException{
		Connection c = conn.createConnessione();
		Statement stm;
		try {
			stm = c.createStatement();
			ResultSet res = stm.executeQuery("SELECT * FROM titolare WHERE Utente_username='"+username+"'");
			if(!res.next()){
				conn.chiudi(stm, c, res);
				return false;
			}
			return true;
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
		
	}
	
	
	/**
	 * metodo che controlla di che tipo è l'utente(organizzatore/giocatore o titolare di un impianto)
	 * @param username  dell'utente
	 * @param password del'utente
	 * @return lista che contiene al massimo due elmenti 
	 * @throws DriverException
	 * @throws DBException
	 */
	public List<Boolean> checkTipo(String username) throws DriverException, DBException{
		Connection c = conn.createConnessione();
		Statement stm;
		try {
			stm = c.createStatement();
			ResultSet res = stm.executeQuery("SELECT organizzatore, giocatore FROM Utente WHERE username = '"+username+"'");
			if(!res.next()){
				conn.chiudi(stm, c, res);
				return Collections.emptyList();
			}
			tipo.add(res.getBoolean("organizzatore"));
			tipo.add(res.getBoolean("giocatore"));
			conn.chiudi(stm, c, res);
			return tipo;
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
	}
	public List<String> cerca(String username, String password) throws DriverException, DBException{
		Connection c = conn.createConnessione();
		Statement stm;
		try {
			stm = c.createStatement();
			ResultSet res = stm.executeQuery("SELECT username, email, passwd, nome, cognome, citta_nome  FROM Utente WHERE username='"+ username +"' AND passwd='" + password + "';" );
			if(!res.next()){
				conn.chiudi(stm, c, res);
				return Collections.emptyList();
			}
			lista.add(res.getString("username"));
			lista.add(res.getString("email"));
			lista.add(res.getString("passwd"));
			lista.add(res.getString("nome"));
			lista.add(res.getString("cognome"));
			lista.add(res.getString("citta_nome"));
			conn.chiudi(stm, c, res);
			return lista;
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}	
	}
	
	public int inserisciUtente(String username, String password, String email, String nome, String cognome, LocalDate data, String citta) throws DriverException, DBException, SQLException{
		Connection c = conn.createConnessione();
		Statement stm = c.createStatement();
		int  res = stm.executeUpdate("INSERT INTO Utente (username, email, passwd, nome, cognome, nascita, citta_nome) VALUES ("+VIRGOLETTA+username+VIRGOLETTA+", "+VIRGOLETTA+email+VIRGOLETTA+", "+VIRGOLETTA+password+VIRGOLETTA+","+VIRGOLETTA+nome+VIRGOLETTA+","+VIRGOLETTA+cognome+VIRGOLETTA+","+VIRGOLETTA+data+VIRGOLETTA+" , "+VIRGOLETTA+citta+VIRGOLETTA+")");
		conn.chiudi(stm, c);
		return res;
	}
	
	public List<String> selectCitta() throws DriverException, DBException, SQLException{
		List<String> l =  new ArrayList<>();
		Connection c = conn.createConnessione();
		Statement stm = c.createStatement();
		ResultSet res = stm.executeQuery("SELECT nome FROM citta");
		while(res.next()){
			l.add(res.getString("nome"));
		}
		conn.chiudi(stm, c, res);
		return l;
	}

}
