package service;

import proxybanque.domainecompte.CCourant;
import proxybanque.domainecompte.CEpargne;

public class ServiceConseiller implements GestionClientFortunes {
	
	// faire un contructeur avec les services comptes instanci�
	
	public void creerClient() {
	}

	public void modifierClient() {
	}

	public void lireInfoClient() {
	}

	public void supprimer() {
	}
	
	
	/**
	 * 
	 * @param somme
	 * @param myCCDebiter
	 * @param myCCCrediter
	 * @return
	 */
	public String virement(double somme, CCourant myCCDebiter, CCourant myCCCrediter) {
		// virement refus� car solde insuffisant
		if((myCCDebiter.getSolde() - somme) < (-myCCDebiter.getDecouvert())) {
			return "Op�ration refus� : autorisation d�couvert insuffisant";
		}else { // le virement est accept�
			ServiceCompte servC = new ServiceCompte();
			myCCDebiter.setSolde(servC.debiter(somme, myCCDebiter.getSolde()));
			myCCCrediter.setSolde(servC.crediter(somme, myCCCrediter.getSolde()));
			return "Le virement est accept�";
		}
	}
	
	public String virement(double somme, CEpargne myCEDebiter, CEpargne myCECrediter) {
		// virement refus� car solde insuffisant
		if((myCEDebiter.getSolde() - somme) < 0) {
			return "Op�ration refus� : solde n�gatif interdit";
		}else {	// le virement est accept�
			ServiceCompte servC = new ServiceCompte();
			myCEDebiter.setSolde(servC.debiter(somme, myCEDebiter.getSolde()));
			myCECrediter.setSolde(servC.crediter(somme, myCECrediter.getSolde()));
			return "Le virement est accept�";
		}
	}
	
	public String virement(double somme, CCourant myCCDebiter, CEpargne myCECrediter) {
		// virement refus� car solde insuffisant
		if((myCCDebiter.getSolde() - somme) < (-myCCDebiter.getDecouvert())) {
			return "Op�ration refus� : autorisation d�couvert insuffisant";
		}else { // le virement est accept�
			ServiceCompte servC = new ServiceCompte();
			myCCDebiter.setSolde(servC.debiter(somme, myCCDebiter.getSolde()));
			myCECrediter.setSolde(servC.crediter(somme, myCECrediter.getSolde()));
			return "Le virement est accept�";
		}
	}

	public String virement(double somme, CEpargne myCEDebiter, CCourant myCCCrediter) {
		// virement refus� car solde insuffisant
		if((myCEDebiter.getSolde() - somme) < 0) {
			return "Op�ration refus� : solde n�gatif interdit";
		}else {	// le virement est accept�
			ServiceCompte servC = new ServiceCompte();
			myCEDebiter.setSolde(servC.debiter(somme, myCEDebiter.getSolde()));
			myCCCrediter.setSolde(servC.crediter(somme, myCCCrediter.getSolde()));
			return "Le virement est accept�";
		}
	}

	public String simulationCreditConso() {
		return "Au vue de votre situation, vous pouvez obtenir un cr�dit � la consomation de 10 000� � 10% remboursable sur 48 mois.";
	}

	public String simulationCreditImmo() {
		return "Au vue de votre situation, vous pouvez obtenir un cr�dit immobilier de 500 000� � 15%; rembousable 360 mois.";
	}

	@Override
	public String gestionPatrimoine() {
		return "Nous vous proposons des placements non toxique sur les bourses de Paris, New-York et Tokyo.";		
	}
}
