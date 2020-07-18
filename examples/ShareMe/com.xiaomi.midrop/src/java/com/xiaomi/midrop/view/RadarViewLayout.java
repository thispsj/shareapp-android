/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.animation.OvershootInterpolator
 *  android.widget.ImageView
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map$Entry
 *  java.util.Random
 *  java.util.Set
 *  midrop.service.c.d
 */
package com.xiaomi.midrop.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import com.xiaomi.midrop.sender.c.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import midrop.service.c.d;

public class RadarViewLayout
extends ViewGroup {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private HashMap<Object, Rect> g = new HashMap();
    private List<Rect> h = new ArrayList(8);
    private List<Rect> i = new ArrayList();
    private Rect j = new Rect();
    private int k;
    private int l;
    private int m;
    private Rect n = new Rect();
    private int o;
    private Random p;
    private int q;

    public RadarViewLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = this.getResources().getDimensionPixelSize(2131165618);
        this.m = this.getResources().getDimensionPixelSize(2131165617);
        this.o = this.getResources().getDimensionPixelSize(2131165614);
        this.p = new Random();
        this.d = this.getResources().getDimensionPixelSize(2131165619);
        this.q = (int)(360.0 * Math.random());
    }

    private int a(View view, int n2, int n3) {
        int n4 = view.getMeasuredWidth();
        int n5 = view.getMeasuredHeight();
        int n6 = this.l;
        int n7 = this.q;
        double d2 = this.q;
        do {
            Point point = RadarViewLayout.super.a(d2, n2);
            Rect rect = this.j;
            int n8 = point.x;
            int n9 = n4 / 2;
            int n10 = n8 - n9;
            int n11 = point.y;
            int n12 = n6 / 2;
            rect.set(n10, n11 - n12, n9 + point.x, n5 + point.y - n12);
            if (RadarViewLayout.super.a(this.j)) {
                if (n3 >= this.h.size()) {
                    this.h.add((Object)new Rect(this.j));
                } else {
                    ((Rect)this.h.get(n3)).set(this.j);
                }
                ++n3;
            }
            if ((n7 += 5) - this.q >= 360) break;
            d2 = n7;
        } while (true);
        return n3;
    }

    private Point a(double d2, int n2) {
        double d3 = n2;
        return new Point((int)(d3 * Math.cos((double)Math.toRadians((double)d2)) + (double)this.a), (int)(d3 * Math.sin((double)Math.toRadians((double)d2)) + (double)this.b));
    }

    private Rect a(int n2) {
        if (n2 > 0) {
            if (n2 >= 4 && this.g.size() < 10) {
                int n3 = RadarViewLayout.super.getProperQuadrant();
                this.i.clear();
                block6 : for (int i2 = 0; i2 < n2 && i2 < this.h.size(); ++i2) {
                    Rect rect = (Rect)this.h.get(i2);
                    switch (n3) {
                        default: {
                            continue block6;
                        }
                        case 4: {
                            if (!RadarViewLayout.super.e(rect)) continue block6;
                            break;
                        }
                        case 3: {
                            if (!RadarViewLayout.super.d(rect)) continue block6;
                            break;
                        }
                        case 2: {
                            if (!RadarViewLayout.super.c(rect)) continue block6;
                            break;
                        }
                        case 1: {
                            if (!RadarViewLayout.super.b(rect)) continue block6;
                        }
                    }
                    this.i.add((Object)rect);
                }
                List<Rect> list = this.i;
                if (!list.isEmpty()) {
                    return (Rect)list.get(Math.round((float)((float)(Math.random() * (double)(-1 + list.size())))));
                }
                int n4 = Math.round((float)((float)(Math.random() * (double)(n2 - 1))));
                return (Rect)this.h.get(n4);
            }
            int n5 = Math.round((float)((float)(Math.random() * (double)(n2 - 1))));
            return (Rect)this.h.get(n5);
        }
        d.b((String)"RadarViewLayout", (String)"Avatar items are too many! ", (Object[])new Object[0]);
        return new Rect();
    }

    private Rect a(View view) {
        int n2 = this.e;
        int n3 = RadarViewLayout.super.a(view, n2, 0);
        int n4 = RadarViewLayout.super.a(view, this.c, n3);
        Rect rect = RadarViewLayout.super.a(RadarViewLayout.super.a(view, this.d, n4));
        if (rect.isEmpty()) {
            int n5 = view.getMeasuredWidth();
            int n6 = view.getMeasuredHeight();
            int n7 = n6 + 0;
            int n8 = this.a + this.c;
            int n9 = 0;
            for (int i2 = 0; i2 < 3; ++i2) {
                int n10 = RadarViewLayout.super.getRandomPadding();
                int n11 = RadarViewLayout.super.getRandomPadding();
                do {
                    int n12;
                    int n13;
                    if (n10 + n5 > n8) {
                        n10 = RadarViewLayout.super.getRandomPadding();
                        n11 += n7;
                    }
                    if ((n13 = n10 + n5) > n8 || (n12 = n11 + n6) > this.b + this.c) break;
                    this.j.set(n10, n11, n13, n12);
                    if (RadarViewLayout.super.a(this.j)) {
                        if (n9 >= this.h.size()) {
                            this.h.add((Object)new Rect(this.j));
                        } else {
                            ((Rect)this.h.get(n9)).set(this.j);
                        }
                        ++n9;
                    }
                    n10 += n5 + 0;
                } while (true);
                if (n9 > 0) break;
            }
            rect = RadarViewLayout.super.a(n9);
        }
        return rect;
    }

    static /* synthetic */ void a(RadarViewLayout radarViewLayout, View view) {
        radarViewLayout.g.remove((Object)view);
        super.removeView(view);
    }

    private boolean a(Rect rect) {
        if (rect.isEmpty()) {
            return false;
        }
        if (rect.left >= this.a - this.c && rect.top >= this.b - this.c && rect.right <= this.a + this.c) {
            if (rect.bottom > this.b + this.c) {
                return false;
            }
            if (Rect.intersects((Rect)this.n, (Rect)rect)) {
                return false;
            }
            for (Map.Entry entry : this.g.entrySet()) {
                if (entry.getValue() == rect || ((Rect)entry.getValue()).isEmpty() || !Rect.intersects((Rect)((Rect)entry.getValue()), (Rect)rect)) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean b(Rect rect) {
        return rect.right < this.a && rect.bottom < this.b;
    }

    private boolean c(Rect rect) {
        return rect.left > this.a && rect.bottom < this.b;
    }

    private boolean d(Rect rect) {
        return rect.right < this.a && rect.top > this.b;
    }

    private boolean e(Rect rect) {
        return rect.left > this.a && rect.top > this.b;
    }

    /*
     * Enabled aggressive block sorting
     */
    private int getProperQuadrant() {
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)1);
        arrayList.add((Object)2);
        arrayList.add((Object)3);
        arrayList.add((Object)4);
        Collections.shuffle((List)arrayList);
        for (Map.Entry entry : this.g.entrySet()) {
            block9 : {
                Integer n2;
                block6 : {
                    Rect rect;
                    block8 : {
                        block7 : {
                            block5 : {
                                if (((Rect)entry.getValue()).isEmpty()) continue;
                                rect = (Rect)entry.getValue();
                                if (!this.b(rect)) break block5;
                                n2 = 1;
                                break block6;
                            }
                            if (!this.c(rect)) break block7;
                            n2 = 2;
                            break block6;
                        }
                        if (!this.d(rect)) break block8;
                        n2 = 3;
                        break block6;
                    }
                    if (!this.e(rect)) break block9;
                    n2 = 4;
                }
                arrayList.remove((Object)n2);
            }
            if (!arrayList.isEmpty()) continue;
        }
        if (arrayList.isEmpty()) {
            return 1 + this.p.nextInt(4);
        }
        return (Integer)arrayList.get(0);
    }

    private int getRandomPadding() {
        return (int)(Math.random() * (double)c.a(this.getContext(), 10.0f));
    }

    public void addView(final View view) {
        this.g.remove((Object)view);
        this.g.put((Object)view, (Object)new Rect());
        this.k = this.l;
        int n2 = this.g.size();
        float f2 = n2 <= 6 ? 1.0f : (n2 <= 12 ? 0.8f : 0.5f);
        this.l = (int)(f2 * (float)this.getResources().getDimensionPixelSize(2131165618));
        super.addView(view);
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(250L);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        valueAnimator.setInterpolator((TimeInterpolator)new OvershootInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f2 = ((Float)valueAnimator.getAnimatedValue()).floatValue();
                float f3 = 0.4f + 0.6f * f2;
                view.setAlpha(f2);
                view.setScaleX(f3);
                view.setScaleY(f3);
            }
        });
        valueAnimator.start();
    }

    protected void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        int n6 = this.getChildCount();
        int n7 = this.getWidth() / 2;
        int n8 = this.getHeight() / 2;
        for (int i2 = 0; i2 < n6; ++i2) {
            View view;
            Rect rect;
            block17 : {
                block16 : {
                    boolean bl2;
                    view = this.getChildAt(i2);
                    ImageView imageView = (ImageView)view.findViewById(2131296418);
                    int n9 = imageView.getWidth() / 2;
                    if (imageView.getWidth() != this.l) {
                        Bitmap bitmap;
                        BitmapDrawable bitmapDrawable;
                        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                        layoutParams.width = this.l;
                        layoutParams.height = this.l;
                        imageView.setLayoutParams(layoutParams);
                        int n10 = this.l;
                        int n11 = this.l;
                        Drawable drawable2 = imageView.getDrawable();
                        if (drawable2 instanceof BitmapDrawable && (bitmapDrawable = (BitmapDrawable)drawable2).getBitmap() != null) {
                            bitmap = bitmapDrawable.getBitmap();
                        } else {
                            int n12;
                            int n13;
                            if (drawable2.getIntrinsicWidth() > 0 && drawable2.getIntrinsicHeight() > 0) {
                                n13 = drawable2.getIntrinsicWidth();
                                n12 = drawable2.getIntrinsicHeight();
                            } else {
                                n13 = this.k;
                                n12 = this.k;
                            }
                            Bitmap bitmap2 = Bitmap.createBitmap((int)n13, (int)n12, (Bitmap.Config)Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(bitmap2);
                            drawable2.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                            drawable2.draw(canvas);
                            bitmap = bitmap2;
                        }
                        if (bitmap != null) {
                            int n14 = bitmap.getWidth();
                            int n15 = bitmap.getHeight();
                            if (n14 != 0 && n15 != 0) {
                                float f2 = (float)n10 / (float)n14;
                                float f3 = (float)n11 / (float)n15;
                                if (!(f2 <= f3)) {
                                    f2 = f3;
                                }
                                Matrix matrix = new Matrix();
                                matrix.postScale(f2, f2);
                                Bitmap bitmap3 = Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)n14, (int)n15, (Matrix)matrix, (boolean)true);
                                int n16 = bitmap3.getWidth();
                                int n17 = bitmap3.getHeight();
                                imageView.setImageDrawable((Drawable)new BitmapDrawable(bitmap3));
                                ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                                layoutParams2.width = n16;
                                layoutParams2.height = n17;
                                imageView.setLayoutParams(layoutParams2);
                            }
                        }
                        bl2 = true;
                    } else {
                        bl2 = false;
                    }
                    rect = (Rect)this.g.get((Object)view);
                    if (rect == null) continue;
                    view.measure(View.MeasureSpec.makeMeasureSpec((int)n7, (int)Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec((int)n8, (int)Integer.MIN_VALUE));
                    if (rect.isEmpty()) break block16;
                    if (bl2) {
                        int n18 = n9 + imageView.getLeft();
                        int n19 = n9 + imageView.getTop();
                        rect.set(n18 - view.getMeasuredWidth() / 2, n19 - view.getMeasuredHeight() / 2, n18 + view.getMeasuredWidth() / 2, n19 + view.getMeasuredHeight() / 2);
                    } else {
                        rect.set(rect.left, rect.top, rect.left + view.getMeasuredWidth(), rect.top + view.getMeasuredHeight());
                    }
                    if (this.a(rect)) break block17;
                }
                rect.set(this.a(view));
            }
            if (this.a(rect)) {
                view.layout(rect.left, rect.top, rect.right, rect.bottom);
                continue;
            }
            view.layout(0, 0, 0, 0);
        }
    }

    protected void onSizeChanged(int n2, int n3, int n4, int n5) {
        int n6;
        this.f = 5;
        this.a = n6 = n2 / 2;
        this.b = n3 / 2;
        this.c = n6 - this.f;
        int n7 = this.o / 2;
        this.n.set(this.a - n7, this.b - n7, n7 + this.a, n7 + this.b);
        this.e = this.d + (this.c - this.d) / 2;
    }

    public void removeView(final View view) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(200L);
        valueAnimator.setFloatValues(new float[]{1.0f, 0.0f});
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f2 = ((Float)valueAnimator.getAnimatedValue()).floatValue();
                float f3 = 0.4f + 0.6f * f2;
                view.setAlpha(f2);
                view.setScaleX(f3);
                view.setScaleY(f3);
            }
        });
        valueAnimator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

            public final void onAnimationEnd(Animator animator) {
                RadarViewLayout.a(RadarViewLayout.this, view);
            }
        });
        valueAnimator.start();
    }

}

