package com.xiaomi.hm.health.bt.profile.Weight;

import android.bluetooth.BluetoothAdapter;
import com.xiaomi.e.a;

public class WeightHwInfo {
    public String address = a.f;
    public String deviceId = a.f;
    public String fwVersion = a.f;
    public String name = a.f;

    public boolean isValid() {
        return this.address != null && this.address.length() > 0 && BluetoothAdapter.checkBluetoothAddress(this.address);
    }

    public String toString() {
        return "Weight info: addr = " + this.address + ", name = " + this.name + ", fw = " + this.fwVersion + ", deviceId = " + this.deviceId;
    }
}
