/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.text.TextUtils
 *  android.widget.Toast
 *  com.xiaomi.midrop.b.b
 *  com.xiaomi.midrop.transmission.c
 *  com.xiaomi.midrop.util.af
 *  com.xiaomi.midrop.util.af$a
 *  com.xiaomi.midrop.util.af$b
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package com.xiaomi.midrop.transmission;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.Toast;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.transmission.c;
import com.xiaomi.midrop.util.af;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class b
extends AsyncTask<Void, Void, Void> {
    private List<Uri> a;
    private List<String> b = new ArrayList();
    private WeakReference<a> c;
    private int d = 0;

    public b(a a2, List<Uri> list) {
        this.c = new WeakReference((Object)a2);
        this.a = new ArrayList(list);
    }

    private static int a(List<Uri> list, String string2) {
        for (int i2 = 0; i2 < list.size(); ++i2) {
            if (!TextUtils.equals((CharSequence)((Uri)list.get(i2)).getPath(), (CharSequence)string2)) continue;
            return i2;
        }
        return -1;
    }

    private static boolean a(g g2, List<Uri> list, List<String> list2) {
        if (g2.m != 2 && g2.m != 1) {
            if (g2.m == 3 && b.a(list, g2.i) != -1) {
                return true;
            }
        } else {
            int n2 = b.a(list, g2.i);
            if (n2 != -1) {
                list2.add((Object)g2.k);
                list.remove(n2);
            }
        }
        return false;
    }

    protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
        if (this.a != null) {
            if (this.a.isEmpty()) {
                return null;
            }
            this.a = com.xiaomi.midrop.send.contacts.a.a(this.a);
            List list = c.e().f;
            if (list != null) {
                for (g g2 : list) {
                    if (g2.z == g.a.b || !(g2 instanceof com.xiaomi.midrop.b.b)) continue;
                    com.xiaomi.midrop.b.b b2 = (com.xiaomi.midrop.b.b)g2;
                    if (!b2.a && b2.g != 1) {
                        this.d += b.a((g)b2, this.a, this.b);
                        continue;
                    }
                    for (g g3 : b2.b) {
                        this.d += b.a(g3, this.a, this.b);
                    }
                }
            }
        }
        return null;
    }

    protected final /* synthetic */ void onPostExecute(Object object) {
        super.onPostExecute((Object)((Void)object));
        a a2 = (a)this.c.get();
        if (a2 != null) {
            if (!(a2 instanceof Activity)) {
                return;
            }
            Activity activity = (Activity)a2;
            if (!activity.isFinishing()) {
                if (activity.isDestroyed()) {
                    return;
                }
                List<String> list = this.b;
                if (list != null && !list.isEmpty()) {
                    String string2;
                    int n2 = list.size();
                    String string3 = (String)list.get(0);
                    if (string3.length() > 10) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(string3.substring(0, 10));
                        stringBuilder.append("...");
                        string3 = stringBuilder.toString();
                    }
                    if (n2 == 1) {
                        string2 = activity.getResources().getString(2131689859, new Object[]{string3});
                    } else {
                        Resources resources = activity.getResources();
                        int n3 = n2 - 1;
                        Object[] arrobject = new Object[]{string3, n3};
                        string2 = resources.getQuantityString(2131558408, n3, arrobject);
                    }
                    Toast.makeText((Context)activity, (CharSequence)string2, (int)1).show();
                }
                if (!this.a.isEmpty()) {
                    a2.a(this.a);
                    a2.b(this.a);
                }
                af.a((af.a)af.a.dQ).a(af.b.aw, this.b.size()).a();
                af.a((af.a)af.a.dR).a(af.b.aw, this.d).a();
            }
        }
    }

    public static interface a {
        public void a(List<Uri> var1);

        public void b(List<Uri> var1);
    }

}

