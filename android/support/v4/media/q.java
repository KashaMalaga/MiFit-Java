package android.support.v4.media;

import android.os.SystemClock;
import android.view.KeyEvent;

public abstract class q {
    static final int a = 1;
    static final int b = 2;
    static final int c = 3;
    static final int d = -1;
    static final int e = -2;
    static final int f = -3;

    public abstract void a();

    public void a(int i) {
        int i2 = 0;
        switch (i) {
            case d /*-1*/:
                i2 = h.j;
                break;
        }
        if (i2 != 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            a(i2, new KeyEvent(uptimeMillis, uptimeMillis, 0, i2, 0));
            b(i2, new KeyEvent(uptimeMillis, uptimeMillis, a, i2, 0));
        }
    }

    public abstract void a(long j);

    public boolean a(int i, KeyEvent keyEvent) {
        switch (i) {
            case 79:
            case 85:
                if (!f()) {
                    a();
                    break;
                }
                b();
                break;
            case 86:
                c();
                break;
            case h.i /*126*/:
                a();
                break;
            case h.j /*127*/:
                b();
                break;
        }
        return true;
    }

    public abstract void b();

    public boolean b(int i, KeyEvent keyEvent) {
        return true;
    }

    public abstract void c();

    public abstract long d();

    public abstract long e();

    public abstract boolean f();

    public int g() {
        return 100;
    }

    public int h() {
        return 60;
    }
}
