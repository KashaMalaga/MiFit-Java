package cn.com.smartdevices.bracelet.weight.a;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.gps.services.ay;
import cn.com.smartdevices.bracelet.i.a.i;
import cn.com.smartdevices.bracelet.weight.WeightInfo;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.xiaomi.e.a;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class q extends i<List<WeightInfo>, String> {
    public String a(List<WeightInfo> list) {
        String str = a.f;
        try {
            JSONArray jSONArray = new JSONArray();
            for (WeightInfo weightInfo : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(WidgetRequestParam.REQ_PARAM_ATTENTION_FUID, weightInfo.uid);
                jSONObject.put("wt", Float.valueOf(weightInfo.weight));
                jSONObject.put(ay.H, weightInfo.timestamp / 1000);
                if (!TextUtils.isEmpty(weightInfo.deviceid)) {
                    jSONObject.put("did", weightInfo.deviceid);
                }
                jSONObject.put("wdt", weightInfo.type);
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return str;
        }
    }

    public /* synthetic */ Object wrap(Object obj) {
        return a((List) obj);
    }
}
