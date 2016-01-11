package cn.com.smartdevices.bracelet.gps.ui;

final class C0504ap {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    int d = a;
    long e = -2;
    long f = -2;
    final /* synthetic */ C0500ak g;

    public C0504ap(C0500ak c0500ak, int i, long j) {
        this.g = c0500ak;
        this.d = i;
        this.e = j;
    }

    public C0504ap(C0500ak c0500ak, int i, long j, long j2) {
        this.g = c0500ak;
        this.d = i;
        this.e = j2;
        this.f = j;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C0504ap)) {
            return false;
        }
        C0504ap c0504ap = (C0504ap) obj;
        return this.d == c0504ap.d && this.e == c0504ap.e && this.f == c0504ap.f;
    }
}
