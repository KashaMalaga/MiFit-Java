package cn.com.smartdevices.bracelet.shoes.ui;

import android.bluetooth.BluetoothDevice;
import com.xiaomi.hm.health.bt.profile.a.b;

class C0661r extends b {
    final /* synthetic */ ShoesBindTestActivity a;

    C0661r(ShoesBindTestActivity shoesBindTestActivity) {
        this.a = shoesBindTestActivity;
    }

    public void a(BluetoothDevice bluetoothDevice, int i) {
        this.a.b(i);
    }
}
