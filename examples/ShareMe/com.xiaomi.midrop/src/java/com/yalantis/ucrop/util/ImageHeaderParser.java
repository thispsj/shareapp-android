/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.support.a.a
 *  android.util.Log
 *  com.yalantis.ucrop.util.ImageHeaderParser$StreamReader
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.charset.Charset
 */
package com.yalantis.ucrop.util;

import android.support.a.a;
import android.util.Log;
import com.yalantis.ucrop.util.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/*
 * Exception performing whole class analysis.
 */
public class ImageHeaderParser {
    private static final int[] BYTES_PER_FORMAT;
    private static final int EXIF_MAGIC_NUMBER = 65496;
    private static final int EXIF_SEGMENT_TYPE = 225;
    private static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
    private static final String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    private static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
    private static final int MARKER_EOI = 217;
    private static final int MOTOROLA_TIFF_MAGIC_NUMBER = 19789;
    private static final int ORIENTATION_TAG_TYPE = 274;
    private static final int SEGMENT_SOS = 218;
    private static final int SEGMENT_START_ID = 255;
    private static final String TAG = "ImageHeaderParser";
    public static final int UNKNOWN_ORIENTATION = -1;
    private final Reader reader;

    static {
        JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(Charset.forName((String)"UTF-8"));
        BYTES_PER_FORMAT = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    }

    public ImageHeaderParser(InputStream inputStream) {
        this.reader = new /* Unavailable Anonymous Inner Class!! */;
    }

    private static int calcTagOffset(int n2, int n3) {
        return n2 + 2 + n3 * 12;
    }

