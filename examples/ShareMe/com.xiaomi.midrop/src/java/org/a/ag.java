/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.net.InetAddress
 *  java.net.InetSocketAddress
 *  java.net.Socket
 *  java.net.SocketAddress
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package org.a;

import android.content.SharedPreferences;
import com.xiaomi.miftp.c.c;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import org.a.ae;
import org.a.ai;
import org.a.al;
import org.json.JSONException;
import org.json.JSONObject;

public class ag
extends Thread {
    private static final String c = "ag";
    public Socket a;
    public InputStream b;
    private com.xiaomi.miftp.b.a d;
    private String e;
    private long f;
    private a g = a.e;

    public ag(com.xiaomi.miftp.b.a a2) {
        this.d = a2;
        this.f = ae.e().getSharedPreferences("proxy_usage_data", 0).getLong("proxy_usage_data", 0L);
        this.a(a.e);
        ae.a((ag)this);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static Socket a(String string2, int n2) {
        Socket socket;
        OutputStream outputStream;
        Throwable throwable;
        InputStream inputStream;
        block21 : {
            block20 : {
                block19 : {
                    int n3;
                    byte[] arrby;
                    block18 : {
                        if (string2 == null) {
                            c.d(c, "newAuthedSocket can't connect to null host");
                            return null;
                        }
                        JSONObject jSONObject = new JSONObject();
                        String string3 = c;
                        StringBuilder stringBuilder = new StringBuilder("Opening proxy connection to ");
                        stringBuilder.append(string2);
                        stringBuilder.append(":");
                        stringBuilder.append(n2);
                        c.a(string3, stringBuilder.toString());
                        socket = new Socket();
                        socket.connect((SocketAddress)new InetSocketAddress(string2, n2), 5000);
                        jSONObject.put("android_id", (Object)al.a());
                        jSONObject.put("swiftp_version", (Object)al.b());
                        jSONObject.put("action", (Object)"login");
                        outputStream = socket.getOutputStream();
                        inputStream = socket.getInputStream();
                        outputStream.write(jSONObject.toString().getBytes("UTF-8"));
                        c.a(c, "Sent login request");
                        arrby = new byte[2048];
                        n3 = inputStream.read(arrby);
                        if (n3 != -1) break block18;
                        c.d(c, "Proxy socket closed while waiting for auth response");
                        com.xiaomi.miftp.c.a.a((Closeable)inputStream);
                        com.xiaomi.miftp.c.a.a((Closeable)outputStream);
                        com.xiaomi.miftp.c.a.a((Closeable)socket);
                        return null;
                    }
                    if (n3 == 0) {
                        c.d(c, "Short network read waiting for auth, quitting");
                        com.xiaomi.miftp.c.a.a((Closeable)inputStream);
                        com.xiaomi.miftp.c.a.a((Closeable)outputStream);
                        com.xiaomi.miftp.c.a.a((Closeable)socket);
                        return null;
                    }
                    boolean bl = ag.a(new JSONObject(new String(arrby, 0, n3, "UTF-8")));
                    if (!bl) break block19;
                    com.xiaomi.miftp.c.a.a((Closeable)inputStream);
                    com.xiaomi.miftp.c.a.a((Closeable)outputStream);
                    com.xiaomi.miftp.c.a.a((Closeable)socket);
                    return null;
                }
                try {
                    c.a(c, "newAuthedSocket successful");
                }
                catch (Exception exception) {
                    break block20;
                }
                com.xiaomi.miftp.c.a.a((Closeable)inputStream);
                com.xiaomi.miftp.c.a.a((Closeable)outputStream);
                return socket;
                catch (Throwable throwable2) {
                    throwable = throwable2;
                    inputStream = null;
                    break block21;
                }
                catch (Exception exception) {
                    inputStream = null;
                    break block20;
                }
                catch (Throwable throwable3) {
                    throwable = throwable3;
                    outputStream = null;
                    inputStream = null;
                    break block21;
                }
                catch (Exception exception) {
                    outputStream = null;
                    inputStream = null;
                    break block20;
                }
                catch (Throwable throwable4) {
                    throwable = throwable4;
                    socket = null;
                    outputStream = null;
                    inputStream = null;
                    break block21;
                }
                catch (Exception exception) {
                    outputStream = null;
                    inputStream = null;
                    socket = null;
                }
            }
            try {
                void var3_15;
                String string4 = c;
                StringBuilder stringBuilder = new StringBuilder("Exception during proxy connection or authentication: ");
                stringBuilder.append((Object)var3_15);
                c.d(string4, stringBuilder.toString());
            }
            catch (Throwable throwable5) {
                // empty catch block
            }
            com.xiaomi.miftp.c.a.a(inputStream);
            com.xiaomi.miftp.c.a.a(outputStream);
            if (socket == null) return null;
            com.xiaomi.miftp.c.a.a((Closeable)socket);
            return null;
        }
        com.xiaomi.miftp.c.a.a(inputStream);
        com.xiaomi.miftp.c.a.a(outputStream);
        if (socket == null) throw throwable;
        com.xiaomi.miftp.c.a.a(socket);
        throw throwable;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static JSONObject a(InputStream inputStream, OutputStream outputStream, JSONObject jSONObject) throws JSONException {
        try {
            byte[] arrby = al.a(jSONObject);
            if (arrby == null) {
                return null;
            }
            outputStream.write(arrby);
            byte[] arrby2 = new byte[2048];
            if (inputStream.read(arrby2) <= 0) {
                c.d(c, "Proxy sendRequest short read on response");
                return null;
            }
            JSONObject jSONObject2 = al.a(arrby2);
            if (jSONObject2 == null) {
                c.d(c, "Null response to sendRequest");
            }
            if (ag.a(jSONObject2)) {
                c.d(c, "Error response to sendRequest");
                return null;
            }
            return jSONObject2;
        }
        catch (IOException iOException) {
            String string2 = c;
            StringBuilder stringBuilder = new StringBuilder("IOException in proxy sendRequest: ");
            stringBuilder.append((Object)iOException);
            c.d(string2, stringBuilder.toString());
            return null;
        }
    }

    public static JSONObject a(String string2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action", (Object)string2);
        return jSONObject;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static JSONObject a(Socket socket, JSONObject jSONObject) throws JSONException {
        if (socket != null) return ag.a(socket.getInputStream(), socket.getOutputStream(), jSONObject);
        try {
            c.d(c, "null socket in ProxyConnector.sendRequest()");
            return null;
        }
        catch (IOException iOException) {}
        String string2 = c;
        StringBuilder stringBuilder = new StringBuilder("IOException in proxy sendRequest wrapper: ");
        stringBuilder.append((Object)iOException);
        c.d(string2, stringBuilder.toString());
        return null;
    }

    static boolean a(Socket socket) {
        block5 : {
            JSONObject jSONObject;
            block4 : {
                try {
                    jSONObject = ag.a(socket, ag.a("data_pasv_accept"));
                    if (jSONObject != null) break block4;
                    return false;
                }
                catch (JSONException jSONException) {
                    String string2 = c;
                    StringBuilder stringBuilder = new StringBuilder("JSONException in pasvAccept: ");
                    stringBuilder.append((Object)jSONException);
                    c.d(string2, stringBuilder.toString());
                    return false;
                }
            }
            if (!ag.a(jSONObject)) break block5;
            c.d(c, "Error response to data_pasv_accept");
            return false;
        }
        c.a(c, "Proxy data_pasv_accept successful");
        return true;
    }

    private static boolean a(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("error_code")) {
            StringBuilder stringBuilder = new StringBuilder("Error in JSON response, code: ");
            stringBuilder.append(jSONObject.getString("error_code"));
            if (jSONObject.has("error_string")) {
                stringBuilder.append(", string: ");
                stringBuilder.append(jSONObject.getString("error_string"));
            }
            c.d(c, stringBuilder.toString());
            return true;
        }
        return false;
    }

    private static void b(String string2) {
        SharedPreferences.Editor editor = ae.e().getSharedPreferences("preferred_server", 0).edit();
        editor.putString("preferred_server", string2);
        editor.apply();
    }

    /*
     * Exception decompiling
     */
    final Socket a(InetAddress var1, int var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl56 : GETSTATIC : trying to set 1 previously set to 0
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
    final ai a() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl59 : GETSTATIC : trying to set 1 previously set to 0
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

    final void a(long l2) {
        long l3 = this.f;
        this.f = l2 + this.f;
        if (this.f % 5000000L < l3 % 5000000L) {
            this.d.c();
            this.b();
        }
    }

    public final void a(a a2) {
        this.g = a2;
        String string2 = c;
        StringBuilder stringBuilder = new StringBuilder("Proxy state changed to ");
        stringBuilder.append((Object)a2);
        c.a(string2, stringBuilder.toString());
        this.d.c();
    }

    public final void b() {
        if (this.f == 0L) {
            return;
        }
        SharedPreferences.Editor editor = ae.e().getSharedPreferences("proxy_usage_data", 0).edit();
        editor.putLong("proxy_usage_data", this.f);
        editor.apply();
        c.a(c, "Persisted proxy usage to preferences");
    }

    /*
     * Exception decompiling
     */
    public void run() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl183 : GETSTATIC : trying to set 1 previously set to 0
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
        public static final /* enum */ a a = new a();
        public static final /* enum */ a b = new a();
        public static final /* enum */ a c = new a();
        public static final /* enum */ a d = new a();
        public static final /* enum */ a e = new a();
        private static final /* synthetic */ a[] f;

        static {
            a[] arra = new a[]{a, b, c, d, e};
            f = arra;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])f.clone();
        }
    }

}

