package cn.com.smartdevices.bracelet;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.h.e;
import cn.com.smartdevices.bracelet.model.MiliConfig;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ReportInfo;
import cn.com.smartdevices.bracelet.model.StartingUpResInfo;
import cn.com.smartdevices.bracelet.model.SwitchOperator;
import cn.com.smartdevices.bracelet.model.UserLocationData;
import cn.com.smartdevices.bracelet.model.UserTotalSportData;
import cn.com.smartdevices.bracelet.ui.C0810j;
import com.c.a.C0993k;
import com.xiaomi.hm.health.bt.b.c;
import com.xiaomi.hm.health.bt.model.AlarmClockItem;
import com.xiaomi.hm.health.bt.model.BraceletBtInfo;
import com.xiaomi.hm.health.bt.profile.Weight.WeightHwInfo;
import com.xiaomi.market.sdk.o;
import com.xiaomi.mipush.sdk.f;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import kankan.wheel.widget.a;

public class Keeper {
    public static final String CURRENT_USER_BIRTH = "CURRENT_USER_BIRTH";
    public static final String CURRENT_USER_GENDER = "CURRENT_USER_GENDER";
    public static final String CURRENT_USER_HEIGHT = "CURRENT_USER_HEIGHT";
    public static final String CURRENT_USER_ID = "CURRENT_USER_ID";
    public static final String CURRENT_USER_NAME = "CURRENT_USER_NAME";
    private static final String REF_MORING_ALARMS = "REF_MORING_ALARMS";
    private static final String TAG = "Keeper";
    private static SharedPreferences sp = null;

    public static void KeepLastMonthReportDate(String str) {
        Editor edit = sp.edit();
        edit.putString("LastMonthReportDate", str);
        edit.commit();
    }

    public static void KeepLastWeekReportDate(String str) {
        Editor edit = sp.edit();
        edit.putString("LastWeekReportDate", str);
        edit.commit();
    }

    public static void clearFeatureVisited() {
        Editor edit = sp.edit();
        edit.remove(Constant.cP);
        edit.commit();
    }

    public static void clearPersonInfo() {
        keepPersonInfo(new PersonInfo());
        Editor edit = sp.edit();
        edit.putString(a.J, com.xiaomi.e.a.f);
        edit.putString(a.G, com.xiaomi.e.a.f);
        edit.putString(a.H, com.xiaomi.e.a.f);
        edit.commit();
    }

    public static int getActiveHistory() {
        return sp.getInt("active_history_state", 0);
    }

    public static String getCurrentUserInfoByTag(String str) {
        return sp.getString(str, com.xiaomi.e.a.f);
    }

    public static String getDebugChannel() {
        return sp.getString("debug_channel", Constant.g);
    }

    public static String getDebugHost() {
        return sp.getString("debug_host", com.xiaomi.e.a.f);
    }

    public static int getEnterAppTrace() {
        return sp.getInt("enter_app_trace", 0);
    }

    public static boolean getHRIfDirection() {
        return sp.getBoolean(Constant.dl, false);
    }

    public static boolean getNeedBabyWeightRemind() {
        return sp.getBoolean("baby_weight_notify", true);
    }

    public static String getPartnerEtag() {
        return sp.getString(Constant.Y, null);
    }

    public static boolean getRssiLayoutVisible() {
        return sp.getBoolean("rssi_visible", false);
    }

    public static int getRssiSignal() {
        return sp.getInt("rssi_signal", 0);
    }

    public static long getServiceUpdateTime() {
        return sp.getLong(a.R, 0);
    }

    public static SharedPreferences getSharedPref() {
        return sp;
    }

    public static List<StartingUpResInfo> getStartupList() {
        return (List) new C0993k().a(sp.getString("startingup_list", com.xiaomi.e.a.f), new C0889x().getType());
    }

    public static int getSyncBraceletInfoToServer() {
        return sp.getInt("flag_bracelet_info_server", 0);
    }

    public static int getSyncWeightInfoToServer() {
        return sp.getInt("flag_weight_info_server", 0);
    }

    public static int getUploadImeiStatus() {
        return sp.getInt("upload_imei_status", -1);
    }

    public static void init(Context context) {
        sp = context.getSharedPreferences(a.m, 0);
    }

