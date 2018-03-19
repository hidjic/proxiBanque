package proxybanque.domainecompte;

import java.text.SimpleDateFormat;
import java.util.Date;

import proxybanque.domaineentity.Client;

public class CCourant extends Compte {
	private int decouvert;
	private Carte carte;

	public CCourant() {

	}

	public CCourant(String formater, Client client) {
		super(formater, client);
		this.decouvert = 1000;
		super.setNumeroCompte(001);
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public int getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(int decouvert) {
		this.decouvert = decouvert;
	}
	public String toString() {
		return super.toString() + ", a un découvert autorisé de " + this.decouvert + " et est associé à une carte " +this.carte.getType();
	}
}
