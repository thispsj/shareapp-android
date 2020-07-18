/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.sql.Date
 *  java.text.DateFormat
 *  java.text.ParseException
 *  java.text.SimpleDateFormat
 *  java.util.Date
 */
package com.google.a.b.a;

import com.google.a.d.a;
import com.google.a.d.b;
import com.google.a.d.c;
import com.google.a.e;
import com.google.a.p;
import com.google.a.r;
import com.google.a.s;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class j
extends r<Date> {
    public static final s a = new s(){

        @Override
        public final <T> r<T> a(e e2, com.google.a.c.a<T> a2) {
            if (a2.a == Date.class) {
                return new j();
            }
            return null;
        }
    };
    private final DateFormat b = new SimpleDateFormat("MMM d, yyyy");

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    private void a(c c2, Date date) throws IOException {
        void var6_3 = this;
        synchronized (var6_3) {
            String string2 = date == null ? null : this.b.format((java.util.Date)date);
            c2.b(string2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Date b(a a2) throws IOException {
        void var5_2 = this;
        synchronized (var5_2) {
            if (a2.f() == b.i) {
                a2.k();
                return null;
            }
            try {
                return new Date(this.b.parse(a2.i()).getTime());
            }
            catch (ParseException parseException) {
                throw new p(parseException);
            }
        }
    }

    @Override
    public final /* synthetic */ Object a(a a2) throws IOException {
        return j.super.b(a2);
    }

}

