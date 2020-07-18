/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.room.i
 *  androidx.room.j
 *  androidx.room.j$a
 *  java.lang.Class
 *  java.lang.String
 */
package com.xiaomi.midrop.db;

import android.content.Context;
import androidx.room.i;
import androidx.room.j;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.db.a.a;

public abstract class TransferHistoryDatabase
extends j {
    private static TransferHistoryDatabase g;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static TransferHistoryDatabase i() {
        Class<TransferHistoryDatabase> class_ = TransferHistoryDatabase.class;
        synchronized (TransferHistoryDatabase.class) {
            if (g != null) return g;
            g = (TransferHistoryDatabase)i.a((Context)MiDropApplication.a(), TransferHistoryDatabase.class, (String)"transfer.db").a().b();
            return g;
        }
    }

    public abstract a j();
}

