/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.TextView
 *  com.google.zxing.client.android.R
 *  com.google.zxing.client.android.R$id
 *  com.google.zxing.client.android.R$layout
 *  com.google.zxing.client.android.R$styleable
 *  com.journeyapps.barcodescanner.BarcodeView
 *  com.journeyapps.barcodescanner.DecoratedBarcodeView$b
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.zxing.client.android.R;
import com.journeyapps.barcodescanner.BarcodeView;
import com.journeyapps.barcodescanner.CameraPreview;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.journeyapps.barcodescanner.ViewfinderView;

/*
 * Exception performing whole class analysis.
 */
public class DecoratedBarcodeView
extends FrameLayout {
    public BarcodeView a;
    private ViewfinderView b;
    private TextView c;
    private a d;

    public DecoratedBarcodeView(Context context) {
        super(context);
        DecoratedBarcodeView.super.a((AttributeSet)null);
    }

    public DecoratedBarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        DecoratedBarcodeView.super.a(attributeSet);
    }

    public DecoratedBarcodeView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        DecoratedBarcodeView.super.a(attributeSet);
    }

    static /* synthetic */ ViewfinderView a(DecoratedBarcodeView decoratedBarcodeView) {
        return decoratedBarcodeView.b;
    }

    private void a(AttributeSet attributeSet) {
        TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.zxing_view);
        int n2 = typedArray.getResourceId(R.styleable.zxing_view_zxing_scanner_layout, R.layout.zxing_barcode_scanner);
        typedArray.recycle();
        DecoratedBarcodeView.inflate((Context)this.getContext(), (int)n2, (ViewGroup)this);
        this.a = (BarcodeView)this.findViewById(R.id.zxing_barcode_surface);
        if (this.a == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.BarcodeView on provided layout with the id \"zxing_barcode_surface\".");
        }
        this.a.a(attributeSet);
        this.b = (ViewfinderView)this.findViewById(R.id.zxing_viewfinder_view);
        if (this.b == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.ViewfinderView on provided layout with the id \"zxing_viewfinder_view\".");
        }
        this.b.setCameraPreview((CameraPreview)this.a);
        this.c = (TextView)this.findViewById(R.id.zxing_status_view);
    }

    public final void a(com.journeyapps.barcodescanner.a a2) {
        this.a.a((com.journeyapps.barcodescanner.a)new /* Unavailable Anonymous Inner Class!! */);
    }

    public BarcodeView getBarcodeView() {
        return (BarcodeView)this.findViewById(R.id.zxing_barcode_surface);
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

    public void setTorchListener(a a2) {
        this.d = a2;
    }

    public static interface a {
    }

}

