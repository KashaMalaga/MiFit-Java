package cn.com.smartdevices.bracelet.j;

import android.content.Context;
import android.os.Build.VERSION;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.lab.sportmode.SportBaseInfo;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.ui.SettingContainerActivity;
import com.amap.api.services.district.DistrictSearchQuery;
import com.tencent.open.SocialConstants;
import com.xiaomi.e.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;

public class g extends e {
    public static final String A = "huami.health.loginout.json";
    public static final String B = "huami.health.queryRecordRank.json";
    public static final String C = "huami.health.apk.upgrade.detect.json";
    public static final String D = "wxunbind.json";
    public static final String E = "huami.health.getThirdAppList.json";
    public static final String F = "huami.health.cancelAuthorization.json";
    public static final String G = "huami.health.authorizeThirdApp.json";
    public static final String H = "huami.health.fetchThirdAppData.json";
    public static final String I = "huami.partner.bindThirdApp.json";
    public static final String J = "huami.partner.checkBindStatus.json";
    public static final String K = "huami.partner.updateAppToken.json";
    public static final String L = "huami.partner.getAppToken.json";
    public static final String M = "huami.health.getUserLazyDay.json";
    public static final String N = "huami.health.setUserLazyDay.json";
    public static final String O = "huami.health.uploadTag.json";
    public static final String P = "v1/data/heart_rate.json";
    public static final String Q = "huami.health.band.userFriend.remindFriend.json";
    public static final String R = "huami.health.band.pushMessage.acceptInvitation.json";
    public static final String S = "huami.health.band.userFriend.removeRelationship.json";
    public static final String T = "huami.health.band.pushMessage.sendInvitation.json";
    public static final String U = "huami.health.band.userFriend.getFriendList.json";
    public static final String V = "huami.health.band.userBasicInfo.searchUser.json";
    public static final String W = "huami.health.band.userFriend.getUserFriendInfo.json";
    public static final String X = "huami.health.band.userFriend.updateFriendNick.json";
    public static final String Y = "huami.health.scale.save.json";
    public static final String Z = "huami.health.scale.get.json";
    public static final String a = "huami.health.receiveData.json";
    public static final String aa = "huami.health.scale.delete.json";
    public static final String ab = "huami.health.scale.familymember.save.json";
    public static final String ac = "huami.health.scale.familymember.get.json";
    public static final String ad = "huami.health.scale.familymember.delete.json";
    public static final String ae = "huami.health.scale.device.save.json";
    public static final String af = "huami.health.scale.device.get.json";
    public static final String ag = "huami.health.scale.usergoal.saveusergoal.json";
    public static final String ah = "huami.health.scale.usergoal.getusergoal.json";
    public static final String ai = "huami.health.scale.usergoal.getusergoallist.json";
    public static final String aj = "huami.health.scale.usergoal.getusergoallast.json";
    public static final String ak = "huami.health.scale.usergoal.deleteusergoal.json";
    public static final String al = "huami.health.addLoginTag.json";
    public static final String am = "huami.health.getStartPageList.json";
    public static final String an = "v1/device/active_history.json";
    public static final String b = "huami.health.bindProfile.json";
    public static final String c = "huami.health.getUserInfo.json";
    public static final String d = "huami.health.apklogin.json";
    public static final String e = "huami.health.backup.json";
    public static final String f = "huami.health.report.json";
    public static final String g = "huami.health.updatedevicedata.json";
    public static final String h = "huami.health.createwxqr.json";
    public static final String i = "huami.health.uploadcollectdata.json";
    public static final String j = "huami.health.uploadlogdata.json";
    public static final String k = "huami.health.getDataNew.json";
    public static final String l = "huami.health.getluapackdata.json";
    public static final String v = "huami.health.getlatestluaversion.json";
    public static final String w = "huami.health.getlatestluaversionlist.json";
    public static final String x = "huami.health.gethuodongconfig.json";
    public static final String y = "huami.health.detectuserwhetherjoinhuodong.json";
    public static final String z = "huami.health.getSysTime.json";

    private static String a(String str, String str2) {
        return b.e() + str + str2;
    }

    public static String a(String str, HashMap<String, String> hashMap) {
        return a(str, a(h.a((Map) hashMap)));
    }

    public static String a(HashMap<String, String> hashMap) {
        Iterator it = hashMap.entrySet().iterator();
        String str = "?";
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            String str2 = ((str + ((String) entry.getKey())) + "=") + ((String) entry.getValue());
            if (it.hasNext()) {
                str2 = str2 + "&";
            }
            str = str2;
        }
        return str;
    }

    public static HashMap<String, String> a(LoginData loginData) {
        HashMap<String, String> hashMap = new HashMap();
        b h = b.h();
        hashMap.put(cn.com.smartdevices.bracelet.shoes.sync.b.g.f, a.f + loginData.uid);
        hashMap.put(kankan.wheel.widget.a.o, loginData.security);
        String str = SportBaseInfo.VERSION;
        h.getClass();
        hashMap.put(str, "1.0");
        hashMap.put(SocialConstants.PARAM_APP_ID, a.f + h.b.a);
        hashMap.put(f.c, a.f + System.currentTimeMillis());
        hashMap.put(f.e, Locale.getDefault().getLanguage());
        hashMap.put(DistrictSearchQuery.KEYWORDS_COUNTRY, Locale.getDefault().getCountry());
        hashMap.put(f.j, TimeZone.getDefault().getID());
        hashMap.put(com.g.a.b.b.c, TimeZone.getDefault().getID());
        hashMap.put(cn.com.smartdevices.bracelet.shoes.sync.b.g.r, "android_" + VERSION.SDK_INT);
        hashMap.put(SettingContainerActivity.a, b.d());
        hashMap.put(f.l, b.b() + "_" + b.a());
        return hashMap;
    }

    public static Map<String, String> a(Context context) {
        b h = b.h();
        LoginData f = cn.com.smartdevices.bracelet.e.a.f(context);
        Map<String, String> hashMap = new HashMap();
        hashMap.put(cn.com.smartdevices.bracelet.shoes.sync.b.g.f, a.f + f.uid);
        hashMap.put(kankan.wheel.widget.a.o, f.security);
        String str = SportBaseInfo.VERSION;
        h.getClass();
        hashMap.put(str, "1.0");
        hashMap.put(SocialConstants.PARAM_APP_ID, a.f + h.b.a);
        hashMap.put(f.c, a.f + System.currentTimeMillis());
        hashMap.put(f.e, Locale.getDefault().getLanguage());
        hashMap.put(f.j, TimeZone.getDefault().getID());
        hashMap.put(com.g.a.b.b.c, b.c());
        hashMap.put(SettingContainerActivity.a, b.d());
        hashMap.put(cn.com.smartdevices.bracelet.shoes.sync.b.g.r, "android_" + VERSION.SDK_INT);
        hashMap.put(f.l, b.b() + "_" + b.a());
        return hashMap;
    }

    public static String b(String str, HashMap<String, String> hashMap) {
        return a(str, a(h.b((Map) hashMap)));
    }
}
