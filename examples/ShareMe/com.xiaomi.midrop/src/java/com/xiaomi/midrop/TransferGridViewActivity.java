/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Point
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.Message
 *  android.support.v7.widget.GridLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$b
 *  android.support.v7.widget.RecyclerView$h
 *  android.support.v7.widget.RecyclerView$i
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.xiaomi.midrop;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.midrop.TransferGridViewActivity;
import com.xiaomi.midrop.b.a;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.receiver.ui.a;
import com.xiaomi.midrop.receiver.ui.c;
import com.xiaomi.midrop.sender.c.d;
import com.xiaomi.midrop.util.Locale.a;
import com.xiaomi.midrop.util.Locale.b;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.ag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransferGridViewActivity
extends a
implements a.a {
    private static final String a = "com.xiaomi.midrop.TransferGridViewActivity";
    private b b;
    private View c;
    private RecyclerView d;
    private c e;
    private ArrayList<g> f;
    private TextView g;
    private int h;
    private final int i = 5;

    static /* synthetic */ ArrayList a(TransferGridViewActivity transferGridViewActivity) {
        return transferGridViewActivity.f;
    }

    private void a() {
        Iterator iterator = this.f.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            int n3 = ((g)iterator.next()).m == 3 ? 1 : 0;
            n2 += n3;
        }
        TextView textView = this.g;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Object)this.b.a(2131689806));
        stringBuilder.append("(");
        stringBuilder.append(n2);
        stringBuilder.append("/");
        stringBuilder.append(this.f.size());
        stringBuilder.append(")");
        textView.setText((CharSequence)stringBuilder.toString());
    }

    public static void a(Context context, List<g> list) {
        d.b = (ArrayList)list;
        context.startActivity(new Intent(context, TransferGridViewActivity.class));
    }

    @Override
    public final void a(Message message) {
        if (message.what != -1 && message.what < this.f.size()) {
            this.e.c(message.what);
        } else {
            this.e.a.b();
        }
        TransferGridViewActivity.super.a();
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a(2131427383, true);
        this.h = this.getResources().getDimensionPixelSize(2131165742);
        ArrayList<g> arrayList = d.b;
        d.b = null;
        this.f = arrayList;
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.c = this.findViewById(2131296591);
        this.d = (RecyclerView)this.findViewById(2131296513);
        this.b = b.a();
        View view = this.findViewById(2131296823);
        this.g = (TextView)view.findViewById(2131296871);
        this.g.setTextColor(this.getResources().getColor(2131100072));
        ImageView imageView = (ImageView)view.findViewById(2131296487);
        imageView.setImageResource(2131230812);
        imageView.setOnClickListener(new View.OnClickListener((TransferGridViewActivity)this){
            final /* synthetic */ TransferGridViewActivity a;
            {
                this.a = transferGridViewActivity;
            }

            public void onClick(View view) {
                this.a.onBackPressed();
            }
        });
        if (ac.c((Context)this)) {
            imageView.setRotation(180.0f);
        }
        int n2 = this.getResources().getColor(2131099965);
        this.c.setBackgroundDrawable((Drawable)new ColorDrawable(n2));
        this.c.setPadding(0, ag.a((Context)this), 0, 0);
        this.a(false);
        int n3 = (ac.b((Context)this).x - 4 * this.h) / 5;
        this.e = new c((Context)this, (List<g>)this.f);
        this.e.e = n3;
        GridLayoutManager gridLayoutManager = new GridLayoutManager((Context)this, 5);
        this.d.setLayoutManager((RecyclerView.i)gridLayoutManager);
        this.d.a((RecyclerView.h)new a.b(this.h));
        this.d.setAdapter((RecyclerView.a)this.e);
        com.xiaomi.midrop.b.a.a().a("TransfezrGridViewActivity", (a.a)this);
        this.e.f = new c.b((TransferGridViewActivity)this){
            final /* synthetic */ TransferGridViewActivity a;
            {
                this.a = transferGridViewActivity;
            }

            public final void a(RecyclerView.a a2, int n2) {
                com.xiaomi.midrop.b.b b2 = ((c)a2).d(n2);
                int n3 = b2.m;
                int n4 = 1;
                if (n3 != 2 && n3 != n4) {
                    n4 = 0;
                }
                if (n4 != 0) {
                    Message message = Message.obtain();
                    message.obj = b2;
                    com.xiaomi.midrop.b.a.a().a("TransferFragment", message);
                    return;
                }
                if (n3 == 3) {
                    com.xiaomi.midrop.util.ak.a().a((List<g>)TransferGridViewActivity.a(this.a));
                    com.xiaomi.midrop.util.j.a((Context)this.a, b2);
                    com.xiaomi.midrop.util.af.a(com.xiaomi.midrop.util.af$a.bW).a();
                }
            }
        };
        TransferGridViewActivity.super.a();
    }

    @Override
    protected void onDestroy() {
        com.xiaomi.midrop.b.a.a().a("TransfezrGridViewActivity");
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}

