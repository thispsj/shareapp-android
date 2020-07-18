/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.io.DataOutput
 *  java.io.DataOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.CharSequence
 *  java.lang.NullPointerException
 *  java.lang.String
 */
package io.netty.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ByteBufOutputStream
extends OutputStream
implements DataOutput {
    private final ByteBuf buffer;
    private final int startIndex;
    private final DataOutputStream utf8out;

    public ByteBufOutputStream(ByteBuf byteBuf) {
        this.utf8out = new DataOutputStream((OutputStream)this);
        if (byteBuf == null) {
            throw new NullPointerException("buffer");
        }
        this.buffer = byteBuf;
        this.startIndex = byteBuf.writerIndex();
    }

    public ByteBuf buffer() {
        return this.buffer;
    }

    public void write(int n2) throws IOException {
        this.buffer.writeByte(n2);
    }

    public void write(byte[] arrby) throws IOException {
        this.buffer.writeBytes(arrby);
    }

    public void write(byte[] arrby, int n2, int n3) throws IOException {
        if (n3 == 0) {
            return;
        }
        this.buffer.writeBytes(arrby, n2, n3);
    }

    public void writeBoolean(boolean bl) throws IOException {
        this.buffer.writeBoolean(bl);
    }

    public void writeByte(int n2) throws IOException {
        this.buffer.writeByte(n2);
    }

    public void writeBytes(String string2) throws IOException {
        ByteBufUtil.writeAscii(this.buffer, (CharSequence)string2);
    }

    public void writeChar(int n2) throws IOException {
        this.buffer.writeChar(n2);
    }

    public void writeChars(String string2) throws IOException {
        int n2 = string2.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.buffer.writeChar((int)string2.charAt(i2));
        }
    }

    public void writeDouble(double d2) throws IOException {
        this.buffer.writeDouble(d2);
    }

    public void writeFloat(float f2) throws IOException {
        this.buffer.writeFloat(f2);
    }

    public void writeInt(int n2) throws IOException {
        this.buffer.writeInt(n2);
    }

    public void writeLong(long l2) throws IOException {
        this.buffer.writeLong(l2);
    }

    public void writeShort(int n2) throws IOException {
        this.buffer.writeShort((int)((short)n2));
    }

    public void writeUTF(String string2) throws IOException {
        this.utf8out.writeUTF(string2);
    }

    public int writtenBytes() {
        return this.buffer.writerIndex() - this.startIndex;
    }
}