    public static void keep24HourFormat(boolean z) {
        Editor edit = sp.edit();
        edit.putBoolean(Constant.aO, z);
        edit.apply();
    }

    public static void keepAlarms(ArrayList<AlarmClockItem> arrayList) {
        Editor edit = sp.edit();
        String b = Utils.c().b((Object) arrayList);
        C0596r.e(TAG, "alarmStr =" + b);
        if (b == null || "null".equals(b)) {
            b = com.xiaomi.e.a.f;
        }
        edit.putString(a.al, b);
        edit.commit();
    }

    public static void keepApkVersion(String str) {
        Editor edit = sp.edit();
        edit.putString("APKVersion", str);
        edit.commit();
    }

    public static void keepBraceletBtInfo(BraceletBtInfo braceletBtInfo) {
        Editor edit = sp.edit();
        edit.putString(a.t, braceletBtInfo.c);
        if (braceletBtInfo.b != null) {
            edit.putString(a.u, braceletBtInfo.b);
        }
        if (braceletBtInfo.d != null) {
            edit.putString(Constant.z, braceletBtInfo.d);
        }
        if (braceletBtInfo.e != null) {
            edit.putString(Constant.A, braceletBtInfo.e);
        }
        edit.putInt(Constant.B, braceletBtInfo.a);
        edit.commit();
    }

    public static void keepBraceletStatisticTime(long j) {
        Editor edit = sp.edit();
        edit.putLong("bracelet_statistic_time", j);
        edit.commit();
    }

    public static void keepCheckUpdateApkDate() {
        Object instance = Calendar.getInstance();
        Editor edit = sp.edit();
        edit.putString(C0810j.b, Utils.c().b(instance));
        edit.commit();
    }

    public static void keepCityCode(String str) {
        Editor edit = sp.edit();
        edit.putString(Constant.cQ, str);
        edit.apply();
    }

    public static void keepConfigDynamicDataInfo(String str) {
        Editor edit = sp.edit();
        edit.putString("configDynamicDataInfo", str);
        edit.commit();
    }

    public static void keepContinueReachGoalRi(ReportInfo reportInfo) {
        Editor edit = sp.edit();
        edit.putString("continue_reach_goal_date_from", reportInfo.dateFrom);
        edit.putString("continue_reach_goal_date_to", reportInfo.dateFrom);
        edit.commit();
    }

    public static void keepCountryCode(String str) {
        Editor edit = sp.edit();
        edit.putString(Constant.cR, str);
        edit.apply();
    }

    public static void keepDailySportReport(String str) {
        Editor edit = sp.edit();
        edit.putString(Constant.cM, str);
        edit.apply();
    }

    public static void keepDownloadApkId(long j) {
        Editor edit = sp.edit();
        edit.putLong(C0810j.a, j);
        edit.commit();
    }

    public static void keepEnableRtHeartrate(boolean z) {
        Editor edit = sp.edit();
        edit.putBoolean("enable_realtime_heartrate", z);
        edit.apply();
    }

