/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 */
package midrop.c.d;

public final class g
extends Enum<g> {
    public static final /* enum */ g a = new g();
    public static final /* enum */ g b = new g();
    public static final /* enum */ g c = new g();
    public static final /* enum */ g d = new g();
    public static final /* enum */ g e = new g();
    public static final /* enum */ g f = new g();
    public static final /* enum */ g g = new g();
    public static final /* enum */ g h = new g();
    public static final /* enum */ g i = new g();
    public static final /* enum */ g j = new g();
    public static final /* enum */ g k = new g();
    public static final /* enum */ g l = new g();
    public static final /* enum */ g m = new g();
    public static final /* enum */ g n = new g();
    public static final /* enum */ g o = new g();
    private static final /* synthetic */ g[] p;

    static {
        g[] arrg = new g[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o};
        p = arrg;
    }

    public static g a(String string2) {
        if (string2 == null) {
            return a;
        }
        if (string2.equals((Object)"accept")) {
            return c;
        }
        if (string2.equals((Object)"reject")) {
            return d;
        }
        if (string2.equals((Object)"reject_kick_off")) {
            return e;
        }
        if (string2.equals((Object)"cancel_download")) {
            return f;
        }
        if (string2.equals((Object)"insufficient_storage")) {
            return g;
        }
        if (string2.equals((Object)"accept_connect")) {
            return h;
        }
        if (string2.equals((Object)"reject_connect")) {
            return i;
        }
        if (string2.equals((Object)"cancel_connect")) {
            return j;
        }
        if (string2.equals((Object)"open_bluetooth")) {
            return k;
        }
        if (string2.equals((Object)"restart_receiver")) {
            return l;
        }
        if (string2.equals((Object)"apk_list")) {
            return m;
        }
        if (string2.equals((Object)"enable_wifi")) {
            return n;
        }
        if (string2.equals((Object)"start_discovery")) {
            return o;
        }
        return b;
    }

    public static g valueOf(String string2) {
        return (g)Enum.valueOf(g.class, (String)string2);
    }

    public static g[] values() {
        return (g[])p.clone();
    }

    public final String toString() {
        switch (1.a[this.ordinal()]) {
            default: {
                return "undefined";
            }
            case 14: {
                return "start_discovery";
            }
            case 13: {
                return "enable_wifi";
            }
            case 12: {
                return "apk_list";
            }
            case 11: {
                return "restart_receiver";
            }
            case 10: {
                return "open_bluetooth";
            }
            case 9: {
                return "cancel_connect";
            }
            case 8: {
                return "reject_connect";
            }
            case 7: {
                return "accept_connect";
            }
            case 6: {
                return "insufficient_storage";
            }
            case 5: {
                return "cancel_download";
            }
            case 4: {
                return "reject_kick_off";
            }
            case 3: {
                return "reject";
            }
            case 2: {
                return "accept";
            }
            case 1: 
        }
        return "null";
    }

}

