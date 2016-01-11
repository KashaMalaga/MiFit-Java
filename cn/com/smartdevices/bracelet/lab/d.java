package cn.com.smartdevices.bracelet.lab;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.gaocept.a;
import com.xiaomi.hm.health.bt.d.f;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import java.io.File;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public final class d implements j, f {
    private static final String a = "Lab";
    private static d c = null;
    private int b = -1;
    private f d = null;
    private File e;
    private ConcurrentHashMap<i, a> f = null;
    private final boolean g = false;

    private d(Context context) {
        e();
        this.f = new ConcurrentHashMap();
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (c == null) {
                c = new d(context);
            }
            dVar = c;
        }
        return dVar;
    }

    private void b(int i) {
        for (Entry key : this.f.entrySet()) {
            ((i) key.getKey()).a(i);
        }
    }

    private void b(short s, short s2, short s3) {
        try {
            for (Entry entry : this.f.entrySet()) {
                a aVar = (a) entry.getValue();
                if (aVar.a(s, s2, s3)) {
                    ((i) entry.getKey()).a((i) entry.getKey(), aVar.c(), aVar.g());
                }
            }
        } catch (Exception e) {
        }
    }

    private a d() {
        return this.e == null ? new a(null) : new a(this.e.getAbsolutePath());
    }

    private boolean e() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return false;
        }
        this.e = cn.com.smartdevices.bracelet.a.a.d(".MISportLab");
        return !this.e.exists() ? this.e.mkdir() : true;
    }

    public int a() {
        return this.d == null ? -1 : this.d.b();
    }

    public int a(i iVar) {
        if (iVar == null) {
            throw new IllegalArgumentException("Argument can't be null");
        }
        a aVar = (a) this.f.get(iVar);
        if (aVar != null) {
            return aVar.c();
        }
        throw new IllegalStateException("SportAnalyserObserver " + iVar.hashCode() + " is already unregistered.");
    }

    public void a(int i) {
        if (i == 1) {
            this.b = 1;
        } else if (i == 0) {
            this.b = 2;
        } else if (i == 3) {
            this.b = 2;
        } else if (i == 2) {
            this.b = 1;
        }
        b(this.b);
    }

    public void a(HwConnStatus hwConnStatus) {
        C0596r.e(a, "onBleStatusChanged: " + hwConnStatus.k() + ", " + hwConnStatus.h() + ", " + hwConnStatus.g() + ", " + hwConnStatus.e() + ", " + hwConnStatus.f() + ", " + hwConnStatus.i());
        if (!hwConnStatus.k()) {
            b(0);
        }
    }

    public void a(short s, short s2, short s3) {
        b(s, s2, s3);
    }

    public boolean a(i iVar, l lVar) {
        if (iVar == null || lVar == null) {
            throw new IllegalArgumentException("Argument can't be null");
        }
        a aVar = (a) this.f.get(iVar);
        if (aVar == null) {
            return false;
        }
        try {
            aVar.start(lVar.e(), lVar.b(), lVar.d(), lVar.a());
            return true;
        } catch (Exception e) {
            C0596r.a(a, e.getMessage());
            return false;
        }
    }

    public boolean a(i iVar, String str) {
        if (iVar == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Argument can't be null");
        }
        a aVar = (a) this.f.get(iVar);
        if (aVar == null) {
            return false;
        }
        try {
            aVar.f();
            return true;
        } catch (Exception e) {
            C0596r.a(a, e.getMessage());
            return false;
        }
    }

    public void b(i iVar) {
        if (iVar == null) {
            throw new IllegalArgumentException("Argument can't be null");
        } else if (this.f.containsKey(iVar)) {
            throw new IllegalStateException("SportAnalyserObserver " + iVar.hashCode() + " is already registered.");
        } else {
            this.f.put(iVar, d());
            synchronized (d.class) {
                if (this.d == null) {
                    this.d = new f(this);
                }
                if (this.f.size() == 1 || this.d.b() == 0) {
                    C0596r.e(a, "wanna enable sensor last opState = " + this.d.b());
                    this.d.a(true);
                }
            }
        }
    }

    public boolean b() {
        return com.xiaomi.hm.health.bt.bleservice.a.c();
    }

    public boolean b(i iVar, String str) {
        if (iVar == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Argument can't be null");
        }
        a aVar = (a) this.f.get(iVar);
        if (aVar == null) {
            return false;
        }
        try {
            aVar.start(str, Keeper.readPersonInfo().getMiliWearHand(), l.d, com.xiaomi.e.a.f);
            return true;
        } catch (Exception e) {
            C0596r.a(a, e.getMessage());
            return false;
        }
    }

    public void c() {
        try {
            for (Entry value : this.f.entrySet()) {
                a aVar = (a) value.getValue();
                if (aVar.g()) {
                    aVar.f();
                }
            }
        } catch (Exception e) {
        }
    }

    public void c(i iVar) {
        if (iVar == null) {
            throw new IllegalArgumentException("Argument can't be null");
        } else if (this.f.size() != 0) {
            if (this.f.containsKey(iVar)) {
                this.f.remove(iVar);
                synchronized (d.class) {
                    if (this.d != null && (this.f.size() == 0 || this.d.b() == 0)) {
                        C0596r.e(a, "wanna disable sensor last opState = " + this.d.b());
                        this.d.a(false);
                    }
                }
                return;
            }
            throw new IllegalStateException("SportAnalyserObserver " + iVar.hashCode() + " is already unregistered.");
        }
    }

    public boolean c(i iVar, String str) {
        if (iVar == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Argument can't be null");
        }
        a aVar = (a) this.f.get(iVar);
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }
}
