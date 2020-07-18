/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.net.NetworkInfo
 *  android.net.wifi.WifiManager
 *  android.net.wifi.p2p.WifiP2pDevice
 *  android.net.wifi.p2p.WifiP2pGroup
 *  android.net.wifi.p2p.WifiP2pInfo
 *  android.net.wifi.p2p.WifiP2pManager
 *  android.net.wifi.p2p.WifiP2pManager$ActionListener
 *  android.net.wifi.p2p.WifiP2pManager$Channel
 *  android.net.wifi.p2p.WifiP2pManager$ChannelListener
 *  android.net.wifi.p2p.WifiP2pManager$GroupInfoListener
 *  android.os.Looper
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.util.Log
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.lang.reflect.Method
 *  java.net.InetAddress
 *  java.util.HashMap
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 *  midrop.service.c.d
 */
package b.e.b.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import b.a.p;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a {
    public static final String a = "a";
    public Context b;
    public WifiManager c;
    public WifiP2pManager d;
    public boolean e;
    public c f;
    public WifiP2pManager.Channel g;
    public b h;
    public int i;
    public String j;
    public HashMap<String, String> k;

    public a(Context context) {
        this.b = context;
        this.c = (WifiManager)context.getApplicationContext().getSystemService("wifi");
        this.d = (WifiP2pManager)context.getSystemService("wifip2p");
        this.f = (a)this.new c();
        this.g = this.d.initialize(context, context.getMainLooper(), new WifiP2pManager.ChannelListener(){

            public final void onChannelDisconnected() {
                Log.d((String)a, (String)"onChannelDisconnected");
            }
        });
        this.k = new HashMap();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void a(int n2) {
        Method method;
        try {
            Class class_ = this.d.getClass();
            Class[] arrclass = new Class[]{WifiP2pManager.Channel.class, Integer.TYPE, Integer.TYPE, WifiP2pManager.ActionListener.class};
            method = class_.getMethod("setWifiP2pChannels", arrclass);
            if (method == null) return;
        }
        catch (Exception exception) {
            midrop.service.c.d.a((String)a, (String)"setWifiP2pChannels", (Throwable)exception, (Object[])new Object[0]);
            return;
        }
        WifiP2pManager wifiP2pManager = this.d;
        Object[] arrobject = new Object[]{this.g, 0, n2, new WifiP2pManager.ActionListener(n2){
            final /* synthetic */ int a;
            final /* synthetic */ int b;
            {
                this.a = 0;
                this.b = n2;
            }

            public final void onFailure(int n2) {
                String string2 = a;
                StringBuilder stringBuilder = new StringBuilder("set channel fail, reason=");
                stringBuilder.append(n2);
                stringBuilder.append(" lc=");
                stringBuilder.append(this.a);
                stringBuilder.append(" oc=");
                stringBuilder.append(this.b);
                midrop.service.c.d.b((String)string2, (String)stringBuilder.toString(), (Object[])new Object[0]);
            }

            public final void onSuccess() {
                a;
            }
        }};
        method.invoke((Object)wifiP2pManager, arrobject);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static /* synthetic */ void a(a a2, boolean bl) {
        int n2 = bl ? 36 : 6;
        a2.a(n2);
        WifiP2pManager.ActionListener actionListener = new WifiP2pManager.ActionListener(){

            public final void onFailure(int n2) {
                String string2 = a;
                Object[] arrobject = new Object[]{b.e.b.a.a.b.a(n2)};
                midrop.service.c.d.b((String)string2, (String)String.format((String)"create group failed: %s", (Object[])arrobject), (Object[])new Object[0]);
                if (a.this.h != null) {
                    a.this.h.a();
                    a.this.h = null;
                }
            }

            public final void onSuccess() {
                a;
            }
        };
        try {
            Field field = a2.g.getClass().getDeclaredField("mAsyncChannel");
            field.setAccessible(true);
            Object object = field.get((Object)a2.g);
            Method method = a2.g.getClass().getDeclaredMethod("putListener", new Class[]{Object.class});
            method.setAccessible(true);
            int n3 = (Integer)method.invoke((Object)a2.g, new Object[]{actionListener});
            int n4 = a2.d.getClass().getDeclaredField("CREATE_GROUP").getInt(null);
            int n5 = WifiP2pGroup.class.getDeclaredField("TEMPORARY_NET_ID").getInt(null);
            Class class_ = object.getClass();
            Class[] arrclass = new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE};
            Method method2 = class_.getDeclaredMethod("sendMessage", arrclass);
            method2.setAccessible(true);
            Object[] arrobject = new Object[]{n4, n5, n3};
            method2.invoke(object, arrobject);
            return;
        }
        catch (Exception exception) {
            midrop.service.c.d.a((String)a, (String)"createTempGroup", (Throwable)exception, (Object[])new Object[0]);
            a2.h.a();
            a2.h = null;
            return;
        }
    }

    private static String b(String string2) {
        try {
            Matcher matcher = Pattern.compile((String)"(\\p{Punct}x\\p{XDigit}{2}+)++").matcher((CharSequence)string2);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(stringBuffer, new String(p.a(matcher.group().replace((CharSequence)"\\x", (CharSequence)"").toCharArray())));
            }
            matcher.appendTail(stringBuffer);
            String string3 = stringBuffer.toString();
            return string3;
        }
        catch (Exception exception) {
            return string2;
        }
    }

    public final void a(final a a2) {
        Log.d((String)a, (String)"close");
        this.d.removeGroup(this.g, new WifiP2pManager.ActionListener(){

            public final void onFailure(int n2) {
                String string2 = a;
                Object[] arrobject = new Object[]{b.e.b.a.a.b.a(n2)};
                Log.d((String)string2, (String)String.format((String)"removeGroup failed: %s", (Object[])arrobject));
                if (a2 != null) {
                    a2.b();
                }
            }

            public final void onSuccess() {
                Log.d((String)a, (String)"removeGroup succeed");
                if (a2 != null) {
                    a2.a();
                }
            }
        });
        if (this.e) {
            this.e = false;
            Log.d((String)a, (String)"unregisterMyReceiver");
            try {
                this.b.unregisterReceiver((BroadcastReceiver)this.f);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                illegalArgumentException.printStackTrace();
            }
        }
        Log.d((String)a, (String)"resetWifiState");
        if (this.i == d.b) {
            Log.d((String)a, (String)"originalWifiState is disabled");
            this.c.setWifiEnabled(false);
        }
    }

    public static interface a {
        public void a();

        public void b();
    }

    public static interface b {
        public void a();

        public void a(String var1, String var2, String var3, String var4);
    }

    public final class c
    extends BroadcastReceiver {
        public final void onReceive(Context context, Intent intent) {
            String string2 = intent.getAction();
            String string3 = a;
            StringBuilder stringBuilder = new StringBuilder("action: ");
            stringBuilder.append(string2);
            midrop.service.c.d.b((String)string3, (String)stringBuilder.toString(), (Object[])new Object[0]);
            if ("android.net.wifi.p2p.CONNECTION_STATE_CHANGE".equals((Object)string2)) {
                WifiP2pInfo wifiP2pInfo = (WifiP2pInfo)intent.getParcelableExtra("wifiP2pInfo");
                NetworkInfo networkInfo = (NetworkInfo)intent.getParcelableExtra("networkInfo");
                WifiP2pGroup wifiP2pGroup = (WifiP2pGroup)intent.getParcelableExtra("p2pGroupInfo");
                a;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(wifiP2pGroup.getNetworkName());
                stringBuilder2.append(" owner:");
                stringBuilder2.append(wifiP2pInfo.isGroupOwner);
                stringBuilder2.append(" connected:");
                stringBuilder2.append(networkInfo.isConnected());
                if (networkInfo.isConnected() && wifiP2pInfo.isGroupOwner && a.this.h != null) {
                    String string4 = a.b(wifiP2pGroup.getNetworkName());
                    if (TextUtils.equals((CharSequence)string4, (CharSequence)a.this.j)) {
                        a.this.h.a(wifiP2pInfo.groupOwnerAddress.getHostAddress(), string4, wifiP2pGroup.getPassphrase(), wifiP2pGroup.getOwner().deviceAddress);
                        a.this.h = null;
                        return;
                    }
                    a.this.k.put((Object)string4, (Object)wifiP2pInfo.groupOwnerAddress.getHostAddress());
                }
                return;
            }
            if ("android.net.wifi.p2p.THIS_DEVICE_CHANGED".equals((Object)string2)) {
                a.this.d.requestGroupInfo(a.this.g, new WifiP2pManager.GroupInfoListener(){

                    public final void onGroupInfoAvailable(WifiP2pGroup wifiP2pGroup) {
                        if (wifiP2pGroup == null) {
                            return;
                        }
                        String string2 = a.b(wifiP2pGroup.getNetworkName());
                        a;
                        StringBuilder stringBuilder = new StringBuilder("group info ");
                        stringBuilder.append(string2);
                        stringBuilder.append(" ");
                        stringBuilder.append(wifiP2pGroup.isGroupOwner());
                        if (a.this.h != null && wifiP2pGroup.isGroupOwner()) {
                            a.this.j = string2;
                            if (a.this.k.containsKey((Object)a.this.j)) {
                                a.this.h.a((String)a.this.k.get((Object)a.this.j), a.this.j, wifiP2pGroup.getPassphrase(), wifiP2pGroup.getOwner().deviceAddress);
                                a.this.h = null;
                            }
                        }
                    }
                });
                return;
            }
            if ("android.net.wifi.p2p.PEERS_CHANGED".equals((Object)string2)) {
                Log.d((String)a, (String)"-- Peers Changed --");
            }
        }

    }

    private static final class d
    extends Enum<d> {
        public static final int a = 1;
        public static final int b = 2;
        private static final /* synthetic */ int[] c;

        static {
            int[] arrn = new int[]{a, b};
            c = arrn;
        }
    }

}

