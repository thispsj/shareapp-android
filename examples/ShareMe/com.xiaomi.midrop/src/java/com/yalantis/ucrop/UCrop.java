/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.app.Fragment
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.support.v4.app.Fragment
 *  com.yalantis.ucrop.UCropActivity
 *  com.yalantis.ucrop.UCropFragment
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Locale
 */
package com.yalantis.ucrop;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.UCropFragment;
import com.yalantis.ucrop.model.AspectRatio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

public class UCrop {
    public static final String EXTRA_ASPECT_RATIO_X = "com.yalantis.ucrop.AspectRatioX";
    public static final String EXTRA_ASPECT_RATIO_Y = "com.yalantis.ucrop.AspectRatioY";
    public static final String EXTRA_ERROR = "com.yalantis.ucrop.Error";
    public static final String EXTRA_INPUT_URI = "com.yalantis.ucrop.InputUri";
    public static final String EXTRA_MAX_SIZE_X = "com.yalantis.ucrop.MaxSizeX";
    public static final String EXTRA_MAX_SIZE_Y = "com.yalantis.ucrop.MaxSizeY";
    public static final String EXTRA_OUTPUT_CROP_ASPECT_RATIO = "com.yalantis.ucrop.CropAspectRatio";
    public static final String EXTRA_OUTPUT_IMAGE_HEIGHT = "com.yalantis.ucrop.ImageHeight";
    public static final String EXTRA_OUTPUT_IMAGE_WIDTH = "com.yalantis.ucrop.ImageWidth";
    public static final String EXTRA_OUTPUT_OFFSET_X = "com.yalantis.ucrop.OffsetX";
    public static final String EXTRA_OUTPUT_OFFSET_Y = "com.yalantis.ucrop.OffsetY";
    public static final String EXTRA_OUTPUT_URI = "com.yalantis.ucrop.OutputUri";
    private static final String EXTRA_PREFIX = "com.yalantis.ucrop";
    public static final int MIN_SIZE = 10;
    public static final int REQUEST_CROP = 69;
    public static final int RESULT_ERROR = 96;
    private Intent mCropIntent = new Intent();
    private Bundle mCropOptionsBundle = new Bundle();

    private UCrop(Uri uri, Uri uri2) {
        this.mCropOptionsBundle.putParcelable(EXTRA_INPUT_URI, (Parcelable)uri);
        this.mCropOptionsBundle.putParcelable(EXTRA_OUTPUT_URI, (Parcelable)uri2);
    }

    public static Throwable getError(Intent intent) {
        return (Throwable)intent.getSerializableExtra(EXTRA_ERROR);
    }

    public static Uri getOutput(Intent intent) {
        return (Uri)intent.getParcelableExtra(EXTRA_OUTPUT_URI);
    }

    public static float getOutputCropAspectRatio(Intent intent) {
        return ((Float)intent.getParcelableExtra(EXTRA_OUTPUT_CROP_ASPECT_RATIO)).floatValue();
    }

    public static int getOutputImageHeight(Intent intent) {
        return intent.getIntExtra(EXTRA_OUTPUT_IMAGE_HEIGHT, -1);
    }

    public static int getOutputImageWidth(Intent intent) {
        return intent.getIntExtra(EXTRA_OUTPUT_IMAGE_WIDTH, -1);
    }

    public static UCrop of(Uri uri, Uri uri2) {
        return new UCrop(uri, uri2);
    }

    public UCropFragment getFragment() {
        return UCropFragment.newInstance((Bundle)this.mCropOptionsBundle);
    }

    public UCropFragment getFragment(Bundle bundle) {
        this.mCropOptionsBundle = bundle;
        return this.getFragment();
    }

    public Intent getIntent(Context context) {
        this.mCropIntent.setClass(context, UCropActivity.class);
        this.mCropIntent.putExtras(this.mCropOptionsBundle);
        return this.mCropIntent;
    }

