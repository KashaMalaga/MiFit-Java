package cn.com.smartdevices.bracelet.shoes.b;

final class f implements g {
    private f() {
    }

    public h a(double d) {
        return new h(d / 1.609344d, k.Mile);
    }

    public i a() {
        return i.British;
    }

    public h b(double d) {
        return new h(1.609344d * d, k.MinPerMile);
    }

    public h c(double d) {
        return new h(d / 1.609344d, k.MilePerHour);
    }
}
