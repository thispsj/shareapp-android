/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.xiaomi.midrop.cloudsettings.UpgradePackageSettingModel
 *  com.xiaomi.midrop.cloudsettings.UpgradePackageSettingModel$UpgradePackageSettingContent
 *  java.lang.Class
 *  java.lang.Object
 */
package com.xiaomi.midrop.transmission.upgrade.util;

import com.xiaomi.midrop.cloudsettings.UpgradePackageSettingModel;

public class b {
    private static b b;
    UpgradePackageSettingModel.UpgradePackageSettingContent a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static b a() {
        Class<b> class_ = b.class;
        synchronized (b.class) {
            if (b == null) {
                b = new b();
            }
            // ** MonitorExit[var1] (shouldn't be in output)
            return b;
        }
    }

    public final boolean b() {
        if (this.a == null) {
            return false;
        }
        return this.a.isUpgradeOtherApps();
    }
}

