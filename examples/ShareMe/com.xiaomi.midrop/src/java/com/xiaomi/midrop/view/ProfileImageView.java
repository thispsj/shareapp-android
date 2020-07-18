/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.support.v4.a.a.b
 *  android.support.v4.a.a.d
 *  android.util.AttributeSet
 *  android.widget.ImageView
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  midrop.service.c.d
 */
package com.xiaomi.midrop.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.a.a.b;
import android.support.v4.a.a.d;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.profile.a;
import com.xiaomi.midrop.util.y;

public final class ProfileImageView
extends ImageView {
    private Paint a;
    private float b;
    private boolean c;

    public ProfileImageView(Context context) {
        super(context, null, 0, 6, null);
    }

    public ProfileImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
    }

    public ProfileImageView(Context context, AttributeSet attributeSet, int n2) {
        a.e.b.d.b((Object)context, "context");
        super(context, attributeSet, n2);
        this.a = new Paint();
        this.b = 1.0f;
        this.c = true;
        this.a.setAntiAlias(true);
        this.a.setColor(Color.parseColor((String)"#21000000"));
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.b);
    }

    public /* synthetic */ ProfileImageView(Context context, AttributeSet attributeSet, int n2, int n3, a.e.b.b b2) {
        if ((n3 & 2) != 0) {
            attributeSet = null;
        }
        if ((n3 & 4) != 0) {
            n2 = 0;
        }
        this(context, attributeSet, n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a() {
        TypedArray typedArray;
        block5 : {
            Resources resources;
            int n2;
            ImageView imageView = this;
            a.e.b.d.b((Object)imageView, "view");
            Context context = MiDropApplication.a();
            a.e.b.d.a((Object)context, "MiDropApplication.getApplication()");
            typedArray = context.getResources().obtainTypedArray(2130903044);
            a.e.b.d.a((Object)typedArray, "MiDropApplication.getApp\u2026ray(R.array.profile_icon)");
            int n3 = y.C();
            if (n3 < 0) {
                n3 = a.a.a(typedArray.length());
                y.f(n3);
            }
            int n4 = -3 + typedArray.length();
            if (n3 >= 0 && n4 >= n3) {
                n2 = typedArray.getResourceId(n3, -1);
                Context context2 = imageView.getContext();
                a.e.b.d.a((Object)context2, "view.context");
                resources = context2.getResources();
            } else {
                try {
                    imageView.setImageURI(a.c());
                    break block5;
                }
                catch (Exception exception) {
                    midrop.service.c.d.a((String)"ProfileModel", (String)"/path fail to find", (Throwable)exception, (Object[])new Object[0]);
                    int n5 = a.a.a(typedArray.length());
                    y.f(n5);
                    Context context3 = imageView.getContext();
                    a.e.b.d.a((Object)context3, "view.context");
                    resources = context3.getResources();
                    n2 = typedArray.getResourceId(n5, -1);
                }
            }
            imageView.setImageDrawable(resources.getDrawable(n2));
        }
        typedArray.recycle();
    }

    public final void a(int n2, String string2, String string3) {
        a.e.b.d.b(string2, "deviceId");
        a.e.b.d.b(string3, "name");
        a.a.a((ImageView)this, n2, string2, string3);
    }

    public final void a(String string2, String string3) {
        CharSequence charSequence = string2;
        boolean bl = charSequence == null || charSequence.length() == 0;
        if (!bl) {
            ImageView imageView = (ImageView)this;
            if (string2 == null) {
                a.e.b.d.a();
            }
            a.e.b.d.b((Object)imageView, "view");
            a.e.b.d.b(string2, "deviceId");
            a.a.a(imageView, a.a.a(string2), string2, string3);
            return;
        }
        this.setImageDrawable(new com.xiaomi.midrop.a.a(string3));
    }

    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.c && canvas != null) {
            canvas.drawCircle((float)this.getWidth() / 2.0f, (float)this.getHeight() / 2.0f, ((float)this.getWidth() - this.b) / 2.0f, this.a);
        }
    }

    public final void setBolderEnable(boolean bl) {
        this.c = bl;
        this.invalidate();
    }

    public final void setImageDrawable(Drawable drawable2) {
        if (drawable2 instanceof BitmapDrawable) {
            Context context = this.getContext();
            a.e.b.d.a((Object)context, "context");
            drawable2 = (Drawable)d.a((Resources)context.getResources(), (Bitmap)((BitmapDrawable)drawable2).getBitmap());
            ((b)drawable2).b();
        }
        super.setImageDrawable(drawable2);
    }

    public final void setImageURI(Uri uri) {
        String string2;
        Context context = this.getContext();
        a.e.b.d.a((Object)context, "context");
        Resources resources = context.getResources();
        if (uri == null || (string2 = uri.getPath()) == null) {
            string2 = "";
        }
        b b2 = d.a((Resources)resources, (String)string2);
        a.e.b.d.a((Object)b2, "RoundedBitmapDrawableFac\u2026sources, uri?.path ?: \"\")");
        b2.b();
        super.setImageDrawable((Drawable)b2);
    }
}

