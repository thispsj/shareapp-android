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
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  com.xiaomi.midrop.sender.adapter.ScanDisplayAdapter
 *  com.xiaomi.midrop.sender.adapter.ScanDisplayAdapter$bindItem
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  midrop.a.c.a.a.a
 */
package com.xiaomi.midrop.sender.adapter;

import a.e.b.d;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.midrop.R;
import com.xiaomi.midrop.sender.adapter.ScanDisplayAdapter;
import com.xiaomi.midrop.view.ProfileImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import midrop.c.a.e;

public final class a
extends RecyclerView.a<RecyclerView.w> {
    public static final b d = new Object(0){};
    public List<midrop.a.c.a.a.a> c;
    private a e;
    private final Context f;

    public a(Context context) {
        d.b((Object)context, "mContext");
        this.f = context;
        this.c = (List)new ArrayList();
    }

    public static final /* synthetic */ a a(a a2) {
        return a2.e;
    }

    public final int a() {
        if (this.c != null) {
            List<midrop.a.c.a.a.a> list = this.c;
            if (list == null) {
                d.a();
            }
            return list.size();
        }
        return 0;
    }

    public final int a(int n2) {
        return n2;
    }

    public final RecyclerView.w a(ViewGroup viewGroup, int n2) {
        d.b((Object)viewGroup, "parent");
        View view = LayoutInflater.from((Context)this.f).inflate(2131427461, viewGroup, false);
        d.a((Object)view, "layoutInflater.inflate\n \u2026ice_small, parent, false)");
        return (a)this.new c(view);
    }

    public final void a(RecyclerView.w w2, int n2) {
        d.b((Object)w2, "holder");
        if (w2 instanceof c) {
            c c2 = (c)w2;
            List<midrop.a.c.a.a.a> list = this.c;
            if (list == null) {
                d.a();
            }
            midrop.a.c.a.a.a a2 = (midrop.a.c.a.a.a)list.get(n2);
            c2.n.setVisibility(0);
            c2.o.setVisibility(0);
            LinearLayout linearLayout = c2.q;
            d.a((Object)linearLayout, "holder.itemDevice");
            linearLayout.setVisibility(0);
            ProfileImageView profileImageView = c2.n;
            e e2 = a2 != null ? a2.c() : null;
            d.a((Object)e2, "receiver?.device");
            int n3 = e2.l();
            String string = a2 != null ? a2.b() : null;
            d.a((Object)string, "receiver?.deviceId");
            String string2 = a2 != null ? a2.a() : null;
            d.a((Object)string2, "receiver?.name");
            profileImageView.a(n3, string, string2);
            TextView textView = c2.o;
            String string3 = a2 != null ? a2.a() : null;
            textView.setText((CharSequence)string3);
            ImageView imageView = c2 != null ? c2.p : null;
            e e3 = a2 != null ? a2.c() : null;
            d.a((Object)e3, "receiver?.device");
            int n4 = e3.i() ? 0 : 8;
            imageView.setVisibility(n4);
            LinearLayout linearLayout2 = null;
            if (c2 != null) {
                linearLayout2 = c2.q;
            }
            linearLayout2.setOnClickListener(new View.OnClickListener((a)this, a2){
                final /* synthetic */ a a;
                final /* synthetic */ midrop.a.c.a.a.a b;
                {
                    this.a = a2;
                    this.b = a3;
                }

                public final void onClick(View view) {
                    a a2 = a.a(this.a);
                    if (a2 != null) {
                        a2.a(this.b);
                    }
                }
            });
        }
    }

    public final void a(a a2) {
        d.b(a2, "listener");
        this.e = a2;
    }

    public final void a(midrop.a.c.a.a.a a2) {
        d.b((Object)a2, "fileReceiver");
        if (this.c != null) {
            List<midrop.a.c.a.a.a> list = this.c;
            if (list == null) {
                d.a();
            }
            if (true ^ ((Collection)list).isEmpty()) {
                List<midrop.a.c.a.a.a> list2 = this.c;
                if (list2 == null) {
                    d.a();
                }
                for (midrop.a.c.a.a.a a3 : list2) {
                    String string = a3 != null ? a3.b() : null;
                    String string2 = null;
                    if (a2 != null) {
                        string2 = a2.b();
                    }
                    if (!d.a((Object)string, (Object)string2)) continue;
                    List<midrop.a.c.a.a.a> list3 = this.c;
                    if (list3 != null) {
                        list3.remove((Object)a2);
                    }
                    this.b();
                    break;
                }
            }
        }
    }

    public final class c
    extends RecyclerView.w {
        ProfileImageView n;
        TextView o;
        ImageView p;
        LinearLayout q;

        public c(View view) {
            d.b((Object)view, "view");
            super(view);
            ProfileImageView profileImageView = (ProfileImageView)view.findViewById(R.id.device_avatar);
            d.a((Object)profileImageView, "view.device_avatar");
            this.n = profileImageView;
            TextView textView = (TextView)view.findViewById(R.id.device_name);
            d.a((Object)textView, "view.device_name");
            this.o = textView;
            ImageView imageView = (ImageView)view.findViewById(R.id.rocket_flag);
            d.a((Object)imageView, "view.rocket_flag");
            this.p = imageView;
            this.q = (LinearLayout)view.findViewById(R.id.item_device);
        }
    }

}

