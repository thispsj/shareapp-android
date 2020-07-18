/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.AsyncTask
 *  android.text.TextUtils
 *  android.util.ArrayMap
 *  com.xiaomi.globalmiuiapp.common.view.CommonWebView
 *  com.xiaomi.midrop.activity.a$b$1
 *  com.xiaomi.midrop.activity.a$b$2
 *  com.xiaomi.midrop.base.http.SimpleResp
 *  com.xiaomi.midrop.util.y
 *  d.b
 *  d.d
 *  d.l
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Date
 *  java.util.GregorianCalendar
 *  java.util.List
 *  java.util.Map
 *  java.util.TimeZone
 *  java.util.concurrent.Executor
 *  java.util.concurrent.TimeUnit
 *  midrop.service.c.c
 *  midrop.service.c.d
 *  okhttp3.ab
 *  okhttp3.ac
 *  okhttp3.v
 *  org.json.JSONObject
 */
package com.xiaomi.midrop.activity;

import android.app.Activity;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.github.lzyzsd.jsbridge.d;
import com.xiaomi.globalmiuiapp.common.f.e;
import com.xiaomi.globalmiuiapp.common.view.CommonWebView;
import com.xiaomi.midrop.activity.ActivityRetrofitApi;
import com.xiaomi.midrop.activity.a;
import com.xiaomi.midrop.base.http.SimpleResp;
import com.xiaomi.midrop.e.a;
import com.xiaomi.midrop.util.y;
import d.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import midrop.service.c.c;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.v;
import org.json.JSONObject;

public final class a {
    private static final Object a = new Object();
    private static boolean b;

    static /* synthetic */ Object a() {
        return a;
    }

