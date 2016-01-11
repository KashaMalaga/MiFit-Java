package b.a;

import cn.com.smartdevices.bracelet.gps.services.ay;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum aP implements cz {
    LAT((short) 1, "lat"),
    LNG((short) 2, "lng"),
    TS((short) 3, ay.H);
    
    private static final Map<String, aP> d = null;
    private final short e;
    private final String f;

    static {
        d = new HashMap();
        Iterator it = EnumSet.allOf(aP.class).iterator();
        while (it.hasNext()) {
            aP aPVar = (aP) it.next();
            d.put(aPVar.b(), aPVar);
        }
    }

    private aP(short s, String str) {
        this.e = s;
        this.f = str;
    }

    public static aP a(int i) {
        switch (i) {
            case l.a /*1*/:
                return LAT;
            case a.k /*2*/:
                return LNG;
            case a.l /*3*/:
                return TS;
            default:
                return null;
        }
    }

    public static aP a(String str) {
        return (aP) d.get(str);
    }

    public static aP b(int i) {
        aP a = a(i);
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
