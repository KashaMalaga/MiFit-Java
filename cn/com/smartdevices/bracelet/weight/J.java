package cn.com.smartdevices.bracelet.weight;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.j.l;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.SyncResult;
import cn.com.smartdevices.bracelet.relation.db.Friend;
import cn.com.smartdevices.bracelet.tencent.QQLogin;
import com.activeandroid.b.e;
import com.huami.android.widget.a;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.tencent.connect.common.Constants;
import com.xiaomi.channel.gamesdk.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class J {
    private static final String a = "UserInfoManager";
    private static J b;

    private J() {
    }

    public static J a() {
        if (b == null) {
            b = new J();
        }
        return b;
    }

    private String a(String str, UserInfo userInfo) {
        String str2 = null;
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject(b.b);
            if (jSONObject.getInt(WidgetRequestParam.REQ_PARAM_ATTENTION_FUID) == userInfo.uid) {
                str2 = jSONObject.getString("avatar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2;
    }

    private List<UserInfo> b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject(b.b);
            List<UserInfo> arrayList = new ArrayList(jSONObject.getInt("total"));
            JSONArray jSONArray = jSONObject.getJSONArray(a.c);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                UserInfo userInfo = new UserInfo();
                userInfo.uid = jSONObject2.getInt(WidgetRequestParam.REQ_PARAM_ATTENTION_FUID);
                userInfo.height = jSONObject2.getInt(f.C);
                userInfo.gender = jSONObject2.optInt(f.B);
                userInfo.birthday = jSONObject2.optString("brithday");
                userInfo.name = jSONObject2.getString(QQLogin.KEY_USER_NICKNAME);
                userInfo.avatarUrl = jSONObject2.optString("avatar");
                userInfo.weight = Float.valueOf(jSONObject2.optString(Friend.d, Constants.VIA_RESULT_SUCCESS)).floatValue();
                userInfo.targetWeight = Float.valueOf(jSONObject2.optString("targetweight", Constants.VIA_RESULT_SUCCESS)).floatValue();
                if (userInfo.uid == 0) {
                    C0596r.d(a, "Sync UserInfo Id Unknown : " + userInfo);
                } else if (userInfo.uid == -1) {
                    C0596r.d(a, "Sync UserInfo Id Self : " + userInfo);
                } else {
                    arrayList.add(userInfo);
                }
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String e(List<UserInfo> list) {
        String jSONArray;
        String str = com.xiaomi.e.a.f;
        try {
            JSONArray jSONArray2 = new JSONArray();
            for (UserInfo userInfo : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(WidgetRequestParam.REQ_PARAM_ATTENTION_FUID, userInfo.uid);
                jSONArray2.put(jSONObject);
            }
            jSONArray = jSONArray2.toString();
        } catch (Exception e) {
            e.printStackTrace();
            jSONArray = str;
        }
        C0596r.e(a, "Sync Deleted UserInfos : " + jSONArray);
        return jSONArray;
    }

    public static boolean e(UserInfo userInfo) {
        return userInfo.synced == 2;
    }

    public static boolean f(UserInfo userInfo) {
        return userInfo.synced == -2;
    }

    public static boolean g(UserInfo userInfo) {
        return userInfo.synced == 2 || userInfo.synced == -2;
    }

    private int h() {
        UserInfo userInfo = (UserInfo) new e().a(UserInfo.class).g("UserId DESC").e();
        int i = userInfo != null ? userInfo.uid : 0;
        C0596r.d(a, "Lastest UserId : " + i);
        return i;
    }

    private void h(UserInfo userInfo) {
        b(userInfo, false);
    }

    private UserInfo i() {
        PersonInfo readPersonInfoForScale = Keeper.readPersonInfoForScale();
        UserInfo userInfo = new UserInfo();
        userInfo.uid = -1;
        userInfo.height = readPersonInfoForScale.height;
        userInfo.weight = readPersonInfoForScale.weight;
        userInfo.targetWeight = readPersonInfoForScale.targetWeight;
        userInfo.birthday = readPersonInfoForScale.birthday;
        userInfo.gender = readPersonInfoForScale.gender;
        userInfo.name = readPersonInfoForScale.nickname;
        userInfo.avatarUrl = readPersonInfoForScale.avatarUrl;
        userInfo.synced = 1;
        return userInfo;
    }

    public UserInfo a(int i) {
        UserInfo i2;
        if (i == -1) {
            i2 = i();
        } else {
            i2 = (UserInfo) new e().a(UserInfo.class).a("UserId=?", Integer.valueOf(i)).e();
        }
        C0596r.e(a, "Get Info : " + i + ", " + i2);
        return i2;
    }

    public UserInfo a(String str) {
        UserInfo userInfo = null;
        if (str != null) {
            userInfo = (UserInfo) new e().a(UserInfo.class).a("Name=?", str).e();
        }
        C0596r.e(a, "Get Info : " + str + ", " + userInfo);
        return userInfo;
    }

    public List<UserInfo> a(boolean z) {
        com.activeandroid.b.b a = new e().a(UserInfo.class);
        if (!z) {
            Object[] objArr = new Object[]{Integer.valueOf(0)};
            a = a.a("Synced>?", Integer.valueOf(-1)).b("UserId!=?", objArr);
        }
        a.g("UserId ASC");
        List<UserInfo> d = a.d();
        C0596r.e(a, "Get All Infos : " + d.size());
        for (UserInfo userInfo : d) {
            C0596r.e(a, "Get Info : " + userInfo);
        }
        return d;
    }

    public boolean a(Context context) {
        List g = g();
        C0596r.d(a, "Sync with Server 2, to server : " + g.size());
        boolean z = true;
        if (!(g == null || g.isEmpty())) {
            z = true & a(context, g);
        }
        g = f();
        C0596r.d(a, "Sync with Server 3, delete from server : " + g.size());
        return (g == null || g.isEmpty()) ? z : z & b(context, g);
    }

    public boolean a(Context context, UserInfo userInfo) {
        boolean z = true;
        C0596r.e(a, "Sync UserInfo To Server!!");
        if (userInfo == null) {
            C0596r.e(a, "user == null");
            return true;
        } else if (userInfo.uid == 0) {
            C0596r.e(a, "user.uid == userinfo.useridunknown");
            return true;
        } else {
            SyncResult syncResult = new SyncResult();
            if (!TextUtils.isEmpty(userInfo.avatarUrl) || userInfo.avatarSource == null) {
                z = false;
            }
            l.a(cn.com.smartdevices.bracelet.e.a.f(context), userInfo, z, new K(this, context, syncResult, z, userInfo));
            C0596r.e(a, "return result.result " + syncResult.result);
            return syncResult.result;
        }
    }

    public boolean a(Context context, aE aEVar) {
        C0596r.e(a, "Sync UserInfos To Local!!");
        SyncResult syncResult = new SyncResult();
        l.a(cn.com.smartdevices.bracelet.e.a.f(context), -1, true, new L(this, context, syncResult, aEVar));
        return syncResult.result;
    }

    public boolean a(Context context, List<UserInfo> list) {
        C0596r.e(a, "Sync UserInfos To Server!!");
        boolean z = true;
        for (UserInfo a : list) {
            z = !a(context, a) ? false : z;
        }
        return z;
    }

    public boolean a(UserInfo userInfo) {
        return a(userInfo, true);
    }

    public boolean a(UserInfo userInfo, boolean z) {
        if (userInfo.uid == -1) {
            return false;
        }
        if (a(userInfo.name) != null) {
            C0596r.d(a, "User Info : " + userInfo + ", name is already exist!!");
        }
        if (z) {
            userInfo.uid = h() + 1;
        }
        userInfo.save();
        C0596r.d(a, "Add Info : " + userInfo);
        return true;
    }

    public boolean a(List<UserInfo> list) {
        return a((List) list, true);
    }

    public boolean a(List<UserInfo> list, boolean z) {
        boolean z2;
        C0596r.d(a, "Add Infos : " + list.size());
        com.activeandroid.a.d();
        try {
            for (UserInfo a : list) {
                a(a, z);
            }
            com.activeandroid.a.f();
            z2 = true;
        } catch (Exception e) {
            e.printStackTrace();
            z2 = false;
        } finally {
            com.activeandroid.a.e();
        }
        return z2;
    }

    public void b() {
        C0596r.d(a, "Delete All Infos!!");
        new com.activeandroid.b.a().a(UserInfo.class).d();
    }

    public void b(UserInfo userInfo) {
        C0596r.d(a, "Delete Info Mark : " + userInfo);
        userInfo.synced = -1;
        h(userInfo);
    }

    public void b(UserInfo userInfo, boolean z) {
        C0596r.d(a, "Update Info : " + userInfo + ", markUpdated : " + z);
        if (userInfo.uid == -1) {
            PersonInfo readPersonInfo = Keeper.readPersonInfo();
            readPersonInfo.targetWeight = userInfo.targetWeight;
            if (z) {
                readPersonInfo.setNeedSyncServer(2);
            }
            Keeper.keepPersonInfo(readPersonInfo);
        } else if (userInfo.uid != 0) {
            if (z && userInfo.synced == 1) {
                userInfo.synced = 0;
            }
            userInfo.save();
        }
    }

    public void b(List<UserInfo> list) {
        C0596r.d(a, "Delete Infos Mark : " + list.size());
        com.activeandroid.a.d();
        try {
            for (UserInfo b : list) {
                b(b);
            }
            com.activeandroid.a.f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            com.activeandroid.a.e();
        }
    }

    public boolean b(Context context, aE aEVar) {
        boolean z = !Keeper.readScaleSyncedUserInfosFromServer();
        C0596r.e(a, "Sync with Server 1, from server : " + z);
        if (z) {
            return a(context, new N(this, aEVar));
        }
        if (aEVar == null) {
            return true;
        }
        aEVar.a();
        return true;
    }

    public boolean b(Context context, List<UserInfo> list) {
        C0596r.e(a, "Sync Deleted UserInfos To Server!!");
        if (list == null || list.isEmpty()) {
            return true;
        }
        SyncResult syncResult = new SyncResult();
        l.e(cn.com.smartdevices.bracelet.e.a.f(context), e((List) list), new M(this, context, syncResult, list));
        return syncResult.result;
    }

    public int c() {
        int g = new e().a(UserInfo.class).a("Synced>?", Integer.valueOf(-1)).g();
        C0596r.e(a, "Get All Infos Count : " + g);
        return g;
    }

    public void c(UserInfo userInfo) {
        C0596r.d(a, "Delete Info Local : " + userInfo);
        userInfo.delete();
    }

    public void c(List<UserInfo> list) {
        C0596r.d(a, "Delete Infos Local : " + list.size());
        com.activeandroid.a.d();
        try {
            for (UserInfo c : list) {
                c(c);
            }
            com.activeandroid.a.f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            com.activeandroid.a.e();
        }
    }

    public List<UserInfo> d() {
        List<UserInfo> e = e();
        e.add(0, i());
        C0596r.e(a, "Get All Infos With Self : " + e.size());
        return e;
    }

    public void d(UserInfo userInfo) {
        b(userInfo, true);
    }

    public void d(List<UserInfo> list) {
        C0596r.e(a, "Merge UserInfos From Server!!");
        List<UserInfo> g = g();
        if (g != null && g.size() > 0 && list != null && list.size() > 0) {
            Collections.sort(list, new O(this));
            int i = ((UserInfo) list.get(list.size() - 1)).uid;
            C0596r.e(a, "Lastest Server UserId : " + i);
            int i2 = i;
            for (UserInfo userInfo : g) {
                int i3 = 0;
                int i4 = 0;
                int i5 = i2;
                for (UserInfo userInfo2 : list) {
                    if (userInfo.name.equals(userInfo2.name)) {
                        C0596r.e(a, "With Same Name : " + userInfo.name);
                        userInfo2.height = userInfo.height;
                        userInfo2.weight = userInfo.weight;
                        userInfo2.birthday = userInfo.birthday;
                        userInfo2.gender = userInfo.gender;
                        userInfo2.targetWeight = userInfo.targetWeight;
                        if (userInfo.avatarSource != null) {
                            userInfo2.avatarSource = userInfo.avatarSource;
                            userInfo2.avatarUrl = null;
                        }
                        userInfo2.synced = 0;
                        i3 = userInfo2.uid;
                        i2 = 1;
                        int i6 = i3;
                        i3 = i5;
                        i5 = i6;
                    } else {
                        i5++;
                        i2 = i3;
                        i3 = i5;
                    }
                    i4 = i5;
                    i5 = i3;
                    i3 = i2;
                }
                ah a = ah.a();
                List<WeightInfo> a2 = a.a(userInfo.uid);
                if (a2 != null && a2.size() > 0) {
                    for (WeightInfo weightInfo : a2) {
                        weightInfo.uid = i4;
                    }
                    a.d((List) a2);
                }
                if (i3 != 0) {
                    c(userInfo);
                } else {
                    userInfo.uid = i4;
                    h(userInfo);
                }
                i2 = i5;
            }
        }
    }

    public List<UserInfo> e() {
        return a(false);
    }

    public List<UserInfo> f() {
        List<UserInfo> d = new e().a(UserInfo.class).a("Synced=?", Integer.valueOf(-1)).d();
        C0596r.e(a, "Get Infos Deleted : " + d.size());
        for (UserInfo userInfo : d) {
            C0596r.e(a, "Deleted : " + userInfo);
        }
        return d;
    }

    public List<UserInfo> g() {
        List<UserInfo> d = new e().a(UserInfo.class).a("Synced=?", Integer.valueOf(0)).d();
        C0596r.e(a, "Get Infos NeedSync : " + d.size());
        for (UserInfo userInfo : d) {
            C0596r.e(a, "NeedSync : " + userInfo);
        }
        return d;
    }
}
