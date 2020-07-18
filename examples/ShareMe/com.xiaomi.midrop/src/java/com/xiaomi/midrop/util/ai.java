/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.storage.StorageManager
 *  android.text.TextUtils
 *  java.io.File
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Method
 *  java.util.ArrayList
 *  java.util.List
 */
package com.xiaomi.midrop.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import com.xiaomi.midrop.b.e;
import com.xiaomi.midrop.util.Locale.b;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class ai {
    public static List<e> a(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ai.d(context);
        }
        return ai.c(context);
    }

    public static String b(Context context) {
        String string2 = "";
        for (e e2 : ai.a(context)) {
            if (!e2.a() || !e2.e && !e2.h || TextUtils.equals((CharSequence)e2.b(), (CharSequence)Environment.getExternalStorageDirectory().getAbsolutePath())) continue;
            string2 = e2.b();
            break;
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static List<e> c(Context context) {
        ArrayList arrayList;
        block5 : {
            int n2;
            int n3;
            Object[] arrobject;
            Context context2 = context;
            StorageManager storageManager = (StorageManager)context2.getSystemService("storage");
            arrayList = new ArrayList();
            try {
                Method method = StorageManager.class.getMethod("getVolumeList", new Class[0]);
                n3 = 1;
                method.setAccessible((boolean)n3);
                arrobject = (Object[])method.invoke((Object)storageManager, new Object[0]);
                if (arrobject == null) break block5;
                n2 = arrobject.length;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                break block5;
            }
            for (int i2 = 0; i2 < n2; ++i2) {
                Object object = arrobject[i2];
                String string2 = (String)object.getClass().getMethod("getPath", new Class[0]).invoke(object, new Object[0]);
                File file = new File(string2);
                if (file.exists() && file.isDirectory() && file.canWrite()) {
                    Class[] arrclass = new Class[n3];
                    arrclass[0] = String.class;
                    Method method = StorageManager.class.getMethod("getVolumeState", arrclass);
                    Object[] arrobject2 = new Object[n3];
                    arrobject2[0] = string2;
                    String string3 = (String)method.invoke((Object)storageManager, arrobject2);
                    Class class_ = object.getClass();
                    Class[] arrclass2 = new Class[n3];
                    arrclass2[0] = Context.class;
                    Method method2 = class_.getMethod("getDescription", arrclass2);
                    Object[] arrobject3 = new Object[n3];
                    arrobject3[0] = context2;
                    String string4 = (String)method2.invoke(object, arrobject3);
                    boolean bl = (Boolean)object.getClass().getMethod("isPrimary", new Class[0]).invoke(object, new Object[0]);
                    if (!bl || string2.equalsIgnoreCase(Environment.getExternalStorageDirectory().getPath())) {
                        String string5 = (String)object.getClass().getMethod("getUuid", new Class[0]).invoke(object, new Object[0]);
                        boolean bl2 = (Boolean)object.getClass().getMethod("isRemovable", new Class[0]).invoke(object, new Object[0]);
                        e e2 = new e(string2, string4, string3);
                        e2.c = bl;
                        e2.d = string5;
                        n3 = 1;
                        e2.g = n3;
                        e2.h = bl2;
                        arrayList.add((Object)e2);
                    }
                }
                context2 = context;
            }
        }
        arrayList.trimToSize();
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static List<e> d(Context context) {
        ArrayList arrayList;
        block8 : {
            StorageManager storageManager = (StorageManager)context.getSystemService("storage");
            arrayList = new ArrayList();
            try {
                Method method = StorageManager.class.getMethod("getVolumes", new Class[0]);
                method.setAccessible(true);
                List list = (List)method.invoke((Object)storageManager, new Object[0]);
                if (list == null) break block8;
                for (Object object : list) {
                    e e2;
                    block9 : {
                        String string2;
                        block11 : {
                            block10 : {
                                int n2 = (Integer)object.getClass().getMethod("getType", new Class[0]).invoke(object, new Object[0]);
                                File file = (File)object.getClass().getMethod("getPath", new Class[0]).invoke(object, new Object[0]);
                                if (file == null) continue;
                                File file2 = new File(file.getPath());
                                if (n2 != 0 && n2 != 2 || !file2.exists() || !file2.isDirectory()) continue;
                                int n3 = (Integer)object.getClass().getMethod("getState", new Class[0]).invoke(object, new Object[0]);
                                Class class_ = Class.forName((String)"android.os.storage.VolumeInfo");
                                Class[] arrclass = new Class[]{Integer.TYPE};
                                Method method2 = class_.getMethod("getEnvironmentForState", arrclass);
                                Object[] arrobject = new Object[]{n3};
                                String string3 = (String)method2.invoke((Object)class_, arrobject);
                                String string4 = (String)object.getClass().getMethod("getDescription", new Class[0]).invoke(object, new Object[0]);
                                String string5 = (String)object.getClass().getMethod("getFsUuid", new Class[0]).invoke(object, new Object[0]);
                                e2 = new e(file2.getPath(), string4, string3);
                                boolean bl = n2 == 2;
                                e2.c = bl;
                                e2.d = string5;
                                e2.g = e2.c ? true : (Boolean)object.getClass().getMethod("isVisible", new Class[0]).invoke(object, new Object[0]);
                                Object object2 = object.getClass().getMethod("getDisk", new Class[0]).invoke(object, new Object[0]);
                                if (object2 == null) break block9;
                                Class class_2 = Class.forName((String)"android.os.storage.DiskInfo");
                                e2.e = (Boolean)class_2.getMethod("isSd", new Class[0]).invoke(object2, new Object[0]);
                                e2.f = (Boolean)class_2.getMethod("isUsb", new Class[0]).invoke(object2, new Object[0]);
                                if (!e2.f) break block10;
                                string2 = b.a().b(2131689954);
                                break block11;
                            }
                            if (!e2.e) break block9;
                            string2 = b.a().b(2131689953);
                        }
                        e2.b = string2;
                    }
                    if (e2.c && e2.b() != null && "mounted".equals((Object)Environment.getExternalStorageState())) {
                        e2.b = b.a().b(2131689735);
                        String string6 = Environment.getExternalStorageDirectory().getPath();
                        if (!e2.b().equalsIgnoreCase(string6)) {
                            e2.a = string6;
                        }
                    }
                    arrayList.add((Object)e2);
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        arrayList.trimToSize();
        return arrayList;
    }
}

