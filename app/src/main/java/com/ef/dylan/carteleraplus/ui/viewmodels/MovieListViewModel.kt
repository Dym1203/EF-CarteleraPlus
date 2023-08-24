package com.ef.dylan.carteleraplus.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ef.dylan.carteleraplus.data.MovieServiceResult
import com.ef.dylan.carteleraplus.data.repository.MovieRepository
import com.ef.dylan.carteleraplus.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieListViewModel : ViewModel() {

    private var _movies : MutableLiveData<List<Movie>> = MutableLiveData<List<Movie>>()
    val movies : LiveData<List<Movie>> = _movies

    private val repository = MovieRepository("63d5d0b9cad1af86d5ebb3651456acc6")

    fun getMoviesFromService() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getMovies()
            when (response) {
                is MovieServiceResult.Success -> {
                    _movies.postValue(response.data.movies)
                }
                is MovieServiceResult.Error -> {
                    /**/
                }
            }
        }
    }

}