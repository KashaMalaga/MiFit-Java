package com.b;

import java.util.TimerTask;

final class C0935t extends TimerTask {
    private /* synthetic */ C0934s a;

    C0935t(C0934s c0934s) {
        this.a = c0934s;
    }

    public final void run() {
        try {
            if (I.a && this.a.a.d != null) {
                this.a.a.d.startScan();
            }
        } catch (Exception e) {
        }
    }
}
