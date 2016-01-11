package b.a;

import android.content.Context;
import android.support.v4.view.a.C0113o;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.g.a.C1059a;
import com.g.a.p;
import com.xiaomi.e.a;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class dD {
    private final int a = C0113o.h;
    private final int b = PersonInfo.INCOMING_CALL_DISABLE_BIT;
    private C0363dB c;
    private Context d;
    private dx e;

    public dD(Context context) {
        if (context == null) {
            throw new RuntimeException("Context is null, can't track event");
        }
        this.d = context.getApplicationContext();
        this.c = new C0363dB(this.d);
        this.c.a(!C1059a.l);
        this.e = dx.a(this.d);
    }

    private boolean a(String str) {
        if (str != null) {
            int length = str.trim().getBytes().length;
            if (length > 0 && length <= C0113o.h) {
                return true;
            }
        }
        bX.b(p.e, "Event id is empty or too long in tracking Event");
        return false;
    }

    private boolean a(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            bX.b(p.e, "map is null or empty in onEvent");
            return false;
        }
        for (Entry entry : map.entrySet()) {
            if (!a((String) entry.getKey())) {
                return false;
            }
            if (entry.getValue() == null) {
                return false;
            }
            if ((entry.getValue() instanceof String) && !b(entry.getValue().toString())) {
                return false;
            }
        }
        return true;
    }

    private boolean b(String str) {
        if (str == null || str.trim().getBytes().length <= PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            return true;
        }
        bX.b(p.e, "Event label or value is empty or too long in tracking Event");
        return false;
    }

    public void a(String str, String str2) {
        if (a(str) && b(str2)) {
            this.c.a(C0335c.b(str, str2, null), C0335c.a(str, str2, null));
        }
    }

    public void a(String str, String str2, long j, int i) {
        if (a(str) && b(str2)) {
            Object obj;
            Map hashMap = new HashMap();
            if (str2 == null) {
                obj = a.f;
            }
            hashMap.put(str, obj);
            this.e.a(new C0335c(str, hashMap, j, i));
        }
    }

    public void a(String str, Map<String, Object> map) {
        try {
            if (a(str)) {
                this.e.a(new C0379e(str, map));
            }
        } catch (Exception e) {
            bX.b(p.e, "Exception occurred in Mobclick.onEvent(). ", e);
        }
    }

    public void a(String str, Map<String, Object> map, long j) {
        try {
            if (a(str) && a((Map) map)) {
                this.e.a(new C0335c(str, map, j, -1));
            }
        } catch (Exception e) {
            bX.b(p.e, "Exception occurred in Mobclick.onEvent(). ", e);
        }
    }

    public void a(String str, Map<String, Object> map, String str2) {
        if (a(str) && a((Map) map)) {
            this.c.a(C0335c.b(str, str2, map), C0335c.a(str, str2, map));
        }
    }

    public void b(String str, String str2) {
        if (a(str) && b(str2)) {
            C0308b b = this.c.b(C0335c.b(str, str2, null));
            if (b != null) {
                a(str, str2, (long) ((int) (System.currentTimeMillis() - b.a)), 0);
            }
        }
    }

    public void c(String str, String str2) {
        if (a(str)) {
            C0308b b = this.c.b(C0335c.b(str, str2, null));
            if (b != null) {
                a(str, b.d, (long) ((int) (System.currentTimeMillis() - b.a)));
            }
        }
    }
}
