package service;

public class ServiceCompte {
	
	/**
	 * Retourne le nouveau solde du compte à débiter
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
	 * Retourne le nouveau solde du compte à créditer
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
