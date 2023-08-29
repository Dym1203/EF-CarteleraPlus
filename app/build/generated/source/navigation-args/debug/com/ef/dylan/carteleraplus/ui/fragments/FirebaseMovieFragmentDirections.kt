package com.ef.dylan.carteleraplus.ui.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.ef.dylan.carteleraplus.R
import com.ef.dylan.carteleraplus.model.TVSerie
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class FirebaseMovieFragmentDirections private constructor() {
  private data class ActionFirebaseMovieFragmentToTVSerieDetailFragment(
    public val tvserie: TVSerie
  ) : NavDirections {
    public override val actionId: Int = R.id.action_firebaseMovieFragment_to_TVSerieDetailFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(TVSerie::class.java)) {
          result.putParcelable("tvserie", this.tvserie as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(TVSerie::class.java)) {
          result.putSerializable("tvserie", this.tvserie as Serializable)
        } else {
          throw UnsupportedOperationException(TVSerie::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun actionFirebaseMovieFragmentToTVSerieDetailFragment(tvserie: TVSerie): NavDirections =
        ActionFirebaseMovieFragmentToTVSerieDetailFragment(tvserie)
  }
}
