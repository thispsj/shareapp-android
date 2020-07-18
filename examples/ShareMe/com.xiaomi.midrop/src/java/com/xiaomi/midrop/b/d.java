/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.b;

import android.os.Parcel;
import android.os.Parcelable;

public final class d
implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>(){

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new d(parcel);
        }
    };
    public String a;
    public String b;
    public String c;
    public long d;
    public int e;
    private int f;

    public d() {
    }

    protected d(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readLong();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeLong(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
    }

}

