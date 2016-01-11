package com.huami.android.widget.share;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.d.a.a;
import cn.com.smartdevices.bracelet.d.a.c;
import com.huami.android.widget.share.ShareDataManager.SharedData;
import java.util.List;

class f extends a<SharedData> {
    public f(c cVar) {
        super(cVar);
    }

    public boolean a(long j) {
        return b(new StringBuilder().append("shared_id=").append(j).toString(), null) >= 0;
    }

    public List<SharedData> d() {
        try {
            return a(null, null, null, null, "shared_id asc", null);
        } catch (Throwable e) {
            C0596r.a("ShareDataManager", "Get shared queue", e);
            return null;
        }
    }
}
