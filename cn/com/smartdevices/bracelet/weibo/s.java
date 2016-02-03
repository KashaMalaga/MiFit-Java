package cn.com.smartdevices.bracelet.weibo;

import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.amap.api.services.district.DistrictSearchQuery;
import com.tencent.open.SocialConstants;
import com.xiaomi.e.a;
import org.json.JSONException;
import org.json.JSONObject;

public class s {
    public boolean A;
    public String B;
    public String C;
    public String D;
    public boolean E;
    public int F;
    public int G;
    public String H;
    public String I;
    public String J;
    public String K;
    public String L;
    public String a;
    public String b;
    public String c;
    public String d;
    public int e;
    public int f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public int o;
    public int p;
    public int q;
    public int r;
    public String s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public int x;
    public String y;
    public r z;

    public static s a(String str) {
        try {
            return a(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static s a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        s sVar = new s();
        sVar.a = jSONObject.optString(SyncShoesDataService.d, a.f);
        sVar.b = jSONObject.optString("idstr", a.f);
        sVar.c = jSONObject.optString("screen_name", a.f);
        sVar.d = jSONObject.optString("name", a.f);
        sVar.e = jSONObject.optInt(DistrictSearchQuery.KEYWORDS_PROVINCE, -1);
        sVar.f = jSONObject.optInt(DistrictSearchQuery.KEYWORDS_CITY, -1);
        sVar.g = jSONObject.optString(com.xiaomi.channel.relationservice.data.a.l, a.f);
        sVar.h = jSONObject.optString(SocialConstants.PARAM_COMMENT, a.f);
        sVar.i = jSONObject.optString(SocialConstants.PARAM_URL, a.f);
        sVar.j = jSONObject.optString("profile_image_url", a.f);
        sVar.k = jSONObject.optString("profile_url", a.f);
        sVar.l = jSONObject.optString("domain", a.f);
        sVar.m = jSONObject.optString("weihao", a.f);
        sVar.n = jSONObject.optString(f.B, a.f);
        sVar.o = jSONObject.optInt("followers_count", 0);
        sVar.p = jSONObject.optInt("friends_count", 0);
        sVar.q = jSONObject.optInt("statuses_count", 0);
        sVar.r = jSONObject.optInt("favourites_count", 0);
        sVar.s = jSONObject.optString("created_at", a.f);
        sVar.t = jSONObject.optBoolean("following", false);
        sVar.u = jSONObject.optBoolean("allow_all_act_msg", false);
        sVar.v = jSONObject.optBoolean("geo_enabled", false);
        sVar.w = jSONObject.optBoolean("verified", false);
        sVar.x = jSONObject.optInt(com.xiaomi.channel.relationservice.data.a.x, -1);
        sVar.y = jSONObject.optString("remark", a.f);
        sVar.A = jSONObject.optBoolean("allow_all_comment", true);
        sVar.B = jSONObject.optString("avatar_large", a.f);
        sVar.C = jSONObject.optString("avatar_hd", a.f);
        sVar.D = jSONObject.optString("verified_reason", a.f);
        sVar.E = jSONObject.optBoolean("follow_me", false);
        sVar.F = jSONObject.optInt("online_status", 0);
        sVar.G = jSONObject.optInt("bi_followers_count", 0);
        sVar.H = jSONObject.optString(f.e, a.f);
        sVar.I = jSONObject.optString("star", a.f);
        sVar.J = jSONObject.optString("mbtype", a.f);
        sVar.K = jSONObject.optString("mbrank", a.f);
        sVar.L = jSONObject.optString("block_word", a.f);
        return sVar;
    }

    public static String b(String str) {
        try {
            return new JSONObject(str).optString("screen_name", a.f);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
