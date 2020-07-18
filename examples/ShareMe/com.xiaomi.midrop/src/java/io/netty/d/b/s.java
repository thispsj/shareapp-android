/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.net.InetAddress
 *  java.net.NetworkInterface
 *  java.net.ServerSocket
 *  java.net.Socket
 *  java.net.SocketAddress
 *  java.nio.channels.ServerSocketChannel
 *  java.nio.channels.SocketChannel
 *  java.security.AccessController
 *  java.security.PrivilegedAction
 *  java.security.PrivilegedActionException
 *  java.security.PrivilegedExceptionAction
 *  java.util.Enumeration
 */
package io.netty.d.b;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Enumeration;

public final class s {
    public static SocketChannel a(final ServerSocketChannel serverSocketChannel) throws IOException {
        try {
            SocketChannel socketChannel = (SocketChannel)AccessController.doPrivileged((PrivilegedExceptionAction)new PrivilegedExceptionAction<SocketChannel>(){

                public final /* synthetic */ Object run() throws Exception {
                    return serverSocketChannel.accept();
                }
            });
            return socketChannel;
        }
        catch (PrivilegedActionException privilegedActionException) {
            throw (IOException)privilegedActionException.getCause();
        }
    }

    public static Enumeration<InetAddress> a(final NetworkInterface networkInterface) {
        return (Enumeration)AccessController.doPrivileged((PrivilegedAction)new PrivilegedAction<Enumeration<InetAddress>>(){

            public final /* synthetic */ Object run() {
                return networkInterface.getInetAddresses();
            }
        });
    }

    public static boolean a(final SocketChannel socketChannel, final SocketAddress socketAddress) throws IOException {
        try {
            boolean bl = (Boolean)AccessController.doPrivileged((PrivilegedExceptionAction)new PrivilegedExceptionAction<Boolean>(){

                public final /* synthetic */ Object run() throws Exception {
                    return socketChannel.connect(socketAddress);
                }
            });
            return bl;
        }
        catch (PrivilegedActionException privilegedActionException) {
            throw (IOException)privilegedActionException.getCause();
        }
    }

}

