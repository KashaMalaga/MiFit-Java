package com.xiaomi.f;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.xiaomi.f.c.e;
import com.xiaomi.f.e.g;
import com.xiaomi.f.e.h;
import com.xiaomi.f.e.i;
import java.io.Writer;
import java.util.Locale;

class u {
    private Writer a;
    private A b;

    protected u(A a) {
        this.b = a;
        this.a = a.j;
    }

    private void b(e eVar) {
        synchronized (this.a) {
            try {
                String c = eVar.c();
                this.a.write(c + "\r\n");
                this.a.flush();
                Object o = eVar.o();
                if (!TextUtils.isEmpty(o)) {
                    i.a(this.b.n, o, (long) i.a(c), false, System.currentTimeMillis());
                }
            } catch (Throwable e) {
                throw new D(e);
            }
        }
    }

    void a() {
        this.b.g.clear();
    }

    public void a(e eVar) {
        b(eVar);
        this.b.c(eVar);
    }

    public void b() {
        synchronized (this.a) {
            this.a.write("</stream:stream>");
            this.a.flush();
        }
    }

    void c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<stream:stream");
        stringBuilder.append(" xmlns=\"xm\"");
        stringBuilder.append(" xmlns:stream=\"xm\"");
        stringBuilder.append(" to=\"").append(this.b.d()).append("\"");
        stringBuilder.append(" version=\"105\"");
        stringBuilder.append(" model=\"").append(g.a(Build.MODEL)).append("\"");
        stringBuilder.append(" os=\"").append(g.a(VERSION.INCREMENTAL)).append("\"");
        String a = h.a();
        if (a != null) {
            stringBuilder.append(" uid=\"").append(a).append("\"");
        }
        stringBuilder.append(" sdk=\"").append(Constants.VIA_SSO_LOGIN).append("\"");
        stringBuilder.append(" connpt=\"").append(g.a(this.b.f())).append("\"");
        stringBuilder.append(" host=\"").append(this.b.e()).append("\"");
        stringBuilder.append(" locale=\"").append(g.a(Locale.getDefault().toString())).append("\"");
        stringBuilder.append(">");
        this.a.write(stringBuilder.toString());
        this.a.flush();
    }

    public void d() {
        synchronized (this.a) {
            try {
                this.a.write(this.b.u() + "\r\n");
                this.a.flush();
                this.b.w();
            } catch (Throwable e) {
                throw new D(e);
            }
        }
    }
}
