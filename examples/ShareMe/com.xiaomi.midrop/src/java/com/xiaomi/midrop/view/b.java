/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.AssetManager
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.NoSuchFieldException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Field
 */
package com.xiaomi.midrop.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Log;
import java.lang.reflect.Field;

public final class b
extends ContextWrapper {
    int a;
    Drawable b;
    Drawable c;
    private a d;

    public b(Context context) {
        super(context, (byte)0);
    }

    private b(Context context, byte by) {
        super(context);
        this.a = 0;
        Resources resources = context.getResources();
        this.d = (b)this.new a(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
    }

    public final Resources getResources() {
        return this.d;
    }

    private final class a
    extends Resources {
        private int b;
        private int c;

        public a(AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
            super(assetManager, displayMetrics, configuration);
            this.b = a.a("overscroll_edge");
            this.c = a.a("overscroll_glow");
        }

        private static int a(String string2) {
            try {
                int n2 = (Integer)Class.forName((String)"com.android.internal.R$drawable").getField(string2).get(null);
                return n2;
            }
            catch (IllegalAccessException illegalAccessException) {
                StringBuilder stringBuilder = new StringBuilder("Cannot access internal resource id: ");
                stringBuilder.append(string2);
                Log.e((String)"[ContextWrapperEdgeEffect].getPlatformDrawableId()", (String)stringBuilder.toString());
                return 0;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                StringBuilder stringBuilder = new StringBuilder("Cannot access internal resource id: ");
                stringBuilder.append(string2);
                Log.e((String)"[ContextWrapperEdgeEffect].getPlatformDrawableId()", (String)stringBuilder.toString());
                return 0;
            }
            catch (NoSuchFieldException noSuchFieldException) {
                StringBuilder stringBuilder = new StringBuilder("Internal resource id does not exist: ");
                stringBuilder.append(string2);
                Log.e((String)"[ContextWrapperEdgeEffect].getPlatformDrawableId()", (String)stringBuilder.toString());
                return 0;
            }
            catch (ClassNotFoundException classNotFoundException) {
                Log.e((String)"[ContextWrapperEdgeEffect].getPlatformDrawableId()", (String)"Cannot find internal resource class");
                return 0;
            }
        }

        public final Drawable getDrawable(int n2) throws Resources.NotFoundException {
            block6 : {
                Drawable drawable2;
                block5 : {
                    block4 : {
                        if (n2 != this.b) break block4;
                        b.this.b = b.this.getBaseContext().getResources().getDrawable(2131231234);
                        drawable2 = b.this.b;
                        break block5;
                    }
                    if (n2 != this.c) break block6;
                    b.this.c = b.this.getBaseContext().getResources().getDrawable(2131231235);
                    drawable2 = b.this.c;
                }
                if (drawable2 != null) {
                    drawable2.setColorFilter(b.this.a, PorterDuff.Mode.MULTIPLY);
                }
                return drawable2;
            }
            return super.getDrawable(n2);
        }
    }

}

