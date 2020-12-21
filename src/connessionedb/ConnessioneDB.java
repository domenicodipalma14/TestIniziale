package connessionedb;

import java.sql.*;

public class ConnessioneDB {
	private Connection connect = null;
	final private String host = "localhost:3306";
	final private String user = "decimo";
	final private String passwd = "IlDecimoDB10";
	
	/**
	 * metodo che crea una connessione con il db
	 * @return 
	 * @throws Exception
	 */
	
	
	
	public Connection createConnessione() throws Exception {
	    try {
	    	//Properties p = new Properties();
	    	/*String username="fghjk";
	    	String password="fghjk";
	    	List<String> l = new ArrayList<String>();*/
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	connect = DriverManager.getConnection("jdbc:mysql://"+host+"/decimo?user="+user+"&password="+passwd+"&serverTimezone=UTC");
	    	return connect;
	    	/*statement = connect.createStatement();
	    	resultSet = statement.executeQuery("SELECT username, email, passwd FROM Utente WHERE username='"+ username +"' AND passwd='" + password + "';" );
	    	System.out.println(resultSet);
	    	if(!resultSet.next()) return connect;
	    	l.add(resultSet.getString("username"));
	    	System.out.println(l.get(0));
	    	return connect;
	    	/*statement = connect.createStatement();
	    	resultSet = statement.executeUpdate("INSERT INTO Utente (username, email, password) VALUES ('LoSpagnolo', 'lospagnolo@gmail.com', '1234')");*/
	    	
	    	
	    } catch (Exception e) {
	      throw e;
	    }
	  }
	
	public void chiudi(Statement stm, Connection c, ResultSet res) throws SQLException{
		res.close();
        stm.close();
        c.close();
	}
	
	
	public static void main(String[] args) throws Exception {
		ConnessioneDB c = new ConnessioneDB();
		System.out.println(c.createConnessione());
	}
	
}
	 