    public static void keepFeatureVisited(String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.indexOf(44) > 0 ? str.split(f.i) : new String[]{str};
            String readFeatureVisited = readFeatureVisited();
            StringBuffer stringBuffer = new StringBuffer();
            if (!TextUtils.isEmpty(readFeatureVisited)) {
                stringBuffer.append(readFeatureVisited);
            }
            int length = split.length;
            while (i < length) {
                String str2 = split[i];
                if (!readFeatureVisited.contains(str2)) {
                    if (stringBuffer.length() <= 0) {
                        stringBuffer.append(str2);
                    } else {
                        stringBuffer.append(f.i).append(str2);
                    }
                }
                i++;
            }
            Editor edit = sp.edit();
            edit.putString(Constant.cP, stringBuffer.toString());
            edit.commit();
        }
    }

    public static void keepFwUpgradeFlag(boolean z) {
        Editor edit = sp.edit();
        edit.putBoolean("fw_update_flag", z);
        edit.commit();
    }

    public static void keepGameFailed(boolean z) {
        Editor edit = sp.edit();
        edit.putBoolean(a.ce, z);
        edit.commit();
    }

    public static void keepIsPlayEnterAnimation(Boolean bool) {
        Editor edit = sp.edit();
        edit.putBoolean("isPlayEnterAnimation", bool.booleanValue());
        edit.commit();
    }

    public static void keepLastBinded(boolean z) {
        Editor edit = sp.edit();
        edit.putBoolean(a.cr, z);
        edit.commit();
    }

    public static void keepLastCaclMedalTime(Long l) {
        Editor edit = sp.edit();
        edit.putLong("lastCaclMedalTime", l.longValue());
        edit.apply();
    }

    public static void keepLastWelcomeDate(String str) {
        Editor edit = sp.edit();
        edit.putString(a.cs, str);
        edit.commit();
    }

    public static void keepLatestDBLuaVersion(String str) {
        Editor edit = sp.edit();
        edit.putString("latestDBLuaVersion", str);
        edit.commit();
    }

    public static String keepLazyDays(String str) {
        Editor edit = sp.edit();
        edit.putString(a.ch, str);
        C0596r.e(TAG, "keepLazyDays :" + str);
        edit.commit();
        return str;
    }

    public static String keepLocaleStr() {
        Locale locale = Locale.getDefault();
        Editor edit = sp.edit();
        edit.putString("Locale", locale.toString());
        edit.commit();
        return locale.toString();
    }

    public static void keepLowBatteryNofityLevel(int i) {
        Editor edit = sp.edit();
        edit.putInt("low_battery_level", i);
        edit.commit();
    }

    public static void keepLuaItem(String str) {
        Editor edit = sp.edit();
        edit.putString(a.cm, str);
        edit.commit();
    }

    public static void keepManualLazyDayAlgoStartDate(String str) {
        Editor edit = sp.edit();
        edit.putString(a.cj, str);
        C0596r.e(TAG, "keepLazyDays algo start date:" + str);
        edit.commit();
    }

    public static void keepMorningAlarms(String str) {
        Editor edit = sp.edit();
        edit.putString(REF_MORING_ALARMS, str);
        edit.commit();
    }

    public static void keepNeedBind(int i) {
        Editor edit = sp.edit();
        edit.putInt("bind_state", i);
        edit.commit();
    }

    public static void keepPersonInfo(PersonInfo personInfo) {
        Editor edit = sp.edit();
        edit.putString(a.v, personInfo.nickname);
        edit.putString(a.w, personInfo.avatarUrl);
        edit.putString(a.x, personInfo.avatarPath);
        edit.putInt(a.D, personInfo.age);
        edit.putInt(a.C, personInfo.gender);
        edit.putInt(a.z, personInfo.height);
        edit.remove(a.A);
        edit.putFloat(a.A, personInfo.weight);
        edit.putFloat(a.B, personInfo.targetWeight);
        edit.putLong(a.y, personInfo.uid);
        edit.putString(a.E, personInfo.personSignature);
        edit.putString(a.F, personInfo.sh);
        edit.putString(a.ak, personInfo.deviceId);
        edit.putInt(a.I, personInfo.getNeedSyncServer());
        edit.putString(a.K, personInfo.getBirthday());
        if (personInfo.miliConfig != null && personInfo.miliConfig.isValid()) {
            edit.putString(a.J, personInfo.miliConfig.toString());
        }
        if (personInfo.location != null && personInfo.location.isValid()) {
            edit.putString(a.G, personInfo.location.toString());
        }
        if (personInfo.totalSportData != null && personInfo.totalSportData.isValid()) {
            edit.putString(a.H, personInfo.totalSportData.toString());
        }
        edit.commit();
        keepAlarms(personInfo.alarmClockItems);
    }

    public static void keepPlayEnterAnimationType(int i) {
        Editor edit = sp.edit();
        edit.putInt("PlayEnterAnimationType", i);
        edit.commit();
    }

    public static void keepPushAlias(String str) {
        Editor edit = sp.edit();
        edit.putString(a.M, str);
        edit.commit();
    }

    public static void keepPushIntentUri(String str) {
        Editor edit = sp.edit();
        edit.putString(a.cn, str);
        edit.commit();
    }

    public static void keepRealtimeSteps(int i, int i2) {
        if (i2 == c.SHOES.b()) {
            cn.com.smartdevices.bracelet.shoes.c.a(BraceletApp.a(), i);
            return;
        }
        Editor edit = sp.edit();
        edit.putInt(a.r, i);
        edit.commit();
    }

    public static void keepRealtimeStepsTimestamp(long j, int i) {
        if (i == c.SHOES.b()) {
            cn.com.smartdevices.bracelet.shoes.c.c(BraceletApp.a(), j);
            return;
        }
        Editor edit = sp.edit();
        edit.putLong(a.q, j);
        edit.commit();
    }

    public static void keepScaleSyncedUserInfosFromServer(boolean z) {
        Editor edit = sp.edit();
        edit.putBoolean("ScaleSyncedUserInfosFromServer", z);
        edit.commit();
    }

    public static void keepScaleSyncedWeightInfosFromServer(boolean z) {
        Editor edit = sp.edit();
        edit.putBoolean("ScaleSyncedWeightInfosFromServer", z);
        edit.commit();
    }

    public static void keepSensorHubInfo(e eVar) {
        Editor edit = sp.edit();
        edit.putLong("sensorhub_sync_timestamp", eVar.c());
        edit.putLong("sensorhub_use_timestamp", eVar.b());
        edit.putInt("sensorhub_type", eVar.d());
        edit.putInt("sensorhub_base_step", eVar.a());
        edit.commit();
    }

    public static void keepSensorHubSupportedFlag(boolean z) {
        Editor edit = sp.edit();
        edit.putBoolean(a.cw, z);
        edit.commit();
    }

    public static void keepShowSensorHubTip(boolean z) {
        Editor edit = sp.edit();
        edit.putBoolean("ShowSensorHubTip", z);
        edit.commit();
    }

    public static void keepShowedUserAgreement(boolean z) {
        Editor edit = sp.edit();
        edit.putBoolean(Constant.ct, z);
        edit.commit();
    }

    public static void keepStartupList(List<StartingUpResInfo> list) {
        Editor edit = sp.edit();
        edit.putString("startingup_list", new C0993k().b((Object) list));
        edit.commit();
    }

    public static void keepSwitchOperator(SwitchOperator switchOperator) {
        Editor edit = sp.edit();
        edit.putInt("switch_type", switchOperator.type);
        edit.putBoolean("enable_clear_data", switchOperator.enableClearData);
        edit.putBoolean("enable_write_realtime_steps", switchOperator.enableSteps);
        edit.putInt("realtime_steps", switchOperator.steps);
        edit.putLong("last_uid", switchOperator.lastUid);
        edit.putString("last_mac_address", switchOperator.lastMacAddress);
        edit.putString("switch_date", switchOperator.date);
        edit.commit();
    }

    public static void keepSyncBraceletTime(long j) {
        Editor edit = sp.edit();
        edit.putLong(a.s, j);
        edit.commit();
    }

    public static void keepSyncTime(long j, int i) {
        if (i == c.SHOES.b()) {
            cn.com.smartdevices.bracelet.shoes.c.b(BraceletApp.a(), j);
            return;
        }
        Editor edit = sp.edit();
        edit.putLong(a.p, j);
        edit.commit();
    }

    public static void keepSyncToServerTime(long j) {
        Editor edit = sp.edit();
        edit.putLong("sync_to_server_timestamp", j);
        edit.commit();
    }

    public static void keepTempSwither(boolean z) {
        Editor edit = sp.edit();
        edit.putBoolean("TempSwither", z);
        edit.commit();
    }

    public static void keepUUID(String str) {
        Editor edit = sp.edit();
        edit.putString(a.Q, str);
        edit.commit();
    }

    public static void keepUploadEnable(boolean z) {
        Editor edit = sp.edit();
        edit.putBoolean("user_agree_upload_enable", z);
        edit.apply();
    }

    public static void keepUserAgreement(boolean z) {
        Editor edit = sp.edit();
        edit.putBoolean(a.cg, z);
        edit.commit();
    }

    public static void keepWeightCurrentUserAsync(int i) {
        Editor edit = sp.edit();
        edit.putInt("WeightUserId", i);
        edit.apply();
    }

    public static void keepWeightHwInfo(WeightHwInfo weightHwInfo) {
        Editor edit = sp.edit();
        edit.putString(Constant.aQ, Utils.c().b((Object) weightHwInfo));
        edit.commit();
    }

    public static boolean read24HourFormat() {
        return sp.getBoolean(Constant.aO, true);
    }

    public static ArrayList<AlarmClockItem> readAlarms() {
        ArrayList<AlarmClockItem> arrayList = null;
        try {
            arrayList = PersonInfo.parseAlarmClockItems(sp.getString(a.al, com.xiaomi.e.a.f));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static String readApkVersion() {
        return sp.getString("APKVersion", "85:1.0.20140625.2");
    }

    public static boolean readBehaviorTagEnable() {
        return sp.getBoolean("behaviorTagEnable", false);
    }

    public static boolean readBluethoothBrocastEnable() {
        return sp.getBoolean("bluethooth_brocast_enable", false);
    }

    public static BraceletBtInfo readBraceletBtInfo() {
        BraceletBtInfo braceletBtInfo = new BraceletBtInfo();
        braceletBtInfo.a = sp.getInt(Constant.B, 0);
        braceletBtInfo.c = sp.getString(a.t, com.xiaomi.e.a.f);
        braceletBtInfo.b = sp.getString(a.u, com.xiaomi.e.a.f);
        braceletBtInfo.d = sp.getString(Constant.z, com.xiaomi.e.a.f);
        braceletBtInfo.e = sp.getString(Constant.A, com.xiaomi.e.a.f);
        return braceletBtInfo;
    }

    public static long readBraceletStatisticTime() {
        return sp.getLong("bracelet_statistic_time", -1);
    }

    public static String readCityCode() {
        return sp.getString(Constant.cQ, null);
    }

    public static String readConfigDynamicDataInfo() {
        return sp.getString("configDynamicDataInfo", "{}");
    }

    public static ReportInfo readContinueReachGoalRi() {
        ReportInfo reportInfo = new ReportInfo();
        reportInfo.dateFrom = sp.getString("continue_reach_goal_date_from", com.xiaomi.e.a.f);
        reportInfo.dateTo = sp.getString("continue_reach_goal_date_to", com.xiaomi.e.a.f);
        return reportInfo;
    }

    public static String readCountryCode() {
        return sp.getString(Constant.cR, null);
    }

    public static String readDailySportReport() {
        return sp.getString(Constant.cM, com.xiaomi.e.a.f);
    }

    public static long readDownloadApkId() {
        return sp.getLong(C0810j.a, -1);
    }

    public static boolean readEnableRtHeartrate() {
        return sp.getBoolean("enable_realtime_heartrate", false);
    }

    public static String readFeatureVisited() {
        return sp.getString(Constant.cP, com.xiaomi.e.a.f);
    }

    public static boolean readFwUpgradeFlag() {
        return sp.getBoolean("fw_update_flag", false);
    }

    public static boolean readGameFailed() {
        return sp.getBoolean(a.ce, false);
    }

    public static boolean readHeartRateDataFromServer() {
        return sp.getBoolean(Constant.aV, false);
    }

    public static Boolean readIsPlayEnterAnimation() {
        return Boolean.valueOf(sp.getBoolean("isPlayEnterAnimation", false));
    }

    public static boolean readLastBinded() {
        return sp.getBoolean(a.cr, false);
    }

    public static long readLastCaclMedalTime() {
        return sp.getLong("lastCaclMedalTime", 0);
    }

    public static Calendar readLastCheckUpdateDate() {
        String string = sp.getString(C0810j.b, com.xiaomi.e.a.f);
        C0596r.e(TAG, "last calendar=" + string);
        return (Calendar) Utils.c().a(string, Calendar.class);
    }

    public static String readLastMonthReportDate() {
        return sp.getString("LastMonthReportDate", com.xiaomi.e.a.f);
    }

    public static String readLastNotifySleepDate() {
        return sp.getString(Constant.cU, com.xiaomi.e.a.f);
    }

    public static String readLastWeekReportDate() {
        return sp.getString("LastWeekReportDate", com.xiaomi.e.a.f);
    }

    public static String readLastWelcomeDate() {
        return sp.getString(a.cs, com.xiaomi.e.a.f);
    }

    public static String readLatestDBLuaVersion() {
        return sp.getString("latestDBLuaVersion", a.cf);
    }

    public static String readLazyDays() {
        String string = sp.getString(a.ch, com.xiaomi.e.a.f);
        C0596r.e(TAG, "readLazyDays = " + string);
        return string;
    }

    public static String readLocaleStr() {
        return sp.getString("Locale", com.xiaomi.e.a.f);
    }

    public static int readLowBatteryNofifyLevel() {
        return sp.getInt("low_battery_level", -1);
    }

    public static String readLuaItem() {
        return sp.getString(a.cm, com.xiaomi.e.a.f);
    }

    public static String readManualLazyDayAlgoStartDate() {
        return sp.getString(a.cj, com.xiaomi.e.a.f);
    }

    public static ArrayList<Calendar> readMorningAlarms() {
        try {
            return (ArrayList) Utils.c().a(sp.getString(REF_MORING_ALARMS, com.xiaomi.e.a.f), new C0853w().getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int readNeedBind() {
        return sp.getInt("bind_state", 1);
    }

    public static PersonInfo readPersonInfo() {
        PersonInfo personInfo = new PersonInfo();
        personInfo.nickname = sp.getString(a.v, personInfo.nickname);
        personInfo.avatarUrl = sp.getString(a.w, com.xiaomi.e.a.f);
        personInfo.avatarPath = sp.getString(a.x, com.xiaomi.e.a.f);
        personInfo.age = sp.getInt(a.D, personInfo.age);
        personInfo.gender = sp.getInt(a.C, personInfo.gender);
        personInfo.height = sp.getInt(a.z, personInfo.height);
        personInfo.targetWeight = sp.getFloat(a.B, personInfo.targetWeight);
        try {
            personInfo.weight = sp.getFloat(a.A, personInfo.weight);
        } catch (Exception e) {
            personInfo.weight = (float) sp.getInt(a.A, (int) personInfo.weight);
        }
        personInfo.uid = sp.getLong(a.y, personInfo.uid);
        personInfo.personSignature = sp.getString(a.E, com.xiaomi.e.a.f);
        personInfo.sh = sp.getString(a.F, com.xiaomi.e.a.f);
        personInfo.location = UserLocationData.fromJsonStr(sp.getString(a.G, com.xiaomi.e.a.f));
        personInfo.totalSportData = UserTotalSportData.fromJsonStr(sp.getString(a.H, com.xiaomi.e.a.f));
        personInfo.deviceId = sp.getString(a.ak, com.xiaomi.e.a.f);
        personInfo.setNeedSyncServer(sp.getInt(a.I, 0));
        personInfo.miliConfig = MiliConfig.fromJsonStr(sp.getString(a.J, com.xiaomi.e.a.f));
        personInfo.alarmClockItems = readAlarms();
        personInfo.setBirthday(sp.getString(a.K, com.xiaomi.e.a.f));
        return personInfo;
    }

    public static PersonInfo readPersonInfoBase() {
        PersonInfo personInfo = new PersonInfo();
        personInfo.uid = sp.getLong(a.y, personInfo.uid);
        personInfo.gender = sp.getInt(a.C, personInfo.gender);
        personInfo.height = sp.getInt(a.z, personInfo.height);
        try {
            personInfo.weight = sp.getFloat(a.A, personInfo.weight);
        } catch (Exception e) {
            personInfo.weight = (float) sp.getInt(a.A, (int) personInfo.weight);
        }
        personInfo.age = sp.getInt(a.D, personInfo.age);
        personInfo.birthday = sp.getString(a.K, personInfo.getBirthday());
        personInfo.miliConfig = MiliConfig.fromJsonStr(sp.getString(a.J, com.xiaomi.e.a.f));
        return personInfo;
    }

    public static PersonInfo readPersonInfoBaseConfig() {
        PersonInfo personInfo = new PersonInfo();
        personInfo.miliConfig = MiliConfig.fromJsonStr(sp.getString(a.J, com.xiaomi.e.a.f));
        return personInfo;
    }

    public static PersonInfo readPersonInfoBaseNeedSync() {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setNeedSyncServer(sp.getInt(a.I, 0));
        return personInfo;
    }

    public static PersonInfo readPersonInfoBaseUID() {
        PersonInfo personInfo = new PersonInfo();
        personInfo.uid = sp.getLong(a.y, personInfo.uid);
        return personInfo;
    }

    public static PersonInfo readPersonInfoForScale() {
        PersonInfo personInfo = new PersonInfo();
        personInfo.gender = sp.getInt(a.C, personInfo.gender);
        personInfo.height = sp.getInt(a.z, personInfo.height);
        try {
            personInfo.weight = sp.getFloat(a.A, personInfo.weight);
        } catch (Exception e) {
            personInfo.weight = (float) sp.getInt(a.A, (int) personInfo.weight);
        }
        personInfo.targetWeight = sp.getFloat(a.B, personInfo.targetWeight);
        personInfo.birthday = sp.getString(a.K, personInfo.getBirthday());
        personInfo.nickname = sp.getString(a.v, personInfo.nickname);
        personInfo.avatarUrl = sp.getString(a.w, com.xiaomi.e.a.f);
        personInfo.avatarPath = sp.getString(a.x, personInfo.avatarPath);
        return personInfo;
    }

    public static int readPlayEnterAnimationType() {
        return sp.getInt("PlayEnterAnimationType", 99);
    }

    public static String readPushAlias() {
        return sp.getString(a.M, null);
    }

    public static String readPushIntentUri() {
        return sp.getString(a.cn, com.xiaomi.e.a.f);
    }

    public static int readRealtimeSteps(int i) {
        return i == c.SHOES.b() ? cn.com.smartdevices.bracelet.shoes.c.b(BraceletApp.a()) : sp.getInt(a.r, -1);
    }

    public static long readRealtimeStepsTimestamp(int i) {
        return i == c.SHOES.b() ? cn.com.smartdevices.bracelet.shoes.c.e(BraceletApp.a()) : sp.getLong(a.q, 0);
    }

    public static boolean readScaleSyncedUserInfosFromServer() {
        return sp.getBoolean("ScaleSyncedUserInfosFromServer", false);
    }

    public static boolean readScaleSyncedWeightInfosFromServer() {
        return sp.getBoolean("ScaleSyncedWeightInfosFromServer", false);
    }

    public static e readSensorHubInfo() {
        return new e(sp.getLong("sensorhub_use_timestamp", -1), sp.getLong("sensorhub_sync_timestamp", -1), sp.getInt("sensorhub_type", -1), sp.getInt("sensorhub_base_step", -1));
    }

    public static boolean readSensorHubSupportedFlag() {
        return sp.getBoolean(a.cw, false);
    }

    public static boolean readShowSensorHubTip() {
        return sp.getBoolean("ShowSensorHubTip", true);
    }

    public static boolean readShowedUserAgreement() {
        return sp.getBoolean(Constant.ct, false);
    }

    public static SwitchOperator readSwitchOperator() {
        SwitchOperator switchOperator = new SwitchOperator();
        switchOperator.type = sp.getInt("switch_type", -1);
        switchOperator.enableClearData = sp.getBoolean("enable_clear_data", false);
        switchOperator.enableSteps = sp.getBoolean("enable_write_realtime_steps", false);
        switchOperator.steps = sp.getInt("realtime_steps", 0);
        switchOperator.lastUid = sp.getLong("last_uid", -1);
        switchOperator.lastMacAddress = sp.getString("last_mac_address", com.xiaomi.e.a.f);
        switchOperator.date = sp.getString("switch_date", com.xiaomi.e.a.f);
        return switchOperator;
    }

    private static long readSyncBraceletTime() {
        return sp.getLong(a.s, -1);
    }

    public static long readSyncDeviceTime(int i) {
        return i == c.SHOES.b() ? cn.com.smartdevices.bracelet.shoes.c.d(BraceletApp.a()) : sp.getLong(a.s, -1);
    }

    public static long readSyncTime(int i) {
        return i == c.SHOES.b() ? cn.com.smartdevices.bracelet.shoes.c.d(BraceletApp.a()) : sp.getLong(a.p, 0);
    }

    public static long readSyncToServerTime() {
        return sp.getLong("sync_to_server_timestamp", -1);
    }

    public static boolean readTempSwither() {
        return sp.getBoolean("TempSwither", false);
    }

    public static String readUUID() {
        return sp.getString(a.Q, null);
    }

    public static boolean readUploadEnable() {
        return sp.getBoolean("user_agree_upload_enable", false);
    }

    public static boolean readUserAgreement() {
        return sp.getBoolean(a.cg, false);
    }

    public static String readUserName() {
        return sp.getString(a.v, com.xiaomi.e.a.f);
    }

    public static int readWeightCurrentUser(int i) {
        return sp.getInt("WeightUserId", i);
    }

    public static WeightHwInfo readWeightHwInfo() {
        WeightHwInfo weightHwInfo;
        try {
            weightHwInfo = (WeightHwInfo) Utils.c().a(sp.getString(Constant.aQ, com.xiaomi.e.a.f), WeightHwInfo.class);
        } catch (Exception e) {
            weightHwInfo = null;
        }
        if (weightHwInfo == null) {
            weightHwInfo = new WeightHwInfo();
            weightHwInfo.name = sp.getString("weight_bind_info_name", com.xiaomi.e.a.f);
            weightHwInfo.address = sp.getString("weight_bind_info_address", com.xiaomi.e.a.f);
        }
        C0596r.e(o.n, weightHwInfo.toString());
        return weightHwInfo;
    }

    public static void saveCurrentUser(String str, String str2) {
        Editor edit = sp.edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public static void setActiveHistory(int i) {
        Editor edit = sp.edit();
        edit.putInt("active_history_state", i);
        edit.commit();
    }

    public static void setBehaviorTagEnable(boolean z) {
        Editor edit = sp.edit();
        edit.putBoolean("behaviorTagEnable", z);
        edit.commit();
    }

    public static void setBluethoothBrocastEnable(boolean z) {
        Editor edit = sp.edit();
        edit.putBoolean("bluethooth_brocast_enable", z);
        edit.commit();
    }

    public static void setDebugChannel(String str) {
        Editor edit = sp.edit();
        edit.putString("debug_channel", str);
        edit.apply();
    }

    public static void setDebugHost(String str) {
        Editor edit = sp.edit();
        edit.putString("debug_host", str);
        edit.apply();
    }

    public static void setEnterAppTrace(int i) {
        Editor edit = sp.edit();
        edit.putInt("enter_app_trace", i);
        edit.commit();
    }

    public static void setHRIfDirection(boolean z) {
        Editor edit = sp.edit();
        edit.putBoolean(Constant.dl, z);
        edit.commit();
    }

    public static void setHeartRateDataFromServer(boolean z) {
        Editor edit = sp.edit();
        edit.putBoolean(Constant.aV, z);
        edit.commit();
    }

    public static void setLastNotifySleepDate(String str) {
        Editor edit = sp.edit();
        edit.putString(Constant.cU, str);
        edit.apply();
    }

    public static void setPartnerEtag(String str) {
        Editor edit = sp.edit();
        edit.putString(Constant.Y, str);
        edit.commit();
    }

    public static void setRssiLayoutVisible(boolean z) {
        Editor edit = sp.edit();
        edit.putBoolean("rssi_visible", z);
        edit.commit();
    }

    public static void setRssiSignal(int i) {
        Editor edit = sp.edit();
        edit.putInt("rssi_signal", i);
        edit.commit();
    }

    public static void setServiceUpdateTime(long j) {
        Editor edit = sp.edit();
        edit.putLong(a.R, j);
        edit.apply();
    }

    public static void setShowBabyWeight(boolean z) {
        Editor edit = sp.edit();
        edit.putBoolean("baby_weight_notify", !z);
        edit.commit();
    }

    public static void setSyncBraceletInfoToServer(int i) {
        Editor edit = sp.edit();
        edit.putInt("flag_bracelet_info_server", i);
        edit.commit();
    }

    public static void setSyncWeightInfoToServer(int i) {
        Editor edit = sp.edit();
        edit.putInt("flag_weight_info_server", i);
        edit.commit();
    }

    public static void setUploadImeiStatus(int i) {
        Editor edit = sp.edit();
        edit.putInt("upload_imei_status", i);
        edit.commit();
    }
}
