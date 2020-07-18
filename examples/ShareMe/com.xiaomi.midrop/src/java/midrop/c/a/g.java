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
 *  java.util.ArrayList
 *  java.util.List
 */
package midrop.c.a;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import midrop.c.a.c;
import midrop.c.a.h;
import midrop.c.a.i;
import midrop.c.c.e;
import midrop.c.c.f;

public class g
implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new Parcelable.Creator<g>(){

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new g(parcel);
        }
    };
    i a;
    f b;
    private List<c> c;

    public g() {
        this.b = new f();
        this.c = new ArrayList();
        this.a();
    }

    public g(Parcel parcel) {
        this.b = new f();
        this.c = new ArrayList();
        g.super.a();
        g.super.a(parcel);
    }

    private void a() {
        this.b.a(h.a, null);
        this.b.a(h.b, null);
        this.b.a(h.c, null);
    }

    private void a(Parcel parcel) {
        this.b = (f)parcel.readParcelable(f.class.getClassLoader());
        int n2 = parcel.readInt();
        for (int i2 = 0; i2 < n2; ++i2) {
            c c2 = new c(parcel.readString(), parcel.readString(), parcel.readString());
            this.c.add((Object)c2);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeParcelable((Parcelable)this.b, n2);
        parcel.writeInt(this.c.size());
        for (c c2 : this.c) {
            parcel.writeString(c2.a());
            parcel.writeString(c2.b().toString());
            parcel.writeString(c2.c());
        }
    }

}

