package cn.com.smartdevices.bracelet.weight.a;

import cn.com.smartdevices.bracelet.gps.services.ay;
import cn.com.smartdevices.bracelet.i.a.d;
import cn.com.smartdevices.bracelet.weight.WeightInfo;
import com.huami.android.widget.a;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.xiaomi.channel.gamesdk.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class j extends d<String, List<WeightInfo>> {
    private j() {
    }

    public List<WeightInfo> a(String str) {
        List<WeightInfo> arrayList;
        Throwable e;
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject(b.b);
            arrayList = new ArrayList(jSONObject.getInt("total"));
            try {
                JSONArray jSONArray = jSONObject.getJSONArray(a.c);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    WeightInfo weightInfo = new WeightInfo();
                    weightInfo.uid = jSONObject2.getInt(WidgetRequestParam.REQ_PARAM_ATTENTION_FUID);
                    weightInfo.weight = Float.valueOf(jSONObject2.getString("wt")).floatValue();
                    weightInfo.timestamp = jSONObject2.getLong(ay.H) * 1000;
                    arrayList.add(weightInfo);
                }
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
                exception(new cn.com.smartdevices.bracelet.i.a(6, e));
                return arrayList;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            arrayList = null;
            e = th;
            e.printStackTrace();
            exception(new cn.com.smartdevices.bracelet.i.a(6, e));
            return arrayList;
        }
        return arrayList;
    }
}
