package b.a;

import cn.com.smartdevices.bracelet.gps.services.ay;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum C0287af implements cz {
    DOMAIN((short) 1, "domain"),
    OLD_ID((short) 2, "old_id"),
    NEW_ID((short) 3, "new_id"),
    TS((short) 4, ay.H);
    
    private static final Map<String, C0287af> e = null;
    private final short f;
    private final String g;

    static {
        e = new HashMap();
        Iterator it = EnumSet.allOf(C0287af.class).iterator();
        while (it.hasNext()) {
            C0287af c0287af = (C0287af) it.next();
            e.put(c0287af.b(), c0287af);
        }
    }

    private C0287af(short s, String str) {
        this.f = s;
        this.g = str;
    }

    public static C0287af a(int i) {
        switch (i) {
            case l.a /*1*/:
                return DOMAIN;
            case a.k /*2*/:
                return OLD_ID;
            case a.l /*3*/:
                return NEW_ID;
            case a.aQ /*4*/:
                return TS;
            default:
                return null;
        }
    }

    public static C0287af a(String str) {
        return (C0287af) e.get(str);
    }

    public static C0287af b(int i) {
        C0287af a = C0287af.a(i);
        if (a != null) {
            return a;
        }
        throw new IllegalArgumentException("Field " + i + " doesn't exist!");
    }

    public short a() {
        return this.f;
    }

    public String b() {
        return this.g;
    }
}
