/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.parameter.AddressType
 *  ezvcard.parameter.EmailType
 *  ezvcard.parameter.TelephoneType
 *  ezvcard.property.Address
 *  ezvcard.property.Email
 *  ezvcard.property.Telephone
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.xiaomi.midrop.send.contacts.a;

import ezvcard.parameter.AddressType;
import ezvcard.parameter.EmailType;
import ezvcard.parameter.TelephoneType;
import ezvcard.property.Address;
import ezvcard.property.Email;
import ezvcard.property.Telephone;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class c {
    private static final Map<TelephoneType, Integer> a;
    private static final Map<String, Integer> b;
    private static final Map<EmailType, Integer> c;
    private static final Map<AddressType, Integer> d;
    private static final Map<String, Integer> e;
    private static final Map<String, Integer> f;
    private static final Map<String, Integer> g;
    private static final Map<String, Integer> h;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)TelephoneType.a, (Object)0);
        hashMap.put((Object)TelephoneType.b, (Object)9);
        hashMap.put((Object)TelephoneType.c, (Object)2);
        hashMap.put((Object)TelephoneType.d, (Object)5);
        hashMap.put((Object)TelephoneType.e, (Object)1);
        hashMap.put((Object)TelephoneType.f, (Object)11);
        hashMap.put((Object)TelephoneType.g, (Object)7);
        hashMap.put((Object)TelephoneType.i, (Object)6);
        hashMap.put((Object)TelephoneType.h, (Object)20);
        hashMap.put((Object)TelephoneType.j, (Object)7);
        hashMap.put((Object)TelephoneType.l, (Object)20);
        hashMap.put((Object)TelephoneType.m, (Object)20);
        hashMap.put((Object)TelephoneType.n, (Object)7);
        hashMap.put((Object)TelephoneType.p, (Object)3);
        hashMap.put((Object)TelephoneType.o, (Object)7);
        a = Collections.unmodifiableMap((Map)hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put((Object)"home", (Object)4);
        hashMap2.put((Object)"work", (Object)5);
        hashMap2.put((Object)"homepage", (Object)1);
        hashMap2.put((Object)"profile", (Object)3);
        b = Collections.unmodifiableMap((Map)hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put((Object)EmailType.n, (Object)1);
        hashMap3.put((Object)EmailType.o, (Object)2);
        c = Collections.unmodifiableMap((Map)hashMap3);
        HashMap hashMap4 = new HashMap();
        hashMap4.put((Object)AddressType.a, (Object)1);
        hashMap4.put((Object)AddressType.a((String)"business"), (Object)2);
        hashMap4.put((Object)AddressType.b, (Object)2);
        hashMap4.put((Object)AddressType.a((String)"other"), (Object)3);
        d = Collections.unmodifiableMap((Map)hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.put((Object)"father", (Object)5);
        hashMap5.put((Object)"spouse", (Object)14);
        hashMap5.put((Object)"mother", (Object)8);
        hashMap5.put((Object)"brother", (Object)2);
        hashMap5.put((Object)"parent", (Object)9);
        hashMap5.put((Object)"sister", (Object)13);
        hashMap5.put((Object)"child", (Object)3);
        hashMap5.put((Object)"assistant", (Object)1);
        hashMap5.put((Object)"partner", (Object)10);
        hashMap5.put((Object)"manager", (Object)7);
        e = Collections.unmodifiableMap((Map)hashMap5);
        HashMap hashMap6 = new HashMap();
        hashMap6.put((Object)"anniversary", (Object)1);
        hashMap6.put((Object)"other", (Object)2);
        f = Collections.unmodifiableMap((Map)hashMap6);
        HashMap hashMap7 = new HashMap();
        hashMap7.put((Object)"X-AIM", (Object)0);
        hashMap7.put((Object)"X-ICQ", (Object)6);
        hashMap7.put((Object)"X-QQ", (Object)6);
        hashMap7.put((Object)"X-GOOGLE-TALK", (Object)-1);
        hashMap7.put((Object)"X-JABBER", (Object)7);
        hashMap7.put((Object)"X-MSN", (Object)1);
        hashMap7.put((Object)"X-MS-IMADDRESS", (Object)1);
        hashMap7.put((Object)"X-YAHOO", (Object)2);
        hashMap7.put((Object)"X-SKYPE", (Object)3);
        hashMap7.put((Object)"X-SKYPE-USERNAME", (Object)3);
        hashMap7.put((Object)"X-TWITTER", (Object)-1);
        g = Collections.unmodifiableMap((Map)hashMap7);
        HashMap hashMap8 = new HashMap();
        hashMap8.put((Object)"aim", (Object)0);
        hashMap8.put((Object)"icq", (Object)6);
        hashMap8.put((Object)"msn", (Object)1);
        hashMap8.put((Object)"ymsgr", (Object)2);
        hashMap8.put((Object)"skype", (Object)3);
        h = Collections.unmodifiableMap((Map)hashMap8);
    }

    public static int a(Address address) {
        for (AddressType addressType : address.getTypes()) {
            Integer n2 = (Integer)d.get((Object)addressType);
            if (n2 == null) continue;
            return n2;
        }
        return 0;
    }

    public static int a(Email email) {
        for (EmailType emailType : email.getTypes()) {
            Integer n2 = (Integer)c.get((Object)emailType);
            if (n2 == null) continue;
            return n2;
        }
        return 3;
    }

    public static int a(Telephone telephone) {
        for (TelephoneType telephoneType : telephone.getTypes()) {
            Integer n2 = (Integer)a.get((Object)telephoneType);
            if (n2 == null) continue;
            return n2;
        }
        return 7;
    }

    public static int a(String string2) {
        if (string2 == null) {
            return 0;
        }
        String string3 = string2.toLowerCase();
        Integer n2 = (Integer)b.get((Object)string3);
        if (n2 == null) {
            return 0;
        }
        return n2;
    }

    public static Map<String, Integer> a() {
        return g;
    }

    public static int b(String string2) {
        if (string2 == null) {
            return 2;
        }
        String string3 = string2.toLowerCase();
        for (Map.Entry entry : f.entrySet()) {
            if (!string3.contains((CharSequence)entry.getKey())) continue;
            return (Integer)entry.getValue();
        }
        return 2;
    }

    public static int c(String string2) {
        if (string2 == null) {
            return 0;
        }
        String string3 = string2.toLowerCase();
        for (Map.Entry entry : e.entrySet()) {
            if (!string3.contains((CharSequence)entry.getKey())) continue;
            return (Integer)entry.getValue();
        }
        return 0;
    }

    public static int d(String string2) {
        if (string2 == null) {
            return -1;
        }
        String string3 = string2.toLowerCase();
        Integer n2 = (Integer)h.get((Object)string3);
        if (n2 == null) {
            return -1;
        }
        return n2;
    }
}

