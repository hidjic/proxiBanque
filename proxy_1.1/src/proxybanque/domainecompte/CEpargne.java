package proxybanque.domainecompte;

import proxybanque.domaineentity.Client;

public class CEpargne extends Compte {
	private double taux;
	
	public CEpargne(String formater, Client client) {
		super(formater, client);
		this.taux = 3;
		super.setNumeroCompte(001);
	}
}
