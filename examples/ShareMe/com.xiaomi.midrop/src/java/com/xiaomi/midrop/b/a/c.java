/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.res.Resources
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Set
 */
package com.xiaomi.midrop.b.a;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.b.a.a;
import com.xiaomi.midrop.b.a.c;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.h;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.util.Locale.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class c
extends a<List<i>> {
    List<i> b = new ArrayList();
    List<g> c = new ArrayList();
    List<g> d = new ArrayList();
    Set<String> e = new HashSet();
    private h.a f = new h.a(){

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public final void a(int n2, List<g> list) {
            Collections.sort(list, (Comparator)new Comparator<g>(this){
                final /* synthetic */ 1 a;
                {
                    this.a = var1;
                }

                public final /* synthetic */ int compare(Object object, Object object2) {
                    g g2 = (g)object;
                    g g3 = (g)object2;
                    return java.text.Collator.getInstance((java.util.Locale)java.util.Locale.CHINA).compare(g2.k, g3.k);
                }
            });
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            i i2 = i.a(0, b.a().b(2131689670), (List<g>)arrayList);
            i2.a = c.this.c;
            i i3 = i.a(0, b.a().b(2131689671), (List<g>)arrayList3);
            i3.a = c.this.d;
            c c2 = c.this;
            if (c2.e.isEmpty()) {
                String string2 = MiDropApplication.a().getSharedPreferences("midrop.hotApp", 0).getString("key_hot_app_white_list", "");
                Object[] arrobject = !TextUtils.isEmpty((CharSequence)string2) ? string2.split(",") : MiDropApplication.a().getResources().getStringArray(2130903043);
                c2.e.addAll((Collection)Arrays.asList((Object[])arrobject));
            }
            Set<String> set = c2.e;
            for (g g2 : list) {
                List<g> list2;
                if (set.contains((Object)g2.C)) {
                    if (arrayList2.isEmpty()) {
                        arrayList.add((Object)i.a((List<g>)arrayList2));
                    }
                    arrayList2.add((Object)g2);
                    if (arrayList2.size() == 5) {
                        arrayList2 = new ArrayList();
                    }
                    list2 = c.this.c;
                } else {
                    if (g2.B) continue;
                    if (arrayList4.isEmpty()) {
                        arrayList3.add((Object)i.a((List<g>)arrayList4));
                    }
                    arrayList4.add((Object)g2);
                    if (arrayList4.size() == 5) {
                        arrayList4 = new ArrayList();
                    }
                    list2 = c.this.d;
                }
                list2.add((Object)g2);
            }
            if (!i2.b.isEmpty()) {
                c.this.b.add((Object)i2);
            }
            if (!i3.b.isEmpty()) {
                c.this.b.add((Object)i3);
            }
            c.this.a(c.this.b);
        }
    };

    @Override
    protected final /* synthetic */ Object b() {
        h.a().a(1, this.f);
        return null;
    }

    @Override
    protected final void c() {
        if (this.b != null) {
            this.b.clear();
        }
        if (this.d != null) {
            this.d.clear();
        }
    }

}

