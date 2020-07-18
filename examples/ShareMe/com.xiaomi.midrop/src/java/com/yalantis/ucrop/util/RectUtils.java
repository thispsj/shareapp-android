/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 *  java.lang.Math
 *  java.lang.Object
 */
package com.yalantis.ucrop.util;

import android.graphics.RectF;

public class RectUtils {
    public static float[] getCenterFromRect(RectF rectF) {
        float[] arrf = new float[]{rectF.centerX(), rectF.centerY()};
        return arrf;
    }

    public static float[] getCornersFromRect(RectF rectF) {
        float[] arrf = new float[]{rectF.left, rectF.top, rectF.right, rectF.top, rectF.right, rectF.bottom, rectF.left, rectF.bottom};
        return arrf;
    }

    public static float[] getRectSidesFromCorners(float[] arrf) {
        float[] arrf2 = new float[]{(float)Math.sqrt((double)(Math.pow((double)(arrf[0] - arrf[2]), (double)2.0) + Math.pow((double)(arrf[1] - arrf[3]), (double)2.0))), (float)Math.sqrt((double)(Math.pow((double)(arrf[2] - arrf[4]), (double)2.0) + Math.pow((double)(arrf[3] - arrf[5]), (double)2.0)))};
        return arrf2;
    }

    public static RectF trapToRect(float[] arrf) {
        RectF rectF = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        for (int i2 = 1; i2 < arrf.length; i2 += 2) {
            float f2 = (float)Math.round((float)(10.0f * arrf[i2 - 1])) / 10.0f;
            float f3 = (float)Math.round((float)(10.0f * arrf[i2])) / 10.0f;
            float f4 = f2 < rectF.left ? f2 : rectF.left;
            rectF.left = f4;
            float f5 = f3 < rectF.top ? f3 : rectF.top;
            rectF.top = f5;
            if (!(f2 > rectF.right)) {
                f2 = rectF.right;
            }
            rectF.right = f2;
            if (!(f3 > rectF.bottom)) {
                f3 = rectF.bottom;
            }
            rectF.bottom = f3;
        }
        rectF.sort();
        return rectF;
    }
}

