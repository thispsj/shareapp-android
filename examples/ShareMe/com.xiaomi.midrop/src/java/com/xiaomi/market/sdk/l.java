/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteOpenHelper
 *  java.lang.String
 */
package com.xiaomi.market.sdk;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.xiaomi.market.sdk.j;

public final class l
extends SQLiteOpenHelper {
    private static l a;

    private l(Context context) {
        super(context, "xiaomi_market_sdk_update.db", null, 1);
    }

    public static l a(Context context) {
        if (a == null) {
            a = new l(context);
        }
        return a;
    }

    public final Cursor a(String string2, String[] arrstring, String string3, String[] arrstring2) {
        return this.getReadableDatabase().query(string2, arrstring, string3, arrstring2, null, null, null);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        j.a("MarketSDKDatabaseHelper", "create database");
        sQLiteDatabase.execSQL("CREATE TABLE update_download (_id INTEGER PRIMARY KEY AUTOINCREMENT,package_name TEXT,download_id INTEGER, version_code INTEGER, apk_url TEXT, apk_hash TEXT, diff_url TEXT, diff_hash TEXT, apk_path TEXT, UNIQUE(package_name));");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int n2, int n3) {
    }
}

