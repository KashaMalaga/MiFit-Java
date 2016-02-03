package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.j.n;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import cn.com.smartdevices.bracelet.shoes.sync.b.j;
import cn.com.smartdevices.bracelet.shoes.sync.b.k;
import cn.com.smartdevices.bracelet.shoes.sync.b.l;
import cn.com.smartdevices.bracelet.shoes.sync.b.m;
import com.huami.android.zxing.CaptureActivity;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.channel.relationservice.data.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class C0642s {
    C0642s() {
    }

    public static n a(Context context, int i, String str, z zVar) {
        int i2 = 0;
        if (zVar == null || context == null) {
            throw new IllegalArgumentException();
        }
        n a;
        n nVar = new n();
        try {
            JSONObject jSONObject = new JSONObject(str);
            a = n.a(context, jSONObject);
            try {
                if (a.c()) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(b.b);
                    jSONObject2.getInt(g.f);
                    int i3 = jSONObject2.getInt(a.h);
                    if (i3 != i) {
                        throw new IllegalArgumentException("type is invalid.type = " + i + ",typeserver =" + i3);
                    } else if (TextUtils.isEmpty(zVar.f) || zVar.f.compareTo(com.xiaomi.e.a.f) <= 0) {
                        JSONArray jSONArray = jSONObject2.getJSONArray(g.t);
                        int length = jSONArray.length();
                        for (int i4 = 0; i4 < length; i4++) {
                            zVar.a(new A(jSONArray.getString(i4)));
                        }
                    } else {
                        JSONArray jSONArray2 = jSONObject2.getJSONArray(g.r);
                        i3 = jSONArray2.length();
                        String str2 = com.xiaomi.e.a.f;
                        str2 = com.xiaomi.e.a.f;
                        while (i2 < i3) {
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                            Object string = jSONObject3.getString(g.t);
                            if (TextUtils.isEmpty(string)) {
                                C0596r.d(B.a, "deviceid is empty");
                            } else {
                                zVar.a(new A(string, jSONObject3.getString(g.p)));
                            }
                            i2++;
                        }
                    }
                }
            } catch (JSONException e) {
                e = e;
                a.h = 2;
                C0596r.d(B.a, e.getMessage());
                return a;
            }
        } catch (JSONException e2) {
            JSONException e3;
            JSONException jSONException = e2;
            a = nVar;
            e3 = jSONException;
            a.h = 2;
            C0596r.d(B.a, e3.getMessage());
            return a;
        }
        return a;
    }

    public static n a(Context context, String str, j jVar) {
        n a;
        if (jVar == null || context == null) {
            throw new IllegalArgumentException();
        }
        n nVar = new n();
        try {
            JSONObject jSONObject = new JSONObject(str);
            a = n.a(context, jSONObject);
            try {
                if (a.c()) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(b.b);
                    jVar.a(jSONObject2.getInt(g.f));
                    jVar.a(jSONObject2.getJSONArray(b.b));
                }
            } catch (JSONException e) {
                e = e;
                a.h = 2;
                C0596r.d(B.a, e.getMessage());
                return a;
            }
        } catch (JSONException e2) {
            JSONException e3;
            JSONException jSONException = e2;
            a = nVar;
            e3 = jSONException;
            a.h = 2;
            C0596r.d(B.a, e3.getMessage());
            return a;
        }
        return a;
    }

    public static n a(Context context, String str, k kVar, c cVar) {
        n a;
        JSONException e;
        if (kVar == null || context == null) {
            throw new IllegalArgumentException();
        }
        n nVar = new n();
        try {
            JSONObject jSONObject = new JSONObject(str);
            a = n.a(context, jSONObject);
            try {
                if (a.c() && !jSONObject.isNull(b.b)) {
                    CharSequence charSequence;
                    JSONObject jSONObject2 = jSONObject.getJSONObject(b.b);
                    String str2 = kVar.a;
                    String str3 = com.xiaomi.e.a.f;
                    if (TextUtils.isEmpty(kVar.a) || jSONObject2.isNull(g.t)) {
                        charSequence = str2;
                    } else {
                        charSequence = jSONObject2.getString(g.t);
                        if (!(TextUtils.isEmpty(charSequence) || charSequence.equals(str2))) {
                            throw new IllegalArgumentException("deviceId is invalid");
                        }
                    }
                    if (TextUtils.isEmpty(charSequence)) {
                        C0596r.d(B.a, "deviceId is empty.mac = " + cVar);
                        throw new IllegalArgumentException("deviceId is invalid");
                    }
                    str3 = com.xiaomi.e.a.f;
                    if (jSONObject2.has(g.p)) {
                        jSONObject2.getString(g.p);
                    }
                    int i = jSONObject2.has(g.f) ? jSONObject2.getInt(g.f) : -1;
                    if (i < 0) {
                        C0596r.d(B.a, "userId is empty");
                    } else {
                        String string = jSONObject2.has(CaptureActivity.n) ? jSONObject2.getString(CaptureActivity.n) : com.xiaomi.e.a.f;
                        str2 = jSONObject2.has(g.k) ? jSONObject2.getString(g.k) : com.xiaomi.e.a.f;
                        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(str2)) {
                            C0596r.d(B.a, "brand = " + string + ",brandType = " + str2);
                        } else {
                            str3 = com.xiaomi.e.a.f;
                            if (jSONObject2.has(SocialConstants.PARAM_SUMMARY)) {
                                str3 = jSONObject2.getString(SocialConstants.PARAM_SUMMARY);
                            }
                            if (TextUtils.isEmpty(str3)) {
                                C0596r.d(B.a, "summaryString is empty");
                            } else {
                                cn.com.smartdevices.bracelet.shoes.model.a a2 = cn.com.smartdevices.bracelet.shoes.data.c.a(string, Integer.valueOf(str2).intValue(), cVar);
                                a2.b(str3);
                                a2.f(cn.com.smartdevices.bracelet.shoes.model.k.STATE_SYNCED_FROM_SERVER.a());
                                kVar.a(a2);
                                kVar.a(i);
                            }
                        }
                    }
                }
            } catch (JSONException e2) {
                e = e2;
                a.h = 2;
                C0596r.d(B.a, e.getMessage());
                return a;
            }
        } catch (JSONException e3) {
            JSONException jSONException = e3;
            a = nVar;
            e = jSONException;
            a.h = 2;
            C0596r.d(B.a, e.getMessage());
            return a;
        }
        return a;
    }

    public static n a(Context context, String str, l lVar) {
        JSONException e;
        if (lVar == null || context == null) {
            throw new IllegalArgumentException();
        }
        n a;
        n nVar = new n();
        try {
            JSONObject jSONObject = new JSONObject(str);
            a = n.a(context, jSONObject);
            try {
                if (a.c()) {
                    lVar.a(jSONObject.getJSONObject(b.b).getJSONArray(b.b));
                }
            } catch (JSONException e2) {
                e = e2;
                a.h = 2;
                C0596r.d(B.a, e.getMessage());
                return a;
            }
        } catch (JSONException e3) {
            JSONException jSONException = e3;
            a = nVar;
            e = jSONException;
            a.h = 2;
            C0596r.d(B.a, e.getMessage());
            return a;
        }
        return a;
    }

    public static n a(Context context, String str, m mVar) {
        n a;
        if (mVar == null || context == null) {
            throw new IllegalArgumentException();
        }
        n nVar = new n();
        try {
            JSONObject jSONObject = new JSONObject(str);
            a = n.a(context, jSONObject);
            try {
                if (a.c()) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(b.b);
                    if (!jSONObject2.isNull(g.g)) {
                        mVar.b(jSONObject2.getLong(g.g));
                    }
                    mVar.a(jSONObject2.getInt(g.f));
                    mVar.a(jSONObject2.getJSONArray(b.b));
                }
            } catch (JSONException e) {
                e = e;
                a.h = 2;
                C0596r.d(B.a, e.getMessage());
                return a;
            }
        } catch (JSONException e2) {
            JSONException e3;
            JSONException jSONException = e2;
            a = nVar;
            e3 = jSONException;
            a.h = 2;
            C0596r.d(B.a, e3.getMessage());
            return a;
        }
        return a;
    }

    public static n a(Context context, String str, cn.com.smartdevices.bracelet.shoes.sync.b.n nVar) {
        n a;
        if (nVar == null || context == null) {
            throw new IllegalArgumentException();
        }
        n nVar2 = new n();
        try {
            JSONObject jSONObject = new JSONObject(str);
            a = n.a(context, jSONObject);
            try {
                if (a.c()) {
                    nVar.a(jSONObject.getJSONObject(b.b).getInt(g.f));
                }
            } catch (JSONException e) {
                e = e;
                a.h = 2;
                C0596r.d(B.a, e.getMessage());
                return a;
            }
        } catch (JSONException e2) {
            JSONException e3;
            JSONException jSONException = e2;
            a = nVar2;
            e3 = jSONException;
            a.h = 2;
            C0596r.d(B.a, e3.getMessage());
            return a;
        }
        return a;
    }
}
