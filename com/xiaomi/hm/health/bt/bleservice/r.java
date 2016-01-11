package com.xiaomi.hm.health.bt.bleservice;

import android.bluetooth.BluetoothDevice;
import com.xiaomi.hm.health.bt.a.d;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import com.xiaomi.hm.health.bt.model.UserInfo;
import com.xiaomi.hm.health.bt.profile.Weight.f;
import com.xiaomi.hm.health.bt.profile.a.j;

public interface r {
    HwConnStatus a();

    void a(BluetoothDevice bluetoothDevice, boolean z);

    void a(BluetoothDevice bluetoothDevice, boolean z, UserInfo userInfo);

    void a(d dVar, long j);

    j b();

    boolean c();

    f d();

    void e();

    void f();

    void g();
}
