/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;

public final class ag {
    public static int a(Context context) {
        int n2 = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(n2);
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().clearFlags(67108864);
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().getDecorView().setSystemUiVisibility(1280);
            activity.getWindow().setStatusBarColor(0);
        } else {
            activity.getWindow().addFlags(67108864);
        }
        ag.b(activity);
    }

    public static void a(Activity activity, int n2) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().clearFlags(67108864);
            activity.getWindow().setStatusBarColor(n2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(67108864);
            ViewGroup viewGroup = (ViewGroup)activity.getWindow().getDecorView();
            View view = viewGroup.findViewById(2131296779);
            if (view != null) {
                if (view.getVisibility() == 8) {
                    view.setVisibility(0);
                }
                view.setBackgroundColor(n2);
            } else {
                View view2 = new View((Context)activity);
                view2.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, ag.a((Context)activity)));
                view2.setBackgroundColor(n2);
                view2.setId(2131296779);
                viewGroup.addView(view2);
            }
            ag.b(activity);
        }
    }

    private static void b(Activity activity) {
        ViewGroup viewGroup = (ViewGroup)activity.findViewById(16908290);
        int n2 = viewGroup.getChildCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            View view = viewGroup.getChildAt(i2);
            if (!(view instanceof ViewGroup)) continue;
            view.setFitsSystemWindows(true);
            ((ViewGroup)view).setClipToPadding(true);
        }
    }
}

