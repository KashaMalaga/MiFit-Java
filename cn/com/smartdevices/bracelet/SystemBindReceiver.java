package cn.com.smartdevices.bracelet;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.hm.health.bt.bleservice.a;

public class SystemBindReceiver extends BroadcastReceiver {
    private static final String a = SystemBindReceiver.class.getSimpleName();

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            C0596r.e(a, "action:" + action);
            BluetoothDevice bluetoothDevice;
            if (action.equals(Constant.aW)) {
                bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice != null) {
                    C0596r.e(a, "bind device:" + bluetoothDevice.getAddress());
                }
            } else if (action.equals(Constant.aX)) {
                bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice != null) {
                    C0596r.e(a, "unbind device:" + bluetoothDevice.getAddress());
                }
            } else if (action.equals("android.intent.action.BOOT_COMPLETED")) {
                a.b(context.getApplicationContext(), Keeper.readBraceletBtInfo().b, Utils.p());
            } else if (action.equals("android.intent.action.USER_PRESENT")) {
                a.b(context.getApplicationContext(), Keeper.readBraceletBtInfo().b, Utils.p());
            }
        }
    }
}
