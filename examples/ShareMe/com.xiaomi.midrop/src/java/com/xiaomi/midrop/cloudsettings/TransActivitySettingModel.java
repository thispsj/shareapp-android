/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.cloudsettings;

import com.xiaomi.globalmiuiapp.common.http.RetrofitModel;
import com.xiaomi.midrop.cloudsettings.AbstractCloudSettingModel;

public class TransActivitySettingModel
extends AbstractCloudSettingModel
implements RetrofitModel {
    public static final String CID = "trans_activity";
    private TransActivitySettingContent content;

    public TransActivitySettingContent getContent() {
        return this.content;
    }

}

