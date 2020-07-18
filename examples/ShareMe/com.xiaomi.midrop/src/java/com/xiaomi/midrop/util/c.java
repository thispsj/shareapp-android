/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  java.lang.Object
 */
package com.xiaomi.midrop.util;

import android.view.MotionEvent;
import android.view.View;

public final class c
implements View.OnTouchListener {
    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final boolean onTouch(View var1_1, MotionEvent var2_2) {
        var3_3 = var2_2.getAction();
        if (var3_3 == 3) ** GOTO lbl-1000
        switch (var3_3) {
            default: {
                return false;
            }
            case 0: {
                var4_4 = 0.6f;
                break;
            }
            case 1: lbl-1000: // 2 sources:
            {
                var4_4 = 1.0f;
            }
        }
        var1_1.setAlpha(var4_4);
        return false;
    }
}

