package cn.com.smartdevices.bracelet.ui;

import android.support.v4.view.bz;
import cn.com.smartdevices.bracelet.chart.util.a;

class C0696az implements bz {
    final /* synthetic */ C0694ax a;

    C0696az(C0694ax c0694ax) {
        this.a = c0694ax;
    }

    public void a(int i) {
        if (this.a.z != 0) {
            this.a.f(((aF) this.a.o.a(i)).c);
        }
    }

    public void a(int i, float f, int i2) {
        int width = this.a.p.getWidth();
        if (width != 0 && this.a.u - i2 < this.a.u / 2) {
            this.a.p.setX((float) (((this.a.u * 2) - i2) - width));
        } else if (width != 0 && i2 < this.a.u / 2) {
            this.a.p.setX((float) ((this.a.u - width) + i2));
        }
        if (this.a.x == null || this.a.y == null) {
            if (this.a.x == null) {
                return;
            }
            if (i == 0) {
                a.a(this.a.x, f);
            } else if (i == 1 && f == 0.0f) {
                a.a(this.a.x, 1.0f);
            }
        } else if (i == 0) {
            a.a(this.a.x, f);
        } else if (i == 1) {
            a.a(this.a.y, f);
        } else if (i == 2 && f == 0.0f) {
            a.a(this.a.y, 1.0f);
        }
    }

    public void b(int i) {
    }
}
