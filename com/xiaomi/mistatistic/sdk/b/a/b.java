package com.xiaomi.mistatistic.sdk.b.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.support.v4.app.C0056bn;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.d.C0430g;
import cn.com.smartdevices.bracelet.d.C0432i;
import cn.com.smartdevices.bracelet.gps.services.ay;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.xiaomi.channel.relationservice.data.a;
import com.xiaomi.mipush.sdk.f;
import com.xiaomi.mistatistic.sdk.b.A;
import com.xiaomi.mistatistic.sdk.b.p;
import com.xiaomi.mistatistic.sdk.b.t;
import com.xiaomi.mistatistic.sdk.c.i;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements p {
    private long a;
    private HashMap b = new HashMap();
    private long c = System.currentTimeMillis();
    private long d = 0;
    private JSONArray e = new JSONArray();
    private JSONObject f = null;
    private ArrayList g = new ArrayList();
    private c h;
    private HashMap i = new HashMap();

    public b(long j, c cVar) {
        this.a = j;
        this.h = cVar;
    }

    private void a(i iVar) {
        JSONObject jSONObject = (JSONObject) this.b.get("mistat_session");
        if (jSONObject == null) {
            JSONArray jSONArray = new JSONArray();
            jSONObject = new JSONObject();
            jSONObject.put(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, "mistat_session");
            jSONObject.put("values", jSONArray);
            this.b.put("mistat_session", jSONObject);
            this.f.getJSONArray(ParamKey.CONTENT).put(jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        String[] split = iVar.e.split(f.i);
        long parseLong = Long.parseLong(split[0]);
        long parseLong2 = Long.parseLong(split[1]);
        jSONObject2.put("start", parseLong);
        jSONObject2.put("end", parseLong2);
        jSONObject2.put("env", iVar.f);
        jSONObject.getJSONArray("values").put(jSONObject2);
    }

    private void b(i iVar) {
        JSONObject jSONObject = (JSONObject) this.b.get("mistat_pv");
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONObject.put(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, "mistat_pv");
            jSONObject.put("values", jSONArray);
            this.b.put("mistat_pv", jSONObject);
            this.f.getJSONArray(ParamKey.CONTENT).put(jSONObject);
        }
        String[] split = iVar.e.trim().split(f.i);
        String[] strArr = new String[split.length];
        for (int i = 0; i < split.length; i++) {
            int indexOf = this.g.indexOf(split[i]);
            if (indexOf >= 0) {
                strArr[i] = String.valueOf(indexOf + 1);
            } else {
                strArr[i] = String.valueOf(this.g.size() + 1);
                this.g.add(split[i]);
            }
        }
        jSONObject.getJSONArray("values").put(TextUtils.join(f.i, strArr));
        jSONObject.put(ay.F, TextUtils.join(f.i, this.g));
    }

    private void c(i iVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = (JSONObject) this.b.get(iVar.a);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONObject2.put(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, iVar.a);
            jSONObject2.put("values", jSONArray);
            this.b.put(iVar.a, jSONObject2);
            this.f.getJSONArray(ParamKey.CONTENT).put(jSONObject2);
            jSONObject = jSONObject2;
        } else {
            jSONObject = jSONObject2;
        }
        if (C0056bn.d.equals(iVar.d) && TextUtils.isEmpty(iVar.f)) {
            jSONObject2 = (JSONObject) this.i.get(iVar.c);
            if (jSONObject2 != null) {
                jSONObject2.put(C0432i.b, jSONObject2.getLong(C0432i.b) + Long.parseLong(iVar.e));
                return;
            }
            jSONObject2 = new JSONObject();
            jSONObject2.put(C0430g.b, iVar.c);
            jSONObject2.put(a.h, iVar.d);
            jSONObject2.put(C0432i.b, Long.parseLong(iVar.e));
            jSONObject.getJSONArray("values").put(jSONObject2);
            this.i.put(iVar.c, jSONObject2);
            return;
        }
        jSONObject2 = new JSONObject();
        jSONObject2.put(C0430g.b, iVar.c);
        jSONObject2.put(a.h, iVar.d);
        if (ParamKey.COUNT.equals(iVar.d) || "numeric".equals(iVar.d)) {
            jSONObject2.put(C0432i.b, Long.parseLong(iVar.e));
        } else {
            jSONObject2.put(C0432i.b, iVar.e);
        }
        if (!TextUtils.isEmpty(iVar.f)) {
            jSONObject2.put("params", new JSONObject(iVar.f));
        }
        jSONObject.getJSONArray("values").put(jSONObject2);
    }

    public void a() {
        try {
            JSONArray b = b();
            if (b == null) {
                this.h.a(com.xiaomi.e.a.f, this.d);
            } else {
                this.h.a(b.toString(), this.d);
            }
        } catch (JSONException e) {
            this.h.a(com.xiaomi.e.a.f, this.d);
        }
    }

    public JSONArray b() {
        A a = new A();
        t tVar = new t();
        tVar.c();
        Cursor b = tVar.b();
        a.a("Begin to packing data from local DB");
        int i = 0;
        if (b != null) {
            try {
                if (b.moveToFirst()) {
                    do {
                        i++;
                        i a2 = t.a(b);
                        a.a("Packing " + a2.toString());
                        if (this.d == 0) {
                            this.d = a2.b;
                            this.c = this.d;
                        }
                        if (this.a > 0 && this.c - a2.b > this.a && this.f != null) {
                            this.f = null;
                            this.b.clear();
                            this.g.clear();
                            this.c = a2.b;
                            this.i.clear();
                        }
                        if (this.f == null) {
                            this.f = new JSONObject();
                            this.f.put("endTS", a2.b);
                            this.f.put(ParamKey.CONTENT, new JSONArray());
                            this.e.put(this.f);
                        }
                        if ("mistat_session".equals(a2.a)) {
                            a(a2);
                        } else if ("mistat_pv".equals(a2.a)) {
                            b(a2);
                        } else {
                            c(a2);
                        }
                        this.f.put("startTS", a2.b);
                    } while (b.moveToNext());
                    a.a("Packing complete, total " + i + " records were packed and to be uploaded");
                    if (b != null) {
                        b.close();
                    }
                    return this.e;
                }
            } catch (SQLiteException e) {
                if (b != null) {
                    b.close();
                }
            } catch (Throwable th) {
                if (b != null) {
                    b.close();
                }
            }
        }
        a.a("No data available to be packed");
        this.e = null;
        if (b != null) {
            b.close();
        }
        return this.e;
    }
}
