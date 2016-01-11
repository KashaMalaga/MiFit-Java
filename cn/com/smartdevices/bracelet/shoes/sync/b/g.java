package cn.com.smartdevices.bracelet.shoes.sync.b;

import android.text.TextUtils;
import android.util.Base64;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.d;
import com.xiaomi.e.a;
import org.json.JSONException;
import org.json.JSONObject;

public class g {
    public static final String a = "date";
    public static final String b = "data";
    public static final String c = "type";
    public static final String d = "heartrate";
    public static final String e = "summary";
    public static final String f = "userid";
    public static final String g = "next_to_date";
    public static final String h = "fromdate";
    public static final String i = "todate";
    public static final String j = "brand";
    public static final String k = "brand_type";
    public static final String l = "count";
    public static final String m = "is_data";
    public static final String n = "uuid";
    public static final String o = "dates";
    public static final String p = "sn";
    public static final String q = "mac";
    public static final String r = "device";
    public static final String s = "shoe_version";
    public static final String t = "deviceid";
    private static final String y = "SyncServerData";
    private String A = null;
    private byte[] B = null;
    private String C = null;
    public int u = -1;
    public String v = null;
    public String w = null;
    public String x = null;
    private final int z = d.a;

    public g(String str) {
        this.B = str.getBytes();
    }

    public g(String str, String str2) {
        this.B = str2.getBytes();
        this.C = str;
    }

    public g(String str, byte[] bArr) {
        this.B = bArr;
        this.C = str;
    }

    public g(byte[] bArr) {
        this.B = bArr;
    }

    public String a() {
        return this.A;
    }

    public void a(String str) {
        this.A = str;
    }

    public String b() {
        return this.B == null ? a.f : Base64.encodeToString(this.B, 2);
    }

    public byte[] c() {
        return this.B;
    }

    public String d() {
        return this.C;
    }

    public int e() {
        return this.z;
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.A)) {
                jSONObject.put(a, this.A);
            }
            if (this.B != null) {
                jSONObject.put(b, Base64.encodeToString(this.B, 2));
            }
            if (!TextUtils.isEmpty(this.C)) {
                jSONObject.put(e, this.C);
            }
        } catch (JSONException e) {
            C0596r.e(y, "toJSONObject:" + e.getMessage());
        }
        return jSONObject;
    }
}
