/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.a.a.a.a.b.p
 *  io.a.a.a.a.c.a
 *  io.a.a.a.a.c.a$4
 *  io.a.a.a.a.c.a$d
 *  io.a.a.a.a.c.a$e
 *  io.a.a.a.a.c.d
 *  io.a.a.a.a.c.f
 *  io.a.a.a.a.c.f$a
 *  io.a.a.a.h
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Comparable
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.lang.annotation.Annotation
 *  java.util.concurrent.Executor
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.FutureTask
 */
package io.a.a.a;

import android.content.Context;
import io.a.a.a.a.b.p;
import io.a.a.a.a.c.a;
import io.a.a.a.a.c.d;
import io.a.a.a.a.c.f;
import io.a.a.a.c;
import io.a.a.a.h;
import java.io.File;
import java.lang.annotation.Annotation;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

public abstract class i<Result>
implements Comparable<i> {
    public c f;
    protected h<Result> g = new h(this);
    public Context h;
    io.a.a.a.f<Result> i;
    protected p j;
    final d k = (d)this.getClass().getAnnotation(d.class);

    private boolean a(i i2) {
        if (i.super.e()) {
            Class[] arrclass = this.k.a();
            int n2 = arrclass.length;
            for (int i3 = 0; i3 < n2; ++i3) {
                if (!arrclass[i3].isAssignableFrom(i2.getClass())) continue;
                return true;
            }
        }
        return false;
    }

    private boolean e() {
        return this.k != null;
    }

    public abstract String a();

    final void a(Context context, c c2, io.a.a.a.f<Result> f2, p p2) {
        this.f = c2;
        this.h = new io.a.a.a.d(context, this.b(), this.j());
        this.i = f2;
        this.j = p2;
    }

    public abstract String b();

    public boolean b_() {
        return true;
    }

    public /* synthetic */ int compareTo(Object object) {
        i i2 = (i)object;
        if (i.super.a(i2)) {
            return 1;
        }
        if (i2.a((i)this)) {
            return -1;
        }
        if (i.super.e() && !i2.e()) {
            return 1;
        }
        if (!i.super.e() && i2.e()) {
            return -1;
        }
        return 0;
    }

    public abstract Result d();

    final void i() {
        h<Result> h2 = this.g;
        ExecutorService executorService = this.f.c;
        Void[] arrvoid = new Void[]{null};
        f.a a2 = new f.a((Executor)executorService, h2);
        if (h2.f != a.d.a) {
            switch (a.4.a[h2.f - 1]) {
                default: {
                    break;
                }
                case 2: {
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                }
                case 1: {
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                }
            }
        }
        h2.f = a.d.b;
        h2.b();
        h2.d.b = arrvoid;
        a2.execute((Runnable)h2.e);
    }

    public final String j() {
        StringBuilder stringBuilder = new StringBuilder(".Fabric");
        stringBuilder.append(File.separator);
        stringBuilder.append(this.b());
        return stringBuilder.toString();
    }
}

