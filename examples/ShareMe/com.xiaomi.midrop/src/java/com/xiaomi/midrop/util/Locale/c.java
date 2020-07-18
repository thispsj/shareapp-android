/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.LocaleList
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package com.xiaomi.midrop.util.Locale;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import java.util.Locale;

public final class c {
    /*
     * Enabled aggressive block sorting
     */
    public static int a(Context context) {
        a a2;
        SharedPreferences sharedPreferences = context.getSharedPreferences("LocaleModel", 4);
        String string2 = sharedPreferences.getString("SHARE_KEY_USER_SEL_LANG", "");
        String string3 = sharedPreferences.getString("SHARE_KEY_USER_SEL_COUNTRY", "");
        if (!TextUtils.isEmpty((CharSequence)string2) && !c.a(context, c.a())) {
            a2 = a.a(string2, string3);
            return a2.ordinal();
        }
        a2 = a.a;
        return a2.ordinal();
    }

    static Locale a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return Resources.getSystem().getConfiguration().getLocales().get(0);
        }
        return Resources.getSystem().getConfiguration().locale;
    }

    public static void a(Context context, a a2) {
        SharedPreferences.Editor editor = context.getSharedPreferences("LocaleModel", 4).edit();
        editor.putString("SHARE_KEY_USER_SEL_LANG", a2.aw);
        editor.putString("SHARE_KEY_USER_SEL_COUNTRY", a2.ax);
        Locale locale = c.a();
        editor.putString("SHARE_KEY_SYS_LANG", locale.getLanguage());
        editor.putString("SHARE_KEY_SYS_LANG_COUNTRY", locale.getCountry());
        editor.apply();
    }

    public static boolean a(Context context, Locale locale) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LocaleModel", 4);
        String string2 = sharedPreferences.getString("SHARE_KEY_SYS_LANG", "");
        String string3 = sharedPreferences.getString("SHARE_KEY_SYS_LANG_COUNTRY", "");
        return !TextUtils.equals((CharSequence)string2, (CharSequence)locale.getLanguage()) || !TextUtils.equals((CharSequence)string3, (CharSequence)locale.getCountry());
        {
        }
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a A;
        public static final /* enum */ a B;
        public static final /* enum */ a C;
        public static final /* enum */ a D;
        public static final /* enum */ a E;
        public static final /* enum */ a F;
        public static final /* enum */ a G;
        public static final /* enum */ a H;
        public static final /* enum */ a I;
        public static final /* enum */ a J;
        public static final /* enum */ a K;
        public static final /* enum */ a L;
        public static final /* enum */ a M;
        public static final /* enum */ a N;
        public static final /* enum */ a O;
        public static final /* enum */ a P;
        public static final /* enum */ a Q;
        public static final /* enum */ a R;
        public static final /* enum */ a S;
        public static final /* enum */ a T;
        public static final /* enum */ a U;
        public static final /* enum */ a V;
        public static final /* enum */ a W;
        public static final /* enum */ a X;
        public static final /* enum */ a Y;
        public static final /* enum */ a Z;
        public static final /* enum */ a a;
        public static final /* enum */ a aa;
        public static final /* enum */ a ab;
        public static final /* enum */ a ac;
        public static final /* enum */ a ad;
        public static final /* enum */ a ae;
        public static final /* enum */ a af;
        public static final /* enum */ a ag;
        public static final /* enum */ a ah;
        public static final /* enum */ a ai;
        public static final /* enum */ a aj;
        public static final /* enum */ a ak;
        public static final /* enum */ a al;
        public static final /* enum */ a am;
        public static final /* enum */ a an;
        public static final /* enum */ a ao;
        public static final /* enum */ a ap;
        public static final /* enum */ a aq;
        public static final /* enum */ a ar;
        public static final /* enum */ a as;
        public static final /* enum */ a at;
        public static final /* enum */ a au;
        private static final /* synthetic */ a[] ay;
        public static final /* enum */ a b;
        public static final /* enum */ a c;
        public static final /* enum */ a d;
        public static final /* enum */ a e;
        public static final /* enum */ a f;
        public static final /* enum */ a g;
        public static final /* enum */ a h;
        public static final /* enum */ a i;
        public static final /* enum */ a j;
        public static final /* enum */ a k;
        public static final /* enum */ a l;
        public static final /* enum */ a m;
        public static final /* enum */ a n;
        public static final /* enum */ a o;
        public static final /* enum */ a p;
        public static final /* enum */ a q;
        public static final /* enum */ a r;
        public static final /* enum */ a s;
        public static final /* enum */ a t;
        public static final /* enum */ a u;
        public static final /* enum */ a v;
        public static final /* enum */ a w;
        public static final /* enum */ a x;
        public static final /* enum */ a y;
        public static final /* enum */ a z;
        private final String av;
        private final String aw;
        private final String ax;

        static {
            a a2;
            a a3;
            a a4;
            a a5;
            a a6;
            a a7;
            a a8;
            a a9;
            a a10;
            a a11;
            a a12;
            a a13;
            a a14;
            a a15;
            a a16;
            a a17;
            a a18;
            a a19;
            a a20;
            a a21;
            a a22;
            a a23;
            a a24;
            a a25;
            a a26;
            a a27;
            a a28;
            a a29;
            a a30;
            a a31;
            a a32;
            a a33;
            a a34;
            a a35;
            a a36;
            a a37;
            a a38;
            a a39;
            a a40;
            a a41;
            a a42;
            a a43;
            a a44;
            a a45;
            a a46;
            a a47;
            a a48;
            a a49;
            a a50;
            a a51;
            a a52;
            a a53;
            a a54;
            a a55;
            a a56;
            a a57;
            a a58;
            a a59;
            a a60;
            a a61;
            a a62;
            a a63;
            a a64;
            a a65;
            a a66;
            a a67;
            a a68;
            a a69;
            a a70;
            a a71;
            a a72;
            a a73;
            a a74;
            a = a14 = new a("", "", "");
            b = a37 = new a("Az\u0259rbaycan dili (lat\u0131n)", "az", "AZ");
            c = a22 = new a("Bahasa Indonesia", "in", "");
            d = a54 = new a("Bahasa Melayu", "ms", "MY");
            e = a13 = new a("Bosanski", "bs", "BA");
            f = a69 = new a("Catal\u00e0", "ca", "ES");
            g = a58 = new a("Deutsch", "de", "");
            h = a9 = new a("Eesti", "et", "EE");
            i = a28 = new a("English (India)", "en", "IN");
            j = a25 = new a("English", Locale.ENGLISH.getLanguage(), Locale.ENGLISH.getCountry());
            k = a52 = new a("Espa\u00f1ol", "es", "ES");
            l = a70 = new a("Espa\u00f1ol (Am\u00e9rica)", "es", "US");
            m = a11 = new a("Euskara", "eu", "ES");
            n = a71 = new a("Fran\u00e7ais", "fr", "");
            o = a40 = new a("Galego", "gl", "ES");
            p = a38 = new a("Hausa", "ha", "NG");
            q = a35 = new a("Italiano", "it", "");
            r = a26 = new a("Latvie\u0161u", "lv", "");
            s = a74 = new a("Lietuvi\u0173", "lt", "");
            t = a8 = new a("Magyar", "hu", "");
            u = a19 = new a("Malti", "mt", "MT");
            v = a41 = new a("Norsk bokm\u00e5l", "nb", "NO");
            w = a42 = new a("Nederlands", "nl", "NL");
            x = a61 = new a("O'zbekcha", "uz", "UZ");
            y = a62 = new a("Polski", "pl", "");
            z = a6 = new a("Portugu\u00eas (Brasil)", "pt", "BR");
            A = a73 = new a("Portugu\u00eas (Portugal)", "pt", "PT");
            B = a51 = new a("Rom\u00e2n\u0103", "ro", "");
            C = a39 = new a("Shqip", "sq", "AL");
            D = a27 = new a("Sloven\u010dina", "sk", "");
            E = a46 = new a("Sloven\u0161\u010dina", "sl", "");
            F = a18 = new a("Suomi", "fi", "");
            G = a59 = new a("Svenska", "sv", "");
            H = a32 = new a("Ti\u1ebfng Vi\u1ec7t", "vi", "");
            I = a3 = new a("T\u00fcrk\u00e7e", "tr", "");
            J = a64 = new a("\u010de\u0161tina", "cs", "");
            K = a16 = new a("\u0441\u0440\u043f\u0441\u043a\u0438", "sr", "");
            L = a17 = new a("Hrvatski", "hr", "");
            M = a49 = new a("\u049a\u0430\u0437\u0430\u049b \u0442\u0456\u043b\u0456", "kk", "KZ");
            N = a68 = new a("\u041c\u0430\u043a\u0435\u0434\u043e\u043d\u0441\u043a\u0438", "mk", "MK");
            O = a33 = new a("\u0420\u0443\u0441\u0441\u043a\u0438\u0439", "ru", "");
            P = a20 = new a("\u0423\u043a\u0440\u0430\u0457\u043d\u0441\u044c\u043a\u0430", "uk", "");
            Q = a55 = new a("\u0431\u044a\u043b\u0433\u0430\u0440\u0441\u043a\u0438", "bg", "");
            R = a30 = new a("E\u03bb\u03bb\u03b7\u03bd\u03b9\u03ba\u03ac", "el", "");
            S = a15 = new a("\u10e5\u10d0\u10e0\u10d7\u10e3\u10da\u10d8", "ka", "GE");
            T = a66 = new a("\u0570\u0561\u0575\u0565\u0580\u0565\u0576", "hy", "AM");
            U = a56 = new a("\u0939\u093f\u0902\u0926\u0940", "hi", "");
            V = a44 = new a("\u092e\u0930\u093e\u0920\u0940", "mr", "IN");
            W = a4 = new a("\u09ac\u09be\u0982\u09b2\u09be (\u09ad\u09be\u09b0\u09a4)", "bn", "IN");
            X = a57 = new a("\u0a97\u0ac1\u0a9c\u0ab0\u0abe\u0aa4\u0ac0", "gu", "IN");
            Y = a10 = new a("\u0a2a\u0a70\u0a1c\u0a3e\u0a2c\u0a40", "pa", "IN");
            Z = a29 = new a("\u0985\u09b8\u09ae\u09c0\u09af\u09bc\u09be", "as", "IN");
            aa = a34 = new a("\u0ba4\u0bae\u0bbf\u0bb4", "ta", "IN");
            ab = a23 = new a("\u0c24\u0c46\u0c32\u0c41\u0c17\u0c41", "te", "IN");
            ac = a5 = new a("\u0c95\u0ca8\u0ccd\u0ca8\u0ca1", "kn", "IN");
            ad = a53 = new a("\u0d2e\u0d32\u0d2f\u0d3e\u0d33\u0d02", "ml", "IN");
            ae = a24 = new a("\u0928\u0947\u092a\u093e\u0932\u0940 (\u092d\u093e\u0930\u0924)", "ne", "IN");
            af = a72 = new a("\u0b13\u0b21\u0b3c\u0b3f\u0b06", "or", "IN");
            ag = a47 = new a("\u0627\u0631\u062f\u0648 (\u0628\u06be\u0627\u0631\u062a)", "ur", "IN");
            ah = a60 = new a("\u0627\u0631\u062f\u0648 (\u067e\u0627\u06a9\u0633\u062a\u0627\u0646)", "ur", "PK");
            ai = a67 = new a("\u09ac\u09be\u0982\u09b2\u09be (\u09ac\u09be\u0982\u09b2\u09be\u09a6\u09c7\u09b6)", "bn", "BD");
            aj = a63 = new a("\u0928\u0947\u092a\u093e\u0932\u0940 (\u0928\u0947\u092a\u093e\u0932)", "ne", "NP");
            ak = a48 = new a("\u0e44\u0e17\u0e22", "th", "");
            al = a21 = new a("\u1017\u1019\u102c", "my", "MM");
            am = a2 = new a("\u0627\u0644\u0639\u0631\u0628\u064a\u0629", "ar", "");
            an = a50 = new a("\u0641\u0627\u0631\u0633\u06cc", "fa", "IR");
            ao = a31 = new a("\u05e2\u05d1\u05e8\u05d9\u05ea", "iw", "IL");
            ap = a12 = new a("\u1781\u17d2\u1798\u17c2\u179a", "km", "KH");
            aq = a7 = new a("\ud55c\uad6d\uc5b4", "ko", "");
            ar = a65 = new a("\u7b80\u4f53\u4e2d\u6587", "zh", "CN");
            as = a45 = new a("\u7e41\u9ad4\u4e2d\u6587\uff08\u53f0\u7063\uff09", "zh", "TW");
            at = a36 = new a("\u7e41\u9ad4\u4e2d\u6587\uff08\u9999\u6e2f\uff09", "zh", "HK");
            au = a43 = new a("\u65e5\u672c\u8a9e", "ja", "");
            a[] arra = new a[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, aa, ab, ac, ad, ae, af, ag, ah, ai, aj, ak, al, am, an, ao, ap, aq, ar, as, at, au};
            ay = arra;
        }

        private a(String string3, String string4, String string5) {
            this.av = string3;
            this.aw = string4;
            this.ax = string5;
        }

        public static a a(String string2, String string3) {
            a[] arra = a.values();
            for (int i2 = 1; i2 < arra.length; ++i2) {
                if (!arra[i2].aw.equals((Object)string2) || !arra[i2].ax.equals((Object)string3)) continue;
                return arra[i2];
            }
            return a;
        }

        public static /* synthetic */ String[] a() {
            a[] arra = a.values();
            String[] arrstring = new String[arra.length];
            for (int i2 = 0; i2 < arra.length; ++i2) {
                arrstring[i2] = arra[i2].av;
            }
            return arrstring;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])ay.clone();
        }
    }

}

