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
 */
package midrop.c.a.a;

import android.os.Parcel;
import android.os.Parcelable;
import midrop.c.a.a.b;
import midrop.c.c.e;
import midrop.c.c.f;
import midrop.c.c.g;

public final class a
implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>(){

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new a(parcel);
        }
    };
    public f a;
    public f b;
    private f c;

    public a() {
        this.c = new f();
        this.a = new f();
        this.b = new f();
        this.d();
    }

    public a(Parcel parcel) {
        this.c = new f();
        this.a = new f();
        this.b = new f();
        a.super.d();
        this.c = (f)parcel.readParcelable(f.class.getClassLoader());
        this.a = (f)parcel.readParcelable(f.class.getClassLoader());
        this.b = (f)parcel.readParcelable(f.class.getClassLoader());
    }

    private void d() {
        this.c.a(b.a, null);
        this.c.a(b.b, null);
        this.c.a(b.c, null);
        this.c.a(b.d, null);
        this.c.a(b.e, null);
        this.c.a(b.f, null);
    }

    public final Object a(e e2) {
        g g2 = this.c.a(e2);
        if (g2 == null) {
            return null;
        }
        return g2.a();
    }

    public final String a() {
        return (String)this.a(b.f);
    }

    final void a(e e2, Object object) {
        g g2 = this.c.a(e2);
        if (g2 != null) {
            g2.a(object);
        }
    }

    public final String b() {
        return (String)this.a(b.a);
    }

    public final String c() {
        return (String)this.a(b.b);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int n2) {
        parcel.writeParcelable((Parcelable)this.c, n2);
        parcel.writeParcelable((Parcelable)this.a, n2);
        parcel.writeParcelable((Parcelable)this.b, n2);
    }

}

