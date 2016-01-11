package cn.com.smartdevices.bracelet.gps.f;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.gps.services.C0466z;
import cn.com.smartdevices.bracelet.gps.services.N;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class j {
    private static final String b = "GPSSportTrackLoader";
    protected t a = null;
    private k c = null;
    private ExecutorService d = null;
    private C e = null;
    private int f = 0;
    private int g = 0;
    private N h = null;

    public j(Context context, C c) {
        this.a = l.a(context, 1, c);
        this.d = Executors.newFixedThreadPool(1);
        this.e = c;
    }

    public static boolean a(String str) {
        return TextUtils.isEmpty(str) || !new File(str).exists();
    }

    public C0466z a(Context context, long j) {
        if (context != null && j > 0) {
            return p.d(context, j);
        }
        throw new IllegalArgumentException();
    }

    public void a() {
        this.a.b();
        b();
        if (this.c != null) {
            this.c.a();
        }
        this.d.shutdown();
    }

    public void a(Context context, long j, int i, int i2, int i3, String str) {
        if (context != null && j > 0) {
            this.f = i2;
            this.g = i3;
            this.c = new k(this, context, i, j, str);
            if (this.h != null) {
                this.c.a(this.h);
            }
            this.c.executeOnExecutor(this.d, new Long[0]);
        }
    }

    public void a(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        }
        this.a.b(cVar);
    }

    public void a(N n) {
        this.h = n;
    }

    public void a(List<c> list) {
        this.c.c(list);
    }

    public void a(boolean z) {
        this.a.a(z);
    }

    public void b() {
        if (this.c != null) {
            this.c.b();
        }
        this.h = null;
    }

    protected void b(c cVar) {
        this.a.d(cVar);
    }

    public void c() {
        this.a.e();
    }
}
