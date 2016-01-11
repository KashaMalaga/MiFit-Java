package cn.com.smartdevices.bracelet.lab.sync;

import android.text.TextUtils;
import android.util.Base64;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.e.a;
import org.json.JSONException;
import org.json.JSONObject;

public class l {
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

    public l(String str) {
        this.k = str.getBytes();
    }

    public l(String str, String str2) {
        this.k = str2.getBytes();
        this.l = str;
    }

    public l(String str, byte[] bArr) {
        this.k = bArr;
        this.l = str;
    }

    public l(byte[] bArr) {
        this.k = bArr;
    }

    public static l a(String str, String str2, int i, long j) {
        l lVar = new l();
        try {
            lVar.k = Base64.decode(str, 2);
        } catch (IllegalArgumentException e) {
            C0596r.a("Sync", e.getMessage());
        }
        lVar.n = j;
        lVar.i = i;
        lVar.l = str2;
        return lVar;
    }

    public static l a(JSONObject jSONObject) {
        l lVar = new l();
        if (!jSONObject.isNull(b)) {
            try {
                lVar.k = Base64.decode(jSONObject.getString(b), 2);
            } catch (IllegalArgumentException e) {
                C0596r.a("Sync", e.getMessage());
            }
        }
        if (!jSONObject.isNull(a)) {
            lVar.j = jSONObject.getString(a);
        }
        if (!jSONObject.isNull(d)) {
            lVar.l = jSONObject.getString(d);
        }
        if (!jSONObject.isNull(e)) {
            lVar.m = jSONObject.getInt(e);
        }
        if (!jSONObject.isNull(c)) {
            lVar.i = jSONObject.getInt(c);
        }
        if (!jSONObject.isNull(f)) {
            lVar.n = jSONObject.getLong(f);
        }
        return lVar;
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
