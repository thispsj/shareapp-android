/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.support.v7.app.d
 *  java.lang.Class
 */
package com.xiaomi.midrop.sender.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.d;
import com.xiaomi.midrop.HomeActivity;

public class NotificationActivity
extends d {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.isTaskRoot()) {
            Intent intent = new Intent(this.getApplicationContext(), HomeActivity.class);
            intent.addFlags(268435456);
            this.startActivity(intent);
        }
        this.finish();
    }
}

