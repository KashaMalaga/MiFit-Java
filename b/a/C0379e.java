package b.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class C0379e extends T implements dF {
    public C0379e(String str, Map<String, Object> map) {
        a(str);
        b(System.currentTimeMillis());
        if (map.size() > 0) {
            a(b(map));
        }
        a(this.d > 0 ? this.d : 1);
    }

    private HashMap<String, C0311bc> b(Map<String, Object> map) {
        Iterator it = map.entrySet().iterator();
        HashMap<String, C0311bc> hashMap = new HashMap();
        int i = 0;
        while (i < 10 && it.hasNext()) {
            Entry entry = (Entry) it.next();
            C0311bc c0311bc = new C0311bc();
            Object value = entry.getValue();
            if (value instanceof String) {
                c0311bc.b((String) value);
            } else if (value instanceof Long) {
                c0311bc.b(((Long) value).longValue());
            } else if (value instanceof Integer) {
                c0311bc.b(((Integer) value).longValue());
            } else if (value instanceof Float) {
                c0311bc.b(((Float) value).longValue());
            } else if (value instanceof Double) {
                c0311bc.b(((Double) value).longValue());
            }
            if (c0311bc.l()) {
                hashMap.put((String) entry.getKey(), c0311bc);
                i++;
            }
        }
        return hashMap;
    }

    public void a(bE bEVar, String str) {
        if (bEVar.s() > 0) {
            for (aE aEVar : bEVar.u()) {
                if (str.equals(aEVar.c())) {
                    break;
                }
            }
        }
        aE aEVar2 = null;
        if (aEVar2 == null) {
            aEVar2 = new aE();
            aEVar2.a(str);
            bEVar.a(aEVar2);
        }
        aEVar2.b((T) this);
    }
}
