package service;

import java.util.Scanner;

import proxybanque.domaineentity.Agence;
import proxybanque.domaineentity.Client;
import proxybanque.domaineentity.Conseiller;

public class ServiceConseiller {
	private int selection;
	private String nouveau;

	public Client creerClient(String nom, String prenom, String adresse, String codePostal, String ville,
			String telephone, boolean riche, boolean entreprise, Agence agenceLyon, Conseiller conseiller) {

		Client client = new Client(nom, prenom, adresse, codePostal, ville, telephone, riche, false, agenceLyon,
				conseiller);
		int nbClient = conseiller.getNombreClient();

		conseiller.setNombreClient(nbClient++);

		return client;
	}

	public void modifierClient(ServiceCompte serviceCompte, ServiceClient serviceClient, Client client) {
		serviceClient.afficherClient(serviceCompte, client);
		do {
			System.out.println("Quel paramètre client voulez vous modifier ?");

			Scanner sc = new Scanner(System.in);
			selection = sc.nextInt();
			Scanner cs = new Scanner(System.in);

			switch (selection) {
			case (1):
				System.out.println("Veuillez rentrer le nouveau nom");
				nouveau = cs.nextLine();
				client.setNom(nouveau);
				break;
			case (2):
				System.out.println("Veuillez rentrer le nouveau prénom");
				nouveau = cs.nextLine();
				client.setPrenom(nouveau);
				break;

			case (3):
				System.out.println("Veuillez rentrer la nouvelle adresse");
				nouveau = cs.nextLine();
				client.setAdresse(nouveau);
				break;

			case (4):
				System.out.println("Veuillez rentrer le nouveau code postal");
				nouveau = cs.nextLine();
				client.setCodePostal(nouveau);
				break;

			case (5):
				System.out.println("Veuillez rentrer la nouvelle ville");
				nouveau = cs.nextLine();
				client.setVille(nouveau);
				break;

			case (6):
				System.out.println("Veuillez rentrer le nouveau numéro de téléphone");
				nouveau = cs.nextLine();
				client.setTelephone(nouveau);
				break;
			case (8):
				serviceCompte.modifierCompte(serviceCompte, client);
			default:
				System.out.println("Choix non reconnu");
			}
		} while (selection != 1 && selection != 2 && selection != 3 && selection != 4 && selection != 5
				&& selection != 6 && selection != 7);
	}

	public void supprimer() {
	}

	public void virement() {
	}

	public void simulationCreditConso() {
	}

	public void simulationCreditImmo() {
	}
}
