// Generated by view binder compiler. Do not edit!
package com.example.demoproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.demoproject.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class OrderSampleBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView orderImage;

  @NonNull
  public final TextView orderItemName;

  @NonNull
  public final TextView orderNumber;

  @NonNull
  public final TextView orderPrice;

  @NonNull
  public final TextView textView7;

  @NonNull
  public final TextView textView8;

  private OrderSampleBinding(@NonNull LinearLayout rootView, @NonNull ImageView orderImage,
      @NonNull TextView orderItemName, @NonNull TextView orderNumber, @NonNull TextView orderPrice,
      @NonNull TextView textView7, @NonNull TextView textView8) {
    this.rootView = rootView;
    this.orderImage = orderImage;
    this.orderItemName = orderItemName;
    this.orderNumber = orderNumber;
    this.orderPrice = orderPrice;
    this.textView7 = textView7;
    this.textView8 = textView8;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static OrderSampleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static OrderSampleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.order_sample, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static OrderSampleBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.orderImage;
      ImageView orderImage = ViewBindings.findChildViewById(rootView, id);
      if (orderImage == null) {
        break missingId;
      }

      id = R.id.orderItemName;
      TextView orderItemName = ViewBindings.findChildViewById(rootView, id);
      if (orderItemName == null) {
        break missingId;
      }

      id = R.id.orderNumber;
      TextView orderNumber = ViewBindings.findChildViewById(rootView, id);
      if (orderNumber == null) {
        break missingId;
      }

      id = R.id.orderPrice;
      TextView orderPrice = ViewBindings.findChildViewById(rootView, id);
      if (orderPrice == null) {
        break missingId;
      }

      id = R.id.textView7;
      TextView textView7 = ViewBindings.findChildViewById(rootView, id);
      if (textView7 == null) {
        break missingId;
      }

      id = R.id.textView8;
      TextView textView8 = ViewBindings.findChildViewById(rootView, id);
      if (textView8 == null) {
        break missingId;
      }

      return new OrderSampleBinding((LinearLayout) rootView, orderImage, orderItemName, orderNumber,
          orderPrice, textView7, textView8);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}