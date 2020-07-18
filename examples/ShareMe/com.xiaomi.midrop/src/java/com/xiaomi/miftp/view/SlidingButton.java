/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.AnimatorSet
 *  android.animation.AnimatorSet$Builder
 *  android.animation.ObjectAnimator
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.Rect
 *  android.graphics.Xfermode
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.support.v7.widget.AppCompatCheckBox
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  android.view.MotionEvent
 *  android.view.View
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.miftp.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import com.xiaomi.miftp.R;
import com.xiaomi.miftp.c.h;
import com.xiaomi.miftp.view.SlidingButton;

public class SlidingButton
extends AppCompatCheckBox {
    private Drawable a;
    private Drawable b;
    private int c;
    private Drawable d;
    private Bitmap e;
    private Paint f;
    private Bitmap g;
    private Paint h;
    private Bitmap i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private CompoundButton.OnCheckedChangeListener p;
    private Animator q;
    private boolean r;
    private boolean s;
    private Drawable t;
    private Drawable u;
    private Animator.AnimatorListener v;

    public SlidingButton(Context context) {
        super(context, null);
    }

    public SlidingButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public SlidingButton(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.r = false;
        this.s = false;
        this.v = new AnimatorListenerAdapter((SlidingButton)this){
            final /* synthetic */ SlidingButton a;
            private boolean b;
            {
                this.a = slidingButton;
            }

            public final void onAnimationCancel(Animator animator2) {
                this.b = true;
            }

            public final void onAnimationEnd(Animator animator2) {
                SlidingButton.a(this.a, false);
                if (!this.b) {
                    SlidingButton.a(this.a);
                    int n2 = SlidingButton.b(this.a);
                    int n3 = SlidingButton.c(this.a);
                    boolean bl = false;
                    if (n2 >= n3) {
                        bl = true;
                    }
                    if (bl != this.a.isChecked()) {
                        this.a.setChecked(bl);
                        if (SlidingButton.d(this.a) != null) {
                            this.a.post(new java.lang.Runnable(this, bl){
                                final /* synthetic */ boolean a;
                                final /* synthetic */ 1 b;
                                {
                                    this.b = var1;
                                    this.a = bl;
                                }

                                public final void run() {
                                    if (SlidingButton.d(this.b.a) != null) {
                                        SlidingButton.d(this.b.a).onCheckedChanged((CompoundButton)this.b.a, this.a);
                                    }
                                }
                            });
                        }
                    }
                }
            }

            public final void onAnimationStart(Animator animator2) {
                this.b = false;
                SlidingButton.a(this.a, true);
            }
        };
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.SlidingButton, n2, R.style.Widget_SlidingButton);
        this.setDrawingCacheEnabled(false);
        this.a = typedArray.getDrawable(R.styleable.SlidingButton_frame);
        this.b = typedArray.getDrawable(R.styleable.SlidingButton_sliderOn);
        this.d = typedArray.getDrawable(R.styleable.SlidingButton_sliderOff);
        this.setBackground(typedArray.getDrawable(R.styleable.SlidingButton_android_background));
        this.j = this.a.getIntrinsicWidth();
        this.k = this.a.getIntrinsicHeight();
        this.l = Math.min((int)this.j, (int)this.b.getIntrinsicWidth());
        this.m = 0;
        this.n = this.j - this.l;
        this.o = this.m;
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(R.styleable.SlidingButton_barOff, typedValue);
        TypedValue typedValue2 = new TypedValue();
        typedArray.getValue(R.styleable.SlidingButton_barOn, typedValue2);
        Drawable drawable2 = typedArray.getDrawable(R.styleable.SlidingButton_barOff);
        Drawable drawable3 = typedArray.getDrawable(R.styleable.SlidingButton_barOn);
        if (drawable2 instanceof BitmapDrawable && drawable3 instanceof BitmapDrawable) {
            this.e = Bitmap.createScaledBitmap((Bitmap)((BitmapDrawable)drawable2).getBitmap(), (int)(2 * this.j - this.l), (int)this.k, (boolean)true);
            Bitmap bitmap = typedValue.type == typedValue2.type && typedValue.data == typedValue2.data && typedValue.resourceId == typedValue2.resourceId ? this.e : Bitmap.createScaledBitmap((Bitmap)((BitmapDrawable)drawable3).getBitmap(), (int)(2 * this.j - this.l), (int)this.k, (boolean)true);
            this.g = bitmap;
        }
        this.a.setBounds(0, 0, this.j, this.k);
        this.f = new Paint();
        this.h = new Paint();
        this.h.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        if (this.g != null && this.e != null) {
            Drawable drawable4 = typedArray.getDrawable(R.styleable.SlidingButton_mask);
            drawable4.setBounds(0, 0, this.j, this.k);
            Rect rect = drawable4.getBounds();
            Bitmap bitmap = Bitmap.createBitmap((int)rect.width(), (int)rect.height(), (Bitmap.Config)Bitmap.Config.ALPHA_8);
            drawable4.draw(new Canvas(bitmap));
            this.i = bitmap;
            this.t = SlidingButton.super.a(true);
            this.u = SlidingButton.super.a(false);
        }
        typedArray.recycle();
    }

    static /* synthetic */ Animator a(SlidingButton slidingButton) {
        slidingButton.q = null;
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    private Drawable a(boolean bl) {
        Bitmap bitmap;
        Paint paint;
        Bitmap bitmap2 = Bitmap.createBitmap((int)this.j, (int)this.k, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap2);
        canvas.drawBitmap(this.i, 0.0f, 0.0f, null);
        if (bl) {
            bitmap = this.g;
            paint = this.h;
        } else {
            bitmap = this.e;
            paint = this.f;
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.getContext().getResources(), bitmap2);
        bitmapDrawable.setBounds(0, 0, this.j, this.k);
        return bitmapDrawable;
    }

    static /* synthetic */ boolean a(SlidingButton slidingButton, boolean bl) {
        slidingButton.r = bl;
        return bl;
    }

    static /* synthetic */ int b(SlidingButton slidingButton) {
        return slidingButton.o;
    }

    static /* synthetic */ int c(SlidingButton slidingButton) {
        return slidingButton.n;
    }

    static /* synthetic */ CompoundButton.OnCheckedChangeListener d(SlidingButton slidingButton) {
        return slidingButton.p;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.b.setState(this.getDrawableState());
    }

    public int getSliderOffset() {
        return this.o;
    }

    public int getSliderOnAlpha() {
        return this.c;
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void onDraw(Canvas canvas) {
        Drawable drawable2;
        int n2 = this.isEnabled() ? 255 : 127;
        if (this.i != null && this.g != null && this.e != null) {
            if (this.r) {
                canvas.saveLayerAlpha(0.0f, 0.0f, (float)this.i.getWidth(), (float)this.i.getHeight(), n2, 31);
                canvas.drawBitmap(this.i, 0.0f, 0.0f, null);
                if (this.h.getAlpha() != 0) {
                    canvas.drawBitmap(this.g, 0.0f, 0.0f, this.h);
                }
                if (this.f.getAlpha() != 0) {
                    canvas.drawBitmap(this.e, 0.0f, 0.0f, this.f);
                }
                canvas.restore();
            } else {
                Drawable drawable3 = this.isChecked() ? this.t : this.u;
                drawable3.draw(canvas);
            }
        }
        this.a.draw(canvas);
        boolean bl = h.a((View)this);
        int n3 = bl ? this.j - this.o - this.l : this.o;
        int n4 = bl ? this.j - this.o : this.l + this.o;
        if (this.isChecked()) {
            this.b.setBounds(n3, 0, n4, this.k);
            drawable2 = this.b;
        } else {
            this.d.setBounds(n3, 0, n4, this.k);
            drawable2 = this.d;
        }
        drawable2.draw(canvas);
        this.setAlpha((float)n2 / 255.0f);
    }

    protected void onMeasure(int n2, int n3) {
        this.setMeasuredDimension(this.j, this.k);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isEnabled()) {
            this.s = true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setButtonDrawable(Drawable drawable2) {
    }

    public void setChecked(boolean bl) {
        if (this.isChecked() != bl) {
            super.setChecked(bl);
            boolean bl2 = this.s;
            int n2 = 255;
            if (bl2) {
                if (this.q != null) {
                    this.q.cancel();
                    this.q = null;
                }
                AnimatorSet animatorSet = new AnimatorSet();
                int[] arrn = new int[1];
                int n3 = bl ? this.n : this.m;
                arrn[0] = n3;
                ObjectAnimator objectAnimator = ObjectAnimator.ofInt((Object)this, (String)"SliderOffset", (int[])arrn);
                int[] arrn2 = new int[1];
                if (!bl) {
                    n2 = 0;
                }
                arrn2[0] = n2;
                ObjectAnimator objectAnimator2 = ObjectAnimator.ofInt((Object)this, (String)"SliderOnAlpha", (int[])arrn2);
                objectAnimator2.setDuration(180L);
                objectAnimator.setDuration(180L);
                animatorSet.play((Animator)objectAnimator2).after((Animator)objectAnimator).after(100L);
                this.q = animatorSet;
                this.q.addListener(this.v);
                this.q.start();
                this.s = false;
                return;
            }
            int n4 = bl ? this.n : this.m;
            this.o = n4;
            Paint paint = this.h;
            int n5 = bl ? 255 : 0;
            paint.setAlpha(n5);
            Paint paint2 = this.f;
            int n6 = !bl ? 255 : 0;
            paint2.setAlpha(n6);
            if (!bl) {
                n2 = 0;
            }
            this.c = n2;
            this.invalidate();
        }
    }

    public void setOnPerformCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.p = onCheckedChangeListener;
    }

    public void setPressed(boolean bl) {
        super.setPressed(bl);
        this.invalidate();
    }

    public void setSliderOffset(int n2) {
        this.o = n2;
        this.invalidate();
    }

    public void setSliderOnAlpha(int n2) {
        this.c = n2;
        this.invalidate();
    }
}

