/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.support.v4.content.a
 *  android.support.v7.app.a
 *  android.support.v7.app.d
 *  android.support.v7.widget.Toolbar
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
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

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.a;
import android.support.v7.app.d;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.UCropActivity;
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

public class UCropActivity
extends d {
    public static final int ALL = 3;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.JPEG;
    public static final int DEFAULT_COMPRESS_QUALITY = 90;
    public static final int NONE = 0;
    public static final int ROTATE = 2;
    private static final int ROTATE_WIDGET_SENSITIVITY_COEFFICIENT = 42;
    public static final int SCALE = 1;
    private static final int SCALE_WIDGET_SENSITIVITY_COEFFICIENT = 15000;
    private static final int TABS_COUNT = 3;
    private static final String TAG = "UCropActivity";
    private int mActiveWidgetColor;
    private int[] mAllowedGestures = new int[]{1, 2, 3};
    private View mBlockingView;
    private Bitmap.CompressFormat mCompressFormat = DEFAULT_COMPRESS_FORMAT;
    private int mCompressQuality = 90;
    private List<ViewGroup> mCropAspectRatioViews = new ArrayList();
    private GestureCropImageView mGestureCropImageView;
    private TransformImageView.TransformImageListener mImageListener = new TransformImageView.TransformImageListener(this){
        final /* synthetic */ UCropActivity this$0;
        {
            this.this$0 = uCropActivity;
        }

        public void onLoadComplete() {
            UCropActivity.access$200(this.this$0).animate().alpha(1.0f).setDuration(300L).setInterpolator((android.animation.TimeInterpolator)new android.view.animation.AccelerateInterpolator());
            UCropActivity.access$300(this.this$0).setClickable(false);
            UCropActivity.access$402(this.this$0, false);
            this.this$0.supportInvalidateOptionsMenu();
        }

        public void onLoadFailure(Exception exception) {
            this.this$0.setResultError(exception);
            this.this$0.finish();
        }

        public void onRotate(float f2) {
            UCropActivity.access$000(this.this$0, f2);
        }

        public void onScale(float f2) {
            UCropActivity.access$100(this.this$0, f2);
        }
    };
    private ViewGroup mLayoutAspectRatio;
    private ViewGroup mLayoutRotate;
    private ViewGroup mLayoutScale;
    private int mLogoColor;
    private OverlayView mOverlayView;
    private int mRootViewBackgroundColor;
    private boolean mShowBottomControls;
    private boolean mShowLoader = true;
    private final View.OnClickListener mStateClickListener = new View.OnClickListener(this){
        final /* synthetic */ UCropActivity this$0;
        {
            this.this$0 = uCropActivity;
        }

        public void onClick(View view) {
            if (!view.isSelected()) {
                UCropActivity.access$900(this.this$0, view.getId());
            }
        }
    };
    private int mStatusBarColor;
    private TextView mTextViewRotateAngle;
    private TextView mTextViewScalePercent;
    private int mToolbarCancelDrawable;
    private int mToolbarColor;
    private int mToolbarCropDrawable;
    private String mToolbarTitle;
    private int mToolbarWidgetColor;
    private UCropView mUCropView;
    private ViewGroup mWrapperStateAspectRatio;
    private ViewGroup mWrapperStateRotate;
    private ViewGroup mWrapperStateScale;

    static /* synthetic */ void access$000(UCropActivity uCropActivity, float f2) {
        uCropActivity.setAngleText(f2);
    }

    static /* synthetic */ void access$100(UCropActivity uCropActivity, float f2) {
        uCropActivity.setScaleText(f2);
    }

    static /* synthetic */ UCropView access$200(UCropActivity uCropActivity) {
        return uCropActivity.mUCropView;
    }

    static /* synthetic */ View access$300(UCropActivity uCropActivity) {
        return uCropActivity.mBlockingView;
    }

    static /* synthetic */ boolean access$402(UCropActivity uCropActivity, boolean bl) {
        uCropActivity.mShowLoader = bl;
        return bl;
    }

    static /* synthetic */ GestureCropImageView access$500(UCropActivity uCropActivity) {
        return uCropActivity.mGestureCropImageView;
    }

    static /* synthetic */ List access$600(UCropActivity uCropActivity) {
        return uCropActivity.mCropAspectRatioViews;
    }

    static /* synthetic */ void access$700(UCropActivity uCropActivity) {
        uCropActivity.resetRotation();
    }

    static /* synthetic */ void access$800(UCropActivity uCropActivity, int n2) {
        uCropActivity.rotateByAngle(n2);
    }

    static /* synthetic */ void access$900(UCropActivity uCropActivity, int n2) {
        uCropActivity.setWidgetState(n2);
    }

    private void addBlockingView() {
        if (this.mBlockingView == null) {
            this.mBlockingView = new View((Context)this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.toolbar);
            this.mBlockingView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            this.mBlockingView.setClickable(true);
        }
        ((RelativeLayout)this.findViewById(R.id.ucrop_photobox)).addView(this.mBlockingView);
    }

    private void initiateRootViews() {
        this.mUCropView = (UCropView)this.findViewById(R.id.ucrop);
        this.mGestureCropImageView = this.mUCropView.getCropImageView();
        this.mOverlayView = this.mUCropView.getOverlayView();
        this.mGestureCropImageView.setTransformImageListener(this.mImageListener);
        ((ImageView)this.findViewById(R.id.image_view_logo)).setColorFilter(this.mLogoColor, PorterDuff.Mode.SRC_ATOP);
        this.findViewById(R.id.ucrop_frame).setBackgroundColor(this.mRootViewBackgroundColor);
    }

    private void processOptions(Intent intent) {
        String string2 = intent.getStringExtra("com.yalantis.ucrop.CompressionFormatName");
        Bitmap.CompressFormat compressFormat = !TextUtils.isEmpty((CharSequence)string2) ? Bitmap.CompressFormat.valueOf((String)string2) : null;
        if (compressFormat == null) {
            compressFormat = DEFAULT_COMPRESS_FORMAT;
        }
        this.mCompressFormat = compressFormat;
        this.mCompressQuality = intent.getIntExtra("com.yalantis.ucrop.CompressionQuality", 90);
        int[] arrn = intent.getIntArrayExtra("com.yalantis.ucrop.AllowedGestures");
        if (arrn != null && arrn.length == 3) {
            this.mAllowedGestures = arrn;
        }
        this.mGestureCropImageView.setMaxBitmapSize(intent.getIntExtra("com.yalantis.ucrop.MaxBitmapSize", 0));
        this.mGestureCropImageView.setMaxScaleMultiplier(intent.getFloatExtra("com.yalantis.ucrop.MaxScaleMultiplier", 10.0f));
        this.mGestureCropImageView.setImageToWrapCropBoundsAnimDuration(intent.getIntExtra("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", 500));
        this.mOverlayView.setFreestyleCropEnabled(intent.getBooleanExtra("com.yalantis.ucrop.FreeStyleCrop", false));
        this.mOverlayView.setDimmedColor(intent.getIntExtra("com.yalantis.ucrop.DimmedLayerColor", this.getResources().getColor(R.color.ucrop_color_default_dimmed)));
        this.mOverlayView.setCircleDimmedLayer(intent.getBooleanExtra("com.yalantis.ucrop.CircleDimmedLayer", false));
        this.mOverlayView.setShowCropFrame(intent.getBooleanExtra("com.yalantis.ucrop.ShowCropFrame", true));
        this.mOverlayView.setCropFrameColor(intent.getIntExtra("com.yalantis.ucrop.CropFrameColor", this.getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.mOverlayView.setCropFrameStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CropFrameStrokeWidth", this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.mOverlayView.setShowCropGrid(intent.getBooleanExtra("com.yalantis.ucrop.ShowCropGrid", true));
        this.mOverlayView.setCropGridRowCount(intent.getIntExtra("com.yalantis.ucrop.CropGridRowCount", 2));
        this.mOverlayView.setCropGridColumnCount(intent.getIntExtra("com.yalantis.ucrop.CropGridColumnCount", 2));
        this.mOverlayView.setCropGridColor(intent.getIntExtra("com.yalantis.ucrop.CropGridColor", this.getResources().getColor(R.color.ucrop_color_default_crop_grid)));
        this.mOverlayView.setCropGridStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CropGridStrokeWidth", this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        float f2 = 0.0f;
        float f3 = intent.getFloatExtra("com.yalantis.ucrop.AspectRatioX", 0.0f);
        float f4 = intent.getFloatExtra("com.yalantis.ucrop.AspectRatioY", 0.0f);
        int n2 = intent.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList arrayList = intent.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
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
        int n3 = intent.getIntExtra("com.yalantis.ucrop.MaxSizeX", 0);
        int n4 = intent.getIntExtra("com.yalantis.ucrop.MaxSizeY", 0);
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

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void setImageData(Intent var1) {
        block2 : {
            var2_2 = (Uri)var1.getParcelableExtra("com.yalantis.ucrop.InputUri");
            var3_3 = (Uri)var1.getParcelableExtra("com.yalantis.ucrop.OutputUri");
            UCropActivity.super.processOptions(var1);
            if (var2_2 == null || var3_3 == null) break block2;
            try {
                this.mGestureCropImageView.setImageUri(var2_2, var3_3);
                return;
            }
            catch (Exception var4_4) {}
            ** GOTO lbl-1000
        }
        var4_5 = new NullPointerException(this.getString(R.string.ucrop_error_input_data_is_absent));
lbl-1000: // 2 sources:
        {
            this.setResultError((Throwable)var4_5);
            this.finish();
            return;
        }
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

    @TargetApi(value=21)
    private void setStatusBarColor(int n2) {
        Window window;
        if (Build.VERSION.SDK_INT >= 21 && (window = this.getWindow()) != null) {
            window.setFlags(1024, 1024);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(n2);
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
            UCropActivity.super.setAllowedGestures(0);
            return;
        }
        if (n2 == R.id.state_rotate) {
            UCropActivity.super.setAllowedGestures(1);
            return;
        }
        UCropActivity.super.setAllowedGestures(2);
    }

    private void setupAppBar() {
        this.setStatusBarColor(this.mStatusBarColor);
        Toolbar toolbar = (Toolbar)this.findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(this.mToolbarColor);
        toolbar.setTitleTextColor(this.mToolbarWidgetColor);
        TextView textView = (TextView)toolbar.findViewById(R.id.toolbar_title);
        textView.setTextColor(this.mToolbarWidgetColor);
        textView.setText((CharSequence)"");
        Drawable drawable2 = android.support.v4.content.a.a((Context)this, (int)this.mToolbarCancelDrawable).mutate();
        drawable2.setColorFilter(this.mToolbarWidgetColor, PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationIcon(drawable2);
        this.setSupportActionBar(toolbar);
        a a2 = this.getSupportActionBar();
        if (a2 != null) {
            a2.b();
        }
    }

    private void setupAspectRatioWidget(Intent intent) {
        int n2 = intent.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList arrayList = intent.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
        if (arrayList == null || arrayList.isEmpty()) {
            n2 = 2;
            arrayList = new ArrayList();
            arrayList.add((Object)new AspectRatio(null, 1.0f, 1.0f));
            arrayList.add((Object)new AspectRatio(null, 3.0f, 4.0f));
            arrayList.add((Object)new AspectRatio(this.getString(R.string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
            arrayList.add((Object)new AspectRatio(null, 3.0f, 2.0f));
            arrayList.add((Object)new AspectRatio(null, 16.0f, 9.0f));
        }
        LinearLayout linearLayout = (LinearLayout)this.findViewById(R.id.layout_aspect_ratio);
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
            ((ViewGroup)iterator.next()).setOnClickListener(new View.OnClickListener((UCropActivity)this){
                final /* synthetic */ UCropActivity this$0;
                {
                    this.this$0 = uCropActivity;
                }

                public void onClick(View view) {
                    UCropActivity.access$500(this.this$0).setTargetAspectRatio(((AspectRatioTextView)((ViewGroup)view).getChildAt(0)).getAspectRatio(view.isSelected()));
                    UCropActivity.access$500(this.this$0).setImageToWrapCropBounds();
                    if (!view.isSelected()) {
                        for (ViewGroup viewGroup : UCropActivity.access$600(this.this$0)) {
                            boolean bl = viewGroup == view;
                            viewGroup.setSelected(bl);
                        }
                    }
                }
            });
        }
    }

    private void setupRotateWidget() {
        this.mTextViewRotateAngle = (TextView)this.findViewById(R.id.text_view_rotate);
        ((HorizontalProgressWheelView)this.findViewById(R.id.rotate_scroll_wheel)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener(this){
            final /* synthetic */ UCropActivity this$0;
            {
                this.this$0 = uCropActivity;
            }

            public void onScroll(float f2, float f3) {
                UCropActivity.access$500(this.this$0).postRotate(f2 / 42.0f);
            }

            public void onScrollEnd() {
                UCropActivity.access$500(this.this$0).setImageToWrapCropBounds();
            }

            public void onScrollStart() {
                UCropActivity.access$500(this.this$0).cancelAllAnimations();
            }
        });
        ((HorizontalProgressWheelView)this.findViewById(R.id.rotate_scroll_wheel)).setMiddleLineColor(this.mActiveWidgetColor);
        this.findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ UCropActivity this$0;
            {
                this.this$0 = uCropActivity;
            }

            public void onClick(View view) {
                UCropActivity.access$700(this.this$0);
            }
        });
        this.findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ UCropActivity this$0;
            {
                this.this$0 = uCropActivity;
            }

            public void onClick(View view) {
                UCropActivity.access$800(this.this$0, 90);
            }
        });
    }

    private void setupScaleWidget() {
        this.mTextViewScalePercent = (TextView)this.findViewById(R.id.text_view_scale);
        ((HorizontalProgressWheelView)this.findViewById(R.id.scale_scroll_wheel)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener(this){
            final /* synthetic */ UCropActivity this$0;
            {
                this.this$0 = uCropActivity;
            }

            public void onScroll(float f2, float f3) {
                if (f2 > 0.0f) {
                    UCropActivity.access$500(this.this$0).zoomInImage(UCropActivity.access$500(this.this$0).getCurrentScale() + f2 * ((UCropActivity.access$500(this.this$0).getMaxScale() - UCropActivity.access$500(this.this$0).getMinScale()) / 15000.0f));
                    return;
                }
                UCropActivity.access$500(this.this$0).zoomOutImage(UCropActivity.access$500(this.this$0).getCurrentScale() + f2 * ((UCropActivity.access$500(this.this$0).getMaxScale() - UCropActivity.access$500(this.this$0).getMinScale()) / 15000.0f));
            }

            public void onScrollEnd() {
                UCropActivity.access$500(this.this$0).setImageToWrapCropBounds();
            }

            public void onScrollStart() {
                UCropActivity.access$500(this.this$0).cancelAllAnimations();
            }
        });
        ((HorizontalProgressWheelView)this.findViewById(R.id.scale_scroll_wheel)).setMiddleLineColor(this.mActiveWidgetColor);
    }

    private void setupStatesWrapper() {
        ImageView imageView = (ImageView)this.findViewById(R.id.image_view_state_scale);
        ImageView imageView2 = (ImageView)this.findViewById(R.id.image_view_state_rotate);
        ImageView imageView3 = (ImageView)this.findViewById(R.id.image_view_state_aspect_ratio);
        imageView.setImageDrawable((Drawable)new SelectedStateListDrawable(imageView.getDrawable(), this.mActiveWidgetColor));
        imageView2.setImageDrawable((Drawable)new SelectedStateListDrawable(imageView2.getDrawable(), this.mActiveWidgetColor));
        imageView3.setImageDrawable((Drawable)new SelectedStateListDrawable(imageView3.getDrawable(), this.mActiveWidgetColor));
    }

    private void setupViews(Intent intent) {
        this.mStatusBarColor = intent.getIntExtra("com.yalantis.ucrop.StatusBarColor", android.support.v4.content.a.c((Context)this, (int)R.color.ucrop_color_statusbar));
        this.mToolbarColor = intent.getIntExtra("com.yalantis.ucrop.ToolbarColor", android.support.v4.content.a.c((Context)this, (int)R.color.ucrop_color_toolbar));
        this.mActiveWidgetColor = intent.getIntExtra("com.yalantis.ucrop.UcropColorWidgetActive", android.support.v4.content.a.c((Context)this, (int)R.color.ucrop_color_widget_active));
        this.mToolbarWidgetColor = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarWidgetColor", android.support.v4.content.a.c((Context)this, (int)R.color.ucrop_color_toolbar_widget));
        this.mToolbarCancelDrawable = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCancelDrawable", R.drawable.ucrop_ic_cross);
        this.mToolbarCropDrawable = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCropDrawable", R.drawable.ucrop_ic_done);
        this.mToolbarTitle = intent.getStringExtra("com.yalantis.ucrop.UcropToolbarTitleText");
        String string2 = this.mToolbarTitle != null ? this.mToolbarTitle : this.getResources().getString(R.string.ucrop_label_edit_photo);
        this.mToolbarTitle = string2;
        this.mLogoColor = intent.getIntExtra("com.yalantis.ucrop.UcropLogoColor", android.support.v4.content.a.c((Context)this, (int)R.color.ucrop_color_default_logo));
        this.mShowBottomControls = true ^ intent.getBooleanExtra("com.yalantis.ucrop.HideBottomControls", false);
        this.mRootViewBackgroundColor = intent.getIntExtra("com.yalantis.ucrop.UcropRootViewBackgroundColor", android.support.v4.content.a.c((Context)this, (int)R.color.ucrop_color_crop_background));
        UCropActivity.super.setupAppBar();
        UCropActivity.super.initiateRootViews();
        if (this.mShowBottomControls) {
            ViewGroup viewGroup = (ViewGroup)this.findViewById(R.id.ucrop_photobox);
            View.inflate((Context)this, (int)R.layout.ucrop_controls, (ViewGroup)viewGroup);
            this.mWrapperStateAspectRatio = (ViewGroup)this.findViewById(R.id.state_aspect_ratio);
            this.mWrapperStateAspectRatio.setOnClickListener(this.mStateClickListener);
            this.mWrapperStateRotate = (ViewGroup)this.findViewById(R.id.state_rotate);
            this.mWrapperStateRotate.setOnClickListener(this.mStateClickListener);
            this.mWrapperStateScale = (ViewGroup)this.findViewById(R.id.state_scale);
            this.mWrapperStateScale.setOnClickListener(this.mStateClickListener);
            this.mLayoutAspectRatio = (ViewGroup)this.findViewById(R.id.layout_aspect_ratio);
            this.mLayoutRotate = (ViewGroup)this.findViewById(R.id.layout_rotate_wheel);
            this.mLayoutScale = (ViewGroup)this.findViewById(R.id.layout_scale_wheel);
            UCropActivity.super.setupAspectRatioWidget(intent);
            UCropActivity.super.setupRotateWidget();
            UCropActivity.super.setupScaleWidget();
            UCropActivity.super.setupStatesWrapper();
        }
    }

    protected void cropAndSaveImage() {
        this.mBlockingView.setClickable(true);
        this.mShowLoader = true;
        this.supportInvalidateOptionsMenu();
        this.mGestureCropImageView.cropAndSaveImage(this.mCompressFormat, this.mCompressQuality, new BitmapCropCallback(this){
            final /* synthetic */ UCropActivity this$0;
            {
                this.this$0 = uCropActivity;
            }

            public void onBitmapCropped(Uri uri, int n2, int n3, int n4, int n5) {
                this.this$0.setResultUri(uri, UCropActivity.access$500(this.this$0).getTargetAspectRatio(), n2, n3, n4, n5);
                this.this$0.finish();
            }

            public void onCropFailure(Throwable throwable) {
                this.this$0.setResultError(throwable);
                this.this$0.finish();
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.ucrop_activity_photobox);
        Intent intent = this.getIntent();
        UCropActivity.super.setupViews(intent);
        UCropActivity.super.setImageData(intent);
        UCropActivity.super.setInitialState();
        UCropActivity.super.addBlockingView();
    }

    public boolean onCreateOptionsMenu(Menu menu2) {
        this.getMenuInflater().inflate(R.menu.ucrop_menu_activity, menu2);
        MenuItem menuItem = menu2.findItem(R.id.menu_loader);
        Drawable drawable2 = menuItem.getIcon();
        if (drawable2 != null) {
            try {
                drawable2.mutate();
                drawable2.setColorFilter(this.mToolbarWidgetColor, PorterDuff.Mode.SRC_ATOP);
                menuItem.setIcon(drawable2);
            }
            catch (IllegalStateException illegalStateException) {
                Object[] arrobject = new Object[]{illegalStateException.getMessage(), this.getString(R.string.ucrop_mutate_exception_hint)};
                Log.i((String)TAG, (String)String.format((String)"%s - %s", (Object[])arrobject));
            }
            ((Animatable)menuItem.getIcon()).start();
        }
        MenuItem menuItem2 = menu2.findItem(R.id.menu_crop);
        Drawable drawable3 = android.support.v4.content.a.a((Context)this, (int)this.mToolbarCropDrawable);
        if (drawable3 != null) {
            drawable3.mutate();
            drawable3.setColorFilter(this.mToolbarWidgetColor, PorterDuff.Mode.SRC_ATOP);
            menuItem2.setIcon(drawable3);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_crop) {
            this.cropAndSaveImage();
        } else if (menuItem.getItemId() == 16908332) {
            this.onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public boolean onPrepareOptionsMenu(Menu menu2) {
        menu2.findItem(R.id.menu_crop).setVisible(true ^ this.mShowLoader);
        menu2.findItem(R.id.menu_loader).setVisible(this.mShowLoader);
        return super.onPrepareOptionsMenu(menu2);
    }

    protected void onStop() {
        super.onStop();
        if (this.mGestureCropImageView != null) {
            this.mGestureCropImageView.cancelAllAnimations();
        }
    }

    protected void setResultError(Throwable throwable) {
        this.setResult(96, new Intent().putExtra("com.yalantis.ucrop.Error", (Serializable)throwable));
    }

    protected void setResultUri(Uri uri, float f2, int n2, int n3, int n4, int n5) {
        this.setResult(-1, new Intent().putExtra("com.yalantis.ucrop.OutputUri", (Parcelable)uri).putExtra("com.yalantis.ucrop.CropAspectRatio", f2).putExtra("com.yalantis.ucrop.ImageWidth", n4).putExtra("com.yalantis.ucrop.ImageHeight", n5).putExtra("com.yalantis.ucrop.OffsetX", n2).putExtra("com.yalantis.ucrop.OffsetY", n3));
    }

}

