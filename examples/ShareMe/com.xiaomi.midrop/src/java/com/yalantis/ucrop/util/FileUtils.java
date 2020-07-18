/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.ContentResolver
 *  android.content.ContentUris
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.provider.DocumentsContract
 *  android.provider.MediaStore
 *  android.provider.MediaStore$Audio
 *  android.provider.MediaStore$Audio$Media
 *  android.provider.MediaStore$Images
 *  android.provider.MediaStore$Images$Media
 *  android.provider.MediaStore$Video
 *  android.provider.MediaStore$Video$Media
 *  android.text.TextUtils
 *  android.util.Log
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.channels.FileChannel
 *  java.nio.channels.WritableByteChannel
 *  java.util.Locale
 */
package com.yalantis.ucrop.util;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Locale;

public class FileUtils {
    private static final String TAG = "FileUtils";

    private FileUtils() {
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void copyFile(String string2, String string3) throws IOException {
        Throwable throwable;
        FileChannel fileChannel;
        FileChannel fileChannel2;
        block9 : {
            block8 : {
                if (string2.equalsIgnoreCase(string3)) {
                    return;
                }
                fileChannel = null;
                FileChannel fileChannel3 = new FileInputStream(new File(string2)).getChannel();
                try {
                    fileChannel2 = new FileOutputStream(new File(string3)).getChannel();
                }
                catch (Throwable throwable2) {
                    fileChannel = fileChannel3;
                    throwable = throwable2;
                    fileChannel2 = null;
                    break block9;
                }
                try {
                    fileChannel3.transferTo(0L, fileChannel3.size(), (WritableByteChannel)fileChannel2);
                    fileChannel3.close();
                    if (fileChannel3 == null) break block8;
                }
                catch (Throwable throwable3) {
                    fileChannel = fileChannel3;
                    throwable = throwable3;
                }
                fileChannel3.close();
            }
            if (fileChannel2 == null) return;
            fileChannel2.close();
            return;
            break block9;
            catch (Throwable throwable4) {
                fileChannel2 = null;
            }
        }
        if (fileChannel != null) {
            fileChannel.close();
        }
        if (fileChannel2 == null) throw throwable;
        fileChannel2.close();
        throw throwable;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static String getDataColumn(Context context, Uri uri, String string2, String[] arrstring) {
        block13 : {
            block14 : {
                block12 : {
                    block10 : {
                        block11 : {
                            arrstring2 = new String[]{"_data"};
                            cursor = context.getContentResolver().query(uri, arrstring2, string2, arrstring, null);
                            if (cursor == null) break block10;
                            try {
                                if (!cursor.moveToFirst()) break block10;
                                string3 = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                                if (cursor == null) break block11;
                            }
                            catch (Exception exception) {
                                break block12;
                            }
                            cursor.close();
                        }
                        return string3;
                    }
                    if (cursor != null) {
                        do {
                            cursor.close();
                            return null;
                            break;
                        } while (true);
                    }
                    break block14;
                    catch (Throwable throwable) {
                        cursor = null;
                        break block13;
                    }
                    catch (Exception exception) {
                        cursor = null;
                    }
                }
                try {
                    locale = Locale.getDefault();
                    arrobject = new Object[]{var5_9.getMessage()};
                    Log.i((String)"FileUtils", (String)String.format((Locale)locale, (String)"getDataColumn: _data - [%s]", (Object[])arrobject));
                    if (cursor != null) ** continue;
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            return null;
        }
        if (cursor != null) {
            cursor.close();
        }
        throw var7_12;
    }

    @SuppressLint(value={"NewApi"})
    public static String getPath(Context context, Uri uri) {
        boolean bl = Build.VERSION.SDK_INT >= 19;
        if (bl && DocumentsContract.isDocumentUri((Context)context, (Uri)uri)) {
            if (FileUtils.isExternalStorageDocument(uri)) {
                String[] arrstring = DocumentsContract.getDocumentId((Uri)uri).split(":");
                if ("primary".equalsIgnoreCase(arrstring[0])) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append((Object)Environment.getExternalStorageDirectory());
                    stringBuilder.append("/");
                    stringBuilder.append(arrstring[1]);
                    return stringBuilder.toString();
                }
            } else if (FileUtils.isDownloadsDocument(uri)) {
                String string2 = DocumentsContract.getDocumentId((Uri)uri);
                if (!TextUtils.isEmpty((CharSequence)string2)) {
                    try {
                        String string3 = FileUtils.getDataColumn(context, ContentUris.withAppendedId((Uri)Uri.parse((String)"content://downloads/public_downloads"), (long)Long.valueOf((String)string2)), null, null);
                        return string3;
                    }
                    catch (NumberFormatException numberFormatException) {
                        Log.i((String)TAG, (String)numberFormatException.getMessage());
                        return null;
                    }
                }
            } else if (FileUtils.isMediaDocument(uri)) {
                Uri uri2;
                String[] arrstring = DocumentsContract.getDocumentId((Uri)uri).split(":");
                String string4 = arrstring[0];
                if ("image".equals((Object)string4)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals((Object)string4)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else {
                    boolean bl2 = "audio".equals((Object)string4);
                    uri2 = null;
                    if (bl2) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                }
                String[] arrstring2 = new String[]{arrstring[1]};
                return FileUtils.getDataColumn(context, uri2, "_id=?", arrstring2);
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                if (FileUtils.isGooglePhotosUri(uri)) {
                    return uri.getLastPathSegment();
                }
                return FileUtils.getDataColumn(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals((Object)uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals((Object)uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals((Object)uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals((Object)uri.getAuthority());
    }
}

