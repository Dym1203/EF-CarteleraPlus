package com.ef.dylan.carteleraplus.ui.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.ef.dylan.carteleraplus.model.TVSerie
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class TVSerieDetailFragmentArgs(
  public val tvserie: TVSerie
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(TVSerie::class.java)) {
      result.set("tvserie", this.tvserie as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(TVSerie::class.java)) {
      result.set("tvserie", this.tvserie as Serializable)
    } else {
      throw UnsupportedOperationException(TVSerie::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): TVSerieDetailFragmentArgs {
      bundle.setClassLoader(TVSerieDetailFragmentArgs::class.java.classLoader)
      val __tvserie : TVSerie?
      if (bundle.containsKey("tvserie")) {
        if (Parcelable::class.java.isAssignableFrom(TVSerie::class.java) ||
            Serializable::class.java.isAssignableFrom(TVSerie::class.java)) {
          __tvserie = bundle.get("tvserie") as TVSerie?
        } else {
          throw UnsupportedOperationException(TVSerie::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__tvserie == null) {
          throw IllegalArgumentException("Argument \"tvserie\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"tvserie\" is missing and does not have an android:defaultValue")
      }
      return TVSerieDetailFragmentArgs(__tvserie)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): TVSerieDetailFragmentArgs {
      val __tvserie : TVSerie?
      if (savedStateHandle.contains("tvserie")) {
        if (Parcelable::class.java.isAssignableFrom(TVSerie::class.java) ||
            Serializable::class.java.isAssignableFrom(TVSerie::class.java)) {
          __tvserie = savedStateHandle.get<TVSerie?>("tvserie")
        } else {
          throw UnsupportedOperationException(TVSerie::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__tvserie == null) {
          throw IllegalArgumentException("Argument \"tvserie\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"tvserie\" is missing and does not have an android:defaultValue")
      }
      return TVSerieDetailFragmentArgs(__tvserie)
    }
  }
}
