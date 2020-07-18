/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.xiaomi.midrop.base.http.SimpleResp
 *  d.b
 *  d.b.a
 *  d.b.f
 *  d.b.o
 *  d.b.t
 *  d.b.x
 *  java.lang.Object
 *  java.lang.String
 *  okhttp3.ab
 */
package com.xiaomi.midrop.activity;

import com.xiaomi.midrop.base.http.SimpleResp;
import d.b;
import d.b.a;
import d.b.f;
import d.b.o;
import d.b.t;
import d.b.x;
import okhttp3.ab;

public interface ActivityRetrofitApi {
    @f
    public b<SimpleResp<String>> registerDevice(@x String var1, @t(a="activity") String var2, @t(a="uid") String var3);

    @o
    public b<SimpleResp<String>> syncTransRecords(@x String var1, @a ab var2);
}

