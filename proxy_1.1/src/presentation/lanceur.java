package presentation;

import java.text.SimpleDateFormat;
import java.util.Date;

import proxybanque.domainecompte.CCourant;
import proxybanque.domainecompte.CEpargne;
import proxybanque.domaineentity.Client;
import service.ServiceConseiller;

public class lanceur {

	public static void main(String[] args) {

		SimpleDateFormat formater = null;
		Date today = new Date();
		formater = new SimpleDateFormat("dd/MM/yy");
		System.out.println(formater.format(today));
		
		
		
		
		Client c = new Client();
		ServiceConseiller servC = new ServiceConseiller();
		
		CCourant cc = new CCourant(today.toString(),c);
		CEpargne ce = new CEpargne(today.toString(),c);
		
		System.out.println(cc.getSolde());
		cc.setSolde(-950);
		System.out.println(cc.getSolde());
		System.out.println(servC.virement(100, cc, cc));
		
		System.out.println(ce.getSolde());
		ce.setSolde(200);
		System.out.println(ce.getSolde());
		System.out.println(servC.virement(100, ce, cc));
		
		
	}

}
