/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.a.c
 */
package org.a;

import java.io.File;
import org.a.ad;
import org.a.aj;
import org.a.c;
import org.a.i;

public final class k
extends c {
    private static final String b = i.class.getSimpleName();
    private String c;

    public k(aj aj2, String string2) {
        super(aj2);
        this.c = string2;
    }

    /*
     * Enabled aggressive block sorting
     */
    final String a(File file) {
        String string2;
        String string3;
        if (!file.exists()) {
            string2 = b;
            string3 = "makeLsString had nonexistent file";
        } else {
            String string4 = file.getName();
            if (!string4.contains((CharSequence)"*") && !string4.contains((CharSequence)"/")) {
                String string5 = b;
                StringBuilder stringBuilder = new StringBuilder("Filename: ");
                stringBuilder.append(string4);
                com.xiaomi.miftp.c.c.a(string5, stringBuilder.toString());
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string4);
                stringBuilder2.append("\r\n");
                return stringBuilder2.toString();
            }
            string2 = b;
            string3 = "Filename omitted due to disallowed character";
        }
        com.xiaomi.miftp.c.c.d(string2, string3);
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final void run() {
        block7 : {
            block10 : {
                block5 : {
                    block9 : {
                        block8 : {
                            block6 : {
                                block4 : {
                                    var1_1 = ad.b(this.c, false);
                                    if (var1_1.startsWith("-")) {
                                        var1_1 = "";
                                    }
                                    if (!"".equals((Object)var1_1)) break block4;
                                    var3_2 = this.a.f;
                                    break block5;
                                }
                                if (!var1_1.contains((CharSequence)"*")) break block6;
                                var5_3 = "550 NLST does not support wildcards\r\n";
                                break block7;
                            }
                            var2_4 = new File(this.a.f, var1_1);
                            if (!k.b((File)var2_4)) break block8;
                            var5_3 = "450 Listing target violates chroot\r\n";
                            break block7;
                        }
                        if (!var2_4.isFile()) break block9;
                        var5_3 = "550 NLST for regular files is unsupported\r\n";
                        break block7;
                    }
                    var3_2 = var2_4;
                }
                if (!var3_2.isDirectory()) break block10;
                var4_5 = new StringBuilder();
                var5_3 = this.a(var4_5, var3_2);
                if (var5_3 != null) break block7;
                var9_6 = var4_5.toString();
                ** GOTO lbl-1000
            }
            var9_6 = this.a(var3_2);
            if (var9_6 == null) {
                var5_3 = "450 Couldn't list that file\r\n";
            } else lbl-1000: // 2 sources:
            {
                var5_3 = this.a(var9_6);
            }
        }
        if (var5_3 != null) {
            this.a.b(var5_3);
            var6_7 = k.b;
            var7_8 = new StringBuilder("NLST failed with: ");
            var7_8.append(var5_3);
            com.xiaomi.miftp.c.c.a(var6_7, var7_8.toString());
            return;
        }
        com.xiaomi.miftp.c.c.a(k.b, "NLST completed OK");
    }
}

