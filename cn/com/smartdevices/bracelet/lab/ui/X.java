package cn.com.smartdevices.bracelet.lab.ui;

import cn.com.smartdevices.bracelet.C0596r;
import java.lang.Thread.State;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

final class X extends Thread {
    final /* synthetic */ V a;

    X(V v) {
        this.a = v;
        super("SportTonePlayer-" + v.i);
    }

    public void run() {
        while (true) {
            synchronized (this.a.f) {
                Y y = (Y) this.a.f.removeFirst();
            }
            switch (y.a) {
                case l.a /*1*/:
                    this.a.b(y);
                    break;
                case a.k /*2*/:
                    if (this.a.h == null) {
                        C0596r.e(this.a.i, "STOP command without a player");
                        break;
                    }
                    this.a.h.stop();
                    this.a.h.release();
                    this.a.h = null;
                    this.a.n.abandonAudioFocus(null);
                    this.a.n = null;
                    if (!(this.a.g == null || this.a.g.getThread().getState() == State.TERMINATED)) {
                        this.a.g.quit();
                        break;
                    }
                case a.l /*3*/:
                    if (this.a.h == null) {
                        C0596r.e(this.a.i, "PAUSE command without a player");
                        break;
                    } else {
                        this.a.h.pause();
                        break;
                    }
                case a.aQ /*4*/:
                    if (this.a.h == null) {
                        C0596r.e(this.a.i, "RESUME command without a player");
                        break;
                    } else {
                        this.a.h.start();
                        break;
                    }
            }
            synchronized (this.a.f) {
                if (this.a.f.size() == 0) {
                    this.a.j = null;
                    this.a.d();
                    return;
                }
            }
        }
    }
}
