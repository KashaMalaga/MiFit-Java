package com.xiaomi.hm.health.bt.bleservice;

import android.bluetooth.BluetoothDevice;
import android.os.Binder;
import com.xiaomi.hm.health.bt.a.d;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import com.xiaomi.hm.health.bt.model.UserInfo;
import com.xiaomi.hm.health.bt.profile.Weight.f;
import com.xiaomi.hm.health.bt.profile.a.j;

public final class q extends Binder implements r {
    private final BLEService a;

    q(BLEService bLEService) {
        this.a = bLEService;
    }

    public HwConnStatus a() {
        return this.a.i();
    }

    public void a(BluetoothDevice bluetoothDevice, boolean z) {
        this.a.b(bluetoothDevice, z);
    }

    public void a(BluetoothDevice bluetoothDevice, boolean z, UserInfo userInfo) {
        this.a.a(userInfo);
        if (bluetoothDevice != null) {
            this.a.a(bluetoothDevice, z);
        } else {
            this.a.a();
        }
    }

    public void a(d dVar, long j) {
        this.a.a(dVar, j);
    }

    public j b() {
        return this.a.h();
    }

    public boolean c() {
        return this.a.g();
    }

    public f d() {
        return this.a.c();
    }

    public void e() {
        this.a.d();
    }

    public void f() {
        this.a.b();
    }

    public void g() {
        this.a.a(39);
    }
}
