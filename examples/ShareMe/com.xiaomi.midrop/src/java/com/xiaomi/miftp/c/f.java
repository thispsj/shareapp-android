/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  org.a.ae
 */
package com.xiaomi.miftp.c;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import org.a.ae;

public final class f {
    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static ResolveInfo a(Intent intent) {
        Class<f> class_ = f.class;
        // MONITORENTER : com.xiaomi.miftp.c.f.class
        ResolveInfo resolveInfo = ae.e().getPackageManager().resolveActivity(intent, 0);
        // MONITOREXIT : class_
        return resolveInfo;
        catch (Exception exception) {
            exception.printStackTrace();
            // MONITOREXIT : class_
            return null;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static boolean a(String string2) {
        block5 : {
            Class<f> class_ = f.class;
            // MONITORENTER : com.xiaomi.miftp.c.f.class
            PackageInfo packageInfo = ae.e().getPackageManager().getPackageInfo(string2, 0);
            if (packageInfo == null) break block5;
            return true;
        }
        // MONITOREXIT : class_
        return false;
        {
            catch (Throwable throwable22) {
                throw throwable22;
            }
            catch (Exception exception) {}
            {
                exception.printStackTrace();
                // MONITOREXIT : class_
                return false;
            }
        }
    }
}

