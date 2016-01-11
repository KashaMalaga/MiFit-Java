package com.xiaomi.network;

import java.util.List;
import java.util.TimerTask;
import org.apache.thrift.f;

class t extends TimerTask {
    final /* synthetic */ o a;

    t(o oVar) {
        this.a = oVar;
    }

    public void run() {
        for (p pVar : this.a.a) {
            List a = pVar.a();
            double b = pVar.b();
            if (a != null) {
                try {
                    if (a.size() > 0) {
                        this.a.a(a, b);
                    }
                } catch (f e) {
                    e.printStackTrace();
                }
            }
        }
        this.a.d = false;
    }
}