    public static String a(ArrayList<Long> arrayList) {
        Collections.sort(arrayList);
        String string2 = String.format((String)"%s&key=%s", (Object[])new Object[]{TextUtils.join((CharSequence)"", arrayList), "ejh3cNfYd7NB153hRRhSRw6agSt37UUR"});
        try {
            String string3 = e.a(string2);
            return string3;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static void a(Activity activity, CommonWebView commonWebView, String string2, d d2) {
        if (b) {
            if (d2 != null) {
                Object[] arrobject = new Object[]{false};
                CommonWebView.a((String)"syncTransRecords", (d)d2, (Object[])arrobject);
            }
            return;
        }
        b = true;
        new b(activity, commonWebView, string2, d2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
    }

    private static final class a {
        l<SimpleResp<String>> a;

        private a() {
        }

        /* synthetic */ a(byte by) {
        }
    }

    private static final class b
    extends AsyncTask<Void, Void, Boolean> {
        WeakReference<Activity> a;
        WeakReference<CommonWebView> b;
        d c;
        String d;

        b(Activity activity, CommonWebView commonWebView, String string2, d d2) {
            this.a = new WeakReference((Object)activity);
            this.b = new WeakReference((Object)commonWebView);
            this.c = d2;
            this.d = string2;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        private /* varargs */ Boolean a() {
            block26 : {
                block30 : {
                    block25 : {
                        block24 : {
                            block31 : {
                                block29 : {
                                    if (!TextUtils.isEmpty((CharSequence)this.d)) break block29;
                                    var3_1 = "MiDrop:ActivityHelper";
                                    var4_2 = "activityId is null";
                                    break block26;
                                }
                                var1_3 = y.x();
                                var2_4 = y.y();
                                if (TextUtils.isEmpty((CharSequence)var1_3) || TextUtils.isEmpty((CharSequence)var2_4)) break block30;
                                var5_5 = String.valueOf((int)c.a());
                                if (!TextUtils.isEmpty((CharSequence)var5_5)) break block31;
                                var3_1 = "MiDrop:ActivityHelper";
                                var4_2 = "device is null";
                                break block26;
                            }
                            if (y.a((String)this.d, (String)var5_5)) ** GOTO lbl45
                            var38_6 = new a(0);
                            com.xiaomi.globalmiuiapp.common.http.b.a(ActivityRetrofitApi.class).registerDevice(var1_3, this.d, var5_5).a((d.d)new 1(this, var38_6));
                            var44_8 = var39_7 = a.a();
                            // MONITORENTER : var44_8
                            try {
                                a.a().wait();
                                break block24;
                            }
                            catch (Throwable var43_9) {
                                break block25;
                            }
                            catch (Exception var40_10) {
                                midrop.service.c.d.a((String)"MiDrop:ActivityHelper", (String)"requestLock wait exception", (Throwable)var40_10, (Object[])new Object[0]);
                            }
                        }
                        // MONITOREXIT : var44_8
                        var41_11 = var38_6.a;
                        if (var41_11 == null || !var41_11.a.a() || var41_11.b == null || ((SimpleResp)var41_11.b).getCode() != 0) {
                            midrop.service.c.d.a((String)"MiDrop:ActivityHelper", (String)"register device failed", (Object[])new Object[0]);
                            return false;
                        }
                        y.b((String)this.d, (String)var5_5);
                        ** GOTO lbl45
                    }
                    try {
                        throw var43_9;
                    }
                    catch (Exception var23_13) {
                        block32 : {
                            block28 : {
                                block27 : {
                                    var24_16 = "MiDrop:ActivityHelper";
                                    var25_17 = "register device failed";
                                    break block32;
lbl45: // 2 sources:
                                    if ((var6_18 = com.xiaomi.midrop.e.a.a(this.d)) == null) return true;
                                    if (var6_18.isEmpty()) {
                                        return true;
                                    }
                                    var7_19 = new ArrayList();
                                    var8_20 = new ArrayList();
                                    for (a.c var32_23 : var6_18) {
                                        if (TextUtils.isEmpty((CharSequence)var32_23.a)) continue;
                                        var33_22 = new ArrayMap();
                                        var33_22.put((Object)"uid", (Object)var32_23.a);
                                        var33_22.put((Object)"timestamp", (Object)var32_23.b);
                                        var7_19.add((Object)var33_22);
                                        var8_20.add((Object)var32_23.b);
                                    }
                                    var10_24 = new ArrayMap();
                                    var10_24.put((Object)"uid", (Object)var5_5);
                                    var10_24.put((Object)"activity", (Object)this.d);
                                    var10_24.put((Object)"timestamp", (Object)System.currentTimeMillis());
                                    var10_24.put((Object)"to", (Object)var7_19);
                                    var15_25 = new GregorianCalendar().getTimeZone();
                                    var16_26 = var15_25.getRawOffset();
                                    var17_27 = var15_25.inDaylightTime(new Date()) != false ? var15_25.getDSTSavings() : 0;
                                    var18_28 = var16_26 + var17_27;
                                    var10_24.put((Object)"timezone", (Object)TimeUnit.HOURS.convert((long)var18_28, TimeUnit.MILLISECONDS));
                                    var20_29 = a.a((ArrayList<Long>)var8_20);
                                    if (TextUtils.isEmpty((CharSequence)var20_29)) {
                                        var3_1 = "MiDrop:ActivityHelper";
                                        var4_2 = "sign is empty";
                                        break block26;
                                    }
                                    var10_24.put((Object)"sign", (Object)var20_29);
                                    var22_30 = new a(0);
                                    var26_31 = ab.a((v)v.a((String)"application/json; charset=utf-8"), (String)new JSONObject((Map)var10_24).toString());
                                    com.xiaomi.globalmiuiapp.common.http.b.a(ActivityRetrofitApi.class).syncTransRecords(var2_4, var26_31).a((d.d)new 2(this, var22_30));
                                    var45_33 = var27_32 = a.a();
                                    // MONITORENTER : var45_33
                                    try {
                                        a.a().wait();
                                        break block27;
                                    }
                                    catch (Throwable var31_34) {
                                        break block28;
                                    }
                                    catch (Exception var28_35) {
                                        midrop.service.c.d.a((String)"MiDrop:ActivityHelper", (String)"requestLock wait exception", (Throwable)var28_35, (Object[])new Object[0]);
                                    }
                                }
                                // MONITOREXIT : var45_33
                                var29_36 = var22_30.a;
                                if (var29_36 == null) return false;
                                if (var29_36.a.a() == false) return false;
                                if (var29_36.b == null) return false;
                                if (((SimpleResp)var29_36.b).getCode() != 0) return false;
                                com.xiaomi.midrop.e.a.b(this.d);
                                return true;
                            }
                            try {
                                throw var31_34;
                            }
                            catch (Exception var23_15) {
                                var24_16 = "MiDrop:ActivityHelper";
                                var25_17 = "sync trans records failed";
                            }
                        }
                        midrop.service.c.d.a((String)var24_16, (String)var25_17, (Throwable)var23_14, (Object[])new Object[0]);
                        return false;
                    }
                }
                var3_1 = "MiDrop:ActivityHelper";
                var4_2 = "initApi or syncApi is null";
            }
            midrop.service.c.d.a((String)var3_1, (String)var4_2, (Object[])new Object[0]);
            return false;
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

        protected final /* synthetic */ void onPostExecute(Object object) {
            Boolean bl = (Boolean)object;
            super.onPostExecute((Object)bl);
            Activity activity = (Activity)this.a.get();
            CommonWebView commonWebView = (CommonWebView)this.b.get();
            if (activity != null && commonWebView != null && this.c != null && !activity.isFinishing() && !activity.isDestroyed()) {
                CommonWebView.a((String)"syncTransRecords", (d)this.c, (Object[])new Object[]{bl});
            }
            b = false;
        }
    }

}

