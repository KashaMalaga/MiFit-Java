package com.amap.api.mapcore.util;

import cn.com.smartdevices.bracelet.partner.NativeInterface;

public abstract class ay implements Runnable {
    a a;

    interface a {
        void a(ay ayVar);

        void b(ay ayVar);
    }

    public abstract void a();

    public final void run() {
        try {
            if (this.a != null) {
                this.a.a(this);
            }
            if (!Thread.interrupted()) {
                a();
                if (!Thread.interrupted() && this.a != null) {
                    this.a.b(this);
                }
            }
        } catch (Throwable th) {
            az.a(th, "ThreadTask", NativeInterface.RUN);
            th.printStackTrace();
        }
    }
}
