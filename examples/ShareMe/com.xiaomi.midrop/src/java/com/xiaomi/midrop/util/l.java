/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$Style
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.util;

import a.e.b.d;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

public final class l
extends Drawable {
    private final Paint a;
    private final String b;
    private final int c;

    public l(String string2, int n2) {
        d.b(string2, "text");
        this.b = string2;
        this.c = n2;
        this.a = new Paint();
        this.a.setColor(-1);
        this.a.setAntiAlias(true);
        this.a.setFakeBoldText(true);
        this.a.setTypeface(Typeface.create((Typeface)Typeface.DEFAULT, (int)1));
        this.a.setStyle(Paint.Style.FILL);
        this.a.setTextAlign(Paint.Align.CENTER);
    }

    public final void draw(Canvas canvas) {
        d.b((Object)canvas, "canvas");
        this.a.setTextSize(12.0f * ((float)canvas.getWidth() / 40.0f));
        canvas.drawColor(this.c);
        float f2 = (float)canvas.getWidth() / 2.0f;
        float f3 = (float)(canvas.getHeight() / 2) - (this.a.descent() + this.a.ascent()) / 2.0f;
        canvas.drawText(this.b, f2, f3, this.a);
    }

    public final int getOpacity() {
        return -1;
    }

    public final void setAlpha(int n2) {
        this.a.setAlpha(n2);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != null) {
            this.a.setColorFilter(colorFilter);
        }
    }
}

