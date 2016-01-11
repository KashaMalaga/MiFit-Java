package com.huami.android.widget.share;

import cn.com.smartdevices.bracelet.C0596r;
import com.d.a.a.h;
import com.xiaomi.channel.gamesdk.b;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

class a extends h {
    final /* synthetic */ ShareDataManager a;

    a(ShareDataManager shareDataManager) {
        this.a = shareDataManager;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e("ShareDataManager", "getAllSharedTimes error");
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        String str = new String(bArr);
        C0596r.e("ShareDataManager", "getAllSharedTimes:" + str);
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject(b.b);
            int i2 = 0;
            if (!jSONObject.isNull("times")) {
                i2 = ((Integer) jSONObject.get("times")).intValue();
            }
            this.a.e.edit().putInt("total_share_cache", i2).commit();
            this.a.g = true;
        } catch (JSONException e) {
            e.printStackTrace();
            C0596r.a("ShareDataManager", "Get share data error from cloud");
        }
    }
}
