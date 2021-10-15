package br.com.up.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.telecom.Call;

import com.google.gson.Gson;

import java.util.ArrayList;

import br.com.up.pokedex.connection.PokeAPI;
import br.com.up.pokedex.model.Ability;
import br.com.up.pokedex.model.Move;
import br.com.up.pokedex.model.Pokemon;
import br.com.up.pokedex.model.ResponseDetail;
import br.com.up.pokedex.model.Stat;
import br.com.up.pokedex.model.Type;
import okhttp3.Response;

public class PokeDetailActivity extends AppCompatActivity {
    private ResponseDetail detail;
    private ArrayList<Ability> abilities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_detail);

        String json = getIntent().getExtras().getString("detail");
        ResponseDetail detail = new Gson().fromJson(json, ResponseDetail.class);

        System.out.println(detail);
    }

}