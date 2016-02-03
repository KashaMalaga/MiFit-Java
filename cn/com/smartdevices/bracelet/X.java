package cn.com.smartdevices.bracelet;

import android.content.Context;
import cn.com.smartdevices.bracelet.j.f;
import com.d.a.a.h;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.hm.health.dataprocess.SportDay;
import java.net.URLDecoder;
import kankan.wheel.widget.a;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

final class X extends h {
    final /* synthetic */ Context a;

    X(Context context) {
        this.a = context;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e("Utils", "onFail status: " + i);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONException e;
        String sportDay;
        String str = new String(bArr);
        C0596r.e("Utils", "result = " + str);
        try {
            JSONObject jSONObject3 = new JSONObject(str);
            str = URLDecoder.decode(jSONObject3.getJSONObject(b.b).getString(f.au));
            C0596r.e("Utils", "details Str : " + str);
            jSONObject = new JSONObject(str);
            try {
                int optInt = jSONObject3.optInt(b.a);
                if (optInt != 1) {
                    C0596r.d("Utils", "getLazyDaysFromServer code = " + optInt);
                }
                jSONObject2 = jSONObject;
            } catch (JSONException e2) {
                e = e2;
                C0596r.e("Utils", "error: " + e.toString());
                jSONObject2 = jSONObject;
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                if (jSONObject2.isNull(a.ck)) {
                    sportDay = new SportDay().toString();
                    try {
                        jSONObject2.put(a.ck, sportDay);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    C0596r.e("Utils", "after add lazy date: " + jSONObject2.toString());
                    Keeper.keepLazyDays(jSONObject2.toString());
                    Keeper.keepManualLazyDayAlgoStartDate(sportDay);
                    Utils.t(this.a);
                }
                Keeper.keepManualLazyDayAlgoStartDate(jSONObject2.optString(a.ck));
                Keeper.keepLazyDays(URLDecoder.decode(jSONObject2.toString()));
            }
        } catch (JSONException e4) {
            e = e4;
            jSONObject = null;
            C0596r.e("Utils", "error: " + e.toString());
            jSONObject2 = jSONObject;
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            if (jSONObject2.isNull(a.ck)) {
                sportDay = new SportDay().toString();
                jSONObject2.put(a.ck, sportDay);
                C0596r.e("Utils", "after add lazy date: " + jSONObject2.toString());
                Keeper.keepLazyDays(jSONObject2.toString());
                Keeper.keepManualLazyDayAlgoStartDate(sportDay);
                Utils.t(this.a);
            }
            Keeper.keepManualLazyDayAlgoStartDate(jSONObject2.optString(a.ck));
            Keeper.keepLazyDays(URLDecoder.decode(jSONObject2.toString()));
        }
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        if (jSONObject2.isNull(a.ck)) {
            sportDay = new SportDay().toString();
            jSONObject2.put(a.ck, sportDay);
            C0596r.e("Utils", "after add lazy date: " + jSONObject2.toString());
            Keeper.keepLazyDays(jSONObject2.toString());
            Keeper.keepManualLazyDayAlgoStartDate(sportDay);
            Utils.t(this.a);
        }
        Keeper.keepManualLazyDayAlgoStartDate(jSONObject2.optString(a.ck));
        Keeper.keepLazyDays(URLDecoder.decode(jSONObject2.toString()));
    }
}
