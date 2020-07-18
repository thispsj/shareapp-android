/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBufProcessor$1
 *  io.netty.buffer.ByteBufProcessor$10
 *  io.netty.buffer.ByteBufProcessor$2
 *  io.netty.buffer.ByteBufProcessor$3
 *  io.netty.buffer.ByteBufProcessor$4
 *  io.netty.buffer.ByteBufProcessor$5
 *  io.netty.buffer.ByteBufProcessor$6
 *  io.netty.buffer.ByteBufProcessor$7
 *  io.netty.buffer.ByteBufProcessor$8
 *  io.netty.buffer.ByteBufProcessor$9
 *  java.lang.Exception
 *  java.lang.Object
 */
package io.netty.buffer;

import io.netty.buffer.ByteBufProcessor;

public interface ByteBufProcessor {
    public static final ByteBufProcessor FIND_CR;
    public static final ByteBufProcessor FIND_CRLF;
    public static final ByteBufProcessor FIND_LF;
    public static final ByteBufProcessor FIND_LINEAR_WHITESPACE;
    public static final ByteBufProcessor FIND_NON_CR;
    public static final ByteBufProcessor FIND_NON_CRLF;
    public static final ByteBufProcessor FIND_NON_LF;
    public static final ByteBufProcessor FIND_NON_LINEAR_WHITESPACE;
    public static final ByteBufProcessor FIND_NON_NUL;
    public static final ByteBufProcessor FIND_NUL;

    static {
        FIND_NUL = new 1();
        FIND_NON_NUL = new 2();
        FIND_CR = new 3();
        FIND_NON_CR = new 4();
        FIND_LF = new 5();
        FIND_NON_LF = new 6();
        FIND_CRLF = new 7();
        FIND_NON_CRLF = new 8();
        FIND_LINEAR_WHITESPACE = new 9();
        FIND_NON_LINEAR_WHITESPACE = new 10();
    }

    public boolean process(byte var1) throws Exception;
}

