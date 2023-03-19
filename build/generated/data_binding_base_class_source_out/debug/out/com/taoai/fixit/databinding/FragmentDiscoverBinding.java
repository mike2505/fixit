// Generated by view binder compiler. Do not edit!
package com.taoai.fixit.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.taoai.fixit.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentDiscoverBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final TextView adv1;

  @NonNull
  public final TextView adv11;

  @NonNull
  public final TextView adv2;

  @NonNull
  public final TextView adv21;

  @NonNull
  public final TextView adv3;

  @NonNull
  public final TextView adv31;

  @NonNull
  public final ImageView checkv10;

  @NonNull
  public final ImageView checkv11;

  @NonNull
  public final ImageView checkv20;

  @NonNull
  public final ImageView checkv21;

  @NonNull
  public final ImageView checkv30;

  @NonNull
  public final ImageView checkv31;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final ImageView imageView10;

  @NonNull
  public final ImageView imageView11;

  @NonNull
  public final ImageView logo1;

  @NonNull
  public final TextView name1;

  @NonNull
  public final TextView name2;

  @NonNull
  public final TextView name3;

  @NonNull
  public final View productTop1;

  @NonNull
  public final View productTop2;

  @NonNull
  public final View productTop3;

  @NonNull
  public final EditText searchService;

  private FragmentDiscoverBinding(@NonNull FrameLayout rootView, @NonNull TextView adv1,
      @NonNull TextView adv11, @NonNull TextView adv2, @NonNull TextView adv21,
      @NonNull TextView adv3, @NonNull TextView adv31, @NonNull ImageView checkv10,
      @NonNull ImageView checkv11, @NonNull ImageView checkv20, @NonNull ImageView checkv21,
      @NonNull ImageView checkv30, @NonNull ImageView checkv31, @NonNull ImageView imageView,
      @NonNull ImageView imageView10, @NonNull ImageView imageView11, @NonNull ImageView logo1,
      @NonNull TextView name1, @NonNull TextView name2, @NonNull TextView name3,
      @NonNull View productTop1, @NonNull View productTop2, @NonNull View productTop3,
      @NonNull EditText searchService) {
    this.rootView = rootView;
    this.adv1 = adv1;
    this.adv11 = adv11;
    this.adv2 = adv2;
    this.adv21 = adv21;
    this.adv3 = adv3;
    this.adv31 = adv31;
    this.checkv10 = checkv10;
    this.checkv11 = checkv11;
    this.checkv20 = checkv20;
    this.checkv21 = checkv21;
    this.checkv30 = checkv30;
    this.checkv31 = checkv31;
    this.imageView = imageView;
    this.imageView10 = imageView10;
    this.imageView11 = imageView11;
    this.logo1 = logo1;
    this.name1 = name1;
    this.name2 = name2;
    this.name3 = name3;
    this.productTop1 = productTop1;
    this.productTop2 = productTop2;
    this.productTop3 = productTop3;
    this.searchService = searchService;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentDiscoverBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentDiscoverBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_discover, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentDiscoverBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.adv1;
      TextView adv1 = ViewBindings.findChildViewById(rootView, id);
      if (adv1 == null) {
        break missingId;
      }

      id = R.id.adv11;
      TextView adv11 = ViewBindings.findChildViewById(rootView, id);
      if (adv11 == null) {
        break missingId;
      }

      id = R.id.adv2;
      TextView adv2 = ViewBindings.findChildViewById(rootView, id);
      if (adv2 == null) {
        break missingId;
      }

      id = R.id.adv21;
      TextView adv21 = ViewBindings.findChildViewById(rootView, id);
      if (adv21 == null) {
        break missingId;
      }

      id = R.id.adv3;
      TextView adv3 = ViewBindings.findChildViewById(rootView, id);
      if (adv3 == null) {
        break missingId;
      }

      id = R.id.adv31;
      TextView adv31 = ViewBindings.findChildViewById(rootView, id);
      if (adv31 == null) {
        break missingId;
      }

      id = R.id.checkv10;
      ImageView checkv10 = ViewBindings.findChildViewById(rootView, id);
      if (checkv10 == null) {
        break missingId;
      }

      id = R.id.checkv11;
      ImageView checkv11 = ViewBindings.findChildViewById(rootView, id);
      if (checkv11 == null) {
        break missingId;
      }

      id = R.id.checkv20;
      ImageView checkv20 = ViewBindings.findChildViewById(rootView, id);
      if (checkv20 == null) {
        break missingId;
      }

      id = R.id.checkv21;
      ImageView checkv21 = ViewBindings.findChildViewById(rootView, id);
      if (checkv21 == null) {
        break missingId;
      }

      id = R.id.checkv30;
      ImageView checkv30 = ViewBindings.findChildViewById(rootView, id);
      if (checkv30 == null) {
        break missingId;
      }

      id = R.id.checkv31;
      ImageView checkv31 = ViewBindings.findChildViewById(rootView, id);
      if (checkv31 == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.imageView10;
      ImageView imageView10 = ViewBindings.findChildViewById(rootView, id);
      if (imageView10 == null) {
        break missingId;
      }

      id = R.id.imageView11;
      ImageView imageView11 = ViewBindings.findChildViewById(rootView, id);
      if (imageView11 == null) {
        break missingId;
      }

      id = R.id.logo1;
      ImageView logo1 = ViewBindings.findChildViewById(rootView, id);
      if (logo1 == null) {
        break missingId;
      }

      id = R.id.name1;
      TextView name1 = ViewBindings.findChildViewById(rootView, id);
      if (name1 == null) {
        break missingId;
      }

      id = R.id.name2;
      TextView name2 = ViewBindings.findChildViewById(rootView, id);
      if (name2 == null) {
        break missingId;
      }

      id = R.id.name3;
      TextView name3 = ViewBindings.findChildViewById(rootView, id);
      if (name3 == null) {
        break missingId;
      }

      id = R.id.product_top1;
      View productTop1 = ViewBindings.findChildViewById(rootView, id);
      if (productTop1 == null) {
        break missingId;
      }

      id = R.id.product_top2;
      View productTop2 = ViewBindings.findChildViewById(rootView, id);
      if (productTop2 == null) {
        break missingId;
      }

      id = R.id.product_top3;
      View productTop3 = ViewBindings.findChildViewById(rootView, id);
      if (productTop3 == null) {
        break missingId;
      }

      id = R.id.searchService;
      EditText searchService = ViewBindings.findChildViewById(rootView, id);
      if (searchService == null) {
        break missingId;
      }

      return new FragmentDiscoverBinding((FrameLayout) rootView, adv1, adv11, adv2, adv21, adv3,
          adv31, checkv10, checkv11, checkv20, checkv21, checkv30, checkv31, imageView, imageView10,
          imageView11, logo1, name1, name2, name3, productTop1, productTop2, productTop3,
          searchService);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}