/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.System
 *  java.security.AccessController
 *  java.security.PrivilegedAction
 */
package io.netty.d.b;

import io.netty.d.b.a.d;
import io.netty.d.b.a.e;
import java.security.AccessController;
import java.security.PrivilegedAction;

public final class u {
    private static final d a = e.a(u.class);

    private u() {
    }

    public static int a(String string2, int n2) {
        String string3 = u.a(string2, null);
        if (string3 == null) {
            return n2;
        }
        String string4 = string3.trim();
        try {
            int n3 = Integer.parseInt((String)string4);
            return n3;
        }
        catch (Exception exception) {
            d d2 = a;
            Object[] arrobject = new Object[]{string2, string4, n2};
            d2.b("Unable to parse the integer system property '{}':{} - using the default value: {}", arrobject);
            return n2;
        }
    }

    public static long a(String string2, long l2) {
        String string3 = u.a(string2, null);
        if (string3 == null) {
            return l2;
        }
        String string4 = string3.trim();
        try {
            long l3 = Long.parseLong((String)string4);
            return l3;
        }
        catch (Exception exception) {
            d d2 = a;
            Object[] arrobject = new Object[]{string2, string4, l2};
            d2.b("Unable to parse the long integer system property '{}':{} - using the default value: {}", arrobject);
            return l2;
        }
    }

    public static String a(final String string2, String string3) {
        String string4;
        if (string2 == null) {
            throw new NullPointerException("key");
        }
        if (string2.isEmpty()) {
            throw new IllegalArgumentException("key must not be empty.");
        }
        try {
            string4 = System.getSecurityManager() == null ? System.getProperty((String)string2) : (String)AccessController.doPrivileged((PrivilegedAction)new PrivilegedAction<String>(){

                public final /* synthetic */ Object run() {
                    return System.getProperty((String)string2);
                }
            });
        }
        catch (SecurityException securityException) {
            a.c("Unable to retrieve a system property '{}'; default values will be used.", (Object)string2, (Object)securityException);
            string4 = null;
        }
        if (string4 == null) {
            return string3;
        }
        return string4;
    }

    public static boolean a(String string2) {
        return u.a(string2, null) != null;
    }

    public static boolean a(String string2, boolean bl) {
        String string3 = u.a(string2, null);
        if (string3 == null) {
            return bl;
        }
        String string4 = string3.trim().toLowerCase();
        if (string4.isEmpty()) {
            return bl;
        }
        if (!"true".equals((Object)string4) && !"yes".equals((Object)string4)) {
            if ("1".equals((Object)string4)) {
                return true;
            }
            if (!"false".equals((Object)string4) && !"no".equals((Object)string4)) {
                if ("0".equals((Object)string4)) {
                    return false;
                }
                d d2 = a;
                Object[] arrobject = new Object[]{string2, string4, bl};
                d2.b("Unable to parse the boolean system property '{}':{} - using the default value: {}", arrobject);
                return bl;
            }
            return false;
        }
        return true;
    }

    public static String b(String string2) {
        return u.a(string2, null);
    }

}

