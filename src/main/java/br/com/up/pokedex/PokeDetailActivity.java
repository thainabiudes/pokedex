package br.com.up.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import android.os.Bundle;
import android.telecom.Call;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import br.com.up.pokedex.connection.PokeAPI;
import br.com.up.pokedex.model.Ability;
import br.com.up.pokedex.model.Move;
import br.com.up.pokedex.model.Pokemon;
import br.com.up.pokedex.model.ResponseDetail;
import br.com.up.pokedex.model.Stat;
import br.com.up.pokedex.model.Type;
import okhttp3.Response;

public class PokeDetailActivity extends AppCompatActivity{
    private ResponseDetail detail;
    private ArrayList<Ability> abilities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_detail);

        String pokemonName = getIntent().getExtras().getString("nome");
        String pokemonImage = getIntent().getExtras().getString("img");

        ImageView imageView = (ImageView) findViewById(R.id.image_detail);
        Picasso.get().load(pokemonImage).into(imageView);

        TextView textViewTitle = (TextView)findViewById(R.id.title_detail);
        textViewTitle.setText(pokemonName);

        String json = getIntent().getExtras().getString("detail");
        this.detail = new Gson().fromJson(json, ResponseDetail.class);

        ListView listViewAbilities = (ListView) findViewById(R.id.listDetail);
        TextView textViewAbilities = (TextView)findViewById(R.id.titleAbility);

        textViewAbilities.setText("Abilities");

        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, this.getAbilities());
        listViewAbilities.setAdapter(arr);

        // ------------------- Moves

        ListView listViewMoves = (ListView) findViewById(R.id.listDetailMove);
        TextView textViewMoves = (TextView)findViewById(R.id.titleMove);

        textViewMoves.setText("Moves");

        ArrayAdapter<String> arrMoves;
        arrMoves = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, this.getMoves());
        listViewMoves.setAdapter(arrMoves);

        // ------------------- Stats

        ListView listViewStats = (ListView) findViewById(R.id.listDetailStat);
        TextView textViewStats = (TextView)findViewById(R.id.titleStat);

        textViewStats.setText("Stats");

        ArrayAdapter<String> arrStats;
        arrStats = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, this.getStats());
        listViewStats.setAdapter(arrStats);

        // ------------------- Types

        ListView listViewTypes = (ListView) findViewById(R.id.listDetailType);
        TextView textViewTypes = (TextView)findViewById(R.id.titleType);

        textViewTypes.setText("Types");

        ArrayAdapter<String> arrTypes;
        arrTypes = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, this.getTypes());
        listViewTypes.setAdapter(arrTypes);

    }

    private String[] getAbilities() {
        List<String> abilitiesName = new ArrayList<>();

        this.detail.getAbilities().stream().forEach(p -> abilitiesName.add(p.getName()));
        String[] abilitiesArray = new String[abilitiesName.size()];
        abilitiesName.toArray(abilitiesArray);

        return abilitiesArray;
    }

    private String[] getMoves() {
        List<String> movesName = new ArrayList<>();

        this.detail.getMoves().stream().forEach(p -> movesName.add(p.getName()));
        String[] movesArray = new String[movesName.size()];
        movesName.toArray(movesArray);

        return movesArray;
    }

    private String[] getStats() {
        List<String> statsName = new ArrayList<>();

        this.detail.getStats().stream().forEach(p -> statsName.add(p.getName()));
        String[] statsArray = new String[statsName.size()];
        statsName.toArray(statsArray);

        return statsArray;
    }

    private String[] getTypes() {
        List<String> typesName = new ArrayList<>();

        this.detail.getTypes().stream().forEach(p -> typesName.add(p.getName()));
        String[] typesArray = new String[typesName.size()];
        typesName.toArray(typesArray);

        return typesArray;
    }

}