/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.b.a.a
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  org.slf4j.Logger
 */
package io.netty.d.b.a;

import io.netty.d.b.a.a;
import org.slf4j.Logger;

final class k
extends a {
    private static final long serialVersionUID = 108038972685130825L;
    private final transient Logger b;

    k(Logger logger) {
        super(logger.getName());
        this.b = logger;
    }

    public final void a(String string2) {
        this.b.trace(string2);
    }

    public final void a(String string2, Object object) {
        this.b.trace(string2, object);
    }

    public final void a(String string2, Object object, Object object2) {
        this.b.trace(string2, object, object2);
    }

    public final void a(String string2, Throwable throwable) {
        this.b.trace(string2, throwable);
    }

    public final /* varargs */ void a(String string2, Object ... arrobject) {
        this.b.debug(string2, arrobject);
    }

    public final boolean a() {
        return this.b.isTraceEnabled();
    }

    public final void b(String string2) {
        this.b.debug(string2);
    }

    public final void b(String string2, Object object) {
        this.b.debug(string2, object);
    }

    public final void b(String string2, Object object, Object object2) {
        this.b.debug(string2, object, object2);
    }

    public final void b(String string2, Throwable throwable) {
        this.b.debug(string2, throwable);
    }

    public final /* varargs */ void b(String string2, Object ... arrobject) {
        this.b.warn(string2, arrobject);
    }

    public final boolean b() {
        return this.b.isDebugEnabled();
    }

    public final void c(String string2) {
        this.b.info(string2);
    }

    public final void c(String string2, Object object) {
        this.b.warn(string2, object);
    }

    public final void c(String string2, Object object, Object object2) {
        this.b.warn(string2, object, object2);
    }

    public final void c(String string2, Throwable throwable) {
        this.b.info(string2, throwable);
    }

    public final /* varargs */ void c(String string2, Object ... arrobject) {
        this.b.error(string2, arrobject);
    }

    public final boolean c() {
        return this.b.isInfoEnabled();
    }

    public final void d(String string2) {
        this.b.warn(string2);
    }

    public final void d(String string2, Object object) {
        this.b.error(string2, object);
    }

    public final void d(String string2, Object object, Object object2) {
        this.b.error(string2, object, object2);
    }

    public final void d(String string2, Throwable throwable) {
        this.b.warn(string2, throwable);
    }

    public final boolean d() {
        return this.b.isWarnEnabled();
    }

    public final void e(String string2) {
        this.b.error(string2);
    }

    public final void e(String string2, Throwable throwable) {
        this.b.error(string2, throwable);
    }

    public final boolean e() {
        return this.b.isErrorEnabled();
    }
}

