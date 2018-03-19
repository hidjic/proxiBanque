package proxybanque.domainecompte;

import java.text.SimpleDateFormat;
import java.util.Date;

import proxybanque.domaineentity.Client;

public abstract class Compte {
	private int numeroCompte;
	private double solde;
	private String dateOuverture;
	private Client client;

	public Compte(String formater, Client client) {
		this.solde = 0;
		this.dateOuverture = formater;
		this.client = client;
	}

	public int getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
