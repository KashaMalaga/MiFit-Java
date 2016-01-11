package b.a;

import cn.com.smartdevices.bracelet.gps.services.ay;
import com.xiaomi.market.sdk.o;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum C0293al implements cz {
    IDENTITY((short) 1, "identity"),
    TS((short) 2, ay.H),
    VERSION((short) 3, o.x);
    
    private static final Map<String, C0293al> d = null;
    private final short e;
    private final String f;

    static {
        d = new HashMap();
        Iterator it = EnumSet.allOf(C0293al.class).iterator();
        while (it.hasNext()) {
            C0293al c0293al = (C0293al) it.next();
            d.put(c0293al.b(), c0293al);
        }
    }

    private C0293al(short s, String str) {
        this.e = s;
        this.f = str;
    }

    public static C0293al a(int i) {
        switch (i) {
            case l.a /*1*/:
                return IDENTITY;
            case a.k /*2*/:
                return TS;
            case a.l /*3*/:
                return VERSION;
            default:
                return null;
        }
    }

    public static C0293al a(String str) {
        return (C0293al) d.get(str);
    }

    public static C0293al b(int i) {
        C0293al a = C0293al.a(i);
        if (a != null) {
            return a;
        }
        throw new IllegalArgumentException("Field " + i + " doesn't exist!");
    }

    public short a() {
        return this.e;
    }

    public String b() {
        return this.f;
    }
}
