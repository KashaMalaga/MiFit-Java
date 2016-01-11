package b.a;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum bD implements cz {
    UPLOAD_TRAFFIC((short) 1, "upload_traffic"),
    DOWNLOAD_TRAFFIC((short) 2, "download_traffic");
    
    private static final Map<String, bD> c = null;
    private final short d;
    private final String e;

    static {
        c = new HashMap();
        Iterator it = EnumSet.allOf(bD.class).iterator();
        while (it.hasNext()) {
            bD bDVar = (bD) it.next();
            c.put(bDVar.b(), bDVar);
        }
    }

    private bD(short s, String str) {
        this.d = s;
        this.e = str;
    }

    public static bD a(int i) {
        switch (i) {
            case l.a /*1*/:
                return UPLOAD_TRAFFIC;
            case a.k /*2*/:
                return DOWNLOAD_TRAFFIC;
            default:
                return null;
        }
    }

    public static bD a(String str) {
        return (bD) c.get(str);
    }

    public static bD b(int i) {
        bD a = a(i);
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
