/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  com.xiaomi.midrop.sender.card.a
 *  com.xiaomi.midrop.sender.card.b
 *  com.xiaomi.midrop.sender.card.c
 *  com.xiaomi.midrop.sender.card.e
 *  com.xiaomi.midrop.sender.card.f
 *  com.xiaomi.midrop.sender.card.g
 *  com.xiaomi.midrop.sender.card.h
 *  com.xiaomi.midrop.sender.card.i
 *  com.xiaomi.midrop.sender.card.k
 *  com.xiaomi.midrop.sender.card.l
 *  java.lang.Object
 */
package com.xiaomi.midrop.sender.card;

import android.content.Context;
import android.view.LayoutInflater;
import com.xiaomi.midrop.sender.card.a;
import com.xiaomi.midrop.sender.card.b;
import com.xiaomi.midrop.sender.card.c;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.sender.card.e;
import com.xiaomi.midrop.sender.card.f;
import com.xiaomi.midrop.sender.card.g;
import com.xiaomi.midrop.sender.card.h;
import com.xiaomi.midrop.sender.card.i;
import com.xiaomi.midrop.sender.card.k;
import com.xiaomi.midrop.sender.card.l;

public final class j {
    public static d a(int n2, Context context, LayoutInflater layoutInflater) {
        i i2;
        switch (n2) {
            default: {
                i2 = null;
                break;
            }
            case 11: {
                i2 = new i(context);
                break;
            }
            case 10: {
                i2 = new g(context);
                break;
            }
            case 8: {
                i2 = new b(context);
                break;
            }
            case 7: {
                i2 = new c(context);
                break;
            }
            case 6: {
                i2 = new f(context);
                break;
            }
            case 5: {
                i2 = new h(context);
                break;
            }
            case 4: {
                i2 = new k(context);
                break;
            }
            case 3: {
                i2 = new a(context);
                break;
            }
            case 2: 
            case 12: {
                i2 = new l(context);
                break;
            }
            case 1: {
                i2 = new e(context);
            }
        }
        if (i2 != null) {
            i2.m = layoutInflater;
        }
        return i2;
    }
}

