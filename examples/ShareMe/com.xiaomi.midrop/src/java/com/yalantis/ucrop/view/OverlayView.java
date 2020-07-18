/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.RectF
 *  android.graphics.Region
 *  android.graphics.Region$Op
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  java.lang.Deprecated
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.annotation.Annotation
 *  java.lang.annotation.Retention
 *  java.lang.annotation.RetentionPolicy
 */
package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;
import com.yalantis.ucrop.util.RectUtils;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class OverlayView
extends View {
    public static final boolean DEFAULT_CIRCLE_DIMMED_LAYER = false;
    public static final int DEFAULT_CROP_GRID_COLUMN_COUNT = 2;
    public static final int DEFAULT_CROP_GRID_ROW_COUNT = 2;
    public static final int DEFAULT_FREESTYLE_CROP_MODE = 0;
    public static final boolean DEFAULT_SHOW_CROP_FRAME = true;
    public static final boolean DEFAULT_SHOW_CROP_GRID = true;
    public static final int FREESTYLE_CROP_MODE_DISABLE = 0;
    public static final int FREESTYLE_CROP_MODE_ENABLE = 1;
    public static final int FREESTYLE_CROP_MODE_ENABLE_WITH_PASS_THROUGH = 2;
    private OverlayViewChangeListener mCallback;
    private boolean mCircleDimmedLayer;
    private Path mCircularPath;
    private Paint mCropFrameCornersPaint;
    private Paint mCropFramePaint;
    protected float[] mCropGridCenter;
    private int mCropGridColumnCount;
    protected float[] mCropGridCorners;
    private Paint mCropGridPaint;
    private int mCropGridRowCount;
    private int mCropRectCornerTouchAreaLineLength;
    private int mCropRectMinSize;
    private final RectF mCropViewRect;
    private int mCurrentTouchCornerIndex;
    private int mDimmedColor;
    private Paint mDimmedStrokePaint;
    private int mFreestyleCropMode;
    private float[] mGridPoints;
    private float mPreviousTouchX;
    private float mPreviousTouchY;
    private boolean mShouldSetupCropBounds;
    private boolean mShowCropFrame;
    private boolean mShowCropGrid;
    private float mTargetAspectRatio;
    private final RectF mTempRect;
    protected int mThisHeight;
    protected int mThisWidth;
    private int mTouchPointThreshold;

    public OverlayView(Context context) {
        super(context, null);
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public OverlayView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.mCropViewRect = new RectF();
        this.mTempRect = new RectF();
        this.mGridPoints = null;
        this.mCircularPath = new Path();
        this.mDimmedStrokePaint = new Paint(1);
        this.mCropGridPaint = new Paint(1);
        this.mCropFramePaint = new Paint(1);
        this.mCropFrameCornersPaint = new Paint(1);
        this.mFreestyleCropMode = 0;
        this.mPreviousTouchX = -1.0f;
        this.mPreviousTouchY = -1.0f;
        this.mCurrentTouchCornerIndex = -1;
        this.mTouchPointThreshold = this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_threshold);
        this.mCropRectMinSize = this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_min_size);
        this.mCropRectCornerTouchAreaLineLength = this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_area_line_length);
        this.init();
    }

    private int getCurrentTouchIndex(float f2, float f3) {
        double d2 = this.mTouchPointThreshold;
        int n2 = -1;
        for (int i2 = 0; i2 < 8; i2 += 2) {
            double d3 = Math.sqrt((double)(Math.pow((double)(f2 - this.mCropGridCorners[i2]), (double)2.0) + Math.pow((double)(f3 - this.mCropGridCorners[i2 + 1]), (double)2.0)));
            if (!(d3 < d2)) continue;
            n2 = i2 / 2;
            d2 = d3;
        }
        if (this.mFreestyleCropMode == 1 && n2 < 0 && this.mCropViewRect.contains(f2, f3)) {
            return 4;
        }
        return n2;
    }

    private void initCropFrameStyle(TypedArray typedArray) {
        int n2 = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_frame_stroke_size, this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width));
        int n3 = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_frame_color, this.getResources().getColor(R.color.ucrop_color_default_crop_frame));
        this.mCropFramePaint.setStrokeWidth((float)n2);
        this.mCropFramePaint.setColor(n3);
        this.mCropFramePaint.setStyle(Paint.Style.STROKE);
        this.mCropFrameCornersPaint.setStrokeWidth((float)(n2 * 3));
        this.mCropFrameCornersPaint.setColor(n3);
        this.mCropFrameCornersPaint.setStyle(Paint.Style.STROKE);
    }

    private void initCropGridStyle(TypedArray typedArray) {
        int n2 = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_grid_stroke_size, this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width));
        int n3 = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_grid_color, this.getResources().getColor(R.color.ucrop_color_default_crop_grid));
        this.mCropGridPaint.setStrokeWidth((float)n2);
        this.mCropGridPaint.setColor(n3);
        this.mCropGridRowCount = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_row_count, 2);
        this.mCropGridColumnCount = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_column_count, 2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void updateCropViewRect(float var1, float var2_2) {
        this.mTempRect.set(this.mCropViewRect);
        switch (this.mCurrentTouchCornerIndex) {
            default: {
                ** break;
            }
            case 4: {
                this.mTempRect.offset(var1 - this.mPreviousTouchX, var2_2 - this.mPreviousTouchY);
                if (!(this.mTempRect.left > (float)this.getLeft())) return;
                if (!(this.mTempRect.top > (float)this.getTop())) return;
                if (!(this.mTempRect.right < (float)this.getRight())) return;
                if (!(this.mTempRect.bottom < (float)this.getBottom())) return;
                this.mCropViewRect.set(this.mTempRect);
                OverlayView.super.updateGridPoints();
                this.postInvalidate();
                return;
            }
            case 3: {
                this.mTempRect.set(var1, this.mCropViewRect.top, this.mCropViewRect.right, var2_2);
                ** break;
            }
            case 2: {
                this.mTempRect.set(this.mCropViewRect.left, this.mCropViewRect.top, var1, var2_2);
                ** break;
            }
            case 1: {
                this.mTempRect.set(this.mCropViewRect.left, var2_2, var1, this.mCropViewRect.bottom);
                ** break;
            }
            case 0: 
        }
        this.mTempRect.set(var1, var2_2, this.mCropViewRect.right, this.mCropViewRect.bottom);
lbl26: // 5 sources:
        var3_3 = this.mTempRect.height() >= (float)this.mCropRectMinSize;
        var4_4 = this.mTempRect.width() FCMPL (float)this.mCropRectMinSize;
        var5_5 = false;
        if (var4_4 >= 0) {
            var5_5 = true;
        }
        var6_6 = this.mCropViewRect;
        var7_7 = var5_5 != false ? this.mTempRect : this.mCropViewRect;
        var8_8 = var7_7.left;
        var9_9 = var3_3 != false ? this.mTempRect : this.mCropViewRect;
        var10_10 = var9_9.top;
        var11_11 = var5_5 != false ? this.mTempRect : this.mCropViewRect;
        var12_12 = var11_11.right;
        var13_13 = var3_3 != false ? this.mTempRect : this.mCropViewRect;
        var14_14 = var13_13.bottom;
        var6_6.set(var8_8, var10_10, var12_12, var14_14);
        if (!var3_3) {
            if (var5_5 == false) return;
        }
        OverlayView.super.updateGridPoints();
        this.postInvalidate();
    }

    private void updateGridPoints() {
        this.mCropGridCorners = RectUtils.getCornersFromRect(this.mCropViewRect);
        this.mCropGridCenter = RectUtils.getCenterFromRect(this.mCropViewRect);
        this.mGridPoints = null;
        this.mCircularPath.reset();
        this.mCircularPath.addCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), Math.min((float)this.mCropViewRect.width(), (float)this.mCropViewRect.height()) / 2.0f, Path.Direction.CW);
    }

    protected void drawCropGrid(Canvas canvas) {
        if (this.mShowCropGrid) {
            if (this.mGridPoints == null && !this.mCropViewRect.isEmpty()) {
                this.mGridPoints = new float[4 * this.mCropGridRowCount + 4 * this.mCropGridColumnCount];
                int n2 = 0;
                int n3 = 0;
                do {
                    int n4 = this.mCropGridRowCount;
                    if (n2 >= n4) break;
                    float[] arrf = this.mGridPoints;
                    int n5 = n3 + 1;
                    arrf[n3] = this.mCropViewRect.left;
                    float[] arrf2 = this.mGridPoints;
                    int n6 = n5 + 1;
                    float f2 = this.mCropViewRect.height();
                    float f3 = 1.0f + (float)n2;
                    arrf2[n5] = f2 * (f3 / (float)(1 + this.mCropGridRowCount)) + this.mCropViewRect.top;
                    float[] arrf3 = this.mGridPoints;
                    int n7 = n6 + 1;
                    arrf3[n6] = this.mCropViewRect.right;
                    float[] arrf4 = this.mGridPoints;
                    int n8 = n7 + 1;
                    arrf4[n7] = this.mCropViewRect.height() * (f3 / (float)(1 + this.mCropGridRowCount)) + this.mCropViewRect.top;
                    ++n2;
                    n3 = n8;
                } while (true);
                for (int i2 = 0; i2 < this.mCropGridColumnCount; ++i2) {
                    float[] arrf = this.mGridPoints;
                    int n9 = n3 + 1;
                    float f4 = this.mCropViewRect.width();
                    float f5 = 1.0f + (float)i2;
                    arrf[n3] = f4 * (f5 / (float)(1 + this.mCropGridColumnCount)) + this.mCropViewRect.left;
                    float[] arrf5 = this.mGridPoints;
                    int n10 = n9 + 1;
                    arrf5[n9] = this.mCropViewRect.top;
                    float[] arrf6 = this.mGridPoints;
                    int n11 = n10 + 1;
                    arrf6[n10] = this.mCropViewRect.width() * (f5 / (float)(1 + this.mCropGridColumnCount)) + this.mCropViewRect.left;
                    float[] arrf7 = this.mGridPoints;
                    n3 = n11 + 1;
                    arrf7[n11] = this.mCropViewRect.bottom;
                }
            }
            if (this.mGridPoints != null) {
                canvas.drawLines(this.mGridPoints, this.mCropGridPaint);
            }
        }
        if (this.mShowCropFrame) {
            canvas.drawRect(this.mCropViewRect, this.mCropFramePaint);
        }
        if (this.mFreestyleCropMode != 0) {
            canvas.save();
            this.mTempRect.set(this.mCropViewRect);
            this.mTempRect.inset((float)this.mCropRectCornerTouchAreaLineLength, (float)(-this.mCropRectCornerTouchAreaLineLength));
            canvas.clipRect(this.mTempRect, Region.Op.DIFFERENCE);
            this.mTempRect.set(this.mCropViewRect);
            this.mTempRect.inset((float)(-this.mCropRectCornerTouchAreaLineLength), (float)this.mCropRectCornerTouchAreaLineLength);
            canvas.clipRect(this.mTempRect, Region.Op.DIFFERENCE);
            canvas.drawRect(this.mCropViewRect, this.mCropFrameCornersPaint);
            canvas.restore();
        }
    }

    protected void drawDimmedLayer(Canvas canvas) {
        canvas.save();
        if (this.mCircleDimmedLayer) {
            canvas.clipPath(this.mCircularPath, Region.Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.mCropViewRect, Region.Op.DIFFERENCE);
        }
        canvas.drawColor(this.mDimmedColor);
        canvas.restore();
        if (this.mCircleDimmedLayer) {
            canvas.drawCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), Math.min((float)this.mCropViewRect.width(), (float)this.mCropViewRect.height()) / 2.0f, this.mDimmedStrokePaint);
        }
    }

    public RectF getCropViewRect() {
        return this.mCropViewRect;
    }

    public int getFreestyleCropMode() {
        return this.mFreestyleCropMode;
    }

    public OverlayViewChangeListener getOverlayViewChangeListener() {
        return this.mCallback;
    }

    protected void init() {
        if (Build.VERSION.SDK_INT < 18) {
            this.setLayerType(1, null);
        }
    }

    @Deprecated
    public boolean isFreestyleCropEnabled() {
        return this.mFreestyleCropMode == 1;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.drawDimmedLayer(canvas);
        this.drawCropGrid(canvas);
    }

    protected void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        super.onLayout(bl, n2, n3, n4, n5);
        if (bl) {
            int n6 = this.getPaddingLeft();
            int n7 = this.getPaddingTop();
            int n8 = this.getWidth() - this.getPaddingRight();
            int n9 = this.getHeight() - this.getPaddingBottom();
            this.mThisWidth = n8 - n6;
            this.mThisHeight = n9 - n7;
            if (this.mShouldSetupCropBounds) {
                this.mShouldSetupCropBounds = false;
                this.setTargetAspectRatio(this.mTargetAspectRatio);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mCropViewRect.isEmpty()) {
            if (this.mFreestyleCropMode == 0) {
                return false;
            }
            float f2 = motionEvent.getX();
            float f3 = motionEvent.getY();
            if ((255 & motionEvent.getAction()) == 0) {
                int n2 = this.mCurrentTouchCornerIndex = OverlayView.super.getCurrentTouchIndex(f2, f3);
                boolean bl = false;
                if (n2 != -1) {
                    bl = true;
                }
                if (!bl) {
                    this.mPreviousTouchX = -1.0f;
                    this.mPreviousTouchY = -1.0f;
                    return bl;
                }
                if (this.mPreviousTouchX < 0.0f) {
                    this.mPreviousTouchX = f2;
                    this.mPreviousTouchY = f3;
                }
                return bl;
            }
            if ((255 & motionEvent.getAction()) == 2 && motionEvent.getPointerCount() == 1 && this.mCurrentTouchCornerIndex != -1) {
                float f4 = Math.min((float)Math.max((float)f2, (float)this.getPaddingLeft()), (float)(this.getWidth() - this.getPaddingRight()));
                float f5 = Math.min((float)Math.max((float)f3, (float)this.getPaddingTop()), (float)(this.getHeight() - this.getPaddingBottom()));
                OverlayView.super.updateCropViewRect(f4, f5);
                this.mPreviousTouchX = f4;
                this.mPreviousTouchY = f5;
                return true;
            }
            if ((255 & motionEvent.getAction()) == 1) {
                this.mPreviousTouchX = -1.0f;
                this.mPreviousTouchY = -1.0f;
                this.mCurrentTouchCornerIndex = -1;
                if (this.mCallback != null) {
                    this.mCallback.onCropRectUpdated(this.mCropViewRect);
                }
            }
        }
        return false;
    }

    protected void processStyledAttributes(TypedArray typedArray) {
        this.mCircleDimmedLayer = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_circle_dimmed_layer, false);
        this.mDimmedColor = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_dimmed_color, this.getResources().getColor(R.color.ucrop_color_default_dimmed));
        this.mDimmedStrokePaint.setColor(this.mDimmedColor);
        this.mDimmedStrokePaint.setStyle(Paint.Style.STROKE);
        this.mDimmedStrokePaint.setStrokeWidth(1.0f);
        OverlayView.super.initCropFrameStyle(typedArray);
        this.mShowCropFrame = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_frame, true);
        OverlayView.super.initCropGridStyle(typedArray);
        this.mShowCropGrid = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_grid, true);
    }

    public void setCircleDimmedLayer(boolean bl) {
        this.mCircleDimmedLayer = bl;
    }

    public void setCropFrameColor(int n2) {
        this.mCropFramePaint.setColor(n2);
    }

    public void setCropFrameStrokeWidth(int n2) {
        this.mCropFramePaint.setStrokeWidth((float)n2);
    }

    public void setCropGridColor(int n2) {
        this.mCropGridPaint.setColor(n2);
    }

    public void setCropGridColumnCount(int n2) {
        this.mCropGridColumnCount = n2;
        this.mGridPoints = null;
    }

    public void setCropGridRowCount(int n2) {
        this.mCropGridRowCount = n2;
        this.mGridPoints = null;
    }

    public void setCropGridStrokeWidth(int n2) {
        this.mCropGridPaint.setStrokeWidth((float)n2);
    }

    public void setDimmedColor(int n2) {
        this.mDimmedColor = n2;
    }

    @Deprecated
    public void setFreestyleCropEnabled(boolean bl) {
        this.mFreestyleCropMode = bl ? 1 : 0;
    }

    public void setFreestyleCropMode(int n2) {
        this.mFreestyleCropMode = n2;
        this.postInvalidate();
    }

    public void setOverlayViewChangeListener(OverlayViewChangeListener overlayViewChangeListener) {
        this.mCallback = overlayViewChangeListener;
    }

    public void setShowCropFrame(boolean bl) {
        this.mShowCropFrame = bl;
    }

    public void setShowCropGrid(boolean bl) {
        this.mShowCropGrid = bl;
    }

    public void setTargetAspectRatio(float f2) {
        this.mTargetAspectRatio = f2;
        if (this.mThisWidth > 0) {
            this.setupCropBounds();
            this.postInvalidate();
            return;
        }
        this.mShouldSetupCropBounds = true;
    }

    public void setupCropBounds() {
        int n2 = (int)((float)this.mThisWidth / this.mTargetAspectRatio);
        if (n2 > this.mThisHeight) {
            int n3 = (int)((float)this.mThisHeight * this.mTargetAspectRatio);
            int n4 = (this.mThisWidth - n3) / 2;
            this.mCropViewRect.set((float)(n4 + this.getPaddingLeft()), (float)this.getPaddingTop(), (float)(n4 + (n3 + this.getPaddingLeft())), (float)(this.getPaddingTop() + this.mThisHeight));
        } else {
            int n5 = (this.mThisHeight - n2) / 2;
            this.mCropViewRect.set((float)this.getPaddingLeft(), (float)(n5 + this.getPaddingTop()), (float)(this.getPaddingLeft() + this.mThisWidth), (float)(n5 + (n2 + this.getPaddingTop())));
        }
        if (this.mCallback != null) {
            this.mCallback.onCropRectUpdated(this.mCropViewRect);
        }
        this.updateGridPoints();
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface FreestyleMode {
    }

}

