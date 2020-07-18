/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.xiaomi.midrop.b.i
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 *  java.text.DateFormat
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Date
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 */
package com.xiaomi.midrop.util;

import android.net.Uri;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.util.Locale.b;
import com.xiaomi.midrop.util.g;
import com.xiaomi.midrop.util.j;
import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class f {
    public static List<com.xiaomi.midrop.b.g> a(List<com.xiaomi.midrop.b.g> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        for (com.xiaomi.midrop.b.g g2 : list) {
            File file = new File(g2.i);
            if (!file.exists()) continue;
            String string2 = j.d(g2.k);
            if (g.h.contains((Object)string2)) {
                arrayList3.add((Object)g2);
                continue;
            }
            if (g.l.contains((Object)string2)) {
                g2.h = Uri.fromFile((File)file).toString();
                arrayList2.add((Object)g2);
                continue;
            }
            if (g.i.contains((Object)string2)) {
                arrayList4.add((Object)g2);
                continue;
            }
            if (g.j.contains((Object)string2)) {
                arrayList5.add((Object)g2);
                continue;
            }
            arrayList6.add((Object)g2);
        }
        if (!arrayList2.isEmpty()) {
            f.b((List<com.xiaomi.midrop.b.g>)arrayList, (List<com.xiaomi.midrop.b.g>)arrayList2, 2131689555);
            arrayList.add((Object)i.a((List)arrayList2));
        }
        if (!arrayList3.isEmpty()) {
            f.b((List<com.xiaomi.midrop.b.g>)arrayList, (List<com.xiaomi.midrop.b.g>)arrayList3, 2131689556);
            arrayList.addAll((Collection)arrayList3);
        }
        if (!arrayList4.isEmpty()) {
            f.b((List<com.xiaomi.midrop.b.g>)arrayList, (List<com.xiaomi.midrop.b.g>)arrayList4, 2131689554);
            arrayList.addAll((Collection)arrayList4);
        }
        if (!arrayList5.isEmpty()) {
            f.b((List<com.xiaomi.midrop.b.g>)arrayList, (List<com.xiaomi.midrop.b.g>)arrayList5, 2131689553);
            arrayList.addAll((Collection)arrayList5);
        }
        if (!arrayList6.isEmpty()) {
            f.b((List<com.xiaomi.midrop.b.g>)arrayList, (List<com.xiaomi.midrop.b.g>)arrayList6, 2131689786);
            arrayList.addAll((Collection)arrayList6);
        }
        return arrayList;
    }

    public static List<i> a(List<com.xiaomi.midrop.b.g> list, int n2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        DateFormat dateFormat = j.b();
        Iterator iterator = list.iterator();
        long l2 = -1L;
        while (iterator.hasNext()) {
            com.xiaomi.midrop.b.g g2 = (com.xiaomi.midrop.b.g)iterator.next();
            boolean bl = true ^ j.a(g2.w, l2);
            if (bl) {
                arrayList3 = new ArrayList();
                arrayList4 = new ArrayList();
                i i2 = i.a((int)0, (String)dateFormat.format(new Date(1000L * g2.w)), (List)arrayList3);
                i2.a = arrayList4;
                arrayList.add((Object)i2);
                l2 = g2.w;
            }
            if (n2 > 1) {
                if (bl || arrayList2.size() == n2) {
                    arrayList2 = new ArrayList();
                    i i3 = i.a((int)1, (String)dateFormat.format(new Date(1000L * g2.w)), (List)arrayList2);
                    i3.a = arrayList4;
                    arrayList3.add((Object)i3);
                    i3.i = g2.i;
                }
                arrayList2.add((Object)g2);
            } else {
                arrayList3.add((Object)g2);
            }
            arrayList4.add((Object)g2);
        }
        return arrayList;
    }

    public static void a(List<i> list, List<com.xiaomi.midrop.b.g> list2, int n2) {
        if (!list2.isEmpty()) {
            ArrayList arrayList = new ArrayList(list2);
            i i2 = i.a((int)0, (String)b.a().b(n2), (List)arrayList);
            i2.a = new ArrayList(list2);
            list.add((Object)i2);
        }
    }

    public static List<i> b(List<com.xiaomi.midrop.b.g> list, int n2) {
        ArrayList arrayList = new ArrayList();
        f.a((List<i>)arrayList, list, n2);
        return arrayList;
    }

    private static void b(List<com.xiaomi.midrop.b.g> list, List<com.xiaomi.midrop.b.g> list2, int n2) {
        if (!list2.isEmpty()) {
            ArrayList arrayList = new ArrayList(list2);
            i i2 = i.a((int)0, (String)b.a().b(n2), (List)arrayList);
            i2.a = new ArrayList(list2);
            list.add((Object)i2);
        }
    }
}

