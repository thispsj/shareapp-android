/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Set
 *  java.util.TreeMap
 */
package com.xiaomi.midrop.send.img;

import android.content.Context;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.send.base.FilePickBaseGroupListFragment;
import com.xiaomi.midrop.send.base.a;
import com.xiaomi.midrop.sender.c.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class FilePickImageGroupFragment
extends FilePickBaseGroupListFragment<TreeMap<String, List<g>>> {
    @Override
    protected final a a() {
        return new a(6);
    }

    @Override
    protected final /* synthetic */ List a(Object object) {
        TreeMap treeMap = (TreeMap)object;
        ArrayList arrayList = new ArrayList();
        Object[] arrobject = (String[])treeMap.keySet().toArray((Object[])new String[treeMap.size()]);
        Arrays.sort((Object[])arrobject, f.b());
        for (int i2 = 0; i2 < arrobject.length; ++i2) {
            Object object2 = arrobject[i2];
            ArrayList arrayList2 = new ArrayList();
            List list = (List)treeMap.get(object2);
            ArrayList arrayList3 = new ArrayList();
            i i3 = i.a(String.valueOf((int)list.size()), (g)list.get(0), (List<g>)arrayList3);
            i3.d = 0;
            i3.a = list;
            ArrayList arrayList4 = arrayList2;
            for (int i4 = 0; i4 < list.size(); ++i4) {
                g g2 = (g)list.get(i4);
                arrayList4.add((Object)g2);
                if (arrayList4.size() != 4 && i4 != list.size() - 1) continue;
                i i5 = i.a(1, "", (List<g>)arrayList4);
                arrayList3.add((Object)i5);
                i5.a = list;
                ArrayList arrayList5 = new ArrayList();
                i5.i = g2.i;
                if (i4 / 4 == 0) {
                    this.e.add((Object)i5);
                }
                if (i4 == list.size() - 1 && i2 < arrobject.length - 1) {
                    this.f.add((Object)i5);
                }
                arrayList4 = arrayList5;
            }
            arrayList.add((Object)i3);
        }
        return arrayList;
    }

    @Override
    protected final com.xiaomi.midrop.b.a.a<TreeMap<String, List<g>>> c() {
        this.getContext();
        return new com.xiaomi.midrop.b.a.i();
    }
}

