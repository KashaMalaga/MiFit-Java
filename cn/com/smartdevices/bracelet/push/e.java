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
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.r;
import org.json.JSONObject;

public class e extends a {
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public static final String k = "url";
    public static final String l = "from_uid";
    public static final String m = "from_username";
    public static final String n = "request_type";
    public static final String o = "data";
    public static final String p = "pic";
    public final Uri q;
    public final long r;
    public final String s;
    public final String t;
    public final String u;
    public final int v;

    public e(Context context, long j, long j2, JSONObject jSONObject) {
        super(context, j, j2, jSONObject);
        this.q = Uri.parse(jSONObject.optString(k));
        this.u = jSONObject.optString(p);
        this.r = (long) jSONObject.optInt(l);
        this.s = jSONObject.optString(m);
        this.v = jSONObject.optInt(n);
        this.t = jSONObject.optString(o);
    }

    public int a() {
        return l.notification_care;
    }

    public void b() {
        if (this.v == i) {
            A.a().a(this);
        } else if (this.v == 0) {
            A.a().b(this);
        } else if (this.v == j) {
            A.a().c(this);
        }
    }

    public void c() {
        Intent intent;
        CharSequence string;
        if (!NativeInterface.APP_SCHEME.equals(this.q.getScheme())) {
            intent = new Intent(this.d, WebActivity.class);
        } else if (a(this.q)) {
            intent = new Intent(Constant.bV);
        } else {
            return;
        }
        CharSequence string2 = this.d.getString(r.message_title_friend);
        Context context;
        Object[] objArr;
        if (this.v == i) {
            context = this.d;
            objArr = new Object[i];
            objArr[h] = this.s;
            string = context.getString(r.label_friend_add_message, objArr);
        } else if (this.v == 0) {
            context = this.d;
            objArr = new Object[i];
            objArr[h] = this.s;
            string = context.getString(r.label_friend_accept_message, objArr);
        } else {
            context = this.d;
            objArr = new Object[i];
            objArr[h] = this.s;
            string = context.getString(r.label_friend_refuse_message, objArr);
        }
        aT e = new aT(this.d).a((int) k.app_icon).a(string2).b(string).e(true);
        e.a(PendingIntent.getBroadcast(this.d, h, intent, 268435456));
        ((NotificationManager) this.d.getSystemService("notification")).notify(i, e.c());
    }
}
