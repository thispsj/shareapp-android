/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.support.v4.content.a
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.webshare;

import a.e.b.d;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.midrop.send.FilePickNewActivity;
import com.xiaomi.midrop.util.Locale.a;
import com.xiaomi.midrop.util.Locale.b;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.ag;

public final class WebshareGuideActivity
extends a
implements View.OnClickListener {
    public final void onClick(View view) {
        if (view != null) {
            int n2 = view.getId();
            if (n2 != 2131296485 && n2 != 2131296810) {
                if (n2 != 2131296861) {
                    return;
                }
                Intent intent = new Intent((Context)this, FilePickNewActivity.class);
                intent.putExtra("from", "from_webshare");
                this.startActivity(intent);
                af.a(af.a.dP).a(af.b.at, 3).a();
                return;
            }
            this.onBackPressed();
        }
    }

    @Override
    protected final void onCreate(Bundle bundle) {
        int n2;
        super.onCreate(bundle);
        this.setContentView(2131427387);
        Context context = (Context)this;
        int n3 = android.support.v4.content.a.c((Context)context, (int)2131100072);
        this.findViewById(16908290).setBackgroundColor(n3);
        this.c(2131427429);
        View view = this.t();
        if (view != null) {
            view.setBackgroundColor(n3);
            ag.a((Activity)this, n3);
            View view2 = view.findViewById(2131296485);
            if (ac.c(context)) {
                d.a((Object)view2, "back");
                view2.setRotation(180.0f);
            }
            View.OnClickListener onClickListener = (View.OnClickListener)this;
            view2.setOnClickListener(onClickListener);
            TextView textView = (TextView)view.findViewById(2131296810);
            d.a((Object)textView, "title");
            textView.setText(b.a().a(2131690032));
            textView.setOnClickListener(onClickListener);
            View view3 = view.findViewById(2131296431);
            d.a((Object)view3, "it.findViewById<View>(R.id.divider)");
            view3.setVisibility(8);
        }
        View view4 = this.findViewById(2131296494);
        d.a((Object)view4, "findViewById<View>(R.id.image)");
        ViewGroup.LayoutParams layoutParams = view4.getLayoutParams();
        layoutParams.width = n2 = (int)(0.9 * (double)ac.a(context));
        layoutParams.height = (int)(272.7 * ((double)n2 / 324.3));
    }
}

