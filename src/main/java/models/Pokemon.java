
package models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
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

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public Integer getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(Integer base_experience) {
        this.base_experience = base_experience;
    }

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    public List<Game_index> getGame_indices() {
        return game_indices;
    }

    public void setGame_indices(List<Game_index> game_indices) {
        this.game_indices = game_indices;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public List<Held_item> getHeld_items() {
        return held_items;
    }

    public void setHeld_items(List<Held_item> held_items) {
        this.held_items = held_items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIs_default() {
        return is_default;
    }

    public void setIs_default(Boolean is_default) {
        this.is_default = is_default;
    }

    public String getLocation_area_encounters() {
        return location_area_encounters;
    }

    public void setLocation_area_encounters(String location_area_encounters) {
        this.location_area_encounters = location_area_encounters;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<Object> getPast_types() {
        return past_types;
    }

    public void setPast_types(List<Object> past_types) {
        this.past_types = past_types;
    }

    public Species getSpecies() {
        return species;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

}
