/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.os.Looper
 *  android.util.TypedValue
 *  java.lang.InstantiationException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.ThreadLocal
 */
package com.midrop.xiaomi.support.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.util.TypedValue;

public class AttributeResolver {
    private static final TypedValue TYPED_VALUE = new TypedValue();
    private static final ThreadLocal<TypedValue> TYPED_VALUE_THREAD_LOCAL = new ThreadLocal();

    protected AttributeResolver() throws InstantiationException {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    private static TypedValue getTypedValue(Context context) {
        if (context.getMainLooper().getThread() == Thread.currentThread()) {
            return TYPED_VALUE;
        }
        TypedValue typedValue = (TypedValue)TYPED_VALUE_THREAD_LOCAL.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            TYPED_VALUE_THREAD_LOCAL.set((Object)typedValue);
        }
        return typedValue;
    }

    public static int resolve(Context context, int n2) {
        TypedValue typedValue = AttributeResolver.getTypedValue(context);
        if (context.getTheme().resolveAttribute(n2, typedValue, true)) {
            return typedValue.resourceId;
        }
        return -1;
    }

    public static int resolveDimensionPixelSize(Context context, int n2) {
        return context.getResources().getDimensionPixelSize(AttributeResolver.resolve(context, n2));
    }
}

