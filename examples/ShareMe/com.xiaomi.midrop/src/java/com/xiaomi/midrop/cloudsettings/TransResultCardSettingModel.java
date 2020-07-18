/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.cloudsettings;

import android.text.TextUtils;
import com.xiaomi.globalmiuiapp.common.http.RetrofitModel;
import com.xiaomi.midrop.cloudsettings.AbstractCloudSettingModel;

public class TransResultCardSettingModel
extends AbstractCloudSettingModel
implements RetrofitModel {
    public static final String CID = "trans_result_card";
    public static final int FILTER_TYPE_BOTH = 0;
    public static final int FILTER_TYPE_RECEIVER = 2;
    public static final int FILTER_TYPE_SENDER = 1;
    private TransResultCardSettingContent content;

    public TransResultCardSettingContent getContent() {
        return this.content;
    }

}

