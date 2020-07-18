/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  io.a.a.a.a.b.i
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package io.a.a.a.a.g;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import io.a.a.a.a.b.i;
import io.a.a.a.c;
import io.a.a.a.l;

public final class n {
    public final String a;
    public final int b;
    public final int c;
    public final int d;

    private n(String string2, int n2, int n3, int n4) {
        this.a = string2;
        this.b = n2;
        this.c = n3;
        this.d = n4;
    }

    public static n a(Context context, String string2) {
        if (string2 != null) {
            try {
                int n2 = i.j((Context)context);
                l l2 = c.a();
                StringBuilder stringBuilder = new StringBuilder("App icon resource ID is ");
                stringBuilder.append(n2);
                l2.a("Fabric", stringBuilder.toString());
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource((Resources)context.getResources(), (int)n2, (BitmapFactory.Options)options);
                n n3 = new n(string2, n2, options.outWidth, options.outHeight);
                return n3;
            }
            catch (Exception exception) {
                c.a().c("Fabric", "Failed to load icon", exception);
            }
        }
        return null;
    }
}

