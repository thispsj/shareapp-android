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
 */
package midrop.c.e;

import android.os.Parcel;
import android.os.Parcelable;
import midrop.c.c.e;
import midrop.c.c.f;
import midrop.c.d.c;
import midrop.c.e.b;

public final class a
implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>(){

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new a(parcel);
        }
    };
    public f a;

    public a() {
        this.a = new f();
        this.m();
    }

    public a(Parcel parcel) {
        this.a = new f();
        a.super.m();
        this.a = (f)parcel.readParcelable(f.class.getClassLoader());
    }

    private void m() {
        this.a.a(b.a, null);
        this.a.a(b.b, null);
        this.a.a(b.c, null);
        this.a.a(b.d, null);
        this.a.a(b.e, null);
        this.a.a(b.f, null);
        this.a.a(b.g, null);
        this.a.a(b.h, null);
        this.a.a(b.i, 0);
        this.a.a(b.j, null);
        this.a.a(b.k, null);
        this.a.a(b.l, null);
        this.a.a(b.m, null);
        this.a.a(b.n, c.a.b.a());
        this.a.a(b.o, null);
        this.a.a(b.p, null);
        this.a.a(b.q, null);
        this.a.a(b.r, false);
        this.a.a(b.s, false);
        this.a.a(b.t, -1);
        this.a.a(b.u, null);
        this.a.a(b.v, false);
    }

    public final String a() {
        return (String)this.a.b(b.a);
    }

    public final void a(boolean bl) {
        this.a.b(b.o, bl);
    }

    public final boolean a(byte by) {
        return this.a.b(b.b, by);
    }

    public final boolean a(int n2) {
        return this.a.b(b.i, n2);
    }

    public final boolean a(String string2) {
        return this.a.b(b.a, string2);
    }

    public final boolean a(c.a a2) {
        return this.a.b(b.n, a2.a());
    }

    public final void b(int n2) {
        this.a.b(b.t, n2);
    }

    public final void b(boolean bl) {
        this.a.b(b.p, bl);
    }

    public final boolean b() {
        return (Boolean)this.a.b(b.f);
    }

    public final boolean b(String string2) {
        return this.a.b(b.c, string2);
    }

    public final String c() {
        return (String)this.a.b(b.h);
    }

    public final void c(boolean bl) {
        this.a.b(b.u, bl);
    }

    public final boolean c(String string2) {
        return this.a.b(b.h, string2);
    }

    public final int d() {
        return (Integer)this.a.b(b.i);
    }

    public final void d(boolean bl) {
        this.a.b(b.v, bl);
    }

    public final boolean d(String string2) {
        return this.a.b(b.k, string2);
    }

    public final int describeContents() {
        return 0;
    }

    public final String e() {
        return (String)this.a.b(b.j);
    }

    public final boolean e(String string2) {
        return this.a.b(b.m, string2);
    }

    public final boolean equals(Object object) {
        if (this.getClass() != object.getClass()) {
            return false;
        }
        a a2 = (a)object;
        if (this == a2) {
            return true;
        }
        return ((String)this.a.b(b.a)).equals((Object)((String)a2.a.b(b.a)));
    }

    public final String f() {
        return (String)this.a.b(b.k);
    }

    public final String g() {
        return (String)this.a.b(b.l);
    }

    public final String h() {
        return (String)this.a.b(b.m);
    }

    public final int hashCode() {
        String string2 = (String)this.a.b(b.a);
        int n2 = string2 == null ? 0 : string2.hashCode();
        return n2 + 31;
    }

    public final c.a i() {
        return c.a.a((Byte)this.a.b(b.n));
    }

    public final boolean j() {
        return (Boolean)this.a.b(b.q);
    }

    public final boolean k() {
        return (Boolean)this.a.b(b.r);
    }

    public final int l() {
        return (Integer)this.a.b(b.t);
    }

    public final void writeToParcel(Parcel parcel, int n2) {
        parcel.writeParcelable((Parcelable)this.a, n2);
    }

}

