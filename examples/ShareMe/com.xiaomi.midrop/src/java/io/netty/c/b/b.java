/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.b.d
 *  io.netty.b.h
 *  io.netty.b.l
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.ByteBufHolder
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.SocketAddress
 */
package io.netty.c.b;

import io.netty.b.d;
import io.netty.b.f;
import io.netty.b.h;
import io.netty.b.j;
import io.netty.b.l;
import io.netty.b.x;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.ByteBufUtil;
import io.netty.c.b.a;
import io.netty.d.b.a.e;
import io.netty.d.b.t;
import java.net.SocketAddress;

@j.a
public final class b
extends f {
    private static final a c = a.b;
    protected final io.netty.d.b.a.d a;
    protected final int b;
    private final a d;

    public b() {
        this(c);
    }

    public b(a a2) {
        if (a2 == null) {
            throw new NullPointerException("level");
        }
        this.a = e.a(this.getClass());
        this.d = a2;
        this.b = a2.f;
    }

    private static String a(l l2, String string2) {
        String string3 = l2.a().toString();
        StringBuilder stringBuilder = new StringBuilder(1 + (string3.length() + string2.length()));
        stringBuilder.append(string3);
        stringBuilder.append(' ');
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void a(l var1, String var2_3, Object var3_2) {
        block4 : {
            block5 : {
                if (this.a.a(this.b) == false) return;
                var4_4 = this.a;
                var5_5 = this.b;
                if (!(var3_2 instanceof ByteBuf)) break block4;
                var13_6 = (ByteBuf)var3_2;
                var32_7 = var13_6.readableBytes();
                if (var32_7 != 0) break block5;
                var15_8 = new StringBuilder(4 + var2_3.length());
                var15_8.append(var2_3);
                var19_9 = ": 0B";
                ** GOTO lbl33
            }
            var34_11 = var32_7 / 16;
            var35_12 = var32_7 % 15 == 0 ? 0 : 1;
            var36_13 = 4 + (var34_11 + var35_12);
            var24_14 = new StringBuilder(2 + (1 + (10 + (2 + var2_3.length()))) + var36_13 * 80);
            var24_14.append(var2_3);
            var24_14.append(": ");
            var24_14.append(var32_7);
            ** GOTO lbl45
        }
        if (var3_2 instanceof ByteBufHolder) {
            var11_15 = (ByteBufHolder)var3_2;
            var12_16 = var11_15.toString();
            var13_6 = var11_15.content();
            var14_17 = var13_6.readableBytes();
            if (var14_17 == 0) {
                var15_8 = new StringBuilder(4 + (2 + var2_3.length() + var12_16.length()));
                var15_8.append(var2_3);
                var15_8.append(", ");
                var15_8.append(var12_16);
                var19_9 = ", 0B";
lbl33: // 2 sources:
                var15_8.append(var19_9);
                var10_10 = var15_8.toString();
            } else {
                var21_18 = var14_17 / 16;
                var22_19 = var14_17 % 15 == 0 ? 0 : 1;
                var23_20 = 4 + (var21_18 + var22_19);
                var24_14 = new StringBuilder(2 + (1 + (10 + (2 + (2 + var2_3.length() + var12_16.length())))) + var23_20 * 80);
                var24_14.append(var2_3);
                var24_14.append(": ");
                var24_14.append(var12_16);
                var24_14.append(", ");
                var24_14.append(var14_17);
lbl45: // 2 sources:
                var24_14.append('B');
                var24_14.append(t.a);
                ByteBufUtil.appendPrettyHexDump(var24_14, var13_6);
                var10_10 = var24_14.toString();
            }
        } else {
            var6_21 = new StringBuilder();
            var6_21.append(var2_3);
            var6_21.append(": ");
            var6_21.append(var3_2);
            var10_10 = var6_21.toString();
        }
        var4_4.a(var5_5, b.a(var1, var10_10));
    }

    @Override
    public final void a(l l2, x x2) throws Exception {
        if (this.a.a(this.b)) {
            this.a.a(this.b, b.a(l2, "CLOSE()"));
        }
        super.a(l2, x2);
    }

    @Override
    public final void a(l l2, Object object) throws Exception {
        b.super.a(l2, "READ", object);
        l2.b(object);
    }

    @Override
    public final void a(l l2, Object object, x x2) throws Exception {
        b.super.a(l2, "WRITE", object);
        l2.a(object, x2);
    }

    @Override
    public final void a(l l2, Throwable throwable) throws Exception {
        if (this.a.a(this.b)) {
            io.netty.d.b.a.d d2 = this.a;
            int n2 = this.b;
            StringBuilder stringBuilder = new StringBuilder("EXCEPTION: ");
            stringBuilder.append((Object)throwable);
            d2.a(n2, b.a(l2, stringBuilder.toString()), throwable);
        }
        super.a(l2, throwable);
    }

    @Override
    public final void a(l l2, SocketAddress socketAddress, x x2) throws Exception {
        if (this.a.a(this.b)) {
            io.netty.d.b.a.d d2 = this.a;
            int n2 = this.b;
            StringBuilder stringBuilder = new StringBuilder("BIND(");
            stringBuilder.append((Object)socketAddress);
            stringBuilder.append(')');
            d2.a(n2, b.a(l2, stringBuilder.toString()));
        }
        super.a(l2, socketAddress, x2);
    }

    @Override
    public final void a(l l2, SocketAddress socketAddress, SocketAddress socketAddress2, x x2) throws Exception {
        if (this.a.a(this.b)) {
            io.netty.d.b.a.d d2 = this.a;
            int n2 = this.b;
            StringBuilder stringBuilder = new StringBuilder("CONNECT(");
            stringBuilder.append((Object)socketAddress);
            stringBuilder.append(", ");
            stringBuilder.append((Object)socketAddress2);
            stringBuilder.append(')');
            d2.a(n2, b.a(l2, stringBuilder.toString()));
        }
        super.a(l2, socketAddress, socketAddress2, x2);
    }

    @Override
    public final void b(l l2) throws Exception {
        if (this.a.a(this.b)) {
            this.a.a(this.b, b.a(l2, "FLUSH"));
        }
        l2.m();
    }

    @Override
    public final void b(l l2, Object object) throws Exception {
        if (this.a.a(this.b)) {
            io.netty.d.b.a.d d2 = this.a;
            int n2 = this.b;
            StringBuilder stringBuilder = new StringBuilder("USER_EVENT: ");
            stringBuilder.append(object);
            d2.a(n2, b.a(l2, stringBuilder.toString()));
        }
        super.b(l2, object);
    }

    @Override
    public final void e(l l2) throws Exception {
        if (this.a.a(this.b)) {
            this.a.a(this.b, b.a(l2, "REGISTERED"));
        }
        super.e(l2);
    }

    @Override
    public final void f(l l2) throws Exception {
        if (this.a.a(this.b)) {
            this.a.a(this.b, b.a(l2, "UNREGISTERED"));
        }
        super.f(l2);
    }

    @Override
    public final void g(l l2) throws Exception {
        if (this.a.a(this.b)) {
            this.a.a(this.b, b.a(l2, "ACTIVE"));
        }
        super.g(l2);
    }

    @Override
    public final void h(l l2) throws Exception {
        if (this.a.a(this.b)) {
            this.a.a(this.b, b.a(l2, "INACTIVE"));
        }
        super.h(l2);
    }

    @Override
    public final void i(l l2) throws Exception {
        if (this.a.a(this.b)) {
            this.a.a(this.b, b.a(l2, "READ COMPLETE"));
        }
        l2.i();
    }

    @Override
    public final void j(l l2) throws Exception {
        if (this.a.a(this.b)) {
            this.a.a(this.b, b.a(l2, "WRITABILITY CHANGED"));
        }
        l2.j();
    }
}

