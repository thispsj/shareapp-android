/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 */
package com.xiaomi.midrop;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.midrop.util.Locale.a;
import com.xiaomi.midrop.util.Locale.b;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.ag;

public class ShareViaQRCodeActivity
extends a
implements View.OnClickListener {
    private b a;

    public void onClick(View view) {
        if (view.getId() != 2131296485) {
            return;
        }
        try {
            this.onBackPressed();
        }
        catch (IllegalStateException illegalStateException) {}
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131427379);
        this.a = b.a();
        this.c(2131427429);
        View view = this.t();
        view.setBackgroundColor(this.getResources().getColor(2131100072));
        ag.a((Activity)this, this.getResources().getColor(2131100072));
        ((TextView)view.findViewById(2131296810)).setText(this.a.a(2131689923));
        View view2 = view.findViewById(2131296485);
        view2.setOnClickListener((View.OnClickListener)this);
        if (ac.c((Context)this)) {
            view2.setRotation(180.0f);
        }
    }
}

