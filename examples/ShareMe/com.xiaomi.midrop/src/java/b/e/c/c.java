/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package b.e.c;

public final class c {
    public static String a(int n2) {
        switch (n2) {
            default: {
                switch (n2) {
                    default: {
                        return "undefined";
                    }
                    case 14: {
                        return "WIFI_AP_STATE_FAILED";
                    }
                    case 13: {
                        return "WIFI_AP_STATE_ENABLED";
                    }
                    case 12: {
                        return "WIFI_AP_STATE_ENABLING";
                    }
                    case 11: {
                        return "WIFI_AP_STATE_DISABLED";
                    }
                    case 10: 
                }
                return "WIFI_AP_STATE_DISABLING";
            }
            case 3: {
                return "WIFI_STATE_ENABLED";
            }
            case 2: {
                return "WIFI_STATE_ENABLING";
            }
            case 1: {
                return "WIFI_STATE_DISABLED";
            }
            case 0: 
        }
        return "WIFI_STATE_DISABLING";
    }
}

