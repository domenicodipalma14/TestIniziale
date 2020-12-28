package error;

public class DriverException extends Exception{
	private static final long serialVersionUID = 1L;

	public DriverException() {
		super();
	}
	
	public DriverException(String message) {
		super("Errore nel caricamento del driver: " + message);
	}
	
	public DriverException(Throwable causa){
		super(causa);
	}

}
