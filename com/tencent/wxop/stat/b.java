package com.tencent.wxop.stat;

import cn.com.smartdevices.bracelet.gps.services.aa;
import cn.com.smartdevices.bracelet.gps.services.ay;
import cn.com.smartdevices.bracelet.lab.sportmode.SportBaseInfo;
import com.xiaomi.e.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    private long K = 0;
    private int L = 0;
    private String M = a.f;
    private String c = a.f;
    private int g = 0;

    public final void a(long j) {
        this.K = j;
    }

    public final JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tm", this.K);
            jSONObject.put(SportBaseInfo.KEY_START_TIME, this.g);
            if (this.c != null) {
                jSONObject.put("dm", this.c);
            }
            jSONObject.put(aa.j, this.L);
            if (this.M != null) {
                jSONObject.put("rip", this.M);
            }
            jSONObject.put(ay.H, System.currentTimeMillis() / 1000);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public final void k(String str) {
        this.M = str;
    }

    public final void setDomain(String str) {
        this.c = str;
    }

    public final void setPort(int i) {
        this.L = i;
    }

    public final void setStatusCode(int i) {
        this.g = i;
    }
}
