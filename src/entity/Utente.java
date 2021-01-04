package entity;

import java.time.LocalDate;

public class Utente {
	private String username;
	private String password;
	private String email;
	private String name;
	private String surname;
	private String citta;
	/**
	 * @return the citta
	 */
	public String getCitta() {
		return citta;
	}

	/**
	 * @param citta the citta to set
	 */
	public void setCitta(String citta) {
		this.citta = citta;
	}


	private boolean organizzatore = false;
	private boolean giocatore = false;
	private int idSquadra;
	private int idVoto;
	private LocalDate date; 
	private boolean titolare = false;
	
	private String sport;
	
	
	/**
	 * @return the sport
	 */
	public String getSport() {
		return sport;
	}

	/**
	 * @param sport the sport to set
	 */
	public void setSport(String sport) {
		this.sport = sport;
	}

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
	 * @return the date
	 */
	public LocalDate getData() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setData(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the name
	 */
	public String getNome() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setNome(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getCognome() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setCognome(String surname) {
		this.surname = surname;
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
