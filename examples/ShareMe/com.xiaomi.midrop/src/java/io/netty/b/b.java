/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.b.ac
 *  io.netty.b.b$b
 *  io.netty.b.b$c
 *  io.netty.b.d
 *  io.netty.b.h
 *  io.netty.b.l
 *  io.netty.b.m
 *  io.netty.b.s
 *  io.netty.d.a.j
 *  io.netty.d.e
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.SocketAddress
 *  java.util.concurrent.atomic.AtomicIntegerFieldUpdater
 */
package io.netty.b;

import io.netty.b.a;
import io.netty.b.ac;
import io.netty.b.ad;
import io.netty.b.ah;
import io.netty.b.ak;
import io.netty.b.as;
import io.netty.b.b;
import io.netty.b.d;
import io.netty.b.e;
import io.netty.b.h;
import io.netty.b.j;
import io.netty.b.l;
import io.netty.b.m;
import io.netty.b.r;
import io.netty.b.s;
import io.netty.b.t;
import io.netty.b.x;
import io.netty.buffer.ByteBufAllocator;
import io.netty.d.b.p;
import io.netty.d.b.u;
import io.netty.d.b.w;
import io.netty.d.j;
import io.netty.d.k;
import java.net.SocketAddress;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/*
 * Exception performing whole class analysis ignored.
 */
