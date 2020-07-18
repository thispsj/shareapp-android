/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ObjectAnimator
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Typeface
 *  android.os.Handler
 *  android.os.SystemClock
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.Property
 *  android.util.TypedValue
 *  android.view.View
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.xiaomi.midrop.view.rocket;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Property;
import android.util.TypedValue;
import android.view.View;
import com.xiaomi.midrop.view.rocket.b;
import com.xiaomi.midrop.view.rocket.c;
import com.xiaomi.midrop.view.rocket.d;

public class RocketFlyCircleView
extends View {
    public float A;
    Matrix B;
    Path C;
    int D;
    float E;
    public boolean F = false;
    Property<RocketFlyCircleView, Float> G;
    public Handler H;
    public Runnable I;
    private b J;
    private com.xiaomi.midrop.view.rocket.a[] K;
    private String L;
    private Paint M;
    private float N;
    private float O;
    private float P;
    private float Q;
    private RectF R = new RectF();
    private float S;
    private float T;
    private float U;
    private float V;
    private float W;
    float a;
    private float aa;
    float b;
    float c;
    float d;
    d e;
    Paint f;
    c[] g;
    public boolean h = false;
    public float i;
    int j = 2000;
    public int k = 0;
    public long l;
    public long m;
    public boolean n = false;
    Bitmap o;
    Bitmap p;
    public float q;
    public float r;
    public float s;
    public float t;
    boolean u = false;
    public int v = 0;
    a w;
    public int x;
    public float y;
    public float z;

    public RocketFlyCircleView(Context context) {
        super(context);
        this.G = new Property<RocketFlyCircleView, Float>(Float.class, "mRocketY"){

            public final /* synthetic */ Object get(Object object) {
                return Float.valueOf((float)((RocketFlyCircleView)((Object)object)).getRocketY());
            }

            public final /* synthetic */ void set(Object object, Object object2) {
                ((RocketFlyCircleView)((Object)object)).setRocketY(((Float)object2).floatValue());
            }
        };
        this.H = new Handler();
        this.I = new Runnable(){

            /*
             * Enabled aggressive block sorting
             */
            public final void run() {
                long l2;
                block15 : {
                    float f2;
                    block17 : {
                        RocketFlyCircleView rocketFlyCircleView;
                        block14 : {
                            block10 : {
                                float f3;
                                block16 : {
                                    RocketFlyCircleView rocketFlyCircleView2;
                                    block11 : {
                                        block12 : {
                                            block13 : {
                                                int n2;
                                                l2 = SystemClock.elapsedRealtime();
                                                if (l2 - RocketFlyCircleView.this.l > (long)(RocketFlyCircleView.this.j / 2)) {
                                                    RocketFlyCircleView.this.i = 50.0f;
                                                }
                                                if (l2 - RocketFlyCircleView.this.l > (long)RocketFlyCircleView.this.j) {
                                                    return;
                                                }
                                                RocketFlyCircleView rocketFlyCircleView3 = RocketFlyCircleView.this;
                                                rocketFlyCircleView3.k = 1 + rocketFlyCircleView3.k;
                                                RocketFlyCircleView rocketFlyCircleView4 = RocketFlyCircleView.this;
                                                rocketFlyCircleView4.x = 1 + rocketFlyCircleView4.x;
                                                if (RocketFlyCircleView.this.x > 10) {
                                                    RocketFlyCircleView.this.x = 1;
                                                }
                                                if ((n2 = RocketFlyCircleView.this.x) == 1) break block10;
                                                if (n2 == 3) break block11;
                                                if (n2 == 5) break block12;
                                                if (n2 == 7) break block13;
                                                if (n2 == 10) break block14;
                                                break block15;
                                            }
                                            rocketFlyCircleView2 = RocketFlyCircleView.this;
                                            f3 = RocketFlyCircleView.this.P;
                                            break block16;
                                        }
                                        RocketFlyCircleView.this.y = 0.0f;
                                        RocketFlyCircleView.this.z = 0.0f;
                                        rocketFlyCircleView = RocketFlyCircleView.this;
                                        f2 = 1.2f;
                                        break block17;
                                    }
                                    rocketFlyCircleView2 = RocketFlyCircleView.this;
                                    f3 = -RocketFlyCircleView.this.P;
                                }
                                rocketFlyCircleView2.y = f3;
                                RocketFlyCircleView.this.z = -RocketFlyCircleView.this.Q;
                                break block15;
                            }
                            RocketFlyCircleView.this.y = 0.0f;
                            RocketFlyCircleView.this.z = 0.0f;
                        }
                        rocketFlyCircleView = RocketFlyCircleView.this;
                        f2 = 1.0f;
                    }
                    rocketFlyCircleView.A = f2;
                }
                boolean bl = RocketFlyCircleView.this.h;
                int n3 = 0;
                if (bl) {
                    for (c c2 : RocketFlyCircleView.this.g) {
                        c2.j += RocketFlyCircleView.this.i;
                        if (!(c2.a() >= c2.b())) continue;
                        RocketFlyCircleView.this.e.a(c2);
                        if (!(RocketFlyCircleView.this.i >= 50.0f) || !(c2.e > 0.2f)) continue;
                        c2.e = 0.8f * c2.e;
                    }
                }
                if (!RocketFlyCircleView.this.u && RocketFlyCircleView.this.v < RocketFlyCircleView.this.D) {
                    RocketFlyCircleView rocketFlyCircleView = RocketFlyCircleView.this;
                    rocketFlyCircleView.r -= 2.0f;
                    RocketFlyCircleView rocketFlyCircleView5 = RocketFlyCircleView.this;
                    rocketFlyCircleView5.v = 2 + rocketFlyCircleView5.v;
                    RocketFlyCircleView.this.m = l2;
                }
                if (RocketFlyCircleView.this.K != null) {
                    com.xiaomi.midrop.view.rocket.a[] arra = RocketFlyCircleView.this.K;
                    int n4 = arra.length;
                    while (n3 < n4) {
                        com.xiaomi.midrop.view.rocket.a a2 = arra[n3];
                        a2.c += RocketFlyCircleView.this.i;
                        if (a2.c > (float)RocketFlyCircleView.d((RocketFlyCircleView)RocketFlyCircleView.this).d) {
                            int n5 = a2.d;
                            a2.c = n5 + (a2.e - n5) / 2;
                        }
                        ++n3;
                    }
                }
                RocketFlyCircleView.this.invalidate();
                if (RocketFlyCircleView.this.n) {
                    RocketFlyCircleView.this.H.postDelayed(RocketFlyCircleView.this.I, 10L);
                }
            }
        };
        RocketFlyCircleView.super.b();
    }

    public RocketFlyCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.G = new /* invalid duplicate definition of identical inner class */;
        this.H = new Handler();
        this.I = new /* invalid duplicate definition of identical inner class */;
        RocketFlyCircleView.super.b();
    }

    private void b() {
        this.e = new d();
        this.f = new Paint();
        this.f.setColor(-1);
        this.f.setStrokeWidth(3.0f);
        this.f.setStyle(Paint.Style.STROKE);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        this.o = BitmapFactory.decodeResource((Resources)this.getContext().getResources(), (int)2131231260, (BitmapFactory.Options)options).copy(Bitmap.Config.ARGB_8888, true);
        this.p = BitmapFactory.decodeResource((Resources)this.getContext().getResources(), (int)2131231261, (BitmapFactory.Options)options).copy(Bitmap.Config.ARGB_8888, true);
        this.B = new Matrix();
        this.C = new Path();
        this.J = new b(this.getContext());
        this.D = 0;
        this.a();
        this.M = new Paint();
        this.M.setTypeface(Typeface.create((Typeface)Typeface.DEFAULT, (int)1));
        this.M.setTextSize(TypedValue.applyDimension((int)2, (float)15.0f, (DisplayMetrics)this.getResources().getDisplayMetrics()));
        this.M.setARGB(204, 255, 255, 255);
        this.M.setAntiAlias(true);
        this.E = TypedValue.applyDimension((int)1, (float)3.0f, (DisplayMetrics)this.getResources().getDisplayMetrics());
        this.A = 1.0f;
        this.P = TypedValue.applyDimension((int)1, (float)0.66f, (DisplayMetrics)this.getResources().getDisplayMetrics());
        this.Q = TypedValue.applyDimension((int)1, (float)0.33f, (DisplayMetrics)this.getResources().getDisplayMetrics());
        this.setBackgroundResource(2131099949);
        this.S = TypedValue.applyDimension((int)1, (float)68.3f, (DisplayMetrics)this.getResources().getDisplayMetrics());
        this.T = TypedValue.applyDimension((int)1, (float)109.0f, (DisplayMetrics)this.getResources().getDisplayMetrics());
        this.U = TypedValue.applyDimension((int)1, (float)16.7f, (DisplayMetrics)this.getResources().getDisplayMetrics());
        this.V = TypedValue.applyDimension((int)1, (float)29.3f, (DisplayMetrics)this.getResources().getDisplayMetrics());
        this.W = this.p.getWidth() != 0 ? this.U / (float)this.p.getWidth() : 1.0f;
        if (this.p.getHeight() != 0) {
            this.aa = this.V / (float)this.p.getHeight();
            return;
        }
        this.aa = 1.0f;
    }

    static /* synthetic */ b d(RocketFlyCircleView rocketFlyCircleView) {
        return rocketFlyCircleView.J;
    }

    public final void a() {
        this.D += (int)TypedValue.applyDimension((int)1, (float)50.0f, (DisplayMetrics)this.getResources().getDisplayMetrics());
    }

    public int getRocketEntireHeight() {
        return (int)(this.T + this.V);
    }

    public Animator getRocketFlyAwayAnimation() {
        float f2 = this.b - this.c - (float)this.getRocketEntireHeight() - 10.0f;
        Property<RocketFlyCircleView, Float> property = this.G;
        float[] arrf = new float[]{this.r, f2};
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)((Object)this), property, (float[])arrf);
        objectAnimator.setDuration(200L);
        objectAnimator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

            public final void onAnimationEnd(Animator animator2) {
                RocketFlyCircleView.this.u = false;
            }

            public final void onAnimationStart(Animator animator2) {
                RocketFlyCircleView.this.u = true;
            }
        });
        return objectAnimator;
    }

    public Animator getRocketFlyInAnimation() {
        Property<RocketFlyCircleView, Float> property = this.G;
        float[] arrf = new float[]{this.b + this.c + (float)this.getRocketEntireHeight(), this.r};
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)((Object)this), property, (float[])arrf);
        objectAnimator.setDuration(300L);
        objectAnimator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

            public final void onAnimationEnd(Animator animator2) {
                RocketFlyCircleView.this.u = false;
            }

            public final void onAnimationStart(Animator animator2) {
                RocketFlyCircleView.this.u = true;
            }
        });
        return objectAnimator;
    }

    public float getRocketY() {
        return this.r;
    }

    protected void onDraw(Canvas canvas) {
        canvas.save();
        boolean bl = this.h;
        int n2 = 0;
        if (bl) {
            canvas.clipPath(this.C);
            for (c c2 : this.g) {
                this.f.setStrokeWidth((float)c2.c);
                this.f.setAlpha((int)(255.0f * c2.e));
                float f2 = c2.a();
                float f3 = c2.b();
                if (f2 > f3 || f3 < c2.f) continue;
                if (f2 < c2.f) {
                    f2 = c2.f;
                }
                float f4 = f2;
                canvas.drawLine(c2.a, f4, c2.a, f3, this.f);
            }
        }
        if (this.F) {
            com.xiaomi.midrop.view.rocket.a[] arra = this.K;
            int n3 = arra.length;
            while (n2 < n3) {
                com.xiaomi.midrop.view.rocket.a a2 = arra[n2];
                if (!(a2.c + (float)a2.a.getHeight() < 0.0f)) {
                    canvas.drawBitmap(a2.a, a2.b, a2.c, null);
                }
                ++n2;
            }
        }
        this.R.left = this.q + this.y;
        this.R.top = this.r + this.z;
        this.R.right = this.R.left + this.S;
        this.R.bottom = this.R.top + this.T;
        canvas.drawBitmap(this.o, null, this.R, null);
        float f5 = this.R.left + this.S / 2.0f - this.U / 2.0f;
        float f6 = this.R.top + this.T + this.E;
        this.B.reset();
        this.B.setTranslate(f5, f6);
        this.B.preScale(this.W, this.aa * this.A);
        canvas.drawBitmap(this.p, this.B, null);
        if (!TextUtils.isEmpty((CharSequence)this.L)) {
            if (this.N == 0.0f) {
                this.N = (float)(canvas.getWidth() / 2) - this.M.measureText(this.L) / 2.0f;
                this.O = f6 + this.V + TypedValue.applyDimension((int)1, (float)30.0f, (DisplayMetrics)this.getResources().getDisplayMetrics());
            }
            canvas.drawText(this.L, this.N, this.O, this.M);
        }
        canvas.restore();
    }

    protected void onSizeChanged(int n2, int n3, int n4, int n5) {
        float f2;
        this.d = 5.0f;
        this.a = f2 = (float)(n2 / 2);
        this.b = n3 / 2;
        this.c = f2 - this.d;
        d d2 = this.e;
        float f3 = this.a;
        float f4 = this.b;
        float f5 = this.c;
        d2.a = f3;
        d2.b = f4;
        d2.c = f5;
        d2.d = f5 / 2.0f;
        d d3 = this.e;
        c[] arrc = new c[20];
        float f6 = 0.0f;
        for (int i2 = 0; i2 < 20; ++i2) {
            float f7 = 9.0f + f6;
            c c2 = new c();
            c2.h = f6;
            c2.i = f7;
            d3.a(c2);
            arrc[i2] = c2;
            if (i2 % 2 == 0) {
                arrc[i2].j = d3.c;
            }
            f6 = f7;
        }
        this.g = arrc;
        this.q = this.a - this.S / 2.0f;
        this.r = this.b - this.T / 2.0f;
        this.s = this.q;
        this.t = this.r;
        this.C.reset();
        this.C.addCircle(this.a, this.b, this.c, Path.Direction.CW);
        b b2 = this.J;
        b2.a = 0;
        b2.b = 0;
        b2.c = n2;
        b2.d = n3;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        b2.e = new b.a[6];
        b2.e[0] = new b.a(0);
        b2.e[0].a = BitmapFactory.decodeResource((Resources)b2.f.getResources(), (int)2131230907, (BitmapFactory.Options)options);
        b2.e[0].b = 0;
        b2.e[1] = new b.a(0);
        b2.e[1].a = BitmapFactory.decodeResource((Resources)b2.f.getResources(), (int)2131230910, (BitmapFactory.Options)options);
        b2.e[1].b = n2 - b2.e[1].a.getWidth();
        b2.e[2] = new b.a(0);
        b2.e[2].a = BitmapFactory.decodeResource((Resources)b2.f.getResources(), (int)2131230908, (BitmapFactory.Options)options);
        b2.e[2].b = 0;
        b2.e[3] = new b.a(0);
        b2.e[3].a = BitmapFactory.decodeResource((Resources)b2.f.getResources(), (int)2131230911, (BitmapFactory.Options)options);
        b2.e[3].b = n2 - b2.e[2].a.getWidth();
        b2.e[4] = new b.a(0);
        b2.e[4].a = BitmapFactory.decodeResource((Resources)b2.f.getResources(), (int)2131230909, (BitmapFactory.Options)options);
        b2.e[4].b = 0;
        b2.e[5] = new b.a(0);
        b2.e[5].a = BitmapFactory.decodeResource((Resources)b2.f.getResources(), (int)2131230910, (BitmapFactory.Options)options);
        b2.e[5].b = n2 - b2.e[5].a.getWidth();
        this.K = this.J.a();
        this.O = 0.0f;
        this.N = 0.0f;
    }

    public void setAnimationDuration(int n2) {
        this.j = n2;
    }

    public void setAnimationListener(a a2) {
        this.w = a2;
    }

    public void setCenterText(String string2) {
        this.L = string2;
    }

    public void setRocketY(float f2) {
        this.r = f2;
        this.invalidate();
    }

    public void setShowClouds(boolean bl) {
        this.F = bl;
    }

    public void setShowLines(boolean bl) {
        this.h = bl;
    }

    public static interface a {
    }

}

