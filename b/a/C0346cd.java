package b.a;

import com.amap.api.location.LocationManagerProxy;
import org.json.JSONObject;

public class C0346cd extends C0345ch {
    public C0347ce a;

    public C0346cd(JSONObject jSONObject) {
        super(jSONObject);
        if ("ok".equalsIgnoreCase(jSONObject.optString(LocationManagerProxy.KEY_STATUS_CHANGED)) || "ok".equalsIgnoreCase(jSONObject.optString("success"))) {
            this.a = C0347ce.SUCCESS;
        } else {
            this.a = C0347ce.FAIL;
        }
    }
}
