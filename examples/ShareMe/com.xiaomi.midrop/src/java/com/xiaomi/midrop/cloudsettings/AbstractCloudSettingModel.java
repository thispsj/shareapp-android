/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.xiaomi.midrop.cloudsettings;

import com.xiaomi.globalmiuiapp.common.http.RetrofitModel;

public abstract class AbstractCloudSettingModel
implements RetrofitModel {
    private Rule rule;

    public Rule getRule() {
        return this.rule;
    }

    public static class Rule
    implements RetrofitModel {
        private long end_time;
        private long start_time;

        public long getEndTime() {
            return this.end_time;
        }

        public long getStartime() {
            return this.start_time;
        }
    }

}

