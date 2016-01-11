package b.a;

import cn.com.smartdevices.bracelet.d.C0432i;
import cn.com.smartdevices.bracelet.gps.services.ay;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum aD implements cz {
    VALUE((short) 1, C0432i.b),
    TS((short) 2, ay.H),
    GUID((short) 3, "guid");
    
    private static final Map<String, aD> d = null;
    private final short e;
    private final String f;

    static {
        d = new HashMap();
        Iterator it = EnumSet.allOf(aD.class).iterator();
        while (it.hasNext()) {
            aD aDVar = (aD) it.next();
            d.put(aDVar.b(), aDVar);
        }
    }

    private aD(short s, String str) {
        this.e = s;
        this.f = str;
    }

    public static aD a(int i) {
        switch (i) {
            case l.a /*1*/:
                return VALUE;
            case a.k /*2*/:
                return TS;
            case a.l /*3*/:
                return GUID;
            default:
                return null;
        }
    }

    public static aD a(String str) {
        return (aD) d.get(str);
    }

    public static aD b(int i) {
        aD a = a(i);
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
