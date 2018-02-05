package com.example.a21650521.apptareaglide;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a21650521.apptareaglide.dataJson.Pokemon;
import com.example.a21650521.apptareaglide.dataJson.PokemonResult;
import com.example.a21650521.apptareaglide.recyclerViewUtils.AdaptadorPokemon;
import com.example.a21650521.apptareaglide.recyclerViewUtils.ItemPokemon;
import com.example.a21650521.apptareaglide.retrofitUtils.RestServicePokemon;
import com.example.a21650521.apptareaglide.retrofitUtils.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListPokemonActivity extends AppCompatActivity {
    private String numPokemon;
    private ProgressBar pb;
    private ArrayList<ItemPokemon>lista;
    private RecyclerView rv;
    private AdaptadorPokemon ap;
    private LinearLayoutManager llm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pokemon);


        lista = new ArrayList<ItemPokemon>();
        numPokemon = getIntent().getStringExtra(getResources()
                .getString(R.string.clave_num_pokemon));
        pb = findViewById(R.id.pbPokemon);
        pb.setVisibility(View.VISIBLE);
        invocarWS();

    }

    private void configurarRecyclerView() {
        rv = findViewById(R.id.rvPokemon);
        rv.setHasFixedSize(true);
        llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        ap = new AdaptadorPokemon(lista);
        rv.setAdapter(ap);
    }

    private void invocarWS() {
        if(isNetworkAvailable()){
            Retrofit rt = RetrofitClient.getClient(RestServicePokemon.BASE_URL);
            RestServicePokemon rsp = rt.create(RestServicePokemon.class);
            Call<Pokemon> call = rsp.obtenerPokemon(numPokemon);

            call.enqueue(new Callback<Pokemon>() {
                @Override
                public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                    pb.setVisibility(View.GONE);

                    if (!response.isSuccessful()) {
                        Log.e("Error", response.code() +"");
                    }else {
                        Pokemon pokeRes = response.body();
                        String url ="";
                        ItemPokemon ip = null;
                        for(PokemonResult poke: pokeRes.getResults()){
                           ip = new ItemPokemon(obtenerCodigo(poke.getUrl()),poke.getName());
                           lista.add(ip);
                        }
                        configurarRecyclerView();
                    }
                }

                @Override
                public void onFailure(Call<Pokemon> call, Throwable t) {
                    pb.setVisibility(View.GONE);
                    Log.e("error",t.toString());
                }
            });
        }
    }

    private String obtenerCodigo(String url){
        String codigo = "";
        String aux ="pokemon/";
        int i = 0; // indice de pokemon\/ + el tamaño de esta cadena
        int j = 0; // último indice \/

        i = url.lastIndexOf(aux) + aux.length();
        j = url.lastIndexOf("/");
        codigo = url.substring(i,j);
        return codigo;
    }

    private boolean isNetworkAvailable() {
        boolean isAvailable=false;
        //Gestor de conectividad
        ConnectivityManager manager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        //Objeto que recupera la información de la red
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        //Si la información de red no es nula y estamos conectados
        //la red está disponible
        if(networkInfo!=null && networkInfo.isConnected()){
            isAvailable=true;
        }
        return isAvailable;
    }
}
