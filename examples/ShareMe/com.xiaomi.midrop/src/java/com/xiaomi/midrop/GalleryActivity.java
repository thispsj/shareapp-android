/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ObjectAnimator
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.support.v4.view.ViewPager
 *  android.support.v4.view.ViewPager$e
 *  android.support.v4.view.n
 *  android.text.TextUtils
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.xiaomi.midrop.GalleryActivity$GalleryAdapter
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Field
 *  java.text.DateFormat
 *  java.util.ArrayList
 *  java.util.Date
 *  java.util.List
 *  java.util.Locale
 */
package com.xiaomi.midrop;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.n;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.midrop.GalleryActivity;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.ag;
import com.xiaomi.midrop.util.ak;
import com.xiaomi.midrop.util.h;
import com.xiaomi.midrop.util.j;
import java.io.File;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import midrop.service.c.d;

public class GalleryActivity
extends com.xiaomi.midrop.util.Locale.a
implements View.OnClickListener {
    private final String a = GalleryActivity.class.getCanonicalName();
    private ViewPager b;
    private TextView c;
    private TextView d;
    private View e;
    private View f;
    private View g;
    private DateFormat h;
    private g i;
    private String j;
    private ObjectAnimator k;
    private ObjectAnimator l;

    static /* synthetic */ View a(GalleryActivity galleryActivity) {
        return galleryActivity.f;
    }

    static /* synthetic */ g a(GalleryActivity galleryActivity, g g2) {
        galleryActivity.i = g2;
        return g2;
    }

    public static void a(Context context, g g2, String string) {
        Intent intent = new Intent(context, GalleryActivity.class);
        intent.putExtra("cur_item", (Parcelable)g2);
        intent.setAction(string);
        context.startActivity(intent);
    }

    private void a(g g2) {
        long l2 = g2.w;
        if (l2 == 0L) {
            if (!TextUtils.isEmpty((CharSequence)g2.i)) {
                l2 = new File(g2.i).lastModified();
            }
        } else {
            l2 *= 1000L;
        }
        this.c.setText((CharSequence)this.h.format(new Date(l2)));
        this.d.setText((CharSequence)j.c(g2.i));
        this.e.setSelected(com.xiaomi.midrop.sender.c.g.e().a(g2));
    }

    static /* synthetic */ g b(GalleryActivity galleryActivity) {
        return galleryActivity.i;
    }

    static /* synthetic */ void b(GalleryActivity galleryActivity, g g2) {
        galleryActivity.a(g2);
    }

    static /* synthetic */ void c(GalleryActivity galleryActivity) {
        if (galleryActivity.k.isRunning()) {
            galleryActivity.k.cancel();
        }
        if (!galleryActivity.l.isRunning() && galleryActivity.f.getVisibility() == 0) {
            galleryActivity.l.start();
            galleryActivity.getWindow().getDecorView().setSystemUiVisibility(3846);
        }
    }

    static /* synthetic */ void d(GalleryActivity galleryActivity) {
        if (galleryActivity.l.isRunning()) {
            galleryActivity.l.cancel();
        }
        if (!galleryActivity.k.isRunning() && galleryActivity.f.getVisibility() == 8) {
            galleryActivity.k.start();
            galleryActivity.x();
        }
    }

    public void onClick(View view) {
        int n2 = view.getId();
        if (n2 != 2131296508) {
            if (n2 != 2131296734) {
                return;
            }
            boolean bl = view.isSelected();
            view.setSelected(bl ^ true);
            if (bl) {
                com.xiaomi.midrop.sender.c.g.e().c(this.i);
                return;
            }
            com.xiaomi.midrop.sender.c.g.e().b(this.i);
            return;
        }
        try {
            this.onBackPressed();
        }
        catch (IllegalStateException illegalStateException) {}
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a(2131427367, false);
        this.x();
        if (Build.VERSION.SDK_INT >= 21) {
            this.getWindow().addFlags(Integer.MIN_VALUE);
            this.getWindow().setNavigationBarColor(this.getResources().getColor(2131100034));
        }
        this.g = this.findViewById(2131296393);
        this.i = (g)this.getIntent().getParcelableExtra("cur_item");
        this.j = this.getIntent().getAction();
        if (TextUtils.isEmpty((CharSequence)this.j)) {
            this.j = "gallery.view";
        }
        if (this.i != null) {
            this.h = j.b();
            this.f = this.findViewById(2131296528);
            int n2 = (int)TypedValue.applyDimension((int)1, (float)6.0f, (DisplayMetrics)this.getResources().getDisplayMetrics());
            this.f.setPaddingRelative(this.f.getPaddingStart(), n2 + ag.a((Context)this), this.f.getPaddingEnd(), this.f.getPaddingBottom());
            View view = this.findViewById(2131296508);
            if (ac.c((Context)this)) {
                view.setRotation(180.0f);
            }
            view.setOnClickListener((View.OnClickListener)this);
            this.c = (TextView)this.findViewById(2131296843);
            this.d = (TextView)this.findViewById(2131296848);
            this.e = this.findViewById(2131296734);
            if (TextUtils.equals((CharSequence)this.j, (CharSequence)"gallery.view")) {
                this.e.setVisibility(8);
            } else {
                this.e.setOnClickListener((View.OnClickListener)this);
            }
            GalleryActivity.super.a(this.i);
        }
        this.k = ObjectAnimator.ofFloat((Object)this.f, (String)"alpha", (float[])new float[]{0.0f, 1.0f});
        this.k.setDuration(500L);
        this.k.addListener(new Animator.AnimatorListener((GalleryActivity)this){
            final /* synthetic */ GalleryActivity a;
            {
                this.a = galleryActivity;
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }

            public final void onAnimationStart(Animator animator) {
                GalleryActivity.a(this.a).setVisibility(0);
            }
        });
        this.l = ObjectAnimator.ofFloat((Object)this.f, (String)"alpha", (float[])new float[]{1.0f, 0.0f});
        this.l.setDuration(300L);
        this.l.addListener(new Animator.AnimatorListener((GalleryActivity)this){
            final /* synthetic */ GalleryActivity a;
            {
                this.a = galleryActivity;
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                GalleryActivity.a(this.a).setVisibility(8);
            }

            public final void onAnimationRepeat(Animator animator) {
            }

            public final void onAnimationStart(Animator animator) {
                GalleryActivity.a(this.a).setVisibility(0);
            }
        });
        if (this.i != null) {
            ArrayList arrayList = ak.a().b();
            if (arrayList == null) {
                arrayList = new ArrayList();
                arrayList.add((Object)this.i);
            }
            this.b = (ViewPager)this.findViewById(2131296919);
            n n3 = new n((Context)this, (List<g>)arrayList){
                private List<g> b;
                private Context c;
                {
                    this.c = context;
                    this.b = list;
                }

                public final Object a(ViewGroup viewGroup, int n2) {
                    Locale locale = Locale.getDefault();
                    Object[] arrobject = new Object[]{n2};
                    String.format((Locale)locale, (String)"Instantiate item, position is %d", (Object[])arrobject);
                    ImageView imageView = (ImageView)LayoutInflater.from((Context)this.c).inflate(2131427450, null);
                    viewGroup.addView((View)imageView);
                    imageView.setOnClickListener(new View.OnClickListener(this){
                        final /* synthetic */ a a;
                        {
                            this.a = a2;
                        }

                        public void onClick(View view) {
                            if (GalleryActivity.a(this.a.GalleryActivity.this).getVisibility() == 0) {
                                GalleryActivity.c(this.a.GalleryActivity.this);
                                return;
                            }
                            GalleryActivity.d(this.a.GalleryActivity.this);
                        }
                    });
                    h.a(this.c, imageView, ((g)this.b.get((int)n2)).i);
                    return imageView;
                }

                public final void a(ViewGroup viewGroup, int n2, Object object) {
                    Locale locale = Locale.getDefault();
                    Object[] arrobject = new Object[]{n2};
                    String.format((Locale)locale, (String)"Destroy item, position is %d", (Object[])arrobject);
                    viewGroup.removeView((View)object);
                }

                public final boolean a(View view, Object object) {
                    return view == object;
                }

                public final int b(Object object) {
                    return super.b(object);
                }

                public final int c() {
                    if (this.b == null) {
                        return 0;
                    }
                    return this.b.size();
                }
            };
            this.b.setAdapter(n3);
            int n4 = arrayList.indexOf((Object)this.i);
            this.b.setCurrentItem(n4);
            this.b.a(new ViewPager.e((GalleryActivity)this, (List)arrayList){
                final /* synthetic */ List a;
                final /* synthetic */ GalleryActivity b;
                {
                    this.b = galleryActivity;
                    this.a = list;
                }

                public final void a(int n2) {
                    GalleryActivity.a(this.b, (g)this.a.get(n2));
                    GalleryActivity.b(this.b, GalleryActivity.b(this.b));
                }

                public final void a(int n2, float f2) {
                }
            });
        }
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams layoutParams = this.getWindow().getAttributes();
            try {
                layoutParams.getClass().getField("layoutInDisplayCutoutMode").set((Object)layoutParams, (Object)1);
                this.getWindow().setAttributes(layoutParams);
                return;
            }
            catch (Exception exception) {
                d.a(this.a, "layoutInDisplayCutoutMode", exception, new Object[0]);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}

