package br.com.up.pokedex.connection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import br.com.up.pokedex.PokeListActivity;
import br.com.up.pokedex.model.Ability;
import br.com.up.pokedex.model.Move;
import br.com.up.pokedex.model.Pokemon;
import br.com.up.pokedex.model.ResponseDetail;
import br.com.up.pokedex.model.Stat;
import br.com.up.pokedex.model.Type;

public class PokeAPI {
    public void getPokemonDetails(String url, OnPokeAPIDetailListener listener){
        PokeConnectionAsyncTask asyncTask = new PokeConnectionAsyncTask(new PokeConnectionAsyncTask.OnRequestListener() {
            @Override
            public void onRequestFinish(JSONObject object) {
                ArrayList<Ability> abilities = new ArrayList<>();
                ArrayList<Move> moves = new ArrayList<>();
                ArrayList<Stat> stats = new ArrayList<>();
                ArrayList<Type> types = new ArrayList<>();
                ResponseDetail detail = new ResponseDetail();

                try {
                    JSONArray results = object.getJSONArray("abilities");
                    JSONArray resultsStat = object.getJSONArray("stats");
                    JSONArray resultsMove = object.getJSONArray("moves");
                    JSONArray resultsType = object.getJSONArray("types");

                    for (int index = 0; index < results.length(); index++) {
                        JSONObject pokeObject = results.getJSONObject(index);

                        Ability ability = new Ability();
                        ability.setName(pokeObject.getJSONObject("ability").getString("name"));
                        ability.setUrl(pokeObject.getJSONObject("ability").getString("url"));

                        abilities.add(ability);

                    }

                    for (int index = 0; index < resultsStat.length(); index++) {
                        JSONObject pokeObject = resultsStat.getJSONObject(index);

                        Stat stat = new Stat();
                        stat.setName(pokeObject.getJSONObject("stat").getString("name"));
                        stat.setUrl(pokeObject.getJSONObject("stat").getString("url"));

                        stats.add(stat);

                    }

                    for (int index = 0; index < resultsMove.length(); index++) {
                        JSONObject pokeObject = resultsMove.getJSONObject(index);

                        Move move = new Move();
                        move.setName(pokeObject.getJSONObject("move").getString("name"));
                        move.setUrl(pokeObject.getJSONObject("move").getString("url"));

                        moves.add(move);

                    }

                    for (int index = 0; index < resultsType.length(); index++) {
                        JSONObject pokeObject = resultsType.getJSONObject(index);

                        Type type = new Type();
                        type.setName(pokeObject.getJSONObject("type").getString("name"));
                        type.setUrl(pokeObject.getJSONObject("type").getString("url"));

                        types.add(type);
                    }

                    detail.setAbilities(abilities);
                    detail.setMoves(moves);
                    detail.setStats(stats);
                    detail.setTypes(types);

                    listener.onFinish(detail);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        asyncTask.execute(url, "GET");
    }

    public void getPokemons(OnPokeAPIListener listener){

        PokeConnectionAsyncTask asyncTask = new PokeConnectionAsyncTask(new PokeConnectionAsyncTask.OnRequestListener() {
            @Override
            public void onRequestFinish(JSONObject object) {
                try {
                    ArrayList<Pokemon> pokemons = new ArrayList<>();

                    JSONArray results = object.getJSONArray("results");

                    for(int index = 0 ; index < results.length() ; index++){
                        JSONObject pokeObject = results.getJSONObject(index);

                        int id = 1 + index;

                        Pokemon pokemon = new Pokemon();
                        pokemon.setId(id);
                        pokemon.setName(pokeObject.getString("name"));
                        pokemon.setImage("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"+id+".png");
                        pokemon.setUrl(pokeObject.getString("url"));

                        pokemons.add(pokemon);

                        //pokemons.add(
                        //    new Pokemon(id, pokeObject.getString("name"),"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"+id+".png"), pokeObject.getString("url"));
                    }

                    listener.onFinish(pokemons);
                    //recycleViewPokeList.getAdapter().notifyDataSetChanged();
                } catch (Exception e) {
                    listener.onFinish(null);
                }
            }
        });
        //tem trigger para executar o doInBackground
        asyncTask.execute("https://pokeapi.co/api/v2/pokemon?limit=151", "GET");

    }

    public interface OnPokeAPIListener {
        void onFinish(ArrayList<Pokemon> pokemons);
    }

    public interface OnPokeAPIDetailListener {
        void onFinish(ResponseDetail detail);
    }
}
