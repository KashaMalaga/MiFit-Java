package b.a;

import com.tencent.open.SocialConstants;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum C0325bq implements cz {
    RESP_CODE((short) 1, "resp_code"),
    MSG((short) 2, SocialConstants.PARAM_SEND_MSG),
    IMPRINT((short) 3, "imprint");
    
    private static final Map<String, C0325bq> d = null;
    private final short e;
    private final String f;

    static {
        d = new HashMap();
        Iterator it = EnumSet.allOf(C0325bq.class).iterator();
        while (it.hasNext()) {
            C0325bq c0325bq = (C0325bq) it.next();
            d.put(c0325bq.b(), c0325bq);
        }
    }

    private C0325bq(short s, String str) {
        this.e = s;
        this.f = str;
    }

    public static C0325bq a(int i) {
        switch (i) {
            case l.a /*1*/:
                return RESP_CODE;
            case a.k /*2*/:
                return MSG;
            case a.l /*3*/:
                return IMPRINT;
            default:
                return null;
        }
    }

    public static C0325bq a(String str) {
        return (C0325bq) d.get(str);
    }

    public static C0325bq b(int i) {
        C0325bq a = C0325bq.a(i);
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
