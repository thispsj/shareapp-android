/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.bluetooth.BluetoothDevice
 *  android.bluetooth.BluetoothGatt
 *  android.bluetooth.BluetoothGattCallback
 *  android.bluetooth.BluetoothGattCharacteristic
 *  android.bluetooth.BluetoothGattService
 *  android.bluetooth.le.BluetoothLeScanner
 *  android.bluetooth.le.ScanCallback
 *  android.bluetooth.le.ScanFilter
 *  android.bluetooth.le.ScanFilter$Builder
 *  android.bluetooth.le.ScanRecord
 *  android.bluetooth.le.ScanResult
 *  android.bluetooth.le.ScanSettings
 *  android.bluetooth.le.ScanSettings$Builder
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.ParcelUuid
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashSet
 *  java.util.List
 *  java.util.UUID
 *  midrop.service.c.d
 */
package b.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelUuid;
import b.a.d;
import b.a.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public final class c {
    public BluetoothAdapter a;
    public BluetoothLeScanner b;
    public Handler c;
    boolean d;
    a e;
    HashSet<String> f = new HashSet();
    BluetoothGatt g;
    BluetoothDevice h;
    d i;
    ScanCallback j;
    private Context k;
    private BluetoothGattCallback l;

    public c(Context context) {
        this.j = new ScanCallback(){

            public final void onScanResult(int n2, ScanResult scanResult) {
                if (c.this.f.contains((Object)scanResult.getDevice().getAddress())) {
                    return;
                }
                ScanRecord scanRecord = scanResult.getScanRecord();
                if (scanRecord == null) {
                    return;
                }
                byte[] arrby = scanRecord.getServiceData(ParcelUuid.fromString((String)j.c.toString()));
                if (arrby == null) {
                    return;
                }
                byte[] arrby2 = scanRecord.getServiceData(ParcelUuid.fromString((String)j.d.toString()));
                if (arrby2 == null) {
                    return;
                }
                String string2 = new String(arrby);
                String string3 = new String(arrby2);
                c.this.f.add((Object)scanResult.getDevice().getAddress());
                a a2 = c.this.e;
                scanResult.getDevice().getAddress();
                a2.a(string2, string3);
            }
        };
        this.l = new BluetoothGattCallback(){

            public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int n2) {
                super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, n2);
                byte[] arrby = bluetoothGattCharacteristic.getValue();
                String string2 = "";
                if (arrby != null) {
                    string2 = new String(arrby);
                }
                StringBuilder stringBuilder = new StringBuilder("onCharacteristicRead ");
                stringBuilder.append(string2);
                midrop.service.c.d.b((String)"BleGattClient", (String)stringBuilder.toString(), (Object[])new Object[0]);
                if (c.this.i != null) {
                    c.this.h.getAddress();
                    bluetoothGattCharacteristic.getUuid().toString();
                }
                c.this.a();
            }

            public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int n2, int n3) {
                if (n3 == 2) {
                    c.this.g.discoverServices();
                    return;
                }
                if (n3 == 0) {
                    c c2 = c.this;
                    c2.c.post(new Runnable(){

                        public final void run() {
                            if (c.this.g != null) {
                                c.this.g.close();
                                c.this.g = null;
                            }
                            c.this.h = null;
                        }
                    });
                }
            }

            public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int n2) {
                boolean bl;
                block2 : {
                    super.onServicesDiscovered(bluetoothGatt, n2);
                    for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
                        if (!bluetoothGattService.getUuid().equals((Object)j.e)) continue;
                        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(j.f);
                        bl = c.this.g.readCharacteristic(bluetoothGattCharacteristic);
                        StringBuilder stringBuilder = new StringBuilder("read ap info character ");
                        stringBuilder.append((Object)bluetoothGattCharacteristic);
                        stringBuilder.append(" ret=");
                        stringBuilder.append(bl);
                        midrop.service.c.d.b((String)"BleGattClient", (String)stringBuilder.toString(), (Object[])new Object[0]);
                        break block2;
                    }
                    bl = false;
                }
                if (!bl) {
                    c.this.a();
                }
            }
        };
        this.k = context.getApplicationContext();
        this.c = new Handler(Looper.getMainLooper());
        this.a = BluetoothAdapter.getDefaultAdapter();
        this.b = this.a.getBluetoothLeScanner();
    }

    public final void a() {
        this.c.post(new Runnable(){

            public final void run() {
                if (c.this.g != null) {
                    c.this.g.disconnect();
                }
            }
        });
    }

    public static interface a {
        public void a(String var1, String var2);
    }

}

