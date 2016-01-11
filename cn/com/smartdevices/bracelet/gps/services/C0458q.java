package cn.com.smartdevices.bracelet.gps.services;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.c.b;
import cn.com.smartdevices.bracelet.gps.sync.z;
import java.util.ArrayList;

final class C0458q extends Handler {
    public static final int a = 3;
    static final int b = 1;
    static final int c = 2;
    static final int d = 1;
    final /* synthetic */ C0456o e;
    private Looper f = null;

    public C0458q(C0456o c0456o, Context context, Looper looper) {
        this.e = c0456o;
        super(looper);
        this.f = looper;
    }

    private void b() {
        this.f.quit();
    }

    public void a() {
        b();
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case d /*1*/:
                if (message.obj != null && (message.obj instanceof ArrayList)) {
                    boolean a = this.e.a(this.e.z, (ArrayList) message.obj);
                    if (b.f(this.e.z) && a) {
                        this.e.o.J = message.arg1;
                        this.e.o.I = this.e.d();
                        p.a(this.e.z, this.e.o);
                        return;
                    }
                    return;
                }
                return;
            case c /*2*/:
                if (message.arg1 == d) {
                    z.b(this.e.z, this.e.l.G());
                } else {
                    p.j(this.e.z, this.e.l.G());
                    p.a(this.e.z, this.e.l);
                }
                if (b.f(this.e.z)) {
                    p.a(this.e.z, this.e.l.G());
                }
                this.e.m();
                b();
                return;
            case a /*3*/:
                if (message.obj != null && (message.obj instanceof ArrayList)) {
                    this.e.a(this.e.z, (ArrayList) message.obj);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
