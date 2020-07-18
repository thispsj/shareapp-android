/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.preference.PreferenceManager
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.io.UnsupportedEncodingException
 *  java.lang.Enum
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.net.Socket
 *  java.nio.ByteBuffer
 */
package org.a;

import android.content.Context;
import android.preference.PreferenceManager;
import com.xiaomi.miftp.c.c;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.nio.ByteBuffer;
import org.a.ab;
import org.a.ac;
import org.a.ae;

public class aj
extends Thread {
    private static final String j = "aj";
    private static int p = 3;
    public Socket a;
    protected ByteBuffer b = ByteBuffer.allocate((int)ac.a());
    boolean c;
    org.a.a d = new org.a.a();
    boolean e;
    File f = ae.b();
    File g;
    ab h;
    String i = PreferenceManager.getDefaultSharedPreferences((Context)ae.e()).getString("pref_charset", ac.d);
    private Socket k;
    private OutputStream l;
    private boolean m;
    private int n;
    private int o;

    public aj(Socket socket, ab ab2, int n2) {
        this.a = socket;
        this.n = n2;
        this.h = ab2;
        boolean bl = n2 == a.a;
        this.m = bl;
    }

    private void c() {
        c.a(j, "SessionThread told to quit");
        com.xiaomi.miftp.c.a.a((Closeable)this.a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final int a(byte[] arrby) {
        int n2;
        block5 : {
            block8 : {
                String string2;
                String string3;
                block7 : {
                    block6 : {
                        if (this.k != null) break block6;
                        string2 = j;
                        string3 = "Can't receive from null dataSocket";
                        break block7;
                    }
                    if (this.k.isConnected()) break block8;
                    string2 = j;
                    string3 = "Can't receive from unconnected socket";
                }
                c.d(string2, string3);
                return -2;
            }
            try {
                InputStream inputStream = this.k.getInputStream();
                while ((n2 = inputStream.read(arrby, 0, arrby.length)) == 0) {
                }
                if (n2 != -1) break block5;
                return -1;
            }
            catch (IOException iOException) {
                c.d(j, "Error reading data socket");
                return 0;
            }
        }
        this.h.a(n2);
        return n2;
    }

    final void a(File file) {
        try {
            this.f = file.getCanonicalFile().getAbsoluteFile();
            return;
        }
        catch (IOException iOException) {
            c.d(j, "SessionThread canonical error");
            return;
        }
    }

    final void a(boolean bl) {
        if (bl) {
            c.d(j, "Authentication complete");
            this.e = true;
            return;
        }
        if (this.n == a.b) {
            aj.super.c();
        } else {
            this.o = 1 + this.o;
            String string2 = j;
            StringBuilder stringBuilder = new StringBuilder("Auth failed: ");
            stringBuilder.append(this.o);
            stringBuilder.append("/");
            stringBuilder.append(p);
            c.d(string2, stringBuilder.toString());
        }
        if (this.o > p) {
            c.d(j, "Too many auth fails, quitting session");
            aj.super.c();
        }
    }

    final boolean a() {
        block3 : {
            try {
                this.k = this.h.b();
                if (this.k != null) break block3;
                c.d(j, "dataSocketFactory.onTransfer() returned null");
                return false;
            }
            catch (IOException iOException) {
                c.d(j, "IOException getting OutputStream for data socket");
                this.k = null;
                return false;
            }
        }
        this.l = this.k.getOutputStream();
        return true;
    }

    final boolean a(String string2) {
        try {
            byte[] arrby = string2.getBytes(this.i);
            String string3 = j;
            StringBuilder stringBuilder = new StringBuilder("Using data connection encoding: ");
            stringBuilder.append(this.i);
            c.a(string3, stringBuilder.toString());
            boolean bl = this.a(arrby, 0, arrby.length);
            return bl;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            c.b(j, "Unsupported encoding for data socket send");
            return false;
        }
    }

    final boolean a(byte[] arrby, int n2, int n3) {
        if (this.l == null) {
            c.d(j, "Can't send via null dataOutputStream");
            return false;
        }
        if (n3 == 0) {
            return true;
        }
        try {
            this.l.write(arrby, n2, n3);
        }
        catch (IOException iOException) {
            c.d(j, "Couldn't write output stream for data socket");
            c.d(j, iOException.toString());
            return false;
        }
        this.h.a(n3);
        return true;
    }

    public final void b() {
        c.d(j, "Closing data socket");
        com.xiaomi.miftp.c.a.a((Closeable)this.l);
        com.xiaomi.miftp.c.a.a((Closeable)this.k);
        this.k = null;
    }

    /*
     * Exception decompiling
     */
    public final void b(String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl26 : FAKE_TRY : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1113)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:588)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    public void run() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl68 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1113)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:588)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    public static final class a
    extends Enum<a> {
        public static final int a = 1;
        public static final int b = 2;
        private static final /* synthetic */ int[] c;

        static {
            int[] arrn = new int[]{a, b};
            c = arrn;
        }
    }

}

