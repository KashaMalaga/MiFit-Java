package cn.com.smartdevices.bracelet.model;

import android.bluetooth.BluetoothDevice;

public class BtDevice {
    public BluetoothDevice device = null;
    public int signal = 0;

    public BtDevice(BluetoothDevice bluetoothDevice, int i) {
        this.device = bluetoothDevice;
        this.signal = i;
    }

    public String getAddress() {
        return this.device != null ? this.device.getAddress() : null;
    }
}
