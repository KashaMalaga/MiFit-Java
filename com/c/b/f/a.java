package com.c.b.f;

import com.c.b.c;
import com.c.b.e;
import com.c.b.n;
import com.c.b.q;
import com.c.b.s;
import com.c.b.u;
import java.util.Map;

public final class a implements q {
    private final q a;

    public a(q qVar) {
        this.a = qVar;
    }

    private static void a(u[] uVarArr, int i, int i2) {
        if (uVarArr != null) {
            for (int i3 = 0; i3 < uVarArr.length; i3++) {
                u uVar = uVarArr[i3];
                uVarArr[i3] = new u(uVar.a() + ((float) i), uVar.b() + ((float) i2));
            }
        }
    }

    public s a(c cVar) {
        return a(cVar, null);
    }

    public s a(c cVar, Map<e, ?> map) {
        s a;
        int a2 = cVar.a() / 2;
        int b = cVar.b() / 2;
        try {
            return this.a.a(cVar.a(0, 0, a2, b), map);
        } catch (n e) {
            try {
                a = this.a.a(cVar.a(a2, 0, a2, b), map);
                a(a.c(), a2, 0);
                return a;
            } catch (n e2) {
                try {
                    a = this.a.a(cVar.a(0, b, a2, b), map);
                    a(a.c(), 0, b);
                    return a;
                } catch (n e3) {
                    try {
                        a = this.a.a(cVar.a(a2, b, a2, b), map);
                        a(a.c(), a2, b);
                        return a;
                    } catch (n e4) {
                        int i = a2 / 2;
                        int i2 = b / 2;
                        a = this.a.a(cVar.a(i, i2, a2, b), map);
                        a(a.c(), i, i2);
                        return a;
                    }
                }
            }
        }
    }

    public void a() {
        this.a.a();
    }
}
