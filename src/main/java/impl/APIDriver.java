package impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Pokemon;

public class APIDriver {

	public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
		try {
			json = getHTML("https://pokeapi.co/api/v2/pokemon/ditto");
			System.out.println("json: " + json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        try {
            Pokemon pokemon = mapper.readValue(json, Pokemon.class);
            System.out.println("ability: " + pokemon.getAbilities().get(0).getAbility().getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
	}

	   public static String getHTML(String urlToRead) throws Exception {
	      StringBuilder result = new StringBuilder();
	      URL url = new URL(urlToRead);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setRequestMethod("GET");
	      try (BufferedReader reader = new BufferedReader(
	                  new InputStreamReader(conn.getInputStream()))) {
	          for (String line; (line = reader.readLine()) != null; ) {
	              result.append(line);
	          }
	      }
	      return result.toString();
	   }
}
