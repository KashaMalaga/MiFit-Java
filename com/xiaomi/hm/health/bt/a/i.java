package com.xiaomi.hm.health.bt.a;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.c.y;
import com.xiaomi.hm.health.bt.profile.a;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.FileInputStream;

public class i extends C {
    private static final Object d = new Object();
    private static Object e = new Object();
    private static final Object f = new Object();
    private static Object g = new Object();
    private String a = null;
    private String b = null;
    private byte[] c = null;

    public i(String str, String str2, d dVar) {
        super(dVar);
        this.a = str2;
        this.b = str;
    }

    public i(String str, byte[] bArr, d dVar) {
        super(dVar);
        this.c = bArr;
        this.b = str;
    }

    public static void a() {
        synchronized (d) {
            C0596r.e(p, "BleFwUpgradeTask before waiting...");
            try {
                d.wait(10000);
            } catch (InterruptedException e) {
            }
            C0596r.e(p, "BleFwUpgradeTask after waiting..." + e);
        }
    }

    public static void a(Object obj) {
        C0596r.e(p, "waitingNotify:" + obj);
        synchronized (d) {
            e = obj;
            d.notify();
        }
    }

    public static void b() {
        synchronized (f) {
            C0596r.e(p, "BleFwUpgradeTask before waitingFwUpdate...");
            try {
                f.wait(10000);
            } catch (InterruptedException e) {
            }
            C0596r.e(p, "BleFwUpgradeTask after waitingFwUpdate..." + g);
        }
    }

    public static void b(Object obj) {
        C0596r.e(p, "waitingNotifyFwUpdate:" + obj);
        synchronized (f) {
            g = obj;
            f.notify();
        }
    }

    public void a(d dVar) {
        Thread.currentThread().setPriority(10);
        e = Integer.valueOf(-1);
        dVar.c();
        if (this.a != null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(this.a);
                this.c = new byte[fileInputStream.available()];
                fileInputStream.read(this.c);
                fileInputStream.close();
            } catch (Exception e) {
                this.c = null;
            }
        }
        if (this.c == null || this.c.length < 1) {
            C0596r.e(p, "no fw data!");
            dVar.c(Integer.valueOf(1));
            return;
        }
        C0596r.e(p, "new firmware version:" + a.a(this.c));
        String[] split = this.b.split(kankan.wheel.widget.a.ci);
        int byteValue = ((Integer.decode("0x" + split[5]).byteValue() & HeartRateInfo.HR_EMPTY_VALUE) | ((Integer.decode("0x" + split[4]).byteValue() & HeartRateInfo.HR_EMPTY_VALUE) << 8)) ^ y.c(this.c);
        byteValue = this.q.j_().f;
        C0596r.e(p, "prepareFirmwareUpdate failed!");
        dVar.c(Integer.valueOf(1));
    }
}
