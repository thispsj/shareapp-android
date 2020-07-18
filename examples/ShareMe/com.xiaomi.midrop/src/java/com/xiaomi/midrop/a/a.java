/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.String
 */
package com.xiaomi.midrop.a;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.profile.a;

public final class a
extends Drawable {
    private Paint a;
    private Paint b;
    private RectF c;
    private String d;
    private int e = 55;
    private float f;
    private float g;

    public a(String string2) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            string2 = string2.trim();
        }
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            string2 = string2.substring(0, string2.offsetByCodePoints(0, 1)).toUpperCase();
        }
        this.d = string2;
        this.a = new Paint();
        this.a.setAntiAlias(true);
        this.a.setColor(-1);
        this.a.setTypeface(Typeface.create((String)"sans-serif", (int)0));
        this.b = new Paint();
        this.b.setAntiAlias(true);
        this.b.setStyle(Paint.Style.FILL);
        this.b.setColor(a.a("", this.d));
    }

    public static int a(String string2, String string3) {
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            string3 = string3.trim();
        }
        if (TextUtils.isEmpty((CharSequence)string3)) {
            return Color.parseColor((String)"#A7AFC4");
        }
        if (a.a.b(string2)) {
            return MiDropApplication.a().getResources().getColor(2131100066);
        }
        int[] arrn = MiDropApplication.a().getResources().getIntArray(2130903042);
        return arrn[string3.getBytes()[0] & 255 % arrn.length];
    }

    public final void draw(Canvas canvas) {
        if (this.c == null) {
            this.c = new RectF(0.0f, 0.0f, (float)canvas.getWidth(), (float)canvas.getHeight());
            this.a.setTextSize((float)this.getBounds().height() * (float)this.e / 100.0f);
            float f2 = this.a.measureText(this.d);
            this.f = (float)this.getBounds().width() / 2.0f - f2 / 2.0f;
            this.g = (float)this.getBounds().height() / 2.0f - (this.a.ascent() + this.a.descent()) / 2.0f;
        }
        canvas.drawOval(this.c, this.b);
        canvas.drawText(this.d, this.f, this.g, this.a);
    }

    public final int getOpacity() {
        return -3;
    }

    public final void setAlpha(int n) {
        this.a.setAlpha(n);
        this.b.setAlpha(n);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
        this.b.setColorFilter(colorFilter);
    }
}

