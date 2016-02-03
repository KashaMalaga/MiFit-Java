package cn.com.smartdevices.bracelet.push;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.aT;
import cn.com.smartdevices.bracelet.Constant;
import cn.com.smartdevices.bracelet.partner.NativeInterface;
import cn.com.smartdevices.bracelet.partner.Partner;
import cn.com.smartdevices.bracelet.shoes.data.db.j;
import com.xiaomi.hm.health.R;
import java.io.Serializable;
import org.json.JSONObject;

public class g extends a {
    public static final String h = "url";
    public static final String i = "title";
    public static final String j = "description";
    public final Uri k;
    public final String l;
    public final String m;

    public g(Context context, long j, long j2, JSONObject jSONObject) {
        super(context, j, j2, jSONObject);
        this.k = Uri.parse(jSONObject.optString(h));
        this.l = jSONObject.optString(i);
        this.m = jSONObject.optString(j);
    }

    public int a() {
        return R.id.notification_jump;
    }

    public void b() {
    }

    public void c() {
        Intent intent;
        if (!NativeInterface.APP_SCHEME.equals(this.k.getScheme())) {
            intent = new Intent(Constant.bX);
            Serializable partner = new Partner();
            partner.url = this.k.toString();
            partner.title = this.l;
            partner.shareContent = this.m;
            Bundle bundle = new Bundle();
            bundle.putSerializable("partner", partner);
            intent.putExtras(bundle);
        } else if (a(this.k)) {
            intent = new Intent(Constant.bW);
            intent.putExtra(j.e, this.k.toString());
        } else {
            return;
        }
        aT e = new aT(this.d).a((int) R.drawable.app_icon).a(this.l).b(this.m).e(true);
        e.a(PendingIntent.getBroadcast(this.d, 0, intent, 268435456));
        ((NotificationManager) this.d.getSystemService("notification")).notify(1, e.c());
    }
}
