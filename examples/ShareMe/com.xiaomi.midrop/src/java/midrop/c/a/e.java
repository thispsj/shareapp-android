/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  midrop.c.a.b.a
 *  midrop.c.a.b.c
 */
package midrop.c.a;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import midrop.c.a.b.a;
import midrop.c.a.b.c;
import midrop.c.a.f;
import midrop.c.a.i;
import midrop.c.d.c;
import midrop.c.e.b;

public class e
implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>(){

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new e(parcel);
        }
    };
    public a a;
    public midrop.c.c.f b;
    public Map<String, i> c;

    public e() {
        this.a = new a();
        this.b = new midrop.c.c.f();
        this.c = new HashMap();
        this.n();
    }

    public e(Parcel parcel) {
        this.a = new a();
        this.b = new midrop.c.c.f();
        this.c = new HashMap();
        e.super.n();
        e.super.a(parcel);
    }

    private void a(Parcel parcel) {
        a a2 = new a();
        String string2 = parcel.readString();
        if (!a2.a(string2)) {
            a2 = null;
        }
        this.a = a2;
        this.b = (midrop.c.c.f)parcel.readParcelable(midrop.c.c.f.class.getClassLoader());
        int n2 = parcel.readInt();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.a((i)parcel.readParcelable(i.class.getClassLoader()));
        }
    }

    private void n() {
        this.b.a(f.a, null);
        this.b.a(f.b, null);
        this.b.a(f.c, null);
        this.b.a(f.d, null);
        this.b.a(f.e, null);
        this.b.a(f.f, null);
        this.b.a(f.g, null);
        this.b.a(f.h, null);
        this.b.a(f.i, null);
        this.b.a(f.j, null);
        this.b.a(f.k, null);
        this.b.a(f.l, null);
        this.b.a(f.m, 0);
        this.b.a(f.n, null);
        this.b.a(f.n, null);
        this.b.a(f.p, null);
        this.b.a(f.q, c.a.b.a());
        this.b.a(f.r, false);
        this.b.a(f.s, null);
        this.b.a(f.t, null);
        this.b.a(f.u, null);
        this.b.a(f.v, null);
        this.b.a(f.w, 0);
        this.b.a(f.x, false);
        this.b.a(f.y, false);
        this.b.a(f.z, false);
        this.b.a(f.A, false);
        this.b.a(f.B, false);
        this.b.a(f.C, null);
        this.b.a(f.D, false);
    }

    public final String a() {
        return (String)this.b.b(f.a);
    }

    public final void a(i i2) {
        c c2 = i2.b;
        if (c2 != null) {
            i2.a = this;
            this.c.put((Object)c2.toString(), (Object)i2);
        }
    }

    public final boolean a(int n2) {
        return this.b.b(f.m, n2);
    }

    public final boolean a(String string2) {
        return this.b.b(f.a, string2);
    }

    public final boolean a(c.a a2) {
        return this.b.b(f.q, a2.a());
    }

    public final boolean a(boolean bl) {
        new StringBuilder().append(bl);
        return this.b.b(f.j, bl);
    }

    public final String b() {
        return (String)this.b.b(f.c);
    }

    public final boolean b(int n2) {
        return this.b.b(f.w, n2);
    }

    public final boolean b(String string2) {
        return this.b.b(f.c, string2);
    }

    public final boolean b(boolean bl) {
        return this.b.b(f.s, bl);
    }

    public final void c(int n2) {
        this.b.b(b.t, n2);
    }

    public final boolean c() {
        return (Boolean)this.b.b(f.j);
    }

    public final boolean c(String string2) {
        return this.b.b(f.l, string2);
    }

    public final boolean c(boolean bl) {
        return this.b.b(f.t, bl);
    }

    public final String d() {
        return (String)this.b.b(f.l);
    }

    public final boolean d(String string2) {
        return this.b.b(f.n, string2);
    }

    public final boolean d(boolean bl) {
        return this.b.b(f.u, bl);
    }

    public int describeContents() {
        return 0;
    }

    public final String e() {
        return (String)this.b.b(f.n);
    }

    public final boolean e(String string2) {
        return this.b.b(f.o, string2);
    }

    public final boolean e(boolean bl) {
        return this.b.b(f.x, bl);
    }

    public boolean equals(Object object) {
        if (this.getClass() != object.getClass()) {
            return false;
        }
        e e2 = (e)object;
        if (this == e2) {
            return true;
        }
        return ((String)this.b.b(f.a)).equals((Object)((String)e2.b.b(f.a)));
    }

    public final c.a f() {
        return c.a.a((Byte)this.b.b(f.q));
    }

    public final boolean f(String string2) {
        return this.b.b(f.p, string2);
    }

    public final boolean f(boolean bl) {
        return this.b.b(f.y, bl);
    }

    public final String g() {
        return (String)this.b.b(f.v);
    }

    public final boolean g(String string2) {
        return this.b.b(f.v, string2);
    }

    public final boolean g(boolean bl) {
        return this.b.b(f.z, bl);
    }

    public final int h() {
        return (Integer)this.b.b(f.w);
    }

    public final boolean h(boolean bl) {
        return this.b.b(f.C, bl);
    }

    public int hashCode() {
        String string2 = (String)this.b.b(f.a);
        int n2 = string2 == null ? 0 : string2.hashCode();
        return n2 + 31;
    }

    public final void i(boolean bl) {
        this.b.b(f.D, bl);
    }

    public final boolean i() {
        return (Boolean)this.b.b(f.x);
    }

    public final boolean j() {
        return (Boolean)this.b.b(f.A);
    }

    public final boolean k() {
        return this.b.b(f.A, true);
    }

    public final int l() {
        return (Integer)this.b.b(b.t);
    }

    public final boolean m() {
        return (Boolean)this.b.b(f.D);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        if (this.a == null) {
            this.a = new a();
        }
        parcel.writeString(this.a.toString());
        parcel.writeParcelable((Parcelable)this.b, n2);
        parcel.writeInt(this.c.size());
        Iterator iterator = this.c.values().iterator();
        while (iterator.hasNext()) {
            parcel.writeParcelable((Parcelable)((i)iterator.next()), n2);
        }
    }

}

