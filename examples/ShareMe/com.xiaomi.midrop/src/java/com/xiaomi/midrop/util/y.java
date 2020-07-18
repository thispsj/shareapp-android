/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  midrop.service.c.e
 */
package com.xiaomi.midrop.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.midrop.common.b;
import midrop.service.c.e;

public final class y {
    private static String a = "is_in_world_cup_period";
    private static String b = "world_cup_dot_has_shown";

    public static boolean A() {
        return e.b((String)"key_has_auto_require_read_contacts_permission", (boolean)false);
    }

    public static void B() {
        e.a((String)"key_has_auto_require_read_contacts_permission", (boolean)true);
    }

    public static int C() {
        return b.a("key_profile_icon", -1);
    }

    public static void D() {
        e.a((String)"key_profile_new_flag", (boolean)false);
    }

    public static boolean E() {
        return e.b((String)"key_profile_new_flag", (boolean)false);
    }

    public static void F() {
        e.a((String)"key_delete_confirm", (boolean)false);
    }

    public static boolean G() {
        return e.b((String)"key_delete_confirm", (boolean)true);
    }

    public static int H() {
        return b.a("sp_history_new_msg", -1);
    }

    public static void a() {
        e.a((String)"first_use_midrop", (boolean)false);
    }

    public static void a(int n2) {
        e.a((String)"midrop_score", (int)n2);
    }

    public static void a(long l2) {
        e.a((String)"last_check_for_updates_time", (long)l2);
    }

    public static void a(String string2) {
        e.a((String)"imported_contacts", (String)string2);
    }

