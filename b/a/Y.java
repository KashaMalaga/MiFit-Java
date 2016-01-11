package b.a;

import cn.com.smartdevices.bracelet.gps.services.ay;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum Y implements cz {
    NAME((short) 1, "name"),
    PROPERTIES((short) 2, "properties"),
    DURATION((short) 3, "duration"),
    ACC((short) 4, "acc"),
    TS((short) 5, ay.H);
    
    private static final Map<String, Y> f = null;
    private final short g;
    private final String h;

    static {
        f = new HashMap();
        Iterator it = EnumSet.allOf(Y.class).iterator();
        while (it.hasNext()) {
            Y y = (Y) it.next();
            f.put(y.b(), y);
        }
    }

    private Y(short s, String str) {
        this.g = s;
        this.h = str;
    }

    public static Y a(int i) {
        switch (i) {
            case l.a /*1*/:
                return NAME;
            case a.k /*2*/:
                return PROPERTIES;
            case a.l /*3*/:
                return DURATION;
            case a.aQ /*4*/:
                return ACC;
            case a.X /*5*/:
                return TS;
            default:
                return null;
        }
    }

    public static Y a(String str) {
        return (Y) f.get(str);
    }

    public static Y b(int i) {
        Y a = a(i);
        if (a != null) {
            return a;
        }
        throw new IllegalArgumentException("Field " + i + " doesn't exist!");
    }

    public short a() {
        return this.g;
    }

    public String b() {
        return this.h;
    }
}
