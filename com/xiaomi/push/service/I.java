package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.view.a.C0113o;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.a.b.c;
import com.xiaomi.channel.a.e.d;
import com.xiaomi.channel.b.v;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.market.sdk.o;
import com.xiaomi.market.sdk.q;
import java.util.ArrayList;
import java.util.List;
import kankan.wheel.widget.a;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class I {
    private static H a;

    public static synchronized H a(Context context) {
        H h = null;
        synchronized (I.class) {
            if (a != null) {
                h = a;
            } else {
                SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
                Object string = sharedPreferences.getString(g.n, null);
                Object string2 = sharedPreferences.getString("token", null);
                Object string3 = sharedPreferences.getString(a.o, null);
                String string4 = sharedPreferences.getString(v.u, null);
                String string5 = sharedPreferences.getString("app_token", null);
                String string6 = sharedPreferences.getString(q.c, null);
                Object string7 = sharedPreferences.getString(a.ak, null);
                int i = sharedPreferences.getInt("env_type", 1);
                if (!TextUtils.isEmpty(string7) && string7.startsWith("a-")) {
                    string7 = G.c(context);
                    sharedPreferences.edit().putString(a.ak, string7).commit();
                }
                if (!(TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3))) {
                    CharSequence c = G.c(context);
                    if ("com.xiaomi.xmsf".equals(context.getPackageName()) || TextUtils.isEmpty(c) || TextUtils.isEmpty(r8) || r8.equals(c)) {
                        a = new H(string, string2, string3, string4, string5, string6, i);
                        h = a;
                    } else {
                        c.c("erase the old account.");
                        b(context);
                    }
                }
            }
        }
        return h;
    }

    public static synchronized H a(Context context, String str, String str2, String str3) {
        H h = null;
        synchronized (I.class) {
            PackageInfo packageInfo;
            List arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("devid", G.a(context)));
            String str4 = c(context) ? "1000271" : str2;
            String str5 = c(context) ? "420100086271" : str3;
            String str6 = c(context) ? "com.xiaomi.xmsf" : str;
            arrayList.add(new BasicNameValuePair(SocialConstants.PARAM_APP_ID, str4));
            arrayList.add(new BasicNameValuePair("apptoken", str5));
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str6, C0113o.o);
            } catch (Throwable e) {
                c.a(e);
                packageInfo = null;
            }
            arrayList.add(new BasicNameValuePair("appversion", packageInfo != null ? String.valueOf(packageInfo.versionCode) : Constants.VIA_RESULT_SUCCESS));
            arrayList.add(new BasicNameValuePair("sdkversion", Constants.VIA_SSO_LOGIN));
            arrayList.add(new BasicNameValuePair(ParamKey.PACKAGENAME, str6));
            arrayList.add(new BasicNameValuePair("model", Build.MODEL));
            arrayList.add(new BasicNameValuePair(o.z, G.b(context)));
            arrayList.add(new BasicNameValuePair(o.j, VERSION.RELEASE + "-" + VERSION.INCREMENTAL));
            String a = com.xiaomi.channel.a.d.a.a(context, a(), arrayList);
            if (!TextUtils.isEmpty(a)) {
                JSONObject jSONObject = new JSONObject(a);
                if (jSONObject.getInt(b.a) == 0) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(b.b);
                    h = new H(jSONObject2.getString(f.U) + "@xiaomi.com/an" + d.a(6), jSONObject2.getString("token"), jSONObject2.getString("ssecurity"), str4, str5, str6, com.xiaomi.channel.a.c.a.c());
                    a(context, h);
                    a = h;
                } else {
                    L.a(context, jSONObject.getInt(b.a), jSONObject.optString(SocialConstants.PARAM_COMMENT));
                    c.a(a);
                }
            }
        }
        return h;
    }

    public static String a() {
        if (com.xiaomi.channel.a.c.a.b()) {
            return "http://10.237.12.17:9085/pass/register";
        }
        return "https://" + (com.xiaomi.channel.a.c.a.a() ? "sandbox.xmpush.xiaomi.com" : "register.xmpush.xiaomi.com") + "/pass/register";
    }

    private static void a(Context context, H h) {
        Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString(g.n, h.a);
        edit.putString(a.o, h.c);
        edit.putString("token", h.b);
        edit.putString(v.u, h.d);
        edit.putString(q.c, h.f);
        edit.putString("app_token", h.e);
        edit.putString(a.ak, G.c(context));
        edit.putInt("env_type", h.g);
        edit.commit();
    }

    public static void b(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        a = null;
    }

    private static boolean c(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }
}
