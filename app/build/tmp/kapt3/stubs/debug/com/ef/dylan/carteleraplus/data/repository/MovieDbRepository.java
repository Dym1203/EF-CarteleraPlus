package com.ef.dylan.carteleraplus.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/ef/dylan/carteleraplus/data/repository/MovieDbRepository;", "", "db", "Lcom/ef/dylan/carteleraplus/data/db/MovieDatabase;", "(Lcom/ef/dylan/carteleraplus/data/db/MovieDatabase;)V", "dao", "Lcom/ef/dylan/carteleraplus/data/db/MovieDao;", "addMovieToFavorites", "", "movie", "Lcom/ef/dylan/carteleraplus/model/Movie;", "(Lcom/ef/dylan/carteleraplus/model/Movie;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMoviesFavorite", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeMovieFromFavorites", "app_debug"})
public final class MovieDbRepository {
    private final com.ef.dylan.carteleraplus.data.db.MovieDatabase db = null;
    private final com.ef.dylan.carteleraplus.data.db.MovieDao dao = null;
    
    public MovieDbRepository() {
        super();
    }
    
    public MovieDbRepository(@org.jetbrains.annotations.Nullable()
    com.ef.dylan.carteleraplus.data.db.MovieDatabase db) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMoviesFavorite(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ef.dylan.carteleraplus.model.Movie>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addMovieToFavorites(@org.jetbrains.annotations.NotNull()
    com.ef.dylan.carteleraplus.model.Movie movie, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object removeMovieFromFavorites(@org.jetbrains.annotations.NotNull()
    com.ef.dylan.carteleraplus.model.Movie movie, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}