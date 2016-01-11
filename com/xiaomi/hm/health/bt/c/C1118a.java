package com.xiaomi.hm.health.bt.c;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.bleservice.BLEService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kankan.wheel.widget.a;

@SuppressLint({"NewApi"})
abstract class C1118a extends BluetoothGattCallback implements z {
    private static final String a = "AbsGattCallback";
    private static final String b = C1118a.class.getSimpleName();
    private static final String c = (b + "*");
    private static final String d = b;
    private static final long e = 30;
    private final Map<BluetoothGattCharacteristic, B> A = new HashMap();
    private boolean B = true;
    private HandlerThread f;
    private Handler k;
    private final ReentrantLock l = new ReentrantLock();
    private final Condition m = this.l.newCondition();
    private boolean n = false;
    private int o = z.j;
    private final Object p = new Object();
    private boolean q = false;
    private int r = 0;
    private int s = z.j;
    private final Context t;
    private final BluetoothDevice u;
    private int v = 45000;
    private Runnable w = new C1119b(this);
    private final ExecutorService x = Executors.newSingleThreadExecutor(new n(this));
    private BluetoothGatt y = null;
    private C z = C.DISCONNECTED;

    protected C1118a(Context context, BluetoothDevice bluetoothDevice) {
        C0596r.e();
        this.f = new HandlerThread(c);
        C0596r.d("********************************");
        C0596r.d("NEW THREAD: " + c);
        C0596r.d("********************************");
        this.f.setUncaughtExceptionHandler(new j(this));
        this.f.start();
        this.k = new Handler(this.f.getLooper());
        this.t = context;
        this.u = bluetoothDevice;
    }

