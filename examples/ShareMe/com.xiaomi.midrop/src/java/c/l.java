/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.a
 *  c.a$1
 *  c.a$2
 *  c.d
 *  c.e
 *  c.l$1
 *  c.l$2
 *  c.l$3
 *  c.l$4
 *  c.n
 *  c.o
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.AssertionError
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.Socket
 *  java.util.logging.Logger
 */
package c;

import c.a;
import c.d;
import c.e;
import c.l;
import c.n;
import c.o;
import c.s;
import c.t;
import c.u;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public final class l {
    static final Logger a = Logger.getLogger((String)l.class.getName());

    private l() {
    }

    public static d a(s s2) {
        return new n(s2);
    }

    public static e a(t t2) {
        return new o(t2);
    }

    public static s a() {
        return new 3();
    }

    public static s a(OutputStream outputStream) {
        return l.a(outputStream, new u());
    }

    private static s a(OutputStream outputStream, u u2) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (u2 == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new 1(u2, outputStream);
    }

    public static s a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        a a2 = l.c(socket);
        return new a.1(a2, l.a(socket.getOutputStream(), (u)a2));
    }

    public static t a(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return l.a((InputStream)new FileInputStream(file));
    }

    public static t a(InputStream inputStream) {
        return l.a(inputStream, new u());
    }

    private static t a(InputStream inputStream, u u2) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (u2 == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new 2(u2, inputStream);
    }

    static boolean a(AssertionError assertionError) {
        return assertionError.getCause() != null && assertionError.getMessage() != null && assertionError.getMessage().contains((CharSequence)"getsockname failed");
    }

    public static s b(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return l.a((OutputStream)new FileOutputStream(file));
    }

    public static t b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        a a2 = l.c(socket);
        return new a.2(a2, l.a(socket.getInputStream(), (u)a2));
    }

    private static a c(Socket socket) {
        return new 4(socket);
    }

    public static s c(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return l.a((OutputStream)new FileOutputStream(file, true));
    }
}

