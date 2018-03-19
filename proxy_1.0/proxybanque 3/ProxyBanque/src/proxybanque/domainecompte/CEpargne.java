package proxybanque.domainecompte;

import proxybanque.domaineentity.Client;

public class CEpargne extends Compte {
	private double taux;
	
	public CEpargne(String formater, Client client) {
		super(formater, client);
		this.taux = 3;
		super.setNumeroCompte(001);
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	public String toString() {
		return super.toString() + " et a un taux d'épargne de " + this.taux +"%";
	}
}
