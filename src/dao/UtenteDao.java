package dao;




import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connessionedb.ConnessioneDB;
import entity.Utente;


public class UtenteDao{
	
	private ConnessioneDB conn = new ConnessioneDB();
	private Utente u;
	private List<String> lista = new ArrayList<String>();

	public List<String> cerca(String username, String password) throws Exception{
		Connection c = conn.createConnessione();
		Statement stm = c.createStatement();
		ResultSet res = stm.executeQuery("SELECT username, email, passwd FROM Utente WHERE username='"+ username +"' AND passwd='" + password + "';" );
		
		if(!res.next()) return null;
		lista.add(res.getString("username"));
		lista.add(res.getString("email"));
		lista.add(res.getString("passwd"));
        /*String user = res.getString("username");
        String email = res.getString("email");
        String passwd = res.getString("password");
		u = new Utente(user, passwd, email);*/
		
		conn.chiudi(stm, c, res);
		return lista;
	}
	

}
