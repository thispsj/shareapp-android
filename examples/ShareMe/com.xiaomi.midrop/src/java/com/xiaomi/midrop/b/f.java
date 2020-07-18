/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class f
implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new Parcelable.Creator<f>(){

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new f(parcel);
        }
    };
    public String a;
    public String b;

    public f() {
    }

    public f(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    public final int describeContents() {
        return 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean equals(Object object) {
        String string2;
        String string3;
        if (object == null) {
            return false;
        }
        if (object instanceof f) {
            string2 = this.a;
            string3 = ((f)object).a;
            do {
                return TextUtils.equals((CharSequence)string2, (CharSequence)string3);
                break;
            } while (true);
        }
        if (!(object instanceof String)) return super.equals(object);
        string2 = this.a;
        string3 = (String)object;
        return TextUtils.equals((CharSequence)string2, (CharSequence)string3);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

}

