package cn.com.smartdevices.bracelet.notification;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.display.DisplayManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.provider.Settings.Secure;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.view.Display;
import cn.com.smartdevices.bracelet.C0596r;
import com.sina.weibo.sdk.constant.WBConstants;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.bt.a.C1115b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h {
    public static final boolean a = true;
    public static final String b = "NotificationManager";
    private static final String c = "Apps";
    private static final String d = "AppPkg";
    private static final String e = "AppOn";
    private static final String f = "NotifiOn";
    private static h g;
    private static Handler m;
    private static HandlerThread n = new HandlerThread("notification_thread");
    private static long o;
    private Context h;
    private SharedPreferences i;
    private List<a> j = new ArrayList();
    private long k = 10;
    private long l = 1000;
    private String p;
    private Runnable q;

    private h() {
    }

    public static h a() {
        return g;
    }

    public static h a(Context context) {
        if (g == null) {
            g = new h();
            g.c(context);
        }
        return g;
    }

    public static void a(Context context, StatusBarNotification statusBarNotification) {
        if (!b(context)) {
            h a = a();
            if (a != null && a.d(statusBarNotification.getPackageName()) && a.g()) {
                if (m == null) {
                    n.start();
                    m = new Handler(n.getLooper());
                }
                m.removeCallbacks(a.q);
                a.p = statusBarNotification.getPackageName();
                a.q = j();
                m.postDelayed(a.q, a.l);
            }
        }
    }

    public static void a(StatusBarNotification statusBarNotification) {
        h a = a();
        if (a != null && a.d(statusBarNotification.getPackageName()) && statusBarNotification.getPackageName().equals(a.p) && a.q != null && m != null) {
            m.removeCallbacks(a.q);
            a.p = null;
            a.q = null;
        }
    }

    private void a(List<a> list) {
        Editor edit = this.i.edit();
        if (list.size() == 0) {
            edit.putString(c, a.f);
        } else {
            try {
                JSONArray jSONArray = new JSONArray();
                for (a aVar : list) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(d, aVar.a);
                    jSONObject.put(e, aVar.b);
                    jSONArray.put(jSONObject);
                }
                String jSONArray2 = jSONArray.toString();
                C0596r.e(b, "Save Apps : " + jSONArray2);
                edit.putString(c, jSONArray2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        edit.apply();
    }

    public static boolean b(Context context) {
        int i = 0;
        if (VERSION.SDK_INT < 20) {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        }
        Display[] displays = ((DisplayManager) context.getSystemService(WBConstants.AUTH_PARAMS_DISPLAY)).getDisplays();
        int length = displays.length;
        boolean z = false;
        while (i < length) {
            if (displays[i].getState() != 1) {
                z = a;
            }
            i++;
        }
        return z;
    }

    private void c(Context context) {
        this.h = context;
        this.i = context.getSharedPreferences(b, 0);
        this.j.addAll(i());
    }

    private List<a> i() {
        List<a> arrayList = new ArrayList();
        String string = this.i.getString(c, a.f);
        C0596r.e(b, "Load Saved Apps : " + string);
        if (!a.f.equals(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    a aVar = new a();
                    aVar.a = jSONObject.getString(d);
                    aVar.b = jSONObject.getBoolean(e);
                    arrayList.add(aVar);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    private static Runnable j() {
        return new i();
    }

    private static void k() {
        C0596r.d(b, "MiSport-Notifi Alert To Device!!");
        new C1115b((byte) 3, null).g();
        o = System.currentTimeMillis();
    }

    public a a(int i) {
        a aVar = null;
        synchronized (this.j) {
            if (i >= 0) {
                if (i < this.j.size()) {
                    aVar = (a) this.j.get(i);
                }
            }
        }
        return aVar;
    }

    public void a(a aVar) {
        synchronized (this.j) {
            if (b(aVar.a) != null) {
                return;
            }
            this.j.add(aVar);
            a(this.j);
        }
    }

    public void a(String str) {
        synchronized (this.j) {
            a b = b(str);
            if (b == null) {
                return;
            }
            this.j.remove(b);
            a(this.j);
        }
    }

    public void a(boolean z) {
        Editor edit = this.i.edit();
        edit.putBoolean(f, z);
        edit.commit();
    }

    public int b() {
        int size;
        synchronized (this.j) {
            size = this.j.size();
        }
        return size;
    }

    public a b(String str) {
        synchronized (this.j) {
            for (a aVar : this.j) {
                if (aVar.a.equals(str)) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public void b(a aVar) {
        synchronized (this.j) {
            a b = b(aVar.a);
            if (b == null) {
                return;
            }
            b.a = aVar.a;
            b.b = aVar.b;
            a(this.j);
        }
    }

    public List<a> c() {
        List<a> arrayList = new ArrayList();
        synchronized (this.j) {
            arrayList.addAll(this.j);
        }
        return arrayList;
    }

    public boolean c(String str) {
        synchronized (this.j) {
            for (a aVar : this.j) {
                if (aVar.a.equals(str)) {
                    return a;
                }
            }
            return false;
        }
    }

    public boolean d() {
        return this.i.getBoolean(f, false);
    }

    public boolean d(String str) {
        boolean z = false;
        if (d() && c(str)) {
            a b = b(str);
            if (b != null) {
                C0596r.d(b, "MiSport-Notifi App : " + b);
                if (b.b) {
                    z = a;
                }
            }
        }
        if (z) {
            C0596r.e(b, "Is Notification Available '" + str);
        }
        return z;
    }

    public boolean e() {
        Object string = Secure.getString(this.h.getContentResolver(), "enabled_notification_listeners");
        return TextUtils.isEmpty(string) ? false : string.contains(this.h.getApplicationContext().getPackageName());
    }

    public boolean f() {
        C0596r.e(b, "IsNotificationAccessEnabled : " + e() + ", IsNotificationON : " + d());
        return e() ? d() : false;
    }

    public boolean g() {
        long j = o;
        return (j <= 0 || (System.currentTimeMillis() - j) / 1000 > this.k) ? a : false;
    }
}
