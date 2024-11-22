package be.condorcet;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.http.client.fluent.Request;
import org.json.JSONObject;
import org.json.JSONArray;

public class StarWarsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SWAPI_URL = "https://swapi.dev/api/people";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Appel à l'API SWAPI -> recevoir une réponse en String
			String jsonResponse = HttpClientHelper.fetch(SWAPI_URL);

			JSONObject jsonObject = new JSONObject(jsonResponse);
			JSONArray characters = jsonObject.getJSONArray("results");
			
			// Stocker les données à la requête
			request.setAttribute("characters", characters);
			
			// Forward à la JSP
			request.getRequestDispatcher("characters.jsp").forward(request, response);
		} catch (Exception e) {
			response.getWriter().write("Erreur : " + e.getMessage());
		}
	}
}
