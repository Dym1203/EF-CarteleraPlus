package com.ef.dylan.carteleraplus.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/movie/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val movieService : MovieService = retrofit.create(MovieService::class.java)
}
//https://api.themoviedb.org/3/discover/movie?api_key=63d5d0b9cad1af86d5ebb3651456acc6