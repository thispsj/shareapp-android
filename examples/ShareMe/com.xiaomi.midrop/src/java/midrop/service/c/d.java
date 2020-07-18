/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  e.a.a
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package midrop.service.c;

import e.a.a;

public final class d {
    public static /* varargs */ void a(String string2, String string3, Throwable throwable, Object ... arrobject) {
        a.a((String)string2);
        a.a((Throwable)throwable, (String)string3, (Object[])arrobject);
    }

    public static /* varargs */ void a(String string2, String string3, Object ... arrobject) {
        a.a((String)string2);
        a.b((String)string3, (Object[])arrobject);
    }

    public static /* varargs */ void a(String string2, Object ... arrobject) {
        a.a((String)"$MiDrop:Connect");
        a.a((String)string2, (Object[])arrobject);
    }

    public static /* varargs */ void b(String string2, String string3, Object ... arrobject) {
        a.a((String)string2);
        a.c((String)string3, (Object[])arrobject);
    }
}

