/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.HashSet
 */
package com.xiaomi.midrop.util;

import com.xiaomi.midrop.util.j;
import java.util.HashMap;
import java.util.HashSet;

public final class g {
    public static final String[] a = new String[]{"mp4", "wmv", "mpeg", "m4v", "3gp", "3g2", "3gpp2", "asf", "flv", "mkv", "vob", "ts", "f4v", "rm", "mov", "rmvb", "avi", "mpg", "3gpp", "wmv", "webm"};
    public static final String[] b = new String[]{"mp3", "wma", "wav", "aac", "ape", "flac", "m4a", "ogg", "mid", "amr", "awb", "mka", "mid"};
    public static final String[] c = new String[]{"apk"};
    public static final String[] d = new String[]{"doc", "docx", "wps", "xls", "xlsx", "ppt", "pptx"};
    public static final String[] e = new String[]{"jpg", "jpeg", "gif", "png", "bmp", "wbmp", "webp", "heic", "dng"};
    public static final String[] f = new String[]{"zip", "rar", "7z", "iso"};
    public static final String[] g = new String[]{"txt", "umd", "pdf", "ebk", "chm"};
    public static final HashSet<String> h;
    public static final HashSet<String> i;
    public static final HashSet<String> j;
    public static final HashSet<String> k;
    public static final HashSet<String> l;
    public static final HashSet<String> m;
    public static final HashSet<String> n;
    public static final HashMap<String, Integer> o;
    public static final String[] p;

    static {
        int n2 = 0;
        h = new a(0);
        i = new a(0);
        j = new a(0);
        k = new a(0);
        l = new a(0);
        m = new a(0);
        n = new a(0);
        o = new HashMap();
        p = new String[a.length + c.length + b.length + d.length + e.length + g.length + f.length];
        String[] arrstring = a;
        int n3 = arrstring.length;
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            String string2 = arrstring[i2];
            String[] arrstring2 = p;
            int n5 = n4 + 1;
            arrstring2[n4] = string2;
            h.add((Object)string2);
            n4 = n5;
        }
        for (String string3 : b) {
            String[] arrstring3 = p;
            int n6 = n4 + 1;
            arrstring3[n4] = string3;
            i.add((Object)string3);
            n4 = n6;
        }
        for (String string4 : c) {
            String[] arrstring4 = p;
            int n7 = n4 + 1;
            arrstring4[n4] = string4;
            j.add((Object)string4);
            n4 = n7;
        }
        for (String string5 : d) {
            String[] arrstring5 = p;
            int n8 = n4 + 1;
            arrstring5[n4] = string5;
            k.add((Object)string5);
            n4 = n8;
        }
        for (String string6 : e) {
            String[] arrstring6 = p;
            int n9 = n4 + 1;
            arrstring6[n4] = string6;
            l.add((Object)string6);
            n4 = n9;
        }
        for (String string7 : f) {
            String[] arrstring7 = p;
            int n10 = n4 + 1;
            arrstring7[n4] = string7;
            m.add((Object)string7);
            n4 = n10;
        }
        String[] arrstring8 = g;
        int n11 = arrstring8.length;
        while (n2 < n11) {
            String string8 = arrstring8[n2];
            String[] arrstring9 = p;
            int n12 = n4 + 1;
            arrstring9[n4] = string8;
            n.add((Object)string8);
            ++n2;
            n4 = n12;
        }
    }

    public static boolean a(String string2) {
        return i.contains((Object)string2);
    }

    public static boolean b(String string2) {
        return h.contains((Object)string2);
    }

    public static boolean c(String string2) {
        return l.contains((Object)string2);
    }

    public static boolean d(String string2) {
        return j.contains((Object)string2);
    }

    public static boolean e(String string2) {
        return k.contains((Object)string2);
    }

    public static boolean f(String string2) {
        return m.contains((Object)string2);
    }

    public static boolean g(String string2) {
        return n.contains((Object)string2);
    }

    public static boolean h(String string2) {
        return com.xiaomi.midrop.send.contacts.a.c(j.a(string2));
    }

    private static final class a
    extends HashSet<String> {
        private a() {
        }

        /* synthetic */ a(byte by) {
        }

        public final boolean contains(Object object) {
            if (object == null) {
                return false;
            }
            if (object instanceof String) {
                object = object.toString().toLowerCase();
            }
            return super.contains(object);
        }
    }

}

