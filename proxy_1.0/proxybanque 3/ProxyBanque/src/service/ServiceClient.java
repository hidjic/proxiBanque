package service;

import proxybanque.domaineentity.Client;

public class ServiceClient {
	/**
	 * @param serviceCompte
	 * @param client
	 */
	public void afficherClient(ServiceCompte serviceCompte, Client client) {
		System.out.println("1 - Nom : " + client.getNom());
		System.out.println("2 - Prénom : " + client.getPrenom());
		System.out.println("3 - Adresse : " + client.getAdresse());
		System.out.println("4 - Code postal : " + client.getCodePostal());
		System.out.println("5 - Ville : " + client.getVille());
		System.out.println("6 - Numéro de telephone : " + client.getTelephone());
		if (client.isRiche() == true) {
		System.out.println("7 - Gestion de patrimoine");
		//TODO appeler méthode gestion
		}
		System.out.println("8 - Comptes : ");
		if (client.getCompteCourant()!=null)
		System.out.println(client.getCompteCourant());
		if (client.getCompteEpargne()!=null)
		System.out.println(client.getCompteEpargne());
		
	}
}
