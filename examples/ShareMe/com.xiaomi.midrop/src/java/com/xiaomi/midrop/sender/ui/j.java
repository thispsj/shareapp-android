/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 *  android.widget.TextView
 *  com.xiaomi.midrop.sender.ui.StoragePopupWindow
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.sender.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.xiaomi.midrop.sender.ui.StoragePopupWindow;

public final class j {
    public PopupWindow a;
    String b;
    public String c;
    public a d;
    private TextView e;
    private TextView f;

    public j(Context context, String string2, String string3, PopupWindow.OnDismissListener onDismissListener) {
        this.a = new PopupWindow(LayoutInflater.from((Context)context).inflate(2131427571, null), -1, -2, true);
        this.a.setBackgroundDrawable((Drawable)new BitmapDrawable());
        this.a.setOutsideTouchable(true);
        this.a.setOnDismissListener(onDismissListener);
        this.b = string2;
        this.c = string3;
        this.e = (TextView)this.a.getContentView().findViewById(2131296533);
        this.f = (TextView)this.a.getContentView().findViewById(2131296449);
        this.e.setText(2131689735);
        this.f.setText(2131689953);
        this.e.setOnClickListener(new View.OnClickListener((j)this){
            final /* synthetic */ j a;
            {
                this.a = j2;
            }

            public void onClick(View view) {
                if (this.a.d != null) {
                    this.a.a.dismiss();
                    this.a.d.a(this.a.b);
                }
            }
        });
        this.f.setOnClickListener(new View.OnClickListener((j)this){
            final /* synthetic */ j a;
            {
                this.a = j2;
            }

            public void onClick(View view) {
                if (this.a.d != null) {
                    this.a.a.dismiss();
                    this.a.d.a(this.a.c);
                }
            }
        });
    }

    public static interface a {
        public void a(String var1);
    }

}

