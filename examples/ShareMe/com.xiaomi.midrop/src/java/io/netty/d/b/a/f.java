/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.b.a.a
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.logging.Level
 *  java.util.logging.LogRecord
 *  java.util.logging.Logger
 */
package io.netty.d.b.a;

import io.netty.d.b.a.a;
import io.netty.d.b.a.b;
import io.netty.d.b.a.j;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

class f
extends a {
    static final String c = "io.netty.d.b.a.f";
    static final String d = a.class.getName();
    private static final long serialVersionUID = -1767272577989225979L;
    final transient Logger b;

    f(Logger logger) {
        super(logger.getName());
        this.b = logger;
    }

    private void a(String string2, Level level, String string3, Throwable throwable) {
        LogRecord logRecord = new LogRecord(level, string3);
        logRecord.setLoggerName(this.a);
        logRecord.setThrown(throwable);
        f.a(string2, logRecord);
        this.b.log(logRecord);
    }

    private static void a(String string2, LogRecord logRecord) {
        int n2;
        StackTraceElement[] arrstackTraceElement;
        block5 : {
            block4 : {
                arrstackTraceElement = new Throwable().getStackTrace();
                for (n2 = 0; n2 < arrstackTraceElement.length; ++n2) {
                    String string3 = arrstackTraceElement[n2].getClassName();
                    if (!string3.equals((Object)string2) && !string3.equals((Object)d)) {
                        continue;
                    }
                    break block4;
                }
                n2 = -1;
            }
            while (++n2 < arrstackTraceElement.length) {
                String string4 = arrstackTraceElement[n2].getClassName();
                if (string4.equals((Object)string2) || string4.equals((Object)d)) continue;
                break block5;
            }
            n2 = -1;
        }
        if (n2 != -1) {
            StackTraceElement stackTraceElement = arrstackTraceElement[n2];
            logRecord.setSourceClassName(stackTraceElement.getClassName());
            logRecord.setSourceMethodName(stackTraceElement.getMethodName());
        }
    }

    public final void a(String string2) {
        if (this.b.isLoggable(Level.FINEST)) {
            f.super.a(c, Level.FINEST, string2, null);
        }
    }

    public final void a(String string2, Object object) {
        if (this.b.isLoggable(Level.FINEST)) {
            b b2 = j.a(string2, object);
            f.super.a(c, Level.FINEST, b2.a, b2.b);
        }
    }

    public final void a(String string2, Object object, Object object2) {
        if (this.b.isLoggable(Level.FINEST)) {
            b b2 = j.a(string2, object, object2);
            f.super.a(c, Level.FINEST, b2.a, b2.b);
        }
    }

    public final void a(String string2, Throwable throwable) {
        if (this.b.isLoggable(Level.FINEST)) {
            f.super.a(c, Level.FINEST, string2, throwable);
        }
    }

    public final /* varargs */ void a(String string2, Object ... arrobject) {
        if (this.b.isLoggable(Level.FINE)) {
            b b2 = j.a(string2, arrobject);
            f.super.a(c, Level.FINE, b2.a, b2.b);
        }
    }

    public final boolean a() {
        return this.b.isLoggable(Level.FINEST);
    }

    public final void b(String string2) {
        if (this.b.isLoggable(Level.FINE)) {
            f.super.a(c, Level.FINE, string2, null);
        }
    }

    public final void b(String string2, Object object) {
        if (this.b.isLoggable(Level.FINE)) {
            b b2 = j.a(string2, object);
            f.super.a(c, Level.FINE, b2.a, b2.b);
        }
    }

    public final void b(String string2, Object object, Object object2) {
        if (this.b.isLoggable(Level.FINE)) {
            b b2 = j.a(string2, object, object2);
            f.super.a(c, Level.FINE, b2.a, b2.b);
        }
    }

    public final void b(String string2, Throwable throwable) {
        if (this.b.isLoggable(Level.FINE)) {
            f.super.a(c, Level.FINE, string2, throwable);
        }
    }

    public final /* varargs */ void b(String string2, Object ... arrobject) {
        if (this.b.isLoggable(Level.WARNING)) {
            b b2 = j.a(string2, arrobject);
            f.super.a(c, Level.WARNING, b2.a, b2.b);
        }
    }

    public final boolean b() {
        return this.b.isLoggable(Level.FINE);
    }

    public final void c(String string2) {
        if (this.b.isLoggable(Level.INFO)) {
            f.super.a(c, Level.INFO, string2, null);
        }
    }

    public final void c(String string2, Object object) {
        if (this.b.isLoggable(Level.WARNING)) {
            b b2 = j.a(string2, object);
            f.super.a(c, Level.WARNING, b2.a, b2.b);
        }
    }

    public final void c(String string2, Object object, Object object2) {
        if (this.b.isLoggable(Level.WARNING)) {
            b b2 = j.a(string2, object, object2);
            f.super.a(c, Level.WARNING, b2.a, b2.b);
        }
    }

    public final void c(String string2, Throwable throwable) {
        if (this.b.isLoggable(Level.INFO)) {
            f.super.a(c, Level.INFO, string2, throwable);
        }
    }

    public final /* varargs */ void c(String string2, Object ... arrobject) {
        if (this.b.isLoggable(Level.SEVERE)) {
            b b2 = j.a(string2, arrobject);
            f.super.a(c, Level.SEVERE, b2.a, b2.b);
        }
    }

    public final boolean c() {
        return this.b.isLoggable(Level.INFO);
    }

    public final void d(String string2) {
        if (this.b.isLoggable(Level.WARNING)) {
            f.super.a(c, Level.WARNING, string2, null);
        }
    }

    public final void d(String string2, Object object) {
        if (this.b.isLoggable(Level.SEVERE)) {
            b b2 = j.a(string2, object);
            f.super.a(c, Level.SEVERE, b2.a, b2.b);
        }
    }

    public final void d(String string2, Object object, Object object2) {
        if (this.b.isLoggable(Level.SEVERE)) {
            b b2 = j.a(string2, object, object2);
            f.super.a(c, Level.SEVERE, b2.a, b2.b);
        }
    }

    public final void d(String string2, Throwable throwable) {
        if (this.b.isLoggable(Level.WARNING)) {
            f.super.a(c, Level.WARNING, string2, throwable);
        }
    }

    public final boolean d() {
        return this.b.isLoggable(Level.WARNING);
    }

    public final void e(String string2) {
        if (this.b.isLoggable(Level.SEVERE)) {
            f.super.a(c, Level.SEVERE, string2, null);
        }
    }

    public final void e(String string2, Throwable throwable) {
        if (this.b.isLoggable(Level.SEVERE)) {
            f.super.a(c, Level.SEVERE, string2, throwable);
        }
    }

    public final boolean e() {
        return this.b.isLoggable(Level.SEVERE);
    }
}

