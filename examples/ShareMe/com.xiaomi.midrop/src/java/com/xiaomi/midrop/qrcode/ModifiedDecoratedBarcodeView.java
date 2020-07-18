/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  com.journeyapps.barcodescanner.BarcodeView
 *  com.xiaomi.midrop.qrcode.ModifiedDecoratedBarcodeView$a
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.String
 */
package com.xiaomi.midrop.qrcode;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.journeyapps.barcodescanner.BarcodeView;
import com.journeyapps.barcodescanner.CameraPreview;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.journeyapps.barcodescanner.ViewfinderView;
import com.journeyapps.barcodescanner.n;
import com.xiaomi.midrop.R;
import com.xiaomi.midrop.qrcode.ModifiedDecoratedBarcodeView;

/*
 * Exception performing whole class analysis.
 */
public class ModifiedDecoratedBarcodeView
extends RelativeLayout {
    public BarcodeView a;
    private ViewfinderView b;
    private TextView c;
    private int d;
    private DecoratedBarcodeView.a e;

    public ModifiedDecoratedBarcodeView(Context context) {
        super(context);
        this.d = 0;
        this.d = (int)context.getResources().getDimension(2131165467);
        ModifiedDecoratedBarcodeView.super.a((AttributeSet)null);
    }

    public ModifiedDecoratedBarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0;
        this.d = (int)context.getResources().getDimension(2131165467);
        ModifiedDecoratedBarcodeView.super.a(attributeSet);
    }

    public ModifiedDecoratedBarcodeView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.d = 0;
        this.d = (int)context.getResources().getDimension(2131165467);
        ModifiedDecoratedBarcodeView.super.a(attributeSet);
    }

    static /* synthetic */ ViewfinderView a(ModifiedDecoratedBarcodeView modifiedDecoratedBarcodeView) {
        return modifiedDecoratedBarcodeView.b;
    }

    private void a(AttributeSet attributeSet) {
        TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.zxing_view);
        int n2 = typedArray.getResourceId(0, 2131427593);
        typedArray.recycle();
        ModifiedDecoratedBarcodeView.inflate((Context)this.getContext(), (int)n2, (ViewGroup)this);
        this.a = (BarcodeView)this.findViewById(2131296939);
        if (this.a == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.BarcodeView on provided layout with the id \"zxing_barcode_surface\".");
        }
        this.a.setFramingRectSize(new n(this.d, this.d));
        this.b = (ViewfinderView)this.findViewById(2131296949);
        if (this.b == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.ViewfinderView on provided layout with the id \"zxing_viewfinder_view\".");
        }
        this.b.setCameraPreview((CameraPreview)this.a);
        this.c = (TextView)this.findViewById(2131296948);
    }

    public final void a(com.journeyapps.barcodescanner.a a2) {
        this.a.a((com.journeyapps.barcodescanner.a)new /* Unavailable Anonymous Inner Class!! */);
    }

    public BarcodeView getBarcodeView() {
        return (BarcodeView)this.findViewById(2131296939);
    }

    public TextView getStatusView() {
        return this.c;
    }

    public ViewfinderView getViewFinder() {
        return this.b;
    }

    public boolean onKeyDown(int n2, KeyEvent keyEvent) {
        if (n2 != 27 && n2 != 80) {
            switch (n2) {
                default: {
                    return super.onKeyDown(n2, keyEvent);
                }
                case 25: {
                    this.a.setTorch(false);
                    return true;
                }
                case 24: 
            }
            this.a.setTorch(true);
        }
        return true;
    }

    public void setStatusText(String string2) {
        if (this.c != null) {
            this.c.setText((CharSequence)string2);
        }
    }

    public void setTorchListener(DecoratedBarcodeView.a a2) {
        this.e = a2;
    }
}

