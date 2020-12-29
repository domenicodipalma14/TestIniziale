package entity;

import java.time.LocalDate;

public class Utente {
	private String username;
	private String password;
	private String email;
	private String nome;
	private String cognome;
	private boolean organizzatore = false;
	private boolean giocatore = false;
	private int idSquadra;
	private int idVoto;
	private LocalDate data; 
	private boolean titolare = false;
	
	
	/**
	 * @return the titolare
	 */
	public boolean isTitolare() {
		return titolare;
	}

	/**
	 * @param titolare the titolare to set
	 */
	public void setTitolare(boolean titolare) {
		this.titolare = titolare;
	}

	/**
	 * @return the organizzatore
	 */
	public boolean isOrganizzatore() {
		return organizzatore;
	}

	/**
	 * @param organizzatore the organizzatore to set
	 */
	public void setOrganizzatore(boolean organizzatore) {
		this.organizzatore = organizzatore;
	}

	/**
	 * @return the giocatore
	 */
	public boolean isGiocatore() {
		return giocatore;
	}

	/**
	 * @param giocatore the giocatore to set
	 */
	public void setGiocatore(boolean giocatore) {
		this.giocatore = giocatore;
	}

	/**
	 * @return the idSquadra
	 */
	public int getIdSquadra() {
		return idSquadra;
	}

	/**
	 * @param idSquadra the idSquadra to set
	 */
	public void setIdSquadra(int idSquadra) {
		this.idSquadra = idSquadra;
	}

	/**
	 * @return the idVoto
	 */
	public int getIdVoto() {
		return idVoto;
	}

	/**
	 * @param idVoto the idVoto to set
	 */
	public void setIdVoto(int idVoto) {
		this.idVoto = idVoto;
	}

	/**
	 * @return the data
	 */
	public LocalDate getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(LocalDate data) {
		this.data = data;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Utente(){}
	
	public Utente(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	


	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
