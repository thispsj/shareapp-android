/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  android.text.TextUtils
 *  io.a.a.a.a.b.i
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Enumeration
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Properties
 *  java.util.concurrent.Callable
 *  java.util.zip.ZipEntry
 *  java.util.zip.ZipFile
 */
package io.a.a.a;

import android.os.SystemClock;
import android.text.TextUtils;
import io.a.a.a.a.b.i;
import io.a.a.a.c;
import io.a.a.a.k;
import io.a.a.a.l;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

final class e
implements Callable<Map<String, k>> {
    final String a;

    e(String string2) {
        this.a = string2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static k a(ZipEntry zipEntry, ZipFile zipFile) {
        void var7_11;
        InputStream inputStream;
        block9 : {
            void var2_14;
            block10 : {
                block8 : {
                    inputStream = zipFile.getInputStream(zipEntry);
                    Properties properties = new Properties();
                    properties.load(inputStream);
                    String string2 = properties.getProperty("fabric-identifier");
                    String string3 = properties.getProperty("fabric-version");
                    String string4 = properties.getProperty("fabric-build-type");
                    if (TextUtils.isEmpty((CharSequence)string2) || TextUtils.isEmpty((CharSequence)string3)) break block8;
                    k k2 = new k(string2, string3, string4);
                    i.a((Closeable)inputStream);
                    return k2;
                }
                try {
                    StringBuilder stringBuilder = new StringBuilder("Invalid format of fabric file,");
                    stringBuilder.append(zipEntry.getName());
                    throw new IllegalStateException(stringBuilder.toString());
                }
                catch (Throwable throwable) {
                    break block9;
                }
                catch (IOException iOException) {
                    break block10;
                }
                catch (Throwable throwable) {
                    inputStream = null;
                    break block9;
                }
                catch (IOException iOException) {
                    inputStream = null;
                }
            }
            l l2 = c.a();
            StringBuilder stringBuilder = new StringBuilder("Error when parsing fabric properties ");
            stringBuilder.append(zipEntry.getName());
            l2.c("Fabric", stringBuilder.toString(), (Throwable)var2_14);
            i.a((Closeable)inputStream);
            return null;
        }
        i.a((Closeable)inputStream);
        throw var7_11;
    }

    private static Map<String, k> a() {
        HashMap hashMap;
        hashMap = new HashMap();
        try {
            Class.forName((String)"com.google.android.gms.ads.AdView");
            k k2 = new k("com.google.firebase.firebase-ads", "0.0.0", "binary");
            hashMap.put((Object)k2.a, (Object)k2);
            c.a().b("Fabric", "Found kit: com.google.firebase.firebase-ads");
        }
        catch (Exception exception) {}
        return hashMap;
    }

    private Map<String, k> b() throws Exception {
        HashMap hashMap;
        hashMap = new HashMap();
        ZipFile zipFile = new ZipFile(this.a);
        Enumeration enumeration = zipFile.entries();
        while (enumeration.hasMoreElements()) {
            k k2;
            ZipEntry zipEntry = (ZipEntry)enumeration.nextElement();
            if (!zipEntry.getName().startsWith("fabric/") || zipEntry.getName().length() <= 7 || (k2 = e.a(zipEntry, zipFile)) == null) continue;
            hashMap.put((Object)k2.a, (Object)k2);
            l l2 = c.a();
            Object[] arrobject = new Object[]{k2.a, k2.b};
            l2.b("Fabric", String.format((String)"Found kit:[%s] version:[%s]", (Object[])arrobject));
        }
        try {
            zipFile.close();
        }
        catch (IOException iOException) {}
        return hashMap;
    }

    public final /* synthetic */ Object call() throws Exception {
        HashMap hashMap = new HashMap();
        long l2 = SystemClock.elapsedRealtime();
        hashMap.putAll(e.a());
        hashMap.putAll(this.b());
        l l3 = c.a();
        StringBuilder stringBuilder = new StringBuilder("finish scanning in ");
        stringBuilder.append(SystemClock.elapsedRealtime() - l2);
        l3.b("Fabric", stringBuilder.toString());
        return hashMap;
    }
}

