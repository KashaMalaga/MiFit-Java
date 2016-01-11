package com.tencent.a.a.a.a;

import android.util.Log;
import cn.com.smartdevices.bracelet.gps.services.ay;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;

public final class c {
    String a = null;
    String b = null;
    String c = Constants.VIA_RESULT_SUCCESS;
    long d = 0;

    static c c(String str) {
        c cVar = new c();
        if (h.d(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("ui")) {
                    cVar.a = jSONObject.getString("ui");
                }
                if (!jSONObject.isNull("mc")) {
                    cVar.b = jSONObject.getString("mc");
                }
                if (!jSONObject.isNull("mid")) {
                    cVar.c = jSONObject.getString("mid");
                }
                if (!jSONObject.isNull(ay.H)) {
                    cVar.d = jSONObject.getLong(ay.H);
                }
            } catch (Throwable e) {
                Log.w("MID", e);
            }
        }
        return cVar;
    }

    private JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            h.a(jSONObject, "ui", this.a);
            h.a(jSONObject, "mc", this.b);
            h.a(jSONObject, "mid", this.c);
            jSONObject.put(ay.H, this.d);
        } catch (Throwable e) {
            Log.w("MID", e);
        }
        return jSONObject;
    }

    public final String c() {
        return this.c;
    }

    public final String toString() {
        return d().toString();
    }
}
