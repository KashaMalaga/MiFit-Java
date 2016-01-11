package cn.com.smartdevices.bracelet.gps.f;

import android.content.Context;
import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.gps.model.g;
import java.util.List;

public class m implements t {
    private s a = null;
    private final c b = null;
    private final int c = 1;

    public m(Context context, C c) {
        this.a = new n(context, c.a());
    }

    public void a() {
        this.a.a();
    }

    public void a(float f) {
        this.a.a(f);
    }

    public void a(int i) {
    }

    public void a(u uVar) {
        this.a.a(uVar);
    }

    public void a(c cVar) {
        this.a.b(cVar);
    }

    public void a(c cVar, c cVar2, g gVar) {
        this.a.b(cVar, cVar2, gVar);
    }

    public void a(List<c> list) {
        this.a.a((List) list);
    }

    public void a(List<c> list, u uVar) {
        this.a.a((List) list, uVar);
    }

    public void a(List<c> list, g gVar) {
        if (list != null && list.size() > 0 && gVar != null) {
            if (!gVar.b || gVar.c) {
                this.a.b(list, gVar);
            } else {
                this.a.c(list, gVar);
            }
        }
    }

    public void a(boolean z) {
        this.a.a(z);
    }

    public void b() {
        this.a.d();
    }

    public void b(int i) {
        this.a.c(i);
    }

    public void b(c cVar) {
        this.a.c(cVar);
    }

    public void b(List<c> list) {
        a((List) list, null);
    }

    public int c() {
        return 1;
    }

    public void c(int i) {
        this.a.d(i);
    }

    public void c(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("End point should not be null.");
        }
        this.a.d(cVar);
    }

    public void d() {
        this.a.a(this.b);
    }

    public void d(c cVar) {
        this.a.e(cVar);
    }

    public void e() {
        a(null);
    }

    public void e(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("Start point should not be null.");
        }
        this.a.g(cVar);
    }
}
