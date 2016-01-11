package cn.com.smartdevices.bracelet.shoes.sync;

import com.xiaomi.hm.health.bt.a.d;

final class C0634k extends d {
    final /* synthetic */ C0632i a;
    private String b = null;

    public C0634k(C0632i c0632i) {
        this.a = c0632i;
        this.b = c0632i.b(true);
    }

    public void a() {
        C0635l.a(this.a.g).b(this.b);
        if (this.a.c != null) {
            this.a.c.d();
        }
    }

    public void a(int i) {
        if (this.a.c != null) {
            this.a.c.a(i);
        }
    }

    public void a(Object obj) {
        C0635l.a(this.a.g).c(this.b);
        if (this.a.c != null) {
            this.a.c.c(obj);
        }
    }

    public void b(Object obj) {
        C0635l.a(this.a.g).c(this.b);
        if (this.a.c != null) {
            this.a.c.b(obj);
        }
    }

    public boolean e(Object obj) {
        return this.a.c != null ? this.a.c.a(obj) : true;
    }
}
