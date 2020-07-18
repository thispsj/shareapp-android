/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.Map
 *  midrop.c.a.b.c
 */
package midrop.c.a.a;

import android.util.Log;
import java.util.List;
import java.util.Map;
import midrop.c.a.a;
import midrop.c.a.a.b;
import midrop.c.a.c;
import midrop.c.a.e;
import midrop.c.a.i;
import midrop.c.c.f;

public final class c {
    /*
     * Enabled aggressive block sorting
     */
    public static midrop.c.a.a.a a(i i2, String string2) {
        a a2;
        block10 : {
            String string3;
            String string4;
            block9 : {
                block8 : {
                    a2 = (a)i2.d.get((Object)string2);
                    if (a2 != null) break block8;
                    string3 = "ActionInfoFactory";
                    string4 = String.format((String)"Action not found: %s", (Object[])new Object[]{string2});
                    break block9;
                }
                if (a2 != null) break block10;
                string3 = "ActionInfoFactory";
                string4 = "action is null";
            }
            Log.d((String)string3, (String)string4);
            return null;
        }
        i i3 = a2.a;
        e e2 = i3.a;
        midrop.c.a.a.a a3 = new midrop.c.a.a.a();
        String string5 = a2.a();
        a3.a(b.a, string5);
        String string6 = (String)a2.b.b(midrop.c.a.b.b);
        a3.a(b.b, string6);
        String string7 = (String)a2.b.b(midrop.c.a.b.c);
        a3.a(b.c, string7);
        String string8 = i3.b.toString();
        a3.a(b.d, string8);
        String string9 = i3.a();
        a3.a(b.e, string9);
        String string10 = e2.a();
        a3.a(b.f, string10);
        for (midrop.c.a.c c2 : a2.c) {
            block13 : {
                midrop.c.c.e e3;
                f f2;
                block12 : {
                    block11 : {
                        e3 = i3.c(c2.c());
                        if (e3 == null) {
                            Object[] arrobject = new Object[]{c2.c()};
                            Log.e((String)"ActionInfoFactory", (String)String.format((String)"PropertyDefinition is null: %s", (Object[])arrobject));
                            continue;
                        }
                        if (c2.b() != c.a.b) break block11;
                        f2 = a3.a;
                        break block12;
                    }
                    if (c2.b() != c.a.c) break block13;
                    f2 = a3.b;
                }
                f2.a(e3, null);
                continue;
            }
            Log.e((String)"ActionInfoFactory", (String)"Argument direction is invalid!!!");
            return a3;
        }
        return a3;
    }
}

