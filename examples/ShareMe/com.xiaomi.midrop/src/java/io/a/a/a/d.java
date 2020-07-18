/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.SharedPreferences
 *  android.database.DatabaseErrorHandler
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  java.io.File
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package io.a.a.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;

final class d
extends ContextWrapper {
    private final String a;
    private final String b;

    public d(Context context, String string2, String string3) {
        super(context);
        this.b = string2;
        this.a = string3;
    }

    public final File getCacheDir() {
        return new File(super.getCacheDir(), this.a);
    }

    public final File getDatabasePath(String string2) {
        File file = new File(super.getDatabasePath(string2).getParentFile(), this.a);
        file.mkdirs();
        return new File(file, string2);
    }

    @TargetApi(value=8)
    public final File getExternalCacheDir() {
        return new File(super.getExternalCacheDir(), this.a);
    }

    @TargetApi(value=8)
    public final File getExternalFilesDir(String string2) {
        return new File(super.getExternalFilesDir(string2), this.a);
    }

    public final File getFilesDir() {
        return new File(super.getFilesDir(), this.a);
    }

    public final SharedPreferences getSharedPreferences(String string2, int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b);
        stringBuilder.append(":");
        stringBuilder.append(string2);
        return super.getSharedPreferences(stringBuilder.toString(), n2);
    }

    public final SQLiteDatabase openOrCreateDatabase(String string2, int n2, SQLiteDatabase.CursorFactory cursorFactory) {
        return SQLiteDatabase.openOrCreateDatabase((File)this.getDatabasePath(string2), (SQLiteDatabase.CursorFactory)cursorFactory);
    }

    @TargetApi(value=11)
    public final SQLiteDatabase openOrCreateDatabase(String string2, int n2, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return SQLiteDatabase.openOrCreateDatabase((String)this.getDatabasePath(string2).getPath(), (SQLiteDatabase.CursorFactory)cursorFactory, (DatabaseErrorHandler)databaseErrorHandler);
    }
}

