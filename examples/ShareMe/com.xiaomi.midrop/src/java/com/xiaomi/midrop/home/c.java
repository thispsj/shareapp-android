/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.support.v4.content.a
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$w
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  com.xiaomi.midrop.home.HomeScreenAdapter
 *  com.xiaomi.midrop.home.HomeScreenAdapter$bindItem
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package com.xiaomi.midrop.home;

import a.e.b.d;
import a.l;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.midrop.R;
import com.xiaomi.midrop.home.HomeScreenAdapter;
import java.util.List;

public final class c
extends RecyclerView.a<RecyclerView.w> {
    public static final a c = new Object(0){};
    private LayoutInflater d;
    private Context e;
    private List<? extends com.xiaomi.midrop.home.a.b> f;

    public c(Context context, List<? extends com.xiaomi.midrop.home.a.b> list) {
        d.b((Object)context, "mContext");
        d.b(list, "mHomeScreenItems");
        this.e = context;
        this.f = list;
    }

    public static final /* synthetic */ void a(c c2, com.xiaomi.midrop.home.a.a a2, String string2) {
        try {
            Intent intent = new Intent(string2);
            if (d.a((Object)string2, (Object)"miui.intent.action.GARBAGE_CLEANUP")) {
                intent.putExtra("enter_homepage_way", "share_me");
                intent.putExtra("force_clean", true);
            }
            c2.e.startActivity(intent);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder("startWithAction Exception = ");
            exception.printStackTrace();
            stringBuilder.append((Object)l.a);
            try {
                Intent intent = new Intent(a2.d());
                c2.e.startActivity(intent);
                return;
            }
            catch (Exception exception2) {
                new StringBuilder("startWithAction, second action, Exception = ").append((Object)exception);
                return;
            }
        }
    }

    /*
     * Exception decompiling
     */
    public static final /* synthetic */ void a(c var0, String var1, String var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl53 : RETURN : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
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

    public static final /* synthetic */ void a(c c2, String string2, String string3, String string4) {
        try {
            Intent intent = !TextUtils.isEmpty((CharSequence)string4) ? new Intent(string4) : new Intent();
            intent.setComponent(new ComponentName(string2, string3));
            c2.e.startActivity(intent);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder("startActionWithComponents Exception = ");
            exception.printStackTrace();
            stringBuilder.append((Object)l.a);
            return;
        }
    }

    public static final /* synthetic */ void b(c c2, String string2, String string3) {
        try {
            Intent intent = new Intent(string3, Uri.parse((String)string2));
            c2.e.startActivity(intent);
            return;
        }
        catch (Exception exception) {
            new StringBuilder("Exception on startWithUri=").append((Object)exception);
            return;
        }
    }

    public final int a() {
        return this.f.size();
    }

    public final int a(int n2) {
        return n2;
    }

    public final RecyclerView.w a(ViewGroup viewGroup, int n2) {
        d.b((Object)viewGroup, "parent");
        LayoutInflater layoutInflater = LayoutInflater.from((Context)this.e);
        d.a((Object)layoutInflater, "LayoutInflater.from(mContext)");
        LayoutInflater layoutInflater2 = this.d = layoutInflater;
        if (layoutInflater2 == null) {
            d.a("mLayoutInflater");
        }
        View view = layoutInflater2.inflate(2131427480, viewGroup, false);
        d.a((Object)view, "mLayoutInflater.inflate\n\u2026hild_item, parent, false)");
        return (c)this.new b(view);
    }

    public final void a(RecyclerView.w w2, int n2) {
        block18 : {
            com.xiaomi.midrop.home.a.b b2;
            b b3;
            block20 : {
                block19 : {
                    ImageView imageView;
                    Context context;
                    int n3;
                    d.b((Object)w2, "holder");
                    if (!(w2 instanceof b)) break block18;
                    b3 = (b)w2;
                    b2 = (com.xiaomi.midrop.home.a.b)this.f.get(n2);
                    String string2 = b2.b();
                    if (string2 == null) break block19;
                    switch (string2.hashCode()) {
                        default: {
                            break block19;
                        }
                        case 1611716962: {
                            if (string2.equals((Object)"Local files")) {
                                TextView textView = b3.o;
                                d.a((Object)textView, "holder.childItemText");
                                textView.setText((CharSequence)this.e.getString(2131689520));
                                imageView = b3.p;
                                d.a((Object)imageView, "holder.childItemImage");
                                context = this.e;
                                n3 = 2131231037;
                                break;
                            }
                            break block19;
                        }
                        case 1035681609: {
                            if (string2.equals((Object)"Update apps")) {
                                TextView textView = b3.o;
                                d.a((Object)textView, "holder.childItemText");
                                textView.setText((CharSequence)this.e.getString(2131689521));
                                imageView = b3.p;
                                d.a((Object)imageView, "holder.childItemImage");
                                context = this.e;
                                n3 = 2131231059;
                                break;
                            }
                            break block19;
                        }
                        case 741683005: {
                            if (string2.equals((Object)"Mi Mover")) {
                                TextView textView = b3.o;
                                d.a((Object)textView, "holder.childItemText");
                                textView.setText((CharSequence)this.e.getString(2131689522));
                                imageView = b3.p;
                                d.a((Object)imageView, "holder.childItemImage");
                                context = this.e;
                                n3 = 2131231060;
                                break;
                            }
                            break block19;
                        }
                        case 271975959: {
                            if (string2.equals((Object)"Share to PC")) {
                                TextView textView = b3.o;
                                d.a((Object)textView, "holder.childItemText");
                                textView.setText((CharSequence)this.e.getString(2131689760));
                                imageView = b3.p;
                                d.a((Object)imageView, "holder.childItemImage");
                                context = this.e;
                                n3 = 2131231098;
                                break;
                            }
                            break block19;
                        }
                        case -635708117: {
                            if (string2.equals((Object)"Webshare")) {
                                TextView textView = b3.o;
                                d.a((Object)textView, "holder.childItemText");
                                textView.setText((CharSequence)this.e.getString(2131690032));
                                imageView = b3.p;
                                d.a((Object)imageView, "holder.childItemImage");
                                context = this.e;
                                n3 = 2131231124;
                                break;
                            }
                            break block19;
                        }
                        case -1769744488: {
                            if (string2.equals((Object)"Received files")) {
                                TextView textView = b3.o;
                                d.a((Object)textView, "holder.childItemText");
                                textView.setText((CharSequence)this.e.getString(2131689826));
                                imageView = b3.p;
                                d.a((Object)imageView, "holder.childItemImage");
                                context = this.e;
                                n3 = 2131231078;
                                break;
                            }
                            break block19;
                        }
                        case -1773540202: {
                            if (string2.equals((Object)"Cleaner")) {
                                TextView textView = b3.o;
                                d.a((Object)textView, "holder.childItemText");
                                textView.setText((CharSequence)this.e.getString(2131689519));
                                imageView = b3.p;
                                d.a((Object)imageView, "holder.childItemImage");
                                context = this.e;
                                n3 = 2131231017;
                                break;
                            }
                            break block19;
                        }
                        case -2099832023: {
                            if (!string2.equals((Object)"Invite")) break block19;
                            TextView textView = b3.o;
                            d.a((Object)textView, "holder.childItemText");
                            textView.setText((CharSequence)this.e.getString(2131689618));
                            imageView = b3.p;
                            d.a((Object)imageView, "holder.childItemImage");
                            context = this.e;
                            n3 = 2131231058;
                        }
                    }
                    imageView.setImageDrawable(android.support.v4.content.a.a((Context)context, (int)n3));
                    break block20;
                }
                LinearLayout linearLayout = b3.n;
                d.a((Object)linearLayout, "holder.childItemParent");
                linearLayout.setBackground(android.support.v4.content.a.a((Context)this.e, (int)2131230979));
            }
            if (!TextUtils.isEmpty((CharSequence)b2.b())) {
                b3.n.setOnClickListener(new View.OnClickListener((c)this, b2){
                    final /* synthetic */ c a;
                    final /* synthetic */ com.xiaomi.midrop.home.a.b b;
                    {
                        this.a = c2;
                        this.b = b2;
                    }

                    /*
                     * Enabled aggressive block sorting
                     */
                    public final void onClick(View view) {
                        block3 : {
                            String string2;
                            com.xiaomi.midrop.home.a.a a2;
                            String string3;
                            c c2;
                            block7 : {
                                com.xiaomi.midrop.home.a.a a3;
                                block6 : {
                                    block5 : {
                                        block4 : {
                                            block2 : {
                                                a3 = this.b.a();
                                                String string4 = this.b.b();
                                                d.a((Object)string4, "homeItem.title");
                                                if (!"Local files".contentEquals((CharSequence)string4)) break block2;
                                                c c3 = this.a;
                                                d.a((Object)a3, "actionClass");
                                                String string5 = a3.b();
                                                d.a((Object)string5, "actionClass.jsonMemberPackage");
                                                String string6 = a3.a();
                                                d.a((Object)string6, "actionClass.launchAction1");
                                                c.a(c3, string5, string6);
                                                break block3;
                                            }
                                            d.a((Object)a3, "actionClass");
                                            if (TextUtils.isEmpty((CharSequence)a3.e())) break block4;
                                            c c4 = this.a;
                                            String string7 = a3.e();
                                            d.a((Object)string7, "actionClass.uri");
                                            String string8 = a3.a();
                                            d.a((Object)string8, "actionClass.launchAction1");
                                            c.b(c4, string7, string8);
                                            break block3;
                                        }
                                        if (TextUtils.isEmpty((CharSequence)a3.b())) break block5;
                                        c c5 = this.a;
                                        String string9 = a3.b();
                                        d.a((Object)string9, "actionClass.jsonMemberPackage");
                                        String string10 = a3.c();
                                        d.a((Object)string10, "actionClass.activity");
                                        String string11 = a3.a();
                                        d.a((Object)string11, "actionClass.launchAction1");
                                        c.a(c5, string9, string10, string11);
                                        break block3;
                                    }
                                    if (TextUtils.isEmpty((CharSequence)a3.a())) break block6;
                                    c2 = this.a;
                                    a2 = this.b.a();
                                    d.a((Object)a2, "homeItem.action");
                                    string2 = a3.a();
                                    string3 = "actionClass.launchAction1";
                                    break block7;
                                }
                                if (TextUtils.isEmpty((CharSequence)a3.d())) break block3;
                                c2 = this.a;
                                a2 = this.b.a();
                                d.a((Object)a2, "homeItem.action");
                                string2 = a3.d();
                                string3 = "actionClass.launchAction2";
                            }
                            d.a((Object)string2, string3);
                            c.a(c2, a2, string2);
                        }
                        String string12 = this.b.c();
                        d.a((Object)string12, "homeItem.event");
                        d.b(string12, "eventName");
                        com.xiaomi.midrop.util.af.a(com.xiaomi.midrop.util.af$a.dX).a(com.xiaomi.midrop.util.af$b.ay, string12).a();
                    }
                });
            }
        }
    }

    public final class b
    extends RecyclerView.w {
        LinearLayout n;
        TextView o;
        ImageView p;

        public b(View view) {
            d.b((Object)view, "view");
            super(view);
            this.n = (LinearLayout)view.findViewById(R.id.child_item_parent);
            this.o = (TextView)view.findViewById(R.id.child_item_text);
            this.p = (ImageView)view.findViewById(R.id.child_item_image);
        }
    }

}

