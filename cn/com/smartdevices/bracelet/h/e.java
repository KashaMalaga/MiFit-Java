package cn.com.smartdevices.bracelet.h;

import java.util.Date;

public class e {
    public static final int a = -1;
    public static final int b = 0;
    public static final int c = 1;
    private int d = a;
    private long e = -1;
    private long f = -1;
    private int g = a;

    public e(long j, int i) {
        this.e = j;
        this.f = j;
        this.d = i;
    }

    public e(long j, int i, int i2) {
        this.e = j;
        this.f = j;
        this.d = i;
        this.g = i2;
    }

    public e(long j, long j2, int i, int i2) {
        this.e = j;
        this.f = j2;
        this.d = i;
        this.g = i2;
    }

    public int a() {
        return this.g;
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(long j) {
        this.e = j;
    }

    public long b() {
        return this.e;
    }

    public void b(int i) {
        this.d = i;
    }

    public void b(long j) {
        this.f = j;
    }

    public long c() {
        return this.f;
    }

    public int d() {
        return this.d;
    }

    public boolean e() {
        return this.d == c && this.e != -1;
    }

    public String toString() {
        return "SensorHubInfo:\ntype:" + this.d + "\n" + "useTimestamp:" + this.e + "(" + new Date(this.e).toString() + ")" + "\n" + "syncTimestamp:" + this.f + "(" + new Date(this.f).toString() + ")\n" + "baseStep:" + this.g;
    }
}
