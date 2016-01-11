package com.tencent.wxop.stat.b;

import cn.com.smartdevices.bracelet.gps.services.ay;
import com.sina.weibo.sdk.constant.WBConstants;
import com.tencent.connect.common.Constants;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    private String W = Constants.VIA_RESULT_SUCCESS;
    private String a = null;
    private String b = null;
    private int bf = 0;
    private String c = null;
    private int cu;
    private long cv = 0;

    public c(String str, String str2, int i) {
        this.a = str;
        this.b = str2;
        this.cu = i;
    }

    private JSONObject aq() {
        JSONObject jSONObject = new JSONObject();
        try {
            r.a(jSONObject, "ui", this.a);
            r.a(jSONObject, "mc", this.b);
            r.a(jSONObject, "mid", this.W);
            r.a(jSONObject, WBConstants.AUTH_PARAMS_AID, this.c);
            jSONObject.put(ay.H, this.cv);
            jSONObject.put("ver", this.bf);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public final String ar() {
        return this.b;
    }

    public final int as() {
        return this.cu;
    }

    public final String b() {
        return this.a;
    }

    public final String toString() {
        return aq().toString();
    }

    public final void z() {
        this.cu = 1;
    }
}
