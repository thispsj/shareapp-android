/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  e.a.a
 *  java.io.IOException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  okhttp3.a.a
 *  okhttp3.a.a$a
 *  okhttp3.a.a$b
 *  okhttp3.ac
 *  okhttp3.u
 *  okhttp3.u$a
 */
package com.xiaomi.globalmiuiapp.common.http;

import android.util.Log;
import java.io.IOException;
import okhttp3.a.a;
import okhttp3.ac;
import okhttp3.u;

public final class a
implements u {
    final String a;
    private final okhttp3.a.a b;

    public a() {
        this("XMOKHttpHelper");
    }

    public a(String string2) {
        this.a = string2;
        this.b = new okhttp3.a.a(new a.b(){

            public final void a(String string2) {
                int n2 = string2.length();
                int n3 = 0;
                block0 : while (n3 < n2) {
                    int n4 = string2.indexOf(10, n3);
                    if (n4 == -1) {
                        n4 = n2;
                    }
                    do {
                        int n5 = Math.min((int)n4, (int)(n3 + 400));
                        e.a.a.a((String)a.this.a);
                        e.a.a.d((String)string2.substring(n3, n5), (Object[])new Object[0]);
                        if (n5 >= n4) {
                            n3 = n5 + 1;
                            continue block0;
                        }
                        n3 = n5;
                    } while (true);
                }
            }
        });
    }

    public final ac a(u.a a2) throws IOException {
        okhttp3.a.a a3 = this.b;
        int n2 = !com.xiaomi.globalmiuiapp.common.a.a.a.c && !Log.isLoggable((String)this.a, (int)2) ? a.a.a : a.a.d;
        if (n2 == 0) {
            throw new NullPointerException("level == null. Use Level.NONE instead.");
        }
        a3.a = n2;
        return this.b.a(a2);
    }

}

