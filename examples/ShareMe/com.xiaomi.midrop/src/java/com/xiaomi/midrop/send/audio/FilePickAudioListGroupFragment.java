/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 *  java.text.Collator
 *  java.util.Comparator
 *  java.util.List
 *  java.util.TreeMap
 */
package com.xiaomi.midrop.send.audio;

import android.content.Context;
import android.os.Bundle;
import com.xiaomi.midrop.b.a.e;
import com.xiaomi.midrop.b.a.f;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.send.base.FilePickBaseGroupListFragment;
import com.xiaomi.midrop.send.base.a;
import com.xiaomi.midrop.sender.c.f;
import java.text.Collator;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class FilePickAudioListGroupFragment
extends FilePickBaseGroupListFragment<TreeMap<String, List<g>>> {
    @Override
    protected final a a() {
        return new a(8);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    protected final /* synthetic */ List a(Object var1) {
        block8 : {
            block6 : {
                block7 : {
                    var2_2 = (TreeMap)var1;
                    var3_3 = this.d;
                    var4_4 = var3_3.hashCode();
                    if (var4_4 == -503914399) break block6;
                    if (var4_4 == -159518692) break block7;
                    if (var4_4 != 41330404 || !var3_3.equals((Object)"param_type_singers")) ** GOTO lbl-1000
                    var5_5 = 0;
                    break block8;
                }
                if (!var3_3.equals((Object)"param_type_album")) ** GOTO lbl-1000
                var5_5 = 1;
                break block8;
            }
            if (var3_3.equals((Object)"param_type_folder")) {
                var5_5 = 2;
            } else lbl-1000: // 3 sources:
            {
                var5_5 = -1;
            }
        }
        switch (var5_5) {
            default: {
                var6_6 = null;
                return this.a((TreeMap<String, List<g>>)var2_2, var6_6);
            }
            case 2: {
                var6_6 = com.xiaomi.midrop.sender.c.f.b();
                return this.a((TreeMap<String, List<g>>)var2_2, var6_6);
            }
            case 0: 
            case 1: 
        }
        var6_6 = new Comparator<String>(Collator.getInstance()){
            final /* synthetic */ Collator a;
            {
                this.a = collator;
            }

            public final /* synthetic */ int compare(Object object, Object object2) {
                String string2 = (String)object;
                String string3 = (String)object2;
                return this.a.getCollationKey(string2).compareTo(this.a.getCollationKey(string3));
            }
        };
        return this.a((TreeMap<String, List<g>>)var2_2, var6_6);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    protected final com.xiaomi.midrop.b.a.a<TreeMap<String, List<g>>> c() {
        block9 : {
            block7 : {
                block8 : {
                    var1_1 = this.d;
                    var2_2 = var1_1.hashCode();
                    if (var2_2 == -503914399) break block7;
                    if (var2_2 == -159518692) break block8;
                    if (var2_2 != 41330404 || !var1_1.equals((Object)"param_type_singers")) ** GOTO lbl-1000
                    var3_3 = 0;
                    break block9;
                }
                if (!var1_1.equals((Object)"param_type_album")) ** GOTO lbl-1000
                var3_3 = 1;
                break block9;
            }
            if (var1_1.equals((Object)"param_type_folder")) {
                var3_3 = 2;
            } else lbl-1000: // 3 sources:
            {
                var3_3 = -1;
            }
        }
        switch (var3_3) {
            default: {
                return null;
            }
            case 2: {
                return new com.xiaomi.midrop.b.a.g(this.getContext());
            }
            case 1: {
                return new e(this.getContext());
            }
            case 0: 
        }
        return new f(this.getContext());
    }

    public void onCreate(Bundle bundle) {
        if (this.getArguments() != null) {
            this.d = this.getArguments().getString("param_type");
        }
        super.onCreate(bundle);
    }
}

