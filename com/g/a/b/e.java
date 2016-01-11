package com.g.a.b;

import b.a.C0345ch;
import b.a.bX;
import com.g.a.p;
import com.xiaomi.account.openauth.h;
import java.util.Locale;
import org.json.JSONObject;

public class e extends C0345ch {
    public JSONObject a = null;
    boolean b = false;
    int c = -1;
    int d = -1;
    String e;
    private final String f = "config_update";
    private final String g = "report_policy";
    private final String h = "online_params";
    private final String i = "last_config_time";
    private final String j = "report_interval";

    public e(JSONObject jSONObject) {
        super(jSONObject);
        if (jSONObject != null) {
            a(jSONObject);
            a();
        }
    }

    private void a() {
        if (this.c < 0 || this.c > 6) {
            this.c = 1;
        }
    }

    private void a(JSONObject jSONObject) {
        try {
            if (jSONObject.has("config_update") && !jSONObject.getString("config_update").toLowerCase(Locale.US).equals("no")) {
                if (jSONObject.has("report_policy")) {
                    this.c = jSONObject.getInt("report_policy");
                    this.d = jSONObject.optInt("report_interval") * h.E;
                    this.e = jSONObject.optString("last_config_time");
                } else {
                    bX.e(p.e, " online config fetch no report policy");
                }
                this.a = jSONObject.optJSONObject("online_params");
                this.b = true;
            }
        } catch (Exception e) {
            bX.e(p.e, "fail to parce online config response", e);
        }
    }
}
