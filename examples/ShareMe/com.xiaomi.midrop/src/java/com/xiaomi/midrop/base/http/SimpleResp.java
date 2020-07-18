/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.xiaomi.midrop.base.http;

import com.xiaomi.globalmiuiapp.common.http.RetrofitModel;

public class SimpleResp<T>
implements RetrofitModel {
    public static final int CODE_INTERNAL_ERROR = 10;
    public static final int CODE_SUCCESS;
    private int code;
    private T data;
    private long time;

    public int getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public long getTime() {
        return this.time;
    }

    public void setCode(int n2) {
        this.code = n2;
    }

    public void setData(T t2) {
        this.data = t2;
    }

    public void setTime(long l2) {
        this.time = l2;
    }
}

