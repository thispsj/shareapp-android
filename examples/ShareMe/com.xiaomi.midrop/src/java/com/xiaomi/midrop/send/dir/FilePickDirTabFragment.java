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
package com.xiaomi.midrop.send.dir;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.xiaomi.midrop.send.base.FilePickBaseTabFragment;
import com.xiaomi.midrop.send.contacts.ContactPickFragment;
import com.xiaomi.midrop.send.dir.FilePickDirectoryFragment;
import com.xiaomi.midrop.send.dir.FilePickExtraFileFragment;
import com.xiaomi.midrop.util.ac;
import java.util.ArrayList;
import java.util.List;

public class FilePickDirTabFragment
extends FilePickBaseTabFragment {
    private int c;

    public static FilePickDirTabFragment a(int n2) {
        FilePickDirTabFragment filePickDirTabFragment = new FilePickDirTabFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("directory_type", n2 - 1);
        filePickDirTabFragment.setArguments(bundle);
        return filePickDirTabFragment;
    }

    @Override
    protected final List<FilePickBaseTabFragment.a> a() {
        if (ac.c(this.getContext())) {
            ArrayList arrayList = new ArrayList();
            Bundle bundle = new Bundle();
            bundle.putInt("TypeExtraFile", 9);
            arrayList.add(new Object(this.getResources().getString(2131689665), ContactPickFragment.class.getName(), bundle){
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
            arrayList.add(new /* invalid duplicate definition of identical inner class */);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("TypeExtraFile", 8);
            arrayList.add(new /* invalid duplicate definition of identical inner class */);
            Bundle bundle3 = new Bundle();
            bundle3.putInt("TypeExtraFile", 5);
            arrayList.add(new /* invalid duplicate definition of identical inner class */);
            Bundle bundle4 = new Bundle();
            bundle4.putInt("directory_type", this.c);
            arrayList.add(new /* invalid duplicate definition of identical inner class */);
            return arrayList;
        }
        ArrayList arrayList = new ArrayList();
        Bundle bundle = new Bundle();
        bundle.putInt("directory_type", this.c);
        arrayList.add(new /* invalid duplicate definition of identical inner class */);
        Bundle bundle5 = new Bundle();
        bundle5.putInt("TypeExtraFile", 5);
        arrayList.add(new /* invalid duplicate definition of identical inner class */);
        Bundle bundle6 = new Bundle();
        bundle6.putInt("TypeExtraFile", 8);
        arrayList.add(new /* invalid duplicate definition of identical inner class */);
        Bundle bundle7 = new Bundle();
        bundle7.putInt("TypeExtraFile", 9);
        arrayList.add(new /* invalid duplicate definition of identical inner class */);
        arrayList.add(new /* invalid duplicate definition of identical inner class */);
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void onCreate(Bundle bundle) {
        block4 : {
            int n2;
            block3 : {
                block2 : {
                    if (bundle == null) break block2;
                    n2 = bundle.getInt("directory_type");
                    break block3;
                }
                if (this.getArguments() == null) break block4;
                n2 = this.getArguments().getInt("directory_type");
            }
            this.c = n2;
        }
        super.onCreate(bundle);
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("directory_type", this.c);
    }
}

