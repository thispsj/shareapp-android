/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.github.a.a.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e {
    private static final String a = System.getProperty((String)"line.separator");

    public static String a(String string2) {
        return e.a(string2, 0, string2.length());
    }

    private static String a(String string2, int n2, int n3) {
        StringBuilder stringBuilder = null;
        boolean bl = false;
        for (int i2 = n2; i2 < n3; ++i2) {
            char c2 = string2.charAt(i2);
            if (bl) {
                if (stringBuilder == null) {
                    stringBuilder = new StringBuilder(n3 - n2);
                    stringBuilder.append(string2.substring(n2, i2 - 1));
                }
                if (c2 != 'N' && c2 != 'n') {
                    stringBuilder.append(c2);
                } else {
                    stringBuilder.append(a);
                }
                bl = false;
                continue;
            }
            if (c2 != '\\') {
                if (stringBuilder == null) continue;
                stringBuilder.append(c2);
                continue;
            }
            bl = true;
        }
        if (stringBuilder != null) {
            return stringBuilder.toString();
        }
        if (n2 == 0 && n3 == string2.length()) {
            return string2;
        }
        return string2.substring(n2, n3);
    }

    private static List<String> a(String string2, char c2, int n2) {
        if (string2.length() == 0) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        boolean bl = false;
        int n3 = 0;
        for (int i2 = 0; i2 < string2.length(); ++i2) {
            char c3 = string2.charAt(i2);
            if (bl) {
                bl = false;
                continue;
            }
            if (c3 == c2) {
                arrayList.add((Object)e.a(string2, n3, i2));
                n3 = i2 + 1;
                if (n2 <= 0 || arrayList.size() != n2 - 1) continue;
                break;
            }
            if (c3 != '\\') continue;
            bl = true;
        }
        arrayList.add((Object)e.a(string2, n3, string2.length()));
        return arrayList;
    }

    public static List<String> a(String string2, int n2) {
        return e.a(string2, ';', n2);
    }

    public static List<String> b(String string2) {
        return e.a(string2, ',', -1);
    }

    public static List<String> c(String string2) {
        return e.a(string2, ';', -1);
    }

    public static List<List<String>> d(String string2) {
        if (string2.length() == 0) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add((Object)arrayList2);
        ArrayList arrayList3 = arrayList2;
        boolean bl = false;
        int n2 = 0;
        for (int i2 = 0; i2 < string2.length(); ++i2) {
            if (bl) {
                bl = false;
                continue;
            }
            char c2 = string2.charAt(i2);
            if (c2 != ',') {
                if (c2 != ';') {
                    if (c2 != '\\') continue;
                    bl = true;
                    continue;
                }
                String string3 = e.a(string2, n2, i2);
                if (!arrayList3.isEmpty() || string3.length() != 0) {
                    arrayList3.add((Object)string3);
                }
                ArrayList arrayList4 = new ArrayList();
                arrayList.add((Object)arrayList4);
                int n3 = i2 + 1;
                arrayList3 = arrayList4;
                n2 = n3;
                continue;
            }
            arrayList3.add((Object)e.a(string2, n2, i2));
            n2 = i2 + 1;
        }
        String string4 = e.a(string2, n2, string2.length());
        if (!arrayList3.isEmpty() || string4.length() != 0) {
            arrayList3.add((Object)string4);
        }
        return arrayList;
    }

    public static final class a {
        private final Iterator<String> a;

        public a(String string2) {
            super(string2, -1);
        }

        public a(String string2, int n2) {
            this.a = e.a(string2, n2).iterator();
        }

        public final String a() {
            if (!this.a.hasNext()) {
                return null;
            }
            String string2 = (String)this.a.next();
            if (string2.length() == 0) {
                return null;
            }
            return string2;
        }
    }

    public static final class b {
        private final Iterator<List<String>> a;

        public b(String string2) {
            super(e.d(string2));
        }

        private b(List<List<String>> list) {
            this.a = list.iterator();
        }

        private boolean c() {
            return this.a.hasNext();
        }

        public final String a() {
            if (!this.c()) {
                return null;
            }
            List list = (List)this.a.next();
            if (list.isEmpty()) {
                return null;
            }
            return (String)list.get(0);
        }

        public final List<String> b() {
            if (!this.c()) {
                return new ArrayList(0);
            }
            return (List)this.a.next();
        }
    }

}

