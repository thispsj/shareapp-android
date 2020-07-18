/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.List
 */
package com.xiaomi.midrop.send.audio;

import a.e.b.d;
import android.content.SharedPreferences;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.sender.c.f;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class a {
    public static final a a = new a(0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte by) {
        }

        public static int a() {
            return MiDropApplication.a().getSharedPreferences("pr_audio_sort", 0).getInt("key_audio_sort_by", 0);
        }

        /*
         * Enabled aggressive block sorting
         */
        public static void a(List<? extends g> list, int n2) {
            Comparator<g> comparator;
            String string2;
            d.b(list, "dada");
            if (n2 == 0) {
                comparator = f.c();
                string2 = "ItemComparator.getComparatorByDate()";
            } else {
                comparator = f.d();
                string2 = "ItemComparator.getComparatorByChineseName()";
            }
            d.a(comparator, string2);
            Collections.sort(list, comparator);
        }
    }

}

