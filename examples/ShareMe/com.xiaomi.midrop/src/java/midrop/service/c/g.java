/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package midrop.service.c;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.profile.a;
import com.xiaomi.midrop.receiver.service.ReceiverService;
import com.xiaomi.midrop.util.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import midrop.c.f.a;
import midrop.service.c.d;

public final class g {
    public static List<com.xiaomi.midrop.b.g> a(List<midrop.c.f.a> list, boolean bl, int n2) {
        ArrayList arrayList = new ArrayList();
        Long l2 = System.currentTimeMillis();
        for (midrop.c.f.a a2 : list) {
            if (a2.l) continue;
            com.xiaomi.midrop.b.g g2 = new com.xiaomi.midrop.b.g(a2.a.ordinal());
            g2.h = a2.e;
            g2.i = a2.f;
            String string2 = n2 == g.a.a ? a2.f : "";
            g2.j = string2;
            g2.k = a2.b;
            g2.l = a2.c;
            g2.m = 1;
            g2.q = a2.h;
            g2.r = a2.i;
            g2.s = a2.g;
            g2.t = a2.j;
            g2.z = n2;
            g2.A = l2;
            if (!bl && !TextUtils.isEmpty((CharSequence)g2.q)) {
                g2.m = 4;
                g2.n = 1;
            }
            arrayList.add((Object)g2);
        }
        return arrayList;
    }

    public static List<com.xiaomi.midrop.b.g> a(midrop.c.d.a a2) {
        return g.a(a2.a, true, g.a.b);
    }

    public static void a(Context context, midrop.c.d.a a2, String string2, String string3) {
        long l2;
        int n2;
        block18 : {
            int n3 = 0;
            if (a2 == null) {
                d.b("TransferUtils", "file queue is null", new Object[0]);
                return;
            }
            l2 = 0L;
            List<com.xiaomi.midrop.b.g> list = g.a(a2);
            if (list == null) {
                d.b("TransferUtils", "trans item is null", new Object[0]);
                return;
            }
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                l2 += ((com.xiaomi.midrop.b.g)iterator.next()).l;
            }
            String string4 = "";
            if (list.size() > 0) {
                string4 = ((com.xiaomi.midrop.b.g)list.get((int)0)).k;
            }
            int n4 = list.size();
            n2 = 2131231213;
            if (n4 == 1) {
                n2 = h.a(string4);
            } else {
                Iterator iterator2 = list.iterator();
                while (iterator2.hasNext()) {
                    int n5 = h.a(((com.xiaomi.midrop.b.g)iterator2.next()).k);
                    if (n3 == 0) {
                        n3 = n5;
                        continue;
                    }
                    if (n3 == n5) continue;
                    break block18;
                }
                if (n3 == 2131231208) {
                    n2 = 2131231209;
                } else if (n3 != 2131231212) {
                    if (n3 == 2131231210) {
                        n2 = 2131231211;
                    } else if (n3 == 2131231216) {
                        n2 = 2131231217;
                    } else if (n3 == 2131231214) {
                        n2 = 2131231215;
                    }
                }
            }
        }
        com.xiaomi.midrop.b.d d2 = new com.xiaomi.midrop.b.d();
        d2.a = a2.d;
        d2.b = a2.b();
        d2.e = n2;
        d2.c = string3;
        d2.d = l2;
        if (!TextUtils.isEmpty((CharSequence)string2) && a2.j() >= 0) {
            int n6 = a2.j();
            a.a.a(string2, n6);
        }
        Intent intent = new Intent("miui.intent.action.SHOW_RECEIVE_DIALOG");
        intent.addFlags(268468224);
        intent.putExtra("dialog_info", (Parcelable)d2);
        intent.putExtra("receiver_service_pid", ReceiverService.b(context));
        if (TextUtils.isEmpty((CharSequence)string2)) {
            string2 = "";
        }
        intent.putExtra("device_id", string2);
        intent.putExtra("need_confirm", a2.c);
        context.sendBroadcast(intent);
    }
}

