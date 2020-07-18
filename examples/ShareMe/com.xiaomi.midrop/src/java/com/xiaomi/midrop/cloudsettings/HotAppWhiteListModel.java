/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.xiaomi.midrop.cloudsettings;

import com.xiaomi.globalmiuiapp.common.http.RetrofitModel;
import com.xiaomi.midrop.cloudsettings.AbstractCloudSettingModel;
import java.util.List;

public final class HotAppWhiteListModel
extends AbstractCloudSettingModel
implements RetrofitModel {
    public static final String CID = "hot_apps";
    private HotAppWhiteList content;

    public final HotAppWhiteList getContent() {
        return this.content;
    }

}

