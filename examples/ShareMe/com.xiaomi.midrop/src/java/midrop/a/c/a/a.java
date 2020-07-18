/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package midrop.a.c.a;

import android.os.Parcelable;
import android.text.TextUtils;
import midrop.c.a.e;

public abstract class a
implements Parcelable {
    public e a = null;
    private String b;

    public final String a() {
        String string2 = this.b;
        if (TextUtils.isEmpty((CharSequence)string2) && this.a != null) {
            string2 = this.a.b();
        }
        return string2;
    }

    public final String b() {
        if (this.a != null) {
            return this.a.a();
        }
        return null;
    }

    public final e c() {
        return this.a;
    }

    public boolean equals(Object object) {
        String string2 = this.b();
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        a a2 = (a)object;
        return !(string2 == null ? a2.b() != null : !string2.equals((Object)a2.b()));
    }

    public int hashCode() {
        String string2 = this.b();
        int n2 = string2 == null ? 0 : string2.hashCode();
        return n2 + 31;
    }
}

