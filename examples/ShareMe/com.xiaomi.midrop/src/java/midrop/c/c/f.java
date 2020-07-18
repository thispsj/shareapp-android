/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.Log
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package midrop.c.c;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import midrop.c.c.d;
import midrop.c.c.e;
import midrop.c.c.g;

public class f
implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new Parcelable.Creator<f>(){

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new f(parcel);
        }
    };
    private static final String b = "f";
    public List<d> a;

    public f() {
        this.a = new ArrayList();
    }

    public f(Parcel parcel) {
        this.a = new ArrayList();
        f.super.a(parcel);
    }

    private void a(Parcel parcel) {
        int n2 = parcel.readInt();
        for (int i2 = 0; i2 < n2; ++i2) {
            d d2 = (d)parcel.readParcelable(d.class.getClassLoader());
            this.a.add((Object)d2);
        }
    }

    public final d a(String string2) {
        Iterator iterator = this.a.iterator();
        d d2 = null;
        while (iterator.hasNext()) {
            d d3 = (d)iterator.next();
            if (!d3.a.d.equals((Object)string2)) continue;
            d2 = d3;
        }
        return d2;
    }

    public final g a(e e2) {
        for (d d2 : this.a) {
            if (!d2.a.equals(e2)) continue;
            return d2.b;
        }
        return null;
    }

    public final void a(e e2, Object object) {
        d d2 = new d(e2, object);
        this.a.add((Object)d2);
    }

    public final Object b(e e2) {
        for (d d2 : this.a) {
            if (!d2.a.equals(e2)) continue;
            return d2.b.a();
        }
        return null;
    }

    public final e b(String string2) {
        for (d d2 : this.a) {
            if (!d2.a.d.equals((Object)string2)) continue;
            return d2.a;
        }
        return null;
    }

    public final boolean b(e e2, Object object) {
        boolean bl = false;
        if (object != null) {
            if (!e2.a(object)) {
                Log.d((String)b, (String)String.format((String)"invalid value: %s", (Object[])new Object[]{object}));
                return false;
            }
            g g2 = this.a(e2);
            if (g2 == null) {
                return false;
            }
            g2.a(object);
            bl = true;
        }
        return bl;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeInt(this.a.size());
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            parcel.writeParcelable((Parcelable)((d)iterator.next()), n2);
        }
    }

}

