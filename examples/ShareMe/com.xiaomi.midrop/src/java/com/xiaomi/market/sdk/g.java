/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.DownloadManager
 *  android.app.DownloadManager$Query
 *  android.app.DownloadManager$Request
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.Intent
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteStatement
 *  android.net.Uri
 *  android.os.Environment
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.support.v4.content.FileProvider
 *  android.text.TextUtils
 *  java.io.File
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 */
package com.xiaomi.market.sdk;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import com.xiaomi.market.sdk.Patcher;
import com.xiaomi.market.sdk.c;
import com.xiaomi.market.sdk.d;
import com.xiaomi.market.sdk.e;
import com.xiaomi.market.sdk.f;
import com.xiaomi.market.sdk.h;
import com.xiaomi.market.sdk.i;
import com.xiaomi.market.sdk.j;
import com.xiaomi.market.sdk.k;
import com.xiaomi.market.sdk.l;
import com.xiaomi.market.sdk.q;
import com.xiaomi.market.sdk.s;
import java.io.File;
import java.lang.reflect.Method;

public final class g {
    public static g a;
    static DownloadManager e;
    s.b b;
    i c;
    long d = -1L;
    b f;
    Context g;
    private HandlerThread h;

    private g(Context context) {
        c.a(context);
        this.g = context.getApplicationContext();
        e = (DownloadManager)this.g.getSystemService("download");
        if (c.l()) {
            try {
                Class class_ = e.getClass();
                Class[] arrclass = new Class[]{Boolean.TYPE};
                Method method = class_.getDeclaredMethod("setAccessFilename", arrclass);
                method.setAccessible(true);
                DownloadManager downloadManager = e;
                Object[] arrobject = new Object[]{true};
                method.invoke((Object)downloadManager, arrobject);
            }
            catch (Exception exception) {
                j.a("MarketUpdateDownload", exception.getMessage(), exception);
            }
        }
        this.h = new HandlerThread("Worker Thread");
        this.h.start();
        this.f = (g)this.new b(this.h.getLooper());
    }