    public static void a(String string2, int n2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return;
        }
        String string3 = b.a("check_for_updates_state_info", null);
        if (string3 == null || Integer.valueOf((String)string3.split("#")[0]) != n2) {
            Object[] arrobject = new Object[]{n2, string2, 0, 1, 1};
            e.a((String)"check_for_updates_state_info", (String)String.format((String)"%d#%s#%d#%d#%d", (Object[])arrobject));
        }
    }

    public static void a(boolean bl) {
        e.a((String)"share_whatsapp_dot_shown", (boolean)bl);
    }

    public static boolean a(String string2, String string3) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            if (TextUtils.isEmpty((CharSequence)string3)) {
                return false;
            }
            return TextUtils.equals((CharSequence)b.a("trans_activity_reg_dev_record", null), (CharSequence)String.format((String)"%s%s%s", (Object[])new Object[]{string2, "#", string3}));
        }
        return false;
    }

    public static int b() {
        return b.a("midrop_score", 0);
    }

    public static int b(String string2) {
        return b.a(string2, -1);
    }

    public static void b(int n2) {
        e.a((String)"transmission_count", (int)n2);
    }

    public static void b(long l2) {
        e.a((String)"daily_stat_time", (long)l2);
    }

    public static void b(String string2, int n2) {
        e.a((String)string2, (int)n2);
    }

    public static void b(String string2, String string3) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            if (TextUtils.isEmpty((CharSequence)string3)) {
                return;
            }
            e.a((String)"trans_activity_reg_dev_record", (String)String.format((String)"%s%s%s", (Object[])new Object[]{string2, "#", string3}));
        }
    }

    public static void b(boolean bl) {
        e.a((String)"about_switch_free_upgrade", (boolean)bl);
    }

    public static void c() {
        e.a((String)"score_dialog_shown", (boolean)true);
    }

    public static void c(boolean bl) {
        e.a((String)"about_switch_free_upgrade_others", (boolean)bl);
    }

    public static boolean c(int n2) {
        String string2 = b.a("local_upgrade_version_show_count", "");
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return true;
        }
        String[] arrstring = string2.split("#");
        int n3 = Integer.valueOf((String)arrstring[0]) == n2 ? Integer.valueOf((String)arrstring[1]) : 1;
        return n3 < 3;
    }

    public static void d(boolean bl) {
        e.a((String)"show_hidden_file", (boolean)bl);
    }

    public static boolean d() {
        return e.b((String)"score_dialog_shown", (boolean)false);
    }

    public static boolean d(int n2) {
        String string2 = b.a("check_for_updates_state_info", null);
        if (string2 == null) {
            return false;
        }
        String[] arrstring = string2.split("#");
        return Integer.valueOf((String)arrstring[0]) > 12826 && Integer.valueOf((String)arrstring[n2]) != 0;
    }

    public static int e() {
        return b.a("transmission_count", 0);
    }

    public static void e(int n2) {
        String string2 = b.a("check_for_updates_state_info", null);
        if (string2 == null) {
            return;
        }
        Object[] arrobject = string2.split("#");
        if (Integer.valueOf((String)arrobject[n2]) == 0) {
            return;
        }
        arrobject[n2] = "0";
        e.a((String)"check_for_updates_state_info", (String)TextUtils.join((CharSequence)"#", (Object[])arrobject));
    }

    public static void e(boolean bl) {
        e.a((String)"key_open_file_remind", (boolean)bl);
    }

    public static void f(int n2) {
        e.a((String)"key_profile_icon", (int)n2);
    }

    public static boolean f() {
        return e.b((String)"share_whatsapp_dot_shown", (boolean)false);
    }

    public static void g() {
        e.a((String)"share_fb_dot_shown", (boolean)true);
    }

    public static void g(int n2) {
        e.a((String)"sp_history_new_msg", (int)n2);
    }

    public static boolean h() {
        return e.b((String)"about_switch_free_upgrade", (boolean)false);
    }

    public static boolean i() {
        return e.b((String)"about_switch_free_upgrade_others", (boolean)true);
    }

    public static boolean j() {
        return e.b((String)"show_hidden_file", (boolean)false);
    }

    public static void k() {
        e.a((String)"new_settings_msg_version_flag", (String)"1.17.8");
        y.e(3);
    }

    public static boolean l() {
        if (!TextUtils.equals((CharSequence)b.a("new_settings_msg_version_flag", ""), (CharSequence)"1.17.8")) {
            return true;
        }
        return y.d(3);
    }

    public static boolean m() {
        return e.b((String)"webshare_guide_need_show", (boolean)true);
    }

    public static void n() {
        e.a((String)"webshare_guide_need_show", (boolean)false);
    }

    public static String o() {
        return b.a("imported_contacts", null);
    }

    public static String p() {
        String string2 = b.a("check_for_updates_state_info", null);
        if (string2 == null) {
            return null;
        }
        return string2.split("#")[1];
    }

    public static int q() {
        String string2 = b.a("check_for_updates_state_info", null);
        if (string2 == null) {
            return 0;
        }
        return Integer.valueOf((String)string2.split("#")[0]);
    }

    public static boolean r() {
        String string2 = b.a("check_for_updates_state_info", null);
        if (string2 == null) {
            return false;
        }
        String[] arrstring = string2.split("#");
        if (Integer.valueOf((String)arrstring[0]) <= 12826) {
            return false;
        }
        return Integer.valueOf((String)arrstring[2]) < 3;
    }

    public static void s() {
        String string2 = b.a("check_for_updates_state_info", null);
        if (string2 == null) {
            return;
        }
        Object[] arrobject = string2.split("#");
        arrobject[2] = String.valueOf((int)(1 + Integer.valueOf((String)arrobject[2])));
        e.a((String)"check_for_updates_state_info", (String)TextUtils.join((CharSequence)"#", (Object[])arrobject));
    }

    public static long t() {
        Bundle bundle = new Bundle();
        bundle.putInt("type", 4);
        bundle.putString("key", "daily_stat_time");
        bundle.putLong("default", 0L);
        Bundle bundle2 = b.a("GET", bundle);
        if (bundle2 == null) {
            return 0L;
        }
        return bundle2.getLong("daily_stat_time", 0L);
    }

    public static boolean u() {
        return e.b((String)"key_is_scan_new_user", (boolean)true);
    }

    public static void v() {
        e.a((String)"key_is_scan_new_user", (boolean)false);
    }

    public static String w() {
        return b.a("trans_activity_id", null);
    }

    public static String x() {
        return b.a("trans_acitvity_reg_dev_url", null);
    }

    public static String y() {
        return b.a("trans_acitvity_sync_url", null);
    }

    public static boolean z() {
        return e.b((String)"key_open_file_remind", (boolean)false);
    }
}

