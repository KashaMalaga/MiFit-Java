package cn.com.smartdevices.bracelet.push;

import android.content.Context;
import android.net.Uri;
import cn.com.smartdevices.bracelet.relation.A;
import com.xiaomi.hm.health.R;
import org.json.JSONObject;

public class j extends a {
    public static final String h = "url";
    public static final String i = "from_uid";
    public static final String j = "from_username";
    public final Uri k;
    public final long l;
    public final String m;

    public j(Context context, long j, long j2, JSONObject jSONObject) {
        super(context, j, j2, jSONObject);
        this.k = Uri.parse(jSONObject.optString(h));
        this.l = jSONObject.optLong(i);
        this.m = jSONObject.optString(j);
    }

    public int a() {
        return R.id.notification_care;
    }

    public void b() {
        A.a().a(this);
    }

    public void c() {
    }
}
