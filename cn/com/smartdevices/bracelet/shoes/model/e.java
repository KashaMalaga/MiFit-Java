package cn.com.smartdevices.bracelet.shoes.model;

import com.xiaomi.e.a;

public class e extends j {
    public static final int a = 1;
    public static final int b = 2;
    private static final long serialVersionUID = 1;
    private String p = a.f;
    private boolean q = false;
    private boolean r = false;
    private c s = null;

    public e(String str, int i) {
        super(str, i);
    }

    public e(String str, int i, c cVar) {
        super(str, i);
        this.s = cVar;
    }

    public String a() {
        return this.e;
    }

    public void a(String str) {
        this.n = str;
    }

    public void a(boolean z) {
        this.r = z;
    }

    public boolean a(c cVar) {
        if (cVar == null || cVar.e()) {
            return false;
        }
        this.s = cVar;
        return true;
    }

    public String b() {
        return this.p;
    }

    public void b(String str) {
        this.p = str;
    }

    public void b(boolean z) {
        this.q = z;
    }

    public String c() {
        return this.s == null ? a.f : this.s.a();
    }

    public void c(String str) {
        if (this.s == null) {
            throw new IllegalStateException("IllegalStateException mShoesIdentity is null");
        }
        this.s.a(str);
    }

    public String d() {
        return this.j;
    }

    public void d(String str) {
        this.i = str;
    }

    public c e() {
        return this.s;
    }

    public void e(String str) {
        this.m = str;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return eVar.e == this.e && eVar.f == this.f;
    }

    public boolean f() {
        return this.q;
    }

    public String g() {
        return this.s == null ? a.f : this.s.b();
    }

    public String h() {
        return this.i;
    }

    public String i() {
        return this.s == null ? a.f : this.s.d();
    }

    public int j() {
        return this.f;
    }

    public boolean k() {
        return this.r;
    }

    public String toString() {
        if (this.s == null) {
            return super.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString()).append(this.s.toString());
        return stringBuilder.toString();
    }
}
