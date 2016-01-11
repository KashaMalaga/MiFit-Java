package com.xiaomi.market.sdk;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.connect.common.Constants;
import com.xiaomi.e.a;
import org.json.JSONException;
import org.json.JSONObject;

class y extends AsyncTask {
    private y() {
    }

    private B a(JSONObject jSONObject) {
        if (jSONObject == null) {
            Log.e("MarketUpdateAgent", "update info json obj null");
            return null;
        }
        B b = new B();
        try {
            b.a = jSONObject.getString(o.A);
            b.b = jSONObject.getInt(o.B);
            b.c = jSONObject.getString(o.C);
            b.d = jSONObject.getInt(o.e);
            b.e = jSONObject.getString(o.E);
            b.f = jSONObject.getString(o.F);
            b.g = jSONObject.getString(o.f);
            b.h = jSONObject.getLong(o.H);
            b.l = jSONObject.optInt(o.L, 0);
            if (d.e) {
                b.i = jSONObject.getString(o.I);
                b.j = jSONObject.getString(o.J);
                b.k = jSONObject.getLong(o.K);
            }
            return b;
        } catch (JSONException e) {
            Log.e("MarketUpdateAgent", "get update info failed : " + e.toString());
            Log.e("MarketUpdateAgent", "original content : " + jSONObject.toString());
            return null;
        }
    }

    private String b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(o.o, f.b + "*" + f.c);
            jSONObject.put(o.p, f.d);
            jSONObject.put(o.q, f.e);
            jSONObject.put(o.r, f.f);
            jSONObject.put(o.s, f.g);
            jSONObject.put(o.t, f.h);
            jSONObject.put(o.u, f.i);
            jSONObject.put(o.v, f.j);
            jSONObject.put(o.w, f.k);
            jSONObject.put(o.x, f.l);
            jSONObject.put(o.y, f.m);
            jSONObject.put(o.z, f.n);
            return jSONObject.toString();
        } catch (JSONException e) {
            return a.f;
        }
    }

    private static void c() {
        if ((d.b instanceof Activity) && ((Activity) d.b).isFinishing()) {
            Log.e("MarketUpdateAgent", "activity not running!");
            return;
        }
        CharSequence string;
        Builder title = new Builder(d.b).setTitle(d.b.getString(x.a(d.b.getPackageName(), "string", "xiaomi_update_dialog_title"), new Object[]{d.f.b}));
        if (TextUtils.isEmpty(d.g.i)) {
            string = d.b.getString(x.a(d.b.getPackageName(), "string", "xiaomi_update_dialog_message"), new Object[]{d.g.e, x.a(d.g.h, d.b)});
        } else {
            string = d.b.getString(x.a(d.b.getPackageName(), "string", "xiaomi_update_dialog_message_diff"), new Object[]{d.g.e, x.a(d.g.k, d.b)});
        }
        title.setMessage(string).setNegativeButton(17039360, null).setPositiveButton(17039370, new z()).show();
    }

    protected Integer a(Void... voidArr) {
        if (!x.c(d.b)) {
            return Integer.valueOf(3);
        }
        if (!x.d(d.b) && d.d) {
            return Integer.valueOf(2);
        }
        f.a(d.b);
        d.f = d.b(d.b);
        if (d.f == null) {
            return Integer.valueOf(5);
        }
        h hVar = new h(o.c);
        hVar.getClass();
        m mVar = new m(hVar);
        mVar.a(o.n, b());
        mVar.a(o.d, d.f.a);
        mVar.a(o.e, new StringBuilder(String.valueOf(d.f.c)).toString());
        mVar.a(o.f, d.f.g);
        mVar.a(o.g, d.f.e);
        mVar.a(o.h, f.o);
        mVar.a(o.w, String.valueOf(f.k));
        mVar.a(o.j, f.l);
        mVar.a(o.k, f.p);
        mVar.a(o.l, f.q);
        mVar.a(o.m, Constants.VIA_RESULT_SUCCESS);
        if (l.OK == hVar.d()) {
            JSONObject a = hVar.a();
            if (x.b) {
                Log.d("MarketUpdateAgent", a.toString());
            }
            d.g = a(a);
            if (d.g != null) {
                Log.i("MarketUpdateAgent", d.g.toString());
                return Integer.valueOf(d.g.b == 0 ? 0 : 1);
            }
        }
        return Integer.valueOf(4);
    }

    protected void a(Integer num) {
        if (d.c) {
            switch (num.intValue()) {
                case kankan.wheel.widget.a.i /*0*/:
                    new A().execute(new Void[0]);
                    return;
                default:
                    return;
            }
        }
        C1123b c1123b = new C1123b();
        if (num.intValue() == 0) {
            c1123b.a = d.g.c;
            c1123b.c = d.g.d;
            c1123b.b = d.g.e;
            c1123b.d = h.a(d.g.a, d.g.f);
        }
        if (d.h != null) {
            d.h.a(num.intValue(), c1123b);
        }
    }

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Integer) obj);
    }

    protected void onPreExecute() {
        Log.d("MarketUpdateAgent", "start to check update");
        if (!d.e) {
            d.e = C1122a.a();
        }
    }
}
