<%@page import="siteMaisonHote.Client"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Formulaire de réservation</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
      <link rel="stylesheet" href="style.css"/>
      <!-- Import Calendar -->
      <link rel="stylesheet" href="calendrier.css">
      <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="all"/>
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body style="background-color:#f1f8e9">

	<!-- affiche le récapitulatif, avant de valider -->
	<%  
 		Client client = (Client) request.getAttribute("client");
 		int base = 100;
 	%>

	<p>Formulaire de réservation</p>
	<br>
	<p>Nom : <b><%=client.getNom()%></b></p>
	<p>Prénom : <b><%=client.getPrenom()%></b></p>
	<p>E-mail : <b><%=client.getEmail()%></b></p>
	<p>Numéro de téléphone : <b><%=client.getnTelephone()%></b></p>
	<p>Date arrivée : <b><%=client.getArrivee()%></b></p>
	<p>Nombre de nuits : <b><%=client.getNuits()%></b></p>
	<p>Nature du séjour : <b><%=client.getGroupeRadio()%></b></p>
	<p>Nombre de personne : <b><%=client.getNbPersonne() %></b></p>
	<p>Parking : <b><% if (client.getParking() == null)
		out.println("non");
		else {
		base += 5;
		out.println("oui");
		} %></b></p>
	<p>Animal : <b><% if (client.getAnimal() == null)
		out.println("non");
		else {
		base += 10;
		out.println("oui");
		} %></b></p>
	<p>Parapluie : <b><% if (client.getParapluie() == null)
		out.println("non");
		else {
		base += 5;
		out.println("oui");
		} %></b></p>
	<p>Fumeur : <b><% if (client.getFumeur() == null)
		out.println("non");
		else
		out.println("oui"); %></b></p>
	<p>Région d'origine : <b>
		<%
			if (client.getRegion() == null)
			out.println("non renseignée");
			else {
			out.println(client.getRegion());
			} %></b></p>
		<%
			int nbN = Integer.parseInt(client.getNuits());
			int nbP = Integer.parseInt(client.getNbPersonne());
			if (nbP == 2)
				base += 50;
			else if (nbP == 3)
				base += 80;
			else if(nbP == 4)
				base += 100;
			int prix = base * nbN;
		%>
	<br>
	<p>Le prix total sera de  <b><%=prix %></b> euros !</p><br>

	<p>Souhaitez-vous confirmer ?</p>

	<div class="row">
		<div class="col s6">
 			<a class="waves-effect waves-light btn" href="formulaire_fr.html">
  			<i class="material-icons right">sentiment_very_dissatisfied</i>Annuler</a>
 		</div>
		<div class="col s6">
 			<a class="waves-effect waves-light btn" href="reservationServlet">
  			<i class="material-icons right">sentiment_very_satisfied</i>Valider</a>
		</div>
	</div>

		 <!--Import jQuery before materialize.js-->
      <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
      <script src="js/materialize.min.js"></script>

	</body>
</html>
