/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.b.l
 *  io.netty.buffer.ByteBuf
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.List
 */
package io.netty.c.a;

import io.netty.b.l;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufProcessor;
import io.netty.c.a.a;
import io.netty.c.a.g;
import java.util.List;

public final class e
extends a {
    private final int d = 1048576;
    private final boolean e = false;
    private final boolean g = true;
    private boolean h;
    private int i;
    private int j;

    public e() {
        this(0);
    }

    private e(byte by) {
    }

    private void a(l l2, int n2) {
        e.super.a(l2, String.valueOf((int)n2));
    }

    private void a(l l2, String string2) {
        StringBuilder stringBuilder = new StringBuilder("frame length (");
        stringBuilder.append(string2);
        stringBuilder.append(") exceeds the allowed maximum (");
        stringBuilder.append(this.d);
        stringBuilder.append(')');
        l2.a((Throwable)((Object)new g(stringBuilder.toString())));
    }

    @Override
    protected final void a(l l2, ByteBuf byteBuf, List<Object> list) throws Exception {
        ByteBuf byteBuf2;
        block16 : {
            block17 : {
                int n2;
                block15 : {
                    int n3;
                    int n4;
                    block12 : {
                        block13 : {
                            ByteBuf byteBuf3;
                            block14 : {
                                int n5 = byteBuf.readableBytes();
                                n4 = byteBuf.forEachByte(byteBuf.readerIndex() + this.j, n5 - this.j, ByteBufProcessor.FIND_LF);
                                if (n4 >= 0) {
                                    this.j = 0;
                                    if (n4 > 0 && byteBuf.getByte(n4 - 1) == 13) {
                                        --n4;
                                    }
                                } else {
                                    this.j = n5;
                                }
                                boolean bl = this.h;
                                byteBuf2 = null;
                                n3 = 2;
                                if (bl) break block12;
                                if (n4 < 0) break block13;
                                n2 = n4 - byteBuf.readerIndex();
                                if (byteBuf.getByte(n4) != 13) {
                                    n3 = 1;
                                }
                                if (n2 <= this.d) break block14;
                                byteBuf.readerIndex(n4 + n3);
                                break block15;
                            }
                            if (this.g) {
                                byteBuf3 = byteBuf.readSlice(n2);
                                byteBuf.skipBytes(n3);
                            } else {
                                byteBuf3 = byteBuf.readSlice(n2 + n3);
                            }
                            byteBuf2 = byteBuf3.retain();
                            break block16;
                        }
                        int n6 = byteBuf.readableBytes();
                        int n7 = this.d;
                        byteBuf2 = null;
                        if (n6 > n7) {
                            this.i = n6;
                            byteBuf.readerIndex(byteBuf.writerIndex());
                            this.h = true;
                            this.j = 0;
                            boolean bl = this.e;
                            byteBuf2 = null;
                            if (bl) {
                                StringBuilder stringBuilder = new StringBuilder("over ");
                                stringBuilder.append(this.i);
                                e.super.a(l2, stringBuilder.toString());
                                byteBuf2 = null;
                            }
                        }
                        break block16;
                    }
                    if (n4 < 0) break block17;
                    n2 = n4 + this.i - byteBuf.readerIndex();
                    if (byteBuf.getByte(n4) != 13) {
                        n3 = 1;
                    }
                    byteBuf.readerIndex(n4 + n3);
                    this.i = 0;
                    this.h = false;
                    boolean bl = this.e;
                    byteBuf2 = null;
                    if (bl) break block16;
                }
                e.super.a(l2, n2);
                byteBuf2 = null;
                break block16;
            }
            this.i += byteBuf.readableBytes();
            byteBuf.readerIndex(byteBuf.writerIndex());
        }
        if (byteBuf2 != null) {
            list.add(byteBuf2);
        }
    }
}

