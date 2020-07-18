/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Notification$BigTextStyle
 *  android.app.Notification$Builder
 *  android.app.Notification$Style
 *  android.app.NotificationChannel
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.xiaomi.midrop.util.Locale.b
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.xiaomi.midrop;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import com.xiaomi.midrop.util.Locale.b;

public final class d {
    public NotificationManager a;
    public Context b;

    public d(Context context) {
        this.b = context;
        this.a = (NotificationManager)context.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26 && this.a.getNotificationChannel("midrop.default") == null) {
            NotificationChannel notificationChannel = new NotificationChannel("midrop.default", (CharSequence)b.a().b(2131689523), 2);
            this.a.createNotificationChannel(notificationChannel);
        }
    }

    public final Notification.Builder a() {
        Notification.Builder builder = new Notification.Builder(this.b);
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId("midrop.default");
        }
        builder.setSmallIcon(2131231206);
        if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 28) {
            builder.setColor(this.b.getResources().getColor(2131099895));
        }
        return builder;
    }

    public final void a(int n, int n2, int n3, String string2, String string3, String string4, Intent intent, int n4) {
        PendingIntent pendingIntent = PendingIntent.getActivity((Context)this.b, (int)0, (Intent)intent, (int)1073741824);
        Notification.Builder builder = this.a();
        builder.setDefaults(4);
        builder.setTicker((CharSequence)string4);
        builder.setStyle((Notification.Style)new Notification.BigTextStyle().bigText((CharSequence)string2));
        builder.setContentTitle((CharSequence)string2);
        builder.setStyle((Notification.Style)new Notification.BigTextStyle().bigText((CharSequence)string3));
        builder.setContentText((CharSequence)string3);
        builder.setContentIntent(pendingIntent);
        builder.setWhen(System.currentTimeMillis());
        builder.setOngoing(true);
        builder.setAutoCancel(true);
        builder.setProgress(n3, n2, false);
        builder.setPriority(n4);
        Notification notification = builder.build();
        this.a.notify(n, notification);
    }

    public final void a(int n, String string2, Intent intent, int n2) {
        PendingIntent pendingIntent = PendingIntent.getActivity((Context)this.b, (int)0, (Intent)intent, (int)1073741824);
        Notification.Builder builder = this.a();
        builder.setDefaults(4);
        builder.setTicker((CharSequence)string2);
        builder.setContentTitle((CharSequence)string2);
        builder.setContentIntent(pendingIntent);
        builder.setWhen(System.currentTimeMillis());
        builder.setOngoing(false);
        builder.setAutoCancel(true);
        builder.setPriority(n2);
        Notification notification = builder.build();
        this.a.notify(n, notification);
    }
}

