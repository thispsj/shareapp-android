/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.util.AttributeSet
 */
package com.xiaomi.midrop.qrcode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.journeyapps.barcodescanner.BarcodeView;

public class ModifiedBarCodeView
extends BarcodeView {
    private float c = 0.0f;

    public ModifiedBarCodeView(Context context) {
        super(context);
        ModifiedBarCodeView.super.a(context);
    }

    public ModifiedBarCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ModifiedBarCodeView.super.a(context);
    }

    public ModifiedBarCodeView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        ModifiedBarCodeView.super.a(context);
    }

    private void a(Context context) {
        this.c = context.getResources().getDimension(2131165466);
    }

    @Override
    protected final Rect a(Rect rect, Rect rect2) {
        Rect rect3 = super.a(rect, rect2);
        rect3.offsetTo(rect3.left, (int)this.c);
        return rect3;
    }
}

