package com.ef.dylan.carteleraplus.data.retrofit

import com.ef.dylan.carteleraplus.data.response.ListMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("now_playing")
    suspend fun getMoviesnowPlaying(@Query("api_key") apiKey: String) : ListMovieResponse
}