/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.String
 *  java.lang.Thread
 *  java.net.ServerSocket
 *  java.net.Socket
 *  org.a.af
 */
package org.a;

import com.xiaomi.miftp.b.a;
import com.xiaomi.miftp.c.c;
import java.net.ServerSocket;
import java.net.Socket;
import org.a.ab;
import org.a.af;
import org.a.aj;

public class ak
extends Thread {
    private static final String b = "ak";
    public ServerSocket a;
    private a c;

    public ak(ServerSocket serverSocket, a a2) {
        this.a = serverSocket;
        this.c = a2;
    }

    public void run() {
        try {
            do {
                Socket socket = this.a.accept();
                c.d(b, "New connection, spawned thread");
                aj aj2 = new aj(socket, (ab)new af(), aj.a.a);
                aj2.start();
                this.c.a(aj2);
            } while (true);
        }
        catch (Exception exception) {
            c.a(b, "Exception in TcpListener");
            return;
        }
    }
}

