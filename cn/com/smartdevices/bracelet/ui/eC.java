package cn.com.smartdevices.bracelet.ui;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import com.xiaomi.hm.health.bt.bleservice.a;

class eC implements Runnable {
    final /* synthetic */ eB a;

    eC(eB eBVar) {
        this.a = eBVar;
    }

    public void run() {
        if (this.a.a.b != null) {
            this.a.a.b.dismiss();
            this.a.a.b = null;
        }
        Utils.a(BluetoothDevice.class, a.d());
        Context b = this.a.a.a;
        if (b == null) {
            C0596r.e(com.xiaomi.e.a.f, "getActivity is null! System.exit(-1) now!");
            System.exit(-1);
            return;
        }
        this.a.a.dismiss();
        Intent intent = new Intent();
        intent.setClass(b, SearchSingleBraceletActivity.class);
        b.startActivity(intent);
        b.finish();
    }
}
