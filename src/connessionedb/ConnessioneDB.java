package connessionedb;

import java.sql.*;

import error.DBException;
import error.DriverException;


public class ConnessioneDB {
	private Connection connect = null;
	private static final String host = "localhost:3306";
	private final String user = "decimo";
	private final String passwd = "IlDecimoDB10";
	
	private static ConnessioneDB istance = null;

	
	private ConnessioneDB(){
		
		
	}
	
	
	public static ConnessioneDB getIstance(){
		if(istance == null){
			istance = new ConnessioneDB();
		}
		
		return istance;
		
	}
	/**
	 * metodo che crea una connessione con il db
	 * @return 
	 * @throws DBException 
	 * @throws ClassNotFoundException 
	 * @throws  
	 * @throws Exception
	 */
	
	
	
	public Connection createConnessione() throws DriverException, DBException{
	    	try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connect = DriverManager.getConnection("jdbc:mysql://"+host+"/decimo?user="+user+"&password="+passwd+"&serverTimezone=UTC");
				return connect;
			} catch (ClassNotFoundException e1) {
				throw new DriverException(e1.getMessage());
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
	    	finally{
	    		try {
					connect.close();
				} catch (SQLException e) {
					throw new DBException(e.getMessage());
				}
	    	}
	    	
	  }
	
	public void chiudi(Statement stm, Connection c, ResultSet res) throws DBException{
		try {
			res.close();
			stm.close();
			c.close();
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
        
       
	}

	public void chiudi(Statement stm, Connection c) throws DBException {
		 try {
			stm.close();
		    c.close();
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
	 
	}

	
}
	 

