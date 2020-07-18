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
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.midrop.R;
import com.xiaomi.midrop.view.tablayout.CommonSlidingTabLayout;
import com.xiaomi.midrop.view.tablayout.a.a;
import com.xiaomi.midrop.view.tablayout.a.b;
import com.xiaomi.midrop.view.tablayout.widget.MsgView;
import java.util.ArrayList;
import java.util.Collection;

public class CommonSlidingTabLayout
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
    private ArrayList<a> Q;
    private float R;
    private Paint S;
    private SparseArray<Boolean> T;
    private b U;
    public LinearLayout a;
    public int b;
    private Context c;
    private ViewPager d;
    private ArrayList<String> e;
    private int f;
    private float g;
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

    public CommonSlidingTabLayout(Context context) {
        super(context, null, 0);
    }

    public CommonSlidingTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public CommonSlidingTabLayout(Context context, AttributeSet attributeSet, int n2) {
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
        this.Q = new ArrayList();
        this.S = new Paint(1);
        this.T = new SparseArray();
        this.setFillViewport(true);
        this.setWillNotDraw(false);
        this.setClipChildren(false);
        this.setClipToPadding(false);
        this.c = context;
        this.a = new LinearLayout(context);
        this.a.setLayoutDirection(0);
        this.addView((View)this.a);
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
        this.t = typedArray.getDimension(6, (float)CommonSlidingTabLayout.super.a(f2));
        float f3 = this.o == 1 ? 10.0f : -1.0f;
        this.u = typedArray.getDimension(12, (float)CommonSlidingTabLayout.super.a(f3));
        float f4 = this.o == 2 ? -1.0f : 0.0f;
        this.v = typedArray.getDimension(4, (float)CommonSlidingTabLayout.super.a(f4));
        this.w = typedArray.getDimension(8, (float)CommonSlidingTabLayout.super.a(0.0f));
        int n4 = this.o;
        float f5 = 7.0f;
        float f6 = n4 == 2 ? 7.0f : 0.0f;
        this.x = typedArray.getDimension(10, (float)CommonSlidingTabLayout.super.a(f6));
        this.y = typedArray.getDimension(9, (float)CommonSlidingTabLayout.super.a(0.0f));
        if (this.o != 2) {
            f5 = 0.0f;
        }
        this.z = typedArray.getDimension(7, (float)CommonSlidingTabLayout.super.a(f5));
        this.A = typedArray.getInt(5, 80);
        this.B = typedArray.getBoolean(13, false);
        this.C = typedArray.getColor(22, Color.parseColor((String)"#ffffff"));
        this.D = typedArray.getDimension(24, (float)CommonSlidingTabLayout.super.a(0.0f));
        this.E = typedArray.getInt(23, 80);
        this.F = typedArray.getColor(0, Color.parseColor((String)"#ffffff"));
        this.G = typedArray.getDimension(2, (float)CommonSlidingTabLayout.super.a(0.0f));
        this.H = typedArray.getDimension(1, (float)CommonSlidingTabLayout.super.a(12.0f));
        this.I = typedArray.getDimension(21, (float)CommonSlidingTabLayout.super.b(14.0f));
        this.J = typedArray.getColor(19, Color.parseColor((String)"#ffffff"));
        this.K = typedArray.getColor(20, Color.parseColor((String)"#AAffffff"));
        this.L = typedArray.getInt(18, 0);
        this.M = typedArray.getBoolean(17, false);
        this.q = typedArray.getBoolean(15, false);
        this.r = typedArray.getDimension(16, (float)CommonSlidingTabLayout.super.a(-1.0f));
        int n5 = !this.q && !(this.r > 0.0f) ? CommonSlidingTabLayout.super.a(20.0f) : CommonSlidingTabLayout.super.a(0.0f);
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
        return (int)(0.5f + f2 * this.c.getResources().getDisplayMetrics().density);
    }

    static /* synthetic */ LinearLayout a(CommonSlidingTabLayout commonSlidingTabLayout) {
        return commonSlidingTabLayout.a;
    }

    private void a() {
        this.a.removeAllViews();
        int n2 = this.e == null ? this.d.getAdapter().c() : this.e.size();
        this.b = n2;
        for (int i2 = 0; i2 < this.b; ++i2) {
            ImageView imageView;
            View view = View.inflate((Context)this.c, (int)2131427498, null);
            CharSequence charSequence = this.e == null ? this.d.getAdapter().b(i2) : (CharSequence)this.e.get(i2);
            String string2 = charSequence.toString();
            TextView textView = (TextView)view.findViewById(2131296870);
            if (textView != null && string2 != null) {
                textView.setText((CharSequence)string2);
            }
            if ((imageView = (ImageView)view.findViewById(2131296559)) != null && !this.Q.isEmpty()) {
                imageView.setImageResource(((a)this.Q.get(i2)).b());
            }
            view.setOnClickListener(new View.OnClickListener(this){
                final /* synthetic */ CommonSlidingTabLayout a;
                {
                    this.a = commonSlidingTabLayout;
                }

                public void onClick(View view) {
                    int n2 = CommonSlidingTabLayout.a(this.a).indexOfChild(view);
                    if (n2 != -1 && CommonSlidingTabLayout.b(this.a).getCurrentItem() != n2) {
                        if (CommonSlidingTabLayout.c(this.a)) {
                            CommonSlidingTabLayout.b(this.a).a(n2, false);
                        } else {
                            CommonSlidingTabLayout.b(this.a).setCurrentItem(n2);
                        }
                        if (CommonSlidingTabLayout.d(this.a) != null) {
                            CommonSlidingTabLayout.d(this.a).a(n2);
                        }
                    }
                }
            });
            LinearLayout.LayoutParams layoutParams = this.q ? new LinearLayout.LayoutParams(0, -1, 1.0f) : new LinearLayout.LayoutParams(-2, -1);
            if (this.r > 0.0f) {
                layoutParams = new LinearLayout.LayoutParams((int)this.r, -1);
            }
            view.setLayoutDirection(2);
            this.a.addView(view, i2, (ViewGroup.LayoutParams)layoutParams);
        }
        this.b();
    }

    private int b(float f2) {
        return (int)(0.5f + f2 * this.c.getResources().getDisplayMetrics().scaledDensity);
    }

    static /* synthetic */ ViewPager b(CommonSlidingTabLayout commonSlidingTabLayout) {
        return commonSlidingTabLayout.d;
    }

    private void b() {
        for (int i2 = 0; i2 < this.b; ++i2) {
            TextView textView = (TextView)this.a.getChildAt(i2).findViewById(2131296870);
            if (textView == null) continue;
            int n2 = i2 == this.f ? this.J : this.K;
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

    private void c() {
        if (this.b <= 0) {
            return;
        }
        int n2 = (int)(this.g * (float)this.a.getChildAt(this.f).getWidth());
        int n3 = n2 + this.a.getChildAt(this.f).getLeft();
        if (this.f > 0 || n2 > 0) {
            int n4 = n3 - (this.getWidth() / 2 - this.getPaddingLeft());
            this.d();
            n3 = n4 + (this.i.right - this.i.left) / 2;
        }
        if (n3 != this.N) {
            this.N = n3;
            this.scrollTo(n3, 0);
        }
    }

    static /* synthetic */ boolean c(CommonSlidingTabLayout commonSlidingTabLayout) {
        return commonSlidingTabLayout.P;
    }

    static /* synthetic */ b d(CommonSlidingTabLayout commonSlidingTabLayout) {
        return commonSlidingTabLayout.U;
    }

    private void d() {
        int n2;
        int n3;
        View view = this.a.getChildAt(this.f);
        float f2 = view.getLeft();
        float f3 = view.getRight();
        if (this.o == 0 && this.B) {
            TextView textView = (TextView)view.findViewById(2131296870);
            this.S.setTextSize(this.I);
            float f4 = this.S.measureText(textView.getText().toString());
            this.R = (f3 - f2 - f4) / 2.0f;
        }
        if (this.f < -1 + this.b) {
            View view2 = this.a.getChildAt(1 + this.f);
            float f5 = view2.getLeft();
            float f6 = view2.getRight();
            f2 += this.g * (f5 - f2);
            f3 += this.g * (f6 - f3);
            if (this.o == 0 && this.B) {
                TextView textView = (TextView)view2.findViewById(2131296870);
                this.S.setTextSize(this.I);
                float f7 = this.S.measureText(textView.getText().toString());
                float f8 = (f6 - f5 - f7) / 2.0f;
                this.R += this.g * (f8 - this.R);
            }
        }
        Rect rect = this.h;
        rect.left = n3 = (int)f2;
        Rect rect2 = this.h;
        rect2.right = n2 = (int)f3;
        if (this.o == 0 && this.B) {
            this.h.left = (int)(f2 + this.R - 1.0f);
            this.h.right = (int)(f3 - this.R - 1.0f);
        }
        this.i.left = n3;
        this.i.right = n2;
        if (!(this.u < 0.0f)) {
            float f9 = (float)view.getLeft() + ((float)view.getWidth() - this.u) / 2.0f;
            if (this.f < -1 + this.b) {
                View view3 = this.a.getChildAt(1 + this.f);
                f9 += this.g * (float)(view.getWidth() / 2 + view3.getWidth() / 2);
            }
            this.h.left = (int)f9;
            this.h.right = (int)((float)this.h.left + this.u);
        }
    }

    private void d(int n2) {
        for (int i2 = 0; i2 < this.b; ++i2) {
            ImageView imageView;
            View view = this.a.getChildAt(i2);
            boolean bl = i2 == n2;
            TextView textView = (TextView)view.findViewById(2131296870);
            if (textView != null) {
                int n3 = bl ? this.J : this.K;
                textView.setTextColor(n3);
                if (this.L == 1) {
                    textView.getPaint().setFakeBoldText(bl);
                }
            }
            if ((imageView = (ImageView)view.findViewById(2131296559)) == null || this.Q.isEmpty()) continue;
            a a2 = (a)this.Q.get(i2);
            int n4 = bl ? a2.a() : a2.b();
            imageView.setImageResource(n4);
        }
    }

    public final void a(int n2) {
        CommonSlidingTabLayout.super.d(n2);
    }

    public final void a(int n2, float f2) {
        this.f = n2;
        this.g = f2;
        CommonSlidingTabLayout.super.c();
        this.invalidate();
    }

    public final void b(int n2) {
        MsgView msgView;
        if (n2 >= this.b) {
            n2 = this.b - 1;
        }
        if (n2 >= this.b) {
            n2 = this.b - 1;
        }
        if ((msgView = (MsgView)this.a.getChildAt(n2).findViewById(2131296694)) != null) {
            if (msgView != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)msgView.getLayoutParams();
                DisplayMetrics displayMetrics = msgView.getResources().getDisplayMetrics();
                msgView.setVisibility(0);
                msgView.setStrokeWidth(0);
                msgView.setText((CharSequence)"");
                layoutParams.width = (int)(5.0f * displayMetrics.density);
                layoutParams.height = (int)(5.0f * displayMetrics.density);
                msgView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            }
            if (this.T.get(n2) == null || !((Boolean)this.T.get(n2)).booleanValue()) {
                this.T.put(n2, (Object)true);
            }
        }
    }

    public final void c(int n2) {
        MsgView msgView;
        if (n2 >= this.b) {
            n2 = -1 + this.b;
        }
        if ((msgView = (MsgView)this.a.getChildAt(n2).findViewById(2131296694)) != null) {
            msgView.setVisibility(8);
        }
    }

    public int getCurrentTab() {
        return this.f;
    }

    public a getCurrentTabEntity() {
        return (a)this.Q.get(this.f);
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
        return this.b;
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
        if (this.b <= 0) {
            return;
        }
        int n2 = this.getHeight();
        int n3 = this.getPaddingStart();
        if (this.G > 0.0f) {
            this.l.setStrokeWidth(this.G);
            this.l.setColor(this.F);
            for (int i2 = 0; i2 < this.b - 1; ++i2) {
                View view = this.a.getChildAt(i2);
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
                f2 = n3 + this.a.getWidth();
            } else {
                f5 = n3;
                f2 = n3 + this.a.getWidth();
                f4 = this.D;
                f3 = 0.0f;
            }
            canvas.drawRect(f5, f3, f2, f4, this.k);
        }
        CommonSlidingTabLayout.super.d();
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
            this.f = bundle.getInt("mCurrentTab");
            parcelable = bundle.getParcelable("instanceState");
            if (this.f != 0 && this.a.getChildCount() > 0) {
                CommonSlidingTabLayout.super.d(this.f);
                CommonSlidingTabLayout.super.c();
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mCurrentTab", this.f);
        return bundle;
    }

    public void setCurrentTab(int n2) {
        this.f = n2;
        this.d.setCurrentItem(n2);
    }

    public void setDividerColor(int n2) {
        this.F = n2;
        this.invalidate();
    }

    public void setDividerPadding(float f2) {
        this.H = CommonSlidingTabLayout.super.a(f2);
        this.invalidate();
    }

    public void setDividerWidth(float f2) {
        this.G = CommonSlidingTabLayout.super.a(f2);
        this.invalidate();
    }

    public void setIndicatorColor(int n2) {
        this.s = n2;
        this.invalidate();
    }

    public void setIndicatorCornerRadius(float f2) {
        this.v = CommonSlidingTabLayout.super.a(f2);
        this.invalidate();
    }

    public void setIndicatorGravity(int n2) {
        this.A = n2;
        this.invalidate();
    }

    public void setIndicatorHeight(float f2) {
        this.t = CommonSlidingTabLayout.super.a(f2);
        this.invalidate();
    }

    public void setIndicatorStyle(int n2) {
        this.o = n2;
        this.invalidate();
    }

    public void setIndicatorWidth(float f2) {
        this.u = CommonSlidingTabLayout.super.a(f2);
        this.invalidate();
    }

    public void setIndicatorWidthEqualTitle(boolean bl) {
        this.B = bl;
        this.invalidate();
    }

    public void setOnTabSelectListener(b b2) {
        this.U = b2;
    }

    public void setSnapOnTabClick(boolean bl) {
        this.P = bl;
    }

    public void setTabData(ArrayList<a> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            this.Q.clear();
            this.Q.addAll(arrayList);
            return;
        }
        throw new IllegalStateException("TabEntitys can not be NULL or EMPTY !");
    }

    public void setTabPadding(float f2) {
        this.p = CommonSlidingTabLayout.super.a(f2);
        CommonSlidingTabLayout.super.b();
    }

    public void setTabSpaceEqual(boolean bl) {
        this.q = bl;
        CommonSlidingTabLayout.super.b();
    }

    public void setTabWidth(float f2) {
        this.r = CommonSlidingTabLayout.super.a(f2);
        CommonSlidingTabLayout.super.b();
    }

    public void setTextAllCaps(boolean bl) {
        this.M = bl;
        CommonSlidingTabLayout.super.b();
    }

    public void setTextBold(int n2) {
        this.L = n2;
        CommonSlidingTabLayout.super.b();
    }

    public void setTextSelectColor(int n2) {
        this.J = n2;
        CommonSlidingTabLayout.super.b();
    }

    public void setTextUnselectColor(int n2) {
        this.K = n2;
        CommonSlidingTabLayout.super.b();
    }

    public void setTextsize(float f2) {
        this.I = CommonSlidingTabLayout.super.b(f2);
        CommonSlidingTabLayout.super.b();
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
        this.D = CommonSlidingTabLayout.super.a(f2);
        this.invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        if (viewPager != null && viewPager.getAdapter() != null) {
            this.d = viewPager;
            this.d.b((ViewPager.e)this);
            this.d.a((ViewPager.e)this);
            CommonSlidingTabLayout.super.a();
            return;
        }
        throw new IllegalStateException("ViewPager or ViewPager adapter can not be NULL !");
    }
}

