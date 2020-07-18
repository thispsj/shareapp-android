/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.res.Resources
 *  android.graphics.Point
 *  android.net.Uri
 *  android.support.v4.app.Fragment
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$w
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  android.widget.Toast
 *  com.bumptech.glide.e
 *  com.bumptech.glide.e.a
 *  com.bumptech.glide.e.a.i
 *  com.bumptech.glide.e.h
 *  com.bumptech.glide.k
 *  com.bumptech.glide.load.b.j
 *  com.xiaomi.midrop.cloudsettings.TransResultCardSettingModel
 *  com.xiaomi.midrop.received.ReceivedActivity
 *  com.xiaomi.midrop.result.ResultAdapter$ActivityItemHolder
 *  com.xiaomi.midrop.result.ResultAdapter$ReceivedItemHolder
 *  com.xiaomi.midrop.result.ResultAdapter$ScoreItemHolder
 *  com.xiaomi.midrop.result.ResultAdapter$SilenceItemHolder
 *  com.xiaomi.midrop.result.ResultAdapter$TransferItemHolder
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.text.DecimalFormat
 *  java.util.HashSet
 *  java.util.List
 */
package com.xiaomi.midrop.result;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.e.a.i;
import com.bumptech.glide.e.h;
import com.bumptech.glide.k;
import com.bumptech.glide.load.b.j;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.cloudsettings.TransResultCardSettingModel;
import com.xiaomi.midrop.received.ReceivedActivity;
import com.xiaomi.midrop.result.ResultAdapter;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.am;
import com.xiaomi.midrop.util.ap;
import com.xiaomi.midrop.view.NumberAnimTextView;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.List;

