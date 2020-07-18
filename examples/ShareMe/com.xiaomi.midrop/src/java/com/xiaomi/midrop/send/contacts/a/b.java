/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentProviderOperation
 *  android.content.ContentProviderOperation$Builder
 *  android.content.ContentProviderResult
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.OperationApplicationException
 *  android.net.Uri
 *  android.os.RemoteException
 *  android.provider.ContactsContract
 *  android.provider.ContactsContract$Data
 *  android.provider.ContactsContract$RawContacts
 *  android.text.TextUtils
 *  com.xiaomi.midrop.send.contacts.a.a
 *  ezvcard.VCard
 *  ezvcard.property.Address
 *  ezvcard.property.Birthday
 *  ezvcard.property.Email
 *  ezvcard.property.FormattedName
 *  ezvcard.property.Impp
 *  ezvcard.property.Nickname
 *  ezvcard.property.Note
 *  ezvcard.property.Organization
 *  ezvcard.property.Photo
 *  ezvcard.property.RawProperty
 *  ezvcard.property.StructuredName
 *  ezvcard.property.Telephone
 *  ezvcard.property.Title
 *  ezvcard.property.Url
 *  ezvcard.property.VCardProperty
 *  ezvcard.util.TelUri
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.text.SimpleDateFormat
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.xiaomi.midrop.send.contacts.a;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.xiaomi.midrop.send.contacts.a.c;
import ezvcard.VCard;
import ezvcard.property.Address;
import ezvcard.property.Birthday;
import ezvcard.property.Email;
import ezvcard.property.FormattedName;
import ezvcard.property.Impp;
import ezvcard.property.Nickname;
import ezvcard.property.Note;
import ezvcard.property.Organization;
import ezvcard.property.Photo;
import ezvcard.property.RawProperty;
import ezvcard.property.StructuredName;
import ezvcard.property.Telephone;
import ezvcard.property.Title;
import ezvcard.property.Url;
import ezvcard.property.VCardProperty;
import ezvcard.util.TelUri;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b {
    private final Context a;
    private final a b;

    public b(Context context) {
        this.a = context;
        this.b = new a();
        this.b.a("account_type", null);
        this.b.a("account_name", null);
    }

    private static void a(List<a> list, VCard vCard) {
        Iterator iterator = vCard.b(Nickname.class).iterator();
        while (iterator.hasNext()) {
            List list2 = ((Nickname)iterator.next()).getValues();
            if (list2.isEmpty()) continue;
            for (String string2 : list2) {
                a a2 = new a("vnd.android.cursor.item/nickname");
                a2.a("data1", string2);
                list.add((Object)a2);
            }
        }
    }

    private static void b(List<a> list, VCard vCard) {
        for (Telephone telephone : vCard.b(Telephone.class)) {
            String string2 = telephone.getText();
            TelUri telUri = telephone.getUri();
            if (TextUtils.isEmpty((CharSequence)string2)) {
                if (telUri == null) continue;
                string2 = telUri.toString();
            }
            int n2 = c.a(telephone);
            a a2 = new a("vnd.android.cursor.item/phone_v2");
            a2.a("data1", string2);
            a2.a("data2", n2);
            list.add((Object)a2);
        }
    }

    private static void c(List<a> list, VCard vCard) {
        for (Email email : vCard.b(Email.class)) {
            String string2 = (String)email.getValue();
            if (TextUtils.isEmpty((CharSequence)string2)) continue;
            int n2 = c.a(email);
            a a2 = new a("vnd.android.cursor.item/email_v2");
            a2.a("data1", string2);
            a2.a("data2", n2);
            list.add((Object)a2);
        }
    }

    private static void d(List<a> list, VCard vCard) {
        for (Address address : vCard.b(Address.class)) {
            a a2 = new a("vnd.android.cursor.item/postal-address_v2");
            a2.a("data4", address.getStreetAddress());
            a2.a("data5", address.getPoBox());
            a2.a("data7", address.getLocality());
            a2.a("data8", address.getRegion());
            a2.a("data9", address.getPostalCode());
            a2.a("data10", address.getCountry());
            a2.a("data3", address.getLabel());
            a2.a("data2", c.a(address));
            list.add((Object)a2);
        }
    }

    private static void e(List<a> list, VCard vCard) {
        for (Map.Entry entry : c.a().entrySet()) {
            String string2 = (String)entry.getKey();
            Integer n2 = (Integer)entry.getValue();
            ArrayList arrayList = new ArrayList();
            for (RawProperty rawProperty : vCard.b(RawProperty.class)) {
                if (!rawProperty.getPropertyName().equalsIgnoreCase(string2)) continue;
                arrayList.add((Object)rawProperty);
            }
            for (RawProperty rawProperty : Collections.unmodifiableList((List)arrayList)) {
                a a2 = new a("vnd.android.cursor.item/im");
                a2.a("data1", (String)rawProperty.getValue());
                a2.a("data5", n2);
                list.add((Object)a2);
            }
        }
        for (Impp impp : vCard.b(Impp.class)) {
            a a3 = new a("vnd.android.cursor.item/im");
            a3.a("data1", impp.getHandle());
            a3.a("data5", c.d(impp.getProtocol()));
            list.add((Object)a3);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void f(List<a> list, VCard vCard) {
        Iterator iterator = vCard.b(com.xiaomi.midrop.send.contacts.a.a.class).iterator();
        while (iterator.hasNext()) {
            Object object;
            String string2;
            a a2;
            com.xiaomi.midrop.send.contacts.a.a a3 = (com.xiaomi.midrop.send.contacts.a.a)iterator.next();
            List list2 = a3.b;
            if (list2.isEmpty()) continue;
            if ("nickname".equals((Object)a3.a)) {
                a2 = new a("vnd.android.cursor.item/nickname");
                string2 = "data1";
                object = list2.get(0);
            } else {
                if ("contact_event".equals((Object)a3.a)) {
                    a2 = new a("vnd.android.cursor.item/contact_event");
                } else {
                    if (!"relation".equals((Object)a3.a)) continue;
                    a2 = new a("vnd.android.cursor.item/relation");
                }
                a2.a("data1", (String)list2.get(0));
                string2 = "data2";
                object = list2.get(1);
            }
            a2.a(string2, (String)object);
            list.add((Object)a2);
        }
        return;
    }

    private static void g(List<a> list, VCard vCard) {
        List list2 = vCard.b(RawProperty.class);
        HashMap hashMap = new HashMap();
        for (VCardProperty vCardProperty : list2) {
            String string2 = vCardProperty.getGroup();
            if (TextUtils.isEmpty((CharSequence)string2)) continue;
            List list3 = (List)hashMap.get((Object)string2);
            if (list3 == null) {
                list3 = new ArrayList();
                hashMap.put((Object)string2, (Object)list3);
            }
            list3.add((Object)vCardProperty);
        }
        block5 : for (List list4 : hashMap.values()) {
            a a2;
            block12 : {
                int n2;
                if (list4.size() == 1) continue;
                int n3 = 0;
                Iterator iterator = list4.iterator();
                String string3 = null;
                String string4 = null;
                while (iterator.hasNext()) {
                    RawProperty rawProperty = (RawProperty)iterator.next();
                    String string5 = rawProperty.getPropertyName();
                    if (string5.equalsIgnoreCase("X-ABDATE")) {
                        string3 = (String)rawProperty.getValue();
                        n3 = 1;
                        continue;
                    }
                    if (string5.equalsIgnoreCase("X-ABRELATEDNAMES")) {
                        string3 = (String)rawProperty.getValue();
                        n3 = 2;
                        continue;
                    }
                    if (!string5.equalsIgnoreCase("X-ABLABEL")) continue;
                    string4 = (String)rawProperty.getValue();
                }
                switch (n3) {
                    default: {
                        continue block5;
                    }
                    case 2: {
                        a2 = null;
                        if (string4 != null) {
                            a2 = new a("vnd.android.cursor.item/nickname");
                            a2.a("data1", string3);
                            if (!string4.equals((Object)"Nickname")) {
                                n2 = c.c(string4);
                                break;
                            }
                        }
                        break block12;
                    }
                    case 1: {
                        a2 = new a("vnd.android.cursor.item/contact_event");
                        a2.a("data1", string3);
                        n2 = c.b(string4);
                    }
                }
                a2.a("data2", n2);
            }
            list.add((Object)a2);
        }
    }

    private static void h(List<a> list, VCard vCard) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Iterator iterator = vCard.b(Birthday.class).iterator();
        while (iterator.hasNext()) {
            Date date = ((Birthday)iterator.next()).getDate();
            if (date == null) continue;
            a a2 = new a("vnd.android.cursor.item/contact_event");
            a2.a("data2", 3);
            a2.a("data1", simpleDateFormat.format(date));
            list.add((Object)a2);
        }
    }

    private static void i(List<a> list, VCard vCard) {
        for (Url url : vCard.b(Url.class)) {
            String string2 = (String)url.getValue();
            if (TextUtils.isEmpty((CharSequence)string2)) continue;
            int n2 = c.a(url.getType());
            a a2 = new a("vnd.android.cursor.item/website");
            a2.a("data1", string2);
            a2.a("data2", n2);
            list.add((Object)a2);
        }
    }

    private static void j(List<a> list, VCard vCard) {
        Iterator iterator = vCard.b(Note.class).iterator();
        while (iterator.hasNext()) {
            String string2 = (String)((Note)iterator.next()).getValue();
            a a2 = new a("vnd.android.cursor.item/note");
            a2.a("data1", string2);
            list.add((Object)a2);
        }
    }

    private static void k(List<a> list, VCard vCard) {
        Iterator iterator = vCard.b(Photo.class).iterator();
        while (iterator.hasNext()) {
            byte[] arrby = ((Photo)iterator.next()).getData();
            a a2 = new a("vnd.android.cursor.item/photo");
            if (arrby != null) {
                a2.a.put("data15", arrby);
            }
            list.add((Object)a2);
        }
    }

    private static void l(List<a> list, VCard vCard) {
        List list2;
        a a2 = new a("vnd.android.cursor.item/organization");
        Organization organization = (Organization)vCard.a(Organization.class);
        if (organization != null) {
            List list3 = organization.getValues();
            String[] arrstring = new String[]{"data1", "data5", "data9"};
            for (int i2 = 0; i2 < list3.size(); ++i2) {
                a2.a(arrstring[i2], (String)list3.get(i2));
            }
        }
        if (!(list2 = vCard.b(Title.class)).isEmpty()) {
            a2.a("data4", (String)((Title)list2.get(0)).getValue());
        }
        list.add((Object)a2);
    }

    public final void a(VCard vCard) throws RemoteException, OperationApplicationException {
        String string2;
        String string3;
        String string4;
        String string5;
        ArrayList arrayList = new ArrayList();
        a a2 = new a("vnd.android.cursor.item/name");
        StructuredName structuredName = vCard.c();
        if (structuredName != null) {
            string3 = structuredName.getGiven();
            a2.a("data2", string3);
            string4 = structuredName.getFamily();
            a2.a("data3", string4);
            List list = structuredName.getPrefixes();
            if (!list.isEmpty()) {
                string5 = (String)list.get(0);
                a2.a("data4", string5);
            } else {
                string5 = null;
            }
            List list2 = structuredName.getSuffixes();
            if (!list2.isEmpty()) {
                string2 = (String)list2.get(0);
                a2.a("data6", string2);
            } else {
                string2 = null;
            }
        } else {
            string2 = null;
            string3 = null;
            string4 = null;
            string5 = null;
        }
        FormattedName formattedName = vCard.b();
        String string6 = formattedName == null ? null : (String)formattedName.getValue();
        if (TextUtils.isEmpty((CharSequence)string6)) {
            StringBuilder stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty((CharSequence)string5)) {
                stringBuilder.append(string5);
                stringBuilder.append(' ');
            }
            if (!TextUtils.isEmpty((CharSequence)string3)) {
                stringBuilder.append(string3);
                stringBuilder.append(' ');
            }
            if (!TextUtils.isEmpty((CharSequence)string4)) {
                stringBuilder.append(string4);
                stringBuilder.append(' ');
            }
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.deleteCharAt(-1 + stringBuilder.length());
                    stringBuilder.append(", ");
                }
                stringBuilder.append(string2);
            }
            string6 = stringBuilder.toString().trim();
        }
        a2.a("data1", string6);
        RawProperty rawProperty = vCard.a("X-PHONETIC-FIRST-NAME");
        String string7 = rawProperty == null ? null : (String)rawProperty.getValue();
        a2.a("data7", string7);
        RawProperty rawProperty2 = vCard.a("X-PHONETIC-LAST-NAME");
        String string8 = rawProperty2 == null ? null : (String)rawProperty2.getValue();
        a2.a("data9", string8);
        arrayList.add((Object)a2);
        b.a((List<a>)arrayList, vCard);
        b.b((List<a>)arrayList, vCard);
        b.c((List<a>)arrayList, vCard);
        b.d((List<a>)arrayList, vCard);
        b.e((List<a>)arrayList, vCard);
        b.f((List<a>)arrayList, vCard);
        b.g((List<a>)arrayList, vCard);
        b.h((List<a>)arrayList, vCard);
        b.i((List<a>)arrayList, vCard);
        b.j((List<a>)arrayList, vCard);
        b.k((List<a>)arrayList, vCard);
        b.l((List<a>)arrayList, vCard);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        ContentValues contentValues = this.b.a();
        arrayList2.add((Object)ContentProviderOperation.newInsert((Uri)ContactsContract.RawContacts.CONTENT_URI).withValues(contentValues).build());
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ContentValues contentValues2 = ((a)iterator.next()).a();
            if (contentValues2.size() == 0) continue;
            arrayList2.add((Object)ContentProviderOperation.newInsert((Uri)ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValues(contentValues2).build());
        }
        this.a.getContentResolver().applyBatch("com.android.contacts", arrayList2);
    }

    private static final class a {
        final ContentValues a = new ContentValues();
        private final String b;

        public a() {
            this(null);
        }

        public a(String string2) {
            this.b = string2;
        }

        public final ContentValues a() {
            if (this.a.size() > 0 && this.b != null) {
                this.a("mimetype", this.b);
            }
            return this.a;
        }

        public final void a(String string2, int n2) {
            this.a.put(string2, Integer.valueOf((int)n2));
        }

        public final void a(String string2, String string3) {
            if (TextUtils.isEmpty((CharSequence)string3)) {
                return;
            }
            this.a.put(string2, string3);
        }
    }

}

