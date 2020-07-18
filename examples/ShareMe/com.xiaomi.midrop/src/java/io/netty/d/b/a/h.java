/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.b.a.a
 *  java.lang.NoSuchMethodError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  org.apache.log4j.Level
 *  org.apache.log4j.Logger
 *  org.apache.log4j.Priority
 */
package io.netty.d.b.a;

import io.netty.d.b.a.a;
import io.netty.d.b.a.b;
import io.netty.d.b.a.j;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

class h
extends a {
    static final String c = "io.netty.d.b.a.h";
    private static final long serialVersionUID = 2851357342488183058L;
    final transient Logger b;
    final boolean d;

    h(Logger logger) {
        super(logger.getName());
        this.b = logger;
        this.d = h.super.f();
    }

    private boolean f() {
        try {
            this.b.isTraceEnabled();
            return true;
        }
        catch (NoSuchMethodError noSuchMethodError) {
            return false;
        }
    }

    public final void a(String string2) {
        Logger logger = this.b;
        String string3 = c;
        Level level = this.d ? Level.TRACE : Level.DEBUG;
        logger.log(string3, (Priority)level, (Object)string2, null);
    }

    public final void a(String string2, Object object) {
        if (this.a()) {
            b b2 = j.a(string2, object);
            Logger logger = this.b;
            String string3 = c;
            Level level = this.d ? Level.TRACE : Level.DEBUG;
            logger.log(string3, (Priority)level, (Object)b2.a, b2.b);
        }
    }

    public final void a(String string2, Object object, Object object2) {
        if (this.a()) {
            b b2 = j.a(string2, object, object2);
            Logger logger = this.b;
            String string3 = c;
            Level level = this.d ? Level.TRACE : Level.DEBUG;
            logger.log(string3, (Priority)level, (Object)b2.a, b2.b);
        }
    }

    public final void a(String string2, Throwable throwable) {
        Logger logger = this.b;
        String string3 = c;
        Level level = this.d ? Level.TRACE : Level.DEBUG;
        logger.log(string3, (Priority)level, (Object)string2, throwable);
    }

    public final /* varargs */ void a(String string2, Object ... arrobject) {
        if (this.b.isDebugEnabled()) {
            b b2 = j.a(string2, arrobject);
            this.b.log(c, (Priority)Level.DEBUG, (Object)b2.a, b2.b);
        }
    }

    public final boolean a() {
        if (this.d) {
            return this.b.isTraceEnabled();
        }
        return this.b.isDebugEnabled();
    }

    public final void b(String string2) {
        this.b.log(c, (Priority)Level.DEBUG, (Object)string2, null);
    }

    public final void b(String string2, Object object) {
        if (this.b.isDebugEnabled()) {
            b b2 = j.a(string2, object);
            this.b.log(c, (Priority)Level.DEBUG, (Object)b2.a, b2.b);
        }
    }

    public final void b(String string2, Object object, Object object2) {
        if (this.b.isDebugEnabled()) {
            b b2 = j.a(string2, object, object2);
            this.b.log(c, (Priority)Level.DEBUG, (Object)b2.a, b2.b);
        }
    }

    public final void b(String string2, Throwable throwable) {
        this.b.log(c, (Priority)Level.DEBUG, (Object)string2, throwable);
    }

    public final /* varargs */ void b(String string2, Object ... arrobject) {
        if (this.b.isEnabledFor((Priority)Level.WARN)) {
            b b2 = j.a(string2, arrobject);
            this.b.log(c, (Priority)Level.WARN, (Object)b2.a, b2.b);
        }
    }

    public final boolean b() {
        return this.b.isDebugEnabled();
    }

    public final void c(String string2) {
        this.b.log(c, (Priority)Level.INFO, (Object)string2, null);
    }

    public final void c(String string2, Object object) {
        if (this.b.isEnabledFor((Priority)Level.WARN)) {
            b b2 = j.a(string2, object);
            this.b.log(c, (Priority)Level.WARN, (Object)b2.a, b2.b);
        }
    }

    public final void c(String string2, Object object, Object object2) {
        if (this.b.isEnabledFor((Priority)Level.WARN)) {
            b b2 = j.a(string2, object, object2);
            this.b.log(c, (Priority)Level.WARN, (Object)b2.a, b2.b);
        }
    }

    public final void c(String string2, Throwable throwable) {
        this.b.log(c, (Priority)Level.INFO, (Object)string2, throwable);
    }

    public final /* varargs */ void c(String string2, Object ... arrobject) {
        if (this.b.isEnabledFor((Priority)Level.ERROR)) {
            b b2 = j.a(string2, arrobject);
            this.b.log(c, (Priority)Level.ERROR, (Object)b2.a, b2.b);
        }
    }

    public final boolean c() {
        return this.b.isInfoEnabled();
    }

    public final void d(String string2) {
        this.b.log(c, (Priority)Level.WARN, (Object)string2, null);
    }

    public final void d(String string2, Object object) {
        if (this.b.isEnabledFor((Priority)Level.ERROR)) {
            b b2 = j.a(string2, object);
            this.b.log(c, (Priority)Level.ERROR, (Object)b2.a, b2.b);
        }
    }

    public final void d(String string2, Object object, Object object2) {
        if (this.b.isEnabledFor((Priority)Level.ERROR)) {
            b b2 = j.a(string2, object, object2);
            this.b.log(c, (Priority)Level.ERROR, (Object)b2.a, b2.b);
        }
    }

    public final void d(String string2, Throwable throwable) {
        this.b.log(c, (Priority)Level.WARN, (Object)string2, throwable);
    }

    public final boolean d() {
        return this.b.isEnabledFor((Priority)Level.WARN);
    }

    public final void e(String string2) {
        this.b.log(c, (Priority)Level.ERROR, (Object)string2, null);
    }

    public final void e(String string2, Throwable throwable) {
        this.b.log(c, (Priority)Level.ERROR, (Object)string2, throwable);
    }

    public final boolean e() {
        return this.b.isEnabledFor((Priority)Level.ERROR);
    }
}

