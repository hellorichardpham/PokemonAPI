package impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Move;
import models.Pokemon;
import roster.PokemonStarter;

public class APIDriver {

    public static void main(String[] args) {
        List <PokemonStarter> roster = new ArrayList <PokemonStarter> ();
        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < 2; i++) {
                System.out.println("Enter a pokemon name.");
                final String pokemonName = sc.nextLine().toLowerCase();
                try {
                    Pokemon pokemon = getPokemonFromAPI(pokemonName);
                    PokemonStarter starter = createPokemonStarter(pokemon);
                    roster.add(starter);
                } catch (IOException e) {
                    System.out.println("An error occurred while trying to retrieve the Pokemon.");
                }
            }
        }
        System.out.println("Final Roster:");
        for (PokemonStarter starter : roster) {
        	System.out.println(starter);
        }
    }

    private static PokemonStarter createPokemonStarter(Pokemon pokemon) throws IOException {
        PokemonStarter starter = new PokemonStarter();
        Set<String> moveSet = generateRandomMoveSet(pokemon.getMoves());
        starter.setName(pokemon.getName());
        starter.setMoveSet(moveSet);
        starter.setStats(pokemon.getStats());
        return starter;
    }

    // Given a list of potential moves, choose up to 4 at random.
    private static Set <String> generateRandomMoveSet(List <Move> moves) {
        Set < String > moveSet = new HashSet<String>();
        Collections.shuffle(moves);
        for (int i = 0; (i < moves.size() && i < 4); i++) {
            String moveName = moves.get(i).getMove().getName();
            moveSet.add(moveName);
        }
        return moveSet;
    }

    // Make the API request to PokeAPI and return the response as a Pokemon object
    private static Pokemon getPokemonFromAPI(String pokemonName) throws MalformedURLException, IOException {
        // The ObjectMapper is responsible for turning a string of JSON into a Java object  
    	ObjectMapper mapper = new ObjectMapper();
    	
        try (CloseableHttpClient client = HttpClients.createDefault()) {
        	// Form up the GET request
            HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon/" + pokemonName);
            
            //Execute the GET request
            CloseableHttpResponse httpResponse = client.execute(request);
            
            // Take the JSON response and convert it into a Pokemon Java object.
            Pokemon pokemon = mapper.readValue(httpResponse.getEntity().getContent(), Pokemon.class);
            return pokemon;
        }
    }
}