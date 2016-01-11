package com.b;

import android.os.Looper;
import java.util.Timer;

final class C0931p extends Thread {
    private /* synthetic */ C0930o a;

    C0931p(C0930o c0930o, String str) {
        this.a = c0930o;
        super(str);
    }

    public final void run() {
        try {
            Looper.prepare();
            this.a.C = Looper.myLooper();
            this.a.A = new Timer();
            this.a.v = new C0932q(this.a);
            C0930o.a(this.a, this.a.v);
            this.a.w = new C0933r(this.a);
            try {
                C0930o.a(this.a, this.a.w);
            } catch (Exception e) {
            }
            Looper.loop();
        } catch (Exception e2) {
        }
    }
}
