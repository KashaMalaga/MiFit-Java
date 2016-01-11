package com.xiaomi.hm.health.bt.profile.a;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Message;

public class b {
    private final int a = 5;
    private final int b = 6;
    private final int c = 7;
    private Handler d = new c(this);

    public void a(int i) {
    }

    public void a(BluetoothDevice bluetoothDevice, int i) {
    }

    public void a(BluetoothDevice bluetoothDevice, int i, int i2) {
    }

    public void b(int i) {
        Message message = new Message();
        message.what = 5;
        message.arg1 = i;
        this.d.sendMessage(message);
    }

    public void b(BluetoothDevice bluetoothDevice, int i) {
        Message message = new Message();
        message.what = 6;
        message.obj = bluetoothDevice;
        message.arg1 = i;
        this.d.sendMessage(message);
    }

    public void b(BluetoothDevice bluetoothDevice, int i, int i2) {
        Message message = new Message();
        message.what = 7;
        message.obj = bluetoothDevice;
        message.arg1 = i;
        message.arg2 = i2;
        this.d.sendMessage(message);
    }
}
