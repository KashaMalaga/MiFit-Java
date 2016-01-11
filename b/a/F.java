package b.a;

import cn.com.smartdevices.bracelet.shoes.ui.ShoesBindActivity;
import com.g.a.b.b;
import com.xiaomi.hm.health.t;
import com.xiaomi.market.sdk.o;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum F implements cz {
    DEVICE_ID((short) 1, a.ak),
    IDMD5((short) 2, b.d),
    MAC_ADDRESS((short) 3, ShoesBindActivity.c),
    OPEN_UDID((short) 4, "open_udid"),
    MODEL((short) 5, "model"),
    CPU((short) 6, "cpu"),
    OS((short) 7, o.j),
    OS_VERSION((short) 8, "os_version"),
    RESOLUTION((short) 9, o.p),
    IS_JAILBROKEN((short) 10, "is_jailbroken"),
    IS_PIRATED((short) 11, "is_pirated"),
    DEVICE_BOARD((short) 12, "device_board"),
    DEVICE_BRAND((short) 13, "device_brand"),
    DEVICE_MANUTIME((short) 14, "device_manutime"),
    DEVICE_MANUFACTURER((short) 15, "device_manufacturer"),
    DEVICE_MANUID((short) 16, "device_manuid"),
    DEVICE_NAME((short) 17, "device_name");
    
    private static final Map<String, F> r = null;
    private final short s;
    private final String t;

    static {
        r = new HashMap();
        Iterator it = EnumSet.allOf(F.class).iterator();
        while (it.hasNext()) {
            F f = (F) it.next();
            r.put(f.b(), f);
        }
    }

    private F(short s, String str) {
        this.s = s;
        this.t = str;
    }

    public static F a(int i) {
        switch (i) {
            case l.a /*1*/:
                return DEVICE_ID;
            case a.k /*2*/:
                return IDMD5;
            case a.l /*3*/:
                return MAC_ADDRESS;
            case a.aQ /*4*/:
                return OPEN_UDID;
            case a.X /*5*/:
                return MODEL;
            case a.bt /*6*/:
                return CPU;
            case a.bc /*7*/:
                return OS;
            case a.ba /*8*/:
                return OS_VERSION;
            case a.bo /*9*/:
                return RESOLUTION;
            case a.bd /*10*/:
                return IS_JAILBROKEN;
            case a.aW /*11*/:
                return IS_PIRATED;
            case a.be /*12*/:
                return DEVICE_BOARD;
            case t.WeightView_wv_bmi_size /*13*/:
                return DEVICE_BRAND;
            case t.WeightView_wv_tips /*14*/:
                return DEVICE_MANUTIME;
            case a.aV /*15*/:
                return DEVICE_MANUFACTURER;
            case a.bp /*16*/:
                return DEVICE_MANUID;
            case a.bu /*17*/:
                return DEVICE_NAME;
            default:
                return null;
        }
    }

    public static F a(String str) {
        return (F) r.get(str);
    }

    public static F b(int i) {
        F a = a(i);
        if (a != null) {
            return a;
        }
        throw new IllegalArgumentException("Field " + i + " doesn't exist!");
    }

    public short a() {
        return this.s;
    }

    public String b() {
        return this.t;
    }
}
