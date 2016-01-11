package cn.com.smartdevices.bracelet.weibo;

import cn.com.smartdevices.bracelet.partner.NativeInterface;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.xiaomi.market.sdk.o;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class r {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public boolean h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public p o;
    public s p;
    public r q;
    public int r;
    public int s;
    public int t;
    public int u;
    public u v;
    public ArrayList<String> w;

    public static r a(String str) {
        try {
            return a(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static r a(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject == null) {
            return null;
        }
        r rVar = new r();
        rVar.a = jSONObject.optString("created_at");
        rVar.b = jSONObject.optString(SyncShoesDataService.d);
        rVar.c = jSONObject.optString("mid");
        rVar.d = jSONObject.optString("idstr");
        rVar.e = jSONObject.optString("text");
        rVar.f = jSONObject.optString(o.L);
        rVar.g = jSONObject.optBoolean("favorited", false);
        rVar.h = jSONObject.optBoolean("truncated", false);
        rVar.i = jSONObject.optString("in_reply_to_status_id");
        rVar.j = jSONObject.optString("in_reply_to_user_id");
        rVar.k = jSONObject.optString("in_reply_to_screen_name");
        rVar.l = jSONObject.optString("thumbnail_pic");
        rVar.m = jSONObject.optString("bmiddle_pic");
        rVar.n = jSONObject.optString("original_pic");
        rVar.o = p.a(jSONObject.optJSONObject("geo"));
        rVar.p = s.a(jSONObject.optJSONObject("user"));
        rVar.q = a(jSONObject.optJSONObject("retweeted_status"));
        rVar.r = jSONObject.optInt("reposts_count");
        rVar.s = jSONObject.optInt("comments_count");
        rVar.t = jSONObject.optInt("attitudes_count");
        rVar.u = jSONObject.optInt("mlevel", -1);
        rVar.v = u.a(jSONObject.optJSONObject(NativeInterface.PARAM_VISIBLE));
        JSONArray optJSONArray = jSONObject.optJSONArray("pic_urls");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return rVar;
        }
        int length = optJSONArray.length();
        rVar.w = new ArrayList(length);
        while (i < length) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                rVar.w.add(optJSONObject.optString("thumbnail_pic"));
            }
            i++;
        }
        return rVar;
    }
}
