package com.ef.dylan.carteleraplus.ui.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.ef.dylan.carteleraplus.model.Movie
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class MovieDetailFragmentArgs(
  public val movie: Movie
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(Movie::class.java)) {
      result.set("movie", this.movie as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Movie::class.java)) {
      result.set("movie", this.movie as Serializable)
    } else {
      throw UnsupportedOperationException(Movie::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): MovieDetailFragmentArgs {
      bundle.setClassLoader(MovieDetailFragmentArgs::class.java.classLoader)
      val __movie : Movie?
      if (bundle.containsKey("movie")) {
        if (Parcelable::class.java.isAssignableFrom(Movie::class.java) ||
            Serializable::class.java.isAssignableFrom(Movie::class.java)) {
          __movie = bundle.get("movie") as Movie?
        } else {
          throw UnsupportedOperationException(Movie::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__movie == null) {
          throw IllegalArgumentException("Argument \"movie\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"movie\" is missing and does not have an android:defaultValue")
      }
      return MovieDetailFragmentArgs(__movie)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): MovieDetailFragmentArgs {
      val __movie : Movie?
      if (savedStateHandle.contains("movie")) {
        if (Parcelable::class.java.isAssignableFrom(Movie::class.java) ||
            Serializable::class.java.isAssignableFrom(Movie::class.java)) {
          __movie = savedStateHandle.get<Movie?>("movie")
        } else {
          throw UnsupportedOperationException(Movie::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__movie == null) {
          throw IllegalArgumentException("Argument \"movie\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"movie\" is missing and does not have an android:defaultValue")
      }
      return MovieDetailFragmentArgs(__movie)
    }
  }
}
