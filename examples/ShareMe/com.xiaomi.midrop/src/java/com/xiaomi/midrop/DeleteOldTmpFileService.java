/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.support.v4.app.u
 *  android.support.v4.app.u$h
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.List
 *  java.util.Locale
 */
package com.xiaomi.midrop;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.u;
import com.b.a.e;
import com.b.a.f;
import com.xiaomi.midrop.util.j;
import java.util.List;
import java.util.Locale;
import midrop.service.c.d;

public class DeleteOldTmpFileService
extends u {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    static void a(Context context, Intent intent) {
        ComponentName componentName;
        try {
            Object object;
            componentName = new ComponentName(context, DeleteOldTmpFileService.class);
            Object object2 = object = u.h;
            // MONITORENTER : object2
        }
        catch (Exception exception) {
            d.a("DeleteOldTmpFileService", "start task failed", exception, new Object[0]);
            return;
        }
        u.h h2 = u.a((Context)context, (ComponentName)componentName, (boolean)true, (int)1);
        h2.a(1);
        h2.a(intent);
        // MONITOREXIT : object2
    }

    protected final void a(Intent intent) {
        long l2 = intent.getLongExtra("param_out_date", 259200000L);
        StringBuilder stringBuilder = new StringBuilder("(_time <= ");
        stringBuilder.append(System.currentTimeMillis() - l2);
        stringBuilder.append(") AND (_status <> 16)");
        String string2 = stringBuilder.toString();
        e.a();
        List<f> list = e.b(string2);
        if (!list.isEmpty()) {
            for (f f2 : list) {
                j.e(f2.e);
                e.a().b(f2);
                Locale locale = Locale.getDefault();
                Object[] arrobject = new Object[]{f2.b, f2.e, f2.i, f2.j};
                String.format((Locale)locale, (String)"Delete file --> [name=%s], \n[path=%s], \n[state=%d], [time=%d]", (Object[])arrobject);
            }
        }
    }
}

