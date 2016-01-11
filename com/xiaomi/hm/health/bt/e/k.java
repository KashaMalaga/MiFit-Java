package com.xiaomi.hm.health.bt.e;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import com.f.a.b.d.a;
import com.xiaomi.hm.health.bt.c.y;
import java.util.ArrayList;
import java.util.UUID;

@SuppressLint({"NewApi"})
class k extends BluetoothGattCallback implements Runnable {
    private final String a = "UUIDTask";
    private final int b = a.a;
    private Context c = null;
    private BluetoothDevice d = null;
    private j e = null;
    private ArrayList<UUID> f = new ArrayList();

    public k(Context context, BluetoothDevice bluetoothDevice, j jVar) {
        this.c = context;
        this.d = bluetoothDevice;
        this.e = jVar;
    }

    private void a(int i) {
        synchronized (this.d) {
            try {
                this.d.wait((long) i);
            } catch (Exception e) {
            }
        }
    }

    private void stop() {
        synchronized (this.d) {
            this.d.notify();
        }
    }

    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        C0596r.d("UUIDTask", "status:" + i + ",newState:" + i2 + ",clientIf:" + y.a(bluetoothGatt));
        if (i != 0) {
            stop();
        } else if (i2 == 2) {
            bluetoothGatt.discoverServices();
        }
    }

    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        C0596r.d("UUIDTask", "status:" + i + ",clientIf:" + y.a(bluetoothGatt));
        if (i == 0) {
            for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
                this.f.add(bluetoothGattService.getUuid());
                C0596r.d("UUIDTask", (bluetoothGattService.getType() == 0 ? "Primary" : "Secondary") + " service: " + y.c(bluetoothGattService.getUuid()));
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                    C0596r.d("UUIDTask", "  Characteristic: " + y.c(bluetoothGattCharacteristic.getUuid()));
                    C0596r.d("UUIDTask", "    - Properties: " + y.b(bluetoothGattCharacteristic.getProperties()));
                    for (BluetoothGattDescriptor uuid : bluetoothGattCharacteristic.getDescriptors()) {
                        C0596r.d("UUIDTask", "    Descriptor: " + y.c(uuid.getUuid()));
                    }
                }
            }
        }
        stop();
    }

    public void run() {
        BluetoothGatt connectGatt = this.d.connectGatt(this.c, false, this);
        if (connectGatt != null) {
            a(a.a);
            connectGatt.disconnect();
            connectGatt.close();
        }
        if (this.e != null) {
            this.e.a(this.d, this.f);
        }
    }
}
