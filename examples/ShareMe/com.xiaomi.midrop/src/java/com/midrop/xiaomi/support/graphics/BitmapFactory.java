/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.Rect
 *  android.graphics.Xfermode
 *  android.graphics.drawable.Drawable
 *  android.renderscript.Allocation
 *  android.renderscript.Element
 *  android.renderscript.RenderScript
 *  android.renderscript.ScriptIntrinsicBlur
 *  android.renderscript.Type
 *  java.lang.CharSequence
 *  java.lang.InstantiationException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ThreadLocal
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package com.midrop.xiaomi.support.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.renderscript.Type;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BitmapFactory
extends android.graphics.BitmapFactory {
    private static final Pattern ASIALANGPATTERN;
    private static final ThreadLocal<Canvas> sCanvasCache;
    static Object sLockForRsContext;
    static RenderScript sRsContext;
    private static final Paint sSrcInPaint;

    static {
        Paint paint;
        sLockForRsContext = new Object();
        sCanvasCache = new ThreadLocal();
        sSrcInPaint = paint = new Paint(1);
        paint.setFilterBitmap(true);
        sSrcInPaint.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        ASIALANGPATTERN = Pattern.compile((String)"[\u3100-\u312d\u31a0-\u31ba\u4e00-\u9fcc\u3400-\u4db5\uf900-\ufad9\u2f00-\u2fd5\u2e80-\u2ef3\u31c0-\u31e3\u1100-\u11ff\ua960-\ua97c\ud7b0-\ud7fb\u3131-\u318e\uac00-\ud7a3\u3040-\u309f\u30a0-\u30ff\u31f0-\u31ff\u3190-\u319f\ua000-\ua48c\ua490-\ua4c6]");
    }

    protected BitmapFactory() throws InstantiationException {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    private static boolean containsEastAsianCharacter(String string2) {
        return ASIALANGPATTERN.matcher((CharSequence)string2).find();
    }

    private static Bitmap copyToEmpty(Bitmap bitmap) {
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        if (bitmap.getConfig() != null) {
            config = bitmap.getConfig();
        }
        return Bitmap.createBitmap((int)bitmap.getWidth(), (int)bitmap.getHeight(), (Bitmap.Config)config);
    }

    public static Bitmap fastBlur(Context context, Bitmap bitmap, int n2) {
        Bitmap bitmap2 = BitmapFactory.copyToEmpty(bitmap);
        BitmapFactory.fastBlur(context, bitmap, bitmap2, n2);
        return bitmap2;
    }

    public static Bitmap fastBlur(Context context, Bitmap bitmap, Bitmap bitmap2, int n2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap2 == null || bitmap.getWidth() != bitmap2.getWidth() || bitmap.getHeight() != bitmap2.getHeight()) {
            bitmap2 = BitmapFactory.copyToEmpty(bitmap);
        }
        BitmapFactory.fastblur_v17(context, bitmap, bitmap2, n2);
        return bitmap2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Bitmap fastblur_v17(Context context, Bitmap bitmap, Bitmap bitmap2, int n2) {
        Object object;
        int n3 = 1;
        while (n2 > 25) {
            n3 *= 2;
            n2 /= 2;
        }
        int n4 = bitmap.getWidth();
        int n5 = bitmap.getHeight();
        Bitmap bitmap3 = n3 == 1 ? bitmap : BitmapFactory.scaleBitmap(bitmap, Math.max((int)(n4 / n3), (int)1), Math.max((int)(n5 / n3), (int)1));
        Object object2 = object = sLockForRsContext;
        synchronized (object2) {
            if (sRsContext == null) {
                sRsContext = RenderScript.create((Context)context);
            }
            Bitmap bitmap4 = n3 == 1 ? bitmap2 : bitmap3;
            if (bitmap3.getRowBytes() != bitmap4.getRowBytes()) {
                bitmap3 = bitmap3.copy(Bitmap.Config.ARGB_8888, true);
            }
            Allocation allocation = Allocation.createFromBitmap((RenderScript)sRsContext, (Bitmap)bitmap3);
            Allocation allocation2 = Allocation.createTyped((RenderScript)sRsContext, (Type)allocation.getType());
            ScriptIntrinsicBlur scriptIntrinsicBlur = ScriptIntrinsicBlur.create((RenderScript)sRsContext, (Element)Element.U8_4((RenderScript)sRsContext));
            scriptIntrinsicBlur.setRadius((float)n2);
            scriptIntrinsicBlur.setInput(allocation);
            scriptIntrinsicBlur.forEach(allocation2);
            allocation2.copyTo(bitmap4);
            if (bitmap4 != bitmap2) {
                BitmapFactory.scaleBitmap(bitmap4, bitmap2);
            }
            if (bitmap3 != bitmap) {
                bitmap3.recycle();
            }
            if (bitmap4 != bitmap2) {
                bitmap4.recycle();
            }
            return bitmap2;
        }
    }

    private static Canvas getCachedCanvas() {
        Canvas canvas = (Canvas)sCanvasCache.get();
        if (canvas == null) {
            canvas = new Canvas();
            sCanvasCache.set((Object)canvas);
        }
        return canvas;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static Bitmap maskOutBitmap(Bitmap var0_2, Drawable var1_1, Bitmap var2_4, Rect var3_3, Rect var4) {
        block8 : {
            block9 : {
                if (var2_4 == null && var4 == null) {
                    return null;
                }
                if (var2_4 == null) {
                    if (var4.height() <= 0) return null;
                    if (var4.width() <= 0) {
                        return null;
                    }
                    var2_4 = Bitmap.createBitmap((int)var4.width(), (int)var4.height(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
                } else if (var4 == null) {
                    var4 = new Rect(0, 0, var2_4.getWidth(), var2_4.getHeight());
                }
                var5_5 = BitmapFactory.getCachedCanvas();
                var5_5.setBitmap(var2_4);
                var5_5.drawColor(0, PorterDuff.Mode.CLEAR);
                if (var1_1 != null) {
                    var1_1.setBounds(var4);
                    var1_1.draw(var5_5);
                }
                if (var3_3 != null) break block8;
                var6_6 = var0_2.getWidth();
                var7_7 = var0_2.getHeight();
                var8_8 = var4.width();
                var9_9 = var4.height();
                var10_10 = var8_8;
                var11_11 = var9_9 / var10_10;
                var12_12 = var6_6;
                var13_13 = var12_12 / var10_10;
                var14_14 = var7_7;
                var15_15 = var14_14 / var9_9;
                if (!(var13_13 > var15_15)) break block9;
                var20_16 = (int)(var14_14 / var11_11);
                var17_17 = (var6_6 - var20_16) / 2;
                var6_6 = var20_16;
                ** GOTO lbl-1000
            }
            var16_20 = var13_13 FCMPG var15_15;
            var17_17 = 0;
            if (var16_20 < 0) {
                var18_18 = (int)(var11_11 * var12_12);
                var19_19 = (var7_7 - var18_18) / 2;
            } else lbl-1000: // 2 sources:
            {
                var18_18 = var7_7;
                var19_19 = 0;
            }
            var3_3 = new Rect(var17_17, var19_19, var6_6 + var17_17, var18_18 + var19_19);
        }
        var5_5.drawBitmap(var0_2, var3_3, var4, BitmapFactory.sSrcInPaint);
        return var2_4;
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, int n2, int n3) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() == n2 && bitmap.getHeight() == n3) {
            return bitmap;
        }
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        if (bitmap.getConfig() != null) {
            config = bitmap.getConfig();
        }
        Bitmap bitmap2 = Bitmap.createBitmap((int)n2, (int)n3, (Bitmap.Config)config);
        BitmapFactory.scaleBitmap(bitmap, bitmap2);
        return bitmap2;
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap != null && bitmap2 != null) {
            if (bitmap.getWidth() == bitmap2.getWidth() && bitmap.getHeight() == bitmap2.getHeight()) {
                return bitmap;
            }
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawARGB(0, 0, 0, 0);
            Paint paint = new Paint();
            paint.setFilterBitmap(true);
            paint.setAntiAlias(true);
            paint.setDither(true);
            canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight()), paint);
            return bitmap2;
        }
        return null;
    }
}

