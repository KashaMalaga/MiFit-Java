package com.xiaomi.hm.health.bt.a;

import com.xiaomi.hm.health.bt.model.UserInfo;
import com.xiaomi.hm.health.bt.profile.a.j;

public class w extends C {
    private UserInfo a = null;

    public w(UserInfo userInfo, d dVar) {
        super(dVar);
        this.a = userInfo;
    }

    public w(j jVar, UserInfo userInfo, d dVar) {
        super(jVar, dVar);
        this.a = userInfo;
    }

    public void a(d dVar) {
        if (dVar != null) {
            dVar.c();
        }
        boolean b = this.q.b(this.a);
        if (dVar != null) {
            dVar.c(Boolean.valueOf(b));
        }
    }
}
