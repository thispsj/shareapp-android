/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.xiaomi.midrop.send.apk;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.xiaomi.midrop.send.apk.FilePickApkListFragment;
import com.xiaomi.midrop.send.base.FilePickBaseTabFragment;
import com.xiaomi.midrop.util.ac;
import java.util.ArrayList;
import java.util.List;

public class FilePickApkTabFragment
extends FilePickBaseTabFragment {
    /*
     * Enabled aggressive block sorting
     */
    @Override
    protected final List<FilePickBaseTabFragment.a> a() {
        ArrayList arrayList;
        Object object;
        if (ac.c(this.getContext())) {
            arrayList = new ArrayList();
            Bundle bundle = new Bundle();
            bundle.putInt("fragment_apk_type", 1);
            arrayList.add(new Object(this.getResources().getString(2131689669), FilePickApkListFragment.class.getName(), bundle){
                String a;
                String b;
                Bundle c;
                {
                    this.a = string2;
                    this.b = string3;
                }
                {
                    this.a = string2;
                    this.b = string3;
                    this.c = bundle;
                }
            });
            Bundle bundle2 = new Bundle();
            bundle2.putInt("fragment_apk_type", 0);
            object = new /* invalid duplicate definition of identical inner class */;
        } else {
            arrayList = new ArrayList();
            Bundle bundle = new Bundle();
            bundle.putInt("fragment_apk_type", 0);
            arrayList.add(new /* invalid duplicate definition of identical inner class */);
            Bundle bundle3 = new Bundle();
            bundle3.putInt("fragment_apk_type", 1);
            object = new /* invalid duplicate definition of identical inner class */;
        }
        arrayList.add(object);
        return arrayList;
    }
}

