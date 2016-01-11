package com.xiaomi.hm.health.bt.e;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanSettings;
import android.bluetooth.le.ScanSettings.Builder;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.c.y;
import com.xiaomi.hm.health.bt.model.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@SuppressLint({"NewApi"})
public class a {
    private static final String a = "BleScanCenter";
    private static a b = null;
    private static final String c = "AF";
    private final boolean d;
    private final BluetoothAdapter e;
    private LeScanCallback f;
    private HandlerThread g;
    private Handler h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;
    private final int n;
    private final int o;
    private volatile boolean p;
    private Context q;
    private List<f> r;
    private int s;
    private int t;
    private ScanCallback u;

    private a() {
        this.d = false;
        this.e = BluetoothAdapter.getDefaultAdapter();
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = 0;
        this.j = 3000;
        this.k = 0;
        this.l = 1;
        this.m = 2;
        this.n = 3;
        this.o = 4;
        this.p = false;
        this.q = null;
        this.r = Collections.synchronizedList(new ArrayList());
        this.s = 0;
        this.t = 0;
        this.u = null;
        this.g = new HandlerThread(a);
        this.g.start();
        this.h = new b(this, this.g.getLooper());
    }

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    private List<BluetoothDevice> a(Context context) {
        HashMap hashMap = new HashMap();
        for (BluetoothDevice bluetoothDevice : ((BluetoothManager) context.getSystemService("bluetooth")).getConnectedDevices(7)) {
            hashMap.put(bluetoothDevice.getAddress(), bluetoothDevice);
        }
        Set<BluetoothDevice> bondedDevices = BluetoothAdapter.getDefaultAdapter().getBondedDevices();
        if (bondedDevices != null && bondedDevices.size() > 0) {
            for (BluetoothDevice bluetoothDevice2 : bondedDevices) {
                if (!(bluetoothDevice2.getType() == 1 || hashMap.containsKey(bluetoothDevice2.getAddress()))) {
                    hashMap.put(bluetoothDevice2.getAddress(), bluetoothDevice2);
                }
            }
        }
        return new ArrayList(hashMap.values());
    }

    private void a(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        C0596r.d(a, "device:" + bluetoothDevice.getAddress() + ",rssi:" + i);
        e e = y.e(bArr);
        e.a = bluetoothDevice;
        e.b = i;
        a(e);
    }

    private void a(BluetoothDevice bluetoothDevice, String str) {
        C0596r.d(a, "device:" + bluetoothDevice.getAddress() + ",uuid:" + str);
        e eVar = new e();
        if (str != null) {
            eVar.f.add(str);
        }
        eVar.a = bluetoothDevice;
        eVar.b = 0;
        a(eVar);
    }

    private void a(Context context, List<BluetoothDevice> list, UUID uuid) {
        C0596r.d(a, "filter UUID:" + uuid);
        this.s = list.size();
        this.t = 0;
        for (BluetoothDevice bluetoothDevice : list) {
            C0596r.d(a, "connected device:" + bluetoothDevice.getAddress());
            if (uuid == null) {
                a(bluetoothDevice, null);
            } else {
                i.a(context, bluetoothDevice, new c(this, uuid));
            }
        }
        if (uuid == null) {
            this.h.sendEmptyMessage(0);
        }
    }

    private void a(e eVar) {
        Message message = new Message();
        message.what = 2;
        message.obj = eVar;
        this.h.sendMessage(message);
    }

    private void b() {
        e();
    }

    private void b(e eVar) {
        if (eVar != null) {
            BluetoothDevice bluetoothDevice = eVar.a;
            if (bluetoothDevice != null) {
                String name = bluetoothDevice.getName();
                if (name != null && name.equals(c)) {
                    C0596r.d(a, "filter AF~");
                    return;
                }
            }
            for (f fVar : this.r) {
                if (fVar.b() != null) {
                    if (eVar.a(fVar.b())) {
                        fVar.d().a(eVar, fVar);
                    }
                } else if (fVar.c() == null) {
                    fVar.d().a(eVar, fVar);
                } else if (eVar.a.getAddress().contains(fVar.c())) {
                    fVar.d().a(eVar, fVar);
                }
            }
        }
    }

    private void c() {
        if (this.f == null) {
            this.f = new d(this);
        }
        this.e.startLeScan(this.f);
    }

    private void d() {
        if (this.f != null) {
            C0596r.e(a, "stopScan");
            try {
                this.e.stopLeScan(this.f);
            } catch (Exception e) {
                C0596r.d(a, "stopLeScan exception:" + e.getMessage());
            } finally {
                this.f = null;
            }
        }
    }

    private void e() {
    }

    private void f() {
        C0596r.e(a, "startForL");
        if (this.u == null) {
            this.u = new e(this);
        }
        ScanSettings build = new Builder().setReportDelay(0).setScanMode(2).build();
        this.e.getBluetoothLeScanner().startScan(new ArrayList(), build, this.u);
    }

    private void g() {
        C0596r.e(a, "stopForL");
        if (this.u != null) {
            this.e.getBluetoothLeScanner().stopScan(this.u);
            this.u = null;
        }
    }

    private void h() {
        C0596r.e(a, "flushForL");
        if (this.u != null) {
            this.e.getBluetoothLeScanner().flushPendingScanResults(this.u);
        }
    }

    private void start() {
        C0596r.e(a, "startScan");
        if (this.p) {
            C0596r.e(a, "need stop,return!!!");
            return;
        }
        stop();
        c();
        this.h.sendEmptyMessageDelayed(3, kankan.wheel.widget.a.bX);
    }

    private void stop() {
        d();
    }

    public void a(Context context, f fVar) {
        C0596r.d(a, "startScan<" + fVar + ">");
        if (fVar == null || this.r.contains(fVar)) {
            C0596r.d(a, "null or exist BleScanOption,return now!!!");
            return;
        }
        this.p = false;
        this.r.add(fVar);
        if (!fVar.e()) {
            this.h.sendEmptyMessage(0);
        } else if (context == null) {
            C0596r.d(a, "null Context,return now!!!");
            return;
        } else {
            List a = a(context.getApplicationContext());
            if (a == null || a.size() == 0) {
                this.h.sendEmptyMessage(0);
            } else {
                a(this.q, a, fVar.b());
            }
        }
        if (fVar.a() > 0) {
            Message message = new Message();
            message.what = 4;
            message.obj = fVar;
            this.h.sendMessageDelayed(message, (long) fVar.a());
        }
    }

    public void a(f fVar) {
        C0596r.d(a, "stopScan<" + fVar + ">");
        if (fVar == null) {
            C0596r.d(a, "null BleScanOption,return now!!!");
            return;
        }
        Message message = new Message();
        message.what = 4;
        message.obj = fVar;
        this.h.sendMessage(message);
    }
}
