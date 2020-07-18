/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  midrop.b.b.a.a
 *  midrop.b.b.a.d
 */
package midrop.b.b;

import android.content.Context;
import android.text.TextUtils;
import midrop.b.b.a;
import midrop.b.b.a.d;
import midrop.c.c.e;
import midrop.c.c.f;
import midrop.c.d.c;

public final class b {
    public static a a;

    public static a a(Context context, midrop.c.a.e e2) {
        if (!(e2.f() == c.a.b || e2.h() == 10004 && !TextUtils.isEmpty((CharSequence)e2.e()) || !e2.i() && !TextUtils.isEmpty((CharSequence)e2.e()) || ((Boolean)e2.b.b(midrop.c.a.f.z)).booleanValue() && !TextUtils.isEmpty((CharSequence)e2.e()))) {
            if (e2.f() == c.a.d) {
                a = midrop.b.b.a.a.a((Context)context);
            }
        } else {
            a = new d(context);
        }
        return a;
    }
}

