
package models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Pokemon {
    private List<Ability> abilities = null;
    private Integer base_experience;
    private List<Form> forms = null;
    private List<Game_index> game_indices = null;
    private Integer height;
    private List<Held_item> held_items = null;
    private Integer id;
    private Boolean is_default;
    private String location_area_encounters;
    private List<Move> moves = null;
    private String name;
    private Integer order;
    private List<Object> past_types = null;
    private Species species;
    private List<Stat> stats = null;
    private List<Type> types = null;
    private Integer weight;
}
