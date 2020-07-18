/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Object
 */
package midrop.c.c;

import android.os.Parcel;
import android.os.Parcelable;
import midrop.c.c.c;
import midrop.c.c.e;
import midrop.c.c.g;

public class d
implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>(){

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new d(parcel);
        }
    };
    public e a;
    public g b;

    public d() {
    }

    public d(Parcel parcel) {
        this.a = (e)parcel.readParcelable(e.class.getClassLoader());
        this.b = (g)parcel.readParcelable(g.class.getClassLoader());
    }

    public d(e e2, Object object) {
        g g2 = g.a(e2.g.b);
        g2.a(object);
        g2.a = false;
        this.a = e2;
        this.b = g2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeParcelable((Parcelable)this.a, n2);
        parcel.writeParcelable((Parcelable)this.b, n2);
    }

}

