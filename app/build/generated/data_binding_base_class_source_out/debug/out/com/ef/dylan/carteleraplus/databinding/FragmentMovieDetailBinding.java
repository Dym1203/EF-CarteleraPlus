// Generated by view binder compiler. Do not edit!
package com.ef.dylan.carteleraplus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ef.dylan.carteleraplus.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentMovieDetailBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final MaterialButton btnAddFavorite;

  @NonNull
  public final MaterialButton btnRemoveFavorite;

  @NonNull
  public final ShapeableImageView imgDetalleMoviePosterPath;

  @NonNull
  public final TextView tvDetalleMovieOriginalLanguage;

  @NonNull
  public final TextView tvDetalleMovieOverview;

  @NonNull
  public final TextView tvDetalleMovieReleaseDate;

  @NonNull
  public final TextView tvDetalleMovieTitle;

  @NonNull
  public final TextView tvDetalleMovieVoteAverage;

  private FragmentMovieDetailBinding(@NonNull ConstraintLayout rootView,
      @NonNull MaterialButton btnAddFavorite, @NonNull MaterialButton btnRemoveFavorite,
      @NonNull ShapeableImageView imgDetalleMoviePosterPath,
      @NonNull TextView tvDetalleMovieOriginalLanguage, @NonNull TextView tvDetalleMovieOverview,
      @NonNull TextView tvDetalleMovieReleaseDate, @NonNull TextView tvDetalleMovieTitle,
      @NonNull TextView tvDetalleMovieVoteAverage) {
    this.rootView = rootView;
    this.btnAddFavorite = btnAddFavorite;
    this.btnRemoveFavorite = btnRemoveFavorite;
    this.imgDetalleMoviePosterPath = imgDetalleMoviePosterPath;
    this.tvDetalleMovieOriginalLanguage = tvDetalleMovieOriginalLanguage;
    this.tvDetalleMovieOverview = tvDetalleMovieOverview;
    this.tvDetalleMovieReleaseDate = tvDetalleMovieReleaseDate;
    this.tvDetalleMovieTitle = tvDetalleMovieTitle;
    this.tvDetalleMovieVoteAverage = tvDetalleMovieVoteAverage;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMovieDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMovieDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_movie_detail, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMovieDetailBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnAddFavorite;
      MaterialButton btnAddFavorite = ViewBindings.findChildViewById(rootView, id);
      if (btnAddFavorite == null) {
        break missingId;
      }

      id = R.id.btnRemoveFavorite;
      MaterialButton btnRemoveFavorite = ViewBindings.findChildViewById(rootView, id);
      if (btnRemoveFavorite == null) {
        break missingId;
      }

      id = R.id.imgDetalleMoviePosterPath;
      ShapeableImageView imgDetalleMoviePosterPath = ViewBindings.findChildViewById(rootView, id);
      if (imgDetalleMoviePosterPath == null) {
        break missingId;
      }

      id = R.id.tvDetalleMovieOriginalLanguage;
      TextView tvDetalleMovieOriginalLanguage = ViewBindings.findChildViewById(rootView, id);
      if (tvDetalleMovieOriginalLanguage == null) {
        break missingId;
      }

      id = R.id.tvDetalleMovieOverview;
      TextView tvDetalleMovieOverview = ViewBindings.findChildViewById(rootView, id);
      if (tvDetalleMovieOverview == null) {
        break missingId;
      }

      id = R.id.tvDetalleMovieReleaseDate;
      TextView tvDetalleMovieReleaseDate = ViewBindings.findChildViewById(rootView, id);
      if (tvDetalleMovieReleaseDate == null) {
        break missingId;
      }

      id = R.id.tvDetalleMovieTitle;
      TextView tvDetalleMovieTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvDetalleMovieTitle == null) {
        break missingId;
      }

      id = R.id.tvDetalleMovieVoteAverage;
      TextView tvDetalleMovieVoteAverage = ViewBindings.findChildViewById(rootView, id);
      if (tvDetalleMovieVoteAverage == null) {
        break missingId;
      }

      return new FragmentMovieDetailBinding((ConstraintLayout) rootView, btnAddFavorite,
          btnRemoveFavorite, imgDetalleMoviePosterPath, tvDetalleMovieOriginalLanguage,
          tvDetalleMovieOverview, tvDetalleMovieReleaseDate, tvDetalleMovieTitle,
          tvDetalleMovieVoteAverage);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
