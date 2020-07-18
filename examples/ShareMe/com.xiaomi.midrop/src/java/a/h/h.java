/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.util.Iterator
 */
package a.h;

import a.e.b.d;
import a.h.b;
import a.h.g;
import java.util.Iterator;

public class h
extends g {
    public static final <T, A extends Appendable> A a(b<? extends T> b2, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
        d.b(b2, "receiver$0");
        d.b(a2, "buffer");
        d.b((Object)charSequence, "separator");
        d.b((Object)charSequence2, "prefix");
        d.b((Object)charSequence3, "postfix");
        d.b((Object)charSequence4, "truncated");
        a2.append(charSequence2);
        Iterator<? extends T> iterator = b2.a();
        int n2 = 0;
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (++n2 > 1) {
                a2.append(charSequence);
            }
            a.i.g.a(a2, object);
        }
        a2.append(charSequence3);
        return a2;
    }
}

