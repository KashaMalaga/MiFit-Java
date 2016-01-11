package cn.com.smartdevices.bracelet.push.a;

import cn.com.smartdevices.bracelet.d.a.a;
import cn.com.smartdevices.bracelet.d.a.c;
import cn.com.smartdevices.bracelet.d.a.d;
import java.sql.SQLDataException;
import java.util.List;

public class b extends a<a> {
    public b(c cVar) {
        super(cVar);
    }

    public boolean a(long j) {
        a aVar;
        try {
            List a = a("msg_id= ?", new String[]{j + com.xiaomi.e.a.f}, null, null, null, null);
            if (!(a == null || a.isEmpty())) {
                aVar = (a) a.get(0);
                return aVar == null;
            }
        } catch (SQLDataException e) {
            e.printStackTrace();
        }
        aVar = null;
        if (aVar == null) {
        }
    }

    public void b(long j) {
        d aVar = new a();
        aVar.c = j;
        a(aVar);
    }
}
