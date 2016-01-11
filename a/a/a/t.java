package a.a.a;

import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.ParcelUuid;
import android.os.RemoteException;
import android.util.Log;
import java.util.List;
import java.util.UUID;

public class t {
    private static final boolean A = true;
    public static final String a = "miui.permission.BLE_IMMEDIATE_ALERT";
    public static final String b = "alert_alarm_enabled";
    public static final String c = "alert_incall_enabled";
    public static final String d = "alert_incall_delayed";
    public static final String e = "alert_incall_enabled_in_contacts";
    public static final String f = "alert_incall_enabled_no_contacts";
    public static final String g = "alert_sms_enabled";
    public static final String h = "alert_sms_enabled_in_contacts";
    public static final String i = "alert_sms_enabled_no_contacts";
    public static final String j = "mi_key_link_loss";
    public static final String k = "mi_key_open_camera_event";
    public static final String l = "mi_key_camera_event";
    public static final String m = "mi_key_alarm_event";
    public static final String n = "device_type";
    public static final int o = 0;
    public static final int p = 1;
    public static final int q = 2;
    public static final String r = "miui.bluetooth.BLE_EVENT";
    public static final String s = "miui.bluetooth.extras.DEVICE";
    public static final String t = "miui.bluetooth.extras.EVENT";
    public static final int u = 0;
    public static final int v = 1;
    public static final int w = 2;
    public static final int x = 3;
    public static final int y = -1;
    private static final String z = "MiBleDeviceManager";
    private Context B;
    private n C;
    private x D;
    private ParcelUuid E;
    private IBinder F;
    private ServiceConnection G = new u(this);

    private t(Context context, x xVar) {
        if (context == null || context.getApplicationContext() == null) {
            throw new IllegalArgumentException("context not valid");
        }
        this.E = new ParcelUuid(UUID.randomUUID());
        this.F = new Binder();
        this.B = context.getApplicationContext();
        this.D = xVar;
    }

    public static t a(Context context, x xVar) {
        t tVar = new t(context, xVar);
        tVar.e();
        return tVar;
    }

    private void a(n nVar) {
        this.C = nVar;
    }

    private void e() {
        Intent intent = new Intent("miui.bluetooth.mible.DeviceManagerService");
        intent.setComponent(new ComponentName("com.android.bluetooth", "com.android.bluetooth.ble.app.MiBleDeviceManagerService"));
        if (!this.B.bindService(intent, this.G, v)) {
            Log.e(z, "bind manager service error: " + intent);
            if (this.D != null) {
                new Handler().post(new v(this));
            }
        }
    }

    private boolean f() {
        if (this.C != null) {
            return A;
        }
        Log.w(z, "Manager is not ready");
        return false;
    }

    public void a() {
        try {
            this.B.unbindService(this.G);
        } catch (Throwable e) {
            Log.e(z, "Close manager service error", e);
        }
    }

    public boolean a(int i, LeScanCallback leScanCallback) {
        if (f()) {
            try {
                this.C.a(this.F, this.E, i, new w(this, i, leScanCallback));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean a(String str) {
        boolean z = false;
        if (f()) {
            try {
                z = this.C.a(str, n, (int) u);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    public boolean a(String str, int i) {
        if (f()) {
            try {
                return this.C.a(str, i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean a(String str, int i, C0004b c0004b) {
        boolean z = false;
        if (c0004b != null && f()) {
            try {
                z = this.C.a(str, i, c0004b);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    public boolean a(String str, String str2) {
        if (!f()) {
            return false;
        }
        try {
            return this.C.b(str, str2) != 0 ? A : false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean a(String str, String str2, int i) {
        if (f()) {
            try {
                return this.C.a(str, str2, i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean a(String str, String str2, String str3) {
        if (f()) {
            try {
                return this.C.a(str, str2, str3);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean a(String str, String str2, boolean z) {
        boolean z2 = false;
        if (f()) {
            try {
                z2 = this.C.a(str, str2, z ? v : u);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return z2;
    }

    public int b() {
        if (f()) {
            try {
                return this.C.a();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return y;
    }

    public int b(String str, String str2) {
        if (f()) {
            try {
                return this.C.b(str, str2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return u;
    }

    public boolean b(String str) {
        if (f()) {
            try {
                return this.C.b(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean b(String str, int i) {
        if (f()) {
            try {
                return this.C.b(str, i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean b(String str, int i, C0004b c0004b) {
        if (f()) {
            try {
                return this.C.b(str, i, c0004b);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public int c(String str) {
        if (f()) {
            try {
                return this.C.c(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return u;
    }

    public String c(String str, int i) {
        if (f()) {
            try {
                return this.C.c(str, i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String c(String str, String str2) {
        if (f()) {
            try {
                return this.C.a(str, str2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<String> c() {
        if (f()) {
            try {
                return this.C.b();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void d() {
        if (f()) {
            try {
                this.C.a(this.E);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
