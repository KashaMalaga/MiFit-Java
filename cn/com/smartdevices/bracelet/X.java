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
        JSONException e;
        String sportDay;
        String str = new String(bArr);
        C0596r.e("Utils", "result = " + str);
        JSONObject jSONObject2;
        try {
            JSONObject jSONObject3 = new JSONObject(str);
            str = URLDecoder.decode(jSONObject3.getJSONObject(b.b).getString(f.au));
            C0596r.e("Utils", "details Str : " + str);
            jSONObject2 = new JSONObject(str);
            try {
                int optInt = jSONObject3.optInt(b.a);
                if (optInt != 1) {
                    C0596r.d("Utils", "getLazyDaysFromServer code = " + optInt);
                }
                jSONObject = jSONObject2;
            } catch (JSONException e2) {
                e = e2;
                C0596r.e("Utils", "error: " + e.toString());
                jSONObject = jSONObject2;
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                if (jSONObject.isNull(a.ck)) {
                    sportDay = new SportDay().toString();
                    try {
                        jSONObject.put(a.ck, sportDay);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    C0596r.e("Utils", "after add lazy date: " + jSONObject.toString());
                    Keeper.keepLazyDays(jSONObject.toString());
                    Keeper.keepManualLazyDayAlgoStartDate(sportDay);
                    Utils.t(this.a);
                }
                Keeper.keepManualLazyDayAlgoStartDate(jSONObject.optString(a.ck));
                Keeper.keepLazyDays(URLDecoder.decode(jSONObject.toString()));
            }
        } catch (JSONException e4) {
            e = e4;
            jSONObject2 = null;
            C0596r.e("Utils", "error: " + e.toString());
            jSONObject = jSONObject2;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (jSONObject.isNull(a.ck)) {
                sportDay = new SportDay().toString();
                jSONObject.put(a.ck, sportDay);
                C0596r.e("Utils", "after add lazy date: " + jSONObject.toString());
                Keeper.keepLazyDays(jSONObject.toString());
                Keeper.keepManualLazyDayAlgoStartDate(sportDay);
                Utils.t(this.a);
            }
            Keeper.keepManualLazyDayAlgoStartDate(jSONObject.optString(a.ck));
            Keeper.keepLazyDays(URLDecoder.decode(jSONObject.toString()));
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (jSONObject.isNull(a.ck)) {
            sportDay = new SportDay().toString();
            jSONObject.put(a.ck, sportDay);
            C0596r.e("Utils", "after add lazy date: " + jSONObject.toString());
            Keeper.keepLazyDays(jSONObject.toString());
            Keeper.keepManualLazyDayAlgoStartDate(sportDay);
            Utils.t(this.a);
        }
        Keeper.keepManualLazyDayAlgoStartDate(jSONObject.optString(a.ck));
        Keeper.keepLazyDays(URLDecoder.decode(jSONObject.toString()));
    }
}