public class ResultAdapter
extends RecyclerView.a
implements View.OnClickListener {
    private Context c;
    private List<com.xiaomi.midrop.result.b> d;
    private int e = -1;
    private d f;

    public ResultAdapter(Fragment fragment, List<com.xiaomi.midrop.result.b> list, d d2) {
        this.c = fragment.getContext();
        this.d = list;
        this.f = d2;
    }

    private static String a(float f2) {
        return new DecimalFormat("0.00").format((double)f2);
    }

    /*
     * Enabled aggressive block sorting
     */
    static /* synthetic */ void a(TextView textView, int n2, int n3) {
        com.xiaomi.midrop.util.Locale.b b2;
        int n4;
        if (n2 == n3) {
            b2 = com.xiaomi.midrop.util.Locale.b.a();
            n4 = 2131689637;
        } else if (n2 < 0) {
            b2 = com.xiaomi.midrop.util.Locale.b.a();
            n4 = 2131689635;
        } else {
            b2 = com.xiaomi.midrop.util.Locale.b.a();
            n4 = 2131689636;
        }
        textView.setText(b2.a(n4));
    }

    static /* synthetic */ void a(ResultAdapter resultAdapter, int n2) {
        resultAdapter.d(n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    static /* synthetic */ void a(ResultAdapter resultAdapter, f f2, View view) {
        int n2;
        Context context;
        if (1.0f * (float)com.xiaomi.midrop.result.a.a().a / 1024.0f / 1024.0f < 5.0f) {
            context = resultAdapter.c;
            n2 = 2131689987;
        } else {
            context = resultAdapter.c;
            n2 = 2131689988;
        }
        String string2 = context.getString(n2);
        com.xiaomi.midrop.result.a a2 = com.xiaomi.midrop.result.a.a();
        Object[] arrobject = new Object[3];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f2.p.getText().toString());
        stringBuilder.append(f2.r.getText().toString());
        arrobject[0] = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(f2.q.getText().toString());
        stringBuilder2.append(f2.s.getText().toString());
        arrobject[1] = stringBuilder2.toString();
        arrobject[2] = resultAdapter.c.getString(2131689708);
        a2.k = String.format((String)string2, (Object[])arrobject);
        if (resultAdapter.f != null) {
            af.a(af.a.dg).a();
            if (am.a(MiDropApplication.a())) {
                resultAdapter.f.onClick(f2.a, view);
                String string3 = "more";
                int n3 = view.getId();
                if (n3 != 2131296480) {
                    if (n3 == 2131296483) {
                        string3 = "whatsapp";
                    }
                } else {
                    string3 = "facebook";
                }
                af.a(af.a.dh).a(af.b.S, string3).a();
                return;
            }
            Toast.makeText((Context)resultAdapter.c, (CharSequence)resultAdapter.c.getString(2131689763), (int)0).show();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void a(NumberAnimTextView numberAnimTextView, float f2, TextView textView, boolean bl) {
        float f3 = f2 * 1.0f / 1024.0f;
        float f4 = f3 / 1024.0f;
        float f5 = f4 / 1024.0f;
        Resources resources = MiDropApplication.a().getResources();
        if (f5 >= 1.0f) {
            numberAnimTextView.a(ResultAdapter.a(0.9f * f5), ResultAdapter.a(f5));
            int n2 = bl ? 2131689935 : 2131689926;
            String string2 = resources.getString(n2);
            textView.setText((CharSequence)string2);
            return;
        }
        if (f4 >= 1.0f) {
            numberAnimTextView.a(ResultAdapter.a(0.9f * f4), ResultAdapter.a(f4));
            int n3 = bl ? 2131689937 : 2131689928;
            String string3 = resources.getString(n3);
            textView.setText((CharSequence)string3);
            return;
        }
        numberAnimTextView.a(ResultAdapter.a(0.9f * f3), ResultAdapter.a(f3));
        int n4 = bl ? 2131689936 : 2131689927;
        String string4 = resources.getString(n4);
        textView.setText((CharSequence)string4);
    }

    static /* synthetic */ int b(ResultAdapter resultAdapter, int n2) {
        resultAdapter.e = n2;
        return n2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static /* synthetic */ void b(ResultAdapter var0) {
        var1_1 = var0.c.getPackageName();
        var2_2 = new StringBuilder("https://play.google.com/store/apps/details?id=");
        var2_2.append(var1_1);
        var4_3 = Uri.parse((String)var2_2.toString());
        var5_4 = new Intent("android.intent.action.VIEW", var4_3);
        var5_4.setPackage("com.android.vending");
        if (var5_4.resolveActivity(var0.c.getPackageManager()) != null) ** GOTO lbl-1000
        var7_5 = new StringBuilder("market://details?id=");
        var7_5.append(var1_1);
        var5_4 = new Intent("android.intent.action.VIEW", Uri.parse((String)var7_5.toString()));
        if (var5_4.resolveActivity(var0.c.getPackageManager()) != null) lbl-1000: // 2 sources:
        {
            var0.c.startActivity(var5_4);
        } else {
            var9_6 = new Intent("android.intent.action.VIEW", var4_3);
            var0.c.startActivity(var9_6);
        }
        Toast.makeText((Context)var0.c, (int)2131689962, (int)1).show();
    }

    private void d(int n2) {
        Intent intent = new Intent(this.c, ReceivedActivity.class);
        intent.putExtra("param_index", n2);
        this.c.startActivity(intent);
    }

    public final int a() {
        if (this.d != null) {
            return this.d.size();
        }
        return 0;
    }

    public final int a(int n2) {
        return ((com.xiaomi.midrop.result.b)this.d.get((int)n2)).a;
    }

    public final RecyclerView.w a(ViewGroup viewGroup, int n2) {
        switch (n2) {
            default: {
                return (ResultAdapter)this.new f(LayoutInflater.from((Context)this.c).inflate(2131427491, viewGroup, false));
            }
            case 4: {
                return (ResultAdapter)this.new a(LayoutInflater.from((Context)this.c).inflate(2131427488, viewGroup, false));
            }
            case 3: {
                return (ResultAdapter)this.new e(LayoutInflater.from((Context)this.c).inflate(2131427492, viewGroup, false));
            }
            case 2: {
                return (ResultAdapter)this.new c(LayoutInflater.from((Context)this.c).inflate(2131427490, viewGroup, false));
            }
            case 1: {
                return (ResultAdapter)this.new b(LayoutInflater.from((Context)this.c).inflate(2131427489, viewGroup, false));
            }
            case 0: 
        }
        return (ResultAdapter)this.new f(LayoutInflater.from((Context)this.c).inflate(2131427491, viewGroup, false));
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void a(RecyclerView.w w2, int n2) {
        switch (this.a(n2)) {
            default: {
                return;
            }
            case 4: {
                a a2 = (a)w2;
                TransResultCardSettingModel.TransResultCardSettingContent transResultCardSettingContent = com.xiaomi.midrop.cloudsettings.a.b.b().a;
                if (!transResultCardSettingContent.validate()) break;
                a2.o.setText((CharSequence)transResultCardSettingContent.getTitle());
                h h2 = (h)((h)new h().a(j.c)).a(2131230959);
                com.bumptech.glide.e.b((Context)this.c).d().a(transResultCardSettingContent.getImgUrl()).a((com.bumptech.glide.e.a)h2).a(a2.p);
                return;
            }
            case 3: {
                e e2 = (e)w2;
                TextView textView = e2.p;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(e2.p.getText().toString());
                stringBuilder.append(" ");
                stringBuilder.append(com.xiaomi.midrop.result.a.a().l);
                textView.setText((CharSequence)stringBuilder.toString());
            }
            case 2: {
                return;
            }
            case 1: {
                HashSet<String> hashSet;
                HashSet<String> hashSet2;
                HashSet<String> hashSet3;
                HashSet<String> hashSet4;
                b b2 = (b)w2;
                HashSet<String> hashSet5 = com.xiaomi.midrop.result.a.a().a(2);
                if (hashSet5 != null && hashSet5.size() > 0) {
                    b2.o.setVisibility(0);
                    b2.o.setText((CharSequence)String.valueOf((int)hashSet5.size()));
                    b2.o.setOnClickListener((View.OnClickListener)this);
                }
                if ((hashSet4 = com.xiaomi.midrop.result.a.a().a(3)) != null && hashSet4.size() > 0) {
                    b2.p.setVisibility(0);
                    b2.p.setText((CharSequence)String.valueOf((int)hashSet4.size()));
                    b2.p.setOnClickListener((View.OnClickListener)this);
                }
                if ((hashSet3 = com.xiaomi.midrop.result.a.a().a(4)) != null && hashSet3.size() > 0) {
                    b2.q.setVisibility(0);
                    b2.q.setText((CharSequence)String.valueOf((int)hashSet3.size()));
                    b2.q.setOnClickListener((View.OnClickListener)this);
                }
                if ((hashSet = com.xiaomi.midrop.result.a.a().a(1)) != null && hashSet.size() > 0) {
                    b2.r.setVisibility(0);
                    b2.r.setText((CharSequence)String.valueOf((int)hashSet.size()));
                    b2.r.setOnClickListener((View.OnClickListener)this);
                }
                if ((hashSet2 = com.xiaomi.midrop.result.a.a().a(7)) != null && hashSet2.size() > 0) {
                    b2.s.setVisibility(0);
                    b2.s.setText((CharSequence)String.valueOf((int)hashSet2.size()));
                    b2.s.setOnClickListener((View.OnClickListener)this);
                }
                return;
            }
            case 0: {
                Context context;
                int n3;
                f f2 = (f)w2;
                float f3 = com.xiaomi.midrop.result.a.a().a;
                float f4 = 1.0f * f3 / 1024.0f / 1024.0f;
                if (f4 > 50.0f) {
                    context = this.c;
                    n3 = 2131689997;
                } else if (f4 > 20.0f) {
                    context = this.c;
                    n3 = 2131689996;
                } else if (f4 > 10.0f) {
                    context = this.c;
                    n3 = 2131689995;
                } else if (f4 > 7.0f) {
                    context = this.c;
                    n3 = 2131689994;
                } else if (f4 > 5.0f) {
                    context = this.c;
                    n3 = 2131689993;
                } else {
                    context = this.c;
                    n3 = 2131689992;
                }
                String string2 = context.getString(n3);
                f2.o.setText((CharSequence)string2);
                long l2 = com.xiaomi.midrop.result.a.a().b;
                ResultAdapter.a(f2.p, l2, f2.r, false);
                ResultAdapter.a(f2.q, f3, f2.s, true);
                f2.t.setText(2131689985);
                f2.u.setText(2131689981);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onClick(View view) {
        af.b b2;
        String string2;
        af af2;
        switch (view.getId()) {
            default: {
                return;
            }
            case 2131296877: {
                ResultAdapter.super.d(ReceivedActivity.a((int)4));
                af2 = af.a(af.a.dj);
                b2 = af.b.T;
                string2 = "video";
                break;
            }
            case 2131296851: {
                ResultAdapter.super.d(ReceivedActivity.a((int)2));
                af2 = af.a(af.a.dj);
                b2 = af.b.T;
                string2 = "image";
                break;
            }
            case 2131296844: {
                ResultAdapter.super.d(ReceivedActivity.a((int)7));
                af.a(af.a.dj).a(af.b.T, "file").a();
                return;
            }
            case 2131296837: {
                ResultAdapter.super.d(ReceivedActivity.a((int)3));
                af2 = af.a(af.a.dj);
                b2 = af.b.T;
                string2 = "audio";
                break;
            }
            case 2131296835: {
                ResultAdapter.super.d(ReceivedActivity.a((int)1));
                af2 = af.a(af.a.dj);
                b2 = af.b.T;
                string2 = "apk";
            }
        }
        af2.a(b2, string2).a();
    }

    private final class a
    extends RecyclerView.w {
        private TextView o;
        private ImageView p;

        a(View view) {
            super(view);
            this.o = (TextView)view.findViewById(2131296871);
            this.p = (ImageView)view.findViewById(2131296494);
            this.p.getLayoutParams().height = (int)(0.5 * (double)(ac.b((Context)ResultAdapter.c((ResultAdapter)ResultAdapter.this)).x - com.xiaomi.midrop.sender.c.c.a(ResultAdapter.this.c, 48.0f)));
            this.p.setOnClickListener(new View.OnClickListener((a)this, ResultAdapter.this){
                final /* synthetic */ ResultAdapter a;
                final /* synthetic */ a b;
                {
                    this.b = a2;
                    this.a = resultAdapter;
                }

                public void onClick(View view) {
                    TransResultCardSettingModel.TransResultCardSettingContent transResultCardSettingContent = com.xiaomi.midrop.cloudsettings.a.b.b().a;
                    if (transResultCardSettingContent != null) {
                        com.xiaomi.midrop.activity.b.a((android.app.Activity)ResultAdapter.c(this.b.ResultAdapter.this), transResultCardSettingContent.getWebUrl(), transResultCardSettingContent.isOpenByBrowser());
                        com.xiaomi.midrop.util.ae.a(af.a.bL, transResultCardSettingContent.getImgUrl());
                    }
                }
            });
        }
    }

    private final class b
    extends RecyclerView.w {
        private TextView o;
        private TextView p;
        private TextView q;
        private TextView r;
        private TextView s;
        private TextView t;

        public b(View view) {
            super(view);
            this.o = (TextView)view.findViewById(2131296851);
            this.p = (TextView)view.findViewById(2131296837);
            this.q = (TextView)view.findViewById(2131296877);
            this.r = (TextView)view.findViewById(2131296835);
            this.s = (TextView)view.findViewById(2131296844);
            this.t = (TextView)view.findViewById(2131296380);
            this.t.setOnClickListener(new View.OnClickListener((b)this, ResultAdapter.this){
                final /* synthetic */ ResultAdapter a;
                final /* synthetic */ b b;
                {
                    this.b = b2;
                    this.a = resultAdapter;
                }

                public void onClick(View view) {
                    int n2;
                    block2 : {
                        int[] arrn = ReceivedActivity.b;
                        for (n2 = 0; n2 < arrn.length; ++n2) {
                            HashSet<String> hashSet = com.xiaomi.midrop.result.a.a().a(arrn[n2]);
                            if (hashSet == null || hashSet.isEmpty()) {
                                continue;
                            }
                            break block2;
                        }
                        n2 = 2;
                    }
                    ResultAdapter.a(this.b.ResultAdapter.this, n2);
                    af.a(af.a.dj).a(af.b.T, "btn").a();
                }
            });
            LinearLayout linearLayout = (LinearLayout)view.findViewById(2131296564);
            int n2 = linearLayout.getChildCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                View view2 = linearLayout.getChildAt(i2);
                view2.setOnTouchListener(new View.OnTouchListener(view2.getAlpha()){
                    final /* synthetic */ float a;
                    final /* synthetic */ float b;
                    {
                        this.a = 0.6f;
                        this.b = f2;
                    }

                    /*
                     * Unable to fully structure code
                     * Enabled aggressive block sorting
                     * Lifted jumps to return sites
                     */
                    public final boolean onTouch(View var1, android.view.MotionEvent var2_2) {
                        var3_3 = var2_2.getAction();
                        if (var3_3 == 3) ** GOTO lbl-1000
                        switch (var3_3) {
                            default: {
                                return false;
                            }
                            case 1: lbl-1000: // 2 sources:
                            {
                                var4_4 = this.b;
                                ** break;
                            }
                            case 0: 
                        }
                        var4_4 = this.a;
lbl11: // 2 sources:
                        var1.setAlpha(var4_4);
                        return false;
                    }
                });
            }
        }
    }

    private final class c
    extends RecyclerView.w {
        private ImageView[] o;
        private int[] p;
        private int[] q;
        private TextView r;
        private TextView s;

        /*
         * Enabled aggressive block sorting
         */
        public c(View view) {
            super(view);
            this.s = (TextView)view.findViewById(2131296659);
            this.p = new int[]{2131231144, 2131231146, 2131231148, 2131231150, 2131231152};
            this.q = new int[]{2131231145, 2131231147, 2131231149, 2131231151, 2131231153};
            TextView textView = this.r = (TextView)view.findViewById(2131296380);
            int n2 = ResultAdapter.this.e;
            int n3 = 0;
            boolean bl = n2 >= 0;
            textView.setEnabled(bl);
            this.r.setOnClickListener(new View.OnClickListener((c)this, ResultAdapter.this){
                final /* synthetic */ ResultAdapter a;
                final /* synthetic */ c b;
                {
                    this.b = c2;
                    this.a = resultAdapter;
                }

                public void onClick(View view) {
                    af.a(af.a.dl).a();
                    if (am.a(MiDropApplication.a())) {
                        if (ResultAdapter.a(this.b.ResultAdapter.this) == -1 + c.a(this.b).length) {
                            ResultAdapter.b(this.b.ResultAdapter.this);
                        } else if (ResultAdapter.a(this.b.ResultAdapter.this) >= 0) {
                            com.xiaomi.midrop.feedback.a.a(ResultAdapter.c(this.b.ResultAdapter.this));
                        }
                        com.xiaomi.midrop.util.y.a(1 + ResultAdapter.a(this.b.ResultAdapter.this));
                        af.a(af.a.dm).a(af.b.U, String.valueOf((int)(1 + ResultAdapter.a(this.b.ResultAdapter.this)))).a();
                        return;
                    }
                    Toast.makeText((Context)ResultAdapter.c(this.b.ResultAdapter.this), (CharSequence)ResultAdapter.c(this.b.ResultAdapter.this).getString(2131689763), (int)0).show();
                }
            });
            this.o = new ImageView[5];
            this.o[0] = (ImageView)view.findViewById(2131296702);
            this.o[1] = (ImageView)view.findViewById(2131296703);
            this.o[2] = (ImageView)view.findViewById(2131296704);
            this.o[3] = (ImageView)view.findViewById(2131296705);
            this.o[4] = (ImageView)view.findViewById(2131296706);
            for (int i2 = 0; i2 < this.o.length; ++i2) {
                int n4;
                ImageView imageView;
                if (ResultAdapter.this.e > i2) {
                    imageView = this.o[i2];
                    n4 = this.q[i2];
                } else {
                    imageView = this.o[i2];
                    n4 = this.p[i2];
                }
                imageView.setImageResource(n4);
            }
            ResultAdapter.a(this.s, ResultAdapter.this.e, this.o.length - 1);
            while (n3 < this.o.length) {
                this.o[n3].setOnClickListener(new View.OnClickListener((c)this, ResultAdapter.this){
                    final /* synthetic */ ResultAdapter a;
                    final /* synthetic */ c b;
                    {
                        this.b = c2;
                        this.a = resultAdapter;
                    }

                    public void onClick(View view) {
                        int n2;
                        for (int i2 = 0; i2 < c.a(this.b).length; ++i2) {
                            c.a(this.b)[i2].setImageResource(c.b(this.b)[i2]);
                        }
                        int n3 = 0;
                        do {
                            int n4 = c.a(this.b).length;
                            n2 = 0;
                            if (n3 >= n4) break;
                            ImageView imageView = c.a(this.b)[n3];
                            n2 = 0;
                            if (imageView == view) break;
                            ++n3;
                        } while (true);
                        while (n2 <= n3) {
                            c.a(this.b)[n2].setImageResource(c.c(this.b)[n3]);
                            ++n2;
                        }
                        ResultAdapter.a(c.d(this.b), n3, c.a(this.b).length - 1);
                        c.e(this.b).setEnabled(true);
                        ResultAdapter.b(this.b.ResultAdapter.this, n3);
                    }
                });
                ++n3;
            }
            return;
        }

        static /* synthetic */ ImageView[] a(c c2) {
            return c2.o;
        }

        static /* synthetic */ int[] b(c c2) {
            return c2.p;
        }

        static /* synthetic */ int[] c(c c2) {
            return c2.q;
        }

        static /* synthetic */ TextView d(c c2) {
            return c2.s;
        }

        static /* synthetic */ TextView e(c c2) {
            return c2.r;
        }
    }

    private final class e
    extends RecyclerView.w {
        private TextView o;
        private TextView p;

        public e(View view) {
            super(view);
            this.o = (TextView)view.findViewById(2131296380);
            this.p = (TextView)view.findViewById(2131296874);
            this.o.setOnClickListener(new View.OnClickListener((e)this, ResultAdapter.this){
                final /* synthetic */ ResultAdapter a;
                final /* synthetic */ e b;
                {
                    this.b = e2;
                    this.a = resultAdapter;
                }

                public void onClick(View view) {
                    String string2 = com.xiaomi.midrop.result.a.a().g;
                    if (!android.text.TextUtils.isEmpty((CharSequence)string2)) {
                        com.xiaomi.midrop.util.j.b(view.getContext(), string2);
                        af.a(af.a.do).a();
                    }
                }
            });
        }
    }

    private final class f
    extends RecyclerView.w {
        private View A;
        private TextView o;
        private NumberAnimTextView p;
        private NumberAnimTextView q;
        private TextView r;
        private TextView s;
        private TextView t;
        private TextView u;
        private View v;
        private View w;
        private View x;
        private View y;
        private View z;

        public f(View view) {
            super(view);
            this.o = (TextView)view.findViewById(2131296874);
            this.p = (NumberAnimTextView)view.findViewById(2131296872);
            this.q = (NumberAnimTextView)view.findViewById(2131296873);
            this.r = (TextView)view.findViewById(2131296854);
            this.s = (TextView)view.findViewById(2131296860);
            this.t = (TextView)view.findViewById(2131296853);
            this.u = (TextView)view.findViewById(2131296859);
            this.v = view.findViewById(2131296480);
            this.w = view.findViewById(2131296483);
            this.x = view.findViewById(2131296481);
            this.y = view.findViewById(2131296861);
            this.z = view.findViewById(2131296747);
            this.A = view.findViewById(2131296746);
            this.v.setOnClickListener(new View.OnClickListener((f)this, ResultAdapter.this){
                final /* synthetic */ ResultAdapter a;
                final /* synthetic */ f b;
                {
                    this.b = f2;
                    this.a = resultAdapter;
                }

                public void onClick(View view) {
                    ResultAdapter.a(this.b.ResultAdapter.this, this.b, view);
                }
            });
            this.w.setOnClickListener(new View.OnClickListener((f)this, ResultAdapter.this){
                final /* synthetic */ ResultAdapter a;
                final /* synthetic */ f b;
                {
                    this.b = f2;
                    this.a = resultAdapter;
                }

                public void onClick(View view) {
                    ResultAdapter.a(this.b.ResultAdapter.this, this.b, view);
                }
            });
            this.x.setOnClickListener(new View.OnClickListener((f)this, ResultAdapter.this){
                final /* synthetic */ ResultAdapter a;
                final /* synthetic */ f b;
                {
                    this.b = f2;
                    this.a = resultAdapter;
                }

                public void onClick(View view) {
                    ResultAdapter.a(this.b.ResultAdapter.this, this.b, view);
                }
            });
            this.y.setOnClickListener(new View.OnClickListener((f)this, ResultAdapter.this){
                final /* synthetic */ ResultAdapter a;
                final /* synthetic */ f b;
                {
                    this.b = f2;
                    this.a = resultAdapter;
                }

                public void onClick(View view) {
                    ResultAdapter.a(this.b.ResultAdapter.this, this.b, view);
                }
            });
        }
    }

}

