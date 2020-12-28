package error;

public class DBException extends Exception{
	private static final long serialVersionUID = -5111623668986851547L;


	public DBException() {
		super();
	}

	public DBException(String message) {
		super("Si è verificato qualche errore nell'interfacciarsi con il DB"+message);
	}

	public DBException(Throwable cause) {
		super(cause);
	}
	
}
