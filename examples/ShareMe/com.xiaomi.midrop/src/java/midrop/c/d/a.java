/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.ClassLoader
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package midrop.c.d;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import midrop.c.c.e;
import midrop.c.c.f;
import midrop.c.d.b;

public final class a
implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>(){

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new a(parcel);
        }
    };
    public ArrayList<midrop.c.f.a> a;
    public f b;
    public boolean c;
    public String d;

    public a() {
        this.a = new ArrayList();
        this.b = new f();
        this.c = true;
        this.m();
    }

    public a(Parcel parcel) {
        this.a = new ArrayList();
        this.b = new f();
        this.c = true;
        a.super.m();
        this.b = (f)parcel.readParcelable(f.class.getClassLoader());
        parcel.readTypedList(this.a, midrop.c.f.a.CREATOR);
    }

    public a(String string2, int n2, ArrayList<midrop.c.f.a> arrayList) {
        this.a = new ArrayList();
        this.b = new f();
        this.c = true;
        a.super.m();
        this.a = arrayList;
        if (TextUtils.isEmpty((CharSequence)string2)) {
            string2 = "";
        }
        this.b.b(b.a, string2);
        this.b.b(b.i, n2);
        this.a(0);
        long l2 = 0L;
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            l2 += ((midrop.c.f.a)iterator.next()).c;
        }
        this.a(l2);
    }

    private void m() {
        this.b.a(b.a, null);
        this.b.a(b.b, 0);
        this.b.a(b.d, 0L);
        this.b.a(b.e, 0L);
        this.b.a(b.f, 0L);
        this.b.a(b.g, 0L);
        this.b.a(b.c, null);
        this.b.a(b.h, 0L);
        this.b.a(b.i, -1);
    }

    public final midrop.c.f.a a() {
        try {
            midrop.c.f.a a2 = (midrop.c.f.a)this.a.get(this.c());
            return a2;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return null;
        }
    }

    public final boolean a(int n2) {
        return this.b.b(b.b, n2);
    }

    public final boolean a(long l2) {
        return this.b.b(b.d, l2);
    }

    public final boolean a(String string2) {
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            midrop.c.f.a a2 = (midrop.c.f.a)iterator.next();
            if (!TextUtils.equals((CharSequence)string2, (CharSequence)a2.g)) continue;
            long l2 = this.d();
            if (l2 >= a2.c) {
                this.a(l2 - a2.c);
            }
            iterator.remove();
            return true;
        }
        return false;
    }

    public final String b() {
        return (String)this.b.b(b.a);
    }

    public final boolean b(long l2) {
        return this.b.b(b.e, l2);
    }

    public final int c() {
        return (Integer)this.b.b(b.b);
    }

    public final boolean c(long l2) {
        return this.b.b(b.f, l2);
    }

    public final long d() {
        return (Long)this.b.b(b.d);
    }

    public final boolean d(long l2) {
        return this.b.b(b.g, l2);
    }

    public final int describeContents() {
        return 0;
    }

    public final long e() {
        return (Long)this.b.b(b.e);
    }

    public final String f() {
        return (String)this.b.b(b.c);
    }

    public final long g() {
        return (Long)this.b.b(b.f);
    }

    public final long h() {
        return (Long)this.b.b(b.g);
    }

    public final long i() {
        return (Long)this.b.b(b.h);
    }

    public final int j() {
        return (Integer)this.b.b(b.i);
    }

    public final int k() {
        ArrayList<midrop.c.f.a> arrayList = this.a;
        int n2 = 0;
        if (arrayList == null) {
            return 0;
        }
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            if (((midrop.c.f.a)iterator.next()).l) continue;
            ++n2;
        }
        return n2;
    }

    public final midrop.c.f.a l() {
        if (this.a == null) {
            return null;
        }
        for (midrop.c.f.a a2 : this.a) {
            if (a2.l) continue;
            return a2;
        }
        return null;
    }

    public final void writeToParcel(Parcel parcel, int n2) {
        parcel.writeParcelable((Parcelable)this.b, n2);
        parcel.writeTypedList(this.a);
    }

}

