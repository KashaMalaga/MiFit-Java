package cn.com.smartdevices.bracelet.gps.services;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.t;
import cn.com.smartdevices.bracelet.lab.sportmode.SportBaseInfo;
import com.xiaomi.e.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class C0453l implements Serializable {
    public static final int a = 500;
    private static final String k = "w";
    private static final String l = "h";
    private static final long serialVersionUID = 1;
    private List<C0454m> b = null;
    private long c = 0;
    private int d = 0;
    private int e = 0;
    private String f = a.f;
    private int g = 0;
    private int h = 4;
    private int i = t.STATE_UNSYNCED.a();
    private int j = 0;

    public C0453l(int i, long j) {
        this.c = j;
        this.h = i;
        this.b = new ArrayList();
    }

    public static int a(int i) {
        return i % a == 0 ? i / a : (i / a) + 1;
    }

    public JSONArray a() {
        if (this.b == null) {
            throw new IllegalStateException();
        }
        JSONArray jSONArray = new JSONArray();
        for (C0454m c0454m : this.b) {
            if (c0454m != null) {
                jSONArray.put(c0454m.a());
            }
        }
        return jSONArray;
    }

    public void a(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    public void a(C0454m c0454m) {
        if (c0454m == null) {
            throw new IllegalArgumentException();
        }
        this.b.add(c0454m);
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    this.b.add(new C0454m((short) jSONObject.getInt(l), (short) jSONObject.getInt(SportBaseInfo.VERSION), (short) jSONObject.getInt(C0454m.c)));
                }
            } catch (JSONException e) {
                C0596r.e("Track", e.getMessage());
            }
        }
    }

    public void a(List<C0454m> list) {
        if (list == null) {
            throw new IllegalArgumentException();
        }
        this.b.addAll(list);
        n();
    }

    public String b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(k, this.d);
            jSONObject.put(l, this.e);
        } catch (JSONException e) {
            C0596r.e("Track", e.getMessage());
        }
        return jSONObject.toString();
    }

    public void b(int i) {
        this.g = i;
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.d = jSONObject.getInt(k);
                this.e = jSONObject.getInt(l);
            } catch (JSONException e) {
                C0596r.e("Track", e.getMessage());
            }
        }
    }

    public int c() {
        return this.g;
    }

    public void c(int i) {
        this.i = i;
    }

    public void c(String str) {
        this.f = str;
    }

    public String d() {
        return this.f;
    }

    public void d(int i) {
        this.j = i;
    }

    public List<C0454m> e() {
        return this.b;
    }

    public int f() {
        return this.h;
    }

    public int[] g() {
        return new int[]{this.d, this.e};
    }

    public int h() {
        return this.i;
    }

    public long i() {
        return this.c;
    }

    public int j() {
        return this.j;
    }

    public boolean k() {
        return t.STATE_SYNCED_FROM_SERVER.a() == this.i;
    }

    public boolean l() {
        return t.STATE_SYNCED_TO_SERVER.a() == this.i;
    }

    public boolean m() {
        return t.STATE_UNSYNCED.a() != this.i;
    }

    void n() {
        if (this.b != null) {
            this.g = C0453l.a(this.b.size());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrackId:").append(this.c).append(",Synced:").append(this.i).append(",Type:").append(this.h).append(",Data:").append(a().toString());
        return stringBuilder.toString();
    }
}
