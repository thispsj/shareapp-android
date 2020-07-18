/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package a.e.b;

import a.e.b.c;
import a.e.b.d;
import a.e.b.g;
import java.io.Serializable;

public abstract class e<R>
implements c<R>,
Serializable {
    private final int a;

    public e(int n2) {
        this.a = n2;
    }

    @Override
    public final int c() {
        return this.a;
    }

    public String toString() {
        String string = g.a(this);
        d.a((Object)string, "Reflection.renderLambdaToString(this)");
        return string;
    }
}

