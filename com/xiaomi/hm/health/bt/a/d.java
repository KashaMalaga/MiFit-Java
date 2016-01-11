package com.xiaomi.hm.health.bt.a;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.C0596r;

public class d {
    private static final int a = 0;
    private final int b = 1;
    Handler c = new C1117e(this);
    private final int d = 2;
    private final int e = 3;
    private final String f = "BleCallBack";

    public void a() {
        C0596r.e("BleCallBack", "onStart");
    }

    public void a(int i) {
        C0596r.e("BleCallBack", "onProgress:" + i);
    }

    public void a(Object obj) {
        C0596r.e("BleCallBack", "onFinish:" + obj);
    }

    public void b(int i) {
        Message obtainMessage = this.c.obtainMessage(2);
        obtainMessage.arg1 = i;
        this.c.sendMessage(obtainMessage);
    }

    public void b(Object obj) {
        C0596r.e("BleCallBack", "onFailed:" + obj);
    }

    public void c() {
        this.c.sendMessage(this.c.obtainMessage(0));
    }

    public void c(Object obj) {
        Message obtainMessage = this.c.obtainMessage(1);
        obtainMessage.obj = obj;
        this.c.sendMessage(obtainMessage);
    }

    public int d() {
        return 0;
    }

    public void d(Object obj) {
        Message obtainMessage = this.c.obtainMessage(3);
        obtainMessage.obj = obj;
        this.c.sendMessage(obtainMessage);
    }

    public boolean e(Object obj) {
        C0596r.e("BleCallBack", "onData:" + obj);
        return true;
    }
}
