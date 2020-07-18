/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.os.Handler
 *  android.os.Message
 *  android.text.Layout
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.widget.Button
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.ScrollView
 *  android.widget.TextView
 *  com.xiaomi.miftp.view.dialog.AlertControllerImpl
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 */
package com.xiaomi.miftp.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.xiaomi.miftp.R;
import com.xiaomi.miftp.view.dialog.AlertControllerImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class b {
    public Button A;
    CharSequence B;
    Message C;
    Handler D;
    ScrollView E;
    DialogInterface F;
    ListAdapter G;
    Context H;
    View.OnClickListener I;
    int J;
    boolean[] K;
    boolean L;
    final int a;
    final int b;
    final int c;
    final int d;
    final int e;
    final Window f;
    ViewGroup g;
    Drawable h;
    int i = 0;
    CharSequence j;
    CharSequence k;
    ListView l;
    TextView m;
    TextView n;
    View o;
    View p;
    boolean q;
    CharSequence r;
    ArrayList<Object> s;
    DialogInterface.OnClickListener t;
    public Button u;
    CharSequence v;
    Message w;
    public Button x;
    CharSequence y;
    Message z;

    public b(Context context, DialogInterface dialogInterface, Window window) {
        this.I = new View.OnClickListener((b)this){
            final /* synthetic */ b a;
            {
                this.a = b2;
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            public void onClick(View var1) {
                block4 : {
                    block3 : {
                        if (var1 != this.a.u || this.a.w == null) break block3;
                        var3_2 = this.a.w;
                        ** GOTO lbl11
                    }
                    if (var1 != this.a.x || this.a.z == null) break block4;
                    var3_2 = this.a.z;
                    ** GOTO lbl11
                }
                if (var1 == this.a.A && this.a.C != null) {
                    var3_2 = this.a.C;
lbl11: // 3 sources:
                    var2_3 = Message.obtain((Message)var3_2);
                } else {
                    var2_3 = null;
                }
                if (var2_3 != null) {
                    var2_3.sendToTarget();
                }
                this.a.D.obtainMessage(1, (Object)this.a.F).sendToTarget();
            }
        };
        this.J = -1;
        this.H = context;
        this.F = dialogInterface;
        this.f = window;
        this.D = new a(dialogInterface);
        TypedArray typedArray = context.obtainStyledAttributes(null, R.styleable.AlertDialog, 16842845, 0);
        this.e = typedArray.getResourceId(R.styleable.AlertDialog_layout_miftp, R.layout.alert_dialog);
        this.a = typedArray.getResourceId(R.styleable.AlertDialog_listLayout, R.layout.select_dialog);
        this.b = typedArray.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, R.layout.select_dialog_multichoice);
        this.c = typedArray.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, R.layout.select_dialog_singlechoice);
        this.d = typedArray.getResourceId(R.styleable.AlertDialog_listItemLayout, R.layout.select_dialog_item);
        typedArray.recycle();
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup)view;
        int n2 = viewGroup.getChildCount();
        while (n2 > 0) {
            if (!b.a(viewGroup.getChildAt(--n2))) continue;
            return true;
        }
        return false;
    }

    static boolean a(TextView textView) {
        Layout layout2 = textView.getLayout();
        return layout2 != null && layout2.getLineCount() > 0 && layout2.getEllipsisCount(layout2.getLineCount() - 1) > 0;
    }

    final void a() {
        if (this.m != null) {
            int n2 = this.H.getResources().getDimensionPixelSize(R.dimen.dialog_title_average_vertical_padding);
            this.m.setPadding(this.m.getPaddingLeft(), n2, this.m.getPaddingRight(), n2);
        }
    }

    private static final class a
    extends Handler {
        private WeakReference<DialogInterface> a;

        public a(DialogInterface dialogInterface) {
            this.a = new WeakReference((Object)dialogInterface);
        }

        public final void handleMessage(Message message) {
            int n2 = message.what;
            if (n2 != 1) {
                switch (n2) {
                    default: {
                        return;
                    }
                    case -3: 
                    case -2: 
                    case -1: 
                }
                ((DialogInterface.OnClickListener)message.obj).onClick((DialogInterface)this.a.get(), message.what);
                return;
            }
            ((DialogInterface)message.obj).dismiss();
        }
    }

}

