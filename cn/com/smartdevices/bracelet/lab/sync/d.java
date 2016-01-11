package cn.com.smartdevices.bracelet.lab.sync;

import android.content.Context;
import android.util.Base64;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.j.n;
import cn.com.smartdevices.bracelet.model.BasicDateData;
import cn.com.smartdevices.bracelet.model.SyncedServerDataInfo;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.huami.android.widget.a;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.gamesdk.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class d {
    private static String a = "WebRes";

    d() {
    }

    public static n a(Context context, int i, String str, ArrayList<BasicDateData> arrayList) {
        n a;
        JSONException e;
        n nVar = new n();
        try {
            JSONObject jSONObject = new JSONObject(str);
            a = n.a(context, jSONObject);
            try {
                if (a.c()) {
                    JSONArray jSONArray;
                    JSONObject jSONObject2 = jSONObject.getJSONObject(b.b);
                    int i2 = jSONObject2.getInt(f.r);
                    if (!jSONObject2.isNull(g.o)) {
                        jSONArray = jSONObject2.getJSONArray(g.o);
                        SyncedServerDataInfo syncedServerDataInfo = new SyncedServerDataInfo(i);
                        if (jSONArray.length() == 2) {
                            syncedServerDataInfo.setState(2);
                            syncedServerDataInfo.setStartDate(jSONArray.getString(0));
                            syncedServerDataInfo.setStopDate(jSONArray.getString(1));
                        } else {
                            syncedServerDataInfo.setState(1);
                        }
                        syncedServerDataInfo.saveInfo();
                    }
                    jSONArray = jSONObject2.getJSONArray(a.c);
                    C0596r.e(a, "List array length = " + jSONArray.length());
                    if (jSONArray.toString().length() != i2) {
                        C0596r.e(a, "size error!");
                    } else {
                        i2 = jSONArray.length();
                        SyncedServerDataInfo syncedServerDataInfo2 = new SyncedServerDataInfo(i);
                        if (i2 > 0) {
                            syncedServerDataInfo2.setState(2);
                            syncedServerDataInfo2.setStartDate(jSONArray.getJSONObject(0).getString(g.a));
                            syncedServerDataInfo2.setStopDate(jSONArray.getJSONObject(i2 - 1).getString(g.a));
                        } else {
                            syncedServerDataInfo2.setState(1);
                        }
                        syncedServerDataInfo2.saveInfo();
                        arrayList.ensureCapacity(i2);
                        for (int i3 = 0; i3 < i2; i3++) {
                            arrayList.add(a(jSONArray.getJSONObject(i3)));
                        }
                    }
                }
            } catch (JSONException e2) {
                e = e2;
                a.h = 2;
                C0596r.f(a, e.getMessage());
                return a;
            }
        } catch (JSONException e3) {
            JSONException jSONException = e3;
            a = nVar;
            e = jSONException;
            a.h = 2;
            C0596r.f(a, e.getMessage());
            return a;
        }
        return a;
    }

    private static BasicDateData a(JSONObject jSONObject) {
        BasicDateData basicDateData = new BasicDateData();
        basicDateData.date = jSONObject.getString(g.a);
        basicDateData.summary = jSONObject.getString(SocialConstants.PARAM_SUMMARY);
        if (!jSONObject.isNull(b.b)) {
            basicDateData.data = Base64.decode(jSONObject.getString(b.b), 2);
        }
        return basicDateData;
    }
}
