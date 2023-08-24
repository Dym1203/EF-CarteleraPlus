package com.ef.dylan.carteleraplus.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ef.dylan.carteleraplus.data.db.MovieDatabase
import com.ef.dylan.carteleraplus.data.repository.MovieDbRepository
import com.ef.dylan.carteleraplus.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailViewModel(application: Application): AndroidViewModel(application) {

    private val repository : MovieDbRepository
    init {
        val db = MovieDatabase.getDatabase(application)
        repository = MovieDbRepository(db)
    }

    fun addMoviesFavorites(movie : Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addMovieToFavorites(movie)
        }
    }

}