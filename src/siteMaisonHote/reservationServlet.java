package siteMaisonHote;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import siteMaisonHote.Client;
import siteMaisonHote.ListeClients;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class reservationServlet
 */
@WebServlet("/reservationServlet")
public class reservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public reservationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("listeClients", ListeClients.getInstance().getListeClients());
		getServletContext().getRequestDispatcher("/afficherListeClients.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		// récupère les données du formulaire
		String resNom = request.getParameter("nom");
		String resPrenom = request.getParameter("prenom");
		String resEmail = request.getParameter("email");
		String resNTelephone = request.getParameter("nTelephone");
		String resArrivee = request.getParameter("arrivee");
		String resNuits = request.getParameter("nuits");
		String resGroupeRadio = request.getParameter("groupeRadio");
		String resNbPersonne = request.getParameter("nbPersonne");
		String resParking = request.getParameter("parking");
		String resAnimal = request.getParameter("animal");
		String resParapluie = request.getParameter("parapluie");
		String resFumeur = request.getParameter("fumeur");
		String resRegion = request.getParameter("region");

		// crée instance et transfert dans la classe java
		Client client = new Client();
		client.setNom(resNom);
		client.setPrenom(resPrenom);
		client.setEmail(resEmail);
		client.setnTelephone(resNTelephone);
		client.setArrivee(resArrivee);
		client.setNuits(resNuits);
		client.setGroupeRadio(resGroupeRadio);
		client.setNbPersonne(resNbPersonne);
		client.setParking(resParking);
		client.setAnimal(resAnimal);
		client.setParapluie(resParapluie);
		client.setFumeur(resFumeur);
		client.setRegion(resRegion);

		ListeClients.getInstance().ajoutClient(client);

		JdbcListeClient jdbcListeClient = new JdbcListeClient();

		try {
			jdbcListeClient.connectToDB();
			System.out.println("connexion ok");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			jdbcListeClient.insertData(resNom, resPrenom, resEmail, resNTelephone, resArrivee, resNuits, resGroupeRadio, resNbPersonne, resParking, resAnimal, resParapluie, resFumeur, resRegion);
			System.out.println("insert ok");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		jdbcListeClient.close();
		System.out.println("fermeture ok");

		request.setAttribute("client", client);
		request.setAttribute("listeClients", ListeClients.getInstance().getListeClients());
		// envoie la requete vers showRecup.jsp
		this.getServletContext().getRequestDispatcher("/showRecup.jsp").forward(request, response);

	}

}
