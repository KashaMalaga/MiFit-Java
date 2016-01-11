package com.xiaomi.f;

import com.activeandroid.b;

class i extends Thread {
    final /* synthetic */ C1091b a;
    private Thread b = this;
    private int c = b.a;

    i(C1091b c1091b) {
        this.a = c1091b;
    }

    public void run() {
        try {
            char[] cArr = new char[this.c];
            while (this.a.x == this.b && !this.a.u) {
                this.a.i.read(cArr, 0, this.c);
            }
        } catch (Throwable th) {
        }
    }
}
