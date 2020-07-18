/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.database.Cursor
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.provider.MediaStore
 *  android.provider.MediaStore$Audio
 *  android.provider.MediaStore$Audio$Albums
 *  android.provider.MediaStore$Audio$Media
 *  android.provider.MediaStore$Files
 *  android.provider.MediaStore$Images
 *  android.provider.MediaStore$Images$Media
 *  android.provider.MediaStore$Video
 *  android.provider.MediaStore$Video$Media
 *  android.text.TextUtils
 *  android.util.SparseArray
 *  android.util.SparseBooleanArray
 *  com.xiaomi.midrop.b.i
 *  com.xiaomi.midrop.util.a
 *  com.xiaomi.midrop.util.am
 *  com.xiaomi.midrop.util.d
 *  com.xiaomi.midrop.util.g
 *  com.xiaomi.midrop.util.j
 *  com.xiaomi.midrop.util.x
 *  com.xiaomi.midrop.util.z
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.HashSet
 *  java.util.List
 *  java.util.concurrent.Executor
 */
package com.xiaomi.midrop.b;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.sender.c.f;
import com.xiaomi.midrop.util.am;
import com.xiaomi.midrop.util.d;
import com.xiaomi.midrop.util.j;
import com.xiaomi.midrop.util.x;
import com.xiaomi.midrop.util.z;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;

public final class h {
    private static h e;
    private static final String[] f;
    private SparseArray<List<g>> a = new SparseArray();
    private SparseArray<List<WeakReference<a>>> b = new SparseArray();
    private SparseBooleanArray c = new SparseBooleanArray();
    private boolean d;

    static {
        f = new String[]{"_id", "_data", "mime_type", "date_modified", "_size"};
    }

    private h() {
    }

    public static h a() {
        Class<h> class_ = h.class;
        synchronized (h.class) {
            if (e == null) {
                e = new h();
            }
            h h2 = e;
            // ** MonitorExit[var2] (shouldn't be in output)
            return h2;
        }
    }