    public void start(Activity activity) {
        this.start(activity, 69);
    }

    public void start(Activity activity, int n2) {
        activity.startActivityForResult(this.getIntent((Context)activity), n2);
    }

    public void start(Context context, android.app.Fragment fragment) {
        this.start(context, fragment, 69);
    }

    @TargetApi(value=11)
    public void start(Context context, android.app.Fragment fragment, int n2) {
        fragment.startActivityForResult(this.getIntent(context), n2);
    }

    public void start(Context context, Fragment fragment) {
        this.start(context, fragment, 69);
    }

    public void start(Context context, Fragment fragment, int n2) {
        fragment.startActivityForResult(this.getIntent(context), n2);
    }

    public UCrop useSourceImageAspectRatio() {
        this.mCropOptionsBundle.putFloat(EXTRA_ASPECT_RATIO_X, 0.0f);
        this.mCropOptionsBundle.putFloat(EXTRA_ASPECT_RATIO_Y, 0.0f);
        return this;
    }

    public UCrop withAspectRatio(float f2, float f3) {
        this.mCropOptionsBundle.putFloat(EXTRA_ASPECT_RATIO_X, f2);
        this.mCropOptionsBundle.putFloat(EXTRA_ASPECT_RATIO_Y, f3);
        return this;
    }

    public UCrop withMaxResultSize(int n2, int n3) {
        if (n2 < 10) {
            n2 = 10;
        }
        if (n3 < 10) {
            n3 = 10;
        }
        this.mCropOptionsBundle.putInt(EXTRA_MAX_SIZE_X, n2);
        this.mCropOptionsBundle.putInt(EXTRA_MAX_SIZE_Y, n3);
        return this;
    }

    public UCrop withOptions(Options options) {
        this.mCropOptionsBundle.putAll(options.getOptionBundle());
        return this;
    }

    public static class Options {
        public static final String EXTRA_ALLOWED_GESTURES = "com.yalantis.ucrop.AllowedGestures";
        public static final String EXTRA_ASPECT_RATIO_OPTIONS = "com.yalantis.ucrop.AspectRatioOptions";
        public static final String EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT = "com.yalantis.ucrop.AspectRatioSelectedByDefault";
        public static final String EXTRA_CIRCLE_DIMMED_LAYER = "com.yalantis.ucrop.CircleDimmedLayer";
        public static final String EXTRA_COMPRESSION_FORMAT_NAME = "com.yalantis.ucrop.CompressionFormatName";
        public static final String EXTRA_COMPRESSION_QUALITY = "com.yalantis.ucrop.CompressionQuality";
        public static final String EXTRA_CROP_FRAME_COLOR = "com.yalantis.ucrop.CropFrameColor";
        public static final String EXTRA_CROP_FRAME_STROKE_WIDTH = "com.yalantis.ucrop.CropFrameStrokeWidth";
        public static final String EXTRA_CROP_GRID_COLOR = "com.yalantis.ucrop.CropGridColor";
        public static final String EXTRA_CROP_GRID_COLUMN_COUNT = "com.yalantis.ucrop.CropGridColumnCount";
        public static final String EXTRA_CROP_GRID_ROW_COUNT = "com.yalantis.ucrop.CropGridRowCount";
        public static final String EXTRA_CROP_GRID_STROKE_WIDTH = "com.yalantis.ucrop.CropGridStrokeWidth";
        public static final String EXTRA_DIMMED_LAYER_COLOR = "com.yalantis.ucrop.DimmedLayerColor";
        public static final String EXTRA_FREE_STYLE_CROP = "com.yalantis.ucrop.FreeStyleCrop";
        public static final String EXTRA_HIDE_BOTTOM_CONTROLS = "com.yalantis.ucrop.HideBottomControls";
        public static final String EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION = "com.yalantis.ucrop.ImageToCropBoundsAnimDuration";
        public static final String EXTRA_MAX_BITMAP_SIZE = "com.yalantis.ucrop.MaxBitmapSize";
        public static final String EXTRA_MAX_SCALE_MULTIPLIER = "com.yalantis.ucrop.MaxScaleMultiplier";
        public static final String EXTRA_SHOW_CROP_FRAME = "com.yalantis.ucrop.ShowCropFrame";
        public static final String EXTRA_SHOW_CROP_GRID = "com.yalantis.ucrop.ShowCropGrid";
        public static final String EXTRA_STATUS_BAR_COLOR = "com.yalantis.ucrop.StatusBarColor";
        public static final String EXTRA_TOOL_BAR_COLOR = "com.yalantis.ucrop.ToolbarColor";
        public static final String EXTRA_UCROP_COLOR_WIDGET_ACTIVE = "com.yalantis.ucrop.UcropColorWidgetActive";
        public static final String EXTRA_UCROP_LOGO_COLOR = "com.yalantis.ucrop.UcropLogoColor";
        public static final String EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR = "com.yalantis.ucrop.UcropRootViewBackgroundColor";
        public static final String EXTRA_UCROP_TITLE_TEXT_TOOLBAR = "com.yalantis.ucrop.UcropToolbarTitleText";
        public static final String EXTRA_UCROP_WIDGET_CANCEL_DRAWABLE = "com.yalantis.ucrop.UcropToolbarCancelDrawable";
        public static final String EXTRA_UCROP_WIDGET_COLOR_TOOLBAR = "com.yalantis.ucrop.UcropToolbarWidgetColor";
        public static final String EXTRA_UCROP_WIDGET_CROP_DRAWABLE = "com.yalantis.ucrop.UcropToolbarCropDrawable";
        private final Bundle mOptionBundle = new Bundle();

