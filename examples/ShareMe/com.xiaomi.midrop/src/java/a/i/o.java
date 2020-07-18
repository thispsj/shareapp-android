/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.Iterator
 */
package a.i;

import a.a.s;
import a.e.b.d;
import a.h.b;
import a.h.c;
import a.h.i;
import a.i.a;
import a.i.g;
import a.i.n;
import a.i.p;
import java.util.Collection;
import java.util.Iterator;

public class o
extends n {
    public static /* synthetic */ String a(String string, String string2, String string3) {
        d.b(string, "receiver$0");
        d.b(string2, "oldValue");
        d.b(string3, "newValue");
        CharSequence charSequence = string;
        String[] arrstring = new String[]{string2};
        d.b((Object)charSequence, "receiver$0");
        d.b(arrstring, "delimiters");
        b b2 = p.a(charSequence, arrstring);
        a.e.a.b b3 = new a.e.a.b<a.f.c, String>(charSequence){
            final /* synthetic */ CharSequence a;
            {
                this.a = charSequence;
                super(1);
            }

            public final /* synthetic */ Object a(Object object) {
                a.f.c c2 = (a.f.c)object;
                d.b(c2, "it");
                return g.a(this.a, c2);
            }
        };
        d.b(b2, "receiver$0");
        d.b(b3, "transform");
        b b4 = new i(b2, b3);
        CharSequence charSequence2 = string3;
        CharSequence charSequence3 = "";
        CharSequence charSequence4 = "";
        CharSequence charSequence5 = "...";
        d.b(b4, "receiver$0");
        d.b((Object)charSequence2, "separator");
        d.b((Object)charSequence3, "prefix");
        d.b((Object)charSequence4, "postfix");
        d.b((Object)charSequence5, "truncated");
        String string4 = ((StringBuilder)c.a(b4, (Appendable)new StringBuilder(), charSequence2, charSequence3, charSequence4, charSequence5)).toString();
        d.a((Object)string4, "joinTo(StringBuilder(), \u2026ed, transform).toString()");
        return string4;
    }

    public static final boolean a(CharSequence charSequence) {
        d.b((Object)charSequence, "receiver$0");
        if (charSequence.length() != 0) {
            boolean bl;
            d.b((Object)charSequence, "receiver$0");
            Iterable iterable = new a.f.c(0, charSequence.length() - 1);
            if (!(iterable instanceof Collection) || !((Collection)iterable).isEmpty()) {
                Iterator iterator = iterable.iterator();
                while (iterator.hasNext()) {
                    if (a.a(charSequence.charAt(((s)iterator).a()))) continue;
                    bl = false;
                    break;
                }
            } else {
                bl = true;
            }
            return bl;
        }
        return true;
    }

    public static final boolean a(String string, String string2, int n2, int n3, boolean bl) {
        d.b(string, "receiver$0");
        d.b(string2, "other");
        if (!bl) {
            return string.regionMatches(0, string2, n2, n3);
        }
        return string.regionMatches(bl, 0, string2, n2, n3);
    }

    public static /* synthetic */ String b(String string, String string2, String string3) {
        d.b(string, "receiver$0");
        d.b(string2, "oldValue");
        d.b(string3, "newValue");
        CharSequence charSequence = string;
        int n2 = g.a(charSequence, string2, 0, 2);
        if (n2 < 0) {
            return string;
        }
        int n3 = n2 + string2.length();
        CharSequence charSequence2 = string3;
        d.b((Object)charSequence, "receiver$0");
        d.b((Object)charSequence2, "replacement");
        if (n3 < n2) {
            StringBuilder stringBuilder = new StringBuilder("End index (");
            stringBuilder.append(n3);
            stringBuilder.append(") is less than start index (");
            stringBuilder.append(n2);
            stringBuilder.append(").");
            throw (Throwable)new IndexOutOfBoundsException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(charSequence, 0, n2);
        stringBuilder.append(charSequence2);
        stringBuilder.append(charSequence, n3, charSequence.length());
        return ((CharSequence)stringBuilder).toString();
    }
}

