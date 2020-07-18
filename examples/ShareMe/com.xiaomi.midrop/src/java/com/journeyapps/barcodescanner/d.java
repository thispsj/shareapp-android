/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.os.Handler
 *  android.util.Log
 *  com.google.zxing.a
 *  com.google.zxing.client.android.R
 *  com.google.zxing.client.android.R$string
 *  com.google.zxing.client.android.b
 *  com.google.zxing.client.android.e
 *  com.google.zxing.r
 *  com.journeyapps.barcodescanner.BarcodeView
 *  com.journeyapps.barcodescanner.d$1
 *  com.journeyapps.barcodescanner.d$2
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.CharSequence
 *  java.lang.Iterable
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 */
package com.journeyapps.barcodescanner;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;
import com.google.zxing.client.android.R;
import com.google.zxing.client.android.e;
import com.google.zxing.r;
import com.journeyapps.barcodescanner.BarcodeView;
import com.journeyapps.barcodescanner.CameraPreview;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.journeyapps.barcodescanner.a;
import com.journeyapps.barcodescanner.a.b;
import com.journeyapps.barcodescanner.c;
import com.journeyapps.barcodescanner.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class d {
    static int a = 250;
    private static final String l = "d";
    Activity b;
    DecoratedBarcodeView c;
    int d = -1;
    boolean e = false;
    boolean f = false;
    e g;
    com.google.zxing.client.android.b h;
    Handler i;
    a j;
    boolean k;
    private boolean m = false;
    private final CameraPreview.a n;

    public d(Activity activity, DecoratedBarcodeView decoratedBarcodeView) {
        this.j = new 1((d)this);
        this.n = new 2((d)this);
        this.k = false;
        this.b = activity;
        this.c = decoratedBarcodeView;
        decoratedBarcodeView.getBarcodeView().a(this.n);
        this.i = new Handler();
        this.g = new e((Context)activity, new Runnable(){

            public final void run() {
                Log.d((String)l, (String)"Finishing due to inactivity");
                d.this.b.finish();
            }
        });
        this.h = new com.google.zxing.client.android.b(activity);
    }

    public static Intent a(c c2, String string2) {
        Map<r, Object> map;
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.addFlags(524288);
        intent.putExtra("SCAN_RESULT", c2.toString());
        intent.putExtra("SCAN_RESULT_FORMAT", c2.d().toString());
        byte[] arrby = c2.c();
        if (arrby != null && arrby.length > 0) {
            intent.putExtra("SCAN_RESULT_BYTES", arrby);
        }
        if ((map = c2.e()) != null) {
            Iterable iterable;
            String string3;
            Number number;
            if (map.containsKey((Object)r.h)) {
                intent.putExtra("SCAN_RESULT_UPC_EAN_EXTENSION", map.get((Object)r.h).toString());
            }
            if ((number = (Number)map.get((Object)r.b)) != null) {
                intent.putExtra("SCAN_RESULT_ORIENTATION", number.intValue());
            }
            if ((string3 = (String)map.get((Object)r.d)) != null) {
                intent.putExtra("SCAN_RESULT_ERROR_CORRECTION_LEVEL", string3);
            }
            if ((iterable = (Iterable)map.get((Object)r.c)) != null) {
                int n2 = 0;
                for (byte[] arrby2 : iterable) {
                    StringBuilder stringBuilder = new StringBuilder("SCAN_RESULT_BYTE_SEGMENTS_");
                    stringBuilder.append(n2);
                    intent.putExtra(stringBuilder.toString(), arrby2);
                    ++n2;
                }
            }
        }
        if (string2 != null) {
            intent.putExtra("SCAN_RESULT_IMAGE_PATH", string2);
        }
        return intent;
    }

    static /* synthetic */ DecoratedBarcodeView a(d d2) {
        return d2.c;
    }

    static /* synthetic */ com.google.zxing.client.android.b b(d d2) {
        return d2.h;
    }

    static /* synthetic */ Handler c(d d2) {
        return d2.i;
    }

    static /* synthetic */ boolean d(d d2) {
        return d2.m;
    }

    final String a(c c2) {
        if (this.e) {
            Bitmap bitmap = c2.a();
            try {
                File file = File.createTempFile((String)"barcodeimage", (String)".jpg", (File)this.b.getCacheDir());
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)fileOutputStream);
                fileOutputStream.close();
                String string2 = file.getAbsolutePath();
                return string2;
            }
            catch (IOException iOException) {
                String string3 = l;
                StringBuilder stringBuilder = new StringBuilder("Unable to create temporary file and store bitmap! ");
                stringBuilder.append((Object)iOException);
                Log.w((String)string3, (String)stringBuilder.toString());
            }
        }
        return null;
    }

    final void a() {
        BarcodeView barcodeView = this.c.getBarcodeView();
        boolean bl = barcodeView.a == null || barcodeView.a.f;
        if (bl) {
            this.b.finish();
        } else {
            this.m = true;
        }
        this.c.a.c();
        this.g.b();
    }

    public final void a(int n2, int[] arrn) {
        if (n2 == a) {
            if (arrn.length > 0 && arrn[0] == 0) {
                this.c.a.d();
                return;
            }
            this.b();
        }
    }

    protected final void b() {
        if (!this.b.isFinishing() && !this.f) {
            if (this.m) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder((Context)this.b);
            builder.setTitle((CharSequence)this.b.getString(R.string.zxing_app_name));
            builder.setMessage((CharSequence)this.b.getString(R.string.zxing_msg_camera_framework_bug));
            builder.setPositiveButton(R.string.zxing_button_ok, new DialogInterface.OnClickListener(){

                public final void onClick(DialogInterface dialogInterface, int n2) {
                    d.this.b.finish();
                }
            });
            builder.setOnCancelListener(new DialogInterface.OnCancelListener(){

                public final void onCancel(DialogInterface dialogInterface) {
                    d.this.b.finish();
                }
            });
            builder.show();
        }
    }

}

