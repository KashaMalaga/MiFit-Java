package b.a;

import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum C0382h implements cw {
    ACCESS_TYPE_UNKNOWN(0),
    ACCESS_TYPE_2G_3G(1),
    ACCESS_TYPE_WIFI(2),
    ACCESS_TYPE_ETHERNET(3);
    
    private final int e;

    private C0382h(int i) {
        this.e = i;
    }

    public static C0382h a(int i) {
        switch (i) {
            case a.i /*0*/:
                return ACCESS_TYPE_UNKNOWN;
            case l.a /*1*/:
                return ACCESS_TYPE_2G_3G;
            case a.k /*2*/:
                return ACCESS_TYPE_WIFI;
            case a.l /*3*/:
                return ACCESS_TYPE_ETHERNET;
            default:
                return null;
        }
    }

    public int a() {
        return this.e;
    }
}
