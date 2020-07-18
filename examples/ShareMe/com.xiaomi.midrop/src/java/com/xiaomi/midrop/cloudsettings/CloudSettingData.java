/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.xiaomi.midrop.cloudsettings.HomeDialogSettingModel
 *  com.xiaomi.midrop.cloudsettings.HomeRightCornerSettingModel
 *  com.xiaomi.midrop.cloudsettings.HotAppWhiteListModel
 *  com.xiaomi.midrop.cloudsettings.TransActivitySettingModel
 *  com.xiaomi.midrop.cloudsettings.TransResultCardSettingModel
 *  com.xiaomi.midrop.cloudsettings.UpgradePackageSettingModel
 *  java.lang.Class
 *  java.lang.Object
 *  java.util.List
 */
package com.xiaomi.midrop.cloudsettings;

import com.xiaomi.globalmiuiapp.common.http.RetrofitModel;
import com.xiaomi.midrop.cloudsettings.AbstractCloudSettingModel;
import com.xiaomi.midrop.cloudsettings.HomeDialogSettingModel;
import com.xiaomi.midrop.cloudsettings.HomeRightCornerSettingModel;
import com.xiaomi.midrop.cloudsettings.HotAppWhiteListModel;
import com.xiaomi.midrop.cloudsettings.TransActivitySettingModel;
import com.xiaomi.midrop.cloudsettings.TransResultCardSettingModel;
import com.xiaomi.midrop.cloudsettings.UpgradePackageSettingModel;
import java.util.List;

public class CloudSettingData
implements RetrofitModel {
    private int count;
    private List<AbstractCloudSettingModel> list;

    private <T extends AbstractCloudSettingModel> T getSettingModel(Class<T> class_) {
        if (this.list == null) {
            return null;
        }
        for (AbstractCloudSettingModel abstractCloudSettingModel : this.list) {
            if (!class_.isInstance((Object)abstractCloudSettingModel)) continue;
            return (T)abstractCloudSettingModel;
        }
        return null;
    }

    public int getCount() {
        return this.count;
    }

    public HomeDialogSettingModel.HomeDialogSettingContent getHomeDialogSetting() {
        HomeDialogSettingModel homeDialogSettingModel = this.getSettingModel(HomeDialogSettingModel.class);
        if (homeDialogSettingModel != null) {
            return homeDialogSettingModel.getContent();
        }
        return null;
    }

    public HomeRightCornerSettingModel.HomeRightCornerSettingContent getHomeRightCornerSetting() {
        HomeRightCornerSettingModel homeRightCornerSettingModel = this.getSettingModel(HomeRightCornerSettingModel.class);
        if (homeRightCornerSettingModel != null) {
            return homeRightCornerSettingModel.getContent();
        }
        return null;
    }

    public HotAppWhiteListModel.HotAppWhiteList getHotWhiteListSetting() {
        HotAppWhiteListModel hotAppWhiteListModel = this.getSettingModel(HotAppWhiteListModel.class);
        if (hotAppWhiteListModel != null) {
            return hotAppWhiteListModel.getContent();
        }
        return null;
    }

    public TransActivitySettingModel.TransActivitySettingContent getTransActivitySetting() {
        TransActivitySettingModel transActivitySettingModel = this.getSettingModel(TransActivitySettingModel.class);
        if (transActivitySettingModel != null) {
            return transActivitySettingModel.getContent();
        }
        return null;
    }

    public TransResultCardSettingModel.TransResultCardSettingContent getTransResultCardSetting() {
        TransResultCardSettingModel transResultCardSettingModel = this.getSettingModel(TransResultCardSettingModel.class);
        if (transResultCardSettingModel != null) {
            return transResultCardSettingModel.getContent();
        }
        return null;
    }

    public UpgradePackageSettingModel.UpgradePackageSettingContent getUpgradeSetting() {
        if (this.list == null) {
            return null;
        }
        for (AbstractCloudSettingModel abstractCloudSettingModel : this.list) {
            if (!(abstractCloudSettingModel instanceof UpgradePackageSettingModel)) continue;
            return ((UpgradePackageSettingModel)abstractCloudSettingModel).getContent();
        }
        return null;
    }

    public void setCount(int n2) {
        this.count = n2;
    }
}

