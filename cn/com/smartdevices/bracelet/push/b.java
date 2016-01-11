package cn.com.smartdevices.bracelet.push;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.aT;
import cn.com.smartdevices.bracelet.Constant;
import cn.com.smartdevices.bracelet.partner.NativeInterface;
import cn.com.smartdevices.bracelet.partner.WebActivity;
import cn.com.smartdevices.bracelet.relation.A;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.bt.a.C1115b;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.r;
import org.json.JSONObject;

public class b extends a {
    public static final String h = "url";
    public static final String i = "from_uid";
    public static final String j = "from_username";
    public static final String k = "nick";
    public static final String l = "pic";
    public final Uri m;
    public final long n;
    public final String o;
    public final String p;

    public b(Context context, long j, long j2, JSONObject jSONObject) {
        super(context, j, j2, jSONObject);
        this.m = Uri.parse(jSONObject.optString(h));
        this.n = (long) jSONObject.optInt(i);
        String str = null;
        if (!jSONObject.isNull(k)) {
            str = jSONObject.optString(k);
        }
        String optString = jSONObject.optString(j);
        if (str == null || a.f.equals(str.trim())) {
            this.o = optString;
        } else {
            this.o = str;
        }
        this.p = jSONObject.optString(l);
    }

    public int a() {
        return l.notification_care;
    }

    public void b() {
        A.a().a(this);
    }

    public void c() {
        Intent intent;
        if (!NativeInterface.APP_SCHEME.equals(this.m.getScheme())) {
            intent = new Intent(this.d, WebActivity.class);
        } else if (a(this.m)) {
            intent = new Intent(Constant.bV);
        } else {
            return;
        }
        CharSequence string = this.d.getString(r.message_title_care);
        aT e = new aT(this.d).a((int) k.app_icon).a(string).b(this.d.getString(r.label_friend_care_message, new Object[]{this.o})).e(true);
        e.a(PendingIntent.getBroadcast(this.d, 0, intent, 268435456));
        ((NotificationManager) this.d.getSystemService("notification")).notify(1, e.c());
        new C1115b((byte) 4, new c(this)).f();
    }

    public String toString() {
        return "CareMessage [uri=" + this.m + ", fromUid=" + this.n + ", fromUsername=" + this.o + ", picUrl=" + this.p + "]";
    }
}
