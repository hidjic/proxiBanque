package service;

public class ServiceCompte {
	
	/**
	 * Retourne le nouveau solde du compte � d�biter
	 * @param somme
	 * @param solde
	 * @return
	 */
	public double debiter(double somme, double solde) {
		double newSolde;
		newSolde = solde - somme;
		return newSolde;
	}
	
	/**
	 * Retourne le nouveau solde du compte � cr�diter
	 * @param somme
	 * @param solde
	 * @return
	 */
	public double crediter(double somme, double solde) {
		double newSolde;
		newSolde = solde + somme;
		return newSolde;
	}
	
	
}
