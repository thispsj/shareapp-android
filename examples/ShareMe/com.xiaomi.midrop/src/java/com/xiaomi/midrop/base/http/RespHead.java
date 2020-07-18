/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.base.http;

import com.xiaomi.globalmiuiapp.common.http.RetrofitModel;

public class RespHead
implements RetrofitModel {
    private int code;
    private String msg;
    private String server;
    private int status;
    private long time;
    private String version;

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getServer() {
        return this.server;
    }

    public long getTime() {
        return this.time;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isStatus() {
        return this.status == 0;
    }

    public void setCode(int n2) {
        this.code = n2;
    }

    public void setMsg(String string2) {
        this.msg = string2;
    }

    public void setServer(String string2) {
        this.server = string2;
    }

    public void setStatus(int n2) {
        this.status = n2;
    }

    public void setTime(long l2) {
        this.time = l2;
    }

    public void setVersion(String string2) {
        this.version = string2;
    }
}

