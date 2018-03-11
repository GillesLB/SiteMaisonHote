<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="siteMaisonHote.Client"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des réservations</title>
<link rel="stylesheet" href="style.css" />
<link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="all" />
</head>

<body>
	<!-- affiche le contenu de l'ArrayList listeClients (pas dans la BDD) -->
	<table class="striped">
		<tr>
			<th>Nom</th>
			<th>Prénom</th>
			<th>E-mail</th>
			<th>Télephone</th>
			<th>Date d'arrivée</th>
			<th>Nb de nuits</th>
			<th>Nature du séjour</th>
			<th>Nb de personne</th>
			<th>Parking</th>
			<th>Animal</th>
			<th>Parapluie</th>
			<th>Fumeur</th>
			<th>Région d'origine</th>
		</tr>
		<%
			SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy");
			Collection<Client> listeClients = (Collection<Client>) request.getAttribute("listeClients");
			if (listeClients != null) {
				Iterator it = listeClients.iterator();
				while (it.hasNext()) {
					Client serveur = (Client) it.next();
		%>
		<tr>
			<td><%=serveur.getNom()%></td>
			<td><%=serveur.getPrenom()%></td>
			<td><%=serveur.getEmail()%></td>
			<td><%=serveur.getnTelephone()%></td>
			<td><%=serveur.getArrivee()%></td>
			<td><%=serveur.getNuits()%></td>
			<td><%=serveur.getGroupeRadio()%></td>
			<td><%=serveur.getNbPersonne()%></td>
			<td>
				<%
					if (serveur.getParking() == null)
								out.println("non");
							else {
								out.println("oui");
							}
				%>
			</td>
			<td>
				<%
					if (serveur.getAnimal() == null)
								out.println("non");
							else {
								out.println("oui");
							}
				%>
			</td>
			<td>
				<%
					if (serveur.getParapluie() == null)
								out.println("non");
							else {
								out.println("oui");
							}
				%>
			</td>
			<td>
				<%
					if (serveur.getFumeur() == null)
								out.println("non");
							else {
								out.println("oui");
							}
				%>
			</td>
			<td><%
					if (serveur.getRegion() == null)
								out.println("non renseignée");
							else {
								out.println(serveur.getRegion());
							}
				%>
			</td>
		</tr>
		<%
			}
			}
		%>
	</table>
	<a class="waves-effect waves-light btn" href="index.html">Retour à l'accueil</a>
</body>
</html>