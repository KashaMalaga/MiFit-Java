package cn.com.smartdevices.bracelet.gps.services;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public final class C0454m implements Serializable {
    public static final String a = "h";
    public static final String b = "v";
    public static final String c = "t";
    public static final int d = 6;
    private static final long serialVersionUID = 1;
    private short e = (short) 0;
    private short f = (short) 0;
    private short g = (short) 0;

    public C0454m(short s, short s2, short s3) {
        this.e = s;
        this.f = s2;
        this.g = s3;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(a, this.e);
            jSONObject.put(b, this.f);
            jSONObject.put(c, this.g);
        } catch (JSONException e) {
            C0596r.a(p.a, e.getMessage());
        }
        return jSONObject;
    }

    public short b() {
        return this.g;
    }

    public short c() {
        return this.e;
    }

    public short d() {
        return this.f;
    }
}
