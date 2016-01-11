package com.xiaomi.hm.health.bt.bleservice;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v7.widget.af;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.a.C1113D;
import com.xiaomi.hm.health.bt.a.d;
import com.xiaomi.hm.health.bt.e.a;
import com.xiaomi.hm.health.bt.e.g;
import com.xiaomi.hm.health.bt.model.HwBatteryStatus;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import com.xiaomi.hm.health.bt.model.UserInfo;
import com.xiaomi.hm.health.bt.model.e;
import com.xiaomi.hm.health.bt.profile.Weight.f;
import com.xiaomi.hm.health.bt.profile.a.b;
import com.xiaomi.hm.health.bt.profile.a.j;
import com.xiaomi.hm.health.t;
import java.util.List;
import kankan.wheel.widget.l;

@SuppressLint({"NewApi"})
public final class BLEService extends Service {
    private static final String A = z;
    private static final String B = "BLEService";
    private static final String C = (y + "." + z);
    public static final String a = "1.9.6.20140519";
    public static final String b = (C + ".INTENT_ACTION_CONN_STATUS_CHANGED");
    public static final String c = (C + ".INTENT_ACTION_WEIGHT_CONN_STATUS_CHANGED");
    public static final String d = (C + ".INTENT_ACTION_WEIGHT_LOW_BATTERY");
    public static final String e = (C + ".INTENT_ACTION_SYNC_DATA_STATUS_CHANGED");
    public static final String f = (C + ".INTENT_ACTION_DYNAMIC_STATUS_CHANGED");
    public static final String g = (C + ".INTENT_ACTION_DEVICE_STATUS_CHANGED");
    public static final String h = (C + ".INTENT_ACTION_BATTERY_STATUS_CHANGED");
    public static final String i = (C + ".INTENT_EXTRA_DEVICE");
    public static final String j = (C + ".INTENT_EXTRA_PARAM");
    public static final String k = (C + ".INTENT_EXTRA_PARAM_EXT");
    public static final String l = (C + ".INTENT_EXTRA_PARAM_ADDRESS");
    public static final String m = (C + ".INTENT_EXTRA_PARAM_USERINFO");
    public static final int n = 3;
    public static final int o = 8;
    public static final int p = 9;
    public static final int q = 10;
    public static final int r = 11;
    public static final int s = 14;
    public static final int t = 15;
    public static final int u = 16;
    public static final int v = 20;
    public static final int w = 21;
    private static final int x = 30000;
    private static final String y = BLEService.class.getPackage().getName();
    private static final String z = BLEService.class.getSimpleName();
    private final HandlerThread D;
    private final Handler E;
    private j F = null;
    private f G = null;
    private final BluetoothAdapter H = BluetoothAdapter.getDefaultAdapter();
    private BroadcastReceiver I = null;
    private final Binder J = new q(this);
    private HwConnStatus K = new HwConnStatus();
    private volatile boolean L = false;
    private final Object M = new Object();
    private final Object N = new Object();
    private String O = null;
    private UserInfo P = null;
    private a Q = a.a();
    private com.xiaomi.hm.health.bt.e.f R = null;
    private e S = null;
    private final b T = new c(this);

    static {
        C0596r.d(BLEService.class.getSimpleName() + ".VERSION: " + a);
    }

    public BLEService() {
        C0596r.e();
        this.D = new HandlerThread(A);
        this.D.setUncaughtExceptionHandler(new h(this));
        this.D.start();
        this.E = new i(this, this.D.getLooper());
    }

    private void a(int i, int i2) {
        C0596r.e(B, "notifyBatteryStatusChanged:" + i + ",level=" + i2);
        Intent intent = new Intent(h);
        intent.putExtra(j, new HwBatteryStatus(i, i2));
        sendBroadcast(intent);
    }

    private void a(int i, BluetoothDevice bluetoothDevice) {
        C0596r.d(B, "notifyWeightStatusChanged:" + i);
        Intent intent = new Intent(c);
        intent.putExtra(j, i);
        intent.putExtra(i, bluetoothDevice);
        sendBroadcast(intent);
    }

