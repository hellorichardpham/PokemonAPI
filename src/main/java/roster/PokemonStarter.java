package roster;

import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import models.Stat;

@Getter
@Setter
public class PokemonStarter {
	private String name;
	private Set<String> moveSet;
    private List<Stat> stats;
    
    private String getFormattedMoves() {
    	String moves = "";
    	for (String s : moveSet) {
    		moves += s + "\n";
    	}
    	return moves;
    }
    
    private String getFormattedStats() {
    	String formattedStats = "";
    	for (Stat stat : stats) {
    		String statName = stat.getStat().getName();
    		Integer statValue = stat.getBase_stat();
    		formattedStats += statName + ": " + statValue + "\n";
    	}
    	return formattedStats;
    }
    
    public String toString() {
    	return "Name: " + name + "\n\nMoves: \n" + this.getFormattedMoves() + "\n" + "Stats: \n" + this.getFormattedStats(); 
    }
}
