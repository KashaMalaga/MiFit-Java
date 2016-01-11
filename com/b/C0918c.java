package com.b;

import java.util.TimerTask;

class C0918c extends TimerTask {
    final /* synthetic */ int a;
    final /* synthetic */ C0916a b;

    C0918c(C0916a c0916a, int i) {
        this.b = c0916a;
        this.a = i;
    }

    public void run() {
        try {
            if (this.b.n()) {
                this.b.d(this.a);
                if (!this.b.e()) {
                    this.b.w();
                    return;
                }
                return;
            }
            this.b.w();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
