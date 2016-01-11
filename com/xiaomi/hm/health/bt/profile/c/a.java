package com.xiaomi.hm.health.bt.profile.c;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.a.d;
import com.xiaomi.hm.health.bt.b.c;
import com.xiaomi.hm.health.bt.c.A;
import com.xiaomi.hm.health.bt.c.x;
import com.xiaomi.hm.health.bt.d.b;
import com.xiaomi.hm.health.bt.e.f;
import com.xiaomi.hm.health.bt.e.g;
import com.xiaomi.hm.health.bt.e.h;
import com.xiaomi.hm.health.bt.model.e;
import com.xiaomi.hm.health.bt.model.i;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"NewApi"})
public abstract class a implements A, h {
    private static String b = "ProfileConnection";
    private static final int c = 0;
    private static final int d = 1;
    protected x a = null;
    private h e = h.UNKNOWN;
    private Context f = null;
    private f g = null;
    private g h = null;
    private boolean i = false;
    private BroadcastReceiver j = new b(this);
    private Handler k = null;
    private ArrayList<f> l = new ArrayList();

    public a(Context context, g gVar) {
        this.f = context;
        this.h = gVar;
        if (gVar.c() == d) {
            this.g = new g().a(gVar.d()).a(true).a((h) this).a();
        } else if (gVar.c() == 2) {
            this.g = new g().a(-1).a(true).a((h) this).a();
        }
        f e = this.h.e();
        if (e != null) {
            this.l.add(e);
        }
        HandlerThread handlerThread = new HandlerThread("ProfileConnection");
        handlerThread.start();
        this.k = new c(this, handlerThread.getLooper());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        this.f.registerReceiver(this.j, intentFilter);
    }

    private void a() {
        com.xiaomi.hm.health.bt.e.a.a().a(this.f, this.g);
        b(h.SEARCHING);
    }

    private void b() {
        com.xiaomi.hm.health.bt.e.a.a().a(this.g);
    }

    private void b(h hVar) {
        if (this.k != null) {
            Message message = new Message();
            message.what = c;
            message.obj = hVar;
            this.k.sendMessage(message);
        }
    }

    private void c() {
        this.i = true;
        if (this.a != null) {
            this.a.a(false);
            this.a.b();
        }
    }

    private boolean d() {
        int state = BluetoothAdapter.getDefaultAdapter().getState();
        return state == 10 || state == 13;
    }

    private void h(BluetoothDevice bluetoothDevice) {
        this.i = false;
        this.a = f(bluetoothDevice);
        if (this.a != null) {
            this.a.a(this.h.f());
            this.a.a();
            b(h.CONNECTING);
        }
    }

    public void a(BluetoothDevice bluetoothDevice) {
        C0596r.d(b, "onDeviceConnected device:" + bluetoothDevice.getAddress());
        b(h.CONNECTING);
    }

    public void a(f fVar) {
        C0596r.d(b, "onScanError:" + fVar);
        b(h.SEARCH_FAILED);
        if (this.h.g() && this.k != null) {
            this.k.sendEmptyMessage(d);
        }
    }

    public void a(e eVar, f fVar) {
        C0596r.d(b, "onScanedDevice<" + eVar.a.getName() + com.xiaomi.mipush.sdk.f.i + eVar.a.getAddress() + ">");
        if (eVar.a.getAddress().equalsIgnoreCase(this.h.a())) {
            b(h.SEARCHED);
            h(eVar.a);
            com.xiaomi.hm.health.bt.e.a.a().a(fVar);
        }
    }

    public void a(f fVar) {
        synchronized (this.l) {
            if (this.l.contains(fVar)) {
                return;
            }
            this.l.add(fVar);
        }
    }

    protected void a(h hVar) {
        synchronized (this.l) {
            Iterator it = this.l.iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(hVar);
            }
        }
    }

    public abstract boolean a(String str, b bVar);

    public void b(BluetoothDevice bluetoothDevice) {
        C0596r.d(b, "onDeviceConnectionFailed device:" + bluetoothDevice.getAddress());
        b(this.h.f() ? h.CONNECTING : h.CONNECT_FAILED);
    }

    public void b(f fVar) {
        C0596r.d(b, "onScanStop:" + fVar);
        if (this.e != h.CONNECTING) {
            b(h.SEARCH_FAILED);
            if (this.h.g() && this.k != null) {
                this.k.sendEmptyMessage(d);
            }
        }
    }

    public void b(f fVar) {
        synchronized (this.l) {
            this.l.remove(fVar);
        }
    }

    public void c(BluetoothDevice bluetoothDevice) {
        C0596r.d(b, "onDeviceDisconnected device:" + bluetoothDevice.getAddress());
        h hVar = h.CONNECTING;
        hVar = this.i ? h.CONNECT_FAILED : this.h.f() ? h.CONNECTING : h.CONNECT_FAILED;
        b(hVar);
    }

    public abstract boolean c(d dVar);

    public void d(BluetoothDevice bluetoothDevice) {
        C0596r.d(b, " onInitializationFailed device:" + bluetoothDevice.getAddress());
        b(this.h.f() ? h.CONNECTING : h.CONNECT_FAILED);
    }

    public abstract i e();

    public void e(BluetoothDevice bluetoothDevice) {
        C0596r.d(b, "onInitializationSuccess device:" + bluetoothDevice.getAddress());
        b(h.CONNECTED);
    }

    protected abstract x f(BluetoothDevice bluetoothDevice);

    public boolean f() {
        boolean z;
        synchronized (this.e) {
            z = this.a != null && this.e == h.CONNECTED;
        }
        return z;
    }

    public h g() {
        h hVar;
        synchronized (this.e) {
            hVar = this.e;
        }
        return hVar;
    }

    void g(BluetoothDevice bluetoothDevice) {
        if (d()) {
            b(h.CONNECT_FAILED);
        } else if (bluetoothDevice == null || bluetoothDevice.getType() != 2) {
            a();
        } else {
            h(bluetoothDevice);
        }
    }

    x h() {
        return this.a;
    }

    public g i() {
        return this.h;
    }

    public c j() {
        return this.h.b();
    }

    public String k() {
        return this.h.a();
    }

    public f l() {
        return this.g;
    }

    void m() {
        b();
        c();
        synchronized (this.l) {
            this.l.clear();
        }
        if (this.k != null) {
            this.k.removeCallbacksAndMessages(null);
            this.k = null;
        }
        if (this.f != null) {
            this.f.unregisterReceiver(this.j);
            this.f = null;
        }
    }
}
