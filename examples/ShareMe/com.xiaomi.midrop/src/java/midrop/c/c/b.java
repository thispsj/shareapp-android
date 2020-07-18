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
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 */
package midrop.c.c;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import midrop.c.c.c;

public class b
implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>(){

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new b(parcel);
        }
    };
    static final String a = "b";
    c b;
    Object c;
    Object d;

    private b() {
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public b(Parcel var1) {
        super();
        this.b = (c)var1.readParcelable(c.class.getClassLoader());
        switch (2.a[this.b.a.ordinal()]) {
            default: {
                return;
            }
            case 6: {
                this.c = var1.readLong();
                this.d = var1.readLong();
                return;
            }
            case 5: {
                this.c = var1.readInt();
                var2_2 = var1.readInt();
                ** GOTO lbl21
            }
            case 4: {
                this.c = Float.valueOf((float)var1.readFloat());
                var2_2 = Float.valueOf((float)var1.readFloat());
                ** GOTO lbl21
            }
            case 3: {
                this.c = var1.readDouble();
                var2_2 = var1.readDouble();
lbl21: // 3 sources:
                this.d = var2_2;
                return;
            }
            case 1: 
            case 2: 
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static b a(c var0_1, Object var1, Object var2_2) {
        block9 : {
            block10 : {
                block8 : {
                    if (var0_1.b.isInstance(var1)) break block8;
                    var6_3 = b.a;
                    var7_4 = "create failed, min dataType invalid";
                    break block9;
                }
                if (var0_1.b.isInstance(var2_2)) break block10;
                var6_3 = b.a;
                var7_4 = "create failed, max dataType invalid";
                break block9;
            }
            var3_5 = 2.a[var0_1.a.ordinal()];
            var4_6 = false;
            switch (var3_5) {
                default: {
                    var4_6 = false;
                    break;
                }
                case 6: {
                    var13_7 = (Long)var1 LCMP (Long)var2_2;
                    var4_6 = false;
                    if (var13_7 > 0) break;
                    ** GOTO lbl37
                }
                case 5: {
                    var11_8 = (Integer)var1;
                    var12_9 = (Integer)var2_2;
                    var4_6 = false;
                    if (var11_8 > var12_9) break;
                    ** GOTO lbl37
                }
                case 4: {
                    var10_10 = ((Float)var1).floatValue() FCMPG ((Float)var2_2).floatValue();
                    var4_6 = false;
                    if (var10_10 >= 0) break;
                    ** GOTO lbl37
                }
                case 3: {
                    var9_11 = (Double)var1 DCMPG (Double)var2_2;
                    var4_6 = false;
                    if (var9_11 >= 0) break;
lbl37: // 4 sources:
                    var4_6 = true;
                    break;
                }
                case 1: 
                case 2: 
            }
            if (var4_6) {
                var5_12 = new b();
                var5_12.b = var0_1;
                var5_12.c = var1;
                var5_12.d = var2_2;
                return var5_12;
            }
            var6_3 = b.a;
            var7_4 = "create failed, min >= max";
        }
        Log.d((String)var6_3, (String)var7_4);
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeParcelable((Parcelable)this.b, n2);
        switch (2.a[this.b.a.ordinal()]) {
            default: {
                return;
            }
            case 6: {
                parcel.writeLong(((Long)this.c).longValue());
                parcel.writeLong(((Long)this.d).longValue());
                return;
            }
            case 5: {
                parcel.writeInt(((Integer)this.c).intValue());
                parcel.writeInt(((Integer)this.d).intValue());
                return;
            }
            case 4: {
                parcel.writeFloat(((Float)this.c).floatValue());
                parcel.writeFloat(((Float)this.d).floatValue());
                return;
            }
            case 3: {
                parcel.writeDouble(((Double)this.c).doubleValue());
                parcel.writeDouble(((Double)this.d).doubleValue());
            }
            case 1: 
            case 2: 
        }
    }

}

