package com.ef.dylan.carteleraplus.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TVSerie(
    @SerializedName("name")
    val titulo : String,
    @SerializedName("origin_country")
    val pais : String,
    @SerializedName("original_language")
    val idioma : String,
    @SerializedName("overview")
    val sinopsis : String,
    @SerializedName("popularity")
    val popularidad : Double,
    @SerializedName("vote_average")
    val puntuacion : Double,
    @SerializedName("poster_path")
    val poster : String
) : Parcelable