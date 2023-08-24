// Generated by view binder compiler. Do not edit!
package com.ef.dylan.carteleraplus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator;
import com.ef.dylan.carteleraplus.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemTvserieBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final CircularProgressIndicator cpiPuntuacionSerie;

  @NonNull
  public final CardView cvItemSerietv;

  @NonNull
  public final ImageView imgserieposter;

  @NonNull
  public final TextView txtserieoriginallanguage;

  @NonNull
  public final TextView txtserieorigincountry;

  @NonNull
  public final TextView txtseriepopularity;

  @NonNull
  public final TextView txtserietitle;

  private ItemTvserieBinding(@NonNull CardView rootView,
      @NonNull CircularProgressIndicator cpiPuntuacionSerie, @NonNull CardView cvItemSerietv,
      @NonNull ImageView imgserieposter, @NonNull TextView txtserieoriginallanguage,
      @NonNull TextView txtserieorigincountry, @NonNull TextView txtseriepopularity,
      @NonNull TextView txtserietitle) {
    this.rootView = rootView;
    this.cpiPuntuacionSerie = cpiPuntuacionSerie;
    this.cvItemSerietv = cvItemSerietv;
    this.imgserieposter = imgserieposter;
    this.txtserieoriginallanguage = txtserieoriginallanguage;
    this.txtserieorigincountry = txtserieorigincountry;
    this.txtseriepopularity = txtseriepopularity;
    this.txtserietitle = txtserietitle;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemTvserieBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemTvserieBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_tvserie, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemTvserieBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cpiPuntuacionSerie;
      CircularProgressIndicator cpiPuntuacionSerie = ViewBindings.findChildViewById(rootView, id);
      if (cpiPuntuacionSerie == null) {
        break missingId;
      }

      CardView cvItemSerietv = (CardView) rootView;

      id = R.id.imgserieposter;
      ImageView imgserieposter = ViewBindings.findChildViewById(rootView, id);
      if (imgserieposter == null) {
        break missingId;
      }

      id = R.id.txtserieoriginallanguage;
      TextView txtserieoriginallanguage = ViewBindings.findChildViewById(rootView, id);
      if (txtserieoriginallanguage == null) {
        break missingId;
      }

      id = R.id.txtserieorigincountry;
      TextView txtserieorigincountry = ViewBindings.findChildViewById(rootView, id);
      if (txtserieorigincountry == null) {
        break missingId;
      }

      id = R.id.txtseriepopularity;
      TextView txtseriepopularity = ViewBindings.findChildViewById(rootView, id);
      if (txtseriepopularity == null) {
        break missingId;
      }

      id = R.id.txtserietitle;
      TextView txtserietitle = ViewBindings.findChildViewById(rootView, id);
      if (txtserietitle == null) {
        break missingId;
      }

      return new ItemTvserieBinding((CardView) rootView, cpiPuntuacionSerie, cvItemSerietv,
          imgserieposter, txtserieoriginallanguage, txtserieorigincountry, txtseriepopularity,
          txtserietitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}