/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.text.TextUtils
 *  android.util.Base64
 *  com.bumptech.glide.e
 *  com.bumptech.glide.e.a
 *  com.bumptech.glide.e.c
 *  com.bumptech.glide.e.h
 *  com.bumptech.glide.k
 *  com.bumptech.glide.load.b
 *  com.bumptech.glide.load.b.j
 *  java.io.ByteArrayOutputStream
 *  java.io.File
 *  java.io.OutputStream
 *  java.lang.CharSequence
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.concurrent.ExecutionException
 */
package com.xiaomi.midrop.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Base64;
import com.bumptech.glide.e;
import com.bumptech.glide.e.c;
import com.bumptech.glide.e.h;
import com.bumptech.glide.k;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.b.f;
import com.xiaomi.midrop.util.g;
import com.xiaomi.midrop.util.j;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;

public final class t {

    public static interface a {
        public void a(List<f> var1);
    }

    public static final class b
    extends AsyncTask<Void, Void, List<f>> {
        private List<Uri> a = new ArrayList();
        private a b;

        public b(List<Uri> list, a a2) {
            this.a.addAll(list);
            this.b = a2;
        }

        private static String a(String string2) {
            Bitmap bitmap;
            block12 : {
                block11 : {
                    String string3 = j.d(string2);
                    if (!new File(string2).exists()) {
                        return null;
                    }
                    if (g.c(string3) || g.b(string3) || g.d(string3)) {
                        h h2;
                        block10 : {
                            int n2 = MiDropApplication.a().getResources().getDimensionPixelOffset(2131165729);
                            h2 = (h)((h)((h)((h)new h().a(com.bumptech.glide.load.b.j.b)).e()).c(n2)).a(com.bumptech.glide.load.b.b);
                            if (!g.d(string3)) break block10;
                            StringBuilder stringBuilder = new StringBuilder("midrop:apk/");
                            stringBuilder.append(string2);
                            String string4 = stringBuilder.toString();
                            Drawable drawable2 = (Drawable)e.b((Context)MiDropApplication.a()).a(string4).a((com.bumptech.glide.e.a)h2).b().get();
                            if (drawable2 == null) break block11;
                            if (drawable2 instanceof BitmapDrawable) {
                                bitmap = ((BitmapDrawable)drawable2).getBitmap();
                            } else {
                                int n3 = drawable2.getIntrinsicWidth();
                                int n4 = drawable2.getIntrinsicHeight();
                                Bitmap bitmap2 = Bitmap.createBitmap((int)n3, (int)n4, (Bitmap.Config)Bitmap.Config.RGB_565);
                                Canvas canvas = new Canvas(bitmap2);
                                drawable2.setBounds(0, 0, n3, n4);
                                drawable2.draw(canvas);
                                bitmap = bitmap2;
                            }
                            break block12;
                        }
                        try {
                            bitmap = (Bitmap)e.b((Context)MiDropApplication.a()).d().a(string2).a((com.bumptech.glide.e.a)h2).b().get();
                            break block12;
                        }
                        catch (ExecutionException executionException) {
                            executionException.printStackTrace();
                        }
                        catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                    }
                }
                bitmap = null;
            }
            if (bitmap != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.WEBP, 75, (OutputStream)byteArrayOutputStream);
                return Base64.encodeToString((byte[])byteArrayOutputStream.toByteArray(), (int)0);
            }
            return null;
        }

        protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
            if (this.a.isEmpty()) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            for (Uri uri : this.a) {
                String string2;
                String string3 = uri.getPath();
                if (TextUtils.isEmpty((CharSequence)string3) || TextUtils.isEmpty((CharSequence)(string2 = b.a(string3)))) continue;
                f f2 = new f();
                f2.a = uri.getPath();
                f2.b = string2;
                arrayList.add((Object)f2);
            }
            return arrayList;
        }

        protected final /* synthetic */ void onPostExecute(Object object) {
            List list = (List)object;
            if (this.b != null) {
                this.b.a((List<f>)list);
            }
        }
    }

}

