/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentProvider
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.database.Cursor
 *  android.net.Uri
 *  android.os.Bundle
 *  java.lang.Boolean
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.xiaomi.midrop.common;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RemoteProvider
extends ContentProvider {
    private SharedPreferences a;

    public Bundle call(String string2, String string3, Bundle bundle) {
        if ("callPreference".equals((Object)string2) && bundle.containsKey("type")) {
            switch (bundle.getInt("type")) {
                default: {
                    return null;
                }
                case 5: {
                    String string4 = bundle.getString("key");
                    if (string4 != null) {
                        if ("SET".equals((Object)string3)) {
                            this.a.edit().putStringSet(string4, (Set)new HashSet((Collection)bundle.getStringArrayList("value"))).apply();
                            return null;
                        }
                        if ("GET".equals((Object)string3)) {
                            HashSet hashSet = new HashSet((Collection)bundle.getStringArrayList("default"));
                            bundle.clear();
                            bundle.putStringArrayList(string4, new ArrayList((Collection)this.a.getStringSet(string4, (Set)hashSet)));
                            return bundle;
                        }
                    }
                    return null;
                }
                case 4: {
                    String string5 = bundle.getString("key");
                    if (string5 != null) {
                        if ("SET".equals((Object)string3)) {
                            this.a.edit().putLong(string5, bundle.getLong("value")).apply();
                            return null;
                        }
                        if ("GET".equals((Object)string3)) {
                            long l2 = bundle.getLong("default");
                            bundle.clear();
                            bundle.putLong(string5, this.a.getLong(string5, l2));
                            return bundle;
                        }
                    }
                    return null;
                }
                case 3: {
                    String string6 = bundle.getString("key");
                    if (string6 != null) {
                        if ("SET".equals((Object)string3)) {
                            this.a.edit().putFloat(string6, bundle.getFloat("value")).apply();
                            return null;
                        }
                        if ("GET".equals((Object)string3)) {
                            float f2 = bundle.getFloat("default");
                            bundle.clear();
                            bundle.putFloat(string6, this.a.getFloat(string6, f2));
                            return bundle;
                        }
                    }
                    return null;
                }
                case 2: {
                    String string7 = bundle.getString("key");
                    if (string7 != null) {
                        if ("SET".equals((Object)string3)) {
                            this.a.edit().putString(string7, bundle.getString("value")).apply();
                            return null;
                        }
                        if ("GET".equals((Object)string3)) {
                            String string8 = bundle.getString("default");
                            bundle.clear();
                            bundle.putString(string7, this.a.getString(string7, string8));
                            return bundle;
                        }
                    }
                    return null;
                }
                case 1: {
                    String string9 = bundle.getString("key");
                    if (string9 != null) {
                        if ("SET".equals((Object)string3)) {
                            boolean bl = bundle.getBoolean("value");
                            this.a.edit().putBoolean(string9, bl).apply();
                            return null;
                        }
                        if ("GET".equals((Object)string3)) {
                            boolean bl = bundle.getBoolean("default");
                            bundle.clear();
                            bundle.putBoolean(string9, this.a.getBoolean(string9, bl));
                            return bundle;
                        }
                    }
                    return null;
                }
                case 0: 
            }
            String string10 = bundle.getString("key");
            if (string10 != null) {
                if ("SET".equals((Object)string3)) {
                    this.a.edit().putInt(string10, bundle.getInt("value")).apply();
                    return null;
                }
                if ("GET".equals((Object)string3)) {
                    int n = bundle.getInt("default");
                    bundle.clear();
                    bundle.putInt(string10, this.a.getInt(string10, n));
                    return bundle;
                }
            }
        }
        return null;
    }

    public int delete(Uri uri, String string2, String[] arrstring) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        this.a = this.getContext().getSharedPreferences("remote_provider_preferences", 0);
        if (true ^ this.a.getBoolean("key_default_preferences_saved", false)) {
            Context context = this.getContext();
            SharedPreferences sharedPreferences = null;
            if (context != null) {
                sharedPreferences = this.getContext().getSharedPreferences("mi_drop_ap_info", 0);
            }
            if (sharedPreferences != null) {
                SharedPreferences.Editor editor = this.a.edit();
                for (Map.Entry entry : sharedPreferences.getAll().entrySet()) {
                    Object object = entry.getValue();
                    String string2 = (String)entry.getKey();
                    if (object instanceof Integer) {
                        editor.putInt(string2, ((Integer)object).intValue());
                        continue;
                    }
                    if (object instanceof String) {
                        editor.putString(string2, (String)object);
                        continue;
                    }
                    if (object instanceof Long) {
                        editor.putLong(string2, ((Long)object).longValue());
                        continue;
                    }
                    if (object instanceof Boolean) {
                        editor.putBoolean(string2, ((Boolean)object).booleanValue());
                        continue;
                    }
                    if (!(object instanceof Float)) continue;
                    editor.putFloat(string2, ((Float)object).floatValue());
                }
                editor.putBoolean("key_default_preferences_saved", true);
                editor.apply();
            }
        }
        return true;
    }

    public Cursor query(Uri uri, String[] arrstring, String string2, String[] arrstring2, String string3) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String string2, String[] arrstring) {
        return 0;
    }
}

