package com.ef.dylan.carteleraplus.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ef.dylan.carteleraplus.model.Movie

@Dao
interface MovieDao {

    @Insert
    suspend fun addMovieToFavorite(movie : Movie)

    @Query("SELECT * FROM movie")
    suspend fun getMovieFavorites() : List<Movie>

    @Delete
    suspend fun removeMovieFromFavorites(movie : Movie)

    @Query("SELECT EXISTS (SELECT 1 FROM movie WHERE id = :movieId)")
    suspend fun isMovieFavorite(movieId : Int) : Boolean

}