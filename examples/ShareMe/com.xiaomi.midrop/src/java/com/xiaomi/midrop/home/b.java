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
 *  android.widget.TextView
 *  com.xiaomi.midrop.home.HomeNavigationAdapter
 *  com.xiaomi.midrop.home.HomeNavigationAdapter$HeaderHolder
 *  com.xiaomi.midrop.home.HomeNavigationAdapter$ItemViewHolder
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.xiaomi.midrop.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.midrop.R;
import com.xiaomi.midrop.home.HomeNavigationAdapter;
import com.xiaomi.midrop.home.d;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.e;
import com.xiaomi.midrop.util.y;
import com.xiaomi.midrop.view.ProfileImageView;
import java.util.List;

public final class b
extends RecyclerView.a<RecyclerView.w> {
    public static final a e = new Object(0){};
    Context c;
    List<? extends d> d;
    private LayoutInflater f;

    public b(Context context, List<? extends d> list) {
        a.e.b.d.b((Object)context, "context");
        a.e.b.d.b(list, "items");
        this.c = context;
        this.d = list;
    }

    public final int a() {
        return 1 + this.d.size();
    }

    public final int a(int n2) {
        return n2 != 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final RecyclerView.w a(ViewGroup viewGroup, int n2) {
        a.e.b.d.b((Object)viewGroup, "parent");
        LayoutInflater layoutInflater = LayoutInflater.from((Context)this.c);
        a.e.b.d.a((Object)layoutInflater, "LayoutInflater.from(context)");
        this.f = layoutInflater;
        if (n2 != 0) {
            LayoutInflater layoutInflater2 = this.f;
            if (layoutInflater2 == null) {
                a.e.b.d.a("layoutInflater");
            }
            View view = layoutInflater2.inflate(2131427482, viewGroup, false);
            a.e.b.d.a((Object)view, "layoutInflater.inflate(R\u2026tion_item, parent, false)");
            return (b)this.new c(view);
        }
        LayoutInflater layoutInflater3 = this.f;
        if (layoutInflater3 == null) {
            a.e.b.d.a("layoutInflater");
        }
        View view = layoutInflater3.inflate(2131427481, viewGroup, false);
        a.e.b.d.a((Object)view, "layoutInflater.inflate(R\u2026tion_head, parent, false)");
        return (b)this.new b(view);
    }

    public final void a(RecyclerView.w w2, int n2) {
        a.e.b.d.b((Object)w2, "holder");
        boolean bl = w2 instanceof b;
        int n3 = 8;
        if (bl) {
            b b2 = (b)w2;
            b2.n.a();
            b2.o.setText((CharSequence)e.a());
            View view = b2.p;
            if (y.E()) {
                n3 = 0;
            }
            view.setVisibility(n3);
            return;
        }
        if (w2 instanceof c) {
            c c2 = (c)w2;
            List<? extends d> list = this.d;
            int n4 = 1;
            d d2 = (d)list.get(n2 - n4);
            c2.o.setText(d2.a);
            TextView textView = c2.p;
            String string2 = d2.b;
            a.e.b.d.a((Object)string2, "settingData.mSubTitle");
            if (((CharSequence)string2).length() != 0) {
                n4 = 0;
            }
            int n5 = n4 != 0 ? 8 : 0;
            textView.setVisibility(n5);
            c2.p.setText((CharSequence)d2.b);
            View view = c2.q;
            int n6 = d2.f ? 0 : 8;
            view.setVisibility(n6);
            View view2 = c2.r;
            if (d2.a()) {
                n3 = 0;
            }
            view2.setVisibility(n3);
            ImageView imageView = c2.n;
            int n7 = d2.g;
            a.e.b.d.b((Object)imageView, "$receiver");
            imageView.setImageResource(n7);
        }
    }

    public final class b
    extends RecyclerView.w {
        ProfileImageView n;
        TextView o;
        View p;
        private View r;

        public b(View view) {
            a.e.b.d.b((Object)view, "view");
            super(view);
            ProfileImageView profileImageView = (ProfileImageView)view.findViewById(R.id.head_icon);
            a.e.b.d.a((Object)profileImageView, "view.head_icon");
            this.n = profileImageView;
            TextView textView = (TextView)view.findViewById(R.id.head_name);
            a.e.b.d.a((Object)textView, "view.head_name");
            this.o = textView;
            View view2 = view.findViewById(R.id.head_new_msg);
            a.e.b.d.a((Object)view2, "view.head_new_msg");
            this.p = view2;
            ImageView imageView = (ImageView)view.findViewById(R.id.head_arrow);
            a.e.b.d.a((Object)imageView, "view.head_arrow");
            this.r = (View)imageView;
            this.a.setOnClickListener(new View.OnClickListener((b)this){
                final /* synthetic */ b a;
                {
                    this.a = b2;
                }

                public final void onClick(View view) {
                    Context context = this.a.b.this.c;
                    context.startActivity(com.xiaomi.midrop.profile.ProfileSettingActivity$a.a(this.a.b.this.c, false));
                    if (this.a.b.this.c instanceof com.xiaomi.midrop.send.FilePickNewActivity) {
                        Context context2 = this.a.b.this.c;
                        if (context2 == null) {
                            throw new a.j("null cannot be cast to non-null type com.xiaomi.midrop.send.FilePickNewActivity");
                        }
                        ((com.xiaomi.midrop.send.FilePickNewActivity)context2).b();
                    }
                    y.D();
                    com.xiaomi.midrop.util.af.a(com.xiaomi.midrop.util.af$a.m).a();
                }
            });
            if (ac.c(b.this.c)) {
                this.r.setRotation(180.0f);
            }
        }
    }

    public final class c
    extends RecyclerView.w {
        ImageView n;
        TextView o;
        TextView p;
        View q;
        View r;

        public c(View view) {
            a.e.b.d.b((Object)view, "view");
            super(view);
            ImageView imageView = (ImageView)view.findViewById(R.id.icon);
            a.e.b.d.a((Object)imageView, "view.icon");
            this.n = imageView;
            TextView textView = (TextView)view.findViewById(R.id.title);
            a.e.b.d.a((Object)textView, "view.title");
            this.o = textView;
            TextView textView2 = (TextView)view.findViewById(R.id.sub_title);
            a.e.b.d.a((Object)textView2, "view.sub_title");
            this.p = textView2;
            View view2 = view.findViewById(R.id.divider);
            a.e.b.d.a((Object)view2, "view.divider");
            this.q = view2;
            View view3 = view.findViewById(R.id.new_msg);
            a.e.b.d.a((Object)view3, "view.new_msg");
            this.r = view3;
            this.a.setOnClickListener(new View.OnClickListener((c)this){
                final /* synthetic */ c a;
                {
                    this.a = c2;
                }

                public final void onClick(View view) {
                    ((d)this.a.b.this.d.get(-1 + this.a.c())).onClick();
                }
            });
        }
    }

}

