package com.xiaomi.channel.a.c;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class c extends Thread {
    final /* synthetic */ b a;
    private final LinkedBlockingQueue<d> b = new LinkedBlockingQueue();

    public c(b bVar) {
        this.a = bVar;
        super("PackageProcessor");
    }

    public void a(d dVar) {
        this.b.add(dVar);
    }

    public void run() {
        while (!this.a.c) {
            try {
                this.a.e = (d) this.b.poll(1, TimeUnit.SECONDS);
                if (this.a.e != null) {
                    this.a.b.sendMessage(this.a.b.obtainMessage(0, this.a.e));
                    this.a.e.b();
                    this.a.b.sendMessage(this.a.b.obtainMessage(1, this.a.e));
                }
            } catch (Throwable e) {
                com.xiaomi.channel.a.b.c.a(e);
            }
        }
    }
}
