package cn.com.smartdevices.bracelet.push;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.cp;
import cn.com.smartdevices.bracelet.activity.MainActivity;
import cn.com.smartdevices.bracelet.d.C0425b;
import cn.com.smartdevices.bracelet.lua.LuaEvent;
import cn.com.smartdevices.bracelet.model.LuaItem;
import cn.com.smartdevices.bracelet.partner.Partner;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class f extends a {
    public static final String h = "expire";
    public static final String i = "stype";
    public static final String j = "t1";
    public static final String k = "t2";
    public static final String l = "weight";
    public static final String m = "style";
    public static final String n = "color";
    public static final String o = "icon";
    public static final String p = "url";
    public final int q;
    public final String r;
    public final String s;
    public final String t;
    public final String u;
    public final String v;
    public final String w;
    public final String x;
    private final String y;

    public f(Context context, long j, long j2, JSONObject jSONObject) {
        super(context, j, j2, jSONObject);
        this.q = jSONObject.optInt(h);
        this.r = jSONObject.optString(j);
        this.s = jSONObject.optString(i);
        this.t = jSONObject.optString(k);
        this.u = jSONObject.optString(l);
        this.y = jSONObject.optString(m);
        this.x = jSONObject.optString(p);
        JSONObject optJSONObject = jSONObject.optJSONObject(m);
        if (optJSONObject != null) {
            this.v = optJSONObject.optString(n);
            this.w = optJSONObject.optString(o);
            return;
        }
        this.v = a.f;
        this.w = a.f;
    }

    public int a() {
        return R.id.notification_home;
    }

    public void b() {
        LuaItem luaItem = new LuaItem();
        luaItem.setExpire((long) this.q);
        luaItem.setRight(this.u);
        luaItem.setStype(this.s);
        luaItem.setT1(this.r);
        luaItem.setT2(this.t);
        luaItem.setStyleJson(this.y);
        luaItem.setScript(this.x);
        List arrayList = new ArrayList();
        Partner partner = new Partner();
        partner.id = this.s;
        partner.url = this.x;
        partner.title = this.r;
        partner.shareContent = this.t;
        partner.expireTime = (long) this.q;
        arrayList.add(partner);
        C0425b.a(this.d).a(arrayList);
        LuaEvent.getInstance(this.d).showLuaItem(luaItem);
    }

    public void c() {
        Intent intent = new Intent();
        intent.setClass(this.d, MainActivity.class);
        intent.addFlags(67108864);
        cp a = cp.a(this.d);
        a.a(MainActivity.class);
        a.a(intent);
        a(this.r, this.t, a.a(0, 268435456));
    }
}
