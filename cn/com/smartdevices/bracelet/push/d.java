package cn.com.smartdevices.bracelet.push;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.config.b;
import com.xiaomi.hm.health.l;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends a {
    private static final String h = "ConfigMessage";
    private final JSONObject i;

    public d(Context context, long j, long j2, JSONObject jSONObject) {
        super(context, j, j2, jSONObject);
        this.i = jSONObject;
    }

    public int a() {
        return l.notification_care;
    }

    public void b() {
        if (this.i != null) {
            b h = b.h();
            JSONObject b = b.b(this.d);
            try {
                b.a(b, this.i);
                h.a(b);
            } catch (JSONException e) {
                C0596r.a(h, e.toString());
            }
            h.b(b);
        }
    }

    public void c() {
    }
}
