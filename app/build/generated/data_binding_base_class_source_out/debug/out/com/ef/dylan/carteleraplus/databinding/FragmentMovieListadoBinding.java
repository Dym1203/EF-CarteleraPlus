// Generated by view binder compiler. Do not edit!
package com.ef.dylan.carteleraplus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ef.dylan.carteleraplus.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentMovieListadoBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RecyclerView rvMovieList;

  @NonNull
  public final TextView tvPeliculasEstreno;

  private FragmentMovieListadoBinding(@NonNull ConstraintLayout rootView,
      @NonNull RecyclerView rvMovieList, @NonNull TextView tvPeliculasEstreno) {
    this.rootView = rootView;
    this.rvMovieList = rvMovieList;
    this.tvPeliculasEstreno = tvPeliculasEstreno;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMovieListadoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMovieListadoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_movie_listado, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMovieListadoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.rv_movie_list;
      RecyclerView rvMovieList = ViewBindings.findChildViewById(rootView, id);
      if (rvMovieList == null) {
        break missingId;
      }

      id = R.id.tvPeliculasEstreno;
      TextView tvPeliculasEstreno = ViewBindings.findChildViewById(rootView, id);
      if (tvPeliculasEstreno == null) {
        break missingId;
      }

      return new FragmentMovieListadoBinding((ConstraintLayout) rootView, rvMovieList,
          tvPeliculasEstreno);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
