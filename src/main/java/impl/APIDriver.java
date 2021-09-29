package impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import models.Move;
import models.Pokemon;
import roster.PokemonStarter;

public class APIDriver {
	
    public static void main(String[] args) {
    	
    }

    // Convert the complex Pokemon object into a simple PokemonStarter object with a defined move set.
    private static PokemonStarter createPokemonStarter(Pokemon pokemon) throws IOException {
    	return null;
    }

    // Given a list of potential moves, choose up to 4 at random.
    private static Set <String> generateRandomMoveSet(List <Move> moves) {
    	return null;
    }

    // Make the API request to PokeAPI and return the response as a Pokemon object
    private static Pokemon getPokemonFromAPI(String pokemonName) throws MalformedURLException, IOException {
    	return null;
    }
}