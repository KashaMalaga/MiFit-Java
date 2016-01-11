package cn.com.smartdevices.bracelet.h;

import java.util.Date;

public class g {
    private int a;
    private long b;
    private long c;
    private int d;
    private int e;

    public g(int i, long j, long j2, int i2, int i3) {
        this.a = i;
        this.b = j;
        this.c = j2;
        this.e = i3;
        this.d = i2;
    }

    public g(g gVar) {
        this.a = gVar.a();
        this.b = gVar.b();
        this.c = gVar.c();
        this.e = gVar.e();
        this.d = gVar.d();
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(long j) {
        this.b = j;
    }

    public long b() {
        return this.b;
    }

    public void b(int i) {
        this.e = i;
    }

    public void b(long j) {
        this.c = j;
    }

    public long c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public String toString() {
        return "\nthis.id:" + this.a + "\n" + "this.mBeginTime:" + new Date(this.b).toString() + "\n" + "this.mEndTime:" + new Date(this.c).toString() + "\n" + "this.mMode:" + this.d + "\n" + "this.mSteps:" + this.e;
    }
}
