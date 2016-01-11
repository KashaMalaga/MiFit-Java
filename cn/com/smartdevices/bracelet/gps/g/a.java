package cn.com.smartdevices.bracelet.gps.g;

import android.content.Context;
import cn.com.smartdevices.bracelet.gps.h.h;
import cn.com.smartdevices.bracelet.gps.h.i;

public class a implements i {
    private j a;
    private e b;
    private boolean c;

    public a(Context context) {
        this.a = null;
        this.b = null;
        this.c = false;
        this.a = new j();
        this.b = new e(this, context);
    }

    public void a() {
        if (this.b != null) {
            this.b.a();
        }
        if (this.a != null) {
            this.a.a();
        }
    }

    public void a(int i) {
        if (!this.c && this.b != null) {
            d dVar = new d();
            dVar.c = 4;
            dVar.b = this.a.a(i);
            this.b.a(dVar);
        }
    }

    public void a(h hVar) {
        if (!this.c) {
            if (hVar == null) {
                throw new IllegalArgumentException();
            }
            hVar.a = h.a(hVar.a / 1000.0f, 2);
            hVar.b = (float) i.c(hVar.b);
            d dVar = new d();
            dVar.c = 1;
            dVar.b = this.a.a(hVar);
            this.b.a(dVar);
        }
    }

    public void a(boolean z) {
        this.c = z;
        if (z) {
            this.b.b();
        }
    }

    public void b() {
        if (!this.c && this.b != null) {
            d dVar = new d();
            dVar.c = 2;
            dVar.b = this.a.b();
            this.b.a(dVar);
        }
    }

    public void c() {
        if (!this.c && this.b != null) {
            d dVar = new d();
            dVar.c = 3;
            dVar.b = this.a.c();
            this.b.a(dVar);
        }
    }
}
