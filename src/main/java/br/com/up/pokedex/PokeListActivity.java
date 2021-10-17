package br.com.up.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import com.google.gson.Gson;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import br.com.up.pokedex.adapter.PokeAdapter;
import br.com.up.pokedex.connection.MockAPI;
import br.com.up.pokedex.connection.PokeAPI;
import br.com.up.pokedex.connection.PokeConnectionAsyncTask;
import br.com.up.pokedex.model.Ability;
import br.com.up.pokedex.model.Pokemon;
import br.com.up.pokedex.model.ResponseDetail;

public class PokeListActivity extends AppCompatActivity {
    private RecyclerView recycleViewPokeList;
    private ArrayList<Pokemon> pokemons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleViewPokeList = findViewById(R.id.recycler_poke_list);
        recycleViewPokeList.setLayoutManager(new GridLayoutManager(this, 3));

//        ArrayList<Pokemon> pokemons = MockAPI.getPokemons();

        recycleViewPokeList.setAdapter(new PokeAdapter(pokemons, new PokeAdapter.OnPokemonClickListener() {
            @Override
            public void onPokemonClick(Pokemon pokemon) {
                //System.out.println(pokemon.getUrl());

                new PokeAPI().getPokemonDetails(pokemon.getUrl(), new PokeAPI.OnPokeAPIDetailListener() {
                    @Override
                    public void onFinish(ResponseDetail detail) {
                        Intent intent = new Intent(PokeListActivity.this, PokeDetailActivity.class);

                        String jsonDetail = new Gson().toJson(detail);
                        intent.putExtra("detail", jsonDetail);
                        intent.putExtra("nome", pokemon.getName());

                        startActivity(intent);
                    }
                });

            }
        }));

        new PokeAPI().getPokemons(new PokeAPI.OnPokeAPIListener() {
            @Override
            public void onFinish(ArrayList<Pokemon> pokemons) {
                PokeListActivity.this.pokemons.addAll(pokemons); //add na lista principal global
                recycleViewPokeList.getAdapter().notifyDataSetChanged(); //ação de atualizar o adapter
            }
        });

    }
}