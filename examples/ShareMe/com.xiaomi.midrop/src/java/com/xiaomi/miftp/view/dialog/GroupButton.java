/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.support.v7.widget.AppCompatButton
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  java.lang.String
 */
package com.xiaomi.miftp.view.dialog;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class GroupButton
extends AppCompatButton {
    private static final int[] b = new int[]{16842916};
    private static final int[] c = new int[]{16842917};
    private static final int[] d = new int[]{16842918};
    private static final int[] e = new int[]{16842915};

    public GroupButton(Context context) {
        super(context);
    }

    public GroupButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GroupButton(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    protected int[] onCreateDrawableState(int n2) {
        int[] arrn;
        Log.d((String)"wuhua", (String)"onCreateDrawableState");
        ViewGroup viewGroup = (ViewGroup)this.getParent();
        if (viewGroup == null) {
            return super.onCreateDrawableState(n2);
        }
        int n3 = viewGroup.getChildCount();
        boolean bl = viewGroup.getChildCount() == 1;
        boolean bl2 = viewGroup.getChildAt(0) == this;
        View view = viewGroup.getChildAt(n3 - 1);
        boolean bl3 = false;
        if (view == this) {
            bl3 = true;
        }
        int[] arrn2 = super.onCreateDrawableState(n2 + 4);
        if (bl) {
            Log.d((String)"wuhua", (String)"single");
            arrn = e;
        } else if (bl2) {
            Log.d((String)"wuhua", (String)"first");
            arrn = b;
        } else if (bl3) {
            Log.d((String)"wuhua", (String)"last");
            arrn = d;
        } else {
            Log.d((String)"wuhua", (String)"middle");
            arrn = c;
        }
        GroupButton.mergeDrawableStates((int[])arrn2, (int[])arrn);
        return arrn2;
    }
}

