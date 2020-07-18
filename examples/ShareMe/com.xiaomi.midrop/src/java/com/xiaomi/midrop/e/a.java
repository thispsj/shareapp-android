/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteOpenHelper
 *  android.os.AsyncTask
 *  android.text.TextUtils
 *  com.xiaomi.midrop.util.af
 *  com.xiaomi.midrop.util.af$a
 *  com.xiaomi.midrop.util.af$b
 *  com.xiaomi.midrop.util.y
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.util.Calendar
 *  java.util.List
 *  midrop.service.c.d
 */
package com.xiaomi.midrop.e;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.y;
import java.util.Calendar;
import java.util.List;
import midrop.service.c.d;

public final class a
extends SQLiteOpenHelper {
    public a(Context context) {
        super(context, "TransmissionRecords.db", null, 2);
    }

    /*
     * Exception decompiling
     */
    public static List<c> a(String var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [7[TRYBLOCK]], but top level block is 17[CATCHBLOCK]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

    public static void a() {
        long l2 = y.t();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long l3 = calendar.getTimeInMillis();
        if (l2 < l3) {
            a a2 = new a(0);
            Object[] arrobject = new Long[]{l3};
            a2.execute(arrobject);
        }
    }

    public static void a(String string2, int n, String string3) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return;
        }
        new b(string2, n, string3).execute((Object[])new Void[0]);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void b(String var0) {
        block14 : {
            block13 : {
                if (TextUtils.isEmpty((CharSequence)var0)) {
                    return;
                }
                var1_1 = new a(MiDropApplication.a());
                var4_2 = var1_1.getWritableDatabase();
                var5_3 = null;
                var6_4 = new ContentValues();
                var6_4.put("synced", "1");
                var10_5 = var4_2.update("transmission_records", var6_4, String.format((String)"%s = ? AND %s = ? AND %s IS NULL", (Object[])new Object[]{"aid", "prole", "synced"}), new String[]{var0, "0"});
                var11_6 = new Object[]{var10_5};
                String.format((String)"updated %d rows", (Object[])var11_6);
                if (var4_2 == null) break block13;
                var4_2.close();
            }
            var1_1.close();
            return;
            {
                catch (Throwable var8_7) {
                }
                catch (Throwable var7_8) {}
                var5_3 = var7_8;
                {
                    throw var5_3;
                }
            }
            if (var4_2 == null) throw var8_7;
            if (var5_3 == null) ** GOTO lbl34
            try {
                try {
                    var4_2.close();
                    throw var8_7;
                }
                catch (Throwable var9_9) {
                    var5_3.addSuppressed(var9_9);
                    throw var8_7;
                }
lbl34: // 1 sources:
                var4_2.close();
                throw var8_7;
            }
            catch (Throwable var3_10) {
                break block14;
            }
            catch (Exception var2_11) {
                d.a((String)"MiDrop:TransmissionRecordsDbHelper", (String)"mark unsynced trans records failed", (Throwable)var2_11, (Object[])new Object[0]);
                var1_1.close();
                return;
            }
        }
        var1_1.close();
        throw var3_10;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE transmission_records (pid TEXT,prole INTEGER,date INTEGER,aid INTEGER,synced INTEGER)");
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int n, int n2) {
        this.onUpgrade(sQLiteDatabase, n, n2);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int n, int n2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS transmission_records");
        this.onCreate(sQLiteDatabase);
    }

    private static final class a
    extends AsyncTask<Long, Void, Void> {
        private long a;
        private long b;

        private a() {
        }

        /* synthetic */ a(byte by) {
        }

        /*
         * Exception decompiling
         */
        private /* varargs */ Void a(Long ... var1) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [6[TRYBLOCK]], but top level block is 8[TRYBLOCK]
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

        protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
            return a.super.a((Long[])arrobject);
        }

        protected final /* synthetic */ void onPostExecute(Object object) {
            super.onPostExecute((Object)((Void)object));
            af.a((af.a)af.a.dp).a(af.b.W, String.valueOf((long)this.a)).a();
            af.a((af.a)af.a.dq).a(af.b.W, String.valueOf((long)this.b)).a();
            y.b((long)System.currentTimeMillis());
        }
    }

    private static final class b
    extends AsyncTask<Void, Void, Void> {
        private String a;
        private int b;
        private String c;

        b(String string2, int n, String string3) {
            this.a = string2;
            this.b = n;
            this.c = string3;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        private /* varargs */ Void a() {
            block17 : {
                block16 : {
                    var1_1 = new a(MiDropApplication.a());
                    var4_2 = var1_1.getWritableDatabase();
                    try {
                        var5_3 = new ContentValues();
                        var5_3.put("pid", this.a);
                        var5_3.put("prole", Integer.valueOf((int)this.b));
                        var5_3.put("date", Long.valueOf((long)System.currentTimeMillis()));
                        if (!TextUtils.isEmpty((CharSequence)this.c)) {
                            var5_3.put("aid", this.c);
                        }
                        if (var4_2.insert("transmission_records", null, var5_3) == -1L) {
                            d.a((String)"MiDrop:TransmissionRecordsDbHelper", (String)"insert transmission record failed!", (Object[])new Object[0]);
                        }
                        ** if (var4_2 == null) goto lbl-1000
                    }
                    catch (Throwable var9_4) {
                        var8_6 = null;
                    }
                    catch (Throwable var6_7) {
                        try {
                            throw var6_7;
                        }
                        catch (Throwable var7_8) {
                            var8_6 = var6_7;
                            var9_5 = var7_8;
                        }
                    }
lbl-1000: // 1 sources:
                    {
                        var4_2.close();
                    }
lbl-1000: // 2 sources:
                    {
                        break block16;
                    }
                    if (var4_2 == null) throw var9_5;
                    if (var8_6 == null) ** GOTO lbl36
                    try {
                        try {
                            var4_2.close();
                            throw var9_5;
                        }
                        catch (Throwable var10_9) {
                            var8_6.addSuppressed(var10_9);
                            throw var9_5;
                        }
lbl36: // 1 sources:
                        var4_2.close();
                        throw var9_5;
                    }
                    catch (Throwable var3_10) {
                        break block17;
                    }
                    catch (Exception var2_11) {
                        d.a((String)"MiDrop:TransmissionRecordsDbHelper", (String)"insert task failed", (Throwable)var2_11, (Object[])new Object[0]);
                    }
                }
                var1_1.close();
                return null;
            }
            var1_1.close();
            throw var3_10;
        }

        /*
         * Exception decompiling
         */
        protected final /* synthetic */ Object doInBackground(Object[] var1) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // java.lang.ArrayIndexOutOfBoundsException: length=0; index=-1
            // java.util.ArrayList.get(ArrayList.java:315)
            // org.benf.cfr.reader.b.a.a.c.ab.a(VarArgsRewriter.java:87)
            // org.benf.cfr.reader.b.a.b.a.e.a(AbstractMemberFunctionInvokation.java:146)
            // org.benf.cfr.reader.b.a.a.c.ab.a(VarArgsRewriter.java:56)
            // org.benf.cfr.reader.b.a.d.b.u.a(StructuredReturn.java:90)
            // org.benf.cfr.reader.b.a.a.c.ab.a(VarArgsRewriter.java:42)
            // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:1185)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:760)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:885)
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
    }

    public static final class c {
        public String a;
        public long b;

        c(String string2, long l2) {
            this.a = string2;
            this.b = l2;
        }
    }

}

