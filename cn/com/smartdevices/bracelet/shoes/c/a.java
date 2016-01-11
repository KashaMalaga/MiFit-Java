package cn.com.smartdevices.bracelet.shoes.c;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;

public class a {
    private a() {
    }

    public static boolean a(Activity activity, boolean z, int i) {
        if (activity == null) {
            return true;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || defaultAdapter.isEnabled()) {
            return true;
        }
        if (!z) {
            return false;
        }
        if (com.xiaomi.hm.health.bt.bleservice.a.l()) {
            return true;
        }
        activity.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), i);
        return false;
    }
}
