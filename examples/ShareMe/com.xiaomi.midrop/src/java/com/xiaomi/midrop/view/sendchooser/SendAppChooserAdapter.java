/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$w
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.widget.ImageView
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.xiaomi.midrop.view.sendchooser;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.midrop.util.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class SendAppChooserAdapter
extends RecyclerView.a<ViewHolder> {
    List<com.xiaomi.midrop.view.sendchooser.a> c = new ArrayList();
    public a d;
    private final int e = 4;
    private final int f = 2;
    private LayoutInflater g;
    private Context h;

    public SendAppChooserAdapter(Context context, List<com.xiaomi.midrop.view.sendchooser.a> list) {
        this.h = context;
        this.g = LayoutInflater.from((Context)context);
        this.c = list;
    }

    public final int a() {
        int n2 = this.c.size() / 8;
        int n3 = this.c.size() % 8 > 0 ? 1 : 0;
        return n2 + n3;
    }

    public final /* synthetic */ RecyclerView.w a(ViewGroup viewGroup, int n2) {
        return (SendAppChooserAdapter)this.new ViewHolder(this.g.inflate(2131427392, viewGroup, false));
    }

    public final /* synthetic */ void a(RecyclerView.w w2, int n2) {
        int n3;
        ViewHolder viewHolder = (ViewHolder)w2;
        int n4 = this.c.size();
        int n5 = (n4 - (n3 = n2 * 8)) / 8 == 0 ? (this.c.size() - n3) % 8 : 8;
        Iterator iterator = viewHolder.n.iterator();
        while (iterator.hasNext()) {
            ((View)iterator.next()).setVisibility(4);
        }
        if (this.c.size() <= 4) {
            viewHolder.o.setVisibility(8);
        }
        for (int i2 = 0; i2 < n5; ++i2) {
            com.xiaomi.midrop.view.sendchooser.a a2 = (com.xiaomi.midrop.view.sendchooser.a)this.c.get(n3 + i2);
            View view = (View)viewHolder.n.get(i2);
            TextView textView = (TextView)view.findViewById(2131296810);
            textView.setSelected(true);
            textView.setText((CharSequence)a2.a);
            h.b(this.h, (ImageView)view.findViewById(2131296505), a2.b, -1);
            view.setVisibility(0);
        }
    }

    public class ViewHolder
    extends RecyclerView.w
    implements View.OnClickListener {
        List<View> n;
        ViewGroup o;

        ViewHolder(View view) {
            super(view);
            this.n = new ArrayList();
            this.o = null;
            this.n.add((Object)view.findViewById(2131296542));
            this.n.add((Object)view.findViewById(2131296543));
            this.n.add((Object)view.findViewById(2131296544));
            this.n.add((Object)view.findViewById(2131296545));
            this.n.add((Object)view.findViewById(2131296546));
            this.n.add((Object)view.findViewById(2131296547));
            this.n.add((Object)view.findViewById(2131296548));
            this.n.add((Object)view.findViewById(2131296549));
            this.o = (ViewGroup)view.findViewById(2131296693);
            Iterator iterator = this.n.iterator();
            while (iterator.hasNext()) {
                ((View)iterator.next()).findViewById(2131296505).setOnClickListener((View.OnClickListener)this);
            }
        }

        public void onClick(View view) {
            ViewParent viewParent;
            if (SendAppChooserAdapter.this.d != null && (viewParent = view.getParent()) != null) {
                if (!(viewParent instanceof View)) {
                    return;
                }
                int n2 = 8 * this.d() + this.n.indexOf((Object)viewParent);
                if (n2 < SendAppChooserAdapter.this.c.size()) {
                    SendAppChooserAdapter.this.d.a((com.xiaomi.midrop.view.sendchooser.a)SendAppChooserAdapter.this.c.get(n2));
                    return;
                }
            }
        }
    }

}

