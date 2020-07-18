/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.b.a.b
 *  androidx.b.a.c
 *  androidx.b.a.c$a
 *  androidx.b.a.c$b
 *  androidx.b.a.c$b$a
 *  androidx.b.a.c$c
 *  androidx.room.a
 *  androidx.room.g
 *  androidx.room.j
 *  androidx.room.k
 *  androidx.room.k$a
 *  java.lang.IllegalArgumentException
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package com.xiaomi.midrop.db;

import android.content.Context;
import androidx.b.a.c;
import androidx.room.g;
import androidx.room.j;
import androidx.room.k;
import com.xiaomi.midrop.db.TransferHistoryDatabase;
import com.xiaomi.midrop.db.TransferHistoryDatabase_Impl;
import com.xiaomi.midrop.db.a.a;
import com.xiaomi.midrop.db.a.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class TransferHistoryDatabase_Impl
extends TransferHistoryDatabase {
    private volatile a g;

    static /* synthetic */ androidx.b.a.b a(TransferHistoryDatabase_Impl transferHistoryDatabase_Impl, androidx.b.a.b b2) {
        transferHistoryDatabase_Impl.a = b2;
        return b2;
    }

    static /* synthetic */ List a(TransferHistoryDatabase_Impl transferHistoryDatabase_Impl) {
        return transferHistoryDatabase_Impl.e;
    }

    static /* synthetic */ List b(TransferHistoryDatabase_Impl transferHistoryDatabase_Impl) {
        return transferHistoryDatabase_Impl.e;
    }

    static /* synthetic */ void b(TransferHistoryDatabase_Impl transferHistoryDatabase_Impl, androidx.b.a.b b2) {
        transferHistoryDatabase_Impl.a(b2);
    }

    static /* synthetic */ List c(TransferHistoryDatabase_Impl transferHistoryDatabase_Impl) {
        return transferHistoryDatabase_Impl.e;
    }

    static /* synthetic */ List d(TransferHistoryDatabase_Impl transferHistoryDatabase_Impl) {
        return transferHistoryDatabase_Impl.e;
    }

    static /* synthetic */ List e(TransferHistoryDatabase_Impl transferHistoryDatabase_Impl) {
        return transferHistoryDatabase_Impl.e;
    }

    static /* synthetic */ List f(TransferHistoryDatabase_Impl transferHistoryDatabase_Impl) {
        return transferHistoryDatabase_Impl.e;
    }

    static /* synthetic */ List g(TransferHistoryDatabase_Impl transferHistoryDatabase_Impl) {
        return transferHistoryDatabase_Impl.e;
    }

    static /* synthetic */ List h(TransferHistoryDatabase_Impl transferHistoryDatabase_Impl) {
        return transferHistoryDatabase_Impl.e;
    }

    static /* synthetic */ List i(TransferHistoryDatabase_Impl transferHistoryDatabase_Impl) {
        return transferHistoryDatabase_Impl.e;
    }

    protected final g a() {
        return new g((j)this, (Map)new HashMap(0), (Map)new HashMap(0), new String[]{"transItemHistory"});
    }

    protected final c b(androidx.room.a a2) {
        k k2 = new k(a2, new k.a((TransferHistoryDatabase_Impl)this){
            final /* synthetic */ TransferHistoryDatabase_Impl b;
            {
                this.b = transferHistoryDatabase_Impl;
            }

            protected final void a() {
                if (TransferHistoryDatabase_Impl.d(this.b) != null) {
                    int n2 = TransferHistoryDatabase_Impl.e(this.b).size();
                    for (int i2 = 0; i2 < n2; ++i2) {
                        TransferHistoryDatabase_Impl.f(this.b).get(i2);
                    }
                }
            }

            public final void a(androidx.b.a.b b2) {
                b2.c("DROP TABLE IF EXISTS `transItemHistory`");
                if (TransferHistoryDatabase_Impl.a(this.b) != null) {
                    int n2 = TransferHistoryDatabase_Impl.b(this.b).size();
                    for (int i2 = 0; i2 < n2; ++i2) {
                        TransferHistoryDatabase_Impl.c(this.b).get(i2);
                    }
                }
            }

            public final void b(androidx.b.a.b b2) {
                b2.c("CREATE TABLE IF NOT EXISTS `transItemHistory` (`uid` TEXT NOT NULL, `transferTime` INTEGER NOT NULL, `deviceId` TEXT, `msgType` INTEGER NOT NULL, `content` TEXT, `deviceName` TEXT, PRIMARY KEY(`uid`))");
                b2.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                b2.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '6dbe42b9c4acedcf62ab65f1ffe8697b')");
            }

            public final void c(androidx.b.a.b b2) {
                TransferHistoryDatabase_Impl.a(this.b, b2);
                TransferHistoryDatabase_Impl.b(this.b, b2);
                if (TransferHistoryDatabase_Impl.g(this.b) != null) {
                    int n2 = TransferHistoryDatabase_Impl.h(this.b).size();
                    for (int i2 = 0; i2 < n2; ++i2) {
                        TransferHistoryDatabase_Impl.i(this.b).get(i2);
                    }
                }
            }

            protected final androidx.room.k$b d(androidx.b.a.b b2) {
                HashMap hashMap = new HashMap(6);
                androidx.room.a.e$a a2 = new androidx.room.a.e$a("uid", "TEXT", true, 1, null, 1);
                hashMap.put((java.lang.Object)"uid", (java.lang.Object)a2);
                androidx.room.a.e$a a3 = new androidx.room.a.e$a("transferTime", "INTEGER", true, 0, null, 1);
                hashMap.put((java.lang.Object)"transferTime", (java.lang.Object)a3);
                androidx.room.a.e$a a4 = new androidx.room.a.e$a("deviceId", "TEXT", false, 0, null, 1);
                hashMap.put((java.lang.Object)"deviceId", (java.lang.Object)a4);
                androidx.room.a.e$a a5 = new androidx.room.a.e$a("msgType", "INTEGER", true, 0, null, 1);
                hashMap.put((java.lang.Object)"msgType", (java.lang.Object)a5);
                androidx.room.a.e$a a6 = new androidx.room.a.e$a("content", "TEXT", false, 0, null, 1);
                hashMap.put((java.lang.Object)"content", (java.lang.Object)a6);
                androidx.room.a.e$a a7 = new androidx.room.a.e$a("deviceName", "TEXT", false, 0, null, 1);
                hashMap.put((java.lang.Object)"deviceName", (java.lang.Object)a7);
                androidx.room.a.e e2 = new androidx.room.a.e("transItemHistory", (Map)hashMap, (java.util.Set)new java.util.HashSet(0), (java.util.Set)new java.util.HashSet(0));
                androidx.room.a.e e3 = androidx.room.a.e.a((androidx.b.a.b)b2, (String)"transItemHistory");
                if (!e2.equals((java.lang.Object)e3)) {
                    java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder("transItemHistory(com.xiaomi.midrop.db.table.TransItemsHistoryEntity).\n Expected:\n");
                    stringBuilder.append((java.lang.Object)e2);
                    stringBuilder.append("\n Found:\n");
                    stringBuilder.append((java.lang.Object)e3);
                    return new androidx.room.k$b(false, stringBuilder.toString());
                }
                return new androidx.room.k$b(true, null);
            }

            public final void e(androidx.b.a.b b2) {
                androidx.room.a.c.a((androidx.b.a.b)b2);
            }
        }, "6dbe42b9c4acedcf62ab65f1ffe8697b", "8e82cde43bbf59380e5db05fc749d2a9");
        c.b.a a3 = new c.b.a(a2.b);
        a3.b = a2.c;
        a3.c = k2;
        if (a3.c == null) {
            throw new IllegalArgumentException("Must set a callback to create the configuration.");
        }
        if (a3.a == null) {
            throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
        }
        c.b b2 = new c.b(a3.a, a3.b, a3.c);
        return a2.a.a(b2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final a j() {
        if (this.g != null) {
            return this.g;
        }
        TransferHistoryDatabase_Impl transferHistoryDatabase_Impl = this;
        synchronized (transferHistoryDatabase_Impl) {
            if (this.g != null) return this.g;
            this.g = new b(this);
            return this.g;
        }
    }
}

