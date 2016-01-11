package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.DateFormat;
import cn.com.smartdevices.bracelet.C0563k;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.C0623s;
import cn.com.smartdevices.bracelet.C0667t;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.eventbus.EventGameUpdate;
import cn.com.smartdevices.bracelet.f.e;
import cn.com.smartdevices.bracelet.gps.ui.WatermarkFragment.WatermarkTag;
import cn.com.smartdevices.bracelet.lab.sportmode.LabFactoryActiveItem;
import cn.com.smartdevices.bracelet.model.LuaItem;
import cn.com.smartdevices.bracelet.model.ReportData;
import cn.com.smartdevices.bracelet.shoes.data.b;
import com.xiaomi.hm.health.dataprocess.ActiveItem;
import com.xiaomi.hm.health.dataprocess.SleepInfo;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.mipush.sdk.f;
import de.greenrobot.daobracelet.LuaListDao;
import java.util.Locale;
import org.keplerproject.luajava.LuaState;

public class LuaEvent {
    private static final String TAG = "LuaEvent";
    private static LuaEvent __instance = null;
    private static Object mSync = new Object();
    private ConfigDynamicDataInfo cInfo = null;
    private Context context = null;
    private LuaEventMsgs lEventMsgs = null;

    public LuaEvent(Context context) {
        this.context = context;
    }

    public static LuaEvent getInstance(Context context) {
        LuaEvent luaEvent;
        synchronized (mSync) {
            if (__instance == null) {
                luaEvent = new LuaEvent(context);
                luaEvent.context = context;
                luaEvent.cInfo = ConfigDynamicDataInfo.getInstance();
                luaEvent.cInfo.setLuaAction(context);
                luaEvent.cInfo.setScreenUnlock(Utils.v(context));
                luaEvent.lEventMsgs = LuaEventMsgs.getInstance(context);
                __instance = luaEvent;
                __instance.setLocale(Locale.getDefault().toString());
                __instance.set24HourFormat(DateFormat.is24HourFormat(context));
                __instance.setNonChineseLocale(Utils.m());
            }
            luaEvent = __instance;
        }
        return luaEvent;
    }

    public void callLabFactoryActivities(LabFactoryActiveItem labFactoryActiveItem) {
        if (labFactoryActiveItem != null) {
            labFactoryActiveItem.setLuaAction(this.context);
            this.lEventMsgs.luaLabFactoryActivityMsg(labFactoryActiveItem);
        }
    }

