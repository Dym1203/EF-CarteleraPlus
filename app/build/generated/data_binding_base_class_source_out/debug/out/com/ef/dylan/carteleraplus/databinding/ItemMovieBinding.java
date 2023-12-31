// Generated by view binder compiler. Do not edit!
package com.ef.dylan.carteleraplus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator;
import com.ef.dylan.carteleraplus.R;
import com.google.android.material.imageview.ShapeableImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemMovieBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final CircularProgressIndicator cpiPuntuacion;

  @NonNull
  public final CardView cvItemMovie;

  @NonNull
  public final ShapeableImageView imgmovieposter;

  private ItemMovieBinding(@NonNull CardView rootView,
      @NonNull CircularProgressIndicator cpiPuntuacion, @NonNull CardView cvItemMovie,
      @NonNull ShapeableImageView imgmovieposter) {
    this.rootView = rootView;
    this.cpiPuntuacion = cpiPuntuacion;
    this.cvItemMovie = cvItemMovie;
    this.imgmovieposter = imgmovieposter;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemMovieBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemMovieBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_movie, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemMovieBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cpiPuntuacion;
      CircularProgressIndicator cpiPuntuacion = ViewBindings.findChildViewById(rootView, id);
      if (cpiPuntuacion == null) {
        break missingId;
      }

      CardView cvItemMovie = (CardView) rootView;

      id = R.id.imgmovieposter;
      ShapeableImageView imgmovieposter = ViewBindings.findChildViewById(rootView, id);
      if (imgmovieposter == null) {
        break missingId;
      }

      return new ItemMovieBinding((CardView) rootView, cpiPuntuacion, cvItemMovie, imgmovieposter);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
