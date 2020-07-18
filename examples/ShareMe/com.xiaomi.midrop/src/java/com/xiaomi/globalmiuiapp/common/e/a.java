/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.xiaomi.globalmiuiapp.common.e.b
 *  e.a.a
 *  e.a.a$a
 *  e.a.a$b
 *  java.io.File
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.concurrent.CountDownLatch
 */
package com.xiaomi.globalmiuiapp.common.e;

import com.xiaomi.globalmiuiapp.common.e.b;
import com.xiaomi.globalmiuiapp.common.f.f;
import e.a.a;
import java.io.File;
import java.util.concurrent.CountDownLatch;

public final class a {
    private static boolean a;

    public static void a() {
        File file = com.xiaomi.globalmiuiapp.common.d.a.a("logs");
        if (!a) {
            b b2 = (b)b.a.b();
            b2.e = file;
            b2.d = 0x500000L;
            b2.c.sendEmptyMessage(2);
            a.b[] arrb = new a.b[]{new a.a(), (a.b)b.a.b()};
            e.a.a.a((a.b[])arrb);
            a = true;
        }
    }

    public static void a(Runnable runnable) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        b b2 = (b)b.a.b();
        Runnable runnable2 = new Runnable(){

            public final void run() {
                countDownLatch.countDown();
            }
        };
        b2.c.post(runnable2);
        try {
            countDownLatch.await();
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        runnable.run();
    }

    public static File b() {
        return ((b)b.a.b()).e;
    }

}

