package cn.com.smartdevices.bracelet;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.d.C0425b;
import cn.com.smartdevices.bracelet.d.C0432i;
import cn.com.smartdevices.bracelet.f.c;
import cn.com.smartdevices.bracelet.g.d;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.d.a.a.p;
import com.xiaomi.channel.gamesdk.b;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

final class R extends p<Double> {
    final /* synthetic */ d a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ Context e;

    R(d dVar, String str, int i, int i2, Context context) {
        this.a = dVar;
        this.b = str;
        this.c = i;
        this.d = i2;
        this.e = context;
    }

    protected Double a(String str, boolean z) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.optInt(b.a) != 1) {
            return null;
        }
        jSONObject = jSONObject.optJSONObject(b.b);
        return jSONObject != null ? Double.valueOf(jSONObject.optDouble("beat_percentage") * 100.0d) : null;
    }

    public void a(int i, Header[] headerArr, String str, Double d) {
        C0596r.e("Utils", "get ranking response : " + d);
        if (d != null) {
            this.a.a(d.doubleValue());
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.b)) {
                try {
                    jSONObject.put(g.a, this.b);
                    jSONObject.put(f.aw, this.c);
                    jSONObject.put(f.ax, this.d);
                    jSONObject.put(C0432i.b, d.doubleValue());
                    C0425b.a(this.e.getApplicationContext()).a(cn.com.smartdevices.bracelet.f.b.a, jSONObject.toString(), c.SHORT);
                } catch (JSONException e) {
                }
            }
        }
    }

    public void a(int i, Header[] headerArr, Throwable th, String str, Double d) {
        this.a.a(-1.0d);
    }

    public /* synthetic */ void onFailure(int i, Header[] headerArr, Throwable th, String str, Object obj) {
        a(i, headerArr, th, str, (Double) obj);
    }

    public /* synthetic */ void onSuccess(int i, Header[] headerArr, String str, Object obj) {
        a(i, headerArr, str, (Double) obj);
    }

    protected /* synthetic */ Object parseResponse(String str, boolean z) {
        return a(str, z);
    }
}
