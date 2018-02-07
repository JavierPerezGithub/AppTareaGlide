package com.example.a21650521.apptareaglide;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.a21650521.apptareaglide.dataJson.Pokemon;
import com.example.a21650521.apptareaglide.dataJson.PokemonForm;
import com.example.a21650521.apptareaglide.recyclerViewUtils.ItemPokemon;
import com.example.a21650521.apptareaglide.retrofitUtils.RestServicePokemon;
import com.example.a21650521.apptareaglide.retrofitUtils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FotoPokemonActivity extends AppCompatActivity {

    ImageView iPokemon;
    private String idRecuperado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto_pokemon);
        iPokemon = findViewById(R.id.imPokemon);
        idRecuperado = getIntent().getStringExtra(getResources().getString(R.string.clave_cod_pokemon));
        invocarWS();
    }

    private void invocarWS() {
        if(isNetworkAvailable()){
            Retrofit rt = RetrofitClient.getClient(RestServicePokemon.BASE_URL);
            RestServicePokemon rsp = rt.create(RestServicePokemon.class);

            Call<PokemonForm> call = rsp.obtenerFotoPokemon(idRecuperado);
            call.enqueue(new Callback<PokemonForm>() {
                @Override
                public void onResponse(Call<PokemonForm> call, Response<PokemonForm> response) {

                    if (!response.isSuccessful()) {
                        Log.e("Error", response.code() +"");
                    }else {
                        //vuelco el contenido del Json en una clase que corresponda. En este caso de la clase PokemonForm
                        PokemonForm pokeForm = response.body();
                        //selecciono la url dentro del contenido de PokeForm
                        String url = pokeForm.getPokemonFoto().getFrontDefault();
                        //String url2 = pokeForm.getPokemonFoto().getBackDefault();
                        Glide.with(iPokemon.getContext())
                                .load(url)
                                .into(iPokemon);

                        //TODO hacer otro Glide para sacar la foto por detrás
                    }
                }

                @Override
                public void onFailure(Call<PokemonForm> call, Throwable t) {
                    Log.e("error",t.toString());
                }
            });
        }
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