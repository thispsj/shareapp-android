/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  io.a.a.a.a$a
 *  io.a.a.a.a$a$1
 *  io.a.a.a.a$b
 *  java.lang.Object
 *  java.util.Set
 */
package io.a.a.a;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import io.a.a.a.a;
import java.util.Set;

/*
 * Exception performing whole class analysis.
 */
public final class a {
    public a a;
    private final Application b;

    public a(Context context) {
        this.b = (Application)context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 14) {
            this.a = new /* Unavailable Anonymous Inner Class!! */;
        }
    }

    public final boolean a(b b2) {
        if (this.a != null) {
            boolean bl;
            a a2 = this.a;
            if (a2.b != null) {
                1 var3_3 = new 1(a2, b2);
                a2.b.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)var3_3);
                a2.a.add((Object)var3_3);
                bl = true;
            } else {
                bl = false;
            }
            if (bl) {
                return true;
            }
        }
        return false;
    }
}

