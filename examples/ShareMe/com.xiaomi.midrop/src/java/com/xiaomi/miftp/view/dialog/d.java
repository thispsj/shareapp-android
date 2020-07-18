/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.DialogInterface$OnKeyListener
 *  android.content.DialogInterface$OnMultiChoiceClickListener
 *  android.content.DialogInterface$OnShowListener
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.database.Cursor
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.TypedValue
 *  android.view.ContextThemeWrapper
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.ArrayAdapter
 *  android.widget.Button
 *  android.widget.CheckBox
 *  android.widget.CursorAdapter
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.ProgressBar
 *  android.widget.ScrollView
 *  android.widget.SimpleCursorAdapter
 *  android.widget.TextView
 *  com.xiaomi.miftp.view.dialog.c
 *  com.xiaomi.miftp.view.dialog.c$a
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.xiaomi.miftp.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.xiaomi.miftp.R;
import com.xiaomi.miftp.view.dialog.b;
import com.xiaomi.miftp.view.dialog.c;
import java.util.ArrayList;

public final class d
extends Dialog
implements DialogInterface {
    public c a;

    protected d(Context context, int n2) {
        super(context, d.a(context, n2));
        this.a = new c(context, (DialogInterface)this, this.getWindow());
    }

    static int a(Context context, int n2) {
        switch (n2) {
            default: {
                if (n2 < 16777216) break;
                return n2;
            }
            case 7: {
                return R.style.Theme_Light_Dialog_Edit_Default;
            }
            case 6: {
                return R.style.MIUITheme_Dark_Dialog_Edit_Default;
            }
            case 5: {
                return R.style.Theme_Light_Dialog_Edit;
            }
            case 4: {
                return R.style.MIUITheme_Dark_Dialog_Edit;
            }
            case 3: {
                return R.style.Theme_Light_Dialog_Alert;
            }
            case 2: {
                return R.style.MIUITheme_Dark_Dialog_Alert;
            }
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        return typedValue.resourceId;
    }

    static /* synthetic */ c a(d d2) {
        return d2.a;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected final void onCreate(Bundle var1) {
        block47 : {
            block48 : {
                block49 : {
                    super.onCreate(var1);
                    var2_2 = this.a.a;
                    var2_2.f.requestFeature(1);
                    if (var2_2.p == null || !b.a(var2_2.p)) {
                        var2_2.f.setFlags(131072, 131072);
                    }
                    if (var2_2.s == null) {
                        var2_2.f.setContentView(var2_2.e);
                        if (!com.xiaomi.miftp.c.b.b.booleanValue()) {
                            var2_2.f.setGravity(80);
                            var2_2.f.setLayout(-1, -2);
                        }
                    }
                    var2_2.g = (ViewGroup)var2_2.f.findViewById(R.id.parentPanel);
                    var4_3 = (ViewGroup)var2_2.g.findViewById(R.id.topPanel);
                    if (var4_3 != null) {
                        if (var2_2.o != null) {
                            var28_4 = new LinearLayout.LayoutParams(-1, -2);
                            var4_3.addView(var2_2.o, 0, (ViewGroup.LayoutParams)var28_4);
                            var29_5 = var2_2.H.getResources().getDimensionPixelSize(R.dimen.dialog_title_vertical_padding);
                            if (var2_2.o.getPaddingTop() != 0) {
                                var29_5 = var2_2.o.getPaddingTop();
                            }
                            var30_6 = var2_2.H.getResources().getDimensionPixelSize(R.dimen.dialog_title_horizontal_padding);
                            var31_7 = var2_2.o.getPaddingLeft() != 0 ? var2_2.o.getPaddingLeft() : var30_6;
                            if (var2_2.o.getPaddingRight() != 0) {
                                var30_6 = var2_2.o.getPaddingRight();
                            }
                            var2_2.o.setPadding(var31_7, var29_5, var30_6, 0);
                            var4_3.removeView(var2_2.g.findViewById(R.id.alertTitle));
                        } else if (true ^ TextUtils.isEmpty((CharSequence)var2_2.j)) {
                            var2_2.m = (TextView)var4_3.findViewById(R.id.alertTitle);
                            var2_2.m.setText(var2_2.j);
                            if (var2_2.h != null) {
                                var2_2.m.setCompoundDrawablesRelativeWithIntrinsicBounds(var2_2.h, null, null, null);
                            }
                            if (var2_2.i != 0) {
                                var2_2.m.setCompoundDrawablesRelativeWithIntrinsicBounds(var2_2.i, 0, 0, 0);
                            }
                        } else {
                            var4_3.setVisibility(8);
                        }
                    }
                    if ((var5_8 = (ViewGroup)var2_2.g.findViewById(R.id.contentPanel)) != null) {
                        var2_2.E = (ScrollView)var2_2.g.findViewById(R.id.scrollView);
                        var2_2.E.setFocusable(false);
                        var2_2.n = (TextView)var2_2.g.findViewById(R.id.message);
                        if (var2_2.n != null) {
                            if (var2_2.k != null) {
                                var2_2.n.setText(var2_2.k);
                                var26_9 = var2_2.g.findViewById(R.id.topPanel);
                                if (var26_9 != null && var26_9.getVisibility() == 8) {
                                    var27_10 = var2_2.H.getResources().getDimensionPixelSize(R.dimen.dialog_message_without_title_vertical_padding);
                                    var5_8.setPadding(var5_8.getPaddingLeft(), var27_10, var5_8.getRight(), var5_8.getPaddingBottom());
                                }
                            } else {
                                var2_2.n.setVisibility(8);
                                var2_2.E.removeView((View)var2_2.n);
                                if (var2_2.l != null) {
                                    var23_11 = var2_2.l.getChoiceMode();
                                    if (var2_2.G != null && var23_11 != 2) {
                                        var2_2.l.setAdapter(var2_2.G);
                                    }
                                    if (var2_2.J >= 0) {
                                        var2_2.l.setItemChecked(var2_2.J, true);
                                        var2_2.l.setSelection(var2_2.J);
                                    }
                                    var5_8.removeView((View)var2_2.E);
                                    var5_8.addView((View)var2_2.l, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
                                    var5_8.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, 0, 1.0f));
                                    var5_8.setPadding(0, 0, 0, 0);
                                    var2_2.a();
                                    if (com.xiaomi.miftp.c.b.b.booleanValue() && var2_2.o == null && var2_2.m != null) {
                                        var2_2.m.setPadding(0, 0, 0, 0);
                                        var24_12 = var2_2.g.findViewById(R.id.topPanel);
                                        try {
                                            var24_12.setBackground(var2_2.H.getResources().getDrawable(R.drawable.dialog_title_bg_light));
                                        }
                                        catch (Resources.NotFoundException v0) {}
                                        var5_8.setPadding(var5_8.getPaddingLeft(), 0, var5_8.getPaddingRight(), var5_8.getPaddingBottom());
                                    }
                                } else {
                                    var5_8.setVisibility(8);
                                }
                            }
                        }
                    }
                    if ((var6_13 = (FrameLayout)var2_2.g.findViewById(R.id.customPanel)) == null) break block47;
                    if (var2_2.p == null) break block48;
                    ((FrameLayout)var2_2.g.findViewById(16908331)).addView(var2_2.p, new ViewGroup.LayoutParams(-1, -1));
                    if (var2_2.l != null) {
                        ((LinearLayout.LayoutParams)var6_13.getLayoutParams()).weight = 0.0f;
                    }
                    if (!(var2_2.p instanceof ViewGroup)) break block47;
                    var17_14 = (ViewGroup)var2_2.p;
                    var18_15 = var2_2.H.getResources().getDimensionPixelSize(R.dimen.dialog_custom_vertical_padding);
                    if (var17_14.getPaddingTop() != 0) {
                        var18_15 = var17_14.getPaddingTop();
                    }
                    var19_16 = var17_14.getPaddingBottom() != 0;
                    var2_2.L = var19_16;
                    var20_17 = var2_2.H.getResources().getDimensionPixelSize(R.dimen.dialog_custom_horizontal_padding);
                    var21_18 = var17_14.getPaddingLeft() != 0 ? var17_14.getPaddingLeft() : var20_17;
                    if (var17_14.getPaddingRight() != 0) {
                        var20_17 = var17_14.getPaddingRight();
                    }
                    if ((var22_19 = var17_14.findViewById(16908301)) == null || var22_19 instanceof ProgressBar) break block49;
                    var6_13.setPadding(0, 0, 0, 0);
                    ** GOTO lbl100
                }
                if (var17_14.findViewById(R.id.datePicker) == null && var17_14.findViewById(R.id.timePicker) == null && var17_14.findViewById(R.id.dateTimePicker) == null) {
                    var6_13.setPadding(var21_18, var18_15, var20_17, var17_14.getPaddingBottom());
                    var17_14.setPadding(0, 0, 0, 0);
                } else {
                    var6_13.setPadding(0, 0, 0, 0);
                    var2_2.a();
lbl100: // 2 sources:
                    var2_2.L = true;
                }
                break block47;
            }
            var6_13.setVisibility(8);
        }
        if ((var7_20 = (FrameLayout)var2_2.g.findViewById(R.id.checkboxPanel)) != null) {
            if (var2_2.r != null) {
                var7_20.setVisibility(0);
                var16_21 = (CheckBox)var7_20.findViewById(16908289);
                var16_21.setChecked(var2_2.q);
                var16_21.setText(var2_2.r);
            } else {
                var7_20.setVisibility(8);
            }
        }
        if ((var8_22 = (ViewGroup)var2_2.g.findViewById(R.id.buttonPanel)) == null) return;
        var2_2.u = (Button)var8_22.findViewById(16908313);
        if (var2_2.u == null) ** GOTO lbl125
        var2_2.u.setOnClickListener(var2_2.I);
        if (!TextUtils.isEmpty((CharSequence)var2_2.v)) {
            var2_2.u.setText(var2_2.v);
            var2_2.u.setVisibility(0);
            var11_23 = b.a((TextView)var2_2.u);
            var9_24 = 1;
            var10_25 = true;
        } else {
            var2_2.u.setVisibility(8);
lbl125: // 2 sources:
            var9_24 = 0;
            var10_25 = false;
            var11_23 = false;
        }
        var2_2.x = (Button)var8_22.findViewById(16908314);
        if (var2_2.x != null) {
            var2_2.x.setOnClickListener(var2_2.I);
            if (TextUtils.isEmpty((CharSequence)var2_2.y)) {
                var2_2.x.setVisibility(8);
            } else {
                var2_2.x.setText(var2_2.y);
                var2_2.x.setVisibility(0);
                var11_23 = b.a((TextView)var2_2.x);
                ++var9_24;
                var10_25 = true;
            }
        }
        var2_2.A = (Button)var8_22.findViewById(16908315);
        if (var2_2.A != null) {
            var2_2.A.setOnClickListener(var2_2.I);
            if (TextUtils.isEmpty((CharSequence)var2_2.B)) {
                var2_2.A.setVisibility(8);
            } else {
                var2_2.A.setText(var2_2.B);
                var2_2.A.setVisibility(0);
                var11_23 = b.a((TextView)var2_2.A);
                ++var9_24;
                var10_25 = true;
            }
        }
        if (!var10_25) {
            var8_22.setVisibility(8);
            return;
        }
        var12_26 = (LinearLayout)var8_22.findViewById(R.id.buttonGroup);
        if (var11_23 || var9_24 > 2) {
            var12_26.setOrientation(1);
            var12_26.removeAllViews();
            if (var2_2.u != null) {
                var15_27 = var2_2.u.getLayoutParams();
                var15_27.width = -1;
                var12_26.addView((View)var2_2.u, var15_27);
            }
            if (var2_2.A != null) {
                var14_28 = var2_2.A.getLayoutParams();
                var14_28.width = -1;
                var12_26.addView((View)var2_2.A, var14_28);
            }
            if (var2_2.x != null) {
                var13_29 = var2_2.x.getLayoutParams();
                var13_29.width = -1;
                var12_26.addView((View)var2_2.x, var13_29);
            }
        }
        if (!var2_2.L && var2_2.l == null) {
            if (var2_2.r == null) return;
        }
        var12_26.setPadding(var12_26.getPaddingLeft(), 0, var12_26.getPaddingRight(), var12_26.getPaddingBottom());
    }

    public final boolean onKeyDown(int n2, KeyEvent keyEvent) {
        b b2 = this.a.a;
        boolean bl = b2.E != null && b2.E.executeKeyEvent(keyEvent);
        if (!bl) {
            return super.onKeyDown(n2, keyEvent);
        }
        return true;
    }

    public final boolean onKeyUp(int n2, KeyEvent keyEvent) {
        b b2 = this.a.a;
        boolean bl = b2.E != null && b2.E.executeKeyEvent(keyEvent);
        if (!bl) {
            return super.onKeyUp(n2, keyEvent);
        }
        return true;
    }

    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.a.a(charSequence);
    }

    public final void show() {
        Activity activity;
        Context context = this.getContext();
        if (context instanceof Activity && ((activity = (Activity)context).isFinishing() || activity.isDestroyed())) {
            return;
        }
        super.show();
    }

    public static final class a {
        public c.a a;
        private int b;

        public a(Context context) {
            super(context, d.a(context, 0));
        }

        public a(Context context, int n2) {
            c.a a2 = this.a = new c.a((Context)new ContextThemeWrapper(context, d.a(context, n2)));
            boolean bl = n2 >= 4 && n2 <= 7;
            a2.H = bl;
            this.b = n2;
        }

        public final a a(int n2) {
            this.a.e = this.a.a.getText(n2);
            return this;
        }

        public final a a(Drawable drawable2) {
            this.a.d = drawable2;
            return this;
        }

        public final a a(View view) {
            this.a.t = view;
            return this;
        }

        public final a a(CharSequence charSequence) {
            this.a.e = charSequence;
            return this;
        }

        public final a a(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.a.h = charSequence;
            this.a.i = onClickListener;
            return this;
        }

        public final a a(CharSequence[] arrcharSequence, DialogInterface.OnClickListener onClickListener) {
            this.a.q = arrcharSequence;
            this.a.s = onClickListener;
            this.a.x = 0;
            this.a.v = true;
            return this;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public final d a() {
            block24 : {
                block31 : {
                    block30 : {
                        block29 : {
                            block27 : {
                                block28 : {
                                    block25 : {
                                        block26 : {
                                            var1_1 = new d(this.a.a, this.b);
                                            var2_2 = this.a;
                                            var3_3 = d.a(var1_1);
                                            if (var2_2.f != null) {
                                                var3_3.a(var2_2.f);
                                            } else if (var2_2.e != null) {
                                                var3_3.a(var2_2.e);
                                            }
                                            if (var2_2.d != null) {
                                                var3_3.a(var2_2.d);
                                            }
                                            if (var2_2.c != 0) {
                                                var3_3.a(var2_2.c);
                                            }
                                            if (var2_2.g != null) {
                                                var3_3.b(var2_2.g);
                                            }
                                            if (var2_2.J != null) {
                                                var24_4 = var3_3.a;
                                                var25_5 = var2_2.I;
                                                var26_6 = var2_2.J;
                                                var24_4.q = var25_5;
                                                var24_4.r = var26_6;
                                            }
                                            if (var2_2.h != null) {
                                                var3_3.a(-1, var2_2.h, var2_2.i);
                                            }
                                            if (var2_2.j != null) {
                                                var3_3.a(-2, var2_2.j, var2_2.k);
                                            }
                                            if (var2_2.l != null) {
                                                var3_3.a(-3, var2_2.l, var2_2.m);
                                            }
                                            if (var2_2.q == null && var2_2.z == null && var2_2.r == null) break block24;
                                            var4_7 = var3_3.a;
                                            var5_8 = (ListView)var2_2.b.inflate(var4_7.a, null);
                                            if (var5_8 == null) break block24;
                                            if (!var2_2.u) break block25;
                                            var19_9 = var4_7.b;
                                            if (var2_2.z != null) break block26;
                                            if (var2_2.H && var2_2.r != null) ** GOTO lbl-1000
                                            var22_16 = var2_2.a;
                                            var23_17 = var2_2.q;
                                            var16_12 = new ArrayAdapter<CharSequence>(var2_2, var22_16, var19_9, var23_17, var5_8){
                                                final /* synthetic */ ListView a;
                                                final /* synthetic */ c.a b;
                                                {
                                                    this.b = a2;
                                                    this.a = listView;
                                                    super(context, n2, 16908308, (Object[])arrcharSequence);
                                                }

                                                public final View getView(int n2, View view, ViewGroup viewGroup) {
                                                    View view2 = super.getView(n2, view, viewGroup);
                                                    if (!this.b.H && this.b.w != null && this.b.w[n2]) {
                                                        this.a.setItemChecked(n2, true);
                                                    }
                                                    return view2;
                                                }
                                            };
                                            break block27;
                                        }
                                        var20_18 = var2_2.a;
                                        var21_19 = var2_2.z;
                                        var16_13 = new CursorAdapter(var2_2, var20_18, var21_19, var5_8, var19_9){
                                            final /* synthetic */ ListView a;
                                            final /* synthetic */ int b;
                                            final /* synthetic */ c.a c;
                                            private final int d;
                                            private final int e;
                                            {
                                                this.c = a2;
                                                this.a = listView;
                                                this.b = n2;
                                                super(context, cursor, false);
                                                Cursor cursor2 = this.getCursor();
                                                this.d = cursor2.getColumnIndexOrThrow(this.c.A);
                                                this.e = cursor2.getColumnIndexOrThrow(this.c.B);
                                            }

                                            public final void bindView(View view, Context context, Cursor cursor) {
                                                ((android.widget.CheckedTextView)view.findViewById(16908308)).setText((CharSequence)cursor.getString(this.d));
                                                if (!this.c.H) {
                                                    int n2;
                                                    ListView listView = this.a;
                                                    int n3 = cursor.getPosition();
                                                    int n4 = cursor.getInt(this.e);
                                                    if (n4 != (n2 = 1)) {
                                                        n2 = 0;
                                                    }
                                                    listView.setItemChecked(n3, (boolean)n2);
                                                }
                                            }

                                            public final View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                                                return this.c.b.inflate(this.b, null);
                                            }
                                        };
                                        break block27;
                                    }
                                    var9_20 = var2_2.v != false ? var4_7.c : var4_7.d;
                                    var10_21 = var9_20;
                                    if (var2_2.z == null) {
                                        ** if (var2_2.r == null) goto lbl-1000
                                    }
                                    break block28;
lbl-1000: // 2 sources:
                                    {
                                        var18_10 = var2_2.r;
                                        ** GOTO lbl53
                                    }
lbl-1000: // 1 sources:
                                    {
                                        var18_10 = new ArrayAdapter(var2_2.a, var10_21, 16908308, (Object[])var2_2.q);
                                    }
lbl53: // 2 sources:
                                    var16_11 = var18_10;
                                    break block27;
                                }
                                var12_23 = var2_2.a;
                                var13_24 = var2_2.z;
                                var14_25 = new String[]{var2_2.A};
                                var15_26 = new int[]{16908308};
                                var16_14 = var11_22;
                                var16_14(var12_23, var10_21, var13_24, var14_25, var15_26);
                            }
                            var4_7.G = var16_15;
                            var4_7.J = var2_2.x;
                            var4_7.K = var2_2.w;
                            if (var2_2.s == null) break block29;
                            var17_27 = new AdapterView.OnItemClickListener(var2_2, var4_7){
                                final /* synthetic */ b a;
                                final /* synthetic */ c.a b;
                                {
                                    this.b = a2;
                                    this.a = b2;
                                }

                                public final void onItemClick(AdapterView adapterView, View view, int n2, long l2) {
                                    this.b.s.onClick(this.a.F, n2);
                                    if (!this.b.v) {
                                        this.a.F.dismiss();
                                    }
                                }
                            };
                            break block30;
                        }
                        if (var2_2.y == null) break block31;
                        var17_29 = new AdapterView.OnItemClickListener(var2_2, var5_8, var4_7){
                            final /* synthetic */ ListView a;
                            final /* synthetic */ b b;
                            final /* synthetic */ c.a c;
                            {
                                this.c = a2;
                                this.a = listView;
                                this.b = b2;
                            }

                            public final void onItemClick(AdapterView adapterView, View view, int n2, long l2) {
                                if (this.c.w != null) {
                                    this.c.w[n2] = this.a.isItemChecked(n2);
                                }
                                this.c.y.onClick(this.b.F, n2, this.a.isItemChecked(n2));
                            }
                        };
                    }
                    var5_8.setOnItemClickListener((AdapterView.OnItemClickListener)var17_28);
                }
                if (var2_2.C != null) {
                    var5_8.setOnItemSelectedListener(var2_2.C);
                }
                if (var2_2.v) {
                    var5_8.setChoiceMode(1);
                } else if (var2_2.u) {
                    var5_8.setChoiceMode(2);
                }
                var4_7.l = var5_8;
            }
            if (var2_2.t != null) {
                var3_3.b(var2_2.t);
            }
            if (var2_2.G != null) {
                var6_30 = var3_3.a;
                var7_31 = var2_2.G;
                var8_32 = var2_2.D;
                var6_30.s = var7_31;
                var6_30.t = var8_32;
            }
            var1_1.setCancelable(this.a.n);
            if (this.a.n) {
                var1_1.setCanceledOnTouchOutside(true);
            }
            var1_1.setOnCancelListener(this.a.o);
            var1_1.setOnDismissListener(this.a.E);
            var1_1.setOnShowListener(this.a.F);
            if (this.a.p == null) return var1_1;
            var1_1.setOnKeyListener(this.a.p);
            return var1_1;
        }

        public final a b(CharSequence charSequence) {
            this.a.g = charSequence;
            return this;
        }

        public final a b(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.a.j = charSequence;
            this.a.k = onClickListener;
            return this;
        }

        public final d b() {
            d d2 = this.a();
            d2.show();
            return d2;
        }
    }

}

