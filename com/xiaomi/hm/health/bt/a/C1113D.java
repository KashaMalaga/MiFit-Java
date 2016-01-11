package com.xiaomi.hm.health.bt.a;

import android.util.Pair;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.d.a;
import com.xiaomi.hm.health.bt.model.UserInfo;
import com.xiaomi.hm.health.bt.model.h;
import java.util.Calendar;

public class C1113D extends C {
    private UserInfo a = null;
    private a b = null;

    public C1113D(UserInfo userInfo, a aVar, d dVar) {
        super(dVar);
        this.a = userInfo;
        this.b = aVar;
    }

    public void a(d dVar) {
        if (dVar != null) {
            dVar.c();
        }
        C0596r.e(p, "user info:\n" + this.a);
        if (this.q.a(this.a, this.b)) {
            if (this.q.a(Calendar.getInstance())) {
                Pair I = this.q.I();
                if (I != null) {
                    C0596r.d(p, "new time:" + ((Calendar) I.first).getTime().toString() + ",old time:" + ((Calendar) I.second).getTime().toString());
                    if (((Calendar) I.second).getTime().toString().contains("1970")) {
                        C0401a.c(C0401a.eo);
                    }
                } else {
                    C0596r.d(p, "can not get bracelet time after _setDateTime");
                }
                C0596r.d(p, "battery info : " + this.q.L());
                h j_ = this.q.j_();
                C0596r.d(p, "device info : " + j_);
                C0596r.d(p, "reboot count : " + this.q.O());
                C0596r.d(p, "heartrate config : " + this.q.W());
                if (j_ != null) {
                    this.q.a(true);
                    this.q.b(3);
                }
                if (dVar != null) {
                    dVar.c(j_);
                }
            } else if (dVar != null) {
                dVar.c(null);
            }
        } else if (dVar != null) {
            dVar.c(null);
        }
    }
}
