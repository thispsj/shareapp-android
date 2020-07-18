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
import java.util.List;
import midrop.a.c.a.a.a;

public interface m
extends IInterface {
    public List<Uri> a(int var1, int var2) throws RemoteException;

    public void a(String var1) throws RemoteException;

    public void a(String var1, String var2, boolean var3, int var4, int var5, long var6, long var8, long var10) throws RemoteException;

    public void a(String var1, a var2) throws RemoteException;

    public void a(List<String> var1) throws RemoteException;
}

