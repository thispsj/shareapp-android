/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Map
 */
package b.c.a.a;

import b.c.a.a.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class b
extends c {
    private static final String g = "b";
    Map<String, String> a = new HashMap();
    a b;

    private static c.k a(c.k.b b2, long l2, InputStream inputStream, c.k.a a2) {
        c.k k2 = new c.k(b2, null, l2, inputStream, a2);
        k2.a("Accept-Ranges", "bytes");
        return k2;
    }

    private static c.k a(c.k.b b2, String string2, String string3) {
        c.k k2 = new c.k(b2, string2, string3);
        k2.a("Accept-Ranges", "bytes");
        return k2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private c.k a(Map<String, String> map, final String string2) {
        block15 : {
            block14 : {
                try {
                    block16 : {
                        file = new File(string2);
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(file.getAbsolutePath());
                        stringBuilder.append(file.lastModified());
                        stringBuilder.append(file.length());
                        string4 = Integer.toHexString((int)stringBuilder.toString().hashCode());
                        l3 = -1L;
                        string3 = (String)map.get((Object)"range");
                        l5 = 0L;
                        if (string3 == null || !string3.startsWith("bytes=") || (n2 = (string3 = string3.substring(6)).indexOf(45)) <= 0) break block14;
                        l2 = Long.parseLong((String)string3.substring(0, n2));
                        n3 = n2 + 1;
                        try {
                            l3 = l6 = Long.parseLong((String)string3.substring(n3));
                            break block15;
                        }
                        catch (NumberFormatException numberFormatException2) {
                            numberFormatException = numberFormatException2;
                            break block16;
                        }
                        catch (NumberFormatException numberFormatException3) {
                            numberFormatException = numberFormatException3;
                            l2 = l5;
                        }
                    }
                    numberFormatException.printStackTrace();
                    break block15;
                }
                catch (IOException iOException) {
                    // empty catch block
                    ** GOTO lbl53
                }
            }
            l2 = l5;
        }
        l7 = file.length();
        if (string3 != null && l2 >= l5) {
            if (l2 >= l7) {
                k2 = b.a(c.k.b.m, "text/plain", "");
                stringBuilder = new StringBuilder("bytes 0-0/");
                stringBuilder.append(l7);
                k2.a("Content-Range", stringBuilder.toString());
                k2.a("ETag", string4);
                return k2;
            }
        } else {
            if (string4.equals(map.get((Object)"if-none-match"))) {
                return b.a(c.k.b.g, null, "");
            }
            b2 = c.k.b.a;
            fileInputStream = new FileInputStream(file);
            try {
                k3 = b.a(b2, l7, (InputStream)fileInputStream, new c.k.a(){

                    @Override
                    public final void a(long l2) {
                        if (b.this.b != null) {
                            b.this.b.a(string2, 0L, l2, l7);
                        }
                    }
                });
                k3.a("Content-Length", String.valueOf((long)l7));
                k3.a("ETag", string4);
                return k3;
            }
            catch (IOException iOException) {}
lbl53: // 2 sources:
            var5_31.printStackTrace();
            return b.a(c.k.b.j, "text/plain", "FORBIDDEN: Reading file failed.");
        }
        if (l3 < l5) {
            l3 = l7 - 1L;
        }
        if ((l4 = 1L + (l3 - l2)) >= l5) {
            l5 = l4;
        }
        fileInputStream = new FileInputStream(file);
        fileInputStream.skip(l2);
        b3 = c.k.b.e;
        l8 = l3;
        l9 = l2;
        l10 = l2;
        a2 = new c.k.a(){

            @Override
            public final void a(long l2) {
                if (b.this.b != null) {
                    b.this.b.a(string2, l9, l2, l7);
                }
            }
        };
        k2 = b.a(b3, l5, (InputStream)fileInputStream, a2);
        k2.a("Content-Length", String.valueOf((long)l5));
        stringBuilder = new StringBuilder("bytes ");
        stringBuilder.append(l10);
        stringBuilder.append("-");
        stringBuilder.append(l8);
        stringBuilder.append("/");
        stringBuilder.append(l7);
        k2.a("Content-Range", stringBuilder.toString());
        k2.a("ETag", string4);
        return k2;
    }

    public final int a() {
        return super.d();
    }

    @Override
    public final c.k a(c.i i2) {
        String string2;
        c.k k2;
        Map<String, String> map = i2.c();
        String string3 = i2.d();
        Map map2 = Collections.unmodifiableMap(map);
        new StringBuilder("****************Header Info****************\n").append((Object)map2);
        String.format((String)"[Request url:%s]", (Object[])new Object[]{string3});
        String string4 = string3.trim().replace(File.separatorChar, '/');
        if (string4.indexOf(63) >= 0) {
            string4 = string4.substring(0, string4.indexOf(63));
        }
        if ((string2 = (String)this.a.get((Object)string4)) != null && (k2 = b.super.a((Map<String, String>)map2, string2)) != null) {
            return k2;
        }
        return b.a(c.k.b.k, "text/plain", "Error 404, file not found.");
    }

}

