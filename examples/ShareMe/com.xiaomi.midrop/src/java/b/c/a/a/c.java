/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.c.a.a.c$d
 *  b.c.a.a.c$g
 *  java.io.ByteArrayInputStream
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.io.PrintWriter
 *  java.io.UnsupportedEncodingException
 *  java.lang.Enum
 *  java.lang.Error
 *  java.lang.Exception
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.net.InetSocketAddress
 *  java.net.ServerSocket
 *  java.net.Socket
 *  java.net.SocketAddress
 *  java.net.URLDecoder
 *  java.text.SimpleDateFormat
 *  java.util.ArrayList
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Set
 *  java.util.TimeZone
 *  midrop.service.c.d
 */
package b.c.a.a;

import b.c.a.a.c;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

/*
 * Exception performing whole class analysis.
 */
public abstract class c {
    private final String a;
    private final int b;
    ServerSocket c;
    Thread d;
    a e;
    o f;
    private Set<Socket> g;

    public c() {
        this(0);
    }

    public c(int n2) {
        this.g = new HashSet();
        this.a = null;
        this.b = n2;
        this.f = new /* Unavailable Anonymous Inner Class!! */;
        this.e = new /* Unavailable Anonymous Inner Class!! */;
    }

    protected static String a(String string2) {
        try {
            String string3 = URLDecoder.decode((String)string2, (String)"UTF8");
            return string3;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return null;
        }
    }

