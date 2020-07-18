/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.base.http;

import com.xiaomi.globalmiuiapp.common.http.RetrofitModel;
import com.xiaomi.midrop.base.http.RespHead;

public class Resp<T>
implements RetrofitModel {
    private T data;
    private RespHead head;

    public T getData() {
        return this.data;
    }

    public RespHead getHead() {
        return this.head;
    }

    public String getHeadMsg() {
        if (this.head != null) {
            return this.head.getMsg();
        }
        return "";
    }

    public boolean isSuccess() {
        return this.head != null && this.head.getCode() == 200 && this.data != null && this.head.isStatus();
    }

    public void setData(T t2) {
        this.data = t2;
    }

    public void setHead(RespHead respHead) {
        this.head = respHead;
    }
}

