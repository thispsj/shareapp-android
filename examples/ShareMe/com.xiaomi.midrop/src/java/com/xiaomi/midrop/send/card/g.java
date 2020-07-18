/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.support.v7.widget.GridLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$b
 *  android.support.v7.widget.RecyclerView$i
 *  android.support.v7.widget.RecyclerView$w
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.xiaomi.midrop.send.card.FilePickHistoryImageCard
 *  com.xiaomi.midrop.send.card.FilePickHistoryImageCard$ImageMoreViewHolder
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package com.xiaomi.midrop.send.card;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.send.card.FilePickHistoryImageCard;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.util.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class g
extends d {
    List<com.xiaomi.midrop.b.g> a = new ArrayList();
    private RecyclerView b;
    private c n;

    public g(Context context) {
        super(context);
    }

    @Override
    public final View a(ViewGroup viewGroup) {
        this.e = this.a().inflate(2131427475, viewGroup, false);
        this.b = (RecyclerView)this.e.findViewById(2131296675);
        this.b.setLayoutManager((RecyclerView.i)new GridLayoutManager(this.g, 4));
        this.n = new RecyclerView.a<RecyclerView.w>(this.g){
            Context c;
            LayoutInflater d;
            {
                this.c = context;
                this.d = LayoutInflater.from((Context)context);
            }

            public final int a() {
                if (g.this.a != null) {
                    if (g.this.a.size() >= 8) {
                        return 8;
                    }
                    return g.this.a.size();
                }
                return 0;
            }

            public final int a(int n2) {
                if (n2 == 7 && g.this.a.size() > 8) {
                    return 102;
                }
                return 101;
            }

            public final RecyclerView.w a(ViewGroup viewGroup, int n2) {
                if (n2 == 101) {
                    return new RecyclerView.w(new com.xiaomi.midrop.sender.card.h(this.c), viewGroup){
                        d n;
                        {
                            this.n = d2;
                        }
                    };
                }
                return new RecyclerView.w(this.d.inflate(2131427470, viewGroup, false)){
                    TextView n;
                    ImageView o;
                    {
                        this.n = (TextView)view.findViewById(2131296399);
                        this.o = (ImageView)view.findViewById(2131296494);
                        this.o.setOnClickListener(new View.OnClickListener(this, g.this, view){
                            final /* synthetic */ g a;
                            final /* synthetic */ View b;
                            final /* synthetic */ a c;
                            {
                                this.c = a2;
                                this.a = g2;
                                this.b = view;
                            }

                            public void onClick(View view) {
                                Context context = this.b.getContext();
                                List<com.xiaomi.midrop.b.g> list = this.c.g.this.a;
                                a.e.b.d.b((Object)context, "context");
                                a.e.b.d.b(list, "items");
                                try {
                                    android.content.Intent intent = new android.content.Intent(context, com.xiaomi.midrop.send.history.FilePickHistoryImageListActivity.class);
                                    intent.putParcelableArrayListExtra("param_items", new ArrayList((Collection)list));
                                    context.startActivity(intent);
                                    return;
                                }
                                catch (java.lang.Exception exception) {
                                    new java.lang.StringBuilder("open exception e=").append((Object)((Object)exception));
                                    return;
                                }
                            }
                        });
                    }
                };
            }

            public final void a(RecyclerView.w w2, int n2) {
                com.xiaomi.midrop.b.g g2 = (com.xiaomi.midrop.b.g)g.this.a.get(n2);
                if (w2 instanceof b) {
                    b b2 = w2;
                    b2.n.a(g.this.a);
                    b2.n.a(g2, com.xiaomi.midrop.sender.c.g.e().a(g2), true);
                    return;
                }
                if (w2 instanceof a) {
                    a a2 = w2;
                    TextView textView = a2.n;
                    com.xiaomi.midrop.util.Locale.b b3 = com.xiaomi.midrop.util.Locale.b.a();
                    Object[] arrobject = new Object[]{1 + (-8 + g.this.a.size())};
                    textView.setText((CharSequence)b3.a(2131689619, arrobject));
                    h.a(this.c, a2.o, g2.h);
                }
            }
        };
        this.b.setAdapter((RecyclerView.a)this.n);
        return this.e;
    }

    @Override
    public final void a(com.xiaomi.midrop.b.g g2, boolean bl, boolean bl2) {
        List<com.xiaomi.midrop.b.g> list = ((i)g2).b;
        if (list != null && !list.isEmpty()) {
            this.a.clear();
            this.a.addAll(list);
            this.n.a.b();
        }
    }

}

