package com.ef.dylan.carteleraplus.data.response

import com.ef.dylan.carteleraplus.model.Movie
import com.google.gson.annotations.SerializedName

data class ListMovieResponse (

    @SerializedName("results")
    var movies : List<Movie>

)