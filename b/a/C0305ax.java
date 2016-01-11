package b.a;

import com.xiaomi.market.sdk.o;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum C0305ax implements cz {
    PROPERTY((short) 1, "property"),
    VERSION((short) 2, o.x),
    CHECKSUM((short) 3, "checksum");
    
    private static final Map<String, C0305ax> d = null;
    private final short e;
    private final String f;

    static {
        d = new HashMap();
        Iterator it = EnumSet.allOf(C0305ax.class).iterator();
        while (it.hasNext()) {
            C0305ax c0305ax = (C0305ax) it.next();
            d.put(c0305ax.b(), c0305ax);
        }
    }

    private C0305ax(short s, String str) {
        this.e = s;
        this.f = str;
    }

    public static C0305ax a(int i) {
        switch (i) {
            case l.a /*1*/:
                return PROPERTY;
            case a.k /*2*/:
                return VERSION;
            case a.l /*3*/:
                return CHECKSUM;
            default:
                return null;
        }
    }

    public static C0305ax a(String str) {
        return (C0305ax) d.get(str);
    }

    public static C0305ax b(int i) {
        C0305ax a = C0305ax.a(i);
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
