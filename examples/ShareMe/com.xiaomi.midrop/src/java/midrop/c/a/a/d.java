/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 *  midrop.c.a.b.c
 */
package midrop.c.a.a;

import android.os.Parcel;
import android.os.Parcelable;
import midrop.c.a.a.e;
import midrop.c.a.b.c;
import midrop.c.c.f;
import midrop.c.c.g;

public final class d
implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>(){

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new d(parcel);
        }
    };
    public f a;
    private f b;

    public d() {
        this.b = new f();
        this.a = new f();
        this.d();
    }

    public d(Parcel parcel) {
        this.b = new f();
        this.a = new f();
        d.super.d();
        this.b = (f)parcel.readParcelable(f.class.getClassLoader());
        this.a = (f)parcel.readParcelable(f.class.getClassLoader());
    }

    private Object a(midrop.c.c.e e2) {
        g g2 = this.b.a(e2);
        if (g2 == null) {
            return null;
        }
        return g2.a();
    }

    private void d() {
        this.b.a(e.b, null);
        this.b.a(e.c, null);
        this.b.a(e.a, null);
    }

    public final String a() {
        return (String)this.a(e.a);
    }

    final void a(midrop.c.c.e e2, Object object) {
        g g2 = this.b.a(e2);
        if (g2 != null) {
            g2.a(object);
        }
    }

    public final c b() {
        String string2 = (String)this.a(e.b);
        c c2 = new c();
        c2.a(string2);
        return c2;
    }

    public final String c() {
        return (String)this.a(e.c);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int n2) {
        parcel.writeParcelable((Parcelable)this.b, n2);
        parcel.writeParcelable((Parcelable)this.a, n2);
    }

}

