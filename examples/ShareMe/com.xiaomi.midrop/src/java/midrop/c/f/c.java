/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  midrop.a.c.a.a.a
 *  midrop.a.c.a.a.a$a
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package midrop.c.f;

import midrop.a.c.a.a.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public a a = a.a;
    public b b = b.a;
    private c c = c.a;
    private a.a.b d = a.a.b.a;

    public static c a(a a2) {
        c c2 = new c();
        c2.c = c.b;
        c2.a = a2;
        return c2;
    }

    public static c a(b b2) {
        c c2 = new c();
        c2.c = c.c;
        c2.b = b2;
        return c2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final c a(String string2) {
        this.c = c.a;
        try {
            JSONObject jSONObject = new JSONObject(string2);
            String string3 = jSONObject.getString("status");
            if (string3 == null) {
                return this.c;
            }
            String string4 = jSONObject.getString("value");
            if (string4 == null) {
                return this.c;
            }
            this.c = c.a(string3);
            switch (1.a[this.c.ordinal()]) {
                case 2: {
                    this.b = b.a(string4);
                    return this.c;
                }
                case 1: {
                    this.a = a.a(string4);
                    return this.c;
                }
            }
            return this.c;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        return this.c;
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final String toString() {
        var1_1 = new JSONObject();
        var1_1.put("status", (Object)this.c.toString());
        var4_2 = 1.a[this.c.ordinal()];
        if (var4_2 == 4) return var1_1.toString();
        switch (var4_2) {
            case 2: {
                var5_3 = "value";
                var6_4 = this.b.toString();
lbl11: // 2 sources:
                do {
                    var1_1.put(var5_3, (Object)var6_4);
                    return var1_1.toString();
                    break;
                } while (true);
            }
            case 1: {
                var5_3 = "value";
                try {
                    var6_4 = this.a.toString();
                    ** continue;
                }
                catch (JSONException var2_5) {
                    var2_5.printStackTrace();
                }
                do {
                    return var1_1.toString();
                    break;
                } while (true);
            }
        }
        return var1_1.toString();
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a();
        public static final /* enum */ a b = new a();
        public static final /* enum */ a c = new a();
        public static final /* enum */ a d = new a();
        public static final /* enum */ a e = new a();
        public static final /* enum */ a f = new a();
        public static final /* enum */ a g = new a();
        private static final /* synthetic */ a[] h;

        static {
            a[] arra = new a[]{a, b, c, d, e, f, g};
            h = arra;
        }

        public static a a(String string2) {
            if (string2.equals((Object)"Ready")) {
                return b;
            }
            if (string2.equals((Object)"Downloading")) {
                return c;
            }
            if (string2.equals((Object)"DownloadFinished")) {
                return e;
            }
            if (string2.equals((Object)"DownloadPerFileFinished")) {
                return d;
            }
            if (string2.equals((Object)"DownloadFailed")) {
                return f;
            }
            if (string2.equals((Object)"DownloadCancelled")) {
                return g;
            }
            return a;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])h.clone();
        }

        public final String toString() {
            switch (1.b[this.ordinal()]) {
                default: {
                    return "Undefined";
                }
                case 6: {
                    return "DownloadCancelled";
                }
                case 5: {
                    return "DownloadFailed";
                }
                case 4: {
                    return "DownloadPerFileFinished";
                }
                case 3: {
                    return "DownloadFinished";
                }
                case 2: {
                    return "Downloading";
                }
                case 1: 
            }
            return "Ready";
        }
    }

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b a = new b();
        public static final /* enum */ b b = new b();
        public static final /* enum */ b c = new b();
        public static final /* enum */ b d = new b();
        public static final /* enum */ b e = new b();
        public static final /* enum */ b f = new b();
        private static final /* synthetic */ b[] g;

        static {
            b[] arrb = new b[]{a, b, c, d, e, f};
            g = arrb;
        }

        public static b a(String string2) {
            if (string2.equals((Object)"Ready")) {
                return b;
            }
            if (string2.equals((Object)"Accept")) {
                return c;
            }
            if (string2.equals((Object)"Reject")) {
                return d;
            }
            if (string2.equals((Object)"RejectKickOff")) {
                return e;
            }
            if (string2.equals((Object)"InsufficientStorage")) {
                return f;
            }
            return a;
        }

        public static b valueOf(String string2) {
            return (b)Enum.valueOf(b.class, (String)string2);
        }

        public static b[] values() {
            return (b[])g.clone();
        }

        public final String toString() {
            switch (1.c[this.ordinal()]) {
                default: {
                    return "Undefined";
                }
                case 5: {
                    return "InsufficientStorage";
                }
                case 4: {
                    return "RejectKickOff";
                }
                case 3: {
                    return "Reject";
                }
                case 2: {
                    return "Accept";
                }
                case 1: 
            }
            return "Ready";
        }
    }

    public static final class c
    extends Enum<c> {
        public static final /* enum */ c a = new c();
        public static final /* enum */ c b = new c();
        public static final /* enum */ c c = new c();
        public static final /* enum */ c d = new c();
        private static final /* synthetic */ c[] e;

        static {
            c[] arrc = new c[]{a, b, c, d};
            e = arrc;
        }

        public static c a(String string2) {
            if (string2.equals((Object)"DownloadStatus")) {
                return b;
            }
            if (string2.equals((Object)"ReceptionStatus")) {
                return c;
            }
            if (string2.equals((Object)"ConnectionStatus")) {
                return d;
            }
            return a;
        }

        public static c valueOf(String string2) {
            return (c)Enum.valueOf(c.class, (String)string2);
        }

        public static c[] values() {
            return (c[])e.clone();
        }

        public final String toString() {
            switch (1.a[this.ordinal()]) {
                default: {
                    return "undefined";
                }
                case 3: {
                    return "ConnectionStatus";
                }
                case 2: {
                    return "ReceptionStatus";
                }
                case 1: 
            }
            return "DownloadStatus";
        }
    }

}

