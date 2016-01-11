package cn.com.smartdevices.bracelet.j;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.d.F;
import cn.com.smartdevices.bracelet.gps.sync.C0483q;
import cn.com.smartdevices.bracelet.model.BasicDateData;
import cn.com.smartdevices.bracelet.model.LoginInfo;
import cn.com.smartdevices.bracelet.model.MiliConfig;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.SyncedServerDataInfo;
import cn.com.smartdevices.bracelet.model.UserLocationData;
import cn.com.smartdevices.bracelet.push.i;
import cn.com.smartdevices.bracelet.relation.db.Friend;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.amap.api.location.LocationManagerProxy;
import com.huami.android.widget.a;
import com.tencent.open.SocialConstants;
import com.xiaomi.account.openauth.h;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.market.sdk.o;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class m {
    private static String a = "WebRes";

    public static n a(Context context, int i, String str, ArrayList<BasicDateData> arrayList) {
        n a;
        n nVar = new n();
        try {
            C0596r.b(a, "parseDownload:\n" + str);
            JSONObject jSONObject = new JSONObject(str);
            a = n.a(context, jSONObject);
            try {
                if (a.c()) {
                    JSONArray jSONArray;
                    JSONObject jSONObject2 = jSONObject.getJSONObject(b.b);
                    if (!jSONObject2.isNull(g.o)) {
                        jSONArray = jSONObject2.getJSONArray(g.o);
                        SyncedServerDataInfo syncedServerDataInfo = new SyncedServerDataInfo(i);
                        if (jSONArray.length() == 2) {
                            syncedServerDataInfo.setState(2);
                            syncedServerDataInfo.setStartDate(jSONArray.getString(0));
                            syncedServerDataInfo.setStopDate(jSONArray.getString(1));
                        } else {
                            syncedServerDataInfo.setState(1);
                        }
                        syncedServerDataInfo.saveInfo();
                    }
                    jSONArray = jSONObject2.getJSONArray(a.c);
                    int length = jSONArray.length();
                    SyncedServerDataInfo syncedServerDataInfo2 = new SyncedServerDataInfo(i);
                    if (length > 0) {
                        syncedServerDataInfo2.setState(2);
                        syncedServerDataInfo2.setStartDate(jSONArray.getJSONObject(0).getString(g.a));
                        syncedServerDataInfo2.setStopDate(jSONArray.getJSONObject(length - 1).getString(g.a));
                    } else {
                        syncedServerDataInfo2.setState(1);
                    }
                    syncedServerDataInfo2.saveInfo();
                    arrayList.ensureCapacity(length);
                    for (int i2 = 0; i2 < length; i2++) {
                        arrayList.add(a(jSONArray.getJSONObject(i2), 0));
                    }
                }
            } catch (JSONException e) {
                e = e;
                a.h = 2;
                C0596r.d(a, e.getMessage());
                return a;
            }
        } catch (JSONException e2) {
            JSONException e3;
            JSONException jSONException = e2;
            a = nVar;
            e3 = jSONException;
            a.h = 2;
            C0596r.d(a, e3.getMessage());
            return a;
        }
        return a;
    }

    public static n a(Context context, String str, PersonInfo personInfo) {
        n a;
        JSONException e;
        n nVar = new n();
        try {
            JSONObject jSONObject = new JSONObject(str);
            a = n.a(context, jSONObject);
            try {
                if (a.c()) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(b.b);
                    if (jSONObject2 != null) {
                        String optString = jSONObject2.optString("avatar");
                        if (optString.length() > 0) {
                            personInfo.avatarUrl = optString;
                        }
                        C0596r.e(a, "get avatar Url: " + optString);
                    } else {
                        a.h = 2;
                    }
                }
            } catch (JSONException e2) {
                e = e2;
                a.h = 2;
                C0596r.e(a, e.getMessage());
                return a;
            }
        } catch (JSONException e3) {
            JSONException jSONException = e3;
            a = nVar;
            e = jSONException;
            a.h = 2;
            C0596r.e(a, e.getMessage());
            return a;
        }
        return a;
    }

    public static n a(Context context, String str, ArrayList<PersonInfo> arrayList) {
        n a;
        Exception e;
        C0596r.f(a, "parseFriendList:" + str);
        n nVar = new n();
        try {
            JSONObject jSONObject = new JSONObject(str);
            a = n.a(context, jSONObject);
            try {
                if (a.c()) {
                    JSONArray jSONArray = jSONObject.getJSONObject(b.b).getJSONArray(a.c);
                    int length = jSONArray.length();
                    arrayList.ensureCapacity(length);
                    for (int i = 0; i < length; i++) {
                        PersonInfo a2 = a(jSONArray.getJSONObject(i));
                        arrayList.add(a2);
                        C0596r.e(a, a2.toString());
                    }
                }
            } catch (Exception e2) {
                e = e2;
                a.h = 2;
                C0596r.e(a, e.getMessage());
                return a;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            a = nVar;
            e = exception;
            a.h = 2;
            C0596r.e(a, e.getMessage());
            return a;
        }
        return a;
    }

    private static BasicDateData a(JSONObject jSONObject, int i) {
        BasicDateData basicDateData = new BasicDateData();
        basicDateData.date = jSONObject.getString(g.a);
        basicDateData.summary = jSONObject.getString(SocialConstants.PARAM_SUMMARY);
        basicDateData.type = i;
        if (!jSONObject.isNull(o.L)) {
            Object string = jSONObject.getString(o.L);
            if (!TextUtils.isEmpty(string)) {
                basicDateData.source = Integer.valueOf(string).intValue();
            }
        }
        if (!jSONObject.isNull(b.b)) {
            basicDateData.data = Base64.decode(jSONObject.getString(b.b), 2);
        }
        if (!jSONObject.isNull(F.i)) {
            basicDateData.dataHR = Base64.decode(jSONObject.getString(F.i), 2);
        }
        if (!jSONObject.isNull(F.j)) {
            basicDateData.summaryHR = jSONObject.getString(F.j);
        }
        return basicDateData;
    }

    public static LoginInfo a(LoginInfo loginInfo, String str) {
        LoginInfo loginInfo2 = loginInfo == null ? new LoginInfo() : loginInfo;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optString(C0483q.g).equals("ok")) {
                jSONObject = jSONObject.optJSONObject(b.b);
                if (jSONObject != null) {
                    loginInfo2.aliasNick = jSONObject.optString(f.T);
                    loginInfo2.miliaoNick = jSONObject.optString(f.Q);
                    loginInfo2.userid = jSONObject.optLong(f.U);
                    loginInfo2.miliaoIcon = jSONObject.optString(f.R);
                    loginInfo2.miliaoIcon_320 = jSONObject.optString(f.S);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return loginInfo2;
    }

    public static PersonInfo a(String str, PersonInfo personInfo) {
        try {
            a(new JSONObject(Utils.e(str)), personInfo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return personInfo;
    }

    private static PersonInfo a(JSONObject jSONObject) {
        PersonInfo personInfo = new PersonInfo();
        if (jSONObject.has(kankan.wheel.widget.a.n) && jSONObject.getString(kankan.wheel.widget.a.n).length() > 0) {
            personInfo.uid = jSONObject.getLong(kankan.wheel.widget.a.n);
        }
        personInfo.nickname = jSONObject.getString(Friend.c);
        if (jSONObject.has(f.B) && jSONObject.getString(f.B).length() > 0) {
            personInfo.gender = jSONObject.getInt(f.B);
        }
        if (jSONObject.has(f.C) && jSONObject.getString(f.C).length() > 0) {
            personInfo.height = jSONObject.getInt(f.C);
        }
        if (jSONObject.has(Friend.d) && jSONObject.getString(Friend.d).length() > 0) {
            personInfo.weight = (float) jSONObject.getInt(Friend.d);
        }
        personInfo.avatarUrl = jSONObject.getString("avatar");
        personInfo.birthday = jSONObject.getString(f.E);
        String[] split = personInfo.birthday.split("-");
        int i = Calendar.getInstance().get(1);
        if (split[0] != null && split[0].length() > 0) {
            personInfo.age = i - Integer.parseInt(split[0]);
        }
        personInfo.location = UserLocationData.fromJsonStr(jSONObject.optString(LocationManagerProxy.KEY_LOCATION_CHANGED));
        personInfo.source = jSONObject.getString(o.L);
        if (jSONObject.has(LocationManagerProxy.KEY_STATUS_CHANGED) && jSONObject.getString(LocationManagerProxy.KEY_STATUS_CHANGED).length() > 0) {
            personInfo.state = jSONObject.getInt(LocationManagerProxy.KEY_STATUS_CHANGED);
        }
        if (jSONObject.has("gid") && jSONObject.getString("gid").length() > 0) {
            personInfo.gid = jSONObject.getInt("gid");
        }
        personInfo.personSignature = jSONObject.getString(o.g);
        personInfo.pinyin = com.xiaomi.e.a.f;
        return personInfo;
    }

    public static String a(Context context, String str) {
        String str2 = null;
        C0596r.f(a, "parseWeixinQR:" + str);
        n nVar = new n();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (n.a(context, jSONObject).c()) {
                jSONObject = jSONObject.getJSONObject(b.b);
                if (jSONObject != null) {
                    str2 = jSONObject.getString(a.c);
                }
            }
        } catch (JSONException e) {
            C0596r.e(a, e.getMessage());
        }
        return str2;
    }

    public static String a(String str) {
        if (str == null) {
            return com.xiaomi.e.a.f;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.optString(C0483q.g).equals("ok")) {
                return com.xiaomi.e.a.f;
            }
            jSONObject = jSONObject.optJSONObject(b.b);
            if (jSONObject != null) {
                return jSONObject.optString("phone");
            }
            return com.xiaomi.e.a.f;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void a(JSONObject jSONObject, PersonInfo personInfo) {
        C0596r.e(a, "parseUserInfo dataObj:" + jSONObject.toString());
        if (jSONObject.length() == 0) {
            C0596r.e(a, "parseUserInfo dataObj is null");
            return;
        }
        if (jSONObject.has(kankan.wheel.widget.a.n) && jSONObject.getString(kankan.wheel.widget.a.n).length() > 0) {
            personInfo.uid = jSONObject.getLong(kankan.wheel.widget.a.n);
        }
        if (personInfo.getNeedSyncServer() != 0) {
            C0596r.e(a, "\n Person info not synced to server, so we skip parse from server! \n");
            return;
        }
        if (jSONObject.has(f.C) && jSONObject.getString(f.C).length() > 0) {
            personInfo.height = jSONObject.getInt(f.C);
        }
        if (jSONObject.has(Friend.d) && jSONObject.getString(Friend.d).length() > 0) {
            int i = jSONObject.getInt(Friend.d);
            if (i > h.E) {
                personInfo.weight = new BigDecimal((double) (((float) i) / 1000.0f)).setScale(1, 4).floatValue();
            } else {
                personInfo.weight = (float) i;
            }
        }
        if (jSONObject.has("weight_float") && jSONObject.getString("weight_float").length() > 0) {
            personInfo.weight = (float) jSONObject.getDouble("weight_float");
        }
        if (jSONObject.has(f.B) && jSONObject.getString(f.B).length() > 0) {
            personInfo.gender = jSONObject.getInt(f.B);
        }
        if (jSONObject.has(f.y) && jSONObject.optString(f.y).length() > 0) {
            personInfo.nickname = jSONObject.getString(f.y);
        }
        personInfo.lastLoginTime = jSONObject.getString("last_login_time");
        personInfo.createTime = jSONObject.getString("creat_time");
        personInfo.birthday = jSONObject.getString(f.E);
        personInfo.avatarUrl = jSONObject.getString("avatar");
        UserLocationData fromJsonStr = UserLocationData.fromJsonStr(jSONObject.optString(LocationManagerProxy.KEY_LOCATION_CHANGED));
        if (fromJsonStr != null && fromJsonStr.isValid()) {
            personInfo.location = fromJsonStr;
        }
        MiliConfig fromJsonStr2 = MiliConfig.fromJsonStr(Utils.f(jSONObject.optString(i.e)));
        if (fromJsonStr2 != null && fromJsonStr2.isValid()) {
            personInfo.setMiliConfig(fromJsonStr2);
            C0596r.d(a, "miliConfig=" + fromJsonStr2);
        }
        ArrayList parseAlarmClockItems = PersonInfo.parseAlarmClockItems(Utils.f(jSONObject.optString(f.W)));
        if (parseAlarmClockItems != null) {
            personInfo.alarmClockItems = parseAlarmClockItems;
        }
        personInfo.age = jSONObject.optInt(f.am);
        personInfo.setVersion(jSONObject.optInt(o.x));
        personInfo.personSignature = jSONObject.getString(o.g);
    }

    public static LoginInfo b(LoginInfo loginInfo, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optString(C0483q.g).equals("ok")) {
                jSONObject = jSONObject.optJSONObject(b.b);
                if (jSONObject != null) {
                    loginInfo.friends = jSONObject.optString(f.V);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return loginInfo;
    }
}
