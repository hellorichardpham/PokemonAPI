package roster;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Roster {
	private List<PokemonFighter> pokemonList;
	
	public String toString() {
		String returnString = "";
		for(PokemonFighter fighter : pokemonList) {
			returnString += fighter + "\n";
		}
		return returnString;
	}
}
