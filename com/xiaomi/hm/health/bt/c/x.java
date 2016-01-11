package com.xiaomi.hm.health.bt.c;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Environment;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.model.p;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import kankan.wheel.widget.a;

public class x extends C1118a implements D {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    private static final String k = "GattPeripheral";
    protected int d_ = a;
    private boolean l = true;
    private A m = null;
    private FileOutputStream n = null;
    private FileLock o = null;

    protected x(Context context, BluetoothDevice bluetoothDevice, A a) {
        super(context, bluetoothDevice);
        C0596r.e();
        this.m = a;
    }

    private void y() {
        C0596r.e();
        try {
            this.n = new FileOutputStream(Environment.getExternalStorageDirectory() + "/Android/.btlock");
            this.o = this.n.getChannel().lock();
            C0596r.a("FileLock: " + this.o.isValid());
            this.n.write(b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void z() {
        C0596r.e();
        if (this.n != null && this.o != null) {
            try {
                this.n.write(a);
                this.o.release();
                this.n.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void a(int i) {
        C0596r.e();
    }

    protected void a(BluetoothGattDescriptor bluetoothGattDescriptor) {
        C0596r.e();
    }

    public void a(Object obj) {
        if (obj != null) {
            synchronized (obj) {
                obj.notify();
            }
        }
    }

    public void a(Object obj, int i) {
        if (obj != null) {
            synchronized (obj) {
                try {
                    obj.wait((long) i);
                } catch (Exception e) {
                }
            }
        }
    }

    public void a(boolean z) {
        this.l = z;
    }

    public boolean a(int i, int i2, int i3, int i4, int i5) {
        return false;
    }

    protected void b(BluetoothGattDescriptor bluetoothGattDescriptor) {
        C0596r.e();
    }

    public boolean b(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        C0596r.e();
        C0596r.a((Object) bluetoothGattCharacteristic);
        C0596r.a((Object) bArr);
        if (bluetoothGattCharacteristic == null || bArr == null) {
            return false;
        }
        int a = a(bluetoothGattCharacteristic, bArr);
        C0596r.a(a == 0);
        return a == 0;
    }

    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    protected void d(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        C0596r.e();
    }

    protected void e(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        C0596r.e();
    }

    protected void f(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        C0596r.e();
    }

    @SuppressLint({"NewApi"})
    public byte[] g(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        C0596r.e();
        C0596r.a((Object) bluetoothGattCharacteristic);
        if (bluetoothGattCharacteristic == null) {
            return null;
        }
        int a = a(bluetoothGattCharacteristic);
        C0596r.a(a == 0);
        return a == 0 ? bluetoothGattCharacteristic.getValue() : null;
    }

    @SuppressLint({"NewApi"})
    protected void h() {
        C0596r.e();
        if (this.m != null) {
            this.m.a(f());
        }
        boolean discoverServices = l().discoverServices();
        C0596r.d(k, "discoverServices return " + discoverServices);
        if (!discoverServices) {
            o();
        }
    }

    protected void i() {
        C0596r.e();
        if (this.m != null) {
            this.m.c(f());
        }
        o();
    }

    protected void j() {
        C0596r.e();
        if (this.m != null) {
            this.m.b(f());
        }
        o();
    }

    @SuppressLint({"NewApi"})
    protected void k() {
        C0596r.e();
        for (BluetoothGattService bluetoothGattService : l().getServices()) {
            C0596r.a((bluetoothGattService.getType() == 0 ? "Primary" : "Secondary") + " service: " + y.c(bluetoothGattService.getUuid()));
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                C0596r.a("  Characteristic: " + y.c(bluetoothGattCharacteristic.getUuid()));
                C0596r.a("    - Properties: " + y.b(bluetoothGattCharacteristic.getProperties()));
                for (BluetoothGattDescriptor uuid : bluetoothGattCharacteristic.getDescriptors()) {
                    C0596r.a("    Descriptor: " + y.c(uuid.getUuid()));
                }
            }
        }
        boolean s = s();
        C0596r.a(s);
        if (!s) {
            n();
        }
    }

    @SuppressLint({"NewApi"})
    protected final void m() {
        C0596r.e();
        C0596r.a("device:");
        C0596r.a("         name: " + f().getName());
        C0596r.a("      address: " + f().getAddress());
        switch (f().getBondState()) {
            case a.bd /*10*/:
                C0596r.a("   bond state: NONE");
                break;
            case a.aW /*11*/:
                C0596r.a("   bond state: BONDING");
                break;
            case a.be /*12*/:
                C0596r.a("   bond state: BONDED");
                break;
        }
        switch (f().getType()) {
            case a /*0*/:
                C0596r.a("         type: UNKNOWN");
                break;
            case b /*1*/:
                C0596r.a("         type: CLASSIC");
                break;
            case c /*2*/:
                C0596r.a("         type: LE");
                break;
            case d /*3*/:
                C0596r.a("         type: DUAL");
                break;
        }
        super.m();
    }

    protected final void n() {
        C0596r.e();
        super.n();
    }

    protected void o() {
        C0596r.e();
        w();
        super.o();
        int state = BluetoothAdapter.getDefaultAdapter().getState();
        C0596r.f("BluetoothAdapter state:" + state);
        if (!this.l) {
            return;
        }
        if (state == 12 || state == 11) {
            try {
                C0596r.a("Delay 1 second before reconnect...");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            m();
        }
    }

    public final boolean q() {
        return this.l;
    }

    public void r() {
        this.m = null;
    }

    public boolean s() {
        C0596r.e();
        boolean t = t();
        C0596r.a(t);
        if (t) {
            if (t) {
                C0596r.d("=================================================");
                C0596r.d("============= INITIALIZATION SUCCESS ============");
                C0596r.d("=================================================");
                this.d_ = b;
                if (this.m != null) {
                    return true;
                }
                this.m.e(f());
                return true;
            }
            C0596r.c("=================================================");
            C0596r.c("============= INITIALIZATION FAILED =============");
            C0596r.c("=================================================");
            this.d_ = c;
            if (this.m != null) {
                this.m.d(f());
            }
            return false;
        } else if (t) {
            C0596r.d("=================================================");
            C0596r.d("============= INITIALIZATION SUCCESS ============");
            C0596r.d("=================================================");
            this.d_ = b;
            if (this.m != null) {
                return true;
            }
            this.m.e(f());
            return true;
        } else {
            C0596r.c("=================================================");
            C0596r.c("============= INITIALIZATION FAILED =============");
            C0596r.c("=================================================");
            this.d_ = c;
            if (this.m != null) {
                this.m.d(f());
            }
            return false;
        }
    }

    protected boolean t() {
        return true;
    }

    public boolean u() {
        return this.d_ == b && g() == C.CONNECTED;
    }

    public boolean v() {
        return this.d_ == b && g() == C.CONNECTED;
    }

    public void w() {
        C0596r.e();
    }

    public p x() {
        return null;
    }
}
