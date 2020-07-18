/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.support.v4.app.Fragment
 *  android.support.v4.content.a
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.ClassCastException
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.annotation.Annotation
 *  java.lang.annotation.Retention
 *  java.lang.annotation.RetentionPolicy
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 */
package com.yalantis.ucrop;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.content.a;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.UCropFragment;
import com.yalantis.ucrop.UCropFragmentCallback;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.util.SelectedStateListDrawable;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class UCropFragment
extends Fragment {
    public static final int ALL = 3;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.JPEG;
    public static final int DEFAULT_COMPRESS_QUALITY = 90;
    public static final int NONE = 0;
    public static final int ROTATE = 2;
    private static final int ROTATE_WIDGET_SENSITIVITY_COEFFICIENT = 42;
    public static final int SCALE = 1;
    private static final int SCALE_WIDGET_SENSITIVITY_COEFFICIENT = 15000;
    private static final int TABS_COUNT = 3;
    public static final String TAG = "UCropFragment";
    private UCropFragmentCallback callback;
    private int mActiveWidgetColor;
    private int[] mAllowedGestures = new int[]{1, 2, 3};
    private View mBlockingView;
    private Bitmap.CompressFormat mCompressFormat = DEFAULT_COMPRESS_FORMAT;
    private int mCompressQuality = 90;
    private List<ViewGroup> mCropAspectRatioViews = new ArrayList();
    private GestureCropImageView mGestureCropImageView;
    private TransformImageView.TransformImageListener mImageListener = new TransformImageView.TransformImageListener(this){
        final /* synthetic */ UCropFragment this$0;
        {
            this.this$0 = uCropFragment;
        }

        public void onLoadComplete() {
            UCropFragment.access$200(this.this$0).animate().alpha(1.0f).setDuration(300L).setInterpolator((android.animation.TimeInterpolator)new android.view.animation.AccelerateInterpolator());
            UCropFragment.access$300(this.this$0).setClickable(false);
            UCropFragment.access$400(this.this$0).loadingProgress(false);
        }

        public void onLoadFailure(Exception exception) {
            UCropFragment.access$400(this.this$0).onCropFinish(this.this$0.getError(exception));
        }

        public void onRotate(float f2) {
            UCropFragment.access$000(this.this$0, f2);
        }

        public void onScale(float f2) {
            UCropFragment.access$100(this.this$0, f2);
        }
    };
    private ViewGroup mLayoutAspectRatio;
    private ViewGroup mLayoutRotate;
    private ViewGroup mLayoutScale;
    private int mLogoColor;
    private OverlayView mOverlayView;
    private int mRootViewBackgroundColor;
    private boolean mShowBottomControls;
    private final View.OnClickListener mStateClickListener = new View.OnClickListener(this){
        final /* synthetic */ UCropFragment this$0;
        {
            this.this$0 = uCropFragment;
        }

        public void onClick(View view) {
            if (!view.isSelected()) {
                UCropFragment.access$900(this.this$0, view.getId());
            }
        }
    };
    private TextView mTextViewRotateAngle;
    private TextView mTextViewScalePercent;
    private UCropView mUCropView;
    private ViewGroup mWrapperStateAspectRatio;
    private ViewGroup mWrapperStateRotate;
    private ViewGroup mWrapperStateScale;

    static /* synthetic */ void access$000(UCropFragment uCropFragment, float f2) {
        uCropFragment.setAngleText(f2);
    }

    static /* synthetic */ void access$100(UCropFragment uCropFragment, float f2) {
        uCropFragment.setScaleText(f2);
    }

    static /* synthetic */ UCropView access$200(UCropFragment uCropFragment) {
        return uCropFragment.mUCropView;
    }

    static /* synthetic */ View access$300(UCropFragment uCropFragment) {
        return uCropFragment.mBlockingView;
    }

    static /* synthetic */ UCropFragmentCallback access$400(UCropFragment uCropFragment) {
        return uCropFragment.callback;
    }

    static /* synthetic */ GestureCropImageView access$500(UCropFragment uCropFragment) {
        return uCropFragment.mGestureCropImageView;
    }

    static /* synthetic */ List access$600(UCropFragment uCropFragment) {
        return uCropFragment.mCropAspectRatioViews;
    }

    static /* synthetic */ void access$700(UCropFragment uCropFragment) {
        uCropFragment.resetRotation();
    }

    static /* synthetic */ void access$800(UCropFragment uCropFragment, int n2) {
        uCropFragment.rotateByAngle(n2);
    }

    static /* synthetic */ void access$900(UCropFragment uCropFragment, int n2) {
        uCropFragment.setWidgetState(n2);
    }

    private void addBlockingView(View view) {
        if (this.mBlockingView == null) {
            this.mBlockingView = new View(this.getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            this.mBlockingView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            this.mBlockingView.setClickable(true);
        }
        ((RelativeLayout)view.findViewById(R.id.ucrop_photobox)).addView(this.mBlockingView);
    }

    private void initiateRootViews(View view) {
        this.mUCropView = (UCropView)view.findViewById(R.id.ucrop);
        this.mGestureCropImageView = this.mUCropView.getCropImageView();
        this.mOverlayView = this.mUCropView.getOverlayView();
        this.mGestureCropImageView.setTransformImageListener(this.mImageListener);
        ((ImageView)view.findViewById(R.id.image_view_logo)).setColorFilter(this.mLogoColor, PorterDuff.Mode.SRC_ATOP);
        view.findViewById(R.id.ucrop_frame).setBackgroundColor(this.mRootViewBackgroundColor);
    }

    public static UCropFragment newInstance(Bundle bundle) {
        UCropFragment uCropFragment = new UCropFragment();
        uCropFragment.setArguments(bundle);
        return uCropFragment;
    }

    private void processOptions(Bundle bundle) {
        String string2 = bundle.getString("com.yalantis.ucrop.CompressionFormatName");
        Bitmap.CompressFormat compressFormat = !TextUtils.isEmpty((CharSequence)string2) ? Bitmap.CompressFormat.valueOf((String)string2) : null;
        if (compressFormat == null) {
            compressFormat = DEFAULT_COMPRESS_FORMAT;
        }
        this.mCompressFormat = compressFormat;
        this.mCompressQuality = bundle.getInt("com.yalantis.ucrop.CompressionQuality", 90);
        int[] arrn = bundle.getIntArray("com.yalantis.ucrop.AllowedGestures");
        if (arrn != null && arrn.length == 3) {
            this.mAllowedGestures = arrn;
        }
        this.mGestureCropImageView.setMaxBitmapSize(bundle.getInt("com.yalantis.ucrop.MaxBitmapSize", 0));
        this.mGestureCropImageView.setMaxScaleMultiplier(bundle.getFloat("com.yalantis.ucrop.MaxScaleMultiplier", 10.0f));
        this.mGestureCropImageView.setImageToWrapCropBoundsAnimDuration(bundle.getInt("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", 500));
        this.mOverlayView.setFreestyleCropEnabled(bundle.getBoolean("com.yalantis.ucrop.FreeStyleCrop", false));
        this.mOverlayView.setDimmedColor(bundle.getInt("com.yalantis.ucrop.DimmedLayerColor", this.getResources().getColor(R.color.ucrop_color_default_dimmed)));
        this.mOverlayView.setCircleDimmedLayer(bundle.getBoolean("com.yalantis.ucrop.CircleDimmedLayer", false));
        this.mOverlayView.setShowCropFrame(bundle.getBoolean("com.yalantis.ucrop.ShowCropFrame", true));
        this.mOverlayView.setCropFrameColor(bundle.getInt("com.yalantis.ucrop.CropFrameColor", this.getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.mOverlayView.setCropFrameStrokeWidth(bundle.getInt("com.yalantis.ucrop.CropFrameStrokeWidth", this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.mOverlayView.setShowCropGrid(bundle.getBoolean("com.yalantis.ucrop.ShowCropGrid", true));
        this.mOverlayView.setCropGridRowCount(bundle.getInt("com.yalantis.ucrop.CropGridRowCount", 2));
        this.mOverlayView.setCropGridColumnCount(bundle.getInt("com.yalantis.ucrop.CropGridColumnCount", 2));
        this.mOverlayView.setCropGridColor(bundle.getInt("com.yalantis.ucrop.CropGridColor", this.getResources().getColor(R.color.ucrop_color_default_crop_grid)));
        this.mOverlayView.setCropGridStrokeWidth(bundle.getInt("com.yalantis.ucrop.CropGridStrokeWidth", this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        float f2 = 0.0f;
        float f3 = bundle.getFloat("com.yalantis.ucrop.AspectRatioX", 0.0f);
        float f4 = bundle.getFloat("com.yalantis.ucrop.AspectRatioY", 0.0f);
        int n2 = bundle.getInt("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList arrayList = bundle.getParcelableArrayList("com.yalantis.ucrop.AspectRatioOptions");
        if (f3 > 0.0f && f4 > 0.0f) {
            if (this.mWrapperStateAspectRatio != null) {
                this.mWrapperStateAspectRatio.setVisibility(8);
            }
            this.mGestureCropImageView.setTargetAspectRatio(f3 / f4);
        } else {
            GestureCropImageView gestureCropImageView;
            if (arrayList != null && n2 < arrayList.size()) {
                gestureCropImageView = this.mGestureCropImageView;
                f2 = ((AspectRatio)arrayList.get(n2)).getAspectRatioX() / ((AspectRatio)arrayList.get(n2)).getAspectRatioY();
            } else {
                gestureCropImageView = this.mGestureCropImageView;
            }
            gestureCropImageView.setTargetAspectRatio(f2);
        }
        int n3 = bundle.getInt("com.yalantis.ucrop.MaxSizeX", 0);
        int n4 = bundle.getInt("com.yalantis.ucrop.MaxSizeY", 0);
        if (n3 > 0 && n4 > 0) {
            this.mGestureCropImageView.setMaxResultImageSizeX(n3);
            this.mGestureCropImageView.setMaxResultImageSizeY(n4);
        }
    }

    private void resetRotation() {
        this.mGestureCropImageView.postRotate(-this.mGestureCropImageView.getCurrentAngle());
        this.mGestureCropImageView.setImageToWrapCropBounds();
    }

    private void rotateByAngle(int n2) {
        this.mGestureCropImageView.postRotate(n2);
        this.mGestureCropImageView.setImageToWrapCropBounds();
    }

    private void setAllowedGestures(int n2) {
        boolean bl;
        GestureCropImageView gestureCropImageView;
        block4 : {
            block3 : {
                GestureCropImageView gestureCropImageView2 = this.mGestureCropImageView;
                boolean bl2 = this.mAllowedGestures[n2] == 3 || this.mAllowedGestures[n2] == 1;
                gestureCropImageView2.setScaleEnabled(bl2);
                gestureCropImageView = this.mGestureCropImageView;
                if (this.mAllowedGestures[n2] == 3) break block3;
                int n3 = this.mAllowedGestures[n2];
                bl = false;
                if (n3 != 2) break block4;
            }
            bl = true;
        }
        gestureCropImageView.setRotateEnabled(bl);
    }

    private void setAngleText(float f2) {
        if (this.mTextViewRotateAngle != null) {
            TextView textView = this.mTextViewRotateAngle;
            Locale locale = Locale.getDefault();
            Object[] arrobject = new Object[]{Float.valueOf((float)f2)};
            textView.setText((CharSequence)String.format((Locale)locale, (String)"%.1f\u00b0", (Object[])arrobject));
        }
    }

    private void setImageData(Bundle bundle) {
        Uri uri = (Uri)bundle.getParcelable("com.yalantis.ucrop.InputUri");
        Uri uri2 = (Uri)bundle.getParcelable("com.yalantis.ucrop.OutputUri");
        UCropFragment.super.processOptions(bundle);
        if (uri != null && uri2 != null) {
            try {
                this.mGestureCropImageView.setImageUri(uri, uri2);
                return;
            }
            catch (Exception exception) {
                this.callback.onCropFinish(this.getError(exception));
                return;
            }
        }
        this.callback.onCropFinish(this.getError((Throwable)new NullPointerException(this.getString(R.string.ucrop_error_input_data_is_absent))));
    }

    private void setInitialState() {
        if (this.mShowBottomControls) {
            if (this.mWrapperStateAspectRatio.getVisibility() == 0) {
                this.setWidgetState(R.id.state_aspect_ratio);
                return;
            }
            this.setWidgetState(R.id.state_scale);
            return;
        }
        this.setAllowedGestures(0);
    }

    private void setScaleText(float f2) {
        if (this.mTextViewScalePercent != null) {
            TextView textView = this.mTextViewScalePercent;
            Locale locale = Locale.getDefault();
            Object[] arrobject = new Object[]{(int)(f2 * 100.0f)};
            textView.setText((CharSequence)String.format((Locale)locale, (String)"%d%%", (Object[])arrobject));
        }
    }

    private void setWidgetState(int n2) {
        if (!this.mShowBottomControls) {
            return;
        }
        ViewGroup viewGroup = this.mWrapperStateAspectRatio;
        boolean bl = n2 == R.id.state_aspect_ratio;
        viewGroup.setSelected(bl);
        ViewGroup viewGroup2 = this.mWrapperStateRotate;
        boolean bl2 = n2 == R.id.state_rotate;
        viewGroup2.setSelected(bl2);
        ViewGroup viewGroup3 = this.mWrapperStateScale;
        boolean bl3 = n2 == R.id.state_scale;
        viewGroup3.setSelected(bl3);
        ViewGroup viewGroup4 = this.mLayoutAspectRatio;
        int n3 = R.id.state_aspect_ratio;
        int n4 = 8;
        int n5 = n2 == n3 ? 0 : 8;
        viewGroup4.setVisibility(n5);
        ViewGroup viewGroup5 = this.mLayoutRotate;
        int n6 = n2 == R.id.state_rotate ? 0 : 8;
        viewGroup5.setVisibility(n6);
        ViewGroup viewGroup6 = this.mLayoutScale;
        if (n2 == R.id.state_scale) {
            n4 = 0;
        }
        viewGroup6.setVisibility(n4);
        if (n2 == R.id.state_scale) {
            UCropFragment.super.setAllowedGestures(0);
            return;
        }
        if (n2 == R.id.state_rotate) {
            UCropFragment.super.setAllowedGestures(1);
            return;
        }
        UCropFragment.super.setAllowedGestures(2);
    }

    private void setupAspectRatioWidget(Bundle bundle, View view) {
        int n2 = bundle.getInt("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList arrayList = bundle.getParcelableArrayList("com.yalantis.ucrop.AspectRatioOptions");
        if (arrayList == null || arrayList.isEmpty()) {
            n2 = 2;
            arrayList = new ArrayList();
            arrayList.add((Object)new AspectRatio(null, 1.0f, 1.0f));
            arrayList.add((Object)new AspectRatio(null, 3.0f, 4.0f));
            arrayList.add((Object)new AspectRatio(this.getString(R.string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
            arrayList.add((Object)new AspectRatio(null, 3.0f, 2.0f));
            arrayList.add((Object)new AspectRatio(null, 16.0f, 9.0f));
        }
        LinearLayout linearLayout = (LinearLayout)view.findViewById(R.id.layout_aspect_ratio);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        for (AspectRatio aspectRatio : arrayList) {
            FrameLayout frameLayout = (FrameLayout)this.getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, null);
            frameLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView)frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.mActiveWidgetColor);
            aspectRatioTextView.setAspectRatio(aspectRatio);
            linearLayout.addView((View)frameLayout);
            this.mCropAspectRatioViews.add((Object)frameLayout);
        }
        ((ViewGroup)this.mCropAspectRatioViews.get(n2)).setSelected(true);
        Iterator iterator = this.mCropAspectRatioViews.iterator();
        while (iterator.hasNext()) {
            ((ViewGroup)iterator.next()).setOnClickListener(new View.OnClickListener((UCropFragment)this){
                final /* synthetic */ UCropFragment this$0;
                {
                    this.this$0 = uCropFragment;
                }

                public void onClick(View view) {
                    UCropFragment.access$500(this.this$0).setTargetAspectRatio(((AspectRatioTextView)((ViewGroup)view).getChildAt(0)).getAspectRatio(view.isSelected()));
                    UCropFragment.access$500(this.this$0).setImageToWrapCropBounds();
                    if (!view.isSelected()) {
                        for (ViewGroup viewGroup : UCropFragment.access$600(this.this$0)) {
                            boolean bl = viewGroup == view;
                            viewGroup.setSelected(bl);
                        }
                    }
                }
            });
        }
    }

    private void setupRotateWidget(View view) {
        this.mTextViewRotateAngle = (TextView)view.findViewById(R.id.text_view_rotate);
        ((HorizontalProgressWheelView)view.findViewById(R.id.rotate_scroll_wheel)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener((UCropFragment)this){
            final /* synthetic */ UCropFragment this$0;
            {
                this.this$0 = uCropFragment;
            }

            public void onScroll(float f2, float f3) {
                UCropFragment.access$500(this.this$0).postRotate(f2 / 42.0f);
            }

            public void onScrollEnd() {
                UCropFragment.access$500(this.this$0).setImageToWrapCropBounds();
            }

            public void onScrollStart() {
                UCropFragment.access$500(this.this$0).cancelAllAnimations();
            }
        });
        ((HorizontalProgressWheelView)view.findViewById(R.id.rotate_scroll_wheel)).setMiddleLineColor(this.mActiveWidgetColor);
        view.findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new View.OnClickListener((UCropFragment)this){
            final /* synthetic */ UCropFragment this$0;
            {
                this.this$0 = uCropFragment;
            }

            public void onClick(View view) {
                UCropFragment.access$700(this.this$0);
            }
        });
        view.findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new View.OnClickListener((UCropFragment)this){
            final /* synthetic */ UCropFragment this$0;
            {
                this.this$0 = uCropFragment;
            }

            public void onClick(View view) {
                UCropFragment.access$800(this.this$0, 90);
            }
        });
    }

    private void setupScaleWidget(View view) {
        this.mTextViewScalePercent = (TextView)view.findViewById(R.id.text_view_scale);
        ((HorizontalProgressWheelView)view.findViewById(R.id.scale_scroll_wheel)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener((UCropFragment)this){
            final /* synthetic */ UCropFragment this$0;
            {
                this.this$0 = uCropFragment;
            }

            public void onScroll(float f2, float f3) {
                if (f2 > 0.0f) {
                    UCropFragment.access$500(this.this$0).zoomInImage(UCropFragment.access$500(this.this$0).getCurrentScale() + f2 * ((UCropFragment.access$500(this.this$0).getMaxScale() - UCropFragment.access$500(this.this$0).getMinScale()) / 15000.0f));
                    return;
                }
                UCropFragment.access$500(this.this$0).zoomOutImage(UCropFragment.access$500(this.this$0).getCurrentScale() + f2 * ((UCropFragment.access$500(this.this$0).getMaxScale() - UCropFragment.access$500(this.this$0).getMinScale()) / 15000.0f));
            }

            public void onScrollEnd() {
                UCropFragment.access$500(this.this$0).setImageToWrapCropBounds();
            }

            public void onScrollStart() {
                UCropFragment.access$500(this.this$0).cancelAllAnimations();
            }
        });
        ((HorizontalProgressWheelView)view.findViewById(R.id.scale_scroll_wheel)).setMiddleLineColor(this.mActiveWidgetColor);
    }

    private void setupStatesWrapper(View view) {
        ImageView imageView = (ImageView)view.findViewById(R.id.image_view_state_scale);
        ImageView imageView2 = (ImageView)view.findViewById(R.id.image_view_state_rotate);
        ImageView imageView3 = (ImageView)view.findViewById(R.id.image_view_state_aspect_ratio);
        imageView.setImageDrawable((Drawable)new SelectedStateListDrawable(imageView.getDrawable(), this.mActiveWidgetColor));
        imageView2.setImageDrawable((Drawable)new SelectedStateListDrawable(imageView2.getDrawable(), this.mActiveWidgetColor));
        imageView3.setImageDrawable((Drawable)new SelectedStateListDrawable(imageView3.getDrawable(), this.mActiveWidgetColor));
    }

    public void cropAndSaveImage() {
        this.mBlockingView.setClickable(true);
        this.callback.loadingProgress(true);
        this.mGestureCropImageView.cropAndSaveImage(this.mCompressFormat, this.mCompressQuality, new BitmapCropCallback(this){
            final /* synthetic */ UCropFragment this$0;
            {
                this.this$0 = uCropFragment;
            }

            public void onBitmapCropped(Uri uri, int n2, int n3, int n4, int n5) {
                UCropFragment.access$400(this.this$0).onCropFinish(this.this$0.getResult(uri, UCropFragment.access$500(this.this$0).getTargetAspectRatio(), n2, n3, n4, n5));
                UCropFragment.access$400(this.this$0).loadingProgress(false);
            }

            public void onCropFailure(Throwable throwable) {
                UCropFragment.access$400(this.this$0).onCropFinish(this.this$0.getError(throwable));
            }
        });
    }

    protected UCropResult getError(Throwable throwable) {
        return new Object(96, new Intent().putExtra("com.yalantis.ucrop.Error", (Serializable)throwable)){
            public int mResultCode;
            public Intent mResultData;
            {
                this.mResultCode = n2;
                this.mResultData = intent;
            }
        };
    }

    protected UCropResult getResult(Uri uri, float f2, int n2, int n3, int n4, int n5) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.callback = (UCropFragmentCallback)context;
            return;
        }
        catch (ClassCastException classCastException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.toString());
            stringBuilder.append(" must implement UCropFragmentCallback");
            throw new ClassCastException(stringBuilder.toString());
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(R.layout.ucrop_fragment_photobox, viewGroup, false);
        Bundle bundle2 = this.getArguments();
        this.setupViews(view, bundle2);
        UCropFragment.super.setImageData(bundle2);
        UCropFragment.super.setInitialState();
        UCropFragment.super.addBlockingView(view);
        return view;
    }

    public void setCallback(UCropFragmentCallback uCropFragmentCallback) {
        this.callback = uCropFragmentCallback;
    }

    public void setupViews(View view, Bundle bundle) {
        this.mActiveWidgetColor = bundle.getInt("com.yalantis.ucrop.UcropColorWidgetActive", a.c((Context)this.getContext(), (int)R.color.ucrop_color_widget_active));
        this.mLogoColor = bundle.getInt("com.yalantis.ucrop.UcropLogoColor", a.c((Context)this.getContext(), (int)R.color.ucrop_color_default_logo));
        this.mShowBottomControls = true ^ bundle.getBoolean("com.yalantis.ucrop.HideBottomControls", false);
        this.mRootViewBackgroundColor = bundle.getInt("com.yalantis.ucrop.UcropRootViewBackgroundColor", a.c((Context)this.getContext(), (int)R.color.ucrop_color_crop_background));
        UCropFragment.super.initiateRootViews(view);
        this.callback.loadingProgress(true);
        if (this.mShowBottomControls) {
            ViewGroup viewGroup = (ViewGroup)view.findViewById(R.id.ucrop_photobox);
            View.inflate((Context)this.getContext(), (int)R.layout.ucrop_controls, (ViewGroup)viewGroup);
            this.mWrapperStateAspectRatio = (ViewGroup)view.findViewById(R.id.state_aspect_ratio);
            this.mWrapperStateAspectRatio.setOnClickListener(this.mStateClickListener);
            this.mWrapperStateRotate = (ViewGroup)view.findViewById(R.id.state_rotate);
            this.mWrapperStateRotate.setOnClickListener(this.mStateClickListener);
            this.mWrapperStateScale = (ViewGroup)view.findViewById(R.id.state_scale);
            this.mWrapperStateScale.setOnClickListener(this.mStateClickListener);
            this.mLayoutAspectRatio = (ViewGroup)view.findViewById(R.id.layout_aspect_ratio);
            this.mLayoutRotate = (ViewGroup)view.findViewById(R.id.layout_rotate_wheel);
            this.mLayoutScale = (ViewGroup)view.findViewById(R.id.layout_scale_wheel);
            UCropFragment.super.setupAspectRatioWidget(bundle, view);
            UCropFragment.super.setupRotateWidget(view);
            UCropFragment.super.setupScaleWidget(view);
            UCropFragment.super.setupStatesWrapper(view);
        }
    }

}

