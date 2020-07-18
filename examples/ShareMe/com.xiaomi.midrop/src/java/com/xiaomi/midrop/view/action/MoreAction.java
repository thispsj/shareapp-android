/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Point
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.support.v7.app.a
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  com.xiaomi.midrop.util.Locale.a
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.view.action;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.af;

public class MoreAction
implements View.OnClickListener {
    public com.xiaomi.midrop.util.Locale.a a;
    public View b;
    public View c;
    public View d;
    public TextView e;
    public View f;
    public View g;
    public a h;
    public ViewGroup i;
    public ViewGroup j;
    public boolean k = false;
    public View l;
    public View m;
    private LayoutInflater n;

    public MoreAction(com.xiaomi.midrop.util.Locale.a a2, a a3) {
        this.a = a2;
        this.h = a3;
        this.n = LayoutInflater.from((Context)this.a);
        this.b = this.n.inflate(2131427360, null);
        com.xiaomi.midrop.util.Locale.a a4 = this.a;
        ViewGroup viewGroup = a4 != null && a4.getSupportActionBar() != null ? (ViewGroup)a4.getSupportActionBar().d() : null;
        this.i = viewGroup;
        this.m = this.a.findViewById(2131296908);
        com.xiaomi.midrop.util.Locale.a a5 = this.a;
        ViewGroup viewGroup2 = null;
        if (a5 != null) {
            viewGroup2 = (ViewGroup)a5.findViewById(2131296404);
        }
        this.j = viewGroup2;
        this.l = this.a.findViewById(2131296404);
    }

    public static void a(View view, ViewGroup viewGroup) {
        if (view != null) {
            if (viewGroup == null) {
                return;
            }
            Context context = viewGroup.getContext();
            try {
                int n2 = ac.b((Context)context).x;
                int n3 = viewGroup.getHeight();
                Bitmap bitmap = Bitmap.createBitmap((int)n2, (int)n3, (Bitmap.Config)Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(context.getResources().getColor(2131099891));
                canvas.drawRect(0.0f, 0.0f, (float)n2, (float)n3, paint);
                view.setBackground((Drawable)new BitmapDrawable(bitmap));
                return;
            }
            catch (Exception exception) {
                int n4;
                exception.printStackTrace();
                if (viewGroup == null || (n4 = viewGroup.getHeight()) == 0) {
                    n4 = MiDropApplication.a().getResources().getDimensionPixelSize(2131165271);
                }
                view.setMinimumHeight(n4 - 1);
                view.setBackgroundColor(context.getResources().getColor(2131099891));
            }
        }
    }

    private static void a(ViewGroup viewGroup, boolean bl) {
        viewGroup.setEnabled(bl);
        int n2 = viewGroup.getChildCount();
        if (n2 > 0) {
            for (int i2 = 0; i2 < n2; ++i2) {
                viewGroup.getChildAt(i2).setEnabled(bl);
            }
        }
    }

    public static void a(String string2) {
        af.a(af.a.cb).a(af.b.G, string2).a();
    }

    public static void b() {
        af.a(af.a.cd).a();
    }

    public final void a() {
        if (this.b != null) {
            this.b.clearAnimation();
        }
        this.i.removeView(this.b);
        if (this.j != null) {
            this.j.clearAnimation();
            this.j.setVisibility(8);
        }
        this.d.setSelected(false);
        this.k = false;
        if (this.l != null) {
            this.l.setVisibility(8);
        }
        if (this.m != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.m.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, 0);
        }
    }

    public final void a(boolean bl, boolean bl2, int n2) {
        this.d.setSelected(bl2);
        if (bl) {
            MoreAction.a((ViewGroup)this.f, false);
            MoreAction.a((ViewGroup)this.g, false);
        } else {
            MoreAction.a((ViewGroup)this.f, true);
            MoreAction.a((ViewGroup)this.g, true);
        }
        TextView textView = this.e;
        Resources resources = this.a.getResources();
        Object[] arrobject = new Object[]{n2};
        textView.setText((CharSequence)resources.getQuantityString(2131558409, n2, arrobject));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            default: {
                return;
            }
            case 2131296735: {
                this.h.g();
                return;
            }
            case 2131296411: {
                this.h.h();
                af.a(af.a.cc).a();
                return;
            }
            case 16908314: {
                if (this.h == null) break;
                if (this.h.f()) {
                    this.d.setSelected(true);
                    return;
                }
                this.d.setSelected(false);
                return;
            }
            case 16908313: {
                if (this.h == null) break;
                this.h.e();
                this.a();
                af.a(af.a.ce).a(af.b.H, "close_btn").a();
            }
        }
    }

    public static interface a {
        public void e();

        public boolean f();

        public void g();

        public void h();
    }

}

