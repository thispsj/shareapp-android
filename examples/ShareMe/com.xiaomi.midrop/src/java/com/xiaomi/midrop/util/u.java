/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Parcelable
 *  android.support.v4.content.FileProvider
 *  android.support.v7.app.c
 *  android.support.v7.app.d
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$h
 *  android.support.v7.widget.RecyclerView$i
 *  android.support.v7.widget.RecyclerView$k
 *  android.support.v7.widget.RecyclerView$m
 *  android.support.v7.widget.aj
 *  android.support.v7.widget.ar
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.widget.Scroller
 *  android.widget.Toast
 *  com.xiaomi.midrop.coolboot.activity.CoolBootActivity
 *  com.xiaomi.midrop.receiver.ui.ReceiveActivity
 *  com.xiaomi.midrop.sender.c.g
 *  com.xiaomi.midrop.sender.ui.TransmissionActivity
 *  com.xiaomi.midrop.util.u$1
 *  com.xiaomi.midrop.view.sendchooser.SendAppChooserAdapter
 *  com.xiaomi.midrop.view.sendchooser.b
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 */
package com.xiaomi.midrop.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.aj;
import android.support.v7.widget.ar;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import android.widget.Toast;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.coolboot.activity.CoolBootActivity;
import com.xiaomi.midrop.receiver.ui.ReceiveActivity;
import com.xiaomi.midrop.sender.c.d;
import com.xiaomi.midrop.sender.ui.TransmissionActivity;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.g;
import com.xiaomi.midrop.util.j;
import com.xiaomi.midrop.util.u;
import com.xiaomi.midrop.util.v;
import com.xiaomi.midrop.util.x;
import com.xiaomi.midrop.view.c;
import com.xiaomi.midrop.view.sendchooser.SendAppChooserAdapter;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class u {
    static ArrayList<Uri> a(ArrayList<Uri> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        for (Uri uri : arrayList) {
            String string2 = j.d(uri.getPath());
            if (g.l.contains((Object)string2)) {
                arrayList2.add((Object)uri);
                continue;
            }
            if (g.i.contains((Object)string2)) {
                arrayList3.add((Object)uri);
                continue;
            }
            if (g.h.contains((Object)string2)) {
                arrayList4.add((Object)uri);
                continue;
            }
            if (g.j.contains((Object)string2)) {
                arrayList5.add((Object)uri);
                continue;
            }
            arrayList6.add((Object)uri);
        }
        arrayList7.addAll((Collection)arrayList2);
        arrayList7.addAll((Collection)arrayList3);
        arrayList7.addAll((Collection)arrayList4);
        arrayList7.addAll((Collection)arrayList5);
        arrayList7.addAll((Collection)arrayList6);
        return arrayList7;
    }

    static /* synthetic */ List a(Context context, Intent intent, List list) {
        ArrayList arrayList = new ArrayList();
        List<ResolveInfo> list2 = x.a(intent);
        if (!list2.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            PackageManager packageManager = context.getPackageManager();
            for (ResolveInfo resolveInfo : list2) {
                if (resolveInfo.activityInfo == null || list.contains((Object)resolveInfo.activityInfo.packageName)) continue;
                HashMap hashMap = new HashMap();
                hashMap.put((Object)"packageName", (Object)resolveInfo.activityInfo.packageName);
                hashMap.put((Object)"className", (Object)resolveInfo.activityInfo.name);
                hashMap.put((Object)"filePath", (Object)resolveInfo.activityInfo.applicationInfo.sourceDir);
                hashMap.put((Object)"simpleName", (Object)resolveInfo.loadLabel(packageManager).toString());
                arrayList2.add((Object)hashMap);
            }
            if (!arrayList2.isEmpty()) {
                Collections.sort((List)arrayList2, (Comparator)new Comparator<HashMap<String, String>>(){

                    public final /* synthetic */ int compare(Object object, Object object2) {
                        HashMap hashMap = (HashMap)object;
                        HashMap hashMap2 = (HashMap)object2;
                        return ((String)hashMap.get((Object)"simpleName")).compareTo((String)hashMap2.get((Object)"simpleName"));
                    }
                });
                com.xiaomi.midrop.view.sendchooser.a a2 = null;
                for (HashMap hashMap : arrayList2) {
                    String string2 = (String)hashMap.get((Object)"packageName");
                    com.xiaomi.midrop.view.sendchooser.a a3 = new com.xiaomi.midrop.view.sendchooser.a((String)hashMap.get((Object)"simpleName"), (String)hashMap.get((Object)"filePath"), string2, (String)hashMap.get((Object)"className"));
                    if (TextUtils.equals((CharSequence)"com.xiaomi.midrop", (CharSequence)string2)) {
                        a2 = a3;
                        continue;
                    }
                    arrayList.add((Object)a3);
                }
                if (a2 != null) {
                    arrayList.add(0, a2);
                }
            }
        }
        return arrayList;
    }

    public static void a(android.support.v7.app.d d2, String string2, String string3, boolean bl, boolean bl2, Intent intent) {
        ArrayList arrayList;
        Intent intent2;
        block17 : {
            block16 : {
                block14 : {
                    block15 : {
                        arrayList = com.xiaomi.midrop.sender.c.g.e().f();
                        if (intent != null && !TextUtils.isEmpty((CharSequence)intent.getAction())) {
                            if (intent.getAction().equals((Object)"android.intent.action.SEND") || intent.getAction().equals((Object)"android.intent.action.SEND_MULTIPLE") || intent.getAction().equals((Object)"com.xiaomi.midrop.FILE_LIST_SHARE")) {
                                try {
                                    intent.setClass((Context)d2, TransmissionActivity.class);
                                    intent.putExtra("is_dialog_shown", bl2);
                                    d2.startActivity(intent);
                                }
                                catch (Exception exception) {
                                    new StringBuilder("sendFiles except=").append((Object)exception);
                                }
                            }
                            if (bl) {
                                d2.finish();
                            }
                            return;
                        }
                        if (arrayList.isEmpty()) {
                            Toast.makeText((Context)d2, (int)2131689768, (int)0).show();
                            return;
                        }
                        d.a = u.a((ArrayList<Uri>)arrayList);
                        if (TextUtils.isEmpty((CharSequence)string2) || TextUtils.equals((CharSequence)string2, (CharSequence)"from_sender") || TextUtils.equals((CharSequence)string2, (CharSequence)"from_other") || TextUtils.equals((CharSequence)string2, (CharSequence)"com.xiaomi.CHOOSE_SEND")) break block14;
                        if (!TextUtils.equals((CharSequence)string2, (CharSequence)"from_receiver")) break block15;
                        intent2 = new Intent((Context)d2, ReceiveActivity.class);
                        break block16;
                    }
                    boolean bl3 = TextUtils.equals((CharSequence)string2, (CharSequence)"from_webshare");
                    intent2 = null;
                    if (bl3) {
                        intent2 = new Intent((Context)d2, CoolBootActivity.class);
                        intent2.putParcelableArrayListExtra("webshare_uris", arrayList);
                        af.a(af.a.dP).a(af.b.at, 4).a();
                    }
                    break block17;
                }
                intent2 = new Intent((Context)d2, TransmissionActivity.class);
                intent2.putExtra("is_dialog_shown", bl2);
            }
            intent2.setAction("com.xiaomi.midrop.FILE_LIST_SHARE");
        }
        if (intent2 == null) {
            return;
        }
        try {
            if (!(TextUtils.isEmpty((CharSequence)string2) || TextUtils.equals((CharSequence)string2, (CharSequence)"com.xiaomi.CHOOSE_SEND") || TextUtils.equals((CharSequence)string2, (CharSequence)"from_other"))) {
                d2.startActivity(intent2);
            } else {
                d2.startActivityForResult(intent2, 1000);
            }
        }
        catch (Exception exception) {
            new StringBuilder("Exception when starting ").append((Object)exception);
        }
        if (bl) {
            d2.finish();
        }
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            u.b((ArrayList<Uri>)arrayList, string3);
        }
    }

    private static void b(ArrayList<Uri> arrayList, String string2) {
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                return;
            }
            Iterator iterator = arrayList.iterator();
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            int n5 = 0;
            int n6 = 0;
            int n7 = 0;
            while (iterator.hasNext()) {
                Uri uri = (Uri)iterator.next();
                String string3 = j.d(uri.getPath());
                if (g.l.contains((Object)string3)) {
                    ++n2;
                    continue;
                }
                if (g.i.contains((Object)string3)) {
                    ++n3;
                    continue;
                }
                if (g.h.contains((Object)string3)) {
                    ++n4;
                    continue;
                }
                if (g.j.contains((Object)string3)) {
                    ++n5;
                    continue;
                }
                if (new File(uri.getPath()).isDirectory()) {
                    ++n7;
                    continue;
                }
                ++n6;
            }
            int n8 = 0;
            if (n2 != 0) {
                n8 = 1;
            }
            if (n3 != 0) {
                ++n8;
            }
            if (n4 != 0) {
                ++n8;
            }
            if (n5 != 0) {
                ++n8;
            }
            if (n6 != 0) {
                ++n8;
            }
            if (n7 != 0) {
                ++n8;
            }
            af.a(af.a.F).a(af.b.d, n5).a(af.b.a, n2).a(af.b.b, n3).a(af.b.c, n4).a(af.b.e, n6).a(af.b.g, n8).a(af.b.h, n7).a(af.b.i, string2).a();
        }
    }

    private static final class a
    extends AsyncTask<Void, Void, List<com.xiaomi.midrop.view.sendchooser.a>> {
        private WeakReference<android.support.v7.app.d> a;
        private String b;
        private ArrayList<Uri> c;
        private ArrayList<Uri> d;
        private Intent e;
        private b f;

        public a(android.support.v7.app.d d2, List<Uri> list, String string2, b b2) {
            this.a = new WeakReference((Object)d2);
            this.d = new ArrayList(list);
            this.b = string2;
            this.f = b2;
        }

        private /* varargs */ List<com.xiaomi.midrop.view.sendchooser.a> a() {
            Context context;
            ArrayList arrayList;
            boolean bl;
            String string2;
            block17 : {
                context = MiDropApplication.a();
                this.c = u.a(this.d);
                ArrayList arrayList2 = new ArrayList();
                Iterator iterator = this.c.iterator();
                while (iterator.hasNext()) {
                    arrayList2.add((Object)new File(((Uri)iterator.next()).getPath()));
                }
                arrayList = new ArrayList();
                string2 = "";
                for (File file : arrayList2) {
                    Uri uri;
                    block19 : {
                        String string3;
                        block18 : {
                            if (file.isDirectory()) {
                                bl = true;
                                break block17;
                            }
                            string3 = v.a(j.d(file.getName()));
                            if (string3.equals((Object)"*/*")) {
                                string3 = v.b(file.getPath());
                            }
                            if (TextUtils.isEmpty((CharSequence)string2)) break block18;
                            if (string2.equals((Object)"*/*") || string2.equals((Object)string3)) break block19;
                            String string4 = string2.substring(0, 1 + string2.indexOf("/"));
                            if (string3.startsWith(string4)) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(string4);
                                stringBuilder.append("*");
                                string3 = stringBuilder.toString();
                            } else {
                                string3 = "*/*";
                            }
                        }
                        string2 = string3;
                    }
                    try {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(context.getPackageName());
                        stringBuilder.append(".fileProvider");
                        uri = FileProvider.a((Context)context, (String)stringBuilder.toString(), (File)file);
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                        uri = null;
                    }
                    if (uri == null) continue;
                    arrayList.add(uri);
                }
                bl = false;
            }
            if (bl) {
                this.e = new Intent("com.xiaomi.midrop.FILE_LIST_SHARE");
            } else {
                if (arrayList.isEmpty()) {
                    return null;
                }
                boolean bl2 = arrayList.size() > 1;
                String string5 = bl2 ? "android.intent.action.SEND_MULTIPLE" : "android.intent.action.SEND";
                this.e = new Intent(string5);
                this.e.setFlags(1);
                this.e.setType(string2);
                if (bl2) {
                    this.e.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                } else {
                    this.e.putExtra("android.intent.extra.STREAM", (Parcelable)arrayList.get(0));
                }
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add((Object)"com.lenovo.anyshare.gps");
            arrayList3.add((Object)"com.lenovo.anyshare");
            arrayList3.add((Object)"cn.xender");
            return u.a(context, this.e, (List)arrayList3);
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
            List list = (List)object;
            super.onPostExecute((Object)list);
            android.support.v7.app.d d2 = (android.support.v7.app.d)this.a.get();
            if (d2 != null && !d2.isFinishing()) {
                if (d2.isDestroyed()) {
                    return;
                }
                if (list != null && !list.isEmpty()) {
                    ArrayList<Uri> arrayList = this.c;
                    Intent intent = this.e;
                    b b2 = this.f;
                    if (d2 != null && !d2.isFinishing() && !d2.isDestroyed()) {
                        c c2 = new c((Context)d2);
                        c2.h = true;
                        c2.a(2131689544, null).c(2131427561);
                        android.support.v7.app.c c3 = c2.d();
                        View view = c2.d(2131296427);
                        view.setPadding(view.getPaddingLeft(), com.xiaomi.miftp.c.d.a(), view.getPaddingRight(), view.getPaddingBottom());
                        c2.d(2131296812).setVisibility(8);
                        c2.d(2131296653).setVisibility(8);
                        c2.d(2131296426).setVisibility(8);
                        RecyclerView recyclerView = (RecyclerView)c2.d(2131296676);
                        recyclerView.setLayoutManager((RecyclerView.i)new LinearLayoutManager((Context)d2, 0, false));
                        SendAppChooserAdapter sendAppChooserAdapter = new SendAppChooserAdapter((Context)d2, list);
                        if (sendAppChooserAdapter.a() > 1) {
                            recyclerView.a((RecyclerView.h)new com.xiaomi.midrop.view.sendchooser.b(ac.c((Context)d2)));
                        }
                        1 var13_12 = new 1(c3, arrayList, d2, intent, b2);
                        sendAppChooserAdapter.d = var13_12;
                        recyclerView.setAdapter((RecyclerView.a)sendAppChooserAdapter);
                        aj aj2 = new aj();
                        if (aj2.a != recyclerView) {
                            if (aj2.a != null) {
                                aj2.a.b(aj2.c);
                                aj2.a.setOnFlingListener(null);
                            }
                            aj2.a = recyclerView;
                            if (aj2.a != null) {
                                if (aj2.a.getOnFlingListener() != null) {
                                    throw new IllegalStateException("An instance of OnFlingListener already set.");
                                }
                                aj2.a.a(aj2.c);
                                aj2.a.setOnFlingListener((RecyclerView.k)aj2);
                                aj2.b = new Scroller(aj2.a.getContext(), (Interpolator)new DecelerateInterpolator());
                                aj2.a();
                            }
                        }
                    }
                    u.b((ArrayList<Uri>)this.c, this.b);
                    return;
                }
                Toast.makeText((Context)d2, (int)2131689768, (int)0).show();
            }
        }
    }

    public static interface b {
        public void onClick();
    }

}

