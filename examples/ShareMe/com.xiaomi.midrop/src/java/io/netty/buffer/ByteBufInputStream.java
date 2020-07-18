/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.io.DataInput
 *  java.io.DataInputStream
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package io.netty.buffer;

import io.netty.buffer.ByteBuf;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class ByteBufInputStream
extends InputStream
implements DataInput {
    private final ByteBuf buffer;
    private boolean closed;
    private final int endIndex;
    private final StringBuilder lineBuf;
    private boolean releaseOnClose;
    private final int startIndex;

    public ByteBufInputStream(ByteBuf byteBuf) {
        super(byteBuf, byteBuf.readableBytes());
    }

    public ByteBufInputStream(ByteBuf byteBuf, int n2) {
        super(byteBuf, n2, false);
    }

    public ByteBufInputStream(ByteBuf byteBuf, int n2, boolean bl) {
        this.lineBuf = new StringBuilder();
        if (byteBuf == null) {
            throw new NullPointerException("buffer");
        }
        if (n2 < 0) {
            if (bl) {
                byteBuf.release();
            }
            StringBuilder stringBuilder = new StringBuilder("length: ");
            stringBuilder.append(n2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (n2 > byteBuf.readableBytes()) {
            if (bl) {
                byteBuf.release();
            }
            StringBuilder stringBuilder = new StringBuilder("Too many bytes to be read - Needs ");
            stringBuilder.append(n2);
            stringBuilder.append(", maximum is ");
            stringBuilder.append(byteBuf.readableBytes());
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
        this.releaseOnClose = bl;
        this.buffer = byteBuf;
        this.startIndex = byteBuf.readerIndex();
        this.endIndex = n2 + this.startIndex;
        byteBuf.markReaderIndex();
    }

    public ByteBufInputStream(ByteBuf byteBuf, boolean bl) {
        super(byteBuf, byteBuf.readableBytes(), bl);
    }

    private void checkAvailable(int n2) throws IOException {
        if (n2 < 0) {
            throw new IndexOutOfBoundsException("fieldSize cannot be a negative number");
        }
        if (n2 > this.available()) {
            StringBuilder stringBuilder = new StringBuilder("fieldSize is too long! Length is ");
            stringBuilder.append(n2);
            stringBuilder.append(", but maximum is ");
            stringBuilder.append(this.available());
            throw new EOFException(stringBuilder.toString());
        }
    }

    public int available() throws IOException {
        return this.endIndex - this.buffer.readerIndex();
    }

    public void close() throws IOException {
        try {
            super.close();
            return;
        }
        finally {
            if (this.releaseOnClose && !this.closed) {
                this.closed = true;
                this.buffer.release();
            }
        }
    }

    public void mark(int n2) {
        this.buffer.markReaderIndex();
    }

    public boolean markSupported() {
        return true;
    }

    public int read() throws IOException {
        if (!this.buffer.isReadable()) {
            return -1;
        }
        return 255 & this.buffer.readByte();
    }

    public int read(byte[] arrby, int n2, int n3) throws IOException {
        int n4 = this.available();
        if (n4 == 0) {
            return -1;
        }
        int n5 = Math.min((int)n4, (int)n3);
        this.buffer.readBytes(arrby, n2, n5);
        return n5;
    }

    public boolean readBoolean() throws IOException {
        this.checkAvailable(1);
        return this.read() != 0;
    }

    public byte readByte() throws IOException {
        if (!this.buffer.isReadable()) {
            throw new EOFException();
        }
        return this.buffer.readByte();
    }

    public int readBytes() {
        return this.buffer.readerIndex() - this.startIndex;
    }

    public char readChar() throws IOException {
        return (char)this.readShort();
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble((long)this.readLong());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat((int)this.readInt());
    }

    public void readFully(byte[] arrby) throws IOException {
        this.readFully(arrby, 0, arrby.length);
    }

    public void readFully(byte[] arrby, int n2, int n3) throws IOException {
        ByteBufInputStream.super.checkAvailable(n3);
        this.buffer.readBytes(arrby, n2, n3);
    }

    public int readInt() throws IOException {
        this.checkAvailable(4);
        return this.buffer.readInt();
    }

    /*
     * Enabled aggressive block sorting
     */
    public String readLine() throws IOException {
        this.lineBuf.setLength(0);
        do {
            if (!this.buffer.isReadable()) {
                if (this.lineBuf.length() <= 0) return null;
                return this.lineBuf.toString();
            }
            short s2 = this.buffer.readUnsignedByte();
            if (s2 == 10) return this.lineBuf.toString();
            if (s2 == 13) {
                if (!this.buffer.isReadable()) return this.lineBuf.toString();
                if ((char)this.buffer.getUnsignedByte(this.buffer.readerIndex()) != '\n') return this.lineBuf.toString();
                this.buffer.skipBytes(1);
                return this.lineBuf.toString();
            }
            this.lineBuf.append((char)s2);
        } while (true);
    }

    public long readLong() throws IOException {
        this.checkAvailable(8);
        return this.buffer.readLong();
    }

    public short readShort() throws IOException {
        this.checkAvailable(2);
        return this.buffer.readShort();
    }

    public String readUTF() throws IOException {
        return DataInputStream.readUTF((DataInput)this);
    }

    public int readUnsignedByte() throws IOException {
        return 255 & this.readByte();
    }

    public int readUnsignedShort() throws IOException {
        return 65535 & this.readShort();
    }

    public void reset() throws IOException {
        this.buffer.resetReaderIndex();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public long skip(long l2) throws IOException {
        int n2;
        if (l2 > Integer.MAX_VALUE) {
            n2 = Integer.MAX_VALUE;
            do {
                return this.skipBytes(n2);
                break;
            } while (true);
        }
        n2 = (int)l2;
        return this.skipBytes(n2);
    }

    public int skipBytes(int n2) throws IOException {
        int n3 = Math.min((int)this.available(), (int)n2);
        this.buffer.skipBytes(n3);
        return n3;
    }
}

