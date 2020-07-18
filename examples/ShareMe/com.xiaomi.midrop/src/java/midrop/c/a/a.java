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
import midrop.c.a.b;
import midrop.c.a.c;
import midrop.c.a.i;
import midrop.c.c.e;
import midrop.c.c.f;

public class a
implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>(){

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new a(parcel);
        }
    };
    public i a;
    public f b;
    public List<c> c;

    public a() {
        this.b = new f();
        this.c = new ArrayList();
        this.b();
    }

    public a(Parcel parcel) {
        this.b = new f();
        this.c = new ArrayList();
        a.super.b();
        a.super.a(parcel);
    }

    private void a(Parcel parcel) {
        this.b = (f)parcel.readParcelable(f.class.getClassLoader());
        int n2 = parcel.readInt();
        for (int i2 = 0; i2 < n2; ++i2) {
            c c2 = new c(parcel.readString(), parcel.readString(), parcel.readString());
            this.c.add((Object)c2);
        }
    }

    private void b() {
        this.b.a(b.a, null);
        this.b.a(b.b, null);
        this.b.a(b.c, null);
    }

    public final String a() {
        return (String)this.b.b(b.a);
    }

    public final boolean a(String string2) {
        return this.b.b(b.a, string2);
    }

    public final boolean b(String string2) {
        return this.b.b(b.b, string2);
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