    /*
     * Exception decompiling
     */
    private InetSocketAddress a() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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
    static /* synthetic */ void a(Closeable var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:885)
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
    static final void a(Socket var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    private void e() {
        c c2 = this;
        synchronized (c2) {
            Iterator iterator = this.g.iterator();
            while (iterator.hasNext()) {
                c.a((Socket)iterator.next());
            }
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
    public k a(i i2) {
        HashMap hashMap = new HashMap();
        j j2 = i2.e();
        if (j.b.equals((Object)j2) || j.c.equals((Object)j2)) {
            i2.a((Map<String, String>)hashMap);
        }
        i2.a().put((Object)"NanoHttpd.QUERY_STRING", (Object)i2.b());
        return new k(k.b.k, "text/plain", "Not Found");
        catch (l l2) {
            return new k(l2.a, "text/plain", l2.getMessage());
        }
        catch (IOException iOException) {
            k.b b2 = k.b.n;
            StringBuilder stringBuilder = new StringBuilder("SERVER INTERNAL ERROR: IOException: ");
            stringBuilder.append(iOException.getMessage());
            return new k(b2, "text/plain", stringBuilder.toString());
        }
    }

    public final void b() throws IOException {
        ServerSocket serverSocket = this.c = new ServerSocket();
        InetSocketAddress inetSocketAddress = this.a != null ? new InetSocketAddress(this.a, this.b) : this.a();
        serverSocket.bind((SocketAddress)inetSocketAddress);
        this.d = new Thread(new Runnable(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public final void run() {
                do {
                    try {
                        final Socket socket = c.this.c.accept();
                        c.this.b(socket);
                        socket.setSoTimeout(5000);
                        final InputStream inputStream = socket.getInputStream();
                        if (inputStream == null) {
                            c.a(socket);
                            c.this.c(socket);
                            continue;
                        }
                        c.this.e.a(new Runnable(){

                            /*
                             * Exception decompiling
                             */
                            public final void run() {
                                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                                // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 13[CATCHBLOCK]
                                // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
                                // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
                                // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
                                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
                                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                                // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                                // org.benf.cfr.reader.entities.g.p(Method.java:396)
                                // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
                                // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                                // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
                                // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                                // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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
                        });
                    }
                    catch (IOException iOException) {
                        midrop.service.c.d.a((String)"NanoHTTPD", (String)"http server start", (Throwable)iOException, (Object[])new Object[0]);
                    }
                } while (!c.this.c.isClosed());
            }

        });
        this.d.setDaemon(true);
        this.d.setName("NanoHttpd Main Listener");
        this.d.start();
    }

    public final void b(Socket socket) {
        void var4_2 = this;
        synchronized (var4_2) {
            this.g.add((Object)socket);
            return;
        }
    }

    /*
     * Exception decompiling
     */
    public final void c() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    public final void c(Socket socket) {
        void var4_2 = this;
        synchronized (var4_2) {
            this.g.remove((Object)socket);
            return;
        }
    }

    public final int d() {
        if (this.c == null) {
            return -1;
        }
        return this.c.getLocalPort();
    }

    public static interface a {
        public void a(Runnable var1);
    }

    public static final class b {
        String a;
        String b;
        String c;
    }

    public final class c
    implements Iterable<String> {
        private HashMap<String, String> b = new HashMap();
        private ArrayList<b> c = new ArrayList();

        public c(Map<String, String> map) {
            String string2 = (String)map.get((Object)"cookie");
            if (string2 != null) {
                String[] arrstring = string2.split(";");
                int n2 = arrstring.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    String[] arrstring2 = arrstring[i2].trim().split("=");
                    if (arrstring2.length != 2) continue;
                    this.b.put((Object)arrstring2[0], (Object)arrstring2[1]);
                }
            }
        }

        public final void a(k k2) {
            for (b b2 : this.c) {
                Object[] arrobject = new Object[]{b2.a, b2.b, b2.c};
                k2.a("Set-Cookie", String.format((String)"%s=%s; expires=%s", (Object[])arrobject));
            }
        }

        public final Iterator<String> iterator() {
            return this.b.keySet().iterator();
        }
    }

    public static interface i {
        public Map<String, String> a();

        public void a(Map<String, String> var1) throws IOException, l;

        public String b();

        public Map<String, String> c();

        public String d();

        public j e();
    }

    public static final class j
    extends Enum<j> {
        public static final /* enum */ j a = new j();
        public static final /* enum */ j b = new j();
        public static final /* enum */ j c = new j();
        public static final /* enum */ j d = new j();
        public static final /* enum */ j e = new j();
        public static final /* enum */ j f = new j();
        private static final /* synthetic */ j[] g;

        static {
            j[] arrj = new j[]{a, b, c, d, e, f};
            g = arrj;
        }

        static j a(String string2) {
            for (j j2 : j.values()) {
                if (!j2.toString().equalsIgnoreCase(string2)) continue;
                return j2;
            }
            return null;
        }

        public static j valueOf(String string2) {
            return (j)Enum.valueOf(j.class, (String)string2);
        }

        public static j[] values() {
            return (j[])g.clone();
        }
    }

    public static final class k {
        j a;
        private b b;
        private String c;
        private long d;
        private InputStream e;
        private Map<String, String> f;
        private boolean g;
        private a h;

        public k(b b2, String string2, long l2, InputStream inputStream, a a2) {
            this(b2, string2, inputStream, a2);
            this.d = l2;
        }

        public k(b b2, String string2, InputStream inputStream, a a2) {
            this.f = new HashMap();
            this.b = b2;
            this.c = string2;
            this.e = inputStream;
            this.h = a2;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public k(b b2, String string2, String string3) {
            ByteArrayInputStream byteArrayInputStream;
            block3 : {
                this.f = new HashMap();
                this.b = b2;
                this.c = string2;
                if (string3 != null) {
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(string3.getBytes("UTF-8"));
                        break block3;
                    }
                    catch (UnsupportedEncodingException unsupportedEncodingException) {}
                    unsupportedEncodingException.printStackTrace();
                    return;
                }
                byteArrayInputStream = null;
            }
            this.e = byteArrayInputStream;
        }

        /*
         * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        static /* synthetic */ void a(k var0_1, OutputStream var1) {
            var2_2 = var0_1.c;
            var3_3 = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            var3_3.setTimeZone(TimeZone.getTimeZone((String)"GMT"));
            if (var0_1.b == null) {
                throw new Error("sendResponse(): Status can't be null.");
            }
            var6_4 = new PrintWriter(var1);
            var7_5 = new StringBuilder("HTTP/1.1 ");
            var8_6 = var0_1.b;
            var9_7 = new StringBuilder();
            var9_7.append(var8_6.o);
            var9_7.append(" ");
            var9_7.append(var8_6.p);
            var7_5.append(var9_7.toString());
            var7_5.append(" \r\n");
            var6_4.print(var7_5.toString());
            if (var2_2 != null) {
                var15_8 = new StringBuilder("Content-Type: ");
                var15_8.append(var2_2);
                var15_8.append("\r\n");
                var6_4.print(var15_8.toString());
            }
            if (var0_1.f == null || var0_1.f.get((Object)"Date") == null) {
                var18_9 = new StringBuilder("Date: ");
                var18_9.append(var3_3.format(new Date()));
                var18_9.append("\r\n");
                var6_4.print(var18_9.toString());
            }
            if (var0_1.f != null) {
                for (String var22_11 : var0_1.f.keySet()) {
                    var23_12 = (String)var0_1.f.get((Object)var22_11);
                    var24_13 = new StringBuilder();
                    var24_13.append(var22_11);
                    var24_13.append(": ");
                    var24_13.append(var23_12);
                    var24_13.append("\r\n");
                    var6_4.print(var24_13.toString());
                }
            }
            var6_4.print("Connection: keep-alive\r\n");
            if (var0_1.a != j.e && var0_1.g) {
                var0_1.a(var1, var6_4);
            } else {
                var0_1.b(var1, var6_4);
            }
            var1.flush();
lbl43: // 2 sources:
            do {
                c.a((Closeable)var0_1.e);
                return;
                break;
            } while (true);
            {
                catch (Throwable var5_14) {
                }
                catch (IOException var4_15) {}
                {
                    midrop.service.c.d.a((String)"NanoHTTPD", (String)"nanoHTTPD", (Throwable)var4_15, (Object[])new Object[0]);
                    ** continue;
                }
            }
            c.a((Closeable)var0_1.e);
            throw var5_14;
        }

        private void a(OutputStream outputStream, PrintWriter printWriter) throws IOException {
            int n2;
            printWriter.print("Transfer-Encoding: chunked\r\n");
            printWriter.print("\r\n");
            printWriter.flush();
            byte[] arrby = "\r\n".getBytes();
            byte[] arrby2 = new byte[16384];
            while ((n2 = this.e.read(arrby2)) > 0) {
                Object[] arrobject = new Object[]{n2};
                outputStream.write(String.format((String)"%x\r\n", (Object[])arrobject).getBytes());
                outputStream.write(arrby2, 0, n2);
                outputStream.write(arrby);
                if (this.h == null) continue;
                this.h.a(n2);
            }
            outputStream.write(String.format((String)"0\r\n\r\n", (Object[])new Object[0]).getBytes());
        }

        private void b(OutputStream outputStream, PrintWriter printWriter) throws IOException {
            long l2;
            if (this.d != 0L) {
                l2 = this.d;
            } else {
                int n2 = this.e != null ? this.e.available() : 0;
                l2 = n2;
            }
            StringBuilder stringBuilder = new StringBuilder("Content-Length: ");
            stringBuilder.append(l2);
            stringBuilder.append("\r\n");
            printWriter.print(stringBuilder.toString());
            printWriter.print("\r\n");
            printWriter.flush();
            if (this.a != j.e && this.e != null) {
                int n3;
                InputStream inputStream;
                int n4;
                byte[] arrby = new byte[32768];
                while (l2 > 0L && (n4 = (inputStream = this.e).read(arrby, 0, n3 = l2 > 32768L ? 32768 : (int)l2)) > 0) {
                    outputStream.write(arrby, 0, n4);
                    long l3 = n4;
                    long l4 = l2 - l3;
                    if (this.h != null) {
                        this.h.a(l3);
                    }
                    l2 = l4;
                }
            }
        }

        public final void a(String string2, String string3) {
            this.f.put((Object)string2, (Object)string3);
        }

        public static interface a {
            public void a(long var1);
        }

        public static final class b
        extends Enum<b> {
            public static final /* enum */ b a = new b(200, "OK");
            public static final /* enum */ b b = new b(201, "Created");
            public static final /* enum */ b c = new b(202, "Accepted");
            public static final /* enum */ b d = new b(204, "No Content");
            public static final /* enum */ b e = new b(206, "Partial Content");
            public static final /* enum */ b f = new b(301, "Moved Permanently");
            public static final /* enum */ b g = new b(304, "Not Modified");
            public static final /* enum */ b h = new b(400, "Bad Request");
            public static final /* enum */ b i = new b(401, "Unauthorized");
            public static final /* enum */ b j = new b(403, "Forbidden");
            public static final /* enum */ b k = new b(404, "Not Found");
            public static final /* enum */ b l = new b(405, "Method Not Allowed");
            public static final /* enum */ b m = new b(416, "Requested Range Not Satisfiable");
            public static final /* enum */ b n = new b(500, "Internal Server Error");
            private static final /* synthetic */ b[] q;
            final int o;
            final String p;

            static {
                b[] arrb = new b[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n};
                q = arrb;
            }

            private b(int n3, String string3) {
                this.o = n3;
                this.p = string3;
            }

            public static b valueOf(String string2) {
                return (b)Enum.valueOf(b.class, (String)string2);
            }

            public static b[] values() {
                return (b[])q.clone();
            }
        }

    }

    public static final class l
    extends Exception {
        private static final long serialVersionUID = -447952585890600909L;
        final k.b a;

        public l(k.b b2, String string2) {
            super(string2);
            this.a = b2;
        }

        public l(k.b b2, String string2, Exception exception) {
            super(string2, (Throwable)exception);
            this.a = b2;
        }
    }

    public static interface m {
        public void a() throws Exception;

        public String b();
    }

    public static interface n {
        public m a() throws Exception;

        public void b();
    }

    public static interface o {
        public n a();
    }

}

