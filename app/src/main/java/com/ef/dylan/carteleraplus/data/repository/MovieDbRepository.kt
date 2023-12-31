package com.ef.dylan.carteleraplus.data.repository

import com.ef.dylan.carteleraplus.data.db.MovieDao
import com.ef.dylan.carteleraplus.data.db.MovieDatabase
import com.ef.dylan.carteleraplus.model.Movie

class MovieDbRepository(private val db: MovieDatabase? = null) {

    private val dao : MovieDao? = db?.movieDao()

    suspend fun getMoviesFavorite() : List<Movie> {
        dao?.let {
            return dao.getMovieFavorites()
        } ?: kotlin.run {
            return listOf()
        }
    }

    suspend fun addMovieToFavorites(movie : Movie) : Boolean {
        dao?.let {
            val isMovieFavorite = dao.isMovieFavorite(movie.id)
            if (!isMovieFavorite) {
                dao.addMovieToFavorite(movie)
                return true
            }
        }
        return false
    }

    suspend fun removeMovieFromFavorites(movie : Movie) {
        dao?.let {
            dao.removeMovieFromFavorites(movie)
        }
    }

}