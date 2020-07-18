/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.a.b;

final class m {
    static String a(int n2, int[] arrn, String[] arrstring, int[] arrn2) {
        StringBuilder stringBuilder = new StringBuilder("$");
        block4 : for (int i2 = 0; i2 < n2; ++i2) {
            switch (arrn[i2]) {
                default: {
                    continue block4;
                }
                case 3: 
                case 4: 
                case 5: {
                    stringBuilder.append('.');
                    if (arrstring[i2] == null) continue block4;
                    stringBuilder.append(arrstring[i2]);
                    continue block4;
                }
                case 1: 
                case 2: {
                    stringBuilder.append('[');
                    stringBuilder.append(arrn2[i2]);
                    stringBuilder.append(']');
                }
            }
        }
        return stringBuilder.toString();
    }
}

