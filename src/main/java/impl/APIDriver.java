package impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Move;
import models.Pokemon;
import roster.PokemonFighter;
import roster.Roster;

public class APIDriver {

	public static void main(String[] args) {
		Roster roster = new Roster();
		List<PokemonFighter> pokeList = new ArrayList<PokemonFighter>();
		roster.setPokemonList(pokeList);
	     final Scanner sc = new Scanner(System.in); 
	     for(int i = 0; i < 2; i++) {
	    	 System.out.println("Enter a pokemon name.");
	         final String input = sc.nextLine().toLowerCase(); 
	 		try {
				PokemonFighter fighter = getPokemon(input);
				pokeList.add(fighter);
				System.out.println("Current Roster:\n" + roster);
			} catch (IOException e) {
				System.out.println("An error occurred while trying to retrieve the Pokemon.");
			}
	     }
		System.out.println("Final Roster: \n" + roster);
	}

	private static PokemonFighter getPokemon(String pokemonName) throws IOException {
		PokemonFighter fighter = new PokemonFighter();
		ObjectMapper mapper = new ObjectMapper();
        String json = null;
		json = getHTML("https://pokeapi.co/api/v2/pokemon/" + pokemonName);
		
        Pokemon pokemon = mapper.readValue(json, Pokemon.class);
        final List<Move> moves = pokemon.getMoves();
        Set<String> moveSet = generateRandomMoveSet(moves);
        fighter.setName(pokemonName);
        fighter.setMoveSet(moveSet);
        fighter.setStats(pokemon.getStats());
        return fighter;
	}
	
	private static Set<String> generateRandomMoveSet(List<Move> moves) {
		Set<String> moveSet = new HashSet<String>();
        Collections.shuffle(moves);
        for (int i = 0; (i < moves.size() && i < 4); i++) {
        	String moveName = moves.get(i).getMove().getName();	
        	moveSet.add(moveName);
        }
        return moveSet;
	}
	
   private static String getHTML(String urlToRead) throws MalformedURLException, IOException {
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
