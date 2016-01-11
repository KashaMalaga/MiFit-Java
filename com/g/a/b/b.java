package com.g.a.b;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import b.a.C0352cm;
import b.a.bW;
import b.a.bX;
import com.g.a.B;
import com.g.a.C1059a;
import com.g.a.p;
import com.xiaomi.e.a;
import java.util.Iterator;
import org.json.JSONObject;

public class b {
    public static final String a = "type";
    public static final String b = "package";
    public static final String c = "channel";
    public static final String d = "idmd5";
    public static final String e = "version_code";
    public static final String f = "appkey";
    public static final String g = "sdk_version";
    private final String h = "last_config_time";
    private final String i = "report_policy";
    private final String j = "online_config";
    private a k = null;
    private f l = null;
    private long m = 0;

    private void a(Context context, e eVar) {
        Editor edit = B.a(context).g().edit();
        if (!TextUtils.isEmpty(eVar.e)) {
            edit.putString(p.j, eVar.e);
            edit.commit();
        }
        if (eVar.c != -1) {
            B.a(context).a(eVar.c, eVar.d);
        }
    }

    private void a(JSONObject jSONObject) {
        if (this.k != null) {
            this.k.a(jSONObject);
        }
    }

    private JSONObject b(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(a, "online_config");
            jSONObject.put(f, C1059a.a(context));
            jSONObject.put(e, bW.c(context));
            jSONObject.put(b, bW.u(context));
            jSONObject.put(g, p.c);
            jSONObject.put(d, C0352cm.b(bW.f(context)));
            jSONObject.put(c, C1059a.b(context));
            jSONObject.put("report_policy", B.a(context).a()[0]);
            jSONObject.put("last_config_time", c(context));
            return jSONObject;
        } catch (Exception e) {
            bX.b(p.e, "exception in onlineConfigInternal");
            return null;
        }
    }

    private void b(Context context, e eVar) {
        if (eVar.a != null && eVar.a.length() != 0) {
            Editor edit = B.a(context).g().edit();
            try {
                JSONObject jSONObject = eVar.a;
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    edit.putString(str, jSONObject.getString(str));
                }
                edit.commit();
                bX.a(p.e, "get online setting params: " + jSONObject);
            } catch (Exception e) {
                bX.c(p.e, "save online config params", e);
            }
        }
    }

    private String c(Context context) {
        return B.a(context).g().getString(p.j, a.f);
    }

    public void a() {
        this.k = null;
    }

    public void a(Context context) {
        if (context == null) {
            try {
                bX.b(p.e, "unexpected null context in updateOnlineConfig");
            } catch (Exception e) {
                bX.b(p.e, "exception in updateOnlineConfig");
            }
        } else if (bX.a && bW.w(context)) {
            new Thread(new d(this, context.getApplicationContext())).start();
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.m > p.n) {
                this.m = currentTimeMillis;
                new Thread(new d(this, context.getApplicationContext())).start();
            }
        }
    }

    public void a(a aVar) {
        this.k = aVar;
    }

    public void a(f fVar) {
        this.l = fVar;
    }

    public void b() {
        this.l = null;
    }
}
