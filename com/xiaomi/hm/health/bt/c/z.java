package com.xiaomi.hm.health.bt.c;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import java.util.List;
import java.util.UUID;

public interface z {
    public static final int g = 0;
    public static final int h = 65281;
    public static final int i = 65282;
    public static final int j = 65534;

    int a(BluetoothGattCharacteristic bluetoothGattCharacteristic);

    int a(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr);

    BluetoothGattService a(UUID uuid);

    void a();

    void a(boolean z);

    void b();

    boolean b(BluetoothGattCharacteristic bluetoothGattCharacteristic, B b);

    void c();

    boolean c(BluetoothGattCharacteristic bluetoothGattCharacteristic);

    List<BluetoothGattService> d();

    int e();

    BluetoothDevice f();

    C g();

    boolean q();
}
