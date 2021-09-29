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
	private static final int NUM_ROSTER_SPOTS = 6;
	
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < NUM_ROSTER_SPOTS; i++) {
                System.out.println("Enter a pokemon name.");
                final String pokemonName = sc.nextLine().toLowerCase();
                
            }
        }
    }

    // Make the API request to PokeAPI and return the response as a Pokemon object
    private static Pokemon getPokemonFromAPI(String pokemonName) throws MalformedURLException, IOException {
    	return null;
    }
    
    private static PokemonStarter createPokemonStarter(Pokemon pokemon) throws IOException {
    	return null;
    }

    // Given a list of potential moves, choose up to 4 at random.
    private static Set <String> generateRandomMoveSet(List <Move> moves) {
    	return null;
    }
}