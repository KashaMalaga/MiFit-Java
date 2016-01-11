package com.xiaomi.channel.b;

import android.text.TextUtils;
import com.tencent.tauth.AuthActivity;
import com.xiaomi.e.a;
import org.json.JSONException;
import org.json.JSONObject;

public class p {
    public String a = a.f;
    public String b = a.f;
    public int c = 0;

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AuthActivity.ACTION_KEY, this.a);
            jSONObject.put("extraUri", this.b);
            jSONObject.put("availableVersion", this.c);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return a.f;
        }
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.a = jSONObject.optString(AuthActivity.ACTION_KEY);
                this.b = jSONObject.optString("extraUri");
                this.c = jSONObject.optInt("availableVersion");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
