package cn.com.smartdevices.bracelet.gps.e;

import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public class c {
    private static final double a = 0.5d;
    private static final double b = 0.454d;
    private static final double c = 1.609344d;

    public static h a() {
        switch (b.c()) {
            case l.a /*1*/:
                return new e();
            default:
                return new l();
        }
    }

    public static i b() {
        switch (b.f()) {
            case l.a /*1*/:
                return new f();
            case a.bp /*16*/:
                return new g();
            default:
                return new m();
        }
    }
}
