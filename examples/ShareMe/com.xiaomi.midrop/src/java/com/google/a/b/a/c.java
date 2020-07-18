/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.text.DateFormat
 *  java.text.ParseException
 *  java.text.ParsePosition
 *  java.text.SimpleDateFormat
 *  java.util.ArrayList
 *  java.util.Date
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 */
package com.google.a.b.a;

import com.google.a.b.a.a.a;
import com.google.a.b.e;
import com.google.a.d.b;
import com.google.a.p;
import com.google.a.r;
import com.google.a.s;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class c
extends r<Date> {
    public static final s a = new s(){

        @Override
        public final <T> r<T> a(com.google.a.e e2, com.google.a.c.a<T> a2) {
            if (a2.a == Date.class) {
                return new c();
            }
            return null;
        }
    };
    private final List<DateFormat> b = new ArrayList();

    public c() {
        this.b.add((Object)DateFormat.getDateTimeInstance((int)2, (int)2, (Locale)Locale.US));
        if (!Locale.getDefault().equals((Object)Locale.US)) {
            this.b.add((Object)DateFormat.getDateTimeInstance((int)2, (int)2));
        }
        if (e.b()) {
            this.b.add((Object)new SimpleDateFormat("MMM d, yyyy h:mm:ss a", Locale.US));
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Date a(String string2) {
        void var9_2 = this;
        synchronized (var9_2) {
            Iterator iterator = this.b.iterator();
            if (iterator.hasNext()) {
                DateFormat dateFormat = (DateFormat)iterator.next();
                return dateFormat.parse(string2);
            }
            try {
                return a.a(string2, new ParsePosition(0));
            }
            catch (ParseException parseException) {
                throw new p(string2, parseException);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    private void a(com.google.a.d.c c2, Date date) throws IOException {
        void var6_3 = this;
        synchronized (var6_3) {
            Throwable throwable2;
            if (date == null) {
                try {
                    c2.e();
                    return;
                }
                catch (Throwable throwable2) {}
            } else {
                c2.b(((DateFormat)this.b.get(0)).format(date));
                return;
            }
            throw throwable2;
        }
    }

    @Override
    public final /* synthetic */ Object a(com.google.a.d.a a2) throws IOException {
        if (a2.f() == b.i) {
            a2.k();
            return null;
        }
        return c.super.a(a2.i());
    }

}

