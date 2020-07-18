/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.i.g
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.AsyncTask
 *  android.provider.ContactsContract
 *  android.provider.ContactsContract$Contacts
 *  android.text.TextUtils
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.xiaomi.midrop.sender.c;

import a.e.b.d;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.xiaomi.midrop.sender.c.b;
import com.xiaomi.midrop.sender.c.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class g
extends b<com.xiaomi.midrop.b.g> {
    public static final String e = g.class.getCanonicalName();
    private static g f;
    private HashMap<String, HashSet<com.xiaomi.midrop.b.g>> g = new HashMap();

    private g() {
    }

    public static int a(List<com.xiaomi.midrop.b.g> list) {
        Iterator iterator = list.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            com.xiaomi.midrop.b.g g2 = (com.xiaomi.midrop.b.g)iterator.next();
            if (!g.e().a(g2)) continue;
            ++n2;
        }
        return n2;
    }

    static /* synthetic */ HashMap a(g g2) {
        return g2.g;
    }

    static /* synthetic */ void a(g g2, String string2, List list) {
        for (int i2 = -1 + g2.d.size(); i2 >= 0; --i2) {
            ((a)g2.d.get(i2)).a(string2, (List<com.xiaomi.midrop.b.g>)list);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static g e() {
        if (f != null) return f;
        Class<g> class_ = g.class;
        synchronized (g.class) {
            if (f != null) return f;
            f = new g();
            // ** MonitorExit[var1] (shouldn't be in output)
            return f;
        }
    }

    public final long a(String string2) {
        if (!this.g.containsKey((Object)string2)) {
            return -1L;
        }
        long l2 = 0L;
        Iterator iterator = ((HashSet)this.g.get((Object)string2)).iterator();
        while (iterator.hasNext()) {
            l2 += ((com.xiaomi.midrop.b.g)iterator.next()).l;
        }
        return l2;
    }

    @Override
    public final boolean a(com.xiaomi.midrop.b.g g2) {
        if (super.a(g2)) {
            return true;
        }
        Iterator iterator = this.g.entrySet().iterator();
        while (iterator.hasNext()) {
            if (!((HashSet)((Map.Entry)iterator.next()).getValue()).contains((Object)g2)) continue;
            return true;
        }
        return false;
    }

    public final void b(String string2) {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.d();
        while (iterator.hasNext()) {
            com.xiaomi.midrop.b.g g2 = (com.xiaomi.midrop.b.g)iterator.next();
            if (g2.i.indexOf(string2) != 0) continue;
            arrayList.add((Object)g2);
        }
        this.c(arrayList);
    }

    @Override
    public final boolean b(com.xiaomi.midrop.b.g g2) {
        if (super.b(g2)) {
            if (com.xiaomi.midrop.b.g.a(g2)) {
                new AsyncTask<Void, Void, List<com.xiaomi.midrop.b.g>>((g)this, g2.i){
                    final /* synthetic */ String a;
                    final /* synthetic */ g b;
                    {
                        this.b = g2;
                        this.a = string2;
                    }

                    protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
                        ArrayList arrayList = new ArrayList();
                        com.xiaomi.midrop.util.z.a(this.a, (List<com.xiaomi.midrop.b.g>)arrayList);
                        return arrayList;
                    }

                    protected final /* synthetic */ void onPostExecute(Object object) {
                        List list = (List)object;
                        g.a(this.b).put((Object)this.a, (Object)new HashSet((Collection)list));
                        g.a(this.b, this.a, list);
                    }
                }.execute((Object[])new Void[0]);
            }
            return true;
        }
        return false;
    }

    @Override
    public final void c() {
        super.c();
        this.g.clear();
    }

    @Override
    public final boolean c(com.xiaomi.midrop.b.g g2) {
        if (super.c(g2)) {
            if (com.xiaomi.midrop.b.g.a(g2)) {
                this.g.remove((Object)g2.i);
            }
            return true;
        }
        Iterator iterator = this.g.entrySet().iterator();
        String string2 = null;
        HashSet hashSet = null;
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            if (!((HashSet)entry.getValue()).contains((Object)g2)) continue;
            ((HashSet)entry.getValue()).remove((Object)g2);
            string2 = (String)entry.getKey();
            hashSet = (HashSet)entry.getValue();
        }
        if (string2 != null && hashSet != null) {
            Iterator iterator2 = this.d();
            while (iterator2.hasNext()) {
                com.xiaomi.midrop.b.g g3 = (com.xiaomi.midrop.b.g)iterator2.next();
                if (!TextUtils.equals((CharSequence)g3.i, string2)) continue;
                this.c(g3);
                break;
            }
            this.b(hashSet);
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final ArrayList<Uri> f() {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.d();
        while (iterator.hasNext()) {
            Uri uri;
            com.xiaomi.midrop.b.g g2 = (com.xiaomi.midrop.b.g)iterator.next();
            if (g2.F) {
                com.xiaomi.midrop.send.contacts.b b2 = com.xiaomi.midrop.send.contacts.b.a(g2);
                String string2 = Uri.withAppendedPath((Uri)ContactsContract.Contacts.CONTENT_VCARD_URI, (String)b2.e).toString();
                d.a((Object)string2, "Uri.withAppendedPath(Con\u2026RI, lookupKey).toString()");
                uri = Uri.parse((String)a.i.g.b((String)string2, (String)"content", (String)"midrop.contact"));
                d.a((Object)uri, "Uri.parse(uriString)");
            } else {
                File file = new File(g2.i);
                if (!file.exists() || file.length() == 0L) continue;
                Uri.Builder builder = new Uri.Builder();
                builder.scheme("file");
                builder.authority("");
                builder.path(g2.i);
                if (file.getName().equals((Object)"base.apk") && !g2.k.endsWith(".apk")) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(g2.k);
                    stringBuilder.append(".apk");
                    builder.appendQueryParameter("name", stringBuilder.toString());
                }
                uri = builder.build();
            }
            arrayList.add((Object)uri);
        }
        return arrayList;
    }

    public static interface a
    extends b.a<com.xiaomi.midrop.b.g> {
        public void a(String var1, List<com.xiaomi.midrop.b.g> var2);
    }

}

