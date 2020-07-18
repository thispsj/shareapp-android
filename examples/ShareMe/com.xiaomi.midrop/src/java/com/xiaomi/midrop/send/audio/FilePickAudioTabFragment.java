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
package com.xiaomi.midrop.send.audio;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.xiaomi.midrop.send.audio.FilePickAudioCommomFragment;
import com.xiaomi.midrop.send.audio.FilePickAudioListGroupFragment;
import com.xiaomi.midrop.send.base.FilePickBaseTabFragment;
import com.xiaomi.midrop.util.ac;
import java.util.ArrayList;
import java.util.List;

public class FilePickAudioTabFragment
extends FilePickBaseTabFragment {
    /*
     * Enabled aggressive block sorting
     */
    @Override
    protected final List<FilePickBaseTabFragment.a> a() {
        Object object;
        ArrayList arrayList;
        if (ac.c(this.getContext())) {
            arrayList = new ArrayList();
            Bundle bundle = new Bundle();
            bundle.putString("param_type", "param_type_folder");
            arrayList.add(new Object(this.getResources().getString(2131689678), FilePickAudioListGroupFragment.class.getName(), bundle){
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
            bundle2.putString("param_type", "param_type_album");
            arrayList.add(new /* invalid duplicate definition of identical inner class */);
            Bundle bundle3 = new Bundle();
            bundle3.putString("param_type", "param_type_singers");
            arrayList.add(new /* invalid duplicate definition of identical inner class */);
            object = new /* invalid duplicate definition of identical inner class */;
        } else {
            arrayList = new ArrayList();
            arrayList.add(new /* invalid duplicate definition of identical inner class */);
            Bundle bundle = new Bundle();
            bundle.putString("param_type", "param_type_singers");
            arrayList.add(new /* invalid duplicate definition of identical inner class */);
            Bundle bundle4 = new Bundle();
            bundle4.putString("param_type", "param_type_album");
            arrayList.add(new /* invalid duplicate definition of identical inner class */);
            Bundle bundle5 = new Bundle();
            bundle5.putString("param_type", "param_type_folder");
            object = new /* invalid duplicate definition of identical inner class */;
        }
        arrayList.add(object);
        return arrayList;
    }
}

