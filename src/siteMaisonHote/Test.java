package siteMaisonHote;

public class Test {

	public static void main(String[] args) throws Exception {
		
		JdbcListeClient test = new JdbcListeClient();
		test.connectToDB();
		test.insertData("nom", "prenom", "email", "nTelephone", "arrivee", "nuits", "groupeRadio", "nbPersonne", "parking", "animal", "parapluie", "fumeur", "region");
		test.close();
	}
		
}