public abstract class b
extends io.netty.d.e
implements l {
    static final /* synthetic */ boolean g = true;
    private static final AtomicIntegerFieldUpdater<b> h = AtomicIntegerFieldUpdater.newUpdater(b.class, (String)"f");
    volatile b a;
    volatile b b;
    final ac c;
    final String d;
    final io.netty.d.a.j e;
    volatile int f = 0;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private Runnable l;
    private Runnable m;
    private Runnable n;
    private Runnable o;

    static {
    }

    b(ac ac2, String string2, boolean bl, boolean bl2) {
        this.d = io.netty.d.b.l.a(string2, "name");
        this.c = ac2;
        this.e = null;
        this.i = bl;
        this.j = bl2;
        this.k = true;
    }

    private x A() {
        return new ad(this.c.d, this.d());
    }

    private b B() {
        b b2 = this;
        do {
            b2 = b2.a;
        } while (!b2.i);
        return b2;
    }

    private b C() {
        b b2 = this;
        do {
            b2 = b2.b;
        } while (!b2.j);
        return b2;
    }

    private boolean D() {
        int n2 = this.f;
        if (n2 != 2) {
            return !this.k && n2 == 1;
        }
        return true;
    }

    static void a(b b2) {
        io.netty.d.a.j j2 = b2.d();
        if (j2.g()) {
            b2.r();
            return;
        }
        j2.execute(new Runnable(b2){
            final /* synthetic */ b a;
            {
                this.a = b2;
            }

            public final void run() {
                b.g(this.a);
            }
        });
    }

    static /* synthetic */ void a(b b2, x x2) {
        b2.b(x2);
    }

    static void a(b b2, Object object) {
        io.netty.d.b.l.a(object, "event");
        io.netty.d.a.j j2 = b2.d();
        if (j2.g()) {
            b2.d(object);
            return;
        }
        j2.execute(new Runnable(b2, object){
            final /* synthetic */ b a;
            final /* synthetic */ Object b;
            {
                this.a = b2;
                this.b = object;
            }

            public final void run() {
                b.c(this.a, this.b);
            }
        });
    }

    static void a(b b2, Throwable throwable) {
        io.netty.d.b.l.a(throwable, "cause");
        io.netty.d.a.j j2 = b2.d();
        if (j2.g()) {
            b2.b(throwable);
            return;
        }
        try {
            j2.execute(new Runnable(b2, throwable){
                final /* synthetic */ b a;
                final /* synthetic */ Throwable b;
                {
                    this.a = b2;
                    this.b = throwable;
                }

                public final void run() {
                    b.b(this.a, this.b);
                }
            });
            return;
        }
        catch (Throwable throwable2) {
            if (ac.a.d()) {
                ac.a.d("Failed to submit an exceptionCaught() event.", throwable2);
                ac.a.d("The exceptionCaught() event that was failed to submit was:", throwable);
            }
            return;
        }
    }

    static /* synthetic */ void a(b b2, SocketAddress socketAddress, x x2) {
        b2.b(socketAddress, x2);
    }

    static /* synthetic */ void a(b b2, SocketAddress socketAddress, SocketAddress socketAddress2, x x2) {
        b2.b(socketAddress, socketAddress2, x2);
    }

    private static void a(io.netty.d.a.j j2, Runnable runnable, x x2, Object object) {
        try {
            j2.execute(runnable);
            return;
        }
        catch (Throwable throwable) {
            try {
                x2.a(throwable);
                return;
            }
            finally {
                if (object != null) {
                    k.a(object);
                }
            }
        }
    }

    private void a(Object object, boolean bl, x x2) {
        b b2 = b.super.C();
        io.netty.d.a.j j2 = b2.d();
        if (j2.g()) {
            if (bl) {
                if (b2.D()) {
                    b2.c(object, x2);
                    b2.z();
                    return;
                }
                b2.d(object, x2);
                return;
            }
            b2.b(object, x2);
            return;
        }
        Object object2 = bl ? b.b((b)b2, (Object)object, (x)x2) : c.b((b)b2, (Object)object, (x)x2);
        b.a(j2, (Runnable)object2, x2, object);
    }

    private static void a(Throwable throwable, x x2) {
        io.netty.d.b.a.d d2 = x2 instanceof as ? null : ac.a;
        p.a(x2, throwable, d2);
    }

    private boolean a(x x2, boolean bl) {
        if (x2 == null) {
            throw new NullPointerException("promise");
        }
        if (x2.isDone()) {
            if (x2.isCancelled()) {
                return true;
            }
            StringBuilder stringBuilder = new StringBuilder("promise already done: ");
            stringBuilder.append((Object)x2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (x2.e() != this.c.d) {
            Object[] arrobject = new Object[]{x2.e(), this.c.d};
            throw new IllegalArgumentException(String.format((String)"promise.channel does not match: %s (expected: %s)", (Object[])arrobject));
        }
        if (x2.getClass() == ad.class) {
            return false;
        }
        if (!bl && x2 instanceof as) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(io.netty.d.b.t.a(as.class));
            stringBuilder.append(" not allowed for this operation");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (x2 instanceof a.e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(io.netty.d.b.t.a(a.e.class));
            stringBuilder.append(" not allowed in a pipeline");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return false;
    }

    static void b(b b2) {
        io.netty.d.a.j j2 = b2.d();
        if (j2.g()) {
            b2.s();
            return;
        }
        j2.execute(new Runnable(b2){
            final /* synthetic */ b a;
            {
                this.a = b2;
            }

            public final void run() {
                b.h(this.a);
            }
        });
    }

    static void b(b b2, Object object) {
        io.netty.d.b.l.a(object, "msg");
        io.netty.d.a.j j2 = b2.d();
        if (j2.g()) {
            b2.e(object);
            return;
        }
        j2.execute(new Runnable(b2, object){
            final /* synthetic */ b a;
            final /* synthetic */ Object b;
            {
                this.a = b2;
                this.b = object;
            }

            public final void run() {
                b.d(this.a, this.b);
            }
        });
    }

    static /* synthetic */ void b(b b2, Throwable throwable) {
        b2.b(throwable);
    }

    private void b(x x2) {
        if (b.super.D()) {
            try {
                ((s)this.q()).a((l)this, x2);
                return;
            }
            catch (Throwable throwable) {
                b.a(throwable, x2);
                return;
            }
        }
        this.a(x2);
    }

    private void b(Object object, x x2) {
        if (b.super.D()) {
            b.super.c(object, x2);
            return;
        }
        this.a(object, x2);
    }

    private void b(Throwable throwable) {
        if (b.super.D()) {
            try {
                this.q().a((l)this, throwable);
                return;
            }
            catch (Throwable throwable2) {
                if (ac.a.b()) {
                    ac.a.b("An exception {}was thrown by a user handler's exceptionCaught() method while handling the following exception:", (Object)w.a(throwable2), (Object)throwable);
                    return;
                }
                if (ac.a.d()) {
                    ac.a.c("An exception '{}' [enable DEBUG level for full stacktrace] was thrown by a user handler's exceptionCaught() method while handling the following exception:", (Object)throwable2, (Object)throwable);
                }
                return;
            }
        }
        this.a(throwable);
    }

    private void b(SocketAddress socketAddress, x x2) {
        if (b.super.D()) {
            try {
                ((s)this.q()).a((l)this, socketAddress, x2);
                return;
            }
            catch (Throwable throwable) {
                b.a(throwable, x2);
                return;
            }
        }
        this.a(socketAddress, x2);
    }

    private void b(SocketAddress socketAddress, SocketAddress socketAddress2, x x2) {
        if (b.super.D()) {
            try {
                ((s)this.q()).a((l)this, socketAddress, socketAddress2, x2);
                return;
            }
            catch (Throwable throwable) {
                b.a(throwable, x2);
                return;
            }
        }
        this.a(socketAddress, socketAddress2, x2);
    }

    static void c(b b2) {
        io.netty.d.a.j j2 = b2.d();
        if (j2.g()) {
            b2.t();
            return;
        }
        j2.execute(new Runnable(b2){
            final /* synthetic */ b a;
            {
                this.a = b2;
            }

            public final void run() {
                b.i(this.a);
            }
        });
    }

    static /* synthetic */ void c(b b2, Object object) {
        b2.d(object);
    }

    private void c(Object object, x x2) {
        try {
            ((s)this.q()).a((l)this, object, x2);
            return;
        }
        catch (Throwable throwable) {
            b.a(throwable, x2);
            return;
        }
    }

    private void c(Throwable throwable) {
        boolean bl;
        Throwable throwable2 = throwable;
        block0 : do {
            StackTraceElement[] arrstackTraceElement;
            if ((arrstackTraceElement = throwable2.getStackTrace()) != null) {
                StackTraceElement stackTraceElement;
                int n2 = arrstackTraceElement.length;
                for (int i2 = 0; i2 < n2 && (stackTraceElement = arrstackTraceElement[i2]) != null; ++i2) {
                    if (!"exceptionCaught".equals((Object)stackTraceElement.getMethodName())) continue;
                    bl = true;
                    break block0;
                }
            }
            throwable2 = throwable2.getCause();
            bl = false;
        } while (throwable2 != null);
        if (bl) {
            if (ac.a.d()) {
                ac.a.d("An exception was thrown by a user handler while handling an exceptionCaught event", throwable);
            }
            return;
        }
        b.super.b(throwable);
    }

    private h d(Object object, x x2) {
        if (object == null) {
            throw new NullPointerException("msg");
        }
        if (b.super.a(x2, true)) {
            k.a(object);
            return x2;
        }
        b.super.a(object, true, x2);
        return x2;
    }

    static void d(b b2) {
        io.netty.d.a.j j2 = b2.d();
        if (j2.g()) {
            b2.u();
            return;
        }
        j2.execute(new Runnable(b2){
            final /* synthetic */ b a;
            {
                this.a = b2;
            }

            public final void run() {
                b.j(this.a);
            }
        });
    }

    static /* synthetic */ void d(b b2, Object object) {
        b2.e(object);
    }

    private void d(Object object) {
        if (b.super.D()) {
            try {
                ((m)this.q()).b((l)this, object);
                return;
            }
            catch (Throwable throwable) {
                b.super.c(throwable);
                return;
            }
        }
        this.a(object);
    }

    static void e(b b2) {
        io.netty.d.a.j j2 = b2.d();
        if (j2.g()) {
            b2.v();
            return;
        }
        Runnable runnable = b2.l;
        if (runnable == null) {
            b2.l = runnable = new Runnable(b2){
                final /* synthetic */ b a;
                {
                    this.a = b2;
                }

                public final void run() {
                    b.k(this.a);
                }
            };
        }
        j2.execute(runnable);
    }

    private void e(Object object) {
        if (b.super.D()) {
            try {
                ((m)this.q()).a((l)this, object);
                return;
            }
            catch (Throwable throwable) {
                b.super.c(throwable);
                return;
            }
        }
        this.b(object);
    }

    static void f(b b2) {
        io.netty.d.a.j j2 = b2.d();
        if (j2.g()) {
            b2.w();
            return;
        }
        Runnable runnable = b2.n;
        if (runnable == null) {
            b2.n = runnable = new Runnable(b2){
                final /* synthetic */ b a;
                {
                    this.a = b2;
                }

                public final void run() {
                    b.l(this.a);
                }
            };
        }
        j2.execute(runnable);
    }

    static /* synthetic */ void g(b b2) {
        b2.r();
    }

    static /* synthetic */ void h(b b2) {
        b2.s();
    }

    static /* synthetic */ void i(b b2) {
        b2.t();
    }

    static /* synthetic */ void j(b b2) {
        b2.u();
    }

    static /* synthetic */ void k(b b2) {
        b2.v();
    }

    static /* synthetic */ void l(b b2) {
        b2.w();
    }

    static /* synthetic */ void m(b b2) {
        b2.x();
    }

    static /* synthetic */ void n(b b2) {
        b2.y();
    }

    private void r() {
        if (this.D()) {
            try {
                ((m)this.q()).e((l)this);
                return;
            }
            catch (Throwable throwable) {
                this.c(throwable);
                return;
            }
        }
        this.e();
    }

    private void s() {
        if (this.D()) {
            try {
                ((m)this.q()).f((l)this);
                return;
            }
            catch (Throwable throwable) {
                this.c(throwable);
                return;
            }
        }
        this.f();
    }

    private void t() {
        if (this.D()) {
            try {
                ((m)this.q()).g((l)this);
                return;
            }
            catch (Throwable throwable) {
                this.c(throwable);
                return;
            }
        }
        this.g();
    }

    private void u() {
        if (this.D()) {
            try {
                ((m)this.q()).h((l)this);
                return;
            }
            catch (Throwable throwable) {
                this.c(throwable);
                return;
            }
        }
        this.h();
    }

    private void v() {
        if (this.D()) {
            try {
                ((m)this.q()).i((l)this);
                return;
            }
            catch (Throwable throwable) {
                this.c(throwable);
                return;
            }
        }
        this.i();
    }

    private void w() {
        if (this.D()) {
            try {
                ((m)this.q()).j((l)this);
                return;
            }
            catch (Throwable throwable) {
                this.c(throwable);
                return;
            }
        }
        this.j();
    }

    private void x() {
        if (this.D()) {
            try {
                ((s)this.q()).a((l)this);
                return;
            }
            catch (Throwable throwable) {
                this.c(throwable);
                return;
            }
        }
        this.l();
    }

    private void y() {
        if (this.D()) {
            this.z();
            return;
        }
        this.m();
    }

    private void z() {
        try {
            ((s)this.q()).b((l)this);
            return;
        }
        catch (Throwable throwable) {
            this.c(throwable);
            return;
        }
    }

    public final d a() {
        return this.c.d;
    }

    public final h a(x x2) {
        if (b.super.a(x2, false)) {
            return x2;
        }
        b b2 = b.super.C();
        io.netty.d.a.j j2 = b2.d();
        if (j2.g()) {
            b2.b(x2);
            return x2;
        }
        b.a(j2, new Runnable((b)this, b2, x2){
            final /* synthetic */ b a;
            final /* synthetic */ x b;
            final /* synthetic */ b c;
            {
                this.c = b2;
                this.a = b3;
                this.b = x2;
            }

            public final void run() {
                b.a(this.a, this.b);
            }
        }, x2, null);
        return x2;
    }

    public final h a(Object object, x x2) {
        block3 : {
            if (object == null) {
                throw new NullPointerException("msg");
            }
            try {
                if (!b.super.a(x2, true)) break block3;
                k.a(object);
                return x2;
            }
            catch (RuntimeException runtimeException) {
                k.a(object);
                throw runtimeException;
            }
        }
        b.super.a(object, false, x2);
        return x2;
    }

    public final h a(SocketAddress socketAddress, x x2) {
        if (socketAddress == null) {
            throw new NullPointerException("localAddress");
        }
        if (b.super.a(x2, false)) {
            return x2;
        }
        b b2 = b.super.C();
        io.netty.d.a.j j2 = b2.d();
        if (j2.g()) {
            b2.b(socketAddress, x2);
            return x2;
        }
        b.a(j2, new Runnable((b)this, b2, socketAddress, x2){
            final /* synthetic */ b a;
            final /* synthetic */ SocketAddress b;
            final /* synthetic */ x c;
            final /* synthetic */ b d;
            {
                this.d = b2;
                this.a = b3;
                this.b = socketAddress;
                this.c = x2;
            }

            public final void run() {
                b.a(this.a, this.b, this.c);
            }
        }, x2, null);
        return x2;
    }

    public final h a(SocketAddress socketAddress, SocketAddress socketAddress2, x x2) {
        if (socketAddress == null) {
            throw new NullPointerException("remoteAddress");
        }
        if (b.super.a(x2, false)) {
            return x2;
        }
        b b2 = b.super.C();
        io.netty.d.a.j j2 = b2.d();
        if (j2.g()) {
            b2.b(socketAddress, socketAddress2, x2);
            return x2;
        }
        Runnable runnable = new Runnable((b)this, b2, socketAddress, socketAddress2, x2){
            final /* synthetic */ b a;
            final /* synthetic */ SocketAddress b;
            final /* synthetic */ SocketAddress c;
            final /* synthetic */ x d;
            final /* synthetic */ b e;
            {
                this.e = b2;
                this.a = b3;
                this.b = socketAddress;
                this.c = socketAddress2;
                this.d = x2;
            }

            public final void run() {
                b.a(this.a, this.b, this.c, this.d);
            }
        };
        b.a(j2, runnable, x2, null);
        return x2;
    }

    public final l a(Object object) {
        b.a(b.super.B(), object);
        return this;
    }

    public final l a(Throwable throwable) {
        b.a(this.a, throwable);
        return this;
    }

    public final l b(Object object) {
        b.b(b.super.B(), object);
        return this;
    }

    public final t b() {
        return this.c;
    }

    public final h c(Object object) {
        return b.super.d(object, b.super.A());
    }

    public final ByteBufAllocator c() {
        return this.c.d.f().d();
    }

    public final io.netty.d.a.j d() {
        if (this.e == null) {
            return this.c.d.j();
        }
        return this.e;
    }

    public final l e() {
        b.a(this.B());
        return this;
    }

    public final l f() {
        b.b(this.B());
        return this;
    }

    public final l g() {
        b.c(this.B());
        return this;
    }

    public final l h() {
        b.d(this.B());
        return this;
    }

    public final l i() {
        b.e(this.B());
        return this;
    }

    public final l j() {
        b.f(this.B());
        return this;
    }

    public final h k() {
        return this.a(this.A());
    }

    public final l l() {
        b b2 = this.C();
        io.netty.d.a.j j2 = b2.d();
        if (j2.g()) {
            b2.x();
            return this;
        }
        Runnable runnable = b2.m;
        if (runnable == null) {
            b2.m = runnable = new Runnable(this, b2){
                final /* synthetic */ b a;
                final /* synthetic */ b b;
                {
                    this.b = b2;
                    this.a = b3;
                }

                public final void run() {
                    b.m(this.a);
                }
            };
        }
        j2.execute(runnable);
        return this;
    }

    public final l m() {
        b b2 = this.C();
        io.netty.d.a.j j2 = b2.d();
        if (j2.g()) {
            b2.y();
            return this;
        }
        Runnable runnable = b2.o;
        if (runnable == null) {
            b2.o = runnable = new Runnable(this, b2){
                final /* synthetic */ b a;
                final /* synthetic */ b b;
                {
                    this.b = b2;
                    this.a = b3;
                }

                public final void run() {
                    b.n(this.a);
                }
            };
        }
        b.a(j2, runnable, this.c.d.s(), null);
        return this;
    }

    final void n() {
        int n2;
        while ((n2 = this.f) != 3 && !h.compareAndSet((Object)this, n2, 2)) {
        }
    }

    final void o() {
        boolean bl = h.compareAndSet((Object)this, 0, 1);
        if (!g && !bl) {
            throw new AssertionError();
        }
    }

    public final boolean p() {
        return this.f == 3;
    }

}

