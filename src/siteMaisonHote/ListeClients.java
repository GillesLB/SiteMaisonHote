package siteMaisonHote;

import java.util.*;

public class ListeClients {

	private final static ListeClients INSTANCE = new ListeClients();
	private final ArrayList<Client> listeClients = new ArrayList<Client>();

	private ListeClients(){
	}

	public static ListeClients getInstance() {
		return INSTANCE;
	}

	public ArrayList<Client> getListeClients(){
		return listeClients;
	}

	public void ajoutClient (Client client) {
		listeClients.add(client);
	}

}
