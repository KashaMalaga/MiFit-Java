package b.a;

import cn.com.smartdevices.bracelet.gps.services.ay;
import com.xiaomi.market.sdk.o;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum R implements cz {
    TS((short) 1, ay.H),
    CONTEXT((short) 2, "context"),
    SOURCE((short) 3, o.L);
    
    private static final Map<String, R> d = null;
    private final short e;
    private final String f;

    static {
        d = new HashMap();
        Iterator it = EnumSet.allOf(R.class).iterator();
        while (it.hasNext()) {
            R r = (R) it.next();
            d.put(r.b(), r);
        }
    }

    private R(short s, String str) {
        this.e = s;
        this.f = str;
    }

    public static R a(int i) {
        switch (i) {
            case l.a /*1*/:
                return TS;
            case a.k /*2*/:
                return CONTEXT;
            case a.l /*3*/:
                return SOURCE;
            default:
                return null;
        }
    }

    public static R a(String str) {
        return (R) d.get(str);
    }

    public static R b(int i) {
        R a = a(i);
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
