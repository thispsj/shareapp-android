/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.support.v7.widget.GridLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$i
 *  android.support.v7.widget.RecyclerView$w
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.xiaomi.midrop.send.history.FilePickHistoryImageListActivity$initView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package com.xiaomi.midrop.send.history;

import a.e.b.d;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.send.history.FilePickHistoryImageListActivity;
import com.xiaomi.midrop.sender.c.b;
import com.xiaomi.midrop.sender.c.g;
import com.xiaomi.midrop.sender.card.h;
import com.xiaomi.midrop.util.ag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class FilePickHistoryImageListActivity
extends com.xiaomi.midrop.util.Locale.a
implements g.a {
    public static final a a = new Object(0){};
    private final ArrayList<g> b = new ArrayList();
    private b c;
    private TextView d;
    private ImageView e;

    public static final /* synthetic */ ArrayList a(FilePickHistoryImageListActivity filePickHistoryImageListActivity) {
        return filePickHistoryImageListActivity.b;
    }

    private final void b() {
        TextView textView;
        ImageView imageView;
        b b2 = this.c;
        if (b2 != null) {
            b2.b();
        }
        if ((textView = this.d) != null) {
            Object[] arrobject = new Object[2];
            com.xiaomi.midrop.sender.c.g.e();
            arrobject[0] = com.xiaomi.midrop.sender.c.g.a((List<g>)((List)this.b));
            arrobject[1] = this.b.size();
            textView.setText((CharSequence)this.getString(2131689672, arrobject));
        }
        if ((imageView = this.e) != null) {
            imageView.setSelected(com.xiaomi.midrop.sender.c.g.e().a((Collection)this.b));
        }
    }

    public final void a(String string2, List<? extends g> list) {
        d.b(string2, "dirPath");
        d.b(list, "transItems");
    }

    @Override
    public final void a(List<? extends g> list) {
        d.b(list, "items");
        FilePickHistoryImageListActivity.super.b();
    }

    @Override
    public final void b(List<? extends g> list) {
        d.b(list, "items");
        FilePickHistoryImageListActivity.super.b();
    }

    @Override
    public final void h_() {
        this.b();
    }

    @Override
    protected final void onCreate(Bundle bundle) {
        TextView textView;
        ImageView imageView;
        ImageView imageView2;
        super.onCreate(bundle);
        this.setContentView(2131427368);
        ag.a((Activity)this, this.getResources().getColor(2131099891));
        this.c(2131427430);
        this.d = (TextView)this.t().findViewById(2131296399);
        this.e = (ImageView)this.t().findViewById(2131296491);
        if (this.getIntent() != null && this.getIntent().getParcelableArrayListExtra("param_items") != null) {
            this.b.clear();
            this.b.addAll((Collection)this.getIntent().getParcelableArrayListExtra("param_items"));
        }
        if ((textView = this.d) != null) {
            Object[] arrobject = new Object[2];
            com.xiaomi.midrop.sender.c.g.e();
            arrobject[0] = com.xiaomi.midrop.sender.c.g.a((List<g>)((List)this.b));
            arrobject[1] = this.b.size();
            textView.setText((CharSequence)this.getString(2131689672, arrobject));
        }
        if ((imageView2 = this.e) != null) {
            imageView2.setSelected(com.xiaomi.midrop.sender.c.g.e().a((Collection)this.b));
        }
        if ((imageView = this.e) != null) {
            imageView.setOnClickListener(new View.OnClickListener((FilePickHistoryImageListActivity)this){
                final /* synthetic */ FilePickHistoryImageListActivity a;
                {
                    this.a = filePickHistoryImageListActivity;
                }

                public final void onClick(View view) {
                    if (com.xiaomi.midrop.sender.c.g.e().a((Collection)FilePickHistoryImageListActivity.a(this.a))) {
                        com.xiaomi.midrop.sender.c.g.e().c((Collection)FilePickHistoryImageListActivity.a(this.a));
                        return;
                    }
                    com.xiaomi.midrop.sender.c.g.e().b((Collection)FilePickHistoryImageListActivity.a(this.a));
                }
            });
        }
        this.t().findViewById(2131296485).setOnClickListener(new View.OnClickListener((FilePickHistoryImageListActivity)this){
            final /* synthetic */ FilePickHistoryImageListActivity a;
            {
                this.a = filePickHistoryImageListActivity;
            }

            public final void onClick(View view) {
                this.a.onBackPressed();
            }
        });
        RecyclerView recyclerView = (RecyclerView)this.findViewById(2131296675);
        Context context = (Context)this;
        this.c = new RecyclerView.a<a>(context, (List<? extends g>)((List)this.b)){
            private LayoutInflater d;
            private Context e;
            private List<? extends g> f;
            {
                d.b((Object)context, "mContext");
                this.e = context;
                this.f = list;
                LayoutInflater layoutInflater = LayoutInflater.from((Context)this.e);
                d.a((Object)layoutInflater, "LayoutInflater.from(mContext)");
                this.d = layoutInflater;
            }

            public final int a() {
                if (this.f != null) {
                    List<? extends g> list = this.f;
                    if (list == null) {
                        d.a();
                    }
                    return list.size();
                }
                return 0;
            }

            public final /* synthetic */ RecyclerView.w a(ViewGroup viewGroup, int n2) {
                d.b((Object)viewGroup, "parent");
                return new a(new h(this.e), viewGroup);
            }

            public final /* synthetic */ void a(RecyclerView.w w2, int n2) {
                a a2 = (a)w2;
                d.b((Object)a2, "holder");
                a2.n.a(this.f);
                com.xiaomi.midrop.sender.card.d d2 = a2.n;
                List<? extends g> list = this.f;
                if (list == null) {
                    d.a();
                }
                g g2 = (g)list.get(n2);
                com.xiaomi.midrop.sender.c.g g3 = com.xiaomi.midrop.sender.c.g.e();
                List<? extends g> list2 = this.f;
                if (list2 == null) {
                    d.a();
                }
                d2.a(g2, g3.a((g)list2.get(n2)), true);
            }

            public final class a
            extends RecyclerView.w {
                com.xiaomi.midrop.sender.card.d n;

                public a(com.xiaomi.midrop.sender.card.d d2, ViewGroup viewGroup) {
                    d.b(d2, "mItemCard");
                    d.b((Object)viewGroup, "parent");
                    super(d2.a(viewGroup));
                    this.n = d2;
                }
            }

        };
        d.a((Object)recyclerView, "recyclerView");
        recyclerView.setLayoutManager((RecyclerView.i)new GridLayoutManager(context, 4));
        recyclerView.setAdapter((RecyclerView.a)this.c);
        com.xiaomi.midrop.sender.c.g.e().a((b.a)this);
    }

    @Override
    protected final void onDestroy() {
        b.a a2;
        com.xiaomi.midrop.sender.c.g g2 = com.xiaomi.midrop.sender.c.g.e();
        if (g2.c(a2 = (b.a)this)) {
            com.xiaomi.midrop.sender.c.g.e().b(a2);
        }
        super.onDestroy();
    }

}

