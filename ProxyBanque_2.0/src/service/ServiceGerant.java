package service;

import java.util.ArrayList;

import proxybanque.domainecompte.CCourant;
import proxybanque.domainecompte.CEpargne;
import proxybanque.domaineentity.Client;

public class ServiceGerant {
	
	public void audit() {
		ArrayList<Client> listClient = new ArrayList<Client>();
		listClient = createClientList();
		
		for(Client c : listClient) {
			if(!c.isEntreprise() && c.getCompteCourant().getSolde() < -5000) {
				
			}
			if(c.isEntreprise() && c.getCompteCourant().getSolde() < -50000) {
				
			}
		}
	}
	
	private ArrayList<Client> createClientList(){
		ArrayList<Client> listClient = new ArrayList<Client>();
//		ServiceConseiller servC = new ServiceConseiller();
		Client c1 = new Client(	"Gaillard", "Pierre", "1 cours Lafayette", 
								"69006", "Lyon", "0123456789", false, false);
		CCourant cc1 = new CCourant("12/12/2012",c1);
		cc1.setSolde(1000);
		CEpargne ce1 = new CEpargne("21/08/2013", c1);
		ce1.setSolde(10000);
		
		
		Client c2 = new Client(	"Barbier", "Paul", "2 cours Lafayette",
								"69006", "Lyon", "0134567892", false, false);
		CEpargne ce2 = new CEpargne("21/08/2013", c1);
		ce1.setSolde(100000);
		
		Client c3 = new Client(	"Agostini", "Jean", "20 cours Lafayette",
								"69006", "Lyon", "0134567892", true, false);
		CCourant cc3 = new CCourant("12/12/2012",c1);
		cc1.setSolde(100000);
		CEpargne ce3 = new CEpargne("21/08/2013", c1);
		ce1.setSolde(800000);
		
		Client c4 = new Client(	"Raoult", "Alain", "18 cours Lafayette",
								"69006", "Lyon", "0134567892", false, false);
		CCourant cc4 = new CCourant("12/12/2012",c1);
		cc1.setSolde(2500);
		CEpargne ce4 = new CEpargne("21/08/2013", c1);
		ce1.setSolde(8000);
		
		Client c5 = new Client(	"Fabre", "Valérie", "150 cours Lafayette",
								"69006", "Lyon", "0134567892", false, true);
		CCourant cc5 = new CCourant("12/12/2012",c1);
		cc1.setSolde(100000);
		CEpargne ce5 = new CEpargne("21/08/2013", c1);
		ce1.setSolde(300000);
		
		Client c6 = new Client(	"Domingues", "Laurence", "87 cours Lafayette",
								"69006", "Lyon", "0134567892", false, false);
		CCourant cc6 = new CCourant("12/12/2012",c1);
		cc1.setSolde(500);
		
		Client c7 = new Client(	"Bouyer", "Louis", "65 cours Lafayette",
								"69006", "Lyon", "0134567892", true, false);
		CEpargne ce7 = new CEpargne("21/08/2013", c1);
		ce1.setSolde(700000);
		
		Client c8 = new Client(	"Franck", "David", "42 cours Lafayette",
								"69006", "Lyon", "0134567892", false, true);
		CCourant cc8 = new CCourant("12/12/2012",c1);
		cc1.setSolde(100000);
		
		Client c9 = new Client(	"Kieffer", "Nolwen", "15 cours Lafayette",
								"69006", "Lyon", "0134567892", false, true);
		CCourant cc9 = new CCourant("12/12/2012",c1);
		cc1.setSolde(1000);
		
		Client c10 = new Client(	"Cuvelier", "Samuel", "94 cours Lafayette",
									"69006", "Lyon", "0134567892", true, false);
		CCourant cc10 = new CCourant("12/12/2012",c1);
		cc1.setSolde(100000);
		CEpargne ce10 = new CEpargne("21/08/2013", c1);
		ce1.setSolde(500000);
		
		listClient.add(c1);
		listClient.add(c2);
		listClient.add(c3);
		listClient.add(c4);
		listClient.add(c5);
		listClient.add(c6);
		listClient.add(c7);
		listClient.add(c8);
		listClient.add(c9);
		listClient.add(c10);
		
		
		
		return listClient;
	}
	
}
