/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteOpenHelper
 *  com.b.a.e
 *  com.xiaomi.midrop.MiDropApplication
 *  com.xiaomi.midrop.util.b
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 *  java.util.Queue
 */
package com.b.a.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.b.a.e;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.util.b;
import java.util.Locale;
import java.util.Queue;

public class a
extends SQLiteOpenHelper {
    private static a b;
    private final String a = a.class.getSimpleName();

    private a(Context context) {
        super(context, "midrop.db", null, 1);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a a() {
        if (b != null) return b;
        Class<a> class_ = a.class;
        synchronized (a.class) {
            if (b != null) return b;
            b = new a(MiDropApplication.a());
            // ** MonitorExit[var1] (shouldn't be in output)
            return b;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        a a2 = this;
        synchronized (a2) {
            e e2 = e.a();
            if (e2.a != null) {
                Queue queue;
                b b2 = e2.a;
                Queue queue2 = queue = b2.b;
                synchronized (queue2) {
                    b2.b.clear();
                }
            }
            super.close();
            b = null;
            return;
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        e.a((SQLiteDatabase)sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n2, int n3) {
        Locale locale = Locale.getDefault();
        Object[] arrobject = new Object[]{n2, n3};
        String.format((Locale)locale, (String)"onUpgrade -> [oldVersion=%d], [newVersion=%d]", (Object[])arrobject);
    }
}

