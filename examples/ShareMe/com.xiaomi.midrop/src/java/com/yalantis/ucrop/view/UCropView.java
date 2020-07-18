/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.RectF
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  com.yalantis.ucrop.view.GestureCropImageView
 *  com.yalantis.ucrop.view.UCropView$1
 *  com.yalantis.ucrop.view.UCropView$2
 */
package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.UCropView;

public class UCropView
extends FrameLayout {
    private GestureCropImageView mGestureCropImageView;
    private final OverlayView mViewOverlay;

    public UCropView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public UCropView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        LayoutInflater.from((Context)context).inflate(R.layout.ucrop_view, (ViewGroup)this, true);
        this.mGestureCropImageView = (GestureCropImageView)this.findViewById(R.id.image_view_crop);
        this.mViewOverlay = (OverlayView)this.findViewById(R.id.view_overlay);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_UCropView);
        this.mViewOverlay.processStyledAttributes(typedArray);
        this.mGestureCropImageView.processStyledAttributes(typedArray);
        typedArray.recycle();
        UCropView.super.setListenersToViews();
    }

    static /* synthetic */ OverlayView access$000(UCropView uCropView) {
        return uCropView.mViewOverlay;
    }

    static /* synthetic */ GestureCropImageView access$100(UCropView uCropView) {
        return uCropView.mGestureCropImageView;
    }

    private void setListenersToViews() {
        this.mGestureCropImageView.setCropBoundsChangeListener((CropBoundsChangeListener)new 1(this));
        this.mViewOverlay.setOverlayViewChangeListener((OverlayViewChangeListener)new 2(this));
    }

    public GestureCropImageView getCropImageView() {
        return this.mGestureCropImageView;
    }

    public OverlayView getOverlayView() {
        return this.mViewOverlay;
    }

    public void resetCropImageView() {
        this.removeView((View)this.mGestureCropImageView);
        this.mGestureCropImageView = new GestureCropImageView(this.getContext());
        this.setListenersToViews();
        this.mGestureCropImageView.setCropRect(this.getOverlayView().getCropViewRect());
        this.addView((View)this.mGestureCropImageView, 0);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}

