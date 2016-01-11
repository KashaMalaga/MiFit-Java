package cn.com.smartdevices.bracelet.gps.model;

import android.text.TextUtils;
import android.util.Base64;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.e.a;
import org.json.JSONException;
import org.json.JSONObject;

public class n {
    public static final String a = "date";
    public static final String b = "data";
    public static final String c = "data_type";
    public static final String d = "summary";
    public static final String e = "count";
    public static final String f = "track_id";
    public static final String g = "latest_track_id";
    private static final String h = "SyncServerData";
    private int i = -1;
    private String j = null;
    private byte[] k = null;
    private String l = null;
    private int m = 0;
    private long n = 0;

    public n(String str) {
        this.k = str.getBytes();
    }

    public n(String str, String str2) {
        this.k = str2.getBytes();
        this.l = str;
    }

    public n(String str, byte[] bArr) {
        this.k = bArr;
        this.l = str;
    }

    public n(byte[] bArr) {
        this.k = bArr;
    }

    public static n a(String str, String str2, int i, long j) {
        n nVar = new n();
        try {
            nVar.k = Base64.decode(str, 2);
        } catch (IllegalArgumentException e) {
            C0596r.a("Sync", e.getMessage());
        }
        nVar.n = j;
        nVar.i = i;
        nVar.l = str2;
        return nVar;
    }

    public static n a(JSONObject jSONObject) {
        n nVar = new n();
        if (!jSONObject.isNull(b)) {
            try {
                nVar.k = Base64.decode(jSONObject.getString(b), 2);
            } catch (IllegalArgumentException e) {
                C0596r.a("Sync", e.getMessage());
            }
        }
        if (!jSONObject.isNull(a)) {
            nVar.j = jSONObject.getString(a);
        }
        if (!jSONObject.isNull(d)) {
            nVar.l = jSONObject.getString(d);
        }
        if (!jSONObject.isNull(e)) {
            nVar.m = jSONObject.getInt(e);
        }
        if (!jSONObject.isNull(c)) {
            nVar.i = jSONObject.getInt(c);
        }
        if (!jSONObject.isNull(f)) {
            nVar.n = jSONObject.getLong(f);
        }
        return nVar;
    }

    public int a() {
        return this.m;
    }

    public void a(int i) {
        this.m = i;
    }

    public void a(long j) {
        this.n = j;
    }

    public void a(String str) {
        this.j = str;
    }

    public String b() {
        return this.j;
    }

    public String c() {
        return this.k == null ? a.f : Base64.encodeToString(this.k, 2);
    }

    public byte[] d() {
        return this.k;
    }

    public String e() {
        return this.l;
    }

    public long f() {
        return this.n;
    }

    public int g() {
        return this.i;
    }

    public JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.j)) {
                jSONObject.put(a, this.j);
            }
            if (this.k != null) {
                jSONObject.put(b, Base64.encodeToString(this.k, 2));
            }
            if (!TextUtils.isEmpty(this.l)) {
                jSONObject.put(d, this.l);
            }
            if (this.m > 0) {
                jSONObject.put(e, String.valueOf(this.m));
            }
            if (this.n > 0) {
                jSONObject.put(f, String.valueOf(this.n));
            }
        } catch (JSONException e) {
            C0596r.e(h, "toJSONObject:" + e.getMessage());
        }
        return jSONObject;
    }
}
