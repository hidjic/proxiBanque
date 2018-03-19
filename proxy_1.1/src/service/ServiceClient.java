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
	
	/**
	 * Mets à jour la propriété du client qui le défini comme fortuné ou non
	 * @param myClient
	 */
	public void gestionBooleanRiche(Client myClient) {
		boolean isEntreprise = myClient.isEntreprise();
		double totalSolde = (myClient.getCompteCourant().getSolde() + myClient.getCompteEpargne().getSolde());
		if(!isEntreprise) {
			if(totalSolde > GestionClientFortunes.valeurIsRich) {
				myClient.setRiche(true);
			}else {
				myClient.setRiche(false);
			}
		}
	}
}
