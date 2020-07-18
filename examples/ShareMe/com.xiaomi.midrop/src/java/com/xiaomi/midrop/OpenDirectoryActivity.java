/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.k
 *  android.support.v4.app.q
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.String
 */
package com.xiaomi.midrop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.k;
import android.support.v4.app.q;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.midrop.OpenDirectoryActivity;
import com.xiaomi.midrop.send.dir.FilePickDirectoryFragment;
import com.xiaomi.midrop.util.Locale.a;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.ag;

public class OpenDirectoryActivity
extends a {
    private String a;
    private String b;
    private FilePickDirectoryFragment c;

    public static void a(Context context, String string, String string2) {
        Intent intent = new Intent(context, OpenDirectoryActivity.class);
        intent.putExtra("dirPath", string2);
        intent.putExtra("dirName", string);
        context.startActivity(intent);
    }

    static /* synthetic */ void a(OpenDirectoryActivity openDirectoryActivity) {
        super.onBackPressed();
    }

    static /* synthetic */ void b(OpenDirectoryActivity openDirectoryActivity) {
        super.onBackPressed();
    }

    public void onBackPressed() {
        if (this.c != null && this.c.e()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a(false);
        this.setContentView(2131427371);
        this.a = this.getIntent().getStringExtra("dirPath");
        this.b = this.getIntent().getStringExtra("dirName");
        ag.a((Activity)this, this.getResources().getColor(2131099891));
        this.c(2131427431);
        View view = this.t();
        View view2 = view.findViewById(2131296485);
        if (ac.c((Context)this)) {
            view2.setRotation(180.0f);
        }
        view2.setOnClickListener(new View.OnClickListener((OpenDirectoryActivity)this){
            final /* synthetic */ OpenDirectoryActivity a;
            {
                this.a = openDirectoryActivity;
            }

            public void onClick(View view) {
                try {
                    OpenDirectoryActivity.a(this.a);
                }
                catch (java.lang.IllegalStateException illegalStateException) {}
            }
        });
        view.findViewById(2131296431).setVisibility(8);
        TextView textView = (TextView)view.findViewById(2131296810);
        textView.setTextColor(this.getResources().getColor(2131100072));
        textView.setOnClickListener(new View.OnClickListener((OpenDirectoryActivity)this){
            final /* synthetic */ OpenDirectoryActivity a;
            {
                this.a = openDirectoryActivity;
            }

            public void onClick(View view) {
                try {
                    OpenDirectoryActivity.b(this.a);
                }
                catch (java.lang.IllegalStateException illegalStateException) {}
            }
        });
        textView.setText((CharSequence)this.b);
        view.setBackgroundColor(this.getResources().getColor(2131099891));
        this.c = FilePickDirectoryFragment.b(FilePickDirectoryFragment.a.d);
        this.c.getArguments().putString("directory_root_path", this.a);
        this.c.getArguments().putString("directory_name", this.b);
        this.getSupportFragmentManager().a().a(2131296463, (Fragment)this.c).f();
    }
}

