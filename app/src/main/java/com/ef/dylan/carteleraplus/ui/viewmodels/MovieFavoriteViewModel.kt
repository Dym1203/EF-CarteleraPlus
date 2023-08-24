package com.ef.dylan.carteleraplus.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ef.dylan.carteleraplus.data.db.MovieDatabase
import com.ef.dylan.carteleraplus.data.repository.MovieDbRepository
import com.ef.dylan.carteleraplus.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieFavoriteViewModel(application: Application): AndroidViewModel(application) {

    private val repository : MovieDbRepository
    private var _moviesfavorites : MutableLiveData<List<Movie>> = MutableLiveData()
    var moviesfavorite : LiveData<List<Movie>> = _moviesfavorites

    init {
        val db = MovieDatabase.getDatabase(application)
        repository = MovieDbRepository(db)
    }

    fun getMoviesFavorite() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getMoviesFavorite()
            _moviesfavorites.postValue(data)
        }
    }

}