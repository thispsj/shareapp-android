/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.BufferedReader
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 */
package a.d;

import a.d.c;
import a.e.b.d;
import a.h.b;
import java.io.BufferedReader;
import java.util.Iterator;

public final class c
implements b<String> {
    final BufferedReader a;

    public c(BufferedReader bufferedReader) {
        d.b((Object)bufferedReader, "reader");
        this.a = bufferedReader;
    }

    @Override
    public final Iterator<String> a() {
        return (Iterator)new Iterator<String>(this){
            final /* synthetic */ c a;
            private String b;
            private boolean c;
            {
                this.a = c2;
            }

            public final boolean hasNext() {
                if (this.b == null && !this.c) {
                    this.b = this.a.a.readLine();
                    if (this.b == null) {
                        this.c = true;
                    }
                }
                return this.b != null;
            }

            public final /* synthetic */ Object next() {
                if (!this.hasNext()) {
                    throw (java.lang.Throwable)new java.util.NoSuchElementException();
                }
                String string2 = this.b;
                this.b = null;
                if (string2 == null) {
                    d.a();
                }
                return string2;
            }

            public final void remove() {
                throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        };
    }
}

