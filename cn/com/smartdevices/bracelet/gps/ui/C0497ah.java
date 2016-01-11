package cn.com.smartdevices.bracelet.gps.ui;

import cn.com.smartdevices.bracelet.gps.model.m;
import cn.com.smartdevices.bracelet.gps.services.aa;
import java.util.ArrayList;
import java.util.List;

class C0497ah {
    m a = null;
    List<aa> b = null;

    public C0497ah(m mVar) {
        this.a = mVar;
        this.b = new ArrayList();
    }

    public m a() {
        return this.a;
    }

    public void a(m mVar) {
        this.a = mVar;
    }

    public void a(aa aaVar) {
        if (aaVar != null) {
            this.b.add(aaVar);
        }
    }

    public void a(List<aa> list) {
        if (list != null && list.size() > 0) {
            this.b.addAll(list);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C0497ah) || this.a == null) {
            return false;
        }
        return this.a.equals(((C0497ah) obj).a);
    }
}
