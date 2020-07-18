/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.wifi.WifiManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  b.e.a.a.a.b
 *  b.e.a.a.a.c
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package b.e.a.a.a;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import b.e.a.a.a.b;
import b.e.a.a.a.c;

public class a {
    int a;
    int b;
    int c;
    private a d;

    protected a() {
        this.a = 0;
        this.b = 1;
        this.c = 6;
    }

    /*
     * Enabled aggressive block sorting
     */
    public a(Context context, WifiManager wifiManager) {
        this.a = 0;
        this.b = 1;
        this.c = 6;
        Object object = Build.VERSION.SDK_INT >= 21 ? new c(context, wifiManager) : new b(context, wifiManager);
        this.d = object;
    }

    public int a() {
        return this.d.a();
    }

    public int a(int n2) {
        return this.d.a(n2);
    }

    public int a(String string2, String string3, String string4, int n2, int n3) {
        return this.d.a(string2, string3, string4, n2, n3);
    }

    public int a(String string2, String string3, boolean bl, int n2) {
        return this.d.a(string2, string3, bl, n2);
    }

    public int a(boolean bl, int n2) {
        return this.d.a(bl, n2);
    }

    public static final class a
    extends Enum<a> {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d;

        static {
            int[] arrn = new int[]{a, b, c};
            d = arrn;
        }

        public static int[] a() {
            return (int[])d.clone();
        }
    }

}

