/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.xiaomi.market.sdk.e$b
 *  java.io.BufferedInputStream
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.io.UnsupportedEncodingException
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.net.MalformedURLException
 *  java.net.URL
 *  java.net.URLConnection
 *  java.net.URLEncoder
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.Set
 *  java.util.TreeMap
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.xiaomi.market.sdk;

import android.text.TextUtils;
import com.xiaomi.market.sdk.e;
import com.xiaomi.market.sdk.j;
import com.xiaomi.market.sdk.q;
import com.xiaomi.market.sdk.s;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * Exception performing whole class analysis.
 */
public final class e {
    protected JSONObject a;
    protected URL b;
    protected d c;
    protected boolean d;
    protected boolean e;
    protected boolean f;
    protected boolean g;
    protected boolean h;
    protected boolean i;

    public e(String string2) {
        super(string2, (byte)0);
    }

    private e(String string2, byte by) {
        URL uRL;
        boolean bl;
        String string3;
        try {
            uRL = new URL(string2);
        }
        catch (MalformedURLException malformedURLException) {
            StringBuilder stringBuilder = new StringBuilder("URL error: ");
            stringBuilder.append((Object)malformedURLException);
            j.b("MarketConnection", stringBuilder.toString());
            uRL = null;
        }
        this.d = bl = true;
        this.e = false;
        this.f = bl;
        this.g = bl;
        this.h = bl;
        if (uRL == null || !TextUtils.equals((CharSequence)(string3 = uRL.getProtocol()), (CharSequence)"http") && !TextUtils.equals((CharSequence)string3, (CharSequence)"https")) {
            bl = false;
        }
        if (bl) {
            this.b = uRL;
        }
        this.i = false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private c a(e e2) {
        d d2;
        if (this.b == null) {
            return c.b;
        }
        if (!q.a(s.d())) {
            return c.c;
        }
        if (this.c == null) {
            this.c = new d((e)this);
        }
        try {
            d2 = this.c;
        }
        catch (a a2) {
            return a2.a;
        }
        String string2 = this.b.toString();
        if (this.e && !d2.a.isEmpty()) {
            StringBuilder stringBuilder;
            String string3;
            String string4 = this.b.getQuery();
            String string5 = this.b.toString();
            if (TextUtils.isEmpty((CharSequence)string4)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string5);
                string3 = "?";
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string5);
                string3 = "&";
            }
            stringBuilder.append(string3);
            stringBuilder.append(d2.toString());
            string2 = stringBuilder.toString();
        }
        if (q.a) {
            StringBuilder stringBuilder = new StringBuilder("connection url: ");
            stringBuilder.append(string2);
            j.a("MarketConnection", stringBuilder.toString());
        }
        String string6 = "";
        if (!this.e) {
            string6 = d2.toString();
        }
        long l2 = System.currentTimeMillis();
        c c2 = e.a(string2, string6, this.e, e2);
        if (q.a) {
            long l3 = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder("Time(ms) spent in request: ");
            stringBuilder.append(l3 - l2);
            stringBuilder.append(", ");
            stringBuilder.append(string2);
            j.a("MarketConnection", stringBuilder.toString());
        }
        return c2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static c a(String string2, String string3, boolean bl, e e2) {
        BufferedInputStream bufferedInputStream;
        Throwable throwable;
        block31 : {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Object)string2);
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                HttpURLConnection httpURLConnection;
                block35 : {
                    block32 : {
                        void var15_34;
                        block34 : {
                            URL uRL;
                            Exception exception;
                            block33 : {
                                c c2;
                                block29 : {
                                    Exception exception2;
                                    block30 : {
                                        int n3;
                                        int n2;
                                        String string4 = (String)iterator.next();
                                        if (q.a) {
                                            StringBuilder stringBuilder = new StringBuilder("hosted connection url: ");
                                            stringBuilder.append(string4);
                                            j.a("MarketConnection", stringBuilder.toString());
                                        }
                                        uRL = new URL(string4);
                                        httpURLConnection = (HttpURLConnection)uRL.openConnection();
                                        httpURLConnection.setConnectTimeout(10000);
                                        if (q.b(s.d())) {
                                            httpURLConnection.setReadTimeout(10000);
                                        } else {
                                            httpURLConnection.setReadTimeout(30000);
                                        }
                                        if (bl) {
                                            httpURLConnection.setRequestMethod("GET");
                                            httpURLConnection.setDoOutput(false);
                                        } else {
                                            httpURLConnection.setRequestMethod("POST");
                                            httpURLConnection.setDoOutput(true);
                                        }
                                        httpURLConnection.connect();
                                        if (!bl && !TextUtils.isEmpty((CharSequence)string3)) {
                                            OutputStream outputStream = httpURLConnection.getOutputStream();
                                            outputStream.write(string3.getBytes());
                                            if (q.a) {
                                                StringBuilder stringBuilder = new StringBuilder("[post]");
                                                stringBuilder.append(string3);
                                                j.a("MarketConnection", stringBuilder.toString());
                                            }
                                            outputStream.close();
                                        }
                                        if ((n3 = httpURLConnection.getResponseCode()) == 200) {
                                            c2 = c.a;
                                        } else {
                                            StringBuilder stringBuilder = new StringBuilder("Network Error : ");
                                            stringBuilder.append(n3);
                                            j.b("MarketConnection", stringBuilder.toString());
                                            c2 = c.f;
                                        }
                                        c c3 = c.a;
                                        if (c2 != c3 || e2 == null) break block29;
                                        bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream(), 8192);
                                        byte[] arrby = new byte[1024];
                                        while ((n2 = bufferedInputStream.read(arrby, 0, 1024)) > 0) {
                                            e2.write(arrby, 0, n2);
                                        }
                                        e2.flush();
                                        bufferedInputStream.close();
                                        break block29;
                                        catch (Exception exception3) {
                                            break block30;
                                        }
                                        catch (Throwable throwable2) {
                                            throwable = throwable2;
                                            bufferedInputStream = null;
                                            break block31;
                                        }
                                        catch (Exception exception4) {
                                            bufferedInputStream = null;
                                            exception2 = exception4;
                                        }
                                    }
                                    StringBuilder stringBuilder = new StringBuilder("Connection Exception for ");
                                    stringBuilder.append(uRL.getHost());
                                    stringBuilder.append(" : read file stream error ");
                                    stringBuilder.append((Object)exception2);
                                    j.b("MarketConnection", stringBuilder.toString());
                                    e2.a();
                                    if (bufferedInputStream == null) break block32;
                                    try {
                                        bufferedInputStream.close();
                                        break block32;
                                    }
                                    catch (Exception exception5) {
                                        break block33;
                                    }
                                }
                                if (httpURLConnection == null) return c2;
                                httpURLConnection.disconnect();
                                return c2;
                                catch (Throwable throwable3) {
                                    httpURLConnection = null;
                                    break block34;
                                }
                                catch (Exception exception6) {
                                    httpURLConnection = null;
                                    exception = exception6;
                                }
                            }
                            try {
                                StringBuilder stringBuilder = new StringBuilder("Connection Exception for ");
                                stringBuilder.append(uRL.getHost());
                                stringBuilder.append(" :");
                                stringBuilder.append((Object)exception);
                                j.b("MarketConnection", stringBuilder.toString());
                                if (httpURLConnection == null) continue;
                                break block35;
                            }
                            catch (Throwable throwable4) {
                                // empty catch block
                            }
                        }
                        if (httpURLConnection == null) throw var15_34;
                        httpURLConnection.disconnect();
                        throw var15_34;
                        catch (MalformedURLException malformedURLException) {
                            StringBuilder stringBuilder = new StringBuilder(" URL error :");
                            stringBuilder.append((Object)malformedURLException);
                            j.b("MarketConnection", stringBuilder.toString());
                            continue;
                        }
                    }
                    if (httpURLConnection == null) continue;
                }
                httpURLConnection.disconnect();
            }
            return c.c;
            catch (Throwable throwable5) {}
        }
        if (bufferedInputStream == null) throw throwable;
        bufferedInputStream.close();
        throw throwable;
    }

    public static String a(String string2, String string3) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return string3;
        }
        if (TextUtils.isEmpty((CharSequence)string3)) {
            return string2;
        }
        if (string2.charAt(string2.length() - 1) == '/') {
            string2 = string2.substring(0, string2.length() - 1);
        }
        if (string3.charAt(0) == '/') {
            string3 = string3.substring(1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("/");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public final JSONObject a() {
        return this.a;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final c b() {
        ByteArrayOutputStream byteArrayOutputStream;
        c c2;
        Throwable throwable2222;
        block11 : {
            byteArrayOutputStream = new ByteArrayOutputStream();
            c2 = this.a((e)new /* Unavailable Anonymous Inner Class!! */);
            if (c2 == c.a) {
                this.a = new JSONObject(byteArrayOutputStream.toString());
                break block11;
            }
            StringBuilder stringBuilder = new StringBuilder("Connection failed : ");
            stringBuilder.append((Object)c2);
            j.b("MarketConnection", stringBuilder.toString());
        }
        try {
            byteArrayOutputStream.close();
            return c2;
        }
        catch (IOException iOException) {}
        return c2;
        {
            c c3;
            catch (Throwable throwable2222) {
            }
            catch (JSONException jSONException) {}
            {
                StringBuilder stringBuilder = new StringBuilder("JSON error: ");
                stringBuilder.append((Object)jSONException);
                j.b("MarketConnection", stringBuilder.toString());
                c3 = c.g;
            }
            try {
                byteArrayOutputStream.close();
                return c3;
            }
            catch (IOException iOException) {}
            return c3;
        }
        try {
            byteArrayOutputStream.close();
            throw throwable2222;
        }
        catch (IOException iOException) {}
        throw throwable2222;
    }

    protected final class a
    extends Exception {
        private static final long serialVersionUID = 1L;
        protected c a;
    }

    public static final class c
    extends Enum<c> {
        public static final /* enum */ c a = new c();
        public static final /* enum */ c b = new c();
        public static final /* enum */ c c = new c();
        public static final /* enum */ c d = new c();
        public static final /* enum */ c e = new c();
        public static final /* enum */ c f = new c();
        public static final /* enum */ c g = new c();
        public static final /* enum */ c h = new c();
        private static final /* synthetic */ c[] i;

        static {
            c[] arrc = new c[]{a, b, c, d, e, f, g, h};
            i = arrc;
        }

        public static c valueOf(String string2) {
            return (c)Enum.valueOf(c.class, (String)string2);
        }

        public static c[] values() {
            return (c[])i.clone();
        }
    }

    public final class d {
        TreeMap<String, String> a;
        final /* synthetic */ e b;

        public d(e e2) {
            super(e2, (byte)0);
        }

        private d(e e2, byte by) {
            this.b = e2;
            this.a = new TreeMap();
            e2.c = this;
        }

        public final d a(String string2, String string3) {
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                if (TextUtils.isEmpty((CharSequence)string3)) {
                    return this;
                }
                this.a.put((Object)string2, (Object)string3);
            }
            return this;
        }

        public final String toString() {
            if (this.a.isEmpty()) {
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (String string2 : this.a.keySet()) {
                stringBuilder.append(string2);
                stringBuilder.append("=");
                try {
                    stringBuilder.append(URLEncoder.encode((String)((String)this.a.get((Object)string2)), (String)"UTF-8"));
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {}
                stringBuilder.append("&");
            }
            return stringBuilder.deleteCharAt(-1 + stringBuilder.length()).toString();
        }
    }

    protected abstract class e
    extends OutputStream {
        protected OutputStream b;

        public e(OutputStream outputStream) {
            if (outputStream == null) {
                throw new IllegalArgumentException("outputstream is null");
            }
            this.b = outputStream;
        }

        public abstract void a();

        public void close() throws IOException {
            this.b.close();
        }

        public void flush() throws IOException {
            this.b.flush();
        }

        public void write(int n2) throws IOException {
            this.b.write(n2);
        }

        public void write(byte[] arrby) throws IOException {
            this.b.write(arrby);
        }

        public void write(byte[] arrby, int n2, int n3) throws IOException {
            this.b.write(arrby, n2, n3);
        }
    }

}

