/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  androidx.b.a.e
 *  androidx.room.a.b
 *  androidx.room.a.c
 *  androidx.room.b
 *  androidx.room.c
 *  androidx.room.j
 *  androidx.room.l
 *  com.xiaomi.midrop.db.a.b$1
 *  com.xiaomi.midrop.db.a.b$2
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.xiaomi.midrop.db.a;

import android.database.Cursor;
import androidx.b.a.e;
import androidx.room.a.c;
import androidx.room.j;
import androidx.room.l;
import com.xiaomi.midrop.db.a.a;
import com.xiaomi.midrop.db.a.b;
import java.util.ArrayList;
import java.util.List;

public final class b
implements a {
    private final j a;
    private final androidx.room.c<com.xiaomi.midrop.db.b.a> b;
    private final androidx.room.b<com.xiaomi.midrop.db.b.a> c;

    public b(j j2) {
        this.a = j2;
        this.b = new 1((b)this, j2);
        this.c = new 2((b)this, j2);
    }

    @Override
    public final List<com.xiaomi.midrop.db.b.a> a() {
        l l2 = l.a((String)"SELECT * From transItemHistory ORDER BY transferTime DESC LIMIT 50");
        this.a.d();
        Cursor cursor = c.a((j)this.a, (e)l2);
        try {
            int n2 = androidx.room.a.b.a((Cursor)cursor, (String)"uid");
            int n3 = androidx.room.a.b.a((Cursor)cursor, (String)"transferTime");
            int n4 = androidx.room.a.b.a((Cursor)cursor, (String)"deviceId");
            int n5 = androidx.room.a.b.a((Cursor)cursor, (String)"msgType");
            int n6 = androidx.room.a.b.a((Cursor)cursor, (String)"content");
            int n7 = androidx.room.a.b.a((Cursor)cursor, (String)"deviceName");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                com.xiaomi.midrop.db.b.a a2 = new com.xiaomi.midrop.db.b.a(cursor.getString(n2), cursor.getString(n4), cursor.getInt(n5), cursor.getString(n7));
                a2.b = cursor.getLong(n3);
                a2.e = cursor.getString(n6);
                arrayList.add((Object)a2);
            }
            return arrayList;
        }
        finally {
            cursor.close();
            l2.a();
        }
    }

    @Override
    public final void a(com.xiaomi.midrop.db.b.a a2) {
        this.a.d();
        this.a.e();
        try {
            this.b.a((Object)a2);
            this.a.g();
            return;
        }
        finally {
            this.a.f();
        }
    }

    @Override
    public final void b(com.xiaomi.midrop.db.b.a a2) {
        this.a.d();
        this.a.e();
        try {
            this.c.a((Object)a2);
            this.a.g();
            return;
        }
        finally {
            this.a.f();
        }
    }
}

