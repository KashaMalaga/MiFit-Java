package com.d.a.a;

import android.content.Context;
import java.util.List;

class C1016e implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ boolean b;
    final /* synthetic */ C1012a c;

    C1016e(C1012a c1012a, Context context, boolean z) {
        this.c = c1012a;
        this.a = context;
        this.b = z;
    }

    public void run() {
        List<N> list = (List) this.c.n.get(this.a);
        if (list != null) {
            for (N a : list) {
                a.a(this.b);
            }
            this.c.n.remove(this.a);
        }
    }
}