    public static List<g> a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        for (ResolveInfo resolveInfo : x.a((Intent)intent)) {
            if (resolveInfo.activityInfo == null) continue;
            g g2 = new g();
            g2.i = resolveInfo.activityInfo.applicationInfo.sourceDir;
            g2.k = resolveInfo.loadLabel(packageManager).toString();
            g2.h = Uri.fromFile((File)new File(g2.i)).toString();
            g2.C = resolveInfo.activityInfo.packageName;
            File file = new File(g2.i);
            if (file.exists()) {
                g2.l = file.length();
                g2.w = file.lastModified() / 1000L;
            }
            g2.B = am.a((String)g2.C);
            g2.D = resolveInfo.activityInfo.applicationInfo.splitSourceDirs;
            if (am.b((String)g2.C)) continue;
            arrayList.add((Object)g2);
        }
        return arrayList;
    }

    static /* synthetic */ void a(h h2, int n, List list) {
        List list2 = (List)h2.b.get(n);
        if (list2 != null) {
            for (WeakReference weakReference : list2) {
                if (weakReference.get() == null) continue;
                if (list == null) {
                    list = new ArrayList(0);
                }
                if (weakReference.get() == null) continue;
                ((a)weakReference.get()).a(n, (List<g>)list);
            }
            list2.clear();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private List<g> b(Context var1) {
        block17 : {
            var2_2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            var3_3 = new ArrayList();
            var4_4 = new String[]{"_display_name", "_data", "_size", "date_modified"};
            var15_5 = var1.getContentResolver().query(var2_2, var4_4, null, null, "date_modified DESC");
            var16_6 = null;
            if (var15_5 == null) ** GOTO lbl41
            try {
                if (var15_5.moveToFirst()) {
                    do {
                        var19_9 = var15_5.getString(var15_5.getColumnIndex("_data"));
                        var20_11 = j.g((String)var19_9);
                        var16_6 = null;
                        if (!var20_11) continue;
                        var21_10 = new g();
                        var21_10.i = var19_9;
                        var21_10.k = var15_5.getString(var15_5.getColumnIndex("_display_name"));
                        var21_10.h = Uri.fromFile((File)new File(var19_9)).toString();
                        var21_10.l = var15_5.getLong(var15_5.getColumnIndex("_size"));
                        var21_10.w = var15_5.getLong(var15_5.getColumnIndex("date_modified"));
                        var3_3.add((Object)var21_10);
                    } while (var23_8 = var15_5.moveToNext());
                }
                ** GOTO lbl41
            }
            catch (Throwable var17_12) {
                break block17;
            }
            catch (Throwable var16_7) {
                throw var16_7;
            }
        }
        if (var15_5 == null) throw var17_12;
        if (var16_6 == null) ** GOTO lbl39
        try {
            try {
                var15_5.close();
                throw var17_12;
            }
            catch (Throwable var18_13) {
                var16_6.addSuppressed(var18_13);
                throw var17_12;
            }
lbl39: // 1 sources:
            var15_5.close();
            throw var17_12;
lbl41: // 2 sources:
            if (var15_5 != null) {
                var15_5.close();
            }
        }
        catch (Exception var5_14) {
            new StringBuilder("Exception e=").append((Object)var5_14);
        }
        if (TextUtils.isEmpty((CharSequence)(var7_15 = d.b((Context)var1)))) {
            return var3_3;
        }
        var8_16 = z.a((String)var7_15, (int)2);
        if (var8_16.isEmpty()) {
            return var3_3;
        }
        var3_3.addAll((Collection)var8_16);
        var10_17 = new ArrayList();
        var11_18 = new HashSet();
        var12_19 = 0;
        do {
            if (var12_19 >= var3_3.size()) {
                Collections.sort((List)var10_17, (Comparator)new Comparator<g>(){

                    public final /* synthetic */ int compare(Object object, Object object2) {
                        g g2 = (g)object;
                        return Long.valueOf((long)((g)object2).w).compareTo(Long.valueOf((long)g2.w));
                    }
                });
                return var10_17;
            }
            if (!var11_18.contains((Object)((g)var3_3.get((int)var12_19)).i)) {
                var10_17.add(var3_3.get(var12_19));
                var11_18.add((Object)((g)var3_3.get((int)var12_19)).i);
            }
            ++var12_19;
        } while (true);
    }

    private void b(final int n) {
        if (this.c.get(n)) {
            return;
        }
        this.c.put(n, true);
        new AsyncTask<Void, Void, List<g>>(){

            protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
                int n2 = n;
                switch (n2) {
                    default: {
                        switch (n2) {
                            default: {
                                return null;
                            }
                            case 11: {
                                return h.this.a(n);
                            }
                            case 10: 
                        }
                        return h.this.a(n);
                    }
                    case 4: {
                        return h.this.c(MiDropApplication.a());
                    }
                    case 3: {
                        return h.this.d(MiDropApplication.a());
                    }
                    case 2: {
                        return h.this.b(MiDropApplication.a());
                    }
                    case 1: 
                }
                return h.a(MiDropApplication.a());
            }

            protected final /* synthetic */ void onPostExecute(Object object) {
                List list = (List)object;
                h.this.c.put(n, false);
                h.this.a.put(n, (Object)list);
                h.a(h.this, n, list);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
    }

    private void b(int n, a a2) {
        List list = (List)this.b.get(n);
        if (list == null) {
            list = new ArrayList();
        }
        list.add((Object)new WeakReference((Object)a2));
        this.b.put(n, (Object)list);
    }

    /*
     * Exception decompiling
     */
    public static i c() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [8[TRYBLOCK]], but top level block is 18[CATCHBLOCK]
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

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private List<g> c(Context var1) {
        block17 : {
            var2_2 = new ArrayList();
            var3_3 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            var4_4 = new String[]{"_id", "_data", "_display_name", "duration", "_size"};
            var15_5 = var1.getContentResolver().query(var3_3, var4_4, null, null, "date_modified DESC");
            var16_6 = null;
            if (var15_5 == null) ** GOTO lbl41
            try {
                if (var15_5.moveToFirst()) {
                    do {
                        var19_9 = var15_5.getString(var15_5.getColumnIndex("_data"));
                        var20_11 = j.g((String)var19_9);
                        var16_6 = null;
                        if (!var20_11) continue;
                        var21_10 = new g();
                        var21_10.i = var19_9;
                        var21_10.h = Uri.fromFile((File)new File(var19_9)).toString();
                        var21_10.k = var15_5.getString(var15_5.getColumnIndex("_display_name"));
                        var21_10.v = var15_5.getLong(var15_5.getColumnIndex("duration"));
                        var21_10.l = var15_5.getLong(var15_5.getColumnIndex("_size"));
                        var2_2.add((Object)var21_10);
                    } while (var23_8 = var15_5.moveToNext());
                }
                ** GOTO lbl41
            }
            catch (Throwable var17_12) {
                break block17;
            }
            catch (Throwable var16_7) {
                throw var16_7;
            }
        }
        if (var15_5 == null) throw var17_12;
        if (var16_6 == null) ** GOTO lbl39
        try {
            try {
                var15_5.close();
                throw var17_12;
            }
            catch (Throwable var18_13) {
                var16_6.addSuppressed(var18_13);
                throw var17_12;
            }
lbl39: // 1 sources:
            var15_5.close();
            throw var17_12;
lbl41: // 2 sources:
            if (var15_5 != null) {
                var15_5.close();
            }
        }
        catch (Exception var5_14) {
            new StringBuilder("loadVideoItems e=").append((Object)var5_14);
        }
        if (TextUtils.isEmpty((CharSequence)(var7_15 = d.b((Context)var1)))) {
            return var2_2;
        }
        var8_16 = z.a((String)var7_15, (int)4);
        if (var8_16.isEmpty()) {
            return var2_2;
        }
        var2_2.addAll((Collection)var8_16);
        var10_17 = new ArrayList();
        var11_18 = new HashSet();
        var12_19 = 0;
        do {
            if (var12_19 >= var2_2.size()) {
                Collections.sort((List)var10_17, (Comparator)new Comparator<g>(){

                    public final /* synthetic */ int compare(Object object, Object object2) {
                        g g2 = (g)object;
                        return Long.valueOf((long)((g)object2).w).compareTo(Long.valueOf((long)g2.w));
                    }
                });
                return var10_17;
            }
            if (!var11_18.contains((Object)((g)var2_2.get((int)var12_19)).i)) {
                var10_17.add(var2_2.get(var12_19));
                var11_18.add((Object)((g)var2_2.get((int)var12_19)).i);
            }
            ++var12_19;
        } while (true);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private List<g> d(Context var1) {
        block43 : {
            block41 : {
                block42 : {
                    block37 : {
                        block36 : {
                            block40 : {
                                block38 : {
                                    block39 : {
                                        var2_2 = new ArrayList();
                                        var3_3 = null;
                                        var32_4 = var1.getContentResolver().query(MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI, new String[]{"_id", "album_art"}, null, null, null);
                                        if (var32_4 == null) break block36;
                                        if (!var32_4.moveToFirst()) break block36;
                                        var6_5 = new SparseArray();
                                        try {
                                            do {
                                                var45_6 = var32_4.getInt(var32_4.getColumnIndex("_id"));
                                                var46_7 = var32_4.getString(var32_4.getColumnIndex("album_art"));
                                                if (!j.g((String)var46_7)) continue;
                                                var6_5.put(var45_6, (Object)var46_7);
                                            } while (var32_4.moveToNext());
                                            var32_4.close();
                                            break block37;
                                        }
                                        catch (Throwable var37_8) {
                                            var38_11 = var6_5;
                                            var39_12 = null;
                                            break block38;
                                        }
                                        catch (Throwable var44_13) {
                                            var36_14 = var6_5;
                                            var35_15 = var44_13;
                                            break block39;
                                        }
                                        catch (Throwable var43_16) {
                                            var40_17 = var43_16;
                                            var39_12 = null;
                                            var38_11 = null;
                                            break block40;
                                        }
                                        catch (Throwable var34_18) {
                                            var35_15 = var34_18;
                                            var36_14 = null;
                                        }
                                    }
                                    try {
                                        throw var35_15;
                                    }
                                    catch (Throwable var37_9) {
                                        var38_11 = var36_14;
                                        var39_12 = var35_15;
                                    }
                                }
                                var40_17 = var37_10;
                            }
                            if (var32_4 == null) throw var40_17;
                            if (var39_12 == null) ** GOTO lbl52
                            try {
                                try {
                                    var32_4.close();
                                    throw var40_17;
                                }
                                catch (Throwable var42_19) {
                                    var39_12.addSuppressed(var42_19);
                                    throw var40_17;
                                }
lbl52: // 1 sources:
                                var32_4.close();
                                throw var40_17;
                            }
                            catch (Exception var41_20) {
                                var5_21 = var41_20;
                                var6_5 = var38_11;
                            }
                            break block42;
                        }
                        var6_5 = null;
                    }
                    if (var32_4 != null) {
                        try {
                            var32_4.close();
                            break block41;
                        }
                        catch (Exception var33_22) {
                            var5_21 = var33_22;
                            break block42;
                        }
                    }
                    break block41;
                    catch (Exception var4_23) {
                        var5_21 = var4_23;
                        var6_5 = null;
                    }
                }
                new StringBuilder("loadAudioItems e=").append((Object)var5_21);
            }
            var8_24 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            var9_25 = new String[]{"_data", "_display_name", "_size", "duration", "album", "artist", "album_id", "date_modified"};
            var20_26 = var1.getContentResolver().query(var8_24, var9_25, null, null, "date_modified DESC");
            if (var20_26 == null) ** GOTO lbl125
            try {
                if (var20_26.moveToFirst()) {
                    do {
                        var25_29 = var20_26.getString(var20_26.getColumnIndex("_data"));
                        var26_28 = j.g((String)var25_29);
                        var3_3 = null;
                        if (!var26_28) continue;
                        var27_31 = new g();
                        var27_31.i = var25_29;
                        var27_31.h = Uri.fromFile((File)new File(var25_29)).toString();
                        var27_31.l = var20_26.getLong(var20_26.getColumnIndex("_size"));
                        var27_31.k = var20_26.getString(var20_26.getColumnIndex("_display_name"));
                        var27_31.v = var20_26.getLong(var20_26.getColumnIndex("duration"));
                        var27_31.w = var20_26.getLong(var20_26.getColumnIndex("date_modified"));
                        var27_31.x = var20_26.getString(var20_26.getColumnIndex("album"));
                        var27_31.y = var20_26.getString(var20_26.getColumnIndex("artist"));
                        var3_3 = null;
                        if (var6_5 != null && var6_5.size() > 0) {
                            var27_31.u = (String)var6_5.get((int)var20_26.getLong(var20_26.getColumnIndex("album_id")));
                        }
                        var28_27 = j.d((String)var27_31.k);
                        var29_30 = com.xiaomi.midrop.util.g.i.contains((Object)var28_27);
                        var3_3 = null;
                        if (!var29_30) continue;
                        var2_2.add((Object)var27_31);
                    } while (var31_32 = var20_26.moveToNext());
                }
                ** GOTO lbl125
            }
            catch (Throwable var22_33) {
                var23_34 = var3_3;
                break block43;
            }
            catch (Throwable var21_35) {
                var3_3 = var21_35;
                throw var3_3;
            }
        }
        if (var20_26 == null) throw var22_33;
        if (var23_34 == null) ** GOTO lbl123
        try {
            try {
                var20_26.close();
                throw var22_33;
            }
            catch (Throwable var24_36) {
                var23_34.addSuppressed(var24_36);
                throw var22_33;
            }
lbl123: // 1 sources:
            var20_26.close();
            throw var22_33;
lbl125: // 2 sources:
            if (var20_26 != null) {
                var20_26.close();
            }
        }
        catch (Exception var10_37) {
            new StringBuilder("loadAudioItems e=").append((Object)var10_37);
        }
        if (TextUtils.isEmpty((CharSequence)(var12_38 = d.b((Context)var1)))) {
            return var2_2;
        }
        var13_39 = z.a((String)var12_38, (int)3);
        if (var13_39.isEmpty()) {
            return var2_2;
        }
        var2_2.addAll((Collection)var13_39);
        var15_40 = new ArrayList();
        var16_41 = new HashSet();
        var17_42 = 0;
        do {
            if (var17_42 >= var2_2.size()) {
                Collections.sort((List)var15_40, (Comparator)new Comparator<g>(){

                    public final /* synthetic */ int compare(Object object, Object object2) {
                        g g2 = (g)object;
                        return Long.valueOf((long)((g)object2).w).compareTo(Long.valueOf((long)g2.w));
                    }
                });
                return var15_40;
            }
            if (!var16_41.contains((Object)((g)var2_2.get((int)var17_42)).i)) {
                var15_40.add(var2_2.get(var17_42));
                var16_41.add((Object)((g)var2_2.get((int)var17_42)).i);
            }
            ++var17_42;
        } while (true);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final List<g> a(int var1) {
        block19 : {
            block20 : {
                block18 : {
                    var2_2 = new ArrayList();
                    var15_3 = this;
                    // MONITORENTER : var15_3
                    var3_4 = null;
                    var7_5 = MiDropApplication.a().getContentResolver().query(MediaStore.Files.getContentUri((String)"external"), h.f, null, null, null);
                    if (var7_5 == null) break block18;
                    try {
                        var8_6 = var7_5.getColumnIndex("date_modified");
                        var9_7 = var7_5.getColumnIndex("_size");
                    }
                    catch (Throwable var6_12) {
                        break block19;
                    }
                    catch (Exception var4_15) {
                        var3_4 = var7_5;
                        ** GOTO lbl-1000
                    }
                    block12 : while (var7_5.moveToNext()) {
                        var10_11 = var7_5.getString(1);
                        var11_8 = j.d((String)var10_11);
                        if (var1 == 5 && com.xiaomi.midrop.util.g.e((String)var11_8) != false || var1 == 8 && com.xiaomi.midrop.util.g.f((String)var11_8) != false || var1 == 9 && com.xiaomi.midrop.util.g.g((String)var11_8)) lbl-1000: // 2 sources:
                        {
                            while ((var12_10 = new File(var10_11)).exists()) {
                                var13_9 = new g();
                                var13_9.k = var12_10.getName();
                                var13_9.i = var12_10.getAbsolutePath();
                                var13_9.w = var7_5.getLong(var8_6);
                                if (!var12_10.isDirectory()) {
                                    var13_9.l = var7_5.getLong(var9_7);
                                    if (var13_9.l == 0L) continue block12;
                                }
                                if (var1 == 10) {
                                    com.xiaomi.midrop.util.a.a((g)var13_9, null);
                                }
                                var2_2.add((Object)var13_9);
                                continue block12;
                            }
                            continue;
                        }
                        if (var1 != 10 && var1 != 11 || !com.xiaomi.midrop.util.g.d((String)var11_8)) continue;
                        ** GOTO lbl-1000
                    }
                }
                if (var7_5 != null) {
                    var7_5.close();
                }
                break block20;
                catch (Throwable var6_13) {
                    var7_5 = var3_4;
                    break block19;
                }
                catch (Exception var4_16) {
                    // empty catch block
                }
lbl-1000: // 2 sources:
                {
                    var4_17.printStackTrace();
                    if (var3_4 == null) break block20;
                }
                var3_4.close();
                // MONITOREXIT : var15_3
            }
            Collections.sort((List)var2_2, (Comparator)new Comparator<g>(){});
            return var2_2;
        }
        if (var7_5 == null) throw var6_14;
        var7_5.close();
        throw var6_14;
    }

    /*
     * Exception decompiling
     */
    public final List<g> a(String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl62 : ALOAD : trying to set 1 previously set to 0
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

    public final void a(int n, a a2) {
        if (!this.c.get(n)) {
            List list = (List)this.a.get(n);
            if (list == null) {
                list = new ArrayList(0);
            }
            if (list.isEmpty() && a2 != null) {
                h.super.b(n, a2);
            }
            if (a2 != null) {
                a2.a(n, (List<g>)list);
            }
            return;
        }
        if (!this.d) {
            this.b();
        }
        if (a2 != null) {
            h.super.b(n, a2);
        }
    }

    public final void b() {
        this.d = true;
        this.b(2);
        this.b(4);
        this.b(3);
        this.b(1);
        this.b(11);
        this.b(10);
    }

    public static interface a {
        public void a(int var1, List<g> var2);
    }

}

