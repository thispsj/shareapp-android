/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.lang.reflect.AccessibleObject
 */
package io.netty.d.b;

import io.netty.d.b.o;
import java.lang.reflect.AccessibleObject;

public final class r {
    public static Throwable a(AccessibleObject accessibleObject, boolean bl) {
        if (bl && !o.j()) {
            return new UnsupportedOperationException("Reflective setAccessible(true) disabled");
        }
        try {
            accessibleObject.setAccessible(true);
            return null;
        }
        catch (RuntimeException runtimeException) {
            if ("java.lang.reflect.InaccessibleObjectException".equals((Object)runtimeException.getClass().getName())) {
                return runtimeException;
            }
            throw runtimeException;
        }
        catch (SecurityException securityException) {
            return securityException;
        }
    }
}

