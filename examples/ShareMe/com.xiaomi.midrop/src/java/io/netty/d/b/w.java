/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.io.PrintStream
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.Throwable
 */
package io.netty.d.b;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public final class w {
    public static String a(Throwable throwable) {
        String string2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream((OutputStream)byteArrayOutputStream);
        throwable.printStackTrace(printStream);
        printStream.flush();
        try {
            string2 = new String(byteArrayOutputStream.toByteArray());
        }
        catch (Throwable throwable2) {
            try {
                byteArrayOutputStream.close();
            }
            catch (IOException iOException) {}
            throw throwable2;
        }
        try {
            byteArrayOutputStream.close();
        }
        catch (IOException iOException) {}
        return string2;
    }

    public static <T extends Throwable> T a(T t2, Class<?> class_, String string2) {
        StackTraceElement[] arrstackTraceElement = new StackTraceElement[]{new StackTraceElement(class_.getName(), string2, null, -1)};
        t2.setStackTrace(arrstackTraceElement);
        return t2;
    }
}

