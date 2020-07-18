/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.NoSuchElementException
 */
package a.a;

import a.a.f;
import a.a.o;
import a.a.r;
import a.e.b.d;
import a.i.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class p
extends o {
    public static final <T, A extends Appendable> A a(Iterable<? extends T> iterable, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
        d.b(iterable, "receiver$0");
        d.b(a2, "buffer");
        d.b((Object)charSequence, "separator");
        d.b((Object)charSequence2, "prefix");
        d.b((Object)charSequence3, "postfix");
        d.b((Object)charSequence4, "truncated");
        a2.append(charSequence2);
        Iterator iterator = iterable.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (++n2 > 1) {
                a2.append(charSequence);
            }
            g.a(a2, object);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final <T> T a(List<? extends T> list) {
        d.b(list, "receiver$0");
        if (list.isEmpty()) {
            throw (Throwable)new NoSuchElementException("List is empty.");
        }
        return (T)list.get(0);
    }

    public static /* synthetic */ String a(Iterable iterable, CharSequence charSequence) {
        CharSequence charSequence2 = "";
        CharSequence charSequence3 = "";
        CharSequence charSequence4 = "...";
        d.b((Object)iterable, "receiver$0");
        d.b((Object)charSequence, "separator");
        d.b((Object)charSequence2, "prefix");
        d.b((Object)charSequence3, "postfix");
        d.b((Object)charSequence4, "truncated");
        String string = ((StringBuilder)f.a(iterable, (Appendable)new StringBuilder(), charSequence, charSequence2, charSequence3, charSequence4)).toString();
        d.a((Object)string, "joinTo(StringBuilder(), \u2026ed, transform).toString()");
        return string;
    }

    public static final <T, C extends Collection<? super T>> C a(Iterable<? extends T> iterable, C c2) {
        d.b(iterable, "receiver$0");
        d.b(c2, "destination");
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            c2.add(iterator.next());
        }
        return c2;
    }

    public static final <T> List<T> a(Collection<? extends T> collection) {
        d.b(collection, "receiver$0");
        return (List)new ArrayList(collection);
    }

    public static final <T> List<T> b(Iterable<? extends T> iterable) {
        d.b(iterable, "receiver$0");
        boolean bl = iterable instanceof Collection;
        if (bl) {
            Collection collection = (Collection)iterable;
            switch (collection.size()) {
                default: {
                    return f.a(collection);
                }
                case 1: {
                    Object object = iterable instanceof List ? ((List)iterable).get(0) : iterable.iterator().next();
                    return f.a(object);
                }
                case 0: 
            }
            return r.a;
        }
        d.b(iterable, "receiver$0");
        List list = bl ? f.a((Collection)iterable) : (List)f.a(iterable, (Collection)new ArrayList());
        d.b(list, "receiver$0");
        switch (list.size()) {
            default: {
                return list;
            }
            case 1: {
                return f.a(list.get(0));
            }
            case 0: 
        }
        return r.a;
    }
}

