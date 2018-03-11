package siteMaisonHote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


	public class JdbcListeClient {

		// connexion à la BDD pour l'insertion des donn�es
		private final static String BDPATH = "jdbc:mysql://localhost:3306/siteMaisonHote";
		private final static String DBUSER = "root";
		private final static String DBPASSWORD = "blubbulb";

		private static Connection connection;

		private static Statement statement = null;
		private static ResultSet resultSet = null;


		public void connectToDB() throws Exception {
	        try {
	            // This will load the MySQL driver, each DB has its own driver
	            Class.forName("com.mysql.jdbc.Driver");

	            // Setup the connection with the DB
	            //connect = DriverManager.getConnection(
	            //        "jdbc:mysql://" + host + "/" + database + "?" + "user=" + user + "&password=" + passwd);
				connection = DriverManager.getConnection(BDPATH, DBUSER, DBPASSWORD);
	            System.out.println("Connection OK");

	        } catch (Exception e) {
	            System.out.println("Pas de connection !");
	            throw e;
	        }
	    }

	public void close() {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }

	            if (statement != null) {
	                statement.close();
	            }

	            if (connection != null) {
	                connection.close();
	            }
	        } catch (Exception e) {

	        }
	    }

		public void insertData(String nom, String prenom, String email, String nTelephone, String arrivee, String nuits, String groupeRadio, String nbPersonne, String parking, String animal, String parapluie, String fumeur, String region) throws SQLException
		{
			Statement statement = null;

			try {
				statement = connection.createStatement();
				System.out.println("statement ok");
				if (parking == null) {
					parking = "non";
				} else {
					parking = "oui";
				}
				String sql = "INSERT INTO `listedesclients` (`nom`, `prenom`, `email`, `nTelephone`, `arrivee`, `nuits`, `groupeRadio`, `nbPersonne`, `parking`, `animal`, `parapluie`, `fumeur`, `region`) VALUES ('" + nom + "', '" + prenom + "', '" + email + "', '" + nTelephone + "', '" + arrivee + "', '" + nuits + "', '" + groupeRadio + "', '" + nbPersonne + "', '" + parking + "', '" + animal + "', '" + parapluie + "', '" + fumeur + "', '" + region + "')";
				System.out.println("insert ok");
				statement.executeUpdate(sql);
				System.out.println("Exe ok");
			}
			catch(SQLException e) {
				System.out.println("Erreur de connection !");
			}
			finally {
				statement.close();
			}

			System.out.println();
		}

		public static void showData() throws SQLException
		{
			Statement statement = null;
			ResultSet rs = null;

		}
	}
