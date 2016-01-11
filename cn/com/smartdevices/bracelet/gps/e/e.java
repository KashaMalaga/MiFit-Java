package cn.com.smartdevices.bracelet.gps.e;

final class e implements h {
    private e() {
    }

    public j a(double d) {
        return new j(d / 1.609344d, n.Mile);
    }

    public k a() {
        return k.British;
    }

    public j b(double d) {
        return new j(1.609344d * d, n.MinPerMile);
    }

    public j c(double d) {
        return new j(d / 1.609344d, n.MilePerHour);
    }
}
