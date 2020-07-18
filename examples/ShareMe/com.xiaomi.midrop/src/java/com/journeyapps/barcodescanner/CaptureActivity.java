/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.support.v4.app.a
 *  android.support.v4.content.a
 *  android.view.Display
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.Window
 *  android.view.WindowManager
 *  com.google.zxing.client.android.R
 *  com.google.zxing.client.android.R$id
 *  com.google.zxing.client.android.R$layout
 *  com.google.zxing.client.android.b
 *  com.google.zxing.client.android.c
 *  com.google.zxing.client.android.d
 *  com.google.zxing.client.android.e
 *  com.google.zxing.k
 *  com.journeyapps.barcodescanner.BarcodeView
 *  com.journeyapps.barcodescanner.i
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Map
 *  java.util.Set
 */
package com.journeyapps.barcodescanner;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.google.zxing.client.android.R;
import com.google.zxing.client.android.b;
import com.google.zxing.client.android.c;
import com.google.zxing.client.android.e;
import com.google.zxing.k;
import com.journeyapps.barcodescanner.BarcodeView;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.journeyapps.barcodescanner.a;
import com.journeyapps.barcodescanner.a.d;
import com.journeyapps.barcodescanner.d;
import com.journeyapps.barcodescanner.f;
import com.journeyapps.barcodescanner.i;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class CaptureActivity
extends Activity {
    private com.journeyapps.barcodescanner.d a;
    private DecoratedBarcodeView b;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    protected void onCreate(Bundle var1) {
        block9 : {
            block10 : {
                block11 : {
                    block13 : {
                        block12 : {
                            super.onCreate(var1);
                            this.setContentView(R.layout.zxing_capture);
                            this.b = (DecoratedBarcodeView)this.findViewById(R.id.zxing_barcode_scanner);
                            var2_2 = this.a = new com.journeyapps.barcodescanner.d((Activity)this, this.b);
                            var3_3 = this.getIntent();
                            var2_2.b.getWindow().addFlags(128);
                            if (var1 != null) {
                                var2_2.d = var1.getInt("SAVED_ORIENTATION_LOCK", -1);
                            }
                            if (var3_3 == null) break block9;
                            if (!var3_3.getBooleanExtra("SCAN_ORIENTATION_LOCKED", true)) break block10;
                            if (var2_2.d != -1) break block11;
                            var15_4 = var2_2.b.getWindowManager().getDefaultDisplay().getRotation();
                            var16_5 = var2_2.b.getResources().getConfiguration().orientation;
                            if (var16_5 != 2) break block12;
                            if (var15_4 == 0 || var15_4 == 1) ** GOTO lbl-1000
                            var17_6 = 8;
                            break block13;
                        }
                        if (var16_5 == 1) {
                            var17_6 = var15_4 != 0 && var15_4 != 3 ? 9 : 1;
                        } else lbl-1000: // 2 sources:
                        {
                            var17_6 = 0;
                        }
                    }
                    var2_2.d = var17_6;
                }
                var2_2.b.setRequestedOrientation(var2_2.d);
            }
            if ("com.google.zxing.client.android.SCAN".equals((Object)var3_3.getAction())) {
                var7_7 = var2_2.c;
                var8_8 = c.a((Intent)var3_3);
                var9_9 = com.google.zxing.client.android.d.a((Intent)var3_3);
                var10_10 = new d();
                if (var3_3.hasExtra("SCAN_CAMERA_ID") && (var14_11 = var3_3.getIntExtra("SCAN_CAMERA_ID", -1)) >= 0) {
                    var10_10.a = var14_11;
                }
                if ((var11_12 = var3_3.getStringExtra("PROMPT_MESSAGE")) != null) {
                    var7_7.setStatusText(var11_12);
                }
                var12_13 = var3_3.getIntExtra("SCAN_TYPE", 0);
                var13_14 = var3_3.getStringExtra("CHARACTER_SET");
                new k().a(var9_9);
                var7_7.a.setCameraSettings(var10_10);
                var7_7.a.setDecoderFactory((f)new i((Collection)var8_8, var9_9, var13_14, var12_13));
            }
            if (!var3_3.getBooleanExtra("BEEP_ENABLED", true)) {
                var2_2.h.a = false;
            }
            if (var3_3.hasExtra("TIMEOUT")) {
                var5_15 = new Runnable(var2_2){
                    final /* synthetic */ com.journeyapps.barcodescanner.d a;
                    {
                        this.a = d2;
                    }

                    public final void run() {
                        com.journeyapps.barcodescanner.d d2 = this.a;
                        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                        intent.putExtra("TIMEOUT", true);
                        d2.b.setResult(0, intent);
                        d2.a();
                    }
                };
                var2_2.i.postDelayed(var5_15, var3_3.getLongExtra("TIMEOUT", 0L));
            }
            if (var3_3.getBooleanExtra("BARCODE_IMAGE_ENABLED", false)) {
                var2_2.e = true;
            }
        }
        var4_16 = this.a;
        var4_16.c.a(var4_16.j);
    }

    protected void onDestroy() {
        super.onDestroy();
        com.journeyapps.barcodescanner.d d2 = this.a;
        d2.f = true;
        d2.g.b();
        d2.i.removeCallbacksAndMessages(null);
    }

    public boolean onKeyDown(int n2, KeyEvent keyEvent) {
        return this.b.onKeyDown(n2, keyEvent) || super.onKeyDown(n2, keyEvent);
        {
        }
    }

    /*
     * Exception decompiling
     */
    protected void onPause() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl34.1 : RETURN : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1113)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:588)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    public void onRequestPermissionsResult(int n2, String[] arrstring, int[] arrn) {
        this.a.a(n2, arrn);
    }

    protected void onResume() {
        super.onResume();
        com.journeyapps.barcodescanner.d d2 = this.a;
        if (Build.VERSION.SDK_INT >= 23 && android.support.v4.content.a.a((Context)d2.b, (String)"android.permission.CAMERA") != 0) {
            if (!d2.k) {
                android.support.v4.app.a.a((Activity)d2.b, (String[])new String[]{"android.permission.CAMERA"}, (int)com.journeyapps.barcodescanner.d.a);
                d2.k = true;
            }
        } else {
            d2.c.a.d();
        }
        e e2 = d2.g;
        if (!e2.c) {
            e2.a.registerReceiver(e2.b, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            e2.c = true;
        }
        e2.a();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("SAVED_ORIENTATION_LOCK", this.a.d);
    }
}

