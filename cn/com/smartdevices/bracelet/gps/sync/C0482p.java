package cn.com.smartdevices.bracelet.gps.sync;

import java.util.ArrayList;
import java.util.List;

class C0482p extends C0480n {
    public List<Long> c;
    public long d;

    public C0482p() {
        this.c = null;
        this.d = -1;
        this.c = new ArrayList(0);
    }

    public C0482p(int i) {
        this.c = null;
        this.d = -1;
        if (i <= 0) {
            i = 0;
        }
        this.c = new ArrayList(i);
    }

    public void a() {
        if (this.c != null) {
            this.c.clear();
        }
    }

    public void a(long j) {
        this.c.add(Long.valueOf(j));
    }

    public void a(C0482p c0482p) {
        super.a(c0482p);
        this.d = c0482p.d;
        if (c0482p.c != null) {
            this.c.addAll(c0482p.c);
        }
    }
}
