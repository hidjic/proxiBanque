package presentation;

import java.util.Date;
import java.util.Scanner;

import proxybanque.domainecompte.CCourant;
import proxybanque.domaineentity.Agence;
import proxybanque.domaineentity.Client;
import proxybanque.domaineentity.Conseiller;
import service.ServiceClient;
import service.ServiceCompte;
import service.ServiceConseiller;

public class lanceur {

	public static void main(String[] args) {
		boolean riche;
		ServiceConseiller service = new ServiceConseiller();
		ServiceCompte serviceCompte = new ServiceCompte();
		ServiceClient serviceClient = new ServiceClient();

		// Création agence Lyon

		Agence agenceLyon = new Agence("00001", "19/05/2005");
		// Connexion conseiller
		Conseiller conseiller = new Conseiller("POGNON", "Gille", 4, agenceLyon);
		// Création client
		System.out.println("Veuillez entrer le nom du client");
		Scanner sc = new Scanner(System.in);
		String nom = sc.nextLine();
		System.out.println("Veuillez entrer le prénom du client");
		String prenom = sc.nextLine();
		System.out.println("Veuillez entrer l'adresse du client");
		String adresse = sc.nextLine();
		System.out.println("Veuillez entrer le code postal du client");
		String codePostal = sc.nextLine();
		System.out.println("Veuillez entrer la ville du client");
		String ville = sc.nextLine();
		System.out.println("Veuillez entrer le téléphone du client");
		String telephone = sc.nextLine();
//		System.out.println("S'agit-il d'un client avec un solde supérieur à 500.000 euros ? O/N");
//		char statutClient = sc.nextLine().charAt(0);
//		if (statutClient == 'O')
//			riche = true;
//		else
//			riche = false;
		// TODO rajouter demande statut entreprise
		Client client = service.creerClient(nom, prenom, adresse, codePostal, ville, telephone, true, false, agenceLyon,
				conseiller);
		// création compte
		serviceCompte.creationCompte(serviceCompte, client);
		service.modifierClient(serviceCompte, serviceClient, client);
		

	}

}
