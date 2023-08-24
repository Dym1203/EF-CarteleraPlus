package com.ef.dylan.carteleraplus.data.repository

import com.ef.dylan.carteleraplus.data.MovieServiceResult
import com.ef.dylan.carteleraplus.data.response.ListMovieResponse
import com.ef.dylan.carteleraplus.data.retrofit.RetrofitHelper

class MovieRepository(private val apiKey : String) {

    suspend fun getMovies() : MovieServiceResult<ListMovieResponse> {
        return try {
            val response = RetrofitHelper.movieService.getMoviesnowPlaying("63d5d0b9cad1af86d5ebb3651456acc6")
            MovieServiceResult.Success(response)
        }
        catch (e : Exception) {
            MovieServiceResult.Error(e)
        }
    }

}