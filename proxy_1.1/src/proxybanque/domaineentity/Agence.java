package proxybanque.domaineentity;

import java.util.Date;

public class Agence {
	private String numeroIdentification;
	private String dateDeCreation;
	private Gerant gerant;
	private Conseiller conseiller;
	private Client client;

	public Agence(String numeroIdentification, String dateDeCreation) {
		this.numeroIdentification = numeroIdentification;
		this.dateDeCreation = dateDeCreation;
	}

	public String getNumeroIdentification() {
		return numeroIdentification;
	}

	public void setNumeroIdentification(String numeroIdentification) {
		this.numeroIdentification = numeroIdentification;
	}

	public String getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(String dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

}
