/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 */
package com.xiaomi.midrop.share;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.midrop.share.ShareViaBluetoothActivity;
import com.xiaomi.midrop.util.Locale.a;
import com.xiaomi.midrop.util.Locale.b;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.ag;

public class ShareViaBluetoothActivity
extends a
implements View.OnClickListener {
    static final String a = "com.xiaomi.midrop.share.ShareViaBluetoothActivity";
    private b b;

    public void onClick(View view) {
        int n2 = view.getId();
        if (n2 != 2131296485) {
            if (n2 != 2131296839) {
                return;
            }
            new AsyncTask<Void, Void, String>((ShareViaBluetoothActivity)this){
                final /* synthetic */ ShareViaBluetoothActivity a;
                {
                    this.a = shareViaBluetoothActivity;
                }

                protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
                    return com.xiaomi.midrop.util.j.b((Context)this.a);
                }

                protected final /* synthetic */ void onPostExecute(Object object) {
                    block10 : {
                        android.net.Uri uri;
                        String string2 = (String)object;
                        ShareViaBluetoothActivity shareViaBluetoothActivity = this.a;
                        if (android.text.TextUtils.isEmpty((CharSequence)string2)) {
                            midrop.service.c.d.b(ShareViaBluetoothActivity.a, "FilePath is null", new Object[0]);
                            return;
                        }
                        java.io.File file = new java.io.File(string2);
                        android.content.Intent intent = new android.content.Intent();
                        if (android.os.Build$VERSION.SDK_INT >= 23) {
                            intent.setFlags(1);
                            try {
                                uri = android.support.v4.content.FileProvider.a((Context)shareViaBluetoothActivity, (String)"com.xiaomi.midrop.fileProvider", (java.io.File)file);
                            }
                            catch (java.lang.IllegalArgumentException illegalArgumentException) {
                                midrop.service.c.d.a(ShareViaBluetoothActivity.a, "Share via bluetooth failure ", illegalArgumentException, new Object[0]);
                                return;
                            }
                        } else {
                            uri = android.net.Uri.fromFile((java.io.File)file);
                        }
                        intent.setAction("android.intent.action.SEND");
                        intent.setType("application/vnd.android.package-archive");
                        intent.setPackage("com.android.bluetooth");
                        intent.putExtra("android.intent.extra.STREAM", (android.os.Parcelable)uri);
                        intent.setFlags(268435456);
                        if (intent.resolveActivity(shareViaBluetoothActivity.getPackageManager()) != null) {
                            shareViaBluetoothActivity.startActivity(intent);
                        } else {
                            java.lang.StringBuilder stringBuilder;
                            String string3;
                            void var13_11;
                            try {
                                android.content.ComponentName componentName = new android.content.ComponentName("com.android.bluetooth", "com.android.bluetooth.opp.BluetoothOppLauncherActivity");
                                intent.setPackage("");
                                intent.setComponent(componentName);
                                shareViaBluetoothActivity.startActivity(intent);
                                break block10;
                            }
                            catch (java.lang.SecurityException securityException) {
                                string3 = ShareViaBluetoothActivity.a;
                                stringBuilder = new java.lang.StringBuilder("shareViaBluetooth");
                            }
                            catch (android.content.ActivityNotFoundException activityNotFoundException) {
                                string3 = ShareViaBluetoothActivity.a;
                                stringBuilder = new java.lang.StringBuilder("ActivityNotFoundException: ");
                            }
                            stringBuilder.append((Object)var13_11);
                            midrop.service.c.d.b(string3, stringBuilder.toString(), new Object[0]);
                        }
                    }
                    com.xiaomi.midrop.util.af.a(com.xiaomi.midrop.util.af$a.bn).a();
                }
            }.execute((Object[])new Void[0]);
            return;
        }
        this.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131427378);
        this.b = b.a();
        this.c(2131427429);
        View view = this.t();
        view.setBackgroundColor(this.getResources().getColor(2131100072));
        ag.a((Activity)this, this.getResources().getColor(2131100072));
        ((TextView)view.findViewById(2131296810)).setText(this.b.a(2131689919));
        View view2 = view.findViewById(2131296485);
        view2.setOnClickListener((View.OnClickListener)this);
        if (ac.c((Context)this)) {
            view2.setRotation(180.0f);
        }
    }
}

