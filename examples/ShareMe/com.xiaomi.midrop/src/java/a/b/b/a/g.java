/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package a.b.b.a;

import a.b.b.a.a;
import a.b.b.a.c;
import a.e.b.d;

public abstract class g
extends c
implements a.e.b.c<Object> {
    private final int a = 2;

    public g(a.b.c<Object> c2) {
        super(c2);
    }

    @Override
    public final int c() {
        return this.a;
    }

    @Override
    public String toString() {
        if (this.h == null) {
            String string = a.e.b.g.a(this);
            d.a((Object)string, "Reflection.renderLambdaToString(this)");
            return string;
        }
        return super.toString();
    }
}

