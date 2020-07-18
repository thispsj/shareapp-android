/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package midrop.c.c;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.ArrayList;
import midrop.c.c.a;
import midrop.c.c.b;
import midrop.c.c.c;

public class e
implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>(){

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new e(parcel);
        }
    };
    private static final String k = "e";
    public boolean a;
    public boolean b;
    public boolean c;
    public String d;
    public String e;
    public String f;
    public c g;
    public int h;
    public a i;
    public b j;

    public e() {
        this.h = 0;
    }

    public e(Parcel parcel) {
        this.h = 0;
        boolean[] arrbl = new boolean[3];
        parcel.readBooleanArray(arrbl);
        this.a = arrbl[0];
        this.b = arrbl[1];
        this.c = arrbl[2];
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = (c)parcel.readParcelable(c.class.getClassLoader());
        this.h = parcel.readInt();
        switch (this.h) {
            default: {
                return;
            }
            case 2: {
                this.j = (b)parcel.readParcelable(b.class.getClassLoader());
                return;
            }
            case 1: {
                this.i = (a)parcel.readParcelable(a.class.getClassLoader());
            }
            case 0: 
        }
    }

    public e(String string2, Class<?> class_) {
        this.h = 0;
        this.d = string2;
        this.g = c.a(class_);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final boolean a(Object object) {
        if (this.g.b != object.getClass()) {
            String string2 = k;
            Object[] arrobject = new Object[]{this.d, this.g.b.getSimpleName(), object.getClass().getSimpleName()};
            Log.e((String)string2, (String)String.format((String)"%s dataType is %s, value type is %s, invalid!", (Object[])arrobject));
            return false;
        }
        if (this.i != null) {
            a a2 = this.i;
            if (!a2.b.b.isInstance(object)) {
                Log.d((String)a.a, (String)"dataType invalid");
                return false;
            }
            boolean bl = a2.c.contains(object);
            if (bl) return bl;
            String string3 = a.a;
            Object[] arrobject = new Object[]{object.toString()};
            Log.d((String)string3, (String)String.format((String)"%s invalid", (Object[])arrobject));
            return bl;
        }
        if (this.j == null) {
            return true;
        }
        b b2 = this.j;
        if (!b2.b.b.isInstance(object)) {
            Log.d((String)b.a, (String)"dataType invalid");
            return false;
        }
        switch (b.2.a[b2.b.a.ordinal()]) {
            default: {
                break;
            }
            case 6: {
                long l2 = (Long)b2.c;
                Long l3 = (Long)object;
                if (l2 > l3 || l3 > (Long)b2.d) break;
                return true;
            }
            case 5: {
                int n2 = (Integer)b2.c;
                Integer n3 = (Integer)object;
                if (n2 > n3 || n3 > (Integer)b2.d) break;
                return true;
            }
            case 4: {
                float f2 = ((Float)b2.c).floatValue();
                Float f3 = (Float)object;
                if (!(f2 < f3.floatValue()) || !(f3.floatValue() < ((Float)b2.d).floatValue())) break;
                return true;
            }
            case 3: {
                double d2 = (Double)b2.c;
                Double d3 = (Double)object;
                if (!(d2 < d3) || !(d3 < (Double)b2.d)) break;
                return true;
            }
            case 1: 
            case 2: 
        }
        boolean bl = false;
        if (bl) return bl;
        String string4 = b.a;
        Object[] arrobject = new Object[]{object.toString(), b2.c.toString(), b2.d.toString()};
        Log.d((String)string4, (String)String.format((String)"%s invalid, [%s, %s]", (Object[])arrobject));
        return bl;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        e e2 = (e)object;
        return !(this.d == null ? e2.d != null : !this.d.equals((Object)e2.d));
    }

    public int hashCode() {
        int n2 = this.d == null ? 0 : this.d.hashCode();
        return n2 + 31;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        boolean[] arrbl = new boolean[]{this.a, this.b, this.c};
        parcel.writeBooleanArray(arrbl);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeParcelable((Parcelable)this.g, n2);
        parcel.writeInt(this.h);
        switch (this.h) {
            default: {
                return;
            }
            case 2: {
                parcel.writeParcelable((Parcelable)this.j, n2);
                return;
            }
            case 1: {
                parcel.writeParcelable((Parcelable)this.i, n2);
            }
            case 0: 
        }
    }

}

