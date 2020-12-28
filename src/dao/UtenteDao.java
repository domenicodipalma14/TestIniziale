package dao;




import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import connessionedb.ConnessioneDB;
import error.DBException;
import error.DriverException;


public class UtenteDao{
	
	//private ConnessioneDB conn = new ConnessioneDB();
	
	private ConnessioneDB conn = ConnessioneDB.getIstance();
	private List<String> lista = new ArrayList<String>();

	public List<String> cerca(String username, String password) throws DriverException, DBException{
		Connection c = conn.createConnessione();
		Statement stm;
		try {
			stm = c.createStatement();
			ResultSet res = stm.executeQuery("SELECT username, email, passwd, nome, cognome FROM Utente WHERE username='"+ username +"' AND passwd='" + password + "';" );
			if(!res.next()){
				conn.chiudi(stm, c, res);
				return null;
			}
			lista.add(res.getString("username"));
			lista.add(res.getString("email"));
			lista.add(res.getString("passwd"));
			lista.add(res.getString("nome"));
			lista.add(res.getString("cognome"));
			conn.chiudi(stm, c, res);
			return lista;
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}	
	}
	
	public int inserisci(String username, String password, String email, String nome, String cognome, LocalDate data) throws Exception{
		Connection c = conn.createConnessione();
		Statement stm = c.createStatement();
		int  res = stm.executeUpdate("INSERT INTO Utente (username, email, passwd, nome, cognome, nascita) VALUES ('"+username+"', '"+email+"', '"+password+"', '"+nome+"' , '"+cognome+"' , '"+data+"')");
		conn.chiudi(stm, c);
		return res;
	}
	

}
