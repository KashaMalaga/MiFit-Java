package cn.com.smartdevices.bracelet.j;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v7.widget.af;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0595q;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.gps.c.d;
import cn.com.smartdevices.bracelet.lab.sportmode.SportBaseInfo;
import cn.com.smartdevices.bracelet.model.DeviceInfo;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.LoginInfo;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ShareData.TimeType;
import cn.com.smartdevices.bracelet.model.SystemInfo;
import cn.com.smartdevices.bracelet.model.ThirdLoginState;
import cn.com.smartdevices.bracelet.model.UserLocationData;
import cn.com.smartdevices.bracelet.push.i;
import cn.com.smartdevices.bracelet.push.j;
import cn.com.smartdevices.bracelet.relation.db.Friend;
import cn.com.smartdevices.bracelet.relation.db.f;
import cn.com.smartdevices.bracelet.shoes.c;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import cn.com.smartdevices.bracelet.tencent.QQLogin;
import cn.com.smartdevices.bracelet.ui.SettingContainerActivity;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.services.district.DistrictSearchQuery;
import com.c.a.C0993k;
import com.c.a.r;
import com.d.a.a.C1012a;
import com.d.a.a.O;
import com.d.a.a.h;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.xiaomi.hm.health.bt.model.BraceletBtInfo;
import com.xiaomi.hm.health.bt.profile.Weight.WeightHwInfo;
import com.xiaomi.market.sdk.o;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import kankan.wheel.widget.a;
import org.apache.http.Header;

public class l {
    public static String a = "WebAPI";

    public static DeviceInfo a(Context context, int i) {
        if (context == null) {
            return null;
        }
        switch (i) {
            case a.i /*0*/:
                BraceletBtInfo readBraceletBtInfo = Keeper.readBraceletBtInfo();
                String d = cn.com.smartdevices.bracelet.e.a.d(context);
                if (!readBraceletBtInfo.a() || TextUtils.isEmpty(d)) {
                    return null;
                }
                if (TextUtils.isEmpty(readBraceletBtInfo.e)) {
                    return new DeviceInfo(i, d, readBraceletBtInfo.b, readBraceletBtInfo.d, readBraceletBtInfo.a);
                }
                return new DeviceInfo(i, d, readBraceletBtInfo.b, readBraceletBtInfo.d, readBraceletBtInfo.e, readBraceletBtInfo.a);
            case kankan.wheel.widget.l.a /*1*/:
                WeightHwInfo readWeightHwInfo = Keeper.readWeightHwInfo();
                return readWeightHwInfo.isValid() ? new DeviceInfo(i, readWeightHwInfo.deviceId, readWeightHwInfo.address, readWeightHwInfo.fwVersion) : null;
            case a.k /*2*/:
                return new DeviceInfo(i, WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, WeiboAuthException.DEFAULT_AUTH_ERROR_CODE);
            default:
                return null;
        }
    }

    public static void a() {
    }

