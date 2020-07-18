/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  android.util.Base64
 *  com.bumptech.glide.c.a
 *  com.bumptech.glide.e
 *  com.bumptech.glide.f
 *  com.bumptech.glide.f.c
 *  com.bumptech.glide.i
 *  com.bumptech.glide.j
 *  com.bumptech.glide.load.a
 *  com.bumptech.glide.load.a.d
 *  com.bumptech.glide.load.a.d$a
 *  com.bumptech.glide.load.b.a.e
 *  com.bumptech.glide.load.b.v
 *  com.bumptech.glide.load.c.n
 *  com.bumptech.glide.load.c.n$a
 *  com.bumptech.glide.load.c.o
 *  com.bumptech.glide.load.d.a.d
 *  com.bumptech.glide.load.d.c.b
 *  com.bumptech.glide.load.g
 *  com.bumptech.glide.load.i
 *  com.bumptech.glide.load.j
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.ConcurrentHashMap
 */
package com.xiaomi.midrop.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import com.bumptech.glide.f;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import com.xiaomi.midrop.util.MiDropGlideModule;
import com.xiaomi.midrop.util.l;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class MiDropGlideModule
extends com.bumptech.glide.c.a {
    public final void a(Context context, com.bumptech.glide.e e2, com.bumptech.glide.j j2) {
        j2.a(String.class, Drawable.class, (j)new j<String, Drawable>(context){
            private final Context a;
            {
                this.a = context;
            }

            public final /* synthetic */ v a(Object object, int n2, int n3, i i2) throws IOException {
                String string2 = ((String)object).substring(11);
                PackageManager packageManager = this.a.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageArchiveInfo(string2, 1);
                if (packageInfo != null) {
                    ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                    applicationInfo.sourceDir = string2;
                    applicationInfo.publicSourceDir = string2;
                    return new com.bumptech.glide.load.d.c.b<Drawable>(this, packageManager.getApplicationIcon(applicationInfo)){
                        final /* synthetic */ a b;
                        {
                            this.b = a2;
                            super(drawable2);
                        }

                        public final Class<Drawable> a() {
                            return Drawable.class;
                        }

                        public final int c() {
                            if (this.a instanceof android.graphics.drawable.BitmapDrawable) {
                                return com.bumptech.glide.g.k.a((Bitmap)((android.graphics.drawable.BitmapDrawable)this.a).getBitmap());
                            }
                            return 1;
                        }

                        public final void d() {
                        }
                    };
                }
                return null;
            }

            public final /* synthetic */ boolean a(Object object, i i2) throws IOException {
                return ((String)object).startsWith("midrop:apk/");
            }
        }).a(String.class, Drawable.class, (j)new j<String, Drawable>(0){
            private final String a;
            {
                this.a = "#";
            }

            public final /* synthetic */ v a(Object object, int n2, int n3, i i2) throws IOException {
                String[] arrstring = ((String)object).substring(12).split("#");
                return new com.bumptech.glide.load.d.c.b<Drawable>(this, (Drawable)new l(arrstring[0].toUpperCase(), Integer.parseInt((String)arrstring[1])), n2, n3){
                    final /* synthetic */ int b;
                    final /* synthetic */ int c;
                    final /* synthetic */ c d;
                    {
                        this.d = c2;
                        this.b = n2;
                        this.c = n3;
                        super(drawable2);
                    }

                    public final Class<Drawable> a() {
                        return Drawable.class;
                    }

                    public final int c() {
                        return 2 * (this.b * this.c);
                    }

                    public final void d() {
                    }
                };
            }

            public final /* synthetic */ boolean a(Object object, i i2) throws IOException {
                return ((String)object).startsWith("midrop:icon/");
            }
        }).a(String.class, Bitmap.class, (j)new j<String, Bitmap>(context, com.xiaomi.midrop.transmission.c.e().g){
            private final Context a;
            private ConcurrentHashMap<String, com.xiaomi.midrop.b.f> b;
            {
                this.a = context;
                this.b = concurrentHashMap;
            }

            public final /* synthetic */ v a(Object object, int n2, int n3, i i2) throws IOException {
                String string2 = (String)object;
                if (this.b != null) {
                    if (this.b.isEmpty()) {
                        return null;
                    }
                    String string3 = string2.substring(14);
                    com.xiaomi.midrop.b.f f2 = (com.xiaomi.midrop.b.f)this.b.get((Object)string3);
                    if (f2 == null) {
                        return null;
                    }
                    String string4 = f2.b;
                    if (TextUtils.isEmpty((CharSequence)string4)) {
                        return null;
                    }
                    byte[] arrby = Base64.decode((String)string4, (int)0);
                    return new com.bumptech.glide.load.d.a.d(this, BitmapFactory.decodeByteArray((byte[])arrby, (int)0, (int)arrby.length), com.bumptech.glide.e.a((Context)this.a).a){
                        final /* synthetic */ b a;
                        {
                            this.a = b2;
                            super(bitmap, e2);
                        }
                    };
                }
                return null;
            }

            public final /* synthetic */ boolean a(Object object, i i2) throws IOException {
                return ((String)object).startsWith("midrop:base64/");
            }
        }).a(String.class, String.class, (o)new o<String, String>((MiDropGlideModule)this){
            final /* synthetic */ MiDropGlideModule a;
            {
                this.a = miDropGlideModule;
            }

            public final n<String, String> a(com.bumptech.glide.load.c.r r2) {
                return new n<String, String>(0){

                    public final /* synthetic */ n.a a(Object object, int n2, int n3, i i2) {
                        final String string2 = (String)object;
                        return new n.a((g)new com.bumptech.glide.f.c((Object)string2), (com.bumptech.glide.load.a.d)new com.bumptech.glide.load.a.d<String>(){

                            public final Class<String> a() {
                                return String.class;
                            }

                            public final void a(com.bumptech.glide.i i2, d.a<? super String> a2) {
                                a2.a((Object)string2);
                            }

                            public final void b() {
                            }

                            public final void c() {
                            }

                            public final com.bumptech.glide.load.a d() {
                                return com.bumptech.glide.load.a.a;
                            }
                        });
                    }

                    public final /* synthetic */ boolean a(Object object) {
                        return ((String)object).startsWith("midrop:");
                    }

                };
            }
        });
    }

    public final void a(Context context, f f2) {
        super.a(context, f2);
        f2.k = 6;
        f2.q = false;
    }

}

