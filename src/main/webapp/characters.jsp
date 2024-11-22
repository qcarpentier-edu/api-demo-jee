<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Personnages de Star Wars</title>
</head>
<body>
	<h1>Liste des personnages</h1>
	<ul>
		<% 
			// Récupérer les personnages de ma requête
			org.json.JSONArray characters = (org.json.JSONArray) request.getAttribute("characters");
			if (characters == null) {
				out.println("<li>Aucun personnage trouvé.</li>");
			} else {
				for (int i = 0; i < characters.length(); i++) {
					// Récupérer le personnage
					org.json.JSONObject character = characters.getJSONObject(i);
					out.println("<li>" + character.getString("name") + "</li>");
				}
			}
		%>
		<a href="index.html">Retour à l'accueil</a>
	</ul>
</body>
</html>