/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ObjectAnimator
 *  android.animation.PropertyValuesHolder
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.util;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public final class q {
    private static ImageView a(Context context, ViewGroup viewGroup, View view) {
        ImageView imageView;
        int[] arrn = new int[2];
        view.getLocationInWindow(arrn);
        imageView = new ImageView(context);
        try {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(view.getWidth(), view.getHeight());
            imageView.setX((float)arrn[0]);
            imageView.setY((float)(-72 + arrn[1]));
            imageView.setPivotX(0.0f);
            imageView.setPivotY(0.0f);
            view.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap((Bitmap)view.getDrawingCache());
            view.setDrawingCacheEnabled(false);
            imageView.setImageBitmap(bitmap);
            viewGroup.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams);
        }
        catch (NullPointerException nullPointerException) {}
        return imageView;
    }

    public static void a(Context context, View view, View view2) {
        final ViewGroup viewGroup = (ViewGroup)((Activity)context).findViewById(16908290);
        final ImageView imageView = q.a(context, viewGroup, view);
        int[] arrn = new int[2];
        view2.getLocationOnScreen(arrn);
        float[] arrf = new float[]{(float)arrn[0] + view2.getPivotX()};
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofFloat((String)"x", (float[])arrf);
        float[] arrf2 = new float[]{(float)arrn[1] - view2.getPivotY()};
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder((Object)imageView, (PropertyValuesHolder[])new PropertyValuesHolder[]{propertyValuesHolder, PropertyValuesHolder.ofFloat((String)"y", (float[])arrf2), PropertyValuesHolder.ofFloat((Property)View.SCALE_X, (float[])new float[]{0.0f}), PropertyValuesHolder.ofFloat((Property)View.SCALE_Y, (float[])new float[]{0.0f})});
        objectAnimator.addListener(new Animator.AnimatorListener(){

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                viewGroup.removeView((View)imageView);
            }

            public final void onAnimationRepeat(Animator animator) {
            }

            public final void onAnimationStart(Animator animator) {
            }
        });
        objectAnimator.setDuration(1000L);
        objectAnimator.start();
    }

}

