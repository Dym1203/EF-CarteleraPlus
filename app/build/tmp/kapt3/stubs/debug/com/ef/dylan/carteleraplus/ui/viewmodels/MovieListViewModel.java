package com.ef.dylan.carteleraplus.ui.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/ef/dylan/carteleraplus/ui/viewmodels/MovieListViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_movies", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/ef/dylan/carteleraplus/model/Movie;", "movies", "Landroidx/lifecycle/LiveData;", "getMovies", "()Landroidx/lifecycle/LiveData;", "repository", "Lcom/ef/dylan/carteleraplus/data/repository/MovieRepository;", "getMoviesFromService", "", "app_debug"})
public final class MovieListViewModel extends androidx.lifecycle.ViewModel {
    private androidx.lifecycle.MutableLiveData<java.util.List<com.ef.dylan.carteleraplus.model.Movie>> _movies;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.ef.dylan.carteleraplus.model.Movie>> movies = null;
    private final com.ef.dylan.carteleraplus.data.repository.MovieRepository repository = null;
    
    public MovieListViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ef.dylan.carteleraplus.model.Movie>> getMovies() {
        return null;
    }
    
    public final void getMoviesFromService() {
    }
}