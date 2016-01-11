package cn.com.smartdevices.bracelet.b;

class d extends a {
    d() {
    }

    protected float b(int i, long j) {
        return j <= 0 ? 0.0f : ((long) (i * 2)) <= j ? 4.0f : ((long) i) / j <= 1 ? 6.0f : ((long) i) / j <= 2 ? 8.0f : 12.0f;
    }
}
