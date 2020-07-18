/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.String
 */
package a.i;

import a.e.b.d;
import a.i.k;

public class l
extends k {
    public static final <T> void a(Appendable appendable, T t2) {
        d.b((Object)appendable, "receiver$0");
        boolean bl = t2 != null ? t2 instanceof CharSequence : true;
        if (bl) {
            appendable.append((CharSequence)t2);
            return;
        }
        if (t2 instanceof Character) {
            appendable.append(((Character)t2).charValue());
            return;
        }
        appendable.append((CharSequence)String.valueOf(t2));
    }
}

