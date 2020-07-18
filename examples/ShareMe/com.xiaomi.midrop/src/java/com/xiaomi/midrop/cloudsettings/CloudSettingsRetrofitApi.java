/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.b
 *  d.b.f
 *  d.b.k
 *  d.b.u
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.xiaomi.midrop.cloudsettings;

import d.b;
import d.b.f;
import d.b.k;
import d.b.u;
import java.util.Map;

public interface CloudSettingsRetrofitApi {
    @f(a="/setting/v1/config")
    @k(a={"MiuiGlobalAppCustomHeader-cache-duration: 3600"})
    public b<String> fetch(@u Map<String, String> var1);
}

