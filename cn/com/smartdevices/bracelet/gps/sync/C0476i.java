package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.model.a;
import cn.com.smartdevices.bracelet.gps.model.o;
import cn.com.smartdevices.bracelet.j.n;
import cn.com.smartdevices.bracelet.lab.sync.l;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.gamesdk.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class C0476i {
    C0476i() {
    }

    public static n a(Context context, String str, a aVar) {
        if (aVar == null || aVar.a() == null) {
            throw new IllegalArgumentException();
        }
        n a;
        n nVar = new n();
        try {
            JSONObject jSONObject = new JSONObject(str);
            a = n.a(context, jSONObject);
            try {
                if (a.c()) {
                    JSONArray jSONArray = jSONObject.getJSONArray(b.b);
                    int length = jSONArray.length();
                    aVar.a().ensureCapacity(length);
                    for (int i = 0; i < length; i++) {
                        aVar.a().add(Long.valueOf(jSONArray.getLong(i)));
                    }
                }
            } catch (JSONException e) {
                e = e;
                a.h = 2;
                C0596r.a("Sync", e.getMessage());
                return a;
            }
        } catch (JSONException e2) {
            JSONException e3;
            JSONException jSONException = e2;
            a = nVar;
            e3 = jSONException;
            a.h = 2;
            C0596r.a("Sync", e3.getMessage());
            return a;
        }
        return a;
    }

    public static n a(Context context, String str, o oVar) {
        n a;
        if (oVar == null || oVar.b == null) {
            throw new IllegalArgumentException();
        }
        n nVar = new n();
        try {
            JSONObject jSONObject = new JSONObject(str);
            a = n.a(context, jSONObject);
            try {
                if (a.c()) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(b.b);
                    JSONArray jSONArray = jSONObject2.getJSONArray(b.b);
                    if (!jSONObject2.isNull(l.g)) {
                        oVar.c = jSONObject2.getLong(l.g);
                    }
                    int length = jSONArray.length();
                    oVar.b.ensureCapacity(length);
                    for (int i = 0; i < length; i++) {
                        oVar.b.add(cn.com.smartdevices.bracelet.gps.model.n.a(jSONArray.getJSONObject(i)));
                    }
                }
            } catch (JSONException e) {
                e = e;
                a.h = 2;
                C0596r.a("Sync", e.getMessage());
                return a;
            }
        } catch (JSONException e2) {
            JSONException e3;
            JSONException jSONException = e2;
            a = nVar;
            e3 = jSONException;
            a.h = 2;
            C0596r.a("Sync", e3.getMessage());
            return a;
        }
        return a;
    }

    public static n a(Context context, String str, T t) {
        if (t == null) {
            throw new IllegalArgumentException();
        }
        n a;
        n nVar = new n();
        try {
            JSONObject jSONObject = new JSONObject(str);
            a = n.a(context, jSONObject);
            try {
                if (a.c()) {
                    t.a(jSONObject.getJSONObject(b.b));
                }
            } catch (JSONException e) {
                e = e;
                a.h = 2;
                C0596r.a("Sync", e.getMessage());
                return a;
            }
        } catch (JSONException e2) {
            JSONException e3;
            JSONException jSONException = e2;
            a = nVar;
            e3 = jSONException;
            a.h = 2;
            C0596r.a("Sync", e3.getMessage());
            return a;
        }
        return a;
    }

    public static n a(Context context, String str, ArrayList<cn.com.smartdevices.bracelet.gps.model.n> arrayList) {
        n a;
        n nVar = new n();
        try {
            JSONObject jSONObject = new JSONObject(str);
            a = n.a(context, jSONObject);
            try {
                if (a.c()) {
                    JSONArray jSONArray = jSONObject.getJSONArray(b.b);
                    int length = jSONArray.length();
                    arrayList.ensureCapacity(length);
                    String str2 = com.xiaomi.e.a.f;
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        int i2 = jSONObject2.getInt(l.c);
                        long j = jSONObject2.getLong(l.f);
                        arrayList.add(cn.com.smartdevices.bracelet.gps.model.n.a(jSONObject2.getJSONArray(b.b).toString(), jSONObject2.getString(SocialConstants.PARAM_SUMMARY), i2, j));
                    }
                }
            } catch (JSONException e) {
                e = e;
                a.h = 2;
                C0596r.a("Sync", e.getMessage());
                return a;
            }
        } catch (JSONException e2) {
            JSONException e3;
            JSONException jSONException = e2;
            a = nVar;
            e3 = jSONException;
            a.h = 2;
            C0596r.a("Sync", e3.getMessage());
            return a;
        }
        return a;
    }

    public static n b(Context context, String str, ArrayList<cn.com.smartdevices.bracelet.gps.model.n> arrayList) {
        n a;
        JSONException e;
        if (arrayList == null) {
            throw new IllegalArgumentException();
        }
        n nVar = new n();
        try {
            JSONObject jSONObject = new JSONObject(str);
            a = n.a(context, jSONObject);
            try {
                if (a.c()) {
                    JSONArray jSONArray = jSONObject.getJSONArray(b.b);
                    int length = jSONArray.length();
                    arrayList.ensureCapacity(length);
                    for (int i = 0; i < length; i++) {
                        arrayList.add(cn.com.smartdevices.bracelet.gps.model.n.a(jSONArray.getJSONObject(i)));
                    }
                }
            } catch (JSONException e2) {
                e = e2;
                a.h = 2;
                C0596r.a("Sync", e.getMessage());
                return a;
            }
        } catch (JSONException e3) {
            JSONException jSONException = e3;
            a = nVar;
            e = jSONException;
            a.h = 2;
            C0596r.a("Sync", e.getMessage());
            return a;
        }
        return a;
    }

    public static n c(Context context, String str, ArrayList<cn.com.smartdevices.bracelet.gps.model.n> arrayList) {
        n a;
        JSONException e;
        if (arrayList == null) {
            throw new IllegalArgumentException();
        }
        n nVar = new n();
        try {
            JSONObject jSONObject = new JSONObject(str);
            a = n.a(context, jSONObject);
            try {
                if (a.c()) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(b.b);
                    JSONArray jSONArray = jSONObject2.getJSONArray(b.b);
                    long j = jSONObject2.getLong(l.f);
                    int i = jSONObject2.getInt(l.c);
                    int length = jSONArray.length();
                    arrayList.ensureCapacity(length);
                    for (int i2 = 0; i2 < length; i2++) {
                        arrayList.add(cn.com.smartdevices.bracelet.gps.model.n.a(jSONArray.getString(i2), com.xiaomi.e.a.f, i, j));
                    }
                }
            } catch (JSONException e2) {
                e = e2;
                a.h = 2;
                C0596r.a("Sync", e.getMessage());
                return a;
            }
        } catch (JSONException e3) {
            JSONException jSONException = e3;
            a = nVar;
            e = jSONException;
            a.h = 2;
            C0596r.a("Sync", e.getMessage());
            return a;
        }
        return a;
    }

    public static n d(Context context, String str, ArrayList<Long> arrayList) {
        if (arrayList == null || arrayList == null) {
            throw new IllegalArgumentException();
        }
        n a;
        n nVar = new n();
        try {
            JSONObject jSONObject = new JSONObject(str);
            a = n.a(context, jSONObject);
            try {
                if (a.c()) {
                    JSONArray jSONArray = jSONObject.getJSONObject(b.b).getJSONArray(b.b);
                    int length = jSONArray.length();
                    arrayList.ensureCapacity(length);
                    for (int i = 0; i < length; i++) {
                        arrayList.add(Long.valueOf(jSONArray.getLong(i)));
                    }
                }
            } catch (JSONException e) {
                e = e;
                a.h = 2;
                C0596r.a("Sync", e.getMessage());
                return a;
            }
        } catch (JSONException e2) {
            JSONException e3;
            JSONException jSONException = e2;
            a = nVar;
            e3 = jSONException;
            a.h = 2;
            C0596r.a("Sync", e3.getMessage());
            return a;
        }
        return a;
    }
}