    public static g a(Context context) {
        Class<g> class_ = g.class;
        synchronized (g.class) {
            if (a == null) {
                a = new g(context);
            }
            g g2 = a;
            // ** MonitorExit[var3_1] (shouldn't be in output)
            return g2;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    final void a() {
        Throwable throwable;
        Cursor cursor;
        block13 : {
            block11 : {
                block12 : {
                    i i2;
                    g g2 = this;
                    // MONITORENTER : g2
                    s.b b2 = this.b;
                    if (b2 != null) {
                        // MONITOREXIT : g2
                        return;
                    }
                    if (this.c == null && (i2 = (this.c = s.b(this.g))) == null) {
                        // MONITOREXIT : g2
                        return;
                    }
                    l l2 = l.a(this.g);
                    String[] arrstring = f.a.a;
                    String[] arrstring2 = new String[]{this.c.a};
                    cursor = l2.a("update_download", arrstring, "package_name=?", arrstring2);
                    if (cursor == null) break block11;
                    try {
                        if (!cursor.moveToFirst()) break block11;
                        this.d = cursor.getLong(cursor.getColumnIndex("download_id"));
                        s.b b3 = new s.b();
                        b3.e = cursor.getInt(cursor.getColumnIndex("version_code"));
                        b3.g = cursor.getString(cursor.getColumnIndex("apk_url"));
                        b3.h = cursor.getString(cursor.getColumnIndex("apk_hash"));
                        b3.j = cursor.getString(cursor.getColumnIndex("diff_url"));
                        b3.k = cursor.getString(cursor.getColumnIndex("diff_hash"));
                        this.b = b3;
                        if (cursor == null) break block12;
                    }
                    catch (Throwable throwable2) {
                        break block13;
                    }
                    cursor.close();
                    // MONITOREXIT : g2
                    return;
                }
                // MONITOREXIT : g2
                return;
            }
            if (cursor != null) {
                cursor.close();
            }
            // MONITOREXIT : g2
            return;
            catch (Throwable throwable3) {
                cursor = null;
                throwable = throwable3;
            }
        }
        if (cursor == null) throw throwable;
        cursor.close();
        throw throwable;
    }

    public final void a(i i2, s.b b2) {
        void var6_3 = this;
        synchronized (var6_3) {
            if (b2 != null && i2 != null) {
                this.b = b2;
                this.c = i2;
                b b3 = this.f;
                b3.post(new Runnable(){

                    public final void run() {
                        if (!q.d()) {
                            h.a(-1);
                            return;
                        }
                        if (g.e == null) {
                            return;
                        }
                        File file = b.a(b.this);
                        if (file == null) {
                            return;
                        }
                        if (file.exists()) {
                            if (TextUtils.equals((CharSequence)d.a(file), (CharSequence)g.this.b.h)) {
                                b.this.a(file.getAbsolutePath(), false);
                                return;
                            }
                            file.delete();
                        }
                        b.a(b.this, b.b(b.this), file.getAbsolutePath());
                    }
                });
                return;
            }
            return;
        }
    }

    public final boolean a(i i2) {
        Cursor cursor;
        long l2;
        block16 : {
            block15 : {
                l l3 = l.a(this.g);
                String[] arrstring = f.a.a;
                String[] arrstring2 = new String[]{i2.a};
                cursor = l3.a("update_download", arrstring, "package_name=?", arrstring2);
                if (cursor != null) {
                    try {
                        if (!cursor.moveToFirst()) break block15;
                        l2 = cursor.getLong(cursor.getColumnIndex("download_id"));
                        break block16;
                    }
                    catch (Throwable throwable) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw throwable;
                    }
                }
            }
            l2 = -1L;
        }
        if (l2 == -1L) {
            if (cursor != null) {
                cursor.close();
            }
            return false;
        }
        if (cursor != null) {
            cursor.close();
        }
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(new long[]{l2});
        Cursor cursor2 = e.query(query);
        int n2 = -1;
        if (cursor2 != null) {
            try {
                if (cursor2.moveToFirst()) {
                    n2 = cursor2.getInt(cursor2.getColumnIndexOrThrow("status"));
                }
            }
            catch (Throwable throwable) {
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw throwable;
            }
        }
        if (n2 != 4 && n2 != 1 && n2 != 2) {
            if (cursor2 != null) {
                cursor2.close();
            }
            return false;
        }
        if (cursor2 != null) {
            cursor2.close();
        }
        return true;
    }

    private static final class a {
        public long a;
        public int b;
        public int c;
        public int d;
        public int e;
        public String f;

        private a() {
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static a a(long l2) {
            Cursor cursor;
            block6 : {
                a a2;
                block7 : {
                    DownloadManager.Query query = new DownloadManager.Query();
                    query.setFilterById(new long[]{l2});
                    try {
                        cursor = g.e.query(query);
                        if (cursor == null) break block6;
                    }
                    catch (Exception exception) {
                        StringBuilder stringBuilder = new StringBuilder("Query download from DownloadManager failed - ");
                        stringBuilder.append(exception.toString());
                        j.b("MarketUpdateDownload", stringBuilder.toString());
                        return null;
                    }
                    try {
                        if (!cursor.moveToFirst()) break block6;
                        int n2 = cursor.getColumnIndexOrThrow("_id");
                        int n3 = cursor.getColumnIndexOrThrow("status");
                        int n4 = cursor.getColumnIndexOrThrow("reason");
                        int n5 = cursor.getColumnIndexOrThrow("bytes_so_far");
                        int n6 = cursor.getColumnIndexOrThrow("total_size");
                        String string2 = c.k() ? "local_filename" : "file_path";
                        int n7 = cursor.getColumnIndexOrThrow(string2);
                        a2 = new a();
                        a2.a = cursor.getLong(n2);
                        a2.b = cursor.getInt(n3);
                        a2.c = cursor.getInt(n4);
                        a2.d = cursor.getInt(n5);
                        a2.e = cursor.getInt(n6);
                        a2.f = cursor.getString(n7);
                        if (cursor == null) break block7;
                    }
                    catch (Throwable throwable) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw throwable;
                    }
                    cursor.close();
                }
                return a2;
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        }
    }

    public final class b
    extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        static /* synthetic */ File a(b b2) {
            File file = b2.g.this.g.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            if (file == null) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(file.getAbsolutePath());
            stringBuilder.append("/xiaomi_update_sdk");
            File file2 = new File(stringBuilder.toString());
            if (!file2.exists()) {
                file2.mkdirs();
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(file2.getAbsolutePath());
            stringBuilder2.append("/");
            stringBuilder2.append(b2.g.this.c.a);
            stringBuilder2.append("_");
            stringBuilder2.append(b2.g.this.b.e);
            stringBuilder2.append(".apk");
            return new File(stringBuilder2.toString());
        }

        private String a(String string2, String string3) {
            if (!TextUtils.isEmpty((CharSequence)string3) && !TextUtils.equals((CharSequence)d.a(new File(string2)), (CharSequence)string3)) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(".apk");
            String string4 = stringBuilder.toString();
            if (g.this.c != null && !TextUtils.isEmpty((CharSequence)g.this.c.f)) {
                Patcher.a(g.this.c.f, string4, string2);
                try {
                    new File(string2).delete();
                }
                catch (Exception exception) {}
                return string4;
            }
            return null;
        }

        static /* synthetic */ void a(b b2, Uri uri, String string2) {
            StringBuilder stringBuilder = new StringBuilder("file://");
            stringBuilder.append(string2);
            Uri uri2 = Uri.parse((String)stringBuilder.toString());
            DownloadManager.Request request = new DownloadManager.Request(uri);
            request.setMimeType("application/apk-ota");
            request.setTitle((CharSequence)b2.g.this.c.b);
            if (uri2 != null) {
                request.setDestinationUri(uri2);
            }
            try {
                b2.g.this.d = g.e.enqueue(request);
            }
            catch (Throwable throwable) {
                j.b("MarketUpdateDownload", throwable.toString());
                h.a(-2);
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("package_name", b2.g.this.c.a);
            contentValues.put("download_id", Long.valueOf((long)b2.g.this.d));
            contentValues.put("version_code", Integer.valueOf((int)b2.g.this.b.e));
            contentValues.put("apk_url", b2.g.this.b.g);
            contentValues.put("apk_hash", b2.g.this.b.h);
            contentValues.put("diff_url", b2.g.this.b.j);
            contentValues.put("diff_hash", b2.g.this.b.k);
            contentValues.put("apk_path", string2);
            SQLiteStatement sQLiteStatement = l.a(com.xiaomi.market.sdk.b.a()).getWritableDatabase().compileStatement("INSERT OR REPLACE INTO update_download(package_name,download_id,version_code,apk_url,apk_hash,diff_url,diff_hash,apk_path) VALUES(?,?,?,?,?,?,?,?)");
            sQLiteStatement.bindString(1, contentValues.getAsString("package_name"));
            sQLiteStatement.bindLong(2, contentValues.getAsLong("download_id").longValue());
            sQLiteStatement.bindLong(3, (long)contentValues.getAsInteger("version_code").intValue());
            sQLiteStatement.bindString(4, contentValues.getAsString("apk_url"));
            sQLiteStatement.bindString(5, contentValues.getAsString("apk_hash"));
            sQLiteStatement.bindString(6, contentValues.getAsString("diff_url"));
            sQLiteStatement.bindString(7, contentValues.getAsString("diff_hash"));
            sQLiteStatement.bindString(8, contentValues.getAsString("apk_path"));
            sQLiteStatement.execute();
        }

        static /* synthetic */ boolean a(b b2, String string2) {
            if (TextUtils.isEmpty((CharSequence)string2)) {
                return false;
            }
            return TextUtils.equals((CharSequence)d.a(new File(string2)), (CharSequence)b2.g.this.b.h);
        }

        /*
         * Enabled aggressive block sorting
         */
        static /* synthetic */ Uri b(b b2) {
            String string2;
            String string3;
            if (TextUtils.isEmpty((CharSequence)b2.g.this.b.j)) {
                string2 = b2.g.this.b.a;
                string3 = b2.g.this.b.g;
            } else {
                string2 = b2.g.this.b.a;
                string3 = b2.g.this.b.j;
            }
            String string4 = e.a(string2, string3);
            return Uri.parse((String)string4);
        }

        static /* synthetic */ void b(b b2, String string2) {
            Uri uri;
            g g2 = b2.g.this;
            if (c.l()) {
                File file = new File(string2);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(g2.g.getPackageName());
                stringBuilder.append(".selfupdate.fileprovider");
                String string3 = stringBuilder.toString();
                uri = FileProvider.a((Context)g2.g, (String)string3, (File)file);
            } else {
                StringBuilder stringBuilder = new StringBuilder("file://");
                stringBuilder.append(string2);
                uri = Uri.parse((String)stringBuilder.toString());
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uri, "application/vnd.android.package-archive");
            String string4 = k.a(intent);
            if (TextUtils.isEmpty((CharSequence)string4)) {
                j.b("MarketUpdateDownload", "no activity found to install apk");
                return;
            }
            if (TextUtils.equals((CharSequence)uri.getScheme(), (CharSequence)"content")) {
                b2.g.this.g.grantUriPermission(string4, uri, 1);
            }
            intent.setPackage(string4);
            intent.setFlags(268435456);
            b2.g.this.g.startActivity(intent);
        }

        public final void a(final String string2, final boolean bl) {
            this.post(new Runnable(){

                public final void run() {
                    if (TextUtils.isEmpty((CharSequence)string2)) {
                        return;
                    }
                    b b2 = b.this;
                    if (b2.g.this.c == null || b2.g.this.b == null) {
                        b2.g.this.c = s.b(b2.g.this.g);
                        if (b2.g.this.c != null) {
                            b2.g.this.a();
                        }
                    }
                    String string22 = string2;
                    if (bl) {
                        string22 = b.this.a(string22, g.this.b.k);
                    }
                    if (!b.a(b.this, string22)) {
                        j.b("MarketUpdateDownload", "verify downloaded apk failed");
                        return;
                    }
                    b.b(b.this, string22);
                }
            });
        }

    }

}

