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
package midrop.a.c;

import android.net.Uri;
import android.os.IInterface;
import android.os.RemoteException;
import com.xiaomi.midrop.b.g;
import java.util.List;
import midrop.a.c.a.a.a;
import midrop.a.c.m;
import midrop.c.a.e;

public interface k
extends IInterface {
    public int a(String var1, boolean var2) throws RemoteException;

    public int a(List<String> var1, String var2) throws RemoteException;

    public int a(midrop.a.b.a var1) throws RemoteException;

    public int a(midrop.c.d.e var1) throws RemoteException;

    public List<g> a(int var1, int var2) throws RemoteException;

    public void a() throws RemoteException;

    public void a(String var1) throws RemoteException;

    public void a(List<Uri> var1) throws RemoteException;

    public void a(m var1) throws RemoteException;

    public void a(e var1) throws RemoteException;

    public int b(String var1) throws RemoteException;

    public int b(midrop.a.b.a var1) throws RemoteException;

    public a b() throws RemoteException;

    public void b(List<Uri> var1) throws RemoteException;

    public a c(String var1) throws RemoteException;

    public void c() throws RemoteException;

    public void d() throws RemoteException;

    public List<a> e() throws RemoteException;

    public midrop.c.d.a f() throws RemoteException;

    public void g() throws RemoteException;

    public boolean h() throws RemoteException;

    public boolean i() throws RemoteException;

    public boolean j() throws RemoteException;

    public void k() throws RemoteException;

    public void l() throws RemoteException;
}

