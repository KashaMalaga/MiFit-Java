package cn.com.smartdevices.bracelet.weibo;

import com.xiaomi.channel.relationservice.data.a;
import org.json.JSONObject;

public class u {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public int e;
    public int f;

    public static u a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        u uVar = new u();
        uVar.e = jSONObject.optInt(a.h, a);
        uVar.f = jSONObject.optInt("list_id", a);
        return uVar;
    }
}
