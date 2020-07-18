/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.google.a;

import com.google.a.b.h;
import com.google.a.i;
import com.google.a.k;

public final class l
extends i {
    public final h<String, i> a = new h();

    public final void a(String string2, i i2) {
        if (i2 == null) {
            i2 = k.a;
        }
        this.a.put(string2, i2);
    }

    public final boolean equals(Object object) {
        return object == this || object instanceof l && ((l)object).a.equals(this.a);
        {
        }
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}

