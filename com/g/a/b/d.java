package com.g.a.b;

import android.content.Context;
import b.a.C0343cg;
import b.a.bX;
import b.a.cf;
import com.g.a.C1059a;
import com.g.a.p;
import com.g.a.q;

public class d extends cf implements Runnable {
    Context a;
    final /* synthetic */ b b;

    public d(b bVar, Context context) {
        this.b = bVar;
        this.a = context.getApplicationContext();
    }

    private void b() {
        C0343cg cVar = new c(this.b, this.b.b(this.a));
        String[] strArr = p.g;
        e eVar = null;
        for (String a : strArr) {
            cVar.a(a);
            eVar = (e) a(cVar, e.class);
            if (eVar != null) {
                break;
            }
        }
        if (eVar == null) {
            this.b.a(null);
        } else if (eVar.b) {
            if (this.b.l != null) {
                this.b.l.a(eVar.c, (long) eVar.d);
            }
            this.b.a(this.a, eVar);
            this.b.b(this.a, eVar);
            this.b.a(eVar.a);
        } else {
            this.b.a(null);
        }
    }

    public boolean a() {
        return false;
    }

    public void run() {
        if (!C1059a.o || q.a(this.a)) {
            try {
                b();
            } catch (Exception e) {
                this.b.a(null);
                bX.c(p.e, "reques update error", e);
            }
        }
    }
}
