package com.ef.dylan.carteleraplus.ui.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.ef.dylan.carteleraplus.R
import com.ef.dylan.carteleraplus.model.Movie
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class MovieFavoriteFragmentDirections private constructor() {
  private data class ActionMovieFavoriteFragmentToMovieDetailFragment(
    public val movie: Movie
  ) : NavDirections {
    public override val actionId: Int = R.id.action_movieFavoriteFragment_to_movieDetailFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(Movie::class.java)) {
          result.putParcelable("movie", this.movie as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(Movie::class.java)) {
          result.putSerializable("movie", this.movie as Serializable)
        } else {
          throw UnsupportedOperationException(Movie::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun actionMovieFavoriteFragmentToMovieDetailFragment(movie: Movie): NavDirections =
        ActionMovieFavoriteFragmentToMovieDetailFragment(movie)
  }
}
