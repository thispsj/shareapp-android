/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.widget.TextView
 *  com.xiaomi.midrop.send.history.FilePickHistoryAdapter
 *  com.xiaomi.midrop.send.history.FilePickHistoryAdapter$onBindHeaderViewHolder
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.List
 */
package com.xiaomi.midrop.send.history;

import a.e.b.f;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.db.TransferHistoryDatabase;
import com.xiaomi.midrop.send.card.h;
import com.xiaomi.midrop.send.history.FilePickHistoryAdapter;
import com.xiaomi.midrop.sender.card.l;
import com.xiaomi.midrop.util.j;
import com.xiaomi.midrop.view.ProfileImageView;
import com.xiaomi.midrop.view.stickadapter.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public final class a
extends com.xiaomi.midrop.send.base.a {
    public static final a k = new Object(0){};
    List<com.xiaomi.midrop.db.b.a> c;
    boolean d;
    Context j;
    private int m;

    public a(Context context) {
        a.e.b.d.b((Object)context, "context");
        this.j = context;
        this.m = (int)this.j.getResources().getDimension(2131165444);
        this.c = (List)new ArrayList();
        this.d = true;
    }

    public static final /* synthetic */ void a(a a2, final com.xiaomi.midrop.db.b.a a3) {
        a2.c.remove((Object)a3);
        com.xiaomi.midrop.sender.c.g.e().c((Collection)a3.g());
        a2.f();
        org.jetbrains.anko.b.a(a2, new a.e.a.b<org.jetbrains.anko.a<a>, a.l>(){

            @Override
            public final /* synthetic */ Object a(Object object) {
                a.e.b.d.b((org.jetbrains.anko.a)object, "receiver$0");
                TransferHistoryDatabase transferHistoryDatabase = TransferHistoryDatabase.i();
                a.e.b.d.a((Object)transferHistoryDatabase, "TransferHistoryDatabase.getInstance()");
                transferHistoryDatabase.j().b(a3);
                return a.l.a;
            }
        });
    }

    @Override
    public final int a(int n2, int n3) {
        g g2 = (g)((com.xiaomi.midrop.db.b.a)this.c.get(n2)).f().get(n3);
        if (g2 instanceof i) {
            i i2 = (i)g2;
            if (i2.b() == 0) {
                return 101;
            }
            if (i2.b() == 1) {
                return 102;
            }
            return 0;
        }
        String string2 = j.d(g2.k);
        if (com.xiaomi.midrop.util.g.h.contains((Object)string2)) {
            return 2;
        }
        if (com.xiaomi.midrop.util.g.i.contains((Object)string2)) {
            return 7;
        }
        if (com.xiaomi.midrop.util.g.j.contains((Object)string2)) {
            return 3;
        }
        return 1;
    }

    @Override
    public final a.c a(ViewGroup viewGroup) {
        View view = this.i.inflate(2131427469, viewGroup, false);
        a.e.b.d.a((Object)view, "mInflater.inflate(R.layo\u2026ory_group, parent, false)");
        return (a)this.new c(view);
    }

    @Override
    public final void a(a.a a2, int n2, int n3) {
        super.a(a2, n2, n3);
        if (a2 instanceof b) {
            if (n2 == 49) {
                ((b)a2).n.setVisibility(0);
            } else {
                ((b)a2).n.setVisibility(8);
            }
            if (this.g(n2)) {
                ((b)a2).o.setVisibility(8);
                return;
            }
            ((b)a2).o.setVisibility(0);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public final void a(a.c c2, int n2, int n3) {
        f.b b2 = new f.b();
        b2.a = (com.xiaomi.midrop.db.b.a)this.c.get(n2);
        if (c2 instanceof c) {
            Object[] arrobject;
            TextView textView;
            String string2;
            if (((com.xiaomi.midrop.db.b.a)b2.a).c() == g.a.b - 1) {
                textView = ((c)c2).n;
                string2 = com.xiaomi.midrop.util.Locale.b.a().b(2131689827);
                a.e.b.d.a((Object)string2, "LanguageUtil.getIns().ge\u2026g(R.string.received_from)");
                arrobject = new Object[]{((com.xiaomi.midrop.db.b.a)b2.a).e()};
            } else {
                textView = ((c)c2).n;
                string2 = com.xiaomi.midrop.util.Locale.b.a().b(2131689889);
                a.e.b.d.a((Object)string2, "LanguageUtil.getIns().getString(R.string.send_to)");
                arrobject = new Object[]{((com.xiaomi.midrop.db.b.a)b2.a).e()};
            }
            String string3 = String.format((String)string2, (Object[])Arrays.copyOf((Object[])arrobject, (int)1));
            a.e.b.d.a((Object)string3, "java.lang.String.format(format, *args)");
            textView.setText((CharSequence)string3);
            c c3 = (c)c2;
            c3.o.a(((com.xiaomi.midrop.db.b.a)b2.a).b(), ((com.xiaomi.midrop.db.b.a)b2.a).e());
            c3.p.setOnClickListener(new View.OnClickListener((a)this, b2, n2){
                final /* synthetic */ a a;
                final /* synthetic */ f.b b;
                final /* synthetic */ int c;
                {
                    this.a = a2;
                    this.b = b2;
                    this.c = n2;
                }

                public final void onClick(View view) {
                    if (com.xiaomi.midrop.util.y.G()) {
                        com.xiaomi.midrop.view.c c2 = new com.xiaomi.midrop.view.c(this.a.j);
                        c2.a(2131689715).c(2131427422).a(2131689536, null).a().b(2131689541, new View.OnClickListener(this, c2){
                            final /* synthetic */ FilePickHistoryAdapter.onBindHeaderViewHolder.1 a;
                            final /* synthetic */ com.xiaomi.midrop.view.c b;
                            {
                                this.a = var1;
                                this.b = c2;
                            }

                            public final void onClick(View view) {
                                a.a(this.a.a, (com.xiaomi.midrop.db.b.a)this.a.b.a);
                                View view2 = this.b.d(2131296354);
                                if (view2 instanceof android.widget.CheckBox && ((android.widget.CheckBox)view2).isChecked()) {
                                    com.xiaomi.midrop.util.y.F();
                                }
                            }
                        }).d();
                        return;
                    }
                    a.a(this.a, (com.xiaomi.midrop.db.b.a)this.b.a);
                }
            });
            c3.q.setText((CharSequence)j.d(((com.xiaomi.midrop.db.b.a)b2.a).a()));
            c2.a.setOnClickListener(new View.OnClickListener((a)this, n2){
                final /* synthetic */ a a;
                final /* synthetic */ int b;
                {
                    this.a = a2;
                    this.b = n2;
                }

                public final void onClick(View view) {
                    this.a.a(this.b, true ^ this.a.g(this.b));
                }
            });
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public final void a(a.d d2, int n2, int n3, int n4) {
        block9 : {
            int n5;
            View view;
            g g2;
            boolean bl;
            d d3;
            block11 : {
                block12 : {
                    block10 : {
                        g g3;
                        g2 = (g)((com.xiaomi.midrop.db.b.a)this.c.get(n2)).f().get(n3);
                        if (!(d2 instanceof d)) break block9;
                        bl = true;
                        d3 = (d)d2;
                        if (!(d3.n instanceof h)) break block10;
                        if (g2 == null) {
                            throw new a.j("null cannot be cast to non-null type com.xiaomi.midrop.data.TransItemWithList");
                        }
                        List<g> list = ((i)g2).a();
                        String string2 = list != null && (g3 = a.a.f.a(list)) != null ? g3.t : null;
                        if (TextUtils.isEmpty((CharSequence)string2)) break block11;
                        break block12;
                    }
                    if (!(d3.n instanceof com.xiaomi.midrop.sender.card.e)) break block11;
                }
                bl = this.d;
            }
            d3.n.a(g2, com.xiaomi.midrop.sender.c.g.e().a(g2), bl);
            View view2 = d2.a.findViewById(2131296432);
            if (view2 != null) {
                view2.setVisibility(8);
            }
            if (d3.n instanceof l) {
                view = d2.a;
                n5 = 2131296400;
            } else {
                view = d2.a;
                n5 = 2131296812;
            }
            View view3 = view.findViewById(n5);
            if (view3 != null) {
                ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
                if (layoutParams == null) {
                    throw new a.j("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, this.m / 2, marginLayoutParams.rightMargin, this.m / 2);
            }
        }
    }

    @Override
    public final a.a b(ViewGroup viewGroup) {
        View view = this.i.inflate(2131427468, viewGroup, false);
        a.e.b.d.a((Object)view, "mInflater.inflate(R.layo\u2026ry_footer, parent, false)");
        return (a)this.new b(view);
    }

    @Override
    public final int c() {
        return this.c.size();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public final a.d c(ViewGroup viewGroup, int n2) {
        d d2;
        switch (n2) {
            default: {
                com.xiaomi.midrop.sender.card.d d3 = com.xiaomi.midrop.sender.card.j.a(n2, this.j, this.i);
                a.e.b.d.a((Object)d3, "ItemCardFactory.create(i\u2026Type, context, mInflater)");
                return (a)this.new d(d3, viewGroup);
            }
            case 102: {
                d2 = (a)this.new d(new com.xiaomi.midrop.send.card.g(this.j), viewGroup);
                do {
                    return d2;
                    break;
                } while (true);
            }
            case 101: 
        }
        d2 = (a)this.new d(new h(this.j), viewGroup);
        return d2;
    }

    @Override
    public final int d(int n2) {
        if (this.c.get(n2) != null && ((com.xiaomi.midrop.db.b.a)this.c.get(n2)).f() != null) {
            return ((com.xiaomi.midrop.db.b.a)this.c.get(n2)).f().size();
        }
        return 0;
    }

    @Override
    public final boolean e() {
        return true;
    }

    @Override
    public final boolean e(int n2) {
        return true;
    }

    private final class b
    extends a.a {
        final TextView n;
        final View o;

        public b(View view) {
            a.e.b.d.b((Object)view, "itemView");
            super(view);
            View view2 = view.findViewById(2131296810);
            a.e.b.d.a((Object)view2, "itemView.findViewById(R.id.title)");
            this.n = (TextView)view2;
            View view3 = view.findViewById(2131296431);
            a.e.b.d.a((Object)view3, "itemView.findViewById(R.id.divider)");
            this.o = view3;
        }
    }

    private final class c
    extends a.c {
        final TextView n;
        final ProfileImageView o;
        final View p;
        final TextView q;

        public c(View view) {
            a.e.b.d.b((Object)view, "itemView");
            super(view);
            View view2 = view.findViewById(2131296810);
            a.e.b.d.a((Object)view2, "itemView.findViewById(R.id.title)");
            this.n = (TextView)view2;
            View view3 = view.findViewById(2131296484);
            a.e.b.d.a((Object)view3, "itemView.findViewById(R.id.icon)");
            this.o = (ProfileImageView)view3;
            View view4 = view.findViewById(2131296367);
            a.e.b.d.a((Object)view4, "itemView.findViewById(R.id.close)");
            this.p = view4;
            View view5 = view.findViewById(2131296807);
            a.e.b.d.a((Object)view5, "itemView.findViewById(R.id.time)");
            this.q = (TextView)view5;
        }
    }

    private final class d
    extends a.d {
        com.xiaomi.midrop.sender.card.d n;

        public d(com.xiaomi.midrop.sender.card.d d2, ViewGroup viewGroup) {
            a.e.b.d.b(d2, "card");
            super(d2.a(viewGroup));
            this.n = d2;
        }
    }

}

