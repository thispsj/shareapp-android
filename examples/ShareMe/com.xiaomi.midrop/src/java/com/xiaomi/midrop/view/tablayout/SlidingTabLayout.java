/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Path
 *  android.graphics.Rect
 *  android.graphics.drawable.GradientDrawable
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.support.v4.view.ViewPager
 *  android.support.v4.view.ViewPager$e
 *  android.support.v4.view.n
 *  android.text.TextPaint
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.HorizontalScrollView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.xiaomi.midrop.view.tablayout;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.n;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.midrop.R;
import com.xiaomi.midrop.view.tablayout.SlidingTabLayout;
import com.xiaomi.midrop.view.tablayout.a.b;
import java.util.ArrayList;

public class SlidingTabLayout
extends HorizontalScrollView
implements ViewPager.e {
    private int A;
    private boolean B;
    private int C;
    private float D;
    private int E;
    private int F;
    private float G;
    private float H;
    private float I;
    private int J;
    private int K;
    private int L;
    private boolean M;
    private int N;
    private int O;
    private boolean P;
    private float Q;
    private Paint R;
    private SparseArray<Boolean> S;
    private b T;
    private Context a;
    private ViewPager b;
    private ArrayList<String> c;
    private LinearLayout d;
    private int e;
    private float f;
    private int g;
    private Rect h;
    private Rect i;
    private GradientDrawable j;
    private Paint k;
    private Paint l;
    private Paint m;
    private Path n;
    private int o;
    private float p;
    private boolean q;
    private float r;
    private int s;
    private float t;
    private float u;
    private float v;
    private float w;
    private float x;
    private float y;
    private float z;

    public SlidingTabLayout(Context context) {
        super(context, null, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int n2) {
        float f2;
        super(context, attributeSet, n2);
        this.h = new Rect();
        this.i = new Rect();
        this.j = new GradientDrawable();
        this.k = new Paint(1);
        this.l = new Paint(1);
        this.m = new Paint(1);
        this.n = new Path();
        this.o = 0;
        this.R = new Paint(1);
        this.S = new SparseArray();
        this.setFillViewport(true);
        this.setWillNotDraw(false);
        this.setClipChildren(false);
        this.setClipToPadding(false);
        this.a = context;
        this.d = new LinearLayout(context);
        this.d.setLayoutDirection(0);
        this.addView((View)this.d);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.SlidingTabLayout);
        this.o = typedArray.getInt(11, 0);
        String string2 = this.o == 2 ? "#4B6A87" : "#ffffff";
        this.s = typedArray.getColor(3, Color.parseColor((String)string2));
        if (this.o == 1) {
            f2 = 4.0f;
        } else {
            int n3 = this.o == 2 ? -1 : 2;
            f2 = n3;
        }
        this.t = typedArray.getDimension(6, (float)SlidingTabLayout.super.a(f2));
        float f3 = this.o == 1 ? 10.0f : -1.0f;
        this.u = typedArray.getDimension(12, (float)SlidingTabLayout.super.a(f3));
        float f4 = this.o == 2 ? -1.0f : 0.0f;
        this.v = typedArray.getDimension(4, (float)SlidingTabLayout.super.a(f4));
        this.w = typedArray.getDimension(8, (float)SlidingTabLayout.super.a(0.0f));
        int n4 = this.o;
        float f5 = 7.0f;
        float f6 = n4 == 2 ? 7.0f : 0.0f;
        this.x = typedArray.getDimension(10, (float)SlidingTabLayout.super.a(f6));
        this.y = typedArray.getDimension(9, (float)SlidingTabLayout.super.a(0.0f));
        if (this.o != 2) {
            f5 = 0.0f;
        }
        this.z = typedArray.getDimension(7, (float)SlidingTabLayout.super.a(f5));
        this.A = typedArray.getInt(5, 80);
        this.B = typedArray.getBoolean(13, false);
        this.C = typedArray.getColor(22, Color.parseColor((String)"#ffffff"));
        this.D = typedArray.getDimension(24, (float)SlidingTabLayout.super.a(0.0f));
        this.E = typedArray.getInt(23, 80);
        this.F = typedArray.getColor(0, Color.parseColor((String)"#ffffff"));
        this.G = typedArray.getDimension(2, (float)SlidingTabLayout.super.a(0.0f));
        this.H = typedArray.getDimension(1, (float)SlidingTabLayout.super.a(12.0f));
        this.I = typedArray.getDimension(21, (float)SlidingTabLayout.super.b(14.0f));
        this.J = typedArray.getColor(19, Color.parseColor((String)"#ffffff"));
        this.K = typedArray.getColor(20, Color.parseColor((String)"#AAffffff"));
        this.L = typedArray.getInt(18, 0);
        this.M = typedArray.getBoolean(17, false);
        this.q = typedArray.getBoolean(15, false);
        this.r = typedArray.getDimension(16, (float)SlidingTabLayout.super.a(-1.0f));
        int n5 = !this.q && !(this.r > 0.0f) ? SlidingTabLayout.super.a(20.0f) : SlidingTabLayout.super.a(0.0f);
        this.p = typedArray.getDimension(14, (float)n5);
        typedArray.recycle();
        String string3 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (!string3.equals((Object)"-1") && !string3.equals((Object)"-2")) {
            TypedArray typedArray2 = context.obtainStyledAttributes(attributeSet, new int[]{16842997});
            this.O = typedArray2.getDimensionPixelSize(0, -2);
            typedArray2.recycle();
        }
    }

    private int a(float f2) {
        return (int)(0.5f + f2 * this.a.getResources().getDisplayMetrics().density);
    }

    static /* synthetic */ LinearLayout a(SlidingTabLayout slidingTabLayout) {
        return slidingTabLayout.d;
    }

    private void a() {
        this.d.removeAllViews();
        int n2 = this.c == null ? this.b.getAdapter().c() : this.c.size();
        this.g = n2;
        for (int i2 = 0; i2 < this.g; ++i2) {
            View view = View.inflate((Context)this.a, (int)2131427494, null);
            CharSequence charSequence = this.c == null ? this.b.getAdapter().b(i2) : (CharSequence)this.c.get(i2);
            String string2 = charSequence.toString();
            TextView textView = (TextView)view.findViewById(2131296870);
            if (textView != null && string2 != null) {
                textView.setText((CharSequence)string2);
            }
            view.setOnClickListener(new View.OnClickListener(this){
                final /* synthetic */ SlidingTabLayout a;
                {
                    this.a = slidingTabLayout;
                }

                public void onClick(View view) {
                    int n2 = SlidingTabLayout.a(this.a).indexOfChild(view);
                    if (n2 != -1 && SlidingTabLayout.b(this.a).getCurrentItem() != n2) {
                        if (SlidingTabLayout.c(this.a)) {
                            SlidingTabLayout.b(this.a).a(n2, false);
                        } else {
                            SlidingTabLayout.b(this.a).setCurrentItem(n2);
                        }
                        if (SlidingTabLayout.d(this.a) != null) {
                            SlidingTabLayout.d(this.a).a(n2);
                        }
                    }
                }
            });
            LinearLayout.LayoutParams layoutParams = this.q ? new LinearLayout.LayoutParams(0, -1, 1.0f) : new LinearLayout.LayoutParams(-2, -1);
            if (this.r > 0.0f) {
                layoutParams = new LinearLayout.LayoutParams((int)this.r, -1);
            }
            view.setLayoutDirection(2);
            this.d.addView(view, i2, (ViewGroup.LayoutParams)layoutParams);
        }
        this.b();
    }

    private int b(float f2) {
        return (int)(0.5f + f2 * this.a.getResources().getDisplayMetrics().scaledDensity);
    }

    static /* synthetic */ ViewPager b(SlidingTabLayout slidingTabLayout) {
        return slidingTabLayout.b;
    }

    private void b() {
        for (int i2 = 0; i2 < this.g; ++i2) {
            TextView textView = (TextView)this.d.getChildAt(i2).findViewById(2131296870);
            if (textView == null) continue;
            int n2 = i2 == this.e ? this.J : this.K;
            textView.setTextColor(n2);
            textView.setTextSize(0, this.I);
            textView.setPadding((int)this.p, 0, (int)this.p, 0);
            if (this.M) {
                textView.setText((CharSequence)textView.getText().toString().toUpperCase());
            }
            if (this.L == 2) {
                textView.getPaint().setFakeBoldText(true);
                continue;
            }
            if (this.L != 0) continue;
            textView.getPaint().setFakeBoldText(false);
        }
    }

    private void b(int n2) {
        for (int i2 = 0; i2 < this.g; ++i2) {
            View view = this.d.getChildAt(i2);
            boolean bl = i2 == n2;
            TextView textView = (TextView)view.findViewById(2131296870);
            if (textView == null) continue;
            int n3 = bl ? this.J : this.K;
            textView.setTextColor(n3);
            if (this.L != 1) continue;
            textView.getPaint().setFakeBoldText(bl);
        }
    }

    private void c() {
        if (this.g <= 0) {
            return;
        }
        int n2 = (int)(this.f * (float)this.d.getChildAt(this.e).getWidth());
        int n3 = n2 + this.d.getChildAt(this.e).getLeft();
        if (this.e > 0 || n2 > 0) {
            int n4 = n3 - (this.getWidth() / 2 - this.getPaddingLeft());
            this.d();
            n3 = n4 + (this.i.right - this.i.left) / 2;
        }
        if (n3 != this.N) {
            this.N = n3;
            this.scrollTo(n3, 0);
        }
    }

    static /* synthetic */ boolean c(SlidingTabLayout slidingTabLayout) {
        return slidingTabLayout.P;
    }

    static /* synthetic */ b d(SlidingTabLayout slidingTabLayout) {
        return slidingTabLayout.T;
    }

    private void d() {
        int n2;
        int n3;
        View view = this.d.getChildAt(this.e);
        float f2 = view.getLeft();
        float f3 = view.getRight();
        if (this.o == 0 && this.B) {
            TextView textView = (TextView)view.findViewById(2131296870);
            this.R.setTextSize(this.I);
            float f4 = this.R.measureText(textView.getText().toString());
            this.Q = (f3 - f2 - f4) / 2.0f;
        }
        if (this.e < -1 + this.g) {
            View view2 = this.d.getChildAt(1 + this.e);
            float f5 = view2.getLeft();
            float f6 = view2.getRight();
            f2 += this.f * (f5 - f2);
            f3 += this.f * (f6 - f3);
            if (this.o == 0 && this.B) {
                TextView textView = (TextView)view2.findViewById(2131296870);
                this.R.setTextSize(this.I);
                float f7 = this.R.measureText(textView.getText().toString());
                float f8 = (f6 - f5 - f7) / 2.0f;
                this.Q += this.f * (f8 - this.Q);
            }
        }
        Rect rect = this.h;
        rect.left = n3 = (int)f2;
        Rect rect2 = this.h;
        rect2.right = n2 = (int)f3;
        if (this.o == 0 && this.B) {
            this.h.left = (int)(f2 + this.Q - 1.0f);
            this.h.right = (int)(f3 - this.Q - 1.0f);
        }
        this.i.left = n3;
        this.i.right = n2;
        if (!(this.u < 0.0f)) {
            float f9 = (float)view.getLeft() + ((float)view.getWidth() - this.u) / 2.0f;
            if (this.e < -1 + this.g) {
                View view3 = this.d.getChildAt(1 + this.e);
                f9 += this.f * (float)(view.getWidth() / 2 + view3.getWidth() / 2);
            }
            this.h.left = (int)f9;
            this.h.right = (int)((float)this.h.left + this.u);
        }
    }

    public final void a(int n2) {
        SlidingTabLayout.super.b(n2);
    }

    public final void a(int n2, float f2) {
        this.e = n2;
        this.f = f2;
        SlidingTabLayout.super.c();
        this.invalidate();
    }

    public int getCurrentTab() {
        return this.e;
    }

    public int getDividerColor() {
        return this.F;
    }

    public float getDividerPadding() {
        return this.H;
    }

    public float getDividerWidth() {
        return this.G;
    }

    public int getIndicatorColor() {
        return this.s;
    }

    public float getIndicatorCornerRadius() {
        return this.v;
    }

    public float getIndicatorHeight() {
        return this.t;
    }

    public float getIndicatorMarginBottom() {
        return this.z;
    }

    public float getIndicatorMarginLeft() {
        return this.w;
    }

    public float getIndicatorMarginRight() {
        return this.y;
    }

    public float getIndicatorMarginTop() {
        return this.x;
    }

    public int getIndicatorStyle() {
        return this.o;
    }

    public float getIndicatorWidth() {
        return this.u;
    }

    public int getTabCount() {
        return this.g;
    }

    public float getTabPadding() {
        return this.p;
    }

    public float getTabWidth() {
        return this.r;
    }

    public int getTextBold() {
        return this.L;
    }

    public int getTextSelectColor() {
        return this.J;
    }

    public int getTextUnselectColor() {
        return this.K;
    }

    public float getTextsize() {
        return this.I;
    }

    public int getUnderlineColor() {
        return this.C;
    }

    public float getUnderlineHeight() {
        return this.D;
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.isInEditMode()) return;
        if (this.g <= 0) {
            return;
        }
        int n2 = this.getHeight();
        int n3 = this.getPaddingStart();
        if (this.G > 0.0f) {
            this.l.setStrokeWidth(this.G);
            this.l.setColor(this.F);
            for (int i2 = 0; i2 < this.g - 1; ++i2) {
                View view = this.d.getChildAt(i2);
                canvas.drawLine((float)(n3 + view.getRight()), this.H, (float)(n3 + view.getRight()), (float)n2 - this.H, this.l);
            }
        }
        if (this.D > 0.0f) {
            float f2;
            float f3;
            float f4;
            float f5;
            this.k.setColor(this.C);
            if (this.E == 80) {
                f5 = n3;
                f4 = n2;
                f3 = f4 - this.D;
                f2 = n3 + this.d.getWidth();
            } else {
                f5 = n3;
                f2 = n3 + this.d.getWidth();
                f4 = this.D;
                f3 = 0.0f;
            }
            canvas.drawRect(f5, f3, f2, f4, this.k);
        }
        SlidingTabLayout.super.d();
        if (this.o == 1) {
            if (!(this.t > 0.0f)) return;
            {
                this.m.setColor(this.s);
                this.n.reset();
                Path path = this.n;
                float f6 = n3 + this.h.left;
                float f7 = n2;
                path.moveTo(f6, f7);
                this.n.lineTo((float)(n3 + this.h.left / 2 + this.h.right / 2), f7 - this.t);
                this.n.lineTo((float)(n3 + this.h.right), f7);
                this.n.close();
                canvas.drawPath(this.n, this.m);
                return;
            }
        }
        if (this.o == 2) {
            if (this.t < 0.0f) {
                this.t = (float)n2 - this.x - this.z;
            }
            if (!(this.t > 0.0f)) return;
            if (this.v < 0.0f || this.v > this.t / 2.0f) {
                this.v = this.t / 2.0f;
            }
            this.j.setColor(this.s);
            this.j.setBounds(n3 + (int)this.w + this.h.left, (int)this.x, (int)((float)(n3 + this.h.right) - this.y), (int)(this.x + this.t));
        } else {
            if (!(this.t > 0.0f)) return;
            this.j.setColor(this.s);
            if (this.A == 80) {
                this.j.setBounds(n3 + (int)this.w + this.h.left, n2 - (int)this.t - (int)this.z, n3 + this.h.right - (int)this.y, n2 - (int)this.z);
            } else {
                this.j.setBounds(n3 + (int)this.w + this.h.left, (int)this.x, n3 + this.h.right - (int)this.y, (int)this.t + (int)this.x);
            }
        }
        this.j.setCornerRadius(this.v);
        this.j.draw(canvas);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle)parcelable;
            this.e = bundle.getInt("mCurrentTab");
            parcelable = bundle.getParcelable("instanceState");
            if (this.e != 0 && this.d.getChildCount() > 0) {
                SlidingTabLayout.super.b(this.e);
                SlidingTabLayout.super.c();
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mCurrentTab", this.e);
        return bundle;
    }

    public void setCurrentTab(int n2) {
        this.e = n2;
        this.b.setCurrentItem(n2);
    }

    public void setDividerColor(int n2) {
        this.F = n2;
        this.invalidate();
    }

    public void setDividerPadding(float f2) {
        this.H = SlidingTabLayout.super.a(f2);
        this.invalidate();
    }

    public void setDividerWidth(float f2) {
        this.G = SlidingTabLayout.super.a(f2);
        this.invalidate();
    }

    public void setIndicatorColor(int n2) {
        this.s = n2;
        this.invalidate();
    }

    public void setIndicatorCornerRadius(float f2) {
        this.v = SlidingTabLayout.super.a(f2);
        this.invalidate();
    }

    public void setIndicatorGravity(int n2) {
        this.A = n2;
        this.invalidate();
    }

    public void setIndicatorHeight(float f2) {
        this.t = SlidingTabLayout.super.a(f2);
        this.invalidate();
    }

    public void setIndicatorStyle(int n2) {
        this.o = n2;
        this.invalidate();
    }

    public void setIndicatorWidth(float f2) {
        this.u = SlidingTabLayout.super.a(f2);
        this.invalidate();
    }

    public void setIndicatorWidthEqualTitle(boolean bl) {
        this.B = bl;
        this.invalidate();
    }

    public void setOnTabSelectListener(b b2) {
        this.T = b2;
    }

    public void setSnapOnTabClick(boolean bl) {
        this.P = bl;
    }

    public void setTabPadding(float f2) {
        this.p = SlidingTabLayout.super.a(f2);
        SlidingTabLayout.super.b();
    }

    public void setTabSpaceEqual(boolean bl) {
        this.q = bl;
        SlidingTabLayout.super.b();
    }

    public void setTabWidth(float f2) {
        this.r = SlidingTabLayout.super.a(f2);
        SlidingTabLayout.super.b();
    }

    public void setTextAllCaps(boolean bl) {
        this.M = bl;
        SlidingTabLayout.super.b();
    }

    public void setTextBold(int n2) {
        this.L = n2;
        SlidingTabLayout.super.b();
    }

    public void setTextSelectColor(int n2) {
        this.J = n2;
        SlidingTabLayout.super.b();
    }

    public void setTextUnselectColor(int n2) {
        this.K = n2;
        SlidingTabLayout.super.b();
    }

    public void setTextsize(float f2) {
        this.I = SlidingTabLayout.super.b(f2);
        SlidingTabLayout.super.b();
    }

    public void setUnderlineColor(int n2) {
        this.C = n2;
        this.invalidate();
    }

    public void setUnderlineGravity(int n2) {
        this.E = n2;
        this.invalidate();
    }

    public void setUnderlineHeight(float f2) {
        this.D = SlidingTabLayout.super.a(f2);
        this.invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        if (viewPager != null && viewPager.getAdapter() != null) {
            this.b = viewPager;
            this.b.b((ViewPager.e)this);
            this.b.a((ViewPager.e)this);
            SlidingTabLayout.super.a();
            return;
        }
        throw new IllegalStateException("ViewPager or ViewPager adapter can not be NULL !");
    }
}

