/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaMetadataRetriever
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.xiaomi.midrop.util.al
 *  java.io.File
 *  java.io.FilenameFilter
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.HashSet
 *  java.util.List
 */
package com.xiaomi.midrop.util;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.midrop.sender.c.f;
import com.xiaomi.midrop.util.al;
import com.xiaomi.midrop.util.d;
import com.xiaomi.midrop.util.g;
import com.xiaomi.midrop.util.j;
import com.xiaomi.midrop.util.p;
import com.xiaomi.midrop.util.y;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public final class z {
    public static List<com.xiaomi.midrop.b.g> a(Context context, int n2) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(z.a(d.a, n2));
        arrayList.addAll(z.a(d.b(context), n2));
        ArrayList arrayList2 = new ArrayList();
        HashSet hashSet = new HashSet();
        for (com.xiaomi.midrop.b.g g2 : arrayList) {
            if (hashSet.contains((Object)g2.i)) continue;
            arrayList2.add((Object)g2);
            hashSet.add((Object)g2.i);
        }
        Collections.sort((List)arrayList2, (Comparator)new Comparator<com.xiaomi.midrop.b.g>(){

            public final /* synthetic */ int compare(Object object, Object object2) {
                com.xiaomi.midrop.b.g g2 = (com.xiaomi.midrop.b.g)object;
                return Long.valueOf((long)((com.xiaomi.midrop.b.g)object2).w).compareTo(Long.valueOf((long)g2.w));
            }
        });
        return arrayList2;
    }

    private static List<com.xiaomi.midrop.b.g> a(String string2) {
        ArrayList arrayList = new ArrayList();
        File file = new File(string2);
        if (!file.exists()) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        File[] arrfile = file.listFiles((FilenameFilter)new al(string2, y.j()));
        if (arrfile != null) {
            for (File file2 : arrfile) {
                com.xiaomi.midrop.b.g g2 = new com.xiaomi.midrop.b.g();
                if (file2.isDirectory()) {
                    g2.k = file2.getName();
                    g2.i = file2.getPath();
                    g2.h = Uri.fromFile((File)new File(g2.i)).toString();
                    g2.w = file2.lastModified() / 1000L;
                    arrayList2.add((Object)g2);
                    continue;
                }
                g2.k = file2.getName();
                g2.i = file2.getPath();
                g2.h = Uri.fromFile((File)file2).toString();
                g2.w = file2.lastModified() / 1000L;
                g2.l = file2.length();
                arrayList3.add((Object)g2);
            }
        }
        Collections.sort((List)arrayList2, f.a());
        Collections.sort((List)arrayList3, f.a());
        arrayList.addAll((Collection)arrayList2);
        arrayList.addAll((Collection)arrayList3);
        return arrayList;
    }

    public static List<com.xiaomi.midrop.b.g> a(String string2, int n2) {
        HashSet<String> hashSet;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return arrayList;
        }
        switch (n2) {
            default: {
                return z.a(string2);
            }
            case 4: {
                hashSet = g.h;
                break;
            }
            case 3: {
                hashSet = g.i;
                break;
            }
            case 2: {
                hashSet = g.l;
                break;
            }
            case 1: {
                hashSet = g.j;
            }
        }
        return z.a(string2, hashSet, n2);
    }

    private static List<com.xiaomi.midrop.b.g> a(String string2, HashSet<String> hashSet, int n2) {
        ArrayList arrayList = new ArrayList();
        File file = new File(string2);
        if (!file.exists()) {
            return arrayList;
        }
        File[] arrfile = file.listFiles();
        if (arrfile == null) {
            return arrayList;
        }
        for (File file2 : arrfile) {
            if (!hashSet.contains((Object)j.d(file2.getName()))) continue;
            com.xiaomi.midrop.b.g g2 = new com.xiaomi.midrop.b.g();
            g2.k = file2.getName();
            g2.i = file2.getAbsolutePath();
            g2.l = file2.length();
            g2.w = file2.lastModified() / 1000L;
            g2.h = Uri.fromFile((File)file2).toString();
            if (n2 == 3) {
                try {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(g2.i);
                    g2.y = mediaMetadataRetriever.extractMetadata(2);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            arrayList.add((Object)g2);
        }
        return arrayList;
    }

    public static void a(String string2, List<com.xiaomi.midrop.b.g> list) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return;
        }
        File file = new File(string2);
        if (!file.exists()) {
            return;
        }
        File[] arrfile = y.j() ? file.listFiles() : file.listFiles((FilenameFilter)new p());
        if (arrfile != null) {
            for (File file2 : arrfile) {
                if (file2.isDirectory()) {
                    z.a(file2.getAbsolutePath(), list);
                    continue;
                }
                com.xiaomi.midrop.b.g g2 = new com.xiaomi.midrop.b.g();
                g2.k = file2.getName();
                g2.i = file2.getAbsolutePath();
                g2.l = file2.length();
                g2.w = file2.lastModified();
                g2.h = Uri.fromFile((File)file2).toString();
                list.add((Object)g2);
            }
        }
    }

}

