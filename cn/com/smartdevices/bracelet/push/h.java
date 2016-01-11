package cn.com.smartdevices.bracelet.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.widget.af;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Constant;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.push.a.b;
import cn.com.smartdevices.bracelet.push.a.c;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.a.b.a;
import com.xiaomi.mipush.sdk.f;
import de.greenrobot.event.EventBus;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class h implements a {
    public static final String a = "messageBuilder";
    static volatile h b = null;
    private static final String c = "abroad";
    private static final String d = "china";
    private static final String e = "last_update_time";
    private static int f = 0;
    private long g = 0;
    private EventBus h = null;
    private b i = null;
    private c j = null;
    private SharedPreferences k = null;
    private final WeakReference<Context> l;

    private h(Context context) {
        this.l = new WeakReference(context);
        d();
    }

    public static h a(Context context) {
        if (b == null) {
            synchronized (h.class) {
                if (b == null) {
                    b = new h(context);
                }
            }
        }
        return b;
    }

    private void d() {
        cn.com.smartdevices.bracelet.config.b h = cn.com.smartdevices.bracelet.config.b.h();
        if (h.d.a.booleanValue()) {
            Context context = (Context) this.l.get();
            if (context != null) {
                h.d.getClass();
                h.d.getClass();
                f.a(context, "2882303761517163841", "5171716313841");
                this.h = EventBus.getDefault();
                this.h.register(this, af.a);
                this.j = new c(context);
                this.i = this.j.b();
                this.k = context.getSharedPreferences("Message", 0);
                this.g = cn.com.smartdevices.bracelet.e.a.f(context).uid;
                if (C0596r.b()) {
                    com.xiaomi.mipush.sdk.c.a(context, this);
                }
                if (this.g > 0) {
                    f.b(context, String.valueOf(this.g), null);
                }
                f.f(context, cn.com.smartdevices.bracelet.config.b.a(), null);
                f.f(context, cn.com.smartdevices.bracelet.config.b.c(), null);
                f.f(context, Locale.getDefault().getLanguage(), null);
                f.f(context, Locale.getDefault().getCountry(), null);
                f.f(context, Locale.getDefault().toString(), null);
                if (e()) {
                    f.f(context, d, null);
                } else {
                    f.f(context, c, null);
                }
            }
        }
    }

    private static boolean e() {
        PersonInfo readPersonInfo = Keeper.readPersonInfo();
        if (readPersonInfo == null) {
            return true;
        }
        long j = readPersonInfo.uid;
        return j > Constant.aU ? j <= Constant.aT ? false : false : true;
    }

    public a a(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(SocialConstants.PARAM_TYPE);
            long optLong = jSONObject.optLong(kankan.wheel.widget.a.n);
            long optLong2 = jSONObject.optLong(cn.com.smartdevices.bracelet.push.a.a.b);
            LoginData f = cn.com.smartdevices.bracelet.e.a.f(context);
            if (optLong != 0 && optLong != f.uid) {
                C0596r.e(a, "uid is invalid");
                return null;
            } else if (this.i.a(optLong2)) {
                C0596r.e(a, "push dao already has the msg!");
                return null;
            } else {
                this.i.b(optLong2);
                JSONObject jSONObject2 = jSONObject.getJSONObject(com.xiaomi.channel.gamesdk.b.b);
                a gVar = i.a.equals(string) ? new g(context, optLong2, optLong, jSONObject2) : i.b.equals(string) ? new f(context, optLong2, optLong, jSONObject2) : i.c.equals(string) ? new b(context, optLong2, optLong, jSONObject2) : i.d.equals(string) ? new e(context, optLong2, optLong, jSONObject2) : i.e.equals(string) ? new d(context, optLong2, optLong, jSONObject2) : i.f.equals(string) ? new j(context, optLong2, optLong, jSONObject2) : null;
                gVar.e = 1;
                return gVar;
            }
        } catch (JSONException e) {
            C0596r.a(a, e.getMessage());
            return null;
        }
    }

    public void a(Object obj) {
        if (this.h != null) {
            this.h.unregister(obj);
            EventBus eventBus = this.h;
            int i = f;
            f = i + 1;
            eventBus.register(obj, i);
        }
    }

    public void a(String str) {
    }

    public void a(String str, Throwable th) {
        C0596r.e(a, str);
    }

    public void a(boolean z) {
        if (this.k != null) {
            Editor edit = this.k.edit();
            edit.putBoolean(e, z);
            edit.apply();
        }
    }

    public boolean a() {
        return this.k != null ? this.k.getBoolean(e, false) : false;
    }

    public void b() {
        Context context = (Context) this.l.get();
        if (context != null) {
            f.c(context, String.valueOf(this.g), null);
            c();
        }
    }

    public void b(Object obj) {
        if (this.h != null) {
            this.h.unregister(obj);
        }
    }

    public void b(String str) {
        C0596r.e(a, str);
    }

    public void c() {
        Context context = (Context) this.l.get();
        if (context != null) {
            EventBus.getDefault().unregister(this);
            f.g(context);
        }
        b = null;
    }

    public void onEvent(a aVar) {
        if (this.h != null && aVar != null && !(aVar instanceof j)) {
            aVar.c();
            a(true);
            this.h.post(new cn.com.smartdevices.bracelet.push.b.a());
        }
    }
}
