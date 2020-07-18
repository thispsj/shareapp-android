/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.bluetooth.le.AdvertiseCallback
 *  android.bluetooth.le.AdvertiseSettings
 *  android.bluetooth.le.BluetoothLeAdvertiser
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  midrop.service.c.d
 */
package b.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import midrop.service.c.d;

public final class b {
    public BluetoothLeAdvertiser a = BluetoothAdapter.getDefaultAdapter().getBluetoothLeAdvertiser();
    public a b;
    public b c = null;

    public static interface a {
        public void a();
    }

    private final class b
    extends AdvertiseCallback {
        final /* synthetic */ b a;

        private b(b b2) {
            this.a = b2;
        }

        public /* synthetic */ b(b b2, byte by) {
            super(b2);
        }

        public final void onStartFailure(int n2) {
            if (this.a.b != null) {
                this.a.b.a();
            }
            StringBuilder stringBuilder = new StringBuilder("onStartFailure ");
            stringBuilder.append(n2);
            d.b((String)"BleAdvertiseProxy", (String)stringBuilder.toString(), (Object[])new Object[0]);
        }

        public final void onStartSuccess(AdvertiseSettings advertiseSettings) {
        }
    }

}

