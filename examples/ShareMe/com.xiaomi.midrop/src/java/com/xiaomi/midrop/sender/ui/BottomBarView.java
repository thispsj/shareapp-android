/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  com.xiaomi.midrop.util.ac
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 */
package com.xiaomi.midrop.sender.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.midrop.R;
import com.xiaomi.midrop.util.ac;

public class BottomBarView
extends RelativeLayout
implements View.OnClickListener {
    public int a;
    public boolean b = false;
    private TextView c;
    private View d;
    private View e;
    private View f;
    private View g;
    private b h;

    public BottomBarView(Context context) {
        super(context);
        BottomBarView.super.a(null, 0);
    }

    public BottomBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        BottomBarView.super.a(attributeSet, 0);
    }

    public BottomBarView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        BottomBarView.super.a(attributeSet, n2);
    }

    private void a(AttributeSet attributeSet, int n2) {
        TypedArray typedArray;
        block6 : {
            int n3;
            typedArray = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.BottomBarView, n2, 0);
            switch (typedArray.getInt(0, 0)) {
                default: {
                    break block6;
                }
                case 2: {
                    n3 = com.xiaomi.midrop.sender.a.a.c;
                    break;
                }
                case 1: {
                    n3 = com.xiaomi.midrop.sender.a.a.b;
                    break;
                }
                case 0: {
                    n3 = com.xiaomi.midrop.sender.a.a.a;
                }
            }
            this.a = n3;
        }
        typedArray.recycle();
        LayoutInflater.from((Context)this.getContext()).inflate(2131427562, (ViewGroup)this, true);
        this.d = this.findViewById(2131296644);
        this.e = this.findViewById(2131296332);
        this.c = (TextView)this.findViewById(2131296838);
        this.c.setOnClickListener((View.OnClickListener)this);
        this.f = this.findViewById(2131296748);
        this.f.setOnClickListener((View.OnClickListener)this);
        this.g = this.findViewById(2131296909);
        this.g.setOnClickListener((View.OnClickListener)this);
        this.a(this.a);
        if (ac.c((Context)this.getContext())) {
            this.c.setBackground(this.getResources().getDrawable(2131230855));
        }
    }

    private void setErrorUI(boolean bl) {
        if (this.b) {
            this.c.setVisibility(8);
            this.e.setVisibility(0);
            this.e.setEnabled(bl);
            this.f.setEnabled(bl);
            ((TextView)this.findViewById(2131296752)).setText(2131689856);
            return;
        }
        this.e.setVisibility(8);
        this.c.setText(2131689856);
        this.c.setVisibility(0);
        this.c.setEnabled(bl);
        this.c.setBackground(this.getResources().getDrawable(2131230848));
        this.d.setBackgroundColor(this.getResources().getColor(2131099975));
    }

    private void setNormalUI(boolean bl) {
        if (this.b) {
            this.c.setVisibility(8);
            this.e.setVisibility(0);
            this.e.setEnabled(bl);
            this.f.setEnabled(bl);
            return;
        }
        this.e.setVisibility(8);
        this.c.setText(2131689887);
        this.c.setVisibility(0);
        this.c.setEnabled(bl);
        this.c.setBackground(this.getResources().getDrawable(2131230854));
        this.d.setBackgroundColor(this.getResources().getColor(2131099932));
    }

    public final void a(int n2) {
        this.a = n2;
        if (this.a != com.xiaomi.midrop.sender.a.a.a) {
            if (this.a == com.xiaomi.midrop.sender.a.a.b) {
                BottomBarView.super.setErrorUI(true);
                return;
            }
            if (this.a == com.xiaomi.midrop.sender.a.a.d) {
                BottomBarView.super.setNormalUI(false);
                return;
            }
        }
        BottomBarView.super.setNormalUI(true);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onClick(View view) {
        block9 : {
            b b2;
            int n2;
            block8 : {
                block6 : {
                    block7 : {
                        if (this.h == null) {
                            return;
                        }
                        if (1.a[this.a - 1] == 1) break block6;
                        if (view.getId() != this.c.getId() && view.getId() != this.f.getId()) break block7;
                        b2 = this.h;
                        n2 = a.d;
                        break block8;
                    }
                    if (view.getId() == this.g.getId()) {
                        this.h.a(a.e);
                    }
                    return;
                }
                if (view.getId() != this.c.getId() && view.getId() != this.f.getId()) break block9;
                b2 = this.h;
                n2 = a.c;
            }
            b2.a(n2);
            return;
        }
        if (view.getId() == this.g.getId()) {
            this.h.a(a.e);
        }
    }

    public void setBottomBarClickListener(b b2) {
        this.h = b2;
    }

    public void setEnabled(boolean bl) {
        super.setEnabled(bl);
        this.c.setEnabled(bl);
        this.e.setEnabled(bl);
    }

    public static final class a
    extends Enum<a> {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        private static final /* synthetic */ int[] f;

        static {
            int[] arrn = new int[]{a, b, c, d, e};
            f = arrn;
        }

        public static int[] a() {
            return (int[])f.clone();
        }
    }

    public static interface b {
        public void a(int var1);
    }

}

