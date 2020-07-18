/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.xiaomi.midrop.send.img;

import android.content.Context;
import android.content.res.Resources;
import com.xiaomi.midrop.send.base.FilePickBaseTabFragment;
import com.xiaomi.midrop.send.img.FilePickImageGroupFragment;
import com.xiaomi.midrop.send.img.FilePickImageTimeFragment;
import com.xiaomi.midrop.util.ac;
import java.util.ArrayList;
import java.util.List;

public class FilePickImageFragment
extends FilePickBaseTabFragment {
    @Override
    protected final List<FilePickBaseTabFragment.a> a() {
        if (ac.c(this.getContext())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Object(this.getResources().getString(2131689675), FilePickImageGroupFragment.class.getName()){
                String a;
                String b;
                android.os.Bundle c;
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
            arrayList.add(new /* invalid duplicate definition of identical inner class */);
            return arrayList;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new /* invalid duplicate definition of identical inner class */);
        arrayList.add(new /* invalid duplicate definition of identical inner class */);
        return arrayList;
    }
}

