package cn.com.smartdevices.bracelet.j;

import android.content.Context;
import android.content.Intent;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import com.huami.android.widget.f;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.e.a;
import org.json.JSONException;
import org.json.JSONObject;

public class n {
    public static final int a = -1;
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 666;
    public static final int f = 50001;
    public static final int g = 50018;
    public int h = a;
    public String i = a.f;

    public static n a(Context context, String str) {
        try {
            return a(context, new JSONObject(str));
        } catch (JSONException e) {
            n nVar = new n();
            nVar.h = d;
            return nVar;
        }
    }

    public static n a(Context context, JSONObject jSONObject) {
        C0596r.e("WebResponse", "getWebResponse:" + jSONObject.toString());
        n nVar = new n();
        try {
            nVar.h = jSONObject.getInt(b.a);
            nVar.i = jSONObject.getString(f.a);
        } catch (JSONException e) {
            nVar.h = d;
            C0596r.e("WebResponse", "getWebResponse:" + jSONObject.toString());
            C0596r.e(C0401a.cc, "ws.code = " + nVar.h + ", ws.message = " + nVar.i);
        }
        if (nVar.b() && cn.com.smartdevices.bracelet.e.a.f(context).isValid()) {
            C0596r.d(C0401a.cc, "start login activity, ws = " + nVar);
            a(context);
        }
        return nVar;
    }

    private static void a(Context context) {
        Intent intent = new Intent("cn.com.smartdevices.bracelet.intent.action.LOGIN");
        intent.setFlags(805339136);
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            try {
                Intent intent2 = new Intent(context, Class.forName("cn.com.smartdevices.bracelet.activity.LoginActivity"));
                intent2.setFlags(805339136);
                context.startActivity(intent2);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("cn.com.smartdevices.bracelet.intent.action.LOGIN not exised");
            }
        }
        cn.com.smartdevices.bracelet.e.a.a(context, -1, null);
    }

    public boolean a() {
        return this.h == f;
    }

    public boolean b() {
        return this.h == 0;
    }

    public boolean c() {
        return this.h == c;
    }

    public boolean equals(Object obj) {
        return ((n) obj).h == this.h;
    }
}
