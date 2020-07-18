/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  b.f.b
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.concurrent.ArrayBlockingQueue
 *  java.util.concurrent.BlockingQueue
 */
package b.f;

import android.util.Log;
import b.f.a;
import b.f.b;
import b.f.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class c
implements Runnable {
    private static final String a = "c";
    private Thread b = null;
    private BlockingQueue<a> c = new ArrayBlockingQueue(128);
    private Map<String, d> d = new HashMap();

    public final int a(a a2) {
        void var4_2 = this;
        synchronized (var4_2) {
            this.c.add((Object)a2);
            return 0;
        }
    }

    public final void a() {
        if (this.b == null) {
            this.b = new Thread((Runnable)this);
            this.b.start();
        }
    }

    public final void a(d d2) {
        this.d.put((Object)d2.b, (Object)d2);
    }

    public final void b() {
        if (this.b != null) {
            this.a((a)new b());
            this.b = null;
        }
    }

    public final void c() {
        c c2 = this;
        synchronized (c2) {
            this.c.clear();
            return;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void run() {
        block5 : {
            Log.i((String)a, (String)"WorkExecutor is running...");
            do {
                a a2 = (a)this.c.take();
                if (!b.a.equals((Object)a2.a())) {
                    d d2 = (d)this.d.get((Object)a2.a());
                    if (d2 == null) {
                        String string2 = a;
                        Object[] arrobject = new Object[]{a2.a()};
                        Log.d((String)string2, (String)String.format((String)"worker not found, %s job not execute!", (Object[])arrobject));
                        continue;
                    }
                    d2.a(a2);
                    continue;
                }
                break block5;
                break;
            } while (true);
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        this.c.clear();
        Log.i((String)a, (String)"WorkExecutor is stopped");
    }
}

