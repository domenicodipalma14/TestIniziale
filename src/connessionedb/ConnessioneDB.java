package connessionedb;

/*import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;*/
import java.sql.*;

import error.DBException;
import error.DriverException;
//import logic.LogInController;

public class ConnessioneDB {
	private Connection connect = null;
	final private String host = "localhost:3306";
	final private String user = "decimo";
	final private String passwd = "IlDecimoDB10";
	
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
	
	
	/*public static void main(String[] args) throws Exception {
		File file = new File("../IlDecimo/WebContent/img/img.jpg");
		FileInputStream fis = new FileInputStream(file);
		ConnessioneDB conn = getIstance();
		Connection c = conn.createConnessione();
		PreparedStatement stm = c.prepareStatement("INSERT INTO Immagine (imm) VALUES (?)");
		//String query = "INSERT INTO Immagine (imm) VALUES (?)";
		//PreparedStatement pstmt = c.prepareStatement(query);
		InputStream in = new FileInputStream("../IlDecimo/WebContent/img/img.jpg");
		stm.setBlob(1, in);
		stm.execute();
		conn.chiudi(stm, c);
	}*/

	public void chiudi(Statement stm, Connection c) throws DBException {
		 try {
			stm.close();
		    c.close();
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
	 
	}

	
}
	 

