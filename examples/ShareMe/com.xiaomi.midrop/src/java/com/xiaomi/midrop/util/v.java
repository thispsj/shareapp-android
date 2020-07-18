/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 *  android.provider.MediaStore
 *  android.provider.MediaStore$Files
 *  android.text.TextUtils
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.LinkedList
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Properties
 *  java.util.Set
 */
package com.xiaomi.midrop.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.xiaomi.midrop.MiDropApplication;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public final class v {
    private static final Map<String, LinkedList<String>> a = new HashMap();
    private static final Map<String, String> b = new HashMap();

    static {
        v.a("application/andrew-inset", "ez");
        v.a("application/dsptype", "tsp");
        v.a("application/futuresplash", "spl");
        v.a("application/hta", "hta");
        v.a("application/mac-binhex40", "hqx");
        v.a("application/mac-compactpro", "cpt");
        v.a("application/mathematica", "nb");
        v.a("application/msaccess", "mdb");
        v.a("application/oda", "oda");
        v.a("application/ogg", "ogg");
        v.a("application/ogg", "oga");
        v.a("audio/aac", "aac");
        v.a("application/pdf", "pdf");
        v.a("application/pgp-keys", "key");
        v.a("application/pgp-signature", "pgp");
        v.a("application/pics-rules", "prf");
        v.a("application/pkix-cert", "cer");
        v.a("application/x-rar-compressed", "rar");
        v.a("application/rdf+xml", "rdf");
        v.a("application/rss+xml", "rss");
        v.a("application/zip", "zip");
        v.a("application/vnd.android.package-archive", "apk");
        v.a("application/vnd.cinderella", "cdy");
        v.a("application/vnd.ms-pki.stl", "stl");
        v.a("application/vnd.oasis.opendocument.database", "odb");
        v.a("application/vnd.oasis.opendocument.formula", "odf");
        v.a("application/vnd.oasis.opendocument.graphics", "odg");
        v.a("application/vnd.oasis.opendocument.graphics-template", "otg");
        v.a("application/vnd.oasis.opendocument.image", "odi");
        v.a("application/vnd.oasis.opendocument.spreadsheet", "ods");
        v.a("application/vnd.oasis.opendocument.spreadsheet-template", "ots");
        v.a("application/vnd.oasis.opendocument.text", "odt");
        v.a("application/vnd.oasis.opendocument.text-master", "odm");
        v.a("application/vnd.oasis.opendocument.text-template", "ott");
        v.a("application/vnd.oasis.opendocument.text-web", "oth");
        v.a("application/vnd.google-earth.kml+xml", "kml");
        v.a("application/vnd.google-earth.kmz", "kmz");
        v.a("application/msword", "doc");
        v.a("application/msword", "dot");
        v.a("application/vnd.openxmlformats-officedocument.wordprocessingml.document", "docx");
        v.a("application/vnd.openxmlformats-officedocument.wordprocessingml.template", "dotx");
        v.a("application/vnd.ms-excel", "xls");
        v.a("application/vnd.ms-excel", "xlt");
        v.a("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "xlsx");
        v.a("application/vnd.openxmlformats-officedocument.spreadsheetml.template", "xltx");
        v.a("application/vnd.ms-powerpoint", "ppt");
        v.a("application/vnd.ms-powerpoint", "pot");
        v.a("application/vnd.ms-powerpoint", "pps");
        v.a("application/vnd.openxmlformats-officedocument.presentationml.presentation", "pptx");
        v.a("application/vnd.openxmlformats-officedocument.presentationml.template", "potx");
        v.a("application/vnd.openxmlformats-officedocument.presentationml.slideshow", "ppsx");
        v.a("application/vnd.rim.cod", "cod");
        v.a("application/vnd.smaf", "mmf");
        v.a("application/vnd.stardivision.calc", "sdc");
        v.a("application/vnd.stardivision.draw", "sda");
        v.a("application/vnd.stardivision.impress", "sdd");
        v.a("application/vnd.stardivision.impress", "sdp");
        v.a("application/vnd.stardivision.math", "smf");
        v.a("application/vnd.stardivision.writer", "sdw");
        v.a("application/vnd.stardivision.writer", "vor");
        v.a("application/vnd.stardivision.writer-global", "sgl");
        v.a("application/vnd.sun.xml.calc", "sxc");
        v.a("application/vnd.sun.xml.calc.template", "stc");
        v.a("application/vnd.sun.xml.draw", "sxd");
        v.a("application/vnd.sun.xml.draw.template", "std");
        v.a("application/vnd.sun.xml.impress", "sxi");
        v.a("application/vnd.sun.xml.impress.template", "sti");
        v.a("application/vnd.sun.xml.math", "sxm");
        v.a("application/vnd.sun.xml.writer", "sxw");
        v.a("application/vnd.sun.xml.writer.global", "sxg");
        v.a("application/vnd.sun.xml.writer.template", "stw");
        v.a("application/vnd.visio", "vsd");
        v.a("application/x-abiword", "abw");
        v.a("application/x-apple-diskimage", "dmg");
        v.a("application/x-bcpio", "bcpio");
        v.a("application/x-bittorrent", "torrent");
        v.a("application/x-cdf", "cdf");
        v.a("application/x-cdlink", "vcd");
        v.a("application/x-chess-pgn", "pgn");
        v.a("application/x-cpio", "cpio");
        v.a("application/x-debian-package", "deb");
        v.a("application/x-debian-package", "udeb");
        v.a("application/x-director", "dcr");
        v.a("application/x-director", "dir");
        v.a("application/x-director", "dxr");
        v.a("application/x-dms", "dms");
        v.a("application/x-doom", "wad");
        v.a("application/x-dvi", "dvi");
        v.a("application/x-flac", "flac");
        v.a("application/x-font", "pfa");
        v.a("application/x-font", "pfb");
        v.a("application/x-font", "gsf");
        v.a("application/x-font", "pcf");
        v.a("application/x-font", "pcf.Z");
        v.a("application/x-freemind", "mm");
        v.a("application/x-futuresplash", "spl");
        v.a("application/x-gnumeric", "gnumeric");
        v.a("application/x-go-sgf", "sgf");
        v.a("application/x-graphing-calculator", "gcf");
        v.a("application/x-gtar", "gtar");
        v.a("application/x-gtar", "tgz");
        v.a("application/x-gtar", "taz");
        v.a("application/x-hdf", "hdf");
        v.a("application/x-ica", "ica");
        v.a("application/x-internet-signup", "ins");
        v.a("application/x-internet-signup", "isp");
        v.a("application/x-iphone", "iii");
        v.a("application/x-iso9660-image", "iso");
        v.a("application/x-jmol", "jmz");
        v.a("application/x-kchart", "chrt");
        v.a("application/x-killustrator", "kil");
        v.a("application/x-koan", "skp");
        v.a("application/x-koan", "skd");
        v.a("application/x-koan", "skt");
        v.a("application/x-koan", "skm");
        v.a("application/x-kpresenter", "kpr");
        v.a("application/x-kpresenter", "kpt");
        v.a("application/x-kspread", "ksp");
        v.a("application/x-kword", "kwd");
        v.a("application/x-kword", "kwt");
        v.a("application/x-latex", "latex");
        v.a("application/x-lha", "lha");
        v.a("application/x-lzh", "lzh");
        v.a("application/x-lzx", "lzx");
        v.a("application/x-maker", "frm");
        v.a("application/x-maker", "maker");
        v.a("application/x-maker", "frame");
        v.a("application/x-maker", "fb");
        v.a("application/x-maker", "book");
        v.a("application/x-maker", "fbdoc");
        v.a("application/x-mif", "mif");
        v.a("application/x-ms-wmd", "wmd");
        v.a("application/x-ms-wmz", "wmz");
        v.a("application/x-msi", "msi");
        v.a("application/x-ns-proxy-autoconfig", "pac");
        v.a("application/x-nwc", "nwc");
        v.a("application/x-object", "o");
        v.a("application/x-oz-application", "oza");
        v.a("application/x-pem-file", "pem");
        v.a("application/x-pkcs12", "p12");
        v.a("application/x-pkcs12", "pfx");
        v.a("application/x-pkcs7-certreqresp", "p7r");
        v.a("application/x-pkcs7-crl", "crl");
        v.a("application/x-quicktimeplayer", "qtl");
        v.a("application/x-shar", "shar");
        v.a("application/x-shockwave-flash", "swf");
        v.a("application/x-stuffit", "sit");
        v.a("application/x-sv4cpio", "sv4cpio");
        v.a("application/x-sv4crc", "sv4crc");
        v.a("application/x-tar", "tar");
        v.a("application/x-texinfo", "texinfo");
        v.a("application/x-texinfo", "texi");
        v.a("application/x-troff", "t");
        v.a("application/x-troff", "roff");
        v.a("application/x-troff-man", "man");
        v.a("application/x-ustar", "ustar");
        v.a("application/x-wais-source", "src");
        v.a("application/x-wingz", "wz");
        v.a("application/x-webarchive", "webarchive");
        v.a("application/x-webarchive-xml", "webarchivexml");
        v.a("application/x-x509-ca-cert", "crt");
        v.a("application/x-x509-user-cert", "crt");
        v.a("application/x-x509-server-cert", "crt");
        v.a("application/x-xcf", "xcf");
        v.a("application/x-xfig", "fig");
        v.a("application/xhtml+xml", "xhtml");
        v.a("audio/3gpp", "3gpp");
        v.a("audio/3gpp2", "3gpp2");
        v.a("audio/amr", "amr");
        v.a("audio/amr-wb", "awb");
        v.a("audio/basic", "snd");
        v.a("audio/midi", "mid");
        v.a("audio/midi", "midi");
        v.a("audio/midi", "kar");
        v.a("audio/midi", "xmf");
        v.a("audio/mobile-xmf", "mxmf");
        v.a("audio/mpeg", "mpga");
        v.a("audio/mpeg", "mpega");
        v.a("audio/mpeg", "mp2");
        v.a("audio/mpeg", "mp3");
        v.a("audio/mpeg", "m4a");
        v.a("audio/mpegurl", "m3u");
        v.a("audio/prs.sid", "sid");
        v.a("audio/x-aiff", "aif");
        v.a("audio/x-aiff", "aiff");
        v.a("audio/x-aiff", "aifc");
        v.a("audio/x-gsm", "gsm");
        v.a("audio/x-mpegurl", "m3u");
        v.a("audio/x-ms-wma", "wma");
        v.a("audio/x-ms-wax", "wax");
        v.a("audio/x-monkeys-audio", "ape");
        v.a("audio/x-pn-realaudio", "ra");
        v.a("video/x-pn-realvideo", "rm");
        v.a("video/x-pn-realvideo", "rmvb");
        v.a("audio/x-pn-realaudio", "ram");
        v.a("audio/x-realaudio", "ra");
        v.a("audio/x-scpls", "pls");
        v.a("audio/x-sd2", "sd2");
        v.a("audio/x-wav", "wav");
        v.a("image/bmp", "bmp");
        v.a("audio/x-qcp", "qcp");
        v.a("image/gif", "gif");
        v.a("image/ico", "cur");
        v.a("image/ico", "ico");
        v.a("image/ief", "ief");
        v.a("image/jpeg", "jpeg");
        v.a("image/jpeg", "jpg");
        v.a("image/jpeg", "jpe");
        v.a("image/pcx", "pcx");
        v.a("image/png", "png");
        v.a("image/svg+xml", "svg");
        v.a("image/svg+xml", "svgz");
        v.a("image/vnd.djvu", "djvu");
        v.a("image/vnd.djvu", "djv");
        v.a("image/vnd.wap.wbmp", "wbmp");
        v.a("image/x-cmu-raster", "ras");
        v.a("image/x-coreldraw", "cdr");
        v.a("image/x-coreldrawpattern", "pat");
        v.a("image/x-coreldrawtemplate", "cdt");
        v.a("image/x-corelphotopaint", "cpt");
        v.a("image/x-icon", "ico");
        v.a("image/x-jg", "art");
        v.a("image/x-jng", "jng");
        v.a("image/x-ms-bmp", "bmp");
        v.a("image/x-photoshop", "psd");
        v.a("image/x-portable-anymap", "pnm");
        v.a("image/x-portable-bitmap", "pbm");
        v.a("image/x-portable-graymap", "pgm");
        v.a("image/x-portable-pixmap", "ppm");
        v.a("image/x-rgb", "rgb");
        v.a("image/x-xbitmap", "xbm");
        v.a("image/x-xpixmap", "xpm");
        v.a("image/x-xwindowdump", "xwd");
        v.a("model/iges", "igs");
        v.a("model/iges", "iges");
        v.a("model/mesh", "msh");
        v.a("model/mesh", "mesh");
        v.a("model/mesh", "silo");
        v.a("text/calendar", "ics");
        v.a("text/calendar", "icz");
        v.a("text/comma-separated-values", "csv");
        v.a("text/css", "css");
        v.a("text/html", "htm");
        v.a("text/html", "html");
        v.a("text/h323", "323");
        v.a("text/iuls", "uls");
        v.a("text/mathml", "mml");
        v.a("text/plain", "txt");
        v.a("text/plain", "asc");
        v.a("text/plain", "text");
        v.a("text/plain", "diff");
        v.a("text/plain", "po");
        v.a("text/richtext", "rtx");
        v.a("text/rtf", "rtf");
        v.a("text/text", "phps");
        v.a("text/tab-separated-values", "tsv");
        v.a("text/xml", "xml");
        v.a("text/x-bibtex", "bib");
        v.a("text/x-boo", "boo");
        v.a("text/x-c++hdr", "h++");
        v.a("text/x-c++hdr", "hpp");
        v.a("text/x-c++hdr", "hxx");
        v.a("text/x-c++hdr", "hh");
        v.a("text/x-c++src", "c++");
        v.a("text/x-c++src", "cpp");
        v.a("text/x-c++src", "cxx");
        v.a("text/x-chdr", "h");
        v.a("text/x-component", "htc");
        v.a("text/x-csh", "csh");
        v.a("text/x-csrc", "c");
        v.a("text/x-dsrc", "d");
        v.a("text/x-haskell", "hs");
        v.a("text/x-java", "java");
        v.a("text/x-literate-haskell", "lhs");
        v.a("text/x-moc", "moc");
        v.a("text/x-pascal", "p");
        v.a("text/x-pascal", "pas");
        v.a("text/x-pcs-gcd", "gcd");
        v.a("text/x-setext", "etx");
        v.a("text/x-tcl", "tcl");
        v.a("text/x-tex", "tex");
        v.a("text/x-tex", "ltx");
        v.a("text/x-tex", "sty");
        v.a("text/x-tex", "cls");
        v.a("text/x-vcalendar", "vcs");
        v.a("text/x-vcard", "vcf");
        v.a("video/3gpp", "3gpp");
        v.a("video/3gpp", "3gp");
        v.a("video/3gpp", "3g2");
        v.a("video/dl", "dl");
        v.a("video/dv", "dif");
        v.a("video/dv", "dv");
        v.a("video/fli", "fli");
        v.a("video/m4v", "m4v");
        v.a("video/mpeg", "mpeg");
        v.a("video/mpeg", "mpg");
        v.a("video/mpeg", "mpe");
        v.a("video/mp4", "mp4");
        v.a("video/quicktime", "qt");
        v.a("video/quicktime", "mov");
        v.a("video/vnd.mpegurl", "mxu");
        v.a("video/x-la-asf", "lsf");
        v.a("video/x-la-asf", "lsx");
        v.a("video/x-mng", "mng");
        v.a("video/x-ms-asf", "asf");
        v.a("video/x-ms-asf", "asx");
        v.a("video/x-ms-wm", "wm");
        v.a("video/x-ms-wmv", "wmv");
        v.a("video/x-ms-wmx", "wmx");
        v.a("video/x-ms-wvx", "wvx");
        v.a("video/x-msvideo", "avi");
        v.a("video/x-sgi-movie", "movie");
        v.a("video/x-flv", "flv");
        v.a("video/x-matroska", "mkv");
        v.a("audio/x-matroska", "mka");
        v.a("application/octet-stream", "vob");
        v.a("video/MP2T", "ts");
        v.a("video/mp4", "f4v");
        v.a("x-conference/x-cooltalk", "ice");
        v.a("x-epoc/x-sisx-app", "sisx");
        v.a("application/wps", "wps");
        v.a("application/wpt", "wpt");
        v.a("application/et", "et");
        v.a("application/ett", "ett");
        v.a("application/dps", "dps");
        v.a("application/dpt", "dpt");
        v.a("application/metastream", "mtz");
        v.b();
    }

    /*
     * Exception decompiling
     */
    private static InputStream a() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl21.1 : LDC_W : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
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

    public static String a(String string2) {
        String string3 = !TextUtils.isEmpty((CharSequence)string2) ? (String)b.get((Object)string2.toLowerCase()) : null;
        if (TextUtils.isEmpty(string3)) {
            string3 = "*/*";
        }
        return string3;
    }

    private static void a(String string2, String string3) {
        LinkedList linkedList = !a.containsKey((Object)string2) ? new LinkedList() : (LinkedList)a.get((Object)string2);
        linkedList.add((Object)string3);
        a.put((Object)string2, (Object)linkedList);
        b.put((Object)string3, (Object)string2);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static String b(String string2) {
        Throwable throwable;
        Cursor cursor;
        block9 : {
            Cursor cursor2;
            String string3;
            block8 : {
                Uri uri = MediaStore.Files.getContentUri((String)"external");
                cursor = null;
                cursor2 = MiDropApplication.a().getApplicationContext().getContentResolver().query(uri, new String[]{"mime_type"}, "_data=?", new String[]{string2}, null);
                string3 = null;
                if (cursor2 == null) break block8;
                try {
                    boolean bl = cursor2.moveToFirst();
                    string3 = null;
                    if (!bl) break block8;
                    string3 = cursor2.getString(0);
                }
                catch (Throwable throwable2) {
                    cursor = cursor2;
                    throwable = throwable2;
                    break block9;
                }
            }
            try {
                cursor2.close();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            if (!TextUtils.isEmpty(string3)) return string3;
            return "*/*";
            catch (Throwable throwable3) {
                // empty catch block
            }
        }
        try {
            cursor.close();
            throw throwable;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        throw throwable;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static void b() {
        InputStream inputStream = v.a();
        if (inputStream == null) {
            return;
        }
        Properties properties = new Properties();
        properties.load(inputStream);
        for (Map.Entry entry : properties.entrySet()) {
            String string2 = (String)entry.getKey();
            v.a((String)entry.getValue(), string2);
        }
        {
            catch (Throwable throwable) {
                try {
                    inputStream.close();
                    throw throwable;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
                throw throwable;
            }
        }
        try {
            try {
                inputStream.close();
                return;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return;
            }
        }
        catch (IOException iOException) {
            return;
        }
    }
}

