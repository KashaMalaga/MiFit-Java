package cn.com.smartdevices.bracelet.gps.sync;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.t;
import cn.com.smartdevices.bracelet.gps.model.l;
import org.json.JSONObject;

class T {
    private static final String c = "userid";
    public l a;
    public int b;

    public T() {
        this.a = null;
        this.b = -1;
        this.a = new l();
    }

    public boolean a(JSONObject jSONObject) {
        try {
            if (!jSONObject.isNull(c)) {
                this.b = jSONObject.getInt(c);
            }
            this.a.e = t.STATE_SYNCED_FROM_SERVER.a();
            return this.a.a(jSONObject.toString());
        } catch (Exception e) {
            C0596r.a("Sync", e.getMessage());
            return false;
        }
    }
}