    public static void a(Context context, LoginData loginData, int i, h hVar) {
        if (loginData.isValid()) {
            O o = new O();
            o.a(g.f, com.xiaomi.e.a.f + loginData.uid);
            o.a(a.o, loginData.security);
            o.a(SettingContainerActivity.a, b.d());
            o.a(o.z, C0401a.b(context));
            String str = com.xiaomi.e.a.f;
            if (i == 1) {
                str = e.a(g.al);
            } else if (i == 2) {
                str = e.a(g.an);
            }
            C0596r.d(a, "tagUrl = " + i + " , url = " + str);
            a.b(d.a, str, o, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(Context context, LoginData loginData, File file, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            try {
                a.a(f.ar, file.getName());
                a.a(f.aq, file);
            } catch (FileNotFoundException e) {
            }
            a(context, a);
            a.b(d.b, e.a(g.j), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    private static void a(Context context, O o) {
        if (context != null && o != null) {
            SystemInfo a = j.a(context);
            if (a != null) {
                o.a(f.ab, a.getMiuiVersionCode());
                o.a(f.ac, a.getMiuiVersionName());
                o.a(f.ad, a.getPhoneBrand());
                o.a(f.ae, a.getPhoneModel());
                o.a(f.af, a.getPhoneSystem());
                o.a(f.ak, a.getSoftVersion());
                if (DeviceSource.hasBindBracelet()) {
                    BraceletBtInfo readBraceletBtInfo = Keeper.readBraceletBtInfo();
                    if (readBraceletBtInfo != null) {
                        o.a(f.ag, readBraceletBtInfo.d);
                    }
                }
                if (DeviceSource.hasBindShoesDevice()) {
                    String a2 = cn.com.smartdevices.bracelet.shoes.data.b.a(context, false);
                    if (!TextUtils.isEmpty(a2)) {
                        o.a(f.aj, c.a(context, a2));
                    }
                }
            }
        }
    }

    public static void a(Context context, h hVar) {
        LoginData f = cn.com.smartdevices.bracelet.e.a.f(context);
        if (f.isValid()) {
            O a = f.a(f);
            a.b(d.b, e.a(g.x), a, hVar);
            return;
        }
        f.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(Context context, h hVar, String str) {
        LoginData f = cn.com.smartdevices.bracelet.e.a.f(context);
        if (f.isValid()) {
            O a = f.a(f);
            a.a(f.au, str);
            a.b(d.a, e.a(g.N), a, hVar);
            return;
        }
        f.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(Context context, String str, h hVar) {
        LoginData f = cn.com.smartdevices.bracelet.e.a.f(context);
        if (f.isValid()) {
            O a = f.a(f);
            a.a(f.bc, str);
            a.b(d.b, e.a(g.P), a, hVar);
            return;
        }
        f.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(Context context, String str, String str2, int i, float f, float f2, int i2, long j, h hVar) {
        LoginData f3 = cn.com.smartdevices.bracelet.e.a.f(context);
        if (f3.isValid()) {
            O a = f.a(f3);
            a.a(g.f, str);
            a.a(WidgetRequestParam.REQ_PARAM_ATTENTION_FUID, str2);
            a.a("goal_type", i);
            a.a("currentval", Float.valueOf(f));
            a.a(d.c, Float.valueOf(f2));
            a.a(f.C, i2);
            a.a("date_time", j);
            String a2 = e.a(g.ag);
            C0596r.e(a, "url for uploadUserWeightGoal " + C1012a.a(true, a2, a));
            a.b(d.b, a2, a, hVar);
            return;
        }
        f3.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(Context context, String str, String str2, int i, long j, h hVar) {
        LoginData f = cn.com.smartdevices.bracelet.e.a.f(context);
        if (f.isValid()) {
            O a = f.a(f);
            a.a(g.f, str);
            a.a(WidgetRequestParam.REQ_PARAM_ATTENTION_FUID, str2);
            a.a("goal_type", i);
            a.a("date_time", j);
            String a2 = e.a(g.ak);
            C0596r.e(a, "url for uploadUserWeightGoal " + C1012a.a(true, a2, a));
            a.b(d.b, a2, a, hVar);
            return;
        }
        f.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(Context context, String str, String str2, int i, String str3, int i2, h hVar) {
        LoginData f = cn.com.smartdevices.bracelet.e.a.f(context);
        if (f.isValid()) {
            O a = f.a(f);
            a.a(g.f, str);
            a.a(WidgetRequestParam.REQ_PARAM_ATTENTION_FUID, str2);
            a.a("goal_type", i);
            a.a("etime", str3);
            a.a("num", i2);
            String a2 = e.a(g.aj);
            C0596r.e(a, "url for getUserWeightGoalList is " + C1012a.a(true, a2, a));
            a.b(d.b, a2, a, hVar);
            return;
        }
        f.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(Context context, String str, String str2, int i, String str3, String str4, h hVar) {
        LoginData f = cn.com.smartdevices.bracelet.e.a.f(context);
        if (f.isValid()) {
            O a = f.a(f);
            a.a(g.f, str);
            a.a("goal_type", i);
            a.a(WidgetRequestParam.REQ_PARAM_ATTENTION_FUID, str2);
            a.a("stime", str3);
            a.a("etime", str4);
            String a2 = e.a(g.ai);
            C0596r.e(a, "url for getUserWeightGoalList is " + C1012a.a(true, a2, a));
            a.b(d.b, a2, a, hVar);
            return;
        }
        f.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(LoginData loginData, int i, int i2, int i3, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a(f.aw, i);
            a.a(cn.com.smartdevices.bracelet.lab.sync.l.c, i2);
            if (i3 == TimeType.DAY.ordinal()) {
                a.a(f.ax, "day");
            } else if (i3 == TimeType.WEEK.ordinal()) {
                a.a(f.ax, cn.com.smartdevices.bracelet.gps.c.a.o.b);
            } else if (i3 == TimeType.MONTH.ordinal()) {
                a.a(f.ax, cn.com.smartdevices.bracelet.gps.c.a.o.a);
            }
            a.b(d.a, e.a(g.B), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(LoginData loginData, int i, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a(f.aQ, i);
            String a2 = e.a(g.C);
            C0596r.e(a, "checkBetaApk, url =" + a2);
            a.b(d.a, a2, a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(LoginData loginData, int i, boolean z, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            if (z) {
                a.a(WidgetRequestParam.REQ_PARAM_ATTENTION_FUID, QQLogin.PERMISSION_ALL);
            } else {
                a.a(WidgetRequestParam.REQ_PARAM_ATTENTION_FUID, i);
            }
            String a2 = e.a(g.ac);
            C0596r.e(a, "Sync UserInfos To Local : " + a2);
            C0596r.e(a, " url tmp syncUserInfosToLocal " + C1012a.a(true, a2, a));
            a.b(d.b, a2, a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(LoginData loginData, long j, int i, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a(f.aG, i + com.xiaomi.e.a.f);
            a.a(ParamKey.OFFSET, j + com.xiaomi.e.a.f);
            a.b(d.a, e.a(g.U), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(LoginData loginData, long j, long j2, int i, boolean z, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a(WidgetRequestParam.REQ_PARAM_ATTENTION_FUID, i);
            if (j > -1) {
                a.a(SportBaseInfo.KEY_START_TIME, j);
            }
            if (j2 > -1) {
                a.a(SportBaseInfo.KEY_END_TIME, j2);
            }
            if (z) {
                a.a(WidgetRequestParam.REQ_PARAM_ATTENTION_FUID, QQLogin.PERMISSION_ALL);
            } else {
                a.a(WidgetRequestParam.REQ_PARAM_ATTENTION_FUID, i);
            }
            a.a(f.aa, 1);
            String a2 = e.a(g.Z);
            C0596r.e(a, "Sync WeightInfos To Local : " + a2);
            a.b(d.b, a2, a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(LoginData loginData, long j, long j2, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a(f.aH, j + com.xiaomi.e.a.f);
            a.a(f.v, (j2 / 1000) + com.xiaomi.e.a.f);
            a.b(d.a, e.a(g.W), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(LoginData loginData, long j, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a(a.n, com.xiaomi.e.a.f + j);
            a.b(d.a, e.a(g.c), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(LoginData loginData, long j, String str, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a(f.aK, j + com.xiaomi.e.a.f);
            a.a(ParamKey.NICK, str);
            a.b(d.a, e.a(g.X), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(LoginData loginData, long j, boolean z, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a(j.i, j + com.xiaomi.e.a.f);
            a.a(LocationManagerProxy.KEY_STATUS_CHANGED, z ? Constants.VIA_TO_TYPE_QQ_GROUP : Constants.VIA_RESULT_SUCCESS);
            a.b(d.a, e.a(g.R), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(LoginData loginData, PersonInfo personInfo, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a(f.E, personInfo.birthday);
            a.a(f.B, com.xiaomi.e.a.f + personInfo.gender);
            a.a(f.C, com.xiaomi.e.a.f + personInfo.height);
            a.a(Friend.d, com.xiaomi.e.a.f + (personInfo.weight * 1000.0f));
            a.a(f.y, personInfo.nickname);
            a.a(f.A, personInfo.avatarUrl);
            a.a(f.G, personInfo.personSignature);
            a.a(f.H, personInfo.sh);
            a.a(f.am, personInfo.age + com.xiaomi.e.a.f);
            a.a(o.x, personInfo.getVersion() + com.xiaomi.e.a.f);
            String readCityCode = Keeper.readCityCode();
            if (!TextUtils.isEmpty(readCityCode)) {
                a.a(DistrictSearchQuery.KEYWORDS_CITY, readCityCode);
            }
            readCityCode = Keeper.readCountryCode();
            if (!TextUtils.isEmpty(readCityCode)) {
                a.a(DistrictSearchQuery.KEYWORDS_COUNTRY, readCityCode);
            }
            C0993k i = new r().i();
            try {
                a.a(LocationManagerProxy.KEY_LOCATION_CHANGED, Utils.c(URLEncoder.encode(i.b(personInfo.location), a.bO)));
                a.a(f.W, Utils.c(URLEncoder.encode(i.b(personInfo.alarmClockItems), a.bO)));
                a.a(i.e, Utils.c(URLEncoder.encode(i.b(personInfo.miliConfig), a.bO)));
                C0596r.d(a, "pInfo.miliConfig = " + personInfo.miliConfig);
                C0596r.e("SCORPIONEAL", "WebAPI updateProfile  gson.toJson(pInfo.miliConfig) " + i.b(personInfo.miliConfig));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            readCityCode = e.a(g.b);
            C0596r.e(a, "updateProfile : " + C1012a.a(true, readCityCode, a));
            if (personInfo.avatarPath == null || (personInfo.getNeedSyncServer() & 1) == 0) {
                a.b(d.a, readCityCode, a, hVar);
                return;
            }
            try {
                a.a(f.h, new File(personInfo.avatarPath));
                a.b(d.a, readCityCode, a, hVar);
                return;
            } catch (FileNotFoundException e2) {
                a.b(d.a, readCityCode, a, hVar);
                return;
            }
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(LoginData loginData, UserLocationData userLocationData, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            try {
                a.a(LocationManagerProxy.KEY_LOCATION_CHANGED, com.xiaomi.e.a.f + URLEncoder.encode(userLocationData.toString(), a.bO));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            a.b(d.a, e.a(g.e), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(LoginData loginData, UserInfo userInfo, boolean z, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a(WidgetRequestParam.REQ_PARAM_ATTENTION_FUID, userInfo.uid);
            a.a(f.C, userInfo.height);
            a.a(QQLogin.KEY_USER_NICKNAME, userInfo.name);
            a.a("brithday", userInfo.birthday);
            a.a(f.B, userInfo.gender);
            if (z) {
                a.a(f.h, new ByteArrayInputStream(userInfo.avatarSource));
            }
            a.a(Friend.d, Float.valueOf(userInfo.weight));
            a.a("targetweight", Float.valueOf(userInfo.targetWeight));
            String a2 = e.a(g.ab);
            C0596r.e(a, "url tmp " + C1012a.a(true, a2, a));
            C0596r.e(a, "Sync UserInfo To Server : " + a2);
            a.b(d.b, a2, a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(LoginData loginData, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.b(d.a, e.a(g.H), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(LoginData loginData, String str, C0595q c0595q, int i, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a(g.t, str);
            a.a(cn.com.smartdevices.bracelet.lab.sync.l.c, com.xiaomi.e.a.f + c0595q.b());
            a.a(o.L, com.xiaomi.e.a.f + c0595q.a());
            a.a(f.as, com.xiaomi.e.a.f + i);
            a.b(d.b, e.a(g.k), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(LoginData loginData, String str, C0595q c0595q, String str2, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a(f.s, str2);
            a.a(g.t, str);
            a.a(cn.com.smartdevices.bracelet.lab.sync.l.c, com.xiaomi.e.a.f + c0595q.b());
            a.a(o.L, com.xiaomi.e.a.f + c0595q.a());
            a.a(f.r, com.xiaomi.e.a.f + str2.length());
            a.a(g.n, Keeper.readUUID());
            a.b(d.a, e.a(g.a), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(LoginData loginData, String str, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            String a2 = e.a(g.G);
            a.a(f.av, str);
            a.b(d.a, a2, a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(LoginData loginData, String str, String str2, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a(com.huami.android.widget.f.a, str);
            a.a(f.Y, str2);
            a.b(d.a, e.a(g.f), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(LoginData loginData, String str, String str2, String str3, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a(g.t, str);
            a.a(f.ao, str2);
            a.a(f.ap, str3);
            a.b(d.a, e.a(g.i), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(LoginData loginData, HashMap<String, String> hashMap, h hVar) {
        if (loginData.isValid()) {
            HashMap a = g.a(loginData);
            a.putAll(hashMap);
            String a2 = e.a(g.b);
            String str = (String) hashMap.get(f.J);
            a.remove(f.J);
            O o = new O();
            for (Entry entry : a.entrySet()) {
                o.a((String) entry.getKey(), (String) entry.getValue());
            }
            if (str == null || str.length() < 1) {
                a.b(d.a, a2, o, hVar);
                return;
            }
            try {
                o.a(f.h, new File(str));
                a.b(d.a, a2, o, hVar);
                return;
            } catch (FileNotFoundException e) {
                a.b(d.a, a2, o, hVar);
                return;
            }
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(LoginInfo loginInfo, String str, h hVar) {
        O o = new O();
        o.a(com.xiaomi.account.openauth.h.I, com.xiaomi.e.a.f + loginInfo.access_token);
        o.a(f.N, loginInfo.expiresIn);
        o.a(f.O, loginInfo.mac_key);
        o.a(f.P, loginInfo.userid);
        o.a(f.T, loginInfo.aliasNick);
        o.a(f.Q, loginInfo.miliaoNick);
        if (loginInfo.miliaoIcon_320 == null || loginInfo.miliaoIcon_320.length() <= 0) {
            o.a(f.R, loginInfo.miliaoIcon);
        } else {
            o.a(f.R, loginInfo.miliaoIcon_320);
        }
        o.a(f.V, loginInfo.friends);
        o.a(g.t, str);
        o.a(f.aa, Constants.VIA_RESULT_SUCCESS);
        o.a(f.aX, loginInfo.refresh_token);
        o.a(g.r, "android_" + VERSION.SDK_INT);
        o.a(SettingContainerActivity.a, b.d());
        String a = e.a(g.d);
        C0596r.e(a, "send login url= " + a + "?" + o.toString());
        a.b(d.a, a, o, hVar);
    }

    public static void a(String str, int i, LoginData loginData, ThirdLoginState thirdLoginState, h hVar) {
        String a = e.a(g.I);
        if (loginData.isValid()) {
            O a2 = f.a(str, loginData, thirdLoginState);
            a2.a(f.aW, i);
            C0596r.d(a, "bindThirdPartyApp url:" + a + " , \n params : " + a2);
            a.b(d.b, a, a2, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(String str, LoginData loginData, ThirdLoginState thirdLoginState, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a(f.av, str);
            a.a(f.aR, thirdLoginState.uid);
            String a2 = e.a(g.J);
            C0596r.d(a, "queryBindStateFromServer url:" + a2 + " \n params:" + a);
            a.b(d.b, a2, a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(String str, LoginData loginData, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a(f.av, str);
            String a2 = e.a(g.L);
            C0596r.d(a, "queryLoginStateFromServer url:" + a2 + " \n params:" + a);
            a.b(d.b, a2, a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(String str, h hVar) {
        a.b(d.a, str, null, hVar);
    }

    public static boolean a(LoginData loginData, File file, String str, String str2, String str3, h hVar) {
        if (loginData.isValid()) {
            Map a = g.a(loginData);
            a.put(f.aA, str);
            a.put(f.aB, str2);
            a.put(f.aD, str3);
            String a2 = e.a(g.O);
            O o = new O();
            for (Entry entry : a.entrySet()) {
                o.a((String) entry.getKey(), (String) entry.getValue());
            }
            try {
                o.a(f.aC, file);
                a.b(d.a, a2, o, hVar);
                return true;
            } catch (FileNotFoundException e) {
                return false;
            }
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
        return false;
    }

    public static void b(Context context, h hVar) {
        LoginData f = cn.com.smartdevices.bracelet.e.a.f(context);
        if (f.isValid()) {
            O a = f.a(f);
            a.b(d.b, e.a(g.y), a, hVar);
            return;
        }
        f.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void b(LoginData loginData, long j, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a(f.aK, j + com.xiaomi.e.a.f);
            String a2 = e.a(g.Q);
            C0596r.e(a, "url:" + a2 + " params:" + a);
            a.b(d.a, a2, a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void b(LoginData loginData, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.b(d.a, e.a(g.E), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void b(LoginData loginData, String str, C0595q c0595q, String str2, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a(f.s, str2);
            a.a(g.t, str);
            a.a(cn.com.smartdevices.bracelet.lab.sync.l.c, com.xiaomi.e.a.f + c0595q.b());
            a.a(o.L, com.xiaomi.e.a.f + c0595q.a());
            a.a(f.r, com.xiaomi.e.a.f + str2.length());
            a.a(g.n, Keeper.readUUID());
            a.b(d.b, e.a(g.a), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void b(LoginData loginData, String str, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            String a2 = e.a(g.F);
            a.a(f.av, str);
            a.b(d.a, a2, a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void b(String str, LoginData loginData, ThirdLoginState thirdLoginState, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(str, loginData, thirdLoginState);
            String a2 = e.a(g.K);
            C0596r.d(a, "uploadToken2Server url:" + a2 + " \n params:" + a);
            a.b(d.b, a2, a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void b(String str, h hVar) {
        O o = new O();
        o.a(com.xiaomi.channel.gamesdk.b.a, str);
        String str2 = b.h().w.booleanValue() ? b.f() + "huami.health.verifycode.json" : b.e() + "huami.health.verifycode.json";
        if (!TextUtils.isEmpty(e.u)) {
            str2 = e.u + "huami.health.verifycode.json";
        }
        C0596r.e(a, "get login code url : " + str2 + "?" + o.toString());
        a.b(d.a, str2, o, hVar);
    }

    public static void c(Context context, h hVar) {
        LoginData f = cn.com.smartdevices.bracelet.e.a.f(context);
        if (f.isValid()) {
            O a = f.a(f);
            a.b(d.a, e.a(g.M), a, hVar);
            return;
        }
        f.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void c(LoginData loginData, long j, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a(f.aK, j + com.xiaomi.e.a.f);
            a.b(d.a, e.a(g.S), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void c(LoginData loginData, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.b(d.a, e.a(g.l), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void c(LoginData loginData, String str, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a(g.t, str);
            a.b(d.a, e.a(g.h), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void d(Context context, h hVar) {
        LoginData f = cn.com.smartdevices.bracelet.e.a.f(context);
        if (f.isValid()) {
            O a = f.a(f);
            a.a(SocialConstants.PARAM_TYPE, 2);
            a.a(ParamKey.COUNT, 100);
            a.a(d.b, e.a(g.P), a, hVar);
            return;
        }
        f.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void d(LoginData loginData, long j, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a(f.aK, j + com.xiaomi.e.a.f);
            a.b(d.a, e.a(g.T), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void d(LoginData loginData, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.b(d.a, e.a(g.v), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void d(LoginData loginData, String str, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a(g.t, str);
            a.b(d.a, e.a(g.D), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void e(Context context, h hVar) {
        O o = new O();
        o.a(DistrictSearchQuery.KEYWORDS_COUNTRY, Locale.getDefault().getCountry());
        o.a(o.p, Utils.A(context));
        o.a(g.r, b.d());
        C0596r.d("getStartingUpInfo", "country = " + Locale.getDefault().getCountry());
        C0596r.d("getStartingUpInfo", "resolution = " + Utils.A(context));
        C0596r.d("getStartingUpInfo", "device = " + b.d());
        a.a(d.a, e.a(g.am), o, hVar);
    }

    public static void e(LoginData loginData, long j, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a(f.aL, j + com.xiaomi.e.a.f);
            a.b(d.a, e.a(g.V), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void e(LoginData loginData, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.b(d.a, e.a(g.w), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void e(LoginData loginData, String str, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a("jsondata", str);
            String a2 = e.a(g.ad);
            C0596r.e(a, "Sync Deleted UserInfos To Server : " + C1012a.a(true, a2, a));
            a.b(d.b, a2, a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void f(LoginData loginData, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.b(d.a, e.a(g.z), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void f(LoginData loginData, String str, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a("jsondata", str);
            a.a(f.aa, 1);
            String a2 = e.a(g.aa);
            C0596r.e(a, "Sync Deleted WeightInfos To Server : " + a2);
            a.b(d.b, a2, a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void g(LoginData loginData, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.b(d.a, e.a(g.A), a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void g(LoginData loginData, String str, h hVar) {
        if (loginData.isValid()) {
            O a = f.a(loginData);
            a.a("jsondata", str);
            a.a(f.aa, 1);
            String a2 = e.a(g.Y);
            C0596r.e(a, "Sync WeightInfos To Server : " + a2);
            a.b(d.b, a2, a, hVar);
            return;
        }
        loginData.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }
}
