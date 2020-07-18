/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 */
package com.xiaomi.midrop.sender.c;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class b<T> {
    public static final String a = b.class.getCanonicalName();
    protected HashSet<T> b = new HashSet();
    public List<T> c = new ArrayList();
    public ArrayList<a> d = new ArrayList();

    private void a(List<T> list) {
        for (int i2 = -1 + this.d.size(); i2 >= 0; --i2) {
            ((a)this.d.get(i2)).b(list);
        }
    }

    private boolean a(T t2, boolean bl) {
        if (this.b.add(t2)) {
            this.c.add(t2);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(t2);
            if (bl) {
                b.super.a((List<T>)arrayList);
            }
            return true;
        }
        return false;
    }

    private void b(List<T> list) {
        for (int i2 = -1 + this.d.size(); i2 >= 0; --i2) {
            ((a)this.d.get(i2)).a(list);
        }
    }

    private boolean b(T t2, boolean bl) {
        if (this.b.remove(t2)) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(t2);
            if (bl) {
                b.super.b((List<T>)arrayList);
            }
            return true;
        }
        return false;
    }

    public final int a() {
        return this.b.size();
    }

    public final void a(a a2) {
        if (!this.d.add((Object)a2)) {
            String string2 = a;
            Object[] arrobject = new Object[]{a2.getClass().getCanonicalName()};
            Log.w((String)string2, (String)String.format((String)"Seems '%s'  had been registered before!", (Object[])arrobject));
        }
    }

    public boolean a(T t2) {
        return this.b.contains(t2);
    }

    public final boolean a(Collection<T> collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (this.a(iterator.next())) continue;
            return false;
        }
        return true;
    }

    public final void b(a a2) {
        if (!this.d.remove((Object)a2)) {
            String string2 = a;
            Object[] arrobject = new Object[]{a2.getClass().getCanonicalName()};
            Log.w((String)string2, (String)String.format((String)"Seems '%s'  had not been registered!", (Object[])arrobject));
        }
    }

    public final boolean b() {
        return this.b.isEmpty();
    }

    public boolean b(T t2) {
        return b.super.a(t2, true);
    }

    public final boolean b(Collection<T> collection) {
        Iterator iterator = collection.iterator();
        boolean bl = false;
        while (iterator.hasNext()) {
            bl |= b.super.a(iterator.next(), false);
        }
        if (bl) {
            b.super.a((List<T>)new ArrayList(collection));
        }
        return bl;
    }

    public void c() {
        this.b.clear();
        this.c.clear();
        for (int i2 = -1 + this.d.size(); i2 >= 0; --i2) {
            ((a)this.d.get(i2)).h_();
        }
    }

    public final boolean c(a a2) {
        return this.d.contains((Object)a2);
    }

    public boolean c(T t2) {
        this.c.remove(t2);
        return b.super.b(t2, true);
    }

    public final boolean c(Collection<T> collection) {
        Iterator iterator = collection.iterator();
        boolean bl = false;
        while (iterator.hasNext()) {
            bl |= b.super.b(iterator.next(), false);
        }
        if (bl) {
            Iterator iterator2 = this.c.iterator();
            while (iterator2.hasNext()) {
                Object object = iterator2.next();
                if (this.b.contains(object)) continue;
                iterator2.remove();
            }
            b.super.b((List<T>)new ArrayList(collection));
        }
        return bl;
    }

    public final Iterator<T> d() {
        return this.b.iterator();
    }

    public static interface a<T> {
        public void a(List<T> var1);

        public void b(List<T> var1);

        public void h_();
    }

}

