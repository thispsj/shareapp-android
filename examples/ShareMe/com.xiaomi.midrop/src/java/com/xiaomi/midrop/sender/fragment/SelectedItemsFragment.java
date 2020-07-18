/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.support.v4.app.g
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$b
 *  android.support.v7.widget.RecyclerView$i
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 */
package com.xiaomi.midrop.sender.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.sender.c.b;
import com.xiaomi.midrop.sender.fragment.BasePickDialogFragment;
import com.xiaomi.midrop.sender.fragment.SelectedItemsFragment;
import com.xiaomi.midrop.util.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SelectedItemsFragment
extends BasePickDialogFragment {
    private TextView b;
    private TextView c;
    private RecyclerView d;
    private com.xiaomi.midrop.sender.ui.g e;
    private ArrayList<g> f;
    private long g;

    private static void a(a a2) {
        new HashMap();
        Iterator iterator = com.xiaomi.midrop.sender.c.g.e().d();
        while (iterator.hasNext()) {
            g g2 = (g)iterator.next();
            if (g.a(g2)) {
                g2.l = com.xiaomi.midrop.sender.c.g.e().a(g2.i);
            }
            a2.a += g2.l;
        }
        List list = com.xiaomi.midrop.sender.c.g.e().c;
        a2.b.addAll(list);
        Collections.reverse(a2.b);
    }

    private void b() {
        Object object = new Object(0){
            long a;
            ArrayList<g> b;
        };
        object.b = new ArrayList();
        SelectedItemsFragment.a(object);
        this.g = object.a;
        this.f.clear();
        this.f.addAll(object.b);
        this.e.a.b();
        TextView textView = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getString(2131689689));
        stringBuilder.append(" ");
        stringBuilder.append(j.b(this.g));
        textView.setText((CharSequence)stringBuilder.toString());
    }

    @Override
    public final void a(String string2, List<g> list) {
        SelectedItemsFragment.super.b();
    }

    /*
     * Exception decompiling
     */
    @Override
    public final void a(List<g> var1) {
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

    @Override
    public final void b(List<g> list) {
        SelectedItemsFragment.super.b();
    }

    @Override
    public final void h_() {
        this.b();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.g = 0L;
        this.f = new ArrayList();
        this.e = new com.xiaomi.midrop.sender.ui.g((Context)this.getActivity(), (List<g>)this.f);
    }

    @Override
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = super.onCreateDialog(bundle);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
        }
        return dialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (!com.xiaomi.midrop.sender.c.g.e().c((b.a)this)) {
            com.xiaomi.midrop.sender.c.g.e().a((b.a)this);
        }
        return layoutInflater.inflate(2131427559, (ViewGroup)new FrameLayout(this.getContext()));
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (com.xiaomi.midrop.sender.c.g.e().c(this)) {
            com.xiaomi.midrop.sender.c.g.e().b(this);
        }
    }

    public void onStart() {
        super.onStart();
        if (this.getDialog() != null && this.getDialog().getWindow() != null) {
            Dialog dialog = this.getDialog();
            WindowManager.LayoutParams layoutParams = dialog.getWindow().getAttributes();
            layoutParams.width = -1;
            dialog.getWindow().setAttributes(layoutParams);
        }
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TextView textView = this.b = (TextView)view.findViewById(2131296863);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getString(2131689689));
        stringBuilder.append(" ");
        stringBuilder.append(j.b(this.g));
        textView.setText((CharSequence)stringBuilder.toString());
        this.c = (TextView)view.findViewById(2131296840);
        this.c.setOnClickListener(new View.OnClickListener((SelectedItemsFragment)this){
            final /* synthetic */ SelectedItemsFragment a;
            {
                this.a = selectedItemsFragment;
            }

            public void onClick(View view) {
                com.xiaomi.midrop.util.af.a(com.xiaomi.midrop.util.af$a.I).a();
                com.xiaomi.midrop.sender.c.g.e().c();
                try {
                    this.a.dismiss();
                }
                catch (java.lang.IllegalStateException illegalStateException) {}
            }
        });
        this.d = (RecyclerView)view.findViewById(2131296676);
        this.d.setLayoutManager((RecyclerView.i)new LinearLayoutManager((Context)this.getActivity()));
        this.d.setAdapter((RecyclerView.a)this.e);
        SelectedItemsFragment.super.b();
    }

}

