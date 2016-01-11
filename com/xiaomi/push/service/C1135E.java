package com.xiaomi.push.service;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Pair;
import cn.com.smartdevices.bracelet.d.C0429f;
import com.xiaomi.channel.a.b.c;
import java.util.ArrayList;
import java.util.List;

public class C1135E extends HandlerThread {
    private volatile long a = 0;
    private volatile boolean b = false;
    private volatile Handler c;
    private List<Pair<e, Long>> d = new ArrayList();

    public C1135E(String str) {
        super(str);
    }

    public void a() {
        for (int i = 1; i < 15; i++) {
            a(i);
        }
    }

    public void a(int i) {
        if (this.c != null) {
            this.c.removeMessages(i);
        }
    }

    public void a(int i, Object obj) {
        if (this.c != null) {
            this.c.removeMessages(i, obj);
        }
    }

    public void a(e eVar, long j) {
        synchronized (this.d) {
            if (this.c != null) {
                Message obtain = Message.obtain();
                obtain.what = eVar.d;
                obtain.obj = eVar;
                this.c.sendMessageDelayed(obtain, j);
            } else {
                c.a("the job is pended, the controller is not ready.");
                this.d.add(new Pair(eVar, Long.valueOf(j)));
            }
        }
    }

    public boolean b() {
        return this.b && System.currentTimeMillis() - this.a > C0429f.a;
    }

    public boolean b(int i) {
        return this.c != null ? this.c.hasMessages(i) : false;
    }

    protected void onLooperPrepared() {
        this.c = new F(this, getLooper());
        synchronized (this.d) {
            for (Pair pair : this.d) {
                c.a("executing the pending job.");
                a((e) pair.first, ((Long) pair.second).longValue());
            }
            this.d.clear();
        }
    }
}
