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

public final class HomeRightCornerSettingModel
extends AbstractCloudSettingModel
implements RetrofitModel {
    public static final String CID = "home_activity_entry";
    private HomeRightCornerSettingContent content;

    public final HomeRightCornerSettingContent getContent() {
        return this.content;
    }

}

