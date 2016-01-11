package cn.com.smartdevices.bracelet.relation.db;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.d.a.a;
import cn.com.smartdevices.bracelet.d.a.c;
import cn.com.smartdevices.bracelet.d.a.d;
import java.sql.SQLDataException;
import java.util.List;

public class b extends a<a> {
    private static final String b = "DetailDao";

    public b(c cVar) {
        super(cVar);
    }

    public List<a> a(long j, int i) {
        List<a> list = null;
        try {
            list = a(0, (long) i, "user_id = " + j, null, "create_time desc ");
        } catch (SQLDataException e) {
            C0596r.a(b, e.getMessage());
        }
        return list;
    }

    public void a(a aVar) {
        if (aVar != null && a((d) aVar, "user_id = " + aVar.k + " and " + a.f + " = " + aVar.o, null) == 0) {
            a((d) aVar);
        }
    }
}
