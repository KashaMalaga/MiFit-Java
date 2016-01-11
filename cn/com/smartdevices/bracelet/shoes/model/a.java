package cn.com.smartdevices.bracelet.shoes.model;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.b.d;
import cn.com.smartdevices.bracelet.shoes.b.g;
import com.xiaomi.account.openauth.h;
import org.json.JSONObject;

public abstract class a {
    public static final int a = -1;
    public static final int e = 1;
    public static final int f = 0;
    public static final int g = -1;
    protected f b = null;
    protected c c = null;
    protected int d = k.SYNC_STATE_DEFAULT.a();
    protected String h = com.xiaomi.e.a.f;
    protected String i = com.xiaomi.e.a.f;
    protected int j = g;
    private final g k = d.a();

    public a(String str) {
        this.c = new c(str);
        this.b = new f();
    }

    public a(String str, String str2, String str3) {
        this.c = new c(str, str2, str3);
        this.b = new f();
    }

    public a(String str, String str2, String str3, String str4) {
        this.c = new c(str, str2, str3, str4);
        C0596r.e("bao", "AbstractShoes mShoesIdentity :" + this.c);
        this.b = new f();
    }

    private void z() {
        this.b.b = com.xiaomi.e.a.f;
        this.b.c = g;
        this.b.c();
    }

    public int a() {
        return this.b.j;
    }

    public String a(String str) {
        return this.b.n;
    }

    public void a(int i) {
        this.b.i = i;
    }

    public void a(int i, String str) {
        this.b.g = i;
        this.b.f = str;
    }

    public void a(long j) {
        this.b.o = j;
    }

    public void a(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        }
        this.c = cVar;
    }

    public int b() {
        return this.b.d;
    }

    public void b(int i) {
        this.b.j = i;
    }

    public void b(String str) {
        this.b.a(str);
    }

    public String c() {
        return this.i;
    }

    public void c(int i) {
        if (i == e || i == 0) {
            this.b.d = i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void c(String str) {
        this.c.a(str);
    }

    public int d() {
        return this.b.h;
    }

    public void d(int i) {
        this.b.h = i;
    }

    public void d(String str) {
        this.h = str;
    }

    public String e() {
        String b = cn.com.smartdevices.bracelet.shoes.c.d.b(this.k.a(Math.rint((double) ((this.b.g + this.b.h) / h.E))).a);
        return b + "/" + cn.com.smartdevices.bracelet.shoes.c.d.b(this.k.a((double) this.b.i).a);
    }

    public void e(int i) {
        this.b.c = i;
        this.j = i;
    }

    public void e(String str) {
        this.b.l = str;
    }

    public String f() {
        return this.c.a();
    }

    public void f(int i) {
        this.d = i;
    }

    public void f(String str) {
        this.b.n = str;
    }

    public c g() {
        return this.c;
    }

    void g(String str) {
        this.i = str;
        this.b.b = str;
    }

    public JSONObject h() {
        return this.b.a();
    }

    public boolean i() {
        return (this.b.g + this.b.h) / h.E >= this.b.i;
    }

    public String j() {
        return this.c.b();
    }

    public String k() {
        return this.h;
    }

    public String l() {
        return this.b.l;
    }

    public String m() {
        return this.c.c();
    }

    public String n() {
        return this.c.d();
    }

    public int o() {
        return this.j;
    }

    public int p() {
        return this.d;
    }

    public long q() {
        return this.b.o;
    }

    public int r() {
        return this.b.g;
    }

    public String s() {
        return this.b.f;
    }

    public boolean t() {
        return this.b.d == e;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Shoes indentity:").append(this.c.toString()).append(",mSyncedStateValue:").append(this.d).append(",mSummary:").append(this.b.toString());
        return stringBuilder.toString();
    }

    public boolean u() {
        return this.d != k.STATE_UNSYNCED.a();
    }

    public void v() {
        if (TextUtils.isEmpty(this.c.b()) || this.b.b()) {
            throw new IllegalStateException();
        }
        this.b.d = e;
        this.b.c();
    }

    public void w() {
        this.b.d = f;
        z();
    }

    public void x() {
        a(System.currentTimeMillis() / 1000);
    }

    protected f y() {
        return this.b;
    }
}
