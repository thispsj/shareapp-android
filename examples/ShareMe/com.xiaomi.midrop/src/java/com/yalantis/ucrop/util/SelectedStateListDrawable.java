/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.StateListDrawable
 */
package com.yalantis.ucrop.util;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

public class SelectedStateListDrawable
extends StateListDrawable {
    private int mSelectionColor;

    public SelectedStateListDrawable(Drawable drawable2, int n2) {
        this.mSelectionColor = n2;
        this.addState(new int[]{16842913}, drawable2);
        this.addState(new int[0], drawable2);
    }

    public boolean isStateful() {
        return true;
    }

    protected boolean onStateChange(int[] arrn) {
        int n2 = arrn.length;
        boolean bl = false;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (arrn[i2] != 16842913) continue;
            bl = true;
        }
        if (bl) {
            super.setColorFilter(this.mSelectionColor, PorterDuff.Mode.SRC_ATOP);
        } else {
            super.clearColorFilter();
        }
        return super.onStateChange(arrn);
    }
}

