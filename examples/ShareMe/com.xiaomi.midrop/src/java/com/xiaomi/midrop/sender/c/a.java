/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.xiaomi.midrop.HomeActivity
 *  com.xiaomi.midrop.send.FilePickNewActivity
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 *  java.util.Iterator
 *  java.util.LinkedList
 */
package com.xiaomi.midrop.sender.c;

import android.app.Activity;
import com.xiaomi.midrop.HomeActivity;
import com.xiaomi.midrop.send.FilePickNewActivity;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public final class a {
    private static a b;
    private LinkedList<WeakReference<Activity>> a = new LinkedList();

    private a() {
    }

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    public final void a(Activity activity) {
        WeakReference weakReference = new WeakReference((Object)activity);
        this.a.add((Object)weakReference);
    }

    public final void b() {
        for (WeakReference weakReference : this.a) {
            if (weakReference.get() == null || ((Activity)weakReference.get()).isDestroyed() || ((Activity)weakReference.get()).isFinishing()) continue;
            ((Activity)weakReference.get()).finish();
        }
        this.a.clear();
    }

    public final void b(Activity activity) {
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            if (((WeakReference)iterator.next()).get() != activity) continue;
            iterator.remove();
            break;
        }
    }

    public final void c() {
        for (WeakReference weakReference : this.a) {
            if (weakReference.get() == null || ((Activity)weakReference.get()).isDestroyed() || ((Activity)weakReference.get()).isFinishing() || weakReference.get() instanceof HomeActivity || weakReference.get() instanceof FilePickNewActivity) continue;
            ((Activity)weakReference.get()).finish();
        }
        this.a.clear();
    }
}

