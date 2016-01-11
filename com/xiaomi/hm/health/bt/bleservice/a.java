package com.xiaomi.hm.health.bt.bleservice;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.a.d;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import com.xiaomi.hm.health.bt.model.UserInfo;
import com.xiaomi.hm.health.bt.model.f;
import com.xiaomi.hm.health.bt.model.h;
import com.xiaomi.hm.health.bt.profile.a.j;

public class a {
    private static String a = "BLEManager";
    private static r b = null;
    private static ServiceConnection c = new b();

    public static j a() {
        return b != null ? b.b() : null;
    }

    public static void a(BluetoothDevice bluetoothDevice, boolean z) {
        if (b != null) {
            b.a(bluetoothDevice, z);
        }
    }

    public static void a(BluetoothDevice bluetoothDevice, boolean z, UserInfo userInfo) {
        if (b != null) {
            b.a(bluetoothDevice, z, userInfo);
        }
    }

    public static void a(Context context, String str, UserInfo userInfo) {
        b(context, str, userInfo);
    }

    public static void a(d dVar, long j) {
        if (b != null) {
            b.a(dVar, j);
        }
    }

    @TargetApi(18)
    public static boolean a(Context context) {
        boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        C0596r.e(a, "isSupportBle:" + hasSystemFeature);
        return hasSystemFeature;
    }

    public static void b() {
        if (b != null) {
            b.f();
        }
    }

    public static void b(Context context, String str, UserInfo userInfo) {
        Intent intent = new Intent(context, BLEService.class);
        intent.putExtra(BLEService.l, str);
        intent.putExtra(BLEService.m, userInfo);
        context.startService(intent);
        if (b == null) {
            context.bindService(intent, c, 1);
        }
    }

    private static boolean b(Context context) {
        boolean z;
        for (RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) {
            if (runningServiceInfo.service.getPackageName().equals(context.getPackageName()) && BLEService.class.getName().equals(runningServiceInfo.service.getClassName())) {
                z = true;
                break;
            }
        }
        z = false;
        C0596r.e(a, "in isBLEServiceRunning:" + z);
        return z;
    }

    public static boolean c() {
        if (b != null) {
            j b = b.b();
            if (b != null) {
                return b.u();
            }
        }
        return false;
    }

    public static BluetoothDevice d() {
        if (b != null) {
            j b = b.b();
            if (b != null) {
                return b.f();
            }
        }
        return null;
    }

    public static f e() {
        if (b != null) {
            j b = b.b();
            if (b != null) {
                return b.N();
            }
        }
        return null;
    }

    public static h f() {
        if (b != null) {
            j b = b.b();
            if (b != null) {
                return b.B();
            }
        }
        return null;
    }

    public static h g() {
        if (b != null) {
            j b = b.b();
            if (b != null) {
                return b.j_();
            }
        }
        return null;
    }

    public static void h() {
        if (b != null) {
            b.e();
        }
    }

    public static com.xiaomi.hm.health.bt.profile.Weight.f i() {
        return b != null ? b.d() : null;
    }

    public static void j() {
        if (b != null) {
            b.g();
        }
    }

    public static HwConnStatus k() {
        return b != null ? b.a() : new HwConnStatus();
    }

    public static boolean l() {
        return b != null ? b.c() : false;
    }
}
