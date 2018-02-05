package com.example.a21650521.apptareaglide.retrofitUtils;

import com.example.a21650521.apptareaglide.dataJson.Pokemon;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 21650521 on 05/02/2018.
 */

public interface RestServicePokemon {
    public static final String BASE_URL = "https://pokeapi.co/api/v2/";

    @GET("pokemon/")
    Call<Pokemon> obtenerPokemon(@Query("limit") String limite);
}
