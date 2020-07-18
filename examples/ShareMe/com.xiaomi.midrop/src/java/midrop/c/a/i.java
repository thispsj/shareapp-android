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
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  midrop.c.a.b.c
 */
package midrop.c.a;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import midrop.c.a.a;
import midrop.c.a.b.c;
import midrop.c.a.e;
import midrop.c.a.g;
import midrop.c.a.h;
import midrop.c.a.j;
import midrop.c.c.f;

public class i
implements Parcelable {
    public static final Parcelable.Creator<i> CREATOR = new Parcelable.Creator<i>(){

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new i(parcel);
        }
    };
    public e a;
    public c b;
    public f c;
    public Map<String, a> d;
    private Map<String, g> e;
    private Map<String, midrop.c.c.e> f;

    public i() {
        this.b = new c();
        this.c = new f();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new HashMap();
        this.c.a(j.a, null);
        this.c.a(j.b, null);
        this.c.a(j.c, null);
    }

    public i(Parcel parcel) {
        this.b = new c();
        this.c = new f();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new HashMap();
        i.super.a(parcel);
    }

    private void a(Parcel parcel) {
        c c2 = new c();
        String string2 = parcel.readString();
        if (!c2.a(string2)) {
            c2 = null;
        }
        this.b = c2;
        this.c = (f)parcel.readParcelable(f.class.getClassLoader());
        int n2 = parcel.readInt();
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.a((a)parcel.readParcelable(a.class.getClassLoader()));
        }
        int n4 = parcel.readInt();
        for (int i3 = 0; i3 < n4; ++i3) {
            g g2 = (g)parcel.readParcelable(g.class.getClassLoader());
            g2.a = this;
            this.e.put((Object)((String)g2.b.b(h.a)), (Object)g2);
        }
        int n5 = parcel.readInt();
        while (n3 < n5) {
            this.a((midrop.c.c.e)parcel.readParcelable(midrop.c.c.e.class.getClassLoader()));
            ++n3;
        }
    }

    public final String a() {
        return (String)this.c.b(j.b);
    }

    public final void a(a a2) {
        a2.a = this;
        this.d.put((Object)a2.a(), (Object)a2);
    }

    public final void a(midrop.c.c.e e2) {
        this.f.put((Object)e2.d, (Object)e2);
    }

    public final boolean a(String string2) {
        return this.c.b(j.a, string2);
    }

    public final boolean b(String string2) {
        return this.c.b(j.b, string2);
    }

    public final midrop.c.c.e c(String string2) {
        return (midrop.c.c.e)this.f.get((Object)string2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeString(this.b.toString());
        parcel.writeParcelable((Parcelable)this.c, n2);
        parcel.writeInt(this.d.size());
        Iterator iterator = this.d.values().iterator();
        while (iterator.hasNext()) {
            parcel.writeParcelable((Parcelable)((a)iterator.next()), n2);
        }
        parcel.writeInt(this.e.size());
        Iterator iterator2 = this.e.values().iterator();
        while (iterator2.hasNext()) {
            parcel.writeParcelable((Parcelable)((g)iterator2.next()), n2);
        }
        parcel.writeInt(this.f.size());
        Iterator iterator3 = this.f.values().iterator();
        while (iterator3.hasNext()) {
            parcel.writeParcelable((Parcelable)((midrop.c.c.e)iterator3.next()), n2);
        }
    }

}

