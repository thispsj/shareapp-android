/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Throwable
 *  java.util.NoSuchElementException
 */
package a.f;

import a.a.s;
import java.util.NoSuchElementException;

public final class b
extends s {
    private final int a;
    private boolean b;
    private int c;
    private final int d;

    /*
     * Enabled aggressive block sorting
     */
    public b(int n2, int n3, int n4) {
        boolean bl;
        block5 : {
            block6 : {
                block4 : {
                    this.d = n4;
                    this.a = n3;
                    if (this.d <= 0) break block4;
                    bl = false;
                    if (n2 > n3) break block5;
                    break block6;
                }
                bl = false;
                if (n2 < n3) break block5;
            }
            bl = true;
        }
        this.b = bl;
        if (!this.b) {
            n2 = this.a;
        }
        this.c = n2;
    }

    @Override
    public final int a() {
        int n2 = this.c;
        if (n2 == this.a) {
            if (!this.b) {
                throw (Throwable)new NoSuchElementException();
            }
            this.b = false;
            return n2;
        }
        this.c += this.d;
        return n2;
    }

    public final boolean hasNext() {
        return this.b;
    }
}

