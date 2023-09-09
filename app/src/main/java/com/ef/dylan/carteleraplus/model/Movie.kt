package com.ef.dylan.carteleraplus.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "movie")
@Parcelize
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    @SerializedName("original_title")
    var titulo : String,
    @SerializedName("overview")
    var sinopsis : String,
    @SerializedName("original_language")
    var idioma : String,
    @SerializedName("poster_path")
    var poster: String,
    @SerializedName("release_date")
    var fechaLanzamiento: String,
    @SerializedName("vote_average")
    var puntuacion : Double,
    var isFavorite : Boolean = false
) : Parcelable

/*fun getData() : List<Movie> {
    return listOf(
        Movie("John Wick 3: Parabellum", "/rktDFPbfHfUbArZ6OOOKsXcv0Bm.jpg", "2019-05-17", 9.8),
        Movie("The Flash", "/gPbM0MK8CP8A174rmUwGsADNYKD.jpg", "2023-06-13", 6.5),
        Movie("Barbie", "/iuFNMS8U5cb6xfzi51Dbkovj7vM.jpg", "2023-07-19", 8.2)
    )
}*/