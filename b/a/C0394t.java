package b.a;

import cn.com.smartdevices.bracelet.d.C0430g;
import com.g.a.b.b;
import com.xiaomi.market.sdk.o;
import com.xiaomi.market.sdk.q;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum C0394t implements cz {
    KEY((short) 1, C0430g.b),
    VERSION((short) 2, o.x),
    VERSION_INDEX((short) 3, "version_index"),
    PACKAGE_NAME((short) 4, q.c),
    SDK_TYPE((short) 5, "sdk_type"),
    SDK_VERSION((short) 6, b.g),
    CHANNEL((short) 7, b.c),
    WRAPPER_TYPE((short) 8, "wrapper_type"),
    WRAPPER_VERSION((short) 9, "wrapper_version"),
    VERTICAL_TYPE((short) 10, "vertical_type");
    
    private static final Map<String, C0394t> k = null;
    private final short l;
    private final String m;

    static {
        k = new HashMap();
        Iterator it = EnumSet.allOf(C0394t.class).iterator();
        while (it.hasNext()) {
            C0394t c0394t = (C0394t) it.next();
            k.put(c0394t.b(), c0394t);
        }
    }

    private C0394t(short s, String str) {
        this.l = s;
        this.m = str;
    }

    public static C0394t a(int i) {
        switch (i) {
            case l.a /*1*/:
                return KEY;
            case a.k /*2*/:
                return VERSION;
            case a.l /*3*/:
                return VERSION_INDEX;
            case a.aQ /*4*/:
                return PACKAGE_NAME;
            case a.X /*5*/:
                return SDK_TYPE;
            case a.bt /*6*/:
                return SDK_VERSION;
            case a.bc /*7*/:
                return CHANNEL;
            case a.ba /*8*/:
                return WRAPPER_TYPE;
            case a.bo /*9*/:
                return WRAPPER_VERSION;
            case a.bd /*10*/:
                return VERTICAL_TYPE;
            default:
                return null;
        }
    }

    public static C0394t a(String str) {
        return (C0394t) k.get(str);
    }

    public static C0394t b(int i) {
        C0394t a = C0394t.a(i);
        if (a != null) {
            return a;
        }
        throw new IllegalArgumentException("Field " + i + " doesn't exist!");
    }

    public short a() {
        return this.l;
    }

    public String b() {
        return this.m;
    }
}