    /*
     * Exception decompiling
     */
    public static void copyExif(a var0_1, int var1, int var2_3, String var3_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 9[UNCONDITIONALDOLOOP]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1113)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:588)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    private static boolean handles(int n2) {
        return (n2 & 65496) == 65496 || n2 == 19789 || n2 == 18761;
        {
        }
    }

    private boolean hasJpegExifPreamble(byte[] arrby, int n2) {
        boolean bl = arrby != null && n2 > JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length;
        if (bl) {
            for (int i2 = 0; i2 < JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length; ++i2) {
                if (arrby[i2] == JPEG_EXIF_SEGMENT_PREAMBLE_BYTES[i2]) continue;
                return false;
            }
        }
        return bl;
    }

    private int moveToExifSegmentAndGetLength() throws IOException {
        int n2;
        block7 : {
            long l2;
            short s2;
            long l3;
            Reader reader;
            do {
                short s3;
                if ((s3 = this.reader.getUInt8()) != 255) {
                    if (Log.isLoggable((String)TAG, (int)3)) {
                        StringBuilder stringBuilder = new StringBuilder("Unknown segmentId=");
                        stringBuilder.append((int)s3);
                        Log.d((String)TAG, (String)stringBuilder.toString());
                    }
                    return -1;
                }
                s2 = this.reader.getUInt8();
                if (s2 == 218) {
                    return -1;
                }
                if (s2 == 217) {
                    if (Log.isLoggable((String)TAG, (int)3)) {
                        Log.d((String)TAG, (String)"Found MARKER_EOI in exif segment");
                    }
                    return -1;
                }
                n2 = -2 + this.reader.getUInt16();
                if (s2 == 225) break block7;
            } while ((l2 = (reader = this.reader).skip(l3 = (long)n2)) == l3);
            if (Log.isLoggable((String)TAG, (int)3)) {
                StringBuilder stringBuilder = new StringBuilder("Unable to skip enough data, type: ");
                stringBuilder.append((int)s2);
                stringBuilder.append(", wanted to skip: ");
                stringBuilder.append(n2);
                stringBuilder.append(", but actually skipped: ");
                stringBuilder.append(l2);
                Log.d((String)TAG, (String)stringBuilder.toString());
            }
            return -1;
        }
        return n2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static int parseExifSegment(RandomAccessReader var0) {
        var1_1 = var0.getInt16(6);
        if (var1_1 == 19789) ** GOTO lbl10
        if (var1_1 == 18761) {
            var2_2 = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable((String)"ImageHeaderParser", (int)3)) {
                var33_3 = new StringBuilder("Unknown endianness = ");
                var33_3.append((int)var1_1);
                Log.d((String)"ImageHeaderParser", (String)var33_3.toString());
            }
lbl10: // 4 sources:
            var2_2 = ByteOrder.BIG_ENDIAN;
        }
        var0.order(var2_2);
        var3_4 = 6 + var0.getInt32(10);
        var4_5 = var0.getInt16(var3_4);
        var5_6 = 0;
        while (var5_6 < var4_5) {
            block11 : {
                block14 : {
                    block16 : {
                        block12 : {
                            block17 : {
                                block15 : {
                                    block13 : {
                                        var6_9 = ImageHeaderParser.calcTagOffset(var3_4, var5_6);
                                        var7_18 = var0.getInt16(var6_9);
                                        if (var7_18 != 274) break block11;
                                        var8_7 = var0.getInt16(var6_9 + 2);
                                        if (var8_7 <= 0 || var8_7 > 12) break block12;
                                        var14_17 = var0.getInt32(var6_9 + 4);
                                        if (var14_17 >= 0) break block13;
                                        if (!Log.isLoggable((String)"ImageHeaderParser", (int)3)) break block11;
                                        var9_11 = "ImageHeaderParser";
                                        var12_15 = "Negative tiff component count";
                                        break block14;
                                    }
                                    if (Log.isLoggable((String)"ImageHeaderParser", (int)3)) {
                                        var15_8 = new StringBuilder("Got tagIndex=");
                                        var15_8.append(var5_6);
                                        var15_8.append(" tagType=");
                                        var15_8.append((int)var7_18);
                                        var15_8.append(" formatCode=");
                                        var15_8.append((int)var8_7);
                                        var15_8.append(" componentCount=");
                                        var15_8.append(var14_17);
                                        Log.d((String)"ImageHeaderParser", (String)var15_8.toString());
                                    }
                                    if ((var24_13 = var14_17 + ImageHeaderParser.BYTES_PER_FORMAT[var8_7]) <= 4) break block15;
                                    if (!Log.isLoggable((String)"ImageHeaderParser", (int)3)) break block11;
                                    var9_11 = "ImageHeaderParser";
                                    var10_16 = new StringBuilder("Got byte count > 4, not orientation, continuing, formatCode=");
                                    break block16;
                                }
                                var25_12 = var6_9 + 8;
                                if (var25_12 < 0 || var25_12 > var0.length()) break block17;
                                if (var24_13 >= 0) {
                                    if (var24_13 + var25_12 <= var0.length()) return var0.getInt16(var25_12);
                                }
                                if (!Log.isLoggable((String)"ImageHeaderParser", (int)3)) break block11;
                                var9_11 = "ImageHeaderParser";
                                var31_14 = new StringBuilder("Illegal number of bytes for TI tag data tagType=");
                                var31_14.append((int)var7_18);
                                var12_15 = var31_14.toString();
                                break block14;
                            }
                            if (Log.isLoggable((String)"ImageHeaderParser", (int)3)) {
                                var26_10 = new StringBuilder("Illegal tagValueOffset=");
                                var26_10.append(var25_12);
                                var26_10.append(" tagType=");
                                var26_10.append((int)var7_18);
                                Log.d((String)"ImageHeaderParser", (String)var26_10.toString());
                            }
                            break block11;
                        }
                        if (!Log.isLoggable((String)"ImageHeaderParser", (int)3)) break block11;
                        var9_11 = "ImageHeaderParser";
                        var10_16 = new StringBuilder("Got invalid format code = ");
                    }
                    var10_16.append((int)var8_7);
                    var12_15 = var10_16.toString();
                }
                Log.d((String)var9_11, (String)var12_15);
            }
            ++var5_6;
        }
        return -1;
    }

    private int parseExifSegment(byte[] arrby, int n2) throws IOException {
        int n3 = this.reader.read(arrby, n2);
        if (n3 != n2) {
            if (Log.isLoggable((String)TAG, (int)3)) {
                StringBuilder stringBuilder = new StringBuilder("Unable to read exif segment data, length: ");
                stringBuilder.append(n2);
                stringBuilder.append(", actually read: ");
                stringBuilder.append(n3);
                Log.d((String)TAG, (String)stringBuilder.toString());
            }
            return -1;
        }
        if (ImageHeaderParser.super.hasJpegExifPreamble(arrby, n2)) {
            return ImageHeaderParser.parseExifSegment(new RandomAccessReader(arrby, n2));
        }
        if (Log.isLoggable((String)TAG, (int)3)) {
            Log.d((String)TAG, (String)"Missing jpeg exif preamble");
        }
        return -1;
    }

    public int getOrientation() throws IOException {
        int n2 = this.reader.getUInt16();
        if (!ImageHeaderParser.handles(n2)) {
            if (Log.isLoggable((String)TAG, (int)3)) {
                StringBuilder stringBuilder = new StringBuilder("Parser doesn't handle magic number: ");
                stringBuilder.append(n2);
                Log.d((String)TAG, (String)stringBuilder.toString());
            }
            return -1;
        }
        int n3 = this.moveToExifSegmentAndGetLength();
        if (n3 == -1) {
            if (Log.isLoggable((String)TAG, (int)3)) {
                Log.d((String)TAG, (String)"Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        return this.parseExifSegment(new byte[n3], n3);
    }

    private static class RandomAccessReader {
        private final ByteBuffer data;

        public RandomAccessReader(byte[] arrby, int n2) {
            this.data = (ByteBuffer)ByteBuffer.wrap((byte[])arrby).order(ByteOrder.BIG_ENDIAN).limit(n2);
        }

        public short getInt16(int n2) {
            return this.data.getShort(n2);
        }

        public int getInt32(int n2) {
            return this.data.getInt(n2);
        }

        public int length() {
            return this.data.remaining();
        }

        public void order(ByteOrder byteOrder) {
            this.data.order(byteOrder);
        }
    }

    private static interface Reader {
        public int getUInt16() throws IOException;

        public short getUInt8() throws IOException;

        public int read(byte[] var1, int var2) throws IOException;

        public long skip(long var1) throws IOException;
    }

}

