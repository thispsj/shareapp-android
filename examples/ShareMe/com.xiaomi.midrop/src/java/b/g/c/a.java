/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.net.InetAddress
 *  java.net.NetworkInterface
 *  java.net.SocketException
 *  java.util.Enumeration
 */
package b.g.c;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public final class a {
    private static byte[] a;

    public static String a() {
        try {
            Enumeration enumeration = NetworkInterface.getNetworkInterfaces();
            while (enumeration.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface)enumeration.nextElement();
                if (!networkInterface.getName().contains((CharSequence)"wlan")) continue;
                Enumeration enumeration2 = networkInterface.getInetAddresses();
                while (enumeration2.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress)enumeration2.nextElement();
                    if (inetAddress.isLoopbackAddress() || inetAddress.getAddress().length != 4) continue;
                    String string2 = inetAddress.getHostAddress();
                    return string2;
                }
            }
        }
        catch (SocketException socketException) {
            socketException.printStackTrace();
        }
        return null;
    }
}

