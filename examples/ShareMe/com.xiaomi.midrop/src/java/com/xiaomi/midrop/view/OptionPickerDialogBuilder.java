/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.support.v7.app.c
 *  android.support.v7.app.c$a
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$i
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.TextView
 *  com.xiaomi.midrop.view.OptionPickerDialogBuilder$2
 *  com.xiaomi.midrop.view.OptionPickerDialogBuilder$Adapter
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.xiaomi.midrop.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.c;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.xiaomi.midrop.util.Locale.b;
import com.xiaomi.midrop.view.OptionPickerDialogBuilder;
import java.util.List;

/*
 * Exception performing whole class analysis.
 */
public final class OptionPickerDialogBuilder {
    public List<com.xiaomi.midrop.b.c> a;
    public a b;
    public int c;
    private Context d;
    private RecyclerView e;
    private CharSequence f;

    public OptionPickerDialogBuilder(Context context) {
        this.d = context;
    }

    public final c a() {
        c.a a2 = new c.a(this.d, 2131755513);
        a2.a(true);
        final c c2 = a2.a();
        c2.show();
        WindowManager.LayoutParams layoutParams = c2.getWindow().getAttributes();
        layoutParams.width = -1;
        layoutParams.gravity = 80;
        c2.getWindow().setAttributes(layoutParams);
        c2.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
        c2.setContentView(2131427527);
        ((TextView)c2.findViewById(2131296810)).setText(this.f);
        TextView textView = (TextView)c2.findViewById(2131296345);
        textView.setText((CharSequence)b.a().b(2131689547));
        textView.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                c2.dismiss();
            }
        });
        this.e = (RecyclerView)c2.findViewById(2131296676);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.d);
        linearLayoutManager.e(this.c);
        linearLayoutManager.b(1);
        this.e.setLayoutManager((RecyclerView.i)linearLayoutManager);
        this.e.setAdapter((RecyclerView.a)new /* Unavailable Anonymous Inner Class!! */);
        return c2;
    }

    public final OptionPickerDialogBuilder a(int n2) {
        this.f = this.d.getString(n2);
        return this;
    }

    public static interface a {
        public void a(int var1);
    }

}

