package cn.com.smartdevices.bracelet.ui;

import android.os.SystemClock;
import cn.com.smartdevices.bracelet.C0591m;
import cn.com.smartdevices.bracelet.C0595q;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.j.n;
import com.d.a.a.h;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.mistatistic.sdk.d;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.http.Header;
import org.json.JSONObject;

class C0822w extends h {
    final /* synthetic */ long a;
    final /* synthetic */ BaseSCActivity b;

    C0822w(BaseSCActivity baseSCActivity, long j) {
        this.b = baseSCActivity;
        this.a = j;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        String str = "yyyy-MM-dd HH:mm:ss";
        try {
            JSONObject jSONObject = new JSONObject(Utils.b(bArr));
            if (n.a(this.b.x, jSONObject).c()) {
                jSONObject = jSONObject.getJSONObject(b.b);
                String trim = jSONObject.getString("timedate").trim();
                str = jSONObject.getString(f.j);
                String id = TimeZone.getDefault().getID();
                if (!str.equalsIgnoreCase(id)) {
                    trim = Utils.a(trim, "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss");
                    if (trim == null) {
                        return;
                    }
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                Date parse = simpleDateFormat.parse(trim);
                Date date = new Date();
                C0596r.e("BaseSCActivity", "ntp tz:" + str + ",local tz:" + id);
                C0596r.e("BaseSCActivity", "ntp ts:" + trim + ",local ts:" + simpleDateFormat.format(date));
                long time = parse.getTime() + ((SystemClock.elapsedRealtime() - this.a) / 2);
                if (Math.abs(time - date.getTime()) / d.g > 0) {
                    C0596r.d("BaseSCActivity", "\n=========================ERROR=========================\nserver time:" + parse.toString() + "\n" + "local time :" + date.toString() + "\n" + "=========================ERROR=========================");
                    return;
                }
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(time);
                C0596r.d("BaseSCActivity", "deleteDataAfterDate:" + C0591m.a().a(new SportDay(instance).getKey(), new C0595q()));
            }
        } catch (Exception e) {
        }
    }
}