    private void a(BluetoothDevice bluetoothDevice, int i) {
        switch (i) {
            case kankan.wheel.widget.a.i /*0*/:
                C0596r.a(bluetoothDevice.getAddress() + "[DISCONNECTED]");
                return;
            case l.a /*1*/:
                C0596r.a(bluetoothDevice.getAddress() + "[CONNECTING]");
                return;
            case kankan.wheel.widget.a.k /*2*/:
                C0596r.a(bluetoothDevice.getAddress() + "[CONNECTED]");
                return;
            case n /*3*/:
                C0596r.a(bluetoothDevice.getAddress() + "[DISCONNECTING]");
                return;
            default:
                return;
        }
    }

    private void a(Context context, Intent intent) {
        C0596r.e();
        C0596r.a(this.D);
        String action = intent.getAction();
        C0596r.a("#Broadcast# Intent: " + intent.getAction());
        if (action.equals("android.intent.action.USER_PRESENT")) {
            C0596r.d("#Broadcast# USER_PRESENT ");
            if (!a(getApplicationContext())) {
                a(39);
            }
        } else if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
            switch (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", af.a)) {
                case q /*10*/:
                    C0596r.d("#Broadcast# Bluetooth OFF.");
                    this.E.sendEmptyMessage(q);
                    return;
                case r /*11*/:
                    C0596r.d("#Broadcast# Bluetooth turning ON.");
                    this.E.sendEmptyMessage(p);
                    return;
                case kankan.wheel.widget.a.be /*12*/:
                    C0596r.d("#Broadcast# Bluetooth ON.");
                    this.E.sendEmptyMessage(o);
                    return;
                case t.WeightView_wv_bmi_size /*13*/:
                    C0596r.d("#Broadcast# Bluetooth turning OFF.");
                    this.E.sendEmptyMessage(r);
                    return;
                default:
                    C0596r.f(">>> UNEXPECTED <<<");
                    return;
            }
        } else if (action.equals("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED")) {
            r1 = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
            C0596r.a("#Broadcast# state: " + r1 + ", prev state: " + intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE", -1) + ", device: " + ((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress());
        } else if (action.equals("android.bluetooth.device.action.ACL_CONNECTED")) {
            C0596r.a("#Broadcast# device: " + ((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress());
        } else if (action.equals("android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED")) {
            C0596r.a("#Broadcast# device: " + ((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress());
        } else if (action.equals("android.bluetooth.device.action.ACL_DISCONNECTED")) {
            C0596r.a("#Broadcast# device: " + ((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress());
        } else if (action.equals("android.bluetooth.device.action.BOND_STATE_CHANGED")) {
            r0 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            r1 = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1);
            C0596r.a("#Broadcast# bond state: " + r1 + ", prev bond state: " + intent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", -1) + ", device: " + r0.getAddress());
        } else if (action.equals("android.bluetooth.device.action.CLASS_CHANGED")) {
            C0596r.a("#Broadcast# device: " + ((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress() + ", btClass: " + ((BluetoothClass) intent.getParcelableExtra("android.bluetooth.device.extra.CLASS")).getDeviceClass());
        } else if (action.equals("android.bluetooth.device.action.NAME_CHANGED")) {
            r0 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            C0596r.a("#Broadcast# device: " + r0.getAddress() + ", name: " + intent.getStringExtra("android.bluetooth.device.extra.NAME"));
        } else if (!action.equals("android.bluetooth.device.action.PAIRING_REQUEST")) {
        }
    }

    private void a(Message message) {
        C0596r.e();
        C0596r.a(this.D);
        switch (message.what) {
            case n /*3*/:
            case p /*9*/:
            case r /*11*/:
            case s /*14*/:
            case t /*15*/:
            case u /*16*/:
                return;
            case o /*8*/:
                l();
                a();
                return;
            case q /*10*/:
                b();
                f();
                return;
            case v /*20*/:
                d();
                return;
            case w /*21*/:
                k();
                return;
            default:
                C0596r.f(">>> UNEXPECTED <<<");
                return;
        }
    }

    private void a(String str) {
        b(0);
        this.S = null;
        if (this.R == null) {
            this.R = new g().a((int) x).a(str).a(new l(this, str)).a();
        }
        this.Q.a((Context) this, this.R);
    }

    private BluetoothDevice b(String str) {
        for (BluetoothDevice bluetoothDevice : ((BluetoothManager) getSystemService("bluetooth")).getConnectedDevices(7)) {
            C0596r.e(B, "conneted device: " + bluetoothDevice.getName() + com.xiaomi.mipush.sdk.f.i + bluetoothDevice.getAddress());
            if (bluetoothDevice.getAddress().equalsIgnoreCase(str)) {
                return bluetoothDevice;
            }
        }
        return null;
    }

    private void b(int i) {
        C0596r.d(B, "notifyStatusChanged:" + i);
        Parcelable hwConnStatus = new HwConnStatus(i);
        this.K = hwConnStatus;
        Intent intent = new Intent(b);
        intent.putExtra(j, hwConnStatus);
        sendBroadcast(intent);
    }

    public static void b(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        C0596r.e(B, "notifyDynamicStatusChanged");
        context.sendBroadcast(new Intent(f));
    }

    private void c(int i) {
        C0596r.e(B, "notifyDeviceStatusChanged:" + i);
        Intent intent = new Intent(g);
        intent.putExtra(j, i);
        sendBroadcast(intent);
    }

    private void j() {
        if (this.R != null) {
            this.Q.a(this.R);
            this.R = null;
        }
    }

    private void k() {
        if (this.P == null) {
            C0596r.d(B, "user info is null!!!");
            b(4);
            return;
        }
        C0596r.e(B, "userinfo:" + this.P);
        new C1113D(this.P, new n(this), new o(this)).f();
    }

    private void l() {
        synchronized (this.M) {
            this.L = false;
        }
    }

    private void m() {
        n();
    }

    private void n() {
        sendBroadcast(new Intent(d));
    }

    public synchronized void a() {
        C0596r.e(B, "in connectDevice");
        if (this.O != null && BluetoothAdapter.checkBluetoothAddress(this.O)) {
            String str = this.O;
            if (this.F != null) {
                C0596r.e(B, "miliProfile != null, miliProfile.getState() = " + this.F.g());
                BluetoothDevice f = this.F.f();
                if (f != null) {
                    a(f, ((BluetoothManager) getSystemService("bluetooth")).getConnectionState(f, 7));
                    if (f.getAddress().equals(str)) {
                        C0596r.e(B, "miliProfile has device:" + f.getName() + com.xiaomi.mipush.sdk.f.i + f.getAddress());
                    }
                }
                this.F.a(false);
                this.F.b();
                this.F = null;
            }
            BluetoothDevice b = b(str);
            if (b != null) {
                a(b, true);
            } else {
                b = this.H.getRemoteDevice(str);
                C0596r.e(B, "mili device type:" + b.getType());
                if (b.getType() == 2) {
                    a(b, true);
                } else {
                    a(str);
                }
            }
        }
    }

    public void a(int i) {
        C0596r.b(B, "current latency level set level:" + i);
        WakeLock newWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(1, "setLatency");
        C0596r.b(B, "waklock acquire......" + i);
        newWakeLock.acquire();
        new com.xiaomi.hm.health.bt.a.t(i, new g(this, i, newWakeLock)).h();
    }

    public void a(BluetoothDevice bluetoothDevice, boolean z) {
        b(2);
        this.F = new j(this, bluetoothDevice, new m(this));
        this.F.a(this.T);
        this.F.a(z);
        this.F.a();
    }

    public void a(d dVar, long j) {
        C0596r.e(B, "in syncWeightData");
        synchronized (this.N) {
            if (this.G == null) {
                return;
            }
            this.G.a(dVar, j);
            C0596r.e(B, "out syncWeightData");
        }
    }

    public void a(UserInfo userInfo) {
        this.P = userInfo;
    }

    public boolean a(Context context) {
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.isEmpty())) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            C0596r.d(B, "topActivity:" + componentName.flattenToString());
            if (!componentName.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    public synchronized void b() {
        C0596r.e(B, "in disconnectDevice");
        j();
        if (this.F != null) {
            this.F.a(false);
            this.F.b();
            this.F = null;
        }
        this.K = new HwConnStatus();
    }

    public void b(BluetoothDevice bluetoothDevice, boolean z) {
        C0596r.d(B, "in connectWeight:" + bluetoothDevice.getName() + com.xiaomi.mipush.sdk.f.i + bluetoothDevice.getAddress());
        synchronized (this.N) {
            if (this.G != null) {
                if (this.G.f().getAddress().equals(bluetoothDevice.getAddress())) {
                    C0596r.d(B, "use current weight profile!!!");
                    return;
                }
                C0596r.d(B, "disconnect current weight profile!!!");
                this.G.a(false);
                this.G.r();
                this.G.b();
                this.G = null;
            }
            this.G = new f(this, bluetoothDevice, new p(this));
            this.G.a(new d(this));
            this.G.a(new e(this));
            this.G.a(z);
            this.G.a();
            C0596r.d(B, "out connectWeight");
        }
    }

    public f c() {
        f fVar;
        C0596r.e(B, "in getWeigthProfile:" + this.G);
        synchronized (this.N) {
            fVar = this.G;
        }
        return fVar;
    }

    public void d() {
        C0596r.e(B, "in disconnectWeight");
        synchronized (this.N) {
            if (this.G != null) {
                this.G.a(false);
                this.G.b();
                this.G = null;
            }
        }
        C0596r.e(B, "out disconnectWeight");
    }

    public void e() {
        synchronized (this.M) {
            if (!this.L) {
                this.L = true;
                BluetoothAdapter.getDefaultAdapter().disable();
            }
        }
    }

    public void f() {
        synchronized (this.M) {
            if (this.L) {
                BluetoothAdapter.getDefaultAdapter().enable();
            }
        }
    }

    public boolean g() {
        boolean z;
        synchronized (this.M) {
            z = this.L;
        }
        return z;
    }

    public synchronized j h() {
        return this.F;
    }

    public HwConnStatus i() {
        return this.K;
    }

    public IBinder onBind(Intent intent) {
        C0596r.e();
        return this.J;
    }

    public void onConfigurationChanged(Configuration configuration) {
        C0596r.e();
        super.onConfigurationChanged(configuration);
    }

    public void onCreate() {
        C0596r.e();
        C0596r.d(B, "onCreate");
        super.onCreate();
        this.I = new j(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        registerReceiver(this.I, intentFilter);
    }

    public void onDestroy() {
        C0596r.e();
        C0596r.d(B, "onDestroy");
        b();
        unregisterReceiver(this.I);
        super.onDestroy();
    }

    public void onLowMemory() {
        C0596r.e();
        super.onLowMemory();
    }

    public void onRebind(Intent intent) {
        C0596r.e();
        C0596r.f(">>> UNEXPECTED <<<");
        super.onRebind(intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        C0596r.d(B, "onStartCommand Intent: " + intent);
        if (intent != null) {
            this.O = intent.getStringExtra(l);
            this.P = (UserInfo) intent.getParcelableExtra(m);
        }
        if (BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            a();
        }
        return n;
    }

    public void onTaskRemoved(Intent intent) {
        C0596r.e();
        C0596r.f("Calling onDestroy()...");
        super.onTaskRemoved(intent);
    }

    public void onTrimMemory(int i) {
        C0596r.e();
        super.onTrimMemory(i);
    }

    public boolean onUnbind(Intent intent) {
        C0596r.e();
        return super.onUnbind(intent);
    }
}
