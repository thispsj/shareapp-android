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
package midrop.c.c;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import midrop.c.c.c;

public class a
implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>(){

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new a(parcel);
        }
    };
    public static final String a = "a";
    public c b;
    public ArrayList<Object> c;

    private a() {
        this.c = new ArrayList();
    }

    public a(Parcel parcel) {
        this.c = new ArrayList();
        this.b = (c)parcel.readParcelable(c.class.getClassLoader());
        parcel.readList(this.c, Object.class.getClassLoader());
    }

    public a(c c2) {
        this.c = new ArrayList();
        this.b = c2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeParcelable((Parcelable)this.b, n2);
        parcel.writeList(this.c);
    }

}

