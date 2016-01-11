package b.a;

import android.content.Context;
import com.xiaomi.mistatistic.sdk.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class C0368da {
    private final String a = "umeng_it.cache";
    private File b;
    private C0294am c = null;
    private long d;
    private long e;
    private Set<C0281a> f = new HashSet();

    public C0368da(Context context) {
        this.b = new File(context.getFilesDir(), "umeng_it.cache");
        this.e = d.h;
    }

    private void a(C0294am c0294am) {
        if (c0294am != null) {
            try {
                byte[] a;
                synchronized (this) {
                    a = new cB().a(c0294am);
                }
                if (a != null) {
                    C0352cm.a(this.b, a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void g() {
        C0294am c0294am = new C0294am();
        Map hashMap = new HashMap();
        List arrayList = new ArrayList();
        for (C0281a c0281a : this.f) {
            if (c0281a.c()) {
                if (c0281a.d() != null) {
                    hashMap.put(c0281a.b(), c0281a.d());
                }
                if (!(c0281a.e() == null || c0281a.e().isEmpty())) {
                    arrayList.addAll(c0281a.e());
                }
            }
        }
        c0294am.a(arrayList);
        c0294am.a(hashMap);
        synchronized (this) {
            this.c = c0294am;
        }
    }

    private C0294am h() {
        InputStream fileInputStream;
        Exception e;
        Throwable th;
        if (!this.b.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(this.b);
            try {
                byte[] b = C0352cm.b(fileInputStream);
                cq c0294am = new C0294am();
                new C0360cv().a(c0294am, b);
                C0352cm.c(fileInputStream);
                return c0294am;
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    C0352cm.c(fileInputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    C0352cm.c(fileInputStream);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            e.printStackTrace();
            C0352cm.c(fileInputStream);
            return null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            C0352cm.c(fileInputStream);
            throw th;
        }
    }

    public void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.d >= this.e) {
            Object obj = null;
            for (C0281a c0281a : this.f) {
                if (!c0281a.c()) {
                    obj = 1;
                } else if (c0281a.a()) {
                    obj = 1;
                }
            }
            if (obj != null) {
                g();
                f();
            }
            this.d = currentTimeMillis;
        }
    }

    public void a(long j) {
        this.e = j;
    }

    public void a(C0281a c0281a) {
        this.f.add(c0281a);
    }

    public C0294am b() {
        return this.c;
    }

    public String c() {
        return null;
    }

    public void d() {
        boolean z = false;
        for (C0281a c0281a : this.f) {
            if (!(!c0281a.c() || c0281a.e() == null || c0281a.e().isEmpty())) {
                c0281a.a(null);
                z = true;
            }
        }
        if (z) {
            this.c.b(false);
            f();
        }
    }

    public void e() {
        C0294am h = h();
        if (h != null) {
            List<C0281a> arrayList = new ArrayList(this.f.size());
            synchronized (this) {
                this.c = h;
                for (C0281a c0281a : this.f) {
                    c0281a.a(this.c);
                    if (!c0281a.c()) {
                        arrayList.add(c0281a);
                    }
                }
                for (C0281a c0281a2 : arrayList) {
                    this.f.remove(c0281a2);
                }
            }
            g();
        }
    }

    public void f() {
        if (this.c != null) {
            a(this.c);
        }
    }
}