    private synchronized int a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        C0596r.e();
        C0596r.a("gatt=" + bluetoothGatt + ", characteristic=" + bluetoothGattCharacteristic);
        C0596r.a((Object) bluetoothGatt);
        C0596r.a((Object) bluetoothGattCharacteristic);
        Runnable kVar = new k(this, bluetoothGatt, bluetoothGattCharacteristic);
        this.l.lock();
        try {
            this.n = true;
            this.k.post(kVar);
            while (this.n) {
                if (!b(bluetoothGatt)) {
                    C0596r.f("NO CONNECTION");
                    break;
                }
                C0596r.b("WAIT: synchronizedReadCharacteristic(): " + y.c(bluetoothGattCharacteristic.getUuid()));
                this.m.await(e, TimeUnit.SECONDS);
                if (this.n) {
                    C0596r.f("GATT OPERATION TIMEOUT");
                    C0596r.b("CONTINUE: synchronizedReadCharacteristic(): " + y.c(bluetoothGattCharacteristic.getUuid()));
                    break;
                }
                C0596r.b("CONTINUE: synchronizedReadCharacteristic(): " + y.c(bluetoothGattCharacteristic.getUuid()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return this.o;
        } finally {
            this.l.unlock();
        }
        return this.o;
    }

    private synchronized int a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        C0596r.e();
        C0596r.a("gatt=" + bluetoothGatt + ", characteristic=" + bluetoothGattCharacteristic + ", value=" + bArr);
        C0596r.a((Object) bluetoothGatt);
        C0596r.a((Object) bluetoothGattCharacteristic);
        C0596r.a((Object) bArr);
        Runnable lVar = new l(this, bluetoothGatt, bluetoothGattCharacteristic, bArr);
        this.l.lock();
        try {
            this.n = true;
            this.k.post(lVar);
            while (this.n) {
                if (!b(bluetoothGatt)) {
                    C0596r.f("NO CONNECTION");
                    break;
                }
                C0596r.b("WAIT: synchronizedWriteCharacteristic(): " + y.c(bluetoothGattCharacteristic.getUuid()));
                this.m.await(e, TimeUnit.SECONDS);
                if (this.n) {
                    C0596r.f("GATT OPERATION TIMEOUT");
                    C0596r.b("CONTINUE: synchronizedWriteCharacteristic(): " + y.c(bluetoothGattCharacteristic.getUuid()));
                    break;
                }
                C0596r.b("CONTINUE: synchronizedWriteCharacteristic(): " + y.c(bluetoothGattCharacteristic.getUuid()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return this.o;
        } finally {
            this.l.unlock();
        }
        return this.o;
    }

    private synchronized int a(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor) {
        C0596r.e();
        C0596r.a("gatt=" + bluetoothGatt + ", characteristic=" + bluetoothGattDescriptor);
        C0596r.a((Object) bluetoothGatt);
        C0596r.a((Object) bluetoothGattDescriptor);
        Runnable mVar = new m(this, bluetoothGatt, bluetoothGattDescriptor);
        this.l.lock();
        try {
            this.n = true;
            this.k.post(mVar);
            while (this.n) {
                if (!b(bluetoothGatt)) {
                    C0596r.f("NO CONNECTION");
                    break;
                }
                C0596r.b("WAIT: synchronizedReadDescriptor(): " + y.c(bluetoothGattDescriptor.getUuid()));
                this.m.await(e, TimeUnit.SECONDS);
                if (this.n) {
                    C0596r.f("GATT OPERATION TIMEOUT");
                    C0596r.b("CONTINUE: synchronizedReadDescriptor(): " + y.c(bluetoothGattDescriptor.getUuid()));
                    break;
                }
                C0596r.b("CONTINUE: synchronizedReadDescriptor(): " + y.c(bluetoothGattDescriptor.getUuid()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return this.o;
        } finally {
            this.l.unlock();
        }
        return this.o;
    }

    private synchronized int a(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr) {
        C0596r.e();
        C0596r.a("gatt=" + bluetoothGatt + ", characteristic=" + bluetoothGattDescriptor + ", value=" + bArr);
        C0596r.a((Object) bluetoothGatt);
        C0596r.a((Object) bluetoothGattDescriptor);
        C0596r.a((Object) bArr);
        Runnable pVar = new p(this, bluetoothGatt, bluetoothGattDescriptor, bArr);
        this.l.lock();
        try {
            this.n = true;
            this.k.post(pVar);
            while (this.n) {
                if (!b(bluetoothGatt)) {
                    C0596r.f("NO CONNECTION");
                    break;
                }
                C0596r.b("WAIT: synchronizedWriteDescriptor(): " + y.c(bluetoothGattDescriptor.getUuid()));
                this.m.await(e, TimeUnit.SECONDS);
                if (this.n) {
                    C0596r.f("GATT OPERATION TIMEOUT");
                    C0596r.b("CONTINUE: synchronizedWriteDescriptor(): " + y.c(bluetoothGattDescriptor.getUuid()));
                    break;
                }
                C0596r.b("CONTINUE: synchronizedWriteDescriptor(): " + y.c(bluetoothGattDescriptor.getUuid()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return this.o;
        } finally {
            this.l.unlock();
        }
        return this.o;
    }

    private void a(BluetoothGatt bluetoothGatt) {
        C0596r.a("mClientIf = " + y.a(bluetoothGatt));
    }

    private boolean b(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt != null;
    }

    public final int a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return a(this.y, bluetoothGattCharacteristic);
    }

    public final int a(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        return a(this.y, bluetoothGattCharacteristic, bArr);
    }

    public final BluetoothGattService a(UUID uuid) {
        C0596r.e();
        C0596r.a(this.y);
        return this.y == null ? null : this.y.getService(uuid);
    }

    public final void a() {
        C0596r.e();
        this.x.execute(new q(this));
    }

    protected abstract void a(int i);

    public final void a(BluetoothGattCharacteristic bluetoothGattCharacteristic, B b) {
        if (!this.A.containsKey(bluetoothGattCharacteristic)) {
            this.A.put(bluetoothGattCharacteristic, b);
        }
    }

    protected abstract void a(BluetoothGattDescriptor bluetoothGattDescriptor);

    public final void b() {
        C0596r.e();
        this.x.execute(new r(this));
    }

    public final void b(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.A.remove(bluetoothGattCharacteristic);
    }

    protected abstract void b(BluetoothGattDescriptor bluetoothGattDescriptor);

    public final boolean b(BluetoothGattCharacteristic bluetoothGattCharacteristic, B b) {
        boolean z = true;
        C0596r.e();
        if (b != null) {
            this.A.put(bluetoothGattCharacteristic, b);
        }
        if (this.y == null) {
            return false;
        }
        boolean characteristicNotification = this.y.setCharacteristicNotification(bluetoothGattCharacteristic, true);
        C0596r.a(characteristicNotification);
        if (!characteristicNotification) {
            return false;
        }
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(y.a);
        C0596r.a((Object) descriptor);
        if (descriptor == null) {
            return false;
        }
        if ((bluetoothGattCharacteristic.getProperties() & 16) > 0) {
            if (a(this.y, descriptor, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE) != 0) {
                z = false;
            }
            return z;
        } else if ((bluetoothGattCharacteristic.getProperties() & 32) <= 0) {
            return false;
        } else {
            if (a(this.y, descriptor, BluetoothGattDescriptor.ENABLE_INDICATION_VALUE) != 0) {
                z = false;
            }
            return z;
        }
    }

    public void c() {
        try {
            BluetoothGatt.class.getDeclaredMethod("refresh", (Class[]) null).invoke(this.y, (Object[]) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final boolean c(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        boolean z = true;
        C0596r.e();
        this.A.remove(bluetoothGattCharacteristic);
        boolean characteristicNotification;
        if (this.z != C.CONNECTED) {
            C0596r.a("m_State != STATE_CONNECTED");
            if (this.y != null) {
                C0596r.a("m_Gatt != null, trying to unregister locally...");
                characteristicNotification = this.y.setCharacteristicNotification(bluetoothGattCharacteristic, false);
                C0596r.a(characteristicNotification);
                if (!characteristicNotification) {
                    return false;
                }
            }
            return true;
        }
        C0596r.a(this.y);
        characteristicNotification = this.y.setCharacteristicNotification(bluetoothGattCharacteristic, false);
        C0596r.a(characteristicNotification);
        if (!characteristicNotification) {
            return false;
        }
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(y.a);
        C0596r.a((Object) descriptor);
        if (descriptor == null) {
            return false;
        }
        if (a(this.y, descriptor, BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE) != 0) {
            z = false;
        }
        return z;
    }

    public final List<BluetoothGattService> d() {
        C0596r.e();
        C0596r.a(this.y);
        return this.y == null ? null : this.y.getServices();
    }

    protected abstract void d(BluetoothGattCharacteristic bluetoothGattCharacteristic);

    public final int e() {
        int i = 0;
        C0596r.e();
        this.q = true;
        C0596r.a(this.y);
        if (this.y == null) {
            this.q = false;
        } else if (this.y.readRemoteRssi()) {
            synchronized (this.p) {
                while (this.q) {
                    try {
                        C0596r.b("WAIT: readRemoteRSSI()");
                        this.p.wait(e);
                        if (this.q) {
                            C0596r.f("GATT OPERATION TIMEOUT");
                            C0596r.b("CONTINUE: readRemoteRSSI()");
                            break;
                        }
                        C0596r.b("CONTINUE: readRemoteRSSI()");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (this.s != 0) {
                } else {
                    i = this.r;
                }
            }
        } else {
            this.q = false;
        }
        return i;
    }

    protected abstract void e(BluetoothGattCharacteristic bluetoothGattCharacteristic);

    public final BluetoothDevice f() {
        return this.u;
    }

    protected abstract void f(BluetoothGattCharacteristic bluetoothGattCharacteristic);

    public final C g() {
        return this.z;
    }

    protected abstract void h();

    protected abstract void i();

    protected abstract void j();

    protected abstract void k();

    protected final BluetoothGatt l() {
        return this.y;
    }

    protected void m() {
        C0596r.e();
        C0596r.a("m_State: " + this.z);
        if (this.z != C.DISCONNECTED) {
            C0596r.f("Illegal state: m_State = " + this.z);
        }
        this.z = C.CONNECTING;
        if (this.y != null) {
            C0596r.a("connect back...");
        }
        this.B = false;
        this.k.postDelayed(this.w, (long) this.v);
        this.y = this.u.connectGatt(this.t, false, this);
        if (this.y == null) {
            C0596r.d("xxx", "connectGatt return null, now disable bluetooth!!!");
            ((BLEService) this.t).e();
        }
        C0596r.a(this.y);
    }

    protected void n() {
        C0596r.e();
        C0596r.a("m_State: " + this.z);
        if (this.z == C.CONNECTING || this.z == C.CONNECTED) {
            C0596r.a(this.y);
            this.z = C.DISCONNECTING;
            this.y.disconnect();
            return;
        }
        C0596r.f("Illegal state: m_State != STATE_CONNECTING && m_State != STATE_CONNECTED");
    }

    protected void o() {
        C0596r.e();
        C0596r.a("m_State: " + this.z);
        if (this.z != C.DISCONNECTED) {
            C0596r.f("Illegal state: m_State = " + this.z);
            return;
        }
        this.A.clear();
        this.l.lock();
        try {
            this.n = false;
            this.o = z.j;
            C0596r.b("RELEASE: c_condGattOperationComplete");
            this.m.signalAll();
            synchronized (this.p) {
                this.q = false;
                this.r = 0;
                this.s = z.j;
                C0596r.b("RELEASE: c_RSSILock");
                this.p.notifyAll();
            }
            this.y.close();
            this.y = null;
            this.B = true;
        } finally {
            this.l.unlock();
        }
    }

    public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        C0596r.e();
        C0596r.a(this.y == bluetoothGatt);
        byte[] value = bluetoothGattCharacteristic.getValue();
        C0596r.a("Characteristic Changed: " + y.b(value));
        Object obj = (B) this.A.get(bluetoothGattCharacteristic);
        C0596r.a(obj);
        this.x.execute(new e(this, obj, value));
        this.x.execute(new f(this, bluetoothGattCharacteristic));
    }

    public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        boolean z = true;
        C0596r.e();
        C0596r.a(i == 0);
        if (this.y != bluetoothGatt) {
            z = false;
        }
        C0596r.a(z);
        C0596r.a("Characteristic Read: " + y.b(bluetoothGattCharacteristic.getValue()));
        this.l.lock();
        try {
            this.o = i;
            C0596r.b("NOTIFY: onCharacteristicRead(): " + this.o);
            this.n = false;
            this.m.signal();
            if (i == 0) {
                this.x.execute(new w(this, bluetoothGattCharacteristic));
            }
        } finally {
            this.l.unlock();
        }
    }

    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        boolean z = true;
        C0596r.e();
        C0596r.a(i == 0);
        if (this.y != bluetoothGatt) {
            z = false;
        }
        C0596r.a(z);
        C0596r.a("Characteristic Write: " + y.b(bluetoothGattCharacteristic.getValue()));
        this.l.lock();
        try {
            this.o = i;
            C0596r.b("NOTIFY: onCharacteristicWrite(): " + this.o);
            this.n = false;
            this.m.signal();
            if (i == 0) {
                this.x.execute(new C1121d(this, bluetoothGattCharacteristic));
            }
        } finally {
            this.l.unlock();
        }
    }

    public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        C0596r.d(a, "onConnectionStateChange:m_Gatt:" + this.y + ",gatt:" + bluetoothGatt + ",status:" + i + ",newState:" + i2);
        this.k.removeCallbacks(this.w);
        C0596r.e();
        C0596r.a(i == 0);
        if (this.y != bluetoothGatt) {
            C0596r.f("m_Gatt: " + this.y);
            C0596r.f("  gatt: " + bluetoothGatt);
            if (this.y != null) {
                C0596r.f("m_Gatt.getDevice(): " + this.y.getDevice());
                a(this.y);
            }
            if (bluetoothGatt != null) {
                C0596r.f("  gatt.getDevice(): " + bluetoothGatt.getDevice());
                a(bluetoothGatt);
            }
            this.y = bluetoothGatt;
        }
        if (i == 0) {
            switch (i2) {
                case a.i /*0*/:
                    this.z = C.DISCONNECTED;
                    C0596r.d("=================================================");
                    C0596r.d("================== DISCONNECTED =================");
                    C0596r.d("=================================================");
                    this.x.execute(new t(this));
                    return;
                case a.k /*2*/:
                    this.z = C.CONNECTED;
                    C0596r.d("=================================================");
                    C0596r.d("=================== CONNECTED ===================");
                    C0596r.d("=================================================");
                    a(this.y);
                    this.x.execute(new s(this));
                    return;
                default:
                    C0596r.f(">>> UNEXPECTED <<<");
                    return;
            }
        }
        C0596r.f("m_Gatt: " + this.y + ",status:" + i);
        C0596r.f("  gatt: " + bluetoothGatt);
        if (this.y != null) {
            C0596r.f("m_Gatt.getDevice(): " + (this.y != null ? this.y.getDevice() : com.xiaomi.e.a.f));
            a(this.y);
        }
        if (bluetoothGatt != null) {
            C0596r.f("  gatt.getDevice(): " + (bluetoothGatt != null ? bluetoothGatt.getDevice() : com.xiaomi.e.a.f));
            a(bluetoothGatt);
        }
        this.z = C.DISCONNECTED;
        C0596r.c("=================================================");
        C0596r.c("=============== CONNECTION FAILED ===============");
        C0596r.c("=================================================");
        this.x.execute(new u(this));
        int a = y.a(this.y);
        if (a > 10 || a == 0) {
            C0596r.d(a, "clientIf is " + a + ", now disable bluetooth!!!");
            ((BLEService) this.t).e();
        }
    }

    public final void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        boolean z = true;
        C0596r.e();
        C0596r.a(i == 0);
        if (this.y != bluetoothGatt) {
            z = false;
        }
        C0596r.a(z);
        C0596r.a("Descriptor Read: " + y.b(bluetoothGattDescriptor.getValue()));
        this.l.lock();
        try {
            this.o = i;
            C0596r.b("NOTIFY: onDescriptorRead(): " + this.o);
            this.n = false;
            this.m.signal();
            if (i == 0) {
                this.x.execute(new g(this, bluetoothGattDescriptor));
            }
        } finally {
            this.l.unlock();
        }
    }

    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        boolean z = true;
        C0596r.e();
        C0596r.a(i == 0);
        if (this.y != bluetoothGatt) {
            z = false;
        }
        C0596r.a(z);
        C0596r.a("Descriptor Write: " + y.b(bluetoothGattDescriptor.getValue()));
        this.l.lock();
        try {
            this.o = i;
            C0596r.b("NOTIFY: onDescriptorWrite(): " + this.o);
            this.n = false;
            this.m.signal();
            if (i == 0) {
                this.x.execute(new h(this, bluetoothGattDescriptor));
            }
        } finally {
            this.l.unlock();
        }
    }

    public final void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        boolean z = true;
        C0596r.e();
        C0596r.a(i2 == 0);
        if (this.y != bluetoothGatt) {
            z = false;
        }
        C0596r.a(z);
        C0596r.a("RSSI: " + i);
        synchronized (this.p) {
            this.r = i;
            this.s = i2;
            C0596r.b("NOTIFY: onReadRemoteRssi(): " + this.s);
            this.q = false;
            this.p.notify();
        }
        if (i2 == 0) {
            this.x.execute(new i(this, i));
        }
    }

    public final void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
        boolean z = true;
        C0596r.e();
        C0596r.a(i == 0);
        if (this.y != bluetoothGatt) {
            z = false;
        }
        C0596r.a(z);
        C0596r.f(">>> UNEXPECTED <<<");
    }

    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        boolean z = true;
        C0596r.d(a, "onServicesDiscovered:m_Gatt:" + this.y + ",gatt:" + bluetoothGatt + ",status:" + i);
        C0596r.e();
        C0596r.a(i == 0);
        if (this.y != bluetoothGatt) {
            z = false;
        }
        C0596r.a(z);
        if (i == 0) {
            this.x.execute(new v(this));
        } else {
            n();
        }
    }
}
