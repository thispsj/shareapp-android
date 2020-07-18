/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnKeyListener
 *  android.content.DialogInterface$OnMultiChoiceClickListener
 *  android.database.Cursor
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.ListAdapter
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.miftp.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;

public abstract class a {
    public abstract void a(int var1);

    public abstract void a(int var1, CharSequence var2, DialogInterface.OnClickListener var3);

    public abstract void a(Drawable var1);

    public abstract void a(View var1);

    public abstract void a(CharSequence var1);

    public abstract void b(View var1);

    public abstract void b(CharSequence var1);

    public static abstract class a {
        public String A;
        public String B;
        public AdapterView.OnItemSelectedListener C;
        public Context a;
        public LayoutInflater b;
        public int c;
        public Drawable d;
        public CharSequence e;
        public View f;
        public CharSequence g;
        public CharSequence h;
        public DialogInterface.OnClickListener i;
        public CharSequence j;
        public DialogInterface.OnClickListener k;
        public CharSequence l;
        public DialogInterface.OnClickListener m;
        public boolean n;
        public DialogInterface.OnCancelListener o;
        public DialogInterface.OnKeyListener p;
        public CharSequence[] q;
        public ListAdapter r;
        public DialogInterface.OnClickListener s;
        public View t;
        public boolean u;
        public boolean v;
        public boolean[] w;
        public int x = -1;
        public DialogInterface.OnMultiChoiceClickListener y;
        public Cursor z;

        public a(Context context) {
            this.a = context;
            this.n = true;
            this.b = (LayoutInflater)context.getSystemService("layout_inflater");
        }
    }

}

