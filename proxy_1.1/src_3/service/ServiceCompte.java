package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import proxybanque.domainecompte.CCourant;
import proxybanque.domainecompte.CEpargne;
import proxybanque.domainecompte.Carte;
import proxybanque.domainecompte.TypeCarte;
import proxybanque.domaineentity.Client;

public class ServiceCompte {
	private int selection;
	private int solde;
	private char choix;
	private Carte carte;

	/**
	 * @param serviceCompte
	 * @param client
	 */
	public void creationCompte(ServiceCompte serviceCompte, Client client) {

		do {
			System.out.println("Quel type de compte voulez vous assigner ?");
			System.out.println("1 - Compte courant");
			System.out.println("2 - Compte épargne");
			System.out.println("3 - Compte courant et compte épargne");

			Scanner sc = new Scanner(System.in);
			selection = sc.nextInt();

			switch (selection) {
			case (1):
				serviceCompte.creationCompteCourant(client);
				break;
			case (2):
				serviceCompte.creationCompteEpargne(client);
				break;
			case (3):
				serviceCompte.creationCompteCourant(client);
				serviceCompte.creationCompteEpargne(client);
				break;
			default:
				System.out.println("Choix non reconnu");
			}
		} while (selection != 1 && selection != 2 && selection != 3);
	}

	/**
	 * @param client
	 */
	private void creationCompteCourant(Client client) {
		SimpleDateFormat formater = null;
		Date today = new Date();
		formater = new SimpleDateFormat("dd/MM/yy");
		CCourant compteCourant = new CCourant(formater.format(today), client);
		System.out.println("Compte courant créé");
		System.out.println("Quel type de carte voulez vous assigner à ce compte ?");
		System.out.println("1 - " + TypeCarte.ELECTRON);
		System.out.println("2 - " + TypeCarte.PREMIER);
		do {
			Scanner sc = new Scanner(System.in);
			selection = sc.nextInt();
			if (selection == 1)
				compteCourant.setCarte(carte = new Carte(TypeCarte.ELECTRON));
			else if (selection == 2)
				compteCourant.setCarte(carte = new Carte(TypeCarte.PREMIER));
			else
				System.out.println("Choix non reconnu, veuillez recommencer");
		} while (selection != 1 && selection != 2);
		client.setCompteCourant(compteCourant);
	}

	/**
	 * @param client
	 */
	private void creationCompteEpargne(Client client) {
		SimpleDateFormat formater = null;
		Date today = new Date();
		formater = new SimpleDateFormat("dd/MM/yy");
		CEpargne compteEpargne = new CEpargne(formater.format(today), client);
		System.out.println("Compte épargne créé");
		client.setCompteEpargne(compteEpargne);

	}

	public void modifierCompte(ServiceCompte serviceCompte, Client client) {
		Scanner cs = new Scanner(System.in);

		boolean securite;
		do {
			securite = true;
			System.out.println("Quel modification voulez vous effectuer ?");
			System.out.println("1 - Supprimer compte");
			System.out.println("2 - ajout compte");
			if (client.getCompteCourant() != null && client.getCompteEpargne() == null)
				System.out.println("3 - modifier le découvert autorisé");
			else if (client.getCompteCourant() == null && client.getCompteEpargne() != null)
				System.out.println("3 - modifier le taux d'intéret");
			else {
				securite = false;
				System.out.println("3 - modifier le découvert autorisé");
				System.out.println("4 - modifier le taux d'intéret");
			}

			Scanner sc = new Scanner(System.in);
			selection = sc.nextInt();

			switch (selection) {
			case (1):
				serviceCompte.supprimerCompte(serviceCompte, client);
				break;
			case (2):
				serviceCompte.ajoutCompte(serviceCompte, client);
				break;
			case (3):
				if (client.getCompteCourant() != null && client.getCompteEpargne() == null) {
					System.out.println("Veuillez entrer un nouveau découvert autorisé");
					int nouveau = cs.nextInt();
					client.getCompteCourant().setDecouvert(nouveau);
				} else if (client.getCompteCourant() == null && client.getCompteEpargne() != null) {
					System.out.println("Veuillez entrer un nouveau taux d'intéret");
					int nouveau = cs.nextInt();
					client.getCompteEpargne().setTaux(nouveau);
				}
				break;
			case (4):
				if (client.getCompteCourant() != null && client.getCompteEpargne() != null) {
					System.out.println("Veuillez entrer un nouveau taux d'intéret");

					int nouveau = cs.nextInt();
					client.getCompteEpargne().setTaux(nouveau);
				}
				break;
			default:
				System.out.println("Choix non reconnu");
			}
			if (securite == true && selection != 1 && selection != 2 && selection != 3)
				selection = 5;
		} while (selection != 1 && selection != 2 && selection != 3 && selection != 4);
	}

	public void supprimerCompte(ServiceCompte serviceCompte, Client client) {
		boolean securite;
		do {
			securite = true;
			System.out.println("Quel compte voulez vous supprimer ?");
			if (client.getCompteCourant() != null && client.getCompteEpargne() == null)
				System.out.println("1 - " + client.getCompteCourant());
			else if (client.getCompteCourant() == null && client.getCompteEpargne() != null)
				System.out.println("1 - " + client.getCompteEpargne());
			else {
				securite = false;
				System.out.println("1 - " + client.getCompteCourant());
				System.out.println("2 - " + client.getCompteEpargne());
			}
			Scanner sc = new Scanner(System.in);
			selection = sc.nextInt();

			switch (selection) {
			case (1):
				if (client.getCompteCourant() != null)
					client.setCompteCourant(null);
				else if (client.getCompteCourant() == null && client.getCompteEpargne() != null)
					client.setCompteEpargne(null);
				break;
			case (2):
				if (client.getCompteCourant() != null && client.getCompteEpargne() != null)
					client.setCompteEpargne(null);
				break;
			default:
				System.out.println("Choix non reconnu");
			}
			if (securite == true && selection != 1)
				selection = 3;
		} while (selection != 1 && selection != 2);
	}

	public void ajoutCompte(ServiceCompte serviceCompte, Client client) {
		if (client.getCompteCourant() == null || client.getCompteEpargne() == null) {

			if (client.getCompteCourant() == null) {
				System.out.println("Voulez vous ajouter un nouveau compte courant ? O/N");
				Scanner sc = new Scanner(System.in);
				char choix = sc.nextLine().charAt(0);
				if (choix == 'O')
					serviceCompte.creationCompteCourant(client);
				else
					serviceCompte.ajoutCompte(serviceCompte, client);
			} else {
				System.out.println("Voulez vous ajouter un nouveau compte épargne ? O/N");
				if (choix == 'O')
					serviceCompte.creationCompteEpargne(client);
				else
					serviceCompte.ajoutCompte(serviceCompte, client);
			}
		} else
			System.out.println("Il n'est pas possible d'ajouter de nouveau compte");

	}
	// System.out.println("Veuillez spécifier le solde :");
	// Scanner sc = new Scanner(System.in);
	// solde = sc.nextInt();
	// compteCourant.setSolde(solde);
	// System.out.println("Voulez vous changer le découvert autoriser ? O/N");
	// Scanner cs = new Scanner(System.in);
	// choix = cs.nextLine().charAt(0);
	// while (choix != 'O' && choix != 'N') {
	// System.out.println("Choix non reconnu, recommencez");
	// choix = sc.nextLine().charAt(0);
	// }
	// if (choix =='O')
	// System.out.println("Veuillez rentrer un nouveau découvert autorisé");
	// Scanner cs = new Scanner(System.in);
	// = cs.nextLine().charAt(0);
}