        public Bundle getOptionBundle() {
            return this.mOptionBundle;
        }

        public void setActiveWidgetColor(int n2) {
            this.mOptionBundle.putInt(EXTRA_UCROP_COLOR_WIDGET_ACTIVE, n2);
        }

        public void setAllowedGestures(int n2, int n3, int n4) {
            this.mOptionBundle.putIntArray(EXTRA_ALLOWED_GESTURES, new int[]{n2, n3, n4});
        }

        public /* varargs */ void setAspectRatioOptions(int n2, AspectRatio ... arraspectRatio) {
            if (n2 > arraspectRatio.length) {
                Locale locale = Locale.US;
                Object[] arrobject = new Object[]{n2, arraspectRatio.length};
                throw new IllegalArgumentException(String.format((Locale)locale, (String)"Index [selectedByDefault = %d] cannot be higher than aspect ratio options count [count = %d].", (Object[])arrobject));
            }
            this.mOptionBundle.putInt(EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, n2);
            this.mOptionBundle.putParcelableArrayList(EXTRA_ASPECT_RATIO_OPTIONS, new ArrayList((Collection)Arrays.asList((Object[])arraspectRatio)));
        }

        public void setCircleDimmedLayer(boolean bl) {
            this.mOptionBundle.putBoolean(EXTRA_CIRCLE_DIMMED_LAYER, bl);
        }

        public void setCompressionFormat(Bitmap.CompressFormat compressFormat) {
            this.mOptionBundle.putString(EXTRA_COMPRESSION_FORMAT_NAME, compressFormat.name());
        }

        public void setCompressionQuality(int n2) {
            this.mOptionBundle.putInt(EXTRA_COMPRESSION_QUALITY, n2);
        }

        public void setCropFrameColor(int n2) {
            this.mOptionBundle.putInt(EXTRA_CROP_FRAME_COLOR, n2);
        }

        public void setCropFrameStrokeWidth(int n2) {
            this.mOptionBundle.putInt(EXTRA_CROP_FRAME_STROKE_WIDTH, n2);
        }

        public void setCropGridColor(int n2) {
            this.mOptionBundle.putInt(EXTRA_CROP_GRID_COLOR, n2);
        }

