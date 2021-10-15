package br.com.up.pokedex.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Pokemon implements Serializable {
    private int id;
    private String name;
    private String url;
    private String image;
    private String genre;
    private ArrayList<String> types;
    private ArrayList<String> stats;
    private ArrayList<String> moves;
    private ArrayList<String> abilities;

    public Pokemon() {}

    public Pokemon(int id, String name, String image, String url) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.url = url;
    }

    public ArrayList<String> getStats() {
        return stats;
    }

    public void setStats(ArrayList<String> stats) {
        this.stats = stats;
    }

    public ArrayList<String> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<String> moves) {
        this.moves = moves;
    }

    public ArrayList<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<String> abilities) {
        this.abilities = abilities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}