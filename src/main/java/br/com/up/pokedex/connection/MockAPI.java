package br.com.up.pokedex.connection;

import java.util.ArrayList;

import br.com.up.pokedex.model.Pokemon;

public class MockAPI {

    public static ArrayList<Pokemon> getPokemons(){
        ArrayList<Pokemon> pokemons = new ArrayList<>();

        //pokemons.add(new Pokemon(1, "bulbasaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png"));
        //pokemons.add(new Pokemon(2, "ivysaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/2.png"));
        //pokemons.add(new Pokemon(3, "venusaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/3.png"));

        //pokemons.add(new Pokemon(4, "charmander", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/4.png"));
        //pokemons.add(new Pokemon(5, "charmeleon", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/5.png"));
        //pokemons.add(new Pokemon(6, "charizard", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/6.png"));

        return pokemons;
    }
}
