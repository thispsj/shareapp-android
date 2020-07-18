/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.xiaomi.midrop.sender.c.h$1
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package com.xiaomi.midrop.sender.c;

import com.xiaomi.midrop.sender.c.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class h<T> {
    private List<T> a;

    public h(List<T> list) {
        this.a = list;
    }

    public static <T> List<T> a(int n2, a<T> a2) {
        List<T> list;
        ArrayList arrayList = new ArrayList();
        int n3 = 0;
        while ((list = a2.a(n3, n2)) != null && list.size() != 0) {
            if (list.size() < n2) {
                arrayList.addAll(list);
                return arrayList;
            }
            arrayList.addAll(list);
            n3 += n2;
        }
        return arrayList;
    }

    public final List<T> a(int n2, int n3) {
        if (this.a != null && !this.a.isEmpty() && n2 < this.a.size()) {
            int n4 = n3 + n2;
            if (n4 > this.a.size()) {
                n4 = this.a.size();
            }
            return this.a.subList(n2, n4);
        }
        return new ArrayList();
    }

    public final void b(int n2, a<T> a2) {
        h.a(n2, new 1((h)this, a2));
    }

    public static interface a<E> {
        public List<E> a(int var1, int var2);
    }

}

