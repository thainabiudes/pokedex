package br.com.up.pokedex.model;

import java.io.Serializable;
import java.util.ArrayList;

public class ResponseDetail implements Serializable {
    private ArrayList<Ability> abilities;
    private ArrayList<Move> moves;
    private ArrayList<Stat> stats;
    private ArrayList<Type> types;

    public ResponseDetail() {}

    public ArrayList<Type> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<Type> types) {
        this.types = types;
    }

    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<Ability> abilities) {
        this.abilities = abilities;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<Move> moves) {
        this.moves = moves;
    }

    public ArrayList<Stat> getStats() {
        return stats;
    }

    public void setStats(ArrayList<Stat> stats) {
        this.stats = stats;
    }
}
