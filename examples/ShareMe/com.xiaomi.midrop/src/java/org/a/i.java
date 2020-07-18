/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.text.SimpleDateFormat
 *  java.util.Date
 *  java.util.Locale
 *  org.a.c
 */
package org.a;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.a.ad;
import org.a.aj;
import org.a.c;

public class i
extends c {
    private String b;
    private String c = i.class.getSimpleName();

    public i(aj aj2, String string2) {
        super(aj2);
        this.b = string2;
    }

    /*
     * Enabled aggressive block sorting
     */
    final String a(File file) {
        String string2;
        String string3;
        StringBuilder stringBuilder = new StringBuilder();
        if (!file.exists()) {
            string3 = this.c;
            string2 = "makeLsString had nonexistent file";
        } else {
            String string4 = file.getName();
            if (!string4.contains((CharSequence)"*") && !string4.contains((CharSequence)"/")) {
                String string5 = file.isDirectory() ? "drwxr-xr-x 1 owner group" : "-rw-r--r-- 1 owner group";
                stringBuilder.append(string5);
                String string6 = Long.toString((long)file.length());
                int n2 = 13 - string6.length();
                do {
                    int n3 = n2 - 1;
                    if (n2 <= 0) break;
                    stringBuilder.append(' ');
                    n2 = n3;
                } while (true);
                stringBuilder.append(string6);
                long l2 = file.lastModified();
                SimpleDateFormat simpleDateFormat = System.currentTimeMillis() - l2 > -1627869184L ? new SimpleDateFormat(" MMM dd HH:mm ", Locale.US) : new SimpleDateFormat(" MMM dd  yyyy ", Locale.US);
                stringBuilder.append(simpleDateFormat.format(new Date(file.lastModified())));
                stringBuilder.append(string4);
                stringBuilder.append("\r\n");
                return stringBuilder.toString();
            }
            string3 = this.c;
            string2 = "Filename omitted due to disallowed character";
        }
        com.xiaomi.miftp.c.c.d(string3, string2);
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void run() {
        block7 : {
            block9 : {
                block5 : {
                    block8 : {
                        block6 : {
                            block4 : {
                                var1_1 = ad.b(this.b, false);
                                var2_2 = this.c;
                                var3_3 = new StringBuilder("LIST parameter: ");
                                var3_3.append(var1_1);
                                com.xiaomi.miftp.c.c.a(var2_2, var3_3.toString());
                                while (var1_1.startsWith("-")) {
                                    var13_5 = this.c;
                                    var14_4 = new StringBuilder("LIST is skipping dashed arg ");
                                    var14_4.append(var1_1);
                                    com.xiaomi.miftp.c.c.a(var13_5, var14_4.toString());
                                    var1_1 = ad.b(var1_1, false);
                                }
                                if (!"".equals((Object)var1_1)) break block4;
                                var6_6 = this.a.f;
                                break block5;
                            }
                            if (!var1_1.contains((CharSequence)"*")) break block6;
                            var8_7 = "550 LIST does not support wildcards\r\n";
                            break block7;
                        }
                        var5_8 = new File(this.a.f, var1_1);
                        if (!i.b((File)var5_8)) break block8;
                        var8_7 = "450 Listing target violates chroot\r\n";
                        break block7;
                    }
                    var6_6 = var5_8;
                }
                if (!var6_6.isDirectory()) break block9;
                var7_9 = new StringBuilder();
                var8_7 = this.a(var7_9, var6_6);
                if (var8_7 != null) break block7;
                var12_10 = var7_9.toString();
                ** GOTO lbl-1000
            }
            var12_10 = this.a(var6_6);
            if (var12_10 == null) {
                var8_7 = "450 Couldn't list that file\r\n";
            } else lbl-1000: // 2 sources:
            {
                var8_7 = this.a(var12_10);
            }
        }
        if (var8_7 != null) {
            this.a.b(var8_7);
            var9_11 = this.c;
            var10_12 = new StringBuilder("LIST failed with: ");
            var10_12.append(var8_7);
            com.xiaomi.miftp.c.c.a(var9_11, var10_12.toString());
            return;
        }
        com.xiaomi.miftp.c.c.a(this.c, "LIST completed OK");
    }
}

