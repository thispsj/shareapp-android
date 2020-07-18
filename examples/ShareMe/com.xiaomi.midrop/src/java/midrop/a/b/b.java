/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.IInterface
 *  android.os.RemoteException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  midrop.a.c.a.a.a
 */
package midrop.a.b;

import android.net.Uri;
import android.os.IInterface;
import android.os.RemoteException;
import com.xiaomi.midrop.b.g;
import java.util.List;
import midrop.a.b.a;
import midrop.a.c.m;
import midrop.c.d.e;

public interface b
extends IInterface {
    public int a() throws RemoteException;

    public int a(String var1) throws RemoteException;

    public int a(List<String> var1, String var2) throws RemoteException;

    public int a(a var1) throws RemoteException;

    public int a(e var1) throws RemoteException;

    public List<g> a(int var1, int var2) throws RemoteException;

    public void a(List<Uri> var1) throws RemoteException;

    public void a(m var1) throws RemoteException;

    public int b() throws RemoteException;

    public int b(a var1) throws RemoteException;

    public void b(List<Uri> var1) throws RemoteException;

    public midrop.c.d.a c() throws RemoteException;

    public midrop.a.c.a.a.a d() throws RemoteException;

    public boolean e() throws RemoteException;

    public boolean f() throws RemoteException;

    public boolean g() throws RemoteException;
}

