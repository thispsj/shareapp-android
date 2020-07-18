/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.database.Cursor
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.util.Log
 *  com.xiaomi.midrop.util.j
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  midrop.service.c.d
 */
package com.xiaomi.midrop.sender.c;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.midrop.util.j;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import midrop.service.c.d;

public final class e {
    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static String a(Context var0_1, Uri var1) {
        block8 : {
            block7 : {
                var2_2 = null;
                var9_3 = var0_1.getContentResolver().query(var1, new String[]{"_data"}, null, null, null);
                var10_4 = null;
                if (var9_3 == null) break block7;
                try {
                    var11_5 = var9_3.moveToFirst();
                    var10_4 = null;
                    if (!var11_5) break block7;
                    var10_4 = var9_3.getString(var9_3.getColumnIndex("_data"));
                }
                catch (Throwable var8_6) {
                    var2_2 = var9_3;
                    break block8;
                }
                catch (Exception var3_9) {
                    var2_2 = var9_3;
                    ** GOTO lbl-1000
                }
            }
            if (var9_3 == null) return var10_4;
            var9_3.close();
            return var10_4;
            catch (Throwable var8_7) {
                break block8;
            }
            catch (Exception var3_10) {
                // empty catch block
            }
lbl-1000: // 2 sources:
            {
                var4_12 = new StringBuilder("resolveFilePath uri = ");
                var4_12.append((Object)var1);
                var4_12.append("error!");
                d.a((String)"FilePathConverter", (String)var4_12.toString(), (Throwable)var3_11, (Object[])new Object[0]);
                var7_13 = e.d(var0_1, var1);
                if (var2_2 == null) return var7_13;
            }
            var2_2.close();
            return var7_13;
        }
        if (var2_2 == null) throw var8_8;
        var2_2.close();
        throw var8_8;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static ArrayList<Uri> a(Context context, ArrayList<Uri> arrayList) {
        ArrayList arrayList2;
        block5 : {
            arrayList2 = new ArrayList();
            if (arrayList == null) break block5;
            if (arrayList.isEmpty()) {
                return arrayList2;
            }
            for (Uri uri : arrayList) {
                block8 : {
                    block7 : {
                        String string2;
                        block6 : {
                            if (uri == null) continue;
                            string2 = uri.getScheme();
                            if (!"content".equals((Object)string2)) break block6;
                            String string3 = e.c(context, uri);
                            if (TextUtils.isEmpty((CharSequence)string3)) continue;
                            uri = Uri.parse((String)string3);
                            break block7;
                        }
                        if (!"file".equals((Object)string2) && !"midrop.contact".equals((Object)string2)) break block8;
                    }
                    arrayList2.add((Object)uri);
                    continue;
                }
                d.b((String)"FilePathConverter", (String)"uri scheme is invalid", (Object[])new Object[0]);
            }
        }
        return arrayList2;
    }

    /*
     * Exception decompiling
     */
    private static Bitmap b(Context var0, Uri var1) throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl47 : ALOAD_3 : trying to set 1 previously set to 0
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
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static String c(Context context, Uri uri) {
        IOException iOException;
        String string2;
        block9 : {
            String string3;
            Bitmap bitmap;
            block8 : {
                string2 = e.a(context, uri);
                if (!TextUtils.isEmpty((CharSequence)string2)) return string2;
                bitmap = e.b(context, uri);
                if (bitmap == null) return string2;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(context.getCacheDir().getPath());
                stringBuilder.append("/share");
                File file = new File(stringBuilder.toString());
                if (!file.exists()) {
                    file.mkdirs();
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(file.getPath());
                stringBuilder2.append("/shared_");
                stringBuilder2.append(uri.getLastPathSegment());
                stringBuilder2.append(".jpg");
                string3 = stringBuilder2.toString();
                if (bitmap == null) break block8;
                FileOutputStream fileOutputStream = new FileOutputStream(string3);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 50, (OutputStream)fileOutputStream);
                {
                    catch (Throwable throwable) {
                        fileOutputStream.close();
                        throw throwable;
                    }
                }
                fileOutputStream.close();
            }
            try {
                bitmap.recycle();
                return string3;
            }
            catch (IOException iOException2) {
                string2 = string3;
                iOException = iOException2;
            }
            break block9;
            catch (IOException iOException3) {
                // empty catch block
            }
        }
        iOException.printStackTrace();
        return string2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static String d(Context var0_1, Uri var1) {
        block49 : {
            block48 : {
                block47 : {
                    block45 : {
                        block44 : {
                            try {
                                var6_2 = var0_1.getContentResolver().query(var1, new String[]{"_display_name"}, null, null, null);
                            }
                            catch (Exception var2_3) {
                                var3_4 = new StringBuilder("getPath uri = ");
                                var3_4.append((Object)var1);
                                var3_4.append("error!");
                                d.a((String)"FilePathConverter", (String)var3_4.toString(), (Throwable)var2_3, (Object[])new Object[0]);
                                var6_2 = null;
                            }
                            var7_5 = null;
                            if (var6_2 == null) break block47;
                            var9_6 = var6_2.moveToFirst();
                            var7_5 = null;
                            if (!var9_6) break block47;
                            var10_7 = var6_2.getString(var6_2.getColumnIndex("_display_name"));
                            var25_8 = var0_1.getContentResolver().openInputStream(var1);
                            var26_9 = new File(j.a((Context)var0_1), var10_7);
                            if (var26_9.exists()) {
                                var26_9.delete();
                            }
                            var27_10 = new FileOutputStream(var26_9);
                            var34_11 = new byte[4096];
                            while ((var35_12 = var25_8.read(var34_11)) != -1) {
                                var27_10.write(var34_11, 0, var35_12);
                            }
                            var27_10.flush();
                            var8_13 /* !! */  = var26_9.getAbsolutePath();
                            try {
                                var27_10.close();
                                break block44;
                            }
                            catch (SecurityException var22_14) {
                                ** GOTO lbl76
                            }
                            catch (NullPointerException var19_18) {
                                ** GOTO lbl80
                            }
                            catch (FileNotFoundException var11_22) {
                                break block45;
                            }
                            catch (IOException var36_26) {
                                var36_26.printStackTrace();
                            }
                        }
                        var7_5 = var8_13 /* !! */ ;
                        ** GOTO lbl56
                        {
                            block46 : {
                                catch (Throwable var32_27) {
                                    break block46;
                                }
                                catch (Exception var28_28) {}
                                {
                                    var28_28.printStackTrace();
                                }
                                try {
                                    var27_10.close();
                                    var7_5 = null;
                                }
                                catch (IOException var29_29) {
                                    var29_29.printStackTrace();
                                }
lbl56: // 3 sources:
                                if (var25_8 == null) break block47;
                                try {
                                    var25_8.close();
                                }
                                catch (Exception var30_30) {
                                    Log.e((String)"FilePathConverter", (String)"could not close stream", (Throwable)var30_30);
                                }
                                break block47;
                            }
                            try {
                                try {
                                    var27_10.close();
                                    throw var32_27;
                                }
                                catch (IOException var33_31) {
                                    var33_31.printStackTrace();
                                }
                                throw var32_27;
                            }
                            catch (Throwable var16_32) {
                                var7_5 = var25_8;
                                break block48;
                            }
                            catch (SecurityException var22_15) {
                                var8_13 /* !! */  = null;
                            }
lbl76: // 2 sources:
                            var7_5 = var25_8;
                            ** GOTO lbl-1000
                            catch (NullPointerException var19_19) {
                                var8_13 /* !! */  = null;
                            }
lbl80: // 2 sources:
                            var7_5 = var25_8;
                            ** GOTO lbl-1000
                            catch (FileNotFoundException var11_23) {
                                var8_13 /* !! */  = null;
                            }
                        }
                    }
                    var7_5 = var25_8;
                    ** GOTO lbl-1000
                }
                var8_13 /* !! */  = var7_5;
                break block49;
                catch (Throwable var16_33) {
                    break block48;
                }
                catch (SecurityException var22_17) {
                    var8_13 /* !! */  = null;
                }
lbl-1000: // 2 sources:
                {
                    var23_35 = new StringBuilder("SecurityException uri ");
                    var23_35.append((Object)var1);
                    d.a((String)"FilePathConverter", (String)var23_35.toString(), (Throwable)var22_16, (Object[])new Object[0]);
                    ** if (var7_5 == null) goto lbl-1000
                }
lbl-1000: // 1 sources:
                {
                    var7_5.close();
                }
lbl-1000: // 1 sources:
                {
                    break block49;
                }
                catch (NullPointerException var19_21) {
                    var8_13 /* !! */  = null;
                }
lbl-1000: // 2 sources:
                {
                    var20_37 = new StringBuilder("uri ");
                    var20_37.append((Object)var1);
                    d.a((String)"FilePathConverter", (String)var20_37.toString(), (Throwable)var19_20, (Object[])new Object[0]);
                    ** if (var7_5 == null) goto lbl-1000
                }
lbl-1000: // 1 sources:
                {
                    var7_5.close();
                }
lbl-1000: // 2 sources:
                {
                    break block49;
                }
                catch (FileNotFoundException var11_25) {
                    var8_13 /* !! */  = null;
                }
lbl-1000: // 2 sources:
                {
                    var12_38 = new StringBuilder("file not found: ");
                    var12_38.append((Object)var1);
                    d.a((String)"FilePathConverter", (String)var12_38.toString(), (Throwable)var11_24, (Object[])new Object[0]);
                    ** if (var7_5 == null) goto lbl-1000
                }
lbl-1000: // 1 sources:
                {
                    var7_5.close();
                }
lbl-1000: // 2 sources:
                {
                    break block49;
                }
                catch (Exception var14_36) {
                    Log.e((String)"FilePathConverter", (String)"could not close stream", (Throwable)var14_36);
                }
                break block49;
            }
            if (var7_5 == null) throw var16_34;
            try {
                var7_5.close();
                throw var16_34;
            }
            catch (Exception var17_39) {
                Log.e((String)"FilePathConverter", (String)"could not close stream", (Throwable)var17_39);
            }
            throw var16_34;
        }
        if (var6_2 == null) return var8_13 /* !! */ ;
        var6_2.close();
        return var8_13 /* !! */ ;
    }
}

