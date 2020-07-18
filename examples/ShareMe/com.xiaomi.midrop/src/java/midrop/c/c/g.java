/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.Object
 *  java.lang.reflect.Constructor
 */
package midrop.c.c;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Constructor;

public class g
implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new Parcelable.Creator<g>(){

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new g(parcel);
        }
    };
    boolean a;
    public Object b;
    private boolean c;
    private Object d;

    public g() {
        this.a = false;
        this.c = false;
        this.b = null;
        this.d = null;
    }

    public g(Parcel parcel) {
        this.a = false;
        this.c = false;
        this.b = null;
        this.d = null;
        boolean bl = parcel.readInt() == 1;
        this.a = bl;
        int n2 = parcel.readInt();
        boolean bl2 = false;
        if (n2 == 1) {
            bl2 = true;
        }
        this.c = bl2;
        if (parcel.readInt() == 1) {
            this.b = parcel.readValue(Object.class.getClassLoader());
        }
        if (parcel.readInt() == 1) {
            this.d = parcel.readValue(Object.class.getClassLoader());
        }
    }

    public static g a(Class<?> class_) {
        Object object;
        block7 : {
            Constructor[] arrconstructor = class_.getConstructors();
            int n2 = arrconstructor.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                Constructor constructor = arrconstructor[i2];
                if (constructor.getParameterTypes().length == 0) {
                    object = class_.newInstance();
                    break block7;
                }
                if (constructor.getParameterTypes().length != 1) continue;
                if (class_ != Boolean.class) break;
                try {
                    object = false;
                    break block7;
                }
                catch (IllegalAccessException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                    break;
                }
                catch (InstantiationException instantiationException) {
                    instantiationException.printStackTrace();
                    break;
                }
            }
            object = null;
        }
        g g2 = new g();
        g2.b = object;
        g2.c = true;
        return g2;
    }

    public final Object a() {
        if (this.d != null) {
            return this.d;
        }
        return this.b;
    }

    public final void a(Object object) {
        if (this.d != null || object != null) {
            if (this.d == null) {
                this.d = object;
                this.a = true;
                return;
            }
            if (!this.d.equals(object)) {
                this.b = this.d;
                this.c = true;
                this.d = object;
                this.a = true;
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeInt((int)this.a);
        parcel.writeInt((int)this.c);
        if (this.b == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeValue(this.b);
        }
        if (this.d == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeValue(this.d);
    }

}

