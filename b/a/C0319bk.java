package b.a;

import cn.com.smartdevices.bracelet.j.f;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum C0319bk implements cz {
    HEIGHT((short) 1, f.C),
    WIDTH((short) 2, "width");
    
    private static final Map<String, C0319bk> c = null;
    private final short d;
    private final String e;

    static {
        c = new HashMap();
        Iterator it = EnumSet.allOf(C0319bk.class).iterator();
        while (it.hasNext()) {
            C0319bk c0319bk = (C0319bk) it.next();
            c.put(c0319bk.b(), c0319bk);
        }
    }

    private C0319bk(short s, String str) {
        this.d = s;
        this.e = str;
    }

    public static C0319bk a(int i) {
        switch (i) {
            case l.a /*1*/:
                return HEIGHT;
            case a.k /*2*/:
                return WIDTH;
            default:
                return null;
        }
    }

    public static C0319bk a(String str) {
        return (C0319bk) c.get(str);
    }

    public static C0319bk b(int i) {
        C0319bk a = C0319bk.a(i);
        if (a != null) {
            return a;
        }
        throw new IllegalArgumentException("Field " + i + " doesn't exist!");
    }

    public short a() {
        return this.d;
    }

    public String b() {
        return this.e;
    }
}
