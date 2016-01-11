package cn.com.smartdevices.bracelet.gps.services;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.gps.model.e;

class C0455n extends C0451j {
    private static final int a = 6;
    private c b;
    private int c;
    private C0456o d;

    public C0455n(long j, String str, C0456o c0456o) {
        super(j, str);
        this.b = null;
        this.c = 0;
        this.d = null;
        this.b = new c();
        this.d = c0456o;
    }

    private boolean a(c cVar, c cVar2) {
        return cVar != null && cVar2 != null && cVar.p == cVar2.p && cVar.q == cVar2.q && cVar.d() == cVar2.d();
    }

    public void b() {
        if (this.d != null) {
            try {
                if (e.a(this.d.d())) {
                    c c = this.d.c();
                    if (c == null) {
                        start();
                        return;
                    }
                    boolean a = a(this.b, c);
                    if (a && this.c >= a) {
                        start();
                        return;
                    } else if (c.a(c.b())) {
                        if (a) {
                            this.c++;
                        } else {
                            this.c = 0;
                            this.b = c;
                        }
                        c = c.a();
                        c.a(System.currentTimeMillis() / 1000);
                        this.d.a(c);
                        this.d.c(c);
                        start();
                        return;
                    } else {
                        start();
                        return;
                    }
                }
                this.c = a;
            } catch (Exception e) {
                C0596r.a("Run", e.getMessage());
            } finally {
                start();
            }
        }
    }
}
