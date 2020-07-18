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
package midrop.c.d;

import android.os.Parcel;
import android.os.Parcelable;
import midrop.c.d.f;
import midrop.c.d.g;

public final class e
implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>(){

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new e(parcel);
        }
    };
    private midrop.c.c.f a;

    public e() {
        this.a = new midrop.c.c.f();
        this.c();
    }

    public e(Parcel parcel) {
        this.a = new midrop.c.c.f();
        e.super.c();
        this.a = (midrop.c.c.f)parcel.readParcelable(midrop.c.c.f.class.getClassLoader());
    }

    public e(g g2) {
        this.a = new midrop.c.c.f();
        e.super.c();
        this.a.b(f.a, g2.toString());
    }

    public e(g g2, String string2) {
        super(g2);
        this.a.b(f.b, string2);
    }

    private void c() {
        this.a.a(f.a, null);
        this.a.a(f.b, null);
    }

    public final g a() {
        return g.a((String)this.a.b(f.a));
    }

    public final String b() {
        return (String)this.a.b(f.b);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int n2) {
        parcel.writeParcelable((Parcelable)this.a, n2);
    }

}