    public void callLuaFunc(String str, EventGameUpdate eventGameUpdate) {
        LuaManager instance = LuaManager.getInstance();
        LuaState luaState = instance.getLuaState();
        luaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), str);
        eventGameUpdate.getConfigInfo().setLuaAction(this.context);
        luaState.pushJavaObject(C0563k.a().b());
        luaState.pushJavaObject(eventGameUpdate.getConfigInfo());
        instance.callLua(2, 0);
    }

    public void deleteGoalAchievedMsg() {
        LuaManager instance = LuaManager.getInstance();
        LuaState luaState = instance.getLuaState();
        LuaListDao b = C0563k.a().b();
        luaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "clearGoalHint");
        luaState.pushJavaObject(b);
        luaState.pushJavaObject(this.cInfo);
        instance.callLua(2, 0);
    }

    public void deleteLuaItem(String str) {
        LuaManager instance = LuaManager.getInstance();
        LuaState luaState = instance.getLuaState();
        LuaListDao b = C0563k.a().b();
        luaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "delMsgByType");
        luaState.pushJavaObject(b);
        luaState.pushJavaObject(this.cInfo);
        luaState.pushJavaObject(str);
        instance.callLua(3, 0);
    }

    public void deleteLuaOfStepAssociatedItem() {
        deleteLuaItem(String.valueOf(3003));
        deleteLuaItem(String.valueOf(3002));
        deleteLuaItem(String.valueOf(3001));
        deleteLuaItem(String.valueOf(WatermarkTag.b));
        deleteLuaItem(String.valueOf(WatermarkTag.c));
        deleteLuaItem(String.valueOf(2003));
        deleteLuaItem(String.valueOf(2004));
        deleteLuaItem(String.valueOf(2006));
        deleteLuaItem(String.valueOf(2007));
        deleteLuaItem(String.valueOf(4001));
        deleteLuaItem(String.valueOf(4002));
        deleteLuaItem(String.valueOf(4003));
        deleteLuaItem(String.valueOf(4004));
    }

    public ConfigDynamicDataInfo getConfigDynamicDataInfo() {
        return this.cInfo;
    }

    public String getGameInfo() {
        setLocale(Locale.getDefault().toString());
        LuaManager instance = LuaManager.getInstance();
        LuaState luaState = instance.getLuaState();
        luaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "getGameInfo");
        luaState.pushJavaObject(this.cInfo);
        instance.callLua(1, 0);
        C0596r.e(TAG, "get lua game info  =" + this.cInfo.getGameInfo());
        return this.cInfo.getGameInfo();
    }

    public LuaEventMsgs getLuaEventMsg() {
        return this.lEventMsgs;
    }

    public String getLuaVersion() {
        LuaManager instance = LuaManager.getInstance();
        LuaState luaState = instance.getLuaState();
        luaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "getLuaVersion");
        luaState.pushJavaObject(this.cInfo);
        instance.callLua(1, 0);
        String luaVersion = this.cInfo.getLuaVersion();
        C0596r.e(TAG, "get lua version from local =" + luaVersion);
        return luaVersion;
    }

    public void resetLuaState() {
        LuaManager.getInstance().resetLuaState();
    }

    public void set24HourFormat(boolean z) {
        LuaManager instance = LuaManager.getInstance();
        LuaState luaState = instance.getLuaState();
        luaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "set24HourFormat");
        luaState.pushBoolean(z);
        instance.callLua(1, 0);
    }

    public void setActivities(ActiveItem activeItem) {
        C0596r.e("chenee", "Activity KEY_MODE = " + activeItem.getMode() + f.i + activeItem.start + "->" + activeItem.stop + ", distance=" + activeItem.distance + ", calories=" + activeItem.calories + ", steps=" + activeItem.steps);
        this.cInfo.setActiveItem(activeItem);
        this.cInfo.setShowActivity(Boolean.valueOf(true));
        this.lEventMsgs.luaEventActivityMsg(this.cInfo);
        this.cInfo.setShowActivity(Boolean.valueOf(false));
    }

    public void setConnectStatus(boolean z) {
        this.cInfo.setConnectStatus(Boolean.valueOf(z));
        if (z) {
            deleteLuaItem("5004");
        } else {
            this.lEventMsgs.luaEventSysInfoMsg(this.cInfo);
        }
    }

    public void setContinueReport(ReportData reportData) {
        this.cInfo.setShowContinue(Boolean.valueOf(true));
        this.cInfo.setContinueReport(reportData);
        this.lEventMsgs.luaEventAchievementMsg(this.cInfo);
        this.cInfo.setShowContinue(Boolean.valueOf(false));
    }

    public void setCurLocale() {
        setLocale(Locale.getDefault().toString());
    }

    public void setDefaultMsgs() {
        setDefaultMsgs(Boolean.valueOf(false));
    }

    public void setDefaultMsgs(Boolean bool) {
        boolean z = true;
        boolean hasBindWeight = DeviceSource.hasBindWeight();
        boolean e = Utils.e();
        boolean readLastBinded = Keeper.readLastBinded();
        Keeper.keepLastBinded(e);
        boolean b = e.a().b();
        C0596r.e(TAG, "support sensor hub = " + b + ", isBind bracelet =" + Utils.e() + ", isShoesBound = " + b.b(this.context));
        this.cInfo.setIsSupportSensorHub(b);
        this.cInfo.setIsBind(e);
        this.cInfo.setIsBindSensorHub(DeviceSource.hasBindSensorHub());
        this.cInfo.setWeightBinded(hasBindWeight);
        this.cInfo.setShoesBound(b.b(this.context));
        if (e != readLastBinded || TextUtils.isEmpty(Keeper.readLastWelcomeDate())) {
            Keeper.keepLastWelcomeDate(new SportDay().toString());
        }
        SportDay fromString = SportDay.fromString(Keeper.readLastWelcomeDate());
        C0596r.e(TAG, "lastbind = " + readLastBinded + ", lastWelcomDay = " + fromString + ", delta day= " + Math.abs(fromString.offsetDay(new SportDay())));
        if (Math.abs(fromString.offsetDay(new SportDay())) > 0) {
            this.cInfo.setNewUser(false);
        } else {
            this.cInfo.setNewUser(true);
        }
        if (C0667t.c(this.context)) {
            if (Utils.o(this.context)) {
                z = false;
            }
            this.cInfo.setShowUnlockInfo(Boolean.valueOf(z));
        } else if (C0623s.a(this.context)) {
            this.cInfo.setShowUnlockInfo(Boolean.valueOf(true));
        } else {
            this.cInfo.setShowUnlockInfo(Boolean.valueOf(false));
        }
        this.cInfo.setForceRefresh(bool);
        this.lEventMsgs.luaEventDefaultMsg(this.cInfo);
    }

    public void setGoal(int i, int i2) {
        LuaManager instance = LuaManager.getInstance();
        LuaState luaState = instance.getLuaState();
        LuaListDao b = C0563k.a().b();
        luaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "dayComplete");
        luaState.pushJavaObject(b);
        luaState.pushJavaObject(this.cInfo);
        luaState.pushJavaObject(Integer.valueOf(i));
        luaState.pushJavaObject(Integer.valueOf(i2));
        instance.callLua(4, 0);
    }

    public void setLocale(String str) {
        LuaManager instance = LuaManager.getInstance();
        LuaState luaState = instance.getLuaState();
        luaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "setLocale");
        luaState.pushString(str);
        instance.callLua(1, 0);
    }

    public void setMonthReport(ReportData reportData) {
        this.cInfo.setShowMonthReport(Boolean.valueOf(true));
        this.cInfo.setMonthReport(reportData);
        this.lEventMsgs.luaEventAchievementMsg(this.cInfo);
        this.cInfo.setShowMonthReport(Boolean.valueOf(false));
    }

    public void setNonChineseLocale(boolean z) {
        LuaManager instance = LuaManager.getInstance();
        LuaState luaState = instance.getLuaState();
        luaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "setNonChineseLocale");
        luaState.pushBoolean(z);
        instance.callLua(1, 0);
    }

    public void setRecord(ReportData reportData) {
        this.cInfo.setNewRecordReport(reportData);
        LuaManager instance = LuaManager.getInstance();
        LuaState luaState = instance.getLuaState();
        LuaListDao b = C0563k.a().b();
        luaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "newRecord");
        luaState.pushJavaObject(b);
        luaState.pushJavaObject(this.cInfo);
        instance.callLua(2, 0);
    }

    public void setSleep(SleepInfo sleepInfo) {
        this.cInfo.setSleepInfo(sleepInfo);
        this.cInfo.setSleepAverageDeepTime(90);
        this.cInfo.setSleepPercent(80);
        this.cInfo.setShowSleep(Boolean.valueOf(true));
        this.lEventMsgs.luaEventSleepMsg(this.cInfo);
        this.cInfo.setShowSleep(Boolean.valueOf(false));
    }

    public void setWeekReport(ReportData reportData) {
        this.cInfo.setShowWeekReport(Boolean.valueOf(true));
        this.cInfo.setWeekReport(reportData);
        this.lEventMsgs.luaEventAchievementMsg(this.cInfo);
        this.cInfo.setShowWeekReport(Boolean.valueOf(false));
    }

    public void showLuaItem(LuaItem luaItem) {
        C0596r.e(TAG, "showLuaItem:" + luaItem);
        LuaManager instance = LuaManager.getInstance();
        LuaState luaState = instance.getLuaState();
        LuaListDao b = C0563k.a().b();
        luaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "showLuaItem");
        luaState.pushJavaObject(b);
        luaState.pushJavaObject(this.cInfo);
        luaState.pushJavaObject(luaItem);
        instance.callLua(3, 0);
    }

    public void testConfig() {
    }

    public void testLuaImp(int i) {
        this.lEventMsgs.testLuaImp(i, this.cInfo);
    }

    public void updateWeatherTips(int i) {
        this.cInfo.setAQILevel(i);
        LuaManager instance = LuaManager.getInstance();
        LuaState luaState = instance.getLuaState();
        LuaListDao b = C0563k.a().b();
        luaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "updateWeatherTips");
        luaState.pushJavaObject(b);
        luaState.pushJavaObject(this.cInfo);
        instance.callLua(2, 0);
    }
}
