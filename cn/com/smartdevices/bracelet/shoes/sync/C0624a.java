package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.b.b;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.sync.b.a;
import com.xiaomi.hm.health.bt.bleservice.BLEService;
import com.xiaomi.hm.health.bt.model.HwSyncDataStatus;
import java.util.HashSet;

class C0624a implements a {
    private static final String a = "SDC";
    private boolean b;
    private boolean c;
    private Context d;
    private c e;
    private int f;
    private boolean g;
    private boolean h;
    private HashSet<String> i;

    public C0624a(Context context, c cVar, boolean z) {
        this.b = false;
        this.c = false;
        this.d = null;
        this.e = null;
        this.f = 0;
        this.g = false;
        this.h = true;
        this.i = null;
        this.b = z;
        this.d = context.getApplicationContext();
        this.e = cVar;
        this.i = new HashSet();
        C0596r.e(a, "DataTransmissionCallback mIdentity = " + this.e);
    }

    public C0624a(Context context, c cVar, boolean z, boolean z2) {
        this.b = false;
        this.c = false;
        this.d = null;
        this.e = null;
        this.f = 0;
        this.g = false;
        this.h = true;
        this.i = null;
        this.i = new HashSet();
        this.h = z2;
        this.b = z;
        this.d = context.getApplicationContext();
        this.e = cVar;
        C0596r.e(a, "DataTransmissionCallback mIdentity = " + this.e);
    }

    private static void a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        context.sendBroadcast(new Intent(BLEService.f));
    }

    private static void a(Context context, int i, int i2, boolean z) {
        Parcelable hwSyncDataStatus = new HwSyncDataStatus(i, i2, z);
        hwSyncDataStatus.a(com.xiaomi.hm.health.bt.b.c.SHOES);
        Intent intent = new Intent(BLEService.e);
        intent.putExtra(BLEService.j, hwSyncDataStatus);
        context.sendBroadcast(intent);
    }

    private static void a(Context context, boolean z) {
        b.a(context, z);
        C0624a.a(context);
    }

    private void a(boolean z) {
        this.c = z;
        this.f = 0;
        this.g = false;
        this.i.clear();
    }

    private static void b(Context context) {
        cn.com.smartdevices.bracelet.shoes.c.b(context, System.currentTimeMillis());
        cn.com.smartdevices.bracelet.shoes.c.c(context, System.currentTimeMillis());
    }

    public void a(int i) {
        this.f = i;
        C0624a.a(this.d, 3, i, true);
    }

    public boolean a() {
        return this.c;
    }

    public boolean a(Object obj) {
        if (obj == null || !(obj instanceof com.xiaomi.hm.health.bt.model.b)) {
            C0596r.d(a, "DataTransmissionCallback onDataUpdated return.identity:" + this.e + ",object = " + obj);
            return true;
        }
        C0596r.d(a, "DataTransmissionCallback onDataUpdated object = " + obj + ",identity:" + this.e + ",thread = " + Thread.currentThread().getId());
        C0629f a = C0628e.a(this.d, this.e, (com.xiaomi.hm.health.bt.model.b) obj);
        boolean z = a.a;
        this.g |= z;
        if (a.b()) {
            this.i.addAll(a.b);
            a.a();
        }
        C0596r.d(a, "DataTransmissionCallback onDataUpdated sectionDone ?= " + z + ",processSucceeded = " + this.g + ",thread:" + Thread.currentThread().getId());
        return z;
    }

    public void b() {
    }

    public void b(Object obj) {
        C0596r.d(a, "DataTransmissionCallback onFailed,thread:" + Thread.currentThread().getId());
        a(false);
        C0624a.a(this.d, 4, 100, false);
    }

    public void c() {
        if (this.f > 0) {
            C0624a.a(this.d, 3, this.f, true);
        }
    }

    public void c(Object obj) {
        C0596r.e(a, "DataTransmissionCallback onFinish processSucceeded = " + this.g + ",mIsSyncToServer = " + this.h + ",thread = " + Thread.currentThread().getId());
        C0624a.b(this.d);
        if (this.g && this.h) {
            J.a(this.d, this.e, this.i);
        }
        if (this.b) {
            C0624a.a(this.d, false);
        }
        a(false);
        C0624a.a(this.d, 4, 100, true);
    }

    public void d() {
        a(true);
        C0624a.a(this.d, 2, 0, true);
        C0596r.e(a, "DataTransmissionCallback onStart");
    }

    public void finalize() {
        C0596r.e(a, "finalize");
        if (this.i != null) {
            this.i.clear();
        }
    }
}
