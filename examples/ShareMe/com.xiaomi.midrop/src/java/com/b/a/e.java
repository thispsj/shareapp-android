/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 */
package com.b.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.b.a.f;
import com.xiaomi.midrop.util.b;
import java.util.ArrayList;
import java.util.List;
import midrop.service.c.d;

public class e
implements b.b<b> {
    private static final String b = "com.b.a.e";
    private static String c = "tb_download";
    private static e e;
    public com.xiaomi.midrop.util.b<b> a;
    private ArrayList<a> d = new ArrayList();

    private e() {
        b.a a2 = new b.a();
        a2.a = 30000;
        a2.b = this;
        this.a = new com.xiaomi.midrop.util.b(a2, 0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static e a() {
        if (e != null) return e;
        Class<e> class_ = e.class;
        synchronized (e.class) {
            if (e != null) return e;
            e = new e();
            // ** MonitorExit[var1] (shouldn't be in output)
            return e;
        }
    }

    private static f a(Cursor cursor) {
        f f2 = new f();
        f2.a = cursor.getString(cursor.getColumnIndex("_id"));
        f2.b = cursor.getString(cursor.getColumnIndex("_name"));
        f2.c = cursor.getString(cursor.getColumnIndex("_url"));
        f2.d = cursor.getString(cursor.getColumnIndex("_mimetype"));
        f2.e = cursor.getString(cursor.getColumnIndex("_savepath"));
        f2.f = cursor.getLong(cursor.getColumnIndex("_finishedsize"));
        f2.g = cursor.getLong(cursor.getColumnIndex("_totalsize"));
        f2.i = cursor.getInt(cursor.getColumnIndex("_status"));
        f2.j = cursor.getLong(cursor.getColumnIndex("_time"));
        return f2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static f a(String string2) {
        Cursor cursor;
        void var3_10;
        block11 : {
            f f2;
            Cursor cursor2;
            block9 : {
                block10 : {
                    if (TextUtils.isEmpty((CharSequence)string2)) {
                        return null;
                    }
                    cursor2 = com.b.a.a.a.a().getWritableDatabase().query(c, null, "_id=?", new String[]{string2}, null, null, null);
                    try {
                        boolean bl = cursor2.moveToNext();
                        f2 = null;
                        if (bl) {
                            f f3;
                            f2 = f3 = e.a(cursor2);
                        }
                        if (cursor2 == null) return f2;
                        break block9;
                    }
                    catch (Exception exception) {
                        break block10;
                    }
                    catch (Throwable throwable) {
                        cursor = null;
                        break block11;
                    }
                    catch (Exception exception) {
                        cursor2 = null;
                    }
                }
                try {
                    void var1_7;
                    var1_7.printStackTrace();
                    f2 = null;
                    if (cursor2 == null) return f2;
                    f2 = null;
                }
                catch (Throwable throwable) {
                    cursor = cursor2;
                }
            }
            cursor2.close();
            return f2;
        }
        if (cursor == null) throw var3_10;
        cursor.close();
        throw var3_10;
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CREATE TABLE IF NOT EXISTS ");
        stringBuffer.append(c);
        stringBuffer.append("(");
        stringBuffer.append("`_id` VARCHAR PRIMARY KEY,");
        stringBuffer.append("`_url` VARCHAR,");
        stringBuffer.append("`_mimetype` VARCHAR,");
        stringBuffer.append("`_savepath` VARCHAR,");
        stringBuffer.append("`_name` VARCHAR,");
        stringBuffer.append("`_finishedsize` LONG,");
        stringBuffer.append("`_totalsize` LONG,");
        stringBuffer.append("`_status` int,");
        stringBuffer.append("`_time` LONG");
        stringBuffer.append(")");
        sQLiteDatabase.execSQL(stringBuffer.toString());
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static List<f> b(String var0) {
        block9 : {
            block8 : {
                var1_1 = new ArrayList();
                var2_2 = null;
                var5_3 = com.b.a.a.a.a().getWritableDatabase().query(e.c, null, var0, null, null, null, null);
                if (var5_3 == null) break block8;
                try {
                    if (!var5_3.moveToFirst()) break block8;
                    do {
                        var1_1.add((Object)e.a(var5_3));
                    } while (var8_4 = var5_3.moveToNext());
                }
                catch (Throwable var4_5) {
                    var2_2 = var5_3;
                    break block9;
                }
                catch (Exception var6_8) {
                    var2_2 = var5_3;
                    var3_9 = var6_8;
                    ** GOTO lbl-1000
                }
            }
            if (var5_3 == null) return var1_1;
            var5_3.close();
            return var1_1;
            catch (Throwable var4_6) {
                break block9;
            }
            catch (Exception var3_10) {
                // empty catch block
            }
lbl-1000: // 2 sources:
            {
                var3_9.printStackTrace();
                if (var2_2 == null) return var1_1;
            }
            var2_2.close();
            return var1_1;
        }
        if (var2_2 == null) throw var4_7;
        var2_2.close();
        throw var4_7;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c(f f2) {
        void var4_2 = this;
        synchronized (var4_2) {
            int n2 = -1 + this.d.size();
            while (n2 >= 0) {
                (this.d.get(n2)).f(f2);
                --n2;
            }
            return;
        }
    }

    private static ContentValues d(f f2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", f2.a);
        contentValues.put("_url", f2.c);
        contentValues.put("_mimetype", f2.d);
        contentValues.put("_savepath", f2.e);
        contentValues.put("_finishedsize", Long.valueOf((long)f2.f));
        contentValues.put("_totalsize", Long.valueOf((long)f2.g));
        contentValues.put("_name", f2.b);
        contentValues.put("_status", Integer.valueOf((int)f2.i));
        contentValues.put("_time", Long.valueOf((long)f2.j));
        return contentValues;
    }

    @Override
    public final void a(f f2) {
        this.a.a(new Object(2, f2){
            int a;
            f b;
            {
                this.a = n2;
                this.b = f2;
            }
        });
    }

    @Override
    public final /* synthetic */ void a(Object object) {
        b b2 = object;
        switch (b2.a) {
            default: {
                return;
            }
            case 2: {
                f f2 = b2.b;
                ContentValues contentValues = e.d(f2);
                SQLiteDatabase sQLiteDatabase = com.b.a.a.a.a().getWritableDatabase();
                String string2 = c;
                String[] arrstring = new String[]{f2.a};
                sQLiteDatabase.update(string2, contentValues, "_id=?", arrstring);
                e.super.c(f2);
                return;
            }
            case 1: 
        }
        f f3 = b2.b;
        ContentValues contentValues = e.d(f3);
        com.b.a.a.a.a().getWritableDatabase().insert(c, null, contentValues);
        e.super.c(f3);
    }

    public final boolean a(a a2) {
        void var4_2 = this;
        synchronized (var4_2) {
            boolean bl = this.d.contains((Object)a2);
            return bl;
        }
    }

    public final void b(a a2) {
        void var8_2 = this;
        synchronized (var8_2) {
            if (this.a(a2)) {
                String string2 = b;
                StringBuilder stringBuilder = new StringBuilder("Observer ");
                stringBuilder.append((Object)a2);
                stringBuilder.append("has registered!");
                d.a(string2, stringBuilder.toString(), new Object[0]);
            }
            this.d.add((Object)a2);
            return;
        }
    }

    public final void b(f f2) {
        SQLiteDatabase sQLiteDatabase = com.b.a.a.a.a().getWritableDatabase();
        String string2 = c;
        String[] arrstring = new String[]{f2.a};
        sQLiteDatabase.delete(string2, "_id=?", arrstring);
        e.super.c(f2);
    }

    public final void c(a a2) {
        void var8_2 = this;
        synchronized (var8_2) {
            if (!this.a(a2)) {
                String string2 = b;
                StringBuilder stringBuilder = new StringBuilder("Observer ");
                stringBuilder.append((Object)a2);
                stringBuilder.append("has not registered!");
                d.a(string2, stringBuilder.toString(), new Object[0]);
            }
            this.d.remove((Object)a2);
            return;
        }
    }

}

