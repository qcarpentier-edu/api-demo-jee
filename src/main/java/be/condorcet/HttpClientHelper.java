package be.condorcet;

import java.io.IOException;
import org.apache.http.client.fluent.Response;
import org.apache.http.client.fluent.Request;

public class HttpClientHelper {
	// Méthode qui fetch les données (req. Get) et qui réponds sous forme de String
	public static String fetch(String url) throws IOException {
		// Requête GET avec l'API HTTPComponents (Fluent)
		Response response = Request.Get(url).execute();
		
		// Retourne la réponse sous forme de String
		return response.returnContent().asString();
	}
}
