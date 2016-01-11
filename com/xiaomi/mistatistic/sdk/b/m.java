package com.xiaomi.mistatistic.sdk.b;

import android.os.Handler;
import java.util.ArrayList;

public class m {
    private static m a = null;
    private static m b = null;
    private volatile Handler c;
    private ArrayList d = new ArrayList();

    private m(String str) {
        new q(this, str).start();
    }

    public static synchronized m a() {
        m mVar;
        synchronized (m.class) {
            if (a == null) {
                a = new m("local_job_dispatcher");
            }
            mVar = a;
        }
        return mVar;
    }

    public static synchronized m b() {
        m mVar;
        synchronized (m.class) {
            if (b == null) {
                b = new m("remote_job_dispatcher");
            }
            mVar = b;
        }
        return mVar;
    }

    public void a(p pVar) {
        synchronized (this.d) {
            if (this.c == null) {
                this.d.add(pVar);
            } else {
                this.c.post(new n(this, pVar));
            }
        }
    }

    public void a(p pVar, long j) {
        if (this.c != null) {
            this.c.postDelayed(new o(this, pVar), j);
        } else {
            new A().a("drop the job as handler is not ready.", null);
        }
    }
}
