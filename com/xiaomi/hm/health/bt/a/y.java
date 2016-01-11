package com.xiaomi.hm.health.bt.a;

import com.xiaomi.hm.health.bt.model.f;
import com.xiaomi.hm.health.bt.model.h;
import com.xiaomi.hm.health.bt.model.s;
import org.json.JSONObject;

public class y extends C {
    public y(d dVar) {
        super(dVar);
    }

    public void a(d dVar) {
        if (dVar != null) {
            dVar.c();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.q != null) {
                s J = this.q.J();
                if (J != null) {
                    jSONObject.put("usage", J.toString());
                }
                f L = this.q.L();
                if (L != null) {
                    jSONObject.put("battery_info", L.toString());
                }
                h j_ = this.q.j_();
                if (j_ != null) {
                    jSONObject.put("device_info", j_.toString());
                }
            }
        } catch (Exception e) {
        }
        if (dVar != null) {
            String jSONObject2 = jSONObject.toString();
            if (jSONObject2 == null || !(jSONObject2.contains("usage") || jSONObject2.contains("battery_info"))) {
                dVar.c(null);
            } else {
                dVar.c(jSONObject2);
            }
        }
    }
}
