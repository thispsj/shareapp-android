/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package b.e.b.a.a;

import java.util.Locale;

public final class b {
    public static String a(int n2) {
        switch (n2) {
            default: {
                Locale locale = Locale.CHINA;
                Object[] arrobject = new Object[]{n2};
                return String.format((Locale)locale, (String)"unknown reason: %d", (Object[])arrobject);
            }
            case 3: {
                return "no service requests";
            }
            case 2: {
                return "busy";
            }
            case 1: {
                return "p2p unsupported";
            }
            case 0: 
        }
        return "error";
    }
}