        public void setCropGridColumnCount(int n2) {
            this.mOptionBundle.putInt(EXTRA_CROP_GRID_COLUMN_COUNT, n2);
        }

        public void setCropGridRowCount(int n2) {
            this.mOptionBundle.putInt(EXTRA_CROP_GRID_ROW_COUNT, n2);
        }

        public void setCropGridStrokeWidth(int n2) {
            this.mOptionBundle.putInt(EXTRA_CROP_GRID_STROKE_WIDTH, n2);
        }

        public void setDimmedLayerColor(int n2) {
            this.mOptionBundle.putInt(EXTRA_DIMMED_LAYER_COLOR, n2);
        }

        public void setFreeStyleCropEnabled(boolean bl) {
            this.mOptionBundle.putBoolean(EXTRA_FREE_STYLE_CROP, bl);
        }

        public void setHideBottomControls(boolean bl) {
            this.mOptionBundle.putBoolean(EXTRA_HIDE_BOTTOM_CONTROLS, bl);
        }

        public void setImageToCropBoundsAnimDuration(int n2) {
            this.mOptionBundle.putInt(EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, n2);
        }

        public void setLogoColor(int n2) {
            this.mOptionBundle.putInt(EXTRA_UCROP_LOGO_COLOR, n2);
        }

        public void setMaxBitmapSize(int n2) {
            this.mOptionBundle.putInt(EXTRA_MAX_BITMAP_SIZE, n2);
        }

        public void setMaxScaleMultiplier(float f2) {
            this.mOptionBundle.putFloat(EXTRA_MAX_SCALE_MULTIPLIER, f2);
        }

        public void setRootViewBackgroundColor(int n2) {
            this.mOptionBundle.putInt(EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR, n2);
        }

        public void setShowCropFrame(boolean bl) {
            this.mOptionBundle.putBoolean(EXTRA_SHOW_CROP_FRAME, bl);
        }

        public void setShowCropGrid(boolean bl) {
            this.mOptionBundle.putBoolean(EXTRA_SHOW_CROP_GRID, bl);
        }

        public void setStatusBarColor(int n2) {
            this.mOptionBundle.putInt(EXTRA_STATUS_BAR_COLOR, n2);
        }

        public void setToolbarCancelDrawable(int n2) {
            this.mOptionBundle.putInt(EXTRA_UCROP_WIDGET_CANCEL_DRAWABLE, n2);
        }

        public void setToolbarColor(int n2) {
            this.mOptionBundle.putInt(EXTRA_TOOL_BAR_COLOR, n2);
        }

        public void setToolbarCropDrawable(int n2) {
            this.mOptionBundle.putInt(EXTRA_UCROP_WIDGET_CROP_DRAWABLE, n2);
        }

        public void setToolbarTitle(String string2) {
            this.mOptionBundle.putString(EXTRA_UCROP_TITLE_TEXT_TOOLBAR, string2);
        }

        public void setToolbarWidgetColor(int n2) {
            this.mOptionBundle.putInt(EXTRA_UCROP_WIDGET_COLOR_TOOLBAR, n2);
        }

        public void useSourceImageAspectRatio() {
            this.mOptionBundle.putFloat(UCrop.EXTRA_ASPECT_RATIO_X, 0.0f);
            this.mOptionBundle.putFloat(UCrop.EXTRA_ASPECT_RATIO_Y, 0.0f);
        }

        public void withAspectRatio(float f2, float f3) {
            this.mOptionBundle.putFloat(UCrop.EXTRA_ASPECT_RATIO_X, f2);
            this.mOptionBundle.putFloat(UCrop.EXTRA_ASPECT_RATIO_Y, f3);
        }

        public void withMaxResultSize(int n2, int n3) {
            this.mOptionBundle.putInt(UCrop.EXTRA_MAX_SIZE_X, n2);
            this.mOptionBundle.putInt(UCrop.EXTRA_MAX_SIZE_Y, n3);
        }
    }

}

