/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.xiaomi.midrop.received.ReceivedActivity
 *  com.xiaomi.midrop.sender.card.DirectoryItemCard
 *  java.io.File
 *  java.io.FilenameFilter
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 *  java.util.Locale
 */
package com.xiaomi.midrop.sender.card;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.received.ReceivedActivity;
import com.xiaomi.midrop.send.contacts.a;
import com.xiaomi.midrop.sender.card.DirectoryItemCard;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.sender.card.e;
import com.xiaomi.midrop.util.h;
import com.xiaomi.midrop.util.j;
import com.xiaomi.midrop.util.p;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashSet;
import java.util.Locale;

public final class e
extends d {
    ImageView a;
    TextView b;
    TextView n;
    View o;
    TextView p;
    TextView q;
    boolean r;
    public boolean s = true;

    public e(Context context) {
        super(context);
    }

    private static boolean a(g g2) {
        return new File(g2.i).isDirectory();
    }

    @Override
    public final View a(ViewGroup viewGroup) {
        this.e = this.a().inflate(2131427424, viewGroup, false);
        this.f = this.e.findViewById(2131296734);
        this.a = (ImageView)this.e.findViewById(2131296522);
        this.b = (TextView)this.e.findViewById(2131296810);
        this.n = (TextView)this.e.findViewById(2131296412);
        this.p = (TextView)this.e.findViewById(2131296526);
        this.q = (TextView)this.e.findViewById(2131296390);
        this.o = this.e.findViewById(2131296602);
        return this.e;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public final void a(g var1, boolean var2_3, boolean var3_2) {
        block20 : {
            block18 : {
                block19 : {
                    block16 : {
                        block17 : {
                            var4_4 = e.a(var1);
                            this.d = var2_3;
                            this.r = var3_2;
                            var5_5 = 1;
                            if (var2_3) {
                                this.f.setSelected((boolean)var5_5);
                            } else {
                                this.f.setSelected(false);
                            }
                            this.b.setText((CharSequence)var1.k);
                            var6_6 = this.n;
                            if (e.a(var1)) {
                                var27_7 = new File(var1.i).list((FilenameFilter)new p());
                                var28_8 = var27_7 == null ? 0 : var27_7.length;
                                var29_9 = this.g;
                                var30_10 = new Object[var5_5];
                                var30_10[0] = var28_8;
                                var31_11 = var29_9.getString(2131689666, var30_10);
                                var32_12 = j.c(1000L * var1.w);
                                var9_13 = Locale.getDefault();
                                var10_14 = "%s | %s";
                                var11_15 = new Object[2];
                                var11_15[0] = var31_11;
                                var11_15[var5_5] = var32_12;
                            } else {
                                var7_16 = j.b(var1.l);
                                var8_17 = j.c(1000L * var1.w);
                                var9_13 = Locale.getDefault();
                                var10_14 = "%s | %s";
                                var11_15 = new Object[2];
                                var11_15[0] = var7_16;
                                var11_15[var5_5] = var8_17;
                            }
                            var6_6.setText((CharSequence)String.format((Locale)var9_13, (String)var10_14, (Object[])var11_15));
                            this.p.setVisibility(8);
                            this.q.setVisibility(8);
                            var12_18 = com.xiaomi.midrop.util.g.h(var1.i);
                            if (!var12_18) break block16;
                            a.a(var1.i, new a.b(){

                                @Override
                                public final void a(boolean bl, String string2, String string3) {
                                    e.this.b.setText((CharSequence)string2);
                                    e.this.n.setText((CharSequence)string3);
                                }
                            });
                            if (this.r) break block16;
                            if (!a.a(var1.i)) break block17;
                            this.q.setVisibility(0);
                            var25_19 = this.q;
                            var26_20 = 2131689721;
                            ** GOTO lbl49
                        }
                        if (a.b(var1.i)) {
                            this.q.setVisibility(0);
                            var25_19 = this.q;
                            var26_20 = 2131689722;
lbl49: // 2 sources:
                            var25_19.setText(var26_20);
                        } else {
                            this.p.setVisibility(0);
                            this.p.setOnClickListener(new View.OnClickListener((e)this, var1){
                                final /* synthetic */ g a;
                                final /* synthetic */ e b;
                                {
                                    this.b = e2;
                                    this.a = g2;
                                }

                                public void onClick(View view) {
                                    this.b.p.setVisibility(8);
                                    this.b.q.setVisibility(0);
                                    this.b.q.setText(2131689722);
                                    if (this.b.g instanceof com.xiaomi.midrop.util.Locale.a) {
                                        ((com.xiaomi.midrop.util.Locale.a)this.b.g).a(this.a.i, new com.xiaomi.midrop.send.contacts.a$c(this){
                                            final /* synthetic */ DirectoryItemCard.2 a;
                                            {
                                                this.a = var1;
                                            }

                                            public final void a(boolean bl) {
                                                if (bl) {
                                                    this.a.b.q.setText(2131689721);
                                                    return;
                                                }
                                                if (!this.a.b.r) {
                                                    this.a.b.q.setVisibility(8);
                                                    this.a.b.p.setVisibility(0);
                                                }
                                            }
                                        });
                                    }
                                }
                            });
                        }
                    }
                    if (e.a(var1) || !TextUtils.isEmpty((CharSequence)var1.t)) break block18;
                    var21_21 = j.d(var1.i);
                    if (!com.xiaomi.midrop.util.g.l.contains((Object)var21_21)) break block19;
                    var22_22 = this.g;
                    var23_23 = this.a;
                    var24_24 = var1.h;
                    ** GOTO lbl66
                }
                if (com.xiaomi.midrop.util.g.h.contains((Object)var21_21)) {
                    var22_22 = this.g;
                    var23_23 = this.a;
                    var24_24 = var1.i;
lbl66: // 2 sources:
                    h.a(var22_22, var23_23, var24_24);
                } else {
                    h.b(this.g, this.a, var1.i);
                }
                break block20;
            }
            this.a.setImageResource(2131230988);
        }
        if (var3_2) {
            this.e.setOnClickListener(new View.OnClickListener((e)this, var4_4, var1){
                final /* synthetic */ boolean a;
                final /* synthetic */ g b;
                final /* synthetic */ e c;
                {
                    this.c = e2;
                    this.a = bl;
                    this.b = g2;
                }

                public void onClick(View view) {
                    if (this.a && this.c.h != null && !this.c.d) {
                        this.c.h.a(this.b);
                        return;
                    }
                    this.c.d = true ^ this.c.d;
                    this.c.f.setSelected(this.c.d);
                    new android.os.Handler().post(new java.lang.Runnable(this){
                        final /* synthetic */ DirectoryItemCard.3 a;
                        {
                            this.a = var1;
                        }

                        public final void run() {
                            if (this.a.c.d) {
                                this.a.c.a((View)this.a.c.a);
                                com.xiaomi.midrop.sender.c.g.e().b(this.a.b);
                                if (this.a.c.g instanceof com.xiaomi.midrop.send.FilePickNewActivity) {
                                    ((com.xiaomi.midrop.send.FilePickNewActivity)this.a.c.g).d();
                                    return;
                                }
                            } else {
                                com.xiaomi.midrop.sender.c.g.e().c(this.a.b);
                            }
                        }
                    });
                }
            });
            if (var4_4 && !this.s) {
                var5_5 = 0;
            }
            var19_25 = this.f;
            var20_26 = var5_5 != 0 ? 0 : 8;
            var19_25.setVisibility(var20_26);
            if (var5_5 != 0) {
                this.f.setOnClickListener(new View.OnClickListener((e)this, var4_4, var1){
                    final /* synthetic */ boolean a;
                    final /* synthetic */ g b;
                    final /* synthetic */ e c;
                    {
                        this.c = e2;
                        this.a = bl;
                        this.b = g2;
                    }

                    public void onClick(View view) {
                        this.c.d = true ^ this.c.d;
                        this.c.f.setSelected(this.c.d);
                        new android.os.Handler().post(new java.lang.Runnable(this){
                            final /* synthetic */ DirectoryItemCard.4 a;
                            {
                                this.a = var1;
                            }

                            public final void run() {
                                if (this.a.c.d) {
                                    if (this.a.a) {
                                        com.xiaomi.midrop.sender.c.g.e().b(this.a.b.i);
                                    }
                                    this.a.c.a((View)this.a.c.a);
                                    com.xiaomi.midrop.sender.c.g.e().b(this.a.b);
                                    if (this.a.c.g instanceof com.xiaomi.midrop.send.FilePickNewActivity) {
                                        ((com.xiaomi.midrop.send.FilePickNewActivity)this.a.c.g).d();
                                        return;
                                    }
                                } else {
                                    com.xiaomi.midrop.sender.c.g.e().c(this.a.b);
                                }
                            }
                        });
                    }
                });
            }
            this.e.setOnLongClickListener(null);
        } else {
            this.f.setVisibility(8);
            if (var12_18) {
                this.e.setOnClickListener(null);
            } else {
                this.e.setOnClickListener(new View.OnClickListener((e)this, var1, var4_4){
                    final /* synthetic */ g a;
                    final /* synthetic */ boolean b;
                    final /* synthetic */ e c;
                    {
                        this.c = e2;
                        this.a = g2;
                        this.b = bl;
                    }

                    /*
                     * Enabled aggressive block sorting
                     */
                    public void onClick(View view) {
                        if (this.c.g instanceof ReceivedActivity) {
                            com.xiaomi.midrop.result.a a2;
                            String string2;
                            this.c.o.setVisibility(8);
                            if (new File(this.a.i).isDirectory()) {
                                a2 = com.xiaomi.midrop.result.a.a();
                                string2 = this.a.k;
                            } else {
                                a2 = com.xiaomi.midrop.result.a.a();
                                string2 = this.a.i;
                            }
                            a2.a(7, string2);
                        }
                        if (this.b && this.c.h != null) {
                            this.c.h.a(this.a);
                            return;
                        }
                        String string3 = j.d(this.a.k);
                        if (com.xiaomi.midrop.util.g.l.contains((Object)string3)) {
                            java.util.List list = (java.util.List)this.c.d();
                            if (list != null) {
                                com.xiaomi.midrop.util.ak.a().a((java.util.List<g>)list);
                            }
                            com.xiaomi.midrop.GalleryActivity.a((Context)this.c.g, (g)this.a, (String)"gallery.view");
                            return;
                        }
                        if (this.c.g instanceof com.xiaomi.midrop.OpenDirectoryActivity) {
                            com.xiaomi.midrop.transmission.a.a((Context)((com.xiaomi.midrop.OpenDirectoryActivity)this.c.g), this.a, false);
                            return;
                        }
                        j.b(this.c.g, this.a.i);
                    }
                });
            }
            this.e.setOnLongClickListener(new View.OnLongClickListener((e)this, var1){
                final /* synthetic */ g a;
                final /* synthetic */ e b;
                {
                    this.b = e2;
                    this.a = g2;
                }

                public final boolean onLongClick(View view) {
                    if (this.b.i != null) {
                        com.xiaomi.midrop.sender.c.g.e().b(this.a);
                        this.b.i.a();
                    }
                    return true;
                }
            });
        }
        if (this.g instanceof ReceivedActivity == false) return;
        if (new File(var1.i).isDirectory()) {
            var13_27 = com.xiaomi.midrop.result.a.a();
            var14_28 = this.g;
            var15_29 = var1.k;
        } else {
            var13_27 = com.xiaomi.midrop.result.a.a();
            var14_28 = this.g;
            var15_29 = var1.i;
        }
        var16_30 = var13_27.a(var14_28, 7, var15_29);
        var17_31 = this.o;
        var18_32 = var16_30 != false ? 0 : 8;
        var17_31.setVisibility(var18_32);
    }

}